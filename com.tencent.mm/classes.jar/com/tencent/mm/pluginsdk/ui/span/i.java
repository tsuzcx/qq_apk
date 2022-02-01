package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;

public class i
{
  private int DhD = 500;
  private long DhE = 0L;
  Context mContext;
  String mSessionId;
  
  public void a(View paramView, u paramu)
  {
    AppMethodBeat.i(152273);
    if (System.currentTimeMillis() - this.DhE <= this.DhD)
    {
      ae.e("MicroMsg.MMSpanClickListener", "process pass");
      AppMethodBeat.o(152273);
      return;
    }
    this.DhE = System.currentTimeMillis();
    if (paramu == null)
    {
      ae.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
      AppMethodBeat.o(152273);
      return;
    }
    ae.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", new Object[] { Integer.valueOf(paramu.type) });
    if (this.mContext == null)
    {
      ae.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
      AppMethodBeat.o(152273);
      return;
    }
    int i;
    h localh;
    if ((k.FzZ != null) && (k.FzZ.size() > 0))
    {
      i = k.FzZ.size();
      localh = (h)k.FzZ.getLast();
      ae.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      Object localObject;
      if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c)))
      {
        bv localbv = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dCi;
        if (localbv != null)
        {
          String str = localbv.field_talker;
          localObject = str;
          if (x.zT(str)) {
            localObject = bl.BM(localbv.field_content);
          }
          paramu.username = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label522;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dCi;
          if ((localObject == null) || (((ei)localObject).field_isSend != 1)) {
            break label522;
          }
          localObject = v.aAC();
          label262:
          paramu.seP = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label528;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dCi;
          if (localObject == null) {
            break label528;
          }
          localObject = ((ei)localObject).field_content;
          label306:
          paramu.skU = localObject;
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label534;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dCi;
          if (localObject == null) {
            break label534;
          }
          localObject = ((ei)localObject).field_talker;
          label350:
          paramu.chatroomName = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label540;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dCi;
          if ((localObject == null) || (((bv)localObject).getType() != 10000)) {
            break label540;
          }
        }
      }
      label522:
      label528:
      label534:
      label540:
      for (i = ((ei)localObject).fmC;; i = 0)
      {
        paramu.fmC = i;
        if (!TextUtils.isEmpty(this.mSessionId)) {
          paramu.mSessionId = this.mSessionId;
        }
        c.a.FzB.a(this.mContext, paramu, localh);
        if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
          ((b)g.ab(b.class)).aaK(paramu.username);
        }
        paramu.mSessionId = null;
        AppMethodBeat.o(152273);
        return;
        if ((paramView != null) && ((paramView.getTag() instanceof a)))
        {
          localObject = ((a)paramView.getTag()).getUserName();
          break;
        }
        localObject = null;
        break;
        localObject = null;
        break label262;
        localObject = null;
        break label306;
        localObject = null;
        break label350;
      }
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.i
 * JD-Core Version:    0.7.0.1
 */