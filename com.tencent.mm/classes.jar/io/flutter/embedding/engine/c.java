package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.h;
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
  private final a BCx;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a> aaql;
  private final a.b aaqm;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a.a> aaqn;
  private io.flutter.embedding.android.c<Activity> aaqo;
  private b aaqp;
  private boolean aaqq;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.d.a> aaqr;
  private Service aaqs;
  private c aaqt;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.b.a> aaqu;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.c.a> aaqv;
  private ContentProvider aaqw;
  @Deprecated
  private Activity activity;
  private BroadcastReceiver broadcastReceiver;
  
  c(Context paramContext, a parama, io.flutter.embedding.engine.a.c paramc)
  {
    AppMethodBeat.i(254999);
    this.aaql = new HashMap();
    this.aaqn = new HashMap();
    this.aaqq = false;
    this.aaqr = new HashMap();
    this.aaqu = new HashMap();
    this.aaqv = new HashMap();
    this.BCx = parama;
    this.aaqm = new a.b(paramContext, parama, parama.aapU, parama.aaos, parama.platformViewsController.aavW, new a(paramc, (byte)0));
    AppMethodBeat.o(254999);
  }
  
  private void A(Set<Class<? extends io.flutter.embedding.engine.plugins.a>> paramSet)
  {
    AppMethodBeat.i(255010);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      bM((Class)paramSet.next());
    }
    AppMethodBeat.o(255010);
  }
  
  private void b(Activity paramActivity, h paramh)
  {
    AppMethodBeat.i(255019);
    this.aaqp = new b(paramActivity, paramh);
    this.BCx.platformViewsController.a(paramActivity, this.BCx.aaos, this.BCx.aapU);
    paramActivity = this.aaqn.values().iterator();
    while (paramActivity.hasNext())
    {
      paramh = (io.flutter.embedding.engine.plugins.a.a)paramActivity.next();
      if (this.aaqq) {
        paramh.b(this.aaqp);
      } else {
        paramh.a(this.aaqp);
      }
    }
    this.aaqq = false;
    AppMethodBeat.o(255019);
  }
  
  private void iAK()
  {
    AppMethodBeat.i(255013);
    if (iAL())
    {
      iAO();
      AppMethodBeat.o(255013);
      return;
    }
    if (iAS())
    {
      iAT();
      AppMethodBeat.o(255013);
      return;
    }
    if (iAU())
    {
      iAV();
      AppMethodBeat.o(255013);
      return;
    }
    if (iAW()) {
      iAX();
    }
    AppMethodBeat.o(255013);
  }
  
  private boolean iAL()
  {
    return (this.activity != null) || (this.aaqo != null);
  }
  
  private Activity iAM()
  {
    AppMethodBeat.i(255014);
    if (this.aaqo != null)
    {
      localActivity = (Activity)this.aaqo.iAn();
      AppMethodBeat.o(255014);
      return localActivity;
    }
    Activity localActivity = this.activity;
    AppMethodBeat.o(255014);
    return localActivity;
  }
  
  private void iAP()
  {
    AppMethodBeat.i(255022);
    this.BCx.platformViewsController.detach();
    this.aaqo = null;
    this.activity = null;
    this.aaqp = null;
    AppMethodBeat.o(255022);
  }
  
  private boolean iAS()
  {
    return this.aaqs != null;
  }
  
  private void iAT()
  {
    AppMethodBeat.i(255029);
    if (iAS())
    {
      new StringBuilder("Detaching from a Service: ").append(this.aaqs);
      io.flutter.b.iAd();
      Iterator localIterator = this.aaqr.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.aaqs = null;
      this.aaqt = null;
      AppMethodBeat.o(255029);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255029);
  }
  
  private boolean iAU()
  {
    return this.broadcastReceiver != null;
  }
  
  private void iAV()
  {
    AppMethodBeat.i(255030);
    if (iAU())
    {
      new StringBuilder("Detaching from BroadcastReceiver: ").append(this.broadcastReceiver);
      io.flutter.b.iAd();
      Iterator localIterator = this.aaqu.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(255030);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255030);
  }
  
  private boolean iAW()
  {
    return this.aaqw != null;
  }
  
  private void iAX()
  {
    AppMethodBeat.i(255031);
    if (iAW())
    {
      new StringBuilder("Detaching from ContentProvider: ").append(this.aaqw);
      io.flutter.b.iAd();
      Iterator localIterator = this.aaqv.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(255031);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255031);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(255011);
    A(new HashSet(this.aaql.keySet()));
    this.aaql.clear();
    AppMethodBeat.o(255011);
  }
  
  public final void a(Activity paramActivity, h paramh)
  {
    AppMethodBeat.i(255015);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an Activity: ").append(paramActivity).append(".");
    if (this.aaqq) {}
    for (String str = " This is after a config change.";; str = "")
    {
      localStringBuilder.append(str);
      io.flutter.b.iAd();
      if (this.aaqo != null) {
        this.aaqo.iAm();
      }
      iAK();
      if (this.aaqo == null) {
        break;
      }
      paramActivity = new AssertionError("Only activity or exclusiveActivity should be set");
      AppMethodBeat.o(255015);
      throw paramActivity;
    }
    this.activity = paramActivity;
    b(paramActivity, paramh);
    AppMethodBeat.o(255015);
  }
  
  public final void a(io.flutter.embedding.android.c<Activity> paramc, h paramh)
  {
    AppMethodBeat.i(255018);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an exclusive Activity: ").append(paramc.iAn());
    if (iAL())
    {
      str = " evicting previous activity " + iAM();
      localStringBuilder = localStringBuilder.append(str).append(".");
      if (!this.aaqq) {
        break label143;
      }
    }
    label143:
    for (String str = " This is after a config change.";; str = "")
    {
      localStringBuilder.append(str);
      io.flutter.b.iAd();
      if (this.aaqo != null) {
        this.aaqo.iAm();
      }
      iAK();
      if (this.activity == null) {
        break label150;
      }
      paramc = new AssertionError("Only activity or exclusiveActivity should be set");
      AppMethodBeat.o(255018);
      throw paramc;
      str = "";
      break;
    }
    label150:
    this.aaqo = paramc;
    b((Activity)paramc.iAn(), paramh);
    AppMethodBeat.o(255018);
  }
  
  public final void a(io.flutter.embedding.engine.plugins.a parama)
  {
    AppMethodBeat.i(255002);
    if (bK(parama.getClass()))
    {
      new StringBuilder("Attempted to register plugin (").append(parama).append(") but it was already registered with this FlutterEngine (").append(this.BCx).append(").");
      io.flutter.b.iAf();
      AppMethodBeat.o(255002);
      return;
    }
    new StringBuilder("Adding plugin: ").append(parama);
    io.flutter.b.iAd();
    this.aaql.put(parama.getClass(), parama);
    parama.a(this.aaqm);
    Object localObject;
    if ((parama instanceof io.flutter.embedding.engine.plugins.a.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.a.a)parama;
      this.aaqn.put(parama.getClass(), localObject);
      if (iAL()) {
        ((io.flutter.embedding.engine.plugins.a.a)localObject).a(this.aaqp);
      }
    }
    if ((parama instanceof io.flutter.embedding.engine.plugins.d.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.d.a)parama;
      this.aaqr.put(parama.getClass(), localObject);
      iAS();
    }
    if ((parama instanceof io.flutter.embedding.engine.plugins.b.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.b.a)parama;
      this.aaqu.put(parama.getClass(), localObject);
      iAU();
    }
    if ((parama instanceof io.flutter.embedding.engine.plugins.c.a))
    {
      localObject = (io.flutter.embedding.engine.plugins.c.a)parama;
      this.aaqv.put(parama.getClass(), localObject);
      iAW();
    }
    AppMethodBeat.o(255002);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(255023);
    io.flutter.b.iAd();
    if (iAL())
    {
      Iterator localIterator = this.aaqp.aaqy.iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        if ((((m.d)localIterator.next()).a(paramInt, paramArrayOfString, paramArrayOfInt)) || (bool)) {}
        for (bool = true;; bool = false) {
          break;
        }
      }
      AppMethodBeat.o(255023);
      return bool;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255023);
    return false;
  }
  
  public final boolean bK(Class<? extends io.flutter.embedding.engine.plugins.a> paramClass)
  {
    AppMethodBeat.i(255003);
    boolean bool = this.aaql.containsKey(paramClass);
    AppMethodBeat.o(255003);
    return bool;
  }
  
  public final io.flutter.embedding.engine.plugins.a bL(Class<? extends io.flutter.embedding.engine.plugins.a> paramClass)
  {
    AppMethodBeat.i(255004);
    paramClass = (io.flutter.embedding.engine.plugins.a)this.aaql.get(paramClass);
    AppMethodBeat.o(255004);
    return paramClass;
  }
  
  public final void bM(Class<? extends io.flutter.embedding.engine.plugins.a> paramClass)
  {
    AppMethodBeat.i(255007);
    io.flutter.embedding.engine.plugins.a locala = (io.flutter.embedding.engine.plugins.a)this.aaql.get(paramClass);
    if (locala != null)
    {
      new StringBuilder("Removing plugin: ").append(locala);
      io.flutter.b.iAd();
      if ((locala instanceof io.flutter.embedding.engine.plugins.a.a))
      {
        if (iAL()) {
          ((io.flutter.embedding.engine.plugins.a.a)locala).qI();
        }
        this.aaqn.remove(paramClass);
      }
      if ((locala instanceof io.flutter.embedding.engine.plugins.d.a))
      {
        iAS();
        this.aaqr.remove(paramClass);
      }
      if ((locala instanceof io.flutter.embedding.engine.plugins.b.a))
      {
        iAU();
        this.aaqu.remove(paramClass);
      }
      if ((locala instanceof io.flutter.embedding.engine.plugins.c.a))
      {
        iAW();
        this.aaqv.remove(paramClass);
      }
      locala.b(this.aaqm);
      this.aaql.remove(paramClass);
    }
    AppMethodBeat.o(255007);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(255000);
    io.flutter.b.iAd();
    iAK();
    removeAll();
    AppMethodBeat.o(255000);
  }
  
  public final void iAN()
  {
    AppMethodBeat.i(255020);
    if (iAL())
    {
      new StringBuilder("Detaching from an Activity for config changes: ").append(iAM());
      io.flutter.b.iAd();
      this.aaqq = true;
      Iterator localIterator = this.aaqn.values().iterator();
      while (localIterator.hasNext()) {
        ((io.flutter.embedding.engine.plugins.a.a)localIterator.next()).qJ();
      }
      iAP();
      AppMethodBeat.o(255020);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255020);
  }
  
  public final void iAO()
  {
    AppMethodBeat.i(255021);
    if (iAL())
    {
      new StringBuilder("Detaching from an Activity: ").append(iAM());
      io.flutter.b.iAd();
      Iterator localIterator = this.aaqn.values().iterator();
      while (localIterator.hasNext()) {
        ((io.flutter.embedding.engine.plugins.a.a)localIterator.next()).qI();
      }
      iAP();
      AppMethodBeat.o(255021);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255021);
  }
  
  public final void iAQ()
  {
    AppMethodBeat.i(255027);
    io.flutter.b.iAd();
    if (iAL())
    {
      Iterator localIterator = this.aaqp.aaqC.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(255027);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255027);
  }
  
  public final void iAR()
  {
    AppMethodBeat.i(255028);
    io.flutter.b.iAd();
    if (iAL())
    {
      Iterator localIterator = this.aaqp.aaqC.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(255028);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255028);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255024);
    io.flutter.b.iAd();
    if (iAL())
    {
      Iterator localIterator = new HashSet(this.aaqp.aaqz).iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        if ((((m.a)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent)) || (bool)) {}
        for (bool = true;; bool = false) {
          break;
        }
      }
      AppMethodBeat.o(255024);
      return bool;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255024);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(255025);
    io.flutter.b.iAd();
    if (iAL())
    {
      Iterator localIterator = this.aaqp.aaqA.iterator();
      while (localIterator.hasNext()) {
        ((m.b)localIterator.next()).onNewIntent(paramIntent);
      }
      AppMethodBeat.o(255025);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255025);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(255026);
    io.flutter.b.iAd();
    if (iAL())
    {
      Iterator localIterator = this.aaqp.aaqB.iterator();
      while (localIterator.hasNext()) {
        ((m.e)localIterator.next()).onUserLeaveHint();
      }
      AppMethodBeat.o(255026);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(255026);
  }
  
  static final class a
    implements a.a
  {
    final io.flutter.embedding.engine.a.c aanR;
    
    private a(io.flutter.embedding.engine.a.c paramc)
    {
      this.aanR = paramc;
    }
    
    public final String bGe(String paramString)
    {
      AppMethodBeat.i(255824);
      paramString = this.aanR.bGf(paramString);
      AppMethodBeat.o(255824);
      return paramString;
    }
    
    public final String pl(String paramString1, String paramString2)
    {
      AppMethodBeat.i(255826);
      paramString1 = this.aanR.getLookupKeyForAsset(paramString1, paramString2);
      AppMethodBeat.o(255826);
      return paramString1;
    }
  }
  
  static final class b
    implements io.flutter.embedding.engine.plugins.a.c
  {
    final Set<m.b> aaqA;
    final Set<m.e> aaqB;
    final Set<Object> aaqC;
    private final HiddenLifecycleReference aaqx;
    final Set<m.d> aaqy;
    final Set<m.a> aaqz;
    private final Activity activity;
    
    public b(Activity paramActivity, h paramh)
    {
      AppMethodBeat.i(255301);
      this.aaqy = new HashSet();
      this.aaqz = new HashSet();
      this.aaqA = new HashSet();
      this.aaqB = new HashSet();
      this.aaqC = new HashSet();
      this.activity = paramActivity;
      this.aaqx = new HiddenLifecycleReference(paramh);
      AppMethodBeat.o(255301);
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