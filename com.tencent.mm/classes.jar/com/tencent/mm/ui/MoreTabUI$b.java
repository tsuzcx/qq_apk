package com.tencent.mm.ui;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.listview.PullDownListView;

final class MoreTabUI$b
{
  private int status = 2;
  
  private MoreTabUI$b(MoreTabUI paramMoreTabUI) {}
  
  public final void Or(int paramInt)
  {
    AppMethodBeat.i(29716);
    ab.i("MicroMsg.MoreTabUI", "forceToStatus %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      MoreTabUI.d(this.zdu, true);
    }
    for (;;)
    {
      this.status = paramInt;
      cbX();
      AppMethodBeat.o(29716);
      return;
      MoreTabUI.d(this.zdu, false);
    }
  }
  
  public final void cbX()
  {
    AppMethodBeat.i(29714);
    if (this.zdu.getActivity() == null)
    {
      AppMethodBeat.o(29714);
      return;
    }
    switch (this.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29714);
      return;
      MoreTabUI.h(this.zdu).setSupportOverscroll(true);
      MoreTabUI.o(this.zdu);
      if (MoreTabUI.n(this.zdu)) {
        MoreTabUI.h(this.zdu).setBackgroundResource(2130839611);
      }
      for (;;)
      {
        if (MoreTabUI.i(this.zdu) != null)
        {
          ((RelativeLayout.LayoutParams)MoreTabUI.i(this.zdu).getLayoutParams()).topMargin = MoreTabUI.v(this.zdu);
          MoreTabUI.h(this.zdu).y(MoreTabUI.i(this.zdu), MoreTabUI.w(this.zdu), MoreTabUI.v(this.zdu));
        }
        MoreTabUI.h(this.zdu).setMuteView(null);
        MoreTabUI.c(this.zdu, MoreTabUI.m(this.zdu));
        MoreTabUI.a(this.zdu, 0);
        MoreTabUI.b(this.zdu, MoreTabUI.m(this.zdu));
        if (MoreTabUI.x(this.zdu) == null) {
          break;
        }
        MoreTabUI.x(this.zdu).ae(MoreTabUI.m(this.zdu), MoreTabUI.n(this.zdu));
        AppMethodBeat.o(29714);
        return;
        MoreTabUI.h(this.zdu).setBackgroundResource(2130839609);
      }
      MoreTabUI.h(this.zdu).setBackgroundResource(2130839609);
      MoreTabUI.h(this.zdu).setSupportOverscroll(MoreTabUI.m(this.zdu));
      MoreTabUI.y(this.zdu);
      MoreTabUI.b(this.zdu, a.ap(this.zdu.getContext(), 2131428634));
      if (MoreTabUI.i(this.zdu) != null)
      {
        ((RelativeLayout.LayoutParams)MoreTabUI.i(this.zdu).getLayoutParams()).topMargin = MoreTabUI.z(this.zdu);
        MoreTabUI.h(this.zdu).y(MoreTabUI.i(this.zdu), MoreTabUI.w(this.zdu), MoreTabUI.z(this.zdu));
      }
      MoreTabUI.h(this.zdu).setMuteView(MoreTabUI.u(this.zdu));
      MoreTabUI.c(this.zdu, MoreTabUI.m(this.zdu));
      MoreTabUI.a(this.zdu, 0);
      MoreTabUI.b(this.zdu, MoreTabUI.m(this.zdu));
      if (MoreTabUI.x(this.zdu) != null)
      {
        MoreTabUI.x(this.zdu).ae(MoreTabUI.m(this.zdu), MoreTabUI.n(this.zdu));
        AppMethodBeat.o(29714);
        return;
        MoreTabUI.h(this.zdu).setBackgroundResource(2130839611);
        MoreTabUI.h(this.zdu).setSupportOverscroll(MoreTabUI.m(this.zdu));
        MoreTabUI.c(this.zdu, MoreTabUI.m(this.zdu));
        MoreTabUI.j(this.zdu);
        if (MoreTabUI.x(this.zdu) != null) {
          MoreTabUI.x(this.zdu).ae(MoreTabUI.m(this.zdu), MoreTabUI.n(this.zdu));
        }
      }
    }
  }
  
  public final void dCY()
  {
    AppMethodBeat.i(29715);
    if ((!n.isShowStoryCheck()) || (MoreTabUI.g(this.zdu)))
    {
      MoreTabUI.d(this.zdu, false);
      this.status = 2;
    }
    for (;;)
    {
      ab.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", new Object[] { Integer.valueOf(this.status) });
      cbX();
      AppMethodBeat.o(29715);
      return;
      if (((e)g.G(e.class)).isStoryExist(r.Zn()))
      {
        MoreTabUI.d(this.zdu, true);
        this.status = 0;
      }
      else
      {
        MoreTabUI.d(this.zdu, false);
        this.status = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.b
 * JD-Core Version:    0.7.0.1
 */