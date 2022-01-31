package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.a.d;
import java.util.Map;

final class u$1
  implements View.OnClickListener
{
  u$1(u paramu) {}
  
  public final void onClick(View paramView)
  {
    bi localbi = (bi)paramView.getTag(R.h.new_dyeing_template_more_v);
    if (localbi == null) {
      y.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
    }
    do
    {
      return;
      localObject = bn.s(localbi.field_content, "msg");
    } while ((localObject == null) || (((Map)localObject).size() == 0));
    String str = bk.pm((String)((Map)localObject).get(".msg.fromusername"));
    int i = bk.e(((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
    int j = bk.e(((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
    Object localObject = new d(paramView.getContext(), 1, false);
    ((d)localObject).phH = new u.1.1(this, paramView);
    ((d)localObject).phI = new u.1.2(this, paramView, str, i, j, localbi);
    ((d)localObject).cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.1
 * JD-Core Version:    0.7.0.1
 */