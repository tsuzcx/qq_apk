package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.c.d;

public final class AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3
  extends c.d
{
  public AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3(AppBrandServiceChattingUI.AppBrandServiceChattingFmUI paramAppBrandServiceChattingFmUI, a parama, c paramc)
  {
    super(parama, paramc);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(30351);
    ab.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
    paramView.getTag();
    if (parambi.dvX())
    {
      super.a(paramView, parama, parambi);
      AppMethodBeat.o(30351);
      return;
    }
    if (parambi.bCn())
    {
      Object localObject = parambi.field_content;
      if (localObject == null)
      {
        AppMethodBeat.o(30351);
        return;
      }
      localObject = j.b.mY((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(30351);
        return;
      }
      if ((AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.b(this.zwg) == 2) && (((j.b)localObject).type == 33) && (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.c(this.zwg).appId.equals(((j.b)localObject).fiY)))
      {
        AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.a(this.zwg, ((j.b)localObject).fiW);
        AppMethodBeat.o(30351);
        return;
      }
      super.a(paramView, parama, parambi);
      AppMethodBeat.o(30351);
      return;
    }
    super.a(paramView, parama, parambi);
    AppMethodBeat.o(30351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3
 * JD-Core Version:    0.7.0.1
 */