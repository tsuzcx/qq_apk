package com.tinkerboots.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.c.g;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

public final class a
{
  public static a aisd;
  public final com.tencent.tinker.lib.e.a aise;
  public final com.tinkerboots.sdk.a.a aisf;
  private final ApplicationLike hfI;
  
  public a(Context paramContext, ApplicationLike paramApplicationLike, com.tencent.tinker.lib.d.c paramc, d paramd, com.tencent.tinker.lib.b.b paramb, com.tencent.tinker.lib.c.a parama, Class<? extends AbstractResultService> paramClass, com.tinkerboots.sdk.a.a.b paramb1)
  {
    AppMethodBeat.i(3427);
    com.tinkerboots.sdk.b.c.context = paramContext;
    this.hfI = paramApplicationLike;
    this.aisf = com.tinkerboots.sdk.a.a.a(paramb1);
    this.aise = com.tencent.tinker.lib.e.c.a(paramApplicationLike, paramc, paramd, paramb, paramClass, parama);
    AppMethodBeat.o(3427);
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(207595);
    if (parama == null)
    {
      parama = new TinkerRuntimeException("TinkerClient init, tinkerClient should not be null.");
      AppMethodBeat.o(207595);
      throw parama;
    }
    if (aisd != null)
    {
      parama = new TinkerRuntimeException("TinkerClient instance is already set.");
      AppMethodBeat.o(207595);
      throw parama;
    }
    aisd = parama;
    AppMethodBeat.o(207595);
    return parama;
  }
  
  public static a kkr()
  {
    AppMethodBeat.i(3428);
    if (aisd == null)
    {
      localObject = new TinkerRuntimeException("you must init TinkerClient sdk first");
      AppMethodBeat.o(3428);
      throw ((Throwable)localObject);
    }
    Object localObject = aisd;
    AppMethodBeat.o(3428);
    return localObject;
  }
  
  public final a Pi(final boolean paramBoolean)
  {
    AppMethodBeat.i(3429);
    if ((this.aisf == null) || (this.aise == null))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject = aisd;
      AppMethodBeat.o(3429);
      return localObject;
    }
    Object localObject = com.tinkerboots.sdk.b.c.getContext();
    if (!com.tinkerboots.sdk.b.b.pj((Context)localObject))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
      localObject = aisd;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if ((!this.aise.kcf()) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences((Context)localObject)))
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
      localObject = aisd;
      AppMethodBeat.o(3429);
      return localObject;
    }
    if (this.aise.isMainProcess())
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(3425);
          Object localObject1 = a.this.aisf;
          boolean bool = paramBoolean;
          Object localObject2 = com.tinkerboots.sdk.b.c.getContext().getSharedPreferences("patch_server_config", 0);
          long l = ((SharedPreferences)localObject2).getLong("fetch_patch_last_check", 0L);
          if (l == -1L) {
            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
          }
          for (;;)
          {
            AppMethodBeat.o(3425);
            return false;
            l = System.currentTimeMillis() - l;
            if ((bool) || (((com.tinkerboots.sdk.a.a)localObject1).eYL) || (l >= ((com.tinkerboots.sdk.a.a)localObject1).qXI))
            {
              ((SharedPreferences)localObject2).edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
              localObject2 = ((com.tinkerboots.sdk.a.a)localObject1).aism;
              localObject1 = ((com.tinkerboots.sdk.a.a)localObject1).aisk;
              if (localObject1 == null)
              {
                localObject1 = new RuntimeException("callback can't be null");
                AppMethodBeat.o(3425);
                throw ((Throwable)localObject1);
              }
              if (((com.tinkerboots.sdk.a.a.b)localObject1).fQe())
              {
                ((com.tinkerboots.sdk.a.a.b)localObject1).fQf();
                ((com.tinkerboots.sdk.a.a.b)localObject1).ax(((com.tinkerboots.sdk.a.b.a)localObject2).aisn.aiso);
              }
            }
            else
            {
              com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[] { Long.valueOf((((com.tinkerboots.sdk.a.a)localObject1).qXI - l) / 1000L) });
            }
          }
        }
      });
    }
    localObject = aisd;
    AppMethodBeat.o(3429);
    return localObject;
  }
  
  public final a aJY(int paramInt)
  {
    AppMethodBeat.i(3431);
    if (this.aisf == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
      locala = aisd;
      AppMethodBeat.o(3431);
      return locala;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[] { Integer.valueOf(paramInt) });
    this.aisf.aJZ(paramInt);
    a locala = aisd;
    AppMethodBeat.o(3431);
    return locala;
  }
  
  public final a rg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3430);
    if (this.aisf == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
      paramString1 = aisd;
      AppMethodBeat.o(3430);
      return paramString1;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[] { paramString1, paramString2 });
    this.aisf.rh(paramString1, paramString2);
    paramString1 = aisd;
    AppMethodBeat.o(3430);
    return paramString1;
  }
  
  public static final class a
  {
    public com.tencent.tinker.lib.b.b ahRG;
    public com.tencent.tinker.lib.d.c ahRH;
    private d ahRI;
    private com.tencent.tinker.lib.c.a aisi;
    public Class<? extends AbstractResultService> aisj;
    private com.tinkerboots.sdk.a.a.b aisk;
    private final Context context;
    private final ApplicationLike hfI;
    
    public a(ApplicationLike paramApplicationLike)
    {
      AppMethodBeat.i(3426);
      if (paramApplicationLike == null)
      {
        paramApplicationLike = new TinkerRuntimeException("applicationLike must not be null.");
        AppMethodBeat.o(3426);
        throw paramApplicationLike;
      }
      this.context = paramApplicationLike.getApplication();
      this.hfI = paramApplicationLike;
      AppMethodBeat.o(3426);
    }
    
    public final a a(d paramd)
    {
      AppMethodBeat.i(207568);
      if (this.ahRI != null)
      {
        paramd = new TinkerRuntimeException("patchReporter is already set.");
        AppMethodBeat.o(207568);
        throw paramd;
      }
      this.ahRI = paramd;
      AppMethodBeat.o(207568);
      return this;
    }
    
    public final a kks()
    {
      AppMethodBeat.i(207576);
      if (this.ahRH == null) {
        this.ahRH = new com.tinkerboots.sdk.tinker.b.a(this.context);
      }
      if (this.ahRI == null) {
        this.ahRI = new com.tinkerboots.sdk.tinker.b.c(this.context);
      }
      if (this.ahRG == null) {
        this.ahRG = new com.tinkerboots.sdk.tinker.b.b(this.context);
      }
      if (this.aisi == null) {
        this.aisi = new g();
      }
      if (this.aisj == null) {
        this.aisj = TinkerServerResultService.class;
      }
      if (this.aisk == null) {
        this.aisk = new com.tinkerboots.sdk.a.a.a();
      }
      a locala = new a(this.context, this.hfI, this.ahRH, this.ahRI, this.ahRG, this.aisi, this.aisj, this.aisk);
      AppMethodBeat.o(207576);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tinkerboots.sdk.a
 * JD-Core Version:    0.7.0.1
 */