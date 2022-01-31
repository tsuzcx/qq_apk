package com.tencent.mm.ui.base;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMRadioGroupView$c
  implements ViewGroup.OnHierarchyChangeListener
{
  private ViewGroup.OnHierarchyChangeListener iI;
  
  private MMRadioGroupView$c(MMRadioGroupView paramMMRadioGroupView) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2)
  {
    AppMethodBeat.i(106749);
    if ((paramView1 == this.zlW) && ((paramView2 instanceof MMRadioImageButton)))
    {
      if (paramView2.getId() == -1)
      {
        int j = paramView2.hashCode();
        int i = j;
        if (j < 0) {
          i = j & 0x7FFFFFFF;
        }
        paramView2.setId(i);
      }
      ((MMRadioImageButton)paramView2).setOnOtherMMRadioButtonCheckedChangeListener(MMRadioGroupView.b(this.zlW));
    }
    if (this.iI != null) {
      this.iI.onChildViewAdded(paramView1, paramView2);
    }
    AppMethodBeat.o(106749);
  }
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    AppMethodBeat.i(106750);
    if ((paramView1 == this.zlW) && ((paramView2 instanceof MMRadioImageButton))) {
      ((MMRadioImageButton)paramView2).setOnOtherMMRadioButtonCheckedChangeListener(null);
    }
    if (this.iI != null) {
      this.iI.onChildViewRemoved(paramView1, paramView2);
    }
    AppMethodBeat.o(106750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioGroupView.c
 * JD-Core Version:    0.7.0.1
 */