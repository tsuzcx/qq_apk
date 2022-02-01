package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.m.a;
import io.flutter.a.a.m.b;
import io.flutter.a.a.m.d;
import io.flutter.a.a.m.e;
import io.flutter.a.c.g;
import io.flutter.embedding.engine.a.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class d
  implements io.flutter.embedding.engine.a.a.b
{
  private final b IYA;
  private final Map<Class<? extends io.flutter.embedding.engine.a.a>, io.flutter.embedding.engine.a.a.a> IYB;
  private a IYC;
  private boolean IYD;
  private final Map<Class<? extends io.flutter.embedding.engine.a.a>, io.flutter.embedding.engine.a.d.a> IYE;
  private Service IYF;
  private b IYG;
  private final Map<Class<? extends io.flutter.embedding.engine.a.a>, io.flutter.embedding.engine.a.b.a> IYH;
  private final Map<Class<? extends io.flutter.embedding.engine.a.a>, io.flutter.embedding.engine.a.c.a> IYI;
  private ContentProvider IYJ;
  private final Map<Class<? extends io.flutter.embedding.engine.a.a>, io.flutter.embedding.engine.a.a> IYy;
  private final a.a IYz;
  private Activity activity;
  private BroadcastReceiver broadcastReceiver;
  
  d(Context paramContext, a parama, b paramb)
  {
    AppMethodBeat.i(10165);
    this.IYy = new HashMap();
    this.IYB = new HashMap();
    this.IYD = false;
    this.IYE = new HashMap();
    this.IYH = new HashMap();
    this.IYI = new HashMap();
    this.IYA = paramb;
    this.IYz = new a.a(paramContext, parama, paramb);
    AppMethodBeat.o(10165);
  }
  
  private void fuF()
  {
    AppMethodBeat.i(10169);
    if (fuG())
    {
      fuI();
      AppMethodBeat.o(10169);
      return;
    }
    if (fuJ())
    {
      fuK();
      AppMethodBeat.o(10169);
      return;
    }
    if (fuL())
    {
      fuM();
      AppMethodBeat.o(10169);
      return;
    }
    if (fuN()) {
      fuO();
    }
    AppMethodBeat.o(10169);
  }
  
  private boolean fuG()
  {
    return this.activity != null;
  }
  
  private boolean fuJ()
  {
    return this.IYF != null;
  }
  
  private void fuK()
  {
    AppMethodBeat.i(10177);
    if (fuJ())
    {
      new StringBuilder("Detaching from a Service: ").append(this.IYF);
      io.flutter.a.ftS();
      Iterator localIterator = this.IYE.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.IYA.a(null);
      this.IYF = null;
      this.IYG = null;
      AppMethodBeat.o(10177);
      return;
    }
    io.flutter.a.ftV();
    AppMethodBeat.o(10177);
  }
  
  private boolean fuL()
  {
    return this.broadcastReceiver != null;
  }
  
  private void fuM()
  {
    AppMethodBeat.i(10178);
    if (fuL())
    {
      new StringBuilder("Detaching from BroadcastReceiver: ").append(this.broadcastReceiver);
      io.flutter.a.ftS();
      Iterator localIterator = this.IYH.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10178);
      return;
    }
    io.flutter.a.ftV();
    AppMethodBeat.o(10178);
  }
  
  private boolean fuN()
  {
    return this.IYJ != null;
  }
  
  private void fuO()
  {
    AppMethodBeat.i(10179);
    if (fuN())
    {
      new StringBuilder("Detaching from ContentProvider: ").append(this.IYJ);
      io.flutter.a.ftS();
      Iterator localIterator = this.IYI.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10179);
      return;
    }
    io.flutter.a.ftV();
    AppMethodBeat.o(10179);
  }
  
  private void k(Set<Class<? extends io.flutter.embedding.engine.a.a>> paramSet)
  {
    AppMethodBeat.i(10167);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Class localClass = (Class)paramSet.next();
      io.flutter.embedding.engine.a.a locala = (io.flutter.embedding.engine.a.a)this.IYy.get(localClass);
      if (locala != null)
      {
        new StringBuilder("Removing plugin: ").append(locala);
        io.flutter.a.ftS();
        if ((locala instanceof io.flutter.embedding.engine.a.a.a)) {
          this.IYB.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.a.d.a)) {
          this.IYE.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.a.b.a)) {
          this.IYH.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.a.c.a)) {
          this.IYI.remove(localClass);
        }
        this.IYy.remove(localClass);
      }
    }
    AppMethodBeat.o(10167);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(10168);
    k(new HashSet(this.IYy.keySet()));
    this.IYy.clear();
    AppMethodBeat.o(10168);
  }
  
  public final void a(Activity paramActivity, Lifecycle paramLifecycle)
  {
    AppMethodBeat.i(10170);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an Activity: ").append(paramActivity).append(".");
    if (this.IYD) {}
    for (String str = " This is after a config change.";; str = "")
    {
      localStringBuilder.append(str);
      io.flutter.a.ftS();
      fuF();
      this.activity = paramActivity;
      this.IYC = new a(paramActivity);
      this.IYA.a(paramLifecycle);
      this.IYz.rdu.IYq.a(paramActivity, this.IYz.rdu.IXd, this.IYz.rdu.IYe);
      paramActivity = this.IYB.values().iterator();
      while (paramActivity.hasNext()) {
        paramActivity.next();
      }
    }
    this.IYD = false;
    AppMethodBeat.o(10170);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10173);
    io.flutter.a.ftS();
    if (fuG())
    {
      Iterator localIterator = this.IYC.IYK.iterator();
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
    io.flutter.a.ftV();
    AppMethodBeat.o(10173);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10166);
    io.flutter.a.ftT();
    fuF();
    this.IYA.destroy();
    removeAll();
    AppMethodBeat.o(10166);
  }
  
  public final void fuH()
  {
    AppMethodBeat.i(10171);
    if (fuG())
    {
      new StringBuilder("Detaching from an Activity for config changes: ").append(this.activity);
      io.flutter.a.ftS();
      this.IYD = true;
      Iterator localIterator = this.IYB.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.IYz.rdu.IYq.detach();
      this.IYA.a(null);
      this.activity = null;
      this.IYC = null;
      AppMethodBeat.o(10171);
      return;
    }
    io.flutter.a.ftV();
    AppMethodBeat.o(10171);
  }
  
  public final void fuI()
  {
    AppMethodBeat.i(10172);
    if (fuG())
    {
      new StringBuilder("Detaching from an Activity: ").append(this.activity);
      io.flutter.a.ftS();
      Iterator localIterator = this.IYB.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.IYz.rdu.IYq.detach();
      this.IYA.a(null);
      this.activity = null;
      this.IYC = null;
      AppMethodBeat.o(10172);
      return;
    }
    io.flutter.a.ftV();
    AppMethodBeat.o(10172);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10174);
    io.flutter.a.ftS();
    if (fuG())
    {
      Iterator localIterator = this.IYC.IYL.iterator();
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
    io.flutter.a.ftV();
    AppMethodBeat.o(10174);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10175);
    io.flutter.a.ftS();
    if (fuG())
    {
      Iterator localIterator = this.IYC.IYM.iterator();
      while (localIterator.hasNext()) {
        ((m.b)localIterator.next()).onNewIntent(paramIntent);
      }
      AppMethodBeat.o(10175);
      return;
    }
    io.flutter.a.ftV();
    AppMethodBeat.o(10175);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(10176);
    io.flutter.a.ftS();
    if (fuG())
    {
      Iterator localIterator = this.IYC.IYN.iterator();
      while (localIterator.hasNext()) {
        ((m.e)localIterator.next()).onUserLeaveHint();
      }
      AppMethodBeat.o(10176);
      return;
    }
    io.flutter.a.ftV();
    AppMethodBeat.o(10176);
  }
  
  static final class a
  {
    final Set<m.d> IYK;
    final Set<m.a> IYL;
    final Set<m.b> IYM;
    final Set<m.e> IYN;
    private final Activity activity;
    
    public a(Activity paramActivity)
    {
      AppMethodBeat.i(10120);
      this.IYK = new HashSet();
      this.IYL = new HashSet();
      this.IYM = new HashSet();
      this.IYN = new HashSet();
      this.activity = paramActivity;
      AppMethodBeat.o(10120);
    }
  }
  
  static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.d
 * JD-Core Version:    0.7.0.1
 */