package com.tencent.mm.vfs;

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
import com.tencent.mm.autogen.a.ye;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
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
  private final boolean agvN;
  private final long agvO;
  
  static
  {
    AppMethodBeat.i(238137);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238137);
  }
  
  protected CleanExpireFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(238131);
    this.agvO = 60000L;
    ah.a(paramParcel, CleanExpireFileSystem.class, 2);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.agvN = bool;
      AppMethodBeat.o(238131);
      return;
    }
  }
  
  public CleanExpireFileSystem(FileSystem paramFileSystem)
  {
    super(paramFileSystem, l1);
    AppMethodBeat.i(238126);
    this.agvO = 60000L;
    this.agvN = true;
    AppMethodBeat.o(238126);
  }
  
  public final FileSystem.b cO(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238143);
    paramMap = new a((FileSystem.b)this.agvG.cN(paramMap));
    AppMethodBeat.o(238143);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238156);
    String str = "CleanExpire [" + this.agvG.toString() + "]";
    AppMethodBeat.o(238156);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238150);
    super.writeToParcel(paramParcel, paramInt);
    ah.b(paramParcel, CleanExpireFileSystem.class, 2);
    if (this.agvN) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(238150);
      return;
    }
  }
  
  protected final class a
    extends ExpireFileSystem.a
    implements Handler.Callback
  {
    private final Object agvP;
    private HashMap<String, Long> agvQ;
    private final Handler agvR;
    
    public a(FileSystem.b paramb)
    {
      super(paramb);
      AppMethodBeat.i(238123);
      this.agvP = new Object();
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        this.agvQ = new HashMap();
        this.agvR = new Handler(k.kMs().akmy.getLooper(), this);
        AppMethodBeat.o(238123);
        return;
      }
      this.agvQ = null;
      this.agvR = null;
      AppMethodBeat.o(238123);
    }
    
    private static long a(j paramj)
    {
      AppMethodBeat.i(238140);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramj != null) {
        localObject1 = localObject2;
      }
      try
      {
        if (paramj.agxi != null)
        {
          localObject1 = localObject2;
          if ((paramj.agxi.jKa() instanceof NativeFileSystem)) {
            localObject1 = Os.stat(paramj.agxi.ex(paramj.acpB, false));
          }
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(238140);
          return -1L;
        }
        long l = ((StructStat)localObject1).st_ctime;
        AppMethodBeat.o(238140);
        return l;
      }
      catch (ErrnoException paramj)
      {
        AppMethodBeat.o(238140);
      }
      return -1L;
    }
    
    private void ey(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238132);
      if (!CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        AppMethodBeat.o(238132);
        return;
      }
      if (paramBoolean) {
        synchronized (this.agvP)
        {
          this.agvQ.remove(paramString);
          AppMethodBeat.o(238132);
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
        AppMethodBeat.o(238132);
        return;
      }
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(238151);
      InputStream localInputStream = this.agwv.Lh(paramString);
      ey(paramString, false);
      AppMethodBeat.o(238151);
      return localInputStream;
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238218);
      CleanExpireFileSystem.this.l(1, new Object[0]);
      Object localObject1;
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        localObject1 = null;
        synchronized (this.agvP)
        {
          if (!this.agvQ.isEmpty())
          {
            localObject1 = this.agvQ;
            this.agvQ = new HashMap();
          }
          if (localObject1 != null)
          {
            localObject1 = ((HashMap)localObject1).entrySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ??? = (Map.Entry)((Iterator)localObject1).next();
              paramCancellationSignal.throwIfCanceled();
              this.agwv.cF((String)((Map.Entry)???).getKey(), ((Long)((Map.Entry)???).getValue()).longValue());
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
      long l4 = Util.getLong(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_default_expire_time", Long.toString(604800000L), false, true), 604800000L);
      Log.i("VFS.CleanExpireFileSystem", "originExpireTime:%d min", new Object[] { Long.valueOf(l1 / 60L / 1000L) });
      if ((l1 < 43200000.0D) || (l1 > l4))
      {
        ((MultiProcessMMKV)localObject6).encode("CleanExpireCurrentExpireTime", l4);
        l1 = l4;
      }
      for (;;)
      {
        long l6 = System.currentTimeMillis();
        int n = ao.iZt().getCount();
        int i1 = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_storage_min", "100", false, true), 100);
        float f2;
        int j;
        if (n > i1)
        {
          localObject1 = ao.iZt();
          ??? = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "id", "CleanDeleteItem" });
          Log.d("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount:".concat(String.valueOf(???)));
          localObject1 = ((ao)localObject1).db.rawQuery((String)???, null);
          i = 0;
          if (localObject1 == null)
          {
            Log.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
            i = 0;
          }
          for (;;)
          {
            f2 = i * 1000000.0F / n;
            i = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_ratio_list_size", "28", false, true), 28);
            ??? = ((MultiProcessMMKV)localObject6).getString("CleanExpireRepetitionRatioList", "");
            localObject1 = new acn();
            if (!Util.isNullOrNil((String)???)) {}
            try
            {
              ((acn)localObject1).parseFrom(((String)???).getBytes("ISO-8859-1"));
              if (((acn)localObject1).ZkS == null) {
                ((acn)localObject1).ZkS = new LinkedList();
              }
              while (((acn)localObject1).ZkS.size() > i)
              {
                ((acn)localObject1).ZkS.removeFirst();
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
              ((acn)localObject1).ZkS.add(Float.valueOf(f2));
              j = ((acn)localObject1).ZkS.size();
            }
          }
        }
        for (;;)
        {
          try
          {
            ((MultiProcessMMKV)localObject6).encode("CleanExpireRepetitionRatioList", new String(((acn)localObject1).toByteArray(), kotlin.n.d.ISO_8859_1));
            if (j >= Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_ratio_min_size", "7", false, true), 7))
            {
              m = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_change_switch", "2", false, true), 2);
              if (m > 0)
              {
                d2 = 0.0D;
                if (m == 1)
                {
                  d2 = Util.getFloat(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_ratio_left_range", "0.009", false, true), 0.009F) * 1000000.0F;
                  d1 = Util.getFloat(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_ratio_right_range", "0.011", false, true), 0.011F) * 1000000.0F;
                  l2 = Util.getLong(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_time_change_threshold", Long.valueOf(259200000L).toString(), false, true), 259200000L);
                  l3 = Util.getLong(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_time_change_step", Long.valueOf(86400000L).toString(), false, true), 86400000L);
                  f1 = Util.getFloat(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_time_change_step_ratio", Float.valueOf(888888.88F).toString(), false, true), 888888.88F);
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
                  ao.iZt().a(l4, localPLong1, localPLong2);
                  localObject1 = ao.iZt();
                  Object localObject3 = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s WHERE %s >= %d GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "saveTime", Long.valueOf(l4), "id", "CleanDeleteItem" });
                  Log.d("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount:".concat(String.valueOf(localObject3)));
                  localObject1 = ((ao)localObject1).db.rawQuery((String)localObject3, null);
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
                  localObject1 = ah.a(this.agwv, "");
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((Iterable)localObject1).iterator();
                  l3 = 0L;
                  l4 = l3;
                  if (!((Iterator)localObject1).hasNext()) {
                    continue;
                  }
                  localObject3 = (j)((Iterator)localObject1).next();
                  paramCancellationSignal.throwIfCanceled();
                  if ((((j)localObject3).agxh) || (((j)localObject3).agxg > l8 - l2)) {
                    continue;
                  }
                  long l9 = a((j)localObject3);
                  l4 = l3;
                  if (((j)localObject3).NP(true))
                  {
                    if (((j)localObject3).agxf >= 0L) {
                      continue;
                    }
                    l5 = ((j)localObject3).size;
                    l3 += l5;
                    l4 = l3;
                    if (!((j)localObject3).name.endsWith(".nomedia"))
                    {
                      localObject6 = new an();
                      ((an)localObject6).field_createTime = l9;
                      if (((an)localObject6).field_createTime < 0L) {
                        ((an)localObject6).field_createTime = ((j)localObject3).agxg;
                      }
                      ((an)localObject6).field_modifyTime = ((j)localObject3).agxg;
                      ((an)localObject6).field_deleteTime = System.currentTimeMillis();
                      ((an)localObject6).field_id = ((j)localObject3).name;
                      ((an)localObject6).field_saveTime = (((an)localObject6).field_deleteTime - ((an)localObject6).field_createTime);
                      ((an)localObject6).field_size = l5;
                      ((an)localObject6).field_flags = 0L;
                      ao.iZt().insert((IAutoDBItem)localObject6);
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
              if (((acn)localObject1).ZkS == null)
              {
                Object localObject4 = ((MultiProcessMMKV)localObject6).getString("CleanExpireRepetitionRatioList", "");
                localObject1 = new acn();
                if (!Util.isNullOrNil((String)localObject4)) {}
                Object localObject5;
                try
                {
                  ((acn)localObject1).parseFrom(((String)localObject4).getBytes("ISO-8859-1"));
                  if (((acn)localObject1).ZkS == null) {
                    ((acn)localObject1).ZkS = new LinkedList();
                  }
                  i = ((acn)localObject1).ZkS.size();
                  f1 = 0.0F;
                  if (i <= 0) {
                    continue;
                  }
                  localObject7 = ((acn)localObject1).ZkS.iterator();
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
                  localObject5 = ((acn)localObject1).ZkS.iterator();
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
                i = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_ratio_left_range_var_count", "1", false, true), 1);
                k = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_ratio_right_range_var_count", "2", false, true), 2);
                float f3 = 1000000.0F * Util.getFloat(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_min", "-1", false, true), -1.0F);
                float f4 = 1000000.0F * Util.getFloat(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_repetition_max", "-1", false, true), -1.0F);
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
                      l5 = ((j)localObject5).agxf;
                      continue;
                      l4 = 0L;
                      l3 = System.currentTimeMillis();
                      l5 = Util.getLong(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_clean_expire_storage_count", "50000", false, true), 20000L);
                      if (ao.iZt().getCount() > l5)
                      {
                        localObject1 = ao.iZt();
                        l8 = ((ao)localObject1).getCount();
                        if (l8 <= l5) {
                          Log.i("MicroMsg.CleanDeleteItemStorage", "cleanDate don't need to clean");
                        }
                        localObject5 = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "CleanDeleteItem", "deleteTime", "deleteTime", "CleanDeleteItem", "deleteTime", Long.valueOf(l8 - l5) });
                        Log.d("MicroMsg.CleanDeleteItemStorage", "cleanData:".concat(String.valueOf(localObject5)));
                        Log.i("MicroMsg.CleanDeleteItemStorage", "cleanData result:%b, size:%d, originCount:%d, finalCount:%d", new Object[] { Boolean.valueOf(((ao)localObject1).db.execSQL("CleanDeleteItem", (String)localObject5)), Long.valueOf(l5), Long.valueOf(l8), Integer.valueOf(((ao)localObject1).getCount()) });
                      }
                      l5 = System.currentTimeMillis();
                      CleanExpireFileSystem.this.l(3, new Object[] { "cleanStorageCount", Integer.valueOf(n), "cleanRepetitionRatio", Float.valueOf(f2), "cleanRepetitionRatioCount", Integer.valueOf(i), "cleanStorageRepetitionRatio", Float.valueOf(f1), "cleanStorageDeleteSize", Long.valueOf(localPLong1.value), "cleanStorageFreeSize", Long.valueOf(localPLong2.value), "deleteSize", Long.valueOf(l4), "cleanOriginExpireTime", Long.valueOf(l1), "cleanNewExpireTime", Long.valueOf(l2), "cleanExtraCostTime", Long.valueOf(l5 - l3 + (-1L + (l7 - l6))), "cleanTrend", Integer.valueOf(k), "changeSwitch", Integer.valueOf(j) });
                      localObject1 = new ye();
                      ((ye)localObject1).ibD.ibE = (l2 / 60L / 1000L);
                      ((ye)localObject1).ibD.ibF = paramCancellationSignal;
                      ((ye)localObject1).publish();
                      localObject1 = jKf().iterator();
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject5 = (FileSystem.b)((Iterator)localObject1).next();
                        paramCancellationSignal.throwIfCanceled();
                        ((FileSystem.b)localObject5).a(paramCancellationSignal);
                        continue;
                      }
                      AppMethodBeat.o(238218);
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
    
    public final ReadableByteChannel bDS(String paramString)
    {
      AppMethodBeat.i(238159);
      ReadableByteChannel localReadableByteChannel = this.agwv.bDS(paramString);
      ey(paramString, false);
      AppMethodBeat.o(238159);
      return localReadableByteChannel;
    }
    
    public final ByteChannel bDT(String paramString)
    {
      AppMethodBeat.i(238178);
      ByteChannel localByteChannel = this.agwv.bDT(paramString);
      ey(paramString, true);
      AppMethodBeat.o(238178);
      return localByteChannel;
    }
    
    public final WritableByteChannel et(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238169);
      WritableByteChannel localWritableByteChannel = this.agwv.et(paramString, paramBoolean);
      ey(paramString, true);
      AppMethodBeat.o(238169);
      return localWritableByteChannel;
    }
    
    public final OutputStream ev(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(238165);
      OutputStream localOutputStream = this.agwv.ev(paramString, paramBoolean);
      ey(paramString, true);
      AppMethodBeat.o(238165);
      return localOutputStream;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(238227);
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
        Log.d("VFS.CleanExpireFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label144:
        AppMethodBeat.o(238227);
        return true;
        label152:
        paramMessage = null;
      }
    }
    
    public final ParcelFileDescriptor qf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238191);
      ParcelFileDescriptor localParcelFileDescriptor = this.agwv.qf(paramString1, paramString2);
      ey(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(238191);
      return localParcelFileDescriptor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CleanExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */