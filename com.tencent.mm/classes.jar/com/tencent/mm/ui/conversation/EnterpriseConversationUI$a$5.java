package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.tools.j;

final class EnterpriseConversationUI$a$5
  implements AdapterView.OnItemLongClickListener
{
  EnterpriseConversationUI$a$5(EnterpriseConversationUI.a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ak)EnterpriseConversationUI.a.f(this.vSW).getItem(paramInt);
    EnterpriseConversationUI.a.c(this.vSW, paramAdapterView.field_username);
    EnterpriseConversationUI.a.i(this.vSW).a(paramView, paramInt, paramLong, this.vSW, EnterpriseConversationUI.a.h(this.vSW));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.5
 * JD-Core Version:    0.7.0.1
 */