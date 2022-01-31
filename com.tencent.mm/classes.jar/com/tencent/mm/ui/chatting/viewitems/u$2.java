package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.su;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.e;

final class u$2
  implements f
{
  u$2(u paramu, bi parambi, bb parambb, boolean paramBoolean, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(1176, this);
    y.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(true) });
    if (this.dUy != this.vEf.vIl.getTag(R.h.new_dyeing_template_ban_toggle_text)) {
      y.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(this.dUy.field_msgId) });
    }
    while ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    paramString = this.vEf.vHH;
    if (this.vEg)
    {
      paramInt1 = 8;
      label117:
      paramString.setVisibility(paramInt1);
      s.makeText(u.b(this.vDZ).vtz.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
      paramString = new su();
      paramString.ccq.bFn = this.rzx;
      paramm = paramString.ccq;
      if (!this.vEg) {
        break label227;
      }
    }
    label227:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      paramm.action = paramInt1;
      paramString.ccq.ccs = 1;
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      if (u.b(this.vDZ) == null) {
        break;
      }
      u.b(this.vDZ).axW();
      return;
      paramInt1 = 0;
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.2
 * JD-Core Version:    0.7.0.1
 */