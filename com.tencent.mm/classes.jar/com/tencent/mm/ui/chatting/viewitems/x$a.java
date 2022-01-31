package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.b.d;
import java.util.Map;

final class x$a
  implements View.OnClickListener
{
  private x$a(x paramx) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33155);
    if (!(paramView.getTag() instanceof bi))
    {
      ab.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
      AppMethodBeat.o(33155);
      return;
    }
    bi localbi = (bi)paramView.getTag();
    if (localbi == null)
    {
      ab.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
      AppMethodBeat.o(33155);
      return;
    }
    Object localObject = br.F(localbi.field_content, "msg");
    if ((localObject == null) || (((Map)localObject).size() == 0))
    {
      ab.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
      AppMethodBeat.o(33155);
      return;
    }
    localObject = bo.nullAsNil((String)((Map)localObject).get(".msg.fromusername"));
    d locald = new d(paramView.getContext(), 1, false);
    locald.sao = new x.a.1(this, paramView);
    locald.sap = new x.a.2(this, paramView, localbi, (String)localObject);
    locald.crd();
    AppMethodBeat.o(33155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a
 * JD-Core Version:    0.7.0.1
 */