package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.g;

final class ap$i
  extends c.a
{
  TextView vEC;
  View vGS = null;
  
  public static void a(i parami, bi parambi, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.c.a parama, ap.h paramh, View.OnLongClickListener paramOnLongClickListener)
  {
    int j = 0;
    if (parami == null) {}
    label34:
    label127:
    do
    {
      return;
      int i;
      if (parami.vBa != null)
      {
        ImageView localImageView = parami.vBa;
        if (parambi.field_status == 6)
        {
          i = 8;
          localImageView.setVisibility(i);
        }
      }
      else
      {
        parami.igg.setTag(new aw(parambi, parama.cFE(), paramInt, null, '\000'));
        parami.igg.setOnClickListener(paramh);
        parami.igg.setOnLongClickListener(paramOnLongClickListener);
        parami.igg.setOnTouchListener(((g)parama.ac(g.class)).cDu());
        parama = parambi.czr;
        if (bk.bl(parama)) {
          break label229;
        }
        parami.vEC.setText(parama);
        if (parami.vGS == null) {
          break label257;
        }
        if (!parambi.field_content.equals(bi.uBP))
        {
          parama = parambi.field_content;
          paramh = new td();
          paramh.ccJ.bNb = 1;
          paramh.ccJ.content = parama;
          com.tencent.mm.sdk.b.a.udP.m(paramh);
          if (paramh.ccK.type != 3) {
            break label259;
          }
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          if (paramBoolean)
          {
            parami.vGS.setBackgroundResource(R.k.voip_voicecall);
            return;
            i = 0;
            break label34;
            if (paramBoolean)
            {
              parami.vEC.setText(R.l.voip_call_cancel_msg_from);
              break label127;
            }
            parami.vEC.setText(R.l.voip_call_cancel_msg_to);
            break label127;
            break;
            paramInt = 0;
            continue;
          }
          parami.vGS.setBackgroundResource(R.k.voip_voicecall_to);
          return;
        }
      }
      if (parambi.field_content.equals(bi.uBQ)) {
        break;
      }
      parambi = parambi.field_content;
      parama = new td();
      parama.ccJ.bNb = 1;
      parama.ccJ.content = parambi;
      com.tencent.mm.sdk.b.a.udP.m(parama);
      paramInt = j;
      if (parama.ccK.type == 2) {
        paramInt = 1;
      }
    } while (paramInt == 0);
    label229:
    if (paramBoolean)
    {
      parami.vGS.setBackgroundResource(R.k.voip_videocall);
      return;
    }
    label257:
    label259:
    parami.vGS.setBackgroundResource(R.k.voip_videocall_to);
  }
  
  public final c.a dX(View paramView)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vEC = ((TextView)paramView.findViewById(R.h.chatting_voip_tv));
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    this.vGS = paramView.findViewById(R.h.chatting_voip_iv);
    this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.i
 * JD-Core Version:    0.7.0.1
 */