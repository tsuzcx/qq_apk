package com.tencent.mm.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.msgsubscription.storage.f;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.LinkedList;

final class ServiceNotifySettingsUI$4
  implements g
{
  ServiceNotifySettingsUI$4(ServiceNotifySettingsUI paramServiceNotifySettingsUI, boolean paramBoolean1, boolean paramBoolean2, LinkedList paramLinkedList, int paramInt) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(33705);
    az.agi().b(1176, this);
    ac.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this.HrR, 2131761765, 0).show();
      if (this.HrS)
      {
        az.ayM();
        c.agA().set(ah.a.GJO, Boolean.valueOf(this.HrT));
        com.tencent.mm.sdk.b.a.GpY.l(new qc());
      }
      paramString = this.fzk.iterator();
      while (paramString.hasNext())
      {
        paramn = (dfv)paramString.next();
        localObject = new wx();
        ((wx)localObject).dzL.cYF = paramn.FPg;
        ((wx)localObject).dzL.action = 1;
        ((wx)localObject).dzL.option = this.HrU;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
      }
      AppMethodBeat.o(33705);
      return;
    }
    paramString = f.iix;
    paramString = f.ES("name_wxa");
    paramInt1 = 0;
    if (paramInt1 < this.fzk.size())
    {
      paramn = (dfv)this.fzk.get(paramInt1);
      if ((paramString != null) && (paramn != null) && (!bs.isNullOrNil(paramn.FPg)))
      {
        localObject = paramn.FPg;
        if (paramn.FPf != 1) {
          break label285;
        }
      }
      label285:
      for (boolean bool = true;; bool = false)
      {
        paramString.Z((String)localObject, bool);
        paramInt1 += 1;
        break;
      }
    }
    AppMethodBeat.o(33705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.4
 * JD-Core Version:    0.7.0.1
 */