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
  protected final FileSystem LFX;
  protected final long lXY;
  
  static
  {
    AppMethodBeat.i(13097);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13097);
  }
  
  protected ExpireFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13094);
    w.a(paramParcel, ExpireFileSystem.class, 1);
    this.LFX = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.LFX == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13094);
      throw paramParcel;
    }
    this.lXY = paramParcel.readLong();
    AppMethodBeat.o(13094);
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    AppMethodBeat.i(170151);
    this.LFX = paramFileSystem;
    this.lXY = paramLong;
    AppMethodBeat.o(170151);
  }
  
  public FileSystem.b cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193367);
    paramMap = new a(this.LFX.cd(paramMap));
    AppMethodBeat.o(193367);
    return paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(170152);
    String str = "Expire [" + this.LFX.toString() + "]";
    AppMethodBeat.o(170152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13096);
    w.b(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.LFX, paramInt);
    paramParcel.writeLong(this.lXY);
    AppMethodBeat.o(13096);
  }
  
  protected class a
    extends b
  {
    protected final FileSystem.b LFY;
    protected final List<FileSystem.b> LFZ;
    
    public a(FileSystem.b paramb)
    {
      AppMethodBeat.i(193365);
      this.LFY = paramb;
      this.LFZ = Collections.singletonList(paramb);
      AppMethodBeat.o(193365);
    }
    
    public void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(193366);
      long l3 = System.currentTimeMillis();
      long l4 = ExpireFileSystem.this.lXY;
      Object localObject = this.LFY.dc("", true);
      long l1;
      c localc;
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
              localc = (c)((Iterator)localObject).next();
              paramCancellationSignal.throwIfCanceled();
              if ((!localc.LGd) && (localc.LGc <= l3 - l4))
              {
                if (!localc.delete()) {
                  break label175;
                }
                if (localc.LGb < 0L) {
                  l2 = localc.size;
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
        l2 = localc.LGb;
        break label122;
        ExpireFileSystem.this.k(3, new Object[] { "deleteSize", Long.valueOf(l1) });
        super.a(paramCancellationSignal);
        AppMethodBeat.o(193366);
        return;
      }
    }
    
    public final FileSystem fSK()
    {
      return ExpireFileSystem.this;
    }
    
    public final List<FileSystem.b> fSM()
    {
      return this.LFZ;
    }
    
    public final FileSystem.b gU(String paramString, int paramInt)
    {
      return this.LFY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */