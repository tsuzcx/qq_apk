package com.tencent.mm.plugin.sns.g;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, int paramInt, com.tencent.mm.plugin.sns.data.b paramb1, View paramView1, View paramView2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36757);
    b localb = this.rkL;
    int j = this.rkI;
    paramView = this.rkJ;
    Object localObject = this.rkK;
    AbsoluteLayout localAbsoluteLayout = this.rkL.rku;
    ab.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + j + " " + paramView.cIo);
    b.b localb1 = (b.b)localb.rkD.get(Long.valueOf(paramView.cIo));
    if (localb1 != null) {
      if (j != 4) {
        break label434;
      }
    }
    label434:
    for (int i = 3;; i = j)
    {
      localb1.aaZ("1:" + i + ":" + localb.mContext.getString(localb.rky[(j - 1)]));
      if (j == 1)
      {
        localObject = ag.cpf().abv(paramView.crk);
        if (localObject != null)
        {
          if (((n)localObject).Ex(32))
          {
            paramView = ((n)localObject).csd();
            if (paramView != null) {
              break label323;
            }
          }
          label323:
          for (paramView = "";; paramView = paramView.hpq)
          {
            ((c)g.E(c.class)).a(11855, ((n)localObject).csR(), new Object[] { Integer.valueOf(3), paramView, Integer.valueOf(((n)localObject).csR()) });
            ag.cpi().delete(((n)localObject).field_snsId);
            ag.cpk().lU(((n)localObject).field_snsId);
            i.lT(((n)localObject).field_snsId);
            paramView = new r(((n)localObject).field_snsId, 8);
            g.RM();
            g.RK().eHt.a(paramView, 0);
            localb.a(localb1);
            localb.cpX();
            AppMethodBeat.o(36757);
            return;
          }
        }
      }
      else
      {
        if (j == 2)
        {
          localb.a((View)localObject, localAbsoluteLayout, paramView);
          AppMethodBeat.o(36757);
          return;
        }
        if (j == 3)
        {
          if (!u.lE(paramView.cIo)) {
            u.lC(paramView.cIo);
          }
          localb.a(localb1);
          localb.cpX();
          AppMethodBeat.o(36757);
          return;
        }
        if (j == 4)
        {
          if (u.lE(paramView.cIo)) {
            u.lD(paramView.cIo);
          }
          localb.a(localb1);
          localb.cpX();
        }
      }
      AppMethodBeat.o(36757);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.b.1
 * JD-Core Version:    0.7.0.1
 */