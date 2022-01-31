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

public class VoipBigIconButton
  extends FrameLayout
{
  private ImageView ioq;
  private View.OnTouchListener kjL;
  private TextView md;
  private Drawable tCL;
  private Drawable tCM;
  private Drawable tCN;
  private Drawable tCO;
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(4853);
    this.tCL = null;
    this.tCM = null;
    this.tCN = null;
    this.tCO = null;
    this.kjL = new VoipBigIconButton.1(this);
    LayoutInflater.from(paramContext).inflate(2130969976, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.a.VoipButton, 0, 0);
    for (;;)
    {
      try
      {
        this.tCL = paramAttributeSet.getDrawable(0);
        this.tCM = paramAttributeSet.getDrawable(1);
        this.tCN = paramAttributeSet.getDrawable(2);
        this.tCO = paramAttributeSet.getDrawable(3);
        int i = paramAttributeSet.getResourceId(4, -1);
        int j = paramAttributeSet.getResourceId(4, 0);
        if (j == 0) {
          break label296;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.tCM == null)
        {
          paramAttributeSet = this.tCL;
          this.tCM = paramAttributeSet;
          if (this.tCO != null) {
            break label288;
          }
          paramAttributeSet = this.tCN;
          this.tCO = paramAttributeSet;
          this.ioq = ((ImageView)findViewById(2131825408));
          this.ioq.setBackgroundDrawable(this.tCL);
          this.ioq.setImageDrawable(this.tCN);
          this.ioq.setOnTouchListener(this.kjL);
          this.ioq.setContentDescription(paramContext);
          this.md = ((TextView)findViewById(2131825409));
          if (i != -1) {
            this.md.setText(getContext().getString(i));
          }
          AppMethodBeat.o(4853);
          return;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
        AppMethodBeat.o(4853);
      }
      paramAttributeSet = this.tCM;
      continue;
      label288:
      paramAttributeSet = this.tCO;
      continue;
      label296:
      paramContext = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(4854);
    this.ioq.setEnabled(paramBoolean);
    this.md.setEnabled(paramBoolean);
    AppMethodBeat.o(4854);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(4855);
    this.ioq.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(4855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */