package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.m;

final class SnsLabelContactListUI$2
  implements AdapterView.OnItemClickListener
{
  SnsLabelContactListUI$2(SnsLabelContactListUI paramSnsLabelContactListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = new Intent();
    paramAdapterView = (a)SnsLabelContactListUI.a(this.vNU).getItem(paramInt);
    h localh = n.omH;
    if (localh == null)
    {
      this.vNU.finish();
      return;
    }
    paramView = localh.e(paramView, paramAdapterView.field_username);
    if (paramView == null)
    {
      this.vNU.finish();
      return;
    }
    paramView.putExtra("Contact_User", paramAdapterView.field_username);
    WorkerProfile.ts().bxL.d(paramView, this.vNU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsLabelContactListUI.2
 * JD-Core Version:    0.7.0.1
 */