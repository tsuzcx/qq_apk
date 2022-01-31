package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;

final class aa$5
  implements f.a
{
  aa$5(aa paramaa) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37306);
    if (this.rxT.mZY.getVisibility() == 0) {
      this.rxT.mZY.setImageBitmap(MMBitmapFactory.decodeFile(paramString));
    }
    AppMethodBeat.o(37306);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.5
 * JD-Core Version:    0.7.0.1
 */