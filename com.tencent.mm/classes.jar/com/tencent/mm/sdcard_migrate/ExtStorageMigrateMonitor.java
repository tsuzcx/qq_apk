package com.tencent.mm.sdcard_migrate;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.az;
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
  private static final String HZm;
  private static final az HZn;
  private static final boolean[] HZo;
  private static final PendingOps HZp;
  private static final a HZq;
  
  static
  {
    AppMethodBeat.i(176861);
    HZm = d.cDP;
    HZn = new az("ExtStorageMigrateMonitor", TimeUnit.DAYS.toMillis(1L));
    HZo = new boolean[] { false };
    HZp = new PendingOps((byte)0);
    HZq = new a()
    {
      private static void a(int paramAnonymousInt, String paramAnonymousString1, Throwable arg2, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176852);
        Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        localObject = "[@" + ((SimpleDateFormat)localObject).format(new Date()) + "|" + ExtStorageMigrateMonitor.HZm + "]";
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
          synchronized (ExtStorageMigrateMonitor.fjj())
          {
            if (ExtStorageMigrateMonitor.fjj()[0] != 0) {
              ExtStorageMigrateMonitor.T(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
            }
            while (paramAnonymousInt == 3)
            {
              AppMethodBeat.o(176852);
              return;
              paramAnonymousString2 = (String)localObject + String.format(paramAnonymousString2, paramAnonymousVarArgs);
              break;
            }
            ExtStorageMigrateMonitor.fjk().U(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(189870);
        ad.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(3, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(189870);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176855);
        ad.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176855);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176853);
        ad.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(4, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176853);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176856);
        ad.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176856);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176854);
        ad.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(5, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176854);
      }
    };
    AppMethodBeat.o(176861);
  }
  
  public static void CQ(long paramLong)
  {
    AppMethodBeat.i(176859);
    if (!HZn.aQG("idkey_1315_".concat(String.valueOf(paramLong))))
    {
      AppMethodBeat.o(176859);
      return;
    }
    synchronized (HZo)
    {
      if (HZo[0] != 0)
      {
        p(1315L, paramLong, 1L);
        AppMethodBeat.o(176859);
        return;
      }
      HZp.r(1315L, paramLong, 1L);
    }
  }
  
  public static a fjf()
  {
    return HZq;
  }
  
  public static void fjg()
  {
    AppMethodBeat.i(176860);
    String str = d.cTo.getApplication().getPackageName();
    if (!d.cDP.equals(str))
    {
      AppMethodBeat.o(176860);
      return;
    }
    g.fOf().Et(500L).d(new a()
    {
      private static Void aYJ()
      {
        AppMethodBeat.i(176857);
        synchronized (ExtStorageMigrateMonitor.fjj())
        {
          ExtStorageMigrateMonitor.fjj()[0] = 1;
          ??? = ExtStorageMigrateMonitor.fjl();
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
        ExtStorageMigrateMonitor.fjm();
        label134:
        ??? = ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.fjk()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.a)((Iterator)???).next();
          ExtStorageMigrateMonitor.q(((ExtStorageMigrateMonitor.PendingOps.a)localObject3).id, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).key, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).value);
        }
        ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.fjk()).clear();
        ??? = ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.fjk()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.T(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).msg);
        }
        ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.fjk()).clear();
        AppMethodBeat.o(176857);
        return null;
      }
    });
    AppMethodBeat.o(176860);
  }
  
  private static PendingOps fjh()
  {
    AppMethodBeat.i(189879);
    try
    {
      Object localObject1 = ax.aQz("mmkv_extstg_mon_pending_ops").decodeBytes("mmkv_key_pendingops");
      if (localObject1 != null)
      {
        try
        {
          localParcel = Parcel.obtain();
          if (localParcel == null) {
            break label71;
          }
        }
        finally
        {
          try
          {
            localParcel.unmarshall((byte[])localObject1, 0, localObject1.length);
            localObject1 = (PendingOps)PendingOps.CREATOR.createFromParcel(localParcel);
            if (localParcel != null) {
              localParcel.recycle();
            }
            AppMethodBeat.o(189879);
            return localObject1;
          }
          finally
          {
            Parcel localParcel;
            break label63;
          }
          localObject2 = finally;
          localParcel = null;
        }
        label63:
        localParcel.recycle();
        label71:
        AppMethodBeat.o(189879);
        throw localObject2;
      }
    }
    catch (Throwable localThrowable)
    {
      HZq.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to load from persist storage.", new Object[0]);
      AppMethodBeat.o(189879);
      return null;
    }
    AppMethodBeat.o(189879);
    return null;
  }
  
  public static void fji()
  {
    AppMethodBeat.i(189880);
    try
    {
      PendingOps localPendingOps = new PendingOps((byte)0);
      ax localax = ax.aQz("mmkv_extstg_mon_pending_ops");
      Object localObject1 = fjh();
      if (localObject1 != null)
      {
        PendingOps.a(localPendingOps).addAll(PendingOps.a((PendingOps)localObject1));
        PendingOps.b(localPendingOps).addAll(PendingOps.b((PendingOps)localObject1));
      }
      PendingOps.a(localPendingOps).addAll(PendingOps.a(HZp));
      PendingOps.b(localPendingOps).addAll(PendingOps.b(HZp));
      localObject1 = null;
      try
      {
        Parcel localParcel = Parcel.obtain();
        localObject1 = localParcel;
        localPendingOps.writeToParcel(localParcel, 0);
        localObject1 = localParcel;
        localax.encode("mmkv_key_pendingops", localParcel.marshall());
        if (localParcel != null) {
          localParcel.recycle();
        }
        PendingOps.a(HZp).clear();
        PendingOps.b(HZp).clear();
        AppMethodBeat.o(189880);
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Parcel)localObject1).recycle();
        }
        AppMethodBeat.o(189880);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      HZq.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to flush to persist storage.", new Object[0]);
      AppMethodBeat.o(189880);
    }
  }
  
  private static void p(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(185089);
    e.ygI.idkeyStat(paramLong1, paramLong2, paramLong3, true);
    AppMethodBeat.o(185089);
  }
  
  static class PendingOps
    implements Parcelable
  {
    public static final Parcelable.Creator<PendingOps> CREATOR;
    private final List<a> HZr;
    private final List<b> HZs;
    
    static
    {
      AppMethodBeat.i(189878);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(189878);
    }
    
    private PendingOps()
    {
      AppMethodBeat.i(189874);
      this.HZr = Collections.synchronizedList(new ArrayList(16));
      this.HZs = Collections.synchronizedList(new ArrayList(32));
      AppMethodBeat.o(189874);
    }
    
    final void U(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(189876);
      this.HZs.add(new b(paramInt, paramString1, paramString2));
      AppMethodBeat.o(189876);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void r(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(189875);
      this.HZr.add(new a(paramLong1, paramLong2, paramLong3));
      AppMethodBeat.o(189875);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(189877);
      paramParcel.writeInt(-33554431);
      paramParcel.writeInt(this.HZr.size());
      Iterator localIterator = this.HZr.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        paramParcel.writeLong(((a)localObject).id);
        paramParcel.writeLong(((a)localObject).key);
        paramParcel.writeLong(((a)localObject).value);
      }
      paramParcel.writeInt(this.HZs.size());
      localIterator = this.HZs.iterator();
      while (localIterator.hasNext())
      {
        localObject = (b)localIterator.next();
        paramParcel.writeInt(((b)localObject).level);
        paramParcel.writeString(((b)localObject).tag);
        paramParcel.writeString(((b)localObject).msg);
      }
      AppMethodBeat.o(189877);
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
        AppMethodBeat.i(189872);
        String str = "IDKeyOp {id:" + this.id + ", key:" + this.key + ", value:" + this.value + "}";
        AppMethodBeat.o(189872);
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
        AppMethodBeat.i(189873);
        String str = "LogOp {level:" + this.level + ", tag:" + this.tag + ", msg:" + this.msg + "}";
        AppMethodBeat.o(189873);
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