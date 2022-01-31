package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.sns.ui.v.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$3
  implements AdapterView.OnItemClickListener
{
  e$3(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.ppV.ppM == null) || (paramView.getTag() == null)) {}
    do
    {
      return;
      paramInt = ((Integer)paramView.getTag()).intValue();
      y.i("DynamicGrid", "click " + paramInt);
    } while (paramInt == 2147483647);
    this.ppV.ppM.yx(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.3
 * JD-Core Version:    0.7.0.1
 */