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
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<CombinedFileSystem> CREATOR;
  protected final FileSystem[] agwk;
  protected final a[] agwl;
  
  static
  {
    AppMethodBeat.i(13047);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13047);
  }
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13040);
    ah.a(paramParcel, CombinedFileSystem.class, 1);
    int k = paramParcel.readInt();
    this.agwk = new FileSystem[k];
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
      this.agwk[i] = localObject;
      i += 1;
    }
    k = paramParcel.readInt();
    this.agwl = new a[k];
    i = j;
    if (i < k)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        j = paramParcel.readInt();
        this.agwl[i] = new a((Pattern)localObject, j);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(13040);
  }
  
  public String toString()
  {
    AppMethodBeat.i(13045);
    Object localObject = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.agwk;
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
    ah.b(paramParcel, CombinedFileSystem.class, 1);
    paramParcel.writeInt(this.agwk.length);
    Object localObject = this.agwk;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.agwl.length);
    a[] arrayOfa = this.agwl;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if (locala.rmg == null) {}
      for (localObject = null;; localObject = locala.rmg.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.agwm);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(13046);
  }
  
  static final class a
  {
    final int agwm;
    final Pattern rmg;
    
    a(Pattern paramPattern, int paramInt)
    {
      this.rmg = paramPattern;
      this.agwm = paramInt;
    }
  }
  
  protected final class b
    extends f
  {
    protected final FileSystem.b[] agwn;
    private final int agwo;
    
    b(FileSystem.b[] paramArrayOfb, int paramInt)
    {
      this.agwn = paramArrayOfb;
      this.agwo = paramInt;
    }
    
    public final boolean bDX(String paramString)
    {
      AppMethodBeat.i(238198);
      FileSystem.b[] arrayOfb = this.agwn;
      int j = arrayOfb.length;
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
      {
        bool2 = arrayOfb[i].bDX(paramString);
        i += 1;
      }
      AppMethodBeat.o(238198);
      return bool1;
    }
    
    public final FileSystem.a bDY(String paramString)
    {
      AppMethodBeat.i(238194);
      paramString = this.agwn[(this.agwn.length - 1)].bDY(paramString);
      AppMethodBeat.o(238194);
      return paramString;
    }
    
    public final FileSystem jKa()
    {
      return CombinedFileSystem.this;
    }
    
    public final int jKc()
    {
      return this.agwo;
    }
    
    public final List<FileSystem.b> jKf()
    {
      AppMethodBeat.i(238185);
      List localList = Arrays.asList(this.agwn);
      AppMethodBeat.o(238185);
      return localList;
    }
    
    public final FileSystem.b jk(String paramString, int paramInt)
    {
      AppMethodBeat.i(238177);
      CombinedFileSystem.a[] arrayOfa = CombinedFileSystem.this.agwl;
      int i = arrayOfa.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CombinedFileSystem.a locala = arrayOfa[paramInt];
        if ((locala.rmg == null) || (locala.rmg.matcher(paramString).matches()))
        {
          paramString = this.agwn[locala.agwm];
          AppMethodBeat.o(238177);
          return paramString;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(238177);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */