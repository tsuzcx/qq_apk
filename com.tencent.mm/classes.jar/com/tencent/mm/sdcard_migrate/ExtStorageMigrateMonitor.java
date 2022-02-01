package com.tencent.mm.sdcard_migrate;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.e;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.tinker.entry.ApplicationLike;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class ExtStorageMigrateMonitor
{
  private static final String acpD;
  private static final PeriodRecorder acpE;
  private static final boolean[] acpF;
  private static final PendingOps acpG;
  private static final a acpH;
  
  static
  {
    AppMethodBeat.i(176861);
    acpD = e.eMg;
    acpE = new PeriodRecorder("ExtStorageMigrateMonitor", TimeUnit.DAYS.toMillis(1L), true, true);
    acpF = new boolean[] { false };
    acpG = new PendingOps((byte)0);
    acpH = new a()
    {
      private static void a(int paramAnonymousInt, String paramAnonymousString1, Throwable arg2, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176852);
        Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        localObject = "[@" + ((SimpleDateFormat)localObject).format(new Date()) + "|" + ExtStorageMigrateMonitor.acpD + "]";
        if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length == 0)) {
          paramAnonymousString2 = (String)localObject + paramAnonymousString2;
        }
        for (;;)
        {
          paramAnonymousVarArgs = paramAnonymousString2;
          if (??? != null)
          {
            paramAnonymousVarArgs = new StringWriter();
            localObject = new PrintWriter(paramAnonymousVarArgs);
            ???.printStackTrace((PrintWriter)localObject);
            ((PrintWriter)localObject).flush();
            paramAnonymousVarArgs = paramAnonymousString2 + "\n" + paramAnonymousVarArgs.toString();
            ((PrintWriter)localObject).close();
          }
          synchronized (ExtStorageMigrateMonitor.iSS())
          {
            if (ExtStorageMigrateMonitor.iSS()[0] != 0) {
              ExtStorageMigrateMonitor.ac(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
            }
            while (paramAnonymousInt == 3)
            {
              AppMethodBeat.o(176852);
              return;
              paramAnonymousString2 = (String)localObject + String.format(paramAnonymousString2, paramAnonymousVarArgs);
              break;
            }
            ExtStorageMigrateMonitor.iST().ad(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(257266);
        Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(3, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(257266);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176855);
        Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176855);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176853);
        Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(4, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176853);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176856);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176856);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176854);
        Log.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(5, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176854);
      }
    };
    AppMethodBeat.o(176861);
  }
  
  public static a iSO()
  {
    return acpH;
  }
  
  public static void iSP()
  {
    AppMethodBeat.i(176860);
    String str = e.hfI.getApplication().getPackageName();
    if (!e.eMg.equals(str))
    {
      AppMethodBeat.o(176860);
      return;
    }
    g.jJU().AA(500L).d(new a()
    {
      private static Void ceW()
      {
        AppMethodBeat.i(176857);
        Object localObject3;
        for (;;)
        {
          synchronized (ExtStorageMigrateMonitor.iSS())
          {
            ExtStorageMigrateMonitor.iSS()[0] = 1;
            ??? = ExtStorageMigrateMonitor.iSU();
            if (??? == null) {
              break;
            }
            Iterator localIterator = ExtStorageMigrateMonitor.PendingOps.a((ExtStorageMigrateMonitor.PendingOps)???).iterator();
            if (localIterator.hasNext())
            {
              ExtStorageMigrateMonitor.PendingOps.a locala = (ExtStorageMigrateMonitor.PendingOps.a)localIterator.next();
              ExtStorageMigrateMonitor.w(locala.id, locala.key, locala.value);
            }
          }
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.ac(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).msg);
          continue;
          ExtStorageMigrateMonitor.iSV();
        }
        ??? = ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.iST()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.a)((Iterator)???).next();
          ExtStorageMigrateMonitor.w(((ExtStorageMigrateMonitor.PendingOps.a)localObject3).id, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).key, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).value);
        }
        ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.iST()).clear();
        ??? = ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.iST()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.ac(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).msg);
        }
        ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.iST()).clear();
        AppMethodBeat.o(176857);
        return null;
      }
    });
    AppMethodBeat.o(176860);
  }
  
  private static PendingOps iSQ()
  {
    AppMethodBeat.i(257261);
    try
    {
      Object localObject1 = MultiProcessMMKV.getMMKV("mmkv_extstg_mon_pending_ops").decodeBytes("mmkv_key_pendingops");
      if (localObject1 != null)
      {
        try
        {
          localParcel = Parcel.obtain();
          if (localParcel == null) {
            break label76;
          }
        }
        finally
        {
          try
          {
            localParcel.unmarshall((byte[])localObject1, 0, localObject1.length);
            localParcel.setDataPosition(0);
            localObject1 = (PendingOps)PendingOps.CREATOR.createFromParcel(localParcel);
            if (localParcel != null) {
              localParcel.recycle();
            }
            AppMethodBeat.o(257261);
            return localObject1;
          }
          finally
          {
            Parcel localParcel;
            break label68;
          }
          localObject2 = finally;
          localParcel = null;
        }
        label68:
        localParcel.recycle();
        label76:
        AppMethodBeat.o(257261);
        throw localObject2;
      }
    }
    finally
    {
      acpH.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to load from persist storage.", new Object[0]);
      AppMethodBeat.o(257261);
      return null;
    }
    AppMethodBeat.o(257261);
    return null;
  }
  
  public static void iSR()
  {
    AppMethodBeat.i(257267);
    try
    {
      PendingOps localPendingOps = new PendingOps((byte)0);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_extstg_mon_pending_ops");
      Object localObject1 = iSQ();
      if (localObject1 != null)
      {
        PendingOps.a(localPendingOps).addAll(PendingOps.a((PendingOps)localObject1));
        PendingOps.b(localPendingOps).addAll(PendingOps.b((PendingOps)localObject1));
      }
      PendingOps.a(localPendingOps).addAll(PendingOps.a(acpG));
      PendingOps.b(localPendingOps).addAll(PendingOps.b(acpG));
      localObject1 = null;
      try
      {
        Parcel localParcel = Parcel.obtain();
        localObject1 = localParcel;
        localPendingOps.writeToParcel(localParcel, 0);
        localObject1 = localParcel;
        localMultiProcessMMKV.encode("mmkv_key_pendingops", localParcel.marshall());
        if (localParcel != null) {
          localParcel.recycle();
        }
        PendingOps.a(acpG).clear();
        PendingOps.b(acpG).clear();
        AppMethodBeat.o(257267);
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Parcel)localObject1).recycle();
        }
        AppMethodBeat.o(257267);
      }
      return;
    }
    finally
    {
      acpH.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to flush to persist storage.", new Object[0]);
      AppMethodBeat.o(257267);
    }
  }
  
  private static void v(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(185089);
    f.Ozc.idkeyStat(paramLong1, paramLong2, paramLong3, true);
    AppMethodBeat.o(185089);
  }
  
  public static void yy(long paramLong)
  {
    AppMethodBeat.i(176859);
    if (!acpE.isExpired("idkey_1315_" + paramLong))
    {
      AppMethodBeat.o(176859);
      return;
    }
    synchronized (acpF)
    {
      if (acpF[0] != 0)
      {
        v(1315L, paramLong, 1L);
        AppMethodBeat.o(176859);
        return;
      }
      acpG.x(1315L, paramLong, 1L);
    }
  }
  
  static class PendingOps
    implements Parcelable
  {
    public static final Parcelable.Creator<PendingOps> CREATOR;
    private final List<a> acpI;
    private final List<b> acpJ;
    
    static
    {
      AppMethodBeat.i(257145);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(257145);
    }
    
    private PendingOps()
    {
      AppMethodBeat.i(257120);
      this.acpI = Collections.synchronizedList(new ArrayList(16));
      this.acpJ = Collections.synchronizedList(new ArrayList(32));
      AppMethodBeat.o(257120);
    }
    
    final void ad(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(257159);
      this.acpJ.add(new b(paramInt, paramString1, paramString2));
      AppMethodBeat.o(257159);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(257171);
      paramParcel.writeInt(-33554431);
      paramParcel.writeInt(this.acpI.size());
      Iterator localIterator = this.acpI.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        paramParcel.writeLong(((a)localObject).id);
        paramParcel.writeLong(((a)localObject).key);
        paramParcel.writeLong(((a)localObject).value);
      }
      paramParcel.writeInt(this.acpJ.size());
      localIterator = this.acpJ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (b)localIterator.next();
        paramParcel.writeInt(((b)localObject).level);
        paramParcel.writeString(((b)localObject).tag);
        paramParcel.writeString(((b)localObject).msg);
      }
      AppMethodBeat.o(257171);
    }
    
    final void x(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(257154);
      this.acpI.add(new a(paramLong1, paramLong2, paramLong3));
      AppMethodBeat.o(257154);
    }
    
    static final class a
    {
      long id;
      long key;
      long value;
      
      a(long paramLong1, long paramLong2, long paramLong3)
      {
        this.id = paramLong1;
        this.key = paramLong2;
        this.value = paramLong3;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(257092);
        String str = "IDKeyOp {id:" + this.id + ", key:" + this.key + ", value:" + this.value + "}";
        AppMethodBeat.o(257092);
        return str;
      }
    }
    
    static final class b
    {
      int level;
      String msg;
      String tag;
      
      b(int paramInt, String paramString1, String paramString2)
      {
        this.level = paramInt;
        this.tag = paramString1;
        this.msg = paramString2;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(257096);
        String str = "LogOp {level:" + this.level + ", tag:" + this.tag + ", msg:" + this.msg + "}";
        AppMethodBeat.o(257096);
        return str;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor
 * JD-Core Version:    0.7.0.1
 */