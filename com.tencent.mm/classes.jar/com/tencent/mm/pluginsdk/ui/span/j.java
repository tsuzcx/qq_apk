package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public class j
{
  private int OJe = 500;
  private long OJf = 0L;
  Context mContext;
  String mSessionId;
  
  public void a(View paramView, u paramu)
  {
    int j = 0;
    AppMethodBeat.i(152273);
    if (System.currentTimeMillis() - this.OJf <= this.OJe)
    {
      Log.e("MicroMsg.MMSpanClickListener", "process pass");
      AppMethodBeat.o(152273);
      return;
    }
    this.OJf = System.currentTimeMillis();
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
    i locali;
    if ((l.Rsk != null) && (l.Rsk.size() > 0))
    {
      i = l.Rsk.size();
      locali = (i)l.Rsk.getLast();
      Log.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView.getTag() instanceof c)))
      {
        ca localca = ((c)paramView.getTag()).fNz;
        if (localca != null)
        {
          String str = localca.field_talker;
          localObject = str;
          if (ab.PO(str)) {
            localObject = bq.RL(localca.field_content);
          }
          paramu.username = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label589;
          }
          localObject = ((c)paramView.getTag()).fNz;
          if ((localObject == null) || (((et)localObject).field_isSend != 1)) {
            break label589;
          }
          localObject = z.bcZ();
          label265:
          paramu.xyW = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label595;
          }
          localObject = ((c)paramView.getTag()).fNz;
          if (localObject == null) {
            break label595;
          }
          localObject = ((et)localObject).field_content;
          label309:
          paramu.xJA = localObject;
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label601;
          }
          localObject = ((c)paramView.getTag()).fNz;
          if (localObject == null) {
            break label601;
          }
          localObject = ((et)localObject).field_talker;
          label353:
          paramu.chatroomName = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label607;
          }
          localObject = ((c)paramView.getTag()).fNz;
          if ((localObject == null) || (((ca)localObject).getType() != 10000)) {
            break label607;
          }
          i = ((et)localObject).ilw;
          label407:
          paramu.ilw = i;
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label612;
          }
        }
      }
      label589:
      label595:
      label601:
      label607:
      label612:
      for (Object localObject = ((c)paramView.getTag()).fNz;; localObject = null)
      {
        paramu.fNz = ((ca)localObject);
        i = j;
        if (paramView != null)
        {
          i = j;
          if ((paramView.getTag() instanceof c)) {
            i = 1;
          }
        }
        if (i != 0) {
          paramu.fromScene = i;
        }
        if (!TextUtils.isEmpty(this.mSessionId)) {
          paramu.mSessionId = this.mSessionId;
        }
        d.a.RrK.a(this.mContext, paramView, paramu, locali);
        if ((paramView != null) && ((paramView.getTag() instanceof c))) {
          ((b)h.ae(b.class)).asK(paramu.username);
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
        break label265;
        localObject = null;
        break label309;
        localObject = null;
        break label353;
        i = 0;
        break label407;
      }
      locali = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.j
 * JD-Core Version:    0.7.0.1
 */