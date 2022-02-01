package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wl;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.am;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CleanExpireFileSystem
  extends ExpireFileSystem
{
  public static final Parcelable.Creator<CleanExpireFileSystem> CREATOR;
  private final boolean YBm;
  private final long YBn;
  
  static
  {
    AppMethodBeat.i(196936);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(196936);
  }
  
  protected CleanExpireFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(196924);
    this.YBn = 60000L;
    ad.a(paramParcel, CleanExpireFileSystem.class, 2);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.YBm = bool;
      AppMethodBeat.o(196924);
      return;
    }
  }
  
  public CleanExpireFileSystem(FileSystem paramFileSystem)
  {
    super(paramFileSystem, l1);
    AppMethodBeat.i(196922);
    this.YBn = 60000L;
    this.YBm = true;
    AppMethodBeat.o(196922);
  }
  
  public final FileSystem.b cp(Map<String, String> paramMap)
  {
    AppMethodBeat.i(196927);
    paramMap = new a(this.YBI.cp(paramMap));
    AppMethodBeat.o(196927);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(196932);
    String str = "CleanExpire [" + this.YBI.toString() + "]";
    AppMethodBeat.o(196932);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(196930);
    super.writeToParcel(paramParcel, paramInt);
    ad.b(paramParcel, CleanExpireFileSystem.class, 2);
    if (this.YBm) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(196930);
      return;
    }
  }
  
  protected final class a
    extends ExpireFileSystem.a
    implements Handler.Callback
  {
    private final Object YBo;
    private HashMap<String, Long> YBp;
    private final Handler YBq;
    
    public a(FileSystem.b paramb)
    {
      super(paramb);
      AppMethodBeat.i(197694);
      this.YBo = new Object();
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        this.YBp = new HashMap();
        this.YBq = new Handler(h.iWH().iWJ(), this);
        AppMethodBeat.o(197694);
        return;
      }
      this.YBp = null;
      this.YBq = null;
      AppMethodBeat.o(197694);
    }
    
    @TargetApi(21)
    private static long a(f paramf)
    {
      AppMethodBeat.i(197734);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramf != null) {
        localObject1 = localObject2;
      }
      try
      {
        if (paramf.YCk != null)
        {
          localObject1 = localObject2;
          if ((paramf.YCk.ieX() instanceof NativeFileSystem)) {
            localObject1 = Os.stat(paramf.YCk.dL(paramf.UUr, false));
          }
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(197734);
          return -1L;
        }
        long l = ((StructStat)localObject1).st_ctime;
        AppMethodBeat.o(197734);
        return l;
      }
      catch (ErrnoException paramf)
      {
        AppMethodBeat.o(197734);
      }
      return -1L;
    }
    
    private void dM(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197697);
      if (!CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        AppMethodBeat.o(197697);
        return;
      }
      if (paramBoolean) {
        synchronized (this.YBo)
        {
          this.YBp.remove(paramString);
          AppMethodBeat.o(197697);
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
        AppMethodBeat.o(197697);
        return;
      }
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(197698);
      InputStream localInputStream = this.YBJ.Tf(paramString);
      dM(paramString, false);
      AppMethodBeat.o(197698);
      return localInputStream;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(197731);
      CleanExpireFileSystem.this.k(1, new Object[0]);
      Object localObject1;
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        localObject1 = null;
        synchronized (this.YBo)
        {
          if (!this.YBp.isEmpty())
          {
            localObject1 = this.YBp;
            this.YBp = new HashMap();
          }
          if (localObject1 != null)
          {
            localObject1 = ((HashMap)localObject1).entrySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ??? = (Map.Entry)((Iterator)localObject1).next();
              paramCancellationSignal.throwIfCanceled();
              this.YBJ.ct((String)((Map.Entry)???).getKey(), ((Long)((Map.Entry)???).getValue()).longValue());
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
      Object localObject6 = MultiProcessMMKV.getMMKV("CleanExpireFileSystem");
      long l1 = ((MultiProcessMMKV)localObject6).getLong("CleanExpireCurrentExpireTime", 0L);
      long l4 = Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_default_expire_time", Long.toString(604800000L), false, true), 604800000L);
      if ((l1 < 43200000.0D) || (l1 > l4))
      {
        ((MultiProcessMMKV)localObject6).encode("CleanExpireCurrentExpireTime", l4);
        l1 = l4;
      }
      for (;;)
      {
        long l6 = System.currentTimeMillis();
        int n = am.hxO().getCount();
        int i1 = Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_storage_min", "100", false, true), 100);
        float f2;
        int j;
        if (n > i1)
        {
          localObject1 = am.hxO();
          ??? = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "id", "CleanDeleteItem" });
          Log.d("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount:".concat(String.valueOf(???)));
          localObject1 = ((am)localObject1).db.rawQuery((String)???, null);
          i = 0;
          if (localObject1 == null)
          {
            Log.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
            i = 0;
          }
          for (;;)
          {
            f2 = i * 1000000.0F / n;
            i = Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_ratio_list_size", "28", false, true), 28);
            ??? = ((MultiProcessMMKV)localObject6).getString("CleanExpireRepetitionRatioList", "");
            localObject1 = new aan();
            if (!Util.isNullOrNil((String)???)) {}
            try
            {
              ((aan)localObject1).parseFrom(((String)???).getBytes("ISO-8859-1"));
              if (((aan)localObject1).SmG == null) {
                ((aan)localObject1).SmG = new LinkedList();
              }
              while (((aan)localObject1).SmG.size() > i)
              {
                ((aan)localObject1).SmG.removeFirst();
                continue;
                if (((Cursor)localObject1).moveToFirst()) {
                  i = ((Cursor)localObject1).getInt(0);
                }
                ((Cursor)localObject1).close();
                Log.i("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount, count:%d,", new Object[] { Integer.valueOf(i) });
              }
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                Log.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException1.getMessage() });
              }
              ((aan)localObject1).SmG.add(Float.valueOf(f2));
              j = ((aan)localObject1).SmG.size();
            }
          }
        }
        for (;;)
        {
          try
          {
            ((MultiProcessMMKV)localObject6).encode("CleanExpireRepetitionRatioList", new String(((aan)localObject1).toByteArray(), kotlin.n.d.ISO_8859_1));
            if (j >= Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_ratio_min_size", "7", false, true), 7))
            {
              m = Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_change_switch", "2", false, true), 2);
              if (m > 0)
              {
                d2 = 0.0D;
                if (m == 1)
                {
                  d2 = Util.getFloat(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_ratio_left_range", "0.009", false, true), 0.009F) * 1000000.0F;
                  d1 = Util.getFloat(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_ratio_right_range", "0.011", false, true), 0.011F) * 1000000.0F;
                  l2 = Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_time_change_threshold", Long.valueOf(259200000L).toString(), false, true), 259200000L);
                  l3 = Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_time_change_step", Long.valueOf(86400000L).toString(), false, true), 86400000L);
                  f1 = Util.getFloat(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_time_change_step_ratio", Float.valueOf(888888.88F).toString(), false, true), 888888.88F);
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
                  ((MultiProcessMMKV)localObject6).encode("CleanExpireCurrentExpireTime", l2);
                  k = i;
                  am.hxO().a(l4, localPLong1, localPLong2);
                  localObject1 = am.hxO();
                  Object localObject3 = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s WHERE %s >= %d GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "saveTime", Long.valueOf(l4), "id", "CleanDeleteItem" });
                  Log.d("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount:".concat(String.valueOf(localObject3)));
                  localObject1 = ((am)localObject1).db.rawQuery((String)localObject3, null);
                  i = 0;
                  if (localObject1 != null) {
                    continue;
                  }
                  Log.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
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
                  Log.i("VFS.CleanExpireFileSystem", "newExpireTime:%s = %s h", new Object[] { Long.valueOf(l2), Long.valueOf(l2 / 1000L / 60L / 60L) });
                  localObject1 = this.YBJ.dJ("", true);
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((Iterable)localObject1).iterator();
                  l3 = 0L;
                  l4 = l3;
                  if (!((Iterator)localObject1).hasNext()) {
                    continue;
                  }
                  localObject3 = (f)((Iterator)localObject1).next();
                  paramCancellationSignal.throwIfCanceled();
                  if ((((f)localObject3).YCj) || (((f)localObject3).YCi > l8 - l2)) {
                    continue;
                  }
                  long l9 = a((f)localObject3);
                  l4 = l3;
                  if (((f)localObject3).cFq())
                  {
                    if (((f)localObject3).YCh >= 0L) {
                      continue;
                    }
                    l5 = ((f)localObject3).size;
                    l3 += l5;
                    l4 = l3;
                    if (!((f)localObject3).name.endsWith(".nomedia"))
                    {
                      localObject6 = new al();
                      ((al)localObject6).field_createTime = l9;
                      if (((al)localObject6).field_createTime < 0L) {
                        ((al)localObject6).field_createTime = ((f)localObject3).YCi;
                      }
                      ((al)localObject6).field_modifyTime = ((f)localObject3).YCi;
                      ((al)localObject6).field_deleteTime = System.currentTimeMillis();
                      ((al)localObject6).field_id = ((f)localObject3).name;
                      ((al)localObject6).field_saveTime = (((al)localObject6).field_deleteTime - ((al)localObject6).field_createTime);
                      ((al)localObject6).field_size = l5;
                      ((al)localObject6).field_flags = 0L;
                      am.hxO().insert((IAutoDBItem)localObject6);
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
            Log.e("VFS.CleanExpireFileSystem", "toByteArray Failed: %s", new Object[] { localIOException2.getMessage() });
            continue;
            if (m == 2)
            {
              if (((aan)localObject1).SmG == null)
              {
                Object localObject4 = ((MultiProcessMMKV)localObject6).getString("CleanExpireRepetitionRatioList", "");
                localObject1 = new aan();
                if (!Util.isNullOrNil((String)localObject4)) {}
                Object localObject5;
                try
                {
                  ((aan)localObject1).parseFrom(((String)localObject4).getBytes("ISO-8859-1"));
                  if (((aan)localObject1).SmG == null) {
                    ((aan)localObject1).SmG = new LinkedList();
                  }
                  i = ((aan)localObject1).SmG.size();
                  f1 = 0.0F;
                  if (i <= 0) {
                    continue;
                  }
                  localObject7 = ((aan)localObject1).SmG.iterator();
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
                  Log.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException3.getMessage() });
                  continue;
                  f1 = localIOException3.floatValue() / i;
                  localObject5 = ((aan)localObject1).SmG.iterator();
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
                i = Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_ratio_left_range_var_count", "1", false, true), 1);
                k = Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_ratio_right_range_var_count", "2", false, true), 2);
                float f3 = 1000000.0F * Util.getFloat(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_min", "-1", false, true), -1.0F);
                float f4 = 1000000.0F * Util.getFloat(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_repetition_max", "-1", false, true), -1.0F);
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
                          if (l3 >= 43200000.0D) {
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
                      Log.i("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount, threshold:%d, count:%d,", new Object[] { Long.valueOf(l4), Integer.valueOf(i) });
                      continue;
                      l5 = ((f)localObject5).YCh;
                      continue;
                      l4 = 0L;
                      l3 = System.currentTimeMillis();
                      l5 = Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_clean_expire_storage_count", "50000", false, true), 20000L);
                      if (am.hxO().getCount() > l5)
                      {
                        localObject1 = am.hxO();
                        l8 = ((am)localObject1).getCount();
                        if (l8 <= l5) {
                          Log.i("MicroMsg.CleanDeleteItemStorage", "cleanDate don't need to clean");
                        }
                        localObject5 = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "CleanDeleteItem", "deleteTime", "deleteTime", "CleanDeleteItem", "deleteTime", Long.valueOf(l8 - l5) });
                        Log.d("MicroMsg.CleanDeleteItemStorage", "cleanData:".concat(String.valueOf(localObject5)));
                        Log.i("MicroMsg.CleanDeleteItemStorage", "cleanData result:%b, size:%d, originCount:%d, finalCount:%d", new Object[] { Boolean.valueOf(((am)localObject1).db.execSQL("CleanDeleteItem", (String)localObject5)), Long.valueOf(l5), Long.valueOf(l8), Integer.valueOf(((am)localObject1).getCount()) });
                      }
                      l5 = System.currentTimeMillis();
                      CleanExpireFileSystem.this.k(3, new Object[] { "cleanStorageCount", Integer.valueOf(n), "cleanRepetitionRatio", Float.valueOf(f2), "cleanRepetitionRatioCount", Integer.valueOf(i), "cleanStorageRepetitionRatio", Float.valueOf(f1), "cleanStorageDeleteSize", Long.valueOf(localPLong1.value), "cleanStorageFreeSize", Long.valueOf(localPLong2.value), "deleteSize", Long.valueOf(l4), "cleanOriginExpireTime", Long.valueOf(l1), "cleanNewExpireTime", Long.valueOf(l2), "cleanExtraCostTime", Long.valueOf(l5 - l3 + (-1L + (l7 - l6))), "cleanTrend", Integer.valueOf(k), "changeSwitch", Integer.valueOf(j) });
                      localObject1 = new wl();
                      ((wl)localObject1).fVD.fVE = (l2 / 60L / 1000L);
                      ((wl)localObject1).fVD.fVF = paramCancellationSignal;
                      EventCenter.instance.publish((IEvent)localObject1);
                      localObject1 = ifa().iterator();
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject5 = (FileSystem.b)((Iterator)localObject1).next();
                        paramCancellationSignal.throwIfCanceled();
                        ((FileSystem.b)localObject5).a(paramCancellationSignal);
                        continue;
                      }
                      AppMethodBeat.o(197731);
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
    
    public final ReadableByteChannel bBy(String paramString)
    {
      AppMethodBeat.i(197699);
      ReadableByteChannel localReadableByteChannel = this.YBJ.bBy(paramString);
      dM(paramString, false);
      AppMethodBeat.o(197699);
      return localReadableByteChannel;
    }
    
    public final ByteChannel bBz(String paramString)
    {
      AppMethodBeat.i(197703);
      ByteChannel localByteChannel = this.YBJ.bBz(paramString);
      dM(paramString, true);
      AppMethodBeat.o(197703);
      return localByteChannel;
    }
    
    public final WritableByteChannel dH(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197702);
      WritableByteChannel localWritableByteChannel = this.YBJ.dH(paramString, paramBoolean);
      dM(paramString, true);
      AppMethodBeat.o(197702);
      return localWritableByteChannel;
    }
    
    public final OutputStream dI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197700);
      OutputStream localOutputStream = this.YBJ.dI(paramString, paramBoolean);
      dM(paramString, true);
      AppMethodBeat.o(197700);
      return localOutputStream;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(197735);
      for (;;)
      {
        synchronized (this.YBo)
        {
          if (this.YBp.isEmpty()) {
            break label153;
          }
          paramMessage = this.YBp;
          this.YBp = new HashMap();
          if (paramMessage == null) {
            break label145;
          }
          ??? = paramMessage.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.YBJ.ct((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
        }
        Log.d("VFS.CleanExpireFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label145:
        AppMethodBeat.o(197735);
        return true;
        label153:
        paramMessage = null;
      }
    }
    
    public final ParcelFileDescriptor oh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(197704);
      ParcelFileDescriptor localParcelFileDescriptor = this.YBJ.oh(paramString1, paramString2);
      dM(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(197704);
      return localParcelFileDescriptor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.CleanExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */