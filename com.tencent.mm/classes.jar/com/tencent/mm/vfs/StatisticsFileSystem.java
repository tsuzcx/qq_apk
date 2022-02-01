package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.f.a;
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
  private static final String[] YEl;
  protected final FileSystem YBI;
  protected final boolean YDa;
  protected final String[] YEm;
  
  static
  {
    AppMethodBeat.i(236831);
    YEl = new String[] { "" };
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(236831);
  }
  
  protected StatisticsFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(236819);
    ad.a(paramParcel, StatisticsFileSystem.class, 1);
    this.YBI = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.YBI == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(236819);
      throw paramParcel;
    }
    this.YEm = paramParcel.createStringArray();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.YDa = bool;
      AppMethodBeat.o(236819);
      return;
    }
  }
  
  public StatisticsFileSystem(FileSystem paramFileSystem)
  {
    this.YBI = paramFileSystem;
    this.YEm = YEl;
    this.YDa = true;
  }
  
  public StatisticsFileSystem(FileSystem paramFileSystem, Collection<String> paramCollection)
  {
    AppMethodBeat.i(236817);
    this.YBI = paramFileSystem;
    this.YDa = true;
    if (paramCollection.isEmpty())
    {
      this.YEm = YEl;
      AppMethodBeat.o(236817);
      return;
    }
    this.YEm = new String[paramCollection.size()];
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramFileSystem = (String)localIterator.next();
      int j;
      if (!paramFileSystem.endsWith(""))
      {
        j = 1;
        label97:
        if (j == 0) {
          break label156;
        }
      }
      for (;;)
      {
        paramCollection = ad.r(paramFileSystem, true, true);
        paramFileSystem = paramCollection;
        if (j == 0) {
          paramFileSystem = paramCollection + "";
        }
        this.YEm[i] = paramFileSystem;
        i += 1;
        break;
        j = 0;
        break label97;
        label156:
        paramFileSystem = paramFileSystem.substring(0, paramFileSystem.length() - 1);
      }
    }
    Arrays.sort(this.YEm);
    AppMethodBeat.o(236817);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236827);
    if (!(paramObject instanceof StatisticsFileSystem))
    {
      AppMethodBeat.o(236827);
      return false;
    }
    paramObject = (StatisticsFileSystem)paramObject;
    if ((this.YBI.equals(paramObject.YBI)) && (this.YDa == paramObject.YDa) && (Arrays.equals(this.YEm, paramObject.YEm)))
    {
      AppMethodBeat.o(236827);
      return true;
    }
    AppMethodBeat.o(236827);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(236826);
    int i = StatisticsFileSystem.class.hashCode();
    int j = ad.hash(new Object[] { this.YBI, this.YEm, Boolean.valueOf(this.YDa) });
    AppMethodBeat.o(236826);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(236825);
    String str = this.YBI.toString();
    AppMethodBeat.o(236825);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(236822);
    ad.b(paramParcel, StatisticsFileSystem.class, 1);
    paramParcel.writeParcelable(this.YBI, paramInt);
    paramParcel.writeStringArray(this.YEm);
    if (this.YDa) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(236822);
      return;
    }
  }
  
  protected class a
    extends d
  {
    protected final FileSystem.b YBJ;
    protected final List<FileSystem.b> YCf;
    private final boolean[] YEn;
    
    a(FileSystem.b paramb)
    {
      AppMethodBeat.i(236806);
      this.YBJ = paramb;
      this.YCf = Collections.singletonList(paramb);
      this.YEn = new boolean[StatisticsFileSystem.this.YEm.length];
      AppMethodBeat.o(236806);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(236812);
      int j;
      Object localObject;
      boolean bool;
      label62:
      label67:
      int i;
      if (StatisticsFileSystem.this.YDa)
      {
        j = 0;
        if (j < StatisticsFileSystem.this.YEm.length) {
          if (this.YEn[j] == 0)
          {
            localObject = StatisticsFileSystem.this.YEm[j];
            if (!((String)localObject).endsWith(""))
            {
              bool = true;
              if (!bool) {
                break label132;
              }
              localObject = dJ((String)localObject, bool);
              if (localObject == null) {
                break label150;
              }
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
          if (i < 10) {
            break label176;
          }
          paramCancellationSignal.throwIfCanceled();
          i = 0;
          continue;
          bool = false;
          break label62;
          label132:
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1);
          break label67;
        }
        label150:
        j += 1;
        break;
        super.a(paramCancellationSignal);
        Arrays.fill(this.YEn, false);
        AppMethodBeat.o(236812);
        return;
        label176:
        i += 1;
      }
    }
    
    public final Iterable<f> dJ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236810);
      Iterable localIterable = super.dJ(paramString, paramBoolean);
      if (localIterable == null)
      {
        AppMethodBeat.o(236810);
        return null;
      }
      String str = ad.r(paramString, true, true);
      String[] arrayOfString = StatisticsFileSystem.this.YEm;
      if (paramBoolean) {}
      int i;
      for (paramString = str;; paramString = str + "")
      {
        i = Arrays.binarySearch(arrayOfString, paramString);
        if (i >= 0) {
          break;
        }
        AppMethodBeat.o(236810);
        return localIterable;
      }
      paramString = new a(str, i, paramBoolean);
      paramString = new com.tencent.mm.vfs.a.h(new com.tencent.mm.vfs.a.f(localIterable, paramString), paramString);
      AppMethodBeat.o(236810);
      return paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236815);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(236815);
        return false;
      }
      paramObject = (a)paramObject;
      if ((this.YBJ.equals(paramObject.YBJ)) && (Arrays.equals(StatisticsFileSystem.this.YEm, paramObject.YEo.YEm)) && (StatisticsFileSystem.this.YDa == paramObject.YEo.YDa))
      {
        AppMethodBeat.o(236815);
        return true;
      }
      AppMethodBeat.o(236815);
      return false;
    }
    
    public final FileSystem.b hX(String paramString, int paramInt)
    {
      return this.YBJ;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(236814);
      int i = a.class.hashCode();
      int j = ad.hash(new Object[] { this.YBJ, StatisticsFileSystem.this.YEm, Boolean.valueOf(StatisticsFileSystem.this.YDa) });
      AppMethodBeat.o(236814);
      return i ^ j;
    }
    
    public final List<FileSystem.b> ifa()
    {
      return this.YCf;
    }
    
    final class a
      implements f.a<f, f>, h.a
    {
      final boolean Wa;
      final long YEp;
      final int YEq;
      int YEr;
      int YEs;
      long YEt;
      int YEu;
      long YEv;
      int YEw;
      final String mPath;
      final int mPos;
      long mTotalSize;
      
      a(String paramString, int paramInt, boolean paramBoolean)
      {
        AppMethodBeat.i(236801);
        this.YEp = System.currentTimeMillis();
        this.mTotalSize = 0L;
        this.YEr = 0;
        this.YEs = 0;
        this.YEt = 0L;
        this.YEu = 0;
        this.YEv = 0L;
        this.YEw = 0;
        this.mPath = paramString;
        this.mPos = paramInt;
        this.YEq = StatisticsFileSystem.bBO(paramString);
        this.Wa = paramBoolean;
        AppMethodBeat.o(236801);
      }
      
      public final void ifx()
      {
        AppMethodBeat.i(236803);
        StatisticsFileSystem localStatisticsFileSystem = StatisticsFileSystem.this;
        String str = this.mPath;
        boolean bool = this.Wa;
        long l2 = this.mTotalSize;
        int i = this.YEr;
        int j = this.YEs;
        if (this.YEr - this.YEw == 0) {}
        for (long l1 = 0L;; l1 = this.YEt / (this.YEr - this.YEw))
        {
          localStatisticsFileSystem.k(2, new Object[] { "relPath", str, "recursive", Boolean.valueOf(bool), "totalSize", Long.valueOf(l2), "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "averageAge", Long.valueOf(l1), "maxDepth", Integer.valueOf(this.YEu), "maxFileSize", Long.valueOf(this.YEv) });
          if (h.iWH().abSU.getLooper() == Looper.myLooper()) {
            StatisticsFileSystem.a.a(StatisticsFileSystem.a.this)[this.mPos] = 1;
          }
          AppMethodBeat.o(236803);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.StatisticsFileSystem
 * JD-Core Version:    0.7.0.1
 */