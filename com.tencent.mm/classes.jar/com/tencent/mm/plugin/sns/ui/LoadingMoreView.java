package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class LoadingMoreView
  extends LinearLayout
{
  private Context context;
  private ImageView cxy;
  protected LinearLayout krq;
  protected LinearLayout krr;
  protected LinearLayout rHU;
  protected LinearLayout rHV;
  protected TextView rHW;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38281);
    this.context = paramContext;
    init();
    AppMethodBeat.o(38281);
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38280);
    this.context = paramContext;
    init();
    AppMethodBeat.o(38280);
  }
  
  private void init()
  {
    AppMethodBeat.i(38282);
    Object localObject = LayoutInflater.from(this.context).inflate(2130970848, this, true);
    this.cxy = ((ImageView)findViewById(2131822312));
    this.krq = ((LinearLayout)((View)localObject).findViewById(2131822311));
    this.krr = ((LinearLayout)((View)localObject).findViewById(2131822313));
    this.rHU = ((LinearLayout)((View)localObject).findViewById(2131828041));
    this.rHV = ((LinearLayout)((View)localObject).findViewById(2131828042));
    this.rHW = ((TextView)((View)localObject).findViewById(2131828043));
    this.krq.setVisibility(0);
    this.krr.setVisibility(8);
    this.rHU.setVisibility(8);
    this.rHV.setVisibility(8);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(1000L);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    this.cxy.startAnimation((Animation)localObject);
    AppMethodBeat.o(38282);
  }
  
  public final void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(138385);
    this.krq.setVisibility(8);
    this.rHU.setVisibility(8);
    this.krr.setVisibility(8);
    this.rHV.setVisibility(0);
    String str = paramString;
    if (bo.isNullOrNil(paramString))
    {
      if (paramInt != 2001) {
        break label83;
      }
      str = getContext().getResources().getString(2131303935);
    }
    for (;;)
    {
      this.rHW.setText(str);
      AppMethodBeat.o(138385);
      return;
      label83:
      if (paramInt == 2003)
      {
        str = getContext().getResources().getString(2131303786);
      }
      else if (paramInt == 2004)
      {
        str = getContext().getResources().getString(2131303937);
      }
      else if (paramInt == 2005)
      {
        str = getContext().getResources().getString(2131303936);
      }
      else
      {
        str = paramString;
        if (paramInt == 203) {
          str = getContext().getResources().getString(2131303969);
        }
      }
    }
  }
  
  public final void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(38283);
    this.krq.setVisibility(8);
    if (paramBoolean)
    {
      this.rHU.setVisibility(0);
      this.krr.setVisibility(8);
    }
    for (;;)
    {
      this.rHV.setVisibility(8);
      AppMethodBeat.o(38283);
      return;
      this.krr.setVisibility(0);
      this.rHU.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */