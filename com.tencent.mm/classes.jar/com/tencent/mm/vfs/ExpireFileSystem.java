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
  protected final FileSystem agvG;
  protected final long tkZ;
  
  static
  {
    AppMethodBeat.i(13097);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13097);
  }
  
  protected ExpireFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13094);
    ah.a(paramParcel, ExpireFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.agvG == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13094);
      throw paramParcel;
    }
    this.tkZ = paramParcel.readLong();
    AppMethodBeat.o(13094);
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    AppMethodBeat.i(170151);
    this.agvG = paramFileSystem;
    this.tkZ = paramLong;
    AppMethodBeat.o(170151);
  }
  
  public FileSystem.b cO(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238214);
    paramMap = new a((FileSystem.b)this.agvG.cN(paramMap));
    AppMethodBeat.o(238214);
    return paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238224);
    if (!(paramObject instanceof ExpireFileSystem))
    {
      AppMethodBeat.o(238224);
      return false;
    }
    paramObject = (ExpireFileSystem)paramObject;
    if ((this.agvG.equals(paramObject.agvG)) && (this.tkZ == paramObject.tkZ))
    {
      AppMethodBeat.o(238224);
      return true;
    }
    AppMethodBeat.o(238224);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238220);
    int i = ExpireFileSystem.class.hashCode();
    int j = ah.hash(new Object[] { this.agvG, Long.valueOf(this.tkZ) });
    AppMethodBeat.o(238220);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(170152);
    String str = "Expire [" + this.agvG.toString() + "]";
    AppMethodBeat.o(170152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13096);
    ah.b(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    paramParcel.writeLong(this.tkZ);
    AppMethodBeat.o(13096);
  }
  
  protected class a
    extends f
  {
    protected final FileSystem.b agwv;
    protected final List<FileSystem.b> agxd;
    
    public a(FileSystem.b paramb)
    {
      AppMethodBeat.i(238427);
      this.agwv = paramb;
      this.agxd = Collections.singletonList(paramb);
      AppMethodBeat.o(238427);
    }
    
    public void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238445);
      long l3 = System.currentTimeMillis();
      long l4 = ExpireFileSystem.this.tkZ;
      Object localObject = ah.b(this.agwv, "");
      long l1;
      j localj;
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
              localj = (j)((Iterator)localObject).next();
              paramCancellationSignal.throwIfCanceled();
              if ((!localj.agxh) && (localj.agxg <= l3 - l4))
              {
                if (!localj.NP(true)) {
                  break label173;
                }
                if (localj.agxf < 0L) {
                  l2 = localj.size;
                }
              }
            }
          }
        }
      }
      label173:
      for (;;)
      {
        break;
        l2 = localj.agxf;
        break label120;
        ExpireFileSystem.this.l(3, new Object[] { "deleteSize", Long.valueOf(l1) });
        super.a(paramCancellationSignal);
        AppMethodBeat.o(238445);
        return;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238455);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(238455);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.agwv.equals(paramObject.agwv)) && (ExpireFileSystem.this.tkZ == paramObject.agxe.tkZ))
      {
        AppMethodBeat.o(238455);
        return true;
      }
      AppMethodBeat.o(238455);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238449);
      int i = a.class.hashCode();
      int j = ah.hash(new Object[] { this.agwv, Long.valueOf(ExpireFileSystem.this.tkZ) });
      AppMethodBeat.o(238449);
      return i ^ j;
    }
    
    public final List<FileSystem.b> jKf()
    {
      return this.agxd;
    }
    
    public final FileSystem.b jk(String paramString, int paramInt)
    {
      return this.agwv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */