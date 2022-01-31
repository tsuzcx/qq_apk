package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.b.d;

final class FlipView$5
  implements View.OnClickListener
{
  FlipView$5(FlipView paramFlipView, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(145450);
    ab.i("MicroMsg.FlipView", "request deal QBAR string");
    if ((FlipView.a(this.rGJ) != null) && (FlipView.a(this.rGJ).isShowing())) {
      FlipView.a(this.rGJ).cre();
    }
    Object localObject = ag.cpf().abv(this.nlv);
    if (localObject == null)
    {
      ab.i("MicroMsg.FlipView", "error beacause info null");
      AppMethodBeat.o(145450);
      return;
    }
    ab.i("MicroMsg.FlipView", "request deal QBAR string");
    paramView = new cg();
    paramView.cpD.activity = ((Activity)FlipView.f(this.rGJ));
    paramView.cpD.cnR = FlipView.g(this.rGJ);
    paramView.cpD.cpE = FlipView.h(this.rGJ);
    paramView.cpD.cpF = FlipView.i(this.rGJ);
    localObject = ak.a((n)localObject, this.Cq);
    if (localObject != null)
    {
      paramView.cpD.imagePath = ((bcs)localObject).Url;
      paramView.cpD.cpI = ((bcs)localObject).xsj;
    }
    paramView.cpD.scene = 38;
    if ((FlipView.f(this.rGJ) instanceof Activity)) {
      paramView.cpD.cpJ = ((Activity)FlipView.f(this.rGJ)).getIntent().getBundleExtra("_stat_obj");
    }
    az localaz;
    if ((this.rGJ instanceof SnsInfoFlip))
    {
      localObject = (SnsInfoFlip)this.rGJ;
      localaz = ((SnsInfoFlip)localObject).getFromScene();
      ab.d("MicroMsg.FlipView", "from Scene: %s", new Object[] { localaz.tag });
      if ((!localaz.tag.equals(az.yNN.tag)) && (!localaz.tag.equals(az.yNO.tag)) && (!localaz.tag.equals(az.yNP.tag))) {
        break label374;
      }
      paramView.cpD.cpG = 5;
      if (bo.isNullOrNil(((SnsInfoFlip)localObject).username))
      {
        ab.i("MicroMsg.FlipView", "empty username");
        ((SnsInfoFlip)localObject).username = "";
      }
      paramView.cpD.source = ((SnsInfoFlip)localObject).username;
    }
    for (;;)
    {
      a.ymk.l(paramView);
      AppMethodBeat.o(145450);
      return;
      label374:
      if (localaz.tag.equals(az.yNM.tag)) {
        paramView.cpD.cpG = 3;
      } else {
        ab.i("MicroMsg.FlipView", "other scene_from: %s", new Object[] { localaz.tag });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView.5
 * JD-Core Version:    0.7.0.1
 */