package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LivingStatusLayout
  extends FrameLayout
{
  private TextView DAG;
  private View DAH;
  
  public LivingStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LivingStatusLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(202422);
    super.onFinishInflate();
    try
    {
      this.DAG = ((TextView)findViewById(2131296501));
      this.DAH = findViewById(2131296500);
      this.DAH.setVisibility(8);
      AppMethodBeat.o(202422);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202422);
    }
  }
  
  public void setLiveStatus(int paramInt)
  {
    AppMethodBeat.i(202423);
    Object localObject;
    if ((paramInt & 0x7F) == 2)
    {
      if (this.DAH != null) {
        this.DAH.setVisibility(0);
      }
      if (this.DAG != null)
      {
        this.DAG.setVisibility(8);
        AppMethodBeat.o(202423);
      }
    }
    else
    {
      if (this.DAH != null) {
        this.DAH.setVisibility(8);
      }
      if (this.DAG != null)
      {
        this.DAG.setVisibility(0);
        TextView localTextView = this.DAG;
        paramInt &= 0x7F;
        if (paramInt != 3) {
          break label140;
        }
        localObject = getContext().getString(2131765966);
        localTextView.setText((CharSequence)localObject);
        localObject = this.DAG;
        if ((paramInt != 2) && (paramInt != 1)) {
          break label164;
        }
      }
    }
    label140:
    label164:
    for (paramInt = 2131230895;; paramInt = 2131230896)
    {
      ((TextView)localObject).setBackgroundResource(paramInt);
      AppMethodBeat.o(202423);
      return;
      if (paramInt == 1)
      {
        localObject = getContext().getString(2131765967);
        break;
      }
      localObject = "";
      break;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(202424);
    super.setVisibility(paramInt);
    if ((this.DAH != null) && (paramInt != 0)) {
      this.DAH.setVisibility(paramInt);
    }
    AppMethodBeat.o(202424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.LivingStatusLayout
 * JD-Core Version:    0.7.0.1
 */