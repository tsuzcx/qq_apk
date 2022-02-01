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
  private final FileSystem[] JrM;
  private final a[] JrN;
  private final int JrO;
  
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
    this.JrM = new FileSystem[m];
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
      this.JrM[i] = localObject;
      j |= ((FileSystem)localObject).fxC();
      i += 1;
    }
    this.JrO = j;
    j = paramParcel.readInt();
    this.JrN = new a[j];
    i = k;
    if (i < j)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        k = paramParcel.readInt();
        this.JrN[i] = new a((Pattern)localObject, k, this.JrM[k]);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(13040);
  }
  
  public final FileSystem.b aSe(String paramString)
  {
    AppMethodBeat.i(13043);
    paramString = this.JrM[(this.JrM.length - 1)].aSe(paramString);
    AppMethodBeat.o(13043);
    return paramString;
  }
  
  public final boolean aSh(String paramString)
  {
    AppMethodBeat.i(13044);
    FileSystem[] arrayOfFileSystem = this.JrM;
    int j = arrayOfFileSystem.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
    {
      bool2 = arrayOfFileSystem[i].aSh(paramString);
      i += 1;
    }
    AppMethodBeat.o(13044);
    return bool1;
  }
  
  public final int fxC()
  {
    return this.JrO;
  }
  
  protected final Iterable<FileSystem> fxD()
  {
    AppMethodBeat.i(13042);
    List localList = Arrays.asList(this.JrM);
    AppMethodBeat.o(13042);
    return localList;
  }
  
  protected final FileSystem gn(String paramString, int paramInt)
  {
    AppMethodBeat.i(13041);
    a[] arrayOfa = this.JrN;
    int i = arrayOfa.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if ((locala.jMJ == null) || (locala.jMJ.matcher(paramString).matches()))
      {
        paramString = locala.JrQ;
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
    FileSystem[] arrayOfFileSystem = this.JrM;
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
    paramParcel.writeInt(this.JrM.length);
    Object localObject = this.JrM;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.JrN.length);
    a[] arrayOfa = this.JrN;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if (locala.jMJ == null) {}
      for (localObject = null;; localObject = locala.jMJ.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.JrP);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(13046);
  }
  
  static final class a
  {
    final int JrP;
    final FileSystem JrQ;
    final Pattern jMJ;
    
    a(Pattern paramPattern, int paramInt, FileSystem paramFileSystem)
    {
      this.jMJ = paramPattern;
      this.JrP = paramInt;
      this.JrQ = paramFileSystem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */