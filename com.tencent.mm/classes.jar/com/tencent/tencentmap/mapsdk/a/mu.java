package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ZoomControls;
import com.tencent.map.lib.d;

public class mu
  implements mp
{
  private Context a;
  private ZoomControls b;
  private mv c = null;
  private ViewGroup d;
  private mp.b e = mp.b.c;
  private oo.a f = null;
  private ma g;
  private int h = 0;
  
  public mu(Context paramContext, ma paramma)
  {
    this.a = paramContext;
    this.g = paramma;
    a(paramContext);
    c();
  }
  
  private void a(Context paramContext)
  {
    this.c = new mv(paramContext);
    this.c.setVisibility(8);
    b();
    try
    {
      this.b = new ZoomControls(paramContext);
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.b.measure(i, j);
      this.h = this.b.getMeasuredHeight();
      this.b.setVisibility(8);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void b()
  {
    Bitmap localBitmap1 = lq.b(lq.b(this.a, "location_enable.png"));
    Bitmap localBitmap2 = lq.b(lq.b(this.a, "location_state_normal.png"));
    Bitmap localBitmap3 = lq.b(lq.b(this.a, "location_state_selected.png"));
    this.c.setScaleType(ImageView.ScaleType.CENTER);
    this.c.setImageBitmap(localBitmap1);
    this.c.a(this.a, localBitmap2, localBitmap3);
  }
  
  private void c()
  {
    if (this.b != null)
    {
      this.b.setOnZoomInClickListener(new mu.1(this));
      this.b.setOnZoomOutClickListener(new mu.2(this));
    }
    this.c.setOnClickListener(new mu.3(this));
  }
  
  private FrameLayout.LayoutParams d()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    switch (mu.4.a[this.e.ordinal()])
    {
    default: 
      d.b("Unknown position:" + this.e);
      return localLayoutParams;
    case 1: 
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = 5;
      localLayoutParams.leftMargin = 5;
      return localLayoutParams;
    case 2: 
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = 5;
      return localLayoutParams;
    case 3: 
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = 5;
      localLayoutParams.rightMargin = 5;
      return localLayoutParams;
    case 4: 
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = 5;
      localLayoutParams.leftMargin = 5;
      return localLayoutParams;
    case 5: 
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = 5;
      return localLayoutParams;
    }
    localLayoutParams.gravity = 53;
    localLayoutParams.topMargin = 5;
    localLayoutParams.rightMargin = 5;
    return localLayoutParams;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(oo.a parama)
  {
    this.f = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    ZoomControls localZoomControls;
    if (this.b != null)
    {
      localZoomControls = this.b;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localZoomControls.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b != null)
    {
      this.b.setIsZoomInEnabled(paramBoolean1);
      this.b.setIsZoomOutEnabled(paramBoolean2);
    }
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (this.b == null) || (this.c == null)) {
      return false;
    }
    this.d = paramViewGroup;
    FrameLayout.LayoutParams localLayoutParams = d();
    if (paramViewGroup.indexOfChild(this.b) < 0)
    {
      paramViewGroup.addView(this.b, localLayoutParams);
      localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = (this.h + 5);
      localLayoutParams.rightMargin = 5;
      if (paramViewGroup.indexOfChild(this.c) >= 0) {
        break label117;
      }
      paramViewGroup.addView(this.c, localLayoutParams);
    }
    for (;;)
    {
      return true;
      paramViewGroup.updateViewLayout(this.b, localLayoutParams);
      break;
      label117:
      paramViewGroup.updateViewLayout(this.c, localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mu
 * JD-Core Version:    0.7.0.1
 */