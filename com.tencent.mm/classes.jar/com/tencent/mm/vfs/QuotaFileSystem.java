package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QuotaFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<QuotaFileSystem> CREATOR;
  protected final boolean LFG;
  protected final FileSystem LFX;
  protected final long LHg;
  protected final long LHh;
  protected final long lXY;
  
  static
  {
    AppMethodBeat.i(13202);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13202);
  }
  
  protected QuotaFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13189);
    w.a(paramParcel, QuotaFileSystem.class, 2);
    this.LFX = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.LFX == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13189);
      throw paramParcel;
    }
    this.LHg = paramParcel.readLong();
    this.LHh = paramParcel.readLong();
    this.lXY = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.LFG = bool;
      fSY();
      AppMethodBeat.o(13189);
      return;
    }
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(13188);
    this.LFX = paramFileSystem;
    this.LHg = paramLong1;
    this.LHh = paramLong2;
    this.lXY = 7776000000L;
    this.LFG = true;
    fSY();
    AppMethodBeat.o(13188);
  }
  
  private void fSY()
  {
    AppMethodBeat.i(13190);
    if (this.LHh < this.LHg)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
      AppMethodBeat.o(13190);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(13190);
  }
  
  public final FileSystem.b cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193429);
    paramMap = new b(this.LFX.cd(paramMap));
    AppMethodBeat.o(193429);
    return paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13200);
    long l = this.LHg / 1024L / 1024L;
    String str = "QuotaFS [" + l + "MB | " + this.LFX.toString() + "]";
    AppMethodBeat.o(13200);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13201);
    w.b(paramParcel, QuotaFileSystem.class, 2);
    paramParcel.writeParcelable(this.LFX, paramInt);
    paramParcel.writeLong(this.LHg);
    paramParcel.writeLong(this.LHh);
    paramParcel.writeLong(this.lXY);
    if (this.LFG) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(13201);
      return;
    }
  }
  
  static final class a
  {
    c LHi;
    int nZU;
    
    a(c paramc)
    {
      this.LHi = paramc;
      this.nZU = 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13187);
      String str = "children: " + this.nZU + " [" + this.LHi + "]";
      AppMethodBeat.o(13187);
      return str;
    }
  }
  
  protected final class b
    extends b
    implements Handler.Callback
  {
    private final Object LFI;
    private HashMap<String, Long> LFJ;
    private final Handler LFK;
    protected final FileSystem.b LFY;
    protected final List<FileSystem.b> LFZ;
    
    b(FileSystem.b paramb)
    {
      AppMethodBeat.i(193419);
      this.LFI = new Object();
      this.LFY = paramb;
      this.LFZ = Collections.singletonList(paramb);
      if (QuotaFileSystem.this.LFG)
      {
        this.LFJ = new HashMap();
        this.LFK = new Handler(e.fSU().OAH.getLooper(), this);
        AppMethodBeat.o(193419);
        return;
      }
      this.LFJ = null;
      this.LFK = null;
      AppMethodBeat.o(193419);
    }
    
    private void df(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193420);
      if (!QuotaFileSystem.this.LFG)
      {
        AppMethodBeat.o(193420);
        return;
      }
      if (paramBoolean) {
        synchronized (this.LFI)
        {
          this.LFJ.remove(paramString);
          AppMethodBeat.o(193420);
          return;
        }
      }
      long l = System.currentTimeMillis();
      synchronized (this.LFI)
      {
        paramBoolean = this.LFJ.isEmpty();
        this.LFJ.put(paramString, Long.valueOf(l));
        if (paramBoolean) {
          this.LFK.sendMessageDelayed(Message.obtain(), 60000L);
        }
        AppMethodBeat.o(193420);
        return;
      }
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(193427);
      long l2 = 0L;
      int i1 = 0;
      int i = 0;
      int j = 0;
      int n = 0;
      int k = n;
      int m = i;
      long l1 = l2;
      int i2;
      label151:
      label201:
      Object localObject1;
      label259:
      Object localObject2;
      Object localObject4;
      long l3;
      for (;;)
      {
        try
        {
          i2 = this.LFY.fSL();
          if ((i2 & 0x1) == 0)
          {
            k = n;
            m = i;
            l1 = l2;
            Log.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.LFY.toString());
            super.a(paramCancellationSignal);
            AppMethodBeat.o(193427);
            return;
          }
          if ((i2 & 0x4) != 0) {
            break label259;
          }
          k = n;
          m = i;
          l1 = l2;
          Log.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.LFY.toString());
          continue;
          if (!(paramCancellationSignal instanceof OperationCanceledException)) {
            break label2157;
          }
        }
        catch (Exception paramCancellationSignal)
        {
          j = m;
          i = k;
        }
        Log.i("VFS.QuotaFileSystem", "Maintenance cancelled. files: " + j + ", dirs: " + i + ", totalSize: " + l1);
        k = 4;
        QuotaFileSystem.this.k(k, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l1) });
        AppMethodBeat.o(193427);
        throw paramCancellationSignal;
        k = n;
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        k = n;
        m = i;
        l1 = l2;
        QuotaFileSystem.this.k(1, new Object[] { "destination", this.LFY });
        k = n;
        m = i;
        l1 = l2;
        if (QuotaFileSystem.this.LFG)
        {
          localObject1 = null;
          k = n;
          m = i;
          l1 = l2;
          localObject2 = this.LFI;
          k = n;
          m = i;
          l1 = l2;
          try
          {
            if (!this.LFJ.isEmpty())
            {
              localObject1 = this.LFJ;
              this.LFJ = new HashMap();
            }
            if (localObject1 != null)
            {
              k = n;
              m = i;
              l1 = l2;
              localObject1 = ((HashMap)localObject1).entrySet().iterator();
              for (;;)
              {
                k = n;
                m = i;
                l1 = l2;
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                k = n;
                m = i;
                l1 = l2;
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                k = n;
                m = i;
                l1 = l2;
                paramCancellationSignal.throwIfCanceled();
                k = n;
                m = i;
                l1 = l2;
                this.LFY.cp((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
              }
            }
            k = n;
          }
          finally
          {
            k = n;
            m = i;
            l1 = l2;
            AppMethodBeat.o(193427);
            k = n;
            m = i;
            l1 = l2;
          }
        }
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        k = n;
        m = i;
        l1 = l2;
        localObject4 = new ArrayList();
        k = n;
        m = i;
        l1 = l2;
        localObject1 = this.LFY.dc("", true);
        if (localObject1 == null)
        {
          k = n;
          m = i;
          l1 = l2;
          Log.e("VFS.QuotaFileSystem", "Unable to list files in FS: " + toString());
        }
        else
        {
          k = n;
          m = i;
          l1 = l2;
          localObject1 = ((Iterable)localObject1).iterator();
          i = i1;
          k = j;
          m = i;
          l1 = l2;
          if (((Iterator)localObject1).hasNext())
          {
            k = j;
            m = i;
            l1 = l2;
            localObject2 = (c)((Iterator)localObject1).next();
            k = j;
            m = i;
            l1 = l2;
            paramCancellationSignal.throwIfCanceled();
            k = j;
            m = i;
            l1 = l2;
            if (((c)localObject2).LGb < 0L)
            {
              k = j;
              m = i;
              l1 = l2;
              l3 = ((c)localObject2).size;
            }
            for (l1 = l3;; l1 = l3)
            {
              for (;;)
              {
                l2 += l1;
                k = j;
                m = i;
                l1 = l2;
                boolean bool = ((c)localObject2).LGd;
                if (!bool) {
                  break label2225;
                }
                j += 1;
                try
                {
                  label817:
                  ((List)localObject4).add(localObject2);
                }
                catch (Exception paramCancellationSignal)
                {
                  Iterator localIterator;
                  Object localObject3;
                  k = i;
                  i = j;
                  j = k;
                  l1 = l2;
                }
              }
              k = j;
              m = i;
              l1 = l2;
              l3 = ((c)localObject2).LGb;
            }
          }
          k = j;
          m = i;
          l1 = l2;
          Log.i("VFS.QuotaFileSystem", "Total size: " + l2 + ", Cleaning threshold: " + QuotaFileSystem.this.LHh);
          k = j;
          m = i;
          l1 = l2;
          QuotaFileSystem.this.k(2, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
          k = j;
          m = i;
          l1 = l2;
          if (l2 > QuotaFileSystem.this.LHh) {
            break;
          }
          k = j;
          m = i;
          l1 = l2;
          Log.i("VFS.QuotaFileSystem", "Threshold not reached, skip cleaning.");
          k = j;
          m = i;
          l1 = l2;
          QuotaFileSystem.this.k(6, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
        }
      }
      if ((i2 & 0x8) != 0)
      {
        k = j;
        m = i;
        l1 = l2;
        localObject2 = new HashMap();
        k = j;
        m = i;
        l1 = l2;
        localIterator = ((List)localObject4).iterator();
        for (;;)
        {
          k = j;
          m = i;
          l1 = l2;
          if (!localIterator.hasNext()) {
            break;
          }
          k = j;
          m = i;
          l1 = l2;
          c localc = (c)localIterator.next();
          k = j;
          m = i;
          l1 = l2;
          if (localc.LGd)
          {
            k = j;
            m = i;
            l1 = l2;
            if (!((HashMap)localObject2).containsKey(localc.Itr))
            {
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(localc.Itr, new QuotaFileSystem.a(localc));
            }
          }
          k = j;
          m = i;
          l1 = l2;
          String str = w.bab(localc.Itr);
          if (str != null)
          {
            k = j;
            m = i;
            l1 = l2;
            localObject3 = (QuotaFileSystem.a)((HashMap)localObject2).get(str);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              k = j;
              m = i;
              l1 = l2;
              localObject1 = new QuotaFileSystem.a(localc);
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(str, localObject1);
            }
            k = j;
            m = i;
            l1 = l2;
            ((QuotaFileSystem.a)localObject1).nZU += 1;
          }
        }
        k = j;
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        localObject1 = localObject2;
        label1367:
        k = j;
        m = i;
        l1 = l2;
        localObject3 = new ArrayList(((List)localObject4).size());
        k = j;
        m = i;
        l1 = l2;
        localObject2 = ((List)localObject4).iterator();
        for (;;)
        {
          k = j;
          m = i;
          l1 = l2;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          k = j;
          m = i;
          l1 = l2;
          localObject4 = (c)((Iterator)localObject2).next();
          k = j;
          m = i;
          l1 = l2;
          if (!((c)localObject4).LGd)
          {
            k = j;
            m = i;
            l1 = l2;
            ((ArrayList)localObject3).add(localObject4);
          }
        }
        k = j;
        m = i;
        l1 = l2;
        Collections.sort((List)localObject3, new Comparator()
        {
          private final long LHk;
        });
        k = j;
        m = i;
        l1 = l2;
        n = ((ArrayList)localObject3).size();
        n -= 1;
        l1 = l2;
        k = i;
        i = j;
        for (;;)
        {
          try
          {
            if ((l1 > QuotaFileSystem.this.LHg) && (n >= 0))
            {
              paramCancellationSignal.throwIfCanceled();
              localObject2 = (c)((ArrayList)localObject3).get(n);
              localObject4 = ((c)localObject2).Itr;
              if (!this.LFY.Dc((String)localObject4)) {
                break label2212;
              }
              if (((c)localObject2).LGb < 0L)
              {
                l2 = ((c)localObject2).size;
                l2 = l1 - l2;
                k -= 1;
                label1633:
                if (localObject1 == null) {
                  break label2209;
                }
                j = i;
                l1 = l2;
                m = k;
              }
            }
            try
            {
              localObject2 = w.bab((String)localObject4);
              if (localObject2 == null) {}
            }
            catch (Exception paramCancellationSignal)
            {
              label1805:
              i = j;
              j = m;
            }
          }
          catch (Exception paramCancellationSignal)
          {
            j = k;
          }
          try
          {
            localObject4 = (QuotaFileSystem.a)((HashMap)localObject1).get(localObject2);
            if (localObject4 != null)
            {
              j = ((QuotaFileSystem.a)localObject4).nZU - 1;
              ((QuotaFileSystem.a)localObject4).nZU = j;
              if ((j == 0) && (this.LFY.dd((String)localObject2, false)))
              {
                if (((QuotaFileSystem.a)localObject4).LHi.LGb < 0L)
                {
                  l1 = ((QuotaFileSystem.a)localObject4).LHi.size;
                  l2 -= l1;
                  i -= 1;
                  j = i;
                  l1 = l2;
                  m = k;
                  ((HashMap)localObject1).remove(localObject2);
                  j = i;
                  l1 = l2;
                  m = k;
                  localObject2 = w.bab((String)localObject2);
                  continue;
                  l2 = ((c)localObject2).LGb;
                  continue;
                }
                l1 = ((QuotaFileSystem.a)localObject4).LHi.LGb;
                continue;
              }
            }
            n -= 1;
            l1 = l2;
          }
          catch (Exception paramCancellationSignal)
          {
            l1 = l2;
            j = k;
          }
        }
        if (localObject1 == null) {
          break label2246;
        }
        localObject1 = ((HashMap)localObject1).values().iterator();
        l2 = l1;
        label1839:
        n = i;
        l3 = l2;
        j = i;
        l1 = l2;
        m = k;
        if (((Iterator)localObject1).hasNext())
        {
          j = i;
          l1 = l2;
          m = k;
          localObject2 = (QuotaFileSystem.a)((Iterator)localObject1).next();
          j = i;
          l1 = l2;
          m = k;
          if (((QuotaFileSystem.a)localObject2).nZU != 0) {
            break label2206;
          }
          j = i;
          l1 = l2;
          m = k;
          paramCancellationSignal.throwIfCanceled();
          j = i;
          l1 = l2;
          m = k;
          if (!this.LFY.dd(((QuotaFileSystem.a)localObject2).LHi.Itr, false)) {
            break label2206;
          }
          j = i;
          l1 = l2;
          m = k;
          if (((QuotaFileSystem.a)localObject2).LHi.LGb < 0L)
          {
            j = i;
            l1 = l2;
            m = k;
            l3 = ((QuotaFileSystem.a)localObject2).LHi.size;
            l1 = l3;
            break label2232;
          }
          j = i;
          l1 = l2;
          m = k;
          l3 = ((QuotaFileSystem.a)localObject2).LHi.LGb;
          l1 = l3;
          break label2232;
        }
      }
      for (;;)
      {
        j = n;
        l1 = l3;
        m = k;
        Log.i("VFS.QuotaFileSystem", "Maintenance done. files: " + k + ", dirs: " + n + ", totalSize: " + l3);
        j = n;
        l1 = l3;
        m = k;
        QuotaFileSystem.this.k(3, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(n), "totalSize", Long.valueOf(l3) });
        break;
        break label151;
        label2157:
        Log.e("VFS.QuotaFileSystem", paramCancellationSignal, "Maintenance failed.");
        k = 5;
        break label201;
        break label151;
        break label151;
        break label151;
        label2206:
        break label2243;
        label2209:
        break label1805;
        label2212:
        l2 = l1;
        break label1633;
        localObject1 = null;
        break label1367;
        label2225:
        i += 1;
        break label817;
        label2232:
        l2 -= l1;
        i -= 1;
        label2243:
        break label1839;
        label2246:
        n = i;
        l3 = l1;
      }
    }
    
    public final ReadableByteChannel aZD(String paramString)
    {
      AppMethodBeat.i(193422);
      ReadableByteChannel localReadableByteChannel = this.LFY.aZD(paramString);
      df(paramString, false);
      AppMethodBeat.o(193422);
      return localReadableByteChannel;
    }
    
    public final ByteChannel aZE(String paramString)
    {
      AppMethodBeat.i(193425);
      ByteChannel localByteChannel = this.LFY.aZE(paramString);
      df(paramString, true);
      AppMethodBeat.o(193425);
      return localByteChannel;
    }
    
    public final WritableByteChannel da(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193424);
      WritableByteChannel localWritableByteChannel = this.LFY.da(paramString, paramBoolean);
      df(paramString, true);
      AppMethodBeat.o(193424);
      return localWritableByteChannel;
    }
    
    public final OutputStream db(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193423);
      OutputStream localOutputStream = this.LFY.db(paramString, paramBoolean);
      df(paramString, true);
      AppMethodBeat.o(193423);
      return localOutputStream;
    }
    
    public final FileSystem fSK()
    {
      return QuotaFileSystem.this;
    }
    
    public final List<FileSystem.b> fSM()
    {
      return this.LFZ;
    }
    
    public final FileSystem.b gU(String paramString, int paramInt)
    {
      return this.LFY;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(193428);
      for (;;)
      {
        synchronized (this.LFI)
        {
          if (this.LFJ.isEmpty()) {
            break label152;
          }
          paramMessage = this.LFJ;
          this.LFJ = new HashMap();
          if (paramMessage == null) {
            break label144;
          }
          ??? = paramMessage.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.LFY.cp((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
        }
        Log.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label144:
        AppMethodBeat.o(193428);
        return true;
        label152:
        paramMessage = null;
      }
    }
    
    public final ParcelFileDescriptor mA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(193426);
      ParcelFileDescriptor localParcelFileDescriptor = this.LFY.mA(paramString1, paramString2);
      df(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(193426);
      return localParcelFileDescriptor;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(193421);
      InputStream localInputStream = this.LFY.openRead(paramString);
      df(paramString, false);
      AppMethodBeat.o(193421);
      return localInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */