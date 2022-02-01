package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class n
  implements a, n.b
{
  private ai contact;
  Context context;
  private f screen;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bYK()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27222);
    boolean bool2 = dqj();
    Object localObject = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757898));
    int i;
    if (bool2)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cK("contact_info_voiceinput_install", bool2);
      localObject = this.screen;
      if (bool2) {
        break label114;
      }
    }
    for (;;)
    {
      ((f)localObject).cK("contact_info_voiceinput_uninstall", bool1);
      AppMethodBeat.o(27222);
      return;
      i = 0;
      break;
      label114:
      bool1 = false;
    }
  }
  
  private static boolean dqj()
  {
    AppMethodBeat.i(27219);
    if ((u.axI() & 0x2000000) == 0)
    {
      AppMethodBeat.o(27219);
      return true;
    }
    AppMethodBeat.o(27219);
    return false;
  }
  
  public static void x(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27223);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new ao()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27217);
          int i = u.axI();
          if (this.oNP)
          {
            i &= 0xFDFFFFFF;
            az.ayM();
            c.agA().set(34, Integer.valueOf(i));
            paramAnonymousMessage = new cft();
            paramAnonymousMessage.DNd = 33554432;
            if (!this.oNP) {
              break label119;
            }
          }
          label119:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.Fuc = i;
            az.ayM();
            c.awA().c(new j.a(39, paramAnonymousMessage));
            if (this.uEr != null) {
              this.uEr.a(null, null);
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
          if (this.oDo != null)
          {
            this.oDo.dismiss();
            this.tAL.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27218);
        }
      }, 1500L);
      AppMethodBeat.o(27223);
      return;
    }
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27220);
    ac.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27220);
      return false;
    }
    if (paramString.equals("contact_info_voiceinput_install"))
    {
      x(this.context, true);
      AppMethodBeat.o(27220);
      return true;
    }
    if (paramString.equals("contact_info_voiceinput_uninstall"))
    {
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27216);
          n.x(n.this.context, false);
          AppMethodBeat.o(27216);
        }
      }, null);
      AppMethodBeat.o(27220);
      return true;
    }
    ac.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27220);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(27225);
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.ayM();
    if ((paramn != c.agA()) || (i <= 0))
    {
      ac.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(27225);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(27225);
      return;
    }
    bYK();
    AppMethodBeat.o(27225);
  }
  
  public final boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27221);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramai != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.xb(paramai.field_username));
      az.ayM();
      c.agA().a(this);
      this.contact = paramai;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951660);
      bYK();
      AppMethodBeat.o(27221);
      return true;
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27224);
    az.ayM();
    c.agA().b(this);
    b.iyy.Lj();
    AppMethodBeat.o(27224);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n
 * JD-Core Version:    0.7.0.1
 */