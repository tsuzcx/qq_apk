package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ZoneSelectOtherCountryPreference$1
  implements View.OnClickListener
{
  ZoneSelectOtherCountryPreference$1(ZoneSelectOtherCountryPreference paramZoneSelectOtherCountryPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35019);
    if (ZoneSelectOtherCountryPreference.a(this.Ayx) != null) {
      ZoneSelectOtherCountryPreference.a(this.Ayx).onClick();
    }
    AppMethodBeat.o(35019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference.1
 * JD-Core Version:    0.7.0.1
 */