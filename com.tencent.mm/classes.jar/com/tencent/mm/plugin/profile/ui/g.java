package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;

public final class g
  extends l
  implements n.b
{
  public g(Context paramContext)
  {
    super(paramContext, new q(paramContext));
    AppMethodBeat.i(27137);
    paramContext = new jg();
    a.GpY.l(paramContext);
    AppMethodBeat.o(27137);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(27138);
    az.ayM();
    c.awD().alq("feedsapp");
    az.ayM();
    c.awG().aNG("feedsapp");
    AppMethodBeat.o(27138);
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27142);
    if ("contact_info_plugin_view".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
      d.b(this.context, "sns", ".ui.SnsTimeLineUI", paramString);
      AppMethodBeat.o(27142);
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
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763367), "", this.context.getString(2131755902), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27136);
          g.this.oS(false);
          AppMethodBeat.o(27136);
        }
      }, null);
      AppMethodBeat.o(27142);
      return true;
    }
    boolean bool = super.WZ(paramString);
    AppMethodBeat.o(27142);
    return bool;
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(27139);
    clearData();
    AppMethodBeat.o(27139);
  }
  
  protected final boolean dqi()
  {
    AppMethodBeat.i(27141);
    if ((u.axI() & 0x8000) == 0)
    {
      AppMethodBeat.o(27141);
      return true;
    }
    AppMethodBeat.o(27141);
    return false;
  }
  
  protected final void oS(boolean paramBoolean)
  {
    AppMethodBeat.i(27140);
    Context localContext = this.context;
    if (paramBoolean) {}
    for (String str = localContext.getString(2131763362);; str = localContext.getString(2131763370))
    {
      localContext.getString(2131755906);
      new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27135);
          int i = u.axI();
          if (this.oNP) {
            i &= 0xFFFF7FFF;
          }
          for (;;)
          {
            az.ayM();
            c.agA().set(34, Integer.valueOf(i));
            az.ayM();
            c.awA().c(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.oNP) {
              g.clearData();
            }
            if (this.uEr != null) {
              this.uEr.a(null, null);
            }
            if (this.oDw != null) {
              this.oDw.dismiss();
            }
            AppMethodBeat.o(27135);
            return true;
            i |= 0x8000;
          }
        }
      }, false).au(1500L, 1500L);
      AppMethodBeat.o(27140);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g
 * JD-Core Version:    0.7.0.1
 */