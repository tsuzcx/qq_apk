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
  private final FileSystem Ljf;
  private final Iterable<FileSystem> Ljg;
  private final long lTw;
  
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
    this.Ljf = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.Ljf == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13094);
      throw paramParcel;
    }
    this.Ljg = Collections.singletonList(this.Ljf);
    this.lTw = paramParcel.readLong();
    AppMethodBeat.o(13094);
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    AppMethodBeat.i(170151);
    this.Ljf = paramFileSystem;
    this.Ljg = Collections.singletonList(this.Ljf);
    this.lTw = paramLong;
    AppMethodBeat.o(170151);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(13095);
    long l3 = System.currentTimeMillis();
    long l4 = this.lTw;
    Object localObject = this.Ljf.cY("", true);
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
            if ((!locala.LjL) && (locala.LjK <= l3 - l4))
            {
              if (!locala.delete()) {
                break label171;
              }
              if (locala.LjJ < 0L) {
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
      l2 = locala.LjJ;
      break label120;
      k(3, new Object[] { "deleteSize", Long.valueOf(l1) });
      super.a(paramCancellationSignal);
      AppMethodBeat.o(13095);
      return;
    }
  }
  
  protected final Iterable<FileSystem> fOq()
  {
    return this.Ljg;
  }
  
  protected final FileSystem gK(String paramString, int paramInt)
  {
    return this.Ljf;
  }
  
  public String toString()
  {
    AppMethodBeat.i(170152);
    String str = "Expire [" + this.Ljf.toString() + "]";
    AppMethodBeat.o(170152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13096);
    q.b(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.Ljf, paramInt);
    paramParcel.writeLong(this.lTw);
    AppMethodBeat.o(13096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */