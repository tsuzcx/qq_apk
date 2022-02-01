package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;

public final class g
  extends m
  implements MStorageEx.IOnStorageChange
{
  public g(Context paramContext)
  {
    super(paramContext, new r(paramContext));
    AppMethodBeat.i(27137);
    paramContext = new ke();
    EventCenter.instance.publish(paramContext);
    AppMethodBeat.o(27137);
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(27138);
    bg.aVF();
    com.tencent.mm.model.c.aSQ().aEE("feedsapp");
    bg.aVF();
    com.tencent.mm.model.c.aST().bjW("feedsapp");
    AppMethodBeat.o(27138);
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(27142);
    if ("contact_info_plugin_view".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("sns_timeline_NeedFirstLoadint", true);
      com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsTimeLineUI", paramString);
      AppMethodBeat.o(27142);
      return true;
    }
    Intent localIntent;
    if ("contact_info_plugin_outsize".equals(paramString))
    {
      localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 4L);
      com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsBlackDetailUI", localIntent);
    }
    if ("contact_info_plugin_black".equals(paramString))
    {
      localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 5L);
      com.tencent.mm.br.c.b(this.context, "sns", ".ui.SnsTagDetailUI", localIntent);
    }
    if (paramString.equals("contact_info_plugin_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765549), "", this.context.getString(2131755994), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27136);
          g.this.sH(false);
          AppMethodBeat.o(27136);
        }
      }, null);
      AppMethodBeat.o(27142);
      return true;
    }
    boolean bool = super.alD(paramString);
    AppMethodBeat.o(27142);
    return bool;
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(27139);
    clearData();
    AppMethodBeat.o(27139);
  }
  
  protected final boolean eEv()
  {
    AppMethodBeat.i(27141);
    if ((z.aUl() & 0x8000) == 0)
    {
      AppMethodBeat.o(27141);
      return true;
    }
    AppMethodBeat.o(27141);
    return false;
  }
  
  protected final void sH(boolean paramBoolean)
  {
    AppMethodBeat.i(27140);
    Context localContext = this.context;
    if (paramBoolean) {}
    for (String str = localContext.getString(2131765544);; str = localContext.getString(2131765552))
    {
      localContext.getString(2131755998);
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27135);
          int i = z.aUl();
          if (this.qNu) {
            i &= 0xFFFF7FFF;
          }
          for (;;)
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(34, Integer.valueOf(i));
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.qNu) {
              g.clearData();
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
            }
            if (this.qDi != null) {
              this.qDi.dismiss();
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