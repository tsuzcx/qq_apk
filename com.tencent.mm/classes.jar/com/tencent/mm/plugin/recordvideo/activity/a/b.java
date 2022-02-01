package com.tencent.mm.plugin.recordvideo.activity.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.d.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "toWhere", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)V", "currentRouter", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "enableRecordPage", "", "isFinishing", "getProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "finish", "", "loadViewFromClass", "key", "clazz", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "scene", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "route", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  implements a
{
  public static final b.a BJA;
  public BasePluginLayout BJw;
  private boolean BJx;
  private int BJy;
  private final RecordConfigProvider BJz;
  private final Context context;
  private final SparseArray<Class<?>> hwn;
  private final SparseArray<BasePluginLayout> hwo;
  private final ViewGroup hwr;
  public boolean isFinishing;
  
  static
  {
    AppMethodBeat.i(75075);
    BJA = new b.a((byte)0);
    AppMethodBeat.o(75075);
  }
  
  public b(Context paramContext, ViewGroup paramViewGroup, RecordConfigProvider paramRecordConfigProvider, int paramInt)
  {
    AppMethodBeat.i(75074);
    this.context = paramContext;
    this.hwr = paramViewGroup;
    this.BJz = paramRecordConfigProvider;
    this.hwn = new SparseArray();
    this.hwo = new SparseArray();
    this.BJy = -2;
    Log.i("MicroMsg.RecordUIRouter", "init");
    this.hwn.put(0, RecordPluginLayout.class);
    this.hwn.put(1, EditPhotoPluginLayout.class);
    this.hwn.put(2, EditorVideoPluginLayoutNew.class);
    paramContext = this.BJz.hwc;
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
          paramContext = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(75074);
          throw paramContext;
          i = 0;
          break;
        }
        Log.i("MicroMsg.RecordUIRouter", ((Integer)localObject).intValue() + " value:" + paramViewGroup.getValue());
        paramRecordConfigProvider = this.hwn;
        localObject = paramViewGroup.getKey();
        if (localObject == null)
        {
          paramContext = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(75074);
          throw paramContext;
        }
        i = ((Integer)localObject).intValue();
        paramViewGroup = paramViewGroup.getValue();
        if (paramViewGroup == null)
        {
          paramContext = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(75074);
          throw paramContext;
        }
        paramRecordConfigProvider.put(i, Class.forName((String)paramViewGroup));
      }
    }
    label344:
    paramContext = g.BXY;
    long l = SystemClock.elapsedRealtime();
    if (g.BXW != 0L)
    {
      Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport In setInitRouterTImeStamp");
      g.BXV.vQ(g.eLg());
      g.BXV.bfK();
    }
    Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReset");
    g.BXV = new if();
    g.BXX.clear();
    g.BXW = l;
    g.BXV.qY(l);
    paramContext = g.BXY;
    g.g(this.hwn);
    if (paramInt == 0)
    {
      this.BJx = true;
      paramContext = this.hwn.get(0);
      p.g(paramContext, "viewTable[KEY_TO_RECORD]");
      e(0, (Class)paramContext);
    }
    Log.i("MicroMsg.RecordUIRouter", "setEnableRecordPage " + this.BJx);
    AppMethodBeat.o(75074);
  }
  
  private final void e(int paramInt, Class<?> paramClass)
  {
    AppMethodBeat.i(75073);
    try
    {
      paramClass = paramClass.getConstructor(new Class[] { Context.class, AttributeSet.class });
      p.g(paramClass, "clazz.getConstructor(Con…AttributeSet::class.java)");
      paramClass = paramClass.newInstance(new Object[] { this.context, null });
      if (paramClass == null)
      {
        paramClass = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout");
        AppMethodBeat.o(75073);
        throw paramClass;
      }
    }
    catch (Exception paramClass)
    {
      Log.printErrStackTrace("MicroMsg.RecordUIRouter", (Throwable)paramClass, "", new Object[0]);
      AppMethodBeat.o(75073);
      return;
    }
    paramClass = (BasePluginLayout)paramClass;
    paramClass.a((a)this, this.BJz);
    this.hwo.put(paramInt, paramClass);
    this.hwr.addView((View)paramClass, new ViewGroup.LayoutParams(-1, -1));
    paramClass.setVisibility(8);
    AppMethodBeat.o(75073);
  }
  
  public static final int q(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(75077);
    int i = b.a.c(-1, paramList1, paramList2);
    AppMethodBeat.o(75077);
    return i;
  }
  
  public final void a(final int paramInt, final com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75072);
    if (this.isFinishing)
    {
      Log.i("MicroMsg.RecordUIRouter", "isFinishing toWhere:" + paramInt + "  MediaCaptureInfo:" + paramb);
      AppMethodBeat.o(75072);
      return;
    }
    if (paramb != null) {}
    final int i;
    for (Object localObject1 = paramb.iqm;; localObject1 = null)
    {
      List localList = (List)localObject1;
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = paramb.iqn;
      }
      i = b.a.c(paramInt, localList, (List)localObject1);
      Log.i("MicroMsg.RecordUIRouter", "toWhere:" + paramInt + " real:" + i + " current:" + this.BJy + " MediaCaptureInfo:" + paramb);
      if (i != this.BJy) {
        break;
      }
      AppMethodBeat.o(75072);
      return;
    }
    this.BJy = i;
    MMHandlerThread.postToMainThread((Runnable)new d(this, i, paramb, paramInt));
    AppMethodBeat.o(75072);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75069);
      int j = b.c(this.BJB).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.BJB).valueAt(i)).onDetach();
        i += 1;
      }
      AppMethodBeat.o(75069);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75070);
      int j = b.c(this.BJB).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.BJB).valueAt(i)).release();
        i += 1;
      }
      AppMethodBeat.o(75070);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb, int paramInt1, com.tencent.mm.media.widget.camerarecordview.b.b paramb1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(75071);
      if ((i == 0) && (!b.a(this.BJB)))
      {
        localObject = b.b(this.BJB);
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
          AppMethodBeat.o(75071);
          throw ((Throwable)localObject);
        }
        ((MMRecordUI)localObject).finish();
        AppMethodBeat.o(75071);
        return;
      }
      if (b.c(this.BJB).get(i) == null)
      {
        if (b.d(this.BJB).get(i) == null)
        {
          Log.e("MicroMsg.RecordUIRouter", "No corresponding " + i);
          AppMethodBeat.o(75071);
          return;
        }
        localObject = b.d(this.BJB).get(i);
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(75071);
          throw ((Throwable)localObject);
        }
        localObject = (Class)localObject;
        Log.i("MicroMsg.RecordUIRouter", "create BasePluginLayout :" + ((Class)localObject).getSimpleName());
        b.a(this.BJB, i, (Class)localObject);
      }
      Object localObject = b.e(this.BJB);
      b.a(this.BJB, (BasePluginLayout)b.c(this.BJB).get(i));
      BasePluginLayout localBasePluginLayout = b.e(this.BJB);
      if (localBasePluginLayout != null) {
        localBasePluginLayout.a(paramb);
      }
      localBasePluginLayout = b.e(this.BJB);
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
        localObject = g.BXY;
        long l = SystemClock.elapsedRealtime();
        localObject = b.d(this.BJB).get(paramInt);
        p.g(localObject, "viewTable.get(toWhere)");
        localObject = ((Class)localObject).getSimpleName();
        p.g(localObject, "viewTable.get(toWhere).simpleName");
        g.F(l, (String)localObject);
        AppMethodBeat.o(75071);
        return;
        localObject = c.BXI;
        c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        continue;
        localObject = c.BXI;
        c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        continue;
        localObject = c.BXI;
        c.VI(19);
        localObject = c.BXI;
        c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.b
 * JD-Core Version:    0.7.0.1
 */