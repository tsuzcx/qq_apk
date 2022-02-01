package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalProfileHeaderPreference$6
  implements View.OnClickListener
{
  NormalProfileHeaderPreference$6(NormalProfileHeaderPreference paramNormalProfileHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305464);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("finder_username", NormalProfileHeaderPreference.f(this.MYq).username);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(this.MYq.mContext, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.6
 * JD-Core Version:    0.7.0.1
 */