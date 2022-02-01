package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExpireFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<ExpireFileSystem> CREATOR;
  protected final FileSystem Rbo;
  protected final long nfE;
  
  static
  {
    AppMethodBeat.i(13097);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13097);
  }
  
  protected ExpireFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13094);
    aa.a(paramParcel, ExpireFileSystem.class, 1);
    this.Rbo = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.Rbo == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13094);
      throw paramParcel;
    }
    this.nfE = paramParcel.readLong();
    AppMethodBeat.o(13094);
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    AppMethodBeat.i(170151);
    this.Rbo = paramFileSystem;
    this.nfE = paramLong;
    AppMethodBeat.o(170151);
  }
  
  public FileSystem.b cj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187647);
    paramMap = new a(this.Rbo.cj(paramMap));
    AppMethodBeat.o(187647);
    return paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(170152);
    String str = "Expire [" + this.Rbo.toString() + "]";
    AppMethodBeat.o(170152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13096);
    aa.b(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.Rbo, paramInt);
    paramParcel.writeLong(this.nfE);
    AppMethodBeat.o(13096);
  }
  
  protected class a
    extends c
  {
    protected final List<FileSystem.b> RbF;
    protected final FileSystem.b Rbp;
    
    public a(FileSystem.b paramb)
    {
      AppMethodBeat.i(187645);
      this.Rbp = paramb;
      this.RbF = Collections.singletonList(paramb);
      AppMethodBeat.o(187645);
    }
    
    public void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(187646);
      long l3 = System.currentTimeMillis();
      long l4 = ExpireFileSystem.this.nfE;
      Object localObject = this.Rbp.dx("", true);
      long l1;
      e locale;
      long l2;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        label122:
        for (l1 = 0L;; l1 = l2 + l1) {
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              locale = (e)((Iterator)localObject).next();
              paramCancellationSignal.throwIfCanceled();
              if ((!locale.RbJ) && (locale.RbI <= l3 - l4))
              {
                if (!locale.hdW()) {
                  break label175;
                }
                if (locale.RbH < 0L) {
                  l2 = locale.size;
                }
              }
            }
          }
        }
      }
      label175:
      for (;;)
      {
        break;
        l2 = locale.RbH;
        break label122;
        ExpireFileSystem.this.l(3, new Object[] { "deleteSize", Long.valueOf(l1) });
        super.a(paramCancellationSignal);
        AppMethodBeat.o(187646);
        return;
      }
    }
    
    public final FileSystem hdQ()
    {
      return ExpireFileSystem.this;
    }
    
    public final List<FileSystem.b> hdS()
    {
      return this.RbF;
    }
    
    public final FileSystem.b ho(String paramString, int paramInt)
    {
      return this.Rbp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */