package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsTagContactListUI$1
  implements AdapterView.OnItemClickListener
{
  SnsTagContactListUI$1(SnsTagContactListUI paramSnsTagContactListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new Intent();
    paramView = (a)SnsTagContactListUI.a(this.vOc).getItem(paramInt);
    h localh = n.omH;
    if (localh == null)
    {
      this.vOc.finish();
      return;
    }
    paramAdapterView = localh.e(paramAdapterView, paramView.field_username);
    if (paramAdapterView == null)
    {
      this.vOc.finish();
      return;
    }
    d.b(this.vOc.mController.uMN, "sns", ".ui.SnsUserUI", paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI.1
 * JD-Core Version:    0.7.0.1
 */