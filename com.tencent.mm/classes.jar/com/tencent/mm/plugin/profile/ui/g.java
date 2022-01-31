package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.hz;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;

public final class g
  extends l
  implements m.b
{
  public g(Context paramContext)
  {
    super(paramContext, new q(paramContext));
    paramContext = new hz();
    a.udP.m(paramContext);
  }
  
  public static void adg()
  {
    au.Hx();
    c.Fy().HG("feedsapp");
    au.Hx();
    c.FB().abu("feedsapp");
  }
  
  protected final boolean bsD()
  {
    return (com.tencent.mm.model.q.Gu() & 0x8000) == 0;
  }
  
  protected final void clear() {}
  
  protected final void ie(boolean paramBoolean)
  {
    Context localContext = this.context;
    if (paramBoolean) {}
    for (String str = localContext.getString(R.l.settings_plugins_installing);; str = localContext.getString(R.l.settings_plugins_uninstalling))
    {
      localContext.getString(R.l.app_tip);
      new am(new g.1(paramBoolean, h.b(localContext, str, true, null)), false).S(1500L, 1500L);
      return;
    }
  }
  
  public final boolean xQ(String paramString)
  {
    if ("contact_info_plugin_view".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
      d.b(this.context, "sns", ".ui.SnsTimeLineUI", paramString);
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
      h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint_by_sns), "", this.context.getString(R.l.app_stop), this.context.getString(R.l.app_cancel), new g.2(this), null);
      return true;
    }
    return super.xQ(paramString);
  }
  
  protected final int xj()
  {
    return R.o.contact_info_pref_feedsapp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g
 * JD-Core Version:    0.7.0.1
 */