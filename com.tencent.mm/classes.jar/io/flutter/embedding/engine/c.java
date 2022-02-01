package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.a;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.plugin.a.m.a;
import io.flutter.plugin.a.m.b;
import io.flutter.plugin.a.m.d;
import io.flutter.plugin.a.m.e;
import io.flutter.plugin.platform.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class c
  implements b
{
  private b MCA;
  private boolean MCB;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.d.a> MCC;
  private Service MCD;
  private c MCE;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.b.a> MCF;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.c.a> MCG;
  private ContentProvider MCH;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a> MCx;
  private final a.b MCy;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a.a> MCz;
  private Activity activity;
  private BroadcastReceiver broadcastReceiver;
  private final a tiq;
  
  c(Context paramContext, a parama, io.flutter.embedding.engine.a.a parama1)
  {
    AppMethodBeat.i(213244);
    this.MCx = new HashMap();
    this.MCz = new HashMap();
    this.MCB = false;
    this.MCC = new HashMap();
    this.MCF = new HashMap();
    this.MCG = new HashMap();
    this.tiq = parama;
    this.MCy = new a.b(paramContext, parama, parama.MCh, parama.MBc, parama.MCs.MGE, new a(parama1, (byte)0));
    AppMethodBeat.o(213244);
  }
  
  private void geE()
  {
    AppMethodBeat.i(10169);
    if (geF())
    {
      geH();
      AppMethodBeat.o(10169);
      return;
    }
    if (geJ())
    {
      geK();
      AppMethodBeat.o(10169);
      return;
    }
    if (geL())
    {
      geM();
      AppMethodBeat.o(10169);
      return;
    }
    if (geN()) {
      geO();
    }
    AppMethodBeat.o(10169);
  }
  
  private boolean geF()
  {
    return this.activity != null;
  }
  
  private boolean geJ()
  {
    return this.MCD != null;
  }
  
  private void geK()
  {
    AppMethodBeat.i(10177);
    if (geJ())
    {
      new StringBuilder("Detaching from a Service: ").append(this.MCD);
      io.flutter.a.gea();
      Iterator localIterator = this.MCC.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.MCD = null;
      this.MCE = null;
      AppMethodBeat.o(10177);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10177);
  }
  
  private boolean geL()
  {
    return this.broadcastReceiver != null;
  }
  
  private void geM()
  {
    AppMethodBeat.i(10178);
    if (geL())
    {
      new StringBuilder("Detaching from BroadcastReceiver: ").append(this.broadcastReceiver);
      io.flutter.a.gea();
      Iterator localIterator = this.MCF.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10178);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10178);
  }
  
  private boolean geN()
  {
    return this.MCH != null;
  }
  
  private void geO()
  {
    AppMethodBeat.i(10179);
    if (geN())
    {
      new StringBuilder("Detaching from ContentProvider: ").append(this.MCH);
      io.flutter.a.gea();
      Iterator localIterator = this.MCG.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10179);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10179);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(10168);
    s(new HashSet(this.MCx.keySet()));
    this.MCx.clear();
    AppMethodBeat.o(10168);
  }
  
  private void s(Set<Class<? extends io.flutter.embedding.engine.plugins.a>> paramSet)
  {
    AppMethodBeat.i(10167);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Class localClass = (Class)paramSet.next();
      io.flutter.embedding.engine.plugins.a locala = (io.flutter.embedding.engine.plugins.a)this.MCx.get(localClass);
      if (locala != null)
      {
        new StringBuilder("Removing plugin: ").append(locala);
        io.flutter.a.gea();
        if ((locala instanceof io.flutter.embedding.engine.plugins.a.a)) {
          this.MCz.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.d.a)) {
          this.MCC.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.b.a)) {
          this.MCF.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.c.a)) {
          this.MCG.remove(localClass);
        }
        locala.geT();
        this.MCx.remove(localClass);
      }
    }
    AppMethodBeat.o(10167);
  }
  
  public final void a(Activity paramActivity, Lifecycle paramLifecycle)
  {
    AppMethodBeat.i(10170);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an Activity: ").append(paramActivity).append(".");
    if (this.MCB) {}
    for (String str = " This is after a config change.";; str = "")
    {
      localStringBuilder.append(str);
      io.flutter.a.gea();
      geE();
      this.activity = paramActivity;
      this.MCA = new b(paramActivity, paramLifecycle);
      this.tiq.MCs.a(paramActivity, this.tiq.MBc, this.tiq.MCh);
      paramActivity = this.MCz.values().iterator();
      while (paramActivity.hasNext()) {
        paramActivity.next();
      }
    }
    this.MCB = false;
    AppMethodBeat.o(10170);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10173);
    io.flutter.a.gea();
    if (geF())
    {
      Iterator localIterator = this.MCA.MCK.iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        if ((((m.d)localIterator.next()).a(paramInt, paramArrayOfString, paramArrayOfInt)) || (bool)) {}
        for (bool = true;; bool = false) {
          break;
        }
      }
      AppMethodBeat.o(10173);
      return bool;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10173);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10166);
    io.flutter.a.gea();
    geE();
    removeAll();
    AppMethodBeat.o(10166);
  }
  
  public final void geG()
  {
    AppMethodBeat.i(10171);
    if (geF())
    {
      new StringBuilder("Detaching from an Activity for config changes: ").append(this.activity);
      io.flutter.a.gea();
      this.MCB = true;
      Iterator localIterator = this.MCz.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.tiq.MCs.detach();
      this.activity = null;
      this.MCA = null;
      AppMethodBeat.o(10171);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10171);
  }
  
  public final void geH()
  {
    AppMethodBeat.i(10172);
    if (geF())
    {
      new StringBuilder("Detaching from an Activity: ").append(this.activity);
      io.flutter.a.gea();
      Iterator localIterator = this.MCz.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.tiq.MCs.detach();
      this.activity = null;
      this.MCA = null;
      AppMethodBeat.o(10172);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10172);
  }
  
  public final void geI()
  {
    AppMethodBeat.i(213246);
    io.flutter.a.gea();
    if (geF())
    {
      Iterator localIterator = this.MCA.MCO.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(213246);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(213246);
  }
  
  public final void gep()
  {
    AppMethodBeat.i(213245);
    io.flutter.a.gea();
    if (geF())
    {
      Iterator localIterator = this.MCA.MCO.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(213245);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(213245);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10174);
    io.flutter.a.gea();
    if (geF())
    {
      Iterator localIterator = this.MCA.MCL.iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        if ((((m.a)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent)) || (bool)) {}
        for (bool = true;; bool = false) {
          break;
        }
      }
      AppMethodBeat.o(10174);
      return bool;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10174);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10175);
    io.flutter.a.gea();
    if (geF())
    {
      Iterator localIterator = this.MCA.MCM.iterator();
      while (localIterator.hasNext()) {
        ((m.b)localIterator.next()).onNewIntent(paramIntent);
      }
      AppMethodBeat.o(10175);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10175);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(10176);
    io.flutter.a.gea();
    if (geF())
    {
      Iterator localIterator = this.MCA.MCN.iterator();
      while (localIterator.hasNext()) {
        ((m.e)localIterator.next()).onUserLeaveHint();
      }
      AppMethodBeat.o(10176);
      return;
    }
    io.flutter.a.gee();
    AppMethodBeat.o(10176);
  }
  
  static final class a
    implements a.a
  {
    final io.flutter.embedding.engine.a.a MCI;
    
    private a(io.flutter.embedding.engine.a.a parama)
    {
      this.MCI = parama;
    }
  }
  
  static final class b
  {
    private final HiddenLifecycleReference MCJ;
    final Set<m.d> MCK;
    final Set<m.a> MCL;
    final Set<m.b> MCM;
    final Set<m.e> MCN;
    final Set<Object> MCO;
    private final Activity activity;
    
    public b(Activity paramActivity, Lifecycle paramLifecycle)
    {
      AppMethodBeat.i(213247);
      this.MCK = new HashSet();
      this.MCL = new HashSet();
      this.MCM = new HashSet();
      this.MCN = new HashSet();
      this.MCO = new HashSet();
      this.activity = paramActivity;
      this.MCJ = new HiddenLifecycleReference(paramLifecycle);
      AppMethodBeat.o(213247);
    }
  }
  
  static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c
 * JD-Core Version:    0.7.0.1
 */