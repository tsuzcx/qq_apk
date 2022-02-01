package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.recordvideo.ui.editor.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/BgMixManager;", "", "()V", "TAG", "", "callbacks", "Landroid/util/SparseArray;", "", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "getCallbacks", "()Landroid/util/SparseArray;", "addCallback", "", "scene", "", "callback", "getFakeImageToVideoLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "context", "Landroid/content/Context;", "getFakeVideoLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "notifyFinish", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "notifyInit", "notifyRun", "runNum", "notifyWait", "removeCallback", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final SparseArray<Set<b>> KXN;
  public static final a NDM;
  
  static
  {
    AppMethodBeat.i(75166);
    NDM = new a();
    KXN = new SparseArray();
    AppMethodBeat.o(75166);
  }
  
  public static void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(75158);
    s.u(paramb, "callback");
    Set localSet2 = (Set)KXN.get(paramInt);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = (Set)new LinkedHashSet();
      KXN.put(paramInt, localSet1);
    }
    localSet1.add(paramb);
    AppMethodBeat.o(75158);
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75163);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.mix_background.BgMixManager", "notifyFinish, taskId:" + paramString + ", success:" + paramBoolean + ", model:" + paramCaptureVideoNormalModel);
    h.ahAA.g(new a..ExternalSyntheticLambda3(paramInt, paramString, paramBoolean, paramCaptureVideoNormalModel), "BgMixManager_notifyFinish");
    AppMethodBeat.o(75163);
  }
  
  public static void b(int paramInt, b paramb)
  {
    AppMethodBeat.i(75159);
    s.u(paramb, "callback");
    Set localSet = (Set)KXN.get(paramInt);
    if (localSet != null) {
      localSet.remove(paramb);
    }
    if ((localSet != null) && (localSet.isEmpty() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        KXN.remove(paramInt);
      }
      AppMethodBeat.o(75159);
      return;
    }
  }
  
  private static final void b(int paramInt, String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(279480);
    s.u(paramString, "$taskId");
    Object localObject = (Set)KXN.get(paramInt);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).a(paramString, paramBoolean, paramCaptureVideoNormalModel);
      }
    }
    AppMethodBeat.o(279480);
  }
  
  public static void cA(int paramInt, String paramString)
  {
    AppMethodBeat.i(75162);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.mix_background.BgMixManager", s.X("notifyWait, taskId:", paramString));
    h.ahAA.g(new a..ExternalSyntheticLambda1(paramInt, paramString), "BgMixManager_notifyWait");
    AppMethodBeat.o(75162);
  }
  
  private static final void cB(int paramInt, String paramString)
  {
    AppMethodBeat.i(279470);
    s.u(paramString, "$taskId");
    Object localObject = (Set)KXN.get(paramInt);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).aGD(paramString);
      }
    }
    AppMethodBeat.o(279470);
  }
  
  private static final void cC(int paramInt, String paramString)
  {
    AppMethodBeat.i(279477);
    s.u(paramString, "$taskId");
    Object localObject = (Set)KXN.get(paramInt);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).aGE(paramString);
      }
    }
    AppMethodBeat.o(279477);
  }
  
  public static void cz(int paramInt, String paramString)
  {
    AppMethodBeat.i(75160);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.mix_background.BgMixManager", s.X("notifyInit, taskId:", paramString));
    h.ahAA.g(new a..ExternalSyntheticLambda0(paramInt, paramString), "BgMixManager_notifyInit");
    AppMethodBeat.o(75160);
  }
  
  public static FakeVideoViewLayer jo(Context paramContext)
  {
    AppMethodBeat.i(75164);
    if (paramContext != null)
    {
      paramContext = new FakeVideoViewLayer(paramContext);
      AppMethodBeat.o(75164);
      return paramContext;
    }
    paramContext = MMApplicationContext.getContext();
    s.s(paramContext, "getContext()");
    paramContext = new FakeVideoViewLayer(paramContext);
    AppMethodBeat.o(75164);
    return paramContext;
  }
  
  public static e jp(Context paramContext)
  {
    AppMethodBeat.i(75165);
    if (paramContext != null)
    {
      paramContext = new e(paramContext);
      AppMethodBeat.o(75165);
      return paramContext;
    }
    paramContext = MMApplicationContext.getContext();
    s.s(paramContext, "getContext()");
    paramContext = new e(paramContext);
    AppMethodBeat.o(75165);
    return paramContext;
  }
  
  public static void v(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(75161);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.mix_background.BgMixManager", "notifyRun, taskId:" + paramString + ", runNum:" + paramInt2);
    h.ahAA.g(new a..ExternalSyntheticLambda2(paramInt1, paramString, paramInt2), "BgMixManager_notifyRun");
    AppMethodBeat.o(75161);
  }
  
  private static final void w(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(279473);
    s.u(paramString, "$taskId");
    Object localObject = (Set)KXN.get(paramInt1);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).fv(paramString, paramInt2);
      }
    }
    AppMethodBeat.o(279473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a
 * JD-Core Version:    0.7.0.1
 */