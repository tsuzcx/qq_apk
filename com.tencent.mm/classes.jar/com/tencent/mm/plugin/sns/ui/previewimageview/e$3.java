package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ui.y.a;
import com.tencent.mm.sdk.platformtools.ae;

final class e$3
  implements AdapterView.OnItemClickListener
{
  e$3(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(100285);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    if (this.ARl.ARd != null)
    {
      if (paramView.getTag() == null)
      {
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100285);
        return;
      }
      paramInt = ((Integer)paramView.getTag()).intValue();
      ae.i("DynamicGrid", "click ".concat(String.valueOf(paramInt)));
      if (paramInt == 2147483647)
      {
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100285);
        return;
      }
      this.ARl.ARd.FN(paramInt);
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(100285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.3
 * JD-Core Version:    0.7.0.1
 */