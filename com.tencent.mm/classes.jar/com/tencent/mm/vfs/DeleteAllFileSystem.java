package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeleteAllFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<DeleteAllFileSystem> CREATOR;
  protected final FileSystem agvG;
  
  static
  {
    AppMethodBeat.i(238247);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238247);
  }
  
  protected DeleteAllFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(238243);
    ah.a(paramParcel, StatisticsFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.agvG == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(238243);
      throw paramParcel;
    }
    AppMethodBeat.o(238243);
  }
  
  public DeleteAllFileSystem(FileSystem paramFileSystem)
  {
    this.agvG = paramFileSystem;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238258);
    if (((paramObject instanceof DeleteAllFileSystem)) && (this.agvG.equals(((DeleteAllFileSystem)paramObject).agvG)))
    {
      AppMethodBeat.o(238258);
      return true;
    }
    AppMethodBeat.o(238258);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238254);
    int i = DeleteAllFileSystem.class.hashCode();
    int j = this.agvG.hashCode();
    AppMethodBeat.o(238254);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238250);
    String str = "DeleteAll [" + this.agvG.toString() + "]";
    AppMethodBeat.o(238250);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238261);
    ah.b(paramParcel, StatisticsFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    AppMethodBeat.o(238261);
  }
  
  protected class a
    extends m
  {
    protected final FileSystem.b agwv;
    
    a(FileSystem.b paramb)
    {
      this.agwv = paramb;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238503);
      this.agwv.ew("", true);
      paramCancellationSignal.throwIfCanceled();
      this.agwv.a(paramCancellationSignal);
      AppMethodBeat.o(238503);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238514);
      if (((paramObject instanceof a)) && (this.agwv.equals(((a)paramObject).agwv)))
      {
        AppMethodBeat.o(238514);
        return true;
      }
      AppMethodBeat.o(238514);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238508);
      int i = a.class.hashCode();
      int j = this.agwv.hashCode();
      AppMethodBeat.o(238508);
      return i ^ j;
    }
    
    public final FileSystem jKa()
    {
      return DeleteAllFileSystem.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.DeleteAllFileSystem
 * JD-Core Version:    0.7.0.1
 */