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
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "toWhere", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)V", "currentRouter", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "enableRecordPage", "", "isFinishing", "getProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "finish", "", "loadViewFromClass", "key", "clazz", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "scene", "onDestroy", "onPause", "onResume", "route", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  implements a
{
  public static final a vcN;
  private int Lna;
  private final Context context;
  public boolean isFinishing;
  private final ViewGroup pTc;
  private final SparseArray<Class<?>> vcI;
  private final SparseArray<BasePluginLayout> vcJ;
  public BasePluginLayout vcK;
  private boolean vcL;
  private final RecordConfigProvider vcM;
  
  static
  {
    AppMethodBeat.i(75075);
    vcN = new a((byte)0);
    AppMethodBeat.o(75075);
  }
  
  public b(Context paramContext, ViewGroup paramViewGroup, RecordConfigProvider paramRecordConfigProvider, int paramInt)
  {
    AppMethodBeat.i(75074);
    this.context = paramContext;
    this.pTc = paramViewGroup;
    this.vcM = paramRecordConfigProvider;
    this.vcI = new SparseArray();
    this.vcJ = new SparseArray();
    this.Lna = -2;
    ad.i("MicroMsg.RecordUIRouter", "init");
    this.vcI.put(0, RecordPluginLayout.class);
    this.vcI.put(1, EditPhotoPluginLayout.class);
    this.vcI.put(2, EditorVideoPluginLayoutNew.class);
    paramContext = this.vcM.vie;
    k.g(paramContext, "routerMap");
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
        paramRecordConfigProvider = this.vcI;
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
      this.vcL = true;
      paramContext = this.vcI.get(0);
      k.g(paramContext, "viewTable[KEY_TO_RECORD]");
      e(0, (Class)paramContext);
    }
    ad.i("MicroMsg.RecordUIRouter", "setEnableRecordPage " + this.vcL);
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
    paramClass.a((a)this, this.vcM);
    this.vcJ.put(paramInt, paramClass);
    this.pTc.addView((View)paramClass, new ViewGroup.LayoutParams(-1, -1));
    paramClass.setVisibility(8);
    AppMethodBeat.o(75073);
  }
  
  public static final int o(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(75077);
    int i = a.c(-1, paramList1, paramList2);
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
    for (Object localObject1 = paramb.gBs;; localObject1 = null)
    {
      List localList = (List)localObject1;
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = paramb.gBt;
      }
      i = a.c(paramInt, localList, (List)localObject1);
      ad.i("MicroMsg.RecordUIRouter", "toWhere:" + paramInt + " real:" + i + " current:" + this.Lna + " MediaCaptureInfo:" + paramb);
      if (i != this.Lna) {
        break;
      }
      AppMethodBeat.o(75072);
      return;
    }
    this.Lna = i;
    aq.f((Runnable)new d(this, i, paramb));
    AppMethodBeat.o(75072);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter$Companion;", "", "()V", "TAG", "", "autoRoute", "", "toWhere", "photoList", "", "videoList", "plugin-recordvideo_release"})
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
            k.fvU();
          }
          paramInt = paramList1.size();
          break label39;
          label103:
          i = 0;
          break label59;
          label108:
          if (paramList2 == null) {
            k.fvU();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75069);
      int j = b.c(this.vcO).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.vcO).valueAt(i)).onDetach();
        i += 1;
      }
      AppMethodBeat.o(75069);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(75070);
      int j = b.c(this.vcO).size();
      int i = 0;
      while (i < j)
      {
        ((BasePluginLayout)b.c(this.vcO).valueAt(i)).release();
        i += 1;
      }
      AppMethodBeat.o(75070);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb, int paramInt, com.tencent.mm.media.widget.camerarecordview.b.b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(75071);
      if ((i == 0) && (!b.a(this.vcO)))
      {
        localObject = b.b(this.vcO);
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
      if (b.c(this.vcO).get(i) == null)
      {
        if (b.d(this.vcO).get(i) == null)
        {
          ad.e("MicroMsg.RecordUIRouter", "No corresponding " + i);
          AppMethodBeat.o(75071);
          return;
        }
        localObject = b.d(this.vcO).get(i);
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(75071);
          throw ((Throwable)localObject);
        }
        localObject = (Class)localObject;
        ad.i("MicroMsg.RecordUIRouter", "create BasePluginLayout :" + ((Class)localObject).getSimpleName());
        b.a(this.vcO, i, (Class)localObject);
      }
      Object localObject = b.e(this.vcO);
      b.a(this.vcO, (BasePluginLayout)b.c(this.vcO).get(i));
      BasePluginLayout localBasePluginLayout = b.e(this.vcO);
      if (localBasePluginLayout != null) {
        localBasePluginLayout.a(paramb);
      }
      localBasePluginLayout = b.e(this.vcO);
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
        localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(75071);
        return;
        localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(75071);
        return;
        localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.Kp(19);
        localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.b
 * JD-Core Version:    0.7.0.1
 */