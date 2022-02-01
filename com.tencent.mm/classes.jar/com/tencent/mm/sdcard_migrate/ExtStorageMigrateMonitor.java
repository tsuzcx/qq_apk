package com.tencent.mm.sdcard_migrate;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
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
  private static final String CURRENT_PROCESS_NAME;
  private static final PeriodRecorder UUt;
  private static final boolean[] UUu;
  private static final PendingOps UUv;
  private static final a UUw;
  
  static
  {
    AppMethodBeat.i(176861);
    CURRENT_PROCESS_NAME = d.cQP;
    UUt = new PeriodRecorder("ExtStorageMigrateMonitor", TimeUnit.DAYS.toMillis(1L), true, true);
    UUu = new boolean[] { false };
    UUv = new PendingOps((byte)0);
    UUw = new a()
    {
      private static void a(int paramAnonymousInt, String paramAnonymousString1, Throwable arg2, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176852);
        Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        localObject = "[@" + ((SimpleDateFormat)localObject).format(new Date()) + "|" + ExtStorageMigrateMonitor.CURRENT_PROCESS_NAME + "]";
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
          synchronized (ExtStorageMigrateMonitor.hsN())
          {
            if (ExtStorageMigrateMonitor.hsN()[0] != 0) {
              ExtStorageMigrateMonitor.Z(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
            }
            while (paramAnonymousInt == 3)
            {
              AppMethodBeat.o(176852);
              return;
              paramAnonymousString2 = (String)localObject + String.format(paramAnonymousString2, paramAnonymousVarArgs);
              break;
            }
            ExtStorageMigrateMonitor.hsO().aa(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(195941);
        Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(3, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(195941);
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
  
  public static void Um(long paramLong)
  {
    AppMethodBeat.i(176859);
    if (!UUt.isExpired("idkey_1315_" + paramLong))
    {
      AppMethodBeat.o(176859);
      return;
    }
    synchronized (UUu)
    {
      if (UUu[0] != 0)
      {
        r(1315L, paramLong, 1L);
        AppMethodBeat.o(176859);
        return;
      }
      UUv.t(1315L, paramLong, 1L);
    }
  }
  
  public static a hsJ()
  {
    return UUw;
  }
  
  public static void hsK()
  {
    AppMethodBeat.i(176860);
    String str = d.fcb.getApplication().getPackageName();
    if (!d.cQP.equals(str))
    {
      AppMethodBeat.o(176860);
      return;
    }
    g.ieN().Wo(500L).d(new a()
    {
      private static Void bFz()
      {
        AppMethodBeat.i(176857);
        Object localObject3;
        for (;;)
        {
          synchronized (ExtStorageMigrateMonitor.hsN())
          {
            ExtStorageMigrateMonitor.hsN()[0] = 1;
            ??? = ExtStorageMigrateMonitor.hsP();
            if (??? == null) {
              break;
            }
            Iterator localIterator = ExtStorageMigrateMonitor.PendingOps.a((ExtStorageMigrateMonitor.PendingOps)???).iterator();
            if (localIterator.hasNext())
            {
              ExtStorageMigrateMonitor.PendingOps.a locala = (ExtStorageMigrateMonitor.PendingOps.a)localIterator.next();
              ExtStorageMigrateMonitor.s(locala.id, locala.key, locala.value);
            }
          }
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.Z(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).msg);
          continue;
          ExtStorageMigrateMonitor.hsQ();
        }
        ??? = ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.hsO()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.a)((Iterator)???).next();
          ExtStorageMigrateMonitor.s(((ExtStorageMigrateMonitor.PendingOps.a)localObject3).id, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).key, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).value);
        }
        ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.hsO()).clear();
        ??? = ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.hsO()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.Z(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).msg);
        }
        ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.hsO()).clear();
        AppMethodBeat.o(176857);
        return null;
      }
    });
    AppMethodBeat.o(176860);
  }
  
  private static PendingOps hsL()
  {
    AppMethodBeat.i(214031);
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
            AppMethodBeat.o(214031);
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
        AppMethodBeat.o(214031);
        throw localObject2;
      }
    }
    catch (Throwable localThrowable)
    {
      UUw.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to load from persist storage.", new Object[0]);
      AppMethodBeat.o(214031);
      return null;
    }
    AppMethodBeat.o(214031);
    return null;
  }
  
  public static void hsM()
  {
    AppMethodBeat.i(214033);
    try
    {
      PendingOps localPendingOps = new PendingOps((byte)0);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_extstg_mon_pending_ops");
      Object localObject1 = hsL();
      if (localObject1 != null)
      {
        PendingOps.a(localPendingOps).addAll(PendingOps.a((PendingOps)localObject1));
        PendingOps.b(localPendingOps).addAll(PendingOps.b((PendingOps)localObject1));
      }
      PendingOps.a(localPendingOps).addAll(PendingOps.a(UUv));
      PendingOps.b(localPendingOps).addAll(PendingOps.b(UUv));
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
        PendingOps.a(UUv).clear();
        PendingOps.b(UUv).clear();
        AppMethodBeat.o(214033);
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Parcel)localObject1).recycle();
        }
        AppMethodBeat.o(214033);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      UUw.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to flush to persist storage.", new Object[0]);
      AppMethodBeat.o(214033);
    }
  }
  
  private static void r(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(185089);
    f.Iyx.idkeyStat(paramLong1, paramLong2, paramLong3, true);
    AppMethodBeat.o(185089);
  }
  
  static class PendingOps
    implements Parcelable
  {
    public static final Parcelable.Creator<PendingOps> CREATOR;
    private final List<a> UUx;
    private final List<b> UUy;
    
    static
    {
      AppMethodBeat.i(194122);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(194122);
    }
    
    private PendingOps()
    {
      AppMethodBeat.i(194113);
      this.UUx = Collections.synchronizedList(new ArrayList(16));
      this.UUy = Collections.synchronizedList(new ArrayList(32));
      AppMethodBeat.o(194113);
    }
    
    final void aa(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(194116);
      this.UUy.add(new b(paramInt, paramString1, paramString2));
      AppMethodBeat.o(194116);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void t(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194115);
      this.UUx.add(new a(paramLong1, paramLong2, paramLong3));
      AppMethodBeat.o(194115);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(194118);
      paramParcel.writeInt(-33554431);
      paramParcel.writeInt(this.UUx.size());
      Iterator localIterator = this.UUx.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        paramParcel.writeLong(((a)localObject).id);
        paramParcel.writeLong(((a)localObject).key);
        paramParcel.writeLong(((a)localObject).value);
      }
      paramParcel.writeInt(this.UUy.size());
      localIterator = this.UUy.iterator();
      while (localIterator.hasNext())
      {
        localObject = (b)localIterator.next();
        paramParcel.writeInt(((b)localObject).level);
        paramParcel.writeString(((b)localObject).tag);
        paramParcel.writeString(((b)localObject).msg);
      }
      AppMethodBeat.o(194118);
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
        AppMethodBeat.i(202207);
        String str = "IDKeyOp {id:" + this.id + ", key:" + this.key + ", value:" + this.value + "}";
        AppMethodBeat.o(202207);
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
        AppMethodBeat.i(196862);
        String str = "LogOp {level:" + this.level + ", tag:" + this.tag + ", msg:" + this.msg + "}";
        AppMethodBeat.o(196862);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor
 * JD-Core Version:    0.7.0.1
 */