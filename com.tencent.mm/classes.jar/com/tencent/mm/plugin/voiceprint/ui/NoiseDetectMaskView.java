package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class NoiseDetectMaskView
  extends RelativeLayout
{
  ProgressBar fsc = null;
  TextView kFl;
  private Context mContext = null;
  TextView pMe;
  private b pMf;
  private a pMg;
  
  public NoiseDetectMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mContext.getSystemService("layout_inflater");
    LayoutInflater.from(this.mContext).inflate(R.i.noise_mask_view, this);
    this.fsc = ((ProgressBar)findViewById(R.h.noise_detect_progress));
    this.kFl = ((TextView)findViewById(R.h.noise_detect_hint));
    this.pMe = ((TextView)findViewById(R.h.noise_detect_retry));
    this.pMe.setOnClickListener(new NoiseDetectMaskView.1(this));
    findViewById(R.h.left_btn).setOnClickListener(new NoiseDetectMaskView.2(this));
  }
  
  public void setOnCancelDetectCallback(a parama)
  {
    this.pMg = parama;
  }
  
  public void setOnClickRetryCallback(b paramb)
  {
    this.pMf = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void bPk();
  }
  
  public static abstract interface b
  {
    public abstract void bPl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView
 * JD-Core Version:    0.7.0.1
 */