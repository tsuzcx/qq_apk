package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  extends i<EmojiGroupInfo>
  implements g.a
{
  public static final String[] dXp = { i.a(EmojiGroupInfo.buS, "EmojiGroupInfo") };
  public com.tencent.mm.sdk.e.e dXw;
  
  public a(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, EmojiGroupInfo.buS, "EmojiGroupInfo", null);
    this.dXw = parame;
  }
  
  private int AE(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = null;
    String str = null;
    for (;;)
    {
      try
      {
        paramString = this.dXw.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { paramString, "0" }, 2);
        if (paramString == null) {
          break label197;
        }
        str = paramString;
        localObject = paramString;
        if (!paramString.moveToFirst()) {
          break label197;
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
        y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bk.j(paramString) });
        localObject = str;
        y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + paramString.getMessage());
        if (str == null) {
          break label192;
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
      }
      y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return j;
      label192:
      int j = 0;
      continue;
      label197:
      int i = 0;
    }
  }
  
  private static final String Fs(int paramInt)
  {
    return " ( type = '" + paramInt + "' ) ";
  }
  
  private static final String Ft(int paramInt)
  {
    return " ( " + Fs(paramInt) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
  }
  
  private int cwg()
  {
    int j = 0;
    int k = 0;
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.dXw.a("select  count(*) from EmojiInfo where catalog=?", new String[] { EmojiGroupInfo.uCS }, 2);
      int i = k;
      if (localCursor != null)
      {
        i = k;
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + localException.getMessage());
      return 0;
    }
    finally
    {
      if (localObject3 == null) {
        break label168;
      }
      localObject3.close();
    }
    return j;
  }
  
  public static boolean cwo()
  {
    return ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(208912, Boolean.valueOf(false))).booleanValue();
  }
  
  private static String cwr()
  {
    return Fs(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Fs(EmojiGroupInfo.TYPE_CUSTOM) + " or " + Fs(EmojiGroupInfo.uCN) + " or " + Fs(EmojiGroupInfo.uCP);
  }
  
  private static final String cws()
  {
    return " ( " + Fs(EmojiGroupInfo.uCN) + " and  ( status = '7' ) " + " ) ";
  }
  
  private ArrayList<EmojiGroupInfo> gk(Context paramContext)
  {
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
      y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
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
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bk.j(paramContext) });
      localObject1 = localObject2;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + paramContext.getMessage());
      if (localObject2 == null) {
        break label664;
      }
      do
      {
        try
        {
          ((InputStream)localObject2).close();
          return localArrayList;
        }
        catch (Exception paramContext)
        {
          y.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
          return localArrayList;
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (localArrayList.size() > 0)
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          dH(localArrayList);
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
      } while (paramContext == null);
      try
      {
        paramContext.close();
        return localArrayList;
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
        return localArrayList;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject1 = localObject3;
        y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bk.j(paramContext) });
        localObject1 = localObject3;
        y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + paramContext.getMessage());
      } while (localObject3 == null);
      try
      {
        ((InputStream)localObject3).close();
        return localArrayList;
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
        return localArrayList;
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
          throw paramContext;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", localException, "", new Object[0]);
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
        y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", new Object[] { Integer.valueOf(k), Integer.decode(localElement.getAttribute("sort")) });
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        j = EmojiGroupInfo.uCR;
        if ((k & j) != j) {
          break label883;
        }
        j = 1;
        if (j == 0) {
          break label582;
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (cwg() <= 0)
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          if (!cwo()) {
            break label582;
          }
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localEmojiGroupInfo.field_sort = -1;
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        com.tencent.mm.kernel.g.DP().Dz().o(208912, Boolean.valueOf(true));
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
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
        label582:
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localEmojiGroupInfo.field_sort = (i + 1);
      }
    }
  }
  
  public final int a(com.tencent.mm.cf.g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final boolean acx(String paramString)
  {
    localObject = null;
    Cursor localCursor = null;
    boolean bool2 = false;
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
    }
    String str = "select count(*) from EmojiGroupInfo where productID = '" + paramString + "' AND  ( status = '7' ) " + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ";
    paramString = localCursor;
    do
    {
      try
      {
        localCursor = this.dXw.a(str, null, 2);
        if (localCursor == null) {
          continue;
        }
        paramString = localCursor;
        localObject = localCursor;
        if (!localCursor.moveToFirst()) {
          continue;
        }
        paramString = localCursor;
        localObject = localCursor;
        int i = localCursor.getInt(0);
        if (i > 0) {
          bool1 = true;
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
        do
        {
          localObject = paramString;
          y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + localException.getMessage());
        } while (paramString == null);
        paramString.close();
        return false;
      }
      finally
      {
        if (localObject == null) {
          break;
        }
        ((Cursor)localObject).close();
      }
      return bool2;
    } while (localCursor == null);
    localCursor.close();
    return false;
  }
  
  public final boolean acy(String paramString)
  {
    String str;
    if (!bk.bl(paramString)) {
      str = paramString;
    }
    for (;;)
    {
      try
      {
        if (paramString.equals("com.tencent.xin.emoticon.tusiji")) {
          str = EmojiGroupInfo.uCQ;
        }
        paramString = bE(str, true);
        if (paramString == null)
        {
          bool = false;
          if (bool)
          {
            b("event_update_group", 0, bk.csb().toString());
            aam("delete_group");
          }
          return bool;
        }
        if (paramString != null)
        {
          if (paramString.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
            y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
          }
        }
        else
        {
          paramString.field_lastUseTime = System.currentTimeMillis();
          paramString.field_recommand = 0;
          paramString.field_sync = 0;
          bool = a(paramString);
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
        y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + paramString.getMessage());
      }
    }
  }
  
  public final void ae(ArrayList<String> paramArrayList)
  {
    h localh = null;
    long l;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(Thread.currentThread().getId());
      y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          acy((String)paramArrayList.next());
        }
      }
      if (localh != null)
      {
        localh.hI(l);
        y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
      }
      return;
      l = -1L;
    }
  }
  
  /* Error */
  public final EmojiGroupInfo bE(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/mm/storage/emotion/a:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc_w 476
    //   7: iconst_1
    //   8: anewarray 15	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: aastore
    //   15: iconst_2
    //   16: invokeinterface 56 4 0
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +57 -> 80
    //   26: aload_3
    //   27: astore 4
    //   29: aload_3
    //   30: invokeinterface 62 1 0
    //   35: ifeq +45 -> 80
    //   38: aload_3
    //   39: astore 4
    //   41: new 17	com/tencent/mm/storage/emotion/EmojiGroupInfo
    //   44: dup
    //   45: invokespecial 257	com/tencent/mm/storage/emotion/EmojiGroupInfo:<init>	()V
    //   48: astore 5
    //   50: aload_3
    //   51: astore 4
    //   53: aload 5
    //   55: aload_3
    //   56: invokevirtual 479	com/tencent/mm/storage/emotion/EmojiGroupInfo:d	(Landroid/database/Cursor;)V
    //   59: aload 5
    //   61: astore 4
    //   63: aload_3
    //   64: ifnull +13 -> 77
    //   67: aload_3
    //   68: invokeinterface 69 1 0
    //   73: aload 5
    //   75: astore 4
    //   77: aload 4
    //   79: areturn
    //   80: aload_3
    //   81: ifnull +156 -> 237
    //   84: aload_3
    //   85: invokeinterface 69 1 0
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore 4
    //   95: aload_1
    //   96: ifnonnull -19 -> 77
    //   99: iload_2
    //   100: ifeq +87 -> 187
    //   103: aconst_null
    //   104: areturn
    //   105: astore 5
    //   107: aconst_null
    //   108: astore 6
    //   110: aconst_null
    //   111: astore_3
    //   112: aload 6
    //   114: astore 4
    //   116: ldc 71
    //   118: new 100	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 481
    //   125: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 483
    //   135: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 5
    //   140: invokevirtual 109	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 119	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 6
    //   154: ifnull +78 -> 232
    //   157: aload 6
    //   159: invokeinterface 69 1 0
    //   164: aload_3
    //   165: astore_1
    //   166: goto -74 -> 92
    //   169: astore_1
    //   170: aconst_null
    //   171: astore 4
    //   173: aload 4
    //   175: ifnull +10 -> 185
    //   178: aload 4
    //   180: invokeinterface 69 1 0
    //   185: aload_1
    //   186: athrow
    //   187: new 17	com/tencent/mm/storage/emotion/EmojiGroupInfo
    //   190: dup
    //   191: invokespecial 257	com/tencent/mm/storage/emotion/EmojiGroupInfo:<init>	()V
    //   194: areturn
    //   195: astore_1
    //   196: goto -23 -> 173
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 4
    //   204: aload_3
    //   205: astore 6
    //   207: aload 4
    //   209: astore_3
    //   210: goto -98 -> 112
    //   213: astore 6
    //   215: aload 5
    //   217: astore 4
    //   219: aload 6
    //   221: astore 5
    //   223: aload_3
    //   224: astore 6
    //   226: aload 4
    //   228: astore_3
    //   229: goto -117 -> 112
    //   232: aload_3
    //   233: astore_1
    //   234: goto -142 -> 92
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -147 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	a
    //   0	242	1	paramString	String
    //   0	242	2	paramBoolean	boolean
    //   21	212	3	localObject1	Object
    //   27	200	4	localObject2	Object
    //   48	26	5	localEmojiGroupInfo	EmojiGroupInfo
    //   105	34	5	localException1	Exception
    //   199	17	5	localException2	Exception
    //   221	1	5	localObject3	Object
    //   108	98	6	localObject4	Object
    //   213	7	6	localException3	Exception
    //   224	1	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	22	105	java/lang/Exception
    //   0	22	169	finally
    //   29	38	195	finally
    //   41	50	195	finally
    //   53	59	195	finally
    //   116	152	195	finally
    //   29	38	199	java/lang/Exception
    //   41	50	199	java/lang/Exception
    //   53	59	213	java/lang/Exception
  }
  
  public final boolean c(EmojiGroupInfo paramEmojiGroupInfo)
  {
    if (paramEmojiGroupInfo == null)
    {
      y.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
      return false;
    }
    paramEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
    paramEmojiGroupInfo.field_sort = 1;
    y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", new Object[] { paramEmojiGroupInfo.field_packName, Long.valueOf(paramEmojiGroupInfo.field_lastUseTime) });
    paramEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
    if (paramEmojiGroupInfo != null) {
      paramEmojiGroupInfo.field_flag &= 0xFFFFFEFF;
    }
    boolean bool = a(paramEmojiGroupInfo);
    if (bool) {
      b("event_update_group", 0, bk.csb().toString());
    }
    return bool;
  }
  
  public final boolean cwh()
  {
    boolean bool = true;
    localObject3 = null;
    localObject1 = null;
    try
    {
      localCursor = this.dXw.a("select * from EmojiGroupInfo where type=?", new String[] { EmojiGroupInfo.TYPE_SYSTEM }, 2);
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
          localEmojiGroupInfo.d(localCursor);
          localObject1 = localCursor;
          localObject3 = localCursor;
          int i = localEmojiGroupInfo.field_flag;
          if ((i & 0x100) > 0)
          {
            i = 1;
            if (i != 0) {
              break label143;
            }
          }
          for (;;)
          {
            return bool;
            i = 0;
            break;
            label143:
            bool = false;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Cursor localCursor;
        localObject3 = localObject1;
        y.d("MicroMsg.emoji.EmojiGroupInfoStorage", localException.toString());
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
    }
    return false;
  }
  
  public final List<EmojiGroupInfo> cwi()
  {
    localObject3 = null;
    localObject1 = null;
    localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + Ft(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Ft(EmojiGroupInfo.TYPE_CUSTOM) + " order by sort ASC";
    try
    {
      localObject4 = this.dXw.a((String)localObject4, null, 2);
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
            localEmojiGroupInfo.d((Cursor)localObject4);
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get system group fail." + localException.getMessage());
      return localArrayList;
    }
    finally
    {
      if (localObject3 == null) {
        break label224;
      }
      localObject3.close();
    }
    return localArrayList;
  }
  
  public final List<EmojiGroupInfo> cwj()
  {
    localObject3 = null;
    localObject1 = null;
    localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + cwr() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.dXw.a((String)localObject4, null, 2);
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
            localEmojiGroupInfo.d((Cursor)localObject4);
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
      return localArrayList;
    }
    finally
    {
      if (localObject3 == null) {
        break label207;
      }
      localObject3.close();
    }
    return localArrayList;
  }
  
  public final HashMap<String, EmojiGroupInfo> cwk()
  {
    localObject3 = null;
    localObject1 = null;
    localHashMap = new HashMap();
    Object localObject4 = "select * from EmojiGroupInfo where " + cwr() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.dXw.a((String)localObject4, null, 2);
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
            localEmojiGroupInfo.d((Cursor)localObject4);
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
      return localHashMap;
    }
    finally
    {
      if (localObject3 == null) {
        break label210;
      }
      localObject3.close();
    }
    return localHashMap;
  }
  
  public final ArrayList<EmojiGroupInfo> cwl()
  {
    localObject3 = null;
    localObject1 = null;
    localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + cws() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.dXw.a((String)localObject4, null, 2);
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
            localEmojiGroupInfo.d((Cursor)localObject4);
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
      return localArrayList;
    }
    finally
    {
      if (localObject3 == null) {
        break label205;
      }
      localObject3.close();
    }
    return localArrayList;
  }
  
  public final int cwm()
  {
    localObject3 = null;
    localObject1 = null;
    int j = 0;
    int k = 0;
    Object localObject4 = "select count(*) from EmojiGroupInfo where " + cws() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.dXw.a((String)localObject4, null, 2);
      int i = k;
      if (localObject4 != null)
      {
        i = k;
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
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + localException.getMessage());
      return 0;
    }
    finally
    {
      if (localObject3 == null) {
        break label174;
      }
      localObject3.close();
    }
    return j;
  }
  
  public final HashMap<String, ar> cwn()
  {
    localObject3 = null;
    localObject1 = null;
    localHashMap = new HashMap();
    Object localObject4 = "select * from EmojiGroupInfo where " + cws() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.dXw.a((String)localObject4, null, 2);
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
            localar.bJd = str;
            localObject1 = localObject4;
            localObject3 = localObject4;
            localar.jfG = ((Cursor)localObject4).getString(j);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localar.Fo(7);
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + localException.getMessage());
      return localHashMap;
    }
    finally
    {
      if (localObject3 == null) {
        break label318;
      }
      localObject3.close();
    }
    return localHashMap;
  }
  
  public final void cwp()
  {
    String str = EmojiGroupInfo.TYPE_CUSTOM;
    str = "UPDATE EmojiGroupInfo SET sort=-1,lastUseTime=" + System.currentTimeMillis() + " WHERE type=" + str;
    if (this.dXw.gk("EmojiGroupInfo", str)) {
      b("event_update_group", 0, bk.csb().toString());
    }
    com.tencent.mm.kernel.g.DP().Dz().o(208912, Boolean.valueOf(true));
  }
  
  public final ArrayList<EmojiGroupInfo> cwq()
  {
    localObject3 = null;
    localObject1 = null;
    localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + cws() + " or " + Ft(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Ft(EmojiGroupInfo.TYPE_CUSTOM) + " or  ( recommand = '1' ) " + " order by sort ASC,idx ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.dXw.a((String)localObject4, null, 2);
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
            localEmojiGroupInfo.d((Cursor)localObject4);
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + localException.getMessage());
      return localArrayList;
    }
    finally
    {
      if (localObject3 == null) {
        break label239;
      }
      localObject3.close();
    }
    return localArrayList;
  }
  
  /* Error */
  public final boolean cwt()
  {
    // Byte code:
    //   0: new 100	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 179	com/tencent/mm/storage/emotion/EmojiGroupInfo:TYPE_SYSTEM	I
    //   10: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16: astore_3
    //   17: new 100	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   24: getstatic 187	com/tencent/mm/storage/emotion/EmojiGroupInfo:uCN	I
    //   27: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 4
    //   35: ldc 71
    //   37: ldc_w 586
    //   40: iconst_1
    //   41: anewarray 75	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: ldc_w 588
    //   49: aastore
    //   50: invokestatic 446	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 37	com/tencent/mm/storage/emotion/a:dXw	Lcom/tencent/mm/sdk/e/e;
    //   59: ldc_w 588
    //   62: iconst_4
    //   63: anewarray 15	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: aload_3
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload 4
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: ldc 51
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: ldc_w 590
    //   85: aastore
    //   86: iconst_2
    //   87: invokeinterface 56 4 0
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +28 -> 122
    //   97: aload_3
    //   98: astore_2
    //   99: aload_3
    //   100: invokeinterface 62 1 0
    //   105: istore_1
    //   106: iload_1
    //   107: ifeq +15 -> 122
    //   110: aload_3
    //   111: ifnull +9 -> 120
    //   114: aload_3
    //   115: invokeinterface 69 1 0
    //   120: iconst_1
    //   121: ireturn
    //   122: aload_3
    //   123: ifnull +9 -> 132
    //   126: aload_3
    //   127: invokeinterface 69 1 0
    //   132: iconst_0
    //   133: ireturn
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_2
    //   137: ldc 71
    //   139: ldc_w 592
    //   142: invokestatic 119	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_2
    //   146: ifnull -14 -> 132
    //   149: aload_2
    //   150: invokeinterface 69 1 0
    //   155: goto -23 -> 132
    //   158: astore_3
    //   159: aload_2
    //   160: ifnull +9 -> 169
    //   163: aload_2
    //   164: invokeinterface 69 1 0
    //   169: aload_3
    //   170: athrow
    //   171: astore_3
    //   172: goto -13 -> 159
    //   175: astore_2
    //   176: aload_3
    //   177: astore_2
    //   178: goto -41 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	a
    //   105	2	1	bool	boolean
    //   54	45	2	localObject1	Object
    //   134	1	2	localException1	Exception
    //   136	28	2	localObject2	Object
    //   175	1	2	localException2	Exception
    //   177	1	2	localObject3	Object
    //   16	111	3	localObject4	Object
    //   158	12	3	localObject5	Object
    //   171	6	3	localObject6	Object
    //   33	40	4	str	String
    // Exception table:
    //   from	to	target	type
    //   55	93	134	java/lang/Exception
    //   55	93	158	finally
    //   99	106	158	finally
    //   137	145	171	finally
    //   99	106	175	java/lang/Exception
  }
  
  public final List<String> cwu()
  {
    localArrayList = new ArrayList();
    Object localObject5 = EmojiGroupInfo.uCN;
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      localObject5 = this.dXw.a("select productID from EmojiGroupInfo where type=? and sync=?", new String[] { localObject5, "1" }, 2);
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
      localObject4 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToSyncStoreEmojiProductList. exception.%s", new Object[] { bk.csb() });
      return localArrayList;
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label180;
      }
      localObject4.close();
    }
    return localArrayList;
  }
  
  public final List<String> cwv()
  {
    localArrayList = new ArrayList();
    Object localObject5 = EmojiGroupInfo.uCN;
    String str = EmojiGroupInfo.TYPE_SYSTEM;
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      localObject5 = this.dXw.a("select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)", new String[] { "0", localObject5, "7", str, "0" }, 2);
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
      localObject4 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToUploadStoreEmojiProductList. exception.%s", new Object[] { bk.csb() });
      return localArrayList;
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label213;
      }
      localObject4.close();
    }
    return localArrayList;
  }
  
  public final ArrayList<EmojiGroupInfo> cww()
  {
    localArrayList = new ArrayList();
    Object localObject4 = EmojiGroupInfo.uCN;
    Object localObject5 = EmojiGroupInfo.TYPE_SYSTEM;
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = this.dXw.a("select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC", new String[] { localObject4, "7", localObject5, "0" }, 2);
      localObject1 = localObject4;
      localObject3 = localObject4;
      y.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
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
            ((EmojiGroupInfo)localObject5).d((Cursor)localObject4);
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
      localObject3 = localObject1;
      y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + localException.getMessage());
      return localArrayList;
    }
    finally
    {
      if (localObject3 == null) {
        break label253;
      }
      localObject3.close();
    }
    return localArrayList;
  }
  
  public final void cwx()
  {
    y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
    EmojiGroupInfo localEmojiGroupInfo = bE(String.valueOf(EmojiGroupInfo.uCR), false);
    if (localEmojiGroupInfo == null) {
      localEmojiGroupInfo = new EmojiGroupInfo();
    }
    for (;;)
    {
      localEmojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.uCR);
      localEmojiGroupInfo.field_packName = "emoji_custom_group";
      localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_CUSTOM;
      localEmojiGroupInfo.field_status = 0;
      localEmojiGroupInfo.field_packStatus = 1;
      localEmojiGroupInfo.field_flag = 0;
      a(localEmojiGroupInfo);
      y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
      return;
      y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", new Object[] { localEmojiGroupInfo.toString() });
    }
  }
  
  public final boolean cwy()
  {
    h localh = null;
    if ((this.dXw instanceof h)) {
      localh = (h)this.dXw;
    }
    for (long l = localh.eV(Thread.currentThread().getId());; l = -1L)
    {
      Object localObject = cwl();
      if (!((ArrayList)localObject).isEmpty())
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject).next();
          if ((localEmojiGroupInfo != null) && (!bk.bl(localEmojiGroupInfo.field_productID)))
          {
            i = AE(localEmojiGroupInfo.field_productID);
            if (localEmojiGroupInfo.field_count != i)
            {
              localEmojiGroupInfo.field_count = i;
              this.dXw.update("EmojiGroupInfo", localEmojiGroupInfo.vf(), "productID=?", new String[] { localEmojiGroupInfo.field_productID });
            }
          }
        }
      }
      if (localh != null) {}
      for (int i = localh.hI(l);; i = -1)
      {
        b("event_update_group", 0, bk.csb().toString());
        return i >= 0;
      }
    }
  }
  
  public final boolean dH(List<EmojiGroupInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
      return false;
    }
    h localh = null;
    long l;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(Thread.currentThread().getId());
      y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int i = 0;
      while (i < paramList.size())
      {
        EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)paramList.get(i);
        y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", new Object[] { localEmojiGroupInfo.field_productID, Long.valueOf(localEmojiGroupInfo.field_lastUseTime), Integer.valueOf(localEmojiGroupInfo.field_sort) });
        a(localEmojiGroupInfo);
        i += 1;
      }
      if (localh != null)
      {
        localh.hI(l);
        y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
      }
      b("event_update_group", 0, bk.csb().toString());
      return true;
      l = -1L;
    }
  }
  
  public final String getTableName()
  {
    return "EmojiGroupInfo";
  }
  
  public final boolean gj(Context paramContext)
  {
    y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
    gk(paramContext);
    y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.a
 * JD-Core Version:    0.7.0.1
 */