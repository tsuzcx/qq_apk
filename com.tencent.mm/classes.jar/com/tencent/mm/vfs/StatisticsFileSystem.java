package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.f;
import com.tencent.mm.vfs.a.f.a;
import com.tencent.mm.vfs.a.h;
import com.tencent.mm.vfs.a.h.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StatisticsFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<StatisticsFileSystem> CREATOR;
  private static final String[] Rdx;
  protected final FileSystem Rbo;
  protected final boolean Rcx;
  protected final String[] Rdy;
  
  static
  {
    AppMethodBeat.i(187754);
    Rdx = new String[] { "" };
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(187754);
  }
  
  protected StatisticsFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(187749);
    aa.a(paramParcel, StatisticsFileSystem.class, 1);
    this.Rbo = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.Rbo == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(187749);
      throw paramParcel;
    }
    this.Rdy = paramParcel.createStringArray();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Rcx = bool;
      AppMethodBeat.o(187749);
      return;
    }
  }
  
  public StatisticsFileSystem(FileSystem paramFileSystem)
  {
    this.Rbo = paramFileSystem;
    this.Rdy = Rdx;
    this.Rcx = true;
  }
  
  public StatisticsFileSystem(FileSystem paramFileSystem, Collection<String> paramCollection)
  {
    AppMethodBeat.i(187748);
    this.Rbo = paramFileSystem;
    this.Rcx = true;
    if (paramCollection.isEmpty())
    {
      this.Rdy = Rdx;
      AppMethodBeat.o(187748);
      return;
    }
    this.Rdy = new String[paramCollection.size()];
    paramFileSystem = paramCollection.iterator();
    int i = 0;
    while (paramFileSystem.hasNext())
    {
      paramCollection = (String)paramFileSystem.next();
      this.Rdy[i] = aa.q(paramCollection, true, true);
      i += 1;
    }
    Arrays.sort(this.Rdy);
    AppMethodBeat.o(187748);
  }
  
  public String toString()
  {
    AppMethodBeat.i(187751);
    String str = this.Rbo.toString();
    AppMethodBeat.o(187751);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(187750);
    aa.b(paramParcel, StatisticsFileSystem.class, 1);
    paramParcel.writeParcelable(this.Rbo, paramInt);
    paramParcel.writeStringArray(this.Rdy);
    if (this.Rcx) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(187750);
      return;
    }
  }
  
  protected final class a
    extends c
  {
    protected final List<FileSystem.b> RbF;
    protected final FileSystem.b Rbp;
    final boolean[] Rdz;
    
    a(FileSystem.b paramb)
    {
      AppMethodBeat.i(187745);
      this.Rbp = paramb;
      this.RbF = Collections.singletonList(paramb);
      this.Rdz = new boolean[StatisticsFileSystem.this.Rdy.length];
      AppMethodBeat.o(187745);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(187747);
      int j;
      Object localObject;
      int i;
      if (StatisticsFileSystem.this.Rcx)
      {
        j = 0;
        if (j < StatisticsFileSystem.this.Rdy.length) {
          if (this.Rdz[j] == 0)
          {
            localObject = dx(StatisticsFileSystem.this.Rdy[j], true);
            if (localObject != null)
            {
              localObject = ((Iterable)localObject).iterator();
              i = 0;
            }
          }
        }
      }
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ((Iterator)localObject).next();
          if (i >= 10)
          {
            paramCancellationSignal.throwIfCanceled();
            i = 0;
          }
        }
        else
        {
          j += 1;
          break;
          super.a(paramCancellationSignal);
          Arrays.fill(this.Rdz, false);
          AppMethodBeat.o(187747);
          return;
        }
        i += 1;
      }
    }
    
    public final Iterable<e> dx(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187746);
      Iterable localIterable = super.dx(paramString, paramBoolean);
      if ((localIterable == null) || (!paramBoolean))
      {
        AppMethodBeat.o(187746);
        return localIterable;
      }
      paramString = aa.q(paramString, true, true);
      int i = Arrays.binarySearch(StatisticsFileSystem.this.Rdy, paramString);
      if (i < 0)
      {
        AppMethodBeat.o(187746);
        return localIterable;
      }
      paramString = new a(paramString, i);
      paramString = new h(new f(localIterable, paramString), paramString);
      AppMethodBeat.o(187746);
      return paramString;
    }
    
    public final FileSystem hdQ()
    {
      return StatisticsFileSystem.this;
    }
    
    public final List<FileSystem.b> hdS()
    {
      return this.RbF;
    }
    
    public final FileSystem.b ho(String paramString, int paramInt)
    {
      return this.Rbp;
    }
    
    final class a
      implements f.a<e, e>, h.a<e>
    {
      final long RdB;
      final int RdC;
      int RdD;
      int RdE;
      long RdF;
      int RdG;
      long RdH;
      int RdI;
      final String mPath;
      final int mPos;
      long mTotalSize;
      
      a(String paramString, int paramInt)
      {
        AppMethodBeat.i(187742);
        this.RdB = System.currentTimeMillis();
        this.mTotalSize = 0L;
        this.RdD = 0;
        this.RdE = 0;
        this.RdF = 0L;
        this.RdG = 0;
        this.RdH = 0L;
        this.RdI = 0;
        this.mPath = paramString;
        this.mPos = paramInt;
        this.RdC = StatisticsFileSystem.boS(paramString);
        AppMethodBeat.o(187742);
      }
      
      public final void hen()
      {
        AppMethodBeat.i(187743);
        StatisticsFileSystem localStatisticsFileSystem = StatisticsFileSystem.this;
        String str = this.mPath;
        long l2 = this.mTotalSize;
        int i = this.RdD;
        int j = this.RdE;
        if (this.RdD - this.RdI == 0) {}
        for (long l1 = 0L;; l1 = this.RdF / (this.RdD - this.RdI))
        {
          localStatisticsFileSystem.l(2, new Object[] { "relPath", str, "totalSize", Long.valueOf(l2), "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "averageAge", Long.valueOf(l1), "maxDepth", Integer.valueOf(this.RdG), "maxFileSize", Long.valueOf(this.RdH) });
          if (g.hRR().Uvj.getLooper() == Looper.myLooper()) {
            StatisticsFileSystem.a.this.Rdz[this.mPos] = true;
          }
          AppMethodBeat.o(187743);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.StatisticsFileSystem
 * JD-Core Version:    0.7.0.1
 */