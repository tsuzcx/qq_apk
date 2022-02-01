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
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a> KLA;
  private final a.b KLB;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.a.a> KLC;
  private b KLD;
  private boolean KLE;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.d.a> KLF;
  private Service KLG;
  private c KLH;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.b.a> KLI;
  private final Map<Class<? extends io.flutter.embedding.engine.plugins.a>, io.flutter.embedding.engine.plugins.c.a> KLJ;
  private ContentProvider KLK;
  private Activity activity;
  private BroadcastReceiver broadcastReceiver;
  private final a slN;
  
  c(Context paramContext, a parama, io.flutter.embedding.engine.a.a parama1)
  {
    AppMethodBeat.i(192797);
    this.KLA = new HashMap();
    this.KLC = new HashMap();
    this.KLE = false;
    this.KLF = new HashMap();
    this.KLI = new HashMap();
    this.KLJ = new HashMap();
    this.slN = parama;
    this.KLB = new a.b(paramContext, parama, parama.KLk, parama.KKo, parama.KLv.KPF, new a(parama1, (byte)0));
    AppMethodBeat.o(192797);
  }
  
  private void fNe()
  {
    AppMethodBeat.i(10169);
    if (fNf())
    {
      fNh();
      AppMethodBeat.o(10169);
      return;
    }
    if (fNj())
    {
      fNk();
      AppMethodBeat.o(10169);
      return;
    }
    if (fNl())
    {
      fNm();
      AppMethodBeat.o(10169);
      return;
    }
    if (fNn()) {
      fNo();
    }
    AppMethodBeat.o(10169);
  }
  
  private boolean fNf()
  {
    return this.activity != null;
  }
  
  private boolean fNj()
  {
    return this.KLG != null;
  }
  
  private void fNk()
  {
    AppMethodBeat.i(10177);
    if (fNj())
    {
      new StringBuilder("Detaching from a Service: ").append(this.KLG);
      io.flutter.a.fMD();
      Iterator localIterator = this.KLF.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.KLG = null;
      this.KLH = null;
      AppMethodBeat.o(10177);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(10177);
  }
  
  private boolean fNl()
  {
    return this.broadcastReceiver != null;
  }
  
  private void fNm()
  {
    AppMethodBeat.i(10178);
    if (fNl())
    {
      new StringBuilder("Detaching from BroadcastReceiver: ").append(this.broadcastReceiver);
      io.flutter.a.fMD();
      Iterator localIterator = this.KLI.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10178);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(10178);
  }
  
  private boolean fNn()
  {
    return this.KLK != null;
  }
  
  private void fNo()
  {
    AppMethodBeat.i(10179);
    if (fNn())
    {
      new StringBuilder("Detaching from ContentProvider: ").append(this.KLK);
      io.flutter.a.fMD();
      Iterator localIterator = this.KLJ.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(10179);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(10179);
  }
  
  private void l(Set<Class<? extends io.flutter.embedding.engine.plugins.a>> paramSet)
  {
    AppMethodBeat.i(10167);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Class localClass = (Class)paramSet.next();
      io.flutter.embedding.engine.plugins.a locala = (io.flutter.embedding.engine.plugins.a)this.KLA.get(localClass);
      if (locala != null)
      {
        new StringBuilder("Removing plugin: ").append(locala);
        io.flutter.a.fMD();
        if ((locala instanceof io.flutter.embedding.engine.plugins.a.a)) {
          this.KLC.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.d.a)) {
          this.KLF.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.b.a)) {
          this.KLI.remove(localClass);
        }
        if ((locala instanceof io.flutter.embedding.engine.plugins.c.a)) {
          this.KLJ.remove(localClass);
        }
        locala.fNu();
        this.KLA.remove(localClass);
      }
    }
    AppMethodBeat.o(10167);
  }
  
  private void removeAll()
  {
    AppMethodBeat.i(10168);
    l(new HashSet(this.KLA.keySet()));
    this.KLA.clear();
    AppMethodBeat.o(10168);
  }
  
  public final void a(Activity paramActivity, Lifecycle paramLifecycle)
  {
    AppMethodBeat.i(10170);
    StringBuilder localStringBuilder = new StringBuilder("Attaching to an Activity: ").append(paramActivity).append(".");
    if (this.KLE) {}
    for (String str = " This is after a config change.";; str = "")
    {
      localStringBuilder.append(str);
      io.flutter.a.fMD();
      fNe();
      this.activity = paramActivity;
      this.KLD = new b(paramActivity, paramLifecycle);
      this.slN.KLv.a(paramActivity, this.slN.KKo, this.slN.KLk);
      paramActivity = this.KLC.values().iterator();
      while (paramActivity.hasNext()) {
        paramActivity.next();
      }
    }
    this.KLE = false;
    AppMethodBeat.o(10170);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10173);
    io.flutter.a.fMD();
    if (fNf())
    {
      Iterator localIterator = this.KLD.KLN.iterator();
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
    io.flutter.a.fMH();
    AppMethodBeat.o(10173);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10166);
    io.flutter.a.fMF();
    fNe();
    removeAll();
    AppMethodBeat.o(10166);
  }
  
  public final void fMQ()
  {
    AppMethodBeat.i(192798);
    io.flutter.a.fMD();
    if (fNf())
    {
      Iterator localIterator = this.KLD.KLR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(192798);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(192798);
  }
  
  public final void fNg()
  {
    AppMethodBeat.i(10171);
    if (fNf())
    {
      new StringBuilder("Detaching from an Activity for config changes: ").append(this.activity);
      io.flutter.a.fMD();
      this.KLE = true;
      Iterator localIterator = this.KLC.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.slN.KLv.detach();
      this.activity = null;
      this.KLD = null;
      AppMethodBeat.o(10171);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(10171);
  }
  
  public final void fNh()
  {
    AppMethodBeat.i(10172);
    if (fNf())
    {
      new StringBuilder("Detaching from an Activity: ").append(this.activity);
      io.flutter.a.fMD();
      Iterator localIterator = this.KLC.values().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.slN.KLv.detach();
      this.activity = null;
      this.KLD = null;
      AppMethodBeat.o(10172);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(10172);
  }
  
  public final void fNi()
  {
    AppMethodBeat.i(192799);
    io.flutter.a.fMD();
    if (fNf())
    {
      Iterator localIterator = this.KLD.KLR.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(192799);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(192799);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10174);
    io.flutter.a.fMD();
    if (fNf())
    {
      Iterator localIterator = this.KLD.KLO.iterator();
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
    io.flutter.a.fMH();
    AppMethodBeat.o(10174);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10175);
    io.flutter.a.fMD();
    if (fNf())
    {
      Iterator localIterator = this.KLD.KLP.iterator();
      while (localIterator.hasNext()) {
        ((m.b)localIterator.next()).onNewIntent(paramIntent);
      }
      AppMethodBeat.o(10175);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(10175);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(10176);
    io.flutter.a.fMD();
    if (fNf())
    {
      Iterator localIterator = this.KLD.KLQ.iterator();
      while (localIterator.hasNext()) {
        ((m.e)localIterator.next()).onUserLeaveHint();
      }
      AppMethodBeat.o(10176);
      return;
    }
    io.flutter.a.fMH();
    AppMethodBeat.o(10176);
  }
  
  static final class a
    implements a.a
  {
    final io.flutter.embedding.engine.a.a KLL;
    
    private a(io.flutter.embedding.engine.a.a parama)
    {
      this.KLL = parama;
    }
  }
  
  static final class b
  {
    private final HiddenLifecycleReference KLM;
    final Set<m.d> KLN;
    final Set<m.a> KLO;
    final Set<m.b> KLP;
    final Set<m.e> KLQ;
    final Set<Object> KLR;
    private final Activity activity;
    
    public b(Activity paramActivity, Lifecycle paramLifecycle)
    {
      AppMethodBeat.i(192800);
      this.KLN = new HashSet();
      this.KLO = new HashSet();
      this.KLP = new HashSet();
      this.KLQ = new HashSet();
      this.KLR = new HashSet();
      this.activity = paramActivity;
      this.KLM = new HiddenLifecycleReference(paramLifecycle);
      AppMethodBeat.o(192800);
    }
  }
  
  static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c
 * JD-Core Version:    0.7.0.1
 */