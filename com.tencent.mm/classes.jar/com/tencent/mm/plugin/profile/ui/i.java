package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.dlm;
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
import com.tencent.mm.ui.v;
import junit.framework.Assert;

public final class i
  implements a, MStorageEx.IOnStorageChange
{
  private HelperHeaderPreference.a GZu;
  private as contact;
  private Context context;
  private f screen;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(27154);
    this.context = paramContext;
    this.GZu = new s(paramContext);
    AppMethodBeat.o(27154);
  }
  
  public static void F(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27159);
    if (paramBoolean) {}
    for (String str = paramContext.getString(R.l.settings_plugins_installing);; str = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27153);
          if (this.ucb != null) {
            this.ucb.dismiss();
          }
          int i = z.bdn();
          dlm localdlm;
          if (paramBoolean)
          {
            i &= 0xFEFFFFFF;
            bh.beI();
            c.aHp().i(34, Integer.valueOf(i));
            localdlm = new dlm();
            localdlm.RFu = 16777216;
            if (!paramBoolean) {
              break label176;
            }
          }
          label176:
          for (i = 0;; i = 1)
          {
            localdlm.TSy = i;
            bh.beI();
            c.bbK().d(new k.a(39, localdlm));
            if (this.ESS != null) {
              this.ESS.onNotifyChange(null, null);
            }
            AppMethodBeat.o(27153);
            return false;
            i |= 0x1000000;
            bh.beI();
            c.aHp().i(286722, "");
            bh.beI();
            c.aHp().i(286721, "");
            bh.beI();
            c.aHp().i(286723, "");
            break;
          }
        }
      }, false).startTimer(1500L);
      AppMethodBeat.o(27159);
      return;
    }
  }
  
  private void cQY()
  {
    AppMethodBeat.i(27158);
    boolean bool = fqo();
    this.screen.removeAll();
    this.screen.auC(R.o.eXn);
    ((HelperHeaderPreference)this.screen.byG("contact_info_header_helper")).a(this.contact, this.GZu);
    if (bool)
    {
      this.screen.dz("contact_info_linkedin_account", false);
      this.screen.byI("contact_info_linkedin_install");
      AppMethodBeat.o(27158);
      return;
    }
    this.screen.dz("contact_info_linkedin_account", true);
    this.screen.byI("contact_info_linkedin_uninstall");
    AppMethodBeat.o(27158);
  }
  
  private static boolean fqo()
  {
    AppMethodBeat.i(27155);
    if ((z.bdn() & 0x1000000) == 0)
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
      Assert.assertTrue(ab.QH(paramas.field_username));
      bh.beI();
      c.aHp().add(this);
      this.contact = paramas;
      this.screen = paramf;
      cQY();
      AppMethodBeat.o(27157);
      return true;
    }
  }
  
  public final boolean atw(String paramString)
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
      F(this.context, true);
      AppMethodBeat.o(27156);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_uninstall"))
    {
      h.c(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27152);
          i.F(i.a(i.this), false);
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
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27160);
    bh.beI();
    c.aHp().remove(this);
    this.screen.byG("contact_info_header_helper");
    b.mIH.abC();
    AppMethodBeat.o(27160);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27161);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      cQY();
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
        cQY();
      }
    }
    AppMethodBeat.o(27162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */