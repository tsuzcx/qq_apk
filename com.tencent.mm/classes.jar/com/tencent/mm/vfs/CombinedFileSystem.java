package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable.Creator;
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
  public static final Parcelable.Creator<CombinedFileSystem> CREATOR = new CombinedFileSystem.1();
  private final FileSystem[] wuj;
  private final CombinedFileSystem.a[] wuk;
  private final int wul;
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    j.a(paramParcel, getClass());
    int m = paramParcel.readInt();
    this.wuj = new FileSystem[m];
    int i = 0;
    int j = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localObject == null) {
        throw new ParcelFormatException();
      }
      this.wuj[i] = localObject;
      j |= ((FileSystem)localObject).Qd();
      i += 1;
    }
    this.wul = j;
    j = paramParcel.readInt();
    this.wuk = new CombinedFileSystem.a[j];
    i = k;
    if (i < j)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        k = paramParcel.readInt();
        this.wuk[i] = new CombinedFileSystem.a((Pattern)localObject, k, this.wuj[k]);
        i += 1;
        break;
      }
    }
  }
  
  private FileSystem aeM(String paramString)
  {
    CombinedFileSystem.a[] arrayOfa = this.wuk;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      CombinedFileSystem.a locala = arrayOfa[i];
      if ((locala.fsW == null) || (locala.fsW.matcher(paramString).matches())) {
        return locala.wun;
      }
      i += 1;
    }
    return null;
  }
  
  public final OutputStream I(String paramString, boolean paramBoolean)
  {
    FileSystem localFileSystem = aeM(paramString);
    if (localFileSystem == null) {
      throw new FileNotFoundException("No file system matches the path.");
    }
    return localFileSystem.I(paramString, paramBoolean);
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
    FileSystem localFileSystem = aeM(paramString);
    if (localFileSystem == null) {
      return null;
    }
    return localFileSystem.L(paramString, paramBoolean);
  }
  
  public final int Qd()
  {
    return this.wul;
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    FileSystem[] arrayOfFileSystem = this.wuj;
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
  }
  
  /* Error */
  public final boolean aC(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 108	com/tencent/mm/vfs/CombinedFileSystem:aeM	(Ljava/lang/String;)Lcom/tencent/mm/vfs/FileSystem;
    //   5: astore 5
    //   7: aload_0
    //   8: aload_2
    //   9: invokespecial 108	com/tencent/mm/vfs/CombinedFileSystem:aeM	(Ljava/lang/String;)Lcom/tencent/mm/vfs/FileSystem;
    //   12: astore 6
    //   14: aload 5
    //   16: ifnull +8 -> 24
    //   19: aload 6
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload 5
    //   28: aload 6
    //   30: if_acmpne +13 -> 43
    //   33: aload 5
    //   35: aload_1
    //   36: aload_2
    //   37: invokeinterface 157 3 0
    //   42: ireturn
    //   43: aload 5
    //   45: aload_1
    //   46: invokeinterface 161 2 0
    //   51: astore 4
    //   53: aload 6
    //   55: aload_2
    //   56: iconst_0
    //   57: invokeinterface 117 3 0
    //   62: astore_2
    //   63: sipush 2048
    //   66: newarray byte
    //   68: astore 6
    //   70: aload 4
    //   72: aload 6
    //   74: invokevirtual 167	java/io/InputStream:read	([B)I
    //   77: istore_3
    //   78: iload_3
    //   79: iflt +38 -> 117
    //   82: aload_2
    //   83: aload 6
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 173	java/io/OutputStream:write	([BII)V
    //   90: goto -20 -> 70
    //   93: astore_1
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 176	java/io/InputStream:close	()V
    //   104: aload_2
    //   105: ifnull -81 -> 24
    //   108: aload_2
    //   109: invokevirtual 177	java/io/OutputStream:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 4
    //   119: ifnull +8 -> 127
    //   122: aload 4
    //   124: invokevirtual 176	java/io/InputStream:close	()V
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 177	java/io/OutputStream:close	()V
    //   135: aload 5
    //   137: aload_1
    //   138: invokeinterface 181 2 0
    //   143: ireturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_2
    //   147: aconst_null
    //   148: astore 4
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 176	java/io/InputStream:close	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 177	java/io/OutputStream:close	()V
    //   168: aload_1
    //   169: athrow
    //   170: astore 4
    //   172: goto -45 -> 127
    //   175: astore_2
    //   176: goto -41 -> 135
    //   179: astore_1
    //   180: goto -76 -> 104
    //   183: astore 4
    //   185: goto -25 -> 160
    //   188: astore_2
    //   189: goto -21 -> 168
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_2
    //   195: goto -45 -> 150
    //   198: astore_1
    //   199: goto -49 -> 150
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_2
    //   205: aconst_null
    //   206: astore 4
    //   208: goto -114 -> 94
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -120 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	CombinedFileSystem
    //   0	217	1	paramString1	String
    //   0	217	2	paramString2	String
    //   77	10	3	i	int
    //   51	105	4	localInputStream	InputStream
    //   170	1	4	localIOException1	java.io.IOException
    //   183	1	4	localIOException2	java.io.IOException
    //   206	1	4	localObject1	Object
    //   5	131	5	localFileSystem	FileSystem
    //   12	72	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	70	93	java/io/IOException
    //   70	78	93	java/io/IOException
    //   82	90	93	java/io/IOException
    //   108	112	114	java/io/IOException
    //   43	53	144	finally
    //   122	127	170	java/io/IOException
    //   131	135	175	java/io/IOException
    //   99	104	179	java/io/IOException
    //   155	160	183	java/io/IOException
    //   164	168	188	java/io/IOException
    //   53	63	192	finally
    //   63	70	198	finally
    //   70	78	198	finally
    //   82	90	198	finally
    //   43	53	202	java/io/IOException
    //   53	63	211	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    FileSystem localFileSystem = aeM(paramString);
    return (localFileSystem != null) && (localFileSystem.exists(paramString));
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
    return this.wuj[(this.wuj.length - 1)].mZ(paramString);
  }
  
  public final FileSystem.a na(String paramString)
  {
    FileSystem localFileSystem = aeM(paramString);
    if (localFileSystem == null) {
      return null;
    }
    return localFileSystem.na(paramString);
  }
  
  public final boolean nb(String paramString)
  {
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].nb(paramString);
      i += 1;
    }
    return bool1;
  }
  
  public final InputStream openRead(String paramString)
  {
    FileSystem localFileSystem = aeM(paramString);
    if (localFileSystem == null) {
      throw new FileNotFoundException("No file system matches the path.");
    }
    return localFileSystem.openRead(paramString);
  }
  
  public final boolean r(String paramString, long paramLong)
  {
    FileSystem localFileSystem = aeM(paramString);
    return (localFileSystem != null) && (localFileSystem.r(paramString, paramLong));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.wuj;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfFileSystem[i].toString()).append(", ");
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    return ']';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(1);
    paramParcel.writeInt(this.wuj.length);
    Object localObject = this.wuj;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.wuk.length);
    CombinedFileSystem.a[] arrayOfa = this.wuk;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      CombinedFileSystem.a locala = arrayOfa[paramInt];
      if (locala.fsW == null) {}
      for (localObject = null;; localObject = locala.fsW.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.wum);
        paramInt += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */