package com.tencent.mm.sdcard_migrate;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ay;
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
  private static final ay GnA;
  private static final boolean[] GnB;
  private static final PendingOps GnC;
  private static final a GnD;
  private static final String Gnz;
  
  static
  {
    AppMethodBeat.i(176861);
    Gnz = d.csT;
    GnA = new ay("ExtStorageMigrateMonitor", TimeUnit.DAYS.toMillis(1L));
    GnB = new boolean[] { false };
    GnC = new PendingOps((byte)0);
    GnD = new a()
    {
      private static void a(int paramAnonymousInt, String paramAnonymousString1, Throwable arg2, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176852);
        Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        localObject = "[@" + ((SimpleDateFormat)localObject).format(new Date()) + "|" + ExtStorageMigrateMonitor.Gnz + "]";
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
          synchronized (ExtStorageMigrateMonitor.eTG())
          {
            if (ExtStorageMigrateMonitor.eTG()[0] != 0) {
              ExtStorageMigrateMonitor.Q(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
            }
            while (paramAnonymousInt == 3)
            {
              AppMethodBeat.o(176852);
              return;
              paramAnonymousString2 = (String)localObject + String.format(paramAnonymousString2, paramAnonymousVarArgs);
              break;
            }
            ExtStorageMigrateMonitor.eTH().R(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(206904);
        ac.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(3, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(206904);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176855);
        ac.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176855);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176853);
        ac.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(4, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176853);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176856);
        ac.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176856);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176854);
        ac.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(5, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176854);
      }
    };
    AppMethodBeat.o(176861);
  }
  
  public static void as(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(206913);
    if (!GnA.aLa("idkey_" + paramLong1 + "_" + paramLong2))
    {
      AppMethodBeat.o(206913);
      return;
    }
    synchronized (GnB)
    {
      if (GnB[0] != 0)
      {
        o(paramLong1, paramLong2, 1L);
        AppMethodBeat.o(206913);
        return;
      }
      GnC.q(paramLong1, paramLong2, 1L);
    }
  }
  
  public static a eTC()
  {
    return GnD;
  }
  
  public static void eTD()
  {
    AppMethodBeat.i(176860);
    String str = d.cIg.getApplication().getPackageName();
    if (!d.csT.equals(str))
    {
      AppMethodBeat.o(176860);
      return;
    }
    g.fxs().BB(500L).d(new a()
    {
      private static Void aVo()
      {
        AppMethodBeat.i(176857);
        synchronized (ExtStorageMigrateMonitor.eTG())
        {
          ExtStorageMigrateMonitor.eTG()[0] = 1;
          ??? = ExtStorageMigrateMonitor.eTI();
          if (??? == null) {
            break label134;
          }
          Iterator localIterator = ExtStorageMigrateMonitor.PendingOps.a((ExtStorageMigrateMonitor.PendingOps)???).iterator();
          if (localIterator.hasNext())
          {
            ExtStorageMigrateMonitor.PendingOps.a locala = (ExtStorageMigrateMonitor.PendingOps.a)localIterator.next();
            ExtStorageMigrateMonitor.p(locala.id, locala.key, locala.value);
          }
        }
        ??? = ExtStorageMigrateMonitor.PendingOps.b((ExtStorageMigrateMonitor.PendingOps)???).iterator();
        Object localObject3;
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.Q(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).bIO);
        }
        ExtStorageMigrateMonitor.eTJ();
        label134:
        ??? = ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.eTH()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.a)((Iterator)???).next();
          ExtStorageMigrateMonitor.p(((ExtStorageMigrateMonitor.PendingOps.a)localObject3).id, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).key, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).value);
        }
        ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.eTH()).clear();
        ??? = ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.eTH()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.Q(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).bIO);
        }
        ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.eTH()).clear();
        AppMethodBeat.o(176857);
        return null;
      }
    });
    AppMethodBeat.o(176860);
  }
  
  private static PendingOps eTE()
  {
    AppMethodBeat.i(206914);
    try
    {
      Object localObject1 = aw.aKT("mmkv_extstg_mon_pending_ops").decodeBytes("mmkv_key_pendingops");
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
            AppMethodBeat.o(206914);
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
        AppMethodBeat.o(206914);
        throw localObject2;
      }
    }
    catch (Throwable localThrowable)
    {
      GnD.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to load from persist storage.", new Object[0]);
      AppMethodBeat.o(206914);
      return null;
    }
    AppMethodBeat.o(206914);
    return null;
  }
  
  public static void eTF()
  {
    AppMethodBeat.i(206915);
    try
    {
      PendingOps localPendingOps = new PendingOps((byte)0);
      aw localaw = aw.aKT("mmkv_extstg_mon_pending_ops");
      Object localObject1 = eTE();
      if (localObject1 != null)
      {
        PendingOps.a(localPendingOps).addAll(PendingOps.a((PendingOps)localObject1));
        PendingOps.b(localPendingOps).addAll(PendingOps.b((PendingOps)localObject1));
      }
      PendingOps.a(localPendingOps).addAll(PendingOps.a(GnC));
      PendingOps.b(localPendingOps).addAll(PendingOps.b(GnC));
      localObject1 = null;
      try
      {
        Parcel localParcel = Parcel.obtain();
        localObject1 = localParcel;
        localPendingOps.writeToParcel(localParcel, 0);
        localObject1 = localParcel;
        localaw.encode("mmkv_key_pendingops", localParcel.marshall());
        if (localParcel != null) {
          localParcel.recycle();
        }
        PendingOps.a(GnC).clear();
        PendingOps.b(GnC).clear();
        AppMethodBeat.o(206915);
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Parcel)localObject1).recycle();
        }
        AppMethodBeat.o(206915);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      GnD.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", localThrowable, "[-] Fail to flush to persist storage.", new Object[0]);
      AppMethodBeat.o(206915);
    }
  }
  
  private static void o(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(185089);
    e.wTc.idkeyStat(paramLong1, paramLong2, paramLong3, true);
    AppMethodBeat.o(185089);
  }
  
  static class PendingOps
    implements Parcelable
  {
    public static final Parcelable.Creator<PendingOps> CREATOR;
    private final List<a> GnE;
    private final List<b> GnF;
    
    static
    {
      AppMethodBeat.i(206912);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(206912);
    }
    
    private PendingOps()
    {
      AppMethodBeat.i(206908);
      this.GnE = Collections.synchronizedList(new ArrayList(16));
      this.GnF = Collections.synchronizedList(new ArrayList(32));
      AppMethodBeat.o(206908);
    }
    
    final void R(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(206910);
      this.GnF.add(new b(paramInt, paramString1, paramString2));
      AppMethodBeat.o(206910);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void q(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(206909);
      this.GnE.add(new a(paramLong1, paramLong2, paramLong3));
      AppMethodBeat.o(206909);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(206911);
      paramParcel.writeInt(-33554431);
      paramParcel.writeInt(this.GnE.size());
      Iterator localIterator = this.GnE.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        paramParcel.writeLong(((a)localObject).id);
        paramParcel.writeLong(((a)localObject).key);
        paramParcel.writeLong(((a)localObject).value);
      }
      paramParcel.writeInt(this.GnF.size());
      localIterator = this.GnF.iterator();
      while (localIterator.hasNext())
      {
        localObject = (b)localIterator.next();
        paramParcel.writeInt(((b)localObject).level);
        paramParcel.writeString(((b)localObject).tag);
        paramParcel.writeString(((b)localObject).bIO);
      }
      AppMethodBeat.o(206911);
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
        AppMethodBeat.i(206906);
        String str = "IDKeyOp {id:" + this.id + ", key:" + this.key + ", value:" + this.value + "}";
        AppMethodBeat.o(206906);
        return str;
      }
    }
    
    static final class b
    {
      String bIO;
      int level;
      String tag;
      
      b(int paramInt, String paramString1, String paramString2)
      {
        this.level = paramInt;
        this.tag = paramString1;
        this.bIO = paramString2;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(206907);
        String str = "LogOp {level:" + this.level + ", tag:" + this.tag + ", msg:" + this.bIO + "}";
        AppMethodBeat.o(206907);
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