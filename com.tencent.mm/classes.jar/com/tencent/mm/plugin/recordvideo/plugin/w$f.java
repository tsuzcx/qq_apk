package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-recordvideo_release"})
public final class w$f
  implements MMSightRecordButton.b
{
  w$f(RecordConfigProvider paramRecordConfigProvider) {}
  
  public final void bYA()
  {
    AppMethodBeat.i(204113);
    Object localObject = new int[2];
    w.d(this.vle).getLocationOnScreen((int[])localObject);
    Bundle localBundle = new Bundle();
    localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT", localObject[1]);
    this.vle.vjo.a(d.c.vnu, localBundle);
    w.e(this.vle).animate().alpha(0.0F).withEndAction((Runnable)new b(this)).start();
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Kp(2);
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.Ko(2);
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diz().Rh();
    AppMethodBeat.o(204113);
  }
  
  public final void bYz()
  {
    AppMethodBeat.i(204115);
    ad.i("MicroMsg.RecordButtonPlugin", "onLongPressFinish");
    w.a(this.vle);
    AppMethodBeat.o(204115);
  }
  
  public final void jd()
  {
    AppMethodBeat.i(204114);
    d.b.a(this.vle.vjo, d.c.vny);
    Object localObject = this.Lnp.vhI;
    if (localObject != null)
    {
      i = ((UICustomParam)localObject).fGY;
      if (i != 0) {
        break label106;
      }
      localObject = this.vle.sRU.getContext();
      k.g(localObject, "layout.context");
    }
    label106:
    for (int i = ((Context)localObject).getResources().getColor(2131101171);; i = this.Lnp.vhI.fGY)
    {
      w.d(this.vle).a(this.vle.vla, i, (MMSightCircularProgressBar.a)new a(this));
      AppMethodBeat.o(204114);
      return;
      i = 0;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin$setEnableType$2$onLongPress$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCircularProgressBar$ProgressCallback;", "onProgress", "", "subProgress", "Ljava/util/ArrayList;", "", "onProgressFinish", "finish", "", "plugin-recordvideo_release"})
  public static final class a
    implements MMSightCircularProgressBar.a
  {
    public final void aV(ArrayList<Float> paramArrayList)
    {
      AppMethodBeat.i(204110);
      k.h(paramArrayList, "subProgress");
      d.g.a.b localb = this.Lnq.vle.Lnn;
      if (localb != null)
      {
        localb.aA(paramArrayList);
        AppMethodBeat.o(204110);
        return;
      }
      AppMethodBeat.o(204110);
    }
    
    public final void yw(boolean paramBoolean)
    {
      AppMethodBeat.i(204111);
      ad.i("MicroMsg.RecordButtonPlugin", "onProgressFinish");
      w.a(this.Lnq.vle, paramBoolean);
      AppMethodBeat.o(204111);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(w.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(204112);
      w.e(this.Lnq.vle).setVisibility(4);
      AppMethodBeat.o(204112);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w.f
 * JD-Core Version:    0.7.0.1
 */