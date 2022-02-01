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
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.plugin.a.m.a;
import io.flutter.plugin.a.m.b;
import io.flutter.plugin.a.m.d;
import io.flutter.plugin.a.m.e;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class c
  implements io.flutter.embedding.engine.plugins.a.b, io.flutter.embedding.engine.plugins.b
{
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a> SOn;
  private final a.b SOo;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a.a> SOp;
  private b SOq;
  private boolean SOr;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.d.a> SOs;
  private Service SOt;
  private c SOu;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.b.a> SOv;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.c.a> SOw;
  private ContentProvider SOx;
  private Activity activity;
  private BroadcastReceiver broadcastReceiver;
  private final a wJi;
  
  c(Context paramContext, a parama, io.flutter.embedding.engine.a.a parama1)
  {
    AppMethodBeat.i(214934);
    this.SOn = new HashMap();
    this.SOp = new HashMap();
    this.SOr = false;
    this.SOs = new HashMap();
    this.SOv = new HashMap();
    this.SOw = new HashMap();
    this.wJi = parama;
    this.SOo = new a.b(paramContext, parama, parama.SNW, parama.SMr, parama.platformViewsController.STj, new a(parama1, (byte)0));
    AppMethodBeat.o(214934);
  }
  
  private void B(Set<Class<? extends io.flutter.embedding.engine.plugins.a>> paramSet)
  {
    AppMethodBeat.i(10167);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Class localClass = (Class)paramSet.next();
      io.flutter.embedding.engine.plugins.a locala = (io.flutter.embedding.engine.plugins.a)this.SOn.get(localClass);
      if (locala != null)
      {
        new StringBuilder("Removing plugin: ").append(locala);
        io.flutter.a.hwd();
        if ((locala instanceof io.flutter.embedding.engine.plugins.a.a))
        {
          if (hwI()) {
            ((io.flutter.embedding.engine.plugins.a.a)locala).sU();
          }
          this.SOp.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.d.a)) {
          this.SOs.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.b.a)) {
          this.SOv.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.c.a)) {
          this.SOw.remove(localClass);
        }
        locala.b(this.SOo);
        this.SOn.remove(localClass);
      }
    }
    AppMethodBeat.o(10167);
  }
  
  private void hwH()
  {
    AppMethodBeat.i(10169);
    if (hwI())
    {
      hwK();
      AppMethodBeat.o(10169);
      return;
    }
    if (hwN())
    {
      hwO();
      AppMethodBeat.o(10169);
      return;
    }
    if (hwP())
    {
      hwQ();
      AppMethodBeat.o(10169);
      return;
    }
    if (hwR()) {
      hwS();
    }
    AppMethodBeat.o(10169);
  }
  
  private boolean hwI()
  {
    return this.activity != null;
  }
  
  private boolean hwN()
  {
    return this.SOt != null;
  }
  
  private void hwO()
  {
    AppMethodBeat.i(10177);
    if (hwN())
    {
      new StringBuilder("Detaching from a Service: ").append(this.SOt);
      io.flutter.a.hwd();
      Iterator localIterator = this.SOs.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.SOt = null;
      this.SOu = null;
      AppMethodBeat.o(10177);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(10177);
  }
  
  private boolean hwP()
  {
    return this.broadcastReceiver != null;
  }
  
  private void hwQ()
  {
    AppMethodBeat.i(10178);
    if (hwP())
    {
      new StringBuilder("Detaching from BroadcastReceiver: ").append(this.broadcastReceiver);
      io.flutter.a.hwd();
      Iterator localIterator = this.SOv.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10178);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(10178);
  }
  
  private boolean hwR()
  {
    return this.SOx != null;
  }
  
  private void hwS()
  {
    AppMethodBeat.i(10179);
    if (hwR())
    {
      new StringBuilder("Detaching from ContentProvider: ").append(this.SOx);
      io.flutter.a.hwd();
      Iterator localIterator = this.SOw.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10179);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(10179);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(10168);
    B(new HashSet(this.SOn.keySet()));
    this.SOn.clear();
    AppMethodBeat.o(10168);
  }
  
  public final void A(Set<io.flutter.embedding.engine.plugins.a> paramSet)
  {
    AppMethodBeat.i(214936);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      a((io.flutter.embedding.engine.plugins.a)paramSet.next());
    }
    AppMethodBeat.o(214936);
  }
  
  public final void a(Activity paramActivity, Lifecycle paramLifecycle)
  {
    AppMethodBeat.i(10170);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an Activity: ").append(paramActivity).append(".");
    String str;
    if (this.SOr)
    {
      str = " This is after a config change.";
      localStringBuilder.append(str);
      io.flutter.a.hwd();
      hwH();
      this.activity = paramActivity;
      this.SOq = new b(paramActivity, paramLifecycle);
      this.wJi.platformViewsController.a(paramActivity, this.wJi.SMr, this.wJi.SNW);
      paramActivity = this.SOp.values().iterator();
    }
    for (;;)
    {
      if (!paramActivity.hasNext()) {
        break label167;
      }
      paramLifecycle = (io.flutter.embedding.engine.plugins.a.a)paramActivity.next();
      if (this.SOr)
      {
        paramLifecycle.b(this.SOq);
        continue;
        str = "";
        break;
      }
      paramLifecycle.a(this.SOq);
    }
    label167:
    this.SOr = false;
    AppMethodBeat.o(10170);
  }
  
  public final void a(io.flutter.embedding.engine.plugins.a parama)
  {
    AppMethodBeat.i(214935);
    Object localObject = parama.getClass();
    if (this.SOn.containsKey(localObject))
    {
      new StringBuilder("Attempted to register plugin (").append(parama).append(") but it was already registered with this FlutterEngine (").append(this.wJi).append(").");
      io.flutter.a.hwf();
      AppMethodBeat.o(214935);
      return;
    }
    new StringBuilder("Adding plugin: ").append(parama);
    io.flutter.a.hwd();
    this.SOn.put(parama.getClass(), parama);
    parama.a(this.SOo);
    if ((parama instanceof io.flutter.embedding.engine.plugins.a.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.a.a)parama;
      this.SOp.put(parama.getClass(), localObject);
      if (hwI()) {
        ((io.flutter.embedding.engine.plugins.a.a)localObject).a(this.SOq);
      }
    }
    if ((parama instanceof io.flutter.embedding.engine.plugins.d.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.d.a)parama;
      this.SOs.put(parama.getClass(), localObject);
    }
    if ((parama instanceof io.flutter.embedding.engine.plugins.b.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.b.a)parama;
      this.SOv.put(parama.getClass(), localObject);
    }
    if ((parama instanceof io.flutter.embedding.engine.plugins.c.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.c.a)parama;
      this.SOw.put(parama.getClass(), localObject);
    }
    AppMethodBeat.o(214935);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10173);
    io.flutter.a.hwd();
    if (hwI())
    {
      Iterator localIterator = this.SOq.SOA.iterator();
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
    io.flutter.a.hwg();
    AppMethodBeat.o(10173);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10166);
    io.flutter.a.hwd();
    hwH();
    removeAll();
    AppMethodBeat.o(10166);
  }
  
  public final void hwJ()
  {
    AppMethodBeat.i(10171);
    if (hwI())
    {
      new StringBuilder("Detaching from an Activity for config changes: ").append(this.activity);
      io.flutter.a.hwd();
      this.SOr = true;
      Iterator localIterator = this.SOp.values().iterator();
      while (localIterator.hasNext()) {
        ((io.flutter.embedding.engine.plugins.a.a)localIterator.next()).sV();
      }
      this.wJi.platformViewsController.detach();
      this.activity = null;
      this.SOq = null;
      AppMethodBeat.o(10171);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(10171);
  }
  
  public final void hwK()
  {
    AppMethodBeat.i(10172);
    if (hwI())
    {
      new StringBuilder("Detaching from an Activity: ").append(this.activity);
      io.flutter.a.hwd();
      Iterator localIterator = this.SOp.values().iterator();
      while (localIterator.hasNext()) {
        ((io.flutter.embedding.engine.plugins.a.a)localIterator.next()).sU();
      }
      this.wJi.platformViewsController.detach();
      this.activity = null;
      this.SOq = null;
      AppMethodBeat.o(10172);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(10172);
  }
  
  public final void hwL()
  {
    AppMethodBeat.i(214937);
    io.flutter.a.hwd();
    if (hwI())
    {
      Iterator localIterator = this.SOq.SOE.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(214937);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(214937);
  }
  
  public final void hwM()
  {
    AppMethodBeat.i(214938);
    io.flutter.a.hwd();
    if (hwI())
    {
      Iterator localIterator = this.SOq.SOE.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(214938);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(214938);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10174);
    io.flutter.a.hwd();
    if (hwI())
    {
      Iterator localIterator = this.SOq.SOB.iterator();
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
    io.flutter.a.hwg();
    AppMethodBeat.o(10174);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10175);
    io.flutter.a.hwd();
    if (hwI())
    {
      Iterator localIterator = this.SOq.SOC.iterator();
      while (localIterator.hasNext()) {
        ((m.b)localIterator.next()).onNewIntent(paramIntent);
      }
      AppMethodBeat.o(10175);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(10175);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(10176);
    io.flutter.a.hwd();
    if (hwI())
    {
      Iterator localIterator = this.SOq.SOD.iterator();
      while (localIterator.hasNext()) {
        ((m.e)localIterator.next()).onUserLeaveHint();
      }
      AppMethodBeat.o(10176);
      return;
    }
    io.flutter.a.hwg();
    AppMethodBeat.o(10176);
  }
  
  static final class a
    implements a.a
  {
    final io.flutter.embedding.engine.a.a SOy;
    
    private a(io.flutter.embedding.engine.a.a parama)
    {
      this.SOy = parama;
    }
    
    public final String btc(String paramString)
    {
      AppMethodBeat.i(214932);
      paramString = this.SOy.btd(paramString);
      AppMethodBeat.o(214932);
      return paramString;
    }
    
    public final String op(String paramString1, String paramString2)
    {
      AppMethodBeat.i(214933);
      paramString1 = this.SOy.getLookupKeyForAsset(paramString1, paramString2);
      AppMethodBeat.o(214933);
      return paramString1;
    }
  }
  
  static final class b
    implements io.flutter.embedding.engine.plugins.a.c
  {
    final Set<m.d> SOA;
    final Set<m.a> SOB;
    final Set<m.b> SOC;
    final Set<m.e> SOD;
    final Set<Object> SOE;
    private final HiddenLifecycleReference SOz;
    private final Activity activity;
    
    public b(Activity paramActivity, Lifecycle paramLifecycle)
    {
      AppMethodBeat.i(214939);
      this.SOA = new HashSet();
      this.SOB = new HashSet();
      this.SOC = new HashSet();
      this.SOD = new HashSet();
      this.SOE = new HashSet();
      this.activity = paramActivity;
      this.SOz = new HiddenLifecycleReference(paramLifecycle);
      AppMethodBeat.o(214939);
    }
    
    public final Activity getActivity()
    {
      return this.activity;
    }
  }
  
  static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c
 * JD-Core Version:    0.7.0.1
 */