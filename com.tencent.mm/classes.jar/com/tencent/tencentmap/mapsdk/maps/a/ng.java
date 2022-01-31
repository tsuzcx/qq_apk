package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ZoomControls;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bg.a;

public class ng
  implements nb
{
  private Context a;
  private ZoomControls b;
  private nh c;
  private ViewGroup d;
  private nb.b e;
  private bg.a f;
  private kx g;
  private int h;
  
  public ng(Context paramContext, kx paramkx)
  {
    AppMethodBeat.i(149455);
    this.c = null;
    this.e = nb.b.c;
    this.f = null;
    this.h = 0;
    this.a = paramContext;
    this.g = paramkx;
    a(paramContext);
    d();
    AppMethodBeat.o(149455);
  }
  
  private void a(Context paramContext)
  {
    AppMethodBeat.i(149459);
    this.c = new nh(paramContext);
    this.c.setVisibility(8);
    c();
    try
    {
      this.b = new ZoomControls(paramContext);
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.b.measure(i, j);
      this.h = this.b.getMeasuredHeight();
      this.b.setVisibility(8);
      AppMethodBeat.o(149459);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(149459);
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(149460);
    Bitmap localBitmap1 = ka.b(ka.b(this.a, "location_enable.png"));
    Bitmap localBitmap2 = ka.b(ka.b(this.a, "location_state_normal.png"));
    Bitmap localBitmap3 = ka.b(ka.b(this.a, "location_state_selected.png"));
    this.c.setScaleType(ImageView.ScaleType.CENTER);
    this.c.setImageBitmap(localBitmap1);
    this.c.a(this.a, localBitmap2, localBitmap3);
    AppMethodBeat.o(149460);
  }
  
  private void d()
  {
    AppMethodBeat.i(149461);
    if (this.b != null)
    {
      this.b.setOnZoomInClickListener(new ng.1(this));
      this.b.setOnZoomOutClickListener(new ng.2(this));
    }
    this.c.setOnClickListener(new ng.3(this));
    AppMethodBeat.o(149461);
  }
  
  private FrameLayout.LayoutParams e()
  {
    AppMethodBeat.i(149466);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    switch (ng.4.a[this.e.ordinal()])
    {
    default: 
      d.b("Unknown position:" + this.e);
    }
    for (;;)
    {
      AppMethodBeat.o(149466);
      return localLayoutParams;
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = 5;
      localLayoutParams.leftMargin = 5;
      continue;
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = 5;
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = 5;
      localLayoutParams.rightMargin = 5;
      continue;
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = 5;
      localLayoutParams.leftMargin = 5;
      continue;
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = 5;
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = 5;
      localLayoutParams.rightMargin = 5;
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(149456);
    if (this.c != null) {
      this.c.a();
    }
    AppMethodBeat.o(149456);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(bg.a parama)
  {
    this.f = parama;
  }
  
  public void a(nb.b paramb)
  {
    AppMethodBeat.i(149458);
    if (this.e != paramb)
    {
      this.e = paramb;
      a(this.d);
    }
    AppMethodBeat.o(149458);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149463);
    ZoomControls localZoomControls;
    if (this.b != null)
    {
      localZoomControls = this.b;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = 4)
    {
      localZoomControls.setVisibility(i);
      AppMethodBeat.o(149463);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(149462);
    if (this.b != null)
    {
      this.b.setIsZoomInEnabled(paramBoolean1);
      this.b.setIsZoomOutEnabled(paramBoolean2);
    }
    AppMethodBeat.o(149462);
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(149457);
    if ((paramViewGroup == null) || (this.b == null) || (this.c == null))
    {
      AppMethodBeat.o(149457);
      return false;
    }
    this.d = paramViewGroup;
    FrameLayout.LayoutParams localLayoutParams = e();
    if (paramViewGroup.indexOfChild(this.b) < 0)
    {
      paramViewGroup.addView(this.b, localLayoutParams);
      localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = (this.h + 5);
      localLayoutParams.rightMargin = 5;
      if (paramViewGroup.indexOfChild(this.c) >= 0) {
        break label132;
      }
      paramViewGroup.addView(this.c, localLayoutParams);
    }
    for (;;)
    {
      AppMethodBeat.o(149457);
      return true;
      paramViewGroup.updateViewLayout(this.b, localLayoutParams);
      break;
      label132:
      paramViewGroup.updateViewLayout(this.c, localLayoutParams);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(149465);
    nh localnh = this.c;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localnh.setVisibility(i);
      AppMethodBeat.o(149465);
      return;
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(149464);
    if (this.b == null)
    {
      AppMethodBeat.o(149464);
      return false;
    }
    if (this.b.getVisibility() == 0)
    {
      AppMethodBeat.o(149464);
      return true;
    }
    AppMethodBeat.o(149464);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ng
 * JD-Core Version:    0.7.0.1
 */