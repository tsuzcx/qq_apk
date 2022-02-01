package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.bd.l;
import com.tencent.mm.f.a.ku;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.v;

public final class g
  extends m
  implements MStorageEx.IOnStorageChange
{
  public g(Context paramContext)
  {
    super(paramContext, new r(paramContext));
    AppMethodBeat.i(27137);
    paramContext = new ku();
    EventCenter.instance.publish(paramContext);
    AppMethodBeat.o(27137);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(27138);
    bh.beI();
    com.tencent.mm.model.c.bbO().aOO("feedsapp");
    bh.beI();
    com.tencent.mm.model.c.bbR().bwv("feedsapp");
    AppMethodBeat.o(27138);
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(27142);
    if ("contact_info_plugin_view".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
      com.tencent.mm.by.c.b(this.context, "sns", ".ui.SnsTimeLineUI", paramString);
      AppMethodBeat.o(27142);
      return true;
    }
    Intent localIntent;
    if ("contact_info_plugin_outsize".equals(paramString))
    {
      localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 4L);
      com.tencent.mm.by.c.b(this.context, "sns", ".ui.SnsBlackDetailUI", localIntent);
    }
    if ("contact_info_plugin_black".equals(paramString))
    {
      localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 5L);
      com.tencent.mm.by.c.b(this.context, "sns", ".ui.SnsTagDetailUI", localIntent);
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.c(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint_by_sns), "", this.context.getString(R.l.app_stop), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27136);
          g.this.vY(false);
          AppMethodBeat.o(27136);
        }
      }, null);
      AppMethodBeat.o(27142);
      return true;
    }
    boolean bool = super.atw(paramString);
    AppMethodBeat.o(27142);
    return bool;
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(27139);
    clearData();
    AppMethodBeat.o(27139);
  }
  
  protected final boolean fqn()
  {
    AppMethodBeat.i(27141);
    if ((z.bdn() & 0x8000) == 0)
    {
      AppMethodBeat.o(27141);
      return true;
    }
    AppMethodBeat.o(27141);
    return false;
  }
  
  protected final int getResourceId()
  {
    return R.o.eXl;
  }
  
  protected final void vY(boolean paramBoolean)
  {
    AppMethodBeat.i(27140);
    Context localContext = this.context;
    if (paramBoolean) {}
    for (String str = localContext.getString(R.l.settings_plugins_installing);; str = localContext.getString(R.l.settings_plugins_uninstalling))
    {
      localContext.getString(R.l.app_tip);
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27135);
          int i = z.bdn();
          if (this.uoH) {
            i &= 0xFFFF7FFF;
          }
          for (;;)
          {
            bh.beI();
            com.tencent.mm.model.c.aHp().i(34, Integer.valueOf(i));
            bh.beI();
            com.tencent.mm.model.c.bbK().d(new l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.uoH) {
              g.clearData();
            }
            if (this.ESS != null) {
              this.ESS.onNotifyChange(null, null);
            }
            if (this.ucj != null) {
              this.ucj.dismiss();
            }
            AppMethodBeat.o(27135);
            return true;
            i |= 0x8000;
          }
        }
      }, false).startTimer(1500L);
      AppMethodBeat.o(27140);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g
 * JD-Core Version:    0.7.0.1
 */