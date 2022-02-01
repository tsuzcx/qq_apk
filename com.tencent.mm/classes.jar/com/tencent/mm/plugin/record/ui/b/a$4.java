package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, rz paramrz, Context paramContext, String paramString, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28005);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.ImageViewWrapper", "request deal QBAR string");
    if (this.HEX.wOW.isShowing()) {
      this.HEX.wOW.bYF();
    }
    if (this.wKX == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(28005);
      return;
    }
    paramView = new cv();
    paramView.fyr.activity = ((Activity)this.val$context);
    paramView.fyr.fwI = this.HEG;
    paramView.fyr.fys = this.oNc;
    paramView.fyr.fyt = this.oNd;
    EventCenter.instance.publish(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.4
 * JD-Core Version:    0.7.0.1
 */