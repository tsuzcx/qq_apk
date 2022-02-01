package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class MigrationFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<MigrationFileSystem> CREATOR;
  protected final FileSystem[] YBx;
  protected final String YCV;
  protected final String YCW;
  protected final String YCX;
  protected final String YCY;
  
  static
  {
    AppMethodBeat.i(13141);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13141);
  }
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13131);
    ad.a(paramParcel, MigrationFileSystem.class, 6);
    int j = paramParcel.readInt();
    this.YBx = new FileSystem[j];
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
      this.YBx[i] = localFileSystem;
      i += 1;
    }
    this.YCV = paramParcel.readString();
    this.YCW = paramParcel.readString();
    this.YCX = paramParcel.readString();
    this.YCY = paramParcel.readString();
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
    AppMethodBeat.i(236310);
    if (paramFileSystem == null)
    {
      paramString1 = new IllegalArgumentException("destination == null");
      AppMethodBeat.o(236310);
      throw paramString1;
    }
    this.YCV = paramString1;
    this.YCW = paramString2;
    this.YCX = paramString3;
    this.YCY = null;
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
        this.YBx = paramString1;
        AppMethodBeat.o(236310);
        return;
        paramString1 = (FileSystem[])Arrays.copyOf(paramString1, i);
      }
    }
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(236320);
    boolean bool1;
    int j;
    label32:
    int i;
    if (ad.ad(this.YCV, paramMap) != null)
    {
      bool1 = true;
      if (ad.ad(this.YCW, paramMap) == null) {
        break label107;
      }
      j = 1;
      if (ad.ad(this.YCX, paramMap) == null) {
        break label112;
      }
      i = 1;
      label45:
      if (ad.ad(this.YCY, paramMap) == null) {
        break label117;
      }
    }
    label107:
    label112:
    label117:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject1 = this.YBx;
      int m = localObject1.length;
      int k = 0;
      while (k < m)
      {
        localObject1[k].cp(paramMap);
        k += 1;
      }
      bool1 = false;
      break;
      j = 0;
      break label32;
      i = 0;
      break label45;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject1 = this.YBx[0].cp(paramMap);
    localLinkedHashSet.add(localObject1);
    Object localObject2;
    if ((localObject1 instanceof NativeFileSystem.c))
    {
      localObject1 = ((NativeFileSystem.c)localObject1).ifp();
      if ((localObject1 != null) && (j != 0))
      {
        localObject2 = new File((String)localObject1);
        localObject1 = localObject2;
        if (!((File)localObject2).exists()) {}
      }
    }
    for (localObject1 = null;; localObject1 = null)
    {
      j = 1;
      FileSystem.b localb;
      boolean bool3;
      if (j < this.YBx.length)
      {
        localb = this.YBx[j].cp(paramMap);
        localObject2 = localObject1;
        if (localb != NullFileSystem.ifq())
        {
          if (!(localb instanceof NativeFileSystem.c)) {
            break label384;
          }
          localObject2 = ((NativeFileSystem.c)localb).ifp();
          if (localObject2 == null) {
            break label428;
          }
          localObject2 = new File((String)localObject2);
          bool3 = ((File)localObject2).isDirectory();
          if ((!bool3) || (localObject1 == null) || (!((File)localObject2).renameTo((File)localObject1))) {
            break label435;
          }
          Log.i("VFS.MigrationFileSystem", "Fast moved '" + localObject2 + "' -> '" + localObject1 + "'");
          bool3 = false;
          localObject1 = null;
        }
      }
      label384:
      label428:
      label435:
      for (;;)
      {
        if (!bool3)
        {
          localObject2 = localObject1;
          if (i == 0) {}
        }
        else
        {
          localLinkedHashSet.add(localb);
          localObject2 = localObject1;
        }
        for (;;)
        {
          j += 1;
          localObject1 = localObject2;
          break;
          localLinkedHashSet.add(localb);
          localObject2 = localObject1;
          continue;
          paramMap = new a(new ArrayList(localLinkedHashSet), bool1, bool2);
          AppMethodBeat.o(236320);
          return paramMap;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13139);
    Object localObject = new StringBuilder("Migration [").append(this.YBx[0].toString()).append(" <= ");
    int i = 1;
    while (i < this.YBx.length)
    {
      ((StringBuilder)localObject).append(this.YBx[i].toString()).append(", ");
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
    ad.b(paramParcel, MigrationFileSystem.class, 6);
    paramParcel.writeInt(this.YBx.length);
    FileSystem[] arrayOfFileSystem = this.YBx;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    paramParcel.writeString(this.YCV);
    paramParcel.writeString(this.YCW);
    paramParcel.writeString(this.YCX);
    paramParcel.writeString(this.YCY);
    AppMethodBeat.o(13140);
  }
  
  protected final class a
    extends d
  {
    protected final List<FileSystem.b> YCZ;
    protected final boolean YDa;
    protected final boolean YDb;
    
    protected a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.YCZ = paramBoolean1;
      this.YDa = paramBoolean2;
      boolean bool;
      this.YDb = bool;
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(236290);
      Object localObject1 = null;
      Iterator localIterator = this.YCZ.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (FileSystem.b)localIterator.next();
        try
        {
          localObject2 = ((FileSystem.b)localObject2).Tf(paramString);
          AppMethodBeat.o(236290);
          return localObject2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (localObject1 != null) {
            break label105;
          }
        }
        localObject1 = localFileNotFoundException;
      }
      label105:
      for (;;)
      {
        break;
        if (localObject1 != null) {}
        for (;;)
        {
          AppMethodBeat.o(236290);
          throw ((Throwable)localObject1);
          localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
        }
      }
    }
    
    /* Error */
    public final void a(android.os.CancellationSignal paramCancellationSignal)
    {
      // Byte code:
      //   0: ldc 87
      //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 26	com/tencent/mm/vfs/MigrationFileSystem$a:YDa	Z
      //   9: ifeq +2213 -> 2222
      //   12: aload_0
      //   13: getfield 24	com/tencent/mm/vfs/MigrationFileSystem$a:YCZ	Ljava/util/List;
      //   16: iconst_0
      //   17: invokeinterface 91 2 0
      //   22: invokestatic 97	com/tencent/mm/vfs/NullFileSystem:ifq	()Lcom/tencent/mm/vfs/FileSystem$b;
      //   25: if_acmpeq +2197 -> 2222
      //   28: iconst_0
      //   29: istore 13
      //   31: iconst_0
      //   32: istore 6
      //   34: iconst_0
      //   35: istore 14
      //   37: iconst_0
      //   38: istore 5
      //   40: iconst_0
      //   41: istore 18
      //   43: iconst_0
      //   44: istore_2
      //   45: iconst_0
      //   46: istore 7
      //   48: iconst_0
      //   49: istore 8
      //   51: iconst_0
      //   52: istore 19
      //   54: iconst_0
      //   55: istore_3
      //   56: iconst_0
      //   57: istore 20
      //   59: iconst_0
      //   60: istore 9
      //   62: lconst_0
      //   63: lstore 21
      //   65: aload_0
      //   66: getfield 24	com/tencent/mm/vfs/MigrationFileSystem$a:YCZ	Ljava/util/List;
      //   69: astore 30
      //   71: lload 21
      //   73: lstore 23
      //   75: iload 19
      //   77: istore 10
      //   79: iload 20
      //   81: istore 15
      //   83: iload 8
      //   85: istore 16
      //   87: iload 7
      //   89: istore 11
      //   91: iload 18
      //   93: istore 12
      //   95: iload 14
      //   97: istore 4
      //   99: iload 13
      //   101: istore 17
      //   103: aload 30
      //   105: iconst_0
      //   106: invokeinterface 91 2 0
      //   111: checkcast 60	com/tencent/mm/vfs/FileSystem$b
      //   114: astore 31
      //   116: lload 21
      //   118: lstore 23
      //   120: iload 19
      //   122: istore 10
      //   124: iload 20
      //   126: istore 15
      //   128: iload 8
      //   130: istore 16
      //   132: iload 7
      //   134: istore 11
      //   136: iload 18
      //   138: istore 12
      //   140: iload 14
      //   142: istore 4
      //   144: iload 13
      //   146: istore 17
      //   148: new 99	java/util/HashSet
      //   151: dup
      //   152: invokespecial 100	java/util/HashSet:<init>	()V
      //   155: astore 32
      //   157: lload 21
      //   159: lstore 23
      //   161: iload 19
      //   163: istore 10
      //   165: iload 20
      //   167: istore 15
      //   169: iload 8
      //   171: istore 16
      //   173: iload 7
      //   175: istore 11
      //   177: iload 18
      //   179: istore 12
      //   181: iload 14
      //   183: istore 4
      //   185: iload 13
      //   187: istore 17
      //   189: aload_1
      //   190: invokevirtual 105	android/os/CancellationSignal:throwIfCanceled	()V
      //   193: lload 21
      //   195: lstore 23
      //   197: iload 19
      //   199: istore 10
      //   201: iload 20
      //   203: istore 15
      //   205: iload 8
      //   207: istore 16
      //   209: iload 7
      //   211: istore 11
      //   213: iload 18
      //   215: istore 12
      //   217: iload 14
      //   219: istore 4
      //   221: iload 13
      //   223: istore 17
      //   225: aload_0
      //   226: getfield 19	com/tencent/mm/vfs/MigrationFileSystem$a:YDc	Lcom/tencent/mm/vfs/MigrationFileSystem;
      //   229: iconst_1
      //   230: iconst_2
      //   231: anewarray 107	java/lang/Object
      //   234: dup
      //   235: iconst_0
      //   236: ldc 109
      //   238: aastore
      //   239: dup
      //   240: iconst_1
      //   241: aload 31
      //   243: aastore
      //   244: invokevirtual 113	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
      //   247: lload 21
      //   249: lstore 23
      //   251: iload 19
      //   253: istore 10
      //   255: iload 20
      //   257: istore 15
      //   259: iload 8
      //   261: istore 16
      //   263: iload 7
      //   265: istore 11
      //   267: iload 18
      //   269: istore 12
      //   271: iload 14
      //   273: istore 4
      //   275: iload 13
      //   277: istore 17
      //   279: aload 30
      //   281: invokeinterface 117 1 0
      //   286: istore 19
      //   288: iconst_1
      //   289: istore 18
      //   291: iconst_0
      //   292: istore 8
      //   294: iconst_0
      //   295: istore 7
      //   297: iload_3
      //   298: istore 4
      //   300: iload 8
      //   302: istore_3
      //   303: iload 18
      //   305: iload 19
      //   307: if_icmpge +1778 -> 2085
      //   310: aload_1
      //   311: invokevirtual 105	android/os/CancellationSignal:throwIfCanceled	()V
      //   314: aload 30
      //   316: iload 18
      //   318: invokeinterface 91 2 0
      //   323: checkcast 60	com/tencent/mm/vfs/FileSystem$b
      //   326: astore 33
      //   328: aload 33
      //   330: ldc 119
      //   332: iconst_1
      //   333: invokeinterface 123 3 0
      //   338: astore 29
      //   340: aload 29
      //   342: ifnull +1929 -> 2271
      //   345: aload 33
      //   347: invokeinterface 126 1 0
      //   352: bipush 9
      //   354: iand
      //   355: bipush 9
      //   357: if_icmpne +1917 -> 2274
      //   360: new 128	java/util/TreeSet
      //   363: dup
      //   364: invokespecial 129	java/util/TreeSet:<init>	()V
      //   367: astore 28
      //   369: aload 29
      //   371: invokeinterface 132 1 0
      //   376: astore 34
      //   378: iload_3
      //   379: istore 8
      //   381: iload 4
      //   383: istore_3
      //   384: lload 21
      //   386: lstore 23
      //   388: iload_3
      //   389: istore 10
      //   391: iload 9
      //   393: istore 15
      //   395: iload 8
      //   397: istore 16
      //   399: iload 7
      //   401: istore 11
      //   403: iload_2
      //   404: istore 12
      //   406: iload 5
      //   408: istore 4
      //   410: iload 6
      //   412: istore 17
      //   414: aload 34
      //   416: invokeinterface 54 1 0
      //   421: ifeq +1429 -> 1850
      //   424: lload 21
      //   426: lstore 23
      //   428: iload_3
      //   429: istore 10
      //   431: iload 9
      //   433: istore 15
      //   435: iload 8
      //   437: istore 16
      //   439: iload 7
      //   441: istore 11
      //   443: iload_2
      //   444: istore 12
      //   446: iload 5
      //   448: istore 4
      //   450: iload 6
      //   452: istore 17
      //   454: aload 34
      //   456: invokeinterface 58 1 0
      //   461: checkcast 134	com/tencent/mm/vfs/f
      //   464: astore 35
      //   466: lload 21
      //   468: lstore 23
      //   470: iload_3
      //   471: istore 10
      //   473: iload 9
      //   475: istore 15
      //   477: iload 8
      //   479: istore 16
      //   481: iload 7
      //   483: istore 11
      //   485: iload_2
      //   486: istore 12
      //   488: iload 5
      //   490: istore 4
      //   492: iload 6
      //   494: istore 17
      //   496: aload_1
      //   497: invokevirtual 105	android/os/CancellationSignal:throwIfCanceled	()V
      //   500: lload 21
      //   502: lstore 23
      //   504: iload_3
      //   505: istore 10
      //   507: iload 9
      //   509: istore 15
      //   511: iload 8
      //   513: istore 16
      //   515: iload 7
      //   517: istore 11
      //   519: iload_2
      //   520: istore 12
      //   522: iload 5
      //   524: istore 4
      //   526: iload 6
      //   528: istore 17
      //   530: aload 35
      //   532: getfield 137	com/tencent/mm/vfs/f:YCj	Z
      //   535: istore 27
      //   537: iload 27
      //   539: ifeq +454 -> 993
      //   542: lload 21
      //   544: lstore 23
      //   546: iload_3
      //   547: istore 10
      //   549: iload 9
      //   551: istore 15
      //   553: iload 8
      //   555: istore 16
      //   557: iload 7
      //   559: istore 11
      //   561: iload_2
      //   562: istore 12
      //   564: iload 5
      //   566: istore 4
      //   568: iload 6
      //   570: istore 17
      //   572: aload 31
      //   574: aload 35
      //   576: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   579: aload 33
      //   581: aload 35
      //   583: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   586: invokeinterface 144 4 0
      //   591: istore 27
      //   593: iload 27
      //   595: ifeq +53 -> 648
      //   598: lload 21
      //   600: lstore 23
      //   602: iload_3
      //   603: istore 10
      //   605: iload 9
      //   607: istore 15
      //   609: iload 8
      //   611: istore 16
      //   613: iload 7
      //   615: istore 11
      //   617: iload_2
      //   618: istore 12
      //   620: iload 5
      //   622: istore 4
      //   624: iload 6
      //   626: istore 17
      //   628: aload 32
      //   630: aload 35
      //   632: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   635: invokevirtual 148	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   638: pop
      //   639: iload 6
      //   641: iconst_1
      //   642: iadd
      //   643: istore 6
      //   645: goto -261 -> 384
      //   648: iload 5
      //   650: istore 13
      //   652: lload 21
      //   654: lstore 23
      //   656: iload_3
      //   657: istore 10
      //   659: iload 9
      //   661: istore 15
      //   663: iload 8
      //   665: istore 16
      //   667: iload 7
      //   669: istore 11
      //   671: iload_2
      //   672: istore 12
      //   674: iload 5
      //   676: istore 4
      //   678: iload 6
      //   680: istore 17
      //   682: aload 32
      //   684: aload 35
      //   686: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   689: invokevirtual 148	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   692: ifeq +52 -> 744
      //   695: lload 21
      //   697: lstore 23
      //   699: iload_3
      //   700: istore 10
      //   702: iload 9
      //   704: istore 15
      //   706: iload 8
      //   708: istore 16
      //   710: iload 7
      //   712: istore 11
      //   714: iload_2
      //   715: istore 12
      //   717: iload 5
      //   719: istore 4
      //   721: iload 6
      //   723: istore 17
      //   725: aload 31
      //   727: aload 35
      //   729: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   732: invokeinterface 152 2 0
      //   737: pop
      //   738: iload 5
      //   740: iconst_1
      //   741: iadd
      //   742: istore 13
      //   744: iload 13
      //   746: istore 5
      //   748: aload 28
      //   750: ifnull -366 -> 384
      //   753: lload 21
      //   755: lstore 23
      //   757: iload_3
      //   758: istore 10
      //   760: iload 9
      //   762: istore 15
      //   764: iload 8
      //   766: istore 16
      //   768: iload 7
      //   770: istore 11
      //   772: iload_2
      //   773: istore 12
      //   775: iload 13
      //   777: istore 4
      //   779: iload 6
      //   781: istore 17
      //   783: aload 28
      //   785: aload 35
      //   787: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   790: invokevirtual 153	java/util/TreeSet:add	(Ljava/lang/Object;)Z
      //   793: pop
      //   794: iload 13
      //   796: istore 5
      //   798: goto -414 -> 384
      //   801: astore_1
      //   802: iload 17
      //   804: istore 6
      //   806: iload 4
      //   808: istore 5
      //   810: iload 12
      //   812: istore_2
      //   813: iload 11
      //   815: istore 7
      //   817: iload 16
      //   819: istore 8
      //   821: iload 15
      //   823: istore 9
      //   825: iload 10
      //   827: istore 4
      //   829: lload 23
      //   831: lstore 21
      //   833: aload_1
      //   834: instanceof 155
      //   837: ifeq +1396 -> 2233
      //   840: iconst_4
      //   841: istore_3
      //   842: aload_0
      //   843: getfield 19	com/tencent/mm/vfs/MigrationFileSystem$a:YDc	Lcom/tencent/mm/vfs/MigrationFileSystem;
      //   846: iload_3
      //   847: bipush 18
      //   849: anewarray 107	java/lang/Object
      //   852: dup
      //   853: iconst_0
      //   854: ldc 109
      //   856: aastore
      //   857: dup
      //   858: iconst_1
      //   859: aload 30
      //   861: iconst_0
      //   862: invokeinterface 91 2 0
      //   867: aastore
      //   868: dup
      //   869: iconst_2
      //   870: ldc 157
      //   872: aastore
      //   873: dup
      //   874: iconst_3
      //   875: iload 6
      //   877: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   880: aastore
      //   881: dup
      //   882: iconst_4
      //   883: ldc 165
      //   885: aastore
      //   886: dup
      //   887: iconst_5
      //   888: iload 5
      //   890: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   893: aastore
      //   894: dup
      //   895: bipush 6
      //   897: ldc 167
      //   899: aastore
      //   900: dup
      //   901: bipush 7
      //   903: iload_2
      //   904: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   907: aastore
      //   908: dup
      //   909: bipush 8
      //   911: ldc 169
      //   913: aastore
      //   914: dup
      //   915: bipush 9
      //   917: iload 7
      //   919: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   922: aastore
      //   923: dup
      //   924: bipush 10
      //   926: ldc 171
      //   928: aastore
      //   929: dup
      //   930: bipush 11
      //   932: iload 4
      //   934: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   937: aastore
      //   938: dup
      //   939: bipush 12
      //   941: ldc 173
      //   943: aastore
      //   944: dup
      //   945: bipush 13
      //   947: iload 8
      //   949: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   952: aastore
      //   953: dup
      //   954: bipush 14
      //   956: ldc 175
      //   958: aastore
      //   959: dup
      //   960: bipush 15
      //   962: iload 9
      //   964: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   967: aastore
      //   968: dup
      //   969: bipush 16
      //   971: ldc 177
      //   973: aastore
      //   974: dup
      //   975: bipush 17
      //   977: lload 21
      //   979: invokestatic 182	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   982: aastore
      //   983: invokevirtual 113	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
      //   986: ldc 87
      //   988: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   991: aload_1
      //   992: athrow
      //   993: lload 21
      //   995: lstore 23
      //   997: iload_3
      //   998: istore 10
      //   1000: iload 9
      //   1002: istore 15
      //   1004: iload 8
      //   1006: istore 16
      //   1008: iload 7
      //   1010: istore 11
      //   1012: iload_2
      //   1013: istore 12
      //   1015: iload 5
      //   1017: istore 4
      //   1019: iload 6
      //   1021: istore 17
      //   1023: aload 35
      //   1025: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1028: invokestatic 188	com/tencent/mm/vfs/ad:bCc	(Ljava/lang/String;)Ljava/lang/String;
      //   1031: astore 29
      //   1033: iload 5
      //   1035: istore 13
      //   1037: aload 29
      //   1039: ifnull +144 -> 1183
      //   1042: lload 21
      //   1044: lstore 23
      //   1046: iload_3
      //   1047: istore 10
      //   1049: iload 9
      //   1051: istore 15
      //   1053: iload 8
      //   1055: istore 16
      //   1057: iload 7
      //   1059: istore 11
      //   1061: iload_2
      //   1062: istore 12
      //   1064: iload 5
      //   1066: istore 4
      //   1068: iload 6
      //   1070: istore 17
      //   1072: iload 5
      //   1074: istore 14
      //   1076: aload 32
      //   1078: aload 29
      //   1080: invokevirtual 148	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   1083: ifeq +49 -> 1132
      //   1086: lload 21
      //   1088: lstore 23
      //   1090: iload_3
      //   1091: istore 10
      //   1093: iload 9
      //   1095: istore 15
      //   1097: iload 8
      //   1099: istore 16
      //   1101: iload 7
      //   1103: istore 11
      //   1105: iload_2
      //   1106: istore 12
      //   1108: iload 5
      //   1110: istore 4
      //   1112: iload 6
      //   1114: istore 17
      //   1116: aload 31
      //   1118: aload 29
      //   1120: invokeinterface 152 2 0
      //   1125: pop
      //   1126: iload 5
      //   1128: iconst_1
      //   1129: iadd
      //   1130: istore 14
      //   1132: iload 14
      //   1134: istore 13
      //   1136: aload 28
      //   1138: ifnull +45 -> 1183
      //   1141: lload 21
      //   1143: lstore 23
      //   1145: iload_3
      //   1146: istore 10
      //   1148: iload 9
      //   1150: istore 15
      //   1152: iload 8
      //   1154: istore 16
      //   1156: iload 7
      //   1158: istore 11
      //   1160: iload_2
      //   1161: istore 12
      //   1163: iload 14
      //   1165: istore 4
      //   1167: iload 6
      //   1169: istore 17
      //   1171: aload 28
      //   1173: aload 29
      //   1175: invokevirtual 153	java/util/TreeSet:add	(Ljava/lang/Object;)Z
      //   1178: pop
      //   1179: iload 14
      //   1181: istore 13
      //   1183: lload 21
      //   1185: lstore 23
      //   1187: iload_3
      //   1188: istore 10
      //   1190: iload 9
      //   1192: istore 15
      //   1194: iload 8
      //   1196: istore 16
      //   1198: iload 7
      //   1200: istore 11
      //   1202: iload_2
      //   1203: istore 12
      //   1205: iload 13
      //   1207: istore 4
      //   1209: iload 6
      //   1211: istore 17
      //   1213: aload 31
      //   1215: aload 35
      //   1217: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1220: invokeinterface 191 2 0
      //   1225: ifeq +151 -> 1376
      //   1228: lload 21
      //   1230: lstore 23
      //   1232: iload_3
      //   1233: istore 10
      //   1235: iload 9
      //   1237: istore 15
      //   1239: iload 8
      //   1241: istore 16
      //   1243: iload 7
      //   1245: istore 11
      //   1247: iload_2
      //   1248: istore 12
      //   1250: iload 13
      //   1252: istore 4
      //   1254: iload 6
      //   1256: istore 17
      //   1258: aload_0
      //   1259: getfield 28	com/tencent/mm/vfs/MigrationFileSystem$a:YDb	Z
      //   1262: ifne +1002 -> 2264
      //   1265: lload 21
      //   1267: lstore 23
      //   1269: iload_3
      //   1270: istore 10
      //   1272: iload 9
      //   1274: istore 15
      //   1276: iload 8
      //   1278: istore 16
      //   1280: iload 7
      //   1282: istore 11
      //   1284: iload_2
      //   1285: istore 12
      //   1287: iload 13
      //   1289: istore 4
      //   1291: iload 6
      //   1293: istore 17
      //   1295: aload 33
      //   1297: aload 35
      //   1299: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1302: invokeinterface 194 2 0
      //   1307: pop
      //   1308: iload 7
      //   1310: iconst_1
      //   1311: iadd
      //   1312: istore 7
      //   1314: lload 21
      //   1316: lstore 23
      //   1318: iload_3
      //   1319: istore 10
      //   1321: iload 9
      //   1323: istore 15
      //   1325: iload 8
      //   1327: istore 16
      //   1329: iload 7
      //   1331: istore 11
      //   1333: iload_2
      //   1334: istore 12
      //   1336: iload 13
      //   1338: istore 4
      //   1340: iload 6
      //   1342: istore 17
      //   1344: ldc 196
      //   1346: new 67	java/lang/StringBuilder
      //   1349: dup
      //   1350: ldc 198
      //   1352: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1355: aload 35
      //   1357: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1360: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1363: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1366: invokestatic 205	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1369: iload 13
      //   1371: istore 5
      //   1373: goto -989 -> 384
      //   1376: lload 21
      //   1378: lstore 23
      //   1380: iload_3
      //   1381: istore 10
      //   1383: iload 9
      //   1385: istore 15
      //   1387: iload 8
      //   1389: istore 16
      //   1391: iload 7
      //   1393: istore 11
      //   1395: iload_2
      //   1396: istore 12
      //   1398: iload 13
      //   1400: istore 4
      //   1402: iload 6
      //   1404: istore 17
      //   1406: iload_3
      //   1407: istore 5
      //   1409: aload 31
      //   1411: aload 35
      //   1413: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1416: aload 33
      //   1418: aload 35
      //   1420: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1423: invokeinterface 144 4 0
      //   1428: ifeq +74 -> 1502
      //   1431: lload 21
      //   1433: lstore 23
      //   1435: iload_3
      //   1436: istore 10
      //   1438: iload 9
      //   1440: istore 15
      //   1442: iload 8
      //   1444: istore 16
      //   1446: iload 7
      //   1448: istore 11
      //   1450: iload_2
      //   1451: istore 12
      //   1453: iload 13
      //   1455: istore 4
      //   1457: iload 6
      //   1459: istore 17
      //   1461: iload_3
      //   1462: istore 5
      //   1464: ldc 196
      //   1466: new 67	java/lang/StringBuilder
      //   1469: dup
      //   1470: ldc 207
      //   1472: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1475: aload 35
      //   1477: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1480: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1483: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1486: invokestatic 205	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1489: iload 8
      //   1491: iconst_1
      //   1492: iadd
      //   1493: istore 8
      //   1495: iload 13
      //   1497: istore 5
      //   1499: goto -1115 -> 384
      //   1502: lload 21
      //   1504: lstore 23
      //   1506: iload_3
      //   1507: istore 10
      //   1509: iload 9
      //   1511: istore 15
      //   1513: iload 8
      //   1515: istore 16
      //   1517: iload 7
      //   1519: istore 11
      //   1521: iload_2
      //   1522: istore 12
      //   1524: iload 13
      //   1526: istore 4
      //   1528: iload 6
      //   1530: istore 17
      //   1532: iload_3
      //   1533: istore 5
      //   1535: aload_0
      //   1536: getfield 28	com/tencent/mm/vfs/MigrationFileSystem$a:YDb	Z
      //   1539: ifne +722 -> 2261
      //   1542: lload 21
      //   1544: lstore 23
      //   1546: iload_3
      //   1547: istore 10
      //   1549: iload 9
      //   1551: istore 15
      //   1553: iload 8
      //   1555: istore 16
      //   1557: iload 7
      //   1559: istore 11
      //   1561: iload_2
      //   1562: istore 12
      //   1564: iload 13
      //   1566: istore 4
      //   1568: iload 6
      //   1570: istore 17
      //   1572: iload_3
      //   1573: istore 5
      //   1575: aload 31
      //   1577: aload 35
      //   1579: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1582: aload 33
      //   1584: aload 35
      //   1586: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1589: iconst_0
      //   1590: invokeinterface 210 5 0
      //   1595: pop2
      //   1596: lload 21
      //   1598: lstore 23
      //   1600: iload_3
      //   1601: istore 10
      //   1603: iload 9
      //   1605: istore 15
      //   1607: iload 8
      //   1609: istore 16
      //   1611: iload 7
      //   1613: istore 11
      //   1615: iload_2
      //   1616: istore 12
      //   1618: iload 13
      //   1620: istore 4
      //   1622: iload 6
      //   1624: istore 17
      //   1626: iload_3
      //   1627: istore 5
      //   1629: aload 33
      //   1631: aload 35
      //   1633: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1636: invokeinterface 194 2 0
      //   1641: pop
      //   1642: lload 21
      //   1644: lstore 23
      //   1646: iload_3
      //   1647: istore 10
      //   1649: iload 9
      //   1651: istore 15
      //   1653: iload 8
      //   1655: istore 16
      //   1657: iload 7
      //   1659: istore 11
      //   1661: iload_2
      //   1662: istore 12
      //   1664: iload 13
      //   1666: istore 4
      //   1668: iload 6
      //   1670: istore 17
      //   1672: iload_3
      //   1673: istore 5
      //   1675: ldc 196
      //   1677: new 67	java/lang/StringBuilder
      //   1680: dup
      //   1681: ldc 212
      //   1683: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1686: aload 35
      //   1688: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1691: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1694: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1697: invokestatic 205	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1700: iload_3
      //   1701: iconst_1
      //   1702: iadd
      //   1703: istore_3
      //   1704: lload 21
      //   1706: lstore 23
      //   1708: iload_3
      //   1709: istore 10
      //   1711: iload 9
      //   1713: istore 15
      //   1715: iload 8
      //   1717: istore 16
      //   1719: iload 7
      //   1721: istore 11
      //   1723: iload_2
      //   1724: istore 12
      //   1726: iload 13
      //   1728: istore 4
      //   1730: iload 6
      //   1732: istore 17
      //   1734: iload_3
      //   1735: istore 5
      //   1737: aload 35
      //   1739: getfield 216	com/tencent/mm/vfs/f:YCh	J
      //   1742: lstore 25
      //   1744: lload 25
      //   1746: lload 21
      //   1748: ladd
      //   1749: lstore 21
      //   1751: iload 13
      //   1753: istore 5
      //   1755: goto -1371 -> 384
      //   1758: astore 36
      //   1760: iload 9
      //   1762: iconst_1
      //   1763: iadd
      //   1764: istore 4
      //   1766: ldc 218
      //   1768: new 67	java/lang/StringBuilder
      //   1771: dup
      //   1772: ldc 220
      //   1774: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1777: aload 35
      //   1779: getfield 141	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
      //   1782: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1785: ldc 222
      //   1787: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1790: aload_0
      //   1791: invokevirtual 223	com/tencent/mm/vfs/MigrationFileSystem$a:toString	()Ljava/lang/String;
      //   1794: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1797: ldc 225
      //   1799: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1802: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1805: invokestatic 228	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   1808: aload 28
      //   1810: ifnull +26 -> 1836
      //   1813: aload 29
      //   1815: ifnull +21 -> 1836
      //   1818: aload 28
      //   1820: aload 29
      //   1822: invokevirtual 231	java/util/TreeSet:remove	(Ljava/lang/Object;)Z
      //   1825: pop
      //   1826: aload 29
      //   1828: invokestatic 188	com/tencent/mm/vfs/ad:bCc	(Ljava/lang/String;)Ljava/lang/String;
      //   1831: astore 29
      //   1833: goto -20 -> 1813
      //   1836: iload 5
      //   1838: istore_3
      //   1839: iload 4
      //   1841: istore 9
      //   1843: iload 13
      //   1845: istore 5
      //   1847: goto -1463 -> 384
      //   1850: iload_2
      //   1851: istore 13
      //   1853: aload 28
      //   1855: ifnull +212 -> 2067
      //   1858: lload 21
      //   1860: lstore 23
      //   1862: iload_3
      //   1863: istore 10
      //   1865: iload 9
      //   1867: istore 15
      //   1869: iload 8
      //   1871: istore 16
      //   1873: iload 7
      //   1875: istore 11
      //   1877: iload_2
      //   1878: istore 12
      //   1880: iload 5
      //   1882: istore 4
      //   1884: iload 6
      //   1886: istore 17
      //   1888: aload 28
      //   1890: invokevirtual 235	java/util/TreeSet:descendingSet	()Ljava/util/NavigableSet;
      //   1893: invokeinterface 238 1 0
      //   1898: astore 28
      //   1900: lload 21
      //   1902: lstore 23
      //   1904: iload_3
      //   1905: istore 10
      //   1907: iload 9
      //   1909: istore 15
      //   1911: iload 8
      //   1913: istore 16
      //   1915: iload 7
      //   1917: istore 11
      //   1919: iload_2
      //   1920: istore 12
      //   1922: iload 5
      //   1924: istore 4
      //   1926: iload 6
      //   1928: istore 17
      //   1930: iload_2
      //   1931: istore 13
      //   1933: aload 28
      //   1935: invokeinterface 54 1 0
      //   1940: ifeq +127 -> 2067
      //   1943: lload 21
      //   1945: lstore 23
      //   1947: iload_3
      //   1948: istore 10
      //   1950: iload 9
      //   1952: istore 15
      //   1954: iload 8
      //   1956: istore 16
      //   1958: iload 7
      //   1960: istore 11
      //   1962: iload_2
      //   1963: istore 12
      //   1965: iload 5
      //   1967: istore 4
      //   1969: iload 6
      //   1971: istore 17
      //   1973: aload 28
      //   1975: invokeinterface 58 1 0
      //   1980: checkcast 240	java/lang/String
      //   1983: astore 29
      //   1985: lload 21
      //   1987: lstore 23
      //   1989: iload_3
      //   1990: istore 10
      //   1992: iload 9
      //   1994: istore 15
      //   1996: iload 8
      //   1998: istore 16
      //   2000: iload 7
      //   2002: istore 11
      //   2004: iload_2
      //   2005: istore 12
      //   2007: iload 5
      //   2009: istore 4
      //   2011: iload 6
      //   2013: istore 17
      //   2015: aload_1
      //   2016: invokevirtual 105	android/os/CancellationSignal:throwIfCanceled	()V
      //   2019: lload 21
      //   2021: lstore 23
      //   2023: iload_3
      //   2024: istore 10
      //   2026: iload 9
      //   2028: istore 15
      //   2030: iload 8
      //   2032: istore 16
      //   2034: iload 7
      //   2036: istore 11
      //   2038: iload_2
      //   2039: istore 12
      //   2041: iload 5
      //   2043: istore 4
      //   2045: iload 6
      //   2047: istore 17
      //   2049: aload 33
      //   2051: aload 29
      //   2053: iconst_0
      //   2054: invokeinterface 244 3 0
      //   2059: pop
      //   2060: iload_2
      //   2061: iconst_1
      //   2062: iadd
      //   2063: istore_2
      //   2064: goto -164 -> 1900
      //   2067: iload 13
      //   2069: istore_2
      //   2070: iload_3
      //   2071: istore 4
      //   2073: iload 8
      //   2075: istore_3
      //   2076: iload 18
      //   2078: iconst_1
      //   2079: iadd
      //   2080: istore 18
      //   2082: goto -1779 -> 303
      //   2085: aload_0
      //   2086: getfield 19	com/tencent/mm/vfs/MigrationFileSystem$a:YDc	Lcom/tencent/mm/vfs/MigrationFileSystem;
      //   2089: iconst_3
      //   2090: bipush 18
      //   2092: anewarray 107	java/lang/Object
      //   2095: dup
      //   2096: iconst_0
      //   2097: ldc 109
      //   2099: aastore
      //   2100: dup
      //   2101: iconst_1
      //   2102: aload 31
      //   2104: aastore
      //   2105: dup
      //   2106: iconst_2
      //   2107: ldc 157
      //   2109: aastore
      //   2110: dup
      //   2111: iconst_3
      //   2112: iload 6
      //   2114: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2117: aastore
      //   2118: dup
      //   2119: iconst_4
      //   2120: ldc 165
      //   2122: aastore
      //   2123: dup
      //   2124: iconst_5
      //   2125: iload 5
      //   2127: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2130: aastore
      //   2131: dup
      //   2132: bipush 6
      //   2134: ldc 167
      //   2136: aastore
      //   2137: dup
      //   2138: bipush 7
      //   2140: iload_2
      //   2141: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2144: aastore
      //   2145: dup
      //   2146: bipush 8
      //   2148: ldc 169
      //   2150: aastore
      //   2151: dup
      //   2152: bipush 9
      //   2154: iload 7
      //   2156: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2159: aastore
      //   2160: dup
      //   2161: bipush 10
      //   2163: ldc 171
      //   2165: aastore
      //   2166: dup
      //   2167: bipush 11
      //   2169: iload 4
      //   2171: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2174: aastore
      //   2175: dup
      //   2176: bipush 12
      //   2178: ldc 173
      //   2180: aastore
      //   2181: dup
      //   2182: bipush 13
      //   2184: iload_3
      //   2185: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2188: aastore
      //   2189: dup
      //   2190: bipush 14
      //   2192: ldc 175
      //   2194: aastore
      //   2195: dup
      //   2196: bipush 15
      //   2198: iload 9
      //   2200: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2203: aastore
      //   2204: dup
      //   2205: bipush 16
      //   2207: ldc 177
      //   2209: aastore
      //   2210: dup
      //   2211: bipush 17
      //   2213: lload 21
      //   2215: invokestatic 182	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2218: aastore
      //   2219: invokevirtual 113	com/tencent/mm/vfs/MigrationFileSystem:k	(I[Ljava/lang/Object;)V
      //   2222: aload_0
      //   2223: aload_1
      //   2224: invokespecial 246	com/tencent/mm/vfs/d:a	(Landroid/os/CancellationSignal;)V
      //   2227: ldc 87
      //   2229: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2232: return
      //   2233: iconst_5
      //   2234: istore_3
      //   2235: goto -1393 -> 842
      //   2238: astore_1
      //   2239: iload_3
      //   2240: istore 8
      //   2242: goto -1409 -> 833
      //   2245: astore_1
      //   2246: iload 4
      //   2248: istore 9
      //   2250: iload 5
      //   2252: istore 4
      //   2254: iload 13
      //   2256: istore 5
      //   2258: goto -1425 -> 833
      //   2261: goto -510 -> 1751
      //   2264: iload 9
      //   2266: istore 4
      //   2268: goto -429 -> 1839
      //   2271: goto -195 -> 2076
      //   2274: aconst_null
      //   2275: astore 28
      //   2277: goto -1908 -> 369
      //   2280: astore 29
      //   2282: iconst_0
      //   2283: istore 27
      //   2285: goto -1692 -> 593
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2288	0	this	a
      //   0	2288	1	paramCancellationSignal	android.os.CancellationSignal
      //   44	2097	2	i	int
      //   55	2185	3	j	int
      //   97	2170	4	k	int
      //   38	2219	5	m	int
      //   32	2081	6	n	int
      //   46	2109	7	i1	int
      //   49	2192	8	i2	int
      //   60	2205	9	i3	int
      //   77	1948	10	i4	int
      //   89	1948	11	i5	int
      //   93	1947	12	i6	int
      //   29	2226	13	i7	int
      //   35	1145	14	i8	int
      //   81	1948	15	i9	int
      //   85	1948	16	i10	int
      //   101	1947	17	i11	int
      //   41	2040	18	i12	int
      //   52	256	19	i13	int
      //   57	199	20	i14	int
      //   63	2151	21	l1	long
      //   73	1949	23	l2	long
      //   1742	3	25	l3	long
      //   535	1749	27	bool	boolean
      //   367	1909	28	localObject1	Object
      //   338	1714	29	localObject2	Object
      //   2280	1	29	localIOException1	java.io.IOException
      //   69	791	30	localList	List
      //   114	1989	31	localb1	FileSystem.b
      //   155	922	32	localHashSet	java.util.HashSet
      //   326	1724	33	localb2	FileSystem.b
      //   376	79	34	localIterator	Iterator
      //   464	1314	35	localf	f
      //   1758	1	36	localIOException2	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   103	116	801	java/lang/Exception
      //   148	157	801	java/lang/Exception
      //   189	193	801	java/lang/Exception
      //   225	247	801	java/lang/Exception
      //   279	288	801	java/lang/Exception
      //   414	424	801	java/lang/Exception
      //   454	466	801	java/lang/Exception
      //   496	500	801	java/lang/Exception
      //   530	537	801	java/lang/Exception
      //   572	593	801	java/lang/Exception
      //   628	639	801	java/lang/Exception
      //   682	695	801	java/lang/Exception
      //   725	738	801	java/lang/Exception
      //   783	794	801	java/lang/Exception
      //   1023	1033	801	java/lang/Exception
      //   1076	1086	801	java/lang/Exception
      //   1116	1126	801	java/lang/Exception
      //   1171	1179	801	java/lang/Exception
      //   1213	1228	801	java/lang/Exception
      //   1258	1265	801	java/lang/Exception
      //   1295	1308	801	java/lang/Exception
      //   1344	1369	801	java/lang/Exception
      //   1409	1431	801	java/lang/Exception
      //   1464	1489	801	java/lang/Exception
      //   1535	1542	801	java/lang/Exception
      //   1575	1596	801	java/lang/Exception
      //   1629	1642	801	java/lang/Exception
      //   1675	1700	801	java/lang/Exception
      //   1737	1744	801	java/lang/Exception
      //   1888	1900	801	java/lang/Exception
      //   1933	1943	801	java/lang/Exception
      //   1973	1985	801	java/lang/Exception
      //   2015	2019	801	java/lang/Exception
      //   2049	2060	801	java/lang/Exception
      //   1409	1431	1758	java/io/IOException
      //   1464	1489	1758	java/io/IOException
      //   1535	1542	1758	java/io/IOException
      //   1575	1596	1758	java/io/IOException
      //   1629	1642	1758	java/io/IOException
      //   1675	1700	1758	java/io/IOException
      //   1737	1744	1758	java/io/IOException
      //   310	340	2238	java/lang/Exception
      //   345	369	2238	java/lang/Exception
      //   369	378	2238	java/lang/Exception
      //   2085	2222	2238	java/lang/Exception
      //   1766	1808	2245	java/lang/Exception
      //   1818	1833	2245	java/lang/Exception
      //   572	593	2280	java/io/IOException
    }
    
    public final boolean bBB(String paramString)
    {
      AppMethodBeat.i(236292);
      Iterator localIterator = this.YCZ.iterator();
      while (localIterator.hasNext()) {
        if (((FileSystem.b)localIterator.next()).bBB(paramString))
        {
          AppMethodBeat.o(236292);
          return true;
        }
      }
      AppMethodBeat.o(236292);
      return false;
    }
    
    public final f bBC(String paramString)
    {
      AppMethodBeat.i(236294);
      Iterator localIterator = this.YCZ.iterator();
      while (localIterator.hasNext())
      {
        f localf = ((FileSystem.b)localIterator.next()).bBC(paramString);
        if (localf != null)
        {
          AppMethodBeat.o(236294);
          return localf;
        }
      }
      AppMethodBeat.o(236294);
      return null;
    }
    
    public final ReadableByteChannel bBy(String paramString)
    {
      AppMethodBeat.i(236291);
      Object localObject1 = null;
      Iterator localIterator = this.YCZ.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (FileSystem.b)localIterator.next();
        try
        {
          localObject2 = ((FileSystem.b)localObject2).bBy(paramString);
          AppMethodBeat.o(236291);
          return localObject2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (localObject1 != null) {
            break label105;
          }
        }
        localObject1 = localFileNotFoundException;
      }
      label105:
      for (;;)
      {
        break;
        if (localObject1 != null) {}
        for (;;)
        {
          AppMethodBeat.o(236291);
          throw ((Throwable)localObject1);
          localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
        }
      }
    }
    
    public final FileSystem.b hX(String paramString, int paramInt)
    {
      AppMethodBeat.i(236286);
      if ((paramInt == 1) || (paramInt == 3))
      {
        Iterator localIterator = this.YCZ.iterator();
        while (localIterator.hasNext())
        {
          FileSystem.b localb = (FileSystem.b)localIterator.next();
          if (localb.bBB(paramString))
          {
            AppMethodBeat.o(236286);
            return localb;
          }
        }
      }
      paramString = (FileSystem.b)this.YCZ.get(0);
      AppMethodBeat.o(236286);
      return paramString;
    }
    
    public final FileSystem ieX()
    {
      return MigrationFileSystem.this;
    }
    
    public final List<FileSystem.b> ifa()
    {
      return this.YCZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */