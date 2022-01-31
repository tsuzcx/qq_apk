package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;

final class g$2
  implements View.OnClickListener
{
  g$2(g paramg, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    this.val$intent.addFlags(268435456);
    ae.getContext().startActivity(this.val$intent);
    paramView.setOnClickListener(null);
    g.a(this.pZD, new am(new g.2.1(this), false));
    g.a(this.pZD).S(2000L, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.g.2
 * JD-Core Version:    0.7.0.1
 */