package com.tencent.mm.smiley;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiResProcessor;", "", "()V", "mEmojiHeader", "Lcom/tencent/mm/smiley/EmojiResHeader;", "mEmojiHeaderInfo", "Lcom/tencent/mm/smiley/EmojiResProcessor$EmojiResHeaderInfo;", "mIsHeaderUpdate", "", "mNeedUpdateBitmapBuffer", "mUseOldEmojiResource", "checkColorEmojiFile", "", "checkColorEmojiRoot", "constructIndex", "emojiDataItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/smiley/EmojiDataItem;", "containEmojiByTrie", "content", "", "containEmojiCountByTrie", "", "copyColorEmojiFile", "srcFilePath", "copyOldColorEmojiFileFromAsset", "emojiResCheck", "Landroid/graphics/drawable/Drawable;", "errorCheck", "emojiItem", "Lcom/tencent/mm/smiley/SystemEmojiItem;", "emojiSoftBank2UnicodeByTrie", "fixResError", "getColorEmojiSupportVersion", "getDrawable", "item", "getDrawableByNameIdx", "nameIdx", "getEmojiFileHeaderInfo", "dis", "Ljava/io/DataInputStream;", "filePath", "getEmojiHeader", "getEmojiHeaderOffset", "getEmojiItemBySoftBank", "codePoint", "getEmojiItemByTrie", "getEmojiItemByUnicode", "codePoint1", "codePoint2", "getEmojiResFilePath", "getEmojiVersion", "", "getSoftbankValByEmojiDataStartPos", "Lcom/tencent/mm/smiley/SoftbankEmojiItem;", "startPos", "getTruncateSafeOffset", "startIndex", "limitCount", "initDescIndex", "initEmojiResProto", "headerInfo", "needUpdateBitmapBuffer", "initHelperIndex", "initRes", "isDefaultEmoji", "isEmojiResProcessorSuccessInit", "replaceEmoji", "replacement", "replaceEmojiSpan", "Landroid/text/Spannable;", "context", "Landroid/content/Context;", "ss", "sizeInPx", "maxNum", "Lcom/tencent/mm/pointers/PInt;", "start", "end", "replaceEmojiWithDescByTrie", "setSpanImg", "drawable", "isWxEmoji", "Companion", "EmojiNewResInitReportStruct", "EmojiResHeaderInfo", "EmojiResProcessorHolder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j.a acxF;
  private static boolean acxL;
  private static final String acxM;
  private static String acxN;
  private static String acxO;
  public i acxG;
  private c acxH;
  private boolean acxI;
  private boolean acxJ;
  private boolean acxK;
  
  static
  {
    AppMethodBeat.i(242900);
    acxF = new j.a((byte)0);
    String str = s.X(com.tencent.mm.loader.i.b.bmq(), "app_font");
    acxM = str;
    acxN = s.X(str, "/color_emoji_new");
    acxO = s.X(acxM, "/color_emoji");
    AppMethodBeat.o(242900);
  }
  
  private j()
  {
    AppMethodBeat.i(242841);
    this.acxG = new i();
    AppMethodBeat.o(242841);
  }
  
  public static w ayo(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(242883);
    int i = j;
    if (57345 <= paramInt)
    {
      i = j;
      if (paramInt <= 58679) {
        i = 1;
      }
    }
    if (i != 0)
    {
      Object localObject = e.acxj;
      localObject = e.c.acxq;
      localObject = (a)e.c.iUR().acxp.acwL.get(paramInt, null);
      if (localObject == null) {}
      for (localObject = null; (localObject instanceof w); localObject = ((a)localObject).iUH())
      {
        localObject = (w)localObject;
        AppMethodBeat.o(242883);
        return localObject;
      }
      AppMethodBeat.o(242883);
      return null;
    }
    AppMethodBeat.o(242883);
    return null;
  }
  
  public static v ayr(int paramInt)
  {
    AppMethodBeat.i(242872);
    Object localObject = e.acxj;
    localObject = e.c.acxq;
    localObject = (v)e.c.iUR().acxl.get(paramInt, null);
    AppMethodBeat.o(242872);
    return localObject;
  }
  
  public static boolean buA(String paramString)
  {
    AppMethodBeat.i(242886);
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label34;
      }
    }
    label34:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(242886);
      return false;
    }
    Object localObject = e.acxj;
    localObject = e.c.acxq;
    paramString = e.c.iUR().k((CharSequence)paramString, paramString.length());
    if ((paramString != null) && ((paramString instanceof w)))
    {
      AppMethodBeat.o(242886);
      return true;
    }
    AppMethodBeat.o(242886);
    return false;
  }
  
  public static void bux(String paramString)
  {
    AppMethodBeat.i(242848);
    iUY();
    y.O(paramString, acxN, false);
    Log.i("MicroMsg.EmojiResProcessor", "copyColorEmojiFile from " + paramString + " to " + acxN);
    AppMethodBeat.o(242848);
  }
  
  /* Error */
  public static c buy(String paramString)
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 304
    //   10: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokestatic 311	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   17: ifeq +107 -> 124
    //   20: aload_0
    //   21: invokestatic 315	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_0
    //   25: new 317	java/io/DataInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 320	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: astore_1
    //   38: new 10	com/tencent/mm/smiley/j$c
    //   41: dup
    //   42: aload_3
    //   43: invokevirtual 323	java/io/DataInputStream:readInt	()I
    //   46: aload_3
    //   47: invokevirtual 327	java/io/DataInputStream:readLong	()J
    //   50: aload_3
    //   51: invokevirtual 323	java/io/DataInputStream:readInt	()I
    //   54: invokespecial 330	com/tencent/mm/smiley/j$c:<init>	(IJI)V
    //   57: astore 4
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 335	java/io/InputStream:close	()V
    //   67: aload_3
    //   68: invokevirtual 336	java/io/DataInputStream:close	()V
    //   71: ldc_w 303
    //   74: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload 4
    //   79: areturn
    //   80: astore 4
    //   82: aconst_null
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_3
    //   87: astore_2
    //   88: aload_0
    //   89: astore_1
    //   90: ldc_w 273
    //   93: aload 4
    //   95: checkcast 338	java/lang/Throwable
    //   98: ldc_w 339
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 335	java/io/InputStream:close	()V
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 336	java/io/DataInputStream:close	()V
    //   124: new 10	com/tencent/mm/smiley/j$c
    //   127: dup
    //   128: iconst_0
    //   129: lconst_0
    //   130: iconst_0
    //   131: invokespecial 330	com/tencent/mm/smiley/j$c:<init>	(IJI)V
    //   134: astore_0
    //   135: ldc_w 303
    //   138: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: areturn
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_3
    //   150: astore_2
    //   151: aload_0
    //   152: astore_1
    //   153: ldc_w 273
    //   156: aload 4
    //   158: checkcast 338	java/lang/Throwable
    //   161: ldc_w 339
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 335	java/io/InputStream:close	()V
    //   179: aload_3
    //   180: ifnull -56 -> 124
    //   183: aload_3
    //   184: invokevirtual 336	java/io/DataInputStream:close	()V
    //   187: goto -63 -> 124
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_2
    //   193: aconst_null
    //   194: astore_0
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 335	java/io/InputStream:close	()V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 336	java/io/DataInputStream:close	()V
    //   211: ldc_w 303
    //   214: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_3
    //   218: athrow
    //   219: astore_3
    //   220: aconst_null
    //   221: astore_2
    //   222: goto -27 -> 195
    //   225: astore_3
    //   226: aload_1
    //   227: astore_0
    //   228: goto -33 -> 195
    //   231: astore 4
    //   233: aconst_null
    //   234: astore_3
    //   235: goto -86 -> 149
    //   238: astore 4
    //   240: goto -91 -> 149
    //   243: astore 4
    //   245: aconst_null
    //   246: astore_3
    //   247: goto -161 -> 86
    //   250: astore 4
    //   252: goto -166 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramString	String
    //   37	190	1	str	String
    //   35	187	2	localDataInputStream1	java.io.DataInputStream
    //   33	151	3	localDataInputStream2	java.io.DataInputStream
    //   190	28	3	localObject1	Object
    //   219	1	3	localObject2	Object
    //   225	1	3	localObject3	Object
    //   234	13	3	localObject4	Object
    //   57	21	4	localc	c
    //   80	14	4	localIOException1	java.io.IOException
    //   143	14	4	localException1	java.lang.Exception
    //   231	1	4	localException2	java.lang.Exception
    //   238	1	4	localException3	java.lang.Exception
    //   243	1	4	localIOException2	java.io.IOException
    //   250	1	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   20	25	80	java/io/IOException
    //   20	25	143	java/lang/Exception
    //   20	25	190	finally
    //   25	34	219	finally
    //   38	59	225	finally
    //   90	108	225	finally
    //   153	171	225	finally
    //   25	34	231	java/lang/Exception
    //   38	59	238	java/lang/Exception
    //   25	34	243	java/io/IOException
    //   38	59	250	java/io/IOException
  }
  
  public static w buz(String paramString)
  {
    AppMethodBeat.i(242870);
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label36;
      }
    }
    label36:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(242870);
      return null;
    }
    Object localObject = e.acxj;
    localObject = e.c.acxq;
    paramString = e.c.iUR().k((CharSequence)paramString, paramString.length());
    if ((paramString != null) && ((paramString instanceof w)))
    {
      paramString = (w)paramString;
      AppMethodBeat.o(242870);
      return paramString;
    }
    AppMethodBeat.o(242870);
    return null;
  }
  
  public static Drawable c(w paramw)
  {
    AppMethodBeat.i(242888);
    Object localObject = EmojiDrawableBitmapRepo.acwO;
    localObject = EmojiDrawableBitmapRepo.b.acwT;
    paramw = EmojiDrawableBitmapRepo.b.iUJ().a(paramw, true);
    AppMethodBeat.o(242888);
    return paramw;
  }
  
  private void ct(LinkedList<b> paramLinkedList)
  {
    AppMethodBeat.i(242857);
    s.u(paramLinkedList, "emojiDataItems");
    if (paramLinkedList.isEmpty())
    {
      Log.i("MicroMsg.EmojiResProcessor", "constructIndex failed , emoji items is empty.");
      AppMethodBeat.o(242857);
      return;
    }
    Object localObject1 = ((Iterable)paramLinkedList).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      localObject3 = ((b)localObject2).acwM;
      s.s(localObject3, "emojiDataItem.codePoints");
      localObject3 = (List)localObject3;
      localObject2 = ((b)localObject2).acwN;
      s.s(localObject2, "emojiDataItem.picItem");
      localObject2 = new w((List)localObject3, (q)localObject2);
      localObject3 = e.acxj;
      localObject3 = e.c.acxq;
      localObject3 = e.c.iUR();
      s.u(localObject2, "item");
      ((e)localObject3).acxp.a((l)localObject2, 0);
    }
    localObject1 = this.acxG.acxD;
    s.s(localObject1, "mEmojiHeader.softbankEmojiItems");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (v)((Iterator)localObject1).next();
      localObject3 = e.acxj;
      localObject3 = e.c.acxq;
      localObject3 = e.c.iUR();
      s.s(localObject2, "softbankItem");
      s.u(paramLinkedList, "emojiItemList");
      s.u(localObject2, "item");
      Object localObject4 = (b)kotlin.a.p.ae((List)paramLinkedList, ((v)localObject2).acyu);
      if (localObject4 != null)
      {
        Object localObject5 = ((b)localObject4).acwM;
        s.s(localObject5, "emojiDataItem.codePoints");
        localObject5 = (List)localObject5;
        localObject4 = ((b)localObject4).acwN;
        s.s(localObject4, "emojiDataItem.picItem");
        localObject4 = new w((List)localObject5, (q)localObject4);
        localObject3 = ((e)localObject3).acxp;
        int i = ((v)localObject2).uKG;
        localObject2 = (l)localObject4;
        s.u(localObject2, "dataItem");
        localObject4 = new e.b();
        ((e.b)localObject4).acwK = ((l)localObject2);
        ((a)localObject3).acwL.put(i, localObject4);
      }
    }
    AppMethodBeat.o(242857);
  }
  
  public static int iE(String paramString, int paramInt)
  {
    AppMethodBeat.i(242890);
    if (!acxL)
    {
      AppMethodBeat.o(242890);
      return paramInt;
    }
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label54;
      }
    }
    label54:
    for (int i = 1; (i != 0) || (paramInt <= 0); i = 0)
    {
      AppMethodBeat.o(242890);
      return 0;
    }
    if (paramString.length() <= paramInt)
    {
      paramInt = paramString.length();
      AppMethodBeat.o(242890);
      return paramInt;
    }
    final ah.d locald1 = new ah.d();
    locald1.aixb = 0;
    final ah.d locald2 = new ah.d();
    locald2.aixb = -1;
    if (locald1.aixb < paramInt)
    {
      Object localObject = e.acxj;
      localObject = e.c.acxq;
      if (e.c.iUR().acxp.acwL.get(paramString.codePointAt(locald1.aixb)) != null)
      {
        localObject = e.acxj;
        localObject = e.c.acxq;
        e.c.iUR().a((CharSequence)paramString, locald1.aixb, paramString.length(), (m)new e(paramInt, locald2, locald1));
      }
      for (;;)
      {
        locald1.aixb += 1;
        break;
        locald2.aixb = locald1.aixb;
      }
    }
    if (locald2.aixb == -1) {
      locald2.aixb = 1;
    }
    paramInt = locald2.aixb;
    AppMethodBeat.o(242890);
    return paramInt + 1;
  }
  
  private static void iUY()
  {
    AppMethodBeat.i(242843);
    u localu = new u(acxM);
    if (localu.jKV()) {
      localu.diJ();
    }
    if (!localu.jKS()) {
      localu.jKY();
    }
    AppMethodBeat.o(242843);
  }
  
  public static int iVc()
  {
    return 1;
  }
  
  private final void iVe()
  {
    AppMethodBeat.i(242865);
    Object localObject3 = this.acxG.acxD;
    Object localObject1 = this.acxG.acxE;
    Object localObject2 = this.acxG.acxC;
    localObject3 = ((LinkedList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      v localv = (v)((Iterator)localObject3).next();
      Object localObject4 = e.acxj;
      localObject4 = e.c.acxq;
      e.c.iUR().acxk.append(localv.uKG, localv);
      localObject4 = e.acxj;
      localObject4 = e.c.acxq;
      e.c.iUR().acxl.append(((b)((LinkedList)localObject2).get(localv.acyu)).acwN.dIY, localv);
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      localObject3 = e.acxj;
      localObject3 = e.c.acxq;
      e.c.iUR().acxm.append(((p)localObject2).acxf, localObject2);
    }
    AppMethodBeat.o(242865);
  }
  
  static void iVf()
  {
    AppMethodBeat.i(242881);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = LocaleUtil.loadApplicationLanguage(((Context)localObject2).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), (Context)localObject2);
    if (localObject1 != null) {}
    switch (((String)localObject1).hashCode())
    {
    default: 
      localObject1 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_name_en);
      s.s(localObject1, "{\n            context.re….emoji_name_en)\n        }");
    }
    for (;;)
    {
      localObject2 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_code);
      s.s(localObject2, "context.resources.getStr…Array(R.array.emoji_code)");
      Object localObject3 = e.acxj;
      localObject3 = e.c.acxq;
      e.c.iUR().acxn.clear();
      int i = 0;
      while ((i < localObject2.length) && (i < localObject1.length))
      {
        localObject3 = e.acxj;
        localObject3 = e.c.acxq;
        e.c.iUR().acxn.put(localObject2[i].charAt(0), localObject1[i]);
        i += 1;
      }
      if (!((String)localObject1).equals("zh_TW")) {
        break;
      }
      do
      {
        localObject1 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_name_tw);
        s.s(localObject1, "{\n            context.re….emoji_name_tw)\n        }");
        break;
      } while (((String)localObject1).equals("zh_HK"));
      if ((goto 64) || (!((String)localObject1).equals("zh_CN"))) {
        break;
      }
      localObject1 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_name_ch);
      s.s(localObject1, "{\n            context.re….emoji_name_ch)\n        }");
    }
    AppMethodBeat.o(242881);
  }
  
  public static final j iVg()
  {
    AppMethodBeat.i(242894);
    Object localObject = d.acxV;
    localObject = d.iVg();
    AppMethodBeat.o(242894);
    return localObject;
  }
  
  public static w nS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242875);
    Object localObject = e.acxj;
    localObject = e.c.acxq;
    localObject = e.c.iUR().acxp.aym(paramInt1);
    if ((localObject instanceof e.b)) {
      localObject = (e.b)localObject;
    }
    while (localObject != null) {
      if (((a)localObject).acwL.size() == 0)
      {
        localObject = ((e.b)localObject).acwK;
        if ((localObject instanceof w))
        {
          localObject = (w)localObject;
          AppMethodBeat.o(242875);
          return localObject;
          localObject = null;
        }
        else
        {
          AppMethodBeat.o(242875);
          return null;
        }
      }
      else
      {
        localObject = (a)((a)localObject).acwL.get(paramInt2, null);
        if (localObject == null) {}
        for (localObject = null; (localObject instanceof w); localObject = ((a)localObject).iUH())
        {
          localObject = (w)localObject;
          AppMethodBeat.o(242875);
          return localObject;
        }
        AppMethodBeat.o(242875);
        return null;
      }
    }
    AppMethodBeat.o(242875);
    return null;
  }
  
  public final Spannable b(final Spannable paramSpannable, final int paramInt1, final PInt paramPInt, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(242906);
    s.u(paramPInt, "maxNum");
    if ((paramSpannable == null) || (paramSpannable.length() == 0))
    {
      AppMethodBeat.o(242906);
      return paramSpannable;
    }
    if (!acxL) {
      iUX();
    }
    long l1 = System.currentTimeMillis();
    final ah.d locald1 = new ah.d();
    final ah.d locald3 = new ah.d();
    ah.d locald2 = new ah.d();
    Object localObject = e.acxj;
    localObject = e.c.acxq;
    e.c.iUR().a((CharSequence)paramSpannable, paramInt2, paramInt3, (m)new f(locald2, paramPInt, locald1, locald3, this, paramSpannable, paramInt1));
    if (locald2.aixb > 0)
    {
      l1 = System.currentTimeMillis() - l1;
      if (l1 > 10L)
      {
        paramPInt = EmojiDrawableBitmapRepo.c.acwV;
        paramPInt = EmojiDrawableBitmapRepo.c.b.acwW;
        EmojiDrawableBitmapRepo.c.b.iUL();
        if (EmojiDrawableBitmapRepo.c.iUK())
        {
          paramPInt = EmojiDrawableBitmapRepo.c.acwV;
          paramPInt = EmojiDrawableBitmapRepo.c.b.acwW;
          EmojiDrawableBitmapRepo.c.b.iUL();
          paramInt1 = locald1.aixb;
          paramInt2 = locald2.aixb;
          paramInt3 = locald3.aixb;
          paramPInt = EmojiDrawableBitmapRepo.c.acwV;
          paramPInt = EmojiDrawableBitmapRepo.c.b.acwW;
          EmojiDrawableBitmapRepo.c.b.iUL();
          int i = EmojiDrawableBitmapRepo.c.nR(locald1.aixb, locald2.aixb);
          long l2 = iVb();
          paramPInt = EmojiDrawableBitmapRepo.acwO;
          paramPInt = EmojiDrawableBitmapRepo.b.acwT;
          EmojiDrawableBitmapRepo.c.b(paramInt1, paramInt2, paramInt3, i, l2, l1, EmojiDrawableBitmapRepo.b.iUJ().iUI());
        }
      }
    }
    AppMethodBeat.o(242906);
    return paramSpannable;
  }
  
  /* Error */
  public final boolean iUX()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 16
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_1
    //   10: istore 7
    //   12: iconst_1
    //   13: istore_2
    //   14: iconst_1
    //   15: istore_3
    //   16: iconst_0
    //   17: istore 8
    //   19: ldc_w 677
    //   22: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   25: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   28: lstore 9
    //   30: iconst_m1
    //   31: istore 6
    //   33: getstatic 162	com/tencent/mm/smiley/j:acxN	Ljava/lang/String;
    //   36: invokestatic 311	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   39: ifne +311 -> 350
    //   42: getstatic 166	com/tencent/mm/smiley/j:acxO	Ljava/lang/String;
    //   45: invokestatic 311	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   48: ifeq +295 -> 343
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 679	com/tencent/mm/smiley/j:acxK	Z
    //   56: aload_0
    //   57: getfield 679	com/tencent/mm/smiley/j:acxK	Z
    //   60: ifeq +307 -> 367
    //   63: getstatic 166	com/tencent/mm/smiley/j:acxO	Ljava/lang/String;
    //   66: astore 13
    //   68: aload 13
    //   70: invokestatic 315	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   73: astore 13
    //   75: new 317	java/io/DataInputStream
    //   78: dup
    //   79: aload 13
    //   81: invokespecial 320	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore 14
    //   86: aload 14
    //   88: ldc_w 680
    //   91: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   94: aload_0
    //   95: new 10	com/tencent/mm/smiley/j$c
    //   98: dup
    //   99: aload 14
    //   101: invokevirtual 323	java/io/DataInputStream:readInt	()I
    //   104: aload 14
    //   106: invokevirtual 327	java/io/DataInputStream:readLong	()J
    //   109: aload 14
    //   111: invokevirtual 323	java/io/DataInputStream:readInt	()I
    //   114: invokespecial 330	com/tencent/mm/smiley/j$c:<init>	(IJI)V
    //   117: putfield 682	com/tencent/mm/smiley/j:acxH	Lcom/tencent/mm/smiley/j$c;
    //   120: aload_0
    //   121: getfield 682	com/tencent/mm/smiley/j:acxH	Lcom/tencent/mm/smiley/j$c;
    //   124: astore 15
    //   126: aload 15
    //   128: ifnonnull +247 -> 375
    //   131: iconst_0
    //   132: istore_1
    //   133: iload_1
    //   134: ifle +12 -> 146
    //   137: iload_1
    //   138: aload 14
    //   140: invokevirtual 685	java/io/DataInputStream:available	()I
    //   143: if_icmple +241 -> 384
    //   146: ldc_w 273
    //   149: ldc_w 687
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: iload_1
    //   159: invokestatic 693	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic 697	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: iconst_3
    //   167: istore_1
    //   168: iconst_0
    //   169: istore 8
    //   171: aload 14
    //   173: invokevirtual 336	java/io/DataInputStream:close	()V
    //   176: aload 13
    //   178: ifnull +8 -> 186
    //   181: aload 13
    //   183: invokevirtual 335	java/io/InputStream:close	()V
    //   186: iload 8
    //   188: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   191: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   194: ifeq +52 -> 246
    //   197: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   200: lstore 11
    //   202: iload 8
    //   204: ifeq +1375 -> 1579
    //   207: iconst_0
    //   208: istore_1
    //   209: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   212: astore 13
    //   214: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   217: astore 13
    //   219: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   222: pop
    //   223: lload 11
    //   225: lload 9
    //   227: lsub
    //   228: iload_1
    //   229: aload_0
    //   230: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   233: aload_0
    //   234: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   237: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   240: invokevirtual 715	java/util/LinkedList:size	()I
    //   243: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   246: aload_0
    //   247: iconst_0
    //   248: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   251: new 275	java/lang/StringBuilder
    //   254: dup
    //   255: ldc_w 722
    //   258: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: astore 14
    //   263: aload_0
    //   264: getfield 682	com/tencent/mm/smiley/j:acxH	Lcom/tencent/mm/smiley/j$c;
    //   267: astore 13
    //   269: aload 13
    //   271: ifnonnull +1163 -> 1434
    //   274: aconst_null
    //   275: astore 13
    //   277: aload 14
    //   279: aload 13
    //   281: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   284: ldc_w 724
    //   287: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: astore 14
    //   292: aload_0
    //   293: getfield 682	com/tencent/mm/smiley/j:acxH	Lcom/tencent/mm/smiley/j$c;
    //   296: astore 13
    //   298: aload 13
    //   300: ifnonnull +1147 -> 1447
    //   303: aload 16
    //   305: astore 13
    //   307: ldc_w 273
    //   310: aload 14
    //   312: aload 13
    //   314: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   317: ldc_w 726
    //   320: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload 8
    //   325: invokevirtual 729	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   328: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: ldc_w 677
    //   337: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: iload 8
    //   342: ireturn
    //   343: aload_0
    //   344: invokevirtual 732	com/tencent/mm/smiley/j:iUZ	()V
    //   347: goto -291 -> 56
    //   350: aload_0
    //   351: iconst_0
    //   352: putfield 679	com/tencent/mm/smiley/j:acxK	Z
    //   355: ldc_w 273
    //   358: ldc_w 734
    //   361: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: goto -308 -> 56
    //   367: getstatic 162	com/tencent/mm/smiley/j:acxN	Ljava/lang/String;
    //   370: astore 13
    //   372: goto -304 -> 68
    //   375: aload 15
    //   377: getfield 737	com/tencent/mm/smiley/j$c:cOg	I
    //   380: istore_1
    //   381: goto -248 -> 133
    //   384: aload_0
    //   385: getfield 682	com/tencent/mm/smiley/j:acxH	Lcom/tencent/mm/smiley/j$c;
    //   388: astore 15
    //   390: aload 15
    //   392: ifnonnull +8 -> 400
    //   395: iconst_0
    //   396: istore_1
    //   397: goto +1185 -> 1582
    //   400: aload 15
    //   402: getfield 737	com/tencent/mm/smiley/j$c:cOg	I
    //   405: istore_1
    //   406: goto +1176 -> 1582
    //   409: iload_1
    //   410: newarray byte
    //   412: astore 17
    //   414: aload 14
    //   416: aload 17
    //   418: invokevirtual 741	java/io/DataInputStream:read	([B)I
    //   421: pop
    //   422: aload_0
    //   423: getfield 679	com/tencent/mm/smiley/j:acxK	Z
    //   426: ifne +51 -> 477
    //   429: aload_0
    //   430: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   433: aload 17
    //   435: invokevirtual 745	com/tencent/mm/smiley/i:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   438: pop
    //   439: aload_0
    //   440: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   443: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   446: astore 15
    //   448: aload 15
    //   450: ldc_w 747
    //   453: invokestatic 405	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   456: aload_0
    //   457: aload 15
    //   459: invokespecial 749	com/tencent/mm/smiley/j:ct	(Ljava/util/LinkedList;)V
    //   462: aload_0
    //   463: invokespecial 751	com/tencent/mm/smiley/j:iVe	()V
    //   466: aload_0
    //   467: iconst_1
    //   468: putfield 753	com/tencent/mm/smiley/j:acxI	Z
    //   471: iconst_1
    //   472: istore 8
    //   474: goto +1120 -> 1594
    //   477: new 755	com/tencent/mm/smiley/c
    //   480: dup
    //   481: invokespecial 756	com/tencent/mm/smiley/c:<init>	()V
    //   484: astore 15
    //   486: aload 15
    //   488: aload 17
    //   490: invokevirtual 757	com/tencent/mm/smiley/c:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   493: pop
    //   494: getstatic 763	com/tencent/mm/smiley/g:acxz	Lcom/tencent/mm/smiley/g$a;
    //   497: astore 17
    //   499: getstatic 769	com/tencent/mm/smiley/g$b:acxA	Lcom/tencent/mm/smiley/g$b;
    //   502: astore 17
    //   504: invokestatic 773	com/tencent/mm/smiley/g$b:iUW	()Lcom/tencent/mm/smiley/g;
    //   507: pop
    //   508: aload_0
    //   509: aload 15
    //   511: invokestatic 776	com/tencent/mm/smiley/g:a	(Lcom/tencent/mm/smiley/c;)Lcom/tencent/mm/smiley/i;
    //   514: putfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   517: goto -78 -> 439
    //   520: astore 15
    //   522: ldc_w 273
    //   525: aload 15
    //   527: checkcast 338	java/lang/Throwable
    //   530: ldc_w 339
    //   533: iconst_0
    //   534: anewarray 4	java/lang/Object
    //   537: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   540: aload 14
    //   542: ifnull +8 -> 550
    //   545: aload 14
    //   547: invokevirtual 336	java/io/DataInputStream:close	()V
    //   550: aload 13
    //   552: ifnull +8 -> 560
    //   555: aload 13
    //   557: invokevirtual 335	java/io/InputStream:close	()V
    //   560: iconst_0
    //   561: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   564: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   567: ifeq +45 -> 612
    //   570: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   573: lstore 11
    //   575: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   578: astore 13
    //   580: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   583: astore 13
    //   585: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   588: pop
    //   589: lload 11
    //   591: lload 9
    //   593: lsub
    //   594: iconst_1
    //   595: aload_0
    //   596: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   599: aload_0
    //   600: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   603: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   606: invokevirtual 715	java/util/LinkedList:size	()I
    //   609: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   612: aload_0
    //   613: iconst_0
    //   614: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   617: goto -366 -> 251
    //   620: astore 13
    //   622: ldc_w 273
    //   625: aload 13
    //   627: checkcast 338	java/lang/Throwable
    //   630: ldc_w 339
    //   633: iconst_0
    //   634: anewarray 4	java/lang/Object
    //   637: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: iload 8
    //   642: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   645: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   648: ifeq +54 -> 702
    //   651: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   654: lstore 11
    //   656: iload_3
    //   657: istore_1
    //   658: iload 8
    //   660: ifeq +5 -> 665
    //   663: iconst_0
    //   664: istore_1
    //   665: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   668: astore 13
    //   670: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   673: astore 13
    //   675: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   678: pop
    //   679: lload 11
    //   681: lload 9
    //   683: lsub
    //   684: iload_1
    //   685: aload_0
    //   686: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   689: aload_0
    //   690: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   693: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   696: invokevirtual 715	java/util/LinkedList:size	()I
    //   699: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   702: aload_0
    //   703: iconst_0
    //   704: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   707: goto -456 -> 251
    //   710: astore 13
    //   712: iload 8
    //   714: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   717: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   720: ifeq +52 -> 772
    //   723: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   726: lstore 11
    //   728: iload 8
    //   730: ifeq +5 -> 735
    //   733: iconst_0
    //   734: istore_1
    //   735: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   738: astore 14
    //   740: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   743: astore 14
    //   745: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   748: pop
    //   749: lload 11
    //   751: lload 9
    //   753: lsub
    //   754: iload_1
    //   755: aload_0
    //   756: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   759: aload_0
    //   760: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   763: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   766: invokevirtual 715	java/util/LinkedList:size	()I
    //   769: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   772: aload_0
    //   773: iconst_0
    //   774: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   777: ldc_w 677
    //   780: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   783: aload 13
    //   785: athrow
    //   786: astore 13
    //   788: ldc_w 273
    //   791: aload 13
    //   793: checkcast 338	java/lang/Throwable
    //   796: ldc_w 339
    //   799: iconst_0
    //   800: anewarray 4	java/lang/Object
    //   803: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: iconst_0
    //   807: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   810: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   813: ifeq +45 -> 858
    //   816: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   819: lstore 11
    //   821: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   824: astore 13
    //   826: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   829: astore 13
    //   831: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   834: pop
    //   835: lload 11
    //   837: lload 9
    //   839: lsub
    //   840: iconst_1
    //   841: aload_0
    //   842: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   845: aload_0
    //   846: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   849: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   852: invokevirtual 715	java/util/LinkedList:size	()I
    //   855: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   858: aload_0
    //   859: iconst_0
    //   860: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   863: goto -612 -> 251
    //   866: astore 13
    //   868: iconst_0
    //   869: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   872: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   875: ifeq +45 -> 920
    //   878: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   881: lstore 11
    //   883: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   886: astore 14
    //   888: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   891: astore 14
    //   893: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   896: pop
    //   897: lload 11
    //   899: lload 9
    //   901: lsub
    //   902: iconst_1
    //   903: aload_0
    //   904: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   907: aload_0
    //   908: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   911: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   914: invokevirtual 715	java/util/LinkedList:size	()I
    //   917: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   920: aload_0
    //   921: iconst_0
    //   922: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   925: ldc_w 677
    //   928: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   931: aload 13
    //   933: athrow
    //   934: astore 15
    //   936: aconst_null
    //   937: astore 14
    //   939: aconst_null
    //   940: astore 13
    //   942: ldc_w 273
    //   945: aload 15
    //   947: checkcast 338	java/lang/Throwable
    //   950: ldc_w 339
    //   953: iconst_0
    //   954: anewarray 4	java/lang/Object
    //   957: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   960: aload 14
    //   962: ifnull +8 -> 970
    //   965: aload 14
    //   967: invokevirtual 336	java/io/DataInputStream:close	()V
    //   970: aload 13
    //   972: ifnull +8 -> 980
    //   975: aload 13
    //   977: invokevirtual 335	java/io/InputStream:close	()V
    //   980: iconst_0
    //   981: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   984: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   987: ifeq +45 -> 1032
    //   990: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   993: lstore 11
    //   995: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   998: astore 13
    //   1000: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   1003: astore 13
    //   1005: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   1008: pop
    //   1009: lload 11
    //   1011: lload 9
    //   1013: lsub
    //   1014: iconst_2
    //   1015: aload_0
    //   1016: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   1019: aload_0
    //   1020: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   1023: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   1026: invokevirtual 715	java/util/LinkedList:size	()I
    //   1029: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   1032: aload_0
    //   1033: iconst_0
    //   1034: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   1037: goto -786 -> 251
    //   1040: astore 13
    //   1042: ldc_w 273
    //   1045: aload 13
    //   1047: checkcast 338	java/lang/Throwable
    //   1050: ldc_w 339
    //   1053: iconst_0
    //   1054: anewarray 4	java/lang/Object
    //   1057: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1060: iconst_0
    //   1061: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   1064: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1067: ifeq +45 -> 1112
    //   1070: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   1073: lstore 11
    //   1075: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   1078: astore 13
    //   1080: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   1083: astore 13
    //   1085: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   1088: pop
    //   1089: lload 11
    //   1091: lload 9
    //   1093: lsub
    //   1094: iconst_1
    //   1095: aload_0
    //   1096: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   1099: aload_0
    //   1100: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   1103: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   1106: invokevirtual 715	java/util/LinkedList:size	()I
    //   1109: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   1112: aload_0
    //   1113: iconst_0
    //   1114: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   1117: goto -866 -> 251
    //   1120: astore 13
    //   1122: iconst_2
    //   1123: istore_1
    //   1124: iconst_0
    //   1125: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   1128: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1131: ifeq +45 -> 1176
    //   1134: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   1137: lstore 11
    //   1139: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   1142: astore 14
    //   1144: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   1147: astore 14
    //   1149: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   1152: pop
    //   1153: lload 11
    //   1155: lload 9
    //   1157: lsub
    //   1158: iload_1
    //   1159: aload_0
    //   1160: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   1163: aload_0
    //   1164: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   1167: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   1170: invokevirtual 715	java/util/LinkedList:size	()I
    //   1173: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   1176: aload_0
    //   1177: iconst_0
    //   1178: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   1181: ldc_w 677
    //   1184: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1187: aload 13
    //   1189: athrow
    //   1190: astore 13
    //   1192: aconst_null
    //   1193: astore 14
    //   1195: aconst_null
    //   1196: astore 15
    //   1198: iconst_m1
    //   1199: istore_1
    //   1200: aload 14
    //   1202: ifnull +8 -> 1210
    //   1205: aload 14
    //   1207: invokevirtual 336	java/io/DataInputStream:close	()V
    //   1210: aload 15
    //   1212: ifnull +8 -> 1220
    //   1215: aload 15
    //   1217: invokevirtual 335	java/io/InputStream:close	()V
    //   1220: iconst_0
    //   1221: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   1224: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1227: ifeq +45 -> 1272
    //   1230: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   1233: lstore 11
    //   1235: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   1238: astore 14
    //   1240: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   1243: astore 14
    //   1245: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   1248: pop
    //   1249: lload 11
    //   1251: lload 9
    //   1253: lsub
    //   1254: iload_1
    //   1255: aload_0
    //   1256: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   1259: aload_0
    //   1260: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   1263: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   1266: invokevirtual 715	java/util/LinkedList:size	()I
    //   1269: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   1272: aload_0
    //   1273: iconst_0
    //   1274: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   1277: ldc_w 677
    //   1280: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1283: aload 13
    //   1285: athrow
    //   1286: astore 14
    //   1288: ldc_w 273
    //   1291: aload 14
    //   1293: checkcast 338	java/lang/Throwable
    //   1296: ldc_w 339
    //   1299: iconst_0
    //   1300: anewarray 4	java/lang/Object
    //   1303: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1306: iconst_0
    //   1307: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   1310: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1313: ifeq +45 -> 1358
    //   1316: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   1319: lstore 11
    //   1321: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   1324: astore 14
    //   1326: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   1329: astore 14
    //   1331: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   1334: pop
    //   1335: lload 11
    //   1337: lload 9
    //   1339: lsub
    //   1340: iconst_1
    //   1341: aload_0
    //   1342: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   1345: aload_0
    //   1346: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   1349: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   1352: invokevirtual 715	java/util/LinkedList:size	()I
    //   1355: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   1358: aload_0
    //   1359: iconst_0
    //   1360: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   1363: goto -86 -> 1277
    //   1366: astore 13
    //   1368: iconst_0
    //   1369: putstatic 464	com/tencent/mm/smiley/j:acxL	Z
    //   1372: invokestatic 700	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   1375: ifeq +45 -> 1420
    //   1378: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   1381: lstore 11
    //   1383: getstatic 704	com/tencent/mm/smiley/j$b:acxP	Lcom/tencent/mm/smiley/j$b$a;
    //   1386: astore 14
    //   1388: getstatic 710	com/tencent/mm/smiley/j$b$b:acxQ	Lcom/tencent/mm/smiley/j$b$b;
    //   1391: astore 14
    //   1393: invokestatic 714	com/tencent/mm/smiley/j$b$b:iVh	()Lcom/tencent/mm/smiley/j$b;
    //   1396: pop
    //   1397: lload 11
    //   1399: lload 9
    //   1401: lsub
    //   1402: iload_1
    //   1403: aload_0
    //   1404: invokevirtual 670	com/tencent/mm/smiley/j:iVb	()J
    //   1407: aload_0
    //   1408: getfield 178	com/tencent/mm/smiley/j:acxG	Lcom/tencent/mm/smiley/i;
    //   1411: getfield 510	com/tencent/mm/smiley/i:acxC	Ljava/util/LinkedList;
    //   1414: invokevirtual 715	java/util/LinkedList:size	()I
    //   1417: invokestatic 718	com/tencent/mm/smiley/j$b:a	(JIJI)V
    //   1420: aload_0
    //   1421: iconst_0
    //   1422: putfield 720	com/tencent/mm/smiley/j:acxJ	Z
    //   1425: ldc_w 677
    //   1428: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1431: aload 13
    //   1433: athrow
    //   1434: aload 13
    //   1436: getfield 779	com/tencent/mm/smiley/j$c:acxS	I
    //   1439: invokestatic 693	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1442: astore 13
    //   1444: goto -1167 -> 277
    //   1447: aload 13
    //   1449: getfield 783	com/tencent/mm/smiley/j$c:acxT	J
    //   1452: invokestatic 788	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1455: astore 13
    //   1457: goto -1150 -> 307
    //   1460: astore 13
    //   1462: iload_2
    //   1463: istore_1
    //   1464: goto -96 -> 1368
    //   1467: astore 16
    //   1469: aconst_null
    //   1470: astore 14
    //   1472: iconst_m1
    //   1473: istore_1
    //   1474: aload 13
    //   1476: astore 15
    //   1478: aload 16
    //   1480: astore 13
    //   1482: goto -282 -> 1200
    //   1485: astore 16
    //   1487: iconst_m1
    //   1488: istore_1
    //   1489: aload 13
    //   1491: astore 15
    //   1493: aload 16
    //   1495: astore 13
    //   1497: goto -297 -> 1200
    //   1500: astore 16
    //   1502: iconst_1
    //   1503: istore_1
    //   1504: aload 13
    //   1506: astore 15
    //   1508: aload 16
    //   1510: astore 13
    //   1512: goto -312 -> 1200
    //   1515: astore 16
    //   1517: aload 13
    //   1519: astore 15
    //   1521: aload 16
    //   1523: astore 13
    //   1525: iload 5
    //   1527: istore_1
    //   1528: goto -328 -> 1200
    //   1531: astore 13
    //   1533: iload 7
    //   1535: istore_1
    //   1536: goto -412 -> 1124
    //   1539: astore 15
    //   1541: aconst_null
    //   1542: astore 14
    //   1544: goto -602 -> 942
    //   1547: astore 15
    //   1549: goto -607 -> 942
    //   1552: astore 15
    //   1554: aconst_null
    //   1555: astore 14
    //   1557: aconst_null
    //   1558: astore 13
    //   1560: goto -1038 -> 522
    //   1563: astore 15
    //   1565: aconst_null
    //   1566: astore 14
    //   1568: goto -1046 -> 522
    //   1571: astore 13
    //   1573: iload 4
    //   1575: istore_1
    //   1576: goto -864 -> 712
    //   1579: goto -1370 -> 209
    //   1582: aload 15
    //   1584: ifnull +7 -> 1591
    //   1587: iload_1
    //   1588: ifgt -1179 -> 409
    //   1591: iconst_0
    //   1592: istore 8
    //   1594: iload 6
    //   1596: istore_1
    //   1597: goto -1426 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1600	0	this	j
    //   132	1465	1	i	int
    //   13	1450	2	j	int
    //   15	642	3	k	int
    //   7	1567	4	m	int
    //   1	1525	5	n	int
    //   31	1564	6	i1	int
    //   10	1524	7	i2	int
    //   17	1576	8	bool	boolean
    //   28	1372	9	l1	long
    //   200	1198	11	l2	long
    //   66	518	13	localObject1	Object
    //   620	6	13	localIOException1	java.io.IOException
    //   668	6	13	localObject2	Object
    //   710	74	13	localObject3	Object
    //   786	6	13	localIOException2	java.io.IOException
    //   824	6	13	localObject4	Object
    //   866	66	13	localObject5	Object
    //   940	64	13	localObject6	Object
    //   1040	6	13	localIOException3	java.io.IOException
    //   1078	6	13	localObject7	Object
    //   1120	68	13	localObject8	Object
    //   1190	94	13	localObject9	Object
    //   1366	69	13	localObject10	Object
    //   1442	14	13	localObject11	Object
    //   1460	15	13	localObject12	Object
    //   1480	44	13	localObject13	Object
    //   1531	1	13	localObject14	Object
    //   1558	1	13	localObject15	Object
    //   1571	1	13	localObject16	Object
    //   84	1160	14	localObject17	Object
    //   1286	6	14	localIOException4	java.io.IOException
    //   1324	243	14	localObject18	Object
    //   124	386	15	localObject19	Object
    //   520	6	15	localIOException5	java.io.IOException
    //   934	12	15	localException1	java.lang.Exception
    //   1196	324	15	localObject20	Object
    //   1539	1	15	localException2	java.lang.Exception
    //   1547	1	15	localException3	java.lang.Exception
    //   1552	1	15	localIOException6	java.io.IOException
    //   1563	20	15	localIOException7	java.io.IOException
    //   4	300	16	localObject21	Object
    //   1467	12	16	localObject22	Object
    //   1485	9	16	localObject23	Object
    //   1500	9	16	localObject24	Object
    //   1515	7	16	localObject25	Object
    //   412	91	17	localObject26	Object
    // Exception table:
    //   from	to	target	type
    //   86	126	520	java/io/IOException
    //   137	146	520	java/io/IOException
    //   146	166	520	java/io/IOException
    //   375	381	520	java/io/IOException
    //   384	390	520	java/io/IOException
    //   400	406	520	java/io/IOException
    //   409	439	520	java/io/IOException
    //   439	471	520	java/io/IOException
    //   477	517	520	java/io/IOException
    //   171	176	620	java/io/IOException
    //   181	186	620	java/io/IOException
    //   171	176	710	finally
    //   181	186	710	finally
    //   545	550	786	java/io/IOException
    //   555	560	786	java/io/IOException
    //   545	550	866	finally
    //   555	560	866	finally
    //   788	806	866	finally
    //   56	68	934	java/lang/Exception
    //   68	75	934	java/lang/Exception
    //   367	372	934	java/lang/Exception
    //   965	970	1040	java/io/IOException
    //   975	980	1040	java/io/IOException
    //   965	970	1120	finally
    //   975	980	1120	finally
    //   56	68	1190	finally
    //   68	75	1190	finally
    //   367	372	1190	finally
    //   1205	1210	1286	java/io/IOException
    //   1215	1220	1286	java/io/IOException
    //   1205	1210	1366	finally
    //   1215	1220	1366	finally
    //   1288	1306	1460	finally
    //   75	86	1467	finally
    //   86	126	1485	finally
    //   137	146	1485	finally
    //   146	166	1485	finally
    //   375	381	1485	finally
    //   384	390	1485	finally
    //   400	406	1485	finally
    //   409	439	1485	finally
    //   439	471	1485	finally
    //   477	517	1485	finally
    //   522	540	1500	finally
    //   942	960	1515	finally
    //   1042	1060	1531	finally
    //   75	86	1539	java/lang/Exception
    //   86	126	1547	java/lang/Exception
    //   137	146	1547	java/lang/Exception
    //   146	166	1547	java/lang/Exception
    //   375	381	1547	java/lang/Exception
    //   384	390	1547	java/lang/Exception
    //   400	406	1547	java/lang/Exception
    //   409	439	1547	java/lang/Exception
    //   439	471	1547	java/lang/Exception
    //   477	517	1547	java/lang/Exception
    //   56	68	1552	java/io/IOException
    //   68	75	1552	java/io/IOException
    //   367	372	1552	java/io/IOException
    //   75	86	1563	java/io/IOException
    //   622	640	1571	finally
  }
  
  final void iUZ()
  {
    AppMethodBeat.i(242904);
    long l = System.currentTimeMillis();
    iUY();
    y.O("assets:///color_emoji", acxO, false);
    this.acxK = true;
    Log.i("MicroMsg.EmojiResProcessor", "copyOldColorEmojiFileFromAsset from asset. use time:" + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(242904);
  }
  
  public final int iVa()
  {
    c localc = this.acxH;
    if (localc == null) {
      return 0;
    }
    return localc.acxU;
  }
  
  public final long iVb()
  {
    c localc = this.acxH;
    if (localc == null) {
      return 0L;
    }
    return localc.acxT;
  }
  
  public final String iVd()
  {
    if (this.acxK) {
      return acxO;
    }
    return acxN;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiResProcessor$EmojiResHeaderInfo;", "", "supportVersion", "", "emojiVersion", "", "headerSize", "(IJI)V", "emojiHeaderOffset", "getEmojiHeaderOffset", "()I", "getEmojiVersion", "()J", "getHeaderSize", "getSupportVersion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public final int acxS;
    public final long acxT;
    final int acxU;
    final int cOg;
    
    public c(int paramInt1, long paramLong, int paramInt2)
    {
      AppMethodBeat.i(242821);
      this.acxS = paramInt1;
      this.acxT = paramLong;
      this.cOg = paramInt2;
      this.acxU = (this.cOg + 4 + 8 + 4);
      AppMethodBeat.o(242821);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiResProcessor$EmojiResProcessorHolder;", "", "()V", "instance", "Lcom/tencent/mm/smiley/EmojiResProcessor;", "getInstance", "()Lcom/tencent/mm/smiley/EmojiResProcessor;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    public static final d acxV;
    private static final j acxW;
    
    static
    {
      AppMethodBeat.i(242823);
      acxV = new d();
      acxW = new j((byte)0);
      AppMethodBeat.o(242823);
    }
    
    public static j iVg()
    {
      return acxW;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/EmojiResProcessor$getTruncateSafeOffset$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements m
  {
    e(int paramInt, ah.d paramd1, ah.d paramd2) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242816);
      s.u(paraml, "item");
      if (paramInt2 - 1 <= this.acxX) {
        locald2.aixb = (paramInt2 - 1);
      }
      locald1.aixb = (paramInt2 - 1);
      AppMethodBeat.o(242816);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/EmojiResProcessor$replaceEmojiSpan$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements m
  {
    f(ah.d paramd1, PInt paramPInt, ah.d paramd2, ah.d paramd3, j paramj, Spannable paramSpannable, int paramInt) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242818);
      s.u(paraml, "item");
      int i;
      if ((this.acya.aixb < paramPInt.value) && ((paraml instanceof w)))
      {
        Object localObject = EmojiDrawableBitmapRepo.acwO;
        localObject = EmojiDrawableBitmapRepo.b.acwT;
        localObject = EmojiDrawableBitmapRepo.b.iUJ();
        String str = String.valueOf(((w)paraml).acwN.dIY);
        s.u(str, "key");
        if (!((EmojiDrawableBitmapRepo)localObject).acwQ.keySet().contains(str)) {
          break label155;
        }
        i = locald1.aixb;
      }
      for (locald1.aixb = (i + 1);; locald3.aixb = (i + 1))
      {
        i = this.acya.aixb;
        this.acya.aixb = (i + 1);
        j.b(paramSpannable, j.c((w)paraml), paramInt1, paramInt2);
        AppMethodBeat.o(242818);
        return false;
        label155:
        i = locald3.aixb;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/EmojiResProcessor$replaceEmojiWithDescByTrie$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements m
  {
    g(StringBuilder paramStringBuilder, String paramString, ah.d paramd, j paramj) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242819);
      s.u(paraml, "item");
      if ((paraml instanceof w))
      {
        this.wGN.append((CharSequence)this.nhk, this.acyh.aixb, paramInt1);
        paraml = j.ayr(((w)paraml).acwN.dIY);
        if (paraml != null) {
          break label112;
        }
        paramInt1 = 0;
        paraml = e.acxj;
        paraml = e.c.acxq;
        paraml = (String)e.c.iUR().acxn.get(paramInt1, null);
        if (paraml == null) {
          break label120;
        }
        this.wGN.append(paraml);
      }
      for (;;)
      {
        this.acyh.aixb = paramInt2;
        AppMethodBeat.o(242819);
        return false;
        label112:
        paramInt1 = paraml.uKG;
        break;
        label120:
        this.wGN.append(MMApplicationContext.getContext().getString(a.j.app_emoji2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.j
 * JD-Core Version:    0.7.0.1
 */