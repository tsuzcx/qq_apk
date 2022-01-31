package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.a.b;
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
  public static final Parcelable.Creator<QuotaFileSystem> CREATOR = new Parcelable.Creator() {};
  private final long gPC;
  private final long wvf;
  private final long wvg;
  private final boolean wvh;
  private final Object wvi = new Object();
  private HashMap<String, Long> wvj;
  private final Handler wvk;
  private final long wvl = 60000L;
  
  public QuotaFileSystem(FileSystem paramFileSystem)
  {
    super(paramFileSystem);
    this.wvf = 402653184L;
    this.wvg = 536870912L;
    this.gPC = 7776000000L;
    this.wvh = true;
    if (this.wvh) {
      this.wvj = new HashMap();
    }
    for (this.wvk = new Handler(FileSystemManager.cVw().xvY.getLooper(), this);; this.wvk = null)
    {
      cLn();
      return;
      this.wvj = null;
    }
  }
  
  protected QuotaFileSystem(FileSystem paramFileSystem, Parcel paramParcel)
  {
    super(paramFileSystem);
    this.wvf = paramParcel.readLong();
    this.wvg = paramParcel.readLong();
    this.gPC = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.wvh = bool;
      if (!this.wvh) {
        break label110;
      }
      this.wvj = new HashMap();
    }
    for (this.wvk = new Handler(FileSystemManager.cVw().xvY.getLooper(), this);; this.wvk = null)
    {
      cLn();
      return;
      bool = false;
      break;
      label110:
      this.wvj = null;
    }
  }
  
  private void cLn()
  {
    if (this.wvg < this.wvf) {
      throw new IllegalArgumentException("Cleaning threshold must not less than target size.");
    }
  }
  
  public final OutputStream I(String paramString, boolean paramBoolean)
  {
    OutputStream localOutputStream = this.wuw.I(paramString, paramBoolean);
    if (this.wvh) {
      synchronized (this.wvi)
      {
        this.wvj.remove(paramString);
        return localOutputStream;
      }
    }
    return localOutputStream;
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    long l2 = 0L;
    int i1 = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    int m = n;
    int k = j;
    long l1 = l2;
    int i2;
    label144:
    label194:
    label244:
    Object localObject1;
    Object localObject2;
    Object localObject4;
    label630:
    long l3;
    for (;;)
    {
      try
      {
        i2 = this.wuw.Qd();
        if ((i2 & 0x1) == 0)
        {
          m = n;
          k = j;
          l1 = l2;
          b.w("VFS.QuotaFileSystem", "No quota operation can be done on read-only file system: " + this.wuw.toString());
          this.wuw.a(paramCancellationSignal);
          return;
        }
        if ((i2 & 0x8) != 0) {
          break label244;
        }
        m = n;
        k = j;
        l1 = l2;
        b.w("VFS.QuotaFileSystem", "No quota operation can be done on non-listable file system: " + this.wuw.toString());
        continue;
        if (!(paramCancellationSignal instanceof OperationCanceledException)) {
          break label2067;
        }
      }
      catch (Exception paramCancellationSignal)
      {
        i = m;
      }
      b.i("VFS.QuotaFileSystem", "Maintenance cancelled. files: " + k + ", dirs: " + i + ", totalSize: " + l1);
      j = 4;
      j(j, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l1) });
      throw paramCancellationSignal;
      m = n;
      k = j;
      l1 = l2;
      paramCancellationSignal.throwIfCanceled();
      m = n;
      k = j;
      l1 = l2;
      j(1, new Object[] { "destination", this.wuw });
      m = n;
      k = j;
      l1 = l2;
      if (this.wvh)
      {
        localObject1 = null;
        m = n;
        k = j;
        l1 = l2;
        localObject2 = this.wvi;
        m = n;
        k = j;
        l1 = l2;
        try
        {
          if (!this.wvj.isEmpty())
          {
            localObject1 = this.wvj;
            this.wvj = new HashMap();
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
              this.wuw.r((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
            }
          }
          m = n;
        }
        finally
        {
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
      localObject4 = this.wuw.J("", true);
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
          if (((FileSystem.a)localObject2).wut < 0L)
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
            if (!((FileSystem.a)localObject2).wuv) {
              break label2112;
            }
            i += 1;
            break;
            m = i;
            k = j;
            l1 = l2;
            l3 = ((FileSystem.a)localObject2).wut;
          }
        }
        m = i;
        k = j;
        l1 = l2;
        b.i("VFS.QuotaFileSystem", "Total size: " + l2 + ", Cleaning threshold: " + this.wvg);
        m = i;
        k = j;
        l1 = l2;
        j(2, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l2) });
        m = i;
        k = j;
        l1 = l2;
        if (l2 > this.wvg) {
          break;
        }
        m = i;
        k = j;
        l1 = l2;
        b.i("VFS.QuotaFileSystem", "Threshold not reached, skip cleaning.");
        m = i;
        k = j;
        l1 = l2;
        j(6, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l2) });
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
        if (locala.wuv)
        {
          m = i;
          k = j;
          l1 = l2;
          if (!((HashMap)localObject2).containsKey(locala.wus))
          {
            m = i;
            k = j;
            l1 = l2;
            ((HashMap)localObject2).put(locala.wus, new a(locala));
          }
        }
        m = i;
        k = j;
        l1 = l2;
        String str = j.afa(locala.wus);
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
          ((a)localObject1).hYe += 1;
        }
      }
      m = i;
      k = j;
      l1 = l2;
      paramCancellationSignal.throwIfCanceled();
      localObject1 = localObject2;
      label1284:
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
        if (!((FileSystem.a)localObject4).wuv)
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
        private final long wvm = System.currentTimeMillis() - QuotaFileSystem.a(QuotaFileSystem.this);
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
          if ((l1 > this.wvf) && (n >= 0))
          {
            paramCancellationSignal.throwIfCanceled();
            localObject2 = (FileSystem.a)((ArrayList)localObject3).get(n);
            localObject4 = ((FileSystem.a)localObject2).wus;
            if (!this.wuw.jJ((String)localObject4)) {
              break label2099;
            }
            if (((FileSystem.a)localObject2).wut < 0L)
            {
              l2 = ((FileSystem.a)localObject2).size;
              l2 = l1 - l2;
              k -= 1;
              label1545:
              if (localObject1 == null) {
                break label2096;
              }
              j = i;
              l1 = l2;
              m = k;
            }
          }
          try
          {
            localObject2 = j.afa((String)localObject4);
            if (localObject2 == null) {}
          }
          catch (Exception paramCancellationSignal)
          {
            label1717:
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
            j = ((a)localObject4).hYe - 1;
            ((a)localObject4).hYe = j;
            if ((j == 0) && (this.wuw.K((String)localObject2, false)))
            {
              if (((a)localObject4).wvo.wut < 0L)
              {
                l1 = ((a)localObject4).wvo.size;
                l2 -= l1;
                i -= 1;
                j = i;
                l1 = l2;
                m = k;
                ((HashMap)localObject1).remove(localObject2);
                j = i;
                l1 = l2;
                m = k;
                localObject2 = j.afa((String)localObject2);
                continue;
                l2 = ((FileSystem.a)localObject2).wut;
                continue;
              }
              l1 = ((a)localObject4).wvo.wut;
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
        break label2133;
      }
      localObject1 = ((HashMap)localObject1).values().iterator();
      l2 = l1;
      label1751:
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
        if (((a)localObject2).hYe != 0) {
          break label2093;
        }
        j = i;
        l1 = l2;
        m = k;
        paramCancellationSignal.throwIfCanceled();
        j = i;
        l1 = l2;
        m = k;
        if (!this.wuw.K(((a)localObject2).wvo.wus, false)) {
          break label2093;
        }
        j = i;
        l1 = l2;
        m = k;
        if (((a)localObject2).wvo.wut < 0L)
        {
          j = i;
          l1 = l2;
          m = k;
          l3 = ((a)localObject2).wvo.size;
          l1 = l3;
          break label2119;
        }
        j = i;
        l1 = l2;
        m = k;
        l3 = ((a)localObject2).wvo.wut;
        l1 = l3;
        break label2119;
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
      j(3, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(n), "totalSize", Long.valueOf(l3) });
      break;
      break label144;
      label2067:
      b.b("VFS.QuotaFileSystem", paramCancellationSignal, "Maintenance failed.");
      j = 5;
      break label194;
      break label144;
      break label144;
      label2093:
      break label2130;
      label2096:
      break label1717;
      label2099:
      l2 = l1;
      break label1545;
      localObject1 = null;
      break label1284;
      label2112:
      j += 1;
      break label630;
      label2119:
      l2 -= l1;
      i -= 1;
      label2130:
      break label1751;
      label2133:
      n = i;
      l3 = l1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      synchronized (this.wvi)
      {
        if (this.wvj.isEmpty()) {
          break label134;
        }
        paramMessage = this.wvj;
        this.wvj = new HashMap();
        if (paramMessage == null) {
          break label132;
        }
        ??? = paramMessage.entrySet().iterator();
        if (((Iterator)???).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
          this.wuw.r((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
        }
      }
      b.d("VFS.QuotaFileSystem", "Flush access time cache entries: " + paramMessage.size());
      label132:
      return true;
      label134:
      paramMessage = null;
    }
  }
  
  public final InputStream openRead(String paramString)
  {
    InputStream localInputStream = this.wuw.openRead(paramString);
    long l;
    if (this.wvh) {
      l = System.currentTimeMillis();
    }
    synchronized (this.wvi)
    {
      boolean bool = this.wvj.isEmpty();
      this.wvj.put(paramString, Long.valueOf(l));
      if (bool) {
        this.wvk.sendMessageDelayed(Message.obtain(), 60000L);
      }
      return localInputStream;
    }
  }
  
  public String toString()
  {
    long l = this.wvf / 1024L / 1024L;
    return "QuotaFS [" + l + "MB | " + this.wuw.toString() + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(1);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.wvf);
    paramParcel.writeLong(this.wvg);
    paramParcel.writeLong(this.gPC);
    if (this.wvh) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
  
  private static final class a
  {
    int hYe;
    FileSystem.a wvo;
    
    a(FileSystem.a parama)
    {
      this.wvo = parama;
      this.hYe = 0;
    }
    
    public final String toString()
    {
      return "children: " + this.hYe + " [" + this.wvo + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */