package com.tencent.mm.wear.app.ui.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.wear.a.b.a;

public final class d
{
  private long aaA = 10000L;
  private View ahE;
  private e aie;
  private View aif;
  private TextView aig;
  private TextView aih;
  private Runnable aii = new Runnable()
  {
    public final void run()
    {
      d.a(d.this).setVisibility(8);
      d.b(d.this).setVisibility(0);
    }
  };
  private View.OnClickListener aij = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      d.this.startLoading();
      if (d.c(d.this) != null) {
        d.c(d.this).onStart();
      }
    }
  };
  
  public d(Activity paramActivity)
  {
    this.ahE = paramActivity.findViewById(2131558498);
    this.aif = paramActivity.findViewById(2131558525);
    this.aif.setOnClickListener(this.aij);
    this.aig = ((TextView)paramActivity.findViewById(2131558524));
    this.aih = ((TextView)paramActivity.findViewById(2131558520));
  }
  
  public final void Q(String paramString)
  {
    this.aig.setText(paramString);
  }
  
  public final void R(String paramString)
  {
    this.aih.setText(paramString);
  }
  
  public final void a(e parame)
  {
    this.aie = parame;
  }
  
  public final void nD()
  {
    this.ahE.setVisibility(8);
    this.aif.setVisibility(8);
    a.aiT.removeCallbacks(this.aii);
  }
  
  public final void setError()
  {
    this.ahE.setVisibility(8);
    this.aif.setVisibility(0);
    a.aiT.removeCallbacks(this.aii);
  }
  
  public final void setTimeout(long paramLong)
  {
    this.aaA = paramLong;
  }
  
  public final void startLoading()
  {
    this.ahE.setVisibility(0);
    this.aif.setVisibility(8);
    a.aiT.removeCallbacks(this.aii);
    a.aiT.postDelayed(this.aii, this.aaA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */