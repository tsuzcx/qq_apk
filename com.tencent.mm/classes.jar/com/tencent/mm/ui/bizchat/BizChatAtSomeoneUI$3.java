package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.j;

final class BizChatAtSomeoneUI$3
  implements AdapterView.OnItemClickListener
{
  BizChatAtSomeoneUI$3(BizChatAtSomeoneUI paramBizChatAtSomeoneUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(30029);
    paramAdapterView = new Intent();
    if ((paramInt == 0) && (BizChatAtSomeoneUI.access$100()))
    {
      paramAdapterView.putExtra("Select_Conv_User", this.zsQ.getString(2131297210, new Object[] { "" }));
      paramAdapterView.putExtra("select_raw_user_name", "notify@all");
    }
    for (;;)
    {
      this.zsQ.setResult(-1, paramAdapterView);
      this.zsQ.finish();
      AppMethodBeat.o(30029);
      return;
      paramView = (j)BizChatAtSomeoneUI.a(this.zsQ).getItem(paramInt);
      String str = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(this.zsQ), paramView.field_userId);
      paramAdapterView.putExtra("select_raw_user_name", paramView.field_userId);
      paramAdapterView.putExtra("Select_Conv_User", str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.3
 * JD-Core Version:    0.7.0.1
 */