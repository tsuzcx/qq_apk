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
  protected final FileSystem[] YBx;
  protected final a[] YBy;
  
  static
  {
    AppMethodBeat.i(13047);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13047);
  }
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13040);
    ad.a(paramParcel, CombinedFileSystem.class, 1);
    int k = paramParcel.readInt();
    this.YBx = new FileSystem[k];
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
      this.YBx[i] = localObject;
      i += 1;
    }
    k = paramParcel.readInt();
    this.YBy = new a[k];
    i = j;
    if (i < k)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        j = paramParcel.readInt();
        this.YBy[i] = new a((Pattern)localObject, j);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(13040);
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(235948);
    FileSystem.b[] arrayOfb = new FileSystem.b[this.YBx.length];
    int j = 0;
    int k;
    for (int i = 0; j < arrayOfb.length; i = k | i)
    {
      FileSystem.b localb = this.YBx[j].cp(paramMap);
      k = localb.ieY();
      arrayOfb[j] = localb;
      j += 1;
    }
    paramMap = new b(arrayOfb, i);
    AppMethodBeat.o(235948);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13045);
    Object localObject = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.YBx;
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
    ad.b(paramParcel, CombinedFileSystem.class, 1);
    paramParcel.writeInt(this.YBx.length);
    Object localObject = this.YBx;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.YBy.length);
    a[] arrayOfa = this.YBy;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if (locala.oiE == null) {}
      for (localObject = null;; localObject = locala.oiE.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.YBz);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(13046);
  }
  
  static final class a
  {
    final int YBz;
    final Pattern oiE;
    
    a(Pattern paramPattern, int paramInt)
    {
      this.oiE = paramPattern;
      this.YBz = paramInt;
    }
  }
  
  protected final class b
    extends d
  {
    protected final FileSystem.b[] YBA;
    private final int YBB;
    
    b(FileSystem.b[] paramArrayOfb, int paramInt)
    {
      this.YBA = paramArrayOfb;
      this.YBB = paramInt;
    }
    
    public final FileSystem.a bBA(String paramString)
    {
      AppMethodBeat.i(235931);
      paramString = this.YBA[(this.YBA.length - 1)].bBA(paramString);
      AppMethodBeat.o(235931);
      return paramString;
    }
    
    public final boolean bBD(String paramString)
    {
      AppMethodBeat.i(235933);
      FileSystem.b[] arrayOfb = this.YBA;
      int j = arrayOfb.length;
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
      {
        bool2 = arrayOfb[i].bBD(paramString);
        i += 1;
      }
      AppMethodBeat.o(235933);
      return bool1;
    }
    
    public final FileSystem.b hX(String paramString, int paramInt)
    {
      AppMethodBeat.i(235928);
      CombinedFileSystem.a[] arrayOfa = CombinedFileSystem.this.YBy;
      int i = arrayOfa.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CombinedFileSystem.a locala = arrayOfa[paramInt];
        if ((locala.oiE == null) || (locala.oiE.matcher(paramString).matches()))
        {
          paramString = this.YBA[locala.YBz];
          AppMethodBeat.o(235928);
          return paramString;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(235928);
      return null;
    }
    
    public final FileSystem ieX()
    {
      return CombinedFileSystem.this;
    }
    
    public final int ieY()
    {
      return this.YBB;
    }
    
    public final List<FileSystem.b> ifa()
    {
      AppMethodBeat.i(235930);
      List localList = Arrays.asList(this.YBA);
      AppMethodBeat.o(235930);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */