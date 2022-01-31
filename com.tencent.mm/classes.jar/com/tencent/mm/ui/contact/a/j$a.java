package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class j$a
  extends a.b
{
  public j$a(j paramj)
  {
    super(paramj);
  }
  
  public final boolean VB()
  {
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listnonlimititem, paramViewGroup, false);
    paramViewGroup = (j.b)this.vOQ.vOP;
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(a.e.title_tv));
    paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
    paramViewGroup.eXQ = ((CheckBox)paramContext.findViewById(a.e.select_cb));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = (j.b)parama;
    paramContext.eXO.setText(a.h.select_contact_nonlimit);
    paramContext.eXQ.setBackgroundResource(a.d.mm_checkbox_btn_grey_noborder);
    paramContext.eXQ.setChecked(paramBoolean2);
    paramContext.eXQ.setEnabled(true);
    paramContext.eXQ.setVisibility(0);
    paramContext.contentView.setBackgroundResource(a.d.comm_list_item_selector_no_divider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.j.a
 * JD-Core Version:    0.7.0.1
 */