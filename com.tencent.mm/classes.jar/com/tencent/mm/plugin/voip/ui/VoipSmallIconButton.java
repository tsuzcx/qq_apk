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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;

public class VoipSmallIconButton
  extends FrameLayout
{
  private ImageView ioq;
  private View.OnTouchListener kjL;
  private TextView md;
  private Drawable tCN;
  private Drawable tCO;
  
  public VoipSmallIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(4868);
    this.tCN = null;
    this.tCO = null;
    this.kjL = new VoipSmallIconButton.1(this);
    LayoutInflater.from(paramContext).inflate(2130969977, this);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.a.VoipButton, 0, 0);
    try
    {
      this.tCN = paramContext.getDrawable(2);
      this.tCO = paramContext.getDrawable(3);
      paramAttributeSet = paramContext.getString(4);
      int i = paramContext.getResourceId(4, -1);
      paramContext.recycle();
      this.ioq = ((ImageView)findViewById(2131825410));
      this.ioq.setImageDrawable(this.tCN);
      this.ioq.setOnTouchListener(this.kjL);
      this.ioq.setContentDescription(paramAttributeSet);
      this.md = ((TextView)findViewById(2131825411));
      if (i != -1) {
        this.md.setText(getContext().getString(i));
      }
      AppMethodBeat.o(4868);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(4868);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(4869);
    this.ioq.setEnabled(paramBoolean);
    this.md.setEnabled(paramBoolean);
    AppMethodBeat.o(4869);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(4867);
    this.ioq.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(4867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipSmallIconButton
 * JD-Core Version:    0.7.0.1
 */