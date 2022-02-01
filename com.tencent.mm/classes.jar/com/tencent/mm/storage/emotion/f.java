package com.tencent.mm.storage.emotion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.u;
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

public final class f
  extends MAutoStorage<EmojiInfo>
{
  public static final String[] SQL_CREATE;
  private static int[] VIE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105104);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(EmojiInfo.info, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )", "CREATE INDEX IF NOT EXISTS emojiinfogatalogindex  on EmojiInfo  (  catalog )" };
    VIE = new int[] { 2, 4, 8 };
    AppMethodBeat.o(105104);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, EmojiInfo.info, "EmojiInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  private EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4)
  {
    AppMethodBeat.i(230342);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      Log.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      AppMethodBeat.o(230342);
      return null;
    }
    EmojiInfo localEmojiInfo2 = bxK(paramString1);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null)
    {
      com.tencent.mm.plugin.emoji.h.cTw();
      localEmojiInfo1 = new EmojiInfo(com.tencent.mm.plugin.emoji.h.cTx());
      localEmojiInfo1.field_catalog = paramInt1;
    }
    localEmojiInfo1.field_md5 = paramString1;
    localEmojiInfo1.field_svrid = paramString2;
    localEmojiInfo1.field_type = paramInt2;
    localEmojiInfo1.field_size = paramInt3;
    localEmojiInfo1.field_state = EmojiInfo.ZuD;
    localEmojiInfo1.field_reserved1 = paramString3;
    localEmojiInfo1.field_reserved2 = paramString4;
    localEmojiInfo1.field_app_id = paramString5;
    localEmojiInfo1.field_temp = 1;
    localEmojiInfo1.field_reserved4 = 0;
    if (!TextUtils.isEmpty(paramString6)) {
      localEmojiInfo1.field_groupId = paramString6;
    }
    AppMethodBeat.o(230342);
    return localEmojiInfo1;
  }
  
  private static List<EmojiInfo> a(InputStream[] paramArrayOfInputStream)
  {
    AppMethodBeat.i(105084);
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
                com.tencent.mm.plugin.emoji.h.cTw();
                EmojiInfo localEmojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.h.cTx());
                localObject = (Element)localNodeList2.item(k);
                localEmojiInfo.field_md5 = ((Element)localObject).getAttribute("md5");
                if (!localEmojiInfo.gRk()) {
                  break label364;
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
                    break label361;
                  }
                  localObject = new String(Base64.decode((String)localObject, 0));
                  localEmojiInfo.field_content = ((String)localObject);
                  localArrayList.add(localEmojiInfo);
                  break label364;
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + paramArrayOfInputStream.getMessage());
        AppMethodBeat.o(105084);
        return localArrayList;
      }
      label361:
      label364:
      k += 1;
    }
  }
  
  private int asP(int paramInt)
  {
    j = 0;
    i = 0;
    AppMethodBeat.i(105070);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.db.rawQuery("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { String.valueOf(paramInt), "0" }, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        localObject3 = localObject1;
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + localException.getMessage());
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
        break label205;
      }
      localObject3.close();
      AppMethodBeat.o(105070);
    }
    AppMethodBeat.o(105070);
    return i;
  }
  
  public final boolean A(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(105090);
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
    long l2 = System.currentTimeMillis();
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
      AppMethodBeat.o(105090);
      return false;
    }
    Object localObject1 = asQ(paramInt);
    com.tencent.mm.storagebase.h localh = null;
    if ((this.db instanceof com.tencent.mm.storagebase.h)) {
      localh = (com.tencent.mm.storagebase.h)this.db;
    }
    for (long l1 = localh.beginTransaction(Thread.currentThread().getId());; l1 = -1L)
    {
      Object localObject2 = paramList.iterator();
      int j;
      for (int i = 1; ((Iterator)localObject2).hasNext(); i = j)
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        EmojiInfo localEmojiInfo = bxK((String)localObject3);
        j = i;
        if (localEmojiInfo != null)
        {
          j = i;
          if (!Util.isNullOrNil(localEmojiInfo.getMd5()))
          {
            if (paramInt == 1) {
              if (localEmojiInfo.hBB() == EmojiInfo.a.VIi) {
                localEmojiInfo.field_idx = i;
              }
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
                localh.endTransaction(l1);
              }
              Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
              AppMethodBeat.o(105090);
              return false;
              localEmojiInfo.field_idx = 0;
              continue;
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
          localObject2 = bxK((String)((Iterator)localObject1).next());
          if ((localObject2 != null) && (!Util.isNullOrNil(((EmojiInfo)localObject2).getMd5())))
          {
            if (paramInt == 1) {
              if (((EmojiInfo)localObject2).hBB() == EmojiInfo.a.VIi) {
                ((EmojiInfo)localObject2).field_idx = i;
              }
            }
            for (;;)
            {
              i += 1;
              localObject2 = ((EmojiInfo)localObject2).convertTo();
              if (this.db.replace("EmojiInfo", "md5", (ContentValues)localObject2) >= 0L) {
                break;
              }
              if (localh != null) {
                localh.endTransaction(l1);
              }
              Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
              AppMethodBeat.o(105090);
              return false;
              ((EmojiInfo)localObject2).field_idx = 0;
              continue;
              ((EmojiInfo)localObject2).field_reserved3 = i;
            }
          }
        }
      }
      if (localh != null) {
        localh.endTransaction(l1);
      }
      l1 = System.currentTimeMillis();
      if (paramList == null) {}
      for (paramInt = 0;; paramInt = paramList.size())
      {
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(paramInt) });
        doNotify("event_update_emoji");
        AppMethodBeat.o(105090);
        return true;
      }
    }
  }
  
  public final boolean B(int paramInt, List<EmojiInfo> paramList)
  {
    for (;;)
    {
      long l2;
      boolean bool;
      int i;
      Object localObject;
      try
      {
        AppMethodBeat.i(105094);
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        l2 = System.currentTimeMillis();
        if ((paramList == null) || (paramList.size() <= 0))
        {
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
          bool = false;
          AppMethodBeat.o(105094);
          return bool;
        }
        if (!(this.db instanceof com.tencent.mm.storagebase.h)) {
          break label533;
        }
        localh = (com.tencent.mm.storagebase.h)this.db;
        l1 = localh.beginTransaction(Thread.currentThread().getId());
        Iterator localIterator = paramList.iterator();
        i = 1;
        if (!localIterator.hasNext()) {
          break label457;
        }
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        String str = localEmojiInfo.getMd5();
        localObject = bxK(str);
        if ((localObject == null) || (Util.isNullOrNil(((EmojiInfo)localObject).getMd5())))
        {
          localObject = new EmojiInfo();
          ((EmojiInfo)localObject).field_md5 = str;
          ((EmojiInfo)localObject).field_source = EmojiInfo.ZuJ;
          ((EmojiInfo)localObject).field_lastUseTime = System.currentTimeMillis();
          if (paramInt != 1) {
            break label429;
          }
          if (((EmojiInfo)localObject).field_catalog != EmojiInfo.YCD) {
            ((EmojiInfo)localObject).field_catalog = EmojiInfo.YCx;
          }
          ((EmojiInfo)localObject).field_groupId = "capture";
          ((EmojiInfo)localObject).field_idx = i;
          if (!((EmojiInfo)localObject).hBo()) {
            break label446;
          }
          ((EmojiInfo)localObject).field_reserved4 |= EmojiInfo.ZuM;
          ((EmojiInfo)localObject).field_state = EmojiInfo.ZuF;
          ((EmojiInfo)localObject).field_size = ((int)u.bBQ(((EmojiInfo)localObject).ifh()));
          b.a(localEmojiInfo, (EmojiInfo)localObject);
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "preparedDownloadCustomEmojiList: %s, %s, %s", new Object[] { ((EmojiInfo)localObject).getMd5(), Integer.valueOf(((EmojiInfo)localObject).field_state), Integer.valueOf(((EmojiInfo)localObject).field_size) });
          localObject = ((EmojiInfo)localObject).convertTo();
          if (this.db.replace("EmojiInfo", "md5", (ContentValues)localObject) >= 0L) {
            break label544;
          }
          if (localh != null) {
            localh.endTransaction(l1);
          }
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          bool = false;
          AppMethodBeat.o(105094);
          continue;
        }
        ((EmojiInfo)localObject).field_source = EmojiInfo.ZuJ;
      }
      finally {}
      continue;
      label429:
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.YCD;
      ((EmojiInfo)localObject).field_reserved3 = i;
      continue;
      label446:
      ((EmojiInfo)localObject).field_state = EmojiInfo.ZuG;
      continue;
      label457:
      if (localh != null) {
        localh.endTransaction(l1);
      }
      long l1 = System.currentTimeMillis();
      if (paramList == null) {}
      for (paramInt = 0;; paramInt = paramList.size())
      {
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(paramInt) });
        bool = true;
        AppMethodBeat.o(105094);
        break;
      }
      label533:
      l1 = -1L;
      com.tencent.mm.storagebase.h localh = null;
      continue;
      label544:
      i += 1;
    }
  }
  
  public final List<String> C(int paramInt, List<String> paramList)
  {
    for (;;)
    {
      long l2;
      int i;
      Object localObject;
      try
      {
        AppMethodBeat.i(230395);
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomMd5List %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        LinkedList localLinkedList = new LinkedList();
        l2 = System.currentTimeMillis();
        if (paramList.size() <= 0)
        {
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDownloadCustomMd5List failed. list is null");
          AppMethodBeat.o(230395);
          return localLinkedList;
        }
        if (!(this.db instanceof com.tencent.mm.storagebase.h)) {
          break label544;
        }
        localh = (com.tencent.mm.storagebase.h)this.db;
        l1 = localh.beginTransaction(Thread.currentThread().getId());
        Iterator localIterator = paramList.iterator();
        i = 1;
        if (!localIterator.hasNext()) {
          break label471;
        }
        String str = (String)localIterator.next();
        localObject = bxK(str);
        if ((localObject == null) || (Util.isNullOrNil(((EmojiInfo)localObject).getMd5())))
        {
          localObject = new EmojiInfo();
          ((EmojiInfo)localObject).field_md5 = str;
          ((EmojiInfo)localObject).field_source = EmojiInfo.ZuJ;
          ((EmojiInfo)localObject).field_lastUseTime = System.currentTimeMillis();
          if (paramInt == 1)
          {
            if (((EmojiInfo)localObject).field_catalog != EmojiInfo.YCD) {
              ((EmojiInfo)localObject).field_catalog = EmojiInfo.YCx;
            }
            ((EmojiInfo)localObject).field_groupId = "capture";
            ((EmojiInfo)localObject).field_idx = i;
            if (!((EmojiInfo)localObject).hBo()) {
              break label460;
            }
            ((EmojiInfo)localObject).field_reserved4 |= EmojiInfo.ZuM;
            ((EmojiInfo)localObject).field_state = EmojiInfo.ZuF;
            ((EmojiInfo)localObject).field_size = ((int)u.bBQ(((EmojiInfo)localObject).ifh()));
            if ((!b.avc(str)) && (Util.isNullOrNil(((EmojiInfo)localObject).field_cdnUrl))) {
              localLinkedList.add(str);
            }
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "preparedDownloadCustomMd5List: %s, %s, %s", new Object[] { ((EmojiInfo)localObject).getMd5(), Integer.valueOf(((EmojiInfo)localObject).field_state), Integer.valueOf(((EmojiInfo)localObject).field_size) });
            localObject = ((EmojiInfo)localObject).convertTo();
            if (this.db.replace("EmojiInfo", "md5", (ContentValues)localObject) >= 0L) {
              break label555;
            }
            if (localh != null) {
              localh.endTransaction(l1);
            }
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomMd5List user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
            AppMethodBeat.o(230395);
          }
        }
        else
        {
          ((EmojiInfo)localObject).field_source = EmojiInfo.ZuJ;
          continue;
        }
        ((EmojiInfo)localObject).field_catalog = EmojiInfo.YCD;
      }
      finally {}
      ((EmojiInfo)localObject).field_reserved3 = i;
      continue;
      label460:
      ((EmojiInfo)localObject).field_state = EmojiInfo.ZuG;
      continue;
      label471:
      if (localh != null) {
        localh.endTransaction(l1);
      }
      long l1 = System.currentTimeMillis();
      if (paramList == null) {}
      for (paramInt = 0;; paramInt = paramList.size())
      {
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomMd5List user time:%d succes. size:%d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(paramInt) });
        AppMethodBeat.o(230395);
        break;
      }
      label544:
      l1 = -1L;
      com.tencent.mm.storagebase.h localh = null;
      continue;
      label555:
      i += 1;
    }
  }
  
  public final int EU(boolean paramBoolean)
  {
    k = 0;
    j = 0;
    AppMethodBeat.i(105073);
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
        localObject4 = this.db.rawQuery(str, (String[])localObject4, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        localObject3 = localObject1;
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", new Object[] { localException.toString() });
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
        AppMethodBeat.o(105073);
      }
      AppMethodBeat.o(105073);
      return j;
      str = "select count(*) from EmojiInfo where groupId=? AND captureStatus=0";
      localObject4 = new String[1];
      localObject4[0] = "capture";
    }
  }
  
  public final boolean J(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(105087);
    if (paramInt == 1)
    {
      bool = jS(paramList);
      AppMethodBeat.o(105087);
      return bool;
    }
    boolean bool = jR(paramList);
    AppMethodBeat.o(105087);
    return bool;
  }
  
  public final EmojiInfo K(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105059);
    if ((paramEmojiInfo == null) || (Util.isNullOrNil(paramEmojiInfo.getMd5())) || (paramEmojiInfo.getMd5().length() <= 0))
    {
      Log.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      AppMethodBeat.o(105059);
      return null;
    }
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "create: %s", new Object[] { paramEmojiInfo.field_md5 });
    if (L(paramEmojiInfo))
    {
      doNotify("create_emoji_info_notify");
      AppMethodBeat.o(105059);
      return paramEmojiInfo;
    }
    AppMethodBeat.o(105059);
    return null;
  }
  
  public final boolean L(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105065);
    if ((paramEmojiInfo == null) || (!paramEmojiInfo.gRk()))
    {
      Log.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      AppMethodBeat.o(105065);
      return false;
    }
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s", new Object[] { paramEmojiInfo.field_md5 });
    ContentValues localContentValues = paramEmojiInfo.convertTo();
    long l = this.db.replace("EmojiInfo", "md5", localContentValues);
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s, %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(l) });
    if (l >= 0L)
    {
      AppMethodBeat.o(105065);
      return true;
    }
    AppMethodBeat.o(105065);
    return false;
  }
  
  public final boolean M(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105066);
    if ((paramEmojiInfo == null) || (!paramEmojiInfo.gRk()))
    {
      Log.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      AppMethodBeat.o(105066);
      return false;
    }
    int i = this.db.update("EmojiInfo", paramEmojiInfo.convertTo(), "md5=?", new String[] { paramEmojiInfo.getMd5() });
    if (i > 0)
    {
      doNotify(paramEmojiInfo.getMd5());
      doNotify("event_update_emoji");
    }
    if (i > 0)
    {
      AppMethodBeat.o(105066);
      return true;
    }
    AppMethodBeat.o(105066);
    return false;
  }
  
  public final boolean N(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105067);
    if ((paramEmojiInfo == null) || (!paramEmojiInfo.gRk()))
    {
      Log.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      AppMethodBeat.o(105067);
      return false;
    }
    if (this.db.update("EmojiInfo", paramEmojiInfo.convertTo(), "md5=?", new String[] { paramEmojiInfo.getMd5() }) > 0)
    {
      AppMethodBeat.o(105067);
      return true;
    }
    AppMethodBeat.o(105067);
    return false;
  }
  
  /* Error */
  public final EmojiInfo UX(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 549
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lload_1
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +11 -> 20
    //   12: ldc_w 549
    //   15: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   24: ldc 30
    //   26: aconst_null
    //   27: ldc_w 551
    //   30: iconst_1
    //   31: anewarray 22	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: lload_1
    //   37: invokestatic 554	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: iconst_2
    //   45: invokeinterface 558 9 0
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +162 -> 216
    //   57: aload 4
    //   59: astore 5
    //   61: aload 4
    //   63: invokeinterface 284 1 0
    //   68: ifeq +148 -> 216
    //   71: aload 4
    //   73: astore 5
    //   75: invokestatic 80	com/tencent/mm/plugin/emoji/h:cTw	()Lcom/tencent/mm/plugin/emoji/h;
    //   78: pop
    //   79: aload 4
    //   81: astore 5
    //   83: new 24	com/tencent/mm/storage/emotion/EmojiInfo
    //   86: dup
    //   87: invokestatic 84	com/tencent/mm/plugin/emoji/h:cTx	()Ljava/lang/String;
    //   90: invokespecial 87	com/tencent/mm/storage/emotion/EmojiInfo:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload 4
    //   96: astore 5
    //   98: aload_3
    //   99: aload 4
    //   101: invokevirtual 562	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   104: aload_3
    //   105: astore 5
    //   107: aload 4
    //   109: ifnull +13 -> 122
    //   112: aload 4
    //   114: invokeinterface 290 1 0
    //   119: aload_3
    //   120: astore 5
    //   122: ldc_w 549
    //   125: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload 5
    //   130: areturn
    //   131: astore 6
    //   133: aconst_null
    //   134: astore 4
    //   136: aconst_null
    //   137: astore_3
    //   138: aload 4
    //   140: astore 5
    //   142: ldc 62
    //   144: aload 6
    //   146: ldc 246
    //   148: iconst_0
    //   149: anewarray 294	java/lang/Object
    //   152: invokestatic 566	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: astore 5
    //   158: aload 4
    //   160: ifnull -38 -> 122
    //   163: aload 4
    //   165: invokeinterface 290 1 0
    //   170: aload_3
    //   171: astore 5
    //   173: goto -51 -> 122
    //   176: astore_3
    //   177: aconst_null
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +10 -> 192
    //   185: aload 5
    //   187: invokeinterface 290 1 0
    //   192: ldc_w 549
    //   195: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	221	0	this	f
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
  
  public final boolean UY(long paramLong)
  {
    AppMethodBeat.i(105081);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(105081);
      return false;
    }
    int i = this.db.delete("EmojiInfo", "captureEnterTime=".concat(String.valueOf(paramLong)), null);
    if (i > 0) {
      doNotify("event_update_emoji");
    }
    if (i > 0)
    {
      AppMethodBeat.o(105081);
      return true;
    }
    AppMethodBeat.o(105081);
    return false;
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(105061);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, null, paramString3, paramString4);
    AppMethodBeat.o(105061);
    return paramString1;
  }
  
  public final EmojiInfo a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(230340);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      Log.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      AppMethodBeat.o(230340);
      return null;
    }
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, null, paramString5, paramString6, 1);
    paramString1.field_state = EmojiInfo.ZuF;
    if (L(paramString1))
    {
      doNotify("create_emoji_info_notify");
      AppMethodBeat.o(230340);
      return paramString1;
    }
    AppMethodBeat.o(230340);
    return null;
  }
  
  public final void a(Context paramContext, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105083);
    Object localObject;
    Context localContext;
    if ((paramEmojiInfo.field_catalog == EmojiInfo.YCz) || (paramEmojiInfo.field_catalog == EmojiInfo.YCC) || (paramEmojiInfo.field_catalog == EmojiInfo.YCB))
    {
      localObject = null;
      localContext = null;
    }
    for (;;)
    {
      try
      {
        paramContext = EmojiInfo.cH(paramContext, paramEmojiInfo.getName());
        if (paramContext == null) {
          break label260;
        }
        localContext = paramContext;
        localObject = paramContext;
        j = paramContext.available();
        i = j;
      }
      catch (IOException paramContext)
      {
        localObject = localContext;
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramContext) });
        if (localContext == null) {
          break label255;
        }
        try
        {
          localContext.close();
          i = 0;
        }
        catch (IOException paramContext)
        {
          Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramContext) });
          i = 0;
        }
        continue;
      }
      finally
      {
        if (localObject == null) {
          break label212;
        }
      }
      try
      {
        paramContext.close();
        i = j;
      }
      catch (IOException paramContext)
      {
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramContext) });
        i = j;
        continue;
      }
      if ((i != 0) && (i != paramEmojiInfo.field_size))
      {
        paramEmojiInfo.field_size = i;
        M(paramEmojiInfo);
      }
      AppMethodBeat.o(105083);
      return;
      try
      {
        ((InputStream)localObject).close();
        label212:
        AppMethodBeat.o(105083);
        throw paramContext;
      }
      catch (IOException paramEmojiInfo)
      {
        for (;;)
        {
          Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramEmojiInfo) });
        }
      }
      int i = (int)u.bBQ(paramEmojiInfo.ifh());
      continue;
      label255:
      i = 0;
      continue;
      label260:
      int j = 0;
    }
  }
  
  public final List<String> asQ(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(105076);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("select md5 from EmojiInfo");
    if (paramInt == 1) {
      ((StringBuilder)localObject4).append(" where groupId = \"capture\" order by idx").append(" asc ");
    }
    for (;;)
    {
      try
      {
        localObject4 = this.db.rawQuery(((StringBuilder)localObject4).toString(), null, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[] { Util.stackTraceToString(localException) });
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
        AppMethodBeat.o(105076);
      }
      AppMethodBeat.o(105076);
      return localArrayList;
      ((StringBuilder)localObject4).append(" where catalog = ").append(EmojiGroupInfo.YCw).append(" order by reserved3 asc ");
    }
  }
  
  public final List<String> asR(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(105077);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(" select md5 from EmojiInfo");
    if (paramInt == 1) {
      ((StringBuilder)localObject4).append(" where groupId = \"capture\" and captureStatus").append(" = 0");
    }
    for (;;)
    {
      ((StringBuilder)localObject4).append(" and state in (").append(EmojiInfo.ZuF);
      ((StringBuilder)localObject4).append(" , ").append(EmojiInfo.ZuG);
      ((StringBuilder)localObject4).append(" ) ");
      localObject4 = ((StringBuilder)localObject4).toString();
      try
      {
        localObject4 = this.db.rawQuery((String)localObject4, null, 2);
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
          Log.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[] { Util.stackTraceToString(localException) });
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
        AppMethodBeat.o(105077);
      }
      AppMethodBeat.o(105077);
      return localArrayList;
      ((StringBuilder)localObject4).append(" where catalog = ").append(EmojiInfo.YCD);
    }
  }
  
  public final Cursor asS(int paramInt)
  {
    AppMethodBeat.i(105078);
    Cursor localCursor = this.db.query("EmojiInfo", null, "catalog=? and temp=?", new String[] { String.valueOf(paramInt), "0" }, null, null, null);
    AppMethodBeat.o(105078);
    return localCursor;
  }
  
  public final boolean asT(int paramInt)
  {
    AppMethodBeat.i(105082);
    if (this.db.delete("EmojiInfo", "catalog=?", new String[] { String.valueOf(paramInt) }) >= 0)
    {
      AppMethodBeat.o(105082);
      return true;
    }
    AppMethodBeat.o(105082);
    return false;
  }
  
  public final List<EmojiInfo> aug(String paramString)
  {
    AppMethodBeat.i(105086);
    ArrayList localArrayList = new ArrayList();
    localObject = null;
    str = null;
    try
    {
      paramString = this.db.rawQuery("select * from EmojiInfo where groupId=? and temp=? order by idx asc", new String[] { paramString, "0" }, 2);
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
            com.tencent.mm.plugin.emoji.h.cTw();
            str = paramString;
            localObject = paramString;
            EmojiInfo localEmojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.h.cTx());
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
        Log.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", new Object[] { paramString.toString() });
        if (str != null) {
          str.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label202;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(105086);
    }
    AppMethodBeat.o(105086);
    return localArrayList;
  }
  
  public final List<EmojiInfo> bR(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(105074);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from EmojiInfo where catalog = ").append(paramInt);
    if (!paramBoolean) {
      ((StringBuilder)localObject).append(" and state != ").append(EmojiInfo.ZuG);
    }
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
    AppMethodBeat.o(105074);
    return localArrayList;
  }
  
  public final int bl(boolean paramBoolean1, boolean paramBoolean2)
  {
    k = 0;
    j = 0;
    AppMethodBeat.i(105072);
    localObject4 = null;
    localObject3 = null;
    String str;
    Object localObject1;
    if (paramBoolean1) {
      if (!paramBoolean2)
      {
        str = "select count(*) from EmojiInfo where catalog IN (?,?)";
        localObject1 = new String[2];
        localObject1[0] = String.valueOf(EmojiGroupInfo.YCv);
        localObject1[1] = String.valueOf(EmojiGroupInfo.YCw);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.db.rawQuery(str, (String[])localObject1, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        localObject4 = localObject3;
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", new Object[] { localException.toString() });
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
        AppMethodBeat.o(105072);
      }
      AppMethodBeat.o(105072);
      return j;
      str = "select count(*) from EmojiInfo where catalog IN (?,?) AND captureStatus=0";
      localObject1 = new String[2];
      localObject1[0] = String.valueOf(EmojiGroupInfo.YCv);
      localObject1[1] = String.valueOf(EmojiGroupInfo.YCw);
      continue;
      if (!paramBoolean2)
      {
        str = "select count(*) from EmojiInfo where catalog=?";
        localObject1 = new String[1];
        localObject1[0] = EmojiGroupInfo.YCw;
      }
      else
      {
        str = "select count(*) from EmojiInfo where catalog=? AND captureStatus=0";
        localObject1 = new String[1];
        localObject1[0] = EmojiGroupInfo.YCw;
      }
    }
  }
  
  public final int bxD(String paramString)
  {
    AppMethodBeat.i(105071);
    long l = System.currentTimeMillis();
    Object localObject = null;
    String str = null;
    for (;;)
    {
      try
      {
        paramString = this.db.rawQuery("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { paramString, "0" }, 2);
        if (paramString == null) {
          break label220;
        }
        str = paramString;
        localObject = paramString;
        if (!paramString.moveToFirst()) {
          break label220;
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        localObject = str;
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + paramString.getMessage());
        if (str == null) {
          break label215;
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
        AppMethodBeat.o(105071);
      }
      Log.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(105071);
      return j;
      label215:
      int j = 0;
      continue;
      label220:
      int i = 0;
    }
  }
  
  /* Error */
  public final EmojiInfo bxK(String paramString)
  {
    // Byte code:
    //   0: ldc_w 715
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 362	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +12 -> 22
    //   13: aload_1
    //   14: invokevirtual 60	java/lang/String:length	()I
    //   17: bipush 32
    //   19: if_icmpeq +27 -> 46
    //   22: ldc 62
    //   24: ldc_w 717
    //   27: iconst_1
    //   28: anewarray 294	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: invokestatic 401	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc_w 715
    //   41: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   50: ldc 30
    //   52: aconst_null
    //   53: ldc_w 540
    //   56: iconst_1
    //   57: anewarray 22	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokeinterface 558 9 0
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +144 -> 219
    //   78: aload_2
    //   79: astore_3
    //   80: aload_2
    //   81: invokeinterface 284 1 0
    //   86: ifeq +133 -> 219
    //   89: aload_2
    //   90: astore_3
    //   91: invokestatic 80	com/tencent/mm/plugin/emoji/h:cTw	()Lcom/tencent/mm/plugin/emoji/h;
    //   94: pop
    //   95: aload_2
    //   96: astore_3
    //   97: new 24	com/tencent/mm/storage/emotion/EmojiInfo
    //   100: dup
    //   101: invokestatic 84	com/tencent/mm/plugin/emoji/h:cTx	()Ljava/lang/String;
    //   104: invokespecial 87	com/tencent/mm/storage/emotion/EmojiInfo:<init>	(Ljava/lang/String;)V
    //   107: astore_1
    //   108: aload_2
    //   109: astore_3
    //   110: aload_1
    //   111: aload_2
    //   112: invokevirtual 562	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   115: aload_1
    //   116: astore_3
    //   117: aload_2
    //   118: ifnull +11 -> 129
    //   121: aload_2
    //   122: invokeinterface 290 1 0
    //   127: aload_1
    //   128: astore_3
    //   129: ldc_w 715
    //   132: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: areturn
    //   137: astore 4
    //   139: aconst_null
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: ldc 62
    //   147: ldc_w 719
    //   150: iconst_1
    //   151: anewarray 294	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 4
    //   158: invokevirtual 508	java/lang/Exception:toString	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload_1
    //   166: astore_3
    //   167: aload_2
    //   168: ifnull -39 -> 129
    //   171: aload_2
    //   172: invokeinterface 290 1 0
    //   177: aload_1
    //   178: astore_3
    //   179: goto -50 -> 129
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 290 1 0
    //   195: ldc_w 715
    //   198: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	224	0	this	f
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
  
  public final boolean bxL(String paramString)
  {
    AppMethodBeat.i(293023);
    boolean bool = du(paramString, true);
    AppMethodBeat.o(293023);
    return bool;
  }
  
  /* Error */
  public final EmojiInfo bxM(String paramString)
  {
    // Byte code:
    //   0: ldc_w 727
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   10: ldc_w 729
    //   13: iconst_2
    //   14: anewarray 22	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc_w 273
    //   26: aastore
    //   27: iconst_2
    //   28: invokeinterface 279 4 0
    //   33: astore_2
    //   34: aload_2
    //   35: astore_3
    //   36: aload_2
    //   37: invokeinterface 284 1 0
    //   42: ifeq +139 -> 181
    //   45: aload_2
    //   46: astore_3
    //   47: invokestatic 80	com/tencent/mm/plugin/emoji/h:cTw	()Lcom/tencent/mm/plugin/emoji/h;
    //   50: pop
    //   51: aload_2
    //   52: astore_3
    //   53: new 24	com/tencent/mm/storage/emotion/EmojiInfo
    //   56: dup
    //   57: invokestatic 84	com/tencent/mm/plugin/emoji/h:cTx	()Ljava/lang/String;
    //   60: invokespecial 87	com/tencent/mm/storage/emotion/EmojiInfo:<init>	(Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_2
    //   65: astore_3
    //   66: aload_1
    //   67: aload_2
    //   68: invokevirtual 562	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   71: aload_1
    //   72: astore_3
    //   73: aload_2
    //   74: ifnull +11 -> 85
    //   77: aload_2
    //   78: invokeinterface 290 1 0
    //   83: aload_1
    //   84: astore_3
    //   85: ldc_w 727
    //   88: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_3
    //   92: areturn
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_2
    //   100: astore_3
    //   101: ldc 62
    //   103: new 248	java/lang/StringBuilder
    //   106: dup
    //   107: ldc_w 731
    //   110: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload 4
    //   115: invokevirtual 254	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: astore_3
    //   129: aload_2
    //   130: ifnull -45 -> 85
    //   133: aload_2
    //   134: invokeinterface 290 1 0
    //   139: aload_1
    //   140: astore_3
    //   141: goto -56 -> 85
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_3
    //   147: aload_3
    //   148: ifnull +9 -> 157
    //   151: aload_3
    //   152: invokeinterface 290 1 0
    //   157: ldc_w 727
    //   160: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: goto -19 -> 147
    //   169: astore 4
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -74 -> 99
    //   176: astore 4
    //   178: goto -79 -> 99
    //   181: aconst_null
    //   182: astore_1
    //   183: goto -112 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	f
    //   0	186	1	paramString	String
    //   33	101	2	localCursor	Cursor
    //   35	117	3	localObject	Object
    //   93	21	4	localException1	Exception
    //   169	1	4	localException2	Exception
    //   176	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   6	34	93	java/lang/Exception
    //   6	34	144	finally
    //   36	45	165	finally
    //   47	51	165	finally
    //   53	64	165	finally
    //   66	71	165	finally
    //   101	127	165	finally
    //   36	45	169	java/lang/Exception
    //   47	51	169	java/lang/Exception
    //   53	64	169	java/lang/Exception
    //   66	71	176	java/lang/Exception
  }
  
  public final boolean bxN(String paramString)
  {
    bool3 = false;
    bool2 = false;
    AppMethodBeat.i(105092);
    localObject2 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.db.rawQuery("select * from EmojiInfo where md5=?", new String[] { paramString }, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", new Object[] { paramString, localException.getMessage() });
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
      AppMethodBeat.o(105092);
    }
    AppMethodBeat.o(105092);
    return bool2;
  }
  
  public final boolean bxO(String paramString)
  {
    AppMethodBeat.i(105093);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "groupId = '" + paramString + "'";
      try
      {
        if (this.db.delete("EmojiInfo", paramString, null) >= 0)
        {
          AppMethodBeat.o(105093);
          return true;
        }
        AppMethodBeat.o(105093);
        return false;
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + paramString.getMessage());
      }
    }
    AppMethodBeat.o(105093);
    return false;
  }
  
  public final boolean ci(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(105097);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
      AppMethodBeat.o(105097);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.IzE.p(164L, 12L, 1L);
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE");
    localStringBuilder.append(" EmojiInfo ");
    localStringBuilder.append(" SET ");
    localStringBuilder.append("needupload");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.ZuL);
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
    Log.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    boolean bool = this.db.execSQL("EmojiInfo", localStringBuilder.toString());
    AppMethodBeat.o(105097);
    return bool;
  }
  
  public final EmojiInfo d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(105060);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, null, null, paramString3);
    AppMethodBeat.o(105060);
    return paramString1;
  }
  
  public final boolean du(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105080);
    if ((paramString == null) || (paramString.length() != 32))
    {
      Log.f("MicroMsg.emoji.EmojiInfoStorage", "delete by md5 assertion");
      AppMethodBeat.o(105080);
      return false;
    }
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "deleteByMd5: %s", new Object[] { paramString });
    int i = this.db.delete("EmojiInfo", "md5=?", new String[] { String.valueOf(paramString) });
    if ((paramBoolean) && (i > 0)) {
      doNotify("event_update_emoji");
    }
    if (i > 0)
    {
      AppMethodBeat.o(105080);
      return true;
    }
    AppMethodBeat.o(105080);
    return false;
  }
  
  public final EmojiInfo e(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(105062);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, null, null, paramString3);
    AppMethodBeat.o(105062);
    return paramString1;
  }
  
  /* Error */
  public final String getKey()
  {
    // Byte code:
    //   0: ldc_w 812
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   10: ldc_w 814
    //   13: iconst_1
    //   14: anewarray 22	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 816
    //   22: aastore
    //   23: iconst_2
    //   24: invokeinterface 279 4 0
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +69 -> 100
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokeinterface 284 1 0
    //   42: ifeq +58 -> 100
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: iconst_0
    //   49: invokeinterface 625 2 0
    //   54: astore_3
    //   55: aload_2
    //   56: astore_1
    //   57: ldc 62
    //   59: new 248	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 818
    //   66: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_3
    //   70: invokestatic 821	com/tencent/mm/sdk/platformtools/Util:secPrint	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_2
    //   83: ifnull +9 -> 92
    //   86: aload_2
    //   87: invokeinterface 290 1 0
    //   92: ldc_w 812
    //   95: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_3
    //   99: areturn
    //   100: aload_2
    //   101: ifnull +9 -> 110
    //   104: aload_2
    //   105: invokeinterface 290 1 0
    //   110: invokestatic 827	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
    //   113: pop
    //   114: invokestatic 832	com/tencent/mm/kernel/b:getUin	()I
    //   117: invokestatic 835	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
    //   120: astore_1
    //   121: ldc 62
    //   123: ldc_w 837
    //   126: iconst_1
    //   127: anewarray 294	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_1
    //   133: aastore
    //   134: invokestatic 401	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_1
    //   138: invokestatic 362	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +130 -> 271
    //   144: aload_1
    //   145: invokevirtual 841	java/lang/String:getBytes	()[B
    //   148: invokestatic 847	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   151: astore_1
    //   152: ldc 62
    //   154: new 248	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 849
    //   161: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload_1
    //   165: invokestatic 821	com/tencent/mm/sdk/platformtools/Util:secPrint	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: new 24	com/tencent/mm/storage/emotion/EmojiInfo
    //   180: dup
    //   181: invokespecial 424	com/tencent/mm/storage/emotion/EmojiInfo:<init>	()V
    //   184: astore_2
    //   185: aload_2
    //   186: aload_1
    //   187: putfield 95	com/tencent/mm/storage/emotion/EmojiInfo:field_md5	Ljava/lang/String;
    //   190: aload_2
    //   191: sipush 153
    //   194: putfield 91	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   197: aload_0
    //   198: aload_2
    //   199: invokevirtual 527	com/tencent/mm/storage/emotion/f:L	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Z
    //   202: ifeq +82 -> 284
    //   205: ldc_w 812
    //   208: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_1
    //   212: areturn
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_2
    //   216: aload_2
    //   217: astore_1
    //   218: ldc 62
    //   220: ldc_w 851
    //   223: iconst_1
    //   224: anewarray 294	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_3
    //   230: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload_2
    //   238: ifnull -128 -> 110
    //   241: aload_2
    //   242: invokeinterface 290 1 0
    //   247: goto -137 -> 110
    //   250: astore_2
    //   251: aconst_null
    //   252: astore_1
    //   253: aload_1
    //   254: ifnull +9 -> 263
    //   257: aload_1
    //   258: invokeinterface 290 1 0
    //   263: ldc_w 812
    //   266: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_2
    //   270: athrow
    //   271: ldc_w 853
    //   274: invokevirtual 841	java/lang/String:getBytes	()[B
    //   277: invokestatic 847	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   280: astore_1
    //   281: goto -129 -> 152
    //   284: ldc_w 812
    //   287: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aconst_null
    //   291: areturn
    //   292: astore_2
    //   293: goto -40 -> 253
    //   296: astore_3
    //   297: goto -81 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	f
    //   35	246	1	localObject1	Object
    //   29	213	2	localObject2	Object
    //   250	20	2	localObject3	Object
    //   292	1	2	localObject4	Object
    //   54	45	3	str	String
    //   213	17	3	localException1	Exception
    //   296	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	30	213	java/lang/Exception
    //   6	30	250	finally
    //   36	45	292	finally
    //   47	55	292	finally
    //   57	82	292	finally
    //   218	237	292	finally
    //   36	45	296	java/lang/Exception
    //   47	55	296	java/lang/Exception
    //   57	82	296	java/lang/Exception
  }
  
  public final String getTableName()
  {
    return "EmojiInfo";
  }
  
  public final List<String> hBF()
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(230396);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(" select md5 from EmojiInfo");
    ((StringBuilder)localObject4).append(" where catalog = ").append(EmojiInfo.YCD);
    ((StringBuilder)localObject4).append(" and state = ").append(EmojiInfo.ZuG);
    try
    {
      localObject4 = this.db.rawQuery(((StringBuilder)localObject4).toString(), null, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[] { Util.stackTraceToString(localException) });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label215;
      }
      localObject3.close();
      AppMethodBeat.o(230396);
    }
    AppMethodBeat.o(230396);
    return localArrayList;
  }
  
  public final ArrayList<String> hBG()
  {
    AppMethodBeat.i(105098);
    ArrayList localArrayList = new ArrayList();
    localObject3 = null;
    localObject1 = null;
    int i = EmojiInfo.ZuL;
    int j = EmojiGroupInfo.YCw;
    try
    {
      Cursor localCursor = this.db.rawQuery("select md5 from EmojiInfo where needupload=? and catalog=?", new String[] { String.valueOf(i), String.valueOf(j) }, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", new Object[] { Util.stackTraceToString(localException) });
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
      AppMethodBeat.o(105098);
    }
    AppMethodBeat.o(105098);
    return localArrayList;
  }
  
  public final int hBH()
  {
    k = 0;
    j = 0;
    AppMethodBeat.i(105099);
    localObject3 = null;
    localObject1 = null;
    int i = EmojiGroupInfo.YCw;
    try
    {
      Cursor localCursor = this.db.rawQuery("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[] { String.valueOf(i) }, 2);
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
        Log.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", new Object[] { Util.stackTraceToString(localException) });
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
      AppMethodBeat.o(105099);
    }
    AppMethodBeat.o(105099);
    return j;
  }
  
  /* Error */
  public final ArrayList<EmojiInfo> hBI()
  {
    // Byte code:
    //   0: ldc_w 879
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 635	com/tencent/mm/storage/emotion/EmojiGroupInfo:YCw	I
    //   9: istore_1
    //   10: getstatic 880	com/tencent/mm/storage/emotion/EmojiGroupInfo:YCx	I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   18: ldc_w 882
    //   21: iconst_2
    //   22: anewarray 22	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: iload_1
    //   28: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: iload_2
    //   35: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   38: aastore
    //   39: iconst_2
    //   40: invokeinterface 279 4 0
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +122 -> 171
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: invokeinterface 284 1 0
    //   63: ifeq +108 -> 171
    //   66: aload 5
    //   68: astore 4
    //   70: new 140	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 142	java/util/ArrayList:<init>	()V
    //   77: astore 6
    //   79: aload 5
    //   81: astore 4
    //   83: new 24	com/tencent/mm/storage/emotion/EmojiInfo
    //   86: dup
    //   87: invokespecial 424	com/tencent/mm/storage/emotion/EmojiInfo:<init>	()V
    //   90: astore 7
    //   92: aload 5
    //   94: astore 4
    //   96: aload 7
    //   98: aload 5
    //   100: invokevirtual 562	com/tencent/mm/storage/emotion/EmojiInfo:convertFrom	(Landroid/database/Cursor;)V
    //   103: aload 5
    //   105: astore 4
    //   107: aload 7
    //   109: getfield 125	com/tencent/mm/storage/emotion/EmojiInfo:field_reserved4	I
    //   112: getstatic 448	com/tencent/mm/storage/emotion/EmojiInfo:ZuM	I
    //   115: iand
    //   116: getstatic 448	com/tencent/mm/storage/emotion/EmojiInfo:ZuM	I
    //   119: if_icmpeq +15 -> 134
    //   122: aload 5
    //   124: astore 4
    //   126: aload 6
    //   128: aload 7
    //   130: invokevirtual 868	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload 5
    //   136: astore 4
    //   138: aload 5
    //   140: invokeinterface 628 1 0
    //   145: istore_3
    //   146: iload_3
    //   147: ifne -68 -> 79
    //   150: aload 5
    //   152: ifnull +10 -> 162
    //   155: aload 5
    //   157: invokeinterface 290 1 0
    //   162: ldc_w 879
    //   165: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload 6
    //   170: areturn
    //   171: aload 5
    //   173: ifnull +10 -> 183
    //   176: aload 5
    //   178: invokeinterface 290 1 0
    //   183: ldc_w 879
    //   186: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aconst_null
    //   190: areturn
    //   191: astore 6
    //   193: aconst_null
    //   194: astore 5
    //   196: aload 5
    //   198: astore 4
    //   200: ldc 62
    //   202: ldc_w 884
    //   205: iconst_1
    //   206: anewarray 294	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 6
    //   213: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   216: aastore
    //   217: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload 5
    //   222: ifnull -39 -> 183
    //   225: aload 5
    //   227: invokeinterface 290 1 0
    //   232: goto -49 -> 183
    //   235: astore 5
    //   237: aconst_null
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +10 -> 252
    //   245: aload 4
    //   247: invokeinterface 290 1 0
    //   252: ldc_w 879
    //   255: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload 5
    //   260: athrow
    //   261: astore 5
    //   263: goto -23 -> 240
    //   266: astore 6
    //   268: goto -72 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	f
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
  
  /* Error */
  public final boolean init(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 888
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 62
    //   8: ldc_w 890
    //   11: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: ldc_w 892
    //   18: invokevirtual 74	com/tencent/mm/storage/emotion/f:bxK	(Ljava/lang/String;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   21: astore 7
    //   23: aload_0
    //   24: ldc_w 894
    //   27: invokevirtual 74	com/tencent/mm/storage/emotion/f:bxK	(Ljava/lang/String;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   30: astore 8
    //   32: aload_0
    //   33: getstatic 897	com/tencent/mm/storage/emotion/EmojiInfo:YCA	I
    //   36: invokespecial 899	com/tencent/mm/storage/emotion/f:asP	(I)I
    //   39: istore_2
    //   40: ldc 62
    //   42: ldc_w 901
    //   45: iconst_1
    //   46: anewarray 294	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_2
    //   52: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: invokestatic 401	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload 7
    //   61: ifnonnull +24 -> 85
    //   64: aload 8
    //   66: ifnull +14 -> 80
    //   69: aload 8
    //   71: invokevirtual 904	com/tencent/mm/storage/emotion/EmojiInfo:getContent	()Ljava/lang/String;
    //   74: invokevirtual 60	java/lang/String:length	()I
    //   77: ifeq +8 -> 85
    //   80: iload_2
    //   81: iconst_2
    //   82: if_icmpgt +35 -> 117
    //   85: ldc 62
    //   87: ldc_w 906
    //   90: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: getstatic 593	com/tencent/mm/storage/emotion/EmojiInfo:YCz	I
    //   97: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   100: pop
    //   101: aload_0
    //   102: getstatic 596	com/tencent/mm/storage/emotion/EmojiInfo:YCC	I
    //   105: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   108: pop
    //   109: aload_0
    //   110: getstatic 599	com/tencent/mm/storage/emotion/EmojiInfo:YCB	I
    //   113: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   116: pop
    //   117: aload_0
    //   118: ldc_w 910
    //   121: invokevirtual 74	com/tencent/mm/storage/emotion/f:bxK	(Ljava/lang/String;)Lcom/tencent/mm/storage/emotion/EmojiInfo;
    //   124: astore 7
    //   126: aload 7
    //   128: ifnull +46 -> 174
    //   131: aload 7
    //   133: getfield 91	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   136: getstatic 593	com/tencent/mm/storage/emotion/EmojiInfo:YCz	I
    //   139: if_icmpne +35 -> 174
    //   142: ldc 62
    //   144: ldc_w 912
    //   147: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_0
    //   151: getstatic 593	com/tencent/mm/storage/emotion/EmojiInfo:YCz	I
    //   154: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   157: pop
    //   158: aload_0
    //   159: getstatic 596	com/tencent/mm/storage/emotion/EmojiInfo:YCC	I
    //   162: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   165: pop
    //   166: aload_0
    //   167: getstatic 599	com/tencent/mm/storage/emotion/EmojiInfo:YCB	I
    //   170: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   173: pop
    //   174: aload_1
    //   175: ldc_w 914
    //   178: invokestatic 606	com/tencent/mm/storage/emotion/EmojiInfo:cH	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   181: astore 7
    //   183: aload 7
    //   185: ifnull +35 -> 220
    //   188: ldc 62
    //   190: ldc_w 916
    //   193: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_0
    //   197: getstatic 593	com/tencent/mm/storage/emotion/EmojiInfo:YCz	I
    //   200: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   203: pop
    //   204: aload_0
    //   205: getstatic 596	com/tencent/mm/storage/emotion/EmojiInfo:YCC	I
    //   208: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   211: pop
    //   212: aload_0
    //   213: getstatic 599	com/tencent/mm/storage/emotion/EmojiInfo:YCB	I
    //   216: invokevirtual 908	com/tencent/mm/storage/emotion/f:asT	(I)Z
    //   219: pop
    //   220: aload 7
    //   222: ifnull +8 -> 230
    //   225: aload 7
    //   227: invokevirtual 612	java/io/InputStream:close	()V
    //   230: aload_0
    //   231: getstatic 593	com/tencent/mm/storage/emotion/EmojiInfo:YCz	I
    //   234: invokespecial 899	com/tencent/mm/storage/emotion/f:asP	(I)I
    //   237: ifeq +11 -> 248
    //   240: ldc_w 888
    //   243: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   262: ldc 62
    //   264: ldc_w 918
    //   267: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 9
    //   272: astore 8
    //   274: aload 10
    //   276: astore 7
    //   278: invokestatic 318	java/lang/System:currentTimeMillis	()J
    //   281: lstore_3
    //   282: aload 9
    //   284: astore 8
    //   286: aload 10
    //   288: astore 7
    //   290: aload_1
    //   291: invokevirtual 924	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   294: ldc_w 926
    //   297: invokevirtual 932	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   300: astore_1
    //   301: aload_1
    //   302: astore 8
    //   304: aload_1
    //   305: astore 7
    //   307: iconst_1
    //   308: anewarray 608	java/io/InputStream
    //   311: dup
    //   312: iconst_0
    //   313: aload_1
    //   314: aastore
    //   315: invokestatic 934	com/tencent/mm/storage/emotion/f:a	([Ljava/io/InputStream;)Ljava/util/List;
    //   318: astore 10
    //   320: aload_1
    //   321: astore 8
    //   323: aload_1
    //   324: astore 7
    //   326: ldc 62
    //   328: ldc_w 936
    //   331: iconst_1
    //   332: anewarray 294	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: invokestatic 318	java/lang/System:currentTimeMillis	()J
    //   340: lload_3
    //   341: lsub
    //   342: invokestatic 399	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   345: aastore
    //   346: invokestatic 401	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_1
    //   350: astore 8
    //   352: aload_1
    //   353: astore 7
    //   355: invokestatic 318	java/lang/System:currentTimeMillis	()J
    //   358: lstore 5
    //   360: aload_1
    //   361: astore 8
    //   363: aload_1
    //   364: astore 7
    //   366: aload 10
    //   368: invokeinterface 321 1 0
    //   373: ifle +168 -> 541
    //   376: aload_1
    //   377: astore 8
    //   379: aload_1
    //   380: astore 7
    //   382: aload 10
    //   384: invokeinterface 321 1 0
    //   389: ifle +152 -> 541
    //   392: ldc2_w 415
    //   395: lstore_3
    //   396: aload_1
    //   397: astore 8
    //   399: aload_1
    //   400: astore 7
    //   402: aload_0
    //   403: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   406: instanceof 329
    //   409: ifeq +351 -> 760
    //   412: aload_1
    //   413: astore 8
    //   415: aload_1
    //   416: astore 7
    //   418: aload_0
    //   419: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   422: checkcast 329	com/tencent/mm/storagebase/h
    //   425: astore 9
    //   427: aload_1
    //   428: astore 8
    //   430: aload_1
    //   431: astore 7
    //   433: aload 9
    //   435: invokestatic 335	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   438: invokevirtual 338	java/lang/Thread:getId	()J
    //   441: invokevirtual 342	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   444: lstore_3
    //   445: aload_1
    //   446: astore 8
    //   448: aload_1
    //   449: astore 7
    //   451: aload 10
    //   453: invokeinterface 346 1 0
    //   458: astore 10
    //   460: aload_1
    //   461: astore 8
    //   463: aload_1
    //   464: astore 7
    //   466: aload 10
    //   468: invokeinterface 351 1 0
    //   473: ifeq +128 -> 601
    //   476: aload_1
    //   477: astore 8
    //   479: aload_1
    //   480: astore 7
    //   482: aload 10
    //   484: invokeinterface 355 1 0
    //   489: checkcast 24	com/tencent/mm/storage/emotion/EmojiInfo
    //   492: invokevirtual 384	com/tencent/mm/storage/emotion/EmojiInfo:convertTo	()Landroid/content/ContentValues;
    //   495: astore 11
    //   497: aload_1
    //   498: astore 8
    //   500: aload_1
    //   501: astore 7
    //   503: aload_0
    //   504: getfield 53	com/tencent/mm/storage/emotion/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   507: ldc 30
    //   509: ldc 200
    //   511: aload 11
    //   513: invokeinterface 388 4 0
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
    //   537: invokevirtual 392	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   540: pop
    //   541: aload_1
    //   542: astore 8
    //   544: aload_1
    //   545: astore 7
    //   547: ldc 62
    //   549: ldc_w 938
    //   552: iconst_1
    //   553: anewarray 294	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: invokestatic 318	java/lang/System:currentTimeMillis	()J
    //   561: lload 5
    //   563: lsub
    //   564: invokestatic 399	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   567: aastore
    //   568: invokestatic 401	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_1
    //   572: astore 8
    //   574: aload_1
    //   575: astore 7
    //   577: ldc 62
    //   579: ldc_w 940
    //   582: invokestatic 794	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: aload_1
    //   586: ifnull +7 -> 593
    //   589: aload_1
    //   590: invokevirtual 612	java/io/InputStream:close	()V
    //   593: ldc_w 888
    //   596: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   615: invokevirtual 392	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   618: pop
    //   619: goto -78 -> 541
    //   622: astore_1
    //   623: aload 8
    //   625: astore 7
    //   627: ldc 62
    //   629: new 248	java/lang/StringBuilder
    //   632: dup
    //   633: ldc_w 942
    //   636: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   639: aload_1
    //   640: invokevirtual 943	java/io/IOException:getMessage	()Ljava/lang/String;
    //   643: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 264	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: aload 8
    //   654: ifnull -61 -> 593
    //   657: aload 8
    //   659: invokevirtual 612	java/io/InputStream:close	()V
    //   662: goto -69 -> 593
    //   665: astore_1
    //   666: ldc 62
    //   668: ldc_w 292
    //   671: iconst_1
    //   672: anewarray 294	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: aload_1
    //   678: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   681: aastore
    //   682: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   685: goto -92 -> 593
    //   688: astore_1
    //   689: ldc 62
    //   691: ldc_w 292
    //   694: iconst_1
    //   695: anewarray 294	java/lang/Object
    //   698: dup
    //   699: iconst_0
    //   700: aload_1
    //   701: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   704: aastore
    //   705: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   708: goto -115 -> 593
    //   711: astore_1
    //   712: aload 7
    //   714: ifnull +8 -> 722
    //   717: aload 7
    //   719: invokevirtual 612	java/io/InputStream:close	()V
    //   722: ldc_w 888
    //   725: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   728: aload_1
    //   729: athrow
    //   730: astore 7
    //   732: ldc 62
    //   734: ldc_w 292
    //   737: iconst_1
    //   738: anewarray 294	java/lang/Object
    //   741: dup
    //   742: iconst_0
    //   743: aload 7
    //   745: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   748: aastore
    //   749: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   752: goto -30 -> 722
    //   755: astore 7
    //   757: goto -527 -> 230
    //   760: aconst_null
    //   761: astore 9
    //   763: goto -318 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	this	f
    //   0	766	1	paramContext	Context
    //   39	44	2	i	int
    //   281	334	3	l1	long
    //   358	204	5	l2	long
    //   21	697	7	localObject1	Object
    //   730	14	7	localException1	Exception
    //   755	1	7	localException2	Exception
    //   30	628	8	localObject2	Object
    //   252	510	9	localh	com.tencent.mm.storagebase.h
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
    //   589	593	688	java/lang/Exception
    //   262	270	711	finally
    //   278	282	711	finally
    //   290	301	711	finally
    //   307	320	711	finally
    //   326	349	711	finally
    //   355	360	711	finally
    //   366	376	711	finally
    //   382	392	711	finally
    //   402	412	711	finally
    //   418	427	711	finally
    //   433	445	711	finally
    //   451	460	711	finally
    //   466	476	711	finally
    //   482	497	711	finally
    //   503	523	711	finally
    //   534	541	711	finally
    //   547	571	711	finally
    //   577	585	711	finally
    //   612	619	711	finally
    //   627	652	711	finally
    //   717	722	730	java/lang/Exception
    //   225	230	755	java/lang/Exception
  }
  
  public final boolean jR(List<String> paramList)
  {
    AppMethodBeat.i(105088);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(105088);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE");
    localStringBuilder.append(" EmojiInfo ");
    localStringBuilder.append(" SET ");
    localStringBuilder.append("catalog");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.YCx);
    localStringBuilder.append(",");
    localStringBuilder.append("source");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.ZuI);
    localStringBuilder.append(",");
    localStringBuilder.append("needupload");
    localStringBuilder.append("=");
    localStringBuilder.append(EmojiInfo.ZuK);
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
    Log.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    if (this.db.execSQL("EmojiInfo", localStringBuilder.toString())) {
      doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(105088);
    return true;
  }
  
  public final boolean jS(List<String> paramList)
  {
    AppMethodBeat.i(105089);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(105089);
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
    Log.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    if (this.db.execSQL("EmojiInfo", localStringBuilder.toString())) {
      doNotify("delete_emoji_info_notify");
    }
    AppMethodBeat.o(105089);
    return true;
  }
  
  public final boolean jT(List<aji> paramList)
  {
    AppMethodBeat.i(105102);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
      AppMethodBeat.o(105102);
      return false;
    }
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = 0;
    while (i < paramList.size())
    {
      aji localaji = (aji)paramList.get(i);
      EmojiInfo localEmojiInfo2 = bxK(localaji.Md5);
      EmojiInfo localEmojiInfo1 = localEmojiInfo2;
      if (localEmojiInfo2 == null)
      {
        localEmojiInfo1 = new EmojiInfo();
        localEmojiInfo1.field_md5 = localaji.Md5;
        localEmojiInfo1.field_catalog = EmojiInfo.YCx;
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
      }
      b.a(localaji, localEmojiInfo1);
      N(localEmojiInfo1);
      i += 1;
    }
    AppMethodBeat.o(105102);
    return true;
  }
  
  public final boolean t(List<EmojiInfo> paramList, String paramString)
  {
    AppMethodBeat.i(105091);
    if (paramList.size() <= 0)
    {
      Log.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
      AppMethodBeat.o(105091);
      return false;
    }
    Log.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    com.tencent.mm.storagebase.h localh = null;
    if ((this.db instanceof com.tencent.mm.storagebase.h)) {
      localh = (com.tencent.mm.storagebase.h)this.db;
    }
    for (long l = localh.beginTransaction(Thread.currentThread().getId());; l = -1L)
    {
      Object localObject = aug(paramString);
      paramString = new HashMap();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        paramString.put(localEmojiInfo.getMd5(), localEmojiInfo);
      }
      int i = 0;
      while (i < paramList.size())
      {
        localObject = (EmojiInfo)paramList.get(i);
        ((EmojiInfo)localObject).field_temp = 0;
        this.db.replace("EmojiInfo", "md5", ((EmojiInfo)localObject).convertTo());
        paramString.remove(((EmojiInfo)localObject).getMd5());
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
        Log.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", new Object[] { ((EmojiInfo)localObject).field_groupId });
      }
      if (localh != null) {
        localh.endTransaction(l);
      }
      AppMethodBeat.o(105091);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.f
 * JD-Core Version:    0.7.0.1
 */