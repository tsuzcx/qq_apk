package com.tencent.mm.wear.app.ui.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.wear.a.b.a;

public final class d
{
  private long aeb = 10000L;
  private e alG;
  private View alH;
  private TextView alI;
  private TextView alJ;
  private Runnable alK = new Runnable()
  {
    public final void run()
    {
      d.a(d.this).setVisibility(8);
      d.b(d.this).setVisibility(0);
    }
  };
  private View.OnClickListener alL = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      d.this.startLoading();
      if (d.c(d.this) != null) {
        d.c(d.this).onStart();
      }
    }
  };
  private View alg;
  
  public d(Activity paramActivity)
  {
    this.alg = paramActivity.findViewById(2131558499);
    this.alH = paramActivity.findViewById(2131558526);
    this.alH.setOnClickListener(this.alL);
    this.alI = ((TextView)paramActivity.findViewById(2131558525));
    this.alJ = ((TextView)paramActivity.findViewById(2131558521));
  }
  
  public final void X(String paramString)
  {
    this.alI.setText(paramString);
  }
  
  public final void Y(String paramString)
  {
    this.alJ.setText(paramString);
  }
  
  public final void a(e parame)
  {
    this.alG = parame;
  }
  
  public final void or()
  {
    this.alg.setVisibility(8);
    this.alH.setVisibility(8);
    a.amv.removeCallbacks(this.alK);
  }
  
  public final void setError()
  {
    this.alg.setVisibility(8);
    this.alH.setVisibility(0);
    a.amv.removeCallbacks(this.alK);
  }
  
  public final void setTimeout(long paramLong)
  {
    this.aeb = paramLong;
  }
  
  public final void startLoading()
  {
    this.alg.setVisibility(0);
    this.alH.setVisibility(8);
    a.amv.removeCallbacks(this.alK);
    a.amv.postDelayed(this.alK, this.aeb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */