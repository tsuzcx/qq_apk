package com.tencent.mm.plugin.record.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.aw.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.t;
import java.io.File;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24351);
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      t.ii(paramView.getContext());
      AppMethodBeat.o(24351);
      return;
    }
    Object localObject1 = (com.tencent.mm.plugin.record.ui.a.b)paramView.getTag();
    acc localacc = ((com.tencent.mm.plugin.record.ui.a.b)localObject1).cuL.wTw.wUb;
    if (b.e(((com.tencent.mm.plugin.record.ui.a.b)localObject1).cuL))
    {
      ab.i("MicroMsg.OtherViewWrapper", "same song, do release");
      a.aiu();
      if (!this.qar.qap)
      {
        this.qar.handler.sendMessageAtFrontOfQueue(this.qar.handler.obtainMessage(1));
        AppMethodBeat.o(24351);
      }
    }
    else
    {
      this.qar.qap = true;
      paramView = new File(n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject1).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject1).cpO));
      if (paramView.exists()) {
        break label333;
      }
      if (((com.tencent.mm.plugin.record.ui.a.b)localObject1).cuL.cpH != null) {
        break label261;
      }
      paramView = "";
    }
    for (;;)
    {
      Object localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject1).cuL;
      localObject1 = ((aca)localObject2).title;
      String str1 = ((aca)localObject2).desc;
      String str2 = ((aca)localObject2).wSJ;
      String str3 = ((aca)localObject2).wSN;
      String str4 = ((aca)localObject2).wSL;
      localObject2 = ((aca)localObject2).mBq;
      StringBuilder localStringBuilder = new StringBuilder();
      aw.aaz();
      a.b(com.tencent.mm.aw.f.a(6, null, (String)localObject1, str1, str2, str3, str4, (String)localObject2, c.YU() + "web/", paramView, "", localacc.appId));
      AppMethodBeat.o(24351);
      return;
      label261:
      paramView = new StringBuilder();
      aw.aaz();
      paramView = new File(c.YU() + "web/" + g.w(((com.tencent.mm.plugin.record.ui.a.b)localObject1).cuL.cpH.getBytes()));
      if (paramView.exists()) {}
      for (paramView = paramView.getAbsolutePath();; paramView = "") {
        break;
      }
      label333:
      paramView = paramView.getAbsolutePath();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.b.2
 * JD-Core Version:    0.7.0.1
 */