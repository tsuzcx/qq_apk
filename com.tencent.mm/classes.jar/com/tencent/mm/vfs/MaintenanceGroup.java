package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MaintenanceGroup
  implements FileSystem
{
  public static final Parcelable.Creator<MaintenanceGroup> CREATOR;
  protected final i agxR;
  
  static
  {
    AppMethodBeat.i(238328);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238328);
  }
  
  protected MaintenanceGroup(Parcel paramParcel)
  {
    AppMethodBeat.i(238317);
    ah.a(paramParcel, MaintenanceGroup.class, 3);
    this.agxR = new i(paramParcel);
    AppMethodBeat.o(238317);
  }
  
  public MaintenanceGroup(Collection<?> paramCollection)
  {
    AppMethodBeat.i(238307);
    this.agxR = new i(paramCollection);
    AppMethodBeat.o(238307);
  }
  
  public MaintenanceGroup(Object... paramVarArgs)
  {
    AppMethodBeat.i(238299);
    this.agxR = new i(paramVarArgs);
    AppMethodBeat.o(238299);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238365);
    if (((paramObject instanceof MaintenanceGroup)) && (this.agxR.equals(((MaintenanceGroup)paramObject).agxR)))
    {
      AppMethodBeat.o(238365);
      return true;
    }
    AppMethodBeat.o(238365);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238357);
    int i = MaintenanceGroup.class.hashCode();
    int j = this.agxR.hashCode();
    AppMethodBeat.o(238357);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238352);
    String str = this.agxR.toString();
    AppMethodBeat.o(238352);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238344);
    ah.b(paramParcel, MaintenanceGroup.class, 3);
    this.agxR.g(paramParcel);
    AppMethodBeat.o(238344);
  }
  
  protected class a
    extends m
  {
    protected final List<FileSystem.b> agxd;
    
    protected a()
    {
      Object localObject;
      this.agxd = localObject;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238327);
      Iterator localIterator = this.agxd.iterator();
      while (localIterator.hasNext())
      {
        FileSystem.b localb = (FileSystem.b)localIterator.next();
        paramCancellationSignal.throwIfCanceled();
        localb.a(paramCancellationSignal);
      }
      AppMethodBeat.o(238327);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238345);
      if (((paramObject instanceof a)) && (this.agxd.equals(((a)paramObject).agxd)))
      {
        AppMethodBeat.o(238345);
        return true;
      }
      AppMethodBeat.o(238345);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238338);
      int i = a.class.hashCode();
      int j = this.agxd.hashCode();
      AppMethodBeat.o(238338);
      return i ^ j;
    }
    
    public final FileSystem jKa()
    {
      return MaintenanceGroup.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.MaintenanceGroup
 * JD-Core Version:    0.7.0.1
 */