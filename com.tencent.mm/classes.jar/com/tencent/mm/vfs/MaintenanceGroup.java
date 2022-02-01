package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;

public class MaintenanceGroup
  implements FileSystem
{
  public static final Parcelable.Creator<MaintenanceGroup> CREATOR;
  protected final FileSystem[] YBx;
  
  static
  {
    AppMethodBeat.i(236268);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(236268);
  }
  
  protected MaintenanceGroup(Parcel paramParcel)
  {
    AppMethodBeat.i(236257);
    ad.a(paramParcel, MaintenanceGroup.class, 2);
    int j = paramParcel.readInt();
    this.YBx = new FileSystem[j];
    int i = 0;
    while (i < j)
    {
      this.YBx[i] = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(236257);
  }
  
  public MaintenanceGroup(Collection<FileSystem> paramCollection)
  {
    AppMethodBeat.i(236255);
    this.YBx = ((FileSystem[])paramCollection.toArray(new FileSystem[0]));
    AppMethodBeat.o(236255);
  }
  
  public MaintenanceGroup(FileSystem... paramVarArgs)
  {
    this.YBx = paramVarArgs;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236264);
    if (((paramObject instanceof MaintenanceGroup)) && (Arrays.equals(this.YBx, ((MaintenanceGroup)paramObject).YBx)))
    {
      AppMethodBeat.o(236264);
      return true;
    }
    AppMethodBeat.o(236264);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(236262);
    int i = MaintenanceGroup.class.hashCode();
    int j = Arrays.hashCode(this.YBx);
    AppMethodBeat.o(236262);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(236261);
    if (this.YBx.length == 0)
    {
      AppMethodBeat.o(236261);
      return "[]";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
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
    AppMethodBeat.o(236261);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(236259);
    ad.b(paramParcel, MaintenanceGroup.class, 2);
    paramParcel.writeInt(this.YBx.length);
    FileSystem[] arrayOfFileSystem = this.YBx;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    AppMethodBeat.o(236259);
  }
  
  protected class a
    extends j
  {
    protected final FileSystem.b[] YCT;
    
    protected a(FileSystem.b[] paramArrayOfb)
    {
      this.YCT = paramArrayOfb;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(236250);
      FileSystem.b[] arrayOfb = this.YCT;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        FileSystem.b localb = arrayOfb[i];
        paramCancellationSignal.throwIfCanceled();
        localb.a(paramCancellationSignal);
        i += 1;
      }
      AppMethodBeat.o(236250);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236253);
      if (((paramObject instanceof a)) && (Arrays.equals(this.YCT, ((a)paramObject).YCT)))
      {
        AppMethodBeat.o(236253);
        return true;
      }
      AppMethodBeat.o(236253);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(236252);
      int i = a.class.hashCode();
      int j = Arrays.hashCode(this.YCT);
      AppMethodBeat.o(236252);
      return i ^ j;
    }
    
    public final FileSystem ieX()
    {
      return MaintenanceGroup.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.MaintenanceGroup
 * JD-Core Version:    0.7.0.1
 */