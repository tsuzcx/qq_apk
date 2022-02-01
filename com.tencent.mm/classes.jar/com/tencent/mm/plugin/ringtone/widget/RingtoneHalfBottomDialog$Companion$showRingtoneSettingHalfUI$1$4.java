package com.tencent.mm.plugin.ringtone.widget;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.ringtone.b.b;
import com.tencent.mm.plugin.ringtone.g.d;
import com.tencent.mm.plugin.ringtone.uic.g;
import kotlin.Metadata;
import kotlin.g.b.ah.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/widget/RingtoneHalfBottomDialog$Companion$showRingtoneSettingHalfUI$1$4", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "onPause", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RingtoneHalfBottomDialog$Companion$showRingtoneSettingHalfUI$1$4
  implements p
{
  RingtoneHalfBottomDialog$Companion$showRingtoneSettingHalfUI$1$4(View paramView1, Context paramContext, MMAnimateView paramMMAnimateView, View paramView2, g paramg, d paramd, ah.a parama) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(273128);
    this.OGl.setBackground(this.$context.getDrawable(b.b.ringtone_info_item_shape_stoke));
    this.OGm.setVisibility(8);
    View localView = this.OGn;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.OGo.a(this.OGp, false);
    this.OGq.aiwY = false;
    AppMethodBeat.o(273128);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(273136);
    this.OGl.setBackground(this.$context.getDrawable(b.b.ringtone_info_item_shape_stoke));
    this.OGm.setVisibility(8);
    View localView = this.OGn;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.OGo.a(this.OGp, false);
    this.OGq.aiwY = false;
    AppMethodBeat.o(273136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.widget.RingtoneHalfBottomDialog.Companion.showRingtoneSettingHalfUI.1.4
 * JD-Core Version:    0.7.0.1
 */