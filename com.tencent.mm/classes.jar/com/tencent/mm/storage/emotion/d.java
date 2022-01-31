package com.tencent.mm.storage.emotion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class d
  extends j<EmojiInfo>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private static int[] yPX;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(62845);
    SQL_CREATE = new String[] { j.getCreateSQLs(EmojiInfo.info, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )", "CREATE INDEX IF NOT EXISTS emojiinfogatalogindex  on EmojiInfo  (  catalog )" };
    yPX = new int[] { 2, 4, 8 };
    AppMethodBeat.o(62845);
  }
  
  public d(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, EmojiInfo.info, "EmojiInfo", null);
    this.db = parame;
  }
  
  private int ND(int paramInt)
  {
    j = 0;
    i = 0;
    AppMethodBeat.i(62813);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.db.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { String.valueOf(paramInt), "0" }, 2);
      paramInt = i;
      if (localCursor != null)
      {
        paramInt = i;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          paramInt = localCursor.getInt(0);
        }
      }
      i = paramInt;
      if (localCursor != null)
      {
        localCursor.close();
        i = paramInt;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(localException) });
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + localException.getMessage());
        i = j;
        if (localObject1 != null)
        {
          localObject1.close();
          i = j;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label199;
      }
      localObject3.close();
      AppMethodBeat.o(62813);
    }
    AppMethodBeat.o(62813);
    return i;
  }
  
  private static List<EmojiInfo> a(InputStream[] paramArrayOfInputStream)
  {
    AppMethodBeat.i(62826);
    ArrayList localArrayList = new ArrayList();
    Object localObject = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int k;
      try
      {
        DocumentBuilder localDocumentBuilder = ((DocumentBuilderFactory)localObject).newDocumentBuilder();
        int i = 0;
        if (i <= 0)
        {
          localObject = paramArrayOfInputStream[i];
          if (localObject != null)
          {
            NodeList localNodeList1 = localDocumentBuilder.parse((InputStream)localObject).getDocumentElement().getElementsByTagName("catalog");
            int j = 0;
            if (j < localNodeList1.getLength())
            {
              localObject = (Element)localNodeList1.item(j);
              int m = Integer.decode(((Element)localObject).getAttribute("id")).intValue();
              NodeList localNodeList2 = ((Element)localObject).getElementsByTagName("emoji");
              k = 0;
              if (k < localNodeList2.getLength())
              {
                com.tencent.mm.plugin.emoji.e.bki();
                EmojiInfo localEmojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bkj());
                localObject = (Element)localNodeList2.item(k);
                localEmojiInfo.field_md5 = ((Element)localObject).getAttribute("md5");
                if (!localEmojiInfo.cZP()) {
                  break label365;
                }
                localEmojiInfo.field_catalog = m;
                localEmojiInfo.field_groupId = String.valueOf(m);
                localEmojiInfo.field_name = ((Element)localObject).getAttribute("name");
                localEmojiInfo.field_type = Integer.decode(((Element)localObject).getAttribute("type")).intValue();
                localObject = ((Element)localObject).getFirstChild();
                if ((localObject instanceof CharacterData))
                {
                  localObject = ((CharacterData)localObject).getData();
                  if (localEmojiInfo.field_type != EmojiInfo.TYPE_TEXT) {
                    break label362;
                  }
                  localObject = new String(Base64.decode((String)localObject, 0));
                  localEmojiInfo.field_content = ((String)localObject);
                  localArrayList.add(localEmojiInfo);
                  break label365;
                }
                localObject = "";
                continue;
              }
              j += 1;
              continue;
            }
          }
          i += 1;
        }
        continue;
      }
      catch (Exception paramArrayOfInputStream)
      {
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + paramArrayOfInputStream.getMessage());
        AppMethodBeat.o(62826);
        return localArrayList;
      }
      label362:
      label365:
      k += 1;
    }
  }
  
  private EmojiInfo c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(62807);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      ab.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      AppMethodBeat.o(62807);
      return null;
    }
    EmojiInfo localEmojiInfo2 = asP(paramString1);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null)
    {
      com.tencent.mm.plugin.emoji.e.bki();
      localEmojiInfo1 = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bkj());
      localEmojiInfo1.field_catalog = paramInt1;
    }
    localEmojiInfo1.field_md5 = paramString1;
    localEmojiInfo1.field_svrid = paramString2;
    localEmojiInfo1.field_type = paramInt2;
    localEmojiInfo1.field_size = paramInt3;
    localEmojiInfo1.field_state = EmojiInfo.yPs;
    localEmojiInfo1.field_reserved1 = null;
    localEmojiInfo1.field_reserved2 = null;
    localEmojiInfo1.field_app_id = paramString3;
    localEmojiInfo1.field_temp = 1;
    localEmojiInfo1.field_reserved4 = 0;
    if (!TextUtils.isEmpty(paramString4)) {
      localEmojiInfo1.field_groupId = paramString4;
    }
    AppMethodBeat.o(62807);
    return localEmojiInfo1;
  }
  
  public final EmojiInfo H(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62802);
    if ((paramEmojiInfo == null) || (bo.isNullOrNil(paramEmojiInfo.Al())) || (paramEmojiInfo.Al().length() <= 0))
    {
      ab.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      AppMethodBeat.o(62802);
      return null;
    }
    ab.i("MicroMsg.emoji.EmojiInfoStorage", "create: %s", new Object[] { paramEmojiInfo.field_md5 });
    if (I(paramEmojiInfo))
    {
      doNotify("create_emoji_info_notify");
      AppMethodBeat.o(62802);
      return paramEmojiInfo;
    }
    AppMethodBeat.o(62802);
    return null;
  }
  
  public final boolean I(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62808);
    if ((paramEmojiInfo == null) || (!paramEmojiInfo.cZP()))
    {
      ab.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      AppMethodBeat.o(62808);
      return false;
    }
    ab.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s", new Object[] { paramEmojiInfo.field_md5 });
    ContentValues localContentValues = paramEmojiInfo.convertTo();
    long l = this.db.replace("EmojiInfo", "md5", localContentValues);
    ab.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s, %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(l) });
    if (l != -1L) {
      doNotify(paramEmojiInfo.Al());
    }
    if (l >= 0L)
    {
      AppMethodBeat.o(62808);
      return true;
    }
    AppMethodBeat.o(62808);
    return false;
  }
  
  public final boolean J(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62809);
    if ((paramEmojiInfo == null) || (!paramEmojiInfo.cZP()))
    {
      ab.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      AppMethodBeat.o(62809);
      return false;
    }
    int i = this.db.update("EmojiInfo", paramEmojiInfo.convertTo(), "md5=?", new String[] { paramEmojiInfo.Al() });
    if (i > 0)
    {
      doNotify(paramEmojiInfo.Al());
      doNotify("event_update_emoji");
    }
    if (i > 0)
    {
      AppMethodBeat.o(62809);
      return true;
    }
    AppMethodBeat.o(62809);
    return false;
  }
  
  public final boolean K(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62810);
    if ((paramEmojiInfo == null) || (!paramEmojiInfo.cZP()))
    {
      ab.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      AppMethodBeat.o(62810);
      return false;
    }
    if (this.db.update("EmojiInfo", paramEmojiInfo.convertTo(), "md5=?", new String[] { paramEmojiInfo.Al() }) > 0)
    {
      AppMethodBeat.o(62810);
      return true;
    }
    AppMethodBeat.o(62810);
    return false;
  }
  
  public final int KF(String paramString)
  {
    AppMethodBeat.i(62814);
    long l = System.currentTimeMillis();
    Object localObject = null;
    String str = null;
    for (;;)
    {
      try
      {
        paramString = this.db.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { paramString, "0" }, 2);
        if (paramString == null) {
          break label216;
        }
        str = paramString;
        localObject = paramString;
        if (!paramString.moveToFirst()) {
          break label216;
        }
        str = paramString;
        localObject = paramString;
        i = paramString.getInt(0);
        j = i;
        if (paramString != null)
        {
          paramString.close();
          j = i;
        }
      }
      catch (Exception paramString)
      {
        localObject = str;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(paramString) });
        localObject = str;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + paramString.getMessage());
        if (str == null) {
          break label211;
        }
        str.close();
        j = 0;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
        AppMethodBeat.o(62814);
      }
      ab.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(62814);
      return j;
      label211:
      int j = 0;
      continue;
      label216:
      int i = 0;
    }
  }
  
  public final List<EmojiInfo> Kw(String paramString)
  {
    AppMethodBeat.i(62828);
    ArrayList localArrayList = new ArrayList();
    localObject = null;
    str = null;
    try
    {
      paramString = this.db.a("select * from EmojiInfo where groupId=? and temp=? order by idx asc", new String[] { paramString, "0" }, 2);
      if (paramString != null)
      {
        str = paramString;
        localObject = paramString;
        if (paramString.moveToFirst())
        {
          boolean bool;
          do
          {
            str = paramString;
            localObject = paramString;
            com.tencent.mm.plugin.emoji.e.bki();
            str = paramString;
            localObject = paramString;
            EmojiInfo localEmojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bkj());
            str = paramString;
            localObject = paramString;
            localEmojiInfo.convertFrom(paramString);
            str = paramString;
            localObject = paramString;
            localArrayList.add(localEmojiInfo);
            str = paramString;
            localObject = paramString;
            bool = paramString.moveToNext();
          } while (bool);
        }
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localObject = str;
        ab.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", new Object[] { paramString.toString() });
        if (str != null) {
          str.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label201;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(62828);
    }
    AppMethodBeat.o(62828);
    return localArrayList;
  }
  
  public final List<EmojiInfo> NE(int paramInt)
  {
    AppMethodBeat.i(62817);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from EmojiInfo where catalog = ").append(paramInt);
    ((StringBuilder)localObject).append(" and state != ").append(EmojiInfo.yPv);
    ((StringBuilder)localObject).append(" order by reserved3 asc ");
    localObject = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          EmojiInfo localEmojiInfo = new EmojiInfo();
          localEmojiInfo.convertFrom((Cursor)localObject);
          localArrayList.add(localEmojiInfo);
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(62817);
    return localArrayList;
  }
  
  public final List<String> NF(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62819);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("select md5 from EmojiInfo");
    if (paramInt == 1) {
      ((StringBuilder)localObject4).append(" where groupId = \"capture\" order by idx asc ");
    }
    for (;;)
    {
      try
      {
        localObject4 = this.db.a(((StringBuilder)localObject4).toString(), null, 2);
        if (localObject4 != null)
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          if (((Cursor)localObject4).moveToFirst())
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(((Cursor)localObject4).getString(0));
            localObject1 = localObject4;
            localObject3 = localObject4;
            boolean bool = ((Cursor)localObject4).moveToNext();
            if (bool) {
              continue;
            }
          }
        }
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
      catch (Exception localException)
      {
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[] { bo.l(localException) });
        if (localObject1 == null) {
          continue;
        }
        localObject1.close();
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        localObject3.close();
        AppMethodBeat.o(62819);
      }
      AppMethodBeat.o(62819);
      return localArrayList;
      ((StringBuilder)localObject4).append(" where catalog = ").append(EmojiGroupInfo.yPf).append(" order by reserved3 asc ");
    }
  }
  
  public final List<String> NG(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62820);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(" select md5 from EmojiInfo");
    if (paramInt == 1) {
      ((StringBuilder)localObject4).append(" where groupId = \"capture\" and captureStatus = 0");
    }
    for (;;)
    {
      ((StringBuilder)localObject4).append(" and state in (").append(EmojiInfo.yPu);
      ((StringBuilder)localObject4).append(" , ").append(EmojiInfo.yPv);
      ((StringBuilder)localObject4).append(" ) ");
      localObject4 = ((StringBuilder)localObject4).toString();
      try
      {
        localObject4 = this.db.a((String)localObject4, null, 2);
        if (localObject4 != null)
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          if (((Cursor)localObject4).moveToFirst())
          {
            boolean bool;
            do
            {
              localObject1 = localObject4;
              localObject3 = localObject4;
              localArrayList.add(((Cursor)localObject4).getString(0));
              localObject1 = localObject4;
              localObject3 = localObject4;
              bool = ((Cursor)localObject4).moveToNext();
            } while (bool);
          }
        }
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = localObject1;
          ab.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[] { bo.l(localException) });
          if (localObject1 != null) {
            localObject1.close();
          }
        }
      }
      finally
      {
        if (localObject3 == null) {
          break;
        }
        localObject3.close();
        AppMethodBeat.o(62820);
      }
      AppMethodBeat.o(62820);
      return localArrayList;
      ((StringBuilder)localObject4).append(" where catalog = ").append(EmojiInfo.yPm);
    }
  }
  
  public final Cursor NH(int paramInt)
  {
    AppMethodBeat.i(62821);
    Cursor localCursor = this.db.query("EmojiInfo", null, "catalog=? and temp=?", new String[] { String.valueOf(paramInt), "0" }, null, null, null);
    AppMethodBeat.o(62821);
    return localCursor;
  }
  
  public final boolean NI(int paramInt)
  {
    AppMethodBeat.i(62824);
    if (this.db.delete("EmojiInfo", "catalog=?", new String[] { String.valueOf(paramInt) }) >= 0)
    {
      AppMethodBeat.o(62824);
      return true;
    }
    AppMethodBeat.o(62824);
    return false;
  }
  
  public final List<String> NJ(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62837);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(" select md5 from EmojiInfo");
    if (paramInt == 1) {
      ((StringBuilder)localObject4).append(" where groupId = \"capture\"");
    }
    for (;;)
    {
      ((StringBuilder)localObject4).append(" and state = ").append(EmojiInfo.yPv);
      try
      {
        localObject4 = this.db.a(((StringBuilder)localObject4).toString(), null, 2);
        if (localObject4 != null)
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          if (((Cursor)localObject4).moveToFirst())
          {
            boolean bool;
            do
            {
              localObject1 = localObject4;
              localObject3 = localObject4;
              localArrayList.add(((Cursor)localObject4).getString(0));
              localObject1 = localObject4;
              localObject3 = localObject4;
              bool = ((Cursor)localObject4).moveToNext();
            } while (bool);
          }
        }
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = localObject1;
          ab.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[] { bo.l(localException) });
          if (localObject1 != null) {
            localObject1.close();
          }
        }
      }
      finally
      {
        if (localObject3 == null) {
          break;
        }
        localObject3.close();
        AppMethodBeat.o(62837);
      }
      AppMethodBeat.o(62837);
      return localArrayList;
      ((StringBuilder)localObject4).append(" where catalog = ").append(EmojiInfo.yPm);
    }
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(62804);
    paramString1 = b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4);
    AppMethodBeat.o(62804);
    return paramString1;
  }
  
  public final void a(Context paramContext, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62825);
    Object localObject;
    Context localContext;
    if ((paramEmojiInfo.field_catalog == EmojiInfo.yPi) || (paramEmojiInfo.field_catalog == EmojiInfo.yPl) || (paramEmojiInfo.field_catalog == EmojiInfo.yPk))
    {
      localObject = null;
      localContext = null;
    }
    for (;;)
    {
      try
      {
        paramContext = EmojiInfo.bI(paramContext, paramEmojiInfo.getName());
        if (paramContext == null) {
          break label256;
        }
        localContext = paramContext;
        localObject = paramContext;
        j = paramContext.available();
        i = j;
      }
      catch (IOException paramContext)
      {
        localObject = localContext;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(paramContext) });
        if (localContext == null) {
          break label251;
        }
        try
        {
          localContext.close();
          i = 0;
        }
        catch (IOException paramContext)
        {
          ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(paramContext) });
          i = 0;
        }
        continue;
      }
      finally
      {
        if (localObject == null) {
          break label209;
        }
      }
      try
      {
        paramContext.close();
        i = j;
      }
      catch (IOException paramContext)
      {
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(paramContext) });
        i = j;
        continue;
      }
      if ((i != 0) && (i != paramEmojiInfo.field_size))
      {
        paramEmojiInfo.field_size = i;
        J(paramEmojiInfo);
      }
      AppMethodBeat.o(62825);
      return;
      try
      {
        ((InputStream)localObject).close();
        label209:
        AppMethodBeat.o(62825);
        throw paramContext;
      }
      catch (IOException paramEmojiInfo)
      {
        for (;;)
        {
          ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(paramEmojiInfo) });
        }
      }
      int i = (int)com.tencent.mm.vfs.e.avI(paramEmojiInfo.dQB());
      continue;
      label251:
      i = 0;
      continue;
      label256:
      int j = 0;
    }
  }
  
  public final boolean aL(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(62838);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
      AppMethodBeat.o(62838);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.qsU.j(164L, 12L, 1L);
    ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE");
    localStringBuilder.append(" EmojiInfo ");
    localStringBuilder.append(" SET ");
    localStringBuilder.append("needupload");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.yPA);
    localStringBuilder.append(" where ");
    localStringBuilder.append("md5");
    localStringBuilder.append(" IN (");
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append("'" + (String)paramLinkedList.get(i) + "'");
      if (i < paramLinkedList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    ab.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    boolean bool = this.db.execSQL("EmojiInfo", localStringBuilder.toString());
    AppMethodBeat.o(62838);
    return bool;
  }
  
  /* Error */
  public final EmojiInfo asP(String paramString)
  {
    // Byte code:
    //   0: ldc_w 589
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 317	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +12 -> 22
    //   13: aload_1
    //   14: invokevirtual 265	java/lang/String:length	()I
    //   17: bipush 32
    //   19: if_icmpeq +27 -> 46
    //   22: ldc 88
    //   24: ldc_w 591
    //   27: iconst_1
    //   28: anewarray 92	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc_w 589
    //   41: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   50: ldc 32
    //   52: aconst_null
    //   53: ldc_w 355
    //   56: iconst_1
    //   57: anewarray 24	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokeinterface 594 9 0
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +144 -> 219
    //   78: aload_2
    //   79: astore_3
    //   80: aload_2
    //   81: invokeinterface 80 1 0
    //   86: ifeq +133 -> 219
    //   89: aload_2
    //   90: astore_3
    //   91: invokestatic 194	com/tencent/mm/plugin/emoji/e:bki	()Lcom/tencent/mm/plugin/emoji/e;
    //   94: pop
    //   95: aload_2
    //   96: astore_3
    //   97: new 26	com/tencent/mm/storage/emotion/EmojiInfo
    //   100: dup
    //   101: invokestatic 197	com/tencent/mm/plugin/emoji/e:bkj	()Ljava/lang/String;
    //   104: invokespecial 198	com/tencent/mm/storage/emotion/EmojiInfo:<init>	(Ljava/lang/String;)V
    //   107: astore_1
    //   108: aload_2
    //   109: astore_3
    //   110: aload_1
    //   111: aload_2
    //   112: invokevirtual 386	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   115: aload_1
    //   116: astore_3
    //   117: aload_2
    //   118: ifnull +11 -> 129
    //   121: aload_2
    //   122: invokeinterface 86 1 0
    //   127: aload_1
    //   128: astore_3
    //   129: ldc_w 589
    //   132: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: areturn
    //   137: astore 4
    //   139: aconst_null
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: ldc 88
    //   147: ldc_w 596
    //   150: iconst_1
    //   151: anewarray 92	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 4
    //   158: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload_1
    //   166: astore_3
    //   167: aload_2
    //   168: ifnull -39 -> 129
    //   171: aload_2
    //   172: invokeinterface 86 1 0
    //   177: aload_1
    //   178: astore_3
    //   179: goto -50 -> 129
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 86 1 0
    //   195: ldc_w 589
    //   198: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_1
    //   202: athrow
    //   203: astore_1
    //   204: goto -19 -> 185
    //   207: astore 4
    //   209: aconst_null
    //   210: astore_1
    //   211: goto -68 -> 143
    //   214: astore 4
    //   216: goto -73 -> 143
    //   219: aconst_null
    //   220: astore_1
    //   221: goto -106 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	d
    //   0	224	1	paramString	String
    //   73	99	2	localCursor	Cursor
    //   79	111	3	localObject	Object
    //   137	20	4	localException1	Exception
    //   207	1	4	localException2	Exception
    //   214	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   46	74	137	java/lang/Exception
    //   46	74	182	finally
    //   80	89	203	finally
    //   91	95	203	finally
    //   97	108	203	finally
    //   110	115	203	finally
    //   145	165	203	finally
    //   80	89	207	java/lang/Exception
    //   91	95	207	java/lang/Exception
    //   97	108	207	java/lang/Exception
    //   110	115	214	java/lang/Exception
  }
  
  public final boolean asQ(String paramString)
  {
    AppMethodBeat.i(62822);
    if ((paramString == null) || (paramString.length() != 32))
    {
      ab.f("MicroMsg.emoji.EmojiInfoStorage", "delete by md5 assertion");
      AppMethodBeat.o(62822);
      return false;
    }
    int i = this.db.delete("EmojiInfo", "md5=?", new String[] { String.valueOf(paramString) });
    if (i > 0) {
      doNotify("event_update_emoji");
    }
    if (i > 0)
    {
      AppMethodBeat.o(62822);
      return true;
    }
    AppMethodBeat.o(62822);
    return false;
  }
  
  /* Error */
  public final EmojiInfo asR(String paramString)
  {
    // Byte code:
    //   0: ldc_w 605
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   10: ldc_w 607
    //   13: iconst_2
    //   14: anewarray 24	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 68
    //   25: aastore
    //   26: iconst_2
    //   27: invokeinterface 74 4 0
    //   32: astore_2
    //   33: aload_2
    //   34: astore_3
    //   35: aload_2
    //   36: invokeinterface 80 1 0
    //   41: ifeq +139 -> 180
    //   44: aload_2
    //   45: astore_3
    //   46: invokestatic 194	com/tencent/mm/plugin/emoji/e:bki	()Lcom/tencent/mm/plugin/emoji/e;
    //   49: pop
    //   50: aload_2
    //   51: astore_3
    //   52: new 26	com/tencent/mm/storage/emotion/EmojiInfo
    //   55: dup
    //   56: invokestatic 197	com/tencent/mm/plugin/emoji/e:bkj	()Ljava/lang/String;
    //   59: invokespecial 198	com/tencent/mm/storage/emotion/EmojiInfo:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: aload_2
    //   64: astore_3
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 386	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   70: aload_1
    //   71: astore_3
    //   72: aload_2
    //   73: ifnull +11 -> 84
    //   76: aload_2
    //   77: invokeinterface 86 1 0
    //   82: aload_1
    //   83: astore_3
    //   84: ldc_w 605
    //   87: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_3
    //   91: areturn
    //   92: astore 4
    //   94: aconst_null
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_2
    //   99: astore_3
    //   100: ldc 88
    //   102: new 106	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 609
    //   109: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload 4
    //   114: invokevirtual 115	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   117: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: astore_3
    //   128: aload_2
    //   129: ifnull -45 -> 84
    //   132: aload_2
    //   133: invokeinterface 86 1 0
    //   138: aload_1
    //   139: astore_3
    //   140: goto -56 -> 84
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +9 -> 156
    //   150: aload_3
    //   151: invokeinterface 86 1 0
    //   156: ldc_w 605
    //   159: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: goto -19 -> 146
    //   168: astore 4
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -74 -> 98
    //   175: astore 4
    //   177: goto -79 -> 98
    //   180: aconst_null
    //   181: astore_1
    //   182: goto -112 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	d
    //   0	185	1	paramString	String
    //   32	101	2	localCursor	Cursor
    //   34	117	3	localObject	Object
    //   92	21	4	localException1	Exception
    //   168	1	4	localException2	Exception
    //   175	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   6	33	92	java/lang/Exception
    //   6	33	143	finally
    //   35	44	164	finally
    //   46	50	164	finally
    //   52	63	164	finally
    //   65	70	164	finally
    //   100	126	164	finally
    //   35	44	168	java/lang/Exception
    //   46	50	168	java/lang/Exception
    //   52	63	168	java/lang/Exception
    //   65	70	175	java/lang/Exception
  }
  
  public final boolean asS(String paramString)
  {
    bool3 = false;
    bool2 = false;
    AppMethodBeat.i(62834);
    localObject2 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.db.a("select * from EmojiInfo where md5=?", new String[] { paramString }, 2);
      boolean bool1 = bool2;
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        boolean bool4 = localCursor.moveToFirst();
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (localCursor != null)
      {
        localCursor.close();
        bool2 = bool1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", new Object[] { paramString, localException.getMessage() });
        bool2 = bool3;
        if (localObject1 != null)
        {
          localObject1.close();
          bool2 = bool3;
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label161;
      }
      localObject2.close();
      AppMethodBeat.o(62834);
    }
    AppMethodBeat.o(62834);
    return bool2;
  }
  
  public final boolean asT(String paramString)
  {
    AppMethodBeat.i(62835);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "groupId = '" + paramString + "'";
      try
      {
        if (this.db.delete("EmojiInfo", paramString, null) >= 0)
        {
          AppMethodBeat.o(62835);
          return true;
        }
        AppMethodBeat.o(62835);
        return false;
      }
      catch (Exception paramString)
      {
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + paramString.getMessage());
      }
    }
    AppMethodBeat.o(62835);
    return false;
  }
  
  public final EmojiInfo b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(62806);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      ab.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      AppMethodBeat.o(62806);
      return null;
    }
    paramString1 = c(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4);
    paramString1.field_state = EmojiInfo.yPu;
    if (I(paramString1))
    {
      doNotify("create_emoji_info_notify");
      AppMethodBeat.o(62806);
      return paramString1;
    }
    AppMethodBeat.o(62806);
    return null;
  }
  
  public final EmojiInfo d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(62803);
    paramString1 = b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, paramString3);
    AppMethodBeat.o(62803);
    return paramString1;
  }
  
  public final ArrayList<String> dzC()
  {
    AppMethodBeat.i(62839);
    ArrayList localArrayList = new ArrayList();
    localObject3 = null;
    localObject1 = null;
    int i = EmojiInfo.yPA;
    int j = EmojiGroupInfo.yPf;
    try
    {
      Cursor localCursor = this.db.a("select md5 from EmojiInfo where needupload=? and catalog=?", new String[] { String.valueOf(i), String.valueOf(j) }, 2);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            localArrayList.add(localCursor.getString(0));
            localObject1 = localCursor;
            localObject3 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", new Object[] { bo.l(localException) });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label203;
      }
      localObject3.close();
      AppMethodBeat.o(62839);
    }
    AppMethodBeat.o(62839);
    return localArrayList;
  }
  
  public final int dzD()
  {
    k = 0;
    j = 0;
    AppMethodBeat.i(62840);
    localObject3 = null;
    localObject1 = null;
    int i = EmojiGroupInfo.yPf;
    try
    {
      Cursor localCursor = this.db.a("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[] { String.valueOf(i) }, 2);
      i = j;
      if (localCursor != null)
      {
        i = j;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          i = localCursor.getInt(0);
        }
      }
      j = i;
      if (localCursor != null)
      {
        localCursor.close();
        j = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", new Object[] { bo.l(localException) });
        j = k;
        if (localObject1 != null)
        {
          localObject1.close();
          j = k;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label173;
      }
      localObject3.close();
      AppMethodBeat.o(62840);
    }
    AppMethodBeat.o(62840);
    return j;
  }
  
  /* Error */
  public final ArrayList<EmojiInfo> dzE()
  {
    // Byte code:
    //   0: ldc_w 643
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 434	com/tencent/mm/storage/emotion/EmojiGroupInfo:yPf	I
    //   9: istore_1
    //   10: getstatic 646	com/tencent/mm/storage/emotion/EmojiGroupInfo:yPg	I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   18: ldc_w 648
    //   21: iconst_2
    //   22: anewarray 24	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: iload_1
    //   28: invokestatic 66	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: iload_2
    //   35: invokestatic 66	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   38: aastore
    //   39: iconst_2
    //   40: invokeinterface 74 4 0
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +122 -> 171
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: invokeinterface 80 1 0
    //   63: ifeq +108 -> 171
    //   66: aload 5
    //   68: astore 4
    //   70: new 129	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 131	java/util/ArrayList:<init>	()V
    //   77: astore 6
    //   79: aload 5
    //   81: astore 4
    //   83: new 26	com/tencent/mm/storage/emotion/EmojiInfo
    //   86: dup
    //   87: invokespecial 417	com/tencent/mm/storage/emotion/EmojiInfo:<init>	()V
    //   90: astore 7
    //   92: aload 5
    //   94: astore 4
    //   96: aload 7
    //   98: aload 5
    //   100: invokevirtual 386	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   103: aload 5
    //   105: astore 4
    //   107: aload 7
    //   109: getfield 301	com/tencent/mm/storage/emotion/EmojiInfo:field_reserved4	I
    //   112: getstatic 651	com/tencent/mm/storage/emotion/EmojiInfo:APx	I
    //   115: iand
    //   116: getstatic 651	com/tencent/mm/storage/emotion/EmojiInfo:APx	I
    //   119: if_icmpeq +15 -> 134
    //   122: aload 5
    //   124: astore 4
    //   126: aload 6
    //   128: aload 7
    //   130: invokevirtual 632	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload 5
    //   136: astore 4
    //   138: aload 5
    //   140: invokeinterface 389 1 0
    //   145: istore_3
    //   146: iload_3
    //   147: ifne -68 -> 79
    //   150: aload 5
    //   152: ifnull +10 -> 162
    //   155: aload 5
    //   157: invokeinterface 86 1 0
    //   162: ldc_w 643
    //   165: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload 6
    //   170: areturn
    //   171: aload 5
    //   173: ifnull +10 -> 183
    //   176: aload 5
    //   178: invokeinterface 86 1 0
    //   183: ldc_w 643
    //   186: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aconst_null
    //   190: areturn
    //   191: astore 6
    //   193: aconst_null
    //   194: astore 5
    //   196: aload 5
    //   198: astore 4
    //   200: ldc 88
    //   202: ldc_w 653
    //   205: iconst_1
    //   206: anewarray 92	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 6
    //   213: invokestatic 98	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   216: aastore
    //   217: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload 5
    //   222: ifnull -39 -> 183
    //   225: aload 5
    //   227: invokeinterface 86 1 0
    //   232: goto -49 -> 183
    //   235: astore 5
    //   237: aconst_null
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +10 -> 252
    //   245: aload 4
    //   247: invokeinterface 86 1 0
    //   252: ldc_w 643
    //   255: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload 5
    //   260: athrow
    //   261: astore 5
    //   263: goto -23 -> 240
    //   266: astore 6
    //   268: goto -72 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	d
    //   9	19	1	i	int
    //   13	22	2	j	int
    //   145	2	3	bool	boolean
    //   54	192	4	localCursor1	Cursor
    //   45	181	5	localCursor2	Cursor
    //   235	24	5	localObject1	Object
    //   261	1	5	localObject2	Object
    //   77	92	6	localArrayList	ArrayList
    //   191	21	6	localException1	Exception
    //   266	1	6	localException2	Exception
    //   90	39	7	localEmojiInfo	EmojiInfo
    // Exception table:
    //   from	to	target	type
    //   14	47	191	java/lang/Exception
    //   14	47	235	finally
    //   56	66	261	finally
    //   70	79	261	finally
    //   83	92	261	finally
    //   96	103	261	finally
    //   107	122	261	finally
    //   126	134	261	finally
    //   138	146	261	finally
    //   200	220	261	finally
    //   56	66	266	java/lang/Exception
    //   70	79	266	java/lang/Exception
    //   83	92	266	java/lang/Exception
    //   96	103	266	java/lang/Exception
    //   107	122	266	java/lang/Exception
    //   126	134	266	java/lang/Exception
    //   138	146	266	java/lang/Exception
  }
  
  public final EmojiInfo e(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(62805);
    paramString1 = b(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, paramString3);
    AppMethodBeat.o(62805);
    return paramString1;
  }
  
  public final boolean eR(List<String> paramList)
  {
    AppMethodBeat.i(62830);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(62830);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE");
    localStringBuilder.append(" EmojiInfo ");
    localStringBuilder.append(" SET ");
    localStringBuilder.append("catalog");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.yPg);
    localStringBuilder.append(",");
    localStringBuilder.append("source");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.yPx);
    localStringBuilder.append(",");
    localStringBuilder.append("needupload");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.yPz);
    localStringBuilder.append(" where ");
    localStringBuilder.append("md5");
    localStringBuilder.append(" IN (");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append("'" + (String)paramList.get(i) + "'");
      if (i < paramList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    ab.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    if (this.db.execSQL("EmojiInfo", localStringBuilder.toString())) {
      doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(62830);
    return true;
  }
  
  public final boolean eS(List<String> paramList)
  {
    AppMethodBeat.i(62831);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(62831);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE");
    localStringBuilder.append(" EmojiInfo ");
    localStringBuilder.append(" SET ");
    localStringBuilder.append("groupId");
    localStringBuilder.append("=");
    localStringBuilder.append("\"\"");
    localStringBuilder.append(" where ");
    localStringBuilder.append("md5");
    localStringBuilder.append(" IN (");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append("'" + (String)paramList.get(i) + "'");
      if (i < paramList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    ab.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    if (this.db.execSQL("EmojiInfo", localStringBuilder.toString())) {
      doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(62831);
    return true;
  }
  
  public final boolean eT(List<zg> paramList)
  {
    AppMethodBeat.i(62843);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
      AppMethodBeat.o(62843);
      return false;
    }
    ab.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    com.tencent.mm.cg.h localh = null;
    long l;
    if ((this.db instanceof com.tencent.mm.cg.h))
    {
      localh = (com.tencent.mm.cg.h)this.db;
      l = localh.kr(Thread.currentThread().getId());
      ab.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int i = 0;
      while (i < paramList.size())
      {
        zg localzg = (zg)paramList.get(i);
        EmojiInfo localEmojiInfo2 = asP(localzg.Md5);
        EmojiInfo localEmojiInfo1 = localEmojiInfo2;
        if (localEmojiInfo2 == null)
        {
          localEmojiInfo1 = new EmojiInfo();
          localEmojiInfo1.field_md5 = localzg.Md5;
          localEmojiInfo1.field_catalog = EmojiInfo.yPg;
          ab.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
        }
        b.a(localzg, localEmojiInfo1);
        J(localEmojiInfo1);
        i += 1;
      }
      if (localh != null)
      {
        localh.nY(l);
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
      }
      AppMethodBeat.o(62843);
      return true;
      l = -1L;
    }
  }
  
  /* Error */
  public final String getKey()
  {
    // Byte code:
    //   0: ldc_w 724
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   10: ldc_w 726
    //   13: iconst_1
    //   14: anewarray 24	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 728
    //   22: aastore
    //   23: iconst_2
    //   24: invokeinterface 74 4 0
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +69 -> 100
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokeinterface 80 1 0
    //   42: ifeq +58 -> 100
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: iconst_0
    //   49: invokeinterface 427 2 0
    //   54: astore_3
    //   55: aload_2
    //   56: astore_1
    //   57: ldc 88
    //   59: new 106	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 730
    //   66: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_3
    //   70: invokestatic 733	com/tencent/mm/sdk/platformtools/bo:aqg	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_2
    //   83: ifnull +9 -> 92
    //   86: aload_2
    //   87: invokeinterface 86 1 0
    //   92: ldc_w 724
    //   95: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_3
    //   99: areturn
    //   100: aload_2
    //   101: ifnull +9 -> 110
    //   104: aload_2
    //   105: invokeinterface 86 1 0
    //   110: invokestatic 738	com/tencent/mm/compatible/e/q:LK	()Ljava/lang/String;
    //   113: astore_1
    //   114: aload_1
    //   115: invokestatic 317	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   118: ifne +130 -> 248
    //   121: aload_1
    //   122: invokevirtual 742	java/lang/String:getBytes	()[B
    //   125: invokestatic 747	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   128: astore_1
    //   129: ldc 88
    //   131: new 106	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 749
    //   138: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_1
    //   142: invokestatic 733	com/tencent/mm/sdk/platformtools/bo:aqg	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: new 26	com/tencent/mm/storage/emotion/EmojiInfo
    //   157: dup
    //   158: invokespecial 417	com/tencent/mm/storage/emotion/EmojiInfo:<init>	()V
    //   161: astore_2
    //   162: aload_2
    //   163: aload_1
    //   164: putfield 204	com/tencent/mm/storage/emotion/EmojiInfo:field_md5	Ljava/lang/String;
    //   167: aload_2
    //   168: sipush 153
    //   171: putfield 211	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   174: aload_0
    //   175: aload_2
    //   176: invokevirtual 324	com/tencent/mm/storage/emotion/d:I	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Z
    //   179: ifeq +82 -> 261
    //   182: ldc_w 724
    //   185: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: areturn
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: astore_1
    //   195: ldc 88
    //   197: ldc_w 751
    //   200: iconst_1
    //   201: anewarray 92	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_3
    //   207: invokestatic 98	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_2
    //   215: ifnull -105 -> 110
    //   218: aload_2
    //   219: invokeinterface 86 1 0
    //   224: goto -114 -> 110
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +9 -> 240
    //   234: aload_1
    //   235: invokeinterface 86 1 0
    //   240: ldc_w 724
    //   243: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_2
    //   247: athrow
    //   248: ldc_w 753
    //   251: invokevirtual 742	java/lang/String:getBytes	()[B
    //   254: invokestatic 747	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   257: astore_1
    //   258: goto -129 -> 129
    //   261: ldc_w 724
    //   264: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_2
    //   270: goto -40 -> 230
    //   273: astore_3
    //   274: goto -81 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	d
    //   35	223	1	localObject1	Object
    //   29	190	2	localObject2	Object
    //   227	20	2	localObject3	Object
    //   269	1	2	localObject4	Object
    //   54	45	3	str	String
    //   190	17	3	localException1	Exception
    //   273	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	30	190	java/lang/Exception
    //   6	30	227	finally
    //   36	45	269	finally
    //   47	55	269	finally
    //   57	82	269	finally
    //   195	214	269	finally
    //   36	45	273	java/lang/Exception
    //   47	55	273	java/lang/Exception
    //   57	82	273	java/lang/Exception
  }
  
  public final String getTableName()
  {
    return "EmojiInfo";
  }
  
  /* Error */
  public final boolean init(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 757
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 88
    //   8: ldc_w 759
    //   11: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: ldc_w 761
    //   18: invokevirtual 274	com/tencent/mm/storage/emotion/d:asP	(Ljava/lang/String;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   21: astore 7
    //   23: aload_0
    //   24: ldc_w 763
    //   27: invokevirtual 274	com/tencent/mm/storage/emotion/d:asP	(Ljava/lang/String;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   30: astore 8
    //   32: aload_0
    //   33: getstatic 766	com/tencent/mm/storage/emotion/EmojiInfo:yPj	I
    //   36: invokespecial 768	com/tencent/mm/storage/emotion/d:ND	(I)I
    //   39: istore_2
    //   40: ldc 88
    //   42: ldc_w 770
    //   45: iconst_1
    //   46: anewarray 92	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_2
    //   52: invokestatic 554	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload 7
    //   61: ifnonnull +24 -> 85
    //   64: aload 8
    //   66: ifnull +14 -> 80
    //   69: aload 8
    //   71: invokevirtual 773	com/tencent/mm/storage/emotion/EmojiInfo:getContent	()Ljava/lang/String;
    //   74: invokevirtual 265	java/lang/String:length	()I
    //   77: ifeq +8 -> 85
    //   80: iload_2
    //   81: iconst_2
    //   82: if_icmpgt +35 -> 117
    //   85: ldc 88
    //   87: ldc_w 775
    //   90: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: getstatic 493	com/tencent/mm/storage/emotion/EmojiInfo:yPi	I
    //   97: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   100: pop
    //   101: aload_0
    //   102: getstatic 496	com/tencent/mm/storage/emotion/EmojiInfo:yPl	I
    //   105: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   108: pop
    //   109: aload_0
    //   110: getstatic 499	com/tencent/mm/storage/emotion/EmojiInfo:yPk	I
    //   113: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   116: pop
    //   117: aload_0
    //   118: ldc_w 779
    //   121: invokevirtual 274	com/tencent/mm/storage/emotion/d:asP	(Ljava/lang/String;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   124: astore 7
    //   126: aload 7
    //   128: ifnull +46 -> 174
    //   131: aload 7
    //   133: getfield 211	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   136: getstatic 493	com/tencent/mm/storage/emotion/EmojiInfo:yPi	I
    //   139: if_icmpne +35 -> 174
    //   142: ldc 88
    //   144: ldc_w 781
    //   147: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_0
    //   151: getstatic 493	com/tencent/mm/storage/emotion/EmojiInfo:yPi	I
    //   154: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   157: pop
    //   158: aload_0
    //   159: getstatic 496	com/tencent/mm/storage/emotion/EmojiInfo:yPl	I
    //   162: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   165: pop
    //   166: aload_0
    //   167: getstatic 499	com/tencent/mm/storage/emotion/EmojiInfo:yPk	I
    //   170: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   173: pop
    //   174: aload_1
    //   175: ldc_w 783
    //   178: invokestatic 506	com/tencent/mm/storage/emotion/EmojiInfo:bI	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   181: astore 7
    //   183: aload 7
    //   185: ifnull +35 -> 220
    //   188: ldc 88
    //   190: ldc_w 785
    //   193: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_0
    //   197: getstatic 493	com/tencent/mm/storage/emotion/EmojiInfo:yPi	I
    //   200: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   203: pop
    //   204: aload_0
    //   205: getstatic 496	com/tencent/mm/storage/emotion/EmojiInfo:yPl	I
    //   208: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   211: pop
    //   212: aload_0
    //   213: getstatic 499	com/tencent/mm/storage/emotion/EmojiInfo:yPk	I
    //   216: invokevirtual 777	com/tencent/mm/storage/emotion/d:NI	(I)Z
    //   219: pop
    //   220: aload 7
    //   222: ifnull +8 -> 230
    //   225: aload 7
    //   227: invokevirtual 512	java/io/InputStream:close	()V
    //   230: aload_0
    //   231: getstatic 493	com/tencent/mm/storage/emotion/EmojiInfo:yPi	I
    //   234: invokespecial 768	com/tencent/mm/storage/emotion/d:ND	(I)I
    //   237: ifeq +11 -> 248
    //   240: ldc_w 757
    //   243: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: iconst_1
    //   247: ireturn
    //   248: aconst_null
    //   249: astore 10
    //   251: aconst_null
    //   252: astore 9
    //   254: aload 9
    //   256: astore 8
    //   258: aload 10
    //   260: astore 7
    //   262: ldc 88
    //   264: ldc_w 787
    //   267: invokestatic 535	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 9
    //   272: astore 8
    //   274: aload 10
    //   276: astore 7
    //   278: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   281: lstore_3
    //   282: aload 9
    //   284: astore 8
    //   286: aload 10
    //   288: astore 7
    //   290: aload_1
    //   291: invokevirtual 793	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   294: ldc_w 795
    //   297: invokevirtual 801	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   300: astore_1
    //   301: aload_1
    //   302: astore 8
    //   304: aload_1
    //   305: astore 7
    //   307: iconst_1
    //   308: anewarray 508	java/io/InputStream
    //   311: dup
    //   312: iconst_0
    //   313: aload_1
    //   314: aastore
    //   315: invokestatic 803	com/tencent/mm/storage/emotion/d:a	([Ljava/io/InputStream;)Ljava/util/List;
    //   318: astore 10
    //   320: aload_1
    //   321: astore 8
    //   323: aload_1
    //   324: astore 7
    //   326: ldc 88
    //   328: ldc_w 805
    //   331: iconst_1
    //   332: anewarray 92	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   340: lload_3
    //   341: lsub
    //   342: invokestatic 349	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   345: aastore
    //   346: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_1
    //   350: astore 8
    //   352: aload_1
    //   353: astore 7
    //   355: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   358: lstore 5
    //   360: aload_1
    //   361: astore 8
    //   363: aload_1
    //   364: astore 7
    //   366: aload 10
    //   368: invokeinterface 659 1 0
    //   373: ifle +168 -> 541
    //   376: aload_1
    //   377: astore 8
    //   379: aload_1
    //   380: astore 7
    //   382: aload 10
    //   384: invokeinterface 659 1 0
    //   389: ifle +152 -> 541
    //   392: ldc2_w 350
    //   395: lstore_3
    //   396: aload_1
    //   397: astore 8
    //   399: aload_1
    //   400: astore 7
    //   402: aload_0
    //   403: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   406: instanceof 688
    //   409: ifeq +348 -> 757
    //   412: aload_1
    //   413: astore 8
    //   415: aload_1
    //   416: astore 7
    //   418: aload_0
    //   419: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   422: checkcast 688	com/tencent/mm/cg/h
    //   425: astore 9
    //   427: aload_1
    //   428: astore 8
    //   430: aload_1
    //   431: astore 7
    //   433: aload 9
    //   435: invokestatic 694	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   438: invokevirtual 697	java/lang/Thread:getId	()J
    //   441: invokevirtual 701	com/tencent/mm/cg/h:kr	(J)J
    //   444: lstore_3
    //   445: aload_1
    //   446: astore 8
    //   448: aload_1
    //   449: astore 7
    //   451: aload 10
    //   453: invokeinterface 809 1 0
    //   458: astore 10
    //   460: aload_1
    //   461: astore 8
    //   463: aload_1
    //   464: astore 7
    //   466: aload 10
    //   468: invokeinterface 814 1 0
    //   473: ifeq +128 -> 601
    //   476: aload_1
    //   477: astore 8
    //   479: aload_1
    //   480: astore 7
    //   482: aload 10
    //   484: invokeinterface 818 1 0
    //   489: checkcast 26	com/tencent/mm/storage/emotion/EmojiInfo
    //   492: invokevirtual 338	com/tencent/mm/storage/emotion/EmojiInfo:convertTo	()Landroid/content/ContentValues;
    //   495: astore 11
    //   497: aload_1
    //   498: astore 8
    //   500: aload_1
    //   501: astore 7
    //   503: aload_0
    //   504: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   507: ldc 32
    //   509: ldc 200
    //   511: aload 11
    //   513: invokeinterface 342 4 0
    //   518: lconst_0
    //   519: lcmp
    //   520: ifge -60 -> 460
    //   523: aload 9
    //   525: ifnull +16 -> 541
    //   528: aload_1
    //   529: astore 8
    //   531: aload_1
    //   532: astore 7
    //   534: aload 9
    //   536: lload_3
    //   537: invokevirtual 719	com/tencent/mm/cg/h:nY	(J)I
    //   540: pop
    //   541: aload_1
    //   542: astore 8
    //   544: aload_1
    //   545: astore 7
    //   547: ldc 88
    //   549: ldc_w 820
    //   552: iconst_1
    //   553: anewarray 92	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   561: lload 5
    //   563: lsub
    //   564: invokestatic 349	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   567: aastore
    //   568: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_1
    //   572: astore 8
    //   574: aload_1
    //   575: astore 7
    //   577: ldc 88
    //   579: ldc_w 822
    //   582: invokestatic 583	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: aload_1
    //   586: ifnull +7 -> 593
    //   589: aload_1
    //   590: invokevirtual 512	java/io/InputStream:close	()V
    //   593: ldc_w 757
    //   596: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   599: iconst_1
    //   600: ireturn
    //   601: aload 9
    //   603: ifnull -62 -> 541
    //   606: aload_1
    //   607: astore 8
    //   609: aload_1
    //   610: astore 7
    //   612: aload 9
    //   614: lload_3
    //   615: invokevirtual 719	com/tencent/mm/cg/h:nY	(J)I
    //   618: pop
    //   619: goto -78 -> 541
    //   622: astore_1
    //   623: aload 8
    //   625: astore 7
    //   627: ldc 88
    //   629: new 106	java/lang/StringBuilder
    //   632: dup
    //   633: ldc_w 824
    //   636: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   639: aload_1
    //   640: invokevirtual 825	java/io/IOException:getMessage	()Ljava/lang/String;
    //   643: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: aload 8
    //   654: ifnull -61 -> 593
    //   657: aload 8
    //   659: invokevirtual 512	java/io/InputStream:close	()V
    //   662: goto -69 -> 593
    //   665: astore_1
    //   666: ldc 88
    //   668: ldc 90
    //   670: iconst_1
    //   671: anewarray 92	java/lang/Object
    //   674: dup
    //   675: iconst_0
    //   676: aload_1
    //   677: invokestatic 98	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   680: aastore
    //   681: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   684: goto -91 -> 593
    //   687: astore_1
    //   688: ldc 88
    //   690: ldc 90
    //   692: iconst_1
    //   693: anewarray 92	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: aload_1
    //   699: invokestatic 98	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   702: aastore
    //   703: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   706: goto -113 -> 593
    //   709: astore_1
    //   710: aload 7
    //   712: ifnull +8 -> 720
    //   715: aload 7
    //   717: invokevirtual 512	java/io/InputStream:close	()V
    //   720: ldc_w 757
    //   723: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_1
    //   727: athrow
    //   728: astore 7
    //   730: ldc 88
    //   732: ldc 90
    //   734: iconst_1
    //   735: anewarray 92	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: aload 7
    //   742: invokestatic 98	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   745: aastore
    //   746: invokestatic 104	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   749: goto -29 -> 720
    //   752: astore 7
    //   754: goto -524 -> 230
    //   757: aconst_null
    //   758: astore 9
    //   760: goto -315 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	d
    //   0	763	1	paramContext	Context
    //   39	44	2	i	int
    //   281	334	3	l1	long
    //   358	204	5	l2	long
    //   21	695	7	localObject1	Object
    //   728	13	7	localException1	Exception
    //   752	1	7	localException2	Exception
    //   30	628	8	localObject2	Object
    //   252	507	9	localh	com.tencent.mm.cg.h
    //   249	234	10	localObject3	Object
    //   495	17	11	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   262	270	622	java/io/IOException
    //   278	282	622	java/io/IOException
    //   290	301	622	java/io/IOException
    //   307	320	622	java/io/IOException
    //   326	349	622	java/io/IOException
    //   355	360	622	java/io/IOException
    //   366	376	622	java/io/IOException
    //   382	392	622	java/io/IOException
    //   402	412	622	java/io/IOException
    //   418	427	622	java/io/IOException
    //   433	445	622	java/io/IOException
    //   451	460	622	java/io/IOException
    //   466	476	622	java/io/IOException
    //   482	497	622	java/io/IOException
    //   503	523	622	java/io/IOException
    //   534	541	622	java/io/IOException
    //   547	571	622	java/io/IOException
    //   577	585	622	java/io/IOException
    //   612	619	622	java/io/IOException
    //   657	662	665	java/lang/Exception
    //   589	593	687	java/lang/Exception
    //   262	270	709	finally
    //   278	282	709	finally
    //   290	301	709	finally
    //   307	320	709	finally
    //   326	349	709	finally
    //   355	360	709	finally
    //   366	376	709	finally
    //   382	392	709	finally
    //   402	412	709	finally
    //   418	427	709	finally
    //   433	445	709	finally
    //   451	460	709	finally
    //   466	476	709	finally
    //   482	497	709	finally
    //   503	523	709	finally
    //   534	541	709	finally
    //   547	571	709	finally
    //   577	585	709	finally
    //   612	619	709	finally
    //   627	652	709	finally
    //   715	720	728	java/lang/Exception
    //   225	230	752	java/lang/Exception
  }
  
  public final boolean k(List<EmojiInfo> paramList, String paramString)
  {
    AppMethodBeat.i(62833);
    if (paramList.size() <= 0)
    {
      ab.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
      AppMethodBeat.o(62833);
      return false;
    }
    ab.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    com.tencent.mm.cg.h localh = null;
    if ((this.db instanceof com.tencent.mm.cg.h)) {
      localh = (com.tencent.mm.cg.h)this.db;
    }
    for (long l = localh.kr(Thread.currentThread().getId());; l = -1L)
    {
      Object localObject = Kw(paramString);
      paramString = new HashMap();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        paramString.put(localEmojiInfo.Al(), localEmojiInfo);
      }
      int i = 0;
      while (i < paramList.size())
      {
        localObject = (EmojiInfo)paramList.get(i);
        ((EmojiInfo)localObject).field_temp = 0;
        this.db.replace("EmojiInfo", "md5", ((EmojiInfo)localObject).convertTo());
        paramString.remove(((EmojiInfo)localObject).Al());
        i += 1;
      }
      paramList = paramString.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (EmojiInfo)((Map.Entry)localObject).getValue();
        ((EmojiInfo)localObject).field_temp = 1;
        this.db.update("EmojiInfo", ((EmojiInfo)localObject).convertTo(), "md5=?", new String[] { paramString });
        ab.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", new Object[] { ((EmojiInfo)localObject).field_groupId });
      }
      if (localh != null) {
        localh.nY(l);
      }
      AppMethodBeat.o(62833);
      return true;
    }
  }
  
  public final boolean l(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(62832);
    ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
    long l2 = System.currentTimeMillis();
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
      AppMethodBeat.o(62832);
      return false;
    }
    Object localObject1 = NF(paramInt);
    com.tencent.mm.cg.h localh = null;
    if ((this.db instanceof com.tencent.mm.cg.h)) {
      localh = (com.tencent.mm.cg.h)this.db;
    }
    for (long l1 = localh.kr(Thread.currentThread().getId());; l1 = -1L)
    {
      Object localObject2 = paramList.iterator();
      int j;
      for (int i = 1; ((Iterator)localObject2).hasNext(); i = j)
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        EmojiInfo localEmojiInfo = asP((String)localObject3);
        j = i;
        if (localEmojiInfo != null)
        {
          j = i;
          if (!bo.isNullOrNil(localEmojiInfo.Al()))
          {
            if (paramInt == 1) {
              localEmojiInfo.field_idx = i;
            }
            for (;;)
            {
              if (!((List)localObject1).isEmpty()) {
                ((List)localObject1).remove(localObject3);
              }
              j = i + 1;
              localObject3 = localEmojiInfo.convertTo();
              if (this.db.replace("EmojiInfo", "md5", (ContentValues)localObject3) >= 0L) {
                break;
              }
              if (localh != null) {
                localh.nY(l1);
              }
              ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
              AppMethodBeat.o(62832);
              return false;
              localEmojiInfo.field_reserved3 = i;
            }
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = asP((String)((Iterator)localObject1).next());
          if ((localObject2 != null) && (!bo.isNullOrNil(((EmojiInfo)localObject2).Al())))
          {
            if (paramInt == 1) {
              ((EmojiInfo)localObject2).field_idx = i;
            }
            for (;;)
            {
              i += 1;
              localObject2 = ((EmojiInfo)localObject2).convertTo();
              if (this.db.replace("EmojiInfo", "md5", (ContentValues)localObject2) >= 0L) {
                break;
              }
              if (localh != null) {
                localh.nY(l1);
              }
              ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
              AppMethodBeat.o(62832);
              return false;
              ((EmojiInfo)localObject2).field_reserved3 = i;
            }
          }
        }
      }
      if (localh != null) {
        localh.nY(l1);
      }
      l1 = System.currentTimeMillis();
      if (paramList == null) {}
      for (paramInt = 0;; paramInt = paramList.size())
      {
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(paramInt) });
        AppMethodBeat.o(62832);
        return true;
      }
    }
  }
  
  public final boolean m(int paramInt, List<EmojiInfo> paramList)
  {
    for (;;)
    {
      long l2;
      boolean bool;
      int i;
      Object localObject;
      try
      {
        AppMethodBeat.i(62836);
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        l2 = System.currentTimeMillis();
        if ((paramList == null) || (paramList.size() <= 0))
        {
          ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
          bool = false;
          AppMethodBeat.o(62836);
          return bool;
        }
        if (!(this.db instanceof com.tencent.mm.cg.h)) {
          break label636;
        }
        localh = (com.tencent.mm.cg.h)this.db;
        l1 = localh.kr(Thread.currentThread().getId());
        Iterator localIterator = paramList.iterator();
        i = 1;
        if (!localIterator.hasNext()) {
          break label560;
        }
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        String str = localEmojiInfo.Al();
        localObject = asP(str);
        if ((localObject == null) || (bo.isNullOrNil(((EmojiInfo)localObject).Al())))
        {
          localObject = new EmojiInfo();
          ((EmojiInfo)localObject).field_md5 = str;
          ((EmojiInfo)localObject).field_source = EmojiInfo.yPy;
          ((EmojiInfo)localObject).field_lastUseTime = System.currentTimeMillis();
          if (paramInt != 1) {
            break label532;
          }
          if (((EmojiInfo)localObject).field_catalog != EmojiInfo.yPm) {
            ((EmojiInfo)localObject).field_catalog = EmojiInfo.yPg;
          }
          ((EmojiInfo)localObject).field_groupId = "capture";
          ((EmojiInfo)localObject).field_idx = i;
          if (!((EmojiInfo)localObject).dzn()) {
            break label549;
          }
          ((EmojiInfo)localObject).field_reserved4 |= EmojiInfo.APx;
          ((EmojiInfo)localObject).field_state = EmojiInfo.yPu;
          ((EmojiInfo)localObject).field_size = ((int)com.tencent.mm.vfs.e.avI(((EmojiInfo)localObject).dQB()));
          ((EmojiInfo)localObject).field_cdnUrl = localEmojiInfo.field_cdnUrl;
          ((EmojiInfo)localObject).field_thumbUrl = localEmojiInfo.field_thumbUrl;
          ((EmojiInfo)localObject).field_designerID = localEmojiInfo.field_designerID;
          ((EmojiInfo)localObject).field_encrypturl = localEmojiInfo.field_encrypturl;
          ((EmojiInfo)localObject).field_aeskey = localEmojiInfo.field_aeskey;
          ((EmojiInfo)localObject).field_externUrl = localEmojiInfo.field_externUrl;
          ((EmojiInfo)localObject).field_externMd5 = localEmojiInfo.field_externMd5;
          ((EmojiInfo)localObject).field_activityid = localEmojiInfo.field_activityid;
          ((EmojiInfo)localObject).field_attachedText = localEmojiInfo.field_attachedText;
          ((EmojiInfo)localObject).field_attachTextColor = localEmojiInfo.field_attachTextColor;
          ((EmojiInfo)localObject).field_lensId = localEmojiInfo.field_lensId;
          ab.i("MicroMsg.emoji.EmojiInfoStorage", "preparedDownloadCustomEmojiList: %s, %s, %s", new Object[] { ((EmojiInfo)localObject).Al(), Integer.valueOf(((EmojiInfo)localObject).field_state), Integer.valueOf(((EmojiInfo)localObject).field_size) });
          localObject = ((EmojiInfo)localObject).convertTo();
          if (this.db.replace("EmojiInfo", "md5", (ContentValues)localObject) >= 0L) {
            break label647;
          }
          if (localh != null) {
            localh.nY(l1);
          }
          ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          bool = false;
          AppMethodBeat.o(62836);
          continue;
        }
        ((EmojiInfo)localObject).field_source = EmojiInfo.yPy;
      }
      finally {}
      continue;
      label532:
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.yPm;
      ((EmojiInfo)localObject).field_reserved3 = i;
      continue;
      label549:
      ((EmojiInfo)localObject).field_state = EmojiInfo.yPv;
      continue;
      label560:
      if (localh != null) {
        localh.nY(l1);
      }
      long l1 = System.currentTimeMillis();
      if (paramList == null) {}
      for (paramInt = 0;; paramInt = paramList.size())
      {
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(paramInt) });
        bool = true;
        AppMethodBeat.o(62836);
        break;
      }
      label636:
      l1 = -1L;
      com.tencent.mm.cg.h localh = null;
      continue;
      label647:
      i += 1;
    }
  }
  
  /* Error */
  public final EmojiInfo or(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 951
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lload_1
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +11 -> 20
    //   12: ldc_w 951
    //   15: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: getfield 55	com/tencent/mm/storage/emotion/d:db	Lcom/tencent/mm/sdk/e/e;
    //   24: ldc 32
    //   26: aconst_null
    //   27: ldc_w 953
    //   30: iconst_1
    //   31: anewarray 24	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: lload_1
    //   37: invokestatic 956	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: iconst_2
    //   45: invokeinterface 594 9 0
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +162 -> 216
    //   57: aload 4
    //   59: astore 5
    //   61: aload 4
    //   63: invokeinterface 80 1 0
    //   68: ifeq +148 -> 216
    //   71: aload 4
    //   73: astore 5
    //   75: invokestatic 194	com/tencent/mm/plugin/emoji/e:bki	()Lcom/tencent/mm/plugin/emoji/e;
    //   78: pop
    //   79: aload 4
    //   81: astore 5
    //   83: new 26	com/tencent/mm/storage/emotion/EmojiInfo
    //   86: dup
    //   87: invokestatic 197	com/tencent/mm/plugin/emoji/e:bkj	()Ljava/lang/String;
    //   90: invokespecial 198	com/tencent/mm/storage/emotion/EmojiInfo:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload 4
    //   96: astore 5
    //   98: aload_3
    //   99: aload 4
    //   101: invokevirtual 386	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   104: aload_3
    //   105: astore 5
    //   107: aload 4
    //   109: ifnull +13 -> 122
    //   112: aload 4
    //   114: invokeinterface 86 1 0
    //   119: aload_3
    //   120: astore 5
    //   122: ldc_w 951
    //   125: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload 5
    //   130: areturn
    //   131: astore 6
    //   133: aconst_null
    //   134: astore 4
    //   136: aconst_null
    //   137: astore_3
    //   138: aload 4
    //   140: astore 5
    //   142: ldc 88
    //   144: aload 6
    //   146: ldc 255
    //   148: iconst_0
    //   149: anewarray 92	java/lang/Object
    //   152: invokestatic 960	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: astore 5
    //   158: aload 4
    //   160: ifnull -38 -> 122
    //   163: aload 4
    //   165: invokeinterface 86 1 0
    //   170: aload_3
    //   171: astore 5
    //   173: goto -51 -> 122
    //   176: astore_3
    //   177: aconst_null
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +10 -> 192
    //   185: aload 5
    //   187: invokeinterface 86 1 0
    //   192: ldc_w 951
    //   195: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_3
    //   199: athrow
    //   200: astore_3
    //   201: goto -21 -> 180
    //   204: astore 6
    //   206: aconst_null
    //   207: astore_3
    //   208: goto -70 -> 138
    //   211: astore 6
    //   213: goto -75 -> 138
    //   216: aconst_null
    //   217: astore_3
    //   218: goto -114 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	d
    //   0	221	1	paramLong	long
    //   93	78	3	localEmojiInfo	EmojiInfo
    //   176	23	3	localObject1	Object
    //   200	1	3	localObject2	Object
    //   207	11	3	localObject3	Object
    //   50	114	4	localCursor	Cursor
    //   59	127	5	localObject4	Object
    //   131	14	6	localException1	Exception
    //   204	1	6	localException2	Exception
    //   211	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   20	52	131	java/lang/Exception
    //   20	52	176	finally
    //   61	71	200	finally
    //   75	79	200	finally
    //   83	94	200	finally
    //   98	104	200	finally
    //   142	155	200	finally
    //   61	71	204	java/lang/Exception
    //   75	79	204	java/lang/Exception
    //   83	94	204	java/lang/Exception
    //   98	104	211	java/lang/Exception
  }
  
  public final boolean os(long paramLong)
  {
    AppMethodBeat.i(62823);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(62823);
      return false;
    }
    int i = this.db.delete("EmojiInfo", "captureEnterTime=".concat(String.valueOf(paramLong)), null);
    if (i > 0) {
      doNotify("event_update_emoji");
    }
    if (i > 0)
    {
      AppMethodBeat.o(62823);
      return true;
    }
    AppMethodBeat.o(62823);
    return false;
  }
  
  public final int pT(boolean paramBoolean)
  {
    k = 0;
    j = 0;
    AppMethodBeat.i(62816);
    localObject3 = null;
    localObject1 = null;
    String str;
    Object localObject4;
    if (!paramBoolean)
    {
      str = "select count(*) from EmojiInfo where groupId=?";
      localObject4 = new String[1];
      localObject4[0] = "capture";
    }
    for (;;)
    {
      try
      {
        localObject4 = this.db.a(str, (String[])localObject4, 2);
        int i = j;
        if (localObject4 != null)
        {
          i = j;
          localObject1 = localObject4;
          localObject3 = localObject4;
          if (((Cursor)localObject4).moveToFirst())
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            i = ((Cursor)localObject4).getInt(0);
          }
        }
        j = i;
        if (localObject4 != null)
        {
          ((Cursor)localObject4).close();
          j = i;
        }
      }
      catch (Exception localException)
      {
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(localException) });
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", new Object[] { localException.toString() });
        j = k;
        if (localObject1 == null) {
          continue;
        }
        localObject1.close();
        j = k;
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        localObject3.close();
        AppMethodBeat.o(62816);
      }
      AppMethodBeat.o(62816);
      return j;
      str = "select count(*) from EmojiInfo where groupId=? AND captureStatus=0";
      localObject4 = new String[1];
      localObject4[0] = "capture";
    }
  }
  
  public final List<EmojiInfo> pU(boolean paramBoolean)
  {
    AppMethodBeat.i(62818);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (Object localObject1 = "select * from EmojiInfo where catalog =?  order by reserved3 asc";; localObject1 = "select * from EmojiInfo where catalog =? and state != " + EmojiInfo.yPv + " order by reserved3 asc")
    {
      Object localObject2 = EmojiGroupInfo.yPf;
      localObject1 = this.db.a((String)localObject1, new String[] { localObject2 }, 2);
      if (((Cursor)localObject1).moveToFirst()) {
        do
        {
          com.tencent.mm.plugin.emoji.e.bki();
          localObject2 = new EmojiInfo(com.tencent.mm.plugin.emoji.e.bkj());
          ((EmojiInfo)localObject2).convertFrom((Cursor)localObject1);
          localArrayList.add(localObject2);
        } while (((Cursor)localObject1).moveToNext());
      }
      ((Cursor)localObject1).close();
      AppMethodBeat.o(62818);
      return localArrayList;
    }
  }
  
  public final boolean t(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(62829);
    if (paramInt == 1)
    {
      bool = eS(paramList);
      AppMethodBeat.o(62829);
      return bool;
    }
    boolean bool = eR(paramList);
    AppMethodBeat.o(62829);
    return bool;
  }
  
  public final int y(boolean paramBoolean1, boolean paramBoolean2)
  {
    k = 0;
    j = 0;
    AppMethodBeat.i(62815);
    localObject4 = null;
    localObject3 = null;
    String str;
    Object localObject1;
    if (paramBoolean1) {
      if (!paramBoolean2)
      {
        str = "select count(*) from EmojiInfo where catalog IN (?,?)";
        localObject1 = new String[2];
        localObject1[0] = String.valueOf(EmojiGroupInfo.yPe);
        localObject1[1] = String.valueOf(EmojiGroupInfo.yPf);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.db.a(str, (String[])localObject1, 2);
        int i = j;
        if (localObject1 != null)
        {
          i = j;
          localObject3 = localObject1;
          localObject4 = localObject1;
          if (((Cursor)localObject1).moveToFirst())
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            i = ((Cursor)localObject1).getInt(0);
          }
        }
        j = i;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          j = i;
        }
      }
      catch (Exception localException)
      {
        localObject4 = localObject3;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bo.l(localException) });
        localObject4 = localObject3;
        ab.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", new Object[] { localException.toString() });
        j = k;
        if (localObject3 == null) {
          continue;
        }
        localObject3.close();
        j = k;
        continue;
      }
      finally
      {
        if (localObject4 == null) {
          continue;
        }
        localObject4.close();
        AppMethodBeat.o(62815);
      }
      AppMethodBeat.o(62815);
      return j;
      str = "select count(*) from EmojiInfo where catalog IN (?,?) AND captureStatus=0";
      localObject1 = new String[2];
      localObject1[0] = String.valueOf(EmojiGroupInfo.yPe);
      localObject1[1] = String.valueOf(EmojiGroupInfo.yPf);
      continue;
      if (!paramBoolean2)
      {
        str = "select count(*) from EmojiInfo where catalog=?";
        localObject1 = new String[1];
        localObject1[0] = EmojiGroupInfo.yPf;
      }
      else
      {
        str = "select count(*) from EmojiInfo where catalog=? AND captureStatus=0";
        localObject1 = new String[1];
        localObject1[0] = EmojiGroupInfo.yPf;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.d
 * JD-Core Version:    0.7.0.1
 */