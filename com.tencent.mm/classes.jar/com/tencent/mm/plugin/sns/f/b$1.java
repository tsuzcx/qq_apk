package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, int paramInt, com.tencent.mm.plugin.sns.data.b paramb1, View paramView1, View paramView2) {}
  
  public final void onClick(View paramView)
  {
    b localb = this.ovQ;
    int j = this.ovN;
    paramView = this.ovO;
    Object localObject = this.ovP;
    AbsoluteLayout localAbsoluteLayout = this.ovQ.ovz;
    y.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + j + " " + paramView.eAA);
    b.b localb1 = (b.b)localb.ovI.get(Long.valueOf(paramView.eAA));
    if (localb1 != null) {
      if (j != 4) {
        break label409;
      }
    }
    label409:
    for (int i = 3;; i = j)
    {
      localb1.Of("1:" + i + ":" + localb.mContext.getString(localb.ovD[(j - 1)]));
      if (j == 1)
      {
        localObject = af.bDF().OB(paramView.bJQ);
        if (localObject != null)
        {
          if (((n)localObject).yr(32))
          {
            paramView = ((n)localObject).bGb();
            if (paramView != null) {
              break label313;
            }
            paramView = "";
            ((c)g.r(c.class)).a(11855, ((n)localObject).bGO(), new Object[] { Integer.valueOf(3), paramView, Integer.valueOf(((n)localObject).bGO()) });
          }
          af.bDI().delete(((n)localObject).field_snsId);
          af.bDK().go(((n)localObject).field_snsId);
          i.gn(((n)localObject).field_snsId);
          paramView = new r(((n)localObject).field_snsId, 8);
          g.DQ();
          g.DO().dJT.a(paramView, 0);
          localb.a(localb1);
          localb.bEx();
        }
      }
      label313:
      do
      {
        return;
        paramView = paramView.fVM;
        break;
        if (j == 2)
        {
          localb.a((View)localObject, localAbsoluteLayout, paramView);
          return;
        }
        if (j == 3)
        {
          if (!u.fZ(paramView.eAA)) {
            u.fX(paramView.eAA);
          }
          localb.a(localb1);
          localb.bEx();
          return;
        }
      } while (j != 4);
      if (u.fZ(paramView.eAA)) {
        u.fY(paramView.eAA);
      }
      localb.a(localb1);
      localb.bEx();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.b.1
 * JD-Core Version:    0.7.0.1
 */