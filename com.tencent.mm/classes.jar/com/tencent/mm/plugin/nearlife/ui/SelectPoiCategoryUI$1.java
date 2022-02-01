package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

final class SelectPoiCategoryUI$1
  implements AdapterView.OnItemClickListener
{
  SelectPoiCategoryUI$1(SelectPoiCategoryUI paramSelectPoiCategoryUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(26626);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    Log.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(SelectPoiCategoryUI.a(this.ACD).size()) });
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("poi_category", (String)SelectPoiCategoryUI.a(this.ACD).get(paramInt));
    this.ACD.setResult(-1, paramAdapterView);
    this.ACD.finish();
    a.a(this, "com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(26626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.1
 * JD-Core Version:    0.7.0.1
 */