package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.n;

final class SnsTagContactListUI$1
  implements AdapterView.OnItemClickListener
{
  SnsTagContactListUI$1(SnsTagContactListUI paramSnsTagContactListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33955);
    paramAdapterView = new Intent();
    paramView = (a)SnsTagContactListUI.a(this.AfK).getItem(paramInt);
    h localh = n.raV;
    if (localh == null)
    {
      this.AfK.finish();
      AppMethodBeat.o(33955);
      return;
    }
    paramAdapterView = localh.e(paramAdapterView, paramView.field_username);
    if (paramAdapterView == null)
    {
      this.AfK.finish();
      AppMethodBeat.o(33955);
      return;
    }
    paramAdapterView.putExtra("sns_adapter_type", 1);
    d.b(this.AfK.getContext(), "sns", ".ui.SnsTimeLineUserPagerUI", paramAdapterView);
    AppMethodBeat.o(33955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI.1
 * JD-Core Version:    0.7.0.1
 */