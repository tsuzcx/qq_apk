package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class bd$4
  implements View.OnClickListener
{
  bd$4(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39865);
    ab.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
    if (!(paramView.getTag() instanceof TimeLineObject))
    {
      AppMethodBeat.o(39865);
      return;
    }
    paramView = (TimeLineObject)paramView.getTag();
    if (paramView.xTY == null)
    {
      ab.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
      AppMethodBeat.o(39865);
      return;
    }
    String str = paramView.xTY.username;
    so localso = new so();
    ab.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(str)));
    localso.cIQ.userName = str;
    localso.cIQ.scene = 1009;
    localso.cIQ.cmF = (paramView.Id + ":" + paramView.jJA);
    a.ymk.l(localso);
    AppMethodBeat.o(39865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.4
 * JD-Core Version:    0.7.0.1
 */