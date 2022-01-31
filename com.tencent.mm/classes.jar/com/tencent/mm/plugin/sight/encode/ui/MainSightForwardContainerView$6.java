package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.ui.base.h;
import java.util.List;

final class MainSightForwardContainerView$6
  implements b.a
{
  MainSightForwardContainerView$6(MainSightForwardContainerView paramMainSightForwardContainerView, List paramList) {}
  
  public final void onError(int paramInt)
  {
    if ((this.ohR.size() <= 1) || (-1 == paramInt)) {
      h.bC(this.ohP.getContext(), this.ohP.getContext().getString(R.l.sendrequest_send_fail));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.6
 * JD-Core Version:    0.7.0.1
 */