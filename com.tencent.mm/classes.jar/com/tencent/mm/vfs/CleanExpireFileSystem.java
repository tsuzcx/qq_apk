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
import com.tencent.mm.protocal.protobuf.aai;
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
  private final boolean RaW;
  private final long RaX;
  
  static
  {
    AppMethodBeat.i(197203);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(197203);
  }
  
  protected CleanExpireFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(197199);
    this.RaX = 60000L;
    aa.a(paramParcel, CleanExpireFileSystem.class, 2);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.RaW = bool;
      AppMethodBeat.o(197199);
      return;
    }
  }
  
  public CleanExpireFileSystem(FileSystem paramFileSystem)
  {
    super(paramFileSystem, l1);
    AppMethodBeat.i(197198);
    this.RaX = 60000L;
    this.RaW = true;
    AppMethodBeat.o(197198);
  }
  
  public final FileSystem.b cj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(197200);
    paramMap = new a(this.Rbo.cj(paramMap));
    AppMethodBeat.o(197200);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197202);
    String str = "CleanExpire [" + this.Rbo.toString() + "]";
    AppMethodBeat.o(197202);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(197201);
    super.writeToParcel(paramParcel, paramInt);
    aa.b(paramParcel, CleanExpireFileSystem.class, 2);
    if (this.RaW) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(197201);
      return;
    }
  }
  
  protected final class a
    extends ExpireFileSystem.a
    implements Handler.Callback
  {
    private final Object RaY;
    private HashMap<String, Long> RaZ;
    private final Handler Rba;
    
    public a(FileSystem.b paramb)
    {
      super(paramb);
      AppMethodBeat.i(197187);
      this.RaY = new Object();
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        this.RaZ = new HashMap();
        this.Rba = new Handler(g.hRR().Uvj.getLooper(), this);
        AppMethodBeat.o(197187);
        return;
      }
      this.RaZ = null;
      this.Rba = null;
      AppMethodBeat.o(197187);
    }
    
    @TargetApi(21)
    private static long c(e parame)
    {
      AppMethodBeat.i(197196);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (parame != null) {
        localObject1 = localObject2;
      }
      try
      {
        if (parame.RbK != null)
        {
          localObject1 = localObject2;
          if ((parame.RbK.hdQ() instanceof NativeFileSystem)) {
            localObject1 = Os.stat(parame.RbK.dz(parame.NGP, false));
          }
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(197196);
          return -1L;
        }
        long l = ((StructStat)localObject1).st_ctime;
        AppMethodBeat.o(197196);
        return l;
      }
      catch (ErrnoException parame)
      {
        AppMethodBeat.o(197196);
      }
      return -1L;
    }
    
    private void dA(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197188);
      if (!CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        AppMethodBeat.o(197188);
        return;
      }
      if (paramBoolean) {
        synchronized (this.RaY)
        {
          this.RaZ.remove(paramString);
          AppMethodBeat.o(197188);
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
        AppMethodBeat.o(197188);
        return;
      }
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(197195);
      CleanExpireFileSystem.this.l(1, new Object[0]);
      Object localObject1;
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        localObject1 = null;
        synchronized (this.RaY)
        {
          if (!this.RaZ.isEmpty())
          {
            localObject1 = this.RaZ;
            this.RaZ = new HashMap();
          }
          if (localObject1 != null)
          {
            localObject1 = ((HashMap)localObject1).entrySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ??? = (Map.Entry)((Iterator)localObject1).next();
              paramCancellationSignal.throwIfCanceled();
              this.Rbp.ck((String)((Map.Entry)???).getKey(), ((Long)((Map.Entry)???).getValue()).longValue());
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
      long l4 = Util.getLong(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_default_expire_time", Long.toString(604800000L), false, true), 604800000L);
      if ((l1 < 0L) || (l1 > l4))
      {
        ((MultiProcessMMKV)localObject6).encode("CleanExpireCurrentExpireTime", l4);
        l1 = l4;
      }
      for (;;)
      {
        long l6 = System.currentTimeMillis();
        int n = am.gBD().getCount();
        int i1 = Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_storage_min", "100", false, true), 100);
        float f2;
        int j;
        if (n > i1)
        {
          localObject1 = am.gBD();
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
            i = Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_ratio_list_size", "28", false, true), 28);
            ??? = ((MultiProcessMMKV)localObject6).getString("CleanExpireRepetitionRatioList", "");
            localObject1 = new aai();
            if (!Util.isNullOrNil((String)???)) {}
            try
            {
              ((aai)localObject1).parseFrom(((String)???).getBytes("ISO-8859-1"));
              if (((aai)localObject1).Llw == null) {
                ((aai)localObject1).Llw = new LinkedList();
              }
              while (((aai)localObject1).Llw.size() > i)
              {
                ((aai)localObject1).Llw.removeFirst();
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
              ((aai)localObject1).Llw.add(Float.valueOf(f2));
              j = ((aai)localObject1).Llw.size();
            }
          }
        }
        for (;;)
        {
          try
          {
            ((MultiProcessMMKV)localObject6).encode("CleanExpireRepetitionRatioList", new String(((aai)localObject1).toByteArray(), kotlin.n.d.ISO_8859_1));
            if (j >= Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_ratio_min_size", "7", false, true), 7))
            {
              m = Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_change_switch", "2", false, true), 2);
              if (m > 0)
              {
                d2 = 0.0D;
                if (m == 1)
                {
                  d2 = Util.getFloat(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_ratio_left_range", "0.009", false, true), 0.009F) * 1000000.0F;
                  d1 = Util.getFloat(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_ratio_right_range", "0.011", false, true), 0.011F) * 1000000.0F;
                  l2 = Util.getLong(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_time_change_threshold", Long.valueOf(259200000L).toString(), false, true), 259200000L);
                  l3 = Util.getLong(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_time_change_step", Long.valueOf(86400000L).toString(), false, true), 86400000L);
                  f1 = Util.getFloat(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_time_change_step_ratio", Float.valueOf(888888.88F).toString(), false, true), 888888.88F);
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
                  am.gBD().a(l4, localPLong1, localPLong2);
                  localObject1 = am.gBD();
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
                  localObject1 = this.Rbp.dx("", true);
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((Iterable)localObject1).iterator();
                  l3 = 0L;
                  l4 = l3;
                  if (!((Iterator)localObject1).hasNext()) {
                    continue;
                  }
                  localObject3 = (e)((Iterator)localObject1).next();
                  paramCancellationSignal.throwIfCanceled();
                  if ((((e)localObject3).RbJ) || (((e)localObject3).RbI > l8 - l2)) {
                    continue;
                  }
                  long l9 = c((e)localObject3);
                  l4 = l3;
                  if (((e)localObject3).hdW())
                  {
                    if (((e)localObject3).RbH >= 0L) {
                      continue;
                    }
                    l5 = ((e)localObject3).size;
                    l3 += l5;
                    l4 = l3;
                    if (!((e)localObject3).name.endsWith(".nomedia"))
                    {
                      localObject6 = new al();
                      ((al)localObject6).field_createTime = l9;
                      if (((al)localObject6).field_createTime < 0L) {
                        ((al)localObject6).field_createTime = ((e)localObject3).RbI;
                      }
                      ((al)localObject6).field_modifyTime = ((e)localObject3).RbI;
                      ((al)localObject6).field_deleteTime = System.currentTimeMillis();
                      ((al)localObject6).field_id = ((e)localObject3).name;
                      ((al)localObject6).field_saveTime = (((al)localObject6).field_deleteTime - ((al)localObject6).field_createTime);
                      ((al)localObject6).field_size = l5;
                      ((al)localObject6).field_flags = 0L;
                      am.gBD().insert((IAutoDBItem)localObject6);
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
              if (((aai)localObject1).Llw == null)
              {
                Object localObject4 = ((MultiProcessMMKV)localObject6).getString("CleanExpireRepetitionRatioList", "");
                localObject1 = new aai();
                if (!Util.isNullOrNil((String)localObject4)) {}
                Object localObject5;
                try
                {
                  ((aai)localObject1).parseFrom(((String)localObject4).getBytes("ISO-8859-1"));
                  if (((aai)localObject1).Llw == null) {
                    ((aai)localObject1).Llw = new LinkedList();
                  }
                  i = ((aai)localObject1).Llw.size();
                  f1 = 0.0F;
                  if (i <= 0) {
                    continue;
                  }
                  localObject7 = ((aai)localObject1).Llw.iterator();
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
                  localObject5 = ((aai)localObject1).Llw.iterator();
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
                i = Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_ratio_left_range_var_count", "1", false, true), 1);
                k = Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_ratio_right_range_var_count", "2", false, true), 2);
                float f3 = 1000000.0F * Util.getFloat(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_min", "-1", false, true), -1.0F);
                float f4 = 1000000.0F * Util.getFloat(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_repetition_max", "-1", false, true), -1.0F);
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
                      Log.i("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount, threshold:%d, count:%d,", new Object[] { Long.valueOf(l4), Integer.valueOf(i) });
                      continue;
                      l5 = ((e)localObject5).RbH;
                      continue;
                      l4 = 0L;
                      l3 = System.currentTimeMillis();
                      l5 = Util.getLong(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_expire_storage_count", "50000", false, true), 20000L);
                      if (am.gBD().getCount() > l5)
                      {
                        localObject1 = am.gBD();
                        l8 = ((am)localObject1).getCount();
                        if (l8 <= l5) {
                          Log.i("MicroMsg.CleanDeleteItemStorage", "cleanDate don't need to clean");
                        }
                        localObject5 = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "CleanDeleteItem", "deleteTime", "deleteTime", "CleanDeleteItem", "deleteTime", Long.valueOf(l8 - l5) });
                        Log.d("MicroMsg.CleanDeleteItemStorage", "cleanData:".concat(String.valueOf(localObject5)));
                        Log.i("MicroMsg.CleanDeleteItemStorage", "cleanData result:%b, size:%d, originCount:%d, finalCount:%d", new Object[] { Boolean.valueOf(((am)localObject1).db.execSQL("CleanDeleteItem", (String)localObject5)), Long.valueOf(l5), Long.valueOf(l8), Integer.valueOf(((am)localObject1).getCount()) });
                      }
                      l5 = System.currentTimeMillis();
                      CleanExpireFileSystem.this.l(3, new Object[] { "cleanStorageCount", Integer.valueOf(n), "cleanRepetitionRatio", Float.valueOf(f2), "cleanRepetitionRatioCount", Integer.valueOf(i), "cleanStorageRepetitionRatio", Float.valueOf(f1), "cleanStorageDeleteSize", Long.valueOf(localPLong1.value), "cleanStorageFreeSize", Long.valueOf(localPLong2.value), "deleteSize", Long.valueOf(l4), "cleanOriginExpireTime", Long.valueOf(l1), "cleanNewExpireTime", Long.valueOf(l2), "cleanExtraCostTime", Long.valueOf(l5 - l3 + (-1L + (l7 - l6))), "cleanTrend", Integer.valueOf(k), "changeSwitch", Integer.valueOf(j) });
                      localObject1 = hdS().iterator();
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject5 = (FileSystem.b)((Iterator)localObject1).next();
                        paramCancellationSignal.throwIfCanceled();
                        ((FileSystem.b)localObject5).a(paramCancellationSignal);
                        continue;
                      }
                      AppMethodBeat.o(197195);
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
    
    public final ReadableByteChannel boI(String paramString)
    {
      AppMethodBeat.i(197190);
      ReadableByteChannel localReadableByteChannel = this.Rbp.boI(paramString);
      dA(paramString, false);
      AppMethodBeat.o(197190);
      return localReadableByteChannel;
    }
    
    public final ByteChannel boJ(String paramString)
    {
      AppMethodBeat.i(197193);
      ByteChannel localByteChannel = this.Rbp.boJ(paramString);
      dA(paramString, true);
      AppMethodBeat.o(197193);
      return localByteChannel;
    }
    
    public final WritableByteChannel dv(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197192);
      WritableByteChannel localWritableByteChannel = this.Rbp.dv(paramString, paramBoolean);
      dA(paramString, true);
      AppMethodBeat.o(197192);
      return localWritableByteChannel;
    }
    
    public final OutputStream dw(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(197191);
      OutputStream localOutputStream = this.Rbp.dw(paramString, paramBoolean);
      dA(paramString, true);
      AppMethodBeat.o(197191);
      return localOutputStream;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(197197);
      for (;;)
      {
        synchronized (this.RaY)
        {
          if (this.RaZ.isEmpty()) {
            break label153;
          }
          paramMessage = this.RaZ;
          this.RaZ = new HashMap();
          if (paramMessage == null) {
            break label145;
          }
          ??? = paramMessage.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.Rbp.ck((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
        }
        Log.d("VFS.CleanExpireFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label145:
        AppMethodBeat.o(197197);
        return true;
        label153:
        paramMessage = null;
      }
    }
    
    public final ParcelFileDescriptor nr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(197194);
      ParcelFileDescriptor localParcelFileDescriptor = this.Rbp.nr(paramString1, paramString2);
      dA(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(197194);
      return localParcelFileDescriptor;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(197189);
      InputStream localInputStream = this.Rbp.openRead(paramString);
      dA(paramString, false);
      AppMethodBeat.o(197189);
      return localInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.CleanExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */