package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, b.a parama) {}
  
  public final void onClick(View paramView)
  {
    switch (b.3.vJv[this.vJt.ordinal()])
    {
    default: 
      y.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[] { this.vJt });
      return;
    case 1: 
      paramView = new Intent();
      paramView.setClassName(b.a(this.vJu), "com.tencent.mm.ui.contact.ChatroomContactUI");
      b.a(this.vJu).startActivity(paramView);
      return;
    case 2: 
      paramView = new Intent();
      d.b(b.a(this.vJu), "label", ".ui.ContactLabelManagerUI", paramView);
      return;
    }
    paramView = new Intent();
    d.b(b.a(this.vJu), "ipcall", ".ui.IPCallAddressUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b.1
 * JD-Core Version:    0.7.0.1
 */