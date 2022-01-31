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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;

public class LoadingMoreView
  extends LinearLayout
{
  private ImageView bQf;
  private Context context;
  protected LinearLayout iqi;
  protected LinearLayout iqj;
  protected LinearLayout oQi;
  protected LinearLayout oQj;
  protected TextView oQk;
  
  public LoadingMoreView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    init();
  }
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    Object localObject = LayoutInflater.from(this.context).inflate(i.g.sns_next_loading, this, true);
    this.bQf = ((ImageView)findViewById(i.f.album_next_progress));
    this.iqi = ((LinearLayout)((View)localObject).findViewById(i.f.loading_more_state));
    this.iqj = ((LinearLayout)((View)localObject).findViewById(i.f.loading_end));
    this.oQi = ((LinearLayout)((View)localObject).findViewById(i.f.strange_limit));
    this.oQj = ((LinearLayout)((View)localObject).findViewById(i.f.recent_limit));
    this.oQk = ((TextView)((View)localObject).findViewById(i.f.recent_limit_text));
    this.iqi.setVisibility(0);
    this.iqj.setVisibility(8);
    this.oQi.setVisibility(8);
    this.oQj.setVisibility(8);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(1000L);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    this.bQf.startAnimation((Animation)localObject);
  }
  
  public final void jq(boolean paramBoolean)
  {
    this.iqi.setVisibility(8);
    if (paramBoolean)
    {
      this.oQi.setVisibility(0);
      this.iqj.setVisibility(8);
    }
    for (;;)
    {
      this.oQj.setVisibility(8);
      return;
      this.iqj.setVisibility(0);
      this.oQi.setVisibility(8);
    }
  }
  
  public final void yA(int paramInt)
  {
    this.iqi.setVisibility(8);
    this.oQi.setVisibility(8);
    this.iqj.setVisibility(8);
    this.oQj.setVisibility(0);
    if (paramInt == 2001) {
      this.oQk.setText(getContext().getResources().getString(i.j.sns_recent_half_year_tip));
    }
    do
    {
      return;
      if (paramInt == 2003)
      {
        this.oQk.setText(getContext().getResources().getString(i.j.sns_close));
        return;
      }
    } while (paramInt != 2004);
    this.oQk.setText(getContext().getResources().getString(i.j.sns_recent_three_day_tip));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */