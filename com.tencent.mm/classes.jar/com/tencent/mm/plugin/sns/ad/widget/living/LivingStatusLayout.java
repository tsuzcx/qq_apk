package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;

public class LivingStatusLayout
  extends FrameLayout
{
  private TextView JMt;
  private View JMu;
  
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
    AppMethodBeat.i(267738);
    super.onFinishInflate();
    try
    {
      this.JMt = ((TextView)findViewById(i.f.ad_live_status_content));
      this.JMu = findViewById(i.f.ad_live_finder_living_icon);
      this.JMu.setVisibility(8);
      AppMethodBeat.o(267738);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(267738);
    }
  }
  
  public void setLiveStatus(int paramInt)
  {
    AppMethodBeat.i(267739);
    Object localObject;
    if ((paramInt & 0x7F) == 2)
    {
      if (this.JMu != null) {
        this.JMu.setVisibility(0);
      }
      if (this.JMt != null)
      {
        this.JMt.setVisibility(8);
        AppMethodBeat.o(267739);
      }
    }
    else
    {
      if (this.JMu != null) {
        this.JMu.setVisibility(8);
      }
      if (this.JMt != null)
      {
        this.JMt.setVisibility(0);
        TextView localTextView = this.JMt;
        paramInt &= 0x7F;
        if (paramInt != 3) {
          break label142;
        }
        localObject = getContext().getString(i.j.sns_ad_living_over);
        localTextView.setText((CharSequence)localObject);
        localObject = this.JMt;
        if ((paramInt != 2) && (paramInt != 1)) {
          break label167;
        }
      }
    }
    label142:
    label167:
    for (paramInt = i.e.ad_live_status_living_background;; paramInt = i.e.ad_live_status_over_background)
    {
      ((TextView)localObject).setBackgroundResource(paramInt);
      AppMethodBeat.o(267739);
      return;
      if (paramInt == 1)
      {
        localObject = getContext().getString(i.j.sns_ad_living_preview);
        break;
      }
      localObject = "";
      break;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(267740);
    super.setVisibility(paramInt);
    if ((this.JMu != null) && (paramInt != 0)) {
      this.JMu.setVisibility(paramInt);
    }
    AppMethodBeat.o(267740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.LivingStatusLayout
 * JD-Core Version:    0.7.0.1
 */