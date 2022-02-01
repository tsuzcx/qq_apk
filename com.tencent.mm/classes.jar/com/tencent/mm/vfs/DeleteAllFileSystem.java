package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeleteAllFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<DeleteAllFileSystem> CREATOR;
  protected final FileSystem Rbo;
  
  static
  {
    AppMethodBeat.i(187644);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(187644);
  }
  
  protected DeleteAllFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(187640);
    aa.a(paramParcel, StatisticsFileSystem.class, 1);
    this.Rbo = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.Rbo == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(187640);
      throw paramParcel;
    }
    AppMethodBeat.o(187640);
  }
  
  public DeleteAllFileSystem(FileSystem paramFileSystem)
  {
    this.Rbo = paramFileSystem;
  }
  
  public String toString()
  {
    AppMethodBeat.i(187641);
    String str = "DeleteAll [" + this.Rbo.toString() + "]";
    AppMethodBeat.o(187641);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(187642);
    aa.b(paramParcel, StatisticsFileSystem.class, 1);
    paramParcel.writeParcelable(this.Rbo, paramInt);
    AppMethodBeat.o(187642);
  }
  
  protected final class a
    extends i
  {
    protected final FileSystem.b Rbp;
    
    a(FileSystem.b paramb)
    {
      this.Rbp = paramb;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(187639);
      this.Rbp.dy("", true);
      paramCancellationSignal.throwIfCanceled();
      this.Rbp.a(paramCancellationSignal);
      AppMethodBeat.o(187639);
    }
    
    public final FileSystem hdQ()
    {
      return DeleteAllFileSystem.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.DeleteAllFileSystem
 * JD-Core Version:    0.7.0.1
 */