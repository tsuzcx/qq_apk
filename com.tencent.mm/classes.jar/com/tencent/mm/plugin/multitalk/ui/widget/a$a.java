package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.d.a;
import com.tencent.mm.ui.contact.a.d.b;

public final class a$a
  extends d.b
{
  public a$a(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(a.e.multitalk_listcontactitem, paramViewGroup, false);
    paramViewGroup = (d.a)a.a(this.mvt);
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(a.d.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(a.d.title_tv));
    paramViewGroup.eXP = ((TextView)paramContext.findViewById(a.d.desc_tv));
    paramViewGroup.contentView = paramContext.findViewById(a.d.select_item_content_layout);
    paramViewGroup.eXQ = ((CheckBox)paramContext.findViewById(a.d.select_cb));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = (d.a)parama;
    parama = (d)parama1;
    if ((parama.username != null) && (parama.username.length() > 0))
    {
      a.b.a(paramContext.doU, parama.username);
      m.a(parama.eXK, paramContext.eXO);
      if (!this.mvt.vLJ) {
        break label123;
      }
      if (!paramBoolean1) {
        break label103;
      }
      paramContext.eXQ.setChecked(true);
      paramContext.eXQ.setEnabled(false);
    }
    for (;;)
    {
      paramContext.eXQ.setVisibility(0);
      return;
      paramContext.doU.setImageResource(a.c.default_avatar);
      break;
      label103:
      paramContext.eXQ.setChecked(paramBoolean2);
      paramContext.eXQ.setEnabled(true);
    }
    label123:
    paramContext.eXQ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.a.a
 * JD-Core Version:    0.7.0.1
 */