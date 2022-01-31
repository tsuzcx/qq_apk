package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MigrationFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<MigrationFileSystem> CREATOR;
  private final FileSystem[] APi;
  private final boolean AQe;
  
  static
  {
    AppMethodBeat.i(54555);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(54555);
  }
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(54537);
    j.a(paramParcel, getClass());
    int j = paramParcel.readInt();
    this.APi = new FileSystem[j];
    int i = 0;
    while (i < j)
    {
      this.APi[i] = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
      i += 1;
    }
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.AQe = bool;
      AppMethodBeat.o(54537);
      return;
    }
  }
  
  public MigrationFileSystem(FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    AppMethodBeat.i(54536);
    this.AQe = true;
    FileSystem[] arrayOfFileSystem = new FileSystem[2];
    arrayOfFileSystem[0] = paramFileSystem;
    int i = 0;
    int k;
    for (int j = 1; i <= 0; j = k)
    {
      paramFileSystem = paramVarArgs[0];
      k = j;
      if (paramFileSystem != null)
      {
        k = j + 1;
        arrayOfFileSystem[1] = paramFileSystem;
      }
      i += 1;
    }
    if (j == 2) {}
    for (paramFileSystem = arrayOfFileSystem;; paramFileSystem = (FileSystem[])Arrays.copyOf(arrayOfFileSystem, 1))
    {
      this.APi = paramFileSystem;
      AppMethodBeat.o(54536);
      return;
    }
  }
  
  public final boolean A(String paramString, long paramLong)
  {
    AppMethodBeat.i(54544);
    boolean bool = this.APi[0].A(paramString, paramLong);
    AppMethodBeat.o(54544);
    return bool;
  }
  
  public final OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54541);
    paramString = this.APi[0].M(paramString, paramBoolean);
    AppMethodBeat.o(54541);
    return paramString;
  }
  
  public final List<FileSystem.a> N(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54546);
    ArrayList localArrayList = new ArrayList();
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      List localList = arrayOfFileSystem[i].N(paramString, paramBoolean);
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      i += 1;
    }
    AppMethodBeat.o(54546);
    return localArrayList;
  }
  
  public final boolean O(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54548);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].O(paramString, paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(54548);
    return bool1;
  }
  
  public final String P(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54550);
    if (paramBoolean)
    {
      paramString = this.APi[0].P(paramString, true);
      AppMethodBeat.o(54550);
      return paramString;
    }
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      FileSystem localFileSystem = arrayOfFileSystem[i];
      if (localFileSystem.exists(paramString))
      {
        paramString = localFileSystem.P(paramString, false);
        AppMethodBeat.o(54550);
        return paramString;
      }
      i += 1;
    }
    paramString = this.APi[0].P(paramString, false);
    AppMethodBeat.o(54550);
    return paramString;
  }
  
  /* Error */
  public final void a(android.os.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 72	com/tencent/mm/vfs/MigrationFileSystem:AQe	Z
    //   9: ifeq +1945 -> 1954
    //   12: iconst_0
    //   13: istore 13
    //   15: iconst_0
    //   16: istore 12
    //   18: iconst_0
    //   19: istore 7
    //   21: iconst_0
    //   22: istore 11
    //   24: iconst_0
    //   25: istore 6
    //   27: iconst_0
    //   28: istore 16
    //   30: iconst_0
    //   31: istore 5
    //   33: iconst_0
    //   34: istore 17
    //   36: iconst_0
    //   37: istore_2
    //   38: iconst_0
    //   39: istore 18
    //   41: iconst_0
    //   42: istore_3
    //   43: iconst_0
    //   44: istore 19
    //   46: iconst_0
    //   47: istore 4
    //   49: lconst_0
    //   50: lstore 20
    //   52: iload 19
    //   54: istore 14
    //   56: iload 18
    //   58: istore 10
    //   60: iload 17
    //   62: istore 15
    //   64: lload 20
    //   66: lstore 22
    //   68: iload 16
    //   70: istore 9
    //   72: iload 11
    //   74: istore 8
    //   76: aload_0
    //   77: getfield 56	com/tencent/mm/vfs/MigrationFileSystem:APi	[Lcom/tencent/mm/vfs/FileSystem;
    //   80: iconst_0
    //   81: aaload
    //   82: astore 34
    //   84: iload 19
    //   86: istore 14
    //   88: iload 18
    //   90: istore 10
    //   92: iload 17
    //   94: istore 15
    //   96: lload 20
    //   98: lstore 22
    //   100: iload 16
    //   102: istore 9
    //   104: iload 11
    //   106: istore 8
    //   108: new 132	java/util/HashSet
    //   111: dup
    //   112: invokespecial 133	java/util/HashSet:<init>	()V
    //   115: astore 35
    //   117: iload 19
    //   119: istore 14
    //   121: iload 18
    //   123: istore 10
    //   125: iload 17
    //   127: istore 15
    //   129: lload 20
    //   131: lstore 22
    //   133: iload 16
    //   135: istore 9
    //   137: iload 11
    //   139: istore 8
    //   141: sipush 4096
    //   144: newarray byte
    //   146: astore 36
    //   148: iload 19
    //   150: istore 14
    //   152: iload 18
    //   154: istore 10
    //   156: iload 17
    //   158: istore 15
    //   160: lload 20
    //   162: lstore 22
    //   164: iload 16
    //   166: istore 9
    //   168: iload 11
    //   170: istore 8
    //   172: aload_1
    //   173: invokevirtual 138	android/os/CancellationSignal:throwIfCanceled	()V
    //   176: iload 19
    //   178: istore 14
    //   180: iload 18
    //   182: istore 10
    //   184: iload 17
    //   186: istore 15
    //   188: lload 20
    //   190: lstore 22
    //   192: iload 16
    //   194: istore 9
    //   196: iload 11
    //   198: istore 8
    //   200: aload_0
    //   201: iconst_1
    //   202: iconst_2
    //   203: anewarray 36	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: ldc 140
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: aload 34
    //   215: aastore
    //   216: invokevirtual 144	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   219: iload 19
    //   221: istore 14
    //   223: iload 18
    //   225: istore 10
    //   227: iload 17
    //   229: istore 15
    //   231: lload 20
    //   233: lstore 22
    //   235: iload 16
    //   237: istore 9
    //   239: iload 11
    //   241: istore 8
    //   243: aload_0
    //   244: getfield 56	com/tencent/mm/vfs/MigrationFileSystem:APi	[Lcom/tencent/mm/vfs/FileSystem;
    //   247: arraylength
    //   248: istore 17
    //   250: iconst_1
    //   251: istore 16
    //   253: iload 16
    //   255: iload 17
    //   257: if_icmpge +1518 -> 1775
    //   260: iload 4
    //   262: istore 14
    //   264: iload_3
    //   265: istore 10
    //   267: iload_2
    //   268: istore 15
    //   270: lload 20
    //   272: lstore 22
    //   274: iload 5
    //   276: istore 9
    //   278: iload 6
    //   280: istore 8
    //   282: aload_1
    //   283: invokevirtual 138	android/os/CancellationSignal:throwIfCanceled	()V
    //   286: iload 4
    //   288: istore 14
    //   290: iload_3
    //   291: istore 10
    //   293: iload_2
    //   294: istore 15
    //   296: lload 20
    //   298: lstore 22
    //   300: iload 5
    //   302: istore 9
    //   304: iload 6
    //   306: istore 8
    //   308: aload_0
    //   309: getfield 56	com/tencent/mm/vfs/MigrationFileSystem:APi	[Lcom/tencent/mm/vfs/FileSystem;
    //   312: iload 16
    //   314: aaload
    //   315: astore 37
    //   317: iload 4
    //   319: istore 14
    //   321: iload_3
    //   322: istore 10
    //   324: iload_2
    //   325: istore 15
    //   327: lload 20
    //   329: lstore 22
    //   331: iload 5
    //   333: istore 9
    //   335: iload 6
    //   337: istore 8
    //   339: aload 37
    //   341: ldc 146
    //   343: iconst_1
    //   344: invokeinterface 99 3 0
    //   349: astore 24
    //   351: aload 24
    //   353: ifnull +1720 -> 2073
    //   356: iload 4
    //   358: istore 14
    //   360: iload_3
    //   361: istore 10
    //   363: iload_2
    //   364: istore 15
    //   366: lload 20
    //   368: lstore 22
    //   370: iload 5
    //   372: istore 9
    //   374: iload 6
    //   376: istore 8
    //   378: aload 24
    //   380: invokeinterface 150 1 0
    //   385: ifne +1688 -> 2073
    //   388: iload 4
    //   390: istore 14
    //   392: iload_3
    //   393: istore 10
    //   395: iload_2
    //   396: istore 15
    //   398: lload 20
    //   400: lstore 22
    //   402: iload 5
    //   404: istore 9
    //   406: iload 6
    //   408: istore 8
    //   410: aload 24
    //   412: invokeinterface 154 1 0
    //   417: astore 25
    //   419: iload 7
    //   421: istore 11
    //   423: iload 4
    //   425: istore 14
    //   427: iload_3
    //   428: istore 10
    //   430: iload_2
    //   431: istore 15
    //   433: lload 20
    //   435: lstore 22
    //   437: iload 5
    //   439: istore 9
    //   441: iload 6
    //   443: istore 8
    //   445: aload 25
    //   447: invokeinterface 159 1 0
    //   452: ifeq +110 -> 562
    //   455: iload 4
    //   457: istore 14
    //   459: iload_3
    //   460: istore 10
    //   462: iload_2
    //   463: istore 15
    //   465: lload 20
    //   467: lstore 22
    //   469: iload 5
    //   471: istore 9
    //   473: iload 6
    //   475: istore 8
    //   477: aload 25
    //   479: invokeinterface 163 1 0
    //   484: checkcast 165	com/tencent/mm/vfs/FileSystem$a
    //   487: astore 26
    //   489: iload 4
    //   491: istore 14
    //   493: iload_3
    //   494: istore 10
    //   496: iload_2
    //   497: istore 15
    //   499: lload 20
    //   501: lstore 22
    //   503: iload 5
    //   505: istore 9
    //   507: iload 6
    //   509: istore 8
    //   511: aload 26
    //   513: getfield 168	com/tencent/mm/vfs/FileSystem$a:APu	Z
    //   516: ifeq +1567 -> 2083
    //   519: iload 12
    //   521: iconst_1
    //   522: iadd
    //   523: istore 12
    //   525: iload 4
    //   527: istore 14
    //   529: iload_3
    //   530: istore 10
    //   532: iload_2
    //   533: istore 15
    //   535: lload 20
    //   537: lstore 22
    //   539: iload 5
    //   541: istore 9
    //   543: iload 6
    //   545: istore 8
    //   547: iload 11
    //   549: i2l
    //   550: aload 26
    //   552: getfield 172	com/tencent/mm/vfs/FileSystem$a:APs	J
    //   555: ladd
    //   556: l2i
    //   557: istore 11
    //   559: goto -136 -> 423
    //   562: iload 4
    //   564: istore 14
    //   566: iload_3
    //   567: istore 10
    //   569: iload_2
    //   570: istore 15
    //   572: lload 20
    //   574: lstore 22
    //   576: iload 5
    //   578: istore 9
    //   580: iload 6
    //   582: istore 8
    //   584: aload 37
    //   586: invokeinterface 175 1 0
    //   591: bipush 33
    //   593: iand
    //   594: bipush 33
    //   596: if_icmpne +196 -> 792
    //   599: iload 4
    //   601: istore 14
    //   603: iload_3
    //   604: istore 10
    //   606: iload_2
    //   607: istore 15
    //   609: lload 20
    //   611: lstore 22
    //   613: iload 5
    //   615: istore 9
    //   617: iload 6
    //   619: istore 8
    //   621: new 177	java/util/TreeSet
    //   624: dup
    //   625: invokespecial 178	java/util/TreeSet:<init>	()V
    //   628: astore 28
    //   630: iload 4
    //   632: istore 14
    //   634: iload_3
    //   635: istore 10
    //   637: iload_2
    //   638: istore 15
    //   640: lload 20
    //   642: lstore 22
    //   644: iload 5
    //   646: istore 9
    //   648: iload 6
    //   650: istore 8
    //   652: aload 24
    //   654: invokeinterface 154 1 0
    //   659: astore 38
    //   661: iload_2
    //   662: istore 7
    //   664: iload 6
    //   666: istore_2
    //   667: iload 7
    //   669: istore 6
    //   671: iload_2
    //   672: istore 8
    //   674: aload 38
    //   676: invokeinterface 159 1 0
    //   681: ifeq +1005 -> 1686
    //   684: iload_2
    //   685: istore 8
    //   687: aload 38
    //   689: invokeinterface 163 1 0
    //   694: checkcast 165	com/tencent/mm/vfs/FileSystem$a
    //   697: astore 39
    //   699: iload_2
    //   700: istore 8
    //   702: aload_1
    //   703: invokevirtual 138	android/os/CancellationSignal:throwIfCanceled	()V
    //   706: iload_2
    //   707: istore 8
    //   709: aload 39
    //   711: getfield 168	com/tencent/mm/vfs/FileSystem$a:APu	Z
    //   714: ifeq +84 -> 798
    //   717: iload_2
    //   718: istore 8
    //   720: aload 35
    //   722: aload 39
    //   724: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   727: invokevirtual 186	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   730: ifeq +1340 -> 2070
    //   733: iload_2
    //   734: istore 8
    //   736: aload 34
    //   738: aload 39
    //   740: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   743: invokeinterface 189 2 0
    //   748: pop
    //   749: iload_2
    //   750: iconst_1
    //   751: iadd
    //   752: istore_2
    //   753: iload 4
    //   755: istore 9
    //   757: iload_3
    //   758: istore 10
    //   760: iload_2
    //   761: istore 8
    //   763: aload 28
    //   765: ifnull +908 -> 1673
    //   768: iload 4
    //   770: istore 8
    //   772: iload_3
    //   773: istore 9
    //   775: iload_2
    //   776: istore 15
    //   778: aload 28
    //   780: aload 39
    //   782: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   785: invokevirtual 190	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   788: pop
    //   789: goto -118 -> 671
    //   792: aconst_null
    //   793: astore 28
    //   795: goto -165 -> 630
    //   798: iload_2
    //   799: istore 8
    //   801: aload 39
    //   803: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   806: invokestatic 194	com/tencent/mm/vfs/j:avQ	(Ljava/lang/String;)Ljava/lang/String;
    //   809: astore 31
    //   811: iload_2
    //   812: istore 8
    //   814: aload 31
    //   816: ifnull +62 -> 878
    //   819: iload_2
    //   820: istore 7
    //   822: iload_2
    //   823: istore 8
    //   825: aload 35
    //   827: aload 31
    //   829: invokevirtual 186	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   832: ifeq +21 -> 853
    //   835: iload_2
    //   836: istore 8
    //   838: aload 34
    //   840: aload 31
    //   842: invokeinterface 189 2 0
    //   847: pop
    //   848: iload_2
    //   849: iconst_1
    //   850: iadd
    //   851: istore 7
    //   853: iload 7
    //   855: istore 8
    //   857: aload 28
    //   859: ifnull +19 -> 878
    //   862: iload 7
    //   864: istore 8
    //   866: aload 28
    //   868: aload 31
    //   870: invokevirtual 190	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   873: pop
    //   874: iload 7
    //   876: istore 8
    //   878: iload 8
    //   880: istore_2
    //   881: iload 4
    //   883: istore 8
    //   885: iload_3
    //   886: istore 9
    //   888: iload_2
    //   889: istore 15
    //   891: aload 34
    //   893: aload 39
    //   895: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   898: invokeinterface 124 2 0
    //   903: ifeq +35 -> 938
    //   906: iload 4
    //   908: istore 8
    //   910: iload_3
    //   911: istore 9
    //   913: iload_2
    //   914: istore 15
    //   916: aload 37
    //   918: aload 39
    //   920: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   923: invokeinterface 197 2 0
    //   928: pop
    //   929: iload 6
    //   931: iconst_1
    //   932: iadd
    //   933: istore 6
    //   935: goto -264 -> 671
    //   938: aconst_null
    //   939: astore 27
    //   941: aconst_null
    //   942: astore 25
    //   944: aconst_null
    //   945: astore 32
    //   947: aconst_null
    //   948: astore 30
    //   950: iload_3
    //   951: istore 7
    //   953: aload 30
    //   955: astore 24
    //   957: iload 4
    //   959: istore 14
    //   961: iload_3
    //   962: istore 10
    //   964: aload 32
    //   966: astore 26
    //   968: aload 37
    //   970: aload 39
    //   972: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   975: invokeinterface 201 2 0
    //   980: astore 29
    //   982: iload_3
    //   983: istore 7
    //   985: aload 30
    //   987: astore 24
    //   989: aload 29
    //   991: astore 25
    //   993: iload 4
    //   995: istore 14
    //   997: iload_3
    //   998: istore 10
    //   1000: aload 32
    //   1002: astore 26
    //   1004: aload 29
    //   1006: astore 27
    //   1008: aload 34
    //   1010: aload 39
    //   1012: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   1015: iconst_0
    //   1016: invokeinterface 91 3 0
    //   1021: astore 30
    //   1023: iload_3
    //   1024: istore 7
    //   1026: aload 30
    //   1028: astore 24
    //   1030: aload 29
    //   1032: astore 25
    //   1034: iload 4
    //   1036: istore 14
    //   1038: iload_3
    //   1039: istore 10
    //   1041: aload 30
    //   1043: astore 26
    //   1045: aload 29
    //   1047: astore 27
    //   1049: aload 29
    //   1051: aload 36
    //   1053: invokevirtual 207	java/io/InputStream:read	([B)I
    //   1056: istore 8
    //   1058: iload 8
    //   1060: ifle +172 -> 1232
    //   1063: iload_3
    //   1064: istore 7
    //   1066: aload 30
    //   1068: astore 24
    //   1070: aload 29
    //   1072: astore 25
    //   1074: iload 4
    //   1076: istore 14
    //   1078: iload_3
    //   1079: istore 10
    //   1081: aload 30
    //   1083: astore 26
    //   1085: aload 29
    //   1087: astore 27
    //   1089: aload 30
    //   1091: aload 36
    //   1093: iconst_0
    //   1094: iload 8
    //   1096: invokevirtual 213	java/io/OutputStream:write	([BII)V
    //   1099: goto -76 -> 1023
    //   1102: astore 26
    //   1104: iload 4
    //   1106: iconst_1
    //   1107: iadd
    //   1108: istore 4
    //   1110: iload 4
    //   1112: istore 14
    //   1114: iload 7
    //   1116: istore 10
    //   1118: aload 24
    //   1120: astore 26
    //   1122: aload 25
    //   1124: astore 27
    //   1126: ldc 215
    //   1128: new 217	java/lang/StringBuilder
    //   1131: dup
    //   1132: ldc 219
    //   1134: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1137: aload 39
    //   1139: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   1142: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: ldc 228
    //   1147: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload_0
    //   1151: invokevirtual 232	com/tencent/mm/vfs/MigrationFileSystem:toString	()Ljava/lang/String;
    //   1154: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: ldc 234
    //   1159: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 241	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1168: aload 28
    //   1170: ifnull +222 -> 1392
    //   1173: aload 31
    //   1175: astore 29
    //   1177: aload 29
    //   1179: ifnull +213 -> 1392
    //   1182: iload 4
    //   1184: istore 14
    //   1186: iload 7
    //   1188: istore 10
    //   1190: aload 24
    //   1192: astore 26
    //   1194: aload 25
    //   1196: astore 27
    //   1198: aload 28
    //   1200: aload 29
    //   1202: invokevirtual 244	java/util/TreeSet:remove	(Ljava/lang/Object;)Z
    //   1205: pop
    //   1206: iload 4
    //   1208: istore 14
    //   1210: iload 7
    //   1212: istore 10
    //   1214: aload 24
    //   1216: astore 26
    //   1218: aload 25
    //   1220: astore 27
    //   1222: aload 29
    //   1224: invokestatic 194	com/tencent/mm/vfs/j:avQ	(Ljava/lang/String;)Ljava/lang/String;
    //   1227: astore 29
    //   1229: goto -52 -> 1177
    //   1232: iload_3
    //   1233: istore 7
    //   1235: aload 30
    //   1237: astore 24
    //   1239: aload 29
    //   1241: astore 25
    //   1243: iload 4
    //   1245: istore 14
    //   1247: iload_3
    //   1248: istore 10
    //   1250: aload 30
    //   1252: astore 26
    //   1254: aload 29
    //   1256: astore 27
    //   1258: aload 29
    //   1260: invokevirtual 247	java/io/InputStream:close	()V
    //   1263: aconst_null
    //   1264: astore 32
    //   1266: aconst_null
    //   1267: astore 29
    //   1269: iload_3
    //   1270: istore 7
    //   1272: aload 30
    //   1274: astore 24
    //   1276: aload 29
    //   1278: astore 25
    //   1280: iload 4
    //   1282: istore 14
    //   1284: iload_3
    //   1285: istore 10
    //   1287: aload 30
    //   1289: astore 26
    //   1291: aload 32
    //   1293: astore 27
    //   1295: aload 30
    //   1297: invokevirtual 248	java/io/OutputStream:close	()V
    //   1300: aconst_null
    //   1301: astore 33
    //   1303: aconst_null
    //   1304: astore 30
    //   1306: iload_3
    //   1307: istore 7
    //   1309: aload 30
    //   1311: astore 24
    //   1313: aload 29
    //   1315: astore 25
    //   1317: iload 4
    //   1319: istore 14
    //   1321: iload_3
    //   1322: istore 10
    //   1324: aload 33
    //   1326: astore 26
    //   1328: aload 32
    //   1330: astore 27
    //   1332: aload 37
    //   1334: aload 39
    //   1336: getfield 182	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   1339: invokeinterface 197 2 0
    //   1344: pop
    //   1345: iload_3
    //   1346: iconst_1
    //   1347: iadd
    //   1348: istore_3
    //   1349: iload_3
    //   1350: istore 7
    //   1352: aload 30
    //   1354: astore 24
    //   1356: aload 29
    //   1358: astore 25
    //   1360: iload 4
    //   1362: istore 14
    //   1364: iload_3
    //   1365: istore 10
    //   1367: aload 33
    //   1369: astore 26
    //   1371: aload 32
    //   1373: astore 27
    //   1375: aload 39
    //   1377: getfield 172	com/tencent/mm/vfs/FileSystem$a:APs	J
    //   1380: lstore 22
    //   1382: lload 20
    //   1384: lload 22
    //   1386: ladd
    //   1387: lstore 20
    //   1389: goto -718 -> 671
    //   1392: aload 25
    //   1394: ifnull +19 -> 1413
    //   1397: iload 4
    //   1399: istore 8
    //   1401: iload 7
    //   1403: istore 9
    //   1405: iload_2
    //   1406: istore 15
    //   1408: aload 25
    //   1410: invokevirtual 247	java/io/InputStream:close	()V
    //   1413: iload 4
    //   1415: istore 9
    //   1417: iload 7
    //   1419: istore 10
    //   1421: iload_2
    //   1422: istore 8
    //   1424: aload 24
    //   1426: ifnull +247 -> 1673
    //   1429: iload 4
    //   1431: istore 8
    //   1433: iload 7
    //   1435: istore 9
    //   1437: iload_2
    //   1438: istore 15
    //   1440: aload 24
    //   1442: invokevirtual 248	java/io/OutputStream:close	()V
    //   1445: iload 7
    //   1447: istore_3
    //   1448: goto -777 -> 671
    //   1451: astore 24
    //   1453: iload 7
    //   1455: istore_3
    //   1456: goto -785 -> 671
    //   1459: astore_1
    //   1460: aload 27
    //   1462: ifnull +19 -> 1481
    //   1465: iload 14
    //   1467: istore 8
    //   1469: iload 10
    //   1471: istore 9
    //   1473: iload_2
    //   1474: istore 15
    //   1476: aload 27
    //   1478: invokevirtual 247	java/io/InputStream:close	()V
    //   1481: aload 26
    //   1483: ifnull +19 -> 1502
    //   1486: iload 14
    //   1488: istore 8
    //   1490: iload 10
    //   1492: istore 9
    //   1494: iload_2
    //   1495: istore 15
    //   1497: aload 26
    //   1499: invokevirtual 248	java/io/OutputStream:close	()V
    //   1502: iload 14
    //   1504: istore 8
    //   1506: iload 10
    //   1508: istore 9
    //   1510: iload_2
    //   1511: istore 15
    //   1513: ldc 130
    //   1515: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1518: iload 14
    //   1520: istore 8
    //   1522: iload 10
    //   1524: istore 9
    //   1526: iload_2
    //   1527: istore 15
    //   1529: aload_1
    //   1530: athrow
    //   1531: astore_1
    //   1532: iload 15
    //   1534: istore_2
    //   1535: iload 9
    //   1537: istore_3
    //   1538: iload 8
    //   1540: istore 4
    //   1542: aload_1
    //   1543: instanceof 250
    //   1546: ifeq +450 -> 1996
    //   1549: iconst_4
    //   1550: istore 7
    //   1552: aload_0
    //   1553: iload 7
    //   1555: bipush 14
    //   1557: anewarray 36	java/lang/Object
    //   1560: dup
    //   1561: iconst_0
    //   1562: ldc 140
    //   1564: aastore
    //   1565: dup
    //   1566: iconst_1
    //   1567: aload_0
    //   1568: getfield 56	com/tencent/mm/vfs/MigrationFileSystem:APi	[Lcom/tencent/mm/vfs/FileSystem;
    //   1571: iconst_0
    //   1572: aaload
    //   1573: aastore
    //   1574: dup
    //   1575: iconst_2
    //   1576: ldc 252
    //   1578: aastore
    //   1579: dup
    //   1580: iconst_3
    //   1581: iload_2
    //   1582: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1585: aastore
    //   1586: dup
    //   1587: iconst_4
    //   1588: ldc_w 260
    //   1591: aastore
    //   1592: dup
    //   1593: iconst_5
    //   1594: iload 5
    //   1596: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1599: aastore
    //   1600: dup
    //   1601: bipush 6
    //   1603: ldc_w 262
    //   1606: aastore
    //   1607: dup
    //   1608: bipush 7
    //   1610: iload 6
    //   1612: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1615: aastore
    //   1616: dup
    //   1617: bipush 8
    //   1619: ldc_w 264
    //   1622: aastore
    //   1623: dup
    //   1624: bipush 9
    //   1626: iload_3
    //   1627: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1630: aastore
    //   1631: dup
    //   1632: bipush 10
    //   1634: ldc_w 266
    //   1637: aastore
    //   1638: dup
    //   1639: bipush 11
    //   1641: iload 4
    //   1643: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1646: aastore
    //   1647: dup
    //   1648: bipush 12
    //   1650: ldc_w 268
    //   1653: aastore
    //   1654: dup
    //   1655: bipush 13
    //   1657: lload 20
    //   1659: invokestatic 273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1662: aastore
    //   1663: invokevirtual 144	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   1666: ldc 130
    //   1668: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1671: aload_1
    //   1672: athrow
    //   1673: iload 9
    //   1675: istore 4
    //   1677: iload 8
    //   1679: istore_2
    //   1680: iload 10
    //   1682: istore_3
    //   1683: goto -1012 -> 671
    //   1686: aload 28
    //   1688: ifnull +372 -> 2060
    //   1691: iload_2
    //   1692: istore 8
    //   1694: aload 28
    //   1696: invokevirtual 277	java/util/TreeSet:descendingSet	()Ljava/util/NavigableSet;
    //   1699: invokeinterface 280 1 0
    //   1704: astore 24
    //   1706: aload 24
    //   1708: invokeinterface 159 1 0
    //   1713: ifeq +39 -> 1752
    //   1716: aload 24
    //   1718: invokeinterface 163 1 0
    //   1723: checkcast 282	java/lang/String
    //   1726: astore 25
    //   1728: aload_1
    //   1729: invokevirtual 138	android/os/CancellationSignal:throwIfCanceled	()V
    //   1732: aload 37
    //   1734: aload 25
    //   1736: iconst_0
    //   1737: invokeinterface 115 3 0
    //   1742: pop
    //   1743: iload 5
    //   1745: iconst_1
    //   1746: iadd
    //   1747: istore 5
    //   1749: goto -43 -> 1706
    //   1752: iload 6
    //   1754: istore 7
    //   1756: iload_2
    //   1757: istore 6
    //   1759: iload 16
    //   1761: iconst_1
    //   1762: iadd
    //   1763: istore 16
    //   1765: iload 7
    //   1767: istore_2
    //   1768: iload 11
    //   1770: istore 7
    //   1772: goto -1519 -> 253
    //   1775: iload 4
    //   1777: istore 14
    //   1779: iload_3
    //   1780: istore 10
    //   1782: iload_2
    //   1783: istore 15
    //   1785: lload 20
    //   1787: lstore 22
    //   1789: iload 5
    //   1791: istore 9
    //   1793: iload 6
    //   1795: istore 8
    //   1797: aload_0
    //   1798: iconst_3
    //   1799: bipush 20
    //   1801: anewarray 36	java/lang/Object
    //   1804: dup
    //   1805: iconst_0
    //   1806: ldc 140
    //   1808: aastore
    //   1809: dup
    //   1810: iconst_1
    //   1811: aload 34
    //   1813: aastore
    //   1814: dup
    //   1815: iconst_2
    //   1816: ldc_w 284
    //   1819: aastore
    //   1820: dup
    //   1821: iconst_3
    //   1822: iload 13
    //   1824: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1827: aastore
    //   1828: dup
    //   1829: iconst_4
    //   1830: ldc_w 286
    //   1833: aastore
    //   1834: dup
    //   1835: iconst_5
    //   1836: iload 12
    //   1838: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1841: aastore
    //   1842: dup
    //   1843: bipush 6
    //   1845: ldc_w 288
    //   1848: aastore
    //   1849: dup
    //   1850: bipush 7
    //   1852: iload 7
    //   1854: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1857: aastore
    //   1858: dup
    //   1859: bipush 8
    //   1861: ldc 252
    //   1863: aastore
    //   1864: dup
    //   1865: bipush 9
    //   1867: iload 6
    //   1869: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1872: aastore
    //   1873: dup
    //   1874: bipush 10
    //   1876: ldc_w 260
    //   1879: aastore
    //   1880: dup
    //   1881: bipush 11
    //   1883: iload 5
    //   1885: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1888: aastore
    //   1889: dup
    //   1890: bipush 12
    //   1892: ldc_w 262
    //   1895: aastore
    //   1896: dup
    //   1897: bipush 13
    //   1899: iload_2
    //   1900: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1903: aastore
    //   1904: dup
    //   1905: bipush 14
    //   1907: ldc_w 264
    //   1910: aastore
    //   1911: dup
    //   1912: bipush 15
    //   1914: iload_3
    //   1915: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1918: aastore
    //   1919: dup
    //   1920: bipush 16
    //   1922: ldc_w 266
    //   1925: aastore
    //   1926: dup
    //   1927: bipush 17
    //   1929: iload 4
    //   1931: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1934: aastore
    //   1935: dup
    //   1936: bipush 18
    //   1938: ldc_w 268
    //   1941: aastore
    //   1942: dup
    //   1943: bipush 19
    //   1945: lload 20
    //   1947: invokestatic 273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1950: aastore
    //   1951: invokevirtual 144	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
    //   1954: aload_0
    //   1955: getfield 56	com/tencent/mm/vfs/MigrationFileSystem:APi	[Lcom/tencent/mm/vfs/FileSystem;
    //   1958: astore 24
    //   1960: aload 24
    //   1962: arraylength
    //   1963: istore_3
    //   1964: iconst_0
    //   1965: istore_2
    //   1966: iload_2
    //   1967: iload_3
    //   1968: if_icmpge +34 -> 2002
    //   1971: aload 24
    //   1973: iload_2
    //   1974: aaload
    //   1975: astore 25
    //   1977: aload_1
    //   1978: invokevirtual 138	android/os/CancellationSignal:throwIfCanceled	()V
    //   1981: aload 25
    //   1983: aload_1
    //   1984: invokeinterface 290 2 0
    //   1989: iload_2
    //   1990: iconst_1
    //   1991: iadd
    //   1992: istore_2
    //   1993: goto -27 -> 1966
    //   1996: iconst_5
    //   1997: istore 7
    //   1999: goto -447 -> 1552
    //   2002: ldc 130
    //   2004: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2007: return
    //   2008: astore 25
    //   2010: goto -597 -> 1413
    //   2013: astore 24
    //   2015: goto -534 -> 1481
    //   2018: astore 24
    //   2020: goto -518 -> 1502
    //   2023: astore_1
    //   2024: iload 15
    //   2026: istore 6
    //   2028: iload 14
    //   2030: istore 4
    //   2032: iload 10
    //   2034: istore_3
    //   2035: lload 22
    //   2037: lstore 20
    //   2039: iload 9
    //   2041: istore 5
    //   2043: iload 8
    //   2045: istore_2
    //   2046: goto -504 -> 1542
    //   2049: astore_1
    //   2050: iload 8
    //   2052: istore_2
    //   2053: goto -511 -> 1542
    //   2056: astore_1
    //   2057: goto -515 -> 1542
    //   2060: iload 6
    //   2062: istore 7
    //   2064: iload_2
    //   2065: istore 6
    //   2067: goto -308 -> 1759
    //   2070: goto -1317 -> 753
    //   2073: iload 7
    //   2075: istore 11
    //   2077: iload_2
    //   2078: istore 7
    //   2080: goto -321 -> 1759
    //   2083: iload 13
    //   2085: iconst_1
    //   2086: iadd
    //   2087: istore 13
    //   2089: goto -1564 -> 525
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2092	0	this	MigrationFileSystem
    //   0	2092	1	paramCancellationSignal	android.os.CancellationSignal
    //   37	2041	2	i	int
    //   42	1993	3	j	int
    //   47	1984	4	k	int
    //   31	2011	5	m	int
    //   25	2041	6	n	int
    //   19	2060	7	i1	int
    //   74	1977	8	i2	int
    //   70	1970	9	i3	int
    //   58	1975	10	i4	int
    //   22	2054	11	i5	int
    //   16	1821	12	i6	int
    //   13	2075	13	i7	int
    //   54	1975	14	i8	int
    //   62	1963	15	i9	int
    //   28	1736	16	i10	int
    //   34	224	17	i11	int
    //   39	185	18	i12	int
    //   44	176	19	i13	int
    //   50	1988	20	l1	long
    //   66	1970	22	l2	long
    //   349	1092	24	localObject1	Object
    //   1451	1	24	localIOException1	IOException
    //   1704	268	24	localObject2	Object
    //   2013	1	24	localIOException2	IOException
    //   2018	1	24	localIOException3	IOException
    //   417	1565	25	localObject3	Object
    //   2008	1	25	localIOException4	IOException
    //   487	597	26	localObject4	Object
    //   1102	1	26	localIOException5	IOException
    //   1120	378	26	localObject5	Object
    //   939	538	27	localObject6	Object
    //   628	1067	28	localTreeSet	java.util.TreeSet
    //   980	377	29	localObject7	Object
    //   948	405	30	localOutputStream	OutputStream
    //   809	365	31	str	String
    //   945	427	32	localObject8	Object
    //   1301	67	33	localObject9	Object
    //   82	1730	34	localFileSystem1	FileSystem
    //   115	711	35	localHashSet	java.util.HashSet
    //   146	946	36	arrayOfByte	byte[]
    //   315	1418	37	localFileSystem2	FileSystem
    //   659	29	38	localIterator	java.util.Iterator
    //   697	679	39	locala	FileSystem.a
    // Exception table:
    //   from	to	target	type
    //   968	982	1102	java/io/IOException
    //   1008	1023	1102	java/io/IOException
    //   1049	1058	1102	java/io/IOException
    //   1089	1099	1102	java/io/IOException
    //   1258	1263	1102	java/io/IOException
    //   1295	1300	1102	java/io/IOException
    //   1332	1345	1102	java/io/IOException
    //   1375	1382	1102	java/io/IOException
    //   1440	1445	1451	java/io/IOException
    //   968	982	1459	finally
    //   1008	1023	1459	finally
    //   1049	1058	1459	finally
    //   1089	1099	1459	finally
    //   1126	1168	1459	finally
    //   1198	1206	1459	finally
    //   1222	1229	1459	finally
    //   1258	1263	1459	finally
    //   1295	1300	1459	finally
    //   1332	1345	1459	finally
    //   1375	1382	1459	finally
    //   778	789	1531	java/lang/Exception
    //   891	906	1531	java/lang/Exception
    //   916	929	1531	java/lang/Exception
    //   1408	1413	1531	java/lang/Exception
    //   1440	1445	1531	java/lang/Exception
    //   1476	1481	1531	java/lang/Exception
    //   1497	1502	1531	java/lang/Exception
    //   1513	1518	1531	java/lang/Exception
    //   1529	1531	1531	java/lang/Exception
    //   1408	1413	2008	java/io/IOException
    //   1476	1481	2013	java/io/IOException
    //   1497	1502	2018	java/io/IOException
    //   76	84	2023	java/lang/Exception
    //   108	117	2023	java/lang/Exception
    //   141	148	2023	java/lang/Exception
    //   172	176	2023	java/lang/Exception
    //   200	219	2023	java/lang/Exception
    //   243	250	2023	java/lang/Exception
    //   282	286	2023	java/lang/Exception
    //   308	317	2023	java/lang/Exception
    //   339	351	2023	java/lang/Exception
    //   378	388	2023	java/lang/Exception
    //   410	419	2023	java/lang/Exception
    //   445	455	2023	java/lang/Exception
    //   477	489	2023	java/lang/Exception
    //   511	519	2023	java/lang/Exception
    //   547	559	2023	java/lang/Exception
    //   584	599	2023	java/lang/Exception
    //   621	630	2023	java/lang/Exception
    //   652	661	2023	java/lang/Exception
    //   1797	1954	2023	java/lang/Exception
    //   674	684	2049	java/lang/Exception
    //   687	699	2049	java/lang/Exception
    //   702	706	2049	java/lang/Exception
    //   709	717	2049	java/lang/Exception
    //   720	733	2049	java/lang/Exception
    //   736	749	2049	java/lang/Exception
    //   801	811	2049	java/lang/Exception
    //   825	835	2049	java/lang/Exception
    //   838	848	2049	java/lang/Exception
    //   866	874	2049	java/lang/Exception
    //   1694	1706	2049	java/lang/Exception
    //   1706	1743	2056	java/lang/Exception
  }
  
  public final boolean aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54549);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfFileSystem[i].aV(paramString1, paramString2))
      {
        AppMethodBeat.o(54549);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(54549);
    return false;
  }
  
  public final int ajj()
  {
    AppMethodBeat.i(54538);
    int i = this.APi[0].ajj();
    AppMethodBeat.o(54538);
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    AppMethodBeat.i(54542);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfFileSystem[i].exists(paramString))
      {
        AppMethodBeat.o(54542);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(54542);
    return false;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(54540);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfFileSystem[i];
      try
      {
        localObject = ((FileSystem)localObject).openRead(paramString);
        if (localObject != null)
        {
          AppMethodBeat.o(54540);
          return localObject;
        }
      }
      catch (IOException localIOException)
      {
        i += 1;
      }
    }
    paramString = new FileNotFoundException(paramString + " not found on all file systems.");
    AppMethodBeat.o(54540);
    throw paramString;
  }
  
  public final void q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(54551);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFileSystem[i].q(paramMap);
      i += 1;
    }
    AppMethodBeat.o(54551);
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(54545);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].qD(paramString);
      i += 1;
    }
    AppMethodBeat.o(54545);
    return bool1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(54553);
    Object localObject = new StringBuilder("MigrationFS [").append(this.APi[0].toString()).append(" <= ");
    int i = 1;
    while (i < this.APi.length)
    {
      ((StringBuilder)localObject).append(this.APi[i].toString()).append(", ");
      i += 1;
    }
    ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
    localObject = ']';
    AppMethodBeat.o(54553);
    return localObject;
  }
  
  public final FileSystem.b uk(String paramString)
  {
    AppMethodBeat.i(54539);
    paramString = this.APi[0].uk(paramString);
    AppMethodBeat.o(54539);
    return paramString;
  }
  
  public final FileSystem.a ul(String paramString)
  {
    AppMethodBeat.i(54543);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      FileSystem.a locala = arrayOfFileSystem[i].ul(paramString);
      if (locala != null)
      {
        AppMethodBeat.o(54543);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(54543);
    return null;
  }
  
  public final boolean um(String paramString)
  {
    AppMethodBeat.i(54547);
    boolean bool = this.APi[0].um(paramString);
    AppMethodBeat.o(54547);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(54554);
    paramParcel.writeInt(1);
    paramParcel.writeInt(this.APi.length);
    FileSystem[] arrayOfFileSystem = this.APi;
    int k = arrayOfFileSystem.length;
    int i = 0;
    while (i < k)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    if (this.AQe) {}
    for (paramInt = j;; paramInt = 1)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(54554);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */