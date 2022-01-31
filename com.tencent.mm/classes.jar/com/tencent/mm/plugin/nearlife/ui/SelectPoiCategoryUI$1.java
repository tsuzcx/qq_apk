package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class SelectPoiCategoryUI$1
  implements AdapterView.OnItemClickListener
{
  SelectPoiCategoryUI$1(SelectPoiCategoryUI paramSelectPoiCategoryUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(SelectPoiCategoryUI.a(this.mFO).size()) });
    paramAdapterView = new Intent();
    paramAdapterView.putExtra("poi_category", (String)SelectPoiCategoryUI.a(this.mFO).get(paramInt));
    this.mFO.setResult(-1, paramAdapterView);
    this.mFO.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.1
 * JD-Core Version:    0.7.0.1
 */