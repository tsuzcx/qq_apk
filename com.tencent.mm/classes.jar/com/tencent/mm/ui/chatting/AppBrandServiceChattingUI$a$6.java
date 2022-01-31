package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.c.d;

public final class AppBrandServiceChattingUI$a$6
  extends c.d
{
  public AppBrandServiceChattingUI$a$6(AppBrandServiceChattingUI.a parama, a parama1, c paramc)
  {
    super(parama1, paramc);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    y.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
    paramView.getTag();
    if (parambi.ctB()) {
      super.a(paramView, parama, parambi);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (!parambi.aVK()) {
          break;
        }
        localObject = parambi.field_content;
      } while (localObject == null);
      localObject = g.a.gp((String)localObject);
    } while (localObject == null);
    if ((AppBrandServiceChattingUI.a.b(this.vhk) == 2) && (((g.a)localObject).type == 33) && (AppBrandServiceChattingUI.a.c(this.vhk).appId.equals(((g.a)localObject).dSZ)))
    {
      AppBrandServiceChattingUI.a.a(this.vhk, ((g.a)localObject).dSX);
      return;
    }
    super.a(paramView, parama, parambi);
    return;
    super.a(paramView, parama, parambi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.6
 * JD-Core Version:    0.7.0.1
 */