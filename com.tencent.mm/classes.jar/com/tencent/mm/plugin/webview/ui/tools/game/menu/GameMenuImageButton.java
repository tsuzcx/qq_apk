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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.cb.a;

public class GameMenuImageButton
  extends LinearLayout
{
  private ImageView bNu;
  public boolean rwH;
  
  public GameMenuImageButton(Context paramContext)
  {
    super(paramContext);
    ca(paramContext);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  public GameMenuImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ca(paramContext);
  }
  
  private void ca(Context paramContext)
  {
    this.bNu = new ImageView(paramContext);
    this.bNu.setLayoutParams(new ViewGroup.LayoutParams(a.ab(paramContext, R.f.game_menu_button_size), a.ab(paramContext, R.f.game_menu_button_size)));
    this.bNu.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.bNu.setImageResource(R.g.game_menu_btn_icon);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, a.ab(paramContext, R.f.game_menu_button_margin), a.ab(paramContext, R.f.game_menu_button_margin), 0);
    addView(this.bNu, localLayoutParams);
  }
  
  public final void a(FrameLayout paramFrameLayout, a parama)
  {
    if ((getParent() == null) && (paramFrameLayout != null))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      paramFrameLayout.addView(this, localLayoutParams);
    }
    if (this.bNu != null) {
      this.bNu.setOnClickListener(new GameMenuImageButton.1(this, parama));
    }
    this.rwH = true;
  }
  
  public static abstract interface a
  {
    public abstract void aYF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton
 * JD-Core Version:    0.7.0.1
 */