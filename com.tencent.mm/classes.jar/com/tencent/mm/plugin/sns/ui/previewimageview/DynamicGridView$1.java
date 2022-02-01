package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class DynamicGridView$1
  implements AdapterView.OnItemClickListener
{
  DynamicGridView$1(DynamicGridView paramDynamicGridView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(100305);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    if ((!this.ARZ.qrh) && (this.ARZ.isEnabled()) && (DynamicGridView.a(this.ARZ) != null)) {
      DynamicGridView.a(this.ARZ).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(100305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.1
 * JD-Core Version:    0.7.0.1
 */