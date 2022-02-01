package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.e.h;
import java.io.File;

public final class c
  extends TBSOneManager
{
  private String a;
  private h b;
  private final Object c;
  private boolean d;
  
  public c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(173797);
    this.c = new Object();
    a.a(paramContext);
    f.a("[%s] Initializing %s (%s)", new Object[] { paramString, "0.0.1", "20200511153747" });
    this.a = paramString;
    this.b = a.a(paramContext, paramString);
    AppMethodBeat.o(173797);
  }
  
  private void a()
  {
    synchronized (this.c)
    {
      this.d = true;
      return;
    }
  }
  
  public final void configure(String paramString, Object paramObject)
  {
    AppMethodBeat.i(173801);
    f.a("[%s] Configuring %s = %s", new Object[] { this.a, paramString, paramObject });
    this.b.a(paramString, paramObject);
    AppMethodBeat.o(173801);
  }
  
  public final TBSOneDebugger getDebugger()
  {
    AppMethodBeat.i(173803);
    TBSOneDebugger localTBSOneDebugger = this.b.d();
    AppMethodBeat.o(173803);
    return localTBSOneDebugger;
  }
  
  public final int[] getInstalledVersionCodesOfComponent(String paramString)
  {
    AppMethodBeat.i(173805);
    paramString = this.b.c(paramString);
    AppMethodBeat.o(173805);
    return paramString;
  }
  
  public final TBSOneComponent getLoadedComponent(String paramString)
  {
    AppMethodBeat.i(173809);
    paramString = this.b.e(paramString);
    AppMethodBeat.o(173809);
    return paramString;
  }
  
  public final TBSOneOnlineService getOnlineService()
  {
    AppMethodBeat.i(173802);
    a();
    TBSOneOnlineService localTBSOneOnlineService = this.b.c();
    AppMethodBeat.o(173802);
    return localTBSOneOnlineService;
  }
  
  public final void installComponent(final String paramString, final Bundle paramBundle, final TBSOneCallback<File> paramTBSOneCallback)
  {
    AppMethodBeat.i(190686);
    f.a("[%s] Installing component %s,Options %s", new Object[] { this.a, paramString, paramBundle });
    a();
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(173885);
        c.a(c.this).b(paramString, paramBundle, paramTBSOneCallback);
        AppMethodBeat.o(173885);
      }
    });
    AppMethodBeat.o(190686);
  }
  
  public final void installComponent(String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    AppMethodBeat.i(173806);
    installComponent(paramString, null, paramTBSOneCallback);
    AppMethodBeat.o(173806);
  }
  
  public final boolean isComponentInstalled(String paramString)
  {
    AppMethodBeat.i(173804);
    boolean bool = this.b.b(paramString);
    AppMethodBeat.o(173804);
    return bool;
  }
  
  public final void loadComponentAsync(final String paramString, final Bundle paramBundle, final TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    AppMethodBeat.i(190687);
    f.a("[%s] Loading component %s asynchronously", new Object[] { this.a, paramString });
    a();
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174259);
        c.a(c.this).a(paramString, paramBundle, paramTBSOneCallback);
        AppMethodBeat.o(174259);
      }
    });
    AppMethodBeat.o(190687);
  }
  
  public final void loadComponentAsync(String paramString, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    AppMethodBeat.i(173807);
    loadComponentAsync(paramString, null, paramTBSOneCallback);
    AppMethodBeat.o(173807);
  }
  
  public final TBSOneComponent loadComponentSync(String paramString)
  {
    AppMethodBeat.i(173808);
    paramString = loadComponentSync(paramString, null);
    AppMethodBeat.o(173808);
    return paramString;
  }
  
  public final TBSOneComponent loadComponentSync(final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(190688);
    f.a("[%s] Loading component %s synchronously", new Object[] { this.a, paramString });
    if (m.b())
    {
      paramString = new RuntimeException("TBSOneManager.loadComponentSync must not be called on TBSOne thread.");
      AppMethodBeat.o(190688);
      throw paramString;
    }
    a();
    final b localb = new b();
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174176);
        c.a(c.this).a(paramString, paramBundle, localb);
        AppMethodBeat.o(174176);
      }
    });
    localb.a();
    if (localb.b != 0)
    {
      paramString = new TBSOneException(localb.b, localb.c);
      AppMethodBeat.o(190688);
      throw paramString;
    }
    paramString = (TBSOneComponent)localb.a;
    AppMethodBeat.o(190688);
    return paramString;
  }
  
  public final void setAutoUpdateEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(173799);
    String str2 = this.a;
    if (paramBoolean) {}
    for (String str1 = "Enabling";; str1 = "Disabling")
    {
      f.a("[%s] %s auto update", new Object[] { str2, str1 });
      this.b.a(paramBoolean);
      AppMethodBeat.o(173799);
      return;
    }
  }
  
  public final void setDelegate(final TBSOneDelegate paramTBSOneDelegate)
  {
    AppMethodBeat.i(173800);
    f.a("[%s] Setting delegate %s", new Object[] { this.a, paramTBSOneDelegate });
    m.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(173796);
        c.a(c.this).f = paramTBSOneDelegate;
        AppMethodBeat.o(173796);
      }
    });
    AppMethodBeat.o(173800);
  }
  
  public final void setPolicy(TBSOneManager.Policy paramPolicy)
  {
    AppMethodBeat.i(173798);
    f.a("[%s] Setting policy %s", new Object[] { this.a, paramPolicy });
    synchronized (this.c)
    {
      if (this.d)
      {
        Log.println(5, "TBSOne", Log.getStackTraceString(new Throwable("TBSOneManager.setPolicy should be called before doing any other operations.")));
        AppMethodBeat.o(173798);
        return;
      }
      this.b.d = paramPolicy;
      AppMethodBeat.o(173798);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c
 * JD-Core Version:    0.7.0.1
 */