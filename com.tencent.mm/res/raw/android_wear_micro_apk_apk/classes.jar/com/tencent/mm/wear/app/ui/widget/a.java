package com.tencent.mm.wear.app.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.n;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.c.b;
import com.tencent.mm.wear.app.ui.MMActivity;

public final class a
{
  private ImageView aeA;
  private TextView afL;
  private TextView agg;
  private TextView ahQ;
  private TextView ahR;
  private View ahS;
  private TextView ahT;
  private ImageButton ahU;
  private View.OnClickListener ahV;
  private TextView ahm;
  private View view;
  
  public a(MMActivity paramMMActivity)
  {
    if (MMActivity.isRect()) {}
    for (this.view = paramMMActivity.getLayoutInflater().inflate(2130903057, null, false);; this.view = paramMMActivity.getLayoutInflater().inflate(2130903058, null, false))
    {
      this.view.setLayoutParams(new AbsListView.LayoutParams(MMActivity.nc(), MMActivity.nc()));
      this.view.setBackgroundResource(2130837587);
      this.ahS = this.view.findViewById(2131558459);
      this.aeA = ((ImageView)this.view.findViewById(2131558442));
      this.afL = ((TextView)this.view.findViewById(2131558460));
      this.ahm = ((TextView)this.view.findViewById(2131558461));
      this.agg = ((TextView)this.view.findViewById(2131558465));
      this.ahR = ((TextView)this.view.findViewById(2131558466));
      this.ahT = ((TextView)this.view.findViewById(2131558464));
      this.ahQ = ((TextView)this.view.findViewById(2131558462));
      this.ahU = ((ImageButton)this.view.findViewById(2131558463));
      this.ahU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (a.a(a.this) != null) {
            a.a(a.this).onClick(paramAnonymousView);
          }
        }
      });
      return;
    }
  }
  
  public final void a(long paramLong, String paramString)
  {
    this.ahU.setVisibility(8);
    if (paramLong > 0L)
    {
      this.ahS.setBackgroundResource(2130837597);
      this.agg.setText(String.format("%.2f", new Object[] { Float.valueOf((float)paramLong / 100.0F) }));
      this.ahR.setVisibility(0);
      this.ahT.setText(paramString);
    }
    for (;;)
    {
      if (MMActivity.isRect()) {
        this.ahm.setVisibility(8);
      }
      return;
      this.ahS.setBackgroundResource(2130837597);
      this.ahQ.setVisibility(0);
      this.ahT.setText(paramString);
    }
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.ahV = paramOnClickListener;
  }
  
  public final void a(n paramn)
  {
    Object localObject;
    if (paramn.VN.endsWith("@chatroom"))
    {
      localObject = paramn.Vx.split("​");
      this.afL.setText(localObject[0]);
      this.ahm.setText(localObject[1]);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.wear.app.c.a();
      ((com.tencent.mm.wear.app.c.a)localObject).acL = this.aeA;
      ((com.tencent.mm.wear.app.c.a)localObject).acM = 2130837531;
      ((com.tencent.mm.wear.app.c.a)localObject).width = 30;
      ((com.tencent.mm.wear.app.c.a)localObject).height = 30;
      ((com.tencent.mm.wear.app.c.a)localObject).type = 3;
      ((com.tencent.mm.wear.app.c.a)localObject).acH = paramn.VN;
      ((com.tencent.mm.wear.app.c.a)localObject).acO = 3;
      h.me().a((com.tencent.mm.wear.app.c.a)localObject);
      return;
      this.afL.setText(paramn.Vw);
      this.ahm.setText(paramn.Vx);
    }
  }
  
  public final void nA()
  {
    if (this.ahU == null) {}
    while (!(this.ahU.getBackground() instanceof AnimationDrawable)) {
      return;
    }
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.ahU.getBackground();
    if (localAnimationDrawable != null) {
      localAnimationDrawable.stop();
    }
    this.ahU.setVisibility(8);
  }
  
  public final View ny()
  {
    return this.view;
  }
  
  public final void nz()
  {
    this.ahU.setBackgroundResource(2130837544);
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.ahU.getBackground();
    if (localAnimationDrawable != null) {
      localAnimationDrawable.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */