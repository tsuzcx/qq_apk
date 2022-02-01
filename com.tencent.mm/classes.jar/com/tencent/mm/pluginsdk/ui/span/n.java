package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.bp;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;

public class n
{
  private int VyQ = 500;
  private long VyR = 0L;
  Context mContext;
  String mSessionId;
  
  private static cc kQ(View paramView)
  {
    AppMethodBeat.i(245190);
    if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c)))
    {
      paramView = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).hTm;
      AppMethodBeat.o(245190);
      return paramView;
    }
    AppMethodBeat.o(245190);
    return null;
  }
  
  public void a(View paramView, u paramu)
  {
    int j = 1;
    AppMethodBeat.i(152273);
    if (System.currentTimeMillis() - this.VyR <= this.VyQ)
    {
      Log.e("MicroMsg.MMSpanClickListener", "process pass");
      AppMethodBeat.o(152273);
      return;
    }
    Object localObject1 = new bp();
    Object localObject2 = kQ(paramView);
    if (localObject2 != null) {
      ((bp)localObject1).hBE.msgId = ((fi)localObject2).field_msgId;
    }
    ((bp)localObject1).hBE.type = 1;
    ((bp)localObject1).publish();
    this.VyR = System.currentTimeMillis();
    if (paramu == null)
    {
      Log.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
      AppMethodBeat.o(152273);
      return;
    }
    Log.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", new Object[] { Integer.valueOf(paramu.type) });
    if (this.mContext == null)
    {
      Log.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
      AppMethodBeat.o(152273);
      return;
    }
    int i;
    if ((p.YoD != null) && (p.YoD.size() > 0))
    {
      i = p.YoD.size();
      localObject2 = (m)p.YoD.getLast();
      Log.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c)))
      {
        cc localcc = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).hTm;
        if (localcc != null)
        {
          String str = localcc.field_talker;
          localObject1 = str;
          if (au.bwE(str)) {
            localObject1 = br.JJ(localcc.field_content);
          }
          paramu.username = ((String)localObject1);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label681;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).hTm;
          if ((localObject1 == null) || (((fi)localObject1).field_isSend != 1)) {
            break label681;
          }
          localObject1 = z.bAM();
          label313:
          paramu.AWk = ((String)localObject1);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label687;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).hTm;
          if (localObject1 == null) {
            break label687;
          }
          localObject1 = ((fi)localObject1).field_content;
          label357:
          paramu.extraData = localObject1;
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label693;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).hTm;
          if (localObject1 == null) {
            break label693;
          }
          localObject1 = ((fi)localObject1).field_talker;
          label401:
          paramu.chatroomName = ((String)localObject1);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label699;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).hTm;
          if ((localObject1 == null) || (((cc)localObject1).getType() != 10000)) {
            break label699;
          }
          i = ((fi)localObject1).kLv;
          label455:
          paramu.kLv = i;
          paramu.hTm = kQ(paramView);
          if ((paramView == null) || (!(paramView.getTag() instanceof a))) {
            break label704;
          }
          i = ((a)paramView.getTag()).hlN();
          label495:
          paramu.YcU = i;
          if ((paramView == null) || (!(paramView.getTag() instanceof a))) {
            break label709;
          }
          localObject1 = ((a)paramView.getTag()).hlO();
          label528:
          paramu.YcV = ((String)localObject1);
          if (paramu.fromScene == 0)
          {
            if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
              break label715;
            }
            i = j;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          paramu.fromScene = i;
        }
        if (!TextUtils.isEmpty(this.mSessionId)) {
          paramu.mSessionId = this.mSessionId;
        }
        d.a.YnY.a(this.mContext, paramView, paramu, (m)localObject2);
        if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
          ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramu.username);
        }
        paramu.mSessionId = null;
        AppMethodBeat.o(152273);
        return;
        if ((paramView != null) && ((paramView.getTag() instanceof a)))
        {
          localObject1 = ((a)paramView.getTag()).getUserName();
          break;
        }
        localObject1 = null;
        break;
        label681:
        localObject1 = null;
        break label313;
        label687:
        localObject1 = null;
        break label357;
        label693:
        localObject1 = null;
        break label401;
        label699:
        i = 0;
        break label455;
        label704:
        i = 1;
        break label495;
        label709:
        localObject1 = null;
        break label528;
        label715:
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          i = 2;
        } else {
          i = 0;
        }
      }
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n
 * JD-Core Version:    0.7.0.1
 */