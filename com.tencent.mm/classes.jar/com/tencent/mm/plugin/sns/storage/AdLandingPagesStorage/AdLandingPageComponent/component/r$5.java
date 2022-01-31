package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;

final class r$5
  implements f.a
{
  r$5(r paramr) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37208);
    if (this.rxh.mZY.getVisibility() == 0) {
      this.rxh.mZY.setImageBitmap(MMBitmapFactory.decodeFile(paramString));
    }
    AppMethodBeat.o(37208);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.5
 * JD-Core Version:    0.7.0.1
 */