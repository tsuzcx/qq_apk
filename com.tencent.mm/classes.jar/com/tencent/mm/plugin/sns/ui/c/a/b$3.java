package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class b$3
  implements f.a
{
  b$3(b paramb) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(40090);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = d.decodeFile(paramString, null);
      if (paramString != null)
      {
        this.sfS.sfP.setVisibility(0);
        ImageView localImageView = (ImageView)this.sfS.sfP.findViewById(2131828111);
        localImageView.setImageBitmap(paramString);
        localImageView.setVisibility(0);
      }
    }
    AppMethodBeat.o(40090);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b.3
 * JD-Core Version:    0.7.0.1
 */