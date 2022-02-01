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
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a> MZC;
  private final a.b MZD;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a.a> MZE;
  private b MZF;
  private boolean MZG;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.d.a> MZH;
  private Service MZI;
  private c MZJ;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.b.a> MZK;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.c.a> MZL;
  private ContentProvider MZM;
  private Activity activity;
  private BroadcastReceiver broadcastReceiver;
  private final a tti;
  
  c(Context paramContext, a parama, io.flutter.embedding.engine.a.a parama1)
  {
    AppMethodBeat.i(197826);
    this.MZC = new HashMap();
    this.MZE = new HashMap();
    this.MZG = false;
    this.MZH = new HashMap();
    this.MZK = new HashMap();
    this.MZL = new HashMap();
    this.tti = parama;
    this.MZD = new a.b(paramContext, parama, parama.MZm, parama.MYh, parama.MZx.NdJ, new a(parama1, (byte)0));
    AppMethodBeat.o(197826);
  }
  
  private void gjg()
  {
    AppMethodBeat.i(10169);
    if (gjh())
    {
      gjj();
      AppMethodBeat.o(10169);
      return;
    }
    if (gjl())
    {
      gjm();
      AppMethodBeat.o(10169);
      return;
    }
    if (gjn())
    {
      gjo();
      AppMethodBeat.o(10169);
      return;
    }
    if (gjp()) {
      gjq();
    }
    AppMethodBeat.o(10169);
  }
  
  private boolean gjh()
  {
    return this.activity != null;
  }
  
  private boolean gjl()
  {
    return this.MZI != null;
  }
  
  private void gjm()
  {
    AppMethodBeat.i(10177);
    if (gjl())
    {
      new StringBuilder("Detaching from a Service: ").append(this.MZI);
      io.flutter.a.giD();
      Iterator localIterator = this.MZH.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.MZI = null;
      this.MZJ = null;
      AppMethodBeat.o(10177);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(10177);
  }
  
  private boolean gjn()
  {
    return this.broadcastReceiver != null;
  }
  
  private void gjo()
  {
    AppMethodBeat.i(10178);
    if (gjn())
    {
      new StringBuilder("Detaching from BroadcastReceiver: ").append(this.broadcastReceiver);
      io.flutter.a.giD();
      Iterator localIterator = this.MZK.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10178);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(10178);
  }
  
  private boolean gjp()
  {
    return this.MZM != null;
  }
  
  private void gjq()
  {
    AppMethodBeat.i(10179);
    if (gjp())
    {
      new StringBuilder("Detaching from ContentProvider: ").append(this.MZM);
      io.flutter.a.giD();
      Iterator localIterator = this.MZL.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10179);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(10179);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(10168);
    s(new HashSet(this.MZC.keySet()));
    this.MZC.clear();
    AppMethodBeat.o(10168);
  }
  
  private void s(Set<Class<? extends io.flutter.embedding.engine.plugins.a>> paramSet)
  {
    AppMethodBeat.i(10167);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Class localClass = (Class)paramSet.next();
      io.flutter.embedding.engine.plugins.a locala = (io.flutter.embedding.engine.plugins.a)this.MZC.get(localClass);
      if (locala != null)
      {
        new StringBuilder("Removing plugin: ").append(locala);
        io.flutter.a.giD();
        if ((locala instanceof io.flutter.embedding.engine.plugins.a.a)) {
          this.MZE.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.d.a)) {
          this.MZH.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.b.a)) {
          this.MZK.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.c.a)) {
          this.MZL.remove(localClass);
        }
        locala.gjv();
        this.MZC.remove(localClass);
      }
    }
    AppMethodBeat.o(10167);
  }
  
  public final void a(Activity paramActivity, Lifecycle paramLifecycle)
  {
    AppMethodBeat.i(10170);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an Activity: ").append(paramActivity).append(".");
    if (this.MZG) {}
    for (String str = " This is after a config change.";; str = "")
    {
      localStringBuilder.append(str);
      io.flutter.a.giD();
      gjg();
      this.activity = paramActivity;
      this.MZF = new b(paramActivity, paramLifecycle);
      this.tti.MZx.a(paramActivity, this.tti.MYh, this.tti.MZm);
      paramActivity = this.MZE.values().iterator();
      while (paramActivity.hasNext()) {
        paramActivity.next();
      }
    }
    this.MZG = false;
    AppMethodBeat.o(10170);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10173);
    io.flutter.a.giD();
    if (gjh())
    {
      Iterator localIterator = this.MZF.MZP.iterator();
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
    io.flutter.a.giH();
    AppMethodBeat.o(10173);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10166);
    io.flutter.a.giD();
    gjg();
    removeAll();
    AppMethodBeat.o(10166);
  }
  
  public final void giS()
  {
    AppMethodBeat.i(197827);
    io.flutter.a.giD();
    if (gjh())
    {
      Iterator localIterator = this.MZF.MZT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(197827);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(197827);
  }
  
  public final void gji()
  {
    AppMethodBeat.i(10171);
    if (gjh())
    {
      new StringBuilder("Detaching from an Activity for config changes: ").append(this.activity);
      io.flutter.a.giD();
      this.MZG = true;
      Iterator localIterator = this.MZE.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.tti.MZx.detach();
      this.activity = null;
      this.MZF = null;
      AppMethodBeat.o(10171);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(10171);
  }
  
  public final void gjj()
  {
    AppMethodBeat.i(10172);
    if (gjh())
    {
      new StringBuilder("Detaching from an Activity: ").append(this.activity);
      io.flutter.a.giD();
      Iterator localIterator = this.MZE.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.tti.MZx.detach();
      this.activity = null;
      this.MZF = null;
      AppMethodBeat.o(10172);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(10172);
  }
  
  public final void gjk()
  {
    AppMethodBeat.i(197828);
    io.flutter.a.giD();
    if (gjh())
    {
      Iterator localIterator = this.MZF.MZT.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(197828);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(197828);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10174);
    io.flutter.a.giD();
    if (gjh())
    {
      Iterator localIterator = this.MZF.MZQ.iterator();
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
    io.flutter.a.giH();
    AppMethodBeat.o(10174);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10175);
    io.flutter.a.giD();
    if (gjh())
    {
      Iterator localIterator = this.MZF.MZR.iterator();
      while (localIterator.hasNext()) {
        ((m.b)localIterator.next()).onNewIntent(paramIntent);
      }
      AppMethodBeat.o(10175);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(10175);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(10176);
    io.flutter.a.giD();
    if (gjh())
    {
      Iterator localIterator = this.MZF.MZS.iterator();
      while (localIterator.hasNext()) {
        ((m.e)localIterator.next()).onUserLeaveHint();
      }
      AppMethodBeat.o(10176);
      return;
    }
    io.flutter.a.giH();
    AppMethodBeat.o(10176);
  }
  
  static final class a
    implements a.a
  {
    final io.flutter.embedding.engine.a.a MZN;
    
    private a(io.flutter.embedding.engine.a.a parama)
    {
      this.MZN = parama;
    }
  }
  
  static final class b
  {
    private final HiddenLifecycleReference MZO;
    final Set<m.d> MZP;
    final Set<m.a> MZQ;
    final Set<m.b> MZR;
    final Set<m.e> MZS;
    final Set<Object> MZT;
    private final Activity activity;
    
    public b(Activity paramActivity, Lifecycle paramLifecycle)
    {
      AppMethodBeat.i(197829);
      this.MZP = new HashSet();
      this.MZQ = new HashSet();
      this.MZR = new HashSet();
      this.MZS = new HashSet();
      this.MZT = new HashSet();
      this.activity = paramActivity;
      this.MZO = new HiddenLifecycleReference(paramLifecycle);
      AppMethodBeat.o(197829);
    }
  }
  
  static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c
 * JD-Core Version:    0.7.0.1
 */