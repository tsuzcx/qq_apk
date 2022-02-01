package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, qz paramqz, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28005);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.ImageViewWrapper", "request deal QBAR string");
    if (this.BIP.tiF.isShowing()) {
      this.BIP.tiF.bMo();
    }
    if (this.teK == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(28005);
      return;
    }
    paramView = new cr();
    paramView.dFK.activity = ((Activity)this.val$context);
    paramView.dFK.dDX = this.teK.dXz.result;
    paramView.dFK.dFL = this.teK.dXz.dFL;
    paramView.dFK.dFM = this.teK.dXz.dFM;
    EventCenter.instance.publish(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/ImageViewWrapper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.4
 * JD-Core Version:    0.7.0.1
 */