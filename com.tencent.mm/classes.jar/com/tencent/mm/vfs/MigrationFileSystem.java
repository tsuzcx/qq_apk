package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;

public class MigrationFileSystem
  extends DelegateFileSystem
{
  public static final Parcelable.Creator<MigrationFileSystem> CREATOR;
  private final FileSystem[] HRf;
  private final String HSc;
  private final String HSd;
  private final String HSe;
  private final String HSf;
  List<FileSystem> HSg;
  private boolean HSh;
  private boolean HSi;
  
  static
  {
    AppMethodBeat.i(13141);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13141);
  }
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13131);
    q.a(paramParcel, MigrationFileSystem.class, 6);
    int j = paramParcel.readInt();
    this.HRf = new FileSystem[j];
    int i = 0;
    while (i < j)
    {
      FileSystem localFileSystem = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localFileSystem == null)
      {
        paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
        AppMethodBeat.o(13131);
        throw paramParcel;
      }
      this.HRf[i] = localFileSystem;
      i += 1;
    }
    this.HSc = paramParcel.readString();
    this.HSd = paramParcel.readString();
    this.HSe = paramParcel.readString();
    this.HSf = paramParcel.readString();
    this.HSg = Arrays.asList(this.HRf);
    AppMethodBeat.o(13131);
  }
  
  public MigrationFileSystem(FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    this(null, null, paramFileSystem, paramVarArgs);
  }
  
  public MigrationFileSystem(String paramString1, String paramString2, FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    this(paramString1, paramString2, null, paramFileSystem, paramVarArgs);
    AppMethodBeat.i(179552);
    AppMethodBeat.o(179552);
  }
  
  public MigrationFileSystem(String paramString1, String paramString2, String paramString3, FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    AppMethodBeat.i(186966);
    if (paramFileSystem == null)
    {
      paramString1 = new IllegalArgumentException("destination == null");
      AppMethodBeat.o(186966);
      throw paramString1;
    }
    this.HSc = paramString1;
    this.HSd = paramString2;
    this.HSe = paramString3;
    this.HSf = null;
    paramString1 = new FileSystem[paramVarArgs.length + 1];
    paramString1[0] = paramFileSystem;
    int i = 1;
    int m = paramVarArgs.length;
    int j = 0;
    if (j < m)
    {
      paramString2 = paramVarArgs[j];
      if (paramString2 == null) {
        break label159;
      }
      int k = i + 1;
      paramString1[i] = paramString2;
      i = k;
    }
    label159:
    for (;;)
    {
      j += 1;
      break;
      if (i == paramString1.length) {}
      for (;;)
      {
        this.HRf = paramString1;
        this.HSg = Arrays.asList(this.HRf);
        AppMethodBeat.o(186966);
        return;
        paramString1 = (FileSystem[])Arrays.copyOf(paramString1, i);
      }
    }
  }
  
  private static boolean t(List<FileSystem> paramList, String paramString)
  {
    AppMethodBeat.i(186967);
    paramString = q.aMW(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(186967);
      return false;
    }
    FileSystem localFileSystem = (FileSystem)paramList.get(0);
    if (localFileSystem.aMD(paramString))
    {
      AppMethodBeat.o(186967);
      return false;
    }
    int j = paramList.size();
    int i = 1;
    while (i < j)
    {
      FileSystem.a locala = ((FileSystem)paramList.get(i)).aME(paramString);
      if ((locala != null) && (locala.HRB))
      {
        boolean bool = localFileSystem.aMF(paramString);
        AppMethodBeat.o(186967);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(186967);
    return false;
  }
  
  /* Error */
  public final void a(android.os.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 13138
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 157	com/tencent/mm/vfs/MigrationFileSystem:HSh	Z
    //   10: ifeq +2242 -> 2252
    //   13: iconst_0
    //   14: istore 14
    //   16: iconst_0
    //   17: istore 11
    //   19: iconst_0
    //   20: istore 17
    //   22: iconst_0
    //   23: istore 4
    //   25: iconst_0
    //   26: istore 18
    //   28: iconst_0
    //   29: istore_2
    //   30: iconst_0
    //   31: istore 19
    //   33: iconst_0
    //   34: istore 10
    //   36: iconst_0
    //   37: istore 12
    //   39: iconst_0
    //   40: istore 20
    //   42: iconst_0
    //   43: istore 6
    //   45: iconst_0
    //   46: istore 13
    //   48: lconst_0
    //   49: lstore 21
    //   51: aload_0
    //   52: getfield 100	com/tencent/mm/vfs/MigrationFileSystem:HSg	Ljava/util/List;
    //   55: astore 30
    //   57: lload 21
    //   59: lstore 23
    //   61: iload 20
    //   63: istore 5
    //   65: iload 13
    //   67: istore 7
    //   69: iload 12
    //   71: istore 15
    //   73: iload 19
    //   75: istore 8
    //   77: iload 18
    //   79: istore 9
    //   81: iload 17
    //   83: istore_3
    //   84: iload 14
    //   86: istore 16
    //   88: aload 30
    //   90: iconst_0
    //   91: invokeinterface 129 2 0
    //   96: checkcast 55	com/tencent/mm/vfs/FileSystem
    //   99: astore 31
    //   101: lload 21
    //   103: lstore 23
    //   105: iload 20
    //   107: istore 5
    //   109: iload 13
    //   111: istore 7
    //   113: iload 12
    //   115: istore 15
    //   117: iload 19
    //   119: istore 8
    //   121: iload 18
    //   123: istore 9
    //   125: iload 17
    //   127: istore_3
    //   128: iload 14
    //   130: istore 16
    //   132: new 159	java/util/HashSet
    //   135: dup
    //   136: invokespecial 160	java/util/HashSet:<init>	()V
    //   139: astore 32
    //   141: lload 21
    //   143: lstore 23
    //   145: iload 20
    //   147: istore 5
    //   149: iload 13
    //   151: istore 7
    //   153: iload 12
    //   155: istore 15
    //   157: iload 19
    //   159: istore 8
    //   161: iload 18
    //   163: istore 9
    //   165: iload 17
    //   167: istore_3
    //   168: iload 14
    //   170: istore 16
    //   172: aload_1
    //   173: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   176: lload 21
    //   178: lstore 23
    //   180: iload 20
    //   182: istore 5
    //   184: iload 13
    //   186: istore 7
    //   188: iload 12
    //   190: istore 15
    //   192: iload 19
    //   194: istore 8
    //   196: iload 18
    //   198: istore 9
    //   200: iload 17
    //   202: istore_3
    //   203: iload 14
    //   205: istore 16
    //   207: aload_0
    //   208: iconst_1
    //   209: iconst_2
    //   210: anewarray 59	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: ldc 167
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload 31
    //   222: aastore
    //   223: invokevirtual 171	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   226: lload 21
    //   228: lstore 23
    //   230: iload 20
    //   232: istore 5
    //   234: iload 13
    //   236: istore 7
    //   238: iload 12
    //   240: istore 15
    //   242: iload 19
    //   244: istore 8
    //   246: iload 18
    //   248: istore 9
    //   250: iload 17
    //   252: istore_3
    //   253: iload 14
    //   255: istore 16
    //   257: aload 30
    //   259: invokeinterface 136 1 0
    //   264: istore 20
    //   266: iconst_1
    //   267: istore 18
    //   269: iconst_0
    //   270: istore_3
    //   271: iconst_0
    //   272: istore 5
    //   274: iload 18
    //   276: iload 20
    //   278: if_icmpge +1840 -> 2118
    //   281: aload_1
    //   282: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   285: aload 30
    //   287: iload 18
    //   289: invokeinterface 129 2 0
    //   294: checkcast 55	com/tencent/mm/vfs/FileSystem
    //   297: astore 33
    //   299: aload 33
    //   301: ldc 173
    //   303: iconst_1
    //   304: invokeinterface 177 3 0
    //   309: astore 29
    //   311: aload 29
    //   313: ifnull +1986 -> 2299
    //   316: aload 33
    //   318: invokeinterface 180 1 0
    //   323: bipush 9
    //   325: iand
    //   326: bipush 9
    //   328: if_icmpne +1974 -> 2302
    //   331: new 182	java/util/TreeSet
    //   334: dup
    //   335: invokespecial 183	java/util/TreeSet:<init>	()V
    //   338: astore 28
    //   340: aload 29
    //   342: invokeinterface 189 1 0
    //   347: astore 34
    //   349: iload 5
    //   351: istore 12
    //   353: iload_3
    //   354: istore 13
    //   356: lload 21
    //   358: lstore 23
    //   360: iload 6
    //   362: istore 5
    //   364: iload 13
    //   366: istore 7
    //   368: iload 12
    //   370: istore 15
    //   372: iload 10
    //   374: istore 8
    //   376: iload_2
    //   377: istore 9
    //   379: iload 4
    //   381: istore_3
    //   382: iload 11
    //   384: istore 16
    //   386: aload 34
    //   388: invokeinterface 195 1 0
    //   393: ifeq +1489 -> 1882
    //   396: lload 21
    //   398: lstore 23
    //   400: iload 6
    //   402: istore 5
    //   404: iload 13
    //   406: istore 7
    //   408: iload 12
    //   410: istore 15
    //   412: iload 10
    //   414: istore 8
    //   416: iload_2
    //   417: istore 9
    //   419: iload 4
    //   421: istore_3
    //   422: iload 11
    //   424: istore 16
    //   426: aload 34
    //   428: invokeinterface 199 1 0
    //   433: checkcast 142	com/tencent/mm/vfs/FileSystem$a
    //   436: astore 35
    //   438: lload 21
    //   440: lstore 23
    //   442: iload 6
    //   444: istore 5
    //   446: iload 13
    //   448: istore 7
    //   450: iload 12
    //   452: istore 15
    //   454: iload 10
    //   456: istore 8
    //   458: iload_2
    //   459: istore 9
    //   461: iload 4
    //   463: istore_3
    //   464: iload 11
    //   466: istore 16
    //   468: aload_1
    //   469: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   472: lload 21
    //   474: lstore 23
    //   476: iload 6
    //   478: istore 5
    //   480: iload 13
    //   482: istore 7
    //   484: iload 12
    //   486: istore 15
    //   488: iload 10
    //   490: istore 8
    //   492: iload_2
    //   493: istore 9
    //   495: iload 4
    //   497: istore_3
    //   498: iload 11
    //   500: istore 16
    //   502: aload 35
    //   504: getfield 145	com/tencent/mm/vfs/FileSystem$a:HRB	Z
    //   507: istore 27
    //   509: iload 27
    //   511: ifeq +433 -> 944
    //   514: lload 21
    //   516: lstore 23
    //   518: iload 6
    //   520: istore 5
    //   522: iload 13
    //   524: istore 7
    //   526: iload 12
    //   528: istore 15
    //   530: iload 10
    //   532: istore 8
    //   534: iload_2
    //   535: istore 9
    //   537: iload 4
    //   539: istore_3
    //   540: iload 11
    //   542: istore 16
    //   544: aload 31
    //   546: aload 35
    //   548: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   551: aload 33
    //   553: aload 35
    //   555: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   558: invokeinterface 205 4 0
    //   563: istore 27
    //   565: iload 27
    //   567: ifeq +53 -> 620
    //   570: lload 21
    //   572: lstore 23
    //   574: iload 6
    //   576: istore 5
    //   578: iload 13
    //   580: istore 7
    //   582: iload 12
    //   584: istore 15
    //   586: iload 10
    //   588: istore 8
    //   590: iload_2
    //   591: istore 9
    //   593: iload 4
    //   595: istore_3
    //   596: iload 11
    //   598: istore 16
    //   600: aload 32
    //   602: aload 35
    //   604: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   607: invokevirtual 209	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   610: pop
    //   611: iload 11
    //   613: iconst_1
    //   614: iadd
    //   615: istore 11
    //   617: goto -261 -> 356
    //   620: iload 4
    //   622: istore 14
    //   624: lload 21
    //   626: lstore 23
    //   628: iload 6
    //   630: istore 5
    //   632: iload 13
    //   634: istore 7
    //   636: iload 12
    //   638: istore 15
    //   640: iload 10
    //   642: istore 8
    //   644: iload_2
    //   645: istore 9
    //   647: iload 4
    //   649: istore_3
    //   650: iload 11
    //   652: istore 16
    //   654: aload 32
    //   656: aload 35
    //   658: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   661: invokevirtual 209	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   664: ifeq +52 -> 716
    //   667: lload 21
    //   669: lstore 23
    //   671: iload 6
    //   673: istore 5
    //   675: iload 13
    //   677: istore 7
    //   679: iload 12
    //   681: istore 15
    //   683: iload 10
    //   685: istore 8
    //   687: iload_2
    //   688: istore 9
    //   690: iload 4
    //   692: istore_3
    //   693: iload 11
    //   695: istore 16
    //   697: aload 31
    //   699: aload 35
    //   701: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   704: invokeinterface 148 2 0
    //   709: pop
    //   710: iload 4
    //   712: iconst_1
    //   713: iadd
    //   714: istore 14
    //   716: iload 14
    //   718: istore 4
    //   720: aload 28
    //   722: ifnull -366 -> 356
    //   725: lload 21
    //   727: lstore 23
    //   729: iload 6
    //   731: istore 5
    //   733: iload 13
    //   735: istore 7
    //   737: iload 12
    //   739: istore 15
    //   741: iload 10
    //   743: istore 8
    //   745: iload_2
    //   746: istore 9
    //   748: iload 14
    //   750: istore_3
    //   751: iload 11
    //   753: istore 16
    //   755: aload 28
    //   757: aload 35
    //   759: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   762: invokevirtual 210	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   765: pop
    //   766: iload 14
    //   768: istore 4
    //   770: goto -414 -> 356
    //   773: astore_1
    //   774: iload 16
    //   776: istore 11
    //   778: iload 9
    //   780: istore_2
    //   781: lload 23
    //   783: lstore 21
    //   785: aload_1
    //   786: instanceof 212
    //   789: ifeq +1475 -> 2264
    //   792: iconst_4
    //   793: istore 4
    //   795: aload_0
    //   796: iload 4
    //   798: bipush 18
    //   800: anewarray 59	java/lang/Object
    //   803: dup
    //   804: iconst_0
    //   805: ldc 167
    //   807: aastore
    //   808: dup
    //   809: iconst_1
    //   810: aload 30
    //   812: iconst_0
    //   813: invokeinterface 129 2 0
    //   818: aastore
    //   819: dup
    //   820: iconst_2
    //   821: ldc 214
    //   823: aastore
    //   824: dup
    //   825: iconst_3
    //   826: iload 11
    //   828: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   831: aastore
    //   832: dup
    //   833: iconst_4
    //   834: ldc 222
    //   836: aastore
    //   837: dup
    //   838: iconst_5
    //   839: iload_3
    //   840: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   843: aastore
    //   844: dup
    //   845: bipush 6
    //   847: ldc 224
    //   849: aastore
    //   850: dup
    //   851: bipush 7
    //   853: iload_2
    //   854: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   857: aastore
    //   858: dup
    //   859: bipush 8
    //   861: ldc 226
    //   863: aastore
    //   864: dup
    //   865: bipush 9
    //   867: iload 8
    //   869: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   872: aastore
    //   873: dup
    //   874: bipush 10
    //   876: ldc 228
    //   878: aastore
    //   879: dup
    //   880: bipush 11
    //   882: iload 5
    //   884: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   887: aastore
    //   888: dup
    //   889: bipush 12
    //   891: ldc 230
    //   893: aastore
    //   894: dup
    //   895: bipush 13
    //   897: iload 15
    //   899: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   902: aastore
    //   903: dup
    //   904: bipush 14
    //   906: ldc 232
    //   908: aastore
    //   909: dup
    //   910: bipush 15
    //   912: iload 7
    //   914: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   917: aastore
    //   918: dup
    //   919: bipush 16
    //   921: ldc 234
    //   923: aastore
    //   924: dup
    //   925: bipush 17
    //   927: lload 21
    //   929: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   932: aastore
    //   933: invokevirtual 171	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   936: sipush 13138
    //   939: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   942: aload_1
    //   943: athrow
    //   944: lload 21
    //   946: lstore 23
    //   948: iload 6
    //   950: istore 5
    //   952: iload 13
    //   954: istore 7
    //   956: iload 12
    //   958: istore 15
    //   960: iload 10
    //   962: istore 8
    //   964: iload_2
    //   965: istore 9
    //   967: iload 4
    //   969: istore_3
    //   970: iload 11
    //   972: istore 16
    //   974: aload 35
    //   976: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   979: invokestatic 123	com/tencent/mm/vfs/q:aMW	(Ljava/lang/String;)Ljava/lang/String;
    //   982: astore 29
    //   984: iload 4
    //   986: istore 17
    //   988: aload 29
    //   990: ifnull +144 -> 1134
    //   993: lload 21
    //   995: lstore 23
    //   997: iload 6
    //   999: istore 5
    //   1001: iload 13
    //   1003: istore 7
    //   1005: iload 12
    //   1007: istore 15
    //   1009: iload 10
    //   1011: istore 8
    //   1013: iload_2
    //   1014: istore 9
    //   1016: iload 4
    //   1018: istore_3
    //   1019: iload 11
    //   1021: istore 16
    //   1023: iload 4
    //   1025: istore 14
    //   1027: aload 32
    //   1029: aload 29
    //   1031: invokevirtual 209	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1034: ifeq +49 -> 1083
    //   1037: lload 21
    //   1039: lstore 23
    //   1041: iload 6
    //   1043: istore 5
    //   1045: iload 13
    //   1047: istore 7
    //   1049: iload 12
    //   1051: istore 15
    //   1053: iload 10
    //   1055: istore 8
    //   1057: iload_2
    //   1058: istore 9
    //   1060: iload 4
    //   1062: istore_3
    //   1063: iload 11
    //   1065: istore 16
    //   1067: aload 31
    //   1069: aload 29
    //   1071: invokeinterface 148 2 0
    //   1076: pop
    //   1077: iload 4
    //   1079: iconst_1
    //   1080: iadd
    //   1081: istore 14
    //   1083: iload 14
    //   1085: istore 17
    //   1087: aload 28
    //   1089: ifnull +45 -> 1134
    //   1092: lload 21
    //   1094: lstore 23
    //   1096: iload 6
    //   1098: istore 5
    //   1100: iload 13
    //   1102: istore 7
    //   1104: iload 12
    //   1106: istore 15
    //   1108: iload 10
    //   1110: istore 8
    //   1112: iload_2
    //   1113: istore 9
    //   1115: iload 14
    //   1117: istore_3
    //   1118: iload 11
    //   1120: istore 16
    //   1122: aload 28
    //   1124: aload 29
    //   1126: invokevirtual 210	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   1129: pop
    //   1130: iload 14
    //   1132: istore 17
    //   1134: lload 21
    //   1136: lstore 23
    //   1138: iload 6
    //   1140: istore 5
    //   1142: iload 13
    //   1144: istore 7
    //   1146: iload 12
    //   1148: istore 15
    //   1150: iload 10
    //   1152: istore 8
    //   1154: iload_2
    //   1155: istore 9
    //   1157: iload 17
    //   1159: istore_3
    //   1160: iload 11
    //   1162: istore 16
    //   1164: aload 31
    //   1166: aload 35
    //   1168: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1171: invokeinterface 133 2 0
    //   1176: ifeq +114 -> 1290
    //   1179: lload 21
    //   1181: lstore 23
    //   1183: iload 6
    //   1185: istore 5
    //   1187: iload 13
    //   1189: istore 7
    //   1191: iload 12
    //   1193: istore 15
    //   1195: iload 10
    //   1197: istore 8
    //   1199: iload_2
    //   1200: istore 9
    //   1202: iload 17
    //   1204: istore_3
    //   1205: iload 11
    //   1207: istore 16
    //   1209: aload 33
    //   1211: aload 35
    //   1213: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1216: invokeinterface 242 2 0
    //   1221: pop
    //   1222: iload 10
    //   1224: iconst_1
    //   1225: iadd
    //   1226: istore 10
    //   1228: lload 21
    //   1230: lstore 23
    //   1232: iload 6
    //   1234: istore 5
    //   1236: iload 13
    //   1238: istore 7
    //   1240: iload 12
    //   1242: istore 15
    //   1244: iload 10
    //   1246: istore 8
    //   1248: iload_2
    //   1249: istore 9
    //   1251: iload 17
    //   1253: istore_3
    //   1254: iload 11
    //   1256: istore 16
    //   1258: ldc 244
    //   1260: new 246	java/lang/StringBuilder
    //   1263: dup
    //   1264: ldc 248
    //   1266: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1269: aload 35
    //   1271: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1274: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 262	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   1283: iload 17
    //   1285: istore 4
    //   1287: goto -931 -> 356
    //   1290: lload 21
    //   1292: lstore 23
    //   1294: iload 6
    //   1296: istore 5
    //   1298: iload 13
    //   1300: istore 7
    //   1302: iload 12
    //   1304: istore 15
    //   1306: iload 10
    //   1308: istore 8
    //   1310: iload_2
    //   1311: istore 9
    //   1313: iload 17
    //   1315: istore_3
    //   1316: iload 11
    //   1318: istore 16
    //   1320: iload 6
    //   1322: istore 14
    //   1324: aload 31
    //   1326: aload 35
    //   1328: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1331: aload 33
    //   1333: aload 35
    //   1335: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1338: invokeinterface 205 4 0
    //   1343: ifeq +76 -> 1419
    //   1346: lload 21
    //   1348: lstore 23
    //   1350: iload 6
    //   1352: istore 5
    //   1354: iload 13
    //   1356: istore 7
    //   1358: iload 12
    //   1360: istore 15
    //   1362: iload 10
    //   1364: istore 8
    //   1366: iload_2
    //   1367: istore 9
    //   1369: iload 17
    //   1371: istore_3
    //   1372: iload 11
    //   1374: istore 16
    //   1376: iload 6
    //   1378: istore 14
    //   1380: ldc 244
    //   1382: new 246	java/lang/StringBuilder
    //   1385: dup
    //   1386: ldc_w 264
    //   1389: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1392: aload 35
    //   1394: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1397: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 262	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   1406: iload 12
    //   1408: iconst_1
    //   1409: iadd
    //   1410: istore 12
    //   1412: iload 17
    //   1414: istore 4
    //   1416: goto -1060 -> 356
    //   1419: lload 21
    //   1421: lstore 23
    //   1423: iload 6
    //   1425: istore 5
    //   1427: iload 13
    //   1429: istore 7
    //   1431: iload 12
    //   1433: istore 15
    //   1435: iload 10
    //   1437: istore 8
    //   1439: iload_2
    //   1440: istore 9
    //   1442: iload 17
    //   1444: istore_3
    //   1445: iload 11
    //   1447: istore 16
    //   1449: iload 6
    //   1451: istore 14
    //   1453: aload_0
    //   1454: getfield 266	com/tencent/mm/vfs/MigrationFileSystem:HSi	Z
    //   1457: ifne +835 -> 2292
    //   1460: lload 21
    //   1462: lstore 23
    //   1464: iload 6
    //   1466: istore 5
    //   1468: iload 13
    //   1470: istore 7
    //   1472: iload 12
    //   1474: istore 15
    //   1476: iload 10
    //   1478: istore 8
    //   1480: iload_2
    //   1481: istore 9
    //   1483: iload 17
    //   1485: istore_3
    //   1486: iload 11
    //   1488: istore 16
    //   1490: iload 6
    //   1492: istore 14
    //   1494: aload 31
    //   1496: aload 35
    //   1498: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1501: aload 33
    //   1503: aload 35
    //   1505: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1508: invokeinterface 270 4 0
    //   1513: pop2
    //   1514: lload 21
    //   1516: lstore 23
    //   1518: iload 6
    //   1520: istore 5
    //   1522: iload 13
    //   1524: istore 7
    //   1526: iload 12
    //   1528: istore 15
    //   1530: iload 10
    //   1532: istore 8
    //   1534: iload_2
    //   1535: istore 9
    //   1537: iload 17
    //   1539: istore_3
    //   1540: iload 11
    //   1542: istore 16
    //   1544: iload 6
    //   1546: istore 14
    //   1548: aload 33
    //   1550: aload 35
    //   1552: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1555: invokeinterface 242 2 0
    //   1560: pop
    //   1561: lload 21
    //   1563: lstore 23
    //   1565: iload 6
    //   1567: istore 5
    //   1569: iload 13
    //   1571: istore 7
    //   1573: iload 12
    //   1575: istore 15
    //   1577: iload 10
    //   1579: istore 8
    //   1581: iload_2
    //   1582: istore 9
    //   1584: iload 17
    //   1586: istore_3
    //   1587: iload 11
    //   1589: istore 16
    //   1591: iload 6
    //   1593: istore 14
    //   1595: ldc 244
    //   1597: new 246	java/lang/StringBuilder
    //   1600: dup
    //   1601: ldc_w 272
    //   1604: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1607: aload 35
    //   1609: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1612: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: invokestatic 262	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   1621: iload 6
    //   1623: iconst_1
    //   1624: iadd
    //   1625: istore 4
    //   1627: lload 21
    //   1629: lstore 23
    //   1631: iload 4
    //   1633: istore 5
    //   1635: iload 13
    //   1637: istore 7
    //   1639: iload 12
    //   1641: istore 15
    //   1643: iload 10
    //   1645: istore 8
    //   1647: iload_2
    //   1648: istore 9
    //   1650: iload 17
    //   1652: istore_3
    //   1653: iload 11
    //   1655: istore 16
    //   1657: iload 4
    //   1659: istore 14
    //   1661: aload 35
    //   1663: getfield 276	com/tencent/mm/vfs/FileSystem$a:HRz	J
    //   1666: lstore 25
    //   1668: lload 25
    //   1670: lload 21
    //   1672: ladd
    //   1673: lstore 21
    //   1675: iload 4
    //   1677: istore 6
    //   1679: iload 17
    //   1681: istore 4
    //   1683: goto -1327 -> 356
    //   1686: astore 36
    //   1688: iload 13
    //   1690: iconst_1
    //   1691: iadd
    //   1692: istore 19
    //   1694: lload 21
    //   1696: lstore 23
    //   1698: iload 14
    //   1700: istore 5
    //   1702: iload 19
    //   1704: istore 7
    //   1706: iload 12
    //   1708: istore 15
    //   1710: iload 10
    //   1712: istore 8
    //   1714: iload_2
    //   1715: istore 9
    //   1717: iload 17
    //   1719: istore_3
    //   1720: iload 11
    //   1722: istore 16
    //   1724: ldc_w 278
    //   1727: new 246	java/lang/StringBuilder
    //   1730: dup
    //   1731: ldc_w 280
    //   1734: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1737: aload 35
    //   1739: getfield 202	com/tencent/mm/vfs/FileSystem$a:EQk	Ljava/lang/String;
    //   1742: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: ldc_w 282
    //   1748: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: aload_0
    //   1752: invokevirtual 283	com/tencent/mm/vfs/MigrationFileSystem:toString	()Ljava/lang/String;
    //   1755: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1758: ldc_w 285
    //   1761: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1767: invokestatic 288	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1770: iload 14
    //   1772: istore 6
    //   1774: iload 19
    //   1776: istore 13
    //   1778: iload 17
    //   1780: istore 4
    //   1782: aload 28
    //   1784: ifnull -1428 -> 356
    //   1787: iload 14
    //   1789: istore 6
    //   1791: iload 19
    //   1793: istore 13
    //   1795: iload 17
    //   1797: istore 4
    //   1799: aload 29
    //   1801: ifnull -1445 -> 356
    //   1804: lload 21
    //   1806: lstore 23
    //   1808: iload 14
    //   1810: istore 5
    //   1812: iload 19
    //   1814: istore 7
    //   1816: iload 12
    //   1818: istore 15
    //   1820: iload 10
    //   1822: istore 8
    //   1824: iload_2
    //   1825: istore 9
    //   1827: iload 17
    //   1829: istore_3
    //   1830: iload 11
    //   1832: istore 16
    //   1834: aload 28
    //   1836: aload 29
    //   1838: invokevirtual 291	java/util/TreeSet:remove	(Ljava/lang/Object;)Z
    //   1841: pop
    //   1842: lload 21
    //   1844: lstore 23
    //   1846: iload 14
    //   1848: istore 5
    //   1850: iload 19
    //   1852: istore 7
    //   1854: iload 12
    //   1856: istore 15
    //   1858: iload 10
    //   1860: istore 8
    //   1862: iload_2
    //   1863: istore 9
    //   1865: iload 17
    //   1867: istore_3
    //   1868: iload 11
    //   1870: istore 16
    //   1872: aload 29
    //   1874: invokestatic 123	com/tencent/mm/vfs/q:aMW	(Ljava/lang/String;)Ljava/lang/String;
    //   1877: astore 29
    //   1879: goto -92 -> 1787
    //   1882: iload_2
    //   1883: istore 14
    //   1885: aload 28
    //   1887: ifnull +212 -> 2099
    //   1890: lload 21
    //   1892: lstore 23
    //   1894: iload 6
    //   1896: istore 5
    //   1898: iload 13
    //   1900: istore 7
    //   1902: iload 12
    //   1904: istore 15
    //   1906: iload 10
    //   1908: istore 8
    //   1910: iload_2
    //   1911: istore 9
    //   1913: iload 4
    //   1915: istore_3
    //   1916: iload 11
    //   1918: istore 16
    //   1920: aload 28
    //   1922: invokevirtual 295	java/util/TreeSet:descendingSet	()Ljava/util/NavigableSet;
    //   1925: invokeinterface 298 1 0
    //   1930: astore 28
    //   1932: lload 21
    //   1934: lstore 23
    //   1936: iload 6
    //   1938: istore 5
    //   1940: iload 13
    //   1942: istore 7
    //   1944: iload 12
    //   1946: istore 15
    //   1948: iload 10
    //   1950: istore 8
    //   1952: iload_2
    //   1953: istore 9
    //   1955: iload 4
    //   1957: istore_3
    //   1958: iload 11
    //   1960: istore 16
    //   1962: iload_2
    //   1963: istore 14
    //   1965: aload 28
    //   1967: invokeinterface 195 1 0
    //   1972: ifeq +127 -> 2099
    //   1975: lload 21
    //   1977: lstore 23
    //   1979: iload 6
    //   1981: istore 5
    //   1983: iload 13
    //   1985: istore 7
    //   1987: iload 12
    //   1989: istore 15
    //   1991: iload 10
    //   1993: istore 8
    //   1995: iload_2
    //   1996: istore 9
    //   1998: iload 4
    //   2000: istore_3
    //   2001: iload 11
    //   2003: istore 16
    //   2005: aload 28
    //   2007: invokeinterface 199 1 0
    //   2012: checkcast 300	java/lang/String
    //   2015: astore 29
    //   2017: lload 21
    //   2019: lstore 23
    //   2021: iload 6
    //   2023: istore 5
    //   2025: iload 13
    //   2027: istore 7
    //   2029: iload 12
    //   2031: istore 15
    //   2033: iload 10
    //   2035: istore 8
    //   2037: iload_2
    //   2038: istore 9
    //   2040: iload 4
    //   2042: istore_3
    //   2043: iload 11
    //   2045: istore 16
    //   2047: aload_1
    //   2048: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   2051: lload 21
    //   2053: lstore 23
    //   2055: iload 6
    //   2057: istore 5
    //   2059: iload 13
    //   2061: istore 7
    //   2063: iload 12
    //   2065: istore 15
    //   2067: iload 10
    //   2069: istore 8
    //   2071: iload_2
    //   2072: istore 9
    //   2074: iload 4
    //   2076: istore_3
    //   2077: iload 11
    //   2079: istore 16
    //   2081: aload 33
    //   2083: aload 29
    //   2085: iconst_0
    //   2086: invokeinterface 304 3 0
    //   2091: pop
    //   2092: iload_2
    //   2093: iconst_1
    //   2094: iadd
    //   2095: istore_2
    //   2096: goto -164 -> 1932
    //   2099: iload 13
    //   2101: istore_3
    //   2102: iload 12
    //   2104: istore 5
    //   2106: iload 14
    //   2108: istore_2
    //   2109: iload 18
    //   2111: iconst_1
    //   2112: iadd
    //   2113: istore 18
    //   2115: goto -1841 -> 274
    //   2118: aload_0
    //   2119: iconst_3
    //   2120: bipush 18
    //   2122: anewarray 59	java/lang/Object
    //   2125: dup
    //   2126: iconst_0
    //   2127: ldc 167
    //   2129: aastore
    //   2130: dup
    //   2131: iconst_1
    //   2132: aload 31
    //   2134: aastore
    //   2135: dup
    //   2136: iconst_2
    //   2137: ldc 214
    //   2139: aastore
    //   2140: dup
    //   2141: iconst_3
    //   2142: iload 11
    //   2144: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2147: aastore
    //   2148: dup
    //   2149: iconst_4
    //   2150: ldc 222
    //   2152: aastore
    //   2153: dup
    //   2154: iconst_5
    //   2155: iload 4
    //   2157: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2160: aastore
    //   2161: dup
    //   2162: bipush 6
    //   2164: ldc 224
    //   2166: aastore
    //   2167: dup
    //   2168: bipush 7
    //   2170: iload_2
    //   2171: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2174: aastore
    //   2175: dup
    //   2176: bipush 8
    //   2178: ldc 226
    //   2180: aastore
    //   2181: dup
    //   2182: bipush 9
    //   2184: iload 10
    //   2186: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2189: aastore
    //   2190: dup
    //   2191: bipush 10
    //   2193: ldc 228
    //   2195: aastore
    //   2196: dup
    //   2197: bipush 11
    //   2199: iload 6
    //   2201: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2204: aastore
    //   2205: dup
    //   2206: bipush 12
    //   2208: ldc 230
    //   2210: aastore
    //   2211: dup
    //   2212: bipush 13
    //   2214: iload 5
    //   2216: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2219: aastore
    //   2220: dup
    //   2221: bipush 14
    //   2223: ldc 232
    //   2225: aastore
    //   2226: dup
    //   2227: bipush 15
    //   2229: iload_3
    //   2230: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2233: aastore
    //   2234: dup
    //   2235: bipush 16
    //   2237: ldc 234
    //   2239: aastore
    //   2240: dup
    //   2241: bipush 17
    //   2243: lload 21
    //   2245: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2248: aastore
    //   2249: invokevirtual 171	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   2252: aload_0
    //   2253: aload_1
    //   2254: invokespecial 306	com/tencent/mm/vfs/DelegateFileSystem:a	(Landroid/os/CancellationSignal;)V
    //   2257: sipush 13138
    //   2260: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2263: return
    //   2264: iconst_5
    //   2265: istore 4
    //   2267: goto -1472 -> 795
    //   2270: astore_1
    //   2271: iload 5
    //   2273: istore 15
    //   2275: iload 6
    //   2277: istore 5
    //   2279: iload_3
    //   2280: istore 7
    //   2282: iload 10
    //   2284: istore 8
    //   2286: iload 4
    //   2288: istore_3
    //   2289: goto -1504 -> 785
    //   2292: iload 6
    //   2294: istore 4
    //   2296: goto -621 -> 1675
    //   2299: goto -190 -> 2109
    //   2302: aconst_null
    //   2303: astore 28
    //   2305: goto -1965 -> 340
    //   2308: astore 29
    //   2310: iconst_0
    //   2311: istore 27
    //   2313: goto -1748 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2316	0	this	MigrationFileSystem
    //   0	2316	1	paramCancellationSignal	android.os.CancellationSignal
    //   29	2142	2	i	int
    //   83	2206	3	j	int
    //   23	2272	4	k	int
    //   63	2215	5	m	int
    //   43	2250	6	n	int
    //   67	2214	7	i1	int
    //   75	2210	8	i2	int
    //   79	1994	9	i3	int
    //   34	2249	10	i4	int
    //   17	2126	11	i5	int
    //   37	2066	12	i6	int
    //   46	2054	13	i7	int
    //   14	2093	14	i8	int
    //   71	2203	15	i9	int
    //   86	1994	16	i10	int
    //   20	1846	17	i11	int
    //   26	2088	18	i12	int
    //   31	1820	19	i13	int
    //   40	239	20	i14	int
    //   49	2195	21	l1	long
    //   59	1995	23	l2	long
    //   1666	3	25	l3	long
    //   507	1805	27	bool	boolean
    //   338	1966	28	localObject1	Object
    //   309	1775	29	localObject2	Object
    //   2308	1	29	localIOException1	java.io.IOException
    //   55	756	30	localList	List
    //   99	2034	31	localFileSystem1	FileSystem
    //   139	889	32	localHashSet	HashSet
    //   297	1785	33	localFileSystem2	FileSystem
    //   347	80	34	localIterator	Iterator
    //   436	1302	35	locala	FileSystem.a
    //   1686	1	36	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   88	101	773	java/lang/Exception
    //   132	141	773	java/lang/Exception
    //   172	176	773	java/lang/Exception
    //   207	226	773	java/lang/Exception
    //   257	266	773	java/lang/Exception
    //   386	396	773	java/lang/Exception
    //   426	438	773	java/lang/Exception
    //   468	472	773	java/lang/Exception
    //   502	509	773	java/lang/Exception
    //   544	565	773	java/lang/Exception
    //   600	611	773	java/lang/Exception
    //   654	667	773	java/lang/Exception
    //   697	710	773	java/lang/Exception
    //   755	766	773	java/lang/Exception
    //   974	984	773	java/lang/Exception
    //   1027	1037	773	java/lang/Exception
    //   1067	1077	773	java/lang/Exception
    //   1122	1130	773	java/lang/Exception
    //   1164	1179	773	java/lang/Exception
    //   1209	1222	773	java/lang/Exception
    //   1258	1283	773	java/lang/Exception
    //   1324	1346	773	java/lang/Exception
    //   1380	1406	773	java/lang/Exception
    //   1453	1460	773	java/lang/Exception
    //   1494	1514	773	java/lang/Exception
    //   1548	1561	773	java/lang/Exception
    //   1595	1621	773	java/lang/Exception
    //   1661	1668	773	java/lang/Exception
    //   1724	1770	773	java/lang/Exception
    //   1834	1842	773	java/lang/Exception
    //   1872	1879	773	java/lang/Exception
    //   1920	1932	773	java/lang/Exception
    //   1965	1975	773	java/lang/Exception
    //   2005	2017	773	java/lang/Exception
    //   2047	2051	773	java/lang/Exception
    //   2081	2092	773	java/lang/Exception
    //   1324	1346	1686	java/io/IOException
    //   1380	1406	1686	java/io/IOException
    //   1453	1460	1686	java/io/IOException
    //   1494	1514	1686	java/io/IOException
    //   1548	1561	1686	java/io/IOException
    //   1595	1621	1686	java/io/IOException
    //   1661	1668	1686	java/io/IOException
    //   281	311	2270	java/lang/Exception
    //   316	340	2270	java/lang/Exception
    //   340	349	2270	java/lang/Exception
    //   2118	2252	2270	java/lang/Exception
    //   544	565	2308	java/io/IOException
  }
  
  public final boolean a(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(186968);
    boolean bool = super.a(paramString1, paramFileSystem, paramString2);
    if ((!bool) && (t(this.HSg, paramString1)))
    {
      bool = super.a(paramString1, paramFileSystem, paramString2);
      AppMethodBeat.o(186968);
      return bool;
    }
    AppMethodBeat.o(186968);
    return bool;
  }
  
  public final ReadableByteChannel aMA(String paramString)
  {
    AppMethodBeat.i(13134);
    Object localObject = this.HSg;
    FileNotFoundException localFileNotFoundException1 = null;
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label72;
      }
      localObject = (FileSystem)localIterator.next();
      try
      {
        localObject = ((FileSystem)localObject).aMA(paramString);
        if (localObject != null)
        {
          AppMethodBeat.o(13134);
          return localObject;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        if (localFileNotFoundException1 != null) {
          break label115;
        }
      }
    }
    localFileNotFoundException1 = localFileNotFoundException2;
    label72:
    label115:
    for (;;)
    {
      break;
      if (localFileNotFoundException1 != null) {}
      for (;;)
      {
        AppMethodBeat.o(13134);
        throw localFileNotFoundException1;
        localFileNotFoundException1 = new FileNotFoundException(paramString + " not found on any file systems.");
      }
    }
  }
  
  public final boolean aMD(String paramString)
  {
    AppMethodBeat.i(13135);
    Iterator localIterator = this.HSg.iterator();
    while (localIterator.hasNext()) {
      if (((FileSystem)localIterator.next()).aMD(paramString))
      {
        AppMethodBeat.o(13135);
        return true;
      }
    }
    AppMethodBeat.o(13135);
    return false;
  }
  
  public final FileSystem.a aME(String paramString)
  {
    AppMethodBeat.i(13136);
    Iterator localIterator = this.HSg.iterator();
    while (localIterator.hasNext())
    {
      FileSystem.a locala = ((FileSystem)localIterator.next()).aME(paramString);
      if (locala != null)
      {
        AppMethodBeat.o(13136);
        return locala;
      }
    }
    AppMethodBeat.o(13136);
    return null;
  }
  
  public final void bN(Map<String, String> paramMap)
  {
    AppMethodBeat.i(13137);
    boolean bool1;
    int j;
    label33:
    int i;
    if (q.P(this.HSc, paramMap) != null)
    {
      bool1 = true;
      if (q.P(this.HSd, paramMap) == null) {
        break label107;
      }
      j = 1;
      if (q.P(this.HSe, paramMap) == null) {
        break label112;
      }
      i = 1;
      label46:
      if (q.P(this.HSf, paramMap) == null) {
        break label117;
      }
    }
    label107:
    label112:
    label117:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject1 = this.HRf;
      int m = localObject1.length;
      int k = 0;
      while (k < m)
      {
        localObject1[k].bN(paramMap);
        k += 1;
      }
      bool1 = false;
      break;
      j = 0;
      break label33;
      i = 0;
      break label46;
    }
    ArrayList localArrayList = new ArrayList(this.HRf.length);
    localArrayList.add(this.HRf[0]);
    HashSet localHashSet = new HashSet();
    Object localObject1 = null;
    paramMap = (Map<String, String>)localObject1;
    Object localObject2;
    if ((this.HRf[0] instanceof NativeFileSystem))
    {
      localObject2 = ((NativeFileSystem)this.HRf[0]).HSl;
      paramMap = (Map<String, String>)localObject1;
      if (localObject2 != null)
      {
        if (j == 0) {
          break label483;
        }
        localObject1 = new File((String)localObject2);
        paramMap = (Map<String, String>)localObject1;
        if (!((File)localObject1).exists()) {}
      }
    }
    label483:
    for (paramMap = null;; paramMap = null)
    {
      localHashSet.add(localObject2);
      j = 1;
      if (j < this.HRf.length)
      {
        if (!(this.HRf[j] instanceof NativeFileSystem)) {
          localArrayList.add(this.HRf[j]);
        }
        for (;;)
        {
          j += 1;
          break;
          NativeFileSystem localNativeFileSystem = (NativeFileSystem)this.HRf[j];
          String str = localNativeFileSystem.HSl;
          localObject2 = paramMap;
          if (str != null)
          {
            localObject2 = new File(str);
            boolean bool3 = ((File)localObject2).isDirectory();
            localObject1 = paramMap;
            if (bool3)
            {
              localObject1 = paramMap;
              if (paramMap != null)
              {
                localObject1 = paramMap;
                if (((File)localObject2).renameTo(paramMap))
                {
                  Log.i("VFS.MigrationFileSystem", "Fast moved '" + localObject2 + "' -> '" + paramMap + "'");
                  paramMap = null;
                  localObject1 = paramMap;
                  if (i == 0)
                  {
                    localHashSet.add(str);
                    localObject1 = paramMap;
                  }
                }
              }
            }
            if (!bool3)
            {
              localObject2 = localObject1;
              if (i == 0) {}
            }
            else
            {
              localObject2 = localObject1;
              if (localHashSet.add(str))
              {
                localArrayList.add(localNativeFileSystem);
                localObject2 = localObject1;
              }
            }
          }
          paramMap = (Map<String, String>)localObject2;
        }
      }
      this.HSg = localArrayList;
      this.HSh = bool1;
      this.HSi = bool2;
      AppMethodBeat.o(13137);
      return;
    }
  }
  
  public final long c(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(186969);
    try
    {
      l = super.c(paramString1, paramFileSystem, paramString2);
      AppMethodBeat.o(186969);
      return l;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      long l;
      if (t(this.HSg, paramString1))
      {
        l = super.c(paramString1, paramFileSystem, paramString2);
        AppMethodBeat.o(186969);
        return l;
      }
      AppMethodBeat.o(186969);
      throw localFileNotFoundException;
    }
  }
  
  public final WritableByteChannel cL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(170156);
    List localList = this.HSg;
    FileSystem localFileSystem = (FileSystem)localList.get(0);
    try
    {
      WritableByteChannel localWritableByteChannel = localFileSystem.cL(paramString, paramBoolean);
      AppMethodBeat.o(170156);
      return localWritableByteChannel;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if ((!paramBoolean) && (t(localList, paramString)))
      {
        paramString = localFileSystem.cL(paramString, false);
        AppMethodBeat.o(170156);
        return paramString;
      }
      AppMethodBeat.o(170156);
      throw localFileNotFoundException;
    }
  }
  
  public final OutputStream cM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(170155);
    List localList = this.HSg;
    FileSystem localFileSystem = (FileSystem)localList.get(0);
    try
    {
      OutputStream localOutputStream = localFileSystem.cM(paramString, paramBoolean);
      AppMethodBeat.o(170155);
      return localOutputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if ((!paramBoolean) && (t(localList, paramString)))
      {
        paramString = localFileSystem.cM(paramString, false);
        AppMethodBeat.o(170155);
        return paramString;
      }
      AppMethodBeat.o(170155);
      throw localFileNotFoundException;
    }
  }
  
  protected final Iterable<FileSystem> fhB()
  {
    return this.HSg;
  }
  
  public final boolean fhN()
  {
    AppMethodBeat.i(186970);
    Iterator localIterator = this.HSg.subList(1, this.HSg.size()).iterator();
    while (localIterator.hasNext())
    {
      Iterable localIterable = ((FileSystem)localIterator.next()).cN("", false);
      if ((localIterable != null) && (localIterable.iterator().hasNext()))
      {
        AppMethodBeat.o(186970);
        return false;
      }
    }
    AppMethodBeat.o(186970);
    return true;
  }
  
  protected final FileSystem gj(String paramString, int paramInt)
  {
    AppMethodBeat.i(13132);
    List localList = this.HSg;
    if ((paramInt == 1) || (paramInt == 3))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FileSystem localFileSystem = (FileSystem)localIterator.next();
        if (localFileSystem.aMD(paramString))
        {
          AppMethodBeat.o(13132);
          return localFileSystem;
        }
      }
    }
    paramString = (FileSystem)localList.get(0);
    AppMethodBeat.o(13132);
    return paramString;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(13133);
    Object localObject = this.HSg;
    FileNotFoundException localFileNotFoundException1 = null;
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label72;
      }
      localObject = (FileSystem)localIterator.next();
      try
      {
        localObject = ((FileSystem)localObject).openRead(paramString);
        if (localObject != null)
        {
          AppMethodBeat.o(13133);
          return localObject;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        if (localFileNotFoundException1 != null) {
          break label115;
        }
      }
    }
    localFileNotFoundException1 = localFileNotFoundException2;
    label72:
    label115:
    for (;;)
    {
      break;
      if (localFileNotFoundException1 != null) {}
      for (;;)
      {
        AppMethodBeat.o(13133);
        throw localFileNotFoundException1;
        localFileNotFoundException1 = new FileNotFoundException(paramString + " not found on any file systems.");
      }
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(13139);
    Object localObject = new StringBuilder("Migration [(");
    if (this.HSh) {
      ((StringBuilder)localObject).append('P');
    }
    if (this.HSi) {
      ((StringBuilder)localObject).append('N');
    }
    ((StringBuilder)localObject).append(") ").append(((FileSystem)this.HSg.get(0)).toString()).append(" <= ");
    int i = 1;
    while (i < this.HSg.size())
    {
      ((StringBuilder)localObject).append(((FileSystem)this.HSg.get(i)).toString()).append(", ");
      i += 1;
    }
    ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
    localObject = ']';
    AppMethodBeat.o(13139);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13140);
    q.b(paramParcel, MigrationFileSystem.class, 6);
    paramParcel.writeInt(this.HRf.length);
    FileSystem[] arrayOfFileSystem = this.HRf;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    paramParcel.writeString(this.HSc);
    paramParcel.writeString(this.HSd);
    paramParcel.writeString(this.HSe);
    paramParcel.writeString(this.HSf);
    AppMethodBeat.o(13140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */