package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;

final class MultiStageCitySelectUI$2
  implements ZoneSelectOtherCountryPreference.a
{
  MultiStageCitySelectUI$2(MultiStageCitySelectUI paramMultiStageCitySelectUI) {}
  
  public final void onClick()
  {
    Intent localIntent = new Intent(this.wdX, MultiStageCitySelectUI.class);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("GetAddress", MultiStageCitySelectUI.e(this.wdX));
    localBundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.f(this.wdX));
    localBundle.putBoolean("IsSelectNonChinaCountry", true);
    localBundle.putBoolean("IsAutoPosition", false);
    localBundle.putBoolean("IsNeedShowSearchBar", true);
    localIntent.putExtras(localBundle);
    this.wdX.startActivityForResult(localIntent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MultiStageCitySelectUI.2
 * JD-Core Version:    0.7.0.1
 */