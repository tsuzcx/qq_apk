package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.e;
import java.util.HashMap;
import java.util.HashSet;

public class FilterPlus
{
  public static HashMap<Integer, String> FilterIdToResIdMap;
  private static final String TAG = "FilterPlus";
  public static HashSet<Integer> preInstallFilterId;
  private static HashMap<String, String> resIdSavePathMap;
  protected BaseFilter mFilter;
  
  static
  {
    AppMethodBeat.i(80645);
    resIdSavePathMap = new HashMap();
    preInstallFilterId = new FilterPlus.1();
    FilterIdToResIdMap = new FilterPlus.2();
    AppMethodBeat.o(80645);
  }
  
  public FilterPlus()
  {
    AppMethodBeat.i(80642);
    this.mFilter = e.createFilter(0);
    AppMethodBeat.o(80642);
  }
  
  /* Error */
  public static BaseFilter createFilter(int paramInt)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 67	com/tencent/view/b:BzJ	Z
    //   10: istore_1
    //   11: getstatic 39	com/tencent/ttpic/FilterPlus:preInstallFilterId	Ljava/util/HashSet;
    //   14: iload_0
    //   15: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 79	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   21: ifeq +448 -> 469
    //   24: iload_0
    //   25: lookupswitch	default:+565->590, 1014:+286->311, 1016:+200->225, 1061:+243->268, 1065:+329->354, 1078:+372->397, 1079:+372->397, 1080:+372->397, 1081:+372->397, 1086:+372->397, 1089:+372->397, 1093:+372->397, 1100:+372->397
    //   133: astore_2
    //   134: iload_0
    //   135: sipush 1078
    //   138: if_icmplt +63 -> 201
    //   141: aload_3
    //   142: astore_2
    //   143: iload_0
    //   144: sipush 1099
    //   147: if_icmpgt +54 -> 201
    //   150: new 81	com/tencent/filter/a/ab
    //   153: dup
    //   154: invokespecial 82	com/tencent/filter/a/ab:<init>	()V
    //   157: astore_2
    //   158: iconst_1
    //   159: putstatic 67	com/tencent/view/b:BzJ	Z
    //   162: getstatic 44	com/tencent/ttpic/FilterPlus:FilterIdToResIdMap	Ljava/util/HashMap;
    //   165: iload_0
    //   166: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: invokevirtual 86	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: checkcast 88	java/lang/String
    //   175: invokestatic 92	com/tencent/view/b:wv	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   178: astore_3
    //   179: iload_1
    //   180: putstatic 67	com/tencent/view/b:BzJ	Z
    //   183: aload_2
    //   184: new 94	com/tencent/filter/m$k
    //   187: dup
    //   188: ldc 96
    //   190: aload_3
    //   191: ldc 97
    //   193: iconst_1
    //   194: invokespecial 100	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   197: invokevirtual 106	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   200: pop
    //   201: aload_2
    //   202: astore_3
    //   203: aload_2
    //   204: ifnonnull +14 -> 218
    //   207: new 102	com/tencent/filter/BaseFilter
    //   210: dup
    //   211: getstatic 112	com/tencent/filter/GLSLRender:btg	I
    //   214: invokespecial 114	com/tencent/filter/BaseFilter:<init>	(I)V
    //   217: astore_3
    //   218: ldc 61
    //   220: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_3
    //   224: areturn
    //   225: new 81	com/tencent/filter/a/ab
    //   228: dup
    //   229: invokespecial 82	com/tencent/filter/a/ab:<init>	()V
    //   232: astore_2
    //   233: iconst_1
    //   234: putstatic 67	com/tencent/view/b:BzJ	Z
    //   237: ldc 116
    //   239: invokestatic 92	com/tencent/view/b:wv	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   242: astore_3
    //   243: iload_1
    //   244: putstatic 67	com/tencent/view/b:BzJ	Z
    //   247: aload_2
    //   248: new 94	com/tencent/filter/m$k
    //   251: dup
    //   252: ldc 96
    //   254: aload_3
    //   255: ldc 97
    //   257: iconst_1
    //   258: invokespecial 100	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   261: invokevirtual 106	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   264: pop
    //   265: goto -64 -> 201
    //   268: new 81	com/tencent/filter/a/ab
    //   271: dup
    //   272: invokespecial 82	com/tencent/filter/a/ab:<init>	()V
    //   275: astore_2
    //   276: iconst_1
    //   277: putstatic 67	com/tencent/view/b:BzJ	Z
    //   280: ldc 118
    //   282: invokestatic 92	com/tencent/view/b:wv	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   285: astore_3
    //   286: iload_1
    //   287: putstatic 67	com/tencent/view/b:BzJ	Z
    //   290: aload_2
    //   291: new 94	com/tencent/filter/m$k
    //   294: dup
    //   295: ldc 96
    //   297: aload_3
    //   298: ldc 97
    //   300: iconst_1
    //   301: invokespecial 100	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   304: invokevirtual 106	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   307: pop
    //   308: goto -107 -> 201
    //   311: new 81	com/tencent/filter/a/ab
    //   314: dup
    //   315: invokespecial 82	com/tencent/filter/a/ab:<init>	()V
    //   318: astore_2
    //   319: iconst_1
    //   320: putstatic 67	com/tencent/view/b:BzJ	Z
    //   323: ldc 120
    //   325: invokestatic 92	com/tencent/view/b:wv	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   328: astore_3
    //   329: iload_1
    //   330: putstatic 67	com/tencent/view/b:BzJ	Z
    //   333: aload_2
    //   334: new 94	com/tencent/filter/m$k
    //   337: dup
    //   338: ldc 96
    //   340: aload_3
    //   341: ldc 97
    //   343: iconst_1
    //   344: invokespecial 100	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   347: invokevirtual 106	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   350: pop
    //   351: goto -150 -> 201
    //   354: new 81	com/tencent/filter/a/ab
    //   357: dup
    //   358: invokespecial 82	com/tencent/filter/a/ab:<init>	()V
    //   361: astore_2
    //   362: iconst_1
    //   363: putstatic 67	com/tencent/view/b:BzJ	Z
    //   366: ldc 122
    //   368: invokestatic 92	com/tencent/view/b:wv	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   371: astore_3
    //   372: iload_1
    //   373: putstatic 67	com/tencent/view/b:BzJ	Z
    //   376: aload_2
    //   377: new 94	com/tencent/filter/m$k
    //   380: dup
    //   381: ldc 96
    //   383: aload_3
    //   384: ldc 97
    //   386: iconst_1
    //   387: invokespecial 100	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   390: invokevirtual 106	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   393: pop
    //   394: goto -193 -> 201
    //   397: aload_3
    //   398: astore_2
    //   399: iload_0
    //   400: sipush 1078
    //   403: if_icmplt -202 -> 201
    //   406: aload_3
    //   407: astore_2
    //   408: iload_0
    //   409: sipush 1099
    //   412: if_icmpgt -211 -> 201
    //   415: new 81	com/tencent/filter/a/ab
    //   418: dup
    //   419: invokespecial 82	com/tencent/filter/a/ab:<init>	()V
    //   422: astore_2
    //   423: iconst_1
    //   424: putstatic 67	com/tencent/view/b:BzJ	Z
    //   427: getstatic 44	com/tencent/ttpic/FilterPlus:FilterIdToResIdMap	Ljava/util/HashMap;
    //   430: iload_0
    //   431: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   434: invokevirtual 86	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   437: checkcast 88	java/lang/String
    //   440: invokestatic 92	com/tencent/view/b:wv	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   443: astore_3
    //   444: iload_1
    //   445: putstatic 67	com/tencent/view/b:BzJ	Z
    //   448: aload_2
    //   449: new 94	com/tencent/filter/m$k
    //   452: dup
    //   453: ldc 96
    //   455: aload_3
    //   456: ldc 97
    //   458: iconst_1
    //   459: invokespecial 100	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   462: invokevirtual 106	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   465: pop
    //   466: goto -265 -> 201
    //   469: new 81	com/tencent/filter/a/ab
    //   472: dup
    //   473: invokespecial 82	com/tencent/filter/a/ab:<init>	()V
    //   476: astore_2
    //   477: getstatic 34	com/tencent/ttpic/FilterPlus:resIdSavePathMap	Ljava/util/HashMap;
    //   480: getstatic 44	com/tencent/ttpic/FilterPlus:FilterIdToResIdMap	Ljava/util/HashMap;
    //   483: iload_0
    //   484: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   487: invokevirtual 86	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   490: invokevirtual 86	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   493: checkcast 88	java/lang/String
    //   496: astore_3
    //   497: aload_3
    //   498: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   501: ifne +86 -> 587
    //   504: aload_3
    //   505: invokestatic 131	com/tencent/view/b:axm	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   508: astore_3
    //   509: aload_3
    //   510: ifnonnull +8 -> 518
    //   513: aconst_null
    //   514: astore_2
    //   515: goto -314 -> 201
    //   518: aload_2
    //   519: new 94	com/tencent/filter/m$k
    //   522: dup
    //   523: ldc 96
    //   525: aload_3
    //   526: ldc 97
    //   528: iconst_1
    //   529: invokespecial 100	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   532: invokevirtual 106	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   535: pop
    //   536: goto -335 -> 201
    //   539: astore_3
    //   540: aconst_null
    //   541: astore_2
    //   542: new 133	java/lang/StringBuilder
    //   545: dup
    //   546: ldc 135
    //   548: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   551: aload_3
    //   552: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: goto -355 -> 201
    //   559: astore_3
    //   560: goto -18 -> 542
    //   563: astore_3
    //   564: goto -22 -> 542
    //   567: astore_3
    //   568: goto -26 -> 542
    //   571: astore_3
    //   572: goto -30 -> 542
    //   575: astore_3
    //   576: goto -34 -> 542
    //   579: astore_3
    //   580: goto -38 -> 542
    //   583: astore_3
    //   584: goto -42 -> 542
    //   587: goto -386 -> 201
    //   590: goto -458 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	paramInt	int
    //   10	435	1	bool	boolean
    //   133	409	2	localObject1	Object
    //   6	520	3	localObject2	Object
    //   539	13	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   559	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   563	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   567	1	3	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   571	1	3	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   575	1	3	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   579	1	3	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   583	1	3	localOutOfMemoryError8	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   11	24	539	java/lang/OutOfMemoryError
    //   150	158	539	java/lang/OutOfMemoryError
    //   225	233	539	java/lang/OutOfMemoryError
    //   268	276	539	java/lang/OutOfMemoryError
    //   311	319	539	java/lang/OutOfMemoryError
    //   354	362	539	java/lang/OutOfMemoryError
    //   415	423	539	java/lang/OutOfMemoryError
    //   469	477	539	java/lang/OutOfMemoryError
    //   233	265	559	java/lang/OutOfMemoryError
    //   276	308	563	java/lang/OutOfMemoryError
    //   319	351	567	java/lang/OutOfMemoryError
    //   362	394	571	java/lang/OutOfMemoryError
    //   423	466	575	java/lang/OutOfMemoryError
    //   158	201	579	java/lang/OutOfMemoryError
    //   477	509	583	java/lang/OutOfMemoryError
    //   518	536	583	java/lang/OutOfMemoryError
  }
  
  public static void setResSavePath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80643);
    resIdSavePathMap.put(paramString1, paramString2);
    AppMethodBeat.o(80643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.FilterPlus
 * JD-Core Version:    0.7.0.1
 */