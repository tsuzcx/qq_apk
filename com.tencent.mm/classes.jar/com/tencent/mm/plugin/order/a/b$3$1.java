package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString, f.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(66637);
    Object localObject1 = b.dnJ();
    Object localObject2 = this.joA;
    Object localObject3 = this.hmp.fXi.vTO;
    j localj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localj = com.tencent.mm.plugin.order.model.c.aoY((String)localObject2);
      if (localj == null)
      {
        ac.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        AppMethodBeat.o(66637);
        return;
      }
      if ((!TextUtils.isEmpty(localj.vyd)) || (!TextUtils.isEmpty(localj.vyu)) || (!TextUtils.isEmpty(localj.vyt)) || (!TextUtils.isEmpty(localj.drV)) || (!TextUtils.isEmpty(localj.vyp)) || (!TextUtils.isEmpty(localj.vyq)) || (!TextUtils.isEmpty(localj.vyo)) || (!TextUtils.isEmpty(localj.vys)) || (!TextUtils.isEmpty(localj.vyr)) || (!TextUtils.isEmpty(localj.vyn))) {
        if ((localj.vyn != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.vyn)))
        {
          int i = bs.getInt(localj.vyn, 0);
          if ((i != 2) && (i != 1)) {}
        }
        else
        {
          if (!TextUtils.isEmpty(localj.vyp)) {
            break label446;
          }
          localj.dtG = ((String)localObject3);
          ac.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.dtG);
          ac.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.vyn);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).apa(localj.dtG)) {
            break label475;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).nUj.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label302:
          ((com.tencent.mm.plugin.order.model.c)localObject1).dnN();
          localObject1 = b.dnG();
          if (localj != null)
          {
            localObject2 = new cep();
            if ((TextUtils.isEmpty(localj.vyp)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.vyp))) {
              break label549;
            }
            ((cep)localObject2).CreateTime = bs.getInt(localj.vyp, 0);
          }
        }
      }
    }
    for (((cep)localObject2).vxY = bs.getInt(localj.vyp, 0);; ((cep)localObject2).vxY = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((cep)localObject2).vyb = 100000;
      ((cep)localObject2).vyd = localj.vyd;
      ((cep)localObject2).vxU = localj.dtG;
      ((cep)localObject2).vxX = localj.vyr;
      ((cep)localObject2).Ftl = -1;
      ((cep)localObject2).vye = localj.vyo;
      ((cep)localObject2).vyf = localj.vyr;
      ((cep)localObject2).vyg = localj.drV;
      ((b)localObject1).dnH();
      AppMethodBeat.o(66637);
      return;
      label446:
      localj.dtG = ((String)localObject3 + localj.vyp);
      break;
      label475:
      ac.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.dtG + " is exist!!");
      localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).apc(localj.dtG);
      ((com.tencent.mm.plugin.order.model.c)localObject1).aoZ(localj.dtG);
      ((com.tencent.mm.plugin.order.model.c)localObject1).nUj.add(localj);
      ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
      break label302;
      label549:
      ((cep)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */