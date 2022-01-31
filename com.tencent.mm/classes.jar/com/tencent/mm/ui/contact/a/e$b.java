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
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class e$b
  extends a.b
{
  public e$b(e parame)
  {
    super(parame);
  }
  
  public final boolean VB()
  {
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    if (com.tencent.mm.cb.a.fh(paramContext)) {}
    for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
    {
      paramViewGroup = (e.a)this.vOC.vOB;
      paramViewGroup.doU = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
      paramViewGroup.doV = ((TextView)paramContext.findViewById(a.e.title_tv));
      paramViewGroup.eXP = ((TextView)paramContext.findViewById(a.e.desc_tv));
      paramViewGroup.eXP.setVisibility(8);
      paramViewGroup.eXQ = ((CheckBox)paramContext.findViewById(a.e.select_cb));
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama1 = (e)parama1;
    parama = (e.a)parama;
    parama.doV.setCompoundDrawables(null, null, null, null);
    if ((this.vOC.vOz != 0) && (this.vOC.vOy != null))
    {
      parama.doU.setImageResource(this.vOC.vOz);
      parama.doV.setText(this.vOC.vOy);
      return;
    }
    m.a(parama1.eXK, parama.doV);
    if (ad.aaU(parama1.username))
    {
      g.DQ();
      ad localad = ((j)g.r(j.class)).Fw().abl(parama1.username);
      ((b)g.r(b.class)).a(paramContext, parama.doV, parama1.eXK, localad.field_openImAppid, localad.field_descWordingId, (int)parama.doV.getTextSize());
    }
    com.tencent.mm.pluginsdk.ui.a.b.a(parama.doU, parama1.username);
    if (s.hb(parama1.username))
    {
      paramContext = paramContext.getResources().getDrawable(a.g.open_im_main_logo);
      paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
      parama.doV.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
      if (!this.vOC.vLJ) {
        break label291;
      }
      if (!paramBoolean1) {
        break label271;
      }
      parama.eXQ.setChecked(true);
      parama.eXQ.setEnabled(false);
    }
    for (;;)
    {
      parama.eXQ.setVisibility(0);
      return;
      parama.doV.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break;
      label271:
      parama.eXQ.setChecked(paramBoolean2);
      parama.eXQ.setEnabled(true);
    }
    label291:
    parama.eXQ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e.b
 * JD-Core Version:    0.7.0.1
 */