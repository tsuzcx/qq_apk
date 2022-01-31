package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d;
import com.tencent.mm.ci.d.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public final class d$a
{
  Context context;
  ProgressBar cxA;
  ImageView cxy;
  View mView;
  TextView nxi;
  FrameLayout zgE;
  WindowManager zgF;
  WindowManager.LayoutParams zgG;
  private ViewGroup.LayoutParams zgH;
  boolean zgY;
  d.b zgZ;
  com.tencent.mm.ci.d.a zha;
  int zhb;
  ak zhc;
  
  public d$a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(29985);
    this.zgY = false;
    this.zgZ = new d.a.1(this);
    this.zhb = 0;
    this.zhc = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29984);
        if (d.a.this.nxi.getVisibility() != 0)
        {
          d.a.this.zhb = 0;
          AppMethodBeat.o(29984);
          return;
        }
        d.a locala = d.a.this;
        locala.zhb += 1;
        d.a.this.dDz();
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(29984);
      }
    };
    if ((this.zgE != null) && (this.zgF != null))
    {
      AppMethodBeat.o(29985);
      return;
    }
    d.dAt().ySV = new WeakReference(this.zgZ);
    this.nxi = ((TextView)paramView.findViewById(2131822569));
    this.cxy = ((ImageView)paramView.findViewById(2131820875));
    ((ImageView)paramView.findViewById(2131828620)).setOnClickListener(new d.a.2(this));
    this.cxA = ((ProgressBar)paramView.findViewById(2131828619));
    this.cxA.setVisibility(8);
    this.context = paramContext;
    this.zgG = new WindowManager.LayoutParams();
    this.zgG.height = -2;
    this.zgG.width = -2;
    this.zgF = ((WindowManager)paramContext.getSystemService("window"));
    this.zgG.x = 0;
    this.zgG.y = 0;
    this.zgG.flags = 40;
    this.zgG.type = 2002;
    this.mView = paramView;
    this.nxi.setVisibility(8);
    this.zgG.gravity = 51;
    this.zgG.format = 1;
    this.zgE = new FrameLayout(paramContext);
    this.zgE.setPadding(4, 4, 4, 4);
    this.zgH = new ViewGroup.LayoutParams(-2, -2);
    this.zgE.addView(this.mView, this.zgH);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.zgE.setOnTouchListener(new d.a.3(this, paramContext));
    AppMethodBeat.o(29985);
  }
  
  final void dDz()
  {
    AppMethodBeat.i(29987);
    this.nxi.setText(this.zhb);
    this.zhc.sendEmptyMessageDelayed(0, 1000L);
    AppMethodBeat.o(29987);
  }
  
  final void id(Context paramContext)
  {
    boolean bool = false;
    AppMethodBeat.i(29986);
    this.cxy.setVisibility(0);
    this.cxA.setVisibility(4);
    if (!this.zgY) {
      bool = true;
    }
    this.zgY = bool;
    this.cxy.setBackgroundDrawable(paramContext.getResources().getDrawable(2130840619));
    this.nxi.setVisibility(8);
    AppMethodBeat.o(29986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d.a
 * JD-Core Version:    0.7.0.1
 */