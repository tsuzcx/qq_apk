package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.websearch.widget.b.a.1;
import com.tencent.mm.plugin.websearch.widget.b.a.2;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.ui.widget.a.d;

final class c$8
  implements View.OnLongClickListener
{
  c$8(c paramc) {}
  
  public final boolean onLongClick(View paramView)
  {
    if ((this.qXZ.qXS != null) && (bl.csf()))
    {
      Object localObject = this.qXZ.hpb.getContext();
      paramView = new c.8.1(this);
      localObject = new d((Context)localObject, 2, true);
      ((d)localObject).h("当前服务为体验版本，可以选择以下调试功能", 48);
      ((d)localObject).phH = new a.1();
      ((d)localObject).phI = new a.2(paramView);
      ((d)localObject).cfU();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.c.8
 * JD-Core Version:    0.7.0.1
 */