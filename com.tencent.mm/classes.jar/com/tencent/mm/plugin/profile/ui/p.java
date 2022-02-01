package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.x;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import junit.framework.Assert;

public final class p
  implements a, MStorageEx.IOnStorageChange
{
  private au contact;
  private Context context;
  private f screen;
  
  public p(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void M(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27223);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = k.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27217);
          int i = z.bBf();
          if (this.xve)
          {
            i &= 0xFDFFFFFF;
            bh.bCz();
            c.ban().B(34, Integer.valueOf(i));
            paramAnonymousMessage = new edx();
            paramAnonymousMessage.YBX = 33554432;
            if (!this.xve) {
              break label119;
            }
          }
          label119:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.abiW = i;
            bh.bCz();
            c.bzz().d(new k.a(39, paramAnonymousMessage));
            if (this.KNw != null) {
              this.KNw.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27217);
            return;
            i |= 0x2000000;
            break;
          }
        }
      };
      h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27218);
          if (p.this != null)
          {
            p.this.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27218);
        }
      }, 1500L);
      AppMethodBeat.o(27223);
      return;
    }
  }
  
  private void dvr()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27222);
    boolean bool2 = gBE();
    Object localObject = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bz(this.contact.field_username, this.contact.aSV(), this.context.getString(R.l.gDb));
    int i;
    if (bool2)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.eh("contact_info_voiceinput_install", bool2);
      localObject = this.screen;
      if (bool2) {
        break label115;
      }
    }
    for (;;)
    {
      ((f)localObject).eh("contact_info_voiceinput_uninstall", bool1);
      AppMethodBeat.o(27222);
      return;
      i = 0;
      break;
      label115:
      bool1 = false;
    }
  }
  
  private static boolean gBE()
  {
    AppMethodBeat.i(27219);
    if ((z.bBf() & 0x2000000) == 0)
    {
      AppMethodBeat.o(27219);
      return true;
    }
    AppMethodBeat.o(27219);
    return false;
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27221);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramau != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(au.bwk(paramau.field_username));
      bh.bCz();
      c.ban().add(this);
      this.contact = paramau;
      this.screen = paramf;
      paramf.aBe(R.o.haY);
      dvr();
      AppMethodBeat.o(27221);
      return true;
    }
  }
  
  public final boolean anl(String paramString)
  {
    AppMethodBeat.i(27220);
    Log.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27220);
      return false;
    }
    if (paramString.equals("contact_info_voiceinput_install"))
    {
      M(this.context, true);
      AppMethodBeat.o(27220);
      return true;
    }
    if (paramString.equals("contact_info_voiceinput_uninstall"))
    {
      k.b(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27216);
          p.M(p.a(p.this), false);
          AppMethodBeat.o(27216);
        }
      }, null);
      AppMethodBeat.o(27220);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27220);
    return false;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27224);
    bh.bCz();
    c.ban().remove(this);
    b.pFo.aDx();
    AppMethodBeat.o(27224);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27225);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bh.bCz();
    if ((paramMStorageEx != c.ban()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(27225);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(27225);
      return;
    }
    dvr();
    AppMethodBeat.o(27225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.p
 * JD-Core Version:    0.7.0.1
 */