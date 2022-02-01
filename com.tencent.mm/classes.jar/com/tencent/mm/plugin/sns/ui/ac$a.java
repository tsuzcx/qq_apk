package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class ac$a
{
  public View.OnClickListener Rea = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(97924);
      b localb = new b();
      localb.cH(paramAnonymousView);
      a.c("com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (paramAnonymousView.getTag() == null)
      {
        a.a(this, "com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97924);
        return;
      }
      int i = ((Integer)paramAnonymousView.getTag()).intValue();
      ac.a.this.VB(i);
      a.a(this, "com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97924);
    }
  };
  
  public abstract void VB(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.a
 * JD-Core Version:    0.7.0.1
 */