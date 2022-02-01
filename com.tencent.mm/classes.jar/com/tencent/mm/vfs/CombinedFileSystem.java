package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CombinedFileSystem
  extends DelegateFileSystem
{
  public static final Parcelable.Creator<CombinedFileSystem> CREATOR;
  private final FileSystem[] Ljr;
  private final a[] Ljs;
  private final int Ljt;
  
  static
  {
    AppMethodBeat.i(13047);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13047);
  }
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13040);
    q.a(paramParcel, CombinedFileSystem.class, 1);
    int m = paramParcel.readInt();
    this.Ljr = new FileSystem[m];
    int i = 0;
    int j = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localObject == null)
      {
        paramParcel = new ParcelFormatException();
        AppMethodBeat.o(13040);
        throw paramParcel;
      }
      this.Ljr[i] = localObject;
      j |= ((FileSystem)localObject).fOp();
      i += 1;
    }
    this.Ljt = j;
    j = paramParcel.readInt();
    this.Ljs = new a[j];
    i = k;
    if (i < j)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        k = paramParcel.readInt();
        this.Ljs[i] = new a((Pattern)localObject, k, this.Ljr[k]);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(13040);
  }
  
  public final FileSystem.b aYd(String paramString)
  {
    AppMethodBeat.i(13043);
    paramString = this.Ljr[(this.Ljr.length - 1)].aYd(paramString);
    AppMethodBeat.o(13043);
    return paramString;
  }
  
  public final boolean aYg(String paramString)
  {
    AppMethodBeat.i(13044);
    FileSystem[] arrayOfFileSystem = this.Ljr;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].aYg(paramString);
      i += 1;
    }
    AppMethodBeat.o(13044);
    return bool1;
  }
  
  public final int fOp()
  {
    return this.Ljt;
  }
  
  protected final Iterable<FileSystem> fOq()
  {
    AppMethodBeat.i(13042);
    List localList = Arrays.asList(this.Ljr);
    AppMethodBeat.o(13042);
    return localList;
  }
  
  protected final FileSystem gK(String paramString, int paramInt)
  {
    AppMethodBeat.i(13041);
    a[] arrayOfa = this.Ljs;
    int i = arrayOfa.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if ((locala.kgU == null) || (locala.kgU.matcher(paramString).matches()))
      {
        paramString = locala.Ljv;
        AppMethodBeat.o(13041);
        return paramString;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(13041);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13045);
    Object localObject = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.Ljr;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfFileSystem[i].toString()).append(", ");
      i += 1;
    }
    ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
    localObject = ']';
    AppMethodBeat.o(13045);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13046);
    q.b(paramParcel, CombinedFileSystem.class, 1);
    paramParcel.writeInt(this.Ljr.length);
    Object localObject = this.Ljr;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.Ljs.length);
    a[] arrayOfa = this.Ljs;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if (locala.kgU == null) {}
      for (localObject = null;; localObject = locala.kgU.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.Lju);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(13046);
  }
  
  static final class a
  {
    final int Lju;
    final FileSystem Ljv;
    final Pattern kgU;
    
    a(Pattern paramPattern, int paramInt, FileSystem paramFileSystem)
    {
      this.kgU = paramPattern;
      this.Lju = paramInt;
      this.Ljv = paramFileSystem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */