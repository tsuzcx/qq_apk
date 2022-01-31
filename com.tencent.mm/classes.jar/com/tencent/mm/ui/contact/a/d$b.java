package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.storage.ad;

public class d$b
  extends a.b
{
  public d$b(d paramd)
  {
    super(paramd);
  }
  
  public final boolean VB()
  {
    if (this.vOx.fYx != null) {
      ((n)g.t(n.class)).updateTopHitsRank(this.vOx.bVk, this.vOx.fYx, 1);
    }
    return false;
  }
  
  public View a(Context paramContext, ViewGroup paramViewGroup)
  {
    if (com.tencent.mm.cb.a.fh(paramContext)) {}
    for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
    {
      paramViewGroup = (d.a)this.vOx.VA();
      paramViewGroup.doU = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
      paramViewGroup.eXO = ((TextView)paramContext.findViewById(a.e.title_tv));
      paramViewGroup.eXP = ((TextView)paramContext.findViewById(a.e.desc_tv));
      paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
      paramViewGroup.eXQ = ((CheckBox)paramContext.findViewById(a.e.select_cb));
      paramViewGroup.vOw = ((CheckBox)paramContext.findViewById(a.e.select_single_mark));
      paramViewGroup.vIQ = ((TextView)paramContext.findViewById(a.e.openim_contact_desc));
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
  }
  
  public void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama = (d.a)parama;
    parama1 = (d)parama1;
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.doU, parama1.username);
      m.a(parama1.eXK, parama.eXO);
      m.a(parama1.eXL, parama.eXP);
      if (!this.vOx.vLJ) {
        break label244;
      }
      parama.eXQ.setBackgroundResource(a.d.mm_checkbox_btn);
      if (!paramBoolean1) {
        break label224;
      }
      parama.eXQ.setChecked(true);
      parama.eXQ.setEnabled(false);
      label103:
      parama.eXQ.setVisibility(0);
      label111:
      if (!this.vOx.icY) {
        break label375;
      }
      parama.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
    }
    for (;;)
    {
      if (parama1.dnp.field_deleteFlag == 1)
      {
        parama.eXP.setVisibility(0);
        parama.eXP.setText(paramContext.getString(a.h.select_contact_account_deleted));
      }
      if ((!this.vOx.vOt) && (parama.vIQ != null))
      {
        if (!ad.aaU(parama1.username)) {
          break label388;
        }
        parama.vIQ.setText(parama1.vOs);
        parama.vIQ.setVisibility(0);
      }
      return;
      parama.doU.setImageResource(a.d.default_avatar);
      break;
      label224:
      parama.eXQ.setChecked(paramBoolean2);
      parama.eXQ.setEnabled(true);
      break label103;
      label244:
      if (this.vOx.vOj)
      {
        parama.eXQ.setBackgroundResource(a.d.round_selector);
        if (paramBoolean1)
        {
          parama.eXQ.setChecked(true);
          parama.eXQ.setEnabled(false);
        }
        for (;;)
        {
          parama.eXQ.setVisibility(0);
          break;
          parama.eXQ.setChecked(paramBoolean2);
          parama.eXQ.setEnabled(true);
        }
      }
      if (this.vOx.vLK)
      {
        parama.eXQ.setVisibility(8);
        parama.vOw.setChecked(paramBoolean2);
        parama.vOw.setEnabled(true);
        parama.vOw.setVisibility(0);
        break label111;
      }
      parama.eXQ.setVisibility(8);
      break label111;
      label375:
      parama.contentView.setBackgroundResource(a.d.comm_list_item_selector);
    }
    label388:
    parama.vIQ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d.b
 * JD-Core Version:    0.7.0.1
 */