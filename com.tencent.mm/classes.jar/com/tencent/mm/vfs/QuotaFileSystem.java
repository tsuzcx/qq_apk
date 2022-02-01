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
  protected final FileSystem YBI;
  protected final long YBW;
  protected final boolean YBm;
  protected final long YDw;
  protected final long qgo;
  
  static
  {
    AppMethodBeat.i(13202);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13202);
  }
  
  protected QuotaFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13189);
    ad.a(paramParcel, QuotaFileSystem.class, 2);
    this.YBI = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.YBI == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13189);
      throw paramParcel;
    }
    this.YBW = paramParcel.readLong();
    this.YDw = paramParcel.readLong();
    this.qgo = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.YBm = bool;
      ifs();
      AppMethodBeat.o(13189);
      return;
    }
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(170157);
    this.YBI = paramFileSystem;
    this.YBW = paramLong1;
    this.YDw = paramLong2;
    this.qgo = paramLong3;
    this.YBm = true;
    ifs();
    AppMethodBeat.o(170157);
  }
  
  private void ifs()
  {
    AppMethodBeat.i(13190);
    if (this.YDw < this.YBW)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
      AppMethodBeat.o(13190);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(13190);
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(236534);
    paramMap = new b(this.YBI.cp(paramMap));
    AppMethodBeat.o(236534);
    return paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236532);
    if (!(paramObject instanceof QuotaFileSystem))
    {
      AppMethodBeat.o(236532);
      return false;
    }
    paramObject = (QuotaFileSystem)paramObject;
    if ((this.YBI.equals(paramObject.YBI)) && (this.YBW == paramObject.YBW) && (this.YDw == paramObject.YDw) && (this.YBm == paramObject.YBm))
    {
      AppMethodBeat.o(236532);
      return true;
    }
    AppMethodBeat.o(236532);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(236531);
    int i = QuotaFileSystem.class.hashCode();
    int j = ad.hash(new Object[] { this.YBI, Long.valueOf(this.YBW), Long.valueOf(this.YDw), Long.valueOf(this.qgo), Boolean.valueOf(this.YBm) });
    AppMethodBeat.o(236531);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13200);
    long l = this.YBW / 1024L / 1024L;
    String str = "Quota [" + l + "MB | " + this.YBI.toString() + "]";
    AppMethodBeat.o(13200);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13201);
    ad.b(paramParcel, QuotaFileSystem.class, 2);
    paramParcel.writeParcelable(this.YBI, paramInt);
    paramParcel.writeLong(this.YBW);
    paramParcel.writeLong(this.YDw);
    paramParcel.writeLong(this.qgo);
    if (this.YBm) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(13201);
      return;
    }
  }
  
  protected class b
    extends d
    implements Handler.Callback
  {
    protected final FileSystem.b YBJ;
    private final Object YBo;
    private HashMap<String, Long> YBp;
    private final Handler YBq;
    protected final List<FileSystem.b> YCf;
    
    b(FileSystem.b paramb)
    {
      AppMethodBeat.i(236503);
      this.YBo = new Object();
      this.YBJ = paramb;
      this.YCf = Collections.singletonList(paramb);
      if (QuotaFileSystem.this.YBm)
      {
        this.YBp = new HashMap();
        this.YBq = new Handler(h.iWH().abSU.getLooper(), this);
        AppMethodBeat.o(236503);
        return;
      }
      this.YBp = null;
      this.YBq = null;
      AppMethodBeat.o(236503);
    }
    
    private void dM(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236504);
      if (!QuotaFileSystem.this.YBm)
      {
        AppMethodBeat.o(236504);
        return;
      }
      if (paramBoolean) {
        synchronized (this.YBo)
        {
          this.YBp.remove(paramString);
          AppMethodBeat.o(236504);
          return;
        }
      }
      long l = System.currentTimeMillis();
      synchronized (this.YBo)
      {
        paramBoolean = this.YBp.isEmpty();
        this.YBp.put(paramString, Long.valueOf(l));
        if (paramBoolean) {
          this.YBq.sendMessageDelayed(Message.obtain(), 60000L);
        }
        AppMethodBeat.o(236504);
        return;
      }
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(236506);
      InputStream localInputStream = this.YBJ.Tf(paramString);
      dM(paramString, false);
      AppMethodBeat.o(236506);
      return localInputStream;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(236520);
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
          i2 = this.YBJ.ieY();
          if ((i2 & 0x1) == 0)
          {
            k = n;
            m = i;
            l1 = l2;
            Log.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.YBJ.toString());
            super.a(paramCancellationSignal);
            AppMethodBeat.o(236520);
            return;
          }
          if ((i2 & 0x4) != 0) {
            break label259;
          }
          k = n;
          m = i;
          l1 = l2;
          Log.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.YBJ.toString());
          continue;
          if (!(paramCancellationSignal instanceof OperationCanceledException)) {
            break label2169;
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
        AppMethodBeat.o(236520);
        throw paramCancellationSignal;
        k = n;
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        k = n;
        m = i;
        l1 = l2;
        QuotaFileSystem.this.k(1, new Object[] { "destination", this.YBJ });
        k = n;
        m = i;
        l1 = l2;
        if (QuotaFileSystem.this.YBm)
        {
          localObject1 = null;
          k = n;
          m = i;
          l1 = l2;
          localObject2 = this.YBo;
          k = n;
          m = i;
          l1 = l2;
          try
          {
            if (!this.YBp.isEmpty())
            {
              localObject1 = this.YBp;
              this.YBp = new HashMap();
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
                this.YBJ.ct((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
              }
            }
            k = n;
          }
          finally
          {
            k = n;
            m = i;
            l1 = l2;
            k = n;
            m = i;
            l1 = l2;
            AppMethodBeat.o(236520);
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
        localObject1 = this.YBJ.dJ("", true);
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
            localObject2 = (f)((Iterator)localObject1).next();
            k = j;
            m = i;
            l1 = l2;
            paramCancellationSignal.throwIfCanceled();
            k = j;
            m = i;
            l1 = l2;
            if (((f)localObject2).YCh < 0L)
            {
              k = j;
              m = i;
              l1 = l2;
              l3 = ((f)localObject2).size;
            }
            for (l1 = l3;; l1 = l3)
            {
              for (;;)
              {
                l2 += l1;
                k = j;
                m = i;
                l1 = l2;
                boolean bool = ((f)localObject2).YCj;
                if (!bool) {
                  break label2237;
                }
                j += 1;
                try
                {
                  label829:
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
              l3 = ((f)localObject2).YCh;
            }
          }
          k = j;
          m = i;
          l1 = l2;
          Log.i("VFS.QuotaFileSystem", "Total size: " + l2 + ", Cleaning threshold: " + QuotaFileSystem.this.YDw);
          k = j;
          m = i;
          l1 = l2;
          QuotaFileSystem.this.k(2, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
          k = j;
          m = i;
          l1 = l2;
          if (l2 > QuotaFileSystem.this.YDw) {
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
          f localf = (f)localIterator.next();
          k = j;
          m = i;
          l1 = l2;
          if (localf.YCj)
          {
            k = j;
            m = i;
            l1 = l2;
            if (!((HashMap)localObject2).containsKey(localf.UUr))
            {
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(localf.UUr, new QuotaFileSystem.a(localf));
            }
          }
          k = j;
          m = i;
          l1 = l2;
          String str = ad.bCc(localf.UUr);
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
              localObject1 = new QuotaFileSystem.a(localf);
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(str, localObject1);
            }
            k = j;
            m = i;
            l1 = l2;
            ((QuotaFileSystem.a)localObject1).beC += 1;
          }
        }
        k = j;
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        localObject1 = localObject2;
        label1379:
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
          localObject4 = (f)((Iterator)localObject2).next();
          k = j;
          m = i;
          l1 = l2;
          if (!((f)localObject4).YCj)
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
          private final long YDz;
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
            if ((l1 > QuotaFileSystem.this.YBW) && (n >= 0))
            {
              paramCancellationSignal.throwIfCanceled();
              localObject2 = (f)((ArrayList)localObject3).get(n);
              localObject4 = ((f)localObject2).UUr;
              if (!this.YBJ.ho((String)localObject4)) {
                break label2224;
              }
              if (((f)localObject2).YCh < 0L)
              {
                l2 = ((f)localObject2).size;
                l2 = l1 - l2;
                k -= 1;
                label1645:
                if (localObject1 == null) {
                  break label2221;
                }
                j = i;
                l1 = l2;
                m = k;
              }
            }
            try
            {
              localObject2 = ad.bCc((String)localObject4);
              if (localObject2 == null) {}
            }
            catch (Exception paramCancellationSignal)
            {
              label1817:
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
              j = ((QuotaFileSystem.a)localObject4).beC - 1;
              ((QuotaFileSystem.a)localObject4).beC = j;
              if ((j == 0) && (this.YBJ.dK((String)localObject2, false)))
              {
                if (((QuotaFileSystem.a)localObject4).YDx.YCh < 0L)
                {
                  l1 = ((QuotaFileSystem.a)localObject4).YDx.size;
                  l2 -= l1;
                  i -= 1;
                  j = i;
                  l1 = l2;
                  m = k;
                  ((HashMap)localObject1).remove(localObject2);
                  j = i;
                  l1 = l2;
                  m = k;
                  localObject2 = ad.bCc((String)localObject2);
                  continue;
                  l2 = ((f)localObject2).YCh;
                  continue;
                }
                l1 = ((QuotaFileSystem.a)localObject4).YDx.YCh;
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
          break label2258;
        }
        localObject1 = ((HashMap)localObject1).values().iterator();
        l2 = l1;
        label1851:
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
          if (((QuotaFileSystem.a)localObject2).beC != 0) {
            break label2218;
          }
          j = i;
          l1 = l2;
          m = k;
          paramCancellationSignal.throwIfCanceled();
          j = i;
          l1 = l2;
          m = k;
          if (!this.YBJ.dK(((QuotaFileSystem.a)localObject2).YDx.UUr, false)) {
            break label2218;
          }
          j = i;
          l1 = l2;
          m = k;
          if (((QuotaFileSystem.a)localObject2).YDx.YCh < 0L)
          {
            j = i;
            l1 = l2;
            m = k;
            l3 = ((QuotaFileSystem.a)localObject2).YDx.size;
            l1 = l3;
            break label2244;
          }
          j = i;
          l1 = l2;
          m = k;
          l3 = ((QuotaFileSystem.a)localObject2).YDx.YCh;
          l1 = l3;
          break label2244;
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
        label2169:
        Log.e("VFS.QuotaFileSystem", paramCancellationSignal, "Maintenance failed.");
        k = 5;
        break label201;
        break label151;
        break label151;
        break label151;
        label2218:
        break label2255;
        label2221:
        break label1817;
        label2224:
        l2 = l1;
        break label1645;
        localObject1 = null;
        break label1379;
        label2237:
        i += 1;
        break label829;
        label2244:
        l2 -= l1;
        i -= 1;
        label2255:
        break label1851;
        label2258:
        n = i;
        l3 = l1;
      }
    }
    
    public final ReadableByteChannel bBy(String paramString)
    {
      AppMethodBeat.i(236508);
      ReadableByteChannel localReadableByteChannel = this.YBJ.bBy(paramString);
      dM(paramString, false);
      AppMethodBeat.o(236508);
      return localReadableByteChannel;
    }
    
    public final ByteChannel bBz(String paramString)
    {
      AppMethodBeat.i(236513);
      ByteChannel localByteChannel = this.YBJ.bBz(paramString);
      dM(paramString, true);
      AppMethodBeat.o(236513);
      return localByteChannel;
    }
    
    public final WritableByteChannel dH(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236511);
      WritableByteChannel localWritableByteChannel = this.YBJ.dH(paramString, paramBoolean);
      dM(paramString, true);
      AppMethodBeat.o(236511);
      return localWritableByteChannel;
    }
    
    public final OutputStream dI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(236509);
      OutputStream localOutputStream = this.YBJ.dI(paramString, paramBoolean);
      dM(paramString, true);
      AppMethodBeat.o(236509);
      return localOutputStream;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236526);
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(236526);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.YBJ.equals(paramObject.YBJ)) && (QuotaFileSystem.this.YBW == paramObject.YDy.YBW) && (QuotaFileSystem.this.YDw == paramObject.YDy.YDw) && (QuotaFileSystem.this.YBm == paramObject.YDy.YBm))
      {
        AppMethodBeat.o(236526);
        return true;
      }
      AppMethodBeat.o(236526);
      return false;
    }
    
    public final FileSystem.b hX(String paramString, int paramInt)
    {
      return this.YBJ;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(236522);
      for (;;)
      {
        synchronized (this.YBo)
        {
          if (this.YBp.isEmpty()) {
            break label152;
          }
          paramMessage = this.YBp;
          this.YBp = new HashMap();
          if (paramMessage == null) {
            break label144;
          }
          ??? = paramMessage.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.YBJ.ct((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
        }
        Log.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label144:
        AppMethodBeat.o(236522);
        return true;
        label152:
        paramMessage = null;
      }
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(236524);
      int i = b.class.hashCode();
      int j = ad.hash(new Object[] { this.YBJ, Long.valueOf(QuotaFileSystem.this.YBW), Long.valueOf(QuotaFileSystem.this.YDw), Boolean.valueOf(QuotaFileSystem.this.YBm) });
      AppMethodBeat.o(236524);
      return i ^ j;
    }
    
    public final List<FileSystem.b> ifa()
    {
      return this.YCf;
    }
    
    public final ParcelFileDescriptor oh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(236515);
      ParcelFileDescriptor localParcelFileDescriptor = this.YBJ.oh(paramString1, paramString2);
      dM(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(236515);
      return localParcelFileDescriptor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */