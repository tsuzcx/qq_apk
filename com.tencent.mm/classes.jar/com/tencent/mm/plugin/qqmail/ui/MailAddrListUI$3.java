package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.o;
import java.util.Map;

final class MailAddrListUI$3
  implements AdapterView.OnItemClickListener
{
  MailAddrListUI$3(MailAddrListUI paramMailAddrListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = MailAddrListUI.e(this.nia);
    paramView = paramAdapterView.wo(paramInt - MailAddrListUI.g(this.nia).getHeaderViewsCount());
    Object localObject = paramView.lCF;
    if (paramAdapterView.nid.containsKey(localObject))
    {
      paramAdapterView.nid.remove(localObject);
      paramAdapterView.notifyDataSetChanged();
      paramView = this.nia;
      localObject = new StringBuilder().append(this.nia.getString(b.j.plugin_qqmail_addrlist_title));
      if (MailAddrListUI.e(this.nia).bug() <= 0) {
        break label162;
      }
    }
    label162:
    for (paramAdapterView = "(" + MailAddrListUI.e(this.nia).bug() + ")";; paramAdapterView = "")
    {
      paramView.setMMTitle(paramAdapterView);
      return;
      paramAdapterView.nid.put(localObject, paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.3
 * JD-Core Version:    0.7.0.1
 */