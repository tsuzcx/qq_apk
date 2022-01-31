package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;

final class SnsTagPartlyUI$2
  implements AdapterView.OnItemClickListener
{
  SnsTagPartlyUI$2(SnsTagPartlyUI paramSnsTagPartlyUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39377);
    if (paramInt < SnsTagPartlyUI.a(this.rWH).getCount() - 1)
    {
      paramAdapterView = new Intent();
      paramView = (com.tencent.mm.plugin.sns.storage.t)SnsTagPartlyUI.a(this.rWH).getItem(paramInt);
      if (paramView == null)
      {
        AppMethodBeat.o(39377);
        return;
      }
      paramAdapterView.putExtra("k_sns_tag_id", paramView.field_tagId);
      paramAdapterView.setClass(this.rWH, SnsTagDetailUI.class);
      this.rWH.startActivity(paramAdapterView);
      AppMethodBeat.o(39377);
      return;
    }
    paramAdapterView = new Intent();
    paramView = r.Zn();
    paramAdapterView.putExtra("titile", this.rWH.getString(2131296497));
    paramAdapterView.putExtra("list_type", 1);
    paramAdapterView.putExtra("KBlockOpenImFav", true);
    paramAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.t.hJ(com.tencent.mm.ui.contact.t.F(new int[] { com.tencent.mm.ui.contact.t.AdU, 1024 }), 16777216));
    paramAdapterView.putExtra("block_contact", paramView);
    d.b(this.rWH, ".ui.contact.SelectContactUI", paramAdapterView, 1);
    AppMethodBeat.o(39377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.2
 * JD-Core Version:    0.7.0.1
 */