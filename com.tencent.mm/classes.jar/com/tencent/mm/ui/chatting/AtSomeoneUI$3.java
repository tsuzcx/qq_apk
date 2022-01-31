package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.ad;

final class AtSomeoneUI$3
  implements AdapterView.OnItemClickListener
{
  AtSomeoneUI$3(AtSomeoneUI paramAtSomeoneUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    Intent localIntent = new Intent();
    if ((paramInt == 0) && (AtSomeoneUI.access$100()))
    {
      localIntent.putExtra("Select_Conv_User", this.vhx.getString(R.l.at_all, new Object[] { "" }));
      localIntent.putExtra("select_raw_user_name", "notify@all");
      this.vhx.setResult(-1, localIntent);
      this.vhx.finish();
      return;
    }
    paramAdapterView = AtSomeoneUI.a(this.vhx);
    if (AtSomeoneUI.access$100()) {}
    for (;;)
    {
      ad localad = (ad)paramAdapterView.getItem(paramInt - i);
      paramView = AtSomeoneUI.a(AtSomeoneUI.b(this.vhx), localad.field_username);
      paramAdapterView = paramView;
      if (ah.bl(paramView)) {
        paramAdapterView = localad.Bp();
      }
      localIntent.putExtra("select_raw_user_name", localad.field_username);
      localIntent.putExtra("Select_Conv_User", paramAdapterView);
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI.3
 * JD-Core Version:    0.7.0.1
 */