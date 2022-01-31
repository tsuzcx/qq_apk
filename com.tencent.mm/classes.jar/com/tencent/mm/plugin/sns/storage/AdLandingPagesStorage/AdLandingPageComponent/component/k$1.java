package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;

final class k$1
  implements f.a
{
  k$1(k paramk) {}
  
  @TargetApi(16)
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37086);
    try
    {
      paramString = Drawable.createFromPath(paramString);
      this.rvt.rvr.setBackground(paramString);
      if ((paramString != null) && (this.rvt.cri().height > 0.0F) && (paramString.getIntrinsicHeight() > 0))
      {
        float f = this.rvt.cri().height * paramString.getIntrinsicWidth() / paramString.getIntrinsicHeight();
        this.rvt.rvr.setLayoutParams(new RelativeLayout.LayoutParams((int)f, (int)this.rvt.cri().height));
      }
      AppMethodBeat.o(37086);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramString.toString());
      AppMethodBeat.o(37086);
    }
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k.1
 * JD-Core Version:    0.7.0.1
 */