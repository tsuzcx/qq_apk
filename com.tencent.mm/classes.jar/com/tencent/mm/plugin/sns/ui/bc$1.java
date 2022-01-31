package com.tencent.mm.plugin.sns.ui;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bo;

final class bc$1
  implements f.a
{
  bc$1(bc parambc, SpannableString paramSpannableString, int paramInt) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(39855);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(39855);
      return;
    }
    paramString = Drawable.createFromPath(paramString);
    if (paramString != null)
    {
      paramString.setBounds(0, 0, (int)(this.scu.scn.getTextSize() * 1.3D), (int)(this.scu.scn.getTextSize() * 1.3D));
      paramString = new ImageSpan(paramString, 0);
      this.scs.setSpan(paramString, this.sct, this.sct + 3, 33);
      this.scu.scn.setText(this.scs);
    }
    AppMethodBeat.o(39855);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bc.1
 * JD-Core Version:    0.7.0.1
 */