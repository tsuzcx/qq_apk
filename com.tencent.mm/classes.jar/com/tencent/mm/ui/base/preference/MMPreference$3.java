package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

final class MMPreference$3
  implements AdapterView.OnItemLongClickListener
{
  MMPreference$3(MMPreference paramMMPreference) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < MMPreference.e(this.vdh).getHeaderViewsCount()) {
      return false;
    }
    paramInt -= MMPreference.e(this.vdh).getHeaderViewsCount();
    if (paramInt >= MMPreference.d(this.vdh).getCount())
    {
      y.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MMPreference.d(this.vdh).getCount()) });
      return false;
    }
    MMPreference.d(this.vdh).getItem(paramInt);
    MMPreference.d(this.vdh);
    MMPreference.e(this.vdh);
    return MMPreference.cBx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.3
 * JD-Core Version:    0.7.0.1
 */