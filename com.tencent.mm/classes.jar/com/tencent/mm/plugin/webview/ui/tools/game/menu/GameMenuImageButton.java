package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class GameMenuImageButton
  extends LinearLayout
{
  private ImageView dtJ;
  public boolean owJ;
  
  public GameMenuImageButton(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(80958);
    aN(paramContext);
    AppMethodBeat.o(80958);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80959);
    aN(paramContext);
    AppMethodBeat.o(80959);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(80960);
    aN(paramContext);
    AppMethodBeat.o(80960);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(80961);
    this.dtJ = new ImageView(paramContext);
    this.dtJ.setLayoutParams(new ViewGroup.LayoutParams(com.tencent.mm.cb.a.ay(paramContext, 2131166405), com.tencent.mm.cb.a.ay(paramContext, 2131166405)));
    this.dtJ.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.dtJ.setImageResource(2131232530);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, com.tencent.mm.cb.a.ay(paramContext, 2131166404), com.tencent.mm.cb.a.ay(paramContext, 2131166404), 0);
    addView(this.dtJ, localLayoutParams);
    AppMethodBeat.o(80961);
  }
  
  public final void a(FrameLayout paramFrameLayout, final a parama)
  {
    AppMethodBeat.i(80962);
    if ((getParent() == null) && (paramFrameLayout != null))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      paramFrameLayout.addView(this, localLayoutParams);
    }
    if (this.dtJ != null) {
      this.dtJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(80957);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/game/menu/GameMenuImageButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (parama != null) {
            parama.dam();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/game/menu/GameMenuImageButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(80957);
        }
      });
    }
    this.owJ = true;
    AppMethodBeat.o(80962);
  }
  
  public static abstract interface a
  {
    public abstract void dam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton
 * JD-Core Version:    0.7.0.1
 */