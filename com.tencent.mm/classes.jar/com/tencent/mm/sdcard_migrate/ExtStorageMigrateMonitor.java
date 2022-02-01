package com.tencent.mm.sdcard_migrate;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ba;
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
  private static final String Itt;
  private static final ba Itu;
  private static final boolean[] Itv;
  private static final PendingOps Itw;
  private static final a Itx;
  
  static
  {
    AppMethodBeat.i(176861);
    Itt = d.cEw;
    Itu = new ba("ExtStorageMigrateMonitor", TimeUnit.DAYS.toMillis(1L));
    Itv = new boolean[] { false };
    Itw = new PendingOps((byte)0);
    Itx = new a()
    {
      private static void a(int paramAnonymousInt, String paramAnonymousString1, Throwable arg2, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176852);
        Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        localObject = "[@" + ((SimpleDateFormat)localObject).format(new Date()) + "|" + ExtStorageMigrateMonitor.Itt + "]";
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
          synchronized (ExtStorageMigrateMonitor.fnb())
          {
            if (ExtStorageMigrateMonitor.fnb()[0] != 0) {
              ExtStorageMigrateMonitor.T(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
            }
            while (paramAnonymousInt == 3)
            {
              AppMethodBeat.o(176852);
              return;
              paramAnonymousString2 = (String)localObject + String.format(paramAnonymousString2, paramAnonymousVarArgs);
              break;
            }
            ExtStorageMigrateMonitor.fnc().U(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(193588);
        ae.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(3, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(193588);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176855);
        ae.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176855);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176853);
        ae.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(4, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176853);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176856);
        ae.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176856);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176854);
        ae.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(5, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176854);
      }
    };
    AppMethodBeat.o(176861);
  }
  
  public static void Do(long paramLong)
  {
    AppMethodBeat.i(176859);
    if (!Itu.aSd("idkey_1315_".concat(String.valueOf(paramLong))))
    {
      AppMethodBeat.o(176859);
      return;
    }
    synchronized (Itv)
    {
      if (Itv[0] != 0)
      {
        p(1315L, paramLong, 1L);
        AppMethodBeat.o(176859);
        return;
      }
      Itw.r(1315L, paramLong, 1L);
    }
  }
  
  public static a fmX()
  {
    return Itx;
  }
  
  public static void fmY()
  {
    AppMethodBeat.i(176860);
    String str = d.cTZ.getApplication().getPackageName();
    if (!d.cEw.equals(str))
    {
      AppMethodBeat.o(176860);
      return;
    }
    g.fSA().EV(500L).d(new a()
    {
      private static Void aZf()
      {
        AppMethodBeat.i(176857);
        synchronized (ExtStorageMigrateMonitor.fnb())
        {
          ExtStorageMigrateMonitor.fnb()[0] = 1;
          ??? = ExtStorageMigrateMonitor.fnd();
          if (??? == null) {
            break label134;
          }
          Iterator localIterator = ExtStorageMigrateMonitor.PendingOps.a((ExtStorageMigrateMonitor.PendingOps)???).iterator();
          if (localIterator.hasNext())
          {
            ExtStorageMigrateMonitor.PendingOps.a locala = (ExtStorageMigrateMonitor.PendingOps.a)localIterator.next();
            ExtStorageMigrateMonitor.q(locala.id, locala.key, locala.value);
          }
        }
        ??? = ExtStorageMigrateMonitor.PendingOps.b((ExtStorageMigrateMonitor.PendingOps)???).iterator();
        Object localObject3;
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.T(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).msg);
        }
        ExtStorageMigrateMonitor.fne();
        label134:
        ??? = ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.fnc()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.a)((Iterator)???).next();
          ExtStorageMigrateMonitor.q(((ExtStorageMigrateMonitor.PendingOps.a)localObject3).id, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).key, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).value);
        }
        ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.fnc()).clear();
        ??? = ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.fnc()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.T(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).msg);
        }
        ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.fnc()).clear();
        AppMethodBeat.o(176857);
        return null;
      }
    });
    AppMethodBeat.o(176860);
  }
  
  private static PendingOps fmZ()
  {
    AppMethodBeat.i(193597);
    try
    {
      Object localObject1 = ay.aRW("mmkv_extstg_mon_pending_ops").decodeBytes("mmkv_key_pendingops");
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
            AppMethodBeat.o(193597);
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
        AppMethodBeat.o(193597);
        throw localObject2;
      }
    }
    catch (Throwable localThrowable)
    {
      Itx.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to load from persist storage.", new Object[0]);
      AppMethodBeat.o(193597);
      return null;
    }
    AppMethodBeat.o(193597);
    return null;
  }
  
  public static void fna()
  {
    AppMethodBeat.i(193598);
    try
    {
      PendingOps localPendingOps = new PendingOps((byte)0);
      ay localay = ay.aRW("mmkv_extstg_mon_pending_ops");
      Object localObject1 = fmZ();
      if (localObject1 != null)
      {
        PendingOps.a(localPendingOps).addAll(PendingOps.a((PendingOps)localObject1));
        PendingOps.b(localPendingOps).addAll(PendingOps.b((PendingOps)localObject1));
      }
      PendingOps.a(localPendingOps).addAll(PendingOps.a(Itw));
      PendingOps.b(localPendingOps).addAll(PendingOps.b(Itw));
      localObject1 = null;
      try
      {
        Parcel localParcel = Parcel.obtain();
        localObject1 = localParcel;
        localPendingOps.writeToParcel(localParcel, 0);
        localObject1 = localParcel;
        localay.encode("mmkv_key_pendingops", localParcel.marshall());
        if (localParcel != null) {
          localParcel.recycle();
        }
        PendingOps.a(Itw).clear();
        PendingOps.b(Itw).clear();
        AppMethodBeat.o(193598);
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Parcel)localObject1).recycle();
        }
        AppMethodBeat.o(193598);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Itx.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to flush to persist storage.", new Object[0]);
      AppMethodBeat.o(193598);
    }
  }
  
  private static void p(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(185089);
    e.ywz.idkeyStat(paramLong1, paramLong2, paramLong3, true);
    AppMethodBeat.o(185089);
  }
  
  static class PendingOps
    implements Parcelable
  {
    public static final Parcelable.Creator<PendingOps> CREATOR;
    private final List<a> Ity;
    private final List<b> Itz;
    
    static
    {
      AppMethodBeat.i(193596);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(193596);
    }
    
    private PendingOps()
    {
      AppMethodBeat.i(193592);
      this.Ity = Collections.synchronizedList(new ArrayList(16));
      this.Itz = Collections.synchronizedList(new ArrayList(32));
      AppMethodBeat.o(193592);
    }
    
    final void U(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(193594);
      this.Itz.add(new b(paramInt, paramString1, paramString2));
      AppMethodBeat.o(193594);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void r(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(193593);
      this.Ity.add(new a(paramLong1, paramLong2, paramLong3));
      AppMethodBeat.o(193593);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(193595);
      paramParcel.writeInt(-33554431);
      paramParcel.writeInt(this.Ity.size());
      Iterator localIterator = this.Ity.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        paramParcel.writeLong(((a)localObject).id);
        paramParcel.writeLong(((a)localObject).key);
        paramParcel.writeLong(((a)localObject).value);
      }
      paramParcel.writeInt(this.Itz.size());
      localIterator = this.Itz.iterator();
      while (localIterator.hasNext())
      {
        localObject = (b)localIterator.next();
        paramParcel.writeInt(((b)localObject).level);
        paramParcel.writeString(((b)localObject).tag);
        paramParcel.writeString(((b)localObject).msg);
      }
      AppMethodBeat.o(193595);
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
        AppMethodBeat.i(193590);
        String str = "IDKeyOp {id:" + this.id + ", key:" + this.key + ", value:" + this.value + "}";
        AppMethodBeat.o(193590);
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
        AppMethodBeat.i(193591);
        String str = "LogOp {level:" + this.level + ", tag:" + this.tag + ", msg:" + this.msg + "}";
        AppMethodBeat.o(193591);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor
 * JD-Core Version:    0.7.0.1
 */