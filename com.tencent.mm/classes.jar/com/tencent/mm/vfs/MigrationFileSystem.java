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
  private final FileSystem[] Ljr;
  private final String Lkm;
  private final String Lkn;
  private final String Lko;
  private final String Lkp;
  List<FileSystem> Lkq;
  private boolean Lkr;
  private boolean Lks;
  
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
    this.Ljr = new FileSystem[j];
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
      this.Ljr[i] = localFileSystem;
      i += 1;
    }
    this.Lkm = paramParcel.readString();
    this.Lkn = paramParcel.readString();
    this.Lko = paramParcel.readString();
    this.Lkp = paramParcel.readString();
    this.Lkq = Arrays.asList(this.Ljr);
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
    AppMethodBeat.i(190381);
    if (paramFileSystem == null)
    {
      paramString1 = new IllegalArgumentException("destination == null");
      AppMethodBeat.o(190381);
      throw paramString1;
    }
    this.Lkm = paramString1;
    this.Lkn = paramString2;
    this.Lko = paramString3;
    this.Lkp = null;
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
        this.Ljr = paramString1;
        this.Lkq = Arrays.asList(this.Ljr);
        AppMethodBeat.o(190381);
        return;
        paramString1 = (FileSystem[])Arrays.copyOf(paramString1, i);
      }
    }
  }
  
  private static boolean t(List<FileSystem> paramList, String paramString)
  {
    AppMethodBeat.i(190382);
    paramString = q.aYy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(190382);
      return false;
    }
    FileSystem localFileSystem = (FileSystem)paramList.get(0);
    if (localFileSystem.aYe(paramString))
    {
      AppMethodBeat.o(190382);
      return false;
    }
    int j = paramList.size();
    int i = 1;
    while (i < j)
    {
      FileSystem.a locala = ((FileSystem)paramList.get(i)).aYf(paramString);
      if ((locala != null) && (locala.LjL))
      {
        boolean bool = localFileSystem.aYg(paramString);
        AppMethodBeat.o(190382);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(190382);
    return false;
  }
  
  /* Error */
  public final void a(android.os.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: sipush 13138
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 157	com/tencent/mm/vfs/MigrationFileSystem:Lkr	Z
    //   10: ifeq +2194 -> 2204
    //   13: iconst_0
    //   14: istore 13
    //   16: iconst_0
    //   17: istore 6
    //   19: iconst_0
    //   20: istore 14
    //   22: iconst_0
    //   23: istore 5
    //   25: iconst_0
    //   26: istore 18
    //   28: iconst_0
    //   29: istore_2
    //   30: iconst_0
    //   31: istore 7
    //   33: iconst_0
    //   34: istore 8
    //   36: iconst_0
    //   37: istore 19
    //   39: iconst_0
    //   40: istore_3
    //   41: iconst_0
    //   42: istore 20
    //   44: iconst_0
    //   45: istore 9
    //   47: lconst_0
    //   48: lstore 21
    //   50: aload_0
    //   51: getfield 100	com/tencent/mm/vfs/MigrationFileSystem:Lkq	Ljava/util/List;
    //   54: astore 30
    //   56: lload 21
    //   58: lstore 23
    //   60: iload 19
    //   62: istore 10
    //   64: iload 20
    //   66: istore 15
    //   68: iload 8
    //   70: istore 16
    //   72: iload 7
    //   74: istore 11
    //   76: iload 18
    //   78: istore 12
    //   80: iload 14
    //   82: istore 4
    //   84: iload 13
    //   86: istore 17
    //   88: aload 30
    //   90: iconst_0
    //   91: invokeinterface 129 2 0
    //   96: checkcast 55	com/tencent/mm/vfs/FileSystem
    //   99: astore 31
    //   101: lload 21
    //   103: lstore 23
    //   105: iload 19
    //   107: istore 10
    //   109: iload 20
    //   111: istore 15
    //   113: iload 8
    //   115: istore 16
    //   117: iload 7
    //   119: istore 11
    //   121: iload 18
    //   123: istore 12
    //   125: iload 14
    //   127: istore 4
    //   129: iload 13
    //   131: istore 17
    //   133: new 159	java/util/HashSet
    //   136: dup
    //   137: invokespecial 160	java/util/HashSet:<init>	()V
    //   140: astore 32
    //   142: lload 21
    //   144: lstore 23
    //   146: iload 19
    //   148: istore 10
    //   150: iload 20
    //   152: istore 15
    //   154: iload 8
    //   156: istore 16
    //   158: iload 7
    //   160: istore 11
    //   162: iload 18
    //   164: istore 12
    //   166: iload 14
    //   168: istore 4
    //   170: iload 13
    //   172: istore 17
    //   174: aload_1
    //   175: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   178: lload 21
    //   180: lstore 23
    //   182: iload 19
    //   184: istore 10
    //   186: iload 20
    //   188: istore 15
    //   190: iload 8
    //   192: istore 16
    //   194: iload 7
    //   196: istore 11
    //   198: iload 18
    //   200: istore 12
    //   202: iload 14
    //   204: istore 4
    //   206: iload 13
    //   208: istore 17
    //   210: aload_0
    //   211: iconst_1
    //   212: iconst_2
    //   213: anewarray 59	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: ldc 167
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload 31
    //   225: aastore
    //   226: invokevirtual 171	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   229: lload 21
    //   231: lstore 23
    //   233: iload 19
    //   235: istore 10
    //   237: iload 20
    //   239: istore 15
    //   241: iload 8
    //   243: istore 16
    //   245: iload 7
    //   247: istore 11
    //   249: iload 18
    //   251: istore 12
    //   253: iload 14
    //   255: istore 4
    //   257: iload 13
    //   259: istore 17
    //   261: aload 30
    //   263: invokeinterface 136 1 0
    //   268: istore 19
    //   270: iconst_1
    //   271: istore 18
    //   273: iconst_0
    //   274: istore 8
    //   276: iconst_0
    //   277: istore 7
    //   279: iload_3
    //   280: istore 4
    //   282: iload 8
    //   284: istore_3
    //   285: iload 18
    //   287: iload 19
    //   289: if_icmpge +1781 -> 2070
    //   292: aload_1
    //   293: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   296: aload 30
    //   298: iload 18
    //   300: invokeinterface 129 2 0
    //   305: checkcast 55	com/tencent/mm/vfs/FileSystem
    //   308: astore 33
    //   310: aload 33
    //   312: ldc 173
    //   314: iconst_1
    //   315: invokeinterface 177 3 0
    //   320: astore 29
    //   322: aload 29
    //   324: ifnull +1930 -> 2254
    //   327: aload 33
    //   329: invokeinterface 180 1 0
    //   334: bipush 9
    //   336: iand
    //   337: bipush 9
    //   339: if_icmpne +1918 -> 2257
    //   342: new 182	java/util/TreeSet
    //   345: dup
    //   346: invokespecial 183	java/util/TreeSet:<init>	()V
    //   349: astore 28
    //   351: aload 29
    //   353: invokeinterface 189 1 0
    //   358: astore 34
    //   360: iload_3
    //   361: istore 8
    //   363: iload 4
    //   365: istore_3
    //   366: lload 21
    //   368: lstore 23
    //   370: iload_3
    //   371: istore 10
    //   373: iload 9
    //   375: istore 15
    //   377: iload 8
    //   379: istore 16
    //   381: iload 7
    //   383: istore 11
    //   385: iload_2
    //   386: istore 12
    //   388: iload 5
    //   390: istore 4
    //   392: iload 6
    //   394: istore 17
    //   396: aload 34
    //   398: invokeinterface 195 1 0
    //   403: ifeq +1432 -> 1835
    //   406: lload 21
    //   408: lstore 23
    //   410: iload_3
    //   411: istore 10
    //   413: iload 9
    //   415: istore 15
    //   417: iload 8
    //   419: istore 16
    //   421: iload 7
    //   423: istore 11
    //   425: iload_2
    //   426: istore 12
    //   428: iload 5
    //   430: istore 4
    //   432: iload 6
    //   434: istore 17
    //   436: aload 34
    //   438: invokeinterface 199 1 0
    //   443: checkcast 142	com/tencent/mm/vfs/FileSystem$a
    //   446: astore 35
    //   448: lload 21
    //   450: lstore 23
    //   452: iload_3
    //   453: istore 10
    //   455: iload 9
    //   457: istore 15
    //   459: iload 8
    //   461: istore 16
    //   463: iload 7
    //   465: istore 11
    //   467: iload_2
    //   468: istore 12
    //   470: iload 5
    //   472: istore 4
    //   474: iload 6
    //   476: istore 17
    //   478: aload_1
    //   479: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   482: lload 21
    //   484: lstore 23
    //   486: iload_3
    //   487: istore 10
    //   489: iload 9
    //   491: istore 15
    //   493: iload 8
    //   495: istore 16
    //   497: iload 7
    //   499: istore 11
    //   501: iload_2
    //   502: istore 12
    //   504: iload 5
    //   506: istore 4
    //   508: iload 6
    //   510: istore 17
    //   512: aload 35
    //   514: getfield 145	com/tencent/mm/vfs/FileSystem$a:LjL	Z
    //   517: istore 27
    //   519: iload 27
    //   521: ifeq +452 -> 973
    //   524: lload 21
    //   526: lstore 23
    //   528: iload_3
    //   529: istore 10
    //   531: iload 9
    //   533: istore 15
    //   535: iload 8
    //   537: istore 16
    //   539: iload 7
    //   541: istore 11
    //   543: iload_2
    //   544: istore 12
    //   546: iload 5
    //   548: istore 4
    //   550: iload 6
    //   552: istore 17
    //   554: aload 31
    //   556: aload 35
    //   558: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   561: aload 33
    //   563: aload 35
    //   565: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   568: invokeinterface 205 4 0
    //   573: istore 27
    //   575: iload 27
    //   577: ifeq +53 -> 630
    //   580: lload 21
    //   582: lstore 23
    //   584: iload_3
    //   585: istore 10
    //   587: iload 9
    //   589: istore 15
    //   591: iload 8
    //   593: istore 16
    //   595: iload 7
    //   597: istore 11
    //   599: iload_2
    //   600: istore 12
    //   602: iload 5
    //   604: istore 4
    //   606: iload 6
    //   608: istore 17
    //   610: aload 32
    //   612: aload 35
    //   614: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   617: invokevirtual 209	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   620: pop
    //   621: iload 6
    //   623: iconst_1
    //   624: iadd
    //   625: istore 6
    //   627: goto -261 -> 366
    //   630: iload 5
    //   632: istore 13
    //   634: lload 21
    //   636: lstore 23
    //   638: iload_3
    //   639: istore 10
    //   641: iload 9
    //   643: istore 15
    //   645: iload 8
    //   647: istore 16
    //   649: iload 7
    //   651: istore 11
    //   653: iload_2
    //   654: istore 12
    //   656: iload 5
    //   658: istore 4
    //   660: iload 6
    //   662: istore 17
    //   664: aload 32
    //   666: aload 35
    //   668: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   671: invokevirtual 209	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   674: ifeq +52 -> 726
    //   677: lload 21
    //   679: lstore 23
    //   681: iload_3
    //   682: istore 10
    //   684: iload 9
    //   686: istore 15
    //   688: iload 8
    //   690: istore 16
    //   692: iload 7
    //   694: istore 11
    //   696: iload_2
    //   697: istore 12
    //   699: iload 5
    //   701: istore 4
    //   703: iload 6
    //   705: istore 17
    //   707: aload 31
    //   709: aload 35
    //   711: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   714: invokeinterface 148 2 0
    //   719: pop
    //   720: iload 5
    //   722: iconst_1
    //   723: iadd
    //   724: istore 13
    //   726: iload 13
    //   728: istore 5
    //   730: aload 28
    //   732: ifnull -366 -> 366
    //   735: lload 21
    //   737: lstore 23
    //   739: iload_3
    //   740: istore 10
    //   742: iload 9
    //   744: istore 15
    //   746: iload 8
    //   748: istore 16
    //   750: iload 7
    //   752: istore 11
    //   754: iload_2
    //   755: istore 12
    //   757: iload 13
    //   759: istore 4
    //   761: iload 6
    //   763: istore 17
    //   765: aload 28
    //   767: aload 35
    //   769: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   772: invokevirtual 210	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   775: pop
    //   776: iload 13
    //   778: istore 5
    //   780: goto -414 -> 366
    //   783: astore_1
    //   784: iload 17
    //   786: istore 6
    //   788: iload 4
    //   790: istore 5
    //   792: iload 12
    //   794: istore_2
    //   795: iload 11
    //   797: istore 7
    //   799: iload 16
    //   801: istore 8
    //   803: iload 15
    //   805: istore 9
    //   807: iload 10
    //   809: istore 4
    //   811: lload 23
    //   813: lstore 21
    //   815: aload_1
    //   816: instanceof 212
    //   819: ifeq +1397 -> 2216
    //   822: iconst_4
    //   823: istore_3
    //   824: aload_0
    //   825: iload_3
    //   826: bipush 18
    //   828: anewarray 59	java/lang/Object
    //   831: dup
    //   832: iconst_0
    //   833: ldc 167
    //   835: aastore
    //   836: dup
    //   837: iconst_1
    //   838: aload 30
    //   840: iconst_0
    //   841: invokeinterface 129 2 0
    //   846: aastore
    //   847: dup
    //   848: iconst_2
    //   849: ldc 214
    //   851: aastore
    //   852: dup
    //   853: iconst_3
    //   854: iload 6
    //   856: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   859: aastore
    //   860: dup
    //   861: iconst_4
    //   862: ldc 222
    //   864: aastore
    //   865: dup
    //   866: iconst_5
    //   867: iload 5
    //   869: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   872: aastore
    //   873: dup
    //   874: bipush 6
    //   876: ldc 224
    //   878: aastore
    //   879: dup
    //   880: bipush 7
    //   882: iload_2
    //   883: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   886: aastore
    //   887: dup
    //   888: bipush 8
    //   890: ldc 226
    //   892: aastore
    //   893: dup
    //   894: bipush 9
    //   896: iload 7
    //   898: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   901: aastore
    //   902: dup
    //   903: bipush 10
    //   905: ldc 228
    //   907: aastore
    //   908: dup
    //   909: bipush 11
    //   911: iload 4
    //   913: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   916: aastore
    //   917: dup
    //   918: bipush 12
    //   920: ldc 230
    //   922: aastore
    //   923: dup
    //   924: bipush 13
    //   926: iload 8
    //   928: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   931: aastore
    //   932: dup
    //   933: bipush 14
    //   935: ldc 232
    //   937: aastore
    //   938: dup
    //   939: bipush 15
    //   941: iload 9
    //   943: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   946: aastore
    //   947: dup
    //   948: bipush 16
    //   950: ldc 234
    //   952: aastore
    //   953: dup
    //   954: bipush 17
    //   956: lload 21
    //   958: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   961: aastore
    //   962: invokevirtual 171	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   965: sipush 13138
    //   968: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   971: aload_1
    //   972: athrow
    //   973: lload 21
    //   975: lstore 23
    //   977: iload_3
    //   978: istore 10
    //   980: iload 9
    //   982: istore 15
    //   984: iload 8
    //   986: istore 16
    //   988: iload 7
    //   990: istore 11
    //   992: iload_2
    //   993: istore 12
    //   995: iload 5
    //   997: istore 4
    //   999: iload 6
    //   1001: istore 17
    //   1003: aload 35
    //   1005: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1008: invokestatic 123	com/tencent/mm/vfs/q:aYy	(Ljava/lang/String;)Ljava/lang/String;
    //   1011: astore 29
    //   1013: iload 5
    //   1015: istore 13
    //   1017: aload 29
    //   1019: ifnull +144 -> 1163
    //   1022: lload 21
    //   1024: lstore 23
    //   1026: iload_3
    //   1027: istore 10
    //   1029: iload 9
    //   1031: istore 15
    //   1033: iload 8
    //   1035: istore 16
    //   1037: iload 7
    //   1039: istore 11
    //   1041: iload_2
    //   1042: istore 12
    //   1044: iload 5
    //   1046: istore 4
    //   1048: iload 6
    //   1050: istore 17
    //   1052: iload 5
    //   1054: istore 14
    //   1056: aload 32
    //   1058: aload 29
    //   1060: invokevirtual 209	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1063: ifeq +49 -> 1112
    //   1066: lload 21
    //   1068: lstore 23
    //   1070: iload_3
    //   1071: istore 10
    //   1073: iload 9
    //   1075: istore 15
    //   1077: iload 8
    //   1079: istore 16
    //   1081: iload 7
    //   1083: istore 11
    //   1085: iload_2
    //   1086: istore 12
    //   1088: iload 5
    //   1090: istore 4
    //   1092: iload 6
    //   1094: istore 17
    //   1096: aload 31
    //   1098: aload 29
    //   1100: invokeinterface 148 2 0
    //   1105: pop
    //   1106: iload 5
    //   1108: iconst_1
    //   1109: iadd
    //   1110: istore 14
    //   1112: iload 14
    //   1114: istore 13
    //   1116: aload 28
    //   1118: ifnull +45 -> 1163
    //   1121: lload 21
    //   1123: lstore 23
    //   1125: iload_3
    //   1126: istore 10
    //   1128: iload 9
    //   1130: istore 15
    //   1132: iload 8
    //   1134: istore 16
    //   1136: iload 7
    //   1138: istore 11
    //   1140: iload_2
    //   1141: istore 12
    //   1143: iload 14
    //   1145: istore 4
    //   1147: iload 6
    //   1149: istore 17
    //   1151: aload 28
    //   1153: aload 29
    //   1155: invokevirtual 210	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   1158: pop
    //   1159: iload 14
    //   1161: istore 13
    //   1163: lload 21
    //   1165: lstore 23
    //   1167: iload_3
    //   1168: istore 10
    //   1170: iload 9
    //   1172: istore 15
    //   1174: iload 8
    //   1176: istore 16
    //   1178: iload 7
    //   1180: istore 11
    //   1182: iload_2
    //   1183: istore 12
    //   1185: iload 13
    //   1187: istore 4
    //   1189: iload 6
    //   1191: istore 17
    //   1193: aload 31
    //   1195: aload 35
    //   1197: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1200: invokeinterface 133 2 0
    //   1205: ifeq +151 -> 1356
    //   1208: lload 21
    //   1210: lstore 23
    //   1212: iload_3
    //   1213: istore 10
    //   1215: iload 9
    //   1217: istore 15
    //   1219: iload 8
    //   1221: istore 16
    //   1223: iload 7
    //   1225: istore 11
    //   1227: iload_2
    //   1228: istore 12
    //   1230: iload 13
    //   1232: istore 4
    //   1234: iload 6
    //   1236: istore 17
    //   1238: aload_0
    //   1239: getfield 241	com/tencent/mm/vfs/MigrationFileSystem:Lks	Z
    //   1242: ifne +1005 -> 2247
    //   1245: lload 21
    //   1247: lstore 23
    //   1249: iload_3
    //   1250: istore 10
    //   1252: iload 9
    //   1254: istore 15
    //   1256: iload 8
    //   1258: istore 16
    //   1260: iload 7
    //   1262: istore 11
    //   1264: iload_2
    //   1265: istore 12
    //   1267: iload 13
    //   1269: istore 4
    //   1271: iload 6
    //   1273: istore 17
    //   1275: aload 33
    //   1277: aload 35
    //   1279: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1282: invokeinterface 244 2 0
    //   1287: pop
    //   1288: iload 7
    //   1290: iconst_1
    //   1291: iadd
    //   1292: istore 7
    //   1294: lload 21
    //   1296: lstore 23
    //   1298: iload_3
    //   1299: istore 10
    //   1301: iload 9
    //   1303: istore 15
    //   1305: iload 8
    //   1307: istore 16
    //   1309: iload 7
    //   1311: istore 11
    //   1313: iload_2
    //   1314: istore 12
    //   1316: iload 13
    //   1318: istore 4
    //   1320: iload 6
    //   1322: istore 17
    //   1324: ldc 246
    //   1326: new 248	java/lang/StringBuilder
    //   1329: dup
    //   1330: ldc 250
    //   1332: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1335: aload 35
    //   1337: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1340: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1346: invokestatic 264	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   1349: iload 13
    //   1351: istore 5
    //   1353: goto -987 -> 366
    //   1356: lload 21
    //   1358: lstore 23
    //   1360: iload_3
    //   1361: istore 10
    //   1363: iload 9
    //   1365: istore 15
    //   1367: iload 8
    //   1369: istore 16
    //   1371: iload 7
    //   1373: istore 11
    //   1375: iload_2
    //   1376: istore 12
    //   1378: iload 13
    //   1380: istore 4
    //   1382: iload 6
    //   1384: istore 17
    //   1386: iload_3
    //   1387: istore 5
    //   1389: aload 31
    //   1391: aload 35
    //   1393: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1396: aload 33
    //   1398: aload 35
    //   1400: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1403: invokeinterface 205 4 0
    //   1408: ifeq +75 -> 1483
    //   1411: lload 21
    //   1413: lstore 23
    //   1415: iload_3
    //   1416: istore 10
    //   1418: iload 9
    //   1420: istore 15
    //   1422: iload 8
    //   1424: istore 16
    //   1426: iload 7
    //   1428: istore 11
    //   1430: iload_2
    //   1431: istore 12
    //   1433: iload 13
    //   1435: istore 4
    //   1437: iload 6
    //   1439: istore 17
    //   1441: iload_3
    //   1442: istore 5
    //   1444: ldc 246
    //   1446: new 248	java/lang/StringBuilder
    //   1449: dup
    //   1450: ldc_w 266
    //   1453: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1456: aload 35
    //   1458: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1461: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: invokestatic 264	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: iload 8
    //   1472: iconst_1
    //   1473: iadd
    //   1474: istore 8
    //   1476: iload 13
    //   1478: istore 5
    //   1480: goto -1114 -> 366
    //   1483: lload 21
    //   1485: lstore 23
    //   1487: iload_3
    //   1488: istore 10
    //   1490: iload 9
    //   1492: istore 15
    //   1494: iload 8
    //   1496: istore 16
    //   1498: iload 7
    //   1500: istore 11
    //   1502: iload_2
    //   1503: istore 12
    //   1505: iload 13
    //   1507: istore 4
    //   1509: iload 6
    //   1511: istore 17
    //   1513: iload_3
    //   1514: istore 5
    //   1516: aload_0
    //   1517: getfield 241	com/tencent/mm/vfs/MigrationFileSystem:Lks	Z
    //   1520: ifne +724 -> 2244
    //   1523: lload 21
    //   1525: lstore 23
    //   1527: iload_3
    //   1528: istore 10
    //   1530: iload 9
    //   1532: istore 15
    //   1534: iload 8
    //   1536: istore 16
    //   1538: iload 7
    //   1540: istore 11
    //   1542: iload_2
    //   1543: istore 12
    //   1545: iload 13
    //   1547: istore 4
    //   1549: iload 6
    //   1551: istore 17
    //   1553: iload_3
    //   1554: istore 5
    //   1556: aload 31
    //   1558: aload 35
    //   1560: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1563: aload 33
    //   1565: aload 35
    //   1567: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1570: invokeinterface 270 4 0
    //   1575: pop2
    //   1576: lload 21
    //   1578: lstore 23
    //   1580: iload_3
    //   1581: istore 10
    //   1583: iload 9
    //   1585: istore 15
    //   1587: iload 8
    //   1589: istore 16
    //   1591: iload 7
    //   1593: istore 11
    //   1595: iload_2
    //   1596: istore 12
    //   1598: iload 13
    //   1600: istore 4
    //   1602: iload 6
    //   1604: istore 17
    //   1606: iload_3
    //   1607: istore 5
    //   1609: aload 33
    //   1611: aload 35
    //   1613: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1616: invokeinterface 244 2 0
    //   1621: pop
    //   1622: lload 21
    //   1624: lstore 23
    //   1626: iload_3
    //   1627: istore 10
    //   1629: iload 9
    //   1631: istore 15
    //   1633: iload 8
    //   1635: istore 16
    //   1637: iload 7
    //   1639: istore 11
    //   1641: iload_2
    //   1642: istore 12
    //   1644: iload 13
    //   1646: istore 4
    //   1648: iload 6
    //   1650: istore 17
    //   1652: iload_3
    //   1653: istore 5
    //   1655: ldc 246
    //   1657: new 248	java/lang/StringBuilder
    //   1660: dup
    //   1661: ldc_w 272
    //   1664: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1667: aload 35
    //   1669: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1672: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1678: invokestatic 264	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   1681: iload_3
    //   1682: iconst_1
    //   1683: iadd
    //   1684: istore_3
    //   1685: lload 21
    //   1687: lstore 23
    //   1689: iload_3
    //   1690: istore 10
    //   1692: iload 9
    //   1694: istore 15
    //   1696: iload 8
    //   1698: istore 16
    //   1700: iload 7
    //   1702: istore 11
    //   1704: iload_2
    //   1705: istore 12
    //   1707: iload 13
    //   1709: istore 4
    //   1711: iload 6
    //   1713: istore 17
    //   1715: iload_3
    //   1716: istore 5
    //   1718: aload 35
    //   1720: getfield 276	com/tencent/mm/vfs/FileSystem$a:LjJ	J
    //   1723: lstore 25
    //   1725: lload 25
    //   1727: lload 21
    //   1729: ladd
    //   1730: lstore 21
    //   1732: iload 13
    //   1734: istore 5
    //   1736: goto -1370 -> 366
    //   1739: astore 36
    //   1741: iload 9
    //   1743: iconst_1
    //   1744: iadd
    //   1745: istore 4
    //   1747: ldc_w 278
    //   1750: new 248	java/lang/StringBuilder
    //   1753: dup
    //   1754: ldc_w 280
    //   1757: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1760: aload 35
    //   1762: getfield 202	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   1765: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: ldc_w 282
    //   1771: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: aload_0
    //   1775: invokevirtual 283	com/tencent/mm/vfs/MigrationFileSystem:toString	()Ljava/lang/String;
    //   1778: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: ldc_w 285
    //   1784: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1790: invokestatic 288	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1793: aload 28
    //   1795: ifnull +26 -> 1821
    //   1798: aload 29
    //   1800: ifnull +21 -> 1821
    //   1803: aload 28
    //   1805: aload 29
    //   1807: invokevirtual 291	java/util/TreeSet:remove	(Ljava/lang/Object;)Z
    //   1810: pop
    //   1811: aload 29
    //   1813: invokestatic 123	com/tencent/mm/vfs/q:aYy	(Ljava/lang/String;)Ljava/lang/String;
    //   1816: astore 29
    //   1818: goto -20 -> 1798
    //   1821: iload 5
    //   1823: istore_3
    //   1824: iload 4
    //   1826: istore 9
    //   1828: iload 13
    //   1830: istore 5
    //   1832: goto -1466 -> 366
    //   1835: iload_2
    //   1836: istore 13
    //   1838: aload 28
    //   1840: ifnull +212 -> 2052
    //   1843: lload 21
    //   1845: lstore 23
    //   1847: iload_3
    //   1848: istore 10
    //   1850: iload 9
    //   1852: istore 15
    //   1854: iload 8
    //   1856: istore 16
    //   1858: iload 7
    //   1860: istore 11
    //   1862: iload_2
    //   1863: istore 12
    //   1865: iload 5
    //   1867: istore 4
    //   1869: iload 6
    //   1871: istore 17
    //   1873: aload 28
    //   1875: invokevirtual 295	java/util/TreeSet:descendingSet	()Ljava/util/NavigableSet;
    //   1878: invokeinterface 298 1 0
    //   1883: astore 28
    //   1885: lload 21
    //   1887: lstore 23
    //   1889: iload_3
    //   1890: istore 10
    //   1892: iload 9
    //   1894: istore 15
    //   1896: iload 8
    //   1898: istore 16
    //   1900: iload 7
    //   1902: istore 11
    //   1904: iload_2
    //   1905: istore 12
    //   1907: iload 5
    //   1909: istore 4
    //   1911: iload 6
    //   1913: istore 17
    //   1915: iload_2
    //   1916: istore 13
    //   1918: aload 28
    //   1920: invokeinterface 195 1 0
    //   1925: ifeq +127 -> 2052
    //   1928: lload 21
    //   1930: lstore 23
    //   1932: iload_3
    //   1933: istore 10
    //   1935: iload 9
    //   1937: istore 15
    //   1939: iload 8
    //   1941: istore 16
    //   1943: iload 7
    //   1945: istore 11
    //   1947: iload_2
    //   1948: istore 12
    //   1950: iload 5
    //   1952: istore 4
    //   1954: iload 6
    //   1956: istore 17
    //   1958: aload 28
    //   1960: invokeinterface 199 1 0
    //   1965: checkcast 300	java/lang/String
    //   1968: astore 29
    //   1970: lload 21
    //   1972: lstore 23
    //   1974: iload_3
    //   1975: istore 10
    //   1977: iload 9
    //   1979: istore 15
    //   1981: iload 8
    //   1983: istore 16
    //   1985: iload 7
    //   1987: istore 11
    //   1989: iload_2
    //   1990: istore 12
    //   1992: iload 5
    //   1994: istore 4
    //   1996: iload 6
    //   1998: istore 17
    //   2000: aload_1
    //   2001: invokevirtual 165	android/os/CancellationSignal:throwIfCanceled	()V
    //   2004: lload 21
    //   2006: lstore 23
    //   2008: iload_3
    //   2009: istore 10
    //   2011: iload 9
    //   2013: istore 15
    //   2015: iload 8
    //   2017: istore 16
    //   2019: iload 7
    //   2021: istore 11
    //   2023: iload_2
    //   2024: istore 12
    //   2026: iload 5
    //   2028: istore 4
    //   2030: iload 6
    //   2032: istore 17
    //   2034: aload 33
    //   2036: aload 29
    //   2038: iconst_0
    //   2039: invokeinterface 304 3 0
    //   2044: pop
    //   2045: iload_2
    //   2046: iconst_1
    //   2047: iadd
    //   2048: istore_2
    //   2049: goto -164 -> 1885
    //   2052: iload 13
    //   2054: istore_2
    //   2055: iload_3
    //   2056: istore 4
    //   2058: iload 8
    //   2060: istore_3
    //   2061: iload 18
    //   2063: iconst_1
    //   2064: iadd
    //   2065: istore 18
    //   2067: goto -1782 -> 285
    //   2070: aload_0
    //   2071: iconst_3
    //   2072: bipush 18
    //   2074: anewarray 59	java/lang/Object
    //   2077: dup
    //   2078: iconst_0
    //   2079: ldc 167
    //   2081: aastore
    //   2082: dup
    //   2083: iconst_1
    //   2084: aload 31
    //   2086: aastore
    //   2087: dup
    //   2088: iconst_2
    //   2089: ldc 214
    //   2091: aastore
    //   2092: dup
    //   2093: iconst_3
    //   2094: iload 6
    //   2096: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2099: aastore
    //   2100: dup
    //   2101: iconst_4
    //   2102: ldc 222
    //   2104: aastore
    //   2105: dup
    //   2106: iconst_5
    //   2107: iload 5
    //   2109: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2112: aastore
    //   2113: dup
    //   2114: bipush 6
    //   2116: ldc 224
    //   2118: aastore
    //   2119: dup
    //   2120: bipush 7
    //   2122: iload_2
    //   2123: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2126: aastore
    //   2127: dup
    //   2128: bipush 8
    //   2130: ldc 226
    //   2132: aastore
    //   2133: dup
    //   2134: bipush 9
    //   2136: iload 7
    //   2138: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2141: aastore
    //   2142: dup
    //   2143: bipush 10
    //   2145: ldc 228
    //   2147: aastore
    //   2148: dup
    //   2149: bipush 11
    //   2151: iload 4
    //   2153: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2156: aastore
    //   2157: dup
    //   2158: bipush 12
    //   2160: ldc 230
    //   2162: aastore
    //   2163: dup
    //   2164: bipush 13
    //   2166: iload_3
    //   2167: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2170: aastore
    //   2171: dup
    //   2172: bipush 14
    //   2174: ldc 232
    //   2176: aastore
    //   2177: dup
    //   2178: bipush 15
    //   2180: iload 9
    //   2182: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2185: aastore
    //   2186: dup
    //   2187: bipush 16
    //   2189: ldc 234
    //   2191: aastore
    //   2192: dup
    //   2193: bipush 17
    //   2195: lload 21
    //   2197: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2200: aastore
    //   2201: invokevirtual 171	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   2204: aload_0
    //   2205: aload_1
    //   2206: invokespecial 306	com/tencent/mm/vfs/DelegateFileSystem:a	(Landroid/os/CancellationSignal;)V
    //   2209: sipush 13138
    //   2212: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2215: return
    //   2216: iconst_5
    //   2217: istore_3
    //   2218: goto -1394 -> 824
    //   2221: astore_1
    //   2222: iload_3
    //   2223: istore 8
    //   2225: goto -1410 -> 815
    //   2228: astore_1
    //   2229: iload 4
    //   2231: istore 9
    //   2233: iload 5
    //   2235: istore 4
    //   2237: iload 13
    //   2239: istore 5
    //   2241: goto -1426 -> 815
    //   2244: goto -512 -> 1732
    //   2247: iload 9
    //   2249: istore 4
    //   2251: goto -427 -> 1824
    //   2254: goto -193 -> 2061
    //   2257: aconst_null
    //   2258: astore 28
    //   2260: goto -1909 -> 351
    //   2263: astore 29
    //   2265: iconst_0
    //   2266: istore 27
    //   2268: goto -1693 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2271	0	this	MigrationFileSystem
    //   0	2271	1	paramCancellationSignal	android.os.CancellationSignal
    //   29	2094	2	i	int
    //   40	2183	3	j	int
    //   82	2168	4	k	int
    //   23	2217	5	m	int
    //   17	2078	6	n	int
    //   31	2106	7	i1	int
    //   34	2190	8	i2	int
    //   45	2203	9	i3	int
    //   62	1948	10	i4	int
    //   74	1948	11	i5	int
    //   78	1947	12	i6	int
    //   14	2224	13	i7	int
    //   20	1140	14	i8	int
    //   66	1948	15	i9	int
    //   70	1948	16	i10	int
    //   86	1947	17	i11	int
    //   26	2040	18	i12	int
    //   37	253	19	i13	int
    //   42	196	20	i14	int
    //   48	2148	21	l1	long
    //   58	1949	23	l2	long
    //   1723	3	25	l3	long
    //   517	1750	27	bool	boolean
    //   349	1910	28	localObject1	Object
    //   320	1717	29	localObject2	Object
    //   2263	1	29	localIOException1	java.io.IOException
    //   54	785	30	localList	List
    //   99	1986	31	localFileSystem1	FileSystem
    //   140	917	32	localHashSet	HashSet
    //   308	1727	33	localFileSystem2	FileSystem
    //   358	79	34	localIterator	Iterator
    //   446	1315	35	locala	FileSystem.a
    //   1739	1	36	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   88	101	783	java/lang/Exception
    //   133	142	783	java/lang/Exception
    //   174	178	783	java/lang/Exception
    //   210	229	783	java/lang/Exception
    //   261	270	783	java/lang/Exception
    //   396	406	783	java/lang/Exception
    //   436	448	783	java/lang/Exception
    //   478	482	783	java/lang/Exception
    //   512	519	783	java/lang/Exception
    //   554	575	783	java/lang/Exception
    //   610	621	783	java/lang/Exception
    //   664	677	783	java/lang/Exception
    //   707	720	783	java/lang/Exception
    //   765	776	783	java/lang/Exception
    //   1003	1013	783	java/lang/Exception
    //   1056	1066	783	java/lang/Exception
    //   1096	1106	783	java/lang/Exception
    //   1151	1159	783	java/lang/Exception
    //   1193	1208	783	java/lang/Exception
    //   1238	1245	783	java/lang/Exception
    //   1275	1288	783	java/lang/Exception
    //   1324	1349	783	java/lang/Exception
    //   1389	1411	783	java/lang/Exception
    //   1444	1470	783	java/lang/Exception
    //   1516	1523	783	java/lang/Exception
    //   1556	1576	783	java/lang/Exception
    //   1609	1622	783	java/lang/Exception
    //   1655	1681	783	java/lang/Exception
    //   1718	1725	783	java/lang/Exception
    //   1873	1885	783	java/lang/Exception
    //   1918	1928	783	java/lang/Exception
    //   1958	1970	783	java/lang/Exception
    //   2000	2004	783	java/lang/Exception
    //   2034	2045	783	java/lang/Exception
    //   1389	1411	1739	java/io/IOException
    //   1444	1470	1739	java/io/IOException
    //   1516	1523	1739	java/io/IOException
    //   1556	1576	1739	java/io/IOException
    //   1609	1622	1739	java/io/IOException
    //   1655	1681	1739	java/io/IOException
    //   1718	1725	1739	java/io/IOException
    //   292	322	2221	java/lang/Exception
    //   327	351	2221	java/lang/Exception
    //   351	360	2221	java/lang/Exception
    //   2070	2204	2221	java/lang/Exception
    //   1747	1793	2228	java/lang/Exception
    //   1803	1818	2228	java/lang/Exception
    //   554	575	2263	java/io/IOException
  }
  
  public final boolean a(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(190383);
    boolean bool = super.a(paramString1, paramFileSystem, paramString2);
    if ((!bool) && (t(this.Lkq, paramString1)))
    {
      bool = super.a(paramString1, paramFileSystem, paramString2);
      AppMethodBeat.o(190383);
      return bool;
    }
    AppMethodBeat.o(190383);
    return bool;
  }
  
  public final ReadableByteChannel aYb(String paramString)
  {
    AppMethodBeat.i(13134);
    Object localObject = this.Lkq;
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
        localObject = ((FileSystem)localObject).aYb(paramString);
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
  
  public final boolean aYe(String paramString)
  {
    AppMethodBeat.i(13135);
    Iterator localIterator = this.Lkq.iterator();
    while (localIterator.hasNext()) {
      if (((FileSystem)localIterator.next()).aYe(paramString))
      {
        AppMethodBeat.o(13135);
        return true;
      }
    }
    AppMethodBeat.o(13135);
    return false;
  }
  
  public final FileSystem.a aYf(String paramString)
  {
    AppMethodBeat.i(13136);
    Iterator localIterator = this.Lkq.iterator();
    while (localIterator.hasNext())
    {
      FileSystem.a locala = ((FileSystem)localIterator.next()).aYf(paramString);
      if (locala != null)
      {
        AppMethodBeat.o(13136);
        return locala;
      }
    }
    AppMethodBeat.o(13136);
    return null;
  }
  
  public final void bY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(13137);
    boolean bool1;
    int j;
    label33:
    int i;
    if (q.S(this.Lkm, paramMap) != null)
    {
      bool1 = true;
      if (q.S(this.Lkn, paramMap) == null) {
        break label107;
      }
      j = 1;
      if (q.S(this.Lko, paramMap) == null) {
        break label112;
      }
      i = 1;
      label46:
      if (q.S(this.Lkp, paramMap) == null) {
        break label117;
      }
    }
    label107:
    label112:
    label117:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject1 = this.Ljr;
      int m = localObject1.length;
      int k = 0;
      while (k < m)
      {
        localObject1[k].bY(paramMap);
        k += 1;
      }
      bool1 = false;
      break;
      j = 0;
      break label33;
      i = 0;
      break label46;
    }
    ArrayList localArrayList = new ArrayList(this.Ljr.length);
    localArrayList.add(this.Ljr[0]);
    HashSet localHashSet = new HashSet();
    Object localObject1 = null;
    paramMap = (Map<String, String>)localObject1;
    Object localObject2;
    if ((this.Ljr[0] instanceof NativeFileSystem))
    {
      localObject2 = ((NativeFileSystem)this.Ljr[0]).Lkv;
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
      if (j < this.Ljr.length)
      {
        if (!(this.Ljr[j] instanceof NativeFileSystem)) {
          localArrayList.add(this.Ljr[j]);
        }
        for (;;)
        {
          j += 1;
          break;
          NativeFileSystem localNativeFileSystem = (NativeFileSystem)this.Ljr[j];
          String str = localNativeFileSystem.Lkv;
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
      this.Lkq = localArrayList;
      this.Lkr = bool1;
      this.Lks = bool2;
      AppMethodBeat.o(13137);
      return;
    }
  }
  
  public final long c(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    AppMethodBeat.i(190384);
    try
    {
      l = super.c(paramString1, paramFileSystem, paramString2);
      AppMethodBeat.o(190384);
      return l;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      long l;
      if (t(this.Lkq, paramString1))
      {
        l = super.c(paramString1, paramFileSystem, paramString2);
        AppMethodBeat.o(190384);
        return l;
      }
      AppMethodBeat.o(190384);
      throw localFileNotFoundException;
    }
  }
  
  public final WritableByteChannel cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(170156);
    List localList = this.Lkq;
    FileSystem localFileSystem = (FileSystem)localList.get(0);
    try
    {
      WritableByteChannel localWritableByteChannel = localFileSystem.cW(paramString, paramBoolean);
      AppMethodBeat.o(170156);
      return localWritableByteChannel;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if ((!paramBoolean) && (t(localList, paramString)))
      {
        paramString = localFileSystem.cW(paramString, false);
        AppMethodBeat.o(170156);
        return paramString;
      }
      AppMethodBeat.o(170156);
      throw localFileNotFoundException;
    }
  }
  
  public final OutputStream cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(170155);
    List localList = this.Lkq;
    FileSystem localFileSystem = (FileSystem)localList.get(0);
    try
    {
      OutputStream localOutputStream = localFileSystem.cX(paramString, paramBoolean);
      AppMethodBeat.o(170155);
      return localOutputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if ((!paramBoolean) && (t(localList, paramString)))
      {
        paramString = localFileSystem.cX(paramString, false);
        AppMethodBeat.o(170155);
        return paramString;
      }
      AppMethodBeat.o(170155);
      throw localFileNotFoundException;
    }
  }
  
  public final boolean fOB()
  {
    AppMethodBeat.i(190385);
    Iterator localIterator = this.Lkq.subList(1, this.Lkq.size()).iterator();
    while (localIterator.hasNext())
    {
      Iterable localIterable = ((FileSystem)localIterator.next()).cY("", false);
      if ((localIterable != null) && (localIterable.iterator().hasNext()))
      {
        AppMethodBeat.o(190385);
        return false;
      }
    }
    AppMethodBeat.o(190385);
    return true;
  }
  
  protected final Iterable<FileSystem> fOq()
  {
    return this.Lkq;
  }
  
  protected final FileSystem gK(String paramString, int paramInt)
  {
    AppMethodBeat.i(13132);
    List localList = this.Lkq;
    if ((paramInt == 1) || (paramInt == 3))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FileSystem localFileSystem = (FileSystem)localIterator.next();
        if (localFileSystem.aYe(paramString))
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
    Object localObject = this.Lkq;
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
    if (this.Lkr) {
      ((StringBuilder)localObject).append('P');
    }
    if (this.Lks) {
      ((StringBuilder)localObject).append('N');
    }
    ((StringBuilder)localObject).append(") ").append(((FileSystem)this.Lkq.get(0)).toString()).append(" <= ");
    int i = 1;
    while (i < this.Lkq.size())
    {
      ((StringBuilder)localObject).append(((FileSystem)this.Lkq.get(i)).toString()).append(", ");
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
    paramParcel.writeInt(this.Ljr.length);
    FileSystem[] arrayOfFileSystem = this.Ljr;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    paramParcel.writeString(this.Lkm);
    paramParcel.writeString(this.Lkn);
    paramParcel.writeString(this.Lko);
    paramParcel.writeString(this.Lkp);
    AppMethodBeat.o(13140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */