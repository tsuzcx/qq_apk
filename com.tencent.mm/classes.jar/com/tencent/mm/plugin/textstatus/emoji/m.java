package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.util.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiUtil;", "", "()V", "TAG", "", "emojiSubTypeArrayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getAllEmojiByType", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiDataList;", "context", "Landroid/content/Context;", "typeName", "subTypeName", "getLastEmojiSubType", "emojiType", "getSubTypeByEmojiType", "saveLastEmojiSubType", "", "subType", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  private static final ArrayList<f> Jyq;
  public static final m TkV;
  
  static
  {
    AppMethodBeat.i(290806);
    TkV = new m();
    ArrayList localArrayList = new ArrayList(13);
    Jyq = localArrayList;
    String str = MMApplicationContext.getContext().getString(a.h.Tgj);
    s.s(str, "getContext().getString(R…us_emoji_subtype_emotion)");
    localArrayList.add(new f(str, "emotion"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgo);
    s.s(str, "getContext().getString(R…atus_emoji_subtype_limbs)");
    localArrayList.add(new f(str, "limbs"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgq);
    s.s(str, "getContext().getString(R…tus_emoji_subtype_person)");
    localArrayList.add(new f(str, "person"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgh);
    s.s(str, "getContext().getString(R…tus_emoji_subtype_animal)");
    localArrayList.add(new f(str, "animal"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgi);
    s.s(str, "getContext().getString(R…tus_emoji_subtype_botany)");
    localArrayList.add(new f(str, "botany"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgp);
    s.s(str, "getContext().getString(R…tus_emoji_subtype_nature)");
    localArrayList.add(new f(str, "nature"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgm);
    s.s(str, "getContext().getString(R…tatus_emoji_subtype_food)");
    localArrayList.add(new f(str, "food"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgr);
    s.s(str, "getContext().getString(R…atus_emoji_subtype_place)");
    localArrayList.add(new f(str, "place"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgt);
    s.s(str, "getContext().getString(R…us_emoji_subtype_traffic)");
    localArrayList.add(new f(str, "traffic"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgk);
    s.s(str, "getContext().getString(R…s_emoji_subtype_exercise)");
    localArrayList.add(new f(str, "exercise"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgn);
    s.s(str, "getContext().getString(R…atus_emoji_subtype_goods)");
    localArrayList.add(new f(str, "goods"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgs);
    s.s(str, "getContext().getString(R…tus_emoji_subtype_symbol)");
    localArrayList.add(new f(str, "symbol"));
    localArrayList = Jyq;
    str = MMApplicationContext.getContext().getString(a.h.Tgl);
    s.s(str, "getContext().getString(R…tatus_emoji_subtype_flag)");
    localArrayList.add(new f(str, "flag"));
    AppMethodBeat.o(290806);
  }
  
  /* Error */
  public static com.tencent.mm.plugin.textstatus.proto.bn V(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 188
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 189
    //   8: invokestatic 192	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 193
    //   14: invokestatic 192	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 194
    //   20: invokestatic 192	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokevirtual 198	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: new 200	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   34: ldc 203
    //   36: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 209
    //   45: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 219	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: aload_0
    //   56: ldc 221
    //   58: invokestatic 83	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   61: new 223	java/io/BufferedReader
    //   64: dup
    //   65: new 225	java/io/InputStreamReader
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 228	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   73: checkcast 230	java/io/Reader
    //   76: invokespecial 233	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore_3
    //   80: new 235	com/tencent/mm/plugin/textstatus/proto/bn
    //   83: dup
    //   84: invokespecial 236	com/tencent/mm/plugin/textstatus/proto/bn:<init>	()V
    //   87: astore_0
    //   88: aload_3
    //   89: invokevirtual 239	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +212 -> 308
    //   99: aload 4
    //   101: ifnull -13 -> 88
    //   104: new 241	com/tencent/mm/plugin/textstatus/proto/bm
    //   107: dup
    //   108: invokespecial 242	com/tencent/mm/plugin/textstatus/proto/bm:<init>	()V
    //   111: astore 5
    //   113: aload_1
    //   114: ldc 244
    //   116: invokestatic 248	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   119: ifeq +169 -> 288
    //   122: aload 4
    //   124: checkcast 250	java/lang/CharSequence
    //   127: iconst_1
    //   128: anewarray 252	java/lang/String
    //   131: dup
    //   132: iconst_0
    //   133: ldc 254
    //   135: aastore
    //   136: invokestatic 260	kotlin/n/n:b	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   139: astore 7
    //   141: new 200	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   148: astore 6
    //   150: aload 7
    //   152: invokeinterface 266 1 0
    //   157: astore 7
    //   159: aload 7
    //   161: invokeinterface 272 1 0
    //   166: ifeq +80 -> 246
    //   169: aload 6
    //   171: aload 7
    //   173: invokeinterface 276 1 0
    //   178: checkcast 252	java/lang/String
    //   181: bipush 16
    //   183: invokestatic 282	kotlin/n/a:aMy	(I)I
    //   186: invokestatic 288	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   189: invokestatic 294	java/lang/Character:toChars	(I)[C
    //   192: invokevirtual 297	java/lang/StringBuilder:append	([C)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: goto -37 -> 159
    //   199: astore_1
    //   200: ldc_w 299
    //   203: new 200	java/lang/StringBuilder
    //   206: dup
    //   207: ldc_w 301
    //   210: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload_2
    //   214: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: bipush 32
    //   219: invokevirtual 307	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 310	java/io/IOException:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_3
    //   236: invokevirtual 321	java/io/BufferedReader:close	()V
    //   239: ldc 188
    //   241: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload_0
    //   245: areturn
    //   246: aload 5
    //   248: aload 6
    //   250: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: putfield 325	com/tencent/mm/plugin/textstatus/proto/bm:content	Ljava/lang/String;
    //   256: aload 5
    //   258: aload 4
    //   260: putfield 328	com/tencent/mm/plugin/textstatus/proto/bm:Trr	Ljava/lang/String;
    //   263: aload_0
    //   264: getfield 332	com/tencent/mm/plugin/textstatus/proto/bn:Trs	Ljava/util/LinkedList;
    //   267: aload 5
    //   269: invokevirtual 335	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   272: pop
    //   273: goto -185 -> 88
    //   276: astore_0
    //   277: aload_3
    //   278: invokevirtual 321	java/io/BufferedReader:close	()V
    //   281: ldc 188
    //   283: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_0
    //   287: athrow
    //   288: aload_1
    //   289: ldc_w 337
    //   292: invokestatic 248	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   295: ifeq -32 -> 263
    //   298: aload 5
    //   300: aload 4
    //   302: putfield 325	com/tencent/mm/plugin/textstatus/proto/bm:content	Ljava/lang/String;
    //   305: goto -42 -> 263
    //   308: aload_3
    //   309: invokevirtual 321	java/io/BufferedReader:close	()V
    //   312: goto -73 -> 239
    //   315: astore_1
    //   316: ldc_w 299
    //   319: new 200	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 301
    //   326: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: aload_2
    //   330: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: bipush 32
    //   335: invokevirtual 307	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 310	java/io/IOException:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -112 -> 239
    //   354: astore_1
    //   355: ldc_w 299
    //   358: new 200	java/lang/StringBuilder
    //   361: dup
    //   362: ldc_w 301
    //   365: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload_2
    //   369: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: bipush 32
    //   374: invokevirtual 307	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   377: aload_1
    //   378: invokevirtual 310	java/io/IOException:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: goto -151 -> 239
    //   393: astore_1
    //   394: ldc_w 299
    //   397: new 200	java/lang/StringBuilder
    //   400: dup
    //   401: ldc_w 301
    //   404: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: aload_2
    //   408: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: bipush 32
    //   413: invokevirtual 307	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: aload_1
    //   417: invokevirtual 310	java/io/IOException:getMessage	()Ljava/lang/String;
    //   420: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: goto -148 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramContext	Context
    //   0	432	1	paramString1	String
    //   0	432	2	paramString2	String
    //   79	230	3	localBufferedReader	java.io.BufferedReader
    //   92	209	4	str	String
    //   111	188	5	localbm	com.tencent.mm.plugin.textstatus.proto.bm
    //   148	101	6	localStringBuilder	java.lang.StringBuilder
    //   139	33	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   88	94	199	java/io/IOException
    //   104	159	199	java/io/IOException
    //   159	196	199	java/io/IOException
    //   246	263	199	java/io/IOException
    //   263	273	199	java/io/IOException
    //   288	305	199	java/io/IOException
    //   88	94	276	finally
    //   104	159	276	finally
    //   159	196	276	finally
    //   200	235	276	finally
    //   246	263	276	finally
    //   263	273	276	finally
    //   288	305	276	finally
    //   308	312	315	java/io/IOException
    //   235	239	354	java/io/IOException
    //   277	281	393	java/io/IOException
  }
  
  public static String aIz(String paramString)
  {
    AppMethodBeat.i(290787);
    s.u(paramString, "emojiType");
    Object localObject = e.TAU;
    localObject = e.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(290787);
      return "emotion";
    }
    paramString = ((MultiProcessMMKV)localObject).getString(paramString, "emotion");
    if (paramString == null)
    {
      AppMethodBeat.o(290787);
      return "emotion";
    }
    AppMethodBeat.o(290787);
    return paramString;
  }
  
  public static ArrayList<f> bg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(290778);
    s.u(paramContext, "context");
    s.u(paramString, "typeName");
    if (s.p(paramString, "emoji"))
    {
      paramContext = Jyq;
      AppMethodBeat.o(290778);
      return paramContext;
    }
    paramContext = new ArrayList();
    AppMethodBeat.o(290778);
    return paramContext;
  }
  
  public static void jA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(290794);
    s.u(paramString1, "emojiType");
    s.u(paramString2, "subType");
    Object localObject = e.TAU;
    localObject = e.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(290794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.m
 * JD-Core Version:    0.7.0.1
 */