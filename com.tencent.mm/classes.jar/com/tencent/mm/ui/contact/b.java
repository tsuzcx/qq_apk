package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.MaskLayout;

public final class b
  extends RelativeLayout
{
  private TextView contentView = null;
  private Context context;
  private View eML = null;
  private View fhl = null;
  
  public b(Context paramContext, b.a parama)
  {
    super(paramContext);
    this.context = paramContext;
    View.inflate(getContext(), R.i.address_entrance_header_view, this);
    this.eML = findViewById(R.h.container);
    this.fhl = this.eML.findViewById(R.h.addressui_contact_entrance);
    paramContext = this.fhl.getLayoutParams();
    paramContext.height = ((int)(a.ab(this.context, R.f.ContactListHeight) * a.fg(this.context)));
    this.fhl.setLayoutParams(paramContext);
    this.contentView = ((TextView)this.fhl.findViewById(R.h.addressui_content));
    this.eML.setOnClickListener(new b.1(this, parama));
    this.fhl.setOnTouchListener(new b.2(this));
    paramContext = (ImageView)((MaskLayout)this.fhl.findViewById(R.h.addressui_contact_entrance_avatar_iv)).getContentView();
    switch (b.3.vJv[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.contentView.setText(R.l.address_chatroom_contact_nick);
      d.a(getContext(), paramContext, R.k.default_chatroom);
      return;
    case 2: 
      this.contentView.setText(R.l.address_contact_label_nick);
      d.a(getContext(), paramContext, R.k.default_contactlabel);
      return;
    }
    this.fhl.setBackgroundResource(R.g.comm_list_item_selector);
    this.contentView.setText(R.l.address_contact_ipcall_nick);
    d.a(getContext(), paramContext, R.k.default_ipcall);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    View localView = this.eML;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b
 * JD-Core Version:    0.7.0.1
 */