package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProfileMobilePhoneView$1
  implements View.OnClickListener
{
  ProfileMobilePhoneView$1(ProfileMobilePhoneView paramProfileMobilePhoneView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27532);
    ProfileMobilePhoneView.a(this.vRE, ((TextView)paramView).getText().toString());
    ProfileMobilePhoneView.a(this.vRE).onClick(paramView);
    AppMethodBeat.o(27532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.1
 * JD-Core Version:    0.7.0.1
 */