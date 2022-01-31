package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;

final class NormalUserFooterPreference$a$13
  implements View.OnClickListener
{
  NormalUserFooterPreference$a$13(NormalUserFooterPreference.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23690);
    paramView = new Intent();
    paramView.putExtra("sns_permission_userName", NormalUserFooterPreference.a(this.pCf.pCe).field_username);
    paramView.putExtra("sns_permission_anim", true);
    paramView.putExtra("sns_permission_block_scene", 4);
    d.b(NormalUserFooterPreference.b(this.pCf.pCe), "sns", ".ui.SnsPermissionUI", paramView);
    AppMethodBeat.o(23690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.13
 * JD-Core Version:    0.7.0.1
 */