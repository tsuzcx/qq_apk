package com.tencent.mm.plugin.mv.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class WeCheckBox
  extends WeImageView
{
  a MaC;
  boolean idG = false;
  
  public WeCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WeCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(286356);
    this.idG = paramBoolean;
    if (this.MaC != null) {
      this.MaC.zX(paramBoolean);
    }
    if (paramBoolean)
    {
      setImageResource(b.g.icons_outlined_pause_white);
      AppMethodBeat.o(286356);
      return;
    }
    setImageResource(b.g.icons_outlined_playbtn_white);
    AppMethodBeat.o(286356);
  }
  
  public void setOnCheckedChangeListener(final a parama)
  {
    AppMethodBeat.i(286350);
    this.MaC = parama;
    super.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(286346);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/mv/ui/WeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = WeCheckBox.this;
        boolean bool;
        if (!WeCheckBox.this.idG)
        {
          bool = true;
          paramAnonymousView.idG = bool;
          if (parama != null) {
            parama.zX(WeCheckBox.this.idG);
          }
          if (!WeCheckBox.this.idG) {
            break label122;
          }
          WeCheckBox.this.setImageResource(b.g.icons_outlined_pause_white);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/mv/ui/WeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(286346);
          return;
          bool = false;
          break;
          label122:
          WeCheckBox.this.setImageResource(b.g.icons_outlined_playbtn_white);
        }
      }
    });
    AppMethodBeat.o(286350);
  }
  
  public static abstract interface a
  {
    public abstract void zX(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.WeCheckBox
 * JD-Core Version:    0.7.0.1
 */