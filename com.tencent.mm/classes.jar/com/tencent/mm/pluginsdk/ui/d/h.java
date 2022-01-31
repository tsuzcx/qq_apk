package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public class h
{
  Context mContext;
  String mSessionId;
  private long ucA = 0L;
  private int ucz = 500;
  
  public void a(View paramView, m paramm)
  {
    AppMethodBeat.i(79817);
    if (System.currentTimeMillis() - this.ucA <= this.ucz)
    {
      ab.e("MicroMsg.MMSpanClickListener", "process pass");
      AppMethodBeat.o(79817);
      return;
    }
    this.ucA = System.currentTimeMillis();
    if (paramm == null)
    {
      ab.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
      AppMethodBeat.o(79817);
      return;
    }
    ab.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", new Object[] { Integer.valueOf(paramm.type) });
    if (this.mContext == null)
    {
      ab.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
      AppMethodBeat.o(79817);
      return;
    }
    g localg;
    if ((j.wco != null) && (j.wco.size() > 0))
    {
      int i = j.wco.size();
      localg = (g)j.wco.getLast();
      ab.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView.getTag() instanceof c)))
      {
        bi localbi = ((c)paramView.getTag()).cEE;
        if (localbi != null)
        {
          String str = localbi.field_talker;
          paramView = str;
          if (t.nI(str)) {
            paramView = bf.pu(localbi.field_content);
          }
        }
      }
      for (;;)
      {
        paramm.username = paramView;
        if (!TextUtils.isEmpty(this.mSessionId)) {
          paramm.mSessionId = this.mSessionId;
        }
        b.a.wbT.a(this.mContext, paramm, localg);
        paramm.mSessionId = null;
        AppMethodBeat.o(79817);
        return;
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          paramView = ((a)paramView.getTag()).getUserName();
        } else {
          paramView = null;
        }
      }
      localg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.h
 * JD-Core Version:    0.7.0.1
 */