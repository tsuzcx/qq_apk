package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.ui.contact.s;

final class SnsTagPartlyUI$2
  implements AdapterView.OnItemClickListener
{
  SnsTagPartlyUI$2(SnsTagPartlyUI paramSnsTagPartlyUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < SnsTagPartlyUI.a(this.pdU).getCount() - 1)
    {
      paramAdapterView = new Intent();
      paramView = (t)SnsTagPartlyUI.a(this.pdU).getItem(paramInt);
      if (paramView == null) {
        return;
      }
      paramAdapterView.putExtra("k_sns_tag_id", paramView.field_tagId);
      paramAdapterView.setClass(this.pdU, SnsTagDetailUI.class);
      this.pdU.startActivity(paramAdapterView);
      return;
    }
    paramAdapterView = new Intent();
    paramView = q.Gj();
    paramAdapterView.putExtra("titile", this.pdU.getString(i.j.address_title_add_contact));
    paramAdapterView.putExtra("list_type", 1);
    paramAdapterView.putExtra("KBlockOpenImFav", true);
    paramAdapterView.putExtra("list_attr", s.fB(s.v(new int[] { s.vMs, 1024 }), 16777216));
    paramAdapterView.putExtra("block_contact", paramView);
    d.c(this.pdU, ".ui.contact.SelectContactUI", paramAdapterView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.2
 * JD-Core Version:    0.7.0.1
 */