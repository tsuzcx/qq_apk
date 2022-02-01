package com.tencent.mm.plugin.recordvideo.activity.a;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "toWhere", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)V", "currentRouter", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "enableRecordPage", "", "isFinishing", "getProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "finish", "", "loadViewFromClass", "key", "clazz", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "scene", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "route", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  implements a
{
  public static final b.a xtA;
  private final Context context;
  private final SparseArray<Class<?>> gGF;
  private final SparseArray<BasePluginLayout> gGG;
  private final ViewGroup gGK;
  public boolean isFinishing;
  public BasePluginLayout xtw;
  private boolean xtx;
  private int xty;
  private final RecordConfigProvider xtz;
  
  static
  {
    AppMethodBeat.i(75075);
    xtA = new b.a((byte)0);
    AppMethodBeat.o(75075);
  }
  
  public b(Context paramContext, ViewGroup paramViewGroup, RecordConfigProvider paramRecordConfigProvider, int paramInt)
  {
    AppMethodBeat.i(75074);
    this.context = paramContext;
    this.gGK = paramViewGroup;
    this.xtz = paramRecordConfigProvider;
    this.gGF = new SparseArray();
    this.gGG = new SparseArray();
    this.xty = -2;
    ad.i("MicroMsg.RecordUIRouter", "init");
    this.gGF.put(0, RecordPluginLayout.class);
    this.gGF.put(1, EditPhotoPluginLayout.class);
    this.gGF.put(2, EditorVideoPluginLayoutNew.class);
    paramContext = this.xtz.gGB;
    p.g(paramContext, "routerMap");
    int i;
    if (!((Map)paramContext).isEmpty())
    {
      i = 1;
      if (i != 0) {
        paramContext = ((Map)paramContext).entrySet().iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramContext.hasNext()) {
          break label344;
        }
        paramViewGroup = (Map.Entry)paramContext.next();
        paramRecordConfigProvider = new StringBuilder("add route key:");
        Object localObject = paramViewGroup.getKey();
        if (localObject == null)
        {
          paramContext = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(75074);
          throw paramContext;
          i = 0;
          break;
        }
        ad.i("MicroMsg.RecordUIRouter", ((Integer)localObject).intValue() + " value:" + paramViewGroup.getValue());
        paramRecordConfigProvider = this.gGF;
        localObject = paramViewGroup.getKey();
        if (localObject == null)
        {
          paramContext = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(75074);
          throw paramContext;
        }
        i = ((Integer)localObject).intValue();
        paramViewGroup = paramViewGroup.getValue();
        if (paramViewGroup == null)
        {
          paramContext = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(75074);
          throw paramContext;
        }
        paramRecordConfigProvider.put(i, Class.forName((String)paramViewGroup));
      }
    }
    label344:
    if (paramInt == 0)
    {
      this.xtx = true;
      paramContext = this.gGF.get(0);
      p.g(paramContext, "viewTable[KEY_TO_RECORD]");
      e(0, (Class)paramContext);
    }
    ad.i("MicroMsg.RecordUIRouter", "setEnableRecordPage " + this.xtx);
    AppMethodBeat.o(75074);
  }
  
  private final void e(int paramInt, Class<?> paramClass)
  {
    AppMethodBeat.i(75073);
    try
    {
      paramClass = paramClass.getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { this.context, null });
      if (paramClass == null)
      {
        paramClass = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout");
        AppMethodBeat.o(75073);
        throw paramClass;
      }
    }
    catch (Exception paramClass)
    {
      ad.printErrStackTrace("MicroMsg.RecordUIRouter", (Throwable)paramClass, "", new Object[0]);
      AppMethodBeat.o(75073);
      return;
    }
    paramClass = (BasePluginLayout)paramClass;
    paramClass.a((a)this, this.xtz);
    this.gGG.put(paramInt, paramClass);
    this.gGK.addView((View)paramClass, new ViewGroup.LayoutParams(-1, -1));
    paramClass.setVisibility(8);
    AppMethodBeat.o(75073);
  }
  
  public static final int o(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(75077);
    int i = b.a.d(-1, paramList1, paramList2);
    AppMethodBeat.o(75077);
    return i;
  }
  
  public final void a(int paramInt, final com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75072);
    if (this.isFinishing)
    {
      ad.i("MicroMsg.RecordUIRouter", "isFinishing toWhere:" + paramInt + "  MediaCaptureInfo:" + paramb);
      AppMethodBeat.o(75072);
      return;
    }
    if (paramb != null) {}
    final int i;
    for (Object localObject1 = paramb.htW;; localObject1 = null)
    {
      List localList = (List)localObject1;
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = paramb.htX;
      }
      i = b.a.d(paramInt, localList, (List)localObject1);
      ad.i("MicroMsg.RecordUIRouter", "toWhere:" + paramInt + " real:" + i + " current:" + this.xty + " MediaCaptureInfo:" + paramb);
      if (i != this.xty) {
        break;
      }
      AppMethodBeat.o(75072);
      return;
    }
    this.xty = i;
    aq.f((Runnable)new d(this, i, paramb));
    AppMethodBeat.o(75072);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75069);
      int j = b.c(this.xtB).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.xtB).valueAt(i)).onDetach();
        i += 1;
      }
      AppMethodBeat.o(75069);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75070);
      int j = b.c(this.xtB).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.xtB).valueAt(i)).release();
        i += 1;
      }
      AppMethodBeat.o(75070);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb, int paramInt, com.tencent.mm.media.widget.camerarecordview.b.b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(75071);
      if ((i == 0) && (!b.a(this.xtB)))
      {
        localObject = b.b(this.xtB);
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75071);
          throw ((Throwable)localObject);
        }
        ((Activity)localObject).finish();
        AppMethodBeat.o(75071);
        return;
      }
      if (b.c(this.xtB).get(i) == null)
      {
        if (b.d(this.xtB).get(i) == null)
        {
          ad.e("MicroMsg.RecordUIRouter", "No corresponding " + i);
          AppMethodBeat.o(75071);
          return;
        }
        localObject = b.d(this.xtB).get(i);
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(75071);
          throw ((Throwable)localObject);
        }
        localObject = (Class)localObject;
        ad.i("MicroMsg.RecordUIRouter", "create BasePluginLayout :" + ((Class)localObject).getSimpleName());
        b.a(this.xtB, i, (Class)localObject);
      }
      Object localObject = b.e(this.xtB);
      b.a(this.xtB, (BasePluginLayout)b.c(this.xtB).get(i));
      BasePluginLayout localBasePluginLayout = b.e(this.xtB);
      if (localBasePluginLayout != null) {
        localBasePluginLayout.a(paramb);
      }
      localBasePluginLayout = b.e(this.xtB);
      if (localBasePluginLayout != null) {
        localBasePluginLayout.bringToFront();
      }
      if (localObject != null) {
        ((BasePluginLayout)localObject).onPause();
      }
      if (localObject != null) {
        ((BasePluginLayout)localObject).onDetach();
      }
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(75071);
        return;
        localObject = c.xHa;
        c.u("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(75071);
        return;
        localObject = c.xHa;
        c.u("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(75071);
        return;
        localObject = c.xHa;
        c.NN(19);
        localObject = c.xHa;
        c.u("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.b
 * JD-Core Version:    0.7.0.1
 */