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
import java.util.Map.Entry;
import java.util.Set;

public class QuotaFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<QuotaFileSystem> CREATOR;
  protected final FileSystem agvG;
  protected final boolean agvN;
  protected final long agwK;
  protected final long agyS;
  protected final long tkZ;
  
  static
  {
    AppMethodBeat.i(13202);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13202);
  }
  
  protected QuotaFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13189);
    ah.a(paramParcel, QuotaFileSystem.class, 2);
    this.agvG = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.agvG == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13189);
      throw paramParcel;
    }
    this.agwK = paramParcel.readLong();
    this.agyS = paramParcel.readLong();
    this.tkZ = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.agvN = bool;
      jKH();
      AppMethodBeat.o(13189);
      return;
    }
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(170157);
    this.agvG = paramFileSystem;
    this.agwK = paramLong1;
    this.agyS = paramLong2;
    this.tkZ = paramLong3;
    this.agvN = true;
    jKH();
    AppMethodBeat.o(170157);
  }
  
  private void jKH()
  {
    AppMethodBeat.i(13190);
    if (this.agyS < this.agwK)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
      AppMethodBeat.o(13190);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(13190);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238196);
    if (!(paramObject instanceof QuotaFileSystem))
    {
      AppMethodBeat.o(238196);
      return false;
    }
    paramObject = (QuotaFileSystem)paramObject;
    if ((this.agvG.equals(paramObject.agvG)) && (this.agwK == paramObject.agwK) && (this.agyS == paramObject.agyS) && (this.agvN == paramObject.agvN))
    {
      AppMethodBeat.o(238196);
      return true;
    }
    AppMethodBeat.o(238196);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(238186);
    int i = QuotaFileSystem.class.hashCode();
    int j = ah.hash(new Object[] { this.agvG, Long.valueOf(this.agwK), Long.valueOf(this.agyS), Long.valueOf(this.tkZ), Boolean.valueOf(this.agvN) });
    AppMethodBeat.o(238186);
    return i ^ j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13200);
    long l = this.agwK / 1024L / 1024L;
    String str = "Quota [" + l + "MB | " + this.agvG.toString() + "]";
    AppMethodBeat.o(13200);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13201);
    ah.b(paramParcel, QuotaFileSystem.class, 2);
    paramParcel.writeParcelable(this.agvG, paramInt);
    paramParcel.writeLong(this.agwK);
    paramParcel.writeLong(this.agyS);
    paramParcel.writeLong(this.tkZ);
    if (this.agvN) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(13201);
      return;
    }
  }
  
  protected class b
    extends f
    implements Handler.Callback
  {
    private final Object agvP;
    private HashMap<String, Long> agvQ;
    private final Handler agvR;
    protected final FileSystem.b agwv;
    protected final List<FileSystem.b> agxd;
    
    b(FileSystem.b paramb)
    {
      AppMethodBeat.i(238359);
      this.agvP = new Object();
      this.agwv = paramb;
      this.agxd = Collections.singletonList(paramb);
      if (QuotaFileSystem.this.agvN)
      {
        this.agvQ = new HashMap();
        this.agvR = new Handler(k.kMs().akmy.getLooper(), this);
        AppMethodBeat.o(238359);
        return;
      }
      this.agvQ = null;
      this.agvR = null;
      AppMethodBeat.o(238359);
    }
    
    private void ey(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238364);
      if (!QuotaFileSystem.this.agvN)
      {
        AppMethodBeat.o(238364);
        return;
      }
      if (paramBoolean) {
        synchronized (this.agvP)
        {
          this.agvQ.remove(paramString);
          AppMethodBeat.o(238364);
          return;
        }
      }
      long l = System.currentTimeMillis();
      synchronized (this.agvP)
      {
        paramBoolean = this.agvQ.isEmpty();
        this.agvQ.put(paramString, Long.valueOf(l));
        if (paramBoolean) {
          this.agvR.sendMessageDelayed(Message.obtain(), 60000L);
        }
        AppMethodBeat.o(238364);
        return;
      }
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(238379);
      InputStream localInputStream = this.agwv.Lh(paramString);
      ey(paramString, false);
      AppMethodBeat.o(238379);
      return localInputStream;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238433);
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
          i2 = this.agwv.jKc();
          if ((i2 & 0x1) == 0)
          {
            k = n;
            m = i;
            l1 = l2;
            Log.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.agwv.toString());
            super.a(paramCancellationSignal);
            AppMethodBeat.o(238433);
            return;
          }
          if ((i2 & 0x4) != 0) {
            break label259;
          }
          k = n;
          m = i;
          l1 = l2;
          Log.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.agwv.toString());
          continue;
          if (!(paramCancellationSignal instanceof OperationCanceledException)) {
            break label2166;
          }
        }
        catch (Exception paramCancellationSignal)
        {
          j = m;
          i = k;
        }
        Log.i("VFS.QuotaFileSystem", "Maintenance cancelled. files: " + j + ", dirs: " + i + ", totalSize: " + l1);
        k = 4;
        QuotaFileSystem.this.l(k, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l1) });
        AppMethodBeat.o(238433);
        throw paramCancellationSignal;
        k = n;
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        k = n;
        m = i;
        l1 = l2;
        QuotaFileSystem.this.l(1, new Object[] { "destination", this.agwv });
        k = n;
        m = i;
        l1 = l2;
        if (QuotaFileSystem.this.agvN)
        {
          localObject1 = null;
          k = n;
          m = i;
          l1 = l2;
          localObject2 = this.agvP;
          k = n;
          m = i;
          l1 = l2;
          try
          {
            if (!this.agvQ.isEmpty())
            {
              localObject1 = this.agvQ;
              this.agvQ = new HashMap();
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
                this.agwv.cF((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
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
            AppMethodBeat.o(238433);
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
        localObject1 = ah.a(this.agwv, "");
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
            localObject2 = (j)((Iterator)localObject1).next();
            k = j;
            m = i;
            l1 = l2;
            paramCancellationSignal.throwIfCanceled();
            k = j;
            m = i;
            l1 = l2;
            if (((j)localObject2).agxf < 0L)
            {
              k = j;
              m = i;
              l1 = l2;
              l3 = ((j)localObject2).size;
            }
            for (l1 = l3;; l1 = l3)
            {
              for (;;)
              {
                l2 += l1;
                k = j;
                m = i;
                l1 = l2;
                boolean bool = ((j)localObject2).agxh;
                if (!bool) {
                  break label2234;
                }
                j += 1;
                try
                {
                  label826:
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
              l3 = ((j)localObject2).agxf;
            }
          }
          k = j;
          m = i;
          l1 = l2;
          Log.i("VFS.QuotaFileSystem", "Total size: " + l2 + ", Cleaning threshold: " + QuotaFileSystem.this.agyS);
          k = j;
          m = i;
          l1 = l2;
          QuotaFileSystem.this.l(2, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
          k = j;
          m = i;
          l1 = l2;
          if (l2 > QuotaFileSystem.this.agyS) {
            break;
          }
          k = j;
          m = i;
          l1 = l2;
          Log.i("VFS.QuotaFileSystem", "Threshold not reached, skip cleaning.");
          k = j;
          m = i;
          l1 = l2;
          QuotaFileSystem.this.l(6, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
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
          j localj = (j)localIterator.next();
          k = j;
          m = i;
          l1 = l2;
          if (localj.agxh)
          {
            k = j;
            m = i;
            l1 = l2;
            if (!((HashMap)localObject2).containsKey(localj.acpB))
            {
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(localj.acpB, new QuotaFileSystem.a(localj));
            }
          }
          k = j;
          m = i;
          l1 = l2;
          String str = ah.bEv(localj.acpB);
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
              localObject1 = new QuotaFileSystem.a(localj);
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(str, localObject1);
            }
            k = j;
            m = i;
            l1 = l2;
            ((QuotaFileSystem.a)localObject1).cYv += 1;
          }
        }
        k = j;
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        localObject1 = localObject2;
        label1376:
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
          localObject4 = (j)((Iterator)localObject2).next();
          k = j;
          m = i;
          l1 = l2;
          if (!((j)localObject4).agxh)
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
          private final long agyV;
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
            if ((l1 > QuotaFileSystem.this.agwK) && (n >= 0))
            {
              paramCancellationSignal.throwIfCanceled();
              localObject2 = (j)((ArrayList)localObject3).get(n);
              localObject4 = ((j)localObject2).acpB;
              if (!this.agwv.iP((String)localObject4)) {
                break label2221;
              }
              if (((j)localObject2).agxf < 0L)
              {
                l2 = ((j)localObject2).size;
                l2 = l1 - l2;
                k -= 1;
                label1642:
                if (localObject1 == null) {
                  break label2218;
                }
                j = i;
                l1 = l2;
                m = k;
              }
            }
            try
            {
              localObject2 = ah.bEv((String)localObject4);
              if (localObject2 == null) {}
            }
            catch (Exception paramCancellationSignal)
            {
              label1814:
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
              j = ((QuotaFileSystem.a)localObject4).cYv - 1;
              ((QuotaFileSystem.a)localObject4).cYv = j;
              if ((j == 0) && (this.agwv.ew((String)localObject2, false)))
              {
                if (((QuotaFileSystem.a)localObject4).agyT.agxf < 0L)
                {
                  l1 = ((QuotaFileSystem.a)localObject4).agyT.size;
                  l2 -= l1;
                  i -= 1;
                  j = i;
                  l1 = l2;
                  m = k;
                  ((HashMap)localObject1).remove(localObject2);
                  j = i;
                  l1 = l2;
                  m = k;
                  localObject2 = ah.bEv((String)localObject2);
                  continue;
                  l2 = ((j)localObject2).agxf;
                  continue;
                }
                l1 = ((QuotaFileSystem.a)localObject4).agyT.agxf;
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
          break label2255;
        }
        localObject1 = ((HashMap)localObject1).values().iterator();
        l2 = l1;
        label1848:
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
          if (((QuotaFileSystem.a)localObject2).cYv != 0) {
            break label2215;
          }
          j = i;
          l1 = l2;
          m = k;
          paramCancellationSignal.throwIfCanceled();
          j = i;
          l1 = l2;
          m = k;
          if (!this.agwv.ew(((QuotaFileSystem.a)localObject2).agyT.acpB, false)) {
            break label2215;
          }
          j = i;
          l1 = l2;
          m = k;
          if (((QuotaFileSystem.a)localObject2).agyT.agxf < 0L)
          {
            j = i;
            l1 = l2;
            m = k;
            l3 = ((QuotaFileSystem.a)localObject2).agyT.size;
            l1 = l3;
            break label2241;
          }
          j = i;
          l1 = l2;
          m = k;
          l3 = ((QuotaFileSystem.a)localObject2).agyT.agxf;
          l1 = l3;
          break label2241;
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
        QuotaFileSystem.this.l(3, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(n), "totalSize", Long.valueOf(l3) });
        break;
        break label151;
        label2166:
        Log.e("VFS.QuotaFileSystem", paramCancellationSignal, "Maintenance failed.");
        k = 5;
        break label201;
        break label151;
        break label151;
        break label151;
        label2215:
        break label2252;
        label2218:
        break label1814;
        label2221:
        l2 = l1;
        break label1642;
        localObject1 = null;
        break label1376;
        label2234:
        i += 1;
        break label826;
        label2241:
        l2 -= l1;
        i -= 1;
        label2252:
        break label1848;
        label2255:
        n = i;
        l3 = l1;
      }
    }
    
    public final ReadableByteChannel bDS(String paramString)
    {
      AppMethodBeat.i(238385);
      ReadableByteChannel localReadableByteChannel = this.agwv.bDS(paramString);
      ey(paramString, false);
      AppMethodBeat.o(238385);
      return localReadableByteChannel;
    }
    
    public final ByteChannel bDT(String paramString)
    {
      AppMethodBeat.i(238401);
      ByteChannel localByteChannel = this.agwv.bDT(paramString);
      ey(paramString, true);
      AppMethodBeat.o(238401);
      return localByteChannel;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(238453);
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(238453);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.agwv.equals(paramObject.agwv)) && (QuotaFileSystem.this.agwK == paramObject.agyU.agwK) && (QuotaFileSystem.this.agyS == paramObject.agyU.agyS) && (QuotaFileSystem.this.agvN == paramObject.agyU.agvN))
      {
        AppMethodBeat.o(238453);
        return true;
      }
      AppMethodBeat.o(238453);
      return false;
    }
    
    public final WritableByteChannel et(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238396);
      WritableByteChannel localWritableByteChannel = this.agwv.et(paramString, paramBoolean);
      ey(paramString, true);
      AppMethodBeat.o(238396);
      return localWritableByteChannel;
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238390);
      OutputStream localOutputStream = this.agwv.ev(paramString, paramBoolean);
      ey(paramString, true);
      AppMethodBeat.o(238390);
      return localOutputStream;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(238441);
      for (;;)
      {
        synchronized (this.agvP)
        {
          if (this.agvQ.isEmpty()) {
            break label152;
          }
          paramMessage = this.agvQ;
          this.agvQ = new HashMap();
          if (paramMessage == null) {
            break label144;
          }
          ??? = paramMessage.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.agwv.cF((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
        }
        Log.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label144:
        AppMethodBeat.o(238441);
        return true;
        label152:
        paramMessage = null;
      }
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(238446);
      int i = b.class.hashCode();
      int j = ah.hash(new Object[] { this.agwv, Long.valueOf(QuotaFileSystem.this.agwK), Long.valueOf(QuotaFileSystem.this.agyS), Boolean.valueOf(QuotaFileSystem.this.agvN) });
      AppMethodBeat.o(238446);
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
    
    public final ParcelFileDescriptor qf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238409);
      ParcelFileDescriptor localParcelFileDescriptor = this.agwv.qf(paramString1, paramString2);
      ey(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(238409);
      return localParcelFileDescriptor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */