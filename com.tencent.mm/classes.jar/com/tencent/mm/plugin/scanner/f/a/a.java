package com.tencent.mm.plugin.scanner.f.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/animation/AlphaImageAnimator;", "Lcom/tencent/mm/plugin/scanner/ocr/animation/BaseOCRImageAnimator;", "animationType", "", "(I)V", "canUpdate", "", "onDismissStart", "", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "onDismissUpdate", "factor", "", "onShowStart", "onShowUpdate", "updateViewAlpha", "view", "Landroid/view/View;", "alpha", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public static final a.a OVd;
  private final int OUN;
  
  static
  {
    AppMethodBeat.i(313520);
    OVd = new a.a((byte)0);
    AppMethodBeat.o(313520);
  }
  
  public a(int paramInt)
  {
    this.OUN = paramInt;
  }
  
  private static void z(View paramView, float paramFloat)
  {
    AppMethodBeat.i(313518);
    Log.v("MicroMsg.AlphaImageAnimator", "alvinluo updateViewAlpha: %s", new Object[] { Float.valueOf(paramFloat) });
    if (paramView != null) {
      paramView.setAlpha(paramFloat);
    }
    AppMethodBeat.o(313518);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(313527);
    s.u(parama, "animationInfo");
    super.a(parama);
    AppMethodBeat.o(313527);
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(313531);
    s.u(parama, "animationInfo");
    AppMethodBeat.o(313531);
  }
  
  public final void db(float paramFloat)
  {
    AppMethodBeat.i(313537);
    View localView = getCurrentImageView();
    s.checkNotNull(localView);
    if (localView.getAlpha() >= 1.0F - paramFloat) {
      z(getCurrentImageView(), 1.0F - paramFloat);
    }
    AppMethodBeat.o(313537);
  }
  
  public final void dc(float paramFloat)
  {
    AppMethodBeat.i(313541);
    View localView = getCurrentImageView();
    s.checkNotNull(localView);
    if (localView.getAlpha() <= paramFloat) {
      z(getCurrentImageView(), paramFloat);
    }
    AppMethodBeat.o(313541);
  }
  
  public final boolean gRI()
  {
    return this.OUN == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.a
 * JD-Core Version:    0.7.0.1
 */