package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;

public class i
{
  Context mContext;
  String mSessionId;
  private int zXq = 500;
  private long zXr = 0L;
  
  public void a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu)
  {
    AppMethodBeat.i(152273);
    if (System.currentTimeMillis() - this.zXr <= this.zXq)
    {
      ad.e("MicroMsg.MMSpanClickListener", "process pass");
      AppMethodBeat.o(152273);
      return;
    }
    this.zXr = System.currentTimeMillis();
    if (paramu == null)
    {
      ad.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
      AppMethodBeat.o(152273);
      return;
    }
    ad.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", new Object[] { Integer.valueOf(paramu.type) });
    if (this.mContext == null)
    {
      ad.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
      AppMethodBeat.o(152273);
      return;
    }
    h localh;
    if ((k.Ckd != null) && (k.Ckd.size() > 0))
    {
      int i = k.Ckd.size();
      localh = (h)k.Ckd.getLast();
      ad.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c)))
      {
        bl localbl = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).drF;
        if (localbl != null)
        {
          String str = localbl.field_talker;
          localObject = str;
          if (w.sl(str)) {
            localObject = bi.uf(localbl.field_content);
          }
          paramu.username = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label469;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).drF;
          if ((localObject == null) || (((du)localObject).field_isSend != 1)) {
            break label469;
          }
          localObject = com.tencent.mm.model.u.aqG();
          label262:
          paramu.BZx = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label475;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).drF;
          if (localObject == null) {
            break label475;
          }
          localObject = ((du)localObject).field_content;
          label306:
          paramu.BZy = localObject;
          if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
            break label481;
          }
          localObject = ((com.tencent.mm.pluginsdk.ui.chat.c)paramView.getTag()).drF;
          if (localObject == null) {
            break label481;
          }
        }
      }
      label469:
      label475:
      label481:
      for (Object localObject = ((du)localObject).field_talker;; localObject = null)
      {
        paramu.chatroomName = ((String)localObject);
        if (!TextUtils.isEmpty(this.mSessionId)) {
          paramu.mSessionId = this.mSessionId;
        }
        c.a.CjF.a(this.mContext, paramu, localh);
        if ((paramView != null) && ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.ui.chat.c))) {
          ((b)g.ab(b.class)).Sa(paramu.username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.i
 * JD-Core Version:    0.7.0.1
 */