package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f.a;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import java.util.ArrayList;
import java.util.List;

final class aw$3
  implements f.a
{
  aw$3(aw paramaw, String paramString1, int paramInt, String paramString2) {}
  
  public final void aB(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(255405);
    if (paramBoolean)
    {
      String str = "werun_daily_push_list;" + this.aeUw + ";" + this.aeUx;
      ArrayList localArrayList = new ArrayList();
      Object localObject = new TextStatusJumpInfo();
      ((TextStatusJumpInfo)localObject).jumpType = "11";
      localArrayList.add(localObject);
      localObject = new TextStatusJumpInfo();
      ((TextStatusJumpInfo)localObject).jumpType = "3";
      ((TextStatusJumpInfo)localObject).busiBuf = "https://support.weixin.qq.com/security/readtemplate?t=w_security_center_website/upgrade&scene=1#wechat_redirect";
      localArrayList.add(localObject);
      localObject = new w.a();
      paramString = ((w.a)localObject).bdr(this.aeUw).bds(this.aeUy).bdw(paramString).bdu("wx7fa037cc7dfabad5@jsticket").bdx(aw.b(this.aeUv).aezO.getContext().getString(R.l.gGX));
      paramString.ThS.Tot = str;
      paramString.ls(localArrayList);
      ((n)h.ax(n.class)).a(aw.b(this.aeUv).aezO.getContext(), ((w.a)localObject).ThS);
      AppMethodBeat.o(255405);
      return;
    }
    k.c(aw.b(this.aeUv).aezO.getContext(), aw.b(this.aeUv).aezO.getContext().getString(R.l.msg_net_error), "", true);
    AppMethodBeat.o(255405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.3
 * JD-Core Version:    0.7.0.1
 */