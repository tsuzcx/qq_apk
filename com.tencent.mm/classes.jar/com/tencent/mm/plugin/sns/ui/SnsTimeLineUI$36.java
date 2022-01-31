package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.j.c.b;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.vending.app.a;

final class SnsTimeLineUI$36
  implements View.OnClickListener
{
  SnsTimeLineUI$36(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    if ((SnsTimeLineUI.g(this.pfC) != null) && (SnsTimeLineUI.g(this.pfC).oNC != null)) {
      SnsTimeLineUI.g(this.pfC).oNC.ota.iZ(true);
    }
    paramView = (c.b)this.pfC.EB().ad(c.b.class);
    com.tencent.mm.modelsns.b localb = com.tencent.mm.modelsns.b.jd(725);
    localb.jg(paramView.prA);
    localb.QX();
    paramView = new Intent();
    paramView.setClass(this.pfC, SnsMsgUI.class);
    this.pfC.startActivityForResult(paramView, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.36
 * JD-Core Version:    0.7.0.1
 */