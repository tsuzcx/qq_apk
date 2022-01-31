package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.a.f;

public class VoipSmallIconButton
  extends FrameLayout
{
  private ImageView jjn;
  private TextView lh;
  private Drawable pXj = null;
  private Drawable pXk = null;
  private View.OnTouchListener pXl = new VoipSmallIconButton.1(this);
  
  public VoipSmallIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(a.c.layout_voip_small_icon_button, this);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.f.VoipButton, 0, 0);
    try
    {
      this.pXj = paramContext.getDrawable(a.f.VoipButton_iconRes);
      this.pXk = paramContext.getDrawable(a.f.VoipButton_iconResPressed);
      paramAttributeSet = paramContext.getString(a.f.VoipButton_iconTip);
      int i = paramContext.getResourceId(a.f.VoipButton_iconTip, -1);
      paramContext.recycle();
      this.jjn = ((ImageView)findViewById(a.b.small_icon_button));
      this.jjn.setImageDrawable(this.pXj);
      this.jjn.setOnTouchListener(this.pXl);
      this.jjn.setContentDescription(paramAttributeSet);
      this.lh = ((TextView)findViewById(a.b.small_icon_text));
      if (i != -1) {
        this.lh.setText(getContext().getString(i));
      }
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.jjn.setEnabled(paramBoolean);
    this.lh.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jjn.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipSmallIconButton
 * JD-Core Version:    0.7.0.1
 */