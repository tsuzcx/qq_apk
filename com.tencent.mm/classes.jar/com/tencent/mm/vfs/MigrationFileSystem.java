package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
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
  public static final Parcelable.Creator<MigrationFileSystem> CREATOR = new Parcelable.Creator() {};
  private final FileSystem[] wuj;
  private final boolean wve;
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    j.a(paramParcel, getClass());
    int j = paramParcel.readInt();
    this.wuj = new FileSystem[j];
    int i = 0;
    while (i < j)
    {
      this.wuj[i] = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
      i += 1;
    }
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.wve = bool;
      return;
    }
  }
  
  public MigrationFileSystem(FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    this.wve = true;
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
      this.wuj = paramFileSystem;
      return;
    }
  }
  
  public final OutputStream I(String paramString, boolean paramBoolean)
  {
    return this.wuj[0].I(paramString, paramBoolean);
  }
  
  public final List<FileSystem.a> J(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      List localList = arrayOfFileSystem[i].J(paramString, paramBoolean);
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final boolean K(String paramString, boolean paramBoolean)
  {
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].K(paramString, paramBoolean);
      i += 1;
    }
    return bool1;
  }
  
  public final String L(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.wuj[0].L(paramString, true);
    }
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      FileSystem localFileSystem = arrayOfFileSystem[i];
      if (localFileSystem.exists(paramString)) {
        return localFileSystem.L(paramString, false);
      }
      i += 1;
    }
    return this.wuj[0].L(paramString, false);
  }
  
  public final int Qd()
  {
    return this.wuj[0].Qd();
  }
  
  /* Error */
  public final void a(android.os.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/tencent/mm/vfs/MigrationFileSystem:wve	Z
    //   4: ifeq +1914 -> 1918
    //   7: iconst_0
    //   8: istore 13
    //   10: iconst_0
    //   11: istore 12
    //   13: iconst_0
    //   14: istore 7
    //   16: iconst_0
    //   17: istore 11
    //   19: iconst_0
    //   20: istore 6
    //   22: iconst_0
    //   23: istore 16
    //   25: iconst_0
    //   26: istore 5
    //   28: iconst_0
    //   29: istore 17
    //   31: iconst_0
    //   32: istore_2
    //   33: iconst_0
    //   34: istore 18
    //   36: iconst_0
    //   37: istore_3
    //   38: iconst_0
    //   39: istore 19
    //   41: iconst_0
    //   42: istore 4
    //   44: lconst_0
    //   45: lstore 20
    //   47: iload 19
    //   49: istore 14
    //   51: iload 18
    //   53: istore 10
    //   55: iload 17
    //   57: istore 15
    //   59: lload 20
    //   61: lstore 22
    //   63: iload 16
    //   65: istore 9
    //   67: iload 11
    //   69: istore 8
    //   71: aload_0
    //   72: getfield 45	com/tencent/mm/vfs/MigrationFileSystem:wuj	[Lcom/tencent/mm/vfs/FileSystem;
    //   75: iconst_0
    //   76: aaload
    //   77: astore 34
    //   79: iload 19
    //   81: istore 14
    //   83: iload 18
    //   85: istore 10
    //   87: iload 17
    //   89: istore 15
    //   91: lload 20
    //   93: lstore 22
    //   95: iload 16
    //   97: istore 9
    //   99: iload 11
    //   101: istore 8
    //   103: new 113	java/util/HashSet
    //   106: dup
    //   107: invokespecial 114	java/util/HashSet:<init>	()V
    //   110: astore 35
    //   112: iload 19
    //   114: istore 14
    //   116: iload 18
    //   118: istore 10
    //   120: iload 17
    //   122: istore 15
    //   124: lload 20
    //   126: lstore 22
    //   128: iload 16
    //   130: istore 9
    //   132: iload 11
    //   134: istore 8
    //   136: sipush 4096
    //   139: newarray byte
    //   141: astore 36
    //   143: iload 19
    //   145: istore 14
    //   147: iload 18
    //   149: istore 10
    //   151: iload 17
    //   153: istore 15
    //   155: lload 20
    //   157: lstore 22
    //   159: iload 16
    //   161: istore 9
    //   163: iload 11
    //   165: istore 8
    //   167: aload_1
    //   168: invokevirtual 119	android/os/CancellationSignal:throwIfCanceled	()V
    //   171: iload 19
    //   173: istore 14
    //   175: iload 18
    //   177: istore 10
    //   179: iload 17
    //   181: istore 15
    //   183: lload 20
    //   185: lstore 22
    //   187: iload 16
    //   189: istore 9
    //   191: iload 11
    //   193: istore 8
    //   195: aload_0
    //   196: iconst_1
    //   197: iconst_2
    //   198: anewarray 25	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: ldc 121
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload 34
    //   210: aastore
    //   211: invokevirtual 125	com/tencent/mm/vfs/MigrationFileSystem:j	(I[Ljava/lang/Object;)V
    //   214: iload 19
    //   216: istore 14
    //   218: iload 18
    //   220: istore 10
    //   222: iload 17
    //   224: istore 15
    //   226: lload 20
    //   228: lstore 22
    //   230: iload 16
    //   232: istore 9
    //   234: iload 11
    //   236: istore 8
    //   238: aload_0
    //   239: getfield 45	com/tencent/mm/vfs/MigrationFileSystem:wuj	[Lcom/tencent/mm/vfs/FileSystem;
    //   242: arraylength
    //   243: istore 17
    //   245: iconst_1
    //   246: istore 16
    //   248: iload 16
    //   250: iload 17
    //   252: if_icmpge +1492 -> 1744
    //   255: iload 4
    //   257: istore 14
    //   259: iload_3
    //   260: istore 10
    //   262: iload_2
    //   263: istore 15
    //   265: lload 20
    //   267: lstore 22
    //   269: iload 5
    //   271: istore 9
    //   273: iload 6
    //   275: istore 8
    //   277: aload_1
    //   278: invokevirtual 119	android/os/CancellationSignal:throwIfCanceled	()V
    //   281: iload 4
    //   283: istore 14
    //   285: iload_3
    //   286: istore 10
    //   288: iload_2
    //   289: istore 15
    //   291: lload 20
    //   293: lstore 22
    //   295: iload 5
    //   297: istore 9
    //   299: iload 6
    //   301: istore 8
    //   303: aload_0
    //   304: getfield 45	com/tencent/mm/vfs/MigrationFileSystem:wuj	[Lcom/tencent/mm/vfs/FileSystem;
    //   307: iload 16
    //   309: aaload
    //   310: astore 37
    //   312: iload 4
    //   314: istore 14
    //   316: iload_3
    //   317: istore 10
    //   319: iload_2
    //   320: istore 15
    //   322: lload 20
    //   324: lstore 22
    //   326: iload 5
    //   328: istore 9
    //   330: iload 6
    //   332: istore 8
    //   334: aload 37
    //   336: ldc 127
    //   338: iconst_1
    //   339: invokeinterface 80 3 0
    //   344: astore 24
    //   346: aload 24
    //   348: ifnull +1684 -> 2032
    //   351: iload 4
    //   353: istore 14
    //   355: iload_3
    //   356: istore 10
    //   358: iload_2
    //   359: istore 15
    //   361: lload 20
    //   363: lstore 22
    //   365: iload 5
    //   367: istore 9
    //   369: iload 6
    //   371: istore 8
    //   373: aload 24
    //   375: invokeinterface 131 1 0
    //   380: ifne +1652 -> 2032
    //   383: iload 4
    //   385: istore 14
    //   387: iload_3
    //   388: istore 10
    //   390: iload_2
    //   391: istore 15
    //   393: lload 20
    //   395: lstore 22
    //   397: iload 5
    //   399: istore 9
    //   401: iload 6
    //   403: istore 8
    //   405: aload 24
    //   407: invokeinterface 135 1 0
    //   412: astore 25
    //   414: iload 7
    //   416: istore 11
    //   418: iload 4
    //   420: istore 14
    //   422: iload_3
    //   423: istore 10
    //   425: iload_2
    //   426: istore 15
    //   428: lload 20
    //   430: lstore 22
    //   432: iload 5
    //   434: istore 9
    //   436: iload 6
    //   438: istore 8
    //   440: aload 25
    //   442: invokeinterface 140 1 0
    //   447: ifeq +110 -> 557
    //   450: iload 4
    //   452: istore 14
    //   454: iload_3
    //   455: istore 10
    //   457: iload_2
    //   458: istore 15
    //   460: lload 20
    //   462: lstore 22
    //   464: iload 5
    //   466: istore 9
    //   468: iload 6
    //   470: istore 8
    //   472: aload 25
    //   474: invokeinterface 144 1 0
    //   479: checkcast 146	com/tencent/mm/vfs/FileSystem$a
    //   482: astore 26
    //   484: iload 4
    //   486: istore 14
    //   488: iload_3
    //   489: istore 10
    //   491: iload_2
    //   492: istore 15
    //   494: lload 20
    //   496: lstore 22
    //   498: iload 5
    //   500: istore 9
    //   502: iload 6
    //   504: istore 8
    //   506: aload 26
    //   508: getfield 149	com/tencent/mm/vfs/FileSystem$a:wuv	Z
    //   511: ifeq +1531 -> 2042
    //   514: iload 12
    //   516: iconst_1
    //   517: iadd
    //   518: istore 12
    //   520: iload 4
    //   522: istore 14
    //   524: iload_3
    //   525: istore 10
    //   527: iload_2
    //   528: istore 15
    //   530: lload 20
    //   532: lstore 22
    //   534: iload 5
    //   536: istore 9
    //   538: iload 6
    //   540: istore 8
    //   542: iload 11
    //   544: i2l
    //   545: aload 26
    //   547: getfield 152	com/tencent/mm/vfs/FileSystem$a:wut	J
    //   550: ladd
    //   551: l2i
    //   552: istore 11
    //   554: goto -136 -> 418
    //   557: iload 4
    //   559: istore 14
    //   561: iload_3
    //   562: istore 10
    //   564: iload_2
    //   565: istore 15
    //   567: lload 20
    //   569: lstore 22
    //   571: iload 5
    //   573: istore 9
    //   575: iload 6
    //   577: istore 8
    //   579: aload 37
    //   581: invokeinterface 106 1 0
    //   586: bipush 33
    //   588: iand
    //   589: bipush 33
    //   591: if_icmpne +196 -> 787
    //   594: iload 4
    //   596: istore 14
    //   598: iload_3
    //   599: istore 10
    //   601: iload_2
    //   602: istore 15
    //   604: lload 20
    //   606: lstore 22
    //   608: iload 5
    //   610: istore 9
    //   612: iload 6
    //   614: istore 8
    //   616: new 154	java/util/TreeSet
    //   619: dup
    //   620: invokespecial 155	java/util/TreeSet:<init>	()V
    //   623: astore 28
    //   625: iload 4
    //   627: istore 14
    //   629: iload_3
    //   630: istore 10
    //   632: iload_2
    //   633: istore 15
    //   635: lload 20
    //   637: lstore 22
    //   639: iload 5
    //   641: istore 9
    //   643: iload 6
    //   645: istore 8
    //   647: aload 24
    //   649: invokeinterface 135 1 0
    //   654: astore 38
    //   656: iload_2
    //   657: istore 7
    //   659: iload 6
    //   661: istore_2
    //   662: iload 7
    //   664: istore 6
    //   666: iload_2
    //   667: istore 8
    //   669: aload 38
    //   671: invokeinterface 140 1 0
    //   676: ifeq +979 -> 1655
    //   679: iload_2
    //   680: istore 8
    //   682: aload 38
    //   684: invokeinterface 144 1 0
    //   689: checkcast 146	com/tencent/mm/vfs/FileSystem$a
    //   692: astore 39
    //   694: iload_2
    //   695: istore 8
    //   697: aload_1
    //   698: invokevirtual 119	android/os/CancellationSignal:throwIfCanceled	()V
    //   701: iload_2
    //   702: istore 8
    //   704: aload 39
    //   706: getfield 149	com/tencent/mm/vfs/FileSystem$a:wuv	Z
    //   709: ifeq +84 -> 793
    //   712: iload_2
    //   713: istore 8
    //   715: aload 35
    //   717: aload 39
    //   719: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   722: invokevirtual 163	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   725: ifeq +1304 -> 2029
    //   728: iload_2
    //   729: istore 8
    //   731: aload 34
    //   733: aload 39
    //   735: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   738: invokeinterface 166 2 0
    //   743: pop
    //   744: iload_2
    //   745: iconst_1
    //   746: iadd
    //   747: istore_2
    //   748: iload 4
    //   750: istore 9
    //   752: iload_3
    //   753: istore 10
    //   755: iload_2
    //   756: istore 8
    //   758: aload 28
    //   760: ifnull +882 -> 1642
    //   763: iload 4
    //   765: istore 8
    //   767: iload_3
    //   768: istore 9
    //   770: iload_2
    //   771: istore 15
    //   773: aload 28
    //   775: aload 39
    //   777: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   780: invokevirtual 167	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   783: pop
    //   784: goto -118 -> 666
    //   787: aconst_null
    //   788: astore 28
    //   790: goto -165 -> 625
    //   793: iload_2
    //   794: istore 8
    //   796: aload 39
    //   798: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   801: invokestatic 171	com/tencent/mm/vfs/j:afa	(Ljava/lang/String;)Ljava/lang/String;
    //   804: astore 31
    //   806: iload_2
    //   807: istore 8
    //   809: aload 31
    //   811: ifnull +62 -> 873
    //   814: iload_2
    //   815: istore 7
    //   817: iload_2
    //   818: istore 8
    //   820: aload 35
    //   822: aload 31
    //   824: invokevirtual 163	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   827: ifeq +21 -> 848
    //   830: iload_2
    //   831: istore 8
    //   833: aload 34
    //   835: aload 31
    //   837: invokeinterface 166 2 0
    //   842: pop
    //   843: iload_2
    //   844: iconst_1
    //   845: iadd
    //   846: istore 7
    //   848: iload 7
    //   850: istore 8
    //   852: aload 28
    //   854: ifnull +19 -> 873
    //   857: iload 7
    //   859: istore 8
    //   861: aload 28
    //   863: aload 31
    //   865: invokevirtual 167	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   868: pop
    //   869: iload 7
    //   871: istore 8
    //   873: iload 8
    //   875: istore_2
    //   876: iload 4
    //   878: istore 8
    //   880: iload_3
    //   881: istore 9
    //   883: iload_2
    //   884: istore 15
    //   886: aload 34
    //   888: aload 39
    //   890: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   893: invokeinterface 103 2 0
    //   898: ifeq +35 -> 933
    //   901: iload 4
    //   903: istore 8
    //   905: iload_3
    //   906: istore 9
    //   908: iload_2
    //   909: istore 15
    //   911: aload 37
    //   913: aload 39
    //   915: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   918: invokeinterface 174 2 0
    //   923: pop
    //   924: iload 6
    //   926: iconst_1
    //   927: iadd
    //   928: istore 6
    //   930: goto -264 -> 666
    //   933: aconst_null
    //   934: astore 27
    //   936: aconst_null
    //   937: astore 25
    //   939: aconst_null
    //   940: astore 32
    //   942: aconst_null
    //   943: astore 30
    //   945: iload_3
    //   946: istore 7
    //   948: aload 30
    //   950: astore 24
    //   952: iload 4
    //   954: istore 14
    //   956: iload_3
    //   957: istore 10
    //   959: aload 32
    //   961: astore 26
    //   963: aload 37
    //   965: aload 39
    //   967: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   970: invokeinterface 178 2 0
    //   975: astore 29
    //   977: iload_3
    //   978: istore 7
    //   980: aload 30
    //   982: astore 24
    //   984: aload 29
    //   986: astore 25
    //   988: iload 4
    //   990: istore 14
    //   992: iload_3
    //   993: istore 10
    //   995: aload 32
    //   997: astore 26
    //   999: aload 29
    //   1001: astore 27
    //   1003: aload 34
    //   1005: aload 39
    //   1007: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   1010: iconst_0
    //   1011: invokeinterface 73 3 0
    //   1016: astore 30
    //   1018: iload_3
    //   1019: istore 7
    //   1021: aload 30
    //   1023: astore 24
    //   1025: aload 29
    //   1027: astore 25
    //   1029: iload 4
    //   1031: istore 14
    //   1033: iload_3
    //   1034: istore 10
    //   1036: aload 30
    //   1038: astore 26
    //   1040: aload 29
    //   1042: astore 27
    //   1044: aload 29
    //   1046: aload 36
    //   1048: invokevirtual 184	java/io/InputStream:read	([B)I
    //   1051: istore 8
    //   1053: iload 8
    //   1055: ifle +172 -> 1227
    //   1058: iload_3
    //   1059: istore 7
    //   1061: aload 30
    //   1063: astore 24
    //   1065: aload 29
    //   1067: astore 25
    //   1069: iload 4
    //   1071: istore 14
    //   1073: iload_3
    //   1074: istore 10
    //   1076: aload 30
    //   1078: astore 26
    //   1080: aload 29
    //   1082: astore 27
    //   1084: aload 30
    //   1086: aload 36
    //   1088: iconst_0
    //   1089: iload 8
    //   1091: invokevirtual 190	java/io/OutputStream:write	([BII)V
    //   1094: goto -76 -> 1018
    //   1097: astore 26
    //   1099: iload 4
    //   1101: iconst_1
    //   1102: iadd
    //   1103: istore 4
    //   1105: iload 4
    //   1107: istore 14
    //   1109: iload 7
    //   1111: istore 10
    //   1113: aload 24
    //   1115: astore 26
    //   1117: aload 25
    //   1119: astore 27
    //   1121: ldc 192
    //   1123: new 194	java/lang/StringBuilder
    //   1126: dup
    //   1127: ldc 196
    //   1129: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1132: aload 39
    //   1134: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   1137: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: ldc 205
    //   1142: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: aload_0
    //   1146: invokevirtual 209	com/tencent/mm/vfs/MigrationFileSystem:toString	()Ljava/lang/String;
    //   1149: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: ldc 211
    //   1154: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1160: invokestatic 218	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1163: aload 28
    //   1165: ifnull +222 -> 1387
    //   1168: aload 31
    //   1170: astore 29
    //   1172: aload 29
    //   1174: ifnull +213 -> 1387
    //   1177: iload 4
    //   1179: istore 14
    //   1181: iload 7
    //   1183: istore 10
    //   1185: aload 24
    //   1187: astore 26
    //   1189: aload 25
    //   1191: astore 27
    //   1193: aload 28
    //   1195: aload 29
    //   1197: invokevirtual 221	java/util/TreeSet:remove	(Ljava/lang/Object;)Z
    //   1200: pop
    //   1201: iload 4
    //   1203: istore 14
    //   1205: iload 7
    //   1207: istore 10
    //   1209: aload 24
    //   1211: astore 26
    //   1213: aload 25
    //   1215: astore 27
    //   1217: aload 29
    //   1219: invokestatic 171	com/tencent/mm/vfs/j:afa	(Ljava/lang/String;)Ljava/lang/String;
    //   1222: astore 29
    //   1224: goto -52 -> 1172
    //   1227: iload_3
    //   1228: istore 7
    //   1230: aload 30
    //   1232: astore 24
    //   1234: aload 29
    //   1236: astore 25
    //   1238: iload 4
    //   1240: istore 14
    //   1242: iload_3
    //   1243: istore 10
    //   1245: aload 30
    //   1247: astore 26
    //   1249: aload 29
    //   1251: astore 27
    //   1253: aload 29
    //   1255: invokevirtual 224	java/io/InputStream:close	()V
    //   1258: aconst_null
    //   1259: astore 32
    //   1261: aconst_null
    //   1262: astore 29
    //   1264: iload_3
    //   1265: istore 7
    //   1267: aload 30
    //   1269: astore 24
    //   1271: aload 29
    //   1273: astore 25
    //   1275: iload 4
    //   1277: istore 14
    //   1279: iload_3
    //   1280: istore 10
    //   1282: aload 30
    //   1284: astore 26
    //   1286: aload 32
    //   1288: astore 27
    //   1290: aload 30
    //   1292: invokevirtual 225	java/io/OutputStream:close	()V
    //   1295: aconst_null
    //   1296: astore 33
    //   1298: aconst_null
    //   1299: astore 30
    //   1301: iload_3
    //   1302: istore 7
    //   1304: aload 30
    //   1306: astore 24
    //   1308: aload 29
    //   1310: astore 25
    //   1312: iload 4
    //   1314: istore 14
    //   1316: iload_3
    //   1317: istore 10
    //   1319: aload 33
    //   1321: astore 26
    //   1323: aload 32
    //   1325: astore 27
    //   1327: aload 37
    //   1329: aload 39
    //   1331: getfield 159	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   1334: invokeinterface 174 2 0
    //   1339: pop
    //   1340: iload_3
    //   1341: iconst_1
    //   1342: iadd
    //   1343: istore_3
    //   1344: iload_3
    //   1345: istore 7
    //   1347: aload 30
    //   1349: astore 24
    //   1351: aload 29
    //   1353: astore 25
    //   1355: iload 4
    //   1357: istore 14
    //   1359: iload_3
    //   1360: istore 10
    //   1362: aload 33
    //   1364: astore 26
    //   1366: aload 32
    //   1368: astore 27
    //   1370: aload 39
    //   1372: getfield 152	com/tencent/mm/vfs/FileSystem$a:wut	J
    //   1375: lstore 22
    //   1377: lload 20
    //   1379: lload 22
    //   1381: ladd
    //   1382: lstore 20
    //   1384: goto -718 -> 666
    //   1387: aload 25
    //   1389: ifnull +19 -> 1408
    //   1392: iload 4
    //   1394: istore 8
    //   1396: iload 7
    //   1398: istore 9
    //   1400: iload_2
    //   1401: istore 15
    //   1403: aload 25
    //   1405: invokevirtual 224	java/io/InputStream:close	()V
    //   1408: iload 4
    //   1410: istore 9
    //   1412: iload 7
    //   1414: istore 10
    //   1416: iload_2
    //   1417: istore 8
    //   1419: aload 24
    //   1421: ifnull +221 -> 1642
    //   1424: iload 4
    //   1426: istore 8
    //   1428: iload 7
    //   1430: istore 9
    //   1432: iload_2
    //   1433: istore 15
    //   1435: aload 24
    //   1437: invokevirtual 225	java/io/OutputStream:close	()V
    //   1440: iload 7
    //   1442: istore_3
    //   1443: goto -777 -> 666
    //   1446: astore 24
    //   1448: iload 7
    //   1450: istore_3
    //   1451: goto -785 -> 666
    //   1454: astore_1
    //   1455: aload 27
    //   1457: ifnull +19 -> 1476
    //   1460: iload 14
    //   1462: istore 8
    //   1464: iload 10
    //   1466: istore 9
    //   1468: iload_2
    //   1469: istore 15
    //   1471: aload 27
    //   1473: invokevirtual 224	java/io/InputStream:close	()V
    //   1476: aload 26
    //   1478: ifnull +19 -> 1497
    //   1481: iload 14
    //   1483: istore 8
    //   1485: iload 10
    //   1487: istore 9
    //   1489: iload_2
    //   1490: istore 15
    //   1492: aload 26
    //   1494: invokevirtual 225	java/io/OutputStream:close	()V
    //   1497: iload 14
    //   1499: istore 8
    //   1501: iload 10
    //   1503: istore 9
    //   1505: iload_2
    //   1506: istore 15
    //   1508: aload_1
    //   1509: athrow
    //   1510: astore_1
    //   1511: iload 15
    //   1513: istore_2
    //   1514: iload 9
    //   1516: istore_3
    //   1517: iload 8
    //   1519: istore 4
    //   1521: aload_1
    //   1522: instanceof 227
    //   1525: ifeq +435 -> 1960
    //   1528: iconst_4
    //   1529: istore 7
    //   1531: aload_0
    //   1532: iload 7
    //   1534: bipush 14
    //   1536: anewarray 25	java/lang/Object
    //   1539: dup
    //   1540: iconst_0
    //   1541: ldc 121
    //   1543: aastore
    //   1544: dup
    //   1545: iconst_1
    //   1546: aload_0
    //   1547: getfield 45	com/tencent/mm/vfs/MigrationFileSystem:wuj	[Lcom/tencent/mm/vfs/FileSystem;
    //   1550: iconst_0
    //   1551: aaload
    //   1552: aastore
    //   1553: dup
    //   1554: iconst_2
    //   1555: ldc 229
    //   1557: aastore
    //   1558: dup
    //   1559: iconst_3
    //   1560: iload_2
    //   1561: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1564: aastore
    //   1565: dup
    //   1566: iconst_4
    //   1567: ldc 237
    //   1569: aastore
    //   1570: dup
    //   1571: iconst_5
    //   1572: iload 5
    //   1574: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1577: aastore
    //   1578: dup
    //   1579: bipush 6
    //   1581: ldc 239
    //   1583: aastore
    //   1584: dup
    //   1585: bipush 7
    //   1587: iload 6
    //   1589: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1592: aastore
    //   1593: dup
    //   1594: bipush 8
    //   1596: ldc 241
    //   1598: aastore
    //   1599: dup
    //   1600: bipush 9
    //   1602: iload_3
    //   1603: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1606: aastore
    //   1607: dup
    //   1608: bipush 10
    //   1610: ldc 243
    //   1612: aastore
    //   1613: dup
    //   1614: bipush 11
    //   1616: iload 4
    //   1618: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1621: aastore
    //   1622: dup
    //   1623: bipush 12
    //   1625: ldc 245
    //   1627: aastore
    //   1628: dup
    //   1629: bipush 13
    //   1631: lload 20
    //   1633: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1636: aastore
    //   1637: invokevirtual 125	com/tencent/mm/vfs/MigrationFileSystem:j	(I[Ljava/lang/Object;)V
    //   1640: aload_1
    //   1641: athrow
    //   1642: iload 9
    //   1644: istore 4
    //   1646: iload 8
    //   1648: istore_2
    //   1649: iload 10
    //   1651: istore_3
    //   1652: goto -986 -> 666
    //   1655: aload 28
    //   1657: ifnull +362 -> 2019
    //   1660: iload_2
    //   1661: istore 8
    //   1663: aload 28
    //   1665: invokevirtual 254	java/util/TreeSet:descendingSet	()Ljava/util/NavigableSet;
    //   1668: invokeinterface 257 1 0
    //   1673: astore 24
    //   1675: aload 24
    //   1677: invokeinterface 140 1 0
    //   1682: ifeq +39 -> 1721
    //   1685: aload 24
    //   1687: invokeinterface 144 1 0
    //   1692: checkcast 259	java/lang/String
    //   1695: astore 25
    //   1697: aload_1
    //   1698: invokevirtual 119	android/os/CancellationSignal:throwIfCanceled	()V
    //   1701: aload 37
    //   1703: aload 25
    //   1705: iconst_0
    //   1706: invokeinterface 95 3 0
    //   1711: pop
    //   1712: iload 5
    //   1714: iconst_1
    //   1715: iadd
    //   1716: istore 5
    //   1718: goto -43 -> 1675
    //   1721: iload 6
    //   1723: istore 7
    //   1725: iload_2
    //   1726: istore 6
    //   1728: iload 16
    //   1730: iconst_1
    //   1731: iadd
    //   1732: istore 16
    //   1734: iload 7
    //   1736: istore_2
    //   1737: iload 11
    //   1739: istore 7
    //   1741: goto -1493 -> 248
    //   1744: iload 4
    //   1746: istore 14
    //   1748: iload_3
    //   1749: istore 10
    //   1751: iload_2
    //   1752: istore 15
    //   1754: lload 20
    //   1756: lstore 22
    //   1758: iload 5
    //   1760: istore 9
    //   1762: iload 6
    //   1764: istore 8
    //   1766: aload_0
    //   1767: iconst_3
    //   1768: bipush 20
    //   1770: anewarray 25	java/lang/Object
    //   1773: dup
    //   1774: iconst_0
    //   1775: ldc 121
    //   1777: aastore
    //   1778: dup
    //   1779: iconst_1
    //   1780: aload 34
    //   1782: aastore
    //   1783: dup
    //   1784: iconst_2
    //   1785: ldc_w 261
    //   1788: aastore
    //   1789: dup
    //   1790: iconst_3
    //   1791: iload 13
    //   1793: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1796: aastore
    //   1797: dup
    //   1798: iconst_4
    //   1799: ldc_w 263
    //   1802: aastore
    //   1803: dup
    //   1804: iconst_5
    //   1805: iload 12
    //   1807: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1810: aastore
    //   1811: dup
    //   1812: bipush 6
    //   1814: ldc_w 265
    //   1817: aastore
    //   1818: dup
    //   1819: bipush 7
    //   1821: iload 7
    //   1823: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1826: aastore
    //   1827: dup
    //   1828: bipush 8
    //   1830: ldc 229
    //   1832: aastore
    //   1833: dup
    //   1834: bipush 9
    //   1836: iload 6
    //   1838: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1841: aastore
    //   1842: dup
    //   1843: bipush 10
    //   1845: ldc 237
    //   1847: aastore
    //   1848: dup
    //   1849: bipush 11
    //   1851: iload 5
    //   1853: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1856: aastore
    //   1857: dup
    //   1858: bipush 12
    //   1860: ldc 239
    //   1862: aastore
    //   1863: dup
    //   1864: bipush 13
    //   1866: iload_2
    //   1867: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1870: aastore
    //   1871: dup
    //   1872: bipush 14
    //   1874: ldc 241
    //   1876: aastore
    //   1877: dup
    //   1878: bipush 15
    //   1880: iload_3
    //   1881: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1884: aastore
    //   1885: dup
    //   1886: bipush 16
    //   1888: ldc 243
    //   1890: aastore
    //   1891: dup
    //   1892: bipush 17
    //   1894: iload 4
    //   1896: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1899: aastore
    //   1900: dup
    //   1901: bipush 18
    //   1903: ldc 245
    //   1905: aastore
    //   1906: dup
    //   1907: bipush 19
    //   1909: lload 20
    //   1911: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1914: aastore
    //   1915: invokevirtual 125	com/tencent/mm/vfs/MigrationFileSystem:j	(I[Ljava/lang/Object;)V
    //   1918: aload_0
    //   1919: getfield 45	com/tencent/mm/vfs/MigrationFileSystem:wuj	[Lcom/tencent/mm/vfs/FileSystem;
    //   1922: astore 24
    //   1924: aload 24
    //   1926: arraylength
    //   1927: istore_3
    //   1928: iconst_0
    //   1929: istore_2
    //   1930: iload_2
    //   1931: iload_3
    //   1932: if_icmpge +49 -> 1981
    //   1935: aload 24
    //   1937: iload_2
    //   1938: aaload
    //   1939: astore 25
    //   1941: aload_1
    //   1942: invokevirtual 119	android/os/CancellationSignal:throwIfCanceled	()V
    //   1945: aload 25
    //   1947: aload_1
    //   1948: invokeinterface 267 2 0
    //   1953: iload_2
    //   1954: iconst_1
    //   1955: iadd
    //   1956: istore_2
    //   1957: goto -27 -> 1930
    //   1960: iconst_5
    //   1961: istore 7
    //   1963: goto -432 -> 1531
    //   1966: astore 25
    //   1968: goto -560 -> 1408
    //   1971: astore 24
    //   1973: goto -497 -> 1476
    //   1976: astore 24
    //   1978: goto -481 -> 1497
    //   1981: return
    //   1982: astore_1
    //   1983: iload 15
    //   1985: istore 6
    //   1987: iload 14
    //   1989: istore 4
    //   1991: iload 10
    //   1993: istore_3
    //   1994: lload 22
    //   1996: lstore 20
    //   1998: iload 9
    //   2000: istore 5
    //   2002: iload 8
    //   2004: istore_2
    //   2005: goto -484 -> 1521
    //   2008: astore_1
    //   2009: iload 8
    //   2011: istore_2
    //   2012: goto -491 -> 1521
    //   2015: astore_1
    //   2016: goto -495 -> 1521
    //   2019: iload 6
    //   2021: istore 7
    //   2023: iload_2
    //   2024: istore 6
    //   2026: goto -298 -> 1728
    //   2029: goto -1281 -> 748
    //   2032: iload 7
    //   2034: istore 11
    //   2036: iload_2
    //   2037: istore 7
    //   2039: goto -311 -> 1728
    //   2042: iload 13
    //   2044: iconst_1
    //   2045: iadd
    //   2046: istore 13
    //   2048: goto -1528 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2051	0	this	MigrationFileSystem
    //   0	2051	1	paramCancellationSignal	android.os.CancellationSignal
    //   32	2005	2	i	int
    //   37	1957	3	j	int
    //   42	1948	4	k	int
    //   26	1975	5	m	int
    //   20	2005	6	n	int
    //   14	2024	7	i1	int
    //   69	1941	8	i2	int
    //   65	1934	9	i3	int
    //   53	1939	10	i4	int
    //   17	2018	11	i5	int
    //   11	1795	12	i6	int
    //   8	2039	13	i7	int
    //   49	1939	14	i8	int
    //   57	1927	15	i9	int
    //   23	1710	16	i10	int
    //   29	224	17	i11	int
    //   34	185	18	i12	int
    //   39	176	19	i13	int
    //   45	1952	20	l1	long
    //   61	1934	22	l2	long
    //   344	1092	24	localObject1	Object
    //   1446	1	24	localIOException1	IOException
    //   1673	263	24	localObject2	Object
    //   1971	1	24	localIOException2	IOException
    //   1976	1	24	localIOException3	IOException
    //   412	1534	25	localObject3	Object
    //   1966	1	25	localIOException4	IOException
    //   482	597	26	localObject4	Object
    //   1097	1	26	localIOException5	IOException
    //   1115	378	26	localObject5	Object
    //   934	538	27	localObject6	Object
    //   623	1041	28	localTreeSet	java.util.TreeSet
    //   975	377	29	localObject7	Object
    //   943	405	30	localOutputStream	OutputStream
    //   804	365	31	str	String
    //   940	427	32	localObject8	Object
    //   1296	67	33	localObject9	Object
    //   77	1704	34	localFileSystem1	FileSystem
    //   110	711	35	localHashSet	java.util.HashSet
    //   141	946	36	arrayOfByte	byte[]
    //   310	1392	37	localFileSystem2	FileSystem
    //   654	29	38	localIterator	java.util.Iterator
    //   692	679	39	locala	FileSystem.a
    // Exception table:
    //   from	to	target	type
    //   963	977	1097	java/io/IOException
    //   1003	1018	1097	java/io/IOException
    //   1044	1053	1097	java/io/IOException
    //   1084	1094	1097	java/io/IOException
    //   1253	1258	1097	java/io/IOException
    //   1290	1295	1097	java/io/IOException
    //   1327	1340	1097	java/io/IOException
    //   1370	1377	1097	java/io/IOException
    //   1435	1440	1446	java/io/IOException
    //   963	977	1454	finally
    //   1003	1018	1454	finally
    //   1044	1053	1454	finally
    //   1084	1094	1454	finally
    //   1121	1163	1454	finally
    //   1193	1201	1454	finally
    //   1217	1224	1454	finally
    //   1253	1258	1454	finally
    //   1290	1295	1454	finally
    //   1327	1340	1454	finally
    //   1370	1377	1454	finally
    //   773	784	1510	java/lang/Exception
    //   886	901	1510	java/lang/Exception
    //   911	924	1510	java/lang/Exception
    //   1403	1408	1510	java/lang/Exception
    //   1435	1440	1510	java/lang/Exception
    //   1471	1476	1510	java/lang/Exception
    //   1492	1497	1510	java/lang/Exception
    //   1508	1510	1510	java/lang/Exception
    //   1403	1408	1966	java/io/IOException
    //   1471	1476	1971	java/io/IOException
    //   1492	1497	1976	java/io/IOException
    //   71	79	1982	java/lang/Exception
    //   103	112	1982	java/lang/Exception
    //   136	143	1982	java/lang/Exception
    //   167	171	1982	java/lang/Exception
    //   195	214	1982	java/lang/Exception
    //   238	245	1982	java/lang/Exception
    //   277	281	1982	java/lang/Exception
    //   303	312	1982	java/lang/Exception
    //   334	346	1982	java/lang/Exception
    //   373	383	1982	java/lang/Exception
    //   405	414	1982	java/lang/Exception
    //   440	450	1982	java/lang/Exception
    //   472	484	1982	java/lang/Exception
    //   506	514	1982	java/lang/Exception
    //   542	554	1982	java/lang/Exception
    //   579	594	1982	java/lang/Exception
    //   616	625	1982	java/lang/Exception
    //   647	656	1982	java/lang/Exception
    //   1766	1918	1982	java/lang/Exception
    //   669	679	2008	java/lang/Exception
    //   682	694	2008	java/lang/Exception
    //   697	701	2008	java/lang/Exception
    //   704	712	2008	java/lang/Exception
    //   715	728	2008	java/lang/Exception
    //   731	744	2008	java/lang/Exception
    //   796	806	2008	java/lang/Exception
    //   820	830	2008	java/lang/Exception
    //   833	843	2008	java/lang/Exception
    //   861	869	2008	java/lang/Exception
    //   1663	1675	2008	java/lang/Exception
    //   1675	1712	2015	java/lang/Exception
  }
  
  public final boolean aC(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfFileSystem[i].aC(paramString1, paramString2)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    boolean bool2 = false;
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfFileSystem[i].exists(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final boolean jJ(String paramString)
  {
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].jJ(paramString);
      i += 1;
    }
    return bool1;
  }
  
  public final void m(Map<String, String> paramMap)
  {
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFileSystem[i].m(paramMap);
      i += 1;
    }
  }
  
  public final FileSystem.b mZ(String paramString)
  {
    return this.wuj[0].mZ(paramString);
  }
  
  public final FileSystem.a na(String paramString)
  {
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      FileSystem.a locala = arrayOfFileSystem[i].na(paramString);
      if (locala != null) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  public final boolean nb(String paramString)
  {
    return this.wuj[0].nb(paramString);
  }
  
  public final InputStream openRead(String paramString)
  {
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfFileSystem[i];
      try
      {
        localObject = ((FileSystem)localObject).openRead(paramString);
        if (localObject != null) {
          return localObject;
        }
      }
      catch (IOException localIOException)
      {
        i += 1;
      }
    }
    throw new FileNotFoundException(paramString + " not found on all file systems.");
  }
  
  public final boolean r(String paramString, long paramLong)
  {
    return this.wuj[0].r(paramString, paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MigrationFS [").append(this.wuj[0].toString()).append(" <= ");
    int i = 1;
    while (i < this.wuj.length)
    {
      localStringBuilder.append(this.wuj[i].toString()).append(", ");
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    return ']';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    paramParcel.writeInt(1);
    paramParcel.writeInt(this.wuj.length);
    FileSystem[] arrayOfFileSystem = this.wuj;
    int k = arrayOfFileSystem.length;
    int i = 0;
    while (i < k)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    if (this.wve) {}
    for (paramInt = j;; paramInt = 1)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */