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
  extends DelegateFileSystem
  implements Handler.Callback
{
  public static final Parcelable.Creator<QuotaFileSystem> CREATOR;
  private final FileSystem JrA;
  private final Iterable<FileSystem> JrB;
  private final boolean JrC;
  private final Object JrD;
  private HashMap<String, Long> JrE;
  private final Handler JrF;
  private final long JrG;
  private final long JrH;
  private final long JrI;
  private final long lum;
  
  static
  {
    AppMethodBeat.i(13202);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13202);
  }
  
  protected QuotaFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(13189);
    this.JrD = new Object();
    this.JrG = 60000L;
    q.a(paramParcel, QuotaFileSystem.class, 2);
    this.JrA = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.JrA == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(13189);
      throw paramParcel;
    }
    this.JrB = Collections.singletonList(this.JrA);
    this.JrH = paramParcel.readLong();
    this.JrI = paramParcel.readLong();
    this.lum = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.JrC = bool;
      if (!this.JrC) {
        break label182;
      }
      this.JrE = new HashMap();
    }
    for (this.JrF = new Handler(a.ghk().KgB.getLooper(), this);; this.JrF = null)
    {
      fxP();
      AppMethodBeat.o(13189);
      return;
      bool = false;
      break;
      label182:
      this.JrE = null;
    }
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(13188);
    this.JrD = new Object();
    this.JrG = 60000L;
    this.JrA = paramFileSystem;
    this.JrB = Collections.singletonList(this.JrA);
    this.JrH = paramLong1;
    this.JrI = paramLong2;
    this.lum = 7776000000L;
    this.JrC = true;
    if (this.JrC) {
      this.JrE = new HashMap();
    }
    for (this.JrF = new Handler(a.ghk().KgB.getLooper(), this);; this.JrF = null)
    {
      fxP();
      AppMethodBeat.o(13188);
      return;
      this.JrE = null;
    }
  }
  
  private void cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13191);
    if (!this.JrC)
    {
      AppMethodBeat.o(13191);
      return;
    }
    if (paramBoolean) {
      synchronized (this.JrD)
      {
        this.JrE.remove(paramString);
        AppMethodBeat.o(13191);
        return;
      }
    }
    long l = System.currentTimeMillis();
    synchronized (this.JrD)
    {
      paramBoolean = this.JrE.isEmpty();
      this.JrE.put(paramString, Long.valueOf(l));
      if (paramBoolean) {
        this.JrF.sendMessageDelayed(Message.obtain(), 60000L);
      }
      AppMethodBeat.o(13191);
      return;
    }
  }
  
  private void fxP()
  {
    AppMethodBeat.i(13190);
    if (this.JrI < this.JrH)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
      AppMethodBeat.o(13190);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(13190);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(13198);
    long l2 = 0L;
    int i1 = 0;
    int i = 0;
    int j = 0;
    int n = 0;
    int k = n;
    int m = i;
    long l1 = l2;
    int i2;
    label153:
    label203:
    Object localObject1;
    label259:
    Object localObject2;
    Object localObject4;
    long l3;
    for (;;)
    {
      try
      {
        i2 = this.JrA.fxC();
        if ((i2 & 0x1) == 0)
        {
          k = n;
          m = i;
          l1 = l2;
          Log.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.JrA.toString());
          super.a(paramCancellationSignal);
          AppMethodBeat.o(13198);
          return;
        }
        if ((i2 & 0x4) != 0) {
          break label259;
        }
        k = n;
        m = i;
        l1 = l2;
        Log.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.JrA.toString());
        continue;
        if (!(paramCancellationSignal instanceof OperationCanceledException)) {
          break label2137;
        }
      }
      catch (Exception paramCancellationSignal)
      {
        j = m;
        i = k;
      }
      Log.i("VFS.QuotaFileSystem", "Maintenance cancelled. files: " + j + ", dirs: " + i + ", totalSize: " + l1);
      k = 4;
      k(k, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l1) });
      AppMethodBeat.o(13198);
      throw paramCancellationSignal;
      k = n;
      m = i;
      l1 = l2;
      paramCancellationSignal.throwIfCanceled();
      k = n;
      m = i;
      l1 = l2;
      k(1, new Object[] { "destination", this.JrA });
      k = n;
      m = i;
      l1 = l2;
      if (this.JrC)
      {
        localObject1 = null;
        k = n;
        m = i;
        l1 = l2;
        localObject2 = this.JrD;
        k = n;
        m = i;
        l1 = l2;
        try
        {
          if (!this.JrE.isEmpty())
          {
            localObject1 = this.JrE;
            this.JrE = new HashMap();
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
              this.JrA.ch((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
            }
          }
          k = n;
        }
        finally
        {
          k = n;
          m = i;
          l1 = l2;
          AppMethodBeat.o(13198);
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
      localObject1 = this.JrA.cT("", true);
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
          localObject2 = (FileSystem.a)((Iterator)localObject1).next();
          k = j;
          m = i;
          l1 = l2;
          paramCancellationSignal.throwIfCanceled();
          k = j;
          m = i;
          l1 = l2;
          if (((FileSystem.a)localObject2).Jse < 0L)
          {
            k = j;
            m = i;
            l1 = l2;
            l3 = ((FileSystem.a)localObject2).size;
          }
          for (l1 = l3;; l1 = l3)
          {
            for (;;)
            {
              l2 += l1;
              k = j;
              m = i;
              l1 = l2;
              boolean bool = ((FileSystem.a)localObject2).Jsg;
              if (!bool) {
                break label2205;
              }
              j += 1;
              try
              {
                label815:
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
            l3 = ((FileSystem.a)localObject2).Jse;
          }
        }
        k = j;
        m = i;
        l1 = l2;
        Log.i("VFS.QuotaFileSystem", "Total size: " + l2 + ", Cleaning threshold: " + this.JrI);
        k = j;
        m = i;
        l1 = l2;
        k(2, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
        k = j;
        m = i;
        l1 = l2;
        if (l2 > this.JrI) {
          break;
        }
        k = j;
        m = i;
        l1 = l2;
        Log.i("VFS.QuotaFileSystem", "Threshold not reached, skip cleaning.");
        k = j;
        m = i;
        l1 = l2;
        k(6, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
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
        FileSystem.a locala = (FileSystem.a)localIterator.next();
        k = j;
        m = i;
        l1 = l2;
        if (locala.Jsg)
        {
          k = j;
          m = i;
          l1 = l2;
          if (!((HashMap)localObject2).containsKey(locala.Gnx))
          {
            k = j;
            m = i;
            l1 = l2;
            ((HashMap)localObject2).put(locala.Gnx, new a(locala));
          }
        }
        k = j;
        m = i;
        l1 = l2;
        String str = q.aSz(locala.Gnx);
        if (str != null)
        {
          k = j;
          m = i;
          l1 = l2;
          localObject3 = (a)((HashMap)localObject2).get(str);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            k = j;
            m = i;
            l1 = l2;
            localObject1 = new a(locala);
            k = j;
            m = i;
            l1 = l2;
            ((HashMap)localObject2).put(str, localObject1);
          }
          k = j;
          m = i;
          l1 = l2;
          ((a)localObject1).nts += 1;
        }
      }
      k = j;
      m = i;
      l1 = l2;
      paramCancellationSignal.throwIfCanceled();
      localObject1 = localObject2;
      label1353:
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
        localObject4 = (FileSystem.a)((Iterator)localObject2).next();
        k = j;
        m = i;
        l1 = l2;
        if (!((FileSystem.a)localObject4).Jsg)
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
        private final long JrJ;
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
          if ((l1 > this.JrH) && (n >= 0))
          {
            paramCancellationSignal.throwIfCanceled();
            localObject2 = (FileSystem.a)((ArrayList)localObject3).get(n);
            localObject4 = ((FileSystem.a)localObject2).Gnx;
            if (!this.JrA.zB((String)localObject4)) {
              break label2192;
            }
            if (((FileSystem.a)localObject2).Jse < 0L)
            {
              l2 = ((FileSystem.a)localObject2).size;
              l2 = l1 - l2;
              k -= 1;
              label1616:
              if (localObject1 == null) {
                break label2189;
              }
              j = i;
              l1 = l2;
              m = k;
            }
          }
          try
          {
            localObject2 = q.aSz((String)localObject4);
            if (localObject2 == null) {}
          }
          catch (Exception paramCancellationSignal)
          {
            label1788:
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
          localObject4 = (a)((HashMap)localObject1).get(localObject2);
          if (localObject4 != null)
          {
            j = ((a)localObject4).nts - 1;
            ((a)localObject4).nts = j;
            if ((j == 0) && (this.JrA.cU((String)localObject2, false)))
            {
              if (((a)localObject4).JrL.Jse < 0L)
              {
                l1 = ((a)localObject4).JrL.size;
                l2 -= l1;
                i -= 1;
                j = i;
                l1 = l2;
                m = k;
                ((HashMap)localObject1).remove(localObject2);
                j = i;
                l1 = l2;
                m = k;
                localObject2 = q.aSz((String)localObject2);
                continue;
                l2 = ((FileSystem.a)localObject2).Jse;
                continue;
              }
              l1 = ((a)localObject4).JrL.Jse;
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
        break label2226;
      }
      localObject1 = ((HashMap)localObject1).values().iterator();
      l2 = l1;
      label1822:
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
        localObject2 = (a)((Iterator)localObject1).next();
        j = i;
        l1 = l2;
        m = k;
        if (((a)localObject2).nts != 0) {
          break label2186;
        }
        j = i;
        l1 = l2;
        m = k;
        paramCancellationSignal.throwIfCanceled();
        j = i;
        l1 = l2;
        m = k;
        if (!this.JrA.cU(((a)localObject2).JrL.Gnx, false)) {
          break label2186;
        }
        j = i;
        l1 = l2;
        m = k;
        if (((a)localObject2).JrL.Jse < 0L)
        {
          j = i;
          l1 = l2;
          m = k;
          l3 = ((a)localObject2).JrL.size;
          l1 = l3;
          break label2212;
        }
        j = i;
        l1 = l2;
        m = k;
        l3 = ((a)localObject2).JrL.Jse;
        l1 = l3;
        break label2212;
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
      k(3, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(n), "totalSize", Long.valueOf(l3) });
      break;
      break label153;
      label2137:
      Log.e("VFS.QuotaFileSystem", paramCancellationSignal, "Maintenance failed.");
      k = 5;
      break label203;
      break label153;
      break label153;
      break label153;
      label2186:
      break label2223;
      label2189:
      break label1788;
      label2192:
      l2 = l1;
      break label1616;
      localObject1 = null;
      break label1353;
      label2205:
      i += 1;
      break label815;
      label2212:
      l2 -= l1;
      i -= 1;
      label2223:
      break label1822;
      label2226:
      n = i;
      l3 = l1;
    }
  }
  
  public final ReadableByteChannel aSc(String paramString)
  {
    AppMethodBeat.i(13193);
    ReadableByteChannel localReadableByteChannel = this.JrA.aSc(paramString);
    cW(paramString, false);
    AppMethodBeat.o(13193);
    return localReadableByteChannel;
  }
  
  public final ByteChannel aSd(String paramString)
  {
    AppMethodBeat.i(13196);
    ByteChannel localByteChannel = this.JrA.aSd(paramString);
    cW(paramString, true);
    AppMethodBeat.o(13196);
    return localByteChannel;
  }
  
  public final WritableByteChannel cR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13195);
    WritableByteChannel localWritableByteChannel = this.JrA.cR(paramString, paramBoolean);
    cW(paramString, true);
    AppMethodBeat.o(13195);
    return localWritableByteChannel;
  }
  
  public final OutputStream cS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13194);
    OutputStream localOutputStream = this.JrA.cS(paramString, paramBoolean);
    cW(paramString, true);
    AppMethodBeat.o(13194);
    return localOutputStream;
  }
  
  protected final Iterable<FileSystem> fxD()
  {
    return this.JrB;
  }
  
  protected final FileSystem gn(String paramString, int paramInt)
  {
    return this.JrA;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(13199);
    for (;;)
    {
      synchronized (this.JrD)
      {
        if (this.JrE.isEmpty()) {
          break label152;
        }
        paramMessage = this.JrE;
        this.JrE = new HashMap();
        if (paramMessage == null) {
          break label144;
        }
        ??? = paramMessage.entrySet().iterator();
        if (((Iterator)???).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
          this.JrA.ch((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
        }
      }
      Log.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + paramMessage.size());
      label144:
      AppMethodBeat.o(13199);
      return true;
      label152:
      paramMessage = null;
    }
  }
  
  public final ParcelFileDescriptor lT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13197);
    ParcelFileDescriptor localParcelFileDescriptor = this.JrA.lT(paramString1, paramString2);
    cW(paramString1, paramString2.contains("w"));
    AppMethodBeat.o(13197);
    return localParcelFileDescriptor;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(13192);
    InputStream localInputStream = this.JrA.openRead(paramString);
    cW(paramString, false);
    AppMethodBeat.o(13192);
    return localInputStream;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13200);
    long l = this.JrH / 1024L / 1024L;
    String str = "QuotaFS [" + l + "MB | " + this.JrA.toString() + "]";
    AppMethodBeat.o(13200);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13201);
    q.b(paramParcel, QuotaFileSystem.class, 2);
    paramParcel.writeParcelable(this.JrA, paramInt);
    paramParcel.writeLong(this.JrH);
    paramParcel.writeLong(this.JrI);
    paramParcel.writeLong(this.lum);
    if (this.JrC) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(13201);
      return;
    }
  }
  
  static final class a
  {
    FileSystem.a JrL;
    int nts;
    
    a(FileSystem.a parama)
    {
      this.JrL = parama;
      this.nts = 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13187);
      String str = "children: " + this.nts + " [" + this.JrL + "]";
      AppMethodBeat.o(13187);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */