package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaintenanceGroup
  implements FileSystem
{
  public static final Parcelable.Creator<MaintenanceGroup> CREATOR;
  protected final FileSystem[] Rbd;
  
  static
  {
    AppMethodBeat.i(187665);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(187665);
  }
  
  protected MaintenanceGroup(Parcel paramParcel)
  {
    AppMethodBeat.i(187661);
    aa.a(paramParcel, MaintenanceGroup.class, 2);
    int j = paramParcel.readInt();
    this.Rbd = new FileSystem[j];
    int i = 0;
    while (i < j)
    {
      this.Rbd[i] = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
      i += 1;
    }
    AppMethodBeat.o(187661);
  }
  
  public MaintenanceGroup(FileSystem... paramVarArgs)
  {
    this.Rbd = paramVarArgs;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(187663);
    if (this.Rbd.length == 0)
    {
      AppMethodBeat.o(187663);
      return "[]";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
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
    AppMethodBeat.o(187663);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(187662);
    aa.b(paramParcel, MaintenanceGroup.class, 2);
    paramParcel.writeInt(this.Rbd.length);
    FileSystem[] arrayOfFileSystem = this.Rbd;
    int j = arrayOfFileSystem.length;
    int i = 0;
    while (i < j)
    {
      paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
      i += 1;
    }
    AppMethodBeat.o(187662);
  }
  
  protected final class a
    extends i
  {
    protected final FileSystem.b[] Rcq;
    
    protected a(FileSystem.b[] paramArrayOfb)
    {
      this.Rcq = paramArrayOfb;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(187660);
      FileSystem.b[] arrayOfb = this.Rcq;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        FileSystem.b localb = arrayOfb[i];
        paramCancellationSignal.throwIfCanceled();
        localb.a(paramCancellationSignal);
        i += 1;
      }
      AppMethodBeat.o(187660);
    }
    
    public final FileSystem hdQ()
    {
      return MaintenanceGroup.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.MaintenanceGroup
 * JD-Core Version:    0.7.0.1
 */