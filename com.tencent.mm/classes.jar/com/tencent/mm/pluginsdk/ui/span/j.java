package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
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
  private int HQW = 500;
  private long HQX = 0L;
  Context mContext;
  String mSessionId;
  
  public void a(View paramView, u paramu)
  {
    int j = 0;
    AppMethodBeat.i(152273);
    if (System.currentTimeMillis() - this.HQX <= this.HQW)
    {
      Log.e("MicroMsg.MMSpanClickListener", "process pass");
      AppMethodBeat.o(152273);
      return;
    }
    this.HQX = System.currentTimeMillis();
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
    if ((l.Krd != null) && (l.Krd.size() > 0))
    {
      i = l.Krd.size();
      locali = (i)l.Krd.getLast();
      Log.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView.getTag() instanceof c)))
      {
        ca localca = ((c)paramView.getTag()).dTX;
        if (localca != null)
        {
          String str = localca.field_talker;
          localObject = str;
          if (ab.Iw(str)) {
            localObject = bp.Ks(localca.field_content);
          }
          paramu.username = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label589;
          }
          localObject = ((c)paramView.getTag()).dTX;
          if ((localObject == null) || (((eo)localObject).field_isSend != 1)) {
            break label589;
          }
          localObject = z.aTY();
          label265:
          paramu.tOw = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label595;
          }
          localObject = ((c)paramView.getTag()).dTX;
          if (localObject == null) {
            break label595;
          }
          localObject = ((eo)localObject).field_content;
          label309:
          paramu.tXF = localObject;
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label601;
          }
          localObject = ((c)paramView.getTag()).dTX;
          if (localObject == null) {
            break label601;
          }
          localObject = ((eo)localObject).field_talker;
          label353:
          paramu.chatroomName = ((String)localObject);
          if ((paramView == null) || (!(paramView.getTag() instanceof c))) {
            break label607;
          }
          localObject = ((c)paramView.getTag()).dTX;
          if ((localObject == null) || (((ca)localObject).getType() != 10000)) {
            break label607;
          }
          i = ((eo)localObject).fRg;
          label407:
          paramu.fRg = i;
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
      for (Object localObject = ((c)paramView.getTag()).dTX;; localObject = null)
      {
        paramu.dTX = ((ca)localObject);
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
        d.a.KqD.a(this.mContext, paramView, paramu, locali);
        if ((paramView != null) && ((paramView.getTag() instanceof c))) {
          ((b)g.af(b.class)).akR(paramu.username);
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