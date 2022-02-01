package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.k;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.p;

public final class g
  extends l
  implements n.b
{
  public g(Context paramContext)
  {
    super(paramContext, new q(paramContext));
    AppMethodBeat.i(27137);
    paramContext = new iz();
    a.ESL.l(paramContext);
    AppMethodBeat.o(27137);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(27138);
    az.arV();
    c.apO().agw("feedsapp");
    az.arV();
    c.apR().aIl("feedsapp");
    AppMethodBeat.o(27138);
  }
  
  public final boolean SN(String paramString)
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
          g.this.nY(false);
          AppMethodBeat.o(27136);
        }
      }, null);
      AppMethodBeat.o(27142);
      return true;
    }
    boolean bool = super.SN(paramString);
    AppMethodBeat.o(27142);
    return bool;
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(27139);
    clearData();
    AppMethodBeat.o(27139);
  }
  
  protected final boolean dcA()
  {
    AppMethodBeat.i(27141);
    if ((u.aqS() & 0x8000) == 0)
    {
      AppMethodBeat.o(27141);
      return true;
    }
    AppMethodBeat.o(27141);
    return false;
  }
  
  protected final void nY(boolean paramBoolean)
  {
    AppMethodBeat.i(27140);
    Context localContext = this.context;
    if (paramBoolean) {}
    for (String str = localContext.getString(2131763362);; str = localContext.getString(2131763370))
    {
      localContext.getString(2131755906);
      new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27135);
          int i = u.aqS();
          if (this.okp) {
            i &= 0xFFFF7FFF;
          }
          for (;;)
          {
            az.arV();
            c.afk().set(34, Integer.valueOf(i));
            az.arV();
            c.apL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.okp) {
              g.clearData();
            }
            if (this.tvY != null) {
              this.tvY.a(null, null);
            }
            if (this.tvZ != null) {
              this.tvZ.dismiss();
            }
            AppMethodBeat.o(27135);
            return true;
            i |= 0x8000;
          }
        }
      }, false).av(1500L, 1500L);
      AppMethodBeat.o(27140);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g
 * JD-Core Version:    0.7.0.1
 */