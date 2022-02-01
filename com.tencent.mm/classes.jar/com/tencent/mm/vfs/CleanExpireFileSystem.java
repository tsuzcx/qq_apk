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
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ag;
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
  private final FileSystem Ljf;
  private final Iterable<FileSystem> Ljg;
  private final boolean Ljh;
  private final Object Lji;
  private HashMap<String, Long> Ljj;
  private final Handler Ljk;
  private final long Ljl;
  private final long lTw;
  
  static
  {
    AppMethodBeat.i(189923);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(189923);
  }
  
  protected CleanExpireFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(189907);
    this.Lji = new Object();
    this.Ljl = 60000L;
    q.a(paramParcel, CleanExpireFileSystem.class, 1);
    this.Ljf = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.Ljf == null)
    {
      paramParcel = new IllegalArgumentException("Wrong wrapped filesystem.");
      AppMethodBeat.o(189907);
      throw paramParcel;
    }
    this.Ljg = Collections.singletonList(this.Ljf);
    long l = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ljh = bool;
      this.lTw = Eu(l);
      if (!this.Ljh) {
        break;
      }
      this.Ljj = new HashMap();
      this.Ljk = new Handler(a.gzU().OfA.getLooper(), this);
      AppMethodBeat.o(189907);
      return;
    }
    this.Ljj = null;
    this.Ljk = null;
    AppMethodBeat.o(189907);
  }
  
  public CleanExpireFileSystem(FileSystem paramFileSystem)
  {
    AppMethodBeat.i(189906);
    this.Lji = new Object();
    this.Ljl = 60000L;
    this.Ljf = paramFileSystem;
    this.Ljg = Collections.singletonList(this.Ljf);
    this.Ljh = true;
    this.lTw = Eu(604800000L);
    if (this.Ljh)
    {
      this.Ljj = new HashMap();
      this.Ljk = new Handler(a.gzU().OfA.getLooper(), this);
      AppMethodBeat.o(189906);
      return;
    }
    this.Ljj = null;
    this.Ljk = null;
    AppMethodBeat.o(189906);
  }
  
  private static long Eu(long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(189908);
    paramLong = bt.getLong(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_default_expire_time", Long.toString(paramLong), false, true), paramLong);
    long l;
    if (bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_need_reset_expire_time", "0", false, true), 0) > 0)
    {
      ax localax = ax.aQz("CleanExpireFileSystem");
      l = localax.getLong("CleanExpireCurrentExpireTime", 0L);
      if ((l > 0L) && (l <= paramLong) && (i == 0)) {
        break label98;
      }
      localax.encode("CleanExpireCurrentExpireTime", paramLong);
    }
    for (;;)
    {
      AppMethodBeat.o(189908);
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
    AppMethodBeat.i(189917);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (parama.LjM != null)
      {
        localObject1 = localObject2;
        if ((parama.LjM instanceof NativeFileSystem)) {
          localObject1 = Os.stat(((NativeFileSystem)parama.LjM).Lkv + '/' + parama.HZk);
        }
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(189917);
        return -1L;
      }
      long l = ((StructStat)localObject1).st_ctime;
      AppMethodBeat.o(189917);
      return l;
    }
    catch (ErrnoException parama)
    {
      AppMethodBeat.o(189917);
    }
    return -1L;
  }
  
  private void db(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189909);
    if (!this.Ljh)
    {
      AppMethodBeat.o(189909);
      return;
    }
    if (paramBoolean) {
      synchronized (this.Lji)
      {
        this.Ljj.remove(paramString);
        AppMethodBeat.o(189909);
        return;
      }
    }
    long l = System.currentTimeMillis();
    synchronized (this.Lji)
    {
      paramBoolean = this.Ljj.isEmpty();
      this.Ljj.put(paramString, Long.valueOf(l));
      if (paramBoolean) {
        this.Ljk.sendMessageDelayed(Message.obtain(), 60000L);
      }
      AppMethodBeat.o(189909);
      return;
    }
  }
  
  public final boolean CA(String paramString)
  {
    AppMethodBeat.i(189921);
    Iterator localIterator = this.Ljg.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).CA(paramString) | bool) {}
    AppMethodBeat.o(189921);
    return bool;
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(189916);
    k(1, new Object[0]);
    Object localObject1;
    if (this.Ljh)
    {
      localObject1 = null;
      synchronized (this.Lji)
      {
        if (!this.Ljj.isEmpty())
        {
          localObject1 = this.Ljj;
          this.Ljj = new HashMap();
        }
        if (localObject1 != null)
        {
          localObject1 = ((HashMap)localObject1).entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            ??? = (Map.Entry)((Iterator)localObject1).next();
            paramCancellationSignal.throwIfCanceled();
            this.Ljf.cn((String)((Map.Entry)???).getKey(), ((Long)((Map.Entry)???).getValue()).longValue());
          }
        }
      }
    }
    paramCancellationSignal.throwIfCanceled();
    int i = 0;
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    int k = -1;
    int m = -1;
    Object localObject6 = ax.aQz("CleanExpireFileSystem");
    long l1 = ((ax)localObject6).getLong("CleanExpireCurrentExpireTime", 0L);
    long l4 = bt.getLong(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_default_expire_time", Long.toString(604800000L), false, true), 604800000L);
    if ((l1 < 0L) || (l1 > l4))
    {
      ((ax)localObject6).encode("CleanExpireCurrentExpireTime", l4);
      l1 = l4;
    }
    for (;;)
    {
      long l6 = System.currentTimeMillis();
      int n = ag.fpX().getCount();
      int i1 = bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_storage_min", "100", false, true), 100);
      float f2;
      int j;
      if (n > i1)
      {
        localObject1 = ag.fpX();
        ??? = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "id", "CleanDeleteItem" });
        ad.d("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount:".concat(String.valueOf(???)));
        localObject1 = ((ag)localObject1).db.rawQuery((String)???, null);
        i = 0;
        if (localObject1 == null)
        {
          ad.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
          i = 0;
        }
        for (;;)
        {
          f2 = i * 1000000.0F / n;
          i = bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_ratio_list_size", "28", false, true), 28);
          ??? = ((ax)localObject6).getString("CleanExpireRepetitionRatioList", "");
          localObject1 = new yq();
          if (!bt.isNullOrNil((String)???)) {}
          try
          {
            ((yq)localObject1).parseFrom(((String)???).getBytes("ISO-8859-1"));
            if (((yq)localObject1).FYb == null) {
              ((yq)localObject1).FYb = new LinkedList();
            }
            while (((yq)localObject1).FYb.size() > i)
            {
              ((yq)localObject1).FYb.removeFirst();
              continue;
              if (((Cursor)localObject1).moveToFirst()) {
                i = ((Cursor)localObject1).getInt(0);
              }
              ((Cursor)localObject1).close();
              ad.i("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount, count:%d,", new Object[] { Integer.valueOf(i) });
            }
          }
          catch (IOException localIOException1)
          {
            for (;;)
            {
              ad.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException1.getMessage() });
            }
            ((yq)localObject1).FYb.add(Float.valueOf(f2));
            j = ((yq)localObject1).FYb.size();
          }
        }
      }
      for (;;)
      {
        try
        {
          ((ax)localObject6).encode("CleanExpireRepetitionRatioList", new String(((yq)localObject1).toByteArray(), d.n.d.ISO_8859_1));
          if (j >= bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_ratio_min_size", "7", false, true), 7))
          {
            m = bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_change_switch", "2", false, true), 2);
            if (m > 0)
            {
              d2 = 0.0D;
              if (m == 1)
              {
                d2 = bt.getFloat(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_ratio_left_range", "0.009", false, true), 0.009F) * 1000000.0F;
                d1 = bt.getFloat(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_ratio_right_range", "0.011", false, true), 0.011F) * 1000000.0F;
                l2 = bt.getLong(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_time_change_threshold", Long.valueOf(259200000L).toString(), false, true), 259200000L);
                l3 = bt.getLong(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_time_change_step", Long.valueOf(86400000L).toString(), false, true), 86400000L);
                f1 = bt.getFloat(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_time_change_step_ratio", Float.valueOf(888888.88F).toString(), false, true), 888888.88F);
                if (f2 <= d1) {
                  continue;
                }
                l3 = l1 + l3;
                k = 1;
                l2 = l3;
                i = k;
                if (l3 > l4)
                {
                  l2 = l4;
                  i = k;
                }
                ((ax)localObject6).encode("CleanExpireCurrentExpireTime", l2);
                k = i;
                ag.fpX().a(l4, localPLong1, localPLong2);
                localObject1 = ag.fpX();
                Object localObject3 = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s WHERE %s >= %d GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "saveTime", Long.valueOf(l4), "id", "CleanDeleteItem" });
                ad.d("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount:".concat(String.valueOf(localObject3)));
                localObject1 = ((ag)localObject1).db.rawQuery((String)localObject3, null);
                i = 0;
                if (localObject1 != null) {
                  continue;
                }
                ad.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
                i = 0;
                l3 = i;
                if (n <= i1) {
                  continue;
                }
                f1 = (float)l3 * 1000000.0F / n;
                i = j;
                j = m;
                l7 = System.currentTimeMillis();
                l8 = System.currentTimeMillis();
                localObject1 = this.Ljf.cY("", true);
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((Iterable)localObject1).iterator();
                l3 = 0L;
                l4 = l3;
                if (!((Iterator)localObject1).hasNext()) {
                  continue;
                }
                localObject3 = (FileSystem.a)((Iterator)localObject1).next();
                if ((((FileSystem.a)localObject3).LjL) || (((FileSystem.a)localObject3).LjK > l8 - l2)) {
                  continue;
                }
                long l9 = b((FileSystem.a)localObject3);
                l4 = l3;
                if (((FileSystem.a)localObject3).delete())
                {
                  if (((FileSystem.a)localObject3).LjJ >= 0L) {
                    continue;
                  }
                  l5 = ((FileSystem.a)localObject3).size;
                  l3 += l5;
                  l4 = l3;
                  if (!((FileSystem.a)localObject3).name.endsWith(".nomedia"))
                  {
                    localObject6 = new af();
                    ((af)localObject6).field_createTime = l9;
                    if (((af)localObject6).field_createTime < 0L) {
                      ((af)localObject6).field_createTime = ((FileSystem.a)localObject3).LjK;
                    }
                    ((af)localObject6).field_modifyTime = ((FileSystem.a)localObject3).LjK;
                    ((af)localObject6).field_deleteTime = System.currentTimeMillis();
                    ((af)localObject6).field_id = ((FileSystem.a)localObject3).name;
                    ((af)localObject6).field_saveTime = (((af)localObject6).field_deleteTime - ((af)localObject6).field_createTime);
                    ((af)localObject6).field_size = l5;
                    ((af)localObject6).field_flags = 0L;
                    ag.fpX().insert((c)localObject6);
                    l4 = l3;
                  }
                }
                l3 = l4;
                continue;
              }
            }
          }
        }
        catch (IOException localIOException2)
        {
          double d2;
          long l3;
          long l7;
          long l8;
          long l5;
          ad.e("VFS.CleanExpireFileSystem", "toByteArray Failed: %s", new Object[] { localIOException2.getMessage() });
          continue;
          if (m == 2)
          {
            if (((yq)localObject1).FYb == null)
            {
              Object localObject4 = ((ax)localObject6).getString("CleanExpireRepetitionRatioList", "");
              localObject1 = new yq();
              if (!bt.isNullOrNil((String)localObject4)) {}
              Object localObject5;
              try
              {
                ((yq)localObject1).parseFrom(((String)localObject4).getBytes("ISO-8859-1"));
                if (((yq)localObject1).FYb == null) {
                  ((yq)localObject1).FYb = new LinkedList();
                }
                i = ((yq)localObject1).FYb.size();
                f1 = 0.0F;
                if (i <= 0) {
                  continue;
                }
                localObject7 = ((yq)localObject1).FYb.iterator();
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
                ad.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException3.getMessage() });
                continue;
                f1 = localIOException3.floatValue() / i;
                localObject5 = ((yq)localObject1).FYb.iterator();
                localObject1 = Double.valueOf(0.0D);
                if (((Iterator)localObject5).hasNext())
                {
                  localObject7 = (Float)((Iterator)localObject5).next();
                  d1 = ((Double)localObject1).doubleValue();
                  localObject1 = Double.valueOf(Math.pow(((Float)localObject7).floatValue() - f1, 2.0D) + d1);
                  continue;
                }
                d1 = Math.sqrt(((Double)localObject1).doubleValue() / i);
              }
              i = bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_ratio_left_range_var_count", "1", false, true), 1);
              k = bt.getInt(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_ratio_right_range_var_count", "2", false, true), 2);
              float f3 = 1000000.0F * bt.getFloat(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_min", "-1", false, true), -1.0F);
              float f4 = 1000000.0F * bt.getFloat(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_repetition_max", "-1", false, true), -1.0F);
              d2 = f1;
              double d3 = i * d1 + d2;
              d2 = f1;
              double d4 = d1 * k + d2;
              d2 = d3;
              if (f3 > 0.0F)
              {
                d2 = d3;
                if (d3 < f3)
                {
                  d1 = f3;
                  d2 = d1;
                  if (d4 < f3)
                  {
                    if (f4 > 0.0F)
                    {
                      d3 = f4;
                      d2 = d1;
                      d1 = d3;
                      continue;
                    }
                    d3 = f3 * 1.1D;
                    d2 = d1;
                    d1 = d3;
                    continue;
                    if (f2 < d2)
                    {
                      k = 2;
                      if (l1 > l2)
                      {
                        l3 = l1 - l3;
                        l2 = l3;
                        i = k;
                        if (l3 >= 0L) {
                          continue;
                        }
                        l2 = l1;
                        i = k;
                        continue;
                      }
                      l3 = ((float)l1 * f1) / 1000000L;
                      continue;
                    }
                    i = 0;
                    l2 = l1;
                    continue;
                    if (((Cursor)localObject1).moveToFirst()) {
                      i = ((Cursor)localObject1).getInt(0);
                    }
                    ((Cursor)localObject1).close();
                    ad.i("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount, threshold:%d, count:%d,", new Object[] { Long.valueOf(l4), Integer.valueOf(i) });
                    continue;
                    l5 = ((FileSystem.a)localObject5).LjJ;
                    continue;
                    l4 = 0L;
                    l3 = System.currentTimeMillis();
                    l5 = bt.getLong(com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_clean_expire_storage_count", "50000", false, true), 20000L);
                    if (ag.fpX().getCount() > l5)
                    {
                      localObject1 = ag.fpX();
                      l8 = ((ag)localObject1).getCount();
                      if (l8 <= l5) {
                        ad.i("MicroMsg.CleanDeleteItemStorage", "cleanDate don't need to clean");
                      }
                      localObject5 = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "CleanDeleteItem", "deleteTime", "deleteTime", "CleanDeleteItem", "deleteTime", Long.valueOf(l8 - l5) });
                      ad.d("MicroMsg.CleanDeleteItemStorage", "cleanData:".concat(String.valueOf(localObject5)));
                      ad.i("MicroMsg.CleanDeleteItemStorage", "cleanData result:%b, size:%d, originCount:%d, finalCount:%d", new Object[] { Boolean.valueOf(((ag)localObject1).db.execSQL("CleanDeleteItem", (String)localObject5)), Long.valueOf(l5), Long.valueOf(l8), Integer.valueOf(((ag)localObject1).getCount()) });
                    }
                    l5 = System.currentTimeMillis();
                    k(3, new Object[] { "cleanStorageCount", Integer.valueOf(n), "cleanRepetitionRatio", Float.valueOf(f2), "cleanRepetitionRatioCount", Integer.valueOf(i), "cleanStorageRepetitionRatio", Float.valueOf(f1), "cleanStorageDeleteSize", Long.valueOf(localPLong1.value), "cleanStorageFreeSize", Long.valueOf(localPLong2.value), "deleteSize", Long.valueOf(l4), "cleanOriginExpireTime", Long.valueOf(l1), "cleanNewExpireTime", Long.valueOf(l2), "cleanExtraCostTime", Long.valueOf(l5 - l3 + (-1L + (l7 - l6))), "cleanTrend", Integer.valueOf(k), "changeSwitch", Integer.valueOf(j) });
                    super.a(paramCancellationSignal);
                    AppMethodBeat.o(189916);
                    return;
                    f1 = -1.0F;
                    i = j;
                    j = m;
                    continue;
                  }
                }
              }
              d1 = d4;
              continue;
              d1 = 0.0D;
              continue;
            }
            continue;
          }
          double d1 = 0.0D;
          continue;
          l2 = l1;
          continue;
          l2 = l1;
          f1 = -1.0F;
          i = j;
          j = m;
          continue;
        }
        long l2 = l1;
        float f1 = -1.0F;
        f2 = -1.0F;
        j = m;
      }
    }
  }
  
  public final ReadableByteChannel aYb(String paramString)
  {
    AppMethodBeat.i(189911);
    ReadableByteChannel localReadableByteChannel = this.Ljf.aYb(paramString);
    db(paramString, false);
    AppMethodBeat.o(189911);
    return localReadableByteChannel;
  }
  
  public final ByteChannel aYc(String paramString)
  {
    AppMethodBeat.i(189914);
    ByteChannel localByteChannel = this.Ljf.aYc(paramString);
    db(paramString, true);
    AppMethodBeat.o(189914);
    return localByteChannel;
  }
  
  public final WritableByteChannel cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189913);
    WritableByteChannel localWritableByteChannel = this.Ljf.cW(paramString, paramBoolean);
    db(paramString, true);
    AppMethodBeat.o(189913);
    return localWritableByteChannel;
  }
  
  public final OutputStream cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189912);
    OutputStream localOutputStream = this.Ljf.cX(paramString, paramBoolean);
    db(paramString, true);
    AppMethodBeat.o(189912);
    return localOutputStream;
  }
  
  public final boolean cZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189922);
    Iterator localIterator = this.Ljg.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).cZ(paramString, paramBoolean) | bool) {}
    AppMethodBeat.o(189922);
    return bool;
  }
  
  protected final Iterable<FileSystem> fOq()
  {
    return this.Ljg;
  }
  
  protected final FileSystem gK(String paramString, int paramInt)
  {
    return this.Ljf;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(189918);
    for (;;)
    {
      synchronized (this.Lji)
      {
        if (this.Ljj.isEmpty()) {
          break label153;
        }
        paramMessage = this.Ljj;
        this.Ljj = new HashMap();
        if (paramMessage == null) {
          break label145;
        }
        ??? = paramMessage.entrySet().iterator();
        if (((Iterator)???).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
          this.Ljf.cn((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
        }
      }
      ad.d("VFS.CleanExpireFileSystem", "Flush access time cache entries: " + paramMessage.size());
      label145:
      AppMethodBeat.o(189918);
      return true;
      label153:
      paramMessage = null;
    }
  }
  
  public final ParcelFileDescriptor mt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189915);
    ParcelFileDescriptor localParcelFileDescriptor = this.Ljf.mt(paramString1, paramString2);
    db(paramString1, paramString2.contains("w"));
    AppMethodBeat.o(189915);
    return localParcelFileDescriptor;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(189910);
    InputStream localInputStream = this.Ljf.openRead(paramString);
    db(paramString, false);
    AppMethodBeat.o(189910);
    return localInputStream;
  }
  
  public String toString()
  {
    AppMethodBeat.i(189920);
    String str = "Expire [" + this.Ljf.toString() + "]";
    AppMethodBeat.o(189920);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(189919);
    q.b(paramParcel, CleanExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.Ljf, paramInt);
    paramParcel.writeLong(this.lTw);
    if (this.Ljh) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(189919);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.CleanExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */