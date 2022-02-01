package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;

public abstract interface z
{
  public abstract void clean();
  
  public abstract View getView();
  
  public abstract void setImageClick(a parama);
  
  public abstract void setIsShowAddImage(boolean paramBoolean);
  
  public abstract void setList$22875ea3(List<String> paramList);
  
  public static abstract class a
  {
    public View.OnClickListener Erh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97924);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getTag() == null)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97924);
          return;
        }
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        z.a.this.Lc(i);
        a.a(this, "com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97924);
      }
    };
    
    public abstract void Lc(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.z
 * JD-Core Version:    0.7.0.1
 */