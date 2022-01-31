package com.tencent.mm.ui.transmit;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.cly;
import com.tencent.mm.protocal.c.cmg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class SendAppMessageWrapperUI$7
  implements w.a
{
  SendAppMessageWrapperUI$7(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, LinkedList paramLinkedList, WxaAttributes paramWxaAttributes, WXMiniProgramObject paramWXMiniProgramObject, String paramString, WXMediaMessage paramWXMediaMessage) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (cly)paramb.ecF.ecN;
    label111:
    String str;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.tYU != null))
    {
      if (paramString.tYU == null)
      {
        paramString = new LinkedList();
        y.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(this.gBP.size()) });
        paramInt1 = 0;
        if (paramInt1 >= this.gBP.size()) {
          break label427;
        }
        if (paramInt1 >= paramString.size()) {
          break label320;
        }
      }
      label320:
      for (paramb = (cmg)paramString.get(paramInt1);; paramb = new cmg())
      {
        g.a locala = new g.a();
        str = SendAppMessageWrapperUI.e(this.whK).field_appId;
        paramm = str;
        if (!SendAppMessageWrapperUI.f(this.whK))
        {
          paramm = str;
          if (SendAppMessageWrapperUI.cJD()) {
            paramm = "";
          }
        }
        locala.appId = paramm;
        locala.dSZ = this.whM.field_appId;
        locala.bYG = this.whM.field_username;
        locala.bYH = this.whM.field_nickname;
        locala.dTf = this.whL.miniprogramType;
        locala.appName = SendAppMessageWrapperUI.e(this.whK).field_appName;
        locala.dQy = 2;
        locala.dTe = paramb.tIu;
        locala.dTd = this.whN;
        l.a(locala, this.bya, (String)this.gBP.get(paramInt1));
        paramInt1 += 1;
        break label111;
        paramString = paramString.tYU;
        break;
      }
    }
    else
    {
      paramm = this.gBP.iterator();
      while (paramm.hasNext())
      {
        str = (String)paramm.next();
        paramb = SendAppMessageWrapperUI.e(this.whK).field_appId;
        paramString = paramb;
        if (!SendAppMessageWrapperUI.f(this.whK))
        {
          paramString = paramb;
          if (SendAppMessageWrapperUI.cJD()) {
            paramString = "";
          }
        }
        l.a(this.bya, paramString, SendAppMessageWrapperUI.e(this.whK).field_appName, str, 2, null, null);
      }
    }
    label427:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.7
 * JD-Core Version:    0.7.0.1
 */