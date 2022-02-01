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
  protected final FileSystem[] LFM;
  protected final a[] LFN;
  
  static
  {
    AppMethodBeat.i(13047);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13047);
  }
  
  private CombinedFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13040);
    w.a(paramParcel, CombinedFileSystem.class, 1);
    int k = paramParcel.readInt();
    this.LFM = new FileSystem[k];
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
      this.LFM[i] = localObject;
      i += 1;
    }
    k = paramParcel.readInt();
    this.LFN = new a[k];
    i = j;
    if (i < k)
    {
      localObject = paramParcel.readString();
      if (localObject == null) {}
      for (localObject = null;; localObject = Pattern.compile((String)localObject))
      {
        j = paramParcel.readInt();
        this.LFN[i] = new a((Pattern)localObject, j);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(13040);
  }
  
  public final FileSystem.b cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193358);
    FileSystem.b[] arrayOfb = new FileSystem.b[this.LFM.length];
    int j = 0;
    int k;
    for (int i = 0; j < arrayOfb.length; i = k | i)
    {
      FileSystem.b localb = this.LFM[j].cd(paramMap);
      k = localb.fSL();
      arrayOfb[j] = localb;
      j += 1;
    }
    paramMap = new b(arrayOfb, i);
    AppMethodBeat.o(193358);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13045);
    Object localObject = new StringBuilder("CombinedFS [");
    FileSystem[] arrayOfFileSystem = this.LFM;
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
    w.b(paramParcel, CombinedFileSystem.class, 1);
    paramParcel.writeInt(this.LFM.length);
    Object localObject = this.LFM;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(localObject[i], paramInt);
      i += 1;
    }
    paramParcel.writeInt(this.LFN.length);
    a[] arrayOfa = this.LFN;
    i = arrayOfa.length;
    paramInt = 0;
    if (paramInt < i)
    {
      a locala = arrayOfa[paramInt];
      if (locala.kkk == null) {}
      for (localObject = null;; localObject = locala.kkk.pattern())
      {
        paramParcel.writeString((String)localObject);
        paramParcel.writeInt(locala.LFO);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(13046);
  }
  
  static final class a
  {
    final int LFO;
    final Pattern kkk;
    
    a(Pattern paramPattern, int paramInt)
    {
      this.kkk = paramPattern;
      this.LFO = paramInt;
    }
  }
  
  protected final class b
    extends b
  {
    protected final FileSystem.b[] LFP;
    private final int LFQ;
    
    b(FileSystem.b[] paramArrayOfb, int paramInt)
    {
      this.LFP = paramArrayOfb;
      this.LFQ = paramInt;
    }
    
    public final FileSystem.a aZF(String paramString)
    {
      AppMethodBeat.i(193356);
      paramString = this.LFP[(this.LFP.length - 1)].aZF(paramString);
      AppMethodBeat.o(193356);
      return paramString;
    }
    
    public final boolean aZI(String paramString)
    {
      AppMethodBeat.i(193357);
      FileSystem.b[] arrayOfb = this.LFP;
      int j = arrayOfb.length;
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < j; bool1 = bool2 | bool1)
      {
        bool2 = arrayOfb[i].aZI(paramString);
        i += 1;
      }
      AppMethodBeat.o(193357);
      return bool1;
    }
    
    public final FileSystem fSK()
    {
      return CombinedFileSystem.this;
    }
    
    public final int fSL()
    {
      return this.LFQ;
    }
    
    public final List<FileSystem.b> fSM()
    {
      AppMethodBeat.i(193355);
      List localList = Arrays.asList(this.LFP);
      AppMethodBeat.o(193355);
      return localList;
    }
    
    public final FileSystem.b gU(String paramString, int paramInt)
    {
      AppMethodBeat.i(193354);
      CombinedFileSystem.a[] arrayOfa = CombinedFileSystem.this.LFN;
      int i = arrayOfa.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CombinedFileSystem.a locala = arrayOfa[paramInt];
        if ((locala.kkk == null) || (locala.kkk.matcher(paramString).matches()))
        {
          paramString = this.LFP[locala.LFO];
          AppMethodBeat.o(193354);
          return paramString;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(193354);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem
 * JD-Core Version:    0.7.0.1
 */