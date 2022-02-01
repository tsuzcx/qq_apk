package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.h;
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
    paramContext = new jp();
    a.IvT.l(paramContext);
    AppMethodBeat.o(27137);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(27138);
    bc.aCg();
    c.azI().arj("feedsapp");
    bc.aCg();
    c.azL().aUY("feedsapp");
    AppMethodBeat.o(27138);
  }
  
  public final boolean abx(String paramString)
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
      h.e(this.context, this.context.getString(2131763367), "", this.context.getString(2131755902), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27136);
          g.this.pz(false);
          AppMethodBeat.o(27136);
        }
      }, null);
      AppMethodBeat.o(27142);
      return true;
    }
    boolean bool = super.abx(paramString);
    AppMethodBeat.o(27142);
    return bool;
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(27139);
    clearData();
    AppMethodBeat.o(27139);
  }
  
  protected final boolean dEc()
  {
    AppMethodBeat.i(27141);
    if ((v.aAO() & 0x8000) == 0)
    {
      AppMethodBeat.o(27141);
      return true;
    }
    AppMethodBeat.o(27141);
    return false;
  }
  
  protected final void pz(boolean paramBoolean)
  {
    AppMethodBeat.i(27140);
    Context localContext = this.context;
    if (paramBoolean) {}
    for (String str = localContext.getString(2131763362);; str = localContext.getString(2131763370))
    {
      localContext.getString(2131755906);
      new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27135);
          int i = v.aAO();
          if (this.pyd) {
            i &= 0xFFFF7FFF;
          }
          for (;;)
          {
            bc.aCg();
            c.ajA().set(34, Integer.valueOf(i));
            bc.aCg();
            c.azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.pyd) {
              g.clearData();
            }
            if (this.vTv != null) {
              this.vTv.a(null, null);
            }
            if (this.pnC != null) {
              this.pnC.dismiss();
            }
            AppMethodBeat.o(27135);
            return true;
            i |= 0x8000;
          }
        }
      }, false).ay(1500L, 1500L);
      AppMethodBeat.o(27140);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g
 * JD-Core Version:    0.7.0.1
 */