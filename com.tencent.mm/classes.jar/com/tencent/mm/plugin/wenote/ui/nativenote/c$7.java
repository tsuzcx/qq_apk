package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.f.b.j;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class c$7
  implements View.OnClickListener
{
  c$7(c paramc, com.tencent.mm.plugin.wenote.model.nativenote.b.a parama, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    int j = 0;
    if (c.a(this.rMB) == 3)
    {
      this.rMA.f(true, 50L);
      this.rMA.U(1, 0L);
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ah(-1, false);
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)this.val$context, "android.permission.RECORD_AUDIO", 80, null, null);
    y.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (!bool) {}
    do
    {
      return;
      if (this.rMB.rMu) {
        break;
      }
      if (!com.tencent.mm.compatible.util.f.zF())
      {
        s.gM(this.val$context);
        return;
      }
    } while ((com.tencent.mm.r.a.bk(this.val$context)) || (com.tencent.mm.r.a.bi(this.val$context)));
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.rMB.rMu)
    {
      h.nFQ.f(14547, new Object[] { Integer.valueOf(3) });
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eP(0, 1))
      {
        this.rMA.chH();
        return;
      }
      this.rMB.rMo.setImageResource(R.k.fav_note_voiceplayer_record_icon);
      if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cjx().aQk()) {
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cjx().stopPlay();
      }
      this.rMB.rMu = true;
      paramView = new l();
      paramView.type = 4;
      paramView.rGJ = false;
      paramView.rGB = Boolean.valueOf(true);
      paramView.rGY = this.val$context.getString(R.l.favorite_wenote_voice_recording);
      this.rMB.rGg = "speex";
      paramView.bNM = 1;
      paramView.rGI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cid();
      paramView.rGz = this.rMB.rGg;
      paramView.kgC = com.tencent.mm.plugin.wenote.model.f.Ur(paramView.toString());
      localObject1 = new xv();
      ((xv)localObject1).XH(paramView.kgC);
      ((xv)localObject1).XE(paramView.rGz);
      localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.k.ciD();
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(paramView, ((com.tencent.mm.plugin.wenote.model.nativenote.manager.k)localObject2).ciG(), false, false, false);
        localObject2 = com.tencent.mm.plugin.wenote.model.k.chy();
        Object localObject3 = this.rMB.rMv;
        String str = com.tencent.mm.plugin.wenote.model.f.o((xv)localObject1);
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).rGk = paramView;
        int k = bk.getInt(paramView.rGI.substring(7), 0);
        localObject1 = paramView.rGz;
        i = j;
        if (!((com.tencent.mm.plugin.wenote.model.k)localObject2).ibC)
        {
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).ibC = true;
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).kdD = null;
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).rGi = k;
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).rGj = ((com.tencent.mm.plugin.wenote.model.b.a)localObject3);
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).rGg = ((String)localObject1);
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).path = str;
          if (((com.tencent.mm.plugin.wenote.model.k)localObject2).eLi != null) {
            ((com.tencent.mm.plugin.wenote.model.k)localObject2).eLi.requestFocus();
          }
          ((com.tencent.mm.plugin.wenote.model.k)localObject2).ibD = false;
          if (bk.bl(((com.tencent.mm.plugin.wenote.model.k)localObject2).path))
          {
            paramView = an.aQP();
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
          if (!bk.bl((String)localObject1)) {
            break label829;
          }
        }
      }
    }
    label654:
    label683:
    label815:
    label829:
    for (paramView = "amr";; paramView = (View)localObject1)
    {
      if (paramView.equals("speex"))
      {
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).rGf = new com.tencent.mm.modelvoice.k();
        new k.1((com.tencent.mm.plugin.wenote.model.k)localObject2);
        label619:
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).ibp = -1L;
        if (!((String)localObject1).equals("speex")) {
          break label771;
        }
        paramView = Boolean.valueOf(((com.tencent.mm.plugin.wenote.model.k)localObject2).rGf.cD(((com.tencent.mm.plugin.wenote.model.k)localObject2).path));
        if (!paramView.booleanValue()) {
          break label791;
        }
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).jlU = bk.UZ();
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).ibI.S(200L, 200L);
        if (((com.tencent.mm.plugin.wenote.model.k)localObject2).jlU != 0L) {
          break label800;
        }
      }
      for (i = -1;; i = j)
      {
        if (i >= 0) {
          break label815;
        }
        this.rMA.chI();
        this.rMB.a(this.rMA);
        return;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(paramView, null, false, false, false);
        break;
        paramView = b.a.dub;
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).kcn = new j();
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).kcn.bEk = new k.2((com.tencent.mm.plugin.wenote.model.k)localObject2);
        break label619;
        paramView = Boolean.valueOf(((com.tencent.mm.plugin.wenote.model.k)localObject2).kcn.cF(((com.tencent.mm.plugin.wenote.model.k)localObject2).path));
        break label654;
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).jlU = 0L;
        break label683;
        ((com.tencent.mm.plugin.wenote.model.k)localObject2).rGl.sendEmptyMessage(4096);
      }
      break;
      this.rMB.a(this.rMA);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.7
 * JD-Core Version:    0.7.0.1
 */