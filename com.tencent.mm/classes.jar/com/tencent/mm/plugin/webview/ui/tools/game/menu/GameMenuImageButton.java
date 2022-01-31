package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class GameMenuImageButton
  extends LinearLayout
{
  private ImageView cuM;
  public boolean vnA;
  
  public GameMenuImageButton(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(8806);
    aA(paramContext);
    AppMethodBeat.o(8806);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8807);
    aA(paramContext);
    AppMethodBeat.o(8807);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(8808);
    aA(paramContext);
    AppMethodBeat.o(8808);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(8809);
    this.cuM = new ImageView(paramContext);
    this.cuM.setLayoutParams(new ViewGroup.LayoutParams(a.ap(paramContext, 2131428443), a.ap(paramContext, 2131428443)));
    this.cuM.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.cuM.setImageResource(2130838994);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, a.ap(paramContext, 2131428442), a.ap(paramContext, 2131428442), 0);
    addView(this.cuM, localLayoutParams);
    AppMethodBeat.o(8809);
  }
  
  public final void a(FrameLayout paramFrameLayout, GameMenuImageButton.a parama)
  {
    AppMethodBeat.i(8810);
    if ((getParent() == null) && (paramFrameLayout != null))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      paramFrameLayout.addView(this, localLayoutParams);
    }
    if (this.cuM != null) {
      this.cuM.setOnClickListener(new GameMenuImageButton.1(this, parama));
    }
    this.vnA = true;
    AppMethodBeat.o(8810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton
 * JD-Core Version:    0.7.0.1
 */