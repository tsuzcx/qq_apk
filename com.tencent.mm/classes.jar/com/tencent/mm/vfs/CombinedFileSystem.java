package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CombinedFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<CombinedFileSystem> CREATOR;
  private final FileSystem[] APi;
  private final CombinedFileSystem.a[] APj;
  private final int APk;
  
  static
  {
    AppMethodBeat.i(54502);
    CREATOR = new CombinedFileSystem.1();
    AppMethodBeat.o(54502);
  }
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(54484);
    j.a(paramParcel, getClass());
    int m = paramParcel.readInt();
    this.APi = new FileSystem[m];
    int i = 0;
    int j = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localObject == null)
      {
        paramParcel = new ParcelFormatException();
        AppMethodBeat.o(54484);
        throw paramParcel;
      }
      this.APi[i] = localObject;
      j |= ((FileSystem)localObject).ajj();
      i += 1;
    }
    this.APk = j;
    j = paramParcel.readInt();
    this.APj = new CombinedFileSystem.a[j];
    i = k;
    if (i < j)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        k = paramParcel.readInt();
        this.APj[i] = new CombinedFileSystem.a((Pattern)localObject, k, this.APi[k]);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(54484);
  }
  
  private FileSystem avE(String paramString)
  {
    AppMethodBeat.i(54486);
    CombinedFileSystem.a[] arrayOfa = this.APj;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      CombinedFileSystem.a locala = arrayOfa[i];
      if ((locala.hpo == null) || (locala.hpo.matcher(paramString).matches()))
      {
        paramString = locala.APm;
        AppMethodBeat.o(54486);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(54486);
    return null;
  }
  
  public final boolean A(String paramString, long paramLong)
  {
    AppMethodBeat.i(54491);
    FileSystem localFileSystem = avE(paramString);
    if ((localFileSystem != null) && (localFileSystem.A(paramString, paramLong)))
    {
      AppMethodBeat.o(54491);
      return true;
    }
    AppMethodBeat.o(54491);
    return false;
  }
  
  public final OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54488);
    FileSystem localFileSystem = avE(paramString);
    if (localFileSystem == null)
    {
      paramString = new FileNotFoundException("No file system matches the path.");
      AppMethodBeat.o(54488);
      throw paramString;
    }
    paramString = localFileSystem.M(paramString, paramBoolean);
    AppMethodBeat.o(54488);
    return paramString;
  }
  
  public final List<FileSystem.a> N(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54493);
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
    AppMethodBeat.o(54493);
    return localArrayList;
  }
  
  public final boolean O(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54495);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].O(paramString, paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(54495);
    return bool1;
  }
  
  public final String P(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54497);
    FileSystem localFileSystem = avE(paramString);
    if (localFileSystem == null)
    {
      AppMethodBeat.o(54497);
      return null;
    }
    paramString = localFileSystem.P(paramString, paramBoolean);
    AppMethodBeat.o(54497);
    return paramString;
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(54499);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      FileSystem localFileSystem = arrayOfFileSystem[i];
      if (paramCancellationSignal.isCanceled()) {
        break;
      }
      localFileSystem.a(paramCancellationSignal);
      i += 1;
    }
    AppMethodBeat.o(54499);
  }
  
  /* Error */
  public final boolean aV(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 179
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 122	com/tencent/mm/vfs/CombinedFileSystem:avE	(Ljava/lang/String;)Lcom/tencent/mm/vfs/FileSystem;
    //   10: astore 6
    //   12: aload_0
    //   13: aload_2
    //   14: invokespecial 122	com/tencent/mm/vfs/CombinedFileSystem:avE	(Ljava/lang/String;)Lcom/tencent/mm/vfs/FileSystem;
    //   17: astore 7
    //   19: aload 6
    //   21: ifnull +8 -> 29
    //   24: aload 7
    //   26: ifnonnull +10 -> 36
    //   29: ldc 179
    //   31: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aload 6
    //   38: aload 7
    //   40: if_acmpne +22 -> 62
    //   43: aload 6
    //   45: aload_1
    //   46: aload_2
    //   47: invokeinterface 181 3 0
    //   52: istore 4
    //   54: ldc 179
    //   56: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iload 4
    //   61: ireturn
    //   62: aload 6
    //   64: aload_1
    //   65: invokeinterface 185 2 0
    //   70: astore 5
    //   72: aload 7
    //   74: aload_2
    //   75: iconst_0
    //   76: invokeinterface 136 3 0
    //   81: astore_2
    //   82: sipush 2048
    //   85: newarray byte
    //   87: astore 7
    //   89: aload 5
    //   91: aload 7
    //   93: invokevirtual 191	java/io/InputStream:read	([B)I
    //   96: istore_3
    //   97: iload_3
    //   98: iflt +40 -> 138
    //   101: aload_2
    //   102: aload 7
    //   104: iconst_0
    //   105: iload_3
    //   106: invokevirtual 197	java/io/OutputStream:write	([BII)V
    //   109: goto -20 -> 89
    //   112: astore_1
    //   113: aload 5
    //   115: ifnull +8 -> 123
    //   118: aload 5
    //   120: invokevirtual 200	java/io/InputStream:close	()V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 201	java/io/OutputStream:close	()V
    //   131: ldc 179
    //   133: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: iconst_0
    //   137: ireturn
    //   138: aload 5
    //   140: ifnull +8 -> 148
    //   143: aload 5
    //   145: invokevirtual 200	java/io/InputStream:close	()V
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 201	java/io/OutputStream:close	()V
    //   156: aload 6
    //   158: aload_1
    //   159: invokeinterface 205 2 0
    //   164: istore 4
    //   166: ldc 179
    //   168: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iload 4
    //   173: ireturn
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_2
    //   177: aconst_null
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 200	java/io/InputStream:close	()V
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 201	java/io/OutputStream:close	()V
    //   198: ldc 179
    //   200: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    //   205: astore 5
    //   207: goto -59 -> 148
    //   210: astore_2
    //   211: goto -55 -> 156
    //   214: astore_1
    //   215: goto -92 -> 123
    //   218: astore_1
    //   219: goto -88 -> 131
    //   222: astore 5
    //   224: goto -34 -> 190
    //   227: astore_2
    //   228: goto -30 -> 198
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_2
    //   234: goto -54 -> 180
    //   237: astore_1
    //   238: goto -58 -> 180
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_2
    //   244: aconst_null
    //   245: astore 5
    //   247: goto -134 -> 113
    //   250: astore_1
    //   251: aconst_null
    //   252: astore_2
    //   253: goto -140 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	CombinedFileSystem
    //   0	256	1	paramString1	String
    //   0	256	2	paramString2	String
    //   96	10	3	i	int
    //   52	120	4	bool	boolean
    //   70	116	5	localInputStream	InputStream
    //   205	1	5	localIOException1	java.io.IOException
    //   222	1	5	localIOException2	java.io.IOException
    //   245	1	5	localObject1	Object
    //   10	147	6	localFileSystem	FileSystem
    //   17	86	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   82	89	112	java/io/IOException
    //   89	97	112	java/io/IOException
    //   101	109	112	java/io/IOException
    //   62	72	174	finally
    //   143	148	205	java/io/IOException
    //   152	156	210	java/io/IOException
    //   118	123	214	java/io/IOException
    //   127	131	218	java/io/IOException
    //   185	190	222	java/io/IOException
    //   194	198	227	java/io/IOException
    //   72	82	231	finally
    //   82	89	237	finally
    //   89	97	237	finally
    //   101	109	237	finally
    //   62	72	241	java/io/IOException
    //   72	82	250	java/io/IOException
  }
  
  public final int ajj()
  {
    return this.APk;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    AppMethodBeat.i(54489);
    FileSystem localFileSystem = avE(paramString);
    if ((localFileSystem != null) && (localFileSystem.exists(paramString)))
    {
      AppMethodBeat.o(54489);
      return true;
    }
    AppMethodBeat.o(54489);
    return false;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(54487);
    FileSystem localFileSystem = avE(paramString);
    if (localFileSystem == null)
    {
      paramString = new FileNotFoundException("No file system matches the path.");
      AppMethodBeat.o(54487);
      throw paramString;
    }
    paramString = localFileSystem.openRead(paramString);
    AppMethodBeat.o(54487);
    return paramString;
  }
  
  public final void q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(54498);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFileSystem[i].q(paramMap);
      i += 1;
    }
    AppMethodBeat.o(54498);
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(54492);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].qD(paramString);
      i += 1;
    }
    AppMethodBeat.o(54492);
    return bool1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(54500);
    Object localObject = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfFileSystem[i].toString()).append(", ");
      i += 1;
    }
    ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
    localObject = ']';
    AppMethodBeat.o(54500);
    return localObject;
  }
  
  public final FileSystem.b uk(String paramString)
  {
    AppMethodBeat.i(54485);
    paramString = this.APi[(this.APi.length - 1)].uk(paramString);
    AppMethodBeat.o(54485);
    return paramString;
  }
  
  public final FileSystem.a ul(String paramString)
  {
    AppMethodBeat.i(54490);
    FileSystem localFileSystem = avE(paramString);
    if (localFileSystem == null)
    {
      AppMethodBeat.o(54490);
      return null;
    }
    paramString = localFileSystem.ul(paramString);
    AppMethodBeat.o(54490);
    return paramString;
  }
  
  public final boolean um(String paramString)
  {
    AppMethodBeat.i(54494);
    FileSystem[] arrayOfFileSystem = this.APi;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].um(paramString);
      i += 1;
    }
    AppMethodBeat.o(54494);
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(54501);
    paramParcel.writeInt(1);
    paramParcel.writeInt(this.APi.length);
    Object localObject = this.APi;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.APj.length);
    CombinedFileSystem.a[] arrayOfa = this.APj;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      CombinedFileSystem.a locala = arrayOfa[paramInt];
      if (locala.hpo == null) {}
      for (localObject = null;; localObject = locala.hpo.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.APl);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(54501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */