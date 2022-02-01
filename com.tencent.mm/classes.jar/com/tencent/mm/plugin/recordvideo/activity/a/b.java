package com.tencent.mm.plugin.recordvideo.activity.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.km;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "toWhere", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)V", "currentRouter", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "enableRecordPage", "", "isFinishing", "getProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "finish", "", "loadViewFromClass", "key", "clazz", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "scene", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "route", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  implements a
{
  public static final a HFK;
  public BasePluginLayout HFG;
  private boolean HFH;
  private int HFI;
  private final RecordConfigProvider HFJ;
  private final Context context;
  public boolean isFinishing;
  private final SparseArray<Class<?>> kiA;
  private final SparseArray<BasePluginLayout> kiB;
  private final ViewGroup kiF;
  
  static
  {
    AppMethodBeat.i(75075);
    HFK = new a((byte)0);
    AppMethodBeat.o(75075);
  }
  
  public b(Context paramContext, ViewGroup paramViewGroup, RecordConfigProvider paramRecordConfigProvider, int paramInt)
  {
    AppMethodBeat.i(75074);
    this.context = paramContext;
    this.kiF = paramViewGroup;
    this.HFJ = paramRecordConfigProvider;
    this.kiA = new SparseArray();
    this.kiB = new SparseArray();
    this.HFI = -2;
    Log.i("MicroMsg.RecordUIRouter", "init");
    this.kiA.put(0, RecordPluginLayout.class);
    this.kiA.put(1, EditPhotoPluginLayout.class);
    this.kiA.put(2, EditorVideoPluginLayoutNew.class);
    paramContext = this.HFJ.kif;
    p.j(paramContext, "routerMap");
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
        paramRecordConfigProvider = this.kiA;
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
    paramContext = g.HUM;
    long l = SystemClock.elapsedRealtime();
    if (g.HUK != 0L)
    {
      Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport In setInitRouterTImeStamp");
      g.HUJ.Bp(g.fxz());
      g.HUJ.bpa();
    }
    Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReset");
    g.HUJ = new km();
    g.HUL.clear();
    g.HUK = l;
    g.HUJ.uQ(l);
    paramContext = g.HUM;
    g.g(this.kiA);
    if (paramInt == 0)
    {
      this.HFH = true;
      paramContext = this.kiA.get(0);
      p.j(paramContext, "viewTable[KEY_TO_RECORD]");
      b(0, (Class)paramContext);
    }
    Log.i("MicroMsg.RecordUIRouter", "setEnableRecordPage " + this.HFH);
    AppMethodBeat.o(75074);
  }
  
  private final void b(int paramInt, Class<?> paramClass)
  {
    AppMethodBeat.i(75073);
    try
    {
      paramClass = paramClass.getConstructor(new Class[] { Context.class, AttributeSet.class });
      p.j(paramClass, "clazz.getConstructor(Con…AttributeSet::class.java)");
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
    paramClass.a((a)this, this.HFJ);
    this.kiB.put(paramInt, paramClass);
    this.kiF.addView((View)paramClass, new ViewGroup.LayoutParams(-1, -1));
    paramClass.setVisibility(8);
    AppMethodBeat.o(75073);
  }
  
  public static final int u(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(75077);
    int i = a.c(-1, paramList1, paramList2);
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
    for (Object localObject1 = paramb.lfr;; localObject1 = null)
    {
      List localList = (List)localObject1;
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = paramb.lfs;
      }
      i = a.c(paramInt, localList, (List)localObject1);
      Log.i("MicroMsg.RecordUIRouter", "toWhere:" + paramInt + " real:" + i + " current:" + this.HFI + " MediaCaptureInfo:" + paramb);
      if (i != this.HFI) {
        break;
      }
      AppMethodBeat.o(75072);
      return;
    }
    this.HFI = i;
    MMHandlerThread.postToMainThread((Runnable)new d(this, i, paramb, paramInt));
    AppMethodBeat.o(75072);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter$Companion;", "", "()V", "TAG", "", "autoRoute", "", "toWhere", "photoList", "", "videoList", "plugin-recordvideo_release"})
  public static final class a
  {
    public static int c(int paramInt, List<String> paramList1, List<String> paramList2)
    {
      AppMethodBeat.i(75068);
      if (-1 == paramInt)
      {
        Collection localCollection = (Collection)paramList1;
        if ((localCollection == null) || (localCollection.isEmpty()))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label86;
          }
          paramInt = 0;
          label39:
          paramList1 = (Collection)paramList2;
          if ((paramList1 != null) && (!paramList1.isEmpty())) {
            break label103;
          }
          i = 1;
          label59:
          if (i == 0) {
            break label108;
          }
        }
        for (int i = 0;; i = paramList2.size())
        {
          if ((paramInt > 2) || (i != 0)) {
            break label125;
          }
          AppMethodBeat.o(75068);
          return 1;
          paramInt = 0;
          break;
          label86:
          if (paramList1 == null) {
            p.iCn();
          }
          paramInt = paramList1.size();
          break label39;
          label103:
          i = 0;
          break label59;
          label108:
          if (paramList2 == null) {
            p.iCn();
          }
        }
        label125:
        if ((paramInt > 2) && (i == 0))
        {
          AppMethodBeat.o(75068);
          return 3;
        }
        if (((paramInt > 0) && (i > 0)) || (i > 1) || (paramInt > 1))
        {
          AppMethodBeat.o(75068);
          return 4;
        }
        if ((paramInt == 0) && (i == 1))
        {
          AppMethodBeat.o(75068);
          return 2;
        }
        AppMethodBeat.o(75068);
        return 0;
      }
      AppMethodBeat.o(75068);
      return paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75069);
      int j = b.c(this.HFL).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.HFL).valueAt(i)).onDetach();
        i += 1;
      }
      AppMethodBeat.o(75069);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75070);
      int j = b.c(this.HFL).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.HFL).valueAt(i)).release();
        i += 1;
      }
      AppMethodBeat.o(75070);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb, int paramInt1, com.tencent.mm.media.widget.camerarecordview.b.b paramb1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(75071);
      if ((i == 0) && (!b.a(this.HFL)))
      {
        localObject = b.b(this.HFL);
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
      if (b.c(this.HFL).get(i) == null)
      {
        if (b.d(this.HFL).get(i) == null)
        {
          Log.e("MicroMsg.RecordUIRouter", "No corresponding " + i);
          AppMethodBeat.o(75071);
          return;
        }
        localObject = b.d(this.HFL).get(i);
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(75071);
          throw ((Throwable)localObject);
        }
        localObject = (Class)localObject;
        Log.i("MicroMsg.RecordUIRouter", "create BasePluginLayout :" + ((Class)localObject).getSimpleName());
        b.a(this.HFL, i, (Class)localObject);
      }
      Object localObject = b.e(this.HFL);
      b.a(this.HFL, (BasePluginLayout)b.c(this.HFL).get(i));
      BasePluginLayout localBasePluginLayout = b.e(this.HFL);
      if (localBasePluginLayout != null) {
        localBasePluginLayout.a(paramb);
      }
      localBasePluginLayout = b.e(this.HFL);
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
        localObject = g.HUM;
        long l = SystemClock.elapsedRealtime();
        localObject = b.d(this.HFL).get(paramInt);
        p.j(localObject, "viewTable.get(toWhere)");
        localObject = ((Class)localObject).getSimpleName();
        p.j(localObject, "viewTable.get(toWhere).simpleName");
        g.N(l, (String)localObject);
        AppMethodBeat.o(75071);
        return;
        localObject = c.HUw;
        c.w("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        continue;
        localObject = c.HUw;
        c.w("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        continue;
        localObject = c.HUw;
        c.acr(19);
        localObject = c.HUw;
        c.w("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.b
 * JD-Core Version:    0.7.0.1
 */