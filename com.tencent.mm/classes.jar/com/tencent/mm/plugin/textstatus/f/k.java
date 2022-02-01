package com.tencent.mm.plugin.textstatus.f;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.f.a;
import com.tencent.mm.plugin.textstatus.f.f.c;
import com.tencent.mm.plugin.textstatus.f.f.d;
import com.tencent.mm.plugin.textstatus.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter;", "", "()V", "ICON_CHAR", "", "TAG", "", "listeners", "", "", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "cancelListener", "", "_key", "subject", "getTextStatusSpan", "", "username", "displayName", "textSize", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "onNotify", "userName", "Listener", "StatusIconListener", "StatusSpanListener", "StatusSpanListenerNoMeasure", "StatusUpdateListener", "plugin-textstatus_release"})
public final class k
{
  public static final k FZi;
  private static final Map<Integer, a> pRR;
  
  static
  {
    AppMethodBeat.i(216225);
    FZi = new k();
    f localf = f.FXJ;
    f.fvM().add((MStorage.IOnStorageChange)1.FZj);
    localf = f.FXJ;
    f.fvN().add((MStorage.IOnStorageChange)2.FZk);
    pRR = (Map)new LinkedHashMap();
    AppMethodBeat.o(216225);
  }
  
  public static void C(String paramString, Object paramObject)
  {
    AppMethodBeat.i(216224);
    p.h(paramString, "_key");
    p.h(paramObject, "subject");
    synchronized (pRR)
    {
      a locala = (a)pRR.get(Integer.valueOf(paramObject.hashCode()));
      if ((locala != null) && (p.j(paramString, locala.key)))
      {
        pRR.remove(Integer.valueOf(paramObject.hashCode()));
        Log.i("MicroMsg.TxtStatus.TextStatusEventCenter", "cancelListener ".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(216224);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "", "subject", "key", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "setRef", "(Ljava/lang/ref/WeakReference;)V", "notDeadToRun", "", "onChange", "plugin-textstatus_release"})
  public static abstract class a
  {
    String key;
    public WeakReference<Object> nsR;
    
    public a(Object paramObject, String arg2)
    {
      this.key = ???;
      this.nsR = new WeakReference(paramObject);
      ??? = k.FZi;
      synchronized (k.fvS())
      {
        k localk = k.FZi;
        k.fvS().put(Integer.valueOf(paramObject.hashCode()), this);
        return;
      }
    }
    
    public final WeakReference<Object> fvT()
    {
      WeakReference localWeakReference = this.nsR;
      if (localWeakReference == null) {
        p.btv("ref");
      }
      return localWeakReference;
    }
    
    public abstract void onChange();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusIconListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconIV", "Landroid/widget/ImageView;", "(Ljava/lang/String;Landroid/widget/ImageView;)V", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class b
    extends k.a
  {
    public static final k.b.a FZl;
    
    static
    {
      AppMethodBeat.i(216213);
      FZl = new k.b.a((byte)0);
      AppMethodBeat.o(216213);
    }
    
    public b(String paramString, ImageView paramImageView)
    {
      super(paramString);
      AppMethodBeat.i(216212);
      paramImageView = k.FZi;
      k.aTh(paramString);
      AppMethodBeat.o(216212);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(216211);
      Log.i("MicroMsg.TxtStatus.StatusIconListener", "onChange " + this.key);
      Object localObject1 = fvT().get();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(216211);
        throw ((Throwable)localObject1);
      }
      localObject1 = (ImageView)localObject1;
      Object localObject2 = f.FXJ;
      localObject2 = f.aTf(this.key);
      if (localObject2 != null)
      {
        localObject2 = ((a)localObject2).field_IconID;
        if (localObject2 != null)
        {
          if (localObject1 != null)
          {
            b localb = b.GfZ;
            ((ImageView)localObject1).setImageDrawable(b.a((String)localObject2, a.c.FXp, null, 4));
          }
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(0);
          }
          if (localObject2 != null) {
            break label136;
          }
        }
      }
      if (localObject1 != null)
      {
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = x.SXb;
      }
      label136:
      AppMethodBeat.o(216211);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Landroid/widget/TextView;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "(Ljava/lang/String;Landroid/widget/TextView;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;)V", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class c
    extends k.a
  {
    public static final k.c.a FZn;
    private final a.c FZm;
    
    static
    {
      AppMethodBeat.i(216216);
      FZn = new k.c.a((byte)0);
      AppMethodBeat.o(216216);
    }
    
    public c(String paramString, TextView paramTextView, a.c paramc)
    {
      super(paramString);
      AppMethodBeat.i(216215);
      this.FZm = paramc;
      onChange();
      AppMethodBeat.o(216215);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(216214);
      Log.d("MicroMsg.TxtStatus.StatusSpanListener", "onChange " + this.key);
      Object localObject1 = fvT().get();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(216214);
        throw ((Throwable)localObject1);
      }
      localObject1 = (TextView)localObject1;
      Object localObject2 = k.FZi;
      localObject2 = k.a(this.key, ((TextView)localObject1).getText(), (int)((TextView)localObject1).getTextSize(), this.FZm);
      if ((localObject2 != null) && ((p.j(((TextView)localObject1).getText(), localObject2) ^ true))) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      AppMethodBeat.o(216214);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListenerNoMeasure;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/NoMeasuredTextView;)V", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class d
    extends k.a
  {
    public static final k.d.a FZo;
    
    static
    {
      AppMethodBeat.i(216219);
      FZo = new k.d.a((byte)0);
      AppMethodBeat.o(216219);
    }
    
    public d(String paramString, NoMeasuredTextView paramNoMeasuredTextView)
    {
      super(paramString);
      AppMethodBeat.i(216218);
      onChange();
      AppMethodBeat.o(216218);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(216217);
      Log.d("MicroMsg.TxtStatus.StatusSpanListenerNoMeasure", "onChange " + this.key);
      Object localObject1 = fvT().get();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.NoMeasuredTextView");
        AppMethodBeat.o(216217);
        throw ((Throwable)localObject1);
      }
      localObject1 = (NoMeasuredTextView)localObject1;
      Object localObject2 = k.FZi;
      localObject2 = k.a(this.key, ((NoMeasuredTextView)localObject1).getText(), (int)((NoMeasuredTextView)localObject1).getTextSize(), a.c.FXp);
      if ((localObject2 != null) && ((p.j(((NoMeasuredTextView)localObject1).getText(), localObject2) ^ true))) {
        ((NoMeasuredTextView)localObject1).setText((CharSequence)localObject2);
      }
      AppMethodBeat.o(216217);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusUpdateListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "statusUpdate", "Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;)V", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class e
    extends k.a
  {
    public static final k.e.a FZp;
    
    static
    {
      AppMethodBeat.i(216222);
      FZp = new k.e.a((byte)0);
      AppMethodBeat.o(216222);
    }
    
    public e(String paramString, j paramj)
    {
      super(paramString);
      AppMethodBeat.i(216221);
      AppMethodBeat.o(216221);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(216220);
      Log.i("MicroMsg.TxtStatus.StatusCardListener", "StatusCardListener onChange " + this.key);
      Object localObject = fvT().get();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusUpdate");
        AppMethodBeat.o(216220);
        throw ((Throwable)localObject);
      }
      ((j)localObject).DV(this.key);
      AppMethodBeat.o(216220);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(216223);
      ??? = k.FZi;
      Object localObject4;
      for (;;)
      {
        synchronized (k.fvS())
        {
          List localList = (List)new ArrayList();
          localObject4 = k.FZi;
          localObject4 = k.fvS().entrySet().iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          if (!p.j(((k.a)((Map.Entry)localObject5).getValue()).key, this.jDi)) {
            continue;
          }
          if (((k.a)((Map.Entry)localObject5).getValue()).fvT().get() == null) {
            localList.add(((Map.Entry)localObject5).getKey());
          }
        }
        Object localObject5 = (k.a)((Map.Entry)localObject5).getValue();
        WeakReference localWeakReference = ((k.a)localObject5).nsR;
        if (localWeakReference == null) {
          p.btv("ref");
        }
        if (localWeakReference.get() != null) {
          ((k.a)localObject5).onChange();
        }
      }
      Object localObject3 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        int i = ((Number)((Iterator)localObject3).next()).intValue();
        localObject4 = k.FZi;
        k.fvS().remove(Integer.valueOf(i));
      }
      localObject3 = x.SXb;
      AppMethodBeat.o(216223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.k
 * JD-Core Version:    0.7.0.1
 */