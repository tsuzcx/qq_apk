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
  protected final FileSystem YBI;
  protected final long qgo;
  
  static
  {
    AppMethodBeat.i(13097);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13097);
  }
  
  protected ExpireFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13094);
    ad.a(paramParcel, ExpireFileSystem.class, 1);
    this.YBI = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.YBI == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13094);
      throw paramParcel;
    }
    this.qgo = paramParcel.readLong();
    AppMethodBeat.o(13094);
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    AppMethodBeat.i(170151);
    this.YBI = paramFileSystem;
    this.qgo = paramLong;
    AppMethodBeat.o(170151);
  }
  
  public FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(236089);
    paramMap = new a(this.YBI.cp(paramMap));
    AppMethodBeat.o(236089);
    return paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236099);
    if (!(paramObject instanceof ExpireFileSystem))
    {
      AppMethodBeat.o(236099);
      return false;
    }
    paramObject = (ExpireFileSystem)paramObject;
    if ((this.YBI.equals(paramObject.YBI)) && (this.qgo == paramObject.qgo))
    {
      AppMethodBeat.o(236099);
      return true;
    }
    AppMethodBeat.o(236099);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(236096);
    int i = ExpireFileSystem.class.hashCode();
    int j = ad.hash(new Object[] { this.YBI, Long.valueOf(this.qgo) });
    AppMethodBeat.o(236096);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(170152);
    String str = "Expire [" + this.YBI.toString() + "]";
    AppMethodBeat.o(170152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13096);
    ad.b(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.YBI, paramInt);
    paramParcel.writeLong(this.qgo);
    AppMethodBeat.o(13096);
  }
  
  protected class a
    extends d
  {
    protected final FileSystem.b YBJ;
    protected final List<FileSystem.b> YCf;
    
    public a(FileSystem.b paramb)
    {
      AppMethodBeat.i(236063);
      this.YBJ = paramb;
      this.YCf = Collections.singletonList(paramb);
      AppMethodBeat.o(236063);
    }
    
    public void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(236070);
      long l3 = System.currentTimeMillis();
      long l4 = ExpireFileSystem.this.qgo;
      Object localObject = this.YBJ.dJ("", true);
      long l1;
      f localf;
      long l2;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        label123:
        for (l1 = 0L;; l1 = l2 + l1) {
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localf = (f)((Iterator)localObject).next();
              paramCancellationSignal.throwIfCanceled();
              if ((!localf.YCj) && (localf.YCi <= l3 - l4))
              {
                if (!localf.HT(true)) {
                  break label176;
                }
                if (localf.YCh < 0L) {
                  l2 = localf.size;
                }
              }
            }
          }
        }
      }
      label176:
      for (;;)
      {
        break;
        l2 = localf.YCh;
        break label123;
        ExpireFileSystem.this.k(3, new Object[] { "deleteSize", Long.valueOf(l1) });
        super.a(paramCancellationSignal);
        AppMethodBeat.o(236070);
        return;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236074);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(236074);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.YBJ.equals(paramObject.YBJ)) && (ExpireFileSystem.this.qgo == paramObject.YCg.qgo))
      {
        AppMethodBeat.o(236074);
        return true;
      }
      AppMethodBeat.o(236074);
      return false;
    }
    
    public final FileSystem.b hX(String paramString, int paramInt)
    {
      return this.YBJ;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(236072);
      int i = a.class.hashCode();
      int j = ad.hash(new Object[] { this.YBJ, Long.valueOf(ExpireFileSystem.this.qgo) });
      AppMethodBeat.o(236072);
      return i ^ j;
    }
    
    public final List<FileSystem.b> ifa()
    {
      return this.YCf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */