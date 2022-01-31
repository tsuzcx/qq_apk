package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, b
{
  View fvD;
  String rGg = "";
  ImageButton rMj;
  LinearLayout rMk;
  ImageButton rMl;
  ImageButton rMm;
  ImageButton rMn;
  ImageButton rMo;
  LinearLayout rMp;
  LinearLayout rMq;
  LinearLayout rMr;
  LinearLayout rMs;
  LinearLayout rMt;
  public boolean rMu = false;
  c rMv = this;
  boolean rMw = false;
  boolean rMx = false;
  boolean rMy = false;
  boolean rMz = false;
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    this.rMo.setImageResource(R.g.wenote_voice_button);
    if (!this.rMu) {}
    int k;
    do
    {
      Object localObject;
      int i;
      int j;
      com.tencent.mm.plugin.wenote.model.a.c localc;
      do
      {
        return;
        this.rMu = false;
        localObject = com.tencent.mm.plugin.wenote.model.k.chy();
        if ((((com.tencent.mm.plugin.wenote.model.k)localObject).ibC) && (!((com.tencent.mm.plugin.wenote.model.k)localObject).ibD)) {
          ((com.tencent.mm.plugin.wenote.model.k)localObject).aRi();
        }
        localObject = com.tencent.mm.plugin.wenote.model.k.chy();
        if (e.bK(((com.tencent.mm.plugin.wenote.model.k)localObject).path)) {}
        for (localObject = ((com.tencent.mm.plugin.wenote.model.k)localObject).path;; localObject = "")
        {
          i = (int)com.tencent.mm.plugin.wenote.model.k.chy().duration;
          j = (int)com.tencent.mm.bj.a.ck(i);
          k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cic();
          localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(k);
          if (e.bK((String)localObject)) {
            break;
          }
          y.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ag(k, false);
          if (parama != null) {
            parama.Dl(k);
          }
          parama = new i();
          parama.content = "";
          parama.rGn = true;
          parama.rGt = false;
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(k, parama);
          com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().eQ(k - 1, k + 1);
          return;
        }
      } while ((k == -1) || (localc == null) || (localc.getType() != 4));
      ((l)localc).rGB = Boolean.valueOf(false);
      ((l)localc).type = 4;
      ((l)localc).rGJ = true;
      ((l)localc).rGY = "";
      ((l)localc).length = j;
      ((l)localc).rGX = com.tencent.mm.bj.a.x(ae.getContext(), j).toString();
      ((l)localc).gum = (an.aQK() + "/fav_fileicon_recording.png");
      ((l)localc).bTY = ((String)localObject);
      ((l)localc).bNN = i;
      parama = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX();
    } while (parama.rHw == null);
    parama.rHw.Dj(k);
  }
  
  public final void chD()
  {
    a(null);
  }
  
  public final void chE()
  {
    com.tencent.mm.ui.base.h.a(this.rMo.getContext(), this.rMo.getContext().getString(R.l.note_record_stop_request), "", true, new c.3(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  public final void lC(boolean paramBoolean)
  {
    this.rMw = paramBoolean;
    this.rMp.setPressed(paramBoolean);
  }
  
  public final void lD(boolean paramBoolean)
  {
    this.rMx = paramBoolean;
    this.rMq.setPressed(paramBoolean);
  }
  
  public final void lE(boolean paramBoolean)
  {
    this.rMy = paramBoolean;
    this.rMr.setPressed(paramBoolean);
  }
  
  public final void lF(boolean paramBoolean)
  {
    this.rMz = paramBoolean;
    this.rMt.setPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */