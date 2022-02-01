package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ui.ac.a;
import com.tencent.mm.sdk.platformtools.Log;

final class e$3
  implements AdapterView.OnItemClickListener
{
  e$3(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(100285);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    if (this.RTk.RTc != null)
    {
      if (paramView.getTag() == null)
      {
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100285);
        return;
      }
      paramInt = ((Integer)paramView.getTag()).intValue();
      Log.i("DynamicGrid", "click ".concat(String.valueOf(paramInt)));
      if (paramInt == 2147483647)
      {
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100285);
        return;
      }
      this.RTk.RTc.VB(paramInt);
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(100285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.3
 * JD-Core Version:    0.7.0.1
 */