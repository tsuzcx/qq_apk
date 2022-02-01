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

public class MigrationFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<MigrationFileSystem> CREATOR;
  protected final FileSystem[] LFM;
  protected final String LGG;
  protected final String LGH;
  protected final String LGI;
  protected final String LGJ;
  
  static
  {
    AppMethodBeat.i(13141);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13141);
  }
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13131);
    w.a(paramParcel, MigrationFileSystem.class, 6);
    int j = paramParcel.readInt();
    this.LFM = new FileSystem[j];
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
      this.LFM[i] = localFileSystem;
      i += 1;
    }
    this.LGG = paramParcel.readString();
    this.LGH = paramParcel.readString();
    this.LGI = paramParcel.readString();
    this.LGJ = paramParcel.readString();
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
    AppMethodBeat.i(193386);
    if (paramFileSystem == null)
    {
      paramString1 = new IllegalArgumentException("destination == null");
      AppMethodBeat.o(193386);
      throw paramString1;
    }
    this.LGG = paramString1;
    this.LGH = paramString2;
    this.LGI = paramString3;
    this.LGJ = null;
    paramString1 = new FileSystem[paramVarArgs.length + 1];
    paramString1[0] = paramFileSystem;
    int i = 1;
    int m = paramVarArgs.length;
    int j = 0;
    if (j < m)
    {
      paramString2 = paramVarArgs[j];
      if (paramString2 == null) {
        break label148;
      }
      int k = i + 1;
      paramString1[i] = paramString2;
      i = k;
    }
    label148:
    for (;;)
    {
      j += 1;
      break;
      if (i == paramString1.length) {}
      for (;;)
      {
        this.LFM = paramString1;
        AppMethodBeat.o(193386);
        return;
        paramString1 = (FileSystem[])Arrays.copyOf(paramString1, i);
      }
    }
  }
  
  public final FileSystem.b cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193387);
    boolean bool1;
    int j;
    label32:
    int i;
    if (w.T(this.LGG, paramMap) != null)
    {
      bool1 = true;
      if (w.T(this.LGH, paramMap) == null) {
        break label107;
      }
      j = 1;
      if (w.T(this.LGI, paramMap) == null) {
        break label112;
      }
      i = 1;
      label45:
      if (w.T(this.LGJ, paramMap) == null) {
        break label117;
      }
    }
    label107:
    label112:
    label117:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject1 = this.LFM;
      int m = localObject1.length;
      int k = 0;
      while (k < m)
      {
        localObject1[k].cd(paramMap);
        k += 1;
      }
      bool1 = false;
      break;
      j = 0;
      break label32;
      i = 0;
      break label45;
    }
    ArrayList localArrayList = new ArrayList(this.LFM.length);
    Object localObject3 = this.LFM[0].cd(paramMap);
    localArrayList.add(localObject3);
    HashSet localHashSet = new HashSet();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((this.LFM[0] instanceof NativeFileSystem))
    {
      localObject3 = ((NativeFileSystem.c)localObject3).fSX();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        if (j == 0) {
          break label509;
        }
        localObject2 = new File((String)localObject3);
        localObject1 = localObject2;
        if (!((File)localObject2).exists()) {}
      }
    }
    label509:
    for (localObject1 = null;; localObject1 = null)
    {
      localHashSet.add(localObject3);
      j = 1;
      if (j < this.LFM.length)
      {
        if (!(this.LFM[j] instanceof NativeFileSystem)) {
          localArrayList.add(this.LFM[j].cd(paramMap));
        }
        for (;;)
        {
          j += 1;
          break;
          NativeFileSystem.c localc = (NativeFileSystem.c)this.LFM[j].cd(paramMap);
          String str = localc.fSX();
          localObject3 = localObject1;
          if (str != null)
          {
            localObject3 = new File(str);
            boolean bool3 = ((File)localObject3).isDirectory();
            localObject2 = localObject1;
            if (bool3)
            {
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (((File)localObject3).renameTo((File)localObject1))
                {
                  Log.i("VFS.MigrationFileSystem", "Fast moved '" + localObject3 + "' -> '" + localObject1 + "'");
                  localObject1 = null;
                  localObject2 = localObject1;
                  if (i == 0)
                  {
                    localHashSet.add(str);
                    localObject2 = localObject1;
                  }
                }
              }
            }
            if (!bool3)
            {
              localObject3 = localObject2;
              if (i == 0) {}
            }
            else
            {
              localObject3 = localObject2;
              if (localHashSet.add(str))
              {
                localArrayList.add(localc);
                localObject3 = localObject2;
              }
            }
          }
          localObject1 = localObject3;
        }
      }
      paramMap = new a(localArrayList, bool1, bool2);
      AppMethodBeat.o(193387);
      return paramMap;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13139);
    Object localObject = new StringBuilder("Migration [").append(this.LFM[0].toString()).append(" <= ");
    int i = 1;
    while (i < this.LFM.length)
    {
      ((StringBuilder)localObject).append(this.LFM[i].toString()).append(", ");
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
    w.b(paramParcel, MigrationFileSystem.class, 6);
    paramParcel.writeInt(this.LFM.length);
    FileSystem[] arrayOfFileSystem = this.LFM;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    paramParcel.writeString(this.LGG);
    paramParcel.writeString(this.LGH);
    paramParcel.writeString(this.LGI);
    paramParcel.writeString(this.LGJ);
    AppMethodBeat.o(13140);
  }
  
  protected final class a
    extends b
  {
    protected final List<FileSystem.b> LGK;
    protected final boolean LGL;
    protected final boolean LGM;
    
    a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.LGK = paramBoolean1;
      this.LGL = paramBoolean2;
      boolean bool;
      this.LGM = bool;
    }
    
    private boolean aZM(String paramString)
    {
      AppMethodBeat.i(193378);
      paramString = w.bab(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(193378);
        return false;
      }
      FileSystem.b localb = (FileSystem.b)this.LGK.get(0);
      if (localb.aZG(paramString))
      {
        AppMethodBeat.o(193378);
        return false;
      }
      int j = this.LGK.size();
      int i = 1;
      while (i < j)
      {
        c localc = ((FileSystem.b)this.LGK.get(i)).aZH(paramString);
        if ((localc != null) && (localc.LGd))
        {
          boolean bool = localb.aZI(paramString);
          AppMethodBeat.o(193378);
          return bool;
        }
        i += 1;
      }
      AppMethodBeat.o(193378);
      return false;
    }
    
    /* Error */
    public final void a(android.os.CancellationSignal paramCancellationSignal)
    {
      // Byte code:
      //   0: ldc 82
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 26	com/tencent/mm/vfs/MigrationFileSystem$a:LGL	Z
      //   9: ifeq +2196 -> 2205
      //   12: iconst_0
      //   13: istore 13
      //   15: iconst_0
      //   16: istore 6
      //   18: iconst_0
      //   19: istore 14
      //   21: iconst_0
      //   22: istore 5
      //   24: iconst_0
      //   25: istore 18
      //   27: iconst_0
      //   28: istore_2
      //   29: iconst_0
      //   30: istore 7
      //   32: iconst_0
      //   33: istore 8
      //   35: iconst_0
      //   36: istore 19
      //   38: iconst_0
      //   39: istore_3
      //   40: iconst_0
      //   41: istore 20
      //   43: iconst_0
      //   44: istore 9
      //   46: lconst_0
      //   47: lstore 21
      //   49: aload_0
      //   50: getfield 24	com/tencent/mm/vfs/MigrationFileSystem$a:LGK	Ljava/util/List;
      //   53: astore 30
      //   55: lload 21
      //   57: lstore 23
      //   59: iload 19
      //   61: istore 10
      //   63: iload 20
      //   65: istore 15
      //   67: iload 8
      //   69: istore 16
      //   71: iload 7
      //   73: istore 11
      //   75: iload 18
      //   77: istore 12
      //   79: iload 14
      //   81: istore 4
      //   83: iload 13
      //   85: istore 17
      //   87: aload 30
      //   89: iconst_0
      //   90: invokeinterface 55 2 0
      //   95: checkcast 57	com/tencent/mm/vfs/FileSystem$b
      //   98: astore 31
      //   100: lload 21
      //   102: lstore 23
      //   104: iload 19
      //   106: istore 10
      //   108: iload 20
      //   110: istore 15
      //   112: iload 8
      //   114: istore 16
      //   116: iload 7
      //   118: istore 11
      //   120: iload 18
      //   122: istore 12
      //   124: iload 14
      //   126: istore 4
      //   128: iload 13
      //   130: istore 17
      //   132: new 84	java/util/HashSet
      //   135: dup
      //   136: invokespecial 85	java/util/HashSet:<init>	()V
      //   139: astore 32
      //   141: lload 21
      //   143: lstore 23
      //   145: iload 19
      //   147: istore 10
      //   149: iload 20
      //   151: istore 15
      //   153: iload 8
      //   155: istore 16
      //   157: iload 7
      //   159: istore 11
      //   161: iload 18
      //   163: istore 12
      //   165: iload 14
      //   167: istore 4
      //   169: iload 13
      //   171: istore 17
      //   173: aload_1
      //   174: invokevirtual 90	android/os/CancellationSignal:throwIfCanceled	()V
      //   177: lload 21
      //   179: lstore 23
      //   181: iload 19
      //   183: istore 10
      //   185: iload 20
      //   187: istore 15
      //   189: iload 8
      //   191: istore 16
      //   193: iload 7
      //   195: istore 11
      //   197: iload 18
      //   199: istore 12
      //   201: iload 14
      //   203: istore 4
      //   205: iload 13
      //   207: istore 17
      //   209: aload_0
      //   210: getfield 19	com/tencent/mm/vfs/MigrationFileSystem$a:LGN	Lcom/tencent/mm/vfs/MigrationFileSystem;
      //   213: iconst_1
      //   214: iconst_2
      //   215: anewarray 92	java/lang/Object
      //   218: dup
      //   219: iconst_0
      //   220: ldc 94
      //   222: aastore
      //   223: dup
      //   224: iconst_1
      //   225: aload 31
      //   227: aastore
      //   228: invokevirtual 98	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
      //   231: lload 21
      //   233: lstore 23
      //   235: iload 19
      //   237: istore 10
      //   239: iload 20
      //   241: istore 15
      //   243: iload 8
      //   245: istore 16
      //   247: iload 7
      //   249: istore 11
      //   251: iload 18
      //   253: istore 12
      //   255: iload 14
      //   257: istore 4
      //   259: iload 13
      //   261: istore 17
      //   263: aload 30
      //   265: invokeinterface 64 1 0
      //   270: istore 19
      //   272: iconst_1
      //   273: istore 18
      //   275: iconst_0
      //   276: istore 8
      //   278: iconst_0
      //   279: istore 7
      //   281: iload_3
      //   282: istore 4
      //   284: iload 8
      //   286: istore_3
      //   287: iload 18
      //   289: iload 19
      //   291: if_icmpge +1777 -> 2068
      //   294: aload_1
      //   295: invokevirtual 90	android/os/CancellationSignal:throwIfCanceled	()V
      //   298: aload 30
      //   300: iload 18
      //   302: invokeinterface 55 2 0
      //   307: checkcast 57	com/tencent/mm/vfs/FileSystem$b
      //   310: astore 33
      //   312: aload 33
      //   314: ldc 100
      //   316: iconst_1
      //   317: invokeinterface 104 3 0
      //   322: astore 29
      //   324: aload 29
      //   326: ifnull +1928 -> 2254
      //   329: aload 33
      //   331: invokeinterface 107 1 0
      //   336: bipush 9
      //   338: iand
      //   339: bipush 9
      //   341: if_icmpne +1916 -> 2257
      //   344: new 109	java/util/TreeSet
      //   347: dup
      //   348: invokespecial 110	java/util/TreeSet:<init>	()V
      //   351: astore 28
      //   353: aload 29
      //   355: invokeinterface 116 1 0
      //   360: astore 34
      //   362: iload_3
      //   363: istore 8
      //   365: iload 4
      //   367: istore_3
      //   368: lload 21
      //   370: lstore 23
      //   372: iload_3
      //   373: istore 10
      //   375: iload 9
      //   377: istore 15
      //   379: iload 8
      //   381: istore 16
      //   383: iload 7
      //   385: istore 11
      //   387: iload_2
      //   388: istore 12
      //   390: iload 5
      //   392: istore 4
      //   394: iload 6
      //   396: istore 17
      //   398: aload 34
      //   400: invokeinterface 122 1 0
      //   405: ifeq +1428 -> 1833
      //   408: lload 21
      //   410: lstore 23
      //   412: iload_3
      //   413: istore 10
      //   415: iload 9
      //   417: istore 15
      //   419: iload 8
      //   421: istore 16
      //   423: iload 7
      //   425: istore 11
      //   427: iload_2
      //   428: istore 12
      //   430: iload 5
      //   432: istore 4
      //   434: iload 6
      //   436: istore 17
      //   438: aload 34
      //   440: invokeinterface 126 1 0
      //   445: checkcast 70	com/tencent/mm/vfs/c
      //   448: astore 35
      //   450: lload 21
      //   452: lstore 23
      //   454: iload_3
      //   455: istore 10
      //   457: iload 9
      //   459: istore 15
      //   461: iload 8
      //   463: istore 16
      //   465: iload 7
      //   467: istore 11
      //   469: iload_2
      //   470: istore 12
      //   472: iload 5
      //   474: istore 4
      //   476: iload 6
      //   478: istore 17
      //   480: aload_1
      //   481: invokevirtual 90	android/os/CancellationSignal:throwIfCanceled	()V
      //   484: lload 21
      //   486: lstore 23
      //   488: iload_3
      //   489: istore 10
      //   491: iload 9
      //   493: istore 15
      //   495: iload 8
      //   497: istore 16
      //   499: iload 7
      //   501: istore 11
      //   503: iload_2
      //   504: istore 12
      //   506: iload 5
      //   508: istore 4
      //   510: iload 6
      //   512: istore 17
      //   514: aload 35
      //   516: getfield 73	com/tencent/mm/vfs/c:LGd	Z
      //   519: istore 27
      //   521: iload 27
      //   523: ifeq +454 -> 977
      //   526: lload 21
      //   528: lstore 23
      //   530: iload_3
      //   531: istore 10
      //   533: iload 9
      //   535: istore 15
      //   537: iload 8
      //   539: istore 16
      //   541: iload 7
      //   543: istore 11
      //   545: iload_2
      //   546: istore 12
      //   548: iload 5
      //   550: istore 4
      //   552: iload 6
      //   554: istore 17
      //   556: aload 31
      //   558: aload 35
      //   560: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   563: aload 33
      //   565: aload 35
      //   567: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   570: invokeinterface 133 4 0
      //   575: istore 27
      //   577: iload 27
      //   579: ifeq +53 -> 632
      //   582: lload 21
      //   584: lstore 23
      //   586: iload_3
      //   587: istore 10
      //   589: iload 9
      //   591: istore 15
      //   593: iload 8
      //   595: istore 16
      //   597: iload 7
      //   599: istore 11
      //   601: iload_2
      //   602: istore 12
      //   604: iload 5
      //   606: istore 4
      //   608: iload 6
      //   610: istore 17
      //   612: aload 32
      //   614: aload 35
      //   616: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   619: invokevirtual 137	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   622: pop
      //   623: iload 6
      //   625: iconst_1
      //   626: iadd
      //   627: istore 6
      //   629: goto -261 -> 368
      //   632: iload 5
      //   634: istore 13
      //   636: lload 21
      //   638: lstore 23
      //   640: iload_3
      //   641: istore 10
      //   643: iload 9
      //   645: istore 15
      //   647: iload 8
      //   649: istore 16
      //   651: iload 7
      //   653: istore 11
      //   655: iload_2
      //   656: istore 12
      //   658: iload 5
      //   660: istore 4
      //   662: iload 6
      //   664: istore 17
      //   666: aload 32
      //   668: aload 35
      //   670: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   673: invokevirtual 137	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   676: ifeq +52 -> 728
      //   679: lload 21
      //   681: lstore 23
      //   683: iload_3
      //   684: istore 10
      //   686: iload 9
      //   688: istore 15
      //   690: iload 8
      //   692: istore 16
      //   694: iload 7
      //   696: istore 11
      //   698: iload_2
      //   699: istore 12
      //   701: iload 5
      //   703: istore 4
      //   705: iload 6
      //   707: istore 17
      //   709: aload 31
      //   711: aload 35
      //   713: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   716: invokeinterface 76 2 0
      //   721: pop
      //   722: iload 5
      //   724: iconst_1
      //   725: iadd
      //   726: istore 13
      //   728: iload 13
      //   730: istore 5
      //   732: aload 28
      //   734: ifnull -366 -> 368
      //   737: lload 21
      //   739: lstore 23
      //   741: iload_3
      //   742: istore 10
      //   744: iload 9
      //   746: istore 15
      //   748: iload 8
      //   750: istore 16
      //   752: iload 7
      //   754: istore 11
      //   756: iload_2
      //   757: istore 12
      //   759: iload 13
      //   761: istore 4
      //   763: iload 6
      //   765: istore 17
      //   767: aload 28
      //   769: aload 35
      //   771: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   774: invokevirtual 138	java/util/TreeSet:add	(Ljava/lang/Object;)Z
      //   777: pop
      //   778: iload 13
      //   780: istore 5
      //   782: goto -414 -> 368
      //   785: astore_1
      //   786: iload 17
      //   788: istore 6
      //   790: iload 4
      //   792: istore 5
      //   794: iload 12
      //   796: istore_2
      //   797: iload 11
      //   799: istore 7
      //   801: iload 16
      //   803: istore 8
      //   805: iload 15
      //   807: istore 9
      //   809: iload 10
      //   811: istore 4
      //   813: lload 23
      //   815: lstore 21
      //   817: aload_1
      //   818: instanceof 140
      //   821: ifeq +1395 -> 2216
      //   824: iconst_4
      //   825: istore_3
      //   826: aload_0
      //   827: getfield 19	com/tencent/mm/vfs/MigrationFileSystem$a:LGN	Lcom/tencent/mm/vfs/MigrationFileSystem;
      //   830: iload_3
      //   831: bipush 18
      //   833: anewarray 92	java/lang/Object
      //   836: dup
      //   837: iconst_0
      //   838: ldc 94
      //   840: aastore
      //   841: dup
      //   842: iconst_1
      //   843: aload 30
      //   845: iconst_0
      //   846: invokeinterface 55 2 0
      //   851: aastore
      //   852: dup
      //   853: iconst_2
      //   854: ldc 142
      //   856: aastore
      //   857: dup
      //   858: iconst_3
      //   859: iload 6
      //   861: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   864: aastore
      //   865: dup
      //   866: iconst_4
      //   867: ldc 150
      //   869: aastore
      //   870: dup
      //   871: iconst_5
      //   872: iload 5
      //   874: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   877: aastore
      //   878: dup
      //   879: bipush 6
      //   881: ldc 152
      //   883: aastore
      //   884: dup
      //   885: bipush 7
      //   887: iload_2
      //   888: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   891: aastore
      //   892: dup
      //   893: bipush 8
      //   895: ldc 154
      //   897: aastore
      //   898: dup
      //   899: bipush 9
      //   901: iload 7
      //   903: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   906: aastore
      //   907: dup
      //   908: bipush 10
      //   910: ldc 156
      //   912: aastore
      //   913: dup
      //   914: bipush 11
      //   916: iload 4
      //   918: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   921: aastore
      //   922: dup
      //   923: bipush 12
      //   925: ldc 158
      //   927: aastore
      //   928: dup
      //   929: bipush 13
      //   931: iload 8
      //   933: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   936: aastore
      //   937: dup
      //   938: bipush 14
      //   940: ldc 160
      //   942: aastore
      //   943: dup
      //   944: bipush 15
      //   946: iload 9
      //   948: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   951: aastore
      //   952: dup
      //   953: bipush 16
      //   955: ldc 162
      //   957: aastore
      //   958: dup
      //   959: bipush 17
      //   961: lload 21
      //   963: invokestatic 167	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   966: aastore
      //   967: invokevirtual 98	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
      //   970: ldc 82
      //   972: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   975: aload_1
      //   976: athrow
      //   977: lload 21
      //   979: lstore 23
      //   981: iload_3
      //   982: istore 10
      //   984: iload 9
      //   986: istore 15
      //   988: iload 8
      //   990: istore 16
      //   992: iload 7
      //   994: istore 11
      //   996: iload_2
      //   997: istore 12
      //   999: iload 5
      //   1001: istore 4
      //   1003: iload 6
      //   1005: istore 17
      //   1007: aload 35
      //   1009: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1012: invokestatic 46	com/tencent/mm/vfs/w:bab	(Ljava/lang/String;)Ljava/lang/String;
      //   1015: astore 29
      //   1017: iload 5
      //   1019: istore 13
      //   1021: aload 29
      //   1023: ifnull +144 -> 1167
      //   1026: lload 21
      //   1028: lstore 23
      //   1030: iload_3
      //   1031: istore 10
      //   1033: iload 9
      //   1035: istore 15
      //   1037: iload 8
      //   1039: istore 16
      //   1041: iload 7
      //   1043: istore 11
      //   1045: iload_2
      //   1046: istore 12
      //   1048: iload 5
      //   1050: istore 4
      //   1052: iload 6
      //   1054: istore 17
      //   1056: iload 5
      //   1058: istore 14
      //   1060: aload 32
      //   1062: aload 29
      //   1064: invokevirtual 137	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   1067: ifeq +49 -> 1116
      //   1070: lload 21
      //   1072: lstore 23
      //   1074: iload_3
      //   1075: istore 10
      //   1077: iload 9
      //   1079: istore 15
      //   1081: iload 8
      //   1083: istore 16
      //   1085: iload 7
      //   1087: istore 11
      //   1089: iload_2
      //   1090: istore 12
      //   1092: iload 5
      //   1094: istore 4
      //   1096: iload 6
      //   1098: istore 17
      //   1100: aload 31
      //   1102: aload 29
      //   1104: invokeinterface 76 2 0
      //   1109: pop
      //   1110: iload 5
      //   1112: iconst_1
      //   1113: iadd
      //   1114: istore 14
      //   1116: iload 14
      //   1118: istore 13
      //   1120: aload 28
      //   1122: ifnull +45 -> 1167
      //   1125: lload 21
      //   1127: lstore 23
      //   1129: iload_3
      //   1130: istore 10
      //   1132: iload 9
      //   1134: istore 15
      //   1136: iload 8
      //   1138: istore 16
      //   1140: iload 7
      //   1142: istore 11
      //   1144: iload_2
      //   1145: istore 12
      //   1147: iload 14
      //   1149: istore 4
      //   1151: iload 6
      //   1153: istore 17
      //   1155: aload 28
      //   1157: aload 29
      //   1159: invokevirtual 138	java/util/TreeSet:add	(Ljava/lang/Object;)Z
      //   1162: pop
      //   1163: iload 14
      //   1165: istore 13
      //   1167: lload 21
      //   1169: lstore 23
      //   1171: iload_3
      //   1172: istore 10
      //   1174: iload 9
      //   1176: istore 15
      //   1178: iload 8
      //   1180: istore 16
      //   1182: iload 7
      //   1184: istore 11
      //   1186: iload_2
      //   1187: istore 12
      //   1189: iload 13
      //   1191: istore 4
      //   1193: iload 6
      //   1195: istore 17
      //   1197: aload 31
      //   1199: aload 35
      //   1201: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1204: invokeinterface 60 2 0
      //   1209: ifeq +151 -> 1360
      //   1212: lload 21
      //   1214: lstore 23
      //   1216: iload_3
      //   1217: istore 10
      //   1219: iload 9
      //   1221: istore 15
      //   1223: iload 8
      //   1225: istore 16
      //   1227: iload 7
      //   1229: istore 11
      //   1231: iload_2
      //   1232: istore 12
      //   1234: iload 13
      //   1236: istore 4
      //   1238: iload 6
      //   1240: istore 17
      //   1242: aload_0
      //   1243: getfield 28	com/tencent/mm/vfs/MigrationFileSystem$a:LGM	Z
      //   1246: ifne +1001 -> 2247
      //   1249: lload 21
      //   1251: lstore 23
      //   1253: iload_3
      //   1254: istore 10
      //   1256: iload 9
      //   1258: istore 15
      //   1260: iload 8
      //   1262: istore 16
      //   1264: iload 7
      //   1266: istore 11
      //   1268: iload_2
      //   1269: istore 12
      //   1271: iload 13
      //   1273: istore 4
      //   1275: iload 6
      //   1277: istore 17
      //   1279: aload 33
      //   1281: aload 35
      //   1283: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1286: invokeinterface 170 2 0
      //   1291: pop
      //   1292: iload 7
      //   1294: iconst_1
      //   1295: iadd
      //   1296: istore 7
      //   1298: lload 21
      //   1300: lstore 23
      //   1302: iload_3
      //   1303: istore 10
      //   1305: iload 9
      //   1307: istore 15
      //   1309: iload 8
      //   1311: istore 16
      //   1313: iload 7
      //   1315: istore 11
      //   1317: iload_2
      //   1318: istore 12
      //   1320: iload 13
      //   1322: istore 4
      //   1324: iload 6
      //   1326: istore 17
      //   1328: ldc 172
      //   1330: new 174	java/lang/StringBuilder
      //   1333: dup
      //   1334: ldc 176
      //   1336: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1339: aload 35
      //   1341: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1344: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1347: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1350: invokestatic 193	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1353: iload 13
      //   1355: istore 5
      //   1357: goto -989 -> 368
      //   1360: lload 21
      //   1362: lstore 23
      //   1364: iload_3
      //   1365: istore 10
      //   1367: iload 9
      //   1369: istore 15
      //   1371: iload 8
      //   1373: istore 16
      //   1375: iload 7
      //   1377: istore 11
      //   1379: iload_2
      //   1380: istore 12
      //   1382: iload 13
      //   1384: istore 4
      //   1386: iload 6
      //   1388: istore 17
      //   1390: iload_3
      //   1391: istore 5
      //   1393: aload 31
      //   1395: aload 35
      //   1397: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1400: aload 33
      //   1402: aload 35
      //   1404: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1407: invokeinterface 133 4 0
      //   1412: ifeq +74 -> 1486
      //   1415: lload 21
      //   1417: lstore 23
      //   1419: iload_3
      //   1420: istore 10
      //   1422: iload 9
      //   1424: istore 15
      //   1426: iload 8
      //   1428: istore 16
      //   1430: iload 7
      //   1432: istore 11
      //   1434: iload_2
      //   1435: istore 12
      //   1437: iload 13
      //   1439: istore 4
      //   1441: iload 6
      //   1443: istore 17
      //   1445: iload_3
      //   1446: istore 5
      //   1448: ldc 172
      //   1450: new 174	java/lang/StringBuilder
      //   1453: dup
      //   1454: ldc 195
      //   1456: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1459: aload 35
      //   1461: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1464: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1467: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1470: invokestatic 193	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1473: iload 8
      //   1475: iconst_1
      //   1476: iadd
      //   1477: istore 8
      //   1479: iload 13
      //   1481: istore 5
      //   1483: goto -1115 -> 368
      //   1486: lload 21
      //   1488: lstore 23
      //   1490: iload_3
      //   1491: istore 10
      //   1493: iload 9
      //   1495: istore 15
      //   1497: iload 8
      //   1499: istore 16
      //   1501: iload 7
      //   1503: istore 11
      //   1505: iload_2
      //   1506: istore 12
      //   1508: iload 13
      //   1510: istore 4
      //   1512: iload 6
      //   1514: istore 17
      //   1516: iload_3
      //   1517: istore 5
      //   1519: aload_0
      //   1520: getfield 28	com/tencent/mm/vfs/MigrationFileSystem$a:LGM	Z
      //   1523: ifne +721 -> 2244
      //   1526: lload 21
      //   1528: lstore 23
      //   1530: iload_3
      //   1531: istore 10
      //   1533: iload 9
      //   1535: istore 15
      //   1537: iload 8
      //   1539: istore 16
      //   1541: iload 7
      //   1543: istore 11
      //   1545: iload_2
      //   1546: istore 12
      //   1548: iload 13
      //   1550: istore 4
      //   1552: iload 6
      //   1554: istore 17
      //   1556: iload_3
      //   1557: istore 5
      //   1559: aload 31
      //   1561: aload 35
      //   1563: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1566: aload 33
      //   1568: aload 35
      //   1570: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1573: invokeinterface 199 4 0
      //   1578: pop2
      //   1579: lload 21
      //   1581: lstore 23
      //   1583: iload_3
      //   1584: istore 10
      //   1586: iload 9
      //   1588: istore 15
      //   1590: iload 8
      //   1592: istore 16
      //   1594: iload 7
      //   1596: istore 11
      //   1598: iload_2
      //   1599: istore 12
      //   1601: iload 13
      //   1603: istore 4
      //   1605: iload 6
      //   1607: istore 17
      //   1609: iload_3
      //   1610: istore 5
      //   1612: aload 33
      //   1614: aload 35
      //   1616: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1619: invokeinterface 170 2 0
      //   1624: pop
      //   1625: lload 21
      //   1627: lstore 23
      //   1629: iload_3
      //   1630: istore 10
      //   1632: iload 9
      //   1634: istore 15
      //   1636: iload 8
      //   1638: istore 16
      //   1640: iload 7
      //   1642: istore 11
      //   1644: iload_2
      //   1645: istore 12
      //   1647: iload 13
      //   1649: istore 4
      //   1651: iload 6
      //   1653: istore 17
      //   1655: iload_3
      //   1656: istore 5
      //   1658: ldc 172
      //   1660: new 174	java/lang/StringBuilder
      //   1663: dup
      //   1664: ldc 201
      //   1666: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1669: aload 35
      //   1671: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1674: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1677: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1680: invokestatic 193	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1683: iload_3
      //   1684: iconst_1
      //   1685: iadd
      //   1686: istore_3
      //   1687: lload 21
      //   1689: lstore 23
      //   1691: iload_3
      //   1692: istore 10
      //   1694: iload 9
      //   1696: istore 15
      //   1698: iload 8
      //   1700: istore 16
      //   1702: iload 7
      //   1704: istore 11
      //   1706: iload_2
      //   1707: istore 12
      //   1709: iload 13
      //   1711: istore 4
      //   1713: iload 6
      //   1715: istore 17
      //   1717: iload_3
      //   1718: istore 5
      //   1720: aload 35
      //   1722: getfield 205	com/tencent/mm/vfs/c:LGb	J
      //   1725: lstore 25
      //   1727: lload 25
      //   1729: lload 21
      //   1731: ladd
      //   1732: lstore 21
      //   1734: iload 13
      //   1736: istore 5
      //   1738: goto -1370 -> 368
      //   1741: astore 36
      //   1743: iload 9
      //   1745: iconst_1
      //   1746: iadd
      //   1747: istore 4
      //   1749: ldc 207
      //   1751: new 174	java/lang/StringBuilder
      //   1754: dup
      //   1755: ldc 209
      //   1757: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1760: aload 35
      //   1762: getfield 130	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
      //   1765: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1768: ldc 211
      //   1770: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1773: aload_0
      //   1774: invokevirtual 212	java/lang/Object:toString	()Ljava/lang/String;
      //   1777: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1780: ldc 214
      //   1782: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1785: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1788: invokestatic 217	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   1791: aload 28
      //   1793: ifnull +26 -> 1819
      //   1796: aload 29
      //   1798: ifnull +21 -> 1819
      //   1801: aload 28
      //   1803: aload 29
      //   1805: invokevirtual 220	java/util/TreeSet:remove	(Ljava/lang/Object;)Z
      //   1808: pop
      //   1809: aload 29
      //   1811: invokestatic 46	com/tencent/mm/vfs/w:bab	(Ljava/lang/String;)Ljava/lang/String;
      //   1814: astore 29
      //   1816: goto -20 -> 1796
      //   1819: iload 5
      //   1821: istore_3
      //   1822: iload 4
      //   1824: istore 9
      //   1826: iload 13
      //   1828: istore 5
      //   1830: goto -1462 -> 368
      //   1833: iload_2
      //   1834: istore 13
      //   1836: aload 28
      //   1838: ifnull +212 -> 2050
      //   1841: lload 21
      //   1843: lstore 23
      //   1845: iload_3
      //   1846: istore 10
      //   1848: iload 9
      //   1850: istore 15
      //   1852: iload 8
      //   1854: istore 16
      //   1856: iload 7
      //   1858: istore 11
      //   1860: iload_2
      //   1861: istore 12
      //   1863: iload 5
      //   1865: istore 4
      //   1867: iload 6
      //   1869: istore 17
      //   1871: aload 28
      //   1873: invokevirtual 224	java/util/TreeSet:descendingSet	()Ljava/util/NavigableSet;
      //   1876: invokeinterface 227 1 0
      //   1881: astore 28
      //   1883: lload 21
      //   1885: lstore 23
      //   1887: iload_3
      //   1888: istore 10
      //   1890: iload 9
      //   1892: istore 15
      //   1894: iload 8
      //   1896: istore 16
      //   1898: iload 7
      //   1900: istore 11
      //   1902: iload_2
      //   1903: istore 12
      //   1905: iload 5
      //   1907: istore 4
      //   1909: iload 6
      //   1911: istore 17
      //   1913: iload_2
      //   1914: istore 13
      //   1916: aload 28
      //   1918: invokeinterface 122 1 0
      //   1923: ifeq +127 -> 2050
      //   1926: lload 21
      //   1928: lstore 23
      //   1930: iload_3
      //   1931: istore 10
      //   1933: iload 9
      //   1935: istore 15
      //   1937: iload 8
      //   1939: istore 16
      //   1941: iload 7
      //   1943: istore 11
      //   1945: iload_2
      //   1946: istore 12
      //   1948: iload 5
      //   1950: istore 4
      //   1952: iload 6
      //   1954: istore 17
      //   1956: aload 28
      //   1958: invokeinterface 126 1 0
      //   1963: checkcast 229	java/lang/String
      //   1966: astore 29
      //   1968: lload 21
      //   1970: lstore 23
      //   1972: iload_3
      //   1973: istore 10
      //   1975: iload 9
      //   1977: istore 15
      //   1979: iload 8
      //   1981: istore 16
      //   1983: iload 7
      //   1985: istore 11
      //   1987: iload_2
      //   1988: istore 12
      //   1990: iload 5
      //   1992: istore 4
      //   1994: iload 6
      //   1996: istore 17
      //   1998: aload_1
      //   1999: invokevirtual 90	android/os/CancellationSignal:throwIfCanceled	()V
      //   2002: lload 21
      //   2004: lstore 23
      //   2006: iload_3
      //   2007: istore 10
      //   2009: iload 9
      //   2011: istore 15
      //   2013: iload 8
      //   2015: istore 16
      //   2017: iload 7
      //   2019: istore 11
      //   2021: iload_2
      //   2022: istore 12
      //   2024: iload 5
      //   2026: istore 4
      //   2028: iload 6
      //   2030: istore 17
      //   2032: aload 33
      //   2034: aload 29
      //   2036: iconst_0
      //   2037: invokeinterface 233 3 0
      //   2042: pop
      //   2043: iload_2
      //   2044: iconst_1
      //   2045: iadd
      //   2046: istore_2
      //   2047: goto -164 -> 1883
      //   2050: iload 13
      //   2052: istore_2
      //   2053: iload_3
      //   2054: istore 4
      //   2056: iload 8
      //   2058: istore_3
      //   2059: iload 18
      //   2061: iconst_1
      //   2062: iadd
      //   2063: istore 18
      //   2065: goto -1778 -> 287
      //   2068: aload_0
      //   2069: getfield 19	com/tencent/mm/vfs/MigrationFileSystem$a:LGN	Lcom/tencent/mm/vfs/MigrationFileSystem;
      //   2072: iconst_3
      //   2073: bipush 18
      //   2075: anewarray 92	java/lang/Object
      //   2078: dup
      //   2079: iconst_0
      //   2080: ldc 94
      //   2082: aastore
      //   2083: dup
      //   2084: iconst_1
      //   2085: aload 31
      //   2087: aastore
      //   2088: dup
      //   2089: iconst_2
      //   2090: ldc 142
      //   2092: aastore
      //   2093: dup
      //   2094: iconst_3
      //   2095: iload 6
      //   2097: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2100: aastore
      //   2101: dup
      //   2102: iconst_4
      //   2103: ldc 150
      //   2105: aastore
      //   2106: dup
      //   2107: iconst_5
      //   2108: iload 5
      //   2110: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2113: aastore
      //   2114: dup
      //   2115: bipush 6
      //   2117: ldc 152
      //   2119: aastore
      //   2120: dup
      //   2121: bipush 7
      //   2123: iload_2
      //   2124: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2127: aastore
      //   2128: dup
      //   2129: bipush 8
      //   2131: ldc 154
      //   2133: aastore
      //   2134: dup
      //   2135: bipush 9
      //   2137: iload 7
      //   2139: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2142: aastore
      //   2143: dup
      //   2144: bipush 10
      //   2146: ldc 156
      //   2148: aastore
      //   2149: dup
      //   2150: bipush 11
      //   2152: iload 4
      //   2154: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2157: aastore
      //   2158: dup
      //   2159: bipush 12
      //   2161: ldc 158
      //   2163: aastore
      //   2164: dup
      //   2165: bipush 13
      //   2167: iload_3
      //   2168: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2171: aastore
      //   2172: dup
      //   2173: bipush 14
      //   2175: ldc 160
      //   2177: aastore
      //   2178: dup
      //   2179: bipush 15
      //   2181: iload 9
      //   2183: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2186: aastore
      //   2187: dup
      //   2188: bipush 16
      //   2190: ldc 162
      //   2192: aastore
      //   2193: dup
      //   2194: bipush 17
      //   2196: lload 21
      //   2198: invokestatic 167	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2201: aastore
      //   2202: invokevirtual 98	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
      //   2205: aload_0
      //   2206: aload_1
      //   2207: invokespecial 235	com/tencent/mm/vfs/b:a	(Landroid/os/CancellationSignal;)V
      //   2210: ldc 82
      //   2212: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2215: return
      //   2216: iconst_5
      //   2217: istore_3
      //   2218: goto -1392 -> 826
      //   2221: astore_1
      //   2222: iload_3
      //   2223: istore 8
      //   2225: goto -1408 -> 817
      //   2228: astore_1
      //   2229: iload 4
      //   2231: istore 9
      //   2233: iload 5
      //   2235: istore 4
      //   2237: iload 13
      //   2239: istore 5
      //   2241: goto -1424 -> 817
      //   2244: goto -510 -> 1734
      //   2247: iload 9
      //   2249: istore 4
      //   2251: goto -429 -> 1822
      //   2254: goto -195 -> 2059
      //   2257: aconst_null
      //   2258: astore 28
      //   2260: goto -1907 -> 353
      //   2263: astore 29
      //   2265: iconst_0
      //   2266: istore 27
      //   2268: goto -1691 -> 577
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2271	0	this	a
      //   0	2271	1	paramCancellationSignal	android.os.CancellationSignal
      //   28	2096	2	i	int
      //   39	2184	3	j	int
      //   81	2169	4	k	int
      //   22	2218	5	m	int
      //   16	2080	6	n	int
      //   30	2108	7	i1	int
      //   33	2191	8	i2	int
      //   44	2204	9	i3	int
      //   61	1947	10	i4	int
      //   73	1947	11	i5	int
      //   77	1946	12	i6	int
      //   13	2225	13	i7	int
      //   19	1145	14	i8	int
      //   65	1947	15	i9	int
      //   69	1947	16	i10	int
      //   85	1946	17	i11	int
      //   25	2039	18	i12	int
      //   36	256	19	i13	int
      //   41	199	20	i14	int
      //   47	2150	21	l1	long
      //   57	1948	23	l2	long
      //   1725	3	25	l3	long
      //   519	1748	27	bool	boolean
      //   351	1908	28	localObject1	Object
      //   322	1713	29	localObject2	Object
      //   2263	1	29	localIOException1	java.io.IOException
      //   53	791	30	localList	List
      //   98	1988	31	localb1	FileSystem.b
      //   139	922	32	localHashSet	HashSet
      //   310	1723	33	localb2	FileSystem.b
      //   360	79	34	localIterator	Iterator
      //   448	1313	35	localc	c
      //   1741	1	36	localIOException2	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   87	100	785	java/lang/Exception
      //   132	141	785	java/lang/Exception
      //   173	177	785	java/lang/Exception
      //   209	231	785	java/lang/Exception
      //   263	272	785	java/lang/Exception
      //   398	408	785	java/lang/Exception
      //   438	450	785	java/lang/Exception
      //   480	484	785	java/lang/Exception
      //   514	521	785	java/lang/Exception
      //   556	577	785	java/lang/Exception
      //   612	623	785	java/lang/Exception
      //   666	679	785	java/lang/Exception
      //   709	722	785	java/lang/Exception
      //   767	778	785	java/lang/Exception
      //   1007	1017	785	java/lang/Exception
      //   1060	1070	785	java/lang/Exception
      //   1100	1110	785	java/lang/Exception
      //   1155	1163	785	java/lang/Exception
      //   1197	1212	785	java/lang/Exception
      //   1242	1249	785	java/lang/Exception
      //   1279	1292	785	java/lang/Exception
      //   1328	1353	785	java/lang/Exception
      //   1393	1415	785	java/lang/Exception
      //   1448	1473	785	java/lang/Exception
      //   1519	1526	785	java/lang/Exception
      //   1559	1579	785	java/lang/Exception
      //   1612	1625	785	java/lang/Exception
      //   1658	1683	785	java/lang/Exception
      //   1720	1727	785	java/lang/Exception
      //   1871	1883	785	java/lang/Exception
      //   1916	1926	785	java/lang/Exception
      //   1956	1968	785	java/lang/Exception
      //   1998	2002	785	java/lang/Exception
      //   2032	2043	785	java/lang/Exception
      //   1393	1415	1741	java/io/IOException
      //   1448	1473	1741	java/io/IOException
      //   1519	1526	1741	java/io/IOException
      //   1559	1579	1741	java/io/IOException
      //   1612	1625	1741	java/io/IOException
      //   1658	1683	1741	java/io/IOException
      //   1720	1727	1741	java/io/IOException
      //   294	324	2221	java/lang/Exception
      //   329	353	2221	java/lang/Exception
      //   353	362	2221	java/lang/Exception
      //   2068	2205	2221	java/lang/Exception
      //   1749	1791	2228	java/lang/Exception
      //   1801	1816	2228	java/lang/Exception
      //   556	577	2263	java/io/IOException
    }
    
    public final boolean a(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193383);
      boolean bool = super.a(paramString1, paramb, paramString2);
      if ((!bool) && (aZM(paramString1)))
      {
        bool = super.a(paramString1, paramb, paramString2);
        AppMethodBeat.o(193383);
        return bool;
      }
      AppMethodBeat.o(193383);
      return bool;
    }
    
    public final ReadableByteChannel aZD(String paramString)
    {
      AppMethodBeat.i(193377);
      Object localObject1 = null;
      Iterator localIterator = this.LGK.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label68;
        }
        Object localObject2 = (FileSystem.b)localIterator.next();
        try
        {
          localObject2 = ((FileSystem.b)localObject2).aZD(paramString);
          if (localObject2 != null)
          {
            AppMethodBeat.o(193377);
            return localObject2;
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (localObject1 != null) {
            break label109;
          }
        }
      }
      localObject1 = localFileNotFoundException;
      label68:
      label109:
      for (;;)
      {
        break;
        if (localObject1 != null) {}
        for (;;)
        {
          AppMethodBeat.o(193377);
          throw ((Throwable)localObject1);
          localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
        }
      }
    }
    
    public final boolean aZG(String paramString)
    {
      AppMethodBeat.i(193381);
      Iterator localIterator = this.LGK.iterator();
      while (localIterator.hasNext()) {
        if (((FileSystem.b)localIterator.next()).aZG(paramString))
        {
          AppMethodBeat.o(193381);
          return true;
        }
      }
      AppMethodBeat.o(193381);
      return false;
    }
    
    public final c aZH(String paramString)
    {
      AppMethodBeat.i(193382);
      Iterator localIterator = this.LGK.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((FileSystem.b)localIterator.next()).aZH(paramString);
        if (localc != null)
        {
          AppMethodBeat.o(193382);
          return localc;
        }
      }
      AppMethodBeat.o(193382);
      return null;
    }
    
    public final long c(String paramString1, FileSystem.b paramb, String paramString2)
    {
      AppMethodBeat.i(193384);
      try
      {
        l = super.c(paramString1, paramb, paramString2);
        AppMethodBeat.o(193384);
        return l;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        long l;
        if (aZM(paramString1))
        {
          l = super.c(paramString1, paramb, paramString2);
          AppMethodBeat.o(193384);
          return l;
        }
        AppMethodBeat.o(193384);
        throw localFileNotFoundException;
      }
    }
    
    public final WritableByteChannel da(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193380);
      FileSystem.b localb = (FileSystem.b)this.LGK.get(0);
      try
      {
        WritableByteChannel localWritableByteChannel = localb.da(paramString, paramBoolean);
        AppMethodBeat.o(193380);
        return localWritableByteChannel;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        if ((!paramBoolean) && (aZM(paramString)))
        {
          paramString = localb.da(paramString, false);
          AppMethodBeat.o(193380);
          return paramString;
        }
        AppMethodBeat.o(193380);
        throw localFileNotFoundException;
      }
    }
    
    public final OutputStream db(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193379);
      FileSystem.b localb = (FileSystem.b)this.LGK.get(0);
      try
      {
        OutputStream localOutputStream = localb.db(paramString, paramBoolean);
        AppMethodBeat.o(193379);
        return localOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        if ((!paramBoolean) && (aZM(paramString)))
        {
          paramString = localb.db(paramString, false);
          AppMethodBeat.o(193379);
          return paramString;
        }
        AppMethodBeat.o(193379);
        throw localFileNotFoundException;
      }
    }
    
    public final FileSystem fSK()
    {
      return MigrationFileSystem.this;
    }
    
    public final List<FileSystem.b> fSM()
    {
      return this.LGK;
    }
    
    public final FileSystem.b gU(String paramString, int paramInt)
    {
      AppMethodBeat.i(193375);
      List localList = this.LGK;
      if ((paramInt == 1) || (paramInt == 3))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          FileSystem.b localb = (FileSystem.b)localIterator.next();
          if (localb.aZG(paramString))
          {
            AppMethodBeat.o(193375);
            return localb;
          }
        }
      }
      paramString = (FileSystem.b)localList.get(0);
      AppMethodBeat.o(193375);
      return paramString;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(193376);
      Object localObject1 = null;
      Iterator localIterator = this.LGK.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label70;
        }
        Object localObject2 = (FileSystem.b)localIterator.next();
        try
        {
          localObject2 = ((FileSystem.b)localObject2).openRead(paramString);
          if (localObject2 != null)
          {
            AppMethodBeat.o(193376);
            return localObject2;
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (localObject1 != null) {
            break label112;
          }
        }
      }
      localObject1 = localFileNotFoundException;
      label70:
      label112:
      for (;;)
      {
        break;
        if (localObject1 != null) {}
        for (;;)
        {
          AppMethodBeat.o(193376);
          throw ((Throwable)localObject1);
          localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */