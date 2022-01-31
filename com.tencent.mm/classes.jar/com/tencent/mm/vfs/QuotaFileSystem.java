package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
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
  extends FileSystemWrapper
  implements Handler.Callback
{
  public static final Parcelable.Creator<QuotaFileSystem> CREATOR;
  private final long AQf;
  private final long AQg;
  private final boolean AQh;
  private final Object AQi;
  private HashMap<String, Long> AQj;
  private final Handler AQk;
  private final long AQl;
  private final long irn;
  
  static
  {
    AppMethodBeat.i(54569);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(54569);
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem)
  {
    super(paramFileSystem);
    AppMethodBeat.i(54560);
    this.AQi = new Object();
    this.AQl = 60000L;
    this.AQf = 402653184L;
    this.AQg = 536870912L;
    this.irn = 7776000000L;
    this.AQh = true;
    if (this.AQh) {
      this.AQj = new HashMap();
    }
    for (this.AQk = new Handler(FileSystemManager.dQE().APN.getLooper(), this);; this.AQk = null)
    {
      dQF();
      AppMethodBeat.o(54560);
      return;
      this.AQj = null;
    }
  }
  
  protected QuotaFileSystem(FileSystem paramFileSystem, Parcel paramParcel)
  {
    super(paramFileSystem);
    AppMethodBeat.i(54561);
    this.AQi = new Object();
    this.AQl = 60000L;
    this.AQf = paramParcel.readLong();
    this.AQg = paramParcel.readLong();
    this.irn = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.AQh = bool;
      if (!this.AQh) {
        break label120;
      }
      this.AQj = new HashMap();
    }
    for (this.AQk = new Handler(FileSystemManager.dQE().APN.getLooper(), this);; this.AQk = null)
    {
      dQF();
      AppMethodBeat.o(54561);
      return;
      bool = false;
      break;
      label120:
      this.AQj = null;
    }
  }
  
  private void dQF()
  {
    AppMethodBeat.i(54562);
    if (this.AQg < this.AQf)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cleaning threshold must not less than target size.");
      AppMethodBeat.o(54562);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(54562);
  }
  
  public final OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54564);
    OutputStream localOutputStream = this.APv.M(paramString, paramBoolean);
    if (this.AQh) {}
    synchronized (this.AQi)
    {
      this.AQj.remove(paramString);
      AppMethodBeat.o(54564);
      return localOutputStream;
    }
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(54565);
    long l2 = 0L;
    int i1 = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    int m = n;
    int k = j;
    long l1 = l2;
    int i2;
    label154:
    label204:
    Object localObject1;
    label259:
    Object localObject2;
    Object localObject4;
    label663:
    long l3;
    for (;;)
    {
      try
      {
        i2 = this.APv.ajj();
        if ((i2 & 0x1) == 0)
        {
          m = n;
          k = j;
          l1 = l2;
          b.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.APv.toString());
          this.APv.a(paramCancellationSignal);
          AppMethodBeat.o(54565);
          return;
        }
        if ((i2 & 0x8) != 0) {
          break label259;
        }
        m = n;
        k = j;
        l1 = l2;
        b.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.APv.toString());
        continue;
        if (!(paramCancellationSignal instanceof OperationCanceledException)) {
          break label2100;
        }
      }
      catch (Exception paramCancellationSignal)
      {
        i = m;
      }
      b.i("VFS.QuotaFileSystem", "Maintenance cancelled. files: " + k + ", dirs: " + i + ", totalSize: " + l1);
      j = 4;
      k(j, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l1) });
      AppMethodBeat.o(54565);
      throw paramCancellationSignal;
      m = n;
      k = j;
      l1 = l2;
      paramCancellationSignal.throwIfCanceled();
      m = n;
      k = j;
      l1 = l2;
      k(1, new Object[] { "destination", this.APv });
      m = n;
      k = j;
      l1 = l2;
      if (this.AQh)
      {
        localObject1 = null;
        m = n;
        k = j;
        l1 = l2;
        localObject2 = this.AQi;
        m = n;
        k = j;
        l1 = l2;
        try
        {
          if (!this.AQj.isEmpty())
          {
            localObject1 = this.AQj;
            this.AQj = new HashMap();
          }
          if (localObject1 != null)
          {
            m = n;
            k = j;
            l1 = l2;
            localObject1 = ((HashMap)localObject1).entrySet().iterator();
            for (;;)
            {
              m = n;
              k = j;
              l1 = l2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              m = n;
              k = j;
              l1 = l2;
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              m = n;
              k = j;
              l1 = l2;
              paramCancellationSignal.throwIfCanceled();
              m = n;
              k = j;
              l1 = l2;
              this.APv.A((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
            }
          }
          m = n;
        }
        finally
        {
          m = n;
          k = j;
          l1 = l2;
          AppMethodBeat.o(54565);
          m = n;
          k = j;
          l1 = l2;
        }
      }
      k = j;
      l1 = l2;
      paramCancellationSignal.throwIfCanceled();
      m = n;
      k = j;
      l1 = l2;
      localObject4 = this.APv.N("", true);
      if (localObject4 == null)
      {
        m = n;
        k = j;
        l1 = l2;
        b.e("VFS.QuotaFileSystem", "Unable to list files in FS: " + toString());
      }
      else
      {
        m = n;
        k = j;
        l1 = l2;
        localObject1 = ((List)localObject4).iterator();
        j = i1;
        m = i;
        k = j;
        l1 = l2;
        if (((Iterator)localObject1).hasNext())
        {
          m = i;
          k = j;
          l1 = l2;
          localObject2 = (FileSystem.a)((Iterator)localObject1).next();
          m = i;
          k = j;
          l1 = l2;
          if (((FileSystem.a)localObject2).APs < 0L)
          {
            m = i;
            k = j;
            l1 = l2;
            l3 = ((FileSystem.a)localObject2).size;
          }
          for (l1 = l3;; l1 = l3)
          {
            l2 += l1;
            m = i;
            k = j;
            l1 = l2;
            if (!((FileSystem.a)localObject2).APu) {
              break label2145;
            }
            i += 1;
            break;
            m = i;
            k = j;
            l1 = l2;
            l3 = ((FileSystem.a)localObject2).APs;
          }
        }
        m = i;
        k = j;
        l1 = l2;
        b.i("VFS.QuotaFileSystem", "Total size: " + l2 + ", Cleaning threshold: " + this.AQg);
        m = i;
        k = j;
        l1 = l2;
        k(2, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l2) });
        m = i;
        k = j;
        l1 = l2;
        if (l2 > this.AQg) {
          break;
        }
        m = i;
        k = j;
        l1 = l2;
        b.i("VFS.QuotaFileSystem", "Threshold not reached, skip cleaning.");
        m = i;
        k = j;
        l1 = l2;
        k(6, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l2) });
      }
    }
    m = i;
    k = j;
    l1 = l2;
    paramCancellationSignal.throwIfCanceled();
    if ((i2 & 0x20) != 0)
    {
      m = i;
      k = j;
      l1 = l2;
      localObject2 = new HashMap();
      m = i;
      k = j;
      l1 = l2;
      Iterator localIterator = ((List)localObject4).iterator();
      for (;;)
      {
        m = i;
        k = j;
        l1 = l2;
        if (!localIterator.hasNext()) {
          break;
        }
        m = i;
        k = j;
        l1 = l2;
        FileSystem.a locala = (FileSystem.a)localIterator.next();
        m = i;
        k = j;
        l1 = l2;
        if (locala.APu)
        {
          m = i;
          k = j;
          l1 = l2;
          if (!((HashMap)localObject2).containsKey(locala.APr))
          {
            m = i;
            k = j;
            l1 = l2;
            ((HashMap)localObject2).put(locala.APr, new a(locala));
          }
        }
        m = i;
        k = j;
        l1 = l2;
        String str = j.avQ(locala.APr);
        if (str != null)
        {
          m = i;
          k = j;
          l1 = l2;
          localObject3 = (a)((HashMap)localObject2).get(str);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            m = i;
            k = j;
            l1 = l2;
            localObject1 = new a(locala);
            m = i;
            k = j;
            l1 = l2;
            ((HashMap)localObject2).put(str, localObject1);
          }
          m = i;
          k = j;
          l1 = l2;
          ((a)localObject1).jRS += 1;
        }
      }
      m = i;
      k = j;
      l1 = l2;
      paramCancellationSignal.throwIfCanceled();
      localObject1 = localObject2;
      label1317:
      m = i;
      k = j;
      l1 = l2;
      Object localObject3 = new ArrayList(((List)localObject4).size());
      m = i;
      k = j;
      l1 = l2;
      localObject2 = ((List)localObject4).iterator();
      for (;;)
      {
        m = i;
        k = j;
        l1 = l2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        m = i;
        k = j;
        l1 = l2;
        localObject4 = (FileSystem.a)((Iterator)localObject2).next();
        m = i;
        k = j;
        l1 = l2;
        if (!((FileSystem.a)localObject4).APu)
        {
          m = i;
          k = j;
          l1 = l2;
          ((ArrayList)localObject3).add(localObject4);
        }
      }
      m = i;
      k = j;
      l1 = l2;
      Collections.sort((List)localObject3, new Comparator()
      {
        private final long AQm;
      });
      m = i;
      k = j;
      l1 = l2;
      n = ((ArrayList)localObject3).size();
      n -= 1;
      l1 = l2;
      k = j;
      for (;;)
      {
        try
        {
          if ((l1 > this.AQf) && (n >= 0))
          {
            paramCancellationSignal.throwIfCanceled();
            localObject2 = (FileSystem.a)((ArrayList)localObject3).get(n);
            localObject4 = ((FileSystem.a)localObject2).APr;
            if (!this.APv.qD((String)localObject4)) {
              break label2132;
            }
            if (((FileSystem.a)localObject2).APs < 0L)
            {
              l2 = ((FileSystem.a)localObject2).size;
              l2 = l1 - l2;
              k -= 1;
              label1578:
              if (localObject1 == null) {
                break label2129;
              }
              j = i;
              l1 = l2;
              m = k;
            }
          }
          try
          {
            localObject2 = j.avQ((String)localObject4);
            if (localObject2 == null) {}
          }
          catch (Exception paramCancellationSignal)
          {
            label1750:
            i = j;
            k = m;
          }
        }
        catch (Exception paramCancellationSignal) {}
        try
        {
          localObject4 = (a)((HashMap)localObject1).get(localObject2);
          if (localObject4 != null)
          {
            j = ((a)localObject4).jRS - 1;
            ((a)localObject4).jRS = j;
            if ((j == 0) && (this.APv.O((String)localObject2, false)))
            {
              if (((a)localObject4).AQo.APs < 0L)
              {
                l1 = ((a)localObject4).AQo.size;
                l2 -= l1;
                i -= 1;
                j = i;
                l1 = l2;
                m = k;
                ((HashMap)localObject1).remove(localObject2);
                j = i;
                l1 = l2;
                m = k;
                localObject2 = j.avQ((String)localObject2);
                continue;
                l2 = ((FileSystem.a)localObject2).APs;
                continue;
              }
              l1 = ((a)localObject4).AQo.APs;
              continue;
            }
          }
          n -= 1;
          l1 = l2;
        }
        catch (Exception paramCancellationSignal)
        {
          l1 = l2;
        }
      }
      if (localObject1 == null) {
        break label2166;
      }
      localObject1 = ((HashMap)localObject1).values().iterator();
      l2 = l1;
      label1784:
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
        if (((a)localObject2).jRS != 0) {
          break label2126;
        }
        j = i;
        l1 = l2;
        m = k;
        paramCancellationSignal.throwIfCanceled();
        j = i;
        l1 = l2;
        m = k;
        if (!this.APv.O(((a)localObject2).AQo.APr, false)) {
          break label2126;
        }
        j = i;
        l1 = l2;
        m = k;
        if (((a)localObject2).AQo.APs < 0L)
        {
          j = i;
          l1 = l2;
          m = k;
          l3 = ((a)localObject2).AQo.size;
          l1 = l3;
          break label2152;
        }
        j = i;
        l1 = l2;
        m = k;
        l3 = ((a)localObject2).AQo.APs;
        l1 = l3;
        break label2152;
      }
    }
    for (;;)
    {
      j = n;
      l1 = l3;
      m = k;
      b.i("VFS.QuotaFileSystem", "Maintenance done. files: " + k + ", dirs: " + n + ", totalSize: " + l3);
      j = n;
      l1 = l3;
      m = k;
      k(3, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(n), "totalSize", Long.valueOf(l3) });
      break;
      break label154;
      label2100:
      b.b("VFS.QuotaFileSystem", paramCancellationSignal, "Maintenance failed.");
      j = 5;
      break label204;
      break label154;
      break label154;
      label2126:
      break label2163;
      label2129:
      break label1750;
      label2132:
      l2 = l1;
      break label1578;
      localObject1 = null;
      break label1317;
      label2145:
      j += 1;
      break label663;
      label2152:
      l2 -= l1;
      i -= 1;
      label2163:
      break label1784;
      label2166:
      n = i;
      l3 = l1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(54566);
    for (;;)
    {
      synchronized (this.AQi)
      {
        if (this.AQj.isEmpty()) {
          break label152;
        }
        paramMessage = this.AQj;
        this.AQj = new HashMap();
        if (paramMessage == null) {
          break label144;
        }
        ??? = paramMessage.entrySet().iterator();
        if (((Iterator)???).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
          this.APv.A((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
        }
      }
      b.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + paramMessage.size());
      label144:
      AppMethodBeat.o(54566);
      return true;
      label152:
      paramMessage = null;
    }
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(54563);
    InputStream localInputStream = this.APv.openRead(paramString);
    long l;
    if (this.AQh) {
      l = System.currentTimeMillis();
    }
    synchronized (this.AQi)
    {
      boolean bool = this.AQj.isEmpty();
      this.AQj.put(paramString, Long.valueOf(l));
      if (bool) {
        this.AQk.sendMessageDelayed(Message.obtain(), 60000L);
      }
      AppMethodBeat.o(54563);
      return localInputStream;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(54567);
    long l = this.AQf / 1024L / 1024L;
    String str = "QuotaFS [" + l + "MB | " + this.APv.toString() + "]";
    AppMethodBeat.o(54567);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(54568);
    paramParcel.writeInt(1);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.AQf);
    paramParcel.writeLong(this.AQg);
    paramParcel.writeLong(this.irn);
    if (this.AQh) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(54568);
      return;
    }
  }
  
  static final class a
  {
    FileSystem.a AQo;
    int jRS;
    
    a(FileSystem.a parama)
    {
      this.AQo = parama;
      this.jRS = 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(54559);
      String str = "children: " + this.jRS + " [" + this.AQo + "]";
      AppMethodBeat.o(54559);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */