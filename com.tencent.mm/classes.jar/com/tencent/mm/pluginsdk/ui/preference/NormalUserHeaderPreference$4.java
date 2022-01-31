package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;

final class NormalUserHeaderPreference$4
  implements View.OnClickListener
{
  NormalUserHeaderPreference$4(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("sns_permission_userName", NormalUserHeaderPreference.b(this.siZ).field_username);
    paramView.putExtra("sns_permission_anim", true);
    paramView.putExtra("sns_permission_block_scene", 3);
    d.b(NormalUserHeaderPreference.a(this.siZ), "sns", ".ui.SnsPermissionUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.4
 * JD-Core Version:    0.7.0.1
 */