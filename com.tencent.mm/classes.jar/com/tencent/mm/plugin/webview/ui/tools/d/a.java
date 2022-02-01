package com.tencent.mm.plugin.webview.ui.tools.d;

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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private View lmD;
  private int lmF;
  private ViewGroup.LayoutParams lmG;
  private ViewGroup lmH;
  private final Set<b> lmI;
  private int lmY;
  private int lmZ;
  private WindowManager.LayoutParams lna;
  private Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(188682);
    this.lmI = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(188682);
  }
  
  private void blJ()
  {
    AppMethodBeat.i(188688);
    Iterator localIterator = this.lmI.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).aWR();
    }
    AppMethodBeat.o(188688);
  }
  
  private void blK()
  {
    AppMethodBeat.i(188689);
    Iterator localIterator = this.lmI.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).Cx();
    }
    AppMethodBeat.o(188689);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(188684);
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      ad.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(188684);
      return;
    }
    View localView = this.lmD;
    this.lmD = paramView;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    if (localView == null)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.lmH = ((ViewGroup)paramView.getParent());
        this.lmF = this.lmH.indexOfChild(paramView);
        this.lmG = paramView.getLayoutParams();
        this.lmH.removeView(paramView);
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
        this.lmY = paramView.getSystemUiVisibility();
      }
      if (!d.lg(19)) {
        break label362;
      }
      paramView.setSystemUiVisibility(2);
      label197:
      if (localView == null)
      {
        this.lna = new WindowManager.LayoutParams();
        this.lna.copyFrom(localActivity.getWindow().getAttributes());
      }
      localActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28) {
        localActivity.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
      }
      if (localView == null)
      {
        this.lmZ = localActivity.getRequestedOrientation();
        ad.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.lmZ) });
      }
      switch (paramInt)
      {
      default: 
        localActivity.setRequestedOrientation(9);
      }
    }
    for (;;)
    {
      blJ();
      AppMethodBeat.o(188684);
      return;
      this.lmF = 0;
      this.lmH = null;
      this.lmG = null;
      break;
      label362:
      paramView.setSystemUiVisibility(4102);
      break label197;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
  
  public final boolean aNT()
  {
    AppMethodBeat.i(188685);
    if (this.lmD == null)
    {
      AppMethodBeat.o(188685);
      return false;
    }
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      ad.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(188685);
      return false;
    }
    ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.lmY);
    localActivity.getWindow().clearFlags(1024);
    if (this.lna != null) {
      localActivity.getWindow().setAttributes(this.lna);
    }
    localActivity.setRequestedOrientation(this.lmZ);
    ad.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.lmZ) });
    if (this.lmH != null)
    {
      if ((this.lmD.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.lmD.getParent()).removeView(this.lmD);
      }
      this.lmH.addView(this.lmD, this.lmF, this.lmG);
    }
    this.lmD = null;
    blK();
    AppMethodBeat.o(188685);
    return true;
  }
  
  public final boolean bcg()
  {
    return this.lmD != null;
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(188686);
    if (!this.lmI.contains(paramb)) {
      this.lmI.add(paramb);
    }
    AppMethodBeat.o(188686);
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(188687);
    this.lmI.remove(paramb);
    AppMethodBeat.o(188687);
  }
  
  public final void release()
  {
    AppMethodBeat.i(188683);
    this.lmI.clear();
    AppMethodBeat.o(188683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a
 * JD-Core Version:    0.7.0.1
 */