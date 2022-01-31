package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public abstract class i
{
  protected ProgressDialog dnm = null;
  protected TextView gSy;
  GestureDetector jEK;
  protected Point jOD;
  protected boolean miw;
  protected int nLA = 20;
  protected i.b nLB;
  protected int nLC;
  protected boolean nLD;
  protected ah nLE = new i.1(this);
  protected long nLt;
  protected Rect nLu;
  protected b nLv;
  protected Point nLw;
  protected int nLx;
  protected int nLy;
  protected int nLz = 40;
  
  public i(i.b paramb, Point paramPoint)
  {
    this.nLB = paramb;
    this.nLw = paramPoint;
  }
  
  public i(i.b paramb, Point paramPoint, byte paramByte)
  {
    this.nLB = paramb;
    this.nLw = paramPoint;
    this.nLz = 50;
  }
  
  protected Rect D(boolean paramBoolean1, boolean paramBoolean2)
  {
    int n;
    int i1;
    int m;
    int k;
    int j;
    int i;
    if ((this.nLu == null) || (paramBoolean1))
    {
      n = this.nLw.x;
      i1 = this.nLw.y;
      if (paramBoolean2) {
        break label162;
      }
      m = n / 2 - this.nLx / 2;
      k = n / 2 + this.nLx / 2;
      j = i1 / 2 - this.nLy / 2;
      i = this.nLy + j;
    }
    for (;;)
    {
      y.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      this.nLu = new Rect(m, j, k, i);
      return this.nLu;
      label162:
      if (n < i1)
      {
        m = i1 / 2 - this.nLx / 2;
        k = i1 / 2 + this.nLx / 2;
        j = BackwardSupportUtil.b.b(this.nLB.getContext(), this.nLA);
        i = this.nLy + j;
      }
      else
      {
        m = n / 2 - this.nLx / 2;
        k = n / 2 + this.nLx / 2;
        j = BackwardSupportUtil.b.b(this.nLB.getContext(), this.nLA);
        i = this.nLy + j;
      }
    }
  }
  
  protected void a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    y.i("MicroMsg.scanner.ScanMode", "decode count:" + m.nHb.nHe);
    if (bxp() != null)
    {
      bxp().a(paramArrayOfByte, paramPoint, paramInt, paramRect);
      if (m.nHb.nHe == 30) {
        this.nLB.bxH();
      }
    }
  }
  
  public final i.b bxQ()
  {
    return this.nLB;
  }
  
  protected abstract void bxo();
  
  protected abstract b bxp();
  
  protected abstract int bxq();
  
  protected abstract int bxr();
  
  protected abstract void bxs();
  
  protected abstract boolean bxt();
  
  protected abstract boolean bxu();
  
  protected void cK(View paramView) {}
  
  protected final double dG(int paramInt1, int paramInt2)
  {
    Activity localActivity = this.nLB.getContext();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localActivity.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    double d = localDisplayMetrics.densityDpi / 160.0D;
    y.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", new Object[] { Double.valueOf(d) });
    int j = (int)(this.nLw.x * 0.85F);
    int i = (int)(this.nLw.y * 0.85F);
    if (((this instanceof j)) || ((this instanceof c)))
    {
      j = (int)(this.nLw.y * 0.85F);
      i = (int)(this.nLw.x * 0.85F);
    }
    for (;;)
    {
      float f2 = 1.0F;
      float f1;
      if (d > 1.2D)
      {
        f1 = f2;
        if (this.nLw.x + this.nLw.y > 3000)
        {
          f1 = f2;
          if (d < 2.4D) {
            f1 = 1.6F;
          }
        }
      }
      for (;;)
      {
        this.nLx = BackwardSupportUtil.b.b(this.nLB.getContext(), paramInt1 * f1);
        this.nLy = BackwardSupportUtil.b.b(this.nLB.getContext(), paramInt2 * f1);
        f2 = f1;
        if (this.nLx <= j) {
          if (this.nLy <= i) {
            break label425;
          }
        }
        for (f2 = f1; (this.nLx > j) || (this.nLy > i); f2 -= 0.1F)
        {
          this.nLx = BackwardSupportUtil.b.b(this.nLB.getContext(), paramInt1 * f2);
          this.nLy = BackwardSupportUtil.b.b(this.nLB.getContext(), paramInt2 * f2);
        }
        if ((this.nLw != null) && (this.nLw.x + this.nLw.y > 1560)) {
          f1 = 1.7F;
        } else if ((this.nLw != null) && (this.nLw.x + this.nLw.y > 1460)) {
          f1 = 1.1F;
        } else {
          f1 = 0.9F;
        }
      }
      y.i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", new Object[] { Float.valueOf(f2) });
      label425:
      if (this.nLx % 2 == 1) {
        this.nLx += 1;
      }
      if (this.nLy % 2 == 1) {
        this.nLy += 1;
      }
      y.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", new Object[] { Integer.valueOf(this.nLx), Integer.valueOf(this.nLy), this.nLw });
      return d;
    }
  }
  
  public final void g(Point paramPoint)
  {
    this.nLw = paramPoint;
  }
  
  protected void h(Point paramPoint)
  {
    this.jOD = paramPoint;
  }
  
  protected Rect iA(boolean paramBoolean)
  {
    return D(true, paramBoolean);
  }
  
  protected void iB(boolean paramBoolean)
  {
    this.miw = paramBoolean;
  }
  
  public final void iC(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.gSy != null)
    {
      localTextView = this.gSy;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  protected final void iz(boolean paramBoolean)
  {
    if (this.gSy == null) {
      return;
    }
    if (paramBoolean)
    {
      this.gSy.setVisibility(4);
      this.nLE.sendEmptyMessageDelayed(1, 210L);
      return;
    }
    this.nLE.removeMessages(1);
    this.gSy.setVisibility(4);
  }
  
  protected abstract void j(Rect paramRect);
  
  protected abstract void onDestroy();
  
  protected void onPause()
  {
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
  }
  
  protected abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i
 * JD-Core Version:    0.7.0.1
 */