package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.ae;

final class af$6
  implements View.OnLayoutChangeListener
{
  af$6(af paramaf) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(219515);
    try
    {
      paramInt1 = paramView.getHeight();
      paramInt2 = paramView.getWidth();
      paramInt3 = af.z(this.zXY).getWidth();
      paramInt4 = af.z(this.zXY).getHeight();
      if ((paramInt2 <= 1) || (paramInt1 <= 1) || (paramInt3 == 0) || (paramInt4 == 0))
      {
        AppMethodBeat.o(219515);
        return;
      }
      ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, video.w=" + paramView.getWidth() + ", h=" + paramView.getHeight() + ", container.w=" + paramInt3 + ", h=" + paramInt4 + ", container.padding=" + k.eR(af.z(this.zXY)));
      if (paramInt1 == paramInt4)
      {
        AppMethodBeat.o(219515);
        return;
      }
      if ((paramInt1 >= paramInt2) && (paramInt4 >= paramInt3) && (Math.abs(paramInt1 - paramInt4) < 2))
      {
        paramView = af.z(this.zXY).getLayoutParams();
        paramView.height = paramInt1;
        af.z(this.zXY).setLayoutParams(paramView);
        ae.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, reset VideoContainer.height");
      }
      AppMethodBeat.o(219515);
      return;
    }
    catch (Exception paramView)
    {
      ae.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onLayoutChange, exp=" + paramView.toString());
      AppMethodBeat.o(219515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af.6
 * JD-Core Version:    0.7.0.1
 */