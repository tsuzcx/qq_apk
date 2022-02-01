package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CombinedFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<CombinedFileSystem> CREATOR;
  protected final FileSystem[] Rbd;
  protected final a[] Rbe;
  
  static
  {
    AppMethodBeat.i(13047);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13047);
  }
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13040);
    aa.a(paramParcel, CombinedFileSystem.class, 1);
    int k = paramParcel.readInt();
    this.Rbd = new FileSystem[k];
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localObject == null)
      {
        paramParcel = new ParcelFormatException();
        AppMethodBeat.o(13040);
        throw paramParcel;
      }
      this.Rbd[i] = localObject;
      i += 1;
    }
    k = paramParcel.readInt();
    this.Rbe = new a[k];
    i = j;
    if (i < k)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        j = paramParcel.readInt();
        this.Rbe[i] = new a((Pattern)localObject, j);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(13040);
  }
  
  public final FileSystem.b cj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187631);
    FileSystem.b[] arrayOfb = new FileSystem.b[this.Rbd.length];
    int j = 0;
    int k;
    for (int i = 0; j < arrayOfb.length; i = k | i)
    {
      FileSystem.b localb = this.Rbd[j].cj(paramMap);
      k = localb.hdR();
      arrayOfb[j] = localb;
      j += 1;
    }
    paramMap = new b(arrayOfb, i);
    AppMethodBeat.o(187631);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13045);
    Object localObject = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.Rbd;
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
    aa.b(paramParcel, CombinedFileSystem.class, 1);
    paramParcel.writeInt(this.Rbd.length);
    Object localObject = this.Rbd;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.Rbe.length);
    a[] arrayOfa = this.Rbe;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if (locala.lnT == null) {}
      for (localObject = null;; localObject = locala.lnT.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.Rbf);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(13046);
  }
  
  static final class a
  {
    final int Rbf;
    final Pattern lnT;
    
    a(Pattern paramPattern, int paramInt)
    {
      this.lnT = paramPattern;
      this.Rbf = paramInt;
    }
  }
  
  protected final class b
    extends c
  {
    protected final FileSystem.b[] Rbg;
    private final int Rbh;
    
    b(FileSystem.b[] paramArrayOfb, int paramInt)
    {
      this.Rbg = paramArrayOfb;
      this.Rbh = paramInt;
    }
    
    public final FileSystem.a boK(String paramString)
    {
      AppMethodBeat.i(187629);
      paramString = this.Rbg[(this.Rbg.length - 1)].boK(paramString);
      AppMethodBeat.o(187629);
      return paramString;
    }
    
    public final boolean boN(String paramString)
    {
      AppMethodBeat.i(187630);
      FileSystem.b[] arrayOfb = this.Rbg;
      int j = arrayOfb.length;
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
      {
        bool2 = arrayOfb[i].boN(paramString);
        i += 1;
      }
      AppMethodBeat.o(187630);
      return bool1;
    }
    
    public final FileSystem hdQ()
    {
      return CombinedFileSystem.this;
    }
    
    public final int hdR()
    {
      return this.Rbh;
    }
    
    public final List<FileSystem.b> hdS()
    {
      AppMethodBeat.i(187628);
      List localList = Arrays.asList(this.Rbg);
      AppMethodBeat.o(187628);
      return localList;
    }
    
    public final FileSystem.b ho(String paramString, int paramInt)
    {
      AppMethodBeat.i(187627);
      CombinedFileSystem.a[] arrayOfa = CombinedFileSystem.this.Rbe;
      int i = arrayOfa.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CombinedFileSystem.a locala = arrayOfa[paramInt];
        if ((locala.lnT == null) || (locala.lnT.matcher(paramString).matches()))
        {
          paramString = this.Rbg[locala.Rbf];
          AppMethodBeat.o(187627);
          return paramString;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(187627);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */