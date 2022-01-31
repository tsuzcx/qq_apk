package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;

final class NormalUserHeaderPreference$1
  implements View.OnClickListener
{
  NormalUserHeaderPreference$1(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28071);
    Object localObject = NormalUserHeaderPreference.a(this.wbA).field_username;
    paramView = (View)localObject;
    if (ad.nM((String)localObject)) {
      paramView = ad.ark((String)localObject);
    }
    localObject = new Intent(NormalUserHeaderPreference.b(this.wbA), ProfileHdHeadImg.class);
    ((Intent)localObject).putExtra("username", paramView);
    NormalUserHeaderPreference.b(this.wbA).startActivity((Intent)localObject);
    AppMethodBeat.o(28071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */