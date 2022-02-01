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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "toWhere", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)V", "currentRouter", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "enableRecordPage", "", "isFinishing", "getProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "finish", "", "loadViewFromClass", "key", "clazz", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "scene", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "route", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  implements a
{
  public static final b.a xJx;
  private final Context context;
  private final SparseArray<Class<?>> gJo;
  private final SparseArray<BasePluginLayout> gJp;
  private final ViewGroup gJt;
  public boolean isFinishing;
  public BasePluginLayout xJt;
  private boolean xJu;
  private int xJv;
  private final RecordConfigProvider xJw;
  
  static
  {
    AppMethodBeat.i(75075);
    xJx = new b.a((byte)0);
    AppMethodBeat.o(75075);
  }
  
  public b(Context paramContext, ViewGroup paramViewGroup, RecordConfigProvider paramRecordConfigProvider, int paramInt)
  {
    AppMethodBeat.i(75074);
    this.context = paramContext;
    this.gJt = paramViewGroup;
    this.xJw = paramRecordConfigProvider;
    this.gJo = new SparseArray();
    this.gJp = new SparseArray();
    this.xJv = -2;
    ae.i("MicroMsg.RecordUIRouter", "init");
    this.gJo.put(0, RecordPluginLayout.class);
    this.gJo.put(1, EditPhotoPluginLayout.class);
    this.gJo.put(2, EditorVideoPluginLayoutNew.class);
    paramContext = this.xJw.gJk;
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
        ae.i("MicroMsg.RecordUIRouter", ((Integer)localObject).intValue() + " value:" + paramViewGroup.getValue());
        paramRecordConfigProvider = this.gJo;
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
      this.xJu = true;
      paramContext = this.gJo.get(0);
      p.g(paramContext, "viewTable[KEY_TO_RECORD]");
      e(0, (Class)paramContext);
    }
    ae.i("MicroMsg.RecordUIRouter", "setEnableRecordPage " + this.xJu);
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
      ae.printErrStackTrace("MicroMsg.RecordUIRouter", (Throwable)paramClass, "", new Object[0]);
      AppMethodBeat.o(75073);
      return;
    }
    paramClass = (BasePluginLayout)paramClass;
    paramClass.a((a)this, this.xJw);
    this.gJp.put(paramInt, paramClass);
    this.gJt.addView((View)paramClass, new ViewGroup.LayoutParams(-1, -1));
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
      ae.i("MicroMsg.RecordUIRouter", "isFinishing toWhere:" + paramInt + "  MediaCaptureInfo:" + paramb);
      AppMethodBeat.o(75072);
      return;
    }
    if (paramb != null) {}
    final int i;
    for (Object localObject1 = paramb.hwK;; localObject1 = null)
    {
      List localList = (List)localObject1;
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = paramb.hwL;
      }
      i = b.a.d(paramInt, localList, (List)localObject1);
      ae.i("MicroMsg.RecordUIRouter", "toWhere:" + paramInt + " real:" + i + " current:" + this.xJv + " MediaCaptureInfo:" + paramb);
      if (i != this.xJv) {
        break;
      }
      AppMethodBeat.o(75072);
      return;
    }
    this.xJv = i;
    ar.f((Runnable)new d(this, i, paramb));
    AppMethodBeat.o(75072);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75069);
      int j = b.c(this.xJy).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.xJy).valueAt(i)).onDetach();
        i += 1;
      }
      AppMethodBeat.o(75069);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75070);
      int j = b.c(this.xJy).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.xJy).valueAt(i)).release();
        i += 1;
      }
      AppMethodBeat.o(75070);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb, int paramInt, com.tencent.mm.media.widget.camerarecordview.b.b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(75071);
      if ((i == 0) && (!b.a(this.xJy)))
      {
        localObject = b.b(this.xJy);
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
      if (b.c(this.xJy).get(i) == null)
      {
        if (b.d(this.xJy).get(i) == null)
        {
          ae.e("MicroMsg.RecordUIRouter", "No corresponding " + i);
          AppMethodBeat.o(75071);
          return;
        }
        localObject = b.d(this.xJy).get(i);
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(75071);
          throw ((Throwable)localObject);
        }
        localObject = (Class)localObject;
        ae.i("MicroMsg.RecordUIRouter", "create BasePluginLayout :" + ((Class)localObject).getSimpleName());
        b.a(this.xJy, i, (Class)localObject);
      }
      Object localObject = b.e(this.xJy);
      b.a(this.xJy, (BasePluginLayout)b.c(this.xJy).get(i));
      BasePluginLayout localBasePluginLayout = b.e(this.xJy);
      if (localBasePluginLayout != null) {
        localBasePluginLayout.a(paramb);
      }
      localBasePluginLayout = b.e(this.xJy);
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
        localObject = c.xWV;
        c.u("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(75071);
        return;
        localObject = c.xWV;
        c.u("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(75071);
        return;
        localObject = c.xWV;
        c.Ot(19);
        localObject = c.xWV;
        c.u("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.b
 * JD-Core Version:    0.7.0.1
 */