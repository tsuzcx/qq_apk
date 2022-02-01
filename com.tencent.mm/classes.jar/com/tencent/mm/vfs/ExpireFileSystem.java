package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;

public class ExpireFileSystem
  extends DelegateFileSystem
{
  public static final Parcelable.Creator<ExpireFileSystem> CREATOR;
  private final FileSystem HRw;
  private final Iterable<FileSystem> HRx;
  private final long kSM;
  
  static
  {
    AppMethodBeat.i(13097);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13097);
  }
  
  protected ExpireFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13094);
    q.a(paramParcel, ExpireFileSystem.class, 1);
    this.HRw = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.HRw == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13094);
      throw paramParcel;
    }
    this.HRx = Collections.singletonList(this.HRw);
    this.kSM = paramParcel.readLong();
    AppMethodBeat.o(13094);
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    AppMethodBeat.i(170151);
    this.HRw = paramFileSystem;
    this.HRx = Collections.singletonList(this.HRw);
    this.kSM = paramLong;
    AppMethodBeat.o(170151);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(13095);
    long l3 = System.currentTimeMillis();
    long l4 = this.kSM;
    Object localObject = this.HRw.cN("", true);
    long l1;
    FileSystem.a locala;
    long l2;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      label120:
      for (l1 = 0L;; l1 = l2 + l1) {
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            locala = (FileSystem.a)((Iterator)localObject).next();
            paramCancellationSignal.throwIfCanceled();
            if ((!locala.HRB) && (locala.HRA <= l3 - l4))
            {
              if (!locala.delete()) {
                break label171;
              }
              if (locala.HRz < 0L) {
                l2 = locala.size;
              }
            }
          }
        }
      }
    }
    label171:
    for (;;)
    {
      break;
      l2 = locala.HRz;
      break label120;
      k(3, new Object[] { "deleteSize", Long.valueOf(l1) });
      super.a(paramCancellationSignal);
      AppMethodBeat.o(13095);
      return;
    }
  }
  
  protected final Iterable<FileSystem> fhB()
  {
    return this.HRx;
  }
  
  protected final FileSystem gj(String paramString, int paramInt)
  {
    return this.HRw;
  }
  
  public String toString()
  {
    AppMethodBeat.i(170152);
    String str = "Expire [" + this.HRw.toString() + "]";
    AppMethodBeat.o(170152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13096);
    q.b(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.HRw, paramInt);
    paramParcel.writeLong(this.kSM);
    AppMethodBeat.o(13096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */