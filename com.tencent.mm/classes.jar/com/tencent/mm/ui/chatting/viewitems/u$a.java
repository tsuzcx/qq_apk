package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.a.d;
import java.util.Map;

final class u$a
  implements View.OnClickListener
{
  private u$a(u paramu) {}
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof bi))
    {
      y.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
      return;
    }
    bi localbi = (bi)paramView.getTag();
    if (localbi == null)
    {
      y.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
      return;
    }
    Object localObject = bn.s(localbi.field_content, "msg");
    if ((localObject == null) || (((Map)localObject).size() == 0))
    {
      y.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
      return;
    }
    localObject = bk.pm((String)((Map)localObject).get(".msg.fromusername"));
    d locald = new d(paramView.getContext(), 1, false);
    locald.phH = new u.a.1(this, paramView);
    locald.phI = new u.a.2(this, paramView, localbi, (String)localObject);
    locald.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a
 * JD-Core Version:    0.7.0.1
 */