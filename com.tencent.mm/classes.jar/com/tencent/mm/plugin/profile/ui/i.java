package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i
  implements a, n.b
{
  private an contact;
  Context context;
  private f screen;
  private HelperHeaderPreference.a xhI;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(27154);
    this.context = paramContext;
    this.xhI = new r(paramContext);
    AppMethodBeat.o(27154);
  }
  
  private void ceD()
  {
    AppMethodBeat.i(27158);
    boolean bool = dEd();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951644);
    ((HelperHeaderPreference)this.screen.aXe("contact_info_header_helper")).a(this.contact, this.xhI);
    if (bool)
    {
      this.screen.cT("contact_info_linkedin_account", false);
      this.screen.aXf("contact_info_linkedin_install");
      AppMethodBeat.o(27158);
      return;
    }
    this.screen.cT("contact_info_linkedin_account", true);
    this.screen.aXf("contact_info_linkedin_uninstall");
    AppMethodBeat.o(27158);
  }
  
  private static boolean dEd()
  {
    AppMethodBeat.i(27155);
    if ((v.aAO() & 0x1000000) == 0)
    {
      AppMethodBeat.o(27155);
      return true;
    }
    AppMethodBeat.o(27155);
    return false;
  }
  
  public static void z(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27159);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131763362);; str = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      new com.tencent.mm.sdk.platformtools.aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27153);
          if (this.pnu != null) {
            this.pnu.dismiss();
          }
          int i = v.aAO();
          clm localclm;
          if (paramBoolean)
          {
            i &= 0xFEFFFFFF;
            bc.aCg();
            c.ajA().set(34, Integer.valueOf(i));
            localclm = new clm();
            localclm.FKG = 16777216;
            if (!paramBoolean) {
              break label176;
            }
          }
          label176:
          for (i = 0;; i = 1)
          {
            localclm.HxH = i;
            bc.aCg();
            c.azE().d(new k.a(39, localclm));
            if (this.vTv != null) {
              this.vTv.a(null, null);
            }
            AppMethodBeat.o(27153);
            return false;
            i |= 0x1000000;
            bc.aCg();
            c.ajA().set(286722, "");
            bc.aCg();
            c.ajA().set(286721, "");
            bc.aCg();
            c.ajA().set(286723, "");
            break;
          }
        }
      }, false).ay(1500L, 1500L);
      AppMethodBeat.o(27159);
      return;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27162);
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if ((paramInt == 40) || (paramInt == 34)) {
        ceD();
      }
    }
    AppMethodBeat.o(27162);
  }
  
  public final boolean a(f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27157);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paraman != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(x.AJ(paraman.field_username));
      bc.aCg();
      c.ajA().a(this);
      this.contact = paraman;
      this.screen = paramf;
      ceD();
      AppMethodBeat.o(27157);
      return true;
    }
  }
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(27156);
    ae.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27156);
      return false;
    }
    if (paramString.equals("contact_info_linkedin_install"))
    {
      z(this.context, true);
      AppMethodBeat.o(27156);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_uninstall"))
    {
      h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27152);
          i.z(i.this.context, false);
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
    ae.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27156);
    return false;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27160);
    bc.aCg();
    c.ajA().b(this);
    this.screen.aXe("contact_info_header_helper");
    b.iUA.MM();
    AppMethodBeat.o(27160);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27161);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      ceD();
    }
    AppMethodBeat.o(27161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */