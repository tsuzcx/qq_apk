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
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ah;
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
  private final boolean LFG;
  private final long LFH;
  
  static
  {
    AppMethodBeat.i(193644);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(193644);
  }
  
  protected CleanExpireFileSystem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(193640);
    this.LFH = 60000L;
    w.a(paramParcel, CleanExpireFileSystem.class, 2);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.LFG = bool;
      AppMethodBeat.o(193640);
      return;
    }
  }
  
  public CleanExpireFileSystem(FileSystem paramFileSystem)
  {
    super(paramFileSystem, l1);
    AppMethodBeat.i(193639);
    this.LFH = 60000L;
    this.LFG = true;
    AppMethodBeat.o(193639);
  }
  
  public final FileSystem.b cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(193641);
    paramMap = new a(this.LFX.cd(paramMap));
    AppMethodBeat.o(193641);
    return paramMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193643);
    String str = "CleanExpire [" + this.LFX.toString() + "]";
    AppMethodBeat.o(193643);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(193642);
    super.writeToParcel(paramParcel, paramInt);
    w.b(paramParcel, CleanExpireFileSystem.class, 2);
    if (this.LFG) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(193642);
      return;
    }
  }
  
  protected final class a
    extends ExpireFileSystem.a
    implements Handler.Callback
  {
    private final Object LFI;
    private HashMap<String, Long> LFJ;
    private final Handler LFK;
    
    public a(FileSystem.b paramb)
    {
      super(paramb);
      AppMethodBeat.i(193628);
      this.LFI = new Object();
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        this.LFJ = new HashMap();
        this.LFK = new Handler(e.fSU().OAH.getLooper(), this);
        AppMethodBeat.o(193628);
        return;
      }
      this.LFJ = null;
      this.LFK = null;
      AppMethodBeat.o(193628);
    }
    
    @TargetApi(21)
    private static long b(c paramc)
    {
      AppMethodBeat.i(193637);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramc != null) {
        localObject1 = localObject2;
      }
      try
      {
        if (paramc.LGe != null)
        {
          localObject1 = localObject2;
          if ((paramc.LGe.fSK() instanceof NativeFileSystem)) {
            localObject1 = Os.stat(paramc.LGe.de(paramc.Itr, false));
          }
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(193637);
          return -1L;
        }
        long l = ((StructStat)localObject1).st_ctime;
        AppMethodBeat.o(193637);
        return l;
      }
      catch (ErrnoException paramc)
      {
        AppMethodBeat.o(193637);
      }
      return -1L;
    }
    
    private void df(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193629);
      if (!CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        AppMethodBeat.o(193629);
        return;
      }
      if (paramBoolean) {
        synchronized (this.LFI)
        {
          this.LFJ.remove(paramString);
          AppMethodBeat.o(193629);
          return;
        }
      }
      long l = System.currentTimeMillis();
      synchronized (this.LFI)
      {
        paramBoolean = this.LFJ.isEmpty();
        this.LFJ.put(paramString, Long.valueOf(l));
        if (paramBoolean) {
          this.LFK.sendMessageDelayed(Message.obtain(), 60000L);
        }
        AppMethodBeat.o(193629);
        return;
      }
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(193636);
      CleanExpireFileSystem.this.k(1, new Object[0]);
      Object localObject1;
      if (CleanExpireFileSystem.a(CleanExpireFileSystem.this))
      {
        localObject1 = null;
        synchronized (this.LFI)
        {
          if (!this.LFJ.isEmpty())
          {
            localObject1 = this.LFJ;
            this.LFJ = new HashMap();
          }
          if (localObject1 != null)
          {
            localObject1 = ((HashMap)localObject1).entrySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ??? = (Map.Entry)((Iterator)localObject1).next();
              paramCancellationSignal.throwIfCanceled();
              this.LFY.cp((String)((Map.Entry)???).getKey(), ((Long)((Map.Entry)???).getValue()).longValue());
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
      Object localObject6 = ay.aRW("CleanExpireFileSystem");
      long l1 = ((ay)localObject6).getLong("CleanExpireCurrentExpireTime", 0L);
      long l4 = bu.getLong(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_default_expire_time", Long.toString(604800000L), false, true), 604800000L);
      if ((l1 < 0L) || (l1 > l4))
      {
        ((ay)localObject6).encode("CleanExpireCurrentExpireTime", l4);
        l1 = l4;
      }
      for (;;)
      {
        long l6 = System.currentTimeMillis();
        int n = ah.ftX().getCount();
        int i1 = bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_storage_min", "100", false, true), 100);
        float f2;
        int j;
        if (n > i1)
        {
          localObject1 = ah.ftX();
          ??? = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "id", "CleanDeleteItem" });
          ae.d("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount:".concat(String.valueOf(???)));
          localObject1 = ((ah)localObject1).db.rawQuery((String)???, null);
          i = 0;
          if (localObject1 == null)
          {
            ae.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
            i = 0;
          }
          for (;;)
          {
            f2 = i * 1000000.0F / n;
            i = bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_ratio_list_size", "28", false, true), 28);
            ??? = ((ay)localObject6).getString("CleanExpireRepetitionRatioList", "");
            localObject1 = new yt();
            if (!bu.isNullOrNil((String)???)) {}
            try
            {
              ((yt)localObject1).parseFrom(((String)???).getBytes("ISO-8859-1"));
              if (((yt)localObject1).GqA == null) {
                ((yt)localObject1).GqA = new LinkedList();
              }
              while (((yt)localObject1).GqA.size() > i)
              {
                ((yt)localObject1).GqA.removeFirst();
                continue;
                if (((Cursor)localObject1).moveToFirst()) {
                  i = ((Cursor)localObject1).getInt(0);
                }
                ((Cursor)localObject1).close();
                ae.i("MicroMsg.CleanDeleteItemStorage", "calculateRepetitionCount, count:%d,", new Object[] { Integer.valueOf(i) });
              }
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                ae.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException1.getMessage() });
              }
              ((yt)localObject1).GqA.add(Float.valueOf(f2));
              j = ((yt)localObject1).GqA.size();
            }
          }
        }
        for (;;)
        {
          try
          {
            ((ay)localObject6).encode("CleanExpireRepetitionRatioList", new String(((yt)localObject1).toByteArray(), d.n.d.ISO_8859_1));
            if (j >= bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_ratio_min_size", "7", false, true), 7))
            {
              m = bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_change_switch", "2", false, true), 2);
              if (m > 0)
              {
                d2 = 0.0D;
                if (m == 1)
                {
                  d2 = bu.getFloat(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_ratio_left_range", "0.009", false, true), 0.009F) * 1000000.0F;
                  d1 = bu.getFloat(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_ratio_right_range", "0.011", false, true), 0.011F) * 1000000.0F;
                  l2 = bu.getLong(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_time_change_threshold", Long.valueOf(259200000L).toString(), false, true), 259200000L);
                  l3 = bu.getLong(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_time_change_step", Long.valueOf(86400000L).toString(), false, true), 86400000L);
                  f1 = bu.getFloat(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_time_change_step_ratio", Float.valueOf(888888.88F).toString(), false, true), 888888.88F);
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
                  ((ay)localObject6).encode("CleanExpireCurrentExpireTime", l2);
                  k = i;
                  ah.ftX().a(l4, localPLong1, localPLong2);
                  localObject1 = ah.ftX();
                  Object localObject3 = String.format("SELECT SUM(IdCount) FROM (SELECT COUNT( %s ) AS IdCount FROM %s WHERE %s >= %d GROUP BY %s ) %s WHERE IdCount > 1", new Object[] { "id", "CleanDeleteItem", "saveTime", Long.valueOf(l4), "id", "CleanDeleteItem" });
                  ae.d("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount:".concat(String.valueOf(localObject3)));
                  localObject1 = ((ah)localObject1).db.rawQuery((String)localObject3, null);
                  i = 0;
                  if (localObject1 != null) {
                    continue;
                  }
                  ae.e("MicroMsg.CleanDeleteItemStorage", "calculateTheRepetitionRatio failed");
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
                  localObject1 = this.LFY.dc("", true);
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((Iterable)localObject1).iterator();
                  l3 = 0L;
                  l4 = l3;
                  if (!((Iterator)localObject1).hasNext()) {
                    continue;
                  }
                  localObject3 = (c)((Iterator)localObject1).next();
                  paramCancellationSignal.throwIfCanceled();
                  if ((((c)localObject3).LGd) || (((c)localObject3).LGc > l8 - l2)) {
                    continue;
                  }
                  long l9 = b((c)localObject3);
                  l4 = l3;
                  if (((c)localObject3).delete())
                  {
                    if (((c)localObject3).LGb >= 0L) {
                      continue;
                    }
                    l5 = ((c)localObject3).size;
                    l3 += l5;
                    l4 = l3;
                    if (!((c)localObject3).name.endsWith(".nomedia"))
                    {
                      localObject6 = new ag();
                      ((ag)localObject6).field_createTime = l9;
                      if (((ag)localObject6).field_createTime < 0L) {
                        ((ag)localObject6).field_createTime = ((c)localObject3).LGc;
                      }
                      ((ag)localObject6).field_modifyTime = ((c)localObject3).LGc;
                      ((ag)localObject6).field_deleteTime = System.currentTimeMillis();
                      ((ag)localObject6).field_id = ((c)localObject3).name;
                      ((ag)localObject6).field_saveTime = (((ag)localObject6).field_deleteTime - ((ag)localObject6).field_createTime);
                      ((ag)localObject6).field_size = l5;
                      ((ag)localObject6).field_flags = 0L;
                      ah.ftX().insert((com.tencent.mm.sdk.e.c)localObject6);
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
            ae.e("VFS.CleanExpireFileSystem", "toByteArray Failed: %s", new Object[] { localIOException2.getMessage() });
            continue;
            if (m == 2)
            {
              if (((yt)localObject1).GqA == null)
              {
                Object localObject4 = ((ay)localObject6).getString("CleanExpireRepetitionRatioList", "");
                localObject1 = new yt();
                if (!bu.isNullOrNil((String)localObject4)) {}
                Object localObject5;
                try
                {
                  ((yt)localObject1).parseFrom(((String)localObject4).getBytes("ISO-8859-1"));
                  if (((yt)localObject1).GqA == null) {
                    ((yt)localObject1).GqA = new LinkedList();
                  }
                  i = ((yt)localObject1).GqA.size();
                  f1 = 0.0F;
                  if (i <= 0) {
                    continue;
                  }
                  localObject7 = ((yt)localObject1).GqA.iterator();
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
                  ae.e("VFS.CleanExpireFileSystem", "Parsing Failed: %s", new Object[] { localIOException3.getMessage() });
                  continue;
                  f1 = localIOException3.floatValue() / i;
                  localObject5 = ((yt)localObject1).GqA.iterator();
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
                i = bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_ratio_left_range_var_count", "1", false, true), 1);
                k = bu.getInt(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_ratio_right_range_var_count", "2", false, true), 2);
                float f3 = 1000000.0F * bu.getFloat(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_min", "-1", false, true), -1.0F);
                float f4 = 1000000.0F * bu.getFloat(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_repetition_max", "-1", false, true), -1.0F);
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
                      ae.i("MicroMsg.CleanDeleteItemStorage", "calculateDefaultRepetitionCount, threshold:%d, count:%d,", new Object[] { Long.valueOf(l4), Integer.valueOf(i) });
                      continue;
                      l5 = ((c)localObject5).LGb;
                      continue;
                      l4 = 0L;
                      l3 = System.currentTimeMillis();
                      l5 = bu.getLong(com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_clean_expire_storage_count", "50000", false, true), 20000L);
                      if (ah.ftX().getCount() > l5)
                      {
                        localObject1 = ah.ftX();
                        l8 = ((ah)localObject1).getCount();
                        if (l8 <= l5) {
                          ae.i("MicroMsg.CleanDeleteItemStorage", "cleanDate don't need to clean");
                        }
                        localObject5 = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "CleanDeleteItem", "deleteTime", "deleteTime", "CleanDeleteItem", "deleteTime", Long.valueOf(l8 - l5) });
                        ae.d("MicroMsg.CleanDeleteItemStorage", "cleanData:".concat(String.valueOf(localObject5)));
                        ae.i("MicroMsg.CleanDeleteItemStorage", "cleanData result:%b, size:%d, originCount:%d, finalCount:%d", new Object[] { Boolean.valueOf(((ah)localObject1).db.execSQL("CleanDeleteItem", (String)localObject5)), Long.valueOf(l5), Long.valueOf(l8), Integer.valueOf(((ah)localObject1).getCount()) });
                      }
                      l5 = System.currentTimeMillis();
                      CleanExpireFileSystem.this.k(3, new Object[] { "cleanStorageCount", Integer.valueOf(n), "cleanRepetitionRatio", Float.valueOf(f2), "cleanRepetitionRatioCount", Integer.valueOf(i), "cleanStorageRepetitionRatio", Float.valueOf(f1), "cleanStorageDeleteSize", Long.valueOf(localPLong1.value), "cleanStorageFreeSize", Long.valueOf(localPLong2.value), "deleteSize", Long.valueOf(l4), "cleanOriginExpireTime", Long.valueOf(l1), "cleanNewExpireTime", Long.valueOf(l2), "cleanExtraCostTime", Long.valueOf(l5 - l3 + (-1L + (l7 - l6))), "cleanTrend", Integer.valueOf(k), "changeSwitch", Integer.valueOf(j) });
                      localObject1 = fSM().iterator();
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject5 = (FileSystem.b)((Iterator)localObject1).next();
                        paramCancellationSignal.throwIfCanceled();
                        ((FileSystem.b)localObject5).a(paramCancellationSignal);
                        continue;
                      }
                      AppMethodBeat.o(193636);
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
    
    public final ReadableByteChannel aZD(String paramString)
    {
      AppMethodBeat.i(193631);
      ReadableByteChannel localReadableByteChannel = this.LFY.aZD(paramString);
      df(paramString, false);
      AppMethodBeat.o(193631);
      return localReadableByteChannel;
    }
    
    public final ByteChannel aZE(String paramString)
    {
      AppMethodBeat.i(193634);
      ByteChannel localByteChannel = this.LFY.aZE(paramString);
      df(paramString, true);
      AppMethodBeat.o(193634);
      return localByteChannel;
    }
    
    public final WritableByteChannel da(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193633);
      WritableByteChannel localWritableByteChannel = this.LFY.da(paramString, paramBoolean);
      df(paramString, true);
      AppMethodBeat.o(193633);
      return localWritableByteChannel;
    }
    
    public final OutputStream db(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(193632);
      OutputStream localOutputStream = this.LFY.db(paramString, paramBoolean);
      df(paramString, true);
      AppMethodBeat.o(193632);
      return localOutputStream;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(193638);
      for (;;)
      {
        synchronized (this.LFI)
        {
          if (this.LFJ.isEmpty()) {
            break label153;
          }
          paramMessage = this.LFJ;
          this.LFJ = new HashMap();
          if (paramMessage == null) {
            break label145;
          }
          ??? = paramMessage.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.LFY.cp((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
        }
        ae.d("VFS.CleanExpireFileSystem", "Flush access time cache entries: " + paramMessage.size());
        label145:
        AppMethodBeat.o(193638);
        return true;
        label153:
        paramMessage = null;
      }
    }
    
    public final ParcelFileDescriptor mA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(193635);
      ParcelFileDescriptor localParcelFileDescriptor = this.LFY.mA(paramString1, paramString2);
      df(paramString1, paramString2.contains("w"));
      AppMethodBeat.o(193635);
      return localParcelFileDescriptor;
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(193630);
      InputStream localInputStream = this.LFY.openRead(paramString);
      df(paramString, false);
      AppMethodBeat.o(193630);
      return localInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.CleanExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */