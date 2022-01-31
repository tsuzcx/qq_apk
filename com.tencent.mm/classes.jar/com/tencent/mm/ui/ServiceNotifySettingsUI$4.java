package com.tencent.mm.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.un;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;

final class ServiceNotifySettingsUI$4
  implements f
{
  ServiceNotifySettingsUI$4(ServiceNotifySettingsUI paramServiceNotifySettingsUI, boolean paramBoolean1, boolean paramBoolean2, LinkedList paramLinkedList, int paramInt) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(29853);
    aw.Rc().b(1176, this);
    ab.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this.zeQ, 2131301990, 0).show();
      if (this.zeR)
      {
        aw.aaz();
        c.Ru().set(ac.a.yDB, Boolean.valueOf(this.zeS));
        a.ymk.l(new oe());
      }
      paramString = this.eiQ.iterator();
      while (paramString.hasNext())
      {
        paramm = (ciy)paramString.next();
        un localun = new un();
        localun.cLa.cmx = paramm.xTh;
        localun.cLa.action = 1;
        localun.cLa.option = this.zeT;
        a.ymk.l(localun);
      }
      AppMethodBeat.o(29853);
      return;
    }
    AppMethodBeat.o(29853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.4
 * JD-Core Version:    0.7.0.1
 */