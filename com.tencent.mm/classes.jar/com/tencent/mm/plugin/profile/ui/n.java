package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
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
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class n
  implements a, n.b
{
  private af contact;
  Context context;
  private f screen;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bRv()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27222);
    boolean bool2 = dcB();
    Object localObject = (HelperHeaderPreference)this.screen.aKk("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757898));
    int i;
    if (bool2)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cE("contact_info_voiceinput_install", bool2);
      localObject = this.screen;
      if (bool2) {
        break label114;
      }
    }
    for (;;)
    {
      ((f)localObject).cE("contact_info_voiceinput_uninstall", bool1);
      AppMethodBeat.o(27222);
      return;
      i = 0;
      break;
      label114:
      bool1 = false;
    }
  }
  
  private static boolean dcB()
  {
    AppMethodBeat.i(27219);
    if ((u.aqS() & 0x2000000) == 0)
    {
      AppMethodBeat.o(27219);
      return true;
    }
    AppMethodBeat.o(27219);
    return false;
  }
  
  public static void w(Context paramContext, boolean paramBoolean)
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
          int i = u.aqS();
          if (this.okp)
          {
            i &= 0xFDFFFFFF;
            az.arV();
            c.afk().set(34, Integer.valueOf(i));
            paramAnonymousMessage = new cau();
            paramAnonymousMessage.CuI = 33554432;
            if (!this.okp) {
              break label119;
            }
          }
          label119:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.DXj = i;
            az.arV();
            c.apL().c(new j.a(39, paramAnonymousMessage));
            if (this.tvY != null) {
              this.tvY.a(null, null);
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
          if (this.nZT != null)
          {
            this.nZT.dismiss();
            this.ssV.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27218);
        }
      }, 1500L);
      AppMethodBeat.o(27223);
      return;
    }
  }
  
  public final boolean SN(String paramString)
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
      w(this.context, true);
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
          n.w(n.this.context, false);
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
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(27225);
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.arV();
    if ((paramn != c.afk()) || (i <= 0))
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
    bRv();
    AppMethodBeat.o(27225);
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27221);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramaf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.sY(paramaf.field_username));
      az.arV();
      c.afk().a(this);
      this.contact = paramaf;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951660);
      bRv();
      AppMethodBeat.o(27221);
      return true;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27224);
    az.arV();
    c.afk().b(this);
    b.hYu.Ll();
    AppMethodBeat.o(27224);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n
 * JD-Core Version:    0.7.0.1
 */