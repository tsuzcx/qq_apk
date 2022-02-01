package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;

public class i
{
  private int BpK = 500;
  private long BpL = 0L;
  Context mContext;
  String mSessionId;
  
  public void a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu)
  {
    AppMethodBeat.i(152273);
    if (System.currentTimeMillis() - this.BpL <= this.BpK)
    {
      ac.e("MicroMsg.MMSpanClickListener", "process pass");
      AppMethodBeat.o(152273);
      return;
    }
    this.BpL = System.currentTimeMillis();
    if (paramu == null)
    {
      ac.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
      AppMethodBeat.o(152273);
      return;
    }
    ac.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", new Object[] { Integer.valueOf(paramu.type) });
    if (this.mContext == null)
    {
      ac.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
      AppMethodBeat.o(152273);
      return;
    }
    h localh;
    if ((k.DCu != null) && (k.DCu.size() > 0))
    {
      int i = k.DCu.size();
      localh = (h)k.DCu.getLast();
      ac.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c)))
      {
        bo localbo = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dpq;
        if (localbo != null)
        {
          String str = localbo.field_talker;
          localObject = str;
          if (w.wo(str)) {
            localObject = bi.yl(localbo.field_content);
          }
          paramu.username = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label469;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dpq;
          if ((localObject == null) || (((dy)localObject).field_isSend != 1)) {
            break label469;
          }
          localObject = com.tencent.mm.model.u.axw();
          label262:
          paramu.DrO = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label475;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dpq;
          if (localObject == null) {
            break label475;
          }
          localObject = ((dy)localObject).field_content;
          label306:
          paramu.rnF = localObject;
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label481;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).dpq;
          if (localObject == null) {
            break label481;
          }
        }
      }
      label469:
      label475:
      label481:
      for (Object localObject = ((dy)localObject).field_talker;; localObject = null)
      {
        paramu.chatroomName = ((String)localObject);
        if (!TextUtils.isEmpty(this.mSessionId)) {
          paramu.mSessionId = this.mSessionId;
        }
        c.a.DBW.a(this.mContext, paramu, localh);
        if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
          ((b)g.ab(b.class)).Wm(paramu.username);
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
      }
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.i
 * JD-Core Version:    0.7.0.1
 */