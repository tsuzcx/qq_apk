package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.ui.MMActivity;

final class NewBizInfoHeaderPreference$1
  implements View.OnClickListener
{
  NewBizInfoHeaderPreference$1(NewBizInfoHeaderPreference paramNewBizInfoHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23854);
    paramView = NewBizInfoHeaderPreference.a(this.pDE).field_username;
    Intent localIntent = new Intent(NewBizInfoHeaderPreference.b(this.pDE), ProfileHdHeadImg.class);
    localIntent.putExtra("username", paramView);
    localIntent.putExtra("brand_icon_url", NewBizInfoHeaderPreference.c(this.pDE));
    NewBizInfoHeaderPreference.b(this.pDE).startActivity(localIntent);
    AppMethodBeat.o(23854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */