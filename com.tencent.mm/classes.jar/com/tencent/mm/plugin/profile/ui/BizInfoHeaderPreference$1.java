package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.ui.MMActivity;

final class BizInfoHeaderPreference$1
  implements View.OnClickListener
{
  BizInfoHeaderPreference$1(BizInfoHeaderPreference paramBizInfoHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23306);
    paramView = BizInfoHeaderPreference.a(this.pyg).field_username;
    Intent localIntent = new Intent(BizInfoHeaderPreference.b(this.pyg), ProfileHdHeadImg.class);
    localIntent.putExtra("username", paramView);
    localIntent.putExtra("brand_icon_url", BizInfoHeaderPreference.c(this.pyg));
    BizInfoHeaderPreference.b(this.pyg).startActivity(localIntent);
    AppMethodBeat.o(23306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */