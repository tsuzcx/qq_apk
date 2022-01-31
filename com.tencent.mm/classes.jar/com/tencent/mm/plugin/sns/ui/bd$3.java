package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class bd$3
  implements View.OnClickListener
{
  bd$3(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39864);
    ab.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
    if (!(paramView.getTag() instanceof q))
    {
      AppMethodBeat.o(39864);
      return;
    }
    Object localObject = (q)paramView.getTag();
    paramView = ((q)localObject).rGk;
    localObject = ag.cpf().abv(((q)localObject).crk);
    if (this.scK.rFN != null) {
      this.scK.rFN.coJ().x((n)localObject);
    }
    if (paramView.xTY == null)
    {
      ab.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
      AppMethodBeat.o(39864);
      return;
    }
    String str1 = paramView.xTY.username;
    String str2 = paramView.xTY.path;
    ab.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
    so localso = new so();
    localso.cIQ.userName = str1;
    localso.cIQ.cIS = str2;
    localso.cIQ.scene = 1009;
    localso.cIQ.cmF = (paramView.Id + ":" + paramView.jJA);
    paramView = new Bundle();
    paramView.putString("stat_send_msg_user", ((n)localObject).field_userName);
    paramView.putString("stat_msg_id", "sns_" + i.lq(((n)localObject).field_snsId));
    a.ymk.l(localso);
    AppMethodBeat.o(39864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.3
 * JD-Core Version:    0.7.0.1
 */