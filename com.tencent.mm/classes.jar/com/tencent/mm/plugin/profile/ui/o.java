package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class o
  implements a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private f screen;
  
  public o(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(27223);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      paramContext = h.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(27217);
          int i = z.aUl();
          if (this.qNu)
          {
            i &= 0xFDFFFFFF;
            bg.aVF();
            c.azQ().set(34, Integer.valueOf(i));
            paramAnonymousMessage = new dbw();
            paramAnonymousMessage.KEc = 33554432;
            if (!this.qNu) {
              break label119;
            }
          }
          label119:
          for (i = 0;; i = 1)
          {
            paramAnonymousMessage.MGK = i;
            bg.aVF();
            c.aSM().d(new k.a(39, paramAnonymousMessage));
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
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
          if (this.qDa != null)
          {
            this.qDa.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(27218);
        }
      }, 1500L);
      AppMethodBeat.o(27223);
      return;
    }
  }
  
  private void cCt()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27222);
    boolean bool2 = eEw();
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758138));
    int i;
    if (bool2)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.jdMethod_do("contact_info_voiceinput_install", bool2);
      localObject = this.screen;
      if (bool2) {
        break label114;
      }
    }
    for (;;)
    {
      ((f)localObject).jdMethod_do("contact_info_voiceinput_uninstall", bool1);
      AppMethodBeat.o(27222);
      return;
      i = 0;
      break;
      label114:
      bool1 = false;
    }
  }
  
  private static boolean eEw()
  {
    AppMethodBeat.i(27219);
    if ((z.aUl() & 0x2000000) == 0)
    {
      AppMethodBeat.o(27219);
      return true;
    }
    AppMethodBeat.o(27219);
    return false;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27221);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Jn(paramas.field_username));
      bg.aVF();
      c.azQ().add(this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2132017198);
      cCt();
      AppMethodBeat.o(27221);
      return true;
    }
  }
  
  public final boolean alD(String paramString)
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
      C(this.context, true);
      AppMethodBeat.o(27220);
      return true;
    }
    if (paramString.equals("contact_info_voiceinput_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27216);
          o.C(o.a(o.this), false);
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
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27224);
    bg.aVF();
    c.azQ().remove(this);
    b.jRu.WZ();
    AppMethodBeat.o(27224);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27225);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bg.aVF();
    if ((paramMStorageEx != c.azQ()) || (i <= 0))
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
    cCt();
    AppMethodBeat.o(27225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.o
 * JD-Core Version:    0.7.0.1
 */