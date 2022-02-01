package com.tencent.mm.plugin.webview.ui.tools.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private View lOF;
  private int lOH;
  private ViewGroup.LayoutParams lOI;
  private ViewGroup lOJ;
  private final Set<b> lOK;
  private int lPa;
  private int lPb;
  private WindowManager.LayoutParams lPc;
  private Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(189249);
    this.lOK = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(189249);
  }
  
  private void bsF()
  {
    AppMethodBeat.i(189255);
    Iterator localIterator = this.lOK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bdP();
    }
    AppMethodBeat.o(189255);
  }
  
  private void bsG()
  {
    AppMethodBeat.i(189256);
    Iterator localIterator = this.lOK.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Cb();
    }
    AppMethodBeat.o(189256);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(189251);
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      ac.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(189251);
      return;
    }
    View localView = this.lOF;
    this.lOF = paramView;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    if (localView == null)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.lOJ = ((ViewGroup)paramView.getParent());
        this.lOH = this.lOJ.indexOfChild(paramView);
        this.lOI = paramView.getLayoutParams();
        this.lOJ.removeView(paramView);
        localViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        localViewGroup.bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
      }
    }
    else
    {
      paramView = (ViewGroup)localActivity.getWindow().getDecorView();
      if (localView == null) {
        this.lPa = paramView.getSystemUiVisibility();
      }
      if (!d.la(19)) {
        break label368;
      }
      paramView.setSystemUiVisibility(2);
      label197:
      if (localView == null)
      {
        this.lPc = new WindowManager.LayoutParams();
        this.lPc.copyFrom(localActivity.getWindow().getAttributes());
      }
      localActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28) {
        localActivity.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
      }
      if (localView == null)
      {
        this.lPb = localActivity.getRequestedOrientation();
        ac.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.lPb) });
      }
      switch (paramInt)
      {
      default: 
        localActivity.setRequestedOrientation(9);
      }
    }
    for (;;)
    {
      f.e(true, true, true);
      bsF();
      AppMethodBeat.o(189251);
      return;
      this.lOH = 0;
      this.lOJ = null;
      this.lOI = null;
      break;
      label368:
      paramView.setSystemUiVisibility(4102);
      break label197;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
  
  public final boolean aUJ()
  {
    AppMethodBeat.i(189252);
    if (this.lOF == null)
    {
      AppMethodBeat.o(189252);
      return false;
    }
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      ac.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(189252);
      return false;
    }
    ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.lPa);
    localActivity.getWindow().clearFlags(1024);
    if (this.lPc != null) {
      localActivity.getWindow().setAttributes(this.lPc);
    }
    localActivity.setRequestedOrientation(this.lPb);
    ac.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.lPb) });
    if (this.lOJ != null)
    {
      if ((this.lOF.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.lOF.getParent()).removeView(this.lOF);
      }
      this.lOJ.addView(this.lOF, this.lOH, this.lOI);
    }
    this.lOF = null;
    f.e(false, true, true);
    bsG();
    AppMethodBeat.o(189252);
    return true;
  }
  
  public final boolean bjb()
  {
    return this.lOF != null;
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(189253);
    if (!this.lOK.contains(paramb)) {
      this.lOK.add(paramb);
    }
    AppMethodBeat.o(189253);
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(189254);
    this.lOK.remove(paramb);
    AppMethodBeat.o(189254);
  }
  
  public final void release()
  {
    AppMethodBeat.i(189250);
    this.lOK.clear();
    AppMethodBeat.o(189250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a
 * JD-Core Version:    0.7.0.1
 */