package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;

final class NormalUserHeaderPreference$4
  implements View.OnClickListener
{
  NormalUserHeaderPreference$4(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28074);
    paramView = new Intent();
    paramView.putExtra("sns_permission_userName", NormalUserHeaderPreference.a(this.wbA).field_username);
    paramView.putExtra("sns_permission_anim", true);
    paramView.putExtra("sns_permission_block_scene", 3);
    d.b(NormalUserHeaderPreference.b(this.wbA), "sns", ".ui.SnsPermissionUI", paramView);
    AppMethodBeat.o(28074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.4
 * JD-Core Version:    0.7.0.1
 */