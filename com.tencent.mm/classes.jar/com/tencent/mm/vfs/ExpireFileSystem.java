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
  private final FileSystem JrA;
  private final Iterable<FileSystem> JrB;
  private final long lum;
  
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
    this.JrA = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.JrA == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13094);
      throw paramParcel;
    }
    this.JrB = Collections.singletonList(this.JrA);
    this.lum = paramParcel.readLong();
    AppMethodBeat.o(13094);
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    AppMethodBeat.i(170151);
    this.JrA = paramFileSystem;
    this.JrB = Collections.singletonList(this.JrA);
    this.lum = paramLong;
    AppMethodBeat.o(170151);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(13095);
    long l3 = System.currentTimeMillis();
    long l4 = this.lum;
    Object localObject = this.JrA.cT("", true);
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
            if ((!locala.Jsg) && (locala.Jsf <= l3 - l4))
            {
              if (!locala.delete()) {
                break label171;
              }
              if (locala.Jse < 0L) {
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
      l2 = locala.Jse;
      break label120;
      k(3, new Object[] { "deleteSize", Long.valueOf(l1) });
      super.a(paramCancellationSignal);
      AppMethodBeat.o(13095);
      return;
    }
  }
  
  protected final Iterable<FileSystem> fxD()
  {
    return this.JrB;
  }
  
  protected final FileSystem gn(String paramString, int paramInt)
  {
    return this.JrA;
  }
  
  public String toString()
  {
    AppMethodBeat.i(170152);
    String str = "Expire [" + this.JrA.toString() + "]";
    AppMethodBeat.o(170152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13096);
    q.b(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.JrA, paramInt);
    paramParcel.writeLong(this.lum);
    AppMethodBeat.o(13096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */