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
import com.tencent.mm.cc.a;

public class GameMenuImageButton
  extends LinearLayout
{
  private ImageView dhf;
  public boolean nNH;
  
  public GameMenuImageButton(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(80958);
    aM(paramContext);
    AppMethodBeat.o(80958);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80959);
    aM(paramContext);
    AppMethodBeat.o(80959);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(80960);
    aM(paramContext);
    AppMethodBeat.o(80960);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(80961);
    this.dhf = new ImageView(paramContext);
    this.dhf.setLayoutParams(new ViewGroup.LayoutParams(a.av(paramContext, 2131166405), a.av(paramContext, 2131166405)));
    this.dhf.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.dhf.setImageResource(2131232530);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, a.av(paramContext, 2131166404), a.av(paramContext, 2131166404), 0);
    addView(this.dhf, localLayoutParams);
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
    if (this.dhf != null) {
      this.dhf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(80957);
          if (parama != null) {
            parama.cOZ();
          }
          AppMethodBeat.o(80957);
        }
      });
    }
    this.nNH = true;
    AppMethodBeat.o(80962);
  }
  
  public static abstract interface a
  {
    public abstract void cOZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton
 * JD-Core Version:    0.7.0.1
 */