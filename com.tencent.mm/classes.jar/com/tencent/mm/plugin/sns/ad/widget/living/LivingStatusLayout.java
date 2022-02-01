package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.j;

public class LivingStatusLayout
  extends FrameLayout
{
  private TextView QgW;
  private View QgX;
  
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
    AppMethodBeat.i(310357);
    super.onFinishInflate();
    try
    {
      this.QgW = ((TextView)findViewById(b.f.ad_live_status_content));
      this.QgX = findViewById(b.f.ad_live_finder_living_icon);
      this.QgX.setVisibility(8);
      return;
    }
    finally
    {
      AppMethodBeat.o(310357);
    }
  }
  
  public void setLiveStatus(int paramInt)
  {
    AppMethodBeat.i(310368);
    Object localObject;
    if ((paramInt & 0x7F) == 2)
    {
      if (this.QgX != null) {
        this.QgX.setVisibility(0);
      }
      if (this.QgW != null)
      {
        this.QgW.setVisibility(8);
        AppMethodBeat.o(310368);
      }
    }
    else
    {
      if (this.QgX != null) {
        this.QgX.setVisibility(8);
      }
      if (this.QgW != null)
      {
        this.QgW.setVisibility(0);
        TextView localTextView = this.QgW;
        paramInt &= 0x7F;
        if (paramInt != 3) {
          break label142;
        }
        localObject = getContext().getString(b.j.sns_ad_living_over);
        localTextView.setText((CharSequence)localObject);
        localObject = this.QgW;
        if ((paramInt != 2) && (paramInt != 1)) {
          break label167;
        }
      }
    }
    label142:
    label167:
    for (paramInt = b.e.ad_live_status_living_background;; paramInt = b.e.ad_live_status_over_background)
    {
      ((TextView)localObject).setBackgroundResource(paramInt);
      AppMethodBeat.o(310368);
      return;
      if (paramInt == 1)
      {
        localObject = getContext().getString(b.j.sns_ad_living_preview);
        break;
      }
      localObject = "";
      break;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(310375);
    super.setVisibility(paramInt);
    if ((this.QgX != null) && (paramInt != 0)) {
      this.QgX.setVisibility(paramInt);
    }
    AppMethodBeat.o(310375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.LivingStatusLayout
 * JD-Core Version:    0.7.0.1
 */