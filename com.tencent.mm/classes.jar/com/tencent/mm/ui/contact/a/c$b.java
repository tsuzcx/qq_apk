package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;

public final class c$b
  extends a.b
{
  public c$b(c paramc)
  {
    super(paramc);
  }
  
  public final boolean VB()
  {
    if (this.vOr.fYx != null) {
      ((n)g.t(n.class)).updateTopHitsRank(this.vOr.bVk, this.vOr.fYx, 1);
    }
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    if (com.tencent.mm.cb.a.fh(paramContext)) {}
    for (paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
    {
      c.a locala = (c.a)this.vOr.vOq;
      locala.doU = ((ImageView)paramViewGroup.findViewById(a.e.avatar_iv));
      locala.eXO = ((TextView)paramViewGroup.findViewById(a.e.title_tv));
      locala.eXO.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 200));
      locala.eXP = ((TextView)paramViewGroup.findViewById(a.e.desc_tv));
      locala.kCv = ((TextView)paramViewGroup.findViewById(a.e.tip_tv));
      locala.contentView = paramViewGroup.findViewById(a.e.select_item_content_layout);
      locala.eXQ = ((CheckBox)paramViewGroup.findViewById(a.e.select_cb));
      if (this.vOr.icY) {
        locala.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
      }
      paramViewGroup.setTag(locala);
      return paramViewGroup;
    }
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama = (c.a)parama;
    parama1 = (c)parama1;
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.doU, parama1.username);
      m.a(parama1.eXK, parama.eXO);
      if (!s.hb(parama1.username)) {
        break label173;
      }
      paramContext = paramContext.getResources().getDrawable(a.g.open_im_main_logo);
      paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
      parama.eXO.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
      label96:
      m.a(parama1.eXL, parama.eXP);
      m.a(parama1.vOo, parama.kCv);
      if (!this.vOr.vLJ) {
        break label207;
      }
      if (!paramBoolean1) {
        break label187;
      }
      parama.eXQ.setChecked(true);
      parama.eXQ.setEnabled(false);
    }
    for (;;)
    {
      parama.eXQ.setVisibility(0);
      return;
      parama.doU.setImageResource(a.d.default_avatar);
      break;
      label173:
      parama.eXO.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label96;
      label187:
      parama.eXQ.setChecked(paramBoolean2);
      parama.eXQ.setEnabled(true);
    }
    label207:
    parama.eXQ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c.b
 * JD-Core Version:    0.7.0.1
 */