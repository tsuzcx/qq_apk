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
  protected final boolean RaW;
  protected final FileSystem Rbo;
  protected final long Rby;
  protected final long RcT;
  protected final long nfE;
  
  static
  {
    AppMethodBeat.i(13202);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13202);
  }
  
  protected QuotaFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13189);
    aa.a(paramParcel, QuotaFileSystem.class, 2);
    this.Rbo = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.Rbo == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13189);
      throw paramParcel;
    }
    this.Rby = paramParcel.readLong();
    this.RcT = paramParcel.readLong();
    this.nfE = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.RaW = bool;
      hei();
      AppMethodBeat.o(13189);
      return;
    }
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(13188);
    this.Rbo = paramFileSystem;
    this.Rby = paramLong1;
    this.RcT = paramLong2;
    this.nfE = 7776000000L;
    this.RaW = true;
    hei();
    AppMethodBeat.o(13188);
  }
  
  private void hei()
  {
    AppMethodBeat.i(13190);
    if (this.RcT < this.Rby)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
      AppMethodBeat.o(13190);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(13190);
  }
  
  public final FileSystem.b cj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(187724);
    paramMap = new b(this.Rbo.cj(paramMap));
    AppMethodBeat.o(187724);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13200);
    long l = this.Rby / 1024L / 1024L;
    String str = "QuotaFS [" + l + "MB | " + this.Rbo.toString() + "]";
    AppMethodBeat.o(13200);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13201);
    aa.b(paramParcel, QuotaFileSystem.class, 2);
    paramParcel.writeParcelable(this.Rbo, paramInt);
    paramParcel.writeLong(this.Rby);
    paramParcel.writeLong(this.RcT);
    paramParcel.writeLong(this.nfE);
    if (this.RaW) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(13201);
      return;
    }
  }
  
  static final class a
  {
    final e RcU;
    int bva;
    
    a(e parame)
    {
      this.RcU = parame;
      this.bva = 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13187);
      String str = "children: " + this.bva + " [" + this.RcU + "]";
      AppMethodBeat.o(13187);
      return str;
    }
  }
  
  protected final class b
    extends c
    implements Handler.Callback
  {
    private final Object RaY;
    private HashMap<String, Long> RaZ;
    protected final List<FileSystem.b> RbF;
    private final Handler Rba;
    protected final FileSystem.b Rbp;
    
    b(FileSystem.b paramb)
    {
      AppMethodBeat.i(187714);
      this.RaY = new Object();
      this.Rbp = paramb;
      this.RbF = Collections.singletonList(paramb);
      if (QuotaFileSystem.this.RaW)
      {
        this.RaZ = new HashMap();
        this.Rba = new Handler(g.hRR().Uvj.getLooper(), this);
        AppMethodBeat.o(187714);
        return;
      }
      this.RaZ = null;
      this.Rba = null;
      AppMethodBeat.o(187714);
    }
    
    private void dA(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187715);
      if (!QuotaFileSystem.this.RaW)
      {
        AppMethodBeat.o(187715);
        return;
      }
      if (paramBoolean) {
        synchronized (this.RaY)
        {
          this.RaZ.remove(paramString);
          AppMethodBeat.o(187715);
          return;
        }
      }
      long l = System.currentTimeMillis();
      synchronized (this.RaY)
      {
        paramBoolean = this.RaZ.isEmpty();
        this.RaZ.put(paramString, Long.valueOf(l));
        if (paramBoolean) {
          this.Rba.sendMessageDelayed(Message.obtain(), 60000L);
        }
        AppMethodBeat.o(187715);
        return;
      }
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(187722);
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
          i2 = this.Rbp.hdR();
          if ((i2 & 0x1) == 0)
          {
            k = n;
            m = i;
            l1 = l2;
            Log.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.Rbp.toString());
            super.a(paramCancellationSignal);
            AppMethodBeat.o(187722);
            return;
          }
          if ((i2 & 0x4) != 0) {
            break label259;
          }
          k = n;
          m = i;
          l1 = l2;
          Log.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.Rbp.toString());
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
        QuotaFileSystem.this.l(k, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l1) });
        AppMethodBeat.o(187722);
        throw paramCancellationSignal;
        k = n;
        m = i;
        l1 = l2;
        paramCancellationSignal.throwIfCanceled();
        k = n;
        m = i;
        l1 = l2;
        QuotaFileSystem.this.l(1, new Object[] { "destination", this.Rbp });
        k = n;
        m = i;
        l1 = l2;
        if (QuotaFileSystem.this.RaW)
        {
          localObject1 = null;
          k = n;
          m = i;
          l1 = l2;
          localObject2 = this.RaY;
          k = n;
          m = i;
          l1 = l2;
          try
          {
            if (!this.RaZ.isEmpty())
            {
              localObject1 = this.RaZ;
              this.RaZ = new HashMap();
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
                this.Rbp.ck((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
              }
            }
            k = n;
          }
          finally
          {
            k = n;
            m = i;
            l1 = l2;
            AppMethodBeat.o(187722);
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
        localObject1 = this.Rbp.dx("", true);
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
            localObject2 = (e)((Iterator)localObject1).next();
            k = j;
            m = i;
            l1 = l2;
            paramCancellationSignal.throwIfCanceled();
            k = j;
            m = i;
            l1 = l2;
            if (((e)localObject2).RbH < 0L)
            {
              k = j;
              m = i;
              l1 = l2;
              l3 = ((e)localObject2).size;
            }
            for (l1 = l3;; l1 = l3)
            {
              for (;;)
              {
                l2 += l1;
                k = j;
                m = i;
                l1 = l2;
                boolean bool = ((e)localObject2).RbJ;
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
              l3 = ((e)localObject2).RbH;
            }
          }
          k = j;
          m = i;
          l1 = l2;
          Log.i("VFS.QuotaFileSystem", "Total size: " + l2 + ", Cleaning threshold: " + QuotaFileSystem.this.RcT);
          k = j;
          m = i;
          l1 = l2;
          QuotaFileSystem.this.l(2, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
          k = j;
          m = i;
          l1 = l2;
          if (l2 > QuotaFileSystem.this.RcT) {
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
          e locale = (e)localIterator.next();
          k = j;
          m = i;
          l1 = l2;
          if (locale.RbJ)
          {
            k = j;
            m = i;
            l1 = l2;
            if (!((HashMap)localObject2).containsKey(locale.NGP))
            {
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(locale.NGP, new QuotaFileSystem.a(locale));
            }
          }
          k = j;
          m = i;
          l1 = l2;
          String str = aa.bpg(locale.NGP);
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
              localObject1 = new QuotaFileSystem.a(locale);
              k = j;
              m = i;
              l1 = l2;
              ((HashMap)localObject2).put(str, localObject1);
            }
            k = j;
            m = i;
            l1 = l2;
            ((QuotaFileSystem.a)localObject1).bva += 1;
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
          localObject4 = (e)((Iterator)localObject2).next();
          k = j;
          m = i;
          l1 = l2;
          if (!((e)localObject4).RbJ)
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
          private final long RcW;
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
            if ((l1 > QuotaFileSystem.this.Rby) && (n >= 0))
            {
              paramCancellationSignal.throwIfCanceled();
              localObject2 = (e)((ArrayList)localObject3).get(n);
              localObject4 = ((e)localObject2).NGP;
              if (!this.Rbp.gC((String)localObject4)) {
                break label2212;
              }
              if (((e)localObject2).RbH < 0L)
              {
                l2 = ((e)localObject2).size;
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
              localObject2 = aa.bpg((String)localObject4);
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
              j = ((QuotaFileSystem.a)localObject4).bva - 1;
              ((QuotaFileSystem.a)localObject4).bva = j;
              if ((j == 0) && (this.Rbp.dy((String)localObject2, false)))
              {
                if (((QuotaFileSystem.a)localObject4).RcU.RbH < 0L)
                {
                  l1 = ((QuotaFileSystem.a)localObject4).RcU.size;
                  l2 -= l1;
                  i -= 1;
                  j = i;
                  l1 = l2;
                  m = k;
                  ((HashMap)localObject1).remove(localObject2);
                  j = i;
                  l1 = l2;
                  m = k;
                  localObject2 = aa.bpg((String)localObject2);
                  continue;
                  l2 = ((e)localObject2).RbH;
                  continue;
                }
                l1 = ((QuotaFileSystem.a)localObject4).RcU.RbH;
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
          if (((QuotaFileSystem.a)localObject2).bva != 0) {
            break label2206;
          }
          j = i;
          l1 = l2;
          m = k;
          paramCancellationSignal.throwIfCanceled();
          j = i;
          l1 = l2;
          m = k;
          if (!this.Rbp.dy(((QuotaFileSystem.a)localObject2).RcU.NGP, false)) {
            break label2206;
          }
          j = i;
          l1 = l2;
          m = k;
          if (((QuotaFileSystem.a)localObject2).RcU.RbH < 0L)
          {
            j = i;
            l1 = l2;
            m = k;
            l3 = ((QuotaFileSystem.a)localObject2).RcU.size;
            l1 = l3;
            break label2232;
          }
          j = i;
          l1 = l2;
          m = k;
          l3 = ((QuotaFileSystem.a)localObject2).RcU.RbH;
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
        QuotaFileSystem.this.l(3, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(n), "totalSize", Long.valueOf(l3) });
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
    
    public final ReadableByteChannel boI(String paramString)
    {
      AppMethodBeat.i(187717);
      ReadableByteChannel localReadableByteChannel = this.Rbp.boI(paramString);
      dA(paramString, false);
      AppMethodBeat.o(187717);
      return localReadableByteChannel;
    }
    
    public final ByteChannel boJ(String paramString)
    {
      AppMethodBeat.i(187720);
      ByteChannel localByteChannel = this.Rbp.boJ(paramString);
      dA(paramString, true);
      AppMethodBeat.o(187720);
      return localByteChannel;
    }
    
    public final WritableByteChannel dv(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187719);
      WritableByteChannel localWritableByteChannel = this.Rbp.dv(paramString, paramBoolean);
      dA(paramString, true);
      AppMethodBeat.o(187719);
      return localWritableByteChannel;
    }
    
    public final OutputStream dw(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(187718);
      OutputStream localOutputStream = this.Rbp.dw(paramString, paramBoolean);
      dA(paramString, true);
      AppMethodBeat.o(187718);
      return localOutputStream;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(187723);
      for (;;)
      {
        synchronized (this.RaY)
        {
          if (this.RaZ.isEmpty()) {
            break label152;
          }
          paramMessage = this.RaZ;
          this.RaZ = new HashMap();
          if (paramMessage == null) {
            break label144;
          }
          ??? = paramMessage.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.Rbp.ck((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
        }
        Log.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label144:
        AppMethodBeat.o(187723);
        return true;
        label152:
        paramMessage = null;
      }
    }
    
    public final FileSystem hdQ()
    {
      return QuotaFileSystem.this;
    }
    
    public final List<FileSystem.b> hdS()
    {
      return this.RbF;
    }
    
    public final FileSystem.b ho(String paramString, int paramInt)
    {
      return this.Rbp;
    }
    
    public final ParcelFileDescriptor nr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187721);
      ParcelFileDescriptor localParcelFileDescriptor = this.Rbp.nr(paramString1, paramString2);
      dA(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(187721);
      return localParcelFileDescriptor;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(187716);
      InputStream localInputStream = this.Rbp.openRead(paramString);
      dA(paramString, false);
      AppMethodBeat.o(187716);
      return localInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */