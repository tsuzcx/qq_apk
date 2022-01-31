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
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class i
{
  protected ProgressDialog eeN = null;
  protected TextView ivt;
  GestureDetector lOj;
  protected Point miT;
  protected boolean oIC;
  protected int qwn = 0;
  protected long qyY;
  protected Rect qyZ;
  protected b qza;
  protected Point qzb;
  protected int qzc;
  protected int qzd;
  protected int qze = 40;
  protected int qzf = 20;
  protected i.b qzg;
  protected int qzh;
  protected boolean qzi;
  protected boolean qzj = false;
  protected ak qzk = new i.1(this);
  protected String typeName = "";
  
  public i(i.b paramb, Point paramPoint)
  {
    this.qzg = paramb;
    this.qzb = paramPoint;
  }
  
  public i(i.b paramb, Point paramPoint, byte paramByte)
  {
    this.qzg = paramb;
    this.qzb = paramPoint;
    this.qze = 50;
  }
  
  public final void CI(int paramInt)
  {
    this.qwn = paramInt;
  }
  
  protected Rect H(boolean paramBoolean1, boolean paramBoolean2)
  {
    int n;
    int i1;
    int m;
    int k;
    int j;
    int i;
    if ((this.qyZ == null) || (paramBoolean1))
    {
      n = this.qzb.x;
      i1 = this.qzb.y;
      if (paramBoolean2) {
        break label162;
      }
      m = n / 2 - this.qzc / 2;
      k = n / 2 + this.qzc / 2;
      j = i1 / 2 - this.qzd / 2;
      i = this.qzd + j;
    }
    for (;;)
    {
      ab.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      this.qyZ = new Rect(m, j, k, i);
      return this.qyZ;
      label162:
      if (n < i1)
      {
        m = i1 / 2 - this.qzc / 2;
        k = i1 / 2 + this.qzc / 2;
        j = BackwardSupportUtil.b.b(this.qzg.getContext(), this.qzf);
        i = this.qzd + j;
      }
      else
      {
        m = n / 2 - this.qzc / 2;
        k = n / 2 + this.qzc / 2;
        j = BackwardSupportUtil.b.b(this.qzg.getContext(), this.qzf);
        i = this.qzd + j;
      }
    }
  }
  
  protected void a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    ab.i("MicroMsg.scanner.ScanMode", "decode count:" + n.qux.quA);
    if (cim() != null)
    {
      cim().a(paramArrayOfByte, paramPoint, paramInt, paramRect);
      if (n.qux.quA == 30) {
        this.qzg.ciI();
      }
    }
  }
  
  public final int ciR()
  {
    return this.qwn;
  }
  
  protected abstract void cil();
  
  protected abstract b cim();
  
  protected abstract int cin();
  
  protected abstract int cio();
  
  protected abstract void cip();
  
  protected abstract boolean ciq();
  
  protected abstract boolean cir();
  
  protected final void dA(View paramView)
  {
    this.lOj = new GestureDetector(new i.2(this));
    paramView.setOnTouchListener(new i.3(this));
  }
  
  protected void dz(View paramView) {}
  
  public final void f(Point paramPoint)
  {
    this.qzb = paramPoint;
  }
  
  protected final double fo(int paramInt1, int paramInt2)
  {
    Activity localActivity = this.qzg.getContext();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localActivity.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    double d = localDisplayMetrics.densityDpi / 160.0D;
    ab.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", new Object[] { Double.valueOf(d) });
    int j = (int)(this.qzb.x * 0.85F);
    int i = (int)(this.qzb.y * 0.85F);
    if (((this instanceof j)) || ((this instanceof c)))
    {
      j = (int)(this.qzb.y * 0.85F);
      i = (int)(this.qzb.x * 0.85F);
    }
    for (;;)
    {
      float f2 = 1.0F;
      float f1;
      if (d > 1.2D)
      {
        f1 = f2;
        if (this.qzb.x + this.qzb.y > 3000)
        {
          f1 = f2;
          if (d < 2.4D) {
            f1 = 1.6F;
          }
        }
      }
      for (;;)
      {
        this.qzc = BackwardSupportUtil.b.b(this.qzg.getContext(), paramInt1 * f1);
        this.qzd = BackwardSupportUtil.b.b(this.qzg.getContext(), paramInt2 * f1);
        f2 = f1;
        if (this.qzc <= j) {
          if (this.qzd <= i) {
            break label425;
          }
        }
        for (f2 = f1; (this.qzc > j) || (this.qzd > i); f2 -= 0.1F)
        {
          this.qzc = BackwardSupportUtil.b.b(this.qzg.getContext(), paramInt1 * f2);
          this.qzd = BackwardSupportUtil.b.b(this.qzg.getContext(), paramInt2 * f2);
        }
        if ((this.qzb != null) && (this.qzb.x + this.qzb.y > 1560)) {
          f1 = 1.7F;
        } else if ((this.qzb != null) && (this.qzb.x + this.qzb.y > 1460)) {
          f1 = 1.1F;
        } else {
          f1 = 0.9F;
        }
      }
      ab.i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", new Object[] { Float.valueOf(f2) });
      label425:
      if (this.qzc % 2 == 1) {
        this.qzc += 1;
      }
      if (this.qzd % 2 == 1) {
        this.qzd += 1;
      }
      ab.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", new Object[] { Integer.valueOf(this.qzc), Integer.valueOf(this.qzd), this.qzb });
      return d;
    }
  }
  
  protected void g(Point paramPoint)
  {
    this.miT = paramPoint;
  }
  
  protected abstract void k(Rect paramRect);
  
  protected final void kC(boolean paramBoolean)
  {
    if (this.ivt == null) {
      return;
    }
    if (paramBoolean)
    {
      this.ivt.setVisibility(4);
      this.qzk.sendEmptyMessageDelayed(1, 210L);
      return;
    }
    this.qzk.removeMessages(1);
    this.ivt.setVisibility(4);
  }
  
  protected Rect kD(boolean paramBoolean)
  {
    return H(true, paramBoolean);
  }
  
  protected void kE(boolean paramBoolean)
  {
    this.oIC = paramBoolean;
  }
  
  public final void kF(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.ivt != null)
    {
      localTextView = this.ivt;
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
  
  public final void kG(boolean paramBoolean)
  {
    this.qzj = paramBoolean;
  }
  
  protected abstract void onDestroy();
  
  protected void onPause()
  {
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
  }
  
  protected abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i
 * JD-Core Version:    0.7.0.1
 */