package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

final class s$1
  implements View.OnClickListener
{
  s$1(s params, l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37235);
    this.rxk.crh();
    f localf = g.ca(this.rxj.rsf, true);
    if ((localf == null) || (TextUtils.isEmpty(localf.field_packageName)) || (!this.rxk.v(paramView.getContext(), localf.field_packageName, g.b(paramView.getContext(), localf, null)))) {
      this.rxk.crj();
    }
    AppMethodBeat.o(37235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.1
 * JD-Core Version:    0.7.0.1
 */