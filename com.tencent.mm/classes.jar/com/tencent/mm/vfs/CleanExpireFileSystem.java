package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ab;
import d.n.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class CleanExpireFileSystem
  extends DelegateFileSystem
  implements Handler.Callback
{
  public static final Parcelable.Creator<CleanExpireFileSystem> CREATOR;
  private final FileSystem JrA;
  private final Iterable<FileSystem> JrB;
  private final boolean JrC;
  private final Object JrD;
  private HashMap<String, Long> JrE;
  private final Handler JrF;
  private final long JrG;
  private final long lum;
  
  static
  {
    AppMethodBeat.i(206955);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(206955);
  }
  
  protected CleanExpireFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(206940);
    this.JrD = new Object();
    this.JrG = 60000L;
    q.a(paramParcel, CleanExpireFileSystem.class, 1);
    this.JrA = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.JrA == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(206940);
      throw paramParcel;
    }
    this.JrB = Collections.singletonList(this.JrA);
    long l = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.JrC = bool;
      this.lum = BC(l);
      if (!this.JrC) {
        break;
      }
      this.JrE = new HashMap();
      this.JrF = new Handler(a.ghk().KgB.getLooper(), this);
      AppMethodBeat.o(206940);
      return;
    }
    this.JrE = null;
    this.JrF = null;
    AppMethodBeat.o(206940);
  }
  
  public CleanExpireFileSystem(FileSystem paramFileSystem)
  {
    AppMethodBeat.i(206939);
    this.JrD = new Object();
    this.JrG = 60000L;
    this.JrA = paramFileSystem;
    this.JrB = Collections.singletonList(this.JrA);
    this.JrC = true;
    this.lum = BC(604800000L);
    if (this.JrC)
    {
      this.JrE = new HashMap();
      this.JrF = new Handler(a.ghk().KgB.getLooper(), this);
      AppMethodBeat.o(206939);
      return;
    }
    this.JrE = null;
    this.JrF = null;
    AppMethodBeat.o(206939);
  }
  
  private static long BC(long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(206941);
    paramLong = bs.getLong(b.cmk().b("clicfg_clean_expire_default_expire_time", Long.toString(paramLong), false, true), paramLong);
    long l;
    if (bs.getInt(b.cmk().b("clicfg_clean_expire_need_reset_expire_time", "0", false, true), 0) > 0)
    {
      aw localaw = aw.aKT("CleanExpireFileSystem");
      l = localaw.getLong("CleanExpireCurrentExpireTime", 0L);
      if ((l > 0L) && (l <= paramLong) && (i == 0)) {
        break label98;
      }
      localaw.encode("CleanExpireCurrentExpireTime", paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(206941);
      return paramLong;
      i = 0;
      break;
      label98:
      paramLong = l;
    }
  }
  
  @TargetApi(21)
  private static long b(FileSystem.a parama)
  {
    AppMethodBeat.i(210313);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (parama.Jsh != null)
      {
        localObject1 = localObject2;
        if ((parama.Jsh instanceof NativeFileSystem)) {
          localObject1 = Os.stat(((NativeFileSystem)parama.Jsh).JsQ + '/' + parama.Gnx);
        }
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(210313);
        return -1L;
      }
      long l = ((StructStat)localObject1).st_ctime;
      AppMethodBeat.o(210313);
      return l;
    }
    catch (ErrnoException parama)
    {
      AppMethodBeat.o(210313);
    }
    return -1L;
  }
  
  private void cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206942);
    if (!this.JrC)
    {
      AppMethodBeat.o(206942);
      return;
    }
    if (paramBoolean) {
      synchronized (this.JrD)
      {
        this.JrE.remove(paramString);
        AppMethodBeat.o(206942);
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
      AppMethodBeat.o(206942);
      return;
    }
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(206949);
    k(1, new Object[0]);
    Object localObject1;
    if (this.JrC)
    {
      localObject1 = null;
      synchronized (this.JrD)
      {
        if (!this.JrE.isEmpty())
        {
          localObject1 = this.JrE;
          this.JrE = new HashMap();
        }
        if (localObject1 != null)
        {
          localObject1 = ((HashMap)localObject1).entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            ??? = (Map.Entry)((Iterator)localObject1).next();
            paramCancellationSignal.throwIfCanceled();
            this.JrA.ch((String)((Map.Entry)???).getKey(), ((Long)((Map.Entry)???).getValue()).longValue());
          }
        }
      }
    }
    paramCancellationSignal.throwIfCanceled();
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    int j = -1;
    Object localObject6 = aw.aKT("CleanExpireFileSystem");
    long l2 = ((aw)localObject6).getLong("CleanExpireCurrentExpireTime", 0L);
    long l5 = System.currentTimeMillis();
    int m = com.tencent.mm.storage.ac.eZV().getCount();
    int n = bs.getInt(b.cmk().b("clicfg_clean_expire_storage_min", "100", false, true), 100);
    int i;
    float f2;
    if (m > n)
    {
      localObject1 = com.tencent.mm.storage.ac.eZV();
      ??? = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "id", "CleanDeleteItem" });
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount:".concat(String.valueOf(???)));
      localObject1 = ((com.tencent.mm.storage.ac)localObject1).db.rawQuery((String)???, null);
      i = 0;
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
        i = 0;
      }
      for (;;)
      {
        f2 = i * 1000000.0F / m;
        i = bs.getInt(b.cmk().b("clicfg_clean_expire_repetition_ratio_list_size", "28", false, true), 28);
        ??? = ((aw)localObject6).getString("CleanExpireRepetitionRatioList", "");
        localObject1 = new wr();
        if (!bs.isNullOrNil((String)???)) {}
        try
        {
          ((wr)localObject1).parseFrom(((String)???).getBytes("ISO-8859-1"));
          if (((wr)localObject1).EqR == null) {
            ((wr)localObject1).EqR = new LinkedList();
          }
          while (((wr)localObject1).EqR.size() > i)
          {
            ((wr)localObject1).EqR.removeFirst();
            continue;
            if (((Cursor)localObject1).moveToFirst()) {
              i = ((Cursor)localObject1).getInt(0);
            }
            ((Cursor)localObject1).close();
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount, count:%d,", new Object[] { Integer.valueOf(i) });
          }
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException1.getMessage() });
          }
          ((wr)localObject1).EqR.add(Float.valueOf(f2));
        }
      }
    }
    for (;;)
    {
      try
      {
        ((aw)localObject6).encode("CleanExpireRepetitionRatioList", new String(((wr)localObject1).toByteArray(), d.ISO_8859_1));
        k = bs.getInt(b.cmk().b("clicfg_clean_expire_change_switch", "0", false, true), 0);
        l4 = bs.getLong(b.cmk().b("clicfg_clean_expire_default_expire_time", Long.toString(604800000L), false, true), 604800000L);
        if (k > 0)
        {
          f1 = 0.0F;
          if (k == 1)
          {
            f1 = bs.getFloat(b.cmk().b("clicfg_clean_expire_repetition_ratio_left_range", "0.009", false, true), 0.009F) * 1000000.0F;
            d = bs.getFloat(b.cmk().b("clicfg_clean_expire_repetition_ratio_right_range", "0.011", false, true), 0.011F) * 1000000.0F;
            l3 = bs.getLong(b.cmk().b("clicfg_clean_expire_time_change_threshold", Long.valueOf(259200000L).toString(), false, true), 259200000L);
            l1 = ((aw)localObject6).getLong("CleanExpireCurrentExpireTime", 0L);
            if (l1 > 0L)
            {
              l2 = l1;
              if (l1 <= l4) {}
            }
            else
            {
              ((aw)localObject6).encode("CleanExpireCurrentExpireTime", l4);
              l2 = l4;
            }
            if (f2 <= d) {
              continue;
            }
            l1 = 86400000L + l2;
            if (l1 <= l4) {
              continue;
            }
            l1 = l4;
            i = 1;
            ((aw)localObject6).encode("CleanExpireCurrentExpireTime", l1);
            com.tencent.mm.storage.ac.eZV().a(l4, localPLong1, localPLong2);
            localObject1 = com.tencent.mm.storage.ac.eZV();
            Object localObject3 = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s WHERE %s >= %d GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "saveTime", Long.valueOf(l4), "id", "CleanDeleteItem" });
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount:".concat(String.valueOf(localObject3)));
            localObject1 = ((com.tencent.mm.storage.ac)localObject1).db.rawQuery((String)localObject3, null);
            j = 0;
            if (localObject1 != null) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
            j = 0;
            l2 = j;
            if (m <= n) {
              continue;
            }
            f1 = (float)l2 * 1000000.0F / m;
            j = k;
            l2 = l1;
            l6 = System.currentTimeMillis();
            l7 = System.currentTimeMillis();
            localObject1 = this.JrA.cT("", true);
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            l1 = 0L;
            l3 = l1;
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject3 = (FileSystem.a)((Iterator)localObject1).next();
            if ((((FileSystem.a)localObject3).Jsg) || (((FileSystem.a)localObject3).Jsf > l7 - l2)) {
              continue;
            }
            long l8 = b((FileSystem.a)localObject3);
            l3 = l1;
            if (((FileSystem.a)localObject3).delete())
            {
              if (((FileSystem.a)localObject3).Jse >= 0L) {
                continue;
              }
              l4 = ((FileSystem.a)localObject3).size;
              l1 += l4;
              l3 = l1;
              if (!((FileSystem.a)localObject3).name.endsWith(".nomedia"))
              {
                localObject6 = new ab();
                ((ab)localObject6).field_createTime = l8;
                if (((ab)localObject6).field_createTime < 0L) {
                  ((ab)localObject6).field_createTime = ((FileSystem.a)localObject3).Jsf;
                }
                ((ab)localObject6).field_modifyTime = ((FileSystem.a)localObject3).Jsf;
                ((ab)localObject6).field_deleteTime = System.currentTimeMillis();
                ((ab)localObject6).field_id = ((FileSystem.a)localObject3).name;
                ((ab)localObject6).field_saveTime = (((ab)localObject6).field_deleteTime - ((ab)localObject6).field_createTime);
                ((ab)localObject6).field_size = l4;
                ((ab)localObject6).field_flags = 0L;
                com.tencent.mm.storage.ac.eZV().insert((c)localObject6);
                l3 = l1;
              }
            }
            l1 = l3;
            continue;
          }
        }
      }
      catch (IOException localIOException2)
      {
        long l4;
        long l3;
        long l6;
        long l7;
        com.tencent.mm.sdk.platformtools.ac.e("VFS.CleanExpireFileSystem", "toByteArray Failed: %s", new Object[] { localIOException2.getMessage() });
        continue;
        if (k == 2)
        {
          if (((wr)localObject1).EqR == null)
          {
            Object localObject4 = ((aw)localObject6).getString("CleanExpireRepetitionRatioList", "");
            localObject1 = new wr();
            if (!bs.isNullOrNil((String)localObject4)) {}
            Object localObject5;
            try
            {
              ((wr)localObject1).parseFrom(((String)localObject4).getBytes("ISO-8859-1"));
              if (((wr)localObject1).EqR == null) {
                ((wr)localObject1).EqR = new LinkedList();
              }
              i = ((wr)localObject1).EqR.size();
              f1 = 0.0F;
              if (i <= 0) {
                continue;
              }
              localObject7 = ((wr)localObject1).EqR.iterator();
              localObject4 = Float.valueOf(0.0F);
              if (((Iterator)localObject7).hasNext())
              {
                Float localFloat = (Float)((Iterator)localObject7).next();
                f1 = ((Float)localObject4).floatValue();
                localObject4 = Float.valueOf(localFloat.floatValue() + f1);
                continue;
              }
            }
            catch (IOException localIOException3)
            {
              Object localObject7;
              com.tencent.mm.sdk.platformtools.ac.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException3.getMessage() });
              continue;
              f1 = localIOException3.floatValue() / i;
              localObject5 = ((wr)localObject1).EqR.iterator();
              localObject1 = Double.valueOf(0.0D);
              if (((Iterator)localObject5).hasNext())
              {
                localObject7 = (Float)((Iterator)localObject5).next();
                d = ((Double)localObject1).doubleValue();
                localObject1 = Double.valueOf(Math.pow(((Float)localObject7).floatValue() - f1, 2.0D) + d);
                continue;
              }
              d = Math.sqrt(((Double)localObject1).doubleValue() / i);
            }
            d += f1;
            continue;
            if (f2 < f1)
            {
              j = 2;
              if (l2 > l3)
              {
                l3 = l2 - 86400000L;
                l1 = l3;
                i = j;
                if (l3 >= 0L) {
                  continue;
                }
                l1 = l2;
                i = j;
                continue;
              }
              l3 = 8L * l2 / 9L;
              continue;
            }
            i = 0;
            l1 = l2;
            continue;
            if (((Cursor)localObject1).moveToFirst()) {
              j = ((Cursor)localObject1).getInt(0);
            }
            ((Cursor)localObject1).close();
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount, threshold:%d, count:%d,", new Object[] { Long.valueOf(l4), Integer.valueOf(j) });
            continue;
            l4 = ((FileSystem.a)localObject5).Jse;
            continue;
            l3 = 0L;
            l1 = System.currentTimeMillis();
            l4 = bs.getLong(b.cmk().b("clicfg_clean_expire_storage_count", "20000", false, true), 20000L);
            if (com.tencent.mm.storage.ac.eZV().getCount() > l4)
            {
              localObject1 = com.tencent.mm.storage.ac.eZV();
              l7 = ((com.tencent.mm.storage.ac)localObject1).getCount();
              if (l7 <= l4) {
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CleanDeleteItemStorage", "cleanDate don't need to clean");
              }
              localObject5 = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "CleanDeleteItem", "deleteTime", "deleteTime", "CleanDeleteItem", "deleteTime", Long.valueOf(l7 - l4) });
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.CleanDeleteItemStorage", "cleanData:".concat(String.valueOf(localObject5)));
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CleanDeleteItemStorage", "cleanData result:%b, size:%d, originCount:%d, finalCount:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.storage.ac)localObject1).db.execSQL("CleanDeleteItem", (String)localObject5)), Long.valueOf(l4), Long.valueOf(l7), Integer.valueOf(((com.tencent.mm.storage.ac)localObject1).getCount()) });
            }
            l4 = System.currentTimeMillis();
            k(3, new Object[] { "cleanStorageCount", Integer.valueOf(m), "cleanRepetitionRatio", Float.valueOf(f2), "cleanStorageRepetitionRatio", Float.valueOf(f1), "cleanStorageDeleteSize", Long.valueOf(localPLong1.value), "cleanStorageFreeSize", Long.valueOf(localPLong2.value), "deleteSize", Long.valueOf(l3), "cleanNewExpireTime", Long.valueOf(l2), "cleanExtraCostTime", Long.valueOf(l4 - l1 + (-1L + (l6 - l5))), "cleanTrend", Integer.valueOf(i), "changeSwitch", Integer.valueOf(j) });
            super.a(paramCancellationSignal);
            AppMethodBeat.o(206949);
            return;
            f1 = -1.0F;
            l2 = l1;
            j = k;
            continue;
            i = 1;
            continue;
            d = 0.0D;
            continue;
          }
          continue;
        }
        double d = 0.0D;
        continue;
        long l1 = l2;
        i = j;
        continue;
      }
      int k = -1;
      float f1 = -1.0F;
      f2 = -1.0F;
      i = j;
      j = k;
    }
  }
  
  public final ReadableByteChannel aSc(String paramString)
  {
    AppMethodBeat.i(206944);
    ReadableByteChannel localReadableByteChannel = this.JrA.aSc(paramString);
    cW(paramString, false);
    AppMethodBeat.o(206944);
    return localReadableByteChannel;
  }
  
  public final ByteChannel aSd(String paramString)
  {
    AppMethodBeat.i(206947);
    ByteChannel localByteChannel = this.JrA.aSd(paramString);
    cW(paramString, true);
    AppMethodBeat.o(206947);
    return localByteChannel;
  }
  
  public final WritableByteChannel cR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206946);
    WritableByteChannel localWritableByteChannel = this.JrA.cR(paramString, paramBoolean);
    cW(paramString, true);
    AppMethodBeat.o(206946);
    return localWritableByteChannel;
  }
  
  public final OutputStream cS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206945);
    OutputStream localOutputStream = this.JrA.cS(paramString, paramBoolean);
    cW(paramString, true);
    AppMethodBeat.o(206945);
    return localOutputStream;
  }
  
  public final boolean cU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206954);
    Iterator localIterator = this.JrB.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).cU(paramString, paramBoolean) | bool) {}
    AppMethodBeat.o(206954);
    return bool;
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
    AppMethodBeat.i(206950);
    for (;;)
    {
      synchronized (this.JrD)
      {
        if (this.JrE.isEmpty()) {
          break label153;
        }
        paramMessage = this.JrE;
        this.JrE = new HashMap();
        if (paramMessage == null) {
          break label145;
        }
        ??? = paramMessage.entrySet().iterator();
        if (((Iterator)???).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
          this.JrA.ch((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
        }
      }
      com.tencent.mm.sdk.platformtools.ac.d("VFS.CleanExpireFileSystem", "Flush access time cache entries: " + paramMessage.size());
      label145:
      AppMethodBeat.o(206950);
      return true;
      label153:
      paramMessage = null;
    }
  }
  
  public final ParcelFileDescriptor lT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206948);
    ParcelFileDescriptor localParcelFileDescriptor = this.JrA.lT(paramString1, paramString2);
    cW(paramString1, paramString2.contains("w"));
    AppMethodBeat.o(206948);
    return localParcelFileDescriptor;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(206943);
    InputStream localInputStream = this.JrA.openRead(paramString);
    cW(paramString, false);
    AppMethodBeat.o(206943);
    return localInputStream;
  }
  
  public String toString()
  {
    AppMethodBeat.i(206952);
    String str = "Expire [" + this.JrA.toString() + "]";
    AppMethodBeat.o(206952);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(206951);
    q.b(paramParcel, CleanExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.JrA, paramInt);
    paramParcel.writeLong(this.lum);
    if (this.JrC) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(206951);
      return;
    }
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(206953);
    Iterator localIterator = this.JrB.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).zB(paramString) | bool) {}
    AppMethodBeat.o(206953);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.CleanExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */