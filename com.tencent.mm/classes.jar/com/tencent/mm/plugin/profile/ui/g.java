package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.id;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.be;

public final class g
  extends l
  implements n.b
{
  public g(Context paramContext)
  {
    super(paramContext, new r(paramContext));
    AppMethodBeat.i(23522);
    paramContext = new id();
    a.ymk.l(paramContext);
    AppMethodBeat.o(23522);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(23523);
    aw.aaz();
    c.YC().Ts("feedsapp");
    aw.aaz();
    c.YF().arF("feedsapp");
    AppMethodBeat.o(23523);
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23527);
    if ("contact_info_plugin_view".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
      d.b(this.context, "sns", ".ui.SnsTimeLineUI", paramString);
      AppMethodBeat.o(23527);
      return true;
    }
    Intent localIntent;
    if ("contact_info_plugin_outsize".equals(paramString))
    {
      localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 4L);
      d.b(this.context, "sns", ".ui.SnsBlackDetailUI", localIntent);
    }
    if ("contact_info_plugin_black".equals(paramString))
    {
      localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 5L);
      d.b(this.context, "sns", ".ui.SnsTagDetailUI", localIntent);
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131303385), "", this.context.getString(2131297084), this.context.getString(2131296888), new g.2(this), null);
      AppMethodBeat.o(23527);
      return true;
    }
    boolean bool = super.Ke(paramString);
    AppMethodBeat.o(23527);
    return bool;
  }
  
  protected final boolean ccj()
  {
    AppMethodBeat.i(23526);
    if ((com.tencent.mm.model.r.Zy() & 0x8000) == 0)
    {
      AppMethodBeat.o(23526);
      return true;
    }
    AppMethodBeat.o(23526);
    return false;
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(23524);
    clearData();
    AppMethodBeat.o(23524);
  }
  
  protected final void kd(boolean paramBoolean)
  {
    AppMethodBeat.i(23525);
    Context localContext = this.context;
    if (paramBoolean) {}
    for (String str = localContext.getString(2131303380);; str = localContext.getString(2131303388))
    {
      localContext.getString(2131297087);
      new ap(new g.1(paramBoolean, com.tencent.mm.ui.base.h.b(localContext, str, true, null)), false).ag(1500L, 1500L);
      AppMethodBeat.o(23525);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g
 * JD-Core Version:    0.7.0.1
 */