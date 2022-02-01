package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeleteAllFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<DeleteAllFileSystem> CREATOR;
  protected final FileSystem YBI;
  
  static
  {
    AppMethodBeat.i(236048);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(236048);
  }
  
  protected DeleteAllFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(236038);
    ad.a(paramParcel, StatisticsFileSystem.class, 1);
    this.YBI = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.YBI == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(236038);
      throw paramParcel;
    }
    AppMethodBeat.o(236038);
  }
  
  public DeleteAllFileSystem(FileSystem paramFileSystem)
  {
    this.YBI = paramFileSystem;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236044);
    if (((paramObject instanceof DeleteAllFileSystem)) && (this.YBI.equals(((DeleteAllFileSystem)paramObject).YBI)))
    {
      AppMethodBeat.o(236044);
      return true;
    }
    AppMethodBeat.o(236044);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(236043);
    int i = DeleteAllFileSystem.class.hashCode();
    int j = this.YBI.hashCode();
    AppMethodBeat.o(236043);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(236041);
    String str = "DeleteAll [" + this.YBI.toString() + "]";
    AppMethodBeat.o(236041);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(236045);
    ad.b(paramParcel, StatisticsFileSystem.class, 1);
    paramParcel.writeParcelable(this.YBI, paramInt);
    AppMethodBeat.o(236045);
  }
  
  protected class a
    extends j
  {
    protected final FileSystem.b YBJ;
    
    a(FileSystem.b paramb)
    {
      this.YBJ = paramb;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(236023);
      this.YBJ.dK("", true);
      paramCancellationSignal.throwIfCanceled();
      this.YBJ.a(paramCancellationSignal);
      AppMethodBeat.o(236023);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236029);
      if (((paramObject instanceof a)) && (this.YBJ.equals(((a)paramObject).YBJ)))
      {
        AppMethodBeat.o(236029);
        return true;
      }
      AppMethodBeat.o(236029);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(236028);
      int i = a.class.hashCode();
      int j = this.YBJ.hashCode();
      AppMethodBeat.o(236028);
      return i ^ j;
    }
    
    public final FileSystem ieX()
    {
      return DeleteAllFileSystem.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.DeleteAllFileSystem
 * JD-Core Version:    0.7.0.1
 */