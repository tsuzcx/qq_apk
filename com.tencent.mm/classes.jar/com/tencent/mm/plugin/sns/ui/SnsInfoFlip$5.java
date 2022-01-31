package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class SnsInfoFlip$5
  implements AdapterView.OnItemLongClickListener
{
  SnsInfoFlip$5(SnsInfoFlip paramSnsInfoFlip) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!SnsInfoFlip.i(this.oZi)) {
      return true;
    }
    if ((SnsInfoFlip.g(this.oZi) instanceof MMGestureGallery))
    {
      paramAdapterView = u.Hc().v("basescanui@datacenter", true);
      paramAdapterView.h("key_basescanui_screen_x", Integer.valueOf(((MMGestureGallery)SnsInfoFlip.g(this.oZi)).getXDown()));
      paramAdapterView.h("key_basescanui_screen_y", Integer.valueOf(((MMGestureGallery)SnsInfoFlip.g(this.oZi)).getYDown()));
    }
    paramAdapterView = ((b)SnsInfoFlip.d(this.oZi).getItem(paramInt)).owP;
    if (bk.bl(paramAdapterView)) {
      return false;
    }
    paramView = ((b)SnsInfoFlip.d(this.oZi).getItem(paramInt)).bZK.lsK;
    String str = an.eJ(af.getAccSnsPath(), paramView) + i.l(((b)SnsInfoFlip.d(this.oZi).getItem(paramInt)).bZK);
    this.oZi.e(str, paramAdapterView, paramView, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.5
 * JD-Core Version:    0.7.0.1
 */