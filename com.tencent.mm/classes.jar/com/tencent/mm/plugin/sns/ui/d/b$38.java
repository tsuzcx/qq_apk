package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.MaskImageButton;

final class b$38
  implements View.OnClickListener
{
  b$38(b paramb) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    int m = 1;
    int k = 1;
    AppMethodBeat.i(40300);
    Object localObject2 = (String)paramView.getTag();
    ab.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
    Object localObject3 = new Intent();
    Object localObject1;
    int j;
    int i;
    long l;
    if (((paramView instanceof MaskImageButton)) && (((MaskImageButton)paramView).eQq != null))
    {
      paramView = (String)((MaskImageButton)paramView).eQq;
      localObject1 = ag.cpf().abv(paramView);
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject1).Ex(32)))
      {
        com.tencent.mm.plugin.sns.storage.b localb = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csb();
        j = this.skd.cpt;
        if (this.skd.cpt == 0)
        {
          i = 1;
          paramView = new SnsAdClick(j, i, ((com.tencent.mm.plugin.sns.storage.n)localObject1).field_snsId, 1, 0);
          if (this.skd.rOU != null) {
            break label373;
          }
        }
        label373:
        for (l = 0L;; l = this.skd.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject1).csH(), 1))
        {
          paramView.fQA = l;
          i.a(paramView);
          if ((localb == null) || (localb.rqa != 1) || (bo.isNullOrNil(localb.rqb))) {
            break label394;
          }
          localObject2 = localb.rqb;
          localObject3 = b.a(this.skd, (com.tencent.mm.plugin.sns.storage.n)localObject1);
          paramView = (View)localObject2;
          if (localObject3 != null) {
            paramView = i.gg((String)localObject2, ((com.tencent.mm.plugin.sns.storage.a)localObject3).cFe);
          }
          ab.i("MicroMsg.TimelineClickListener", "headClickParam url " + paramView + " " + localb.rqc);
          localObject2 = new Intent();
          if (localb.rqc == 0) {
            bool = true;
          }
          ((Intent)localObject2).putExtra("KsnsViewId", b.a(this.skd, (com.tencent.mm.plugin.sns.storage.n)localObject1).hpq);
          ((Intent)localObject2).putExtra("KRightBtn", bool);
          ((Intent)localObject2).putExtra("jsapiargs", new Bundle());
          ((Intent)localObject2).putExtra("rawUrl", paramView);
          ((Intent)localObject2).putExtra("useJs", true);
          com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject2, this.skd.activity);
          AppMethodBeat.o(40300);
          return;
          i = 2;
          break;
        }
        label394:
        i = 1;
        paramView = (View)localObject1;
      }
    }
    for (;;)
    {
      if (((String)localObject2).endsWith("@ad"))
      {
        AppMethodBeat.o(40300);
        return;
      }
      if (paramView != null)
      {
        if (this.skd.cpt != 0) {
          break label629;
        }
        if (paramView.Ex(32))
        {
          j = 722;
          localObject1 = com.tencent.mm.modelsns.b.lV(j);
          ((com.tencent.mm.modelsns.b)localObject1).uv(i.j(paramView)).lY(paramView.field_type).de(paramView.Ex(32)).uv(paramView.csP()).uv((String)localObject2);
          ((com.tencent.mm.modelsns.b)localObject1).ake();
        }
      }
      else
      {
        if (i == 0) {
          break label683;
        }
        j = this.skd.cpt;
        if (this.skd.cpt != 0) {
          break label658;
        }
        i = 1;
        label516:
        localObject1 = new SnsAdClick(j, i, paramView.field_snsId, 1, 0);
        if (this.skd.rOU != null) {
          break label663;
        }
      }
      label658:
      label663:
      for (l = 0L;; l = this.skd.rOU.di(paramView.csH(), 1))
      {
        ((SnsAdClick)localObject1).fQA = l;
        ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
        ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
        i = k;
        if (this.skd.cpt == 0) {
          i = 6;
        }
        ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
        com.tencent.mm.plugin.sns.c.a.gmO.c((Intent)localObject3, this.skd.activity);
        AppMethodBeat.o(40300);
        return;
        j = 721;
        break;
        label629:
        if (paramView.Ex(32)) {}
        for (j = 722;; j = 721)
        {
          localObject1 = com.tencent.mm.modelsns.b.lW(j);
          break;
        }
        i = 2;
        break label516;
      }
      label683:
      this.skd.rFN.coJ().a(paramView, true);
      if (this.skd.cpt == 0) {}
      for (paramView = com.tencent.mm.modelsns.b.lV(746);; paramView = com.tencent.mm.modelsns.b.lW(746))
      {
        localObject1 = r.Zn();
        paramView.uv((String)localObject2).de(((String)localObject2).endsWith((String)localObject1));
        paramView.b((Intent)localObject3, "intent_key_StatisticsOplog");
        i = m;
        if (this.skd.cpt == 0) {
          i = 6;
        }
        ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
        ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
        com.tencent.mm.plugin.sns.c.a.gmO.c((Intent)localObject3, this.skd.activity);
        AppMethodBeat.o(40300);
        return;
      }
      i = 0;
      paramView = (View)localObject1;
      continue;
      paramView = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.38
 * JD-Core Version:    0.7.0.1
 */