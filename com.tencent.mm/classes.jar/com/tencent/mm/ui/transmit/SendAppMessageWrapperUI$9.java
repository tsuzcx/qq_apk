package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

final class SendAppMessageWrapperUI$9
  implements w.a
{
  SendAppMessageWrapperUI$9(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, LinkedList paramLinkedList, WxaAttributes paramWxaAttributes, WXMiniProgramObject paramWXMiniProgramObject, String paramString, WXMediaMessage paramWXMediaMessage) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(154019);
    ab.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (czp)paramb.fsW.fta;
    label116:
    String str;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (paramString.ygq != null))
    {
      if (paramString.ygq == null)
      {
        paramString = new LinkedList();
        ab.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(this.iai.size()) });
        paramInt1 = 0;
        if (paramInt1 >= this.iai.size()) {
          break label482;
        }
        if (paramInt1 >= paramString.size()) {
          break label338;
        }
      }
      label338:
      for (paramb = (czx)paramString.get(paramInt1);; paramb = new czx())
      {
        j.b localb = new j.b();
        str = SendAppMessageWrapperUI.d(this.AAH).field_appId;
        paramm = str;
        if (!SendAppMessageWrapperUI.f(this.AAH))
        {
          paramm = str;
          if (SendAppMessageWrapperUI.g(this.AAH)) {
            paramm = "";
          }
        }
        localb.appId = paramm;
        localb.fiY = this.AAJ.field_appId;
        localb.cGN = this.AAJ.field_username;
        localb.cGO = this.AAJ.field_nickname;
        localb.fjh = this.AAI.miniprogramType;
        localb.appName = SendAppMessageWrapperUI.d(this.AAH).field_appName;
        localb.fgz = 2;
        localb.fjd = paramb.xMI;
        localb.fjc = this.AAK;
        SendAppMessageWrapperUI.b(localb, this.cac);
        l.a(localb, this.cac, (String)this.iai.get(paramInt1));
        paramInt1 += 1;
        break label116;
        paramString = paramString.ygq;
        break;
      }
    }
    else
    {
      paramm = this.iai.iterator();
      while (paramm.hasNext())
      {
        str = (String)paramm.next();
        paramb = SendAppMessageWrapperUI.d(this.AAH).field_appId;
        paramString = paramb;
        if (!SendAppMessageWrapperUI.f(this.AAH))
        {
          paramString = paramb;
          if (SendAppMessageWrapperUI.g(this.AAH)) {
            paramString = "";
          }
        }
        paramb = new j.b();
        paramb.appId = paramString;
        paramb.appName = SendAppMessageWrapperUI.d(this.AAH).field_appName;
        paramb.fgz = 2;
        SendAppMessageWrapperUI.b(paramb, this.cac);
        l.a(paramb, this.cac, str);
      }
    }
    label482:
    AppMethodBeat.o(154019);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.9
 * JD-Core Version:    0.7.0.1
 */