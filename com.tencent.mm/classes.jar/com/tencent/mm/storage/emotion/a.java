package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class a
  extends j<EmojiGroupInfo>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(62757);
    SQL_CREATE = new String[] { j.getCreateSQLs(EmojiGroupInfo.info, "EmojiGroupInfo") };
    AppMethodBeat.o(62757);
  }
  
  public a(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, EmojiGroupInfo.info, "EmojiGroupInfo", null);
    this.db = parame;
  }
  
  private int KF(String paramString)
  {
    AppMethodBeat.i(62755);
    long l = System.currentTimeMillis();
    Object localObject = null;
    String str = null;
    for (;;)
    {
      try
      {
        paramString = this.db.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { paramString, "0" }, 2);
        if (paramString == null) {
          break label212;
        }
        str = paramString;
        localObject = paramString;
        if (!paramString.moveToFirst()) {
          break label212;
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bo.l(paramString) });
        localObject = str;
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + paramString.getMessage());
        if (str == null) {
          break label207;
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
        AppMethodBeat.o(62755);
      }
      ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(62755);
      return j;
      label207:
      int j = 0;
      continue;
      label212:
      int i = 0;
    }
  }
  
  private static final String NA(int paramInt)
  {
    AppMethodBeat.i(62748);
    String str = " ( " + Nz(paramInt) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
    AppMethodBeat.o(62748);
    return str;
  }
  
  private static final String Nz(int paramInt)
  {
    AppMethodBeat.i(62747);
    String str = " ( type = '" + paramInt + "' ) ";
    AppMethodBeat.o(62747);
    return str;
  }
  
  private static boolean d(EmojiGroupInfo paramEmojiGroupInfo)
  {
    if (paramEmojiGroupInfo == null) {
      return false;
    }
    paramEmojiGroupInfo.field_flag &= 0xFFFFFEFF;
    return true;
  }
  
  private int dyS()
  {
    k = 0;
    j = 0;
    AppMethodBeat.i(62729);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.db.a("select  count(*) from EmojiInfo where catalog=?", new String[] { EmojiGroupInfo.yPf }, 2);
      int i = j;
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + localException.getMessage());
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
        break label183;
      }
      localObject3.close();
      AppMethodBeat.o(62729);
    }
    AppMethodBeat.o(62729);
    return j;
  }
  
  public static boolean dyZ()
  {
    AppMethodBeat.i(62737);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(208912, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(62737);
    return bool;
  }
  
  private static String dzc()
  {
    AppMethodBeat.i(62745);
    String str = Nz(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Nz(EmojiGroupInfo.TYPE_CUSTOM) + " or " + Nz(EmojiGroupInfo.yPa) + " or " + Nz(EmojiGroupInfo.yPc);
    AppMethodBeat.o(62745);
    return str;
  }
  
  private static final String dzd()
  {
    AppMethodBeat.i(62746);
    String str = " ( " + Nz(EmojiGroupInfo.yPa) + " and  ( status = '7' ) " + " ) ";
    AppMethodBeat.o(62746);
    return str;
  }
  
  private ArrayList<EmojiGroupInfo> hB(Context paramContext)
  {
    AppMethodBeat.i(62727);
    EmojiGroupInfo localEmojiGroupInfo = null;
    Element localElement = null;
    NodeList localNodeList = null;
    localArrayList = new ArrayList();
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    localObject2 = localNodeList;
    localObject3 = localEmojiGroupInfo;
    localObject1 = localElement;
    try
    {
      ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
      localObject2 = localNodeList;
      localObject3 = localEmojiGroupInfo;
      localObject1 = localElement;
      paramContext = paramContext.getAssets().open("custom_emoji/manifest.xml");
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      localNodeList = localDocumentBuilderFactory.newDocumentBuilder().parse(paramContext).getDocumentElement().getElementsByTagName("catalog");
      i = 0;
    }
    catch (IOException paramContext)
    {
      int k;
      localObject1 = localObject2;
      ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bo.l(paramContext) });
      localObject1 = localObject2;
      ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + paramContext.getMessage());
      if (localObject2 == null) {
        break label669;
      }
      try
      {
        ((InputStream)localObject2).close();
        for (;;)
        {
          AppMethodBeat.o(62727);
          return localArrayList;
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          if (localArrayList.size() > 0)
          {
            localObject2 = paramContext;
            localObject3 = paramContext;
            localObject1 = paramContext;
            eQ(localArrayList);
          }
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
          if (paramContext != null) {
            try
            {
              paramContext.close();
            }
            catch (Exception paramContext)
            {
              ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        localObject1 = localObject3;
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bo.l(paramContext) });
        localObject1 = localObject3;
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + paramContext.getMessage());
        if (localObject3 != null) {
          try
          {
            ((InputStream)localObject3).close();
          }
          catch (Exception paramContext)
          {
            ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        if (localObject1 != null) {}
        try
        {
          ((InputStream)localObject1).close();
          AppMethodBeat.o(62727);
          throw paramContext;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", localException, "", new Object[0]);
          }
        }
        i += 1;
        continue;
        int j = 0;
      }
    }
    localObject2 = paramContext;
    localObject3 = paramContext;
    localObject1 = paramContext;
    if (i < localNodeList.getLength())
    {
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      localEmojiGroupInfo = new EmojiGroupInfo();
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      localElement = (Element)localNodeList.item(i);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      k = Integer.decode(localElement.getAttribute("id")).intValue();
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      if (!TextUtils.isEmpty(localElement.getAttribute("sort")))
      {
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", new Object[] { Integer.valueOf(k), Integer.decode(localElement.getAttribute("sort")) });
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        j = EmojiGroupInfo.yPe;
        if ((k & j) != j) {
          break label898;
        }
        j = 1;
        if (j == 0) {
          break label587;
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (dyS() <= 0)
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          if (!dyZ()) {
            break label587;
          }
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localEmojiGroupInfo.field_sort = -1;
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        com.tencent.mm.kernel.g.RL().Ru().set(208912, Boolean.TRUE);
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
      }
      for (;;)
      {
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localEmojiGroupInfo.field_productID = String.valueOf(k);
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localEmojiGroupInfo.field_packName = localElement.getAttribute("name");
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (!TextUtils.isEmpty(localElement.getAttribute("type")))
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          localEmojiGroupInfo.field_type = Integer.decode(localElement.getAttribute("type")).intValue();
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (!TextUtils.isEmpty(localElement.getAttribute("free")))
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          localEmojiGroupInfo.field_packType = Integer.decode(localElement.getAttribute("free")).intValue();
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (localEmojiGroupInfo.field_type != EmojiGroupInfo.TYPE_SYSTEM)
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          if (localEmojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
            break;
          }
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localArrayList.add(localEmojiGroupInfo);
        break;
        label587:
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localEmojiGroupInfo.field_sort = (i + 1);
      }
    }
  }
  
  public final int a(com.tencent.mm.cg.g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final void ak(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(62741);
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
      ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          asK((String)paramArrayList.next());
        }
      }
      if (localh != null)
      {
        localh.nY(l);
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
      }
      AppMethodBeat.o(62741);
      return;
      l = -1L;
    }
  }
  
  public final boolean al(ArrayList<EmojiGroupInfo> paramArrayList)
  {
    AppMethodBeat.i(62743);
    ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
    boolean bool = eQ(paramArrayList);
    AppMethodBeat.o(62743);
    return bool;
  }
  
  public final boolean asJ(String paramString)
  {
    localObject = null;
    Cursor localCursor = null;
    boolean bool = false;
    AppMethodBeat.i(62736);
    if (TextUtils.isEmpty(paramString)) {
      ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
    }
    String str = "select count(*) from EmojiGroupInfo where productID = '" + paramString + "' AND  ( status = '7' ) " + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ";
    paramString = localCursor;
    try
    {
      localCursor = this.db.a(str, null, 2);
      if (localCursor != null)
      {
        paramString = localCursor;
        localObject = localCursor;
        if (localCursor.moveToFirst())
        {
          paramString = localCursor;
          localObject = localCursor;
          int i = localCursor.getInt(0);
          if (i > 0) {
            bool = true;
          }
          if (localCursor != null) {
            localCursor.close();
          }
          AppMethodBeat.o(62736);
          return bool;
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
        localObject = paramString;
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + localException.getMessage());
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label218;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(62736);
    }
    AppMethodBeat.o(62736);
    return false;
  }
  
  public final boolean asK(String paramString)
  {
    AppMethodBeat.i(62740);
    String str;
    if (!bo.isNullOrNil(paramString)) {
      str = paramString;
    }
    for (;;)
    {
      try
      {
        if (paramString.equals("com.tencent.xin.emoticon.tusiji")) {
          str = EmojiGroupInfo.yPd;
        }
        paramString = cg(str, true);
        if (paramString == null)
        {
          bool = false;
          if (bool)
          {
            doNotify("event_update_group", 0, bo.dtY().toString());
            doNotify("delete_group");
          }
          AppMethodBeat.o(62740);
          return bool;
        }
        if (paramString != null)
        {
          if (paramString.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
            ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
          }
        }
        else
        {
          paramString.field_lastUseTime = System.currentTimeMillis();
          paramString.field_recommand = 0;
          paramString.field_sync = 0;
          bool = replace(paramString);
          continue;
        }
        paramString.field_flag |= 0x100;
        paramString.field_status = -1;
        paramString.field_sort = 1;
        paramString.field_recommand = 0;
        paramString.field_sync = 0;
        continue;
        boolean bool = false;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + paramString.getMessage());
      }
    }
  }
  
  public final boolean c(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(62738);
    if (paramEmojiGroupInfo == null)
    {
      ab.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
      AppMethodBeat.o(62738);
      return false;
    }
    paramEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
    paramEmojiGroupInfo.field_sort = 1;
    ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", new Object[] { paramEmojiGroupInfo.field_packName, Long.valueOf(paramEmojiGroupInfo.field_lastUseTime) });
    paramEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
    d(paramEmojiGroupInfo);
    boolean bool = replace(paramEmojiGroupInfo);
    if (bool) {
      doNotify("event_update_group", 0, bo.dtY().toString());
    }
    AppMethodBeat.o(62738);
    return bool;
  }
  
  /* Error */
  public final EmojiGroupInfo cg(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 514
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 47	com/tencent/mm/storage/emotion/a:db	Lcom/tencent/mm/sdk/e/e;
    //   10: ldc_w 516
    //   13: iconst_1
    //   14: anewarray 22	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: iconst_2
    //   22: invokeinterface 68 4 0
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +55 -> 84
    //   32: aload_3
    //   33: astore 4
    //   35: aload_3
    //   36: invokeinterface 74 1 0
    //   41: ifeq +43 -> 84
    //   44: aload_3
    //   45: astore 4
    //   47: new 24	com/tencent/mm/storage/emotion/EmojiGroupInfo
    //   50: dup
    //   51: invokespecial 280	com/tencent/mm/storage/emotion/EmojiGroupInfo:<init>	()V
    //   54: astore 5
    //   56: aload_3
    //   57: astore 4
    //   59: aload 5
    //   61: aload_3
    //   62: invokevirtual 520	com/tencent/mm/storage/emotion/EmojiGroupInfo:convertFrom	(Landroid/database/Cursor;)V
    //   65: aload_3
    //   66: ifnull +9 -> 75
    //   69: aload_3
    //   70: invokeinterface 81 1 0
    //   75: ldc_w 514
    //   78: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload 5
    //   83: areturn
    //   84: aload_3
    //   85: ifnull +181 -> 266
    //   88: aload_3
    //   89: invokeinterface 81 1 0
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: ifnonnull +119 -> 216
    //   100: iload_2
    //   101: ifeq +99 -> 200
    //   104: ldc_w 514
    //   107: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 5
    //   114: aconst_null
    //   115: astore 6
    //   117: aconst_null
    //   118: astore_3
    //   119: aload 6
    //   121: astore 4
    //   123: ldc 83
    //   125: new 112	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 522
    //   132: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 524
    //   142: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 5
    //   147: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 131	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload 6
    //   161: ifnull +100 -> 261
    //   164: aload 6
    //   166: invokeinterface 81 1 0
    //   171: aload_3
    //   172: astore_1
    //   173: goto -77 -> 96
    //   176: astore_1
    //   177: aconst_null
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +10 -> 192
    //   185: aload 4
    //   187: invokeinterface 81 1 0
    //   192: ldc_w 514
    //   195: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_1
    //   199: athrow
    //   200: new 24	com/tencent/mm/storage/emotion/EmojiGroupInfo
    //   203: dup
    //   204: invokespecial 280	com/tencent/mm/storage/emotion/EmojiGroupInfo:<init>	()V
    //   207: astore_1
    //   208: ldc_w 514
    //   211: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: areturn
    //   216: ldc_w 514
    //   219: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_1
    //   223: areturn
    //   224: astore_1
    //   225: goto -45 -> 180
    //   228: astore 5
    //   230: aconst_null
    //   231: astore 4
    //   233: aload_3
    //   234: astore 6
    //   236: aload 4
    //   238: astore_3
    //   239: goto -120 -> 119
    //   242: astore 6
    //   244: aload 5
    //   246: astore 4
    //   248: aload 6
    //   250: astore 5
    //   252: aload_3
    //   253: astore 6
    //   255: aload 4
    //   257: astore_3
    //   258: goto -139 -> 119
    //   261: aload_3
    //   262: astore_1
    //   263: goto -167 -> 96
    //   266: aconst_null
    //   267: astore_1
    //   268: goto -172 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	a
    //   0	271	1	paramString	String
    //   0	271	2	paramBoolean	boolean
    //   27	235	3	localObject1	Object
    //   33	223	4	localObject2	Object
    //   54	28	5	localEmojiGroupInfo	EmojiGroupInfo
    //   112	34	5	localException1	Exception
    //   228	17	5	localException2	Exception
    //   250	1	5	localObject3	Object
    //   115	120	6	localObject4	Object
    //   242	7	6	localException3	Exception
    //   253	1	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   6	28	112	java/lang/Exception
    //   6	28	176	finally
    //   35	44	224	finally
    //   47	56	224	finally
    //   59	65	224	finally
    //   123	159	224	finally
    //   35	44	228	java/lang/Exception
    //   47	56	228	java/lang/Exception
    //   59	65	242	java/lang/Exception
  }
  
  public final boolean dyT()
  {
    boolean bool = true;
    AppMethodBeat.i(62730);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.db.a("select * from EmojiGroupInfo where type=?", new String[] { EmojiGroupInfo.TYPE_SYSTEM }, 2);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
          localObject1 = localCursor;
          localObject3 = localCursor;
          localEmojiGroupInfo.convertFrom(localCursor);
          localObject1 = localCursor;
          localObject3 = localCursor;
          int i = localEmojiGroupInfo.field_flag;
          if ((i & 0x100) > 0)
          {
            i = 1;
            if (i != 0) {
              break label155;
            }
          }
          for (;;)
          {
            return bool;
            i = 0;
            break;
            label155:
            bool = false;
          }
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
        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", localException.toString());
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label221;
      }
      localObject3.close();
      AppMethodBeat.o(62730);
    }
    AppMethodBeat.o(62730);
    return false;
  }
  
  public final List<EmojiGroupInfo> dyU()
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62731);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + dzc() + " order by sort ASC,lastUseTime DESC";
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
            EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
            localObject1 = localObject4;
            localObject3 = localObject4;
            localEmojiGroupInfo.convertFrom((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localEmojiGroupInfo);
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label219;
      }
      localObject3.close();
      AppMethodBeat.o(62731);
    }
    AppMethodBeat.o(62731);
    return localArrayList;
  }
  
  public final HashMap<String, EmojiGroupInfo> dyV()
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62732);
    HashMap localHashMap = new HashMap();
    Object localObject4 = "select * from EmojiGroupInfo where " + dzc() + " order by sort ASC,lastUseTime DESC";
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
            EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
            localObject1 = localObject4;
            localObject3 = localObject4;
            localEmojiGroupInfo.convertFrom((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localHashMap.put(localEmojiGroupInfo.field_productID, localEmojiGroupInfo);
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label222;
      }
      localObject3.close();
      AppMethodBeat.o(62732);
    }
    AppMethodBeat.o(62732);
    return localHashMap;
  }
  
  public final ArrayList<EmojiGroupInfo> dyW()
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62733);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + dzd() + " order by sort ASC,lastUseTime DESC";
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
            EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
            localObject1 = localObject4;
            localObject3 = localObject4;
            localEmojiGroupInfo.convertFrom((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localEmojiGroupInfo);
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label217;
      }
      localObject3.close();
      AppMethodBeat.o(62733);
    }
    AppMethodBeat.o(62733);
    return localArrayList;
  }
  
  public final int dyX()
  {
    localObject3 = null;
    localObject1 = null;
    k = 0;
    j = 0;
    AppMethodBeat.i(62734);
    Object localObject4 = "select count(*) from EmojiGroupInfo where " + dzd() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.db.a((String)localObject4, null, 2);
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
      for (;;)
      {
        localObject3 = localObject1;
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + localException.getMessage());
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
        break label191;
      }
      localObject3.close();
      AppMethodBeat.o(62734);
    }
    AppMethodBeat.o(62734);
    return j;
  }
  
  public final HashMap<String, ar> dyY()
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62735);
    HashMap localHashMap = new HashMap();
    Object localObject4 = "select * from EmojiGroupInfo where " + dzd() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.db.a((String)localObject4, null, 2);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          ar localar = new ar();
          localObject1 = localObject4;
          localObject3 = localObject4;
          int i = ((Cursor)localObject4).getColumnIndex("productID");
          localObject1 = localObject4;
          localObject3 = localObject4;
          int j = ((Cursor)localObject4).getColumnIndex("packName");
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            String str = ((Cursor)localObject4).getString(i);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localar.cqx = str;
            localObject1 = localObject4;
            localObject3 = localObject4;
            localar.loz = ((Cursor)localObject4).getString(j);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localar.Nu(7);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localHashMap.put(str, localar);
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + localException.getMessage());
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label330;
      }
      localObject3.close();
      AppMethodBeat.o(62735);
    }
    AppMethodBeat.o(62735);
    return localHashMap;
  }
  
  public final boolean dza()
  {
    AppMethodBeat.i(62742);
    String str = EmojiGroupInfo.yPa;
    if (this.db.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", new String[] { "1", str, "7" }) > 0)
    {
      AppMethodBeat.o(62742);
      return true;
    }
    AppMethodBeat.o(62742);
    return false;
  }
  
  public final ArrayList<EmojiGroupInfo> dzb()
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(62744);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + dzd() + " or " + NA(EmojiGroupInfo.TYPE_SYSTEM) + " or " + NA(EmojiGroupInfo.TYPE_CUSTOM) + " or  ( recommand = '1' ) " + " order by sort ASC,idx ASC,lastUseTime DESC";
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
            EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
            localObject1 = localObject4;
            localObject3 = localObject4;
            localEmojiGroupInfo.convertFrom((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localEmojiGroupInfo);
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (bo.isEqual(localEmojiGroupInfo.field_productID, String.valueOf(EmojiGroupInfo.yPd)))
            {
              localObject1 = localObject4;
              localObject3 = localObject4;
              localEmojiGroupInfo.field_packName = ah.getContext().getString(2131299259);
            }
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + localException.getMessage());
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label294;
      }
      localObject3.close();
      AppMethodBeat.o(62744);
    }
    AppMethodBeat.o(62744);
    return localArrayList;
  }
  
  /* Error */
  public final boolean dze()
  {
    // Byte code:
    //   0: ldc_w 633
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 112	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 201	com/tencent/mm/storage/emotion/EmojiGroupInfo:TYPE_SYSTEM	I
    //   16: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore_3
    //   23: new 112	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   30: getstatic 209	com/tencent/mm/storage/emotion/EmojiGroupInfo:yPa	I
    //   33: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 4
    //   41: ldc 83
    //   43: ldc_w 635
    //   46: iconst_1
    //   47: anewarray 87	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: ldc_w 637
    //   55: aastore
    //   56: invokestatic 406	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 47	com/tencent/mm/storage/emotion/a:db	Lcom/tencent/mm/sdk/e/e;
    //   65: ldc_w 637
    //   68: iconst_4
    //   69: anewarray 22	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload_3
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload 4
    //   80: aastore
    //   81: dup
    //   82: iconst_2
    //   83: ldc 62
    //   85: aastore
    //   86: dup
    //   87: iconst_3
    //   88: ldc_w 605
    //   91: aastore
    //   92: iconst_2
    //   93: invokeinterface 68 4 0
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull +34 -> 134
    //   103: aload_3
    //   104: astore_2
    //   105: aload_3
    //   106: invokeinterface 74 1 0
    //   111: istore_1
    //   112: iload_1
    //   113: ifeq +21 -> 134
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokeinterface 81 1 0
    //   126: ldc_w 633
    //   129: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_1
    //   133: ireturn
    //   134: aload_3
    //   135: ifnull +9 -> 144
    //   138: aload_3
    //   139: invokeinterface 81 1 0
    //   144: ldc_w 633
    //   147: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_2
    //   155: ldc 83
    //   157: ldc_w 639
    //   160: invokestatic 131	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_2
    //   164: ifnull -20 -> 144
    //   167: aload_2
    //   168: invokeinterface 81 1 0
    //   173: goto -29 -> 144
    //   176: astore_3
    //   177: aload_2
    //   178: ifnull +9 -> 187
    //   181: aload_2
    //   182: invokeinterface 81 1 0
    //   187: ldc_w 633
    //   190: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_3
    //   194: athrow
    //   195: astore_3
    //   196: goto -19 -> 177
    //   199: astore_2
    //   200: aload_3
    //   201: astore_2
    //   202: goto -47 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	a
    //   111	2	1	bool	boolean
    //   60	45	2	localObject1	Object
    //   152	1	2	localException1	Exception
    //   154	28	2	localObject2	Object
    //   199	1	2	localException2	Exception
    //   201	1	2	localObject3	Object
    //   22	117	3	localObject4	Object
    //   176	18	3	localObject5	Object
    //   195	6	3	localObject6	Object
    //   39	40	4	str	String
    // Exception table:
    //   from	to	target	type
    //   61	99	152	java/lang/Exception
    //   61	99	176	finally
    //   105	112	176	finally
    //   155	163	195	finally
    //   105	112	199	java/lang/Exception
  }
  
  public final List<String> dzf()
  {
    AppMethodBeat.i(62750);
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = EmojiGroupInfo.yPa;
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      localObject5 = this.db.a("select productID from EmojiGroupInfo where type=? and sync=?", new String[] { localObject5, "1" }, 2);
      if (localObject5 != null)
      {
        localObject1 = localObject5;
        localObject3 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject5;
            localObject3 = localObject5;
            localArrayList.add(((Cursor)localObject5).getString(0));
            localObject1 = localObject5;
            localObject3 = localObject5;
            bool = ((Cursor)localObject5).moveToNext();
          } while (bool);
        }
      }
      if (localObject5 != null) {
        ((Cursor)localObject5).close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject4 = localObject1;
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToSyncStoreEmojiProductList. exception.%s", new Object[] { bo.dtY() });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label192;
      }
      localObject4.close();
      AppMethodBeat.o(62750);
    }
    AppMethodBeat.o(62750);
    return localArrayList;
  }
  
  public final List<String> dzg()
  {
    AppMethodBeat.i(62751);
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = EmojiGroupInfo.yPa;
    String str = EmojiGroupInfo.TYPE_SYSTEM;
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      localObject5 = this.db.a("select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)", new String[] { "0", localObject5, "7", str, "0" }, 2);
      if (localObject5 != null)
      {
        localObject1 = localObject5;
        localObject3 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject5;
            localObject3 = localObject5;
            localArrayList.add(((Cursor)localObject5).getString(0));
            localObject1 = localObject5;
            localObject3 = localObject5;
            bool = ((Cursor)localObject5).moveToNext();
          } while (bool);
        }
      }
      if (localObject5 != null) {
        ((Cursor)localObject5).close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject4 = localObject1;
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToUploadStoreEmojiProductList. exception.%s", new Object[] { bo.dtY() });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label225;
      }
      localObject4.close();
      AppMethodBeat.o(62751);
    }
    AppMethodBeat.o(62751);
    return localArrayList;
  }
  
  public final ArrayList<EmojiGroupInfo> dzh()
  {
    AppMethodBeat.i(62752);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = EmojiGroupInfo.yPa;
    Object localObject5 = EmojiGroupInfo.TYPE_SYSTEM;
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = this.db.a("select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC", new String[] { localObject4, "7", localObject5, "0" }, 2);
      localObject1 = localObject4;
      localObject3 = localObject4;
      ab.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
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
            localObject5 = new EmojiGroupInfo();
            localObject1 = localObject4;
            localObject3 = localObject4;
            ((EmojiGroupInfo)localObject5).convertFrom((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localObject5);
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
        ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + localException.getMessage());
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label265;
      }
      localObject3.close();
      AppMethodBeat.o(62752);
    }
    AppMethodBeat.o(62752);
    return localArrayList;
  }
  
  public final void dzi()
  {
    AppMethodBeat.i(62753);
    ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
    EmojiGroupInfo localEmojiGroupInfo = cg(String.valueOf(EmojiGroupInfo.yPe), false);
    if (localEmojiGroupInfo == null) {
      localEmojiGroupInfo = new EmojiGroupInfo();
    }
    for (;;)
    {
      localEmojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.yPe);
      localEmojiGroupInfo.field_packName = "emoji_custom_group";
      localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_CUSTOM;
      localEmojiGroupInfo.field_status = 0;
      localEmojiGroupInfo.field_packStatus = 1;
      localEmojiGroupInfo.field_flag = 0;
      replace(localEmojiGroupInfo);
      ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
      AppMethodBeat.o(62753);
      return;
      ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", new Object[] { localEmojiGroupInfo.toString() });
    }
  }
  
  public final boolean dzj()
  {
    AppMethodBeat.i(62754);
    h localh = null;
    if ((this.db instanceof h)) {
      localh = (h)this.db;
    }
    for (long l = localh.kr(Thread.currentThread().getId());; l = -1L)
    {
      Object localObject = dyW();
      if (!((ArrayList)localObject).isEmpty())
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject).next();
          if ((localEmojiGroupInfo != null) && (!bo.isNullOrNil(localEmojiGroupInfo.field_productID)))
          {
            i = KF(localEmojiGroupInfo.field_productID);
            if (localEmojiGroupInfo.field_count != i)
            {
              localEmojiGroupInfo.field_count = i;
              this.db.update("EmojiGroupInfo", localEmojiGroupInfo.convertTo(), "productID=?", new String[] { localEmojiGroupInfo.field_productID });
            }
          }
        }
      }
      if (localh != null) {}
      for (int i = localh.nY(l);; i = -1)
      {
        doNotify("event_update_group", 0, bo.dtY().toString());
        if (i >= 0)
        {
          AppMethodBeat.o(62754);
          return true;
        }
        AppMethodBeat.o(62754);
        return false;
      }
    }
  }
  
  public final boolean eQ(List<EmojiGroupInfo> paramList)
  {
    AppMethodBeat.i(62739);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
      AppMethodBeat.o(62739);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
      ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int i = 0;
      while (i < paramList.size())
      {
        EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)paramList.get(i);
        ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_productID, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
        replace(localEmojiGroupInfo);
        i += 1;
      }
      if (localh != null)
      {
        localh.nY(l);
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
      }
      doNotify("event_update_group", 0, bo.dtY().toString());
      AppMethodBeat.o(62739);
      return true;
      l = -1L;
    }
  }
  
  public final String getTableName()
  {
    return "EmojiGroupInfo";
  }
  
  public final boolean init(Context paramContext)
  {
    AppMethodBeat.i(62726);
    ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
    hB(paramContext);
    ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
    AppMethodBeat.o(62726);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.a
 * JD-Core Version:    0.7.0.1
 */