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
  private final FileSystem[] HRf;
  private final a[] HRg;
  private final int HRh;
  
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
    this.HRf = new FileSystem[m];
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
      this.HRf[i] = localObject;
      j |= ((FileSystem)localObject).fhA();
      i += 1;
    }
    this.HRh = j;
    j = paramParcel.readInt();
    this.HRg = new a[j];
    i = k;
    if (i < j)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        k = paramParcel.readInt();
        this.HRg[i] = new a((Pattern)localObject, k, this.HRf[k]);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(13040);
  }
  
  public final FileSystem.b aMC(String paramString)
  {
    AppMethodBeat.i(13043);
    paramString = this.HRf[(this.HRf.length - 1)].aMC(paramString);
    AppMethodBeat.o(13043);
    return paramString;
  }
  
  public final boolean aMF(String paramString)
  {
    AppMethodBeat.i(13044);
    FileSystem[] arrayOfFileSystem = this.HRf;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].aMF(paramString);
      i += 1;
    }
    AppMethodBeat.o(13044);
    return bool1;
  }
  
  public final int fhA()
  {
    return this.HRh;
  }
  
  protected final Iterable<FileSystem> fhB()
  {
    AppMethodBeat.i(13042);
    List localList = Arrays.asList(this.HRf);
    AppMethodBeat.o(13042);
    return localList;
  }
  
  protected final FileSystem gj(String paramString, int paramInt)
  {
    AppMethodBeat.i(13041);
    a[] arrayOfa = this.HRg;
    int i = arrayOfa.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if ((locala.jmw == null) || (locala.jmw.matcher(paramString).matches()))
      {
        paramString = locala.HRj;
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
    FileSystem[] arrayOfFileSystem = this.HRf;
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
    paramParcel.writeInt(this.HRf.length);
    Object localObject = this.HRf;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.HRg.length);
    a[] arrayOfa = this.HRg;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if (locala.jmw == null) {}
      for (localObject = null;; localObject = locala.jmw.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.HRi);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(13046);
  }
  
  static final class a
  {
    final int HRi;
    final FileSystem HRj;
    final Pattern jmw;
    
    a(Pattern paramPattern, int paramInt, FileSystem paramFileSystem)
    {
      this.jmw = paramPattern;
      this.HRi = paramInt;
      this.HRj = paramFileSystem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */