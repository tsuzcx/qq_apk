package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.sdk.platformtools.al;

final class ab$1
  implements Runnable
{
  ab$1(ab paramab, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(37338);
    if (this.rxX.rxV)
    {
      AppMethodBeat.o(37338);
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37337);
        ab.1.this.rxX.euY.setText(g.dvk().b(this.ryb, ab.1.this.rxX.euY.getTextSize()));
        AppMethodBeat.o(37337);
      }
    });
    AppMethodBeat.o(37338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.1
 * JD-Core Version:    0.7.0.1
 */