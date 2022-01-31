package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class c$7
  implements View.OnClickListener
{
  c$7(c paramc, com.tencent.mm.plugin.wenote.model.nativenote.b.a parama, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(27121);
    if (c.a(this.vDf) == 3)
    {
      this.vDe.h(true, 50L);
      this.vDe.aj(1, 0L);
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().aw(-1, false);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.val$context, "android.permission.RECORD_AUDIO", 80, null, null);
    ab.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (!bool)
    {
      AppMethodBeat.o(27121);
      return;
    }
    if (!this.vDf.vCY)
    {
      if (!com.tencent.mm.compatible.util.f.Mi())
      {
        t.ii(this.val$context);
        AppMethodBeat.o(27121);
        return;
      }
      if ((com.tencent.mm.r.a.bO(this.val$context)) || (com.tencent.mm.r.a.bM(this.val$context)))
      {
        AppMethodBeat.o(27121);
        return;
      }
    }
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.vDf.vCY)
    {
      h.qsU.e(14547, new Object[] { Integer.valueOf(3) });
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gV(0, 1))
      {
        this.vDe.dhX();
        AppMethodBeat.o(27121);
        return;
      }
      this.vDf.vCS.setImageResource(2131231308);
      if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.djZ().bwz()) {
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.djZ().stopPlay();
      }
      this.vDf.vCY = true;
      paramView = new l();
      paramView.type = 4;
      paramView.vxs = false;
      paramView.vxk = Boolean.TRUE;
      paramView.vxG = this.val$context.getString(2131299862);
      this.vDf.vwP = "speex";
      paramView.cve = 1;
      paramView.vxr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dit();
      paramView.vxi = this.vDf.vwP;
      paramView.mBq = com.tencent.mm.plugin.wenote.model.f.ajF(paramView.toString());
      localObject1 = new aca();
      ((aca)localObject1).anD(paramView.mBq);
      ((aca)localObject1).anA(paramView.vxi);
      localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.k.diU();
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(paramView, ((com.tencent.mm.plugin.wenote.model.nativenote.manager.k)localObject2).diX(), false, false, false);
        localObject2 = com.tencent.mm.plugin.wenote.model.k.dhL();
        Object localObject3 = this.vDf.vCZ;
        String str = com.tencent.mm.plugin.wenote.model.f.o((aca)localObject1);
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).vwT = paramView;
        int k = bo.getInt(paramView.vxr.substring(7), 0);
        localObject1 = paramView.vxi;
        i = j;
        if (!((com.tencent.mm.plugin.wenote.model.k)localObject2).mwK)
        {
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).mwK = true;
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).myn = null;
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).vwR = k;
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).vwS = ((com.tencent.mm.plugin.wenote.model.b.a)localObject3);
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).vwP = ((String)localObject1);
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).path = str;
          if (((com.tencent.mm.plugin.wenote.model.k)localObject2).gaP != null) {
            ((com.tencent.mm.plugin.wenote.model.k)localObject2).gaP.requestFocus();
          }
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).mwL = false;
          if (bo.isNullOrNil(((com.tencent.mm.plugin.wenote.model.k)localObject2).path))
          {
            paramView = an.bxe();
            localObject3 = new com.tencent.mm.vfs.b(paramView);
            if (!((com.tencent.mm.vfs.b)localObject3).exists()) {
              ((com.tencent.mm.vfs.b)localObject3).mkdirs();
            }
            do
            {
              localObject3 = paramView + "/" + System.currentTimeMillis();
            } while (new com.tencent.mm.vfs.b((String)localObject3).exists());
            ((com.tencent.mm.plugin.wenote.model.k)localObject2).path = ((String)localObject3);
          }
          if (!bo.isNullOrNil((String)localObject1)) {
            break label873;
          }
        }
      }
    }
    label647:
    label686:
    label715:
    label873:
    for (paramView = "amr";; paramView = (View)localObject1)
    {
      if (paramView.equals("speex"))
      {
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).vwO = new m();
        new k.1((com.tencent.mm.plugin.wenote.model.k)localObject2);
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).mwM = -1L;
        paramView = Boolean.FALSE;
        if (!((String)localObject1).equals("speex")) {
          break label809;
        }
        paramView = Boolean.valueOf(((com.tencent.mm.plugin.wenote.model.k)localObject2).vwO.eH(((com.tencent.mm.plugin.wenote.model.k)localObject2).path));
        if (!paramView.booleanValue()) {
          break label829;
        }
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).lvI = bo.yB();
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).mwY.ag(200L, 200L);
        if (((com.tencent.mm.plugin.wenote.model.k)localObject2).lvI != 0L) {
          break label838;
        }
      }
      for (i = -1;; i = j)
      {
        if (i < 0)
        {
          this.vDe.dhY();
          this.vDf.a(this.vDe);
        }
        AppMethodBeat.o(27121);
        return;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(paramView, null, false, false, false);
        break;
        paramView = c.a.elP;
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).mwV = new j();
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).mwV.ckW = new k.2((com.tencent.mm.plugin.wenote.model.k)localObject2);
        break label647;
        paramView = Boolean.valueOf(((com.tencent.mm.plugin.wenote.model.k)localObject2).mwV.eJ(((com.tencent.mm.plugin.wenote.model.k)localObject2).path));
        break label686;
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).lvI = 0L;
        break label715;
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).vwU.sendEmptyMessage(4096);
      }
      this.vDf.a(this.vDe);
      AppMethodBeat.o(27121);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.7
 * JD-Core Version:    0.7.0.1
 */