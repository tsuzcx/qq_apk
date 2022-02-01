package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/BgMixManager;", "", "()V", "TAG", "", "callbacks", "Landroid/util/SparseArray;", "", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "getCallbacks", "()Landroid/util/SparseArray;", "addCallback", "", "scene", "", "callback", "getFakeImageToVideoLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "context", "Landroid/content/Context;", "getFakeVideoLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "notifyFinish", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "notifyInit", "notifyRun", "runNum", "notifyWait", "removeCallback", "plugin-recordvideo_release"})
public final class a
{
  private static final SparseArray<Set<b>> vQF;
  public static final a xua;
  
  static
  {
    AppMethodBeat.i(75166);
    xua = new a();
    vQF = new SparseArray();
    AppMethodBeat.o(75166);
  }
  
  public static void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(75158);
    p.h(paramb, "callback");
    Set localSet2 = (Set)vQF.get(paramInt);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = (Set)new LinkedHashSet();
      vQF.put(paramInt, localSet1);
    }
    localSet1.add(paramb);
    AppMethodBeat.o(75158);
  }
  
  public static void a(int paramInt, final String paramString, final boolean paramBoolean, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75163);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.mix_background.BgMixManager", "notifyFinish, taskId:" + paramString + ", success:" + paramBoolean + ", model:" + paramCaptureVideoNormalModel);
    h.LTJ.f((Runnable)new a(paramInt, paramString, paramBoolean, paramCaptureVideoNormalModel), "BgMixManager_notifyFinish");
    AppMethodBeat.o(75163);
  }
  
  public static void b(int paramInt, b paramb)
  {
    AppMethodBeat.i(75159);
    p.h(paramb, "callback");
    Set localSet = (Set)vQF.get(paramInt);
    if (localSet != null) {
      localSet.remove(paramb);
    }
    if (localSet != null)
    {
      if (localSet.isEmpty() == true) {
        vQF.remove(paramInt);
      }
      AppMethodBeat.o(75159);
      return;
    }
    AppMethodBeat.o(75159);
  }
  
  public static void bF(int paramInt, final String paramString)
  {
    AppMethodBeat.i(75160);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.mix_background.BgMixManager", "notifyInit, taskId:".concat(String.valueOf(paramString)));
    h.LTJ.f((Runnable)new b(paramInt, paramString), "BgMixManager_notifyInit");
    AppMethodBeat.o(75160);
  }
  
  public static void bG(int paramInt, final String paramString)
  {
    AppMethodBeat.i(75162);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.mix_background.BgMixManager", "notifyWait, taskId:".concat(String.valueOf(paramString)));
    h.LTJ.f((Runnable)new d(paramInt, paramString), "BgMixManager_notifyWait");
    AppMethodBeat.o(75162);
  }
  
  public static SparseArray<Set<b>> dEC()
  {
    return vQF;
  }
  
  public static FakeVideoViewLayer fY(Context paramContext)
  {
    AppMethodBeat.i(75164);
    if (paramContext != null)
    {
      paramContext = new FakeVideoViewLayer(paramContext);
      AppMethodBeat.o(75164);
      return paramContext;
    }
    paramContext = aj.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    paramContext = new FakeVideoViewLayer(paramContext);
    AppMethodBeat.o(75164);
    return paramContext;
  }
  
  public static f fZ(Context paramContext)
  {
    AppMethodBeat.i(75165);
    if (paramContext != null)
    {
      paramContext = new f(paramContext);
      AppMethodBeat.o(75165);
      return paramContext;
    }
    paramContext = aj.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    paramContext = new f(paramContext);
    AppMethodBeat.o(75165);
    return paramContext;
  }
  
  public static void n(int paramInt1, final String paramString, final int paramInt2)
  {
    AppMethodBeat.i(75161);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.mix_background.BgMixManager", "notifyRun, taskId:" + paramString + ", runNum:" + paramInt2);
    h.LTJ.f((Runnable)new c(paramInt1, paramString, paramInt2), "BgMixManager_notifyRun");
    AppMethodBeat.o(75161);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(int paramInt, String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel) {}
    
    public final void run()
    {
      AppMethodBeat.i(75154);
      Object localObject = a.xua;
      localObject = (Set)a.dEC().get(this.hST);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((b)((Iterator)localObject).next()).a(paramString, paramBoolean, paramCaptureVideoNormalModel);
        }
        AppMethodBeat.o(75154);
        return;
      }
      AppMethodBeat.o(75154);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75155);
      Object localObject = a.xua;
      localObject = (Set)a.dEC().get(this.hST);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((b)((Iterator)localObject).next()).alO(paramString);
        }
        AppMethodBeat.o(75155);
        return;
      }
      AppMethodBeat.o(75155);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(int paramInt1, String paramString, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(75156);
      Object localObject = a.xua;
      localObject = (Set)a.dEC().get(this.hST);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((b)((Iterator)localObject).next()).dO(paramString, paramInt2);
        }
        AppMethodBeat.o(75156);
        return;
      }
      AppMethodBeat.o(75156);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75157);
      Object localObject = a.xua;
      localObject = (Set)a.dEC().get(this.hST);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((b)((Iterator)localObject).next()).alP(paramString);
        }
        AppMethodBeat.o(75157);
        return;
      }
      AppMethodBeat.o(75157);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a
 * JD-Core Version:    0.7.0.1
 */