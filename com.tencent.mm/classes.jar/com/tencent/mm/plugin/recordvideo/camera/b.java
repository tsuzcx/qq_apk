package com.tencent.mm.plugin.recordvideo.camera;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.media.widget.a.c;
import com.tencent.mm.media.widget.a.e;
import com.tencent.mm.media.widget.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/CameraInstanceFactory;", "", "()V", "CAMERA_TYPE_1", "", "CAMERA_TYPE_2", "CAMERA_TYPE_DEFAULT", "CAMERA_TYPE_X", "TAG", "", "getCameraInstance", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "scene", "useCpuCrop", "", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getCameraInstanceSelect", "select", "getCameraOneInstance", "getCameraTwoInstance", "plugin-recordvideo_release"})
public final class b
{
  public static final b HJh;
  
  static
  {
    AppMethodBeat.i(217064);
    HJh = new b();
    AppMethodBeat.o(217064);
  }
  
  public static boolean aZo()
  {
    AppMethodBeat.i(217061);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.Vnh, Integer.valueOf(-1));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(217061);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i == 1)
    {
      Log.i("MicroMsg.CameraInstanceFactory", "useCupCrop false by user.");
      AppMethodBeat.o(217061);
      return false;
    }
    if (i == 2)
    {
      Log.i("MicroMsg.CameraInstanceFactory", "useCupCrop true by user.");
      AppMethodBeat.o(217061);
      return true;
    }
    if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
    {
      Log.i("MicroMsg.CameraInstanceFactory", "useCupCrop true by mediacodec error.");
      AppMethodBeat.o(217061);
      return true;
    }
    if (com.tencent.mm.plugin.recordvideo.b.h.isInit())
    {
      localObject = com.tencent.mm.plugin.recordvideo.b.h.HKf;
      boolean bool = com.tencent.mm.plugin.recordvideo.b.h.fvL();
      Log.i("MicroMsg.CameraInstanceFactory", "useCupCrop " + bool + " by SightRecordConfig");
      AppMethodBeat.o(217061);
      return bool;
    }
    Log.i("MicroMsg.CameraInstanceFactory", "useCupCrop true by default.");
    AppMethodBeat.o(217061);
    return false;
  }
  
  public static e hP(Context paramContext)
  {
    AppMethodBeat.i(217057);
    p.k(paramContext, "context");
    paramContext = (e)new c(paramContext);
    AppMethodBeat.o(217057);
    return paramContext;
  }
  
  public static e hQ(Context paramContext)
  {
    AppMethodBeat.i(217059);
    p.k(paramContext, "context");
    paramContext = (e)new d(paramContext);
    AppMethodBeat.o(217059);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.camera.b
 * JD-Core Version:    0.7.0.1
 */