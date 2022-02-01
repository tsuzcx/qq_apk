package com.tencent.mm.plugin.textstatus.g;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter;", "", "()V", "ICON_CHAR", "", "TAG", "", "listeners", "", "", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "cancelListener", "", "_key", "subject", "onNotify", "userName", "Listener", "StatusIconListener", "StatusSpanListener", "StatusSpanListenerNoMeasure", "StatusUpdateListener", "plugin-textstatus_release"})
public final class n
{
  public static final n MDy;
  private static final Map<Integer, a> tnR;
  
  static
  {
    AppMethodBeat.i(237358);
    MDy = new n();
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.MAm;
    com.tencent.mm.plugin.textstatus.b.f.gly().add((MStorage.IOnStorageChange)1.MDz);
    localf = com.tencent.mm.plugin.textstatus.b.f.MAm;
    com.tencent.mm.plugin.textstatus.b.f.glz().add((MStorage.IOnStorageChange)2.MDA);
    tnR = (Map)new LinkedHashMap();
    AppMethodBeat.o(237358);
  }
  
  public static void B(String paramString, Object paramObject)
  {
    AppMethodBeat.i(237355);
    p.k(paramString, "_key");
    p.k(paramObject, "subject");
    synchronized (tnR)
    {
      a locala = (a)tnR.get(Integer.valueOf(paramObject.hashCode()));
      if ((locala != null) && (p.h(paramString, locala.key)))
      {
        tnR.remove(Integer.valueOf(paramObject.hashCode()));
        Log.i("MicroMsg.TextStatus.TextStatusEventCenter", "cancelListener ".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(237355);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "", "subject", "key", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "setRef", "(Ljava/lang/ref/WeakReference;)V", "notDeadToRun", "", "onChange", "plugin-textstatus_release"})
  public static abstract class a
  {
    String key;
    public WeakReference<Object> quK;
    
    public a(Object paramObject, String arg2)
    {
      this.key = ???;
      this.quK = new WeakReference(paramObject);
      ??? = n.MDy;
      synchronized (n.glW())
      {
        n localn = n.MDy;
        n.glW().put(Integer.valueOf(paramObject.hashCode()), this);
        return;
      }
    }
    
    public final WeakReference<Object> glX()
    {
      WeakReference localWeakReference = this.quK;
      if (localWeakReference == null) {
        p.bGy("ref");
      }
      return localWeakReference;
    }
    
    public abstract void onChange();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusIconListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconIV", "Landroid/widget/ImageView;", "(Ljava/lang/String;Landroid/widget/ImageView;)V", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class b
    extends n.a
  {
    public static final n.b.a MDB;
    
    static
    {
      AppMethodBeat.i(234281);
      MDB = new n.b.a((byte)0);
      AppMethodBeat.o(234281);
    }
    
    public b(String paramString, ImageView paramImageView)
    {
      super(paramString);
      AppMethodBeat.i(234280);
      paramImageView = n.MDy;
      n.bet(paramString);
      AppMethodBeat.o(234280);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(234279);
      Log.i("MicroMsg.TextStatus.StatusIconListener", "onChange " + this.key);
      Object localObject2 = glX().get();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ImageView)) {
        localObject1 = null;
      }
      localObject1 = (ImageView)localObject1;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.bep(this.key);
      if (localObject2 != null)
      {
        String str = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_IconID;
        if (str != null)
        {
          com.tencent.mm.plugin.textstatus.k.a.a(com.tencent.mm.plugin.textstatus.k.c.gnz(), (ImageView)localObject1, str, a.c.MzI, null, (com.tencent.mm.plugin.textstatus.g.e.a)localObject2, 8);
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(0);
          }
          if (str != null) {
            break label120;
          }
        }
      }
      if (localObject1 != null)
      {
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = x.aazN;
      }
      label120:
      AppMethodBeat.o(234279);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Landroid/widget/TextView;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Ljava/lang/String;Landroid/widget/TextView;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class c
    extends n.a
  {
    public static final n.c.a MDE;
    private final a.c MDC;
    private final a.b MDD;
    
    static
    {
      AppMethodBeat.i(235721);
      MDE = new n.c.a((byte)0);
      AppMethodBeat.o(235721);
    }
    
    public c(String paramString, TextView paramTextView, a.c paramc, a.b paramb)
    {
      super(paramString);
      AppMethodBeat.i(235719);
      this.MDC = paramc;
      this.MDD = paramb;
      onChange();
      AppMethodBeat.o(235719);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(235718);
      Log.d("MicroMsg.TextStatus.StatusSpanListener", "onChange " + this.key);
      Object localObject = glX().get();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(235718);
        throw ((Throwable)localObject);
      }
      localObject = (TextView)localObject;
      com.tencent.mm.plugin.textstatus.k.c.gnz();
      CharSequence localCharSequence = com.tencent.mm.plugin.textstatus.k.a.a((View)localObject, this.key, ((TextView)localObject).getText(), (int)((TextView)localObject).getTextSize(), this.MDC, this.MDD);
      if ((localCharSequence != null) && ((p.h(((TextView)localObject).getText(), localCharSequence) ^ true))) {
        ((TextView)localObject).setText(localCharSequence);
      }
      AppMethodBeat.o(235718);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListenerNoMeasure;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/NoMeasuredTextView;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class d
    extends n.a
  {
    public static final n.d.a MDF;
    private final a.b MDD;
    
    static
    {
      AppMethodBeat.i(234901);
      MDF = new n.d.a((byte)0);
      AppMethodBeat.o(234901);
    }
    
    public d(String paramString, NoMeasuredTextView paramNoMeasuredTextView, a.b paramb)
    {
      super(paramString);
      AppMethodBeat.i(234900);
      this.MDD = paramb;
      onChange();
      AppMethodBeat.o(234900);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(234899);
      Log.d("MicroMsg.TextStatus.StatusSpanListenerNoMeasure", "onChange " + this.key);
      Object localObject = glX().get();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.NoMeasuredTextView");
        AppMethodBeat.o(234899);
        throw ((Throwable)localObject);
      }
      localObject = (NoMeasuredTextView)localObject;
      com.tencent.mm.plugin.textstatus.k.c.gnz();
      CharSequence localCharSequence = com.tencent.mm.plugin.textstatus.k.a.a((View)localObject, this.key, ((NoMeasuredTextView)localObject).getText(), (int)((NoMeasuredTextView)localObject).getTextSize(), a.c.MzI, this.MDD);
      if ((localCharSequence != null) && ((p.h(((NoMeasuredTextView)localObject).getText(), localCharSequence) ^ true))) {
        ((NoMeasuredTextView)localObject).setText(localCharSequence);
      }
      AppMethodBeat.o(234899);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusUpdateListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "statusUpdate", "Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;)V", "onChange", "", "Companion", "plugin-textstatus_release"})
  public static final class e
    extends n.a
  {
    public static final n.e.a MDG;
    
    static
    {
      AppMethodBeat.i(235125);
      MDG = new n.e.a((byte)0);
      AppMethodBeat.o(235125);
    }
    
    public e(String paramString, com.tencent.mm.plugin.textstatus.a.n paramn)
    {
      super(paramString);
      AppMethodBeat.i(235123);
      AppMethodBeat.o(235123);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(235121);
      Log.i("MicroMsg.TextStatus.StatusCardListener", "StatusCardListener onChange " + this.key);
      Object localObject = glX().get();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusUpdate");
        AppMethodBeat.o(235121);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.plugin.textstatus.a.n)localObject).KN(this.key);
      AppMethodBeat.o(235121);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(235016);
      ??? = n.MDy;
      Object localObject4;
      for (;;)
      {
        synchronized (n.glW())
        {
          List localList = (List)new ArrayList();
          localObject4 = n.MDy;
          localObject4 = n.glW().entrySet().iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          if (!p.h(((n.a)((Map.Entry)localObject5).getValue()).key, this.mtC)) {
            continue;
          }
          if (((n.a)((Map.Entry)localObject5).getValue()).glX().get() == null) {
            localList.add(((Map.Entry)localObject5).getKey());
          }
        }
        Object localObject5 = (n.a)((Map.Entry)localObject5).getValue();
        WeakReference localWeakReference = ((n.a)localObject5).quK;
        if (localWeakReference == null) {
          p.bGy("ref");
        }
        if (localWeakReference.get() != null) {
          ((n.a)localObject5).onChange();
        }
      }
      Object localObject3 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        int i = ((Number)((Iterator)localObject3).next()).intValue();
        localObject4 = n.MDy;
        n.glW().remove(Integer.valueOf(i));
      }
      localObject3 = x.aazN;
      AppMethodBeat.o(235016);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.n
 * JD-Core Version:    0.7.0.1
 */