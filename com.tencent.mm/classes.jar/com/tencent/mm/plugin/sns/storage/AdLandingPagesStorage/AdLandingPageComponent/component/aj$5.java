package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.ae;

final class aj$5
  implements View.OnLayoutChangeListener
{
  aj$5(aj paramaj) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(219562);
    try
    {
      paramInt1 = paramView.getWidth();
      paramInt2 = paramView.getHeight();
      paramInt3 = aj.v(this.zYz).getWidth();
      paramInt4 = aj.v(this.zYz).getHeight();
      if ((paramInt2 <= 1) || (paramInt1 <= 1) || (paramInt3 == 0) || (paramInt4 == 0))
      {
        AppMethodBeat.o(219562);
        return;
      }
      ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, videoW=" + paramInt1 + ", videoH=" + paramInt2 + ", containerW=" + paramInt3 + ", containH=" + paramInt4 + ", container.padding=" + k.eR(aj.v(this.zYz)));
      if (paramInt2 == paramInt4)
      {
        AppMethodBeat.o(219562);
        return;
      }
      if ((paramInt2 >= paramInt1) && (paramInt4 >= paramInt3) && (Math.abs(paramInt2 - paramInt4) < 2))
      {
        paramView = aj.v(this.zYz).getLayoutParams();
        paramView.height = paramInt2;
        aj.v(this.zYz).setLayoutParams(paramView);
        ae.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, reset VideoContainer.height");
      }
      AppMethodBeat.o(219562);
      return;
    }
    catch (Exception paramView)
    {
      ae.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLayoutChange, exp=" + paramView.toString());
      AppMethodBeat.o(219562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj.5
 * JD-Core Version:    0.7.0.1
 */