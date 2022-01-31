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

public class VoipBigIconButton
  extends FrameLayout
{
  private ImageView jjn;
  private TextView lh;
  private Drawable pXh = null;
  private Drawable pXi = null;
  private Drawable pXj = null;
  private Drawable pXk = null;
  private View.OnTouchListener pXl = new VoipBigIconButton.1(this);
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(a.c.layout_voip_big_icon_button, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.f.VoipButton, 0, 0);
    for (;;)
    {
      try
      {
        this.pXh = paramAttributeSet.getDrawable(a.f.VoipButton_iconBackground);
        this.pXi = paramAttributeSet.getDrawable(a.f.VoipButton_iconBackgroundPressed);
        this.pXj = paramAttributeSet.getDrawable(a.f.VoipButton_iconRes);
        this.pXk = paramAttributeSet.getDrawable(a.f.VoipButton_iconResPressed);
        int i = paramAttributeSet.getResourceId(a.f.VoipButton_iconTip, -1);
        int j = paramAttributeSet.getResourceId(a.f.VoipButton_iconTip, 0);
        if (j == 0) {
          break label293;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.pXi == null)
        {
          paramAttributeSet = this.pXh;
          this.pXi = paramAttributeSet;
          if (this.pXk != null) {
            break label285;
          }
          paramAttributeSet = this.pXj;
          this.pXk = paramAttributeSet;
          this.jjn = ((ImageView)findViewById(a.b.big_icon_button));
          this.jjn.setBackgroundDrawable(this.pXh);
          this.jjn.setImageDrawable(this.pXj);
          this.jjn.setOnTouchListener(this.pXl);
          this.jjn.setContentDescription(paramContext);
          this.lh = ((TextView)findViewById(a.b.big_icon_text));
          if (i != -1) {
            this.lh.setText(getContext().getString(i));
          }
          return;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      paramAttributeSet = this.pXi;
      continue;
      label285:
      paramAttributeSet = this.pXk;
      continue;
      label293:
      paramContext = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */