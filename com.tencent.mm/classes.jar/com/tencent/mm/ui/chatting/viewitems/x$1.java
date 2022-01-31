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

final class x$1
  implements View.OnClickListener
{
  x$1(x paramx) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33127);
    bi localbi = (bi)paramView.getTag(2131822533);
    if (localbi == null)
    {
      ab.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
      AppMethodBeat.o(33127);
      return;
    }
    Object localObject = br.F(localbi.field_content, "msg");
    if ((localObject == null) || (((Map)localObject).size() == 0))
    {
      AppMethodBeat.o(33127);
      return;
    }
    String str = bo.nullAsNil((String)((Map)localObject).get(".msg.fromusername"));
    int i = bo.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
    int j = bo.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
    localObject = new d(paramView.getContext(), 1, false);
    ((d)localObject).sao = new x.1.1(this, paramView);
    ((d)localObject).sap = new x.1.2(this, paramView, str, i, j, localbi);
    ((d)localObject).crd();
    AppMethodBeat.o(33127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.1
 * JD-Core Version:    0.7.0.1
 */