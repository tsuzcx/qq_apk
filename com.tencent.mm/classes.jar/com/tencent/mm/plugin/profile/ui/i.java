package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i
  implements a, MStorageEx.IOnStorageChange
{
  private HelperHeaderPreference.a Bfw;
  private as contact;
  private Context context;
  private f screen;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(27154);
    this.context = paramContext;
    this.Bfw = new s(paramContext);
    AppMethodBeat.o(27154);
  }
  
  public static void C(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27159);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131765544);; str = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27153);
          if (this.qDa != null) {
            this.qDa.dismiss();
          }
          int i = z.aUl();
          dbw localdbw;
          if (paramBoolean)
          {
            i &= 0xFEFFFFFF;
            bg.aVF();
            c.azQ().set(34, Integer.valueOf(i));
            localdbw = new dbw();
            localdbw.KEc = 16777216;
            if (!paramBoolean) {
              break label176;
            }
          }
          label176:
          for (i = 0;; i = 1)
          {
            localdbw.MGK = i;
            bg.aVF();
            c.aSM().d(new k.a(39, localdbw));
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27153);
            return false;
            i |= 0x1000000;
            bg.aVF();
            c.azQ().set(286722, "");
            bg.aVF();
            c.azQ().set(286721, "");
            bg.aVF();
            c.azQ().set(286723, "");
            break;
          }
        }
      }, false).startTimer(1500L);
      AppMethodBeat.o(27159);
      return;
    }
  }
  
  private void cCt()
  {
    AppMethodBeat.i(27158);
    boolean bool = eEw();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017181);
    ((HelperHeaderPreference)this.screen.bmg("contact_info_header_helper")).a(this.contact, this.Bfw);
    if (bool)
    {
      this.screen.jdMethod_do("contact_info_linkedin_account", false);
      this.screen.bmi("contact_info_linkedin_install");
      AppMethodBeat.o(27158);
      return;
    }
    this.screen.jdMethod_do("contact_info_linkedin_account", true);
    this.screen.bmi("contact_info_linkedin_uninstall");
    AppMethodBeat.o(27158);
  }
  
  private static boolean eEw()
  {
    AppMethodBeat.i(27155);
    if ((z.aUl() & 0x1000000) == 0)
    {
      AppMethodBeat.o(27155);
      return true;
    }
    AppMethodBeat.o(27155);
    return false;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27157);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Jo(paramas.field_username));
      bg.aVF();
      c.azQ().add(this);
      this.contact = paramas;
      this.screen = paramf;
      cCt();
      AppMethodBeat.o(27157);
      return true;
    }
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(27156);
    Log.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27156);
      return false;
    }
    if (paramString.equals("contact_info_linkedin_install"))
    {
      C(this.context, true);
      AppMethodBeat.o(27156);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_uninstall"))
    {
      h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27152);
          i.C(i.a(i.this), false);
          AppMethodBeat.o(27152);
        }
      }, null);
      AppMethodBeat.o(27156);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_account"))
    {
      Intent localIntent = new Intent(this.context, BindLinkedInUI.class);
      ((Activity)this.context).startActivityForResult(localIntent, 1);
    }
    Log.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27156);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27160);
    bg.aVF();
    c.azQ().remove(this);
    this.screen.bmg("contact_info_header_helper");
    b.jRu.WZ();
    AppMethodBeat.o(27160);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27161);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      cCt();
    }
    AppMethodBeat.o(27161);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27162);
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if ((paramInt == 40) || (paramInt == 34)) {
        cCt();
      }
    }
    AppMethodBeat.o(27162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */