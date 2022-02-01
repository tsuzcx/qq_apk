package com.tencent.mm.plugin.scanner.f.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/animation/AlphaImageAnimator;", "Lcom/tencent/mm/plugin/scanner/ocr/animation/BaseOCRImageAnimator;", "animationType", "", "(I)V", "canUpdate", "", "onDismissStart", "", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "onDismissUpdate", "factor", "", "onShowStart", "onShowUpdate", "updateViewAlpha", "view", "Landroid/view/View;", "alpha", "Companion", "plugin-scan_release"})
public final class a
  extends b
{
  public static final a.a IOb;
  private final int INI;
  
  static
  {
    AppMethodBeat.i(216881);
    IOb = new a.a((byte)0);
    AppMethodBeat.o(216881);
  }
  
  public a(int paramInt)
  {
    this.INI = paramInt;
  }
  
  private static void y(View paramView, float paramFloat)
  {
    AppMethodBeat.i(216876);
    Log.v("MicroMsg.AlphaImageAnimator", "alvinluo updateViewAlpha: %s", new Object[] { Float.valueOf(paramFloat) });
    if (paramView != null)
    {
      paramView.setAlpha(paramFloat);
      AppMethodBeat.o(216876);
      return;
    }
    AppMethodBeat.o(216876);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(216865);
    p.k(parama, "animationInfo");
    super.a(parama);
    AppMethodBeat.o(216865);
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(216868);
    p.k(parama, "animationInfo");
    AppMethodBeat.o(216868);
  }
  
  public final void bV(float paramFloat)
  {
    AppMethodBeat.i(216871);
    View localView = getCurrentImageView();
    if (localView == null) {
      p.iCn();
    }
    if (localView.getAlpha() >= 1.0F - paramFloat) {
      y(getCurrentImageView(), 1.0F - paramFloat);
    }
    AppMethodBeat.o(216871);
  }
  
  public final void bW(float paramFloat)
  {
    AppMethodBeat.i(216873);
    View localView = getCurrentImageView();
    if (localView == null) {
      p.iCn();
    }
    if (localView.getAlpha() <= paramFloat) {
      y(getCurrentImageView(), paramFloat);
    }
    AppMethodBeat.o(216873);
  }
  
  public final boolean fDw()
  {
    return this.INI == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.a
 * JD-Core Version:    0.7.0.1
 */