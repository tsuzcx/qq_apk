package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class SnsInfoFlip$5
  implements AdapterView.OnItemLongClickListener
{
  SnsInfoFlip$5(SnsInfoFlip paramSnsInfoFlip) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38971);
    if (!SnsInfoFlip.i(this.rRB))
    {
      AppMethodBeat.o(38971);
      return true;
    }
    if ((SnsInfoFlip.g(this.rRB) instanceof MMGestureGallery))
    {
      paramAdapterView = v.aae().z("basescanui@datacenter", true);
      paramAdapterView.i("key_basescanui_screen_x", Integer.valueOf(((MMGestureGallery)SnsInfoFlip.g(this.rRB)).getXDown()));
      paramAdapterView.i("key_basescanui_screen_y", Integer.valueOf(((MMGestureGallery)SnsInfoFlip.g(this.rRB)).getYDown()));
    }
    paramAdapterView = ((b)SnsInfoFlip.d(this.rRB).getItem(paramInt)).rlJ;
    if (bo.isNullOrNil(paramAdapterView))
    {
      AppMethodBeat.o(38971);
      return false;
    }
    paramView = ((b)SnsInfoFlip.d(this.rRB).getItem(paramInt)).cIc.Id;
    String str = ao.gl(ag.getAccSnsPath(), paramView) + i.l(((b)SnsInfoFlip.d(this.rRB).getItem(paramInt)).cIc);
    this.rRB.e(str, paramAdapterView, paramView, true);
    AppMethodBeat.o(38971);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.5
 * JD-Core Version:    0.7.0.1
 */