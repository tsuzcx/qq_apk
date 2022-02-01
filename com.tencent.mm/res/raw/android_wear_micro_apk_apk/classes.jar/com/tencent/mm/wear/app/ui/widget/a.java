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
  private ImageView aic;
  private TextView ajI;
  private TextView ajn;
  private TextView akO;
  private TextView als;
  private TextView alt;
  private View alu;
  private TextView alv;
  private ImageButton alw;
  private View.OnClickListener alx;
  private View view;
  
  public a(MMActivity paramMMActivity)
  {
    if (MMActivity.isRect()) {}
    for (this.view = paramMMActivity.getLayoutInflater().inflate(2130903057, null, false);; this.view = paramMMActivity.getLayoutInflater().inflate(2130903058, null, false))
    {
      this.view.setLayoutParams(new AbsListView.LayoutParams(MMActivity.nP(), MMActivity.nP()));
      this.view.setBackgroundResource(2130837587);
      this.alu = this.view.findViewById(2131558460);
      this.aic = ((ImageView)this.view.findViewById(2131558443));
      this.ajn = ((TextView)this.view.findViewById(2131558461));
      this.akO = ((TextView)this.view.findViewById(2131558462));
      this.ajI = ((TextView)this.view.findViewById(2131558466));
      this.alt = ((TextView)this.view.findViewById(2131558467));
      this.alv = ((TextView)this.view.findViewById(2131558465));
      this.als = ((TextView)this.view.findViewById(2131558463));
      this.alw = ((ImageButton)this.view.findViewById(2131558464));
      this.alw.setOnClickListener(new View.OnClickListener()
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
    this.alw.setVisibility(8);
    if (paramLong > 0L)
    {
      this.alu.setBackgroundResource(2130837597);
      this.ajI.setText(String.format("%.2f", new Object[] { Float.valueOf((float)paramLong / 100.0F) }));
      this.alt.setVisibility(0);
      this.alv.setText(paramString);
    }
    for (;;)
    {
      if (MMActivity.isRect()) {
        this.akO.setVisibility(8);
      }
      return;
      this.alu.setBackgroundResource(2130837597);
      this.als.setVisibility(0);
      this.alv.setText(paramString);
    }
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.alx = paramOnClickListener;
  }
  
  public final void a(n paramn)
  {
    Object localObject;
    if (paramn.XI.endsWith("@chatroom"))
    {
      localObject = paramn.Xs.split("​");
      this.ajn.setText(localObject[0]);
      this.akO.setText(localObject[1]);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.wear.app.c.a();
      ((com.tencent.mm.wear.app.c.a)localObject).agm = this.aic;
      ((com.tencent.mm.wear.app.c.a)localObject).agn = 2130837531;
      ((com.tencent.mm.wear.app.c.a)localObject).width = 30;
      ((com.tencent.mm.wear.app.c.a)localObject).height = 30;
      ((com.tencent.mm.wear.app.c.a)localObject).type = 3;
      ((com.tencent.mm.wear.app.c.a)localObject).agi = paramn.XI;
      ((com.tencent.mm.wear.app.c.a)localObject).agp = 3;
      h.mR().a((com.tencent.mm.wear.app.c.a)localObject);
      return;
      this.ajn.setText(paramn.Xr);
      this.akO.setText(paramn.Xs);
    }
  }
  
  public final View om()
  {
    return this.view;
  }
  
  public final void on()
  {
    this.alw.setBackgroundResource(2130837544);
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.alw.getBackground();
    if (localAnimationDrawable != null) {
      localAnimationDrawable.start();
    }
  }
  
  public final void oo()
  {
    if (this.alw == null) {}
    while (!(this.alw.getBackground() instanceof AnimationDrawable)) {
      return;
    }
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.alw.getBackground();
    if (localAnimationDrawable != null) {
      localAnimationDrawable.stop();
    }
    this.alw.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */