package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.d.b;

public final class c$a$b
  extends d.b
{
  public c$a$b(c.a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.sight_select_contact_item, paramViewGroup, false);
    paramViewGroup = (c.a.a)this.ohY.VA();
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(R.h.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(R.h.title_tv));
    paramViewGroup.eXP = ((TextView)paramContext.findViewById(R.h.desc_tv));
    paramViewGroup.contentView = paramContext.findViewById(R.h.select_item_content_layout);
    paramViewGroup.eXQ = ((CheckBox)paramContext.findViewById(R.h.select_cb));
    paramViewGroup.ogQ = paramContext.findViewById(R.h.item_shadow);
    paramViewGroup.ohX = paramContext.findViewById(R.h.search_view);
    paramContext.setTag(paramViewGroup);
    paramViewGroup.eXO.setTextColor(-1);
    paramViewGroup = (AbsListView.LayoutParams)paramContext.getLayoutParams();
    paramViewGroup.width = -1;
    paramContext.setLayoutParams(paramViewGroup);
    paramContext.setBackgroundResource(R.e.black);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    ad localad = parama1.dnp;
    c.a.a locala = (c.a.a)parama;
    locala.contentView.setVisibility(0);
    locala.ohX.setVisibility(8);
    locala.ogQ.setVisibility(8);
    if (c.ML(localad.field_username))
    {
      locala.doU.setImageResource(R.k.sight_icon_draft_item);
      locala.eXO.setText(R.l.sight_draft_title);
      locala.eXP.setText(R.l.sight_draft_subtitle);
      locala.eXP.setVisibility(0);
      locala.eXQ.setEnabled(false);
      if (c.ohV)
      {
        locala.contentView.setBackgroundResource(R.g.sight_list_divider);
        locala.eXQ.setVisibility(0);
        locala.eXQ.setBackgroundResource(R.k.sight_list_checkbox_selected);
        locala.ogQ.setVisibility(0);
      }
      for (;;)
      {
        parama = this.ohY.ohW;
        c.d(paramContext, locala.contentView);
        parama = locala.doU.getLayoutParams();
        parama.width = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_avatar_size);
        parama.height = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_avatar_size);
        locala.doU.setLayoutParams(parama);
        parama = (LinearLayout.LayoutParams)locala.eXQ.getLayoutParams();
        parama.height = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_checkbox_size);
        parama.width = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_checkbox_size);
        parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
        locala.eXQ.setLayoutParams(parama);
        return;
        locala.contentView.setBackgroundResource(R.g.sight_select_contact_item_bg);
        locala.eXQ.setVisibility(8);
        locala.eXQ.setBackgroundResource(R.k.sight_list_checkbox_unselected);
        locala.ogQ.setVisibility(8);
      }
    }
    if (c.MJ(localad.field_username))
    {
      locala.doU.setImageResource(R.k.sight_item_sns_icon);
      locala.eXQ.setVisibility(8);
      locala.eXO.setText(paramContext.getString(R.l.sight_share_sns));
      locala.eXP.setVisibility(8);
      if (c.ohU)
      {
        locala.contentView.setBackgroundResource(R.g.sight_select_contact_item_bg);
        locala.ogQ.setVisibility(8);
        parama = this.ohY.ohW;
        c.d(paramContext, locala.contentView);
      }
    }
    for (;;)
    {
      parama = locala.doU.getLayoutParams();
      parama.width = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_avatar_size);
      parama.height = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_avatar_size);
      locala.doU.setLayoutParams(parama);
      parama = (LinearLayout.LayoutParams)locala.eXQ.getLayoutParams();
      parama.height = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_checkbox_size);
      parama.width = com.tencent.mm.cb.a.aa(paramContext, R.f.sight_checkbox_size);
      parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
      locala.eXQ.setLayoutParams(parama);
      locala.eXQ.setBackgroundResource(R.g.sight_list_checkbox);
      return;
      locala.contentView.setBackgroundResource(R.g.sight_list_divider);
      locala.ogQ.setVisibility(0);
      break;
      if (c.MK(localad.field_username))
      {
        locala.contentView.setVisibility(8);
        locala.ohX.setVisibility(0);
        return;
      }
      super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
      locala.contentView.setBackgroundResource(R.g.sight_select_contact_item_bg);
      parama = this.ohY.ohW;
      c.d(paramContext, locala.contentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */