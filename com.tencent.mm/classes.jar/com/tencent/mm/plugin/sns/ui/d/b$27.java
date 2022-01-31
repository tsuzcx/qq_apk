package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class b$27
  implements AdapterView.OnItemClickListener
{
  b$27(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.i("MicroMsg.TimelineClickListener", "unlike click");
    if (!(paramAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c)) {
      y.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
    }
    Object localObject2;
    n localn;
    Object localObject1;
    label274:
    label279:
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
          localn = af.bDF().OB(((com.tencent.mm.plugin.sns.data.b)localObject2).bJQ);
        } while (localn == null);
        if (paramInt != 0) {
          break;
        }
        if (localn.yr(32))
        {
          localObject1 = b.a(this.ppl, localn);
          if (localObject1 == null)
          {
            localObject1 = "";
            ((com.tencent.mm.plugin.sns.b.c)g.r(com.tencent.mm.plugin.sns.b.c.class)).a(11855, localn.bGO(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localn.bGO()) });
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).omM.pjN.oAp.bED().size() <= 0) {
            break label274;
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label279;
          }
          paramView = (com.tencent.mm.plugin.sns.ui.c)paramAdapterView.getAdapter();
          paramView.ghE += 1;
          paramView.notifyDataSetChanged();
          paramAdapterView.setOnItemClickListener(this.ppl.ppc);
          this.ppl.bHp();
          paramAdapterView = new a.b.a();
          paramAdapterView.oAC = a.b.a.oAy;
          paramAdapterView.omN = ((com.tencent.mm.plugin.sns.data.b)localObject2).omN;
          paramAdapterView.oAD = 0L;
          paramAdapterView = new r(localn.field_snsId, 8, paramAdapterView);
          g.DQ();
          g.DO().dJT.a(paramAdapterView, 0);
          return;
          localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).fVM;
          break;
        }
      } while (((com.tencent.mm.plugin.sns.data.b)localObject2).omM.pjN.oAt);
      this.ppl.cY(paramView);
      paramAdapterView = new a.b.a();
      paramAdapterView.omN = ((com.tencent.mm.plugin.sns.data.b)localObject2).omN;
      paramAdapterView.oAD = System.currentTimeMillis();
      paramAdapterView = new r(localn.field_snsId, 8, paramAdapterView);
      g.DQ();
      g.DO().dJT.a(paramAdapterView, 0);
      return;
      if (((com.tencent.mm.plugin.sns.data.b)localObject2).omM.pjM.oBz == null)
      {
        y.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
        return;
      }
      paramAdapterView = ((com.tencent.mm.plugin.sns.data.b)localObject2).omM.pjM.oBz;
      paramInt -= 1;
    } while (paramInt >= paramAdapterView.list.size());
    paramAdapterView = ((b.b)paramAdapterView.list.get(paramInt)).url;
    try
    {
      paramView = String.format("snsid=%s", new Object[] { localn.bGe().lsK });
      localObject1 = String.format("aid=%s", new Object[] { localn.bGJ() });
      localObject2 = String.format("traceid=%s", new Object[] { localn.bGK() });
      g.DN();
      paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.k(paramAdapterView, new String[] { paramView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.CL() }) });
      paramAdapterView = paramView;
    }
    catch (Exception paramView)
    {
      label535:
      break label535;
    }
    paramView = new Intent();
    paramView.putExtra("rawUrl", paramAdapterView);
    paramView.putExtra("useJs", true);
    paramView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId));
    paramView.putExtra("pre_username", localn.field_userName);
    paramView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId));
    paramView.putExtra("preUsername", localn.field_userName);
    com.tencent.mm.plugin.sns.c.a.eUR.j(paramView, this.ppl.activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.27
 * JD-Core Version:    0.7.0.1
 */