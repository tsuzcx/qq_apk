package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class n
  implements a, n.b
{
  private am contact;
  Context context;
  private f screen;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cdo()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27222);
    boolean bool2 = dAM();
    Object localObject = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131757898));
    int i;
    if (bool2)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cP("contact_info_voiceinput_install", bool2);
      localObject = this.screen;
      if (bool2) {
        break label114;
      }
    }
    for (;;)
    {
      ((f)localObject).cP("contact_info_voiceinput_uninstall", bool1);
      AppMethodBeat.o(27222);
      return;
      i = 0;
      break;
      label114:
      bool1 = false;
    }
  }
  
  private static boolean dAM()
  {
    AppMethodBeat.i(27219);
    if ((u.aAy() & 0x2000000) == 0)
    {
      AppMethodBeat.o(27219);
      return true;
    }
    AppMethodBeat.o(27219);
    return false;
  }
  
  public static void z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27223);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27217);
          int i = u.aAy();
          if (this.prx)
          {
            i &= 0xFDFFFFFF;
            ba.aBQ();
            c.ajl().set(34, Integer.valueOf(i));
            paramAnonymousMessage = new cks();
            paramAnonymousMessage.Fsi = 33554432;
            if (!this.prx) {
              break label119;
            }
          }
          label119:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.Heh = i;
            ba.aBQ();
            c.azo().c(new k.a(39, paramAnonymousMessage));
            if (this.vHr != null) {
              this.vHr.a(null, null);
            }
            AppMethodBeat.o(27217);
            return;
            i |= 0x2000000;
            break;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(27218);
          if (this.pgO != null)
          {
            this.pgO.dismiss();
            this.uDu.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27218);
        }
      }, 1500L);
      AppMethodBeat.o(27223);
      return;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(27225);
    int i = bt.m(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    ba.aBQ();
    if ((paramn != c.ajl()) || (i <= 0))
    {
      ad.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(27225);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(27225);
      return;
    }
    cdo();
    AppMethodBeat.o(27225);
  }
  
  public final boolean a(f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27221);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramam != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.zY(paramam.field_username));
      ba.aBQ();
      c.ajl().a(this);
      this.contact = paramam;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951660);
      cdo();
      AppMethodBeat.o(27221);
      return true;
    }
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(27220);
    ad.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27220);
      return false;
    }
    if (paramString.equals("contact_info_voiceinput_install"))
    {
      z(this.context, true);
      AppMethodBeat.o(27220);
      return true;
    }
    if (paramString.equals("contact_info_voiceinput_uninstall"))
    {
      h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27216);
          n.z(n.this.context, false);
          AppMethodBeat.o(27216);
        }
      }, null);
      AppMethodBeat.o(27220);
      return true;
    }
    ad.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27220);
    return false;
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27224);
    ba.aBQ();
    c.ajl().b(this);
    b.iRH.MR();
    AppMethodBeat.o(27224);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n
 * JD-Core Version:    0.7.0.1
 */