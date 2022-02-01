package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i
  implements a, n.b
{
  private ai contact;
  Context context;
  private f screen;
  private HelperHeaderPreference.a vKI;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(27154);
    this.context = paramContext;
    this.vKI = new r(paramContext);
    AppMethodBeat.o(27154);
  }
  
  private void bYK()
  {
    AppMethodBeat.i(27158);
    boolean bool = dqj();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951644);
    ((HelperHeaderPreference)this.screen.aPN("contact_info_header_helper")).a(this.contact, this.vKI);
    if (bool)
    {
      this.screen.cK("contact_info_linkedin_account", false);
      this.screen.aPO("contact_info_linkedin_install");
      AppMethodBeat.o(27158);
      return;
    }
    this.screen.cK("contact_info_linkedin_account", true);
    this.screen.aPO("contact_info_linkedin_uninstall");
    AppMethodBeat.o(27158);
  }
  
  private static boolean dqj()
  {
    AppMethodBeat.i(27155);
    if ((u.axI() & 0x1000000) == 0)
    {
      AppMethodBeat.o(27155);
      return true;
    }
    AppMethodBeat.o(27155);
    return false;
  }
  
  public static void x(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27159);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131763362);; str = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27153);
          if (this.oDo != null) {
            this.oDo.dismiss();
          }
          int i = u.axI();
          cft localcft;
          if (paramBoolean)
          {
            i &= 0xFEFFFFFF;
            az.ayM();
            c.agA().set(34, Integer.valueOf(i));
            localcft = new cft();
            localcft.DNd = 16777216;
            if (!paramBoolean) {
              break label176;
            }
          }
          label176:
          for (i = 0;; i = 1)
          {
            localcft.Fuc = i;
            az.ayM();
            c.awA().c(new j.a(39, localcft));
            if (this.uEr != null) {
              this.uEr.a(null, null);
            }
            AppMethodBeat.o(27153);
            return false;
            i |= 0x1000000;
            az.ayM();
            c.agA().set(286722, "");
            az.ayM();
            c.agA().set(286721, "");
            az.ayM();
            c.agA().set(286723, "");
            break;
          }
        }
      }, false).au(1500L, 1500L);
      AppMethodBeat.o(27159);
      return;
    }
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27156);
    ac.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27156);
      return false;
    }
    if (paramString.equals("contact_info_linkedin_install"))
    {
      x(this.context, true);
      AppMethodBeat.o(27156);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_uninstall"))
    {
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27152);
          i.x(i.this.context, false);
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
    ac.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27156);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(27162);
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if ((paramInt == 40) || (paramInt == 34)) {
        bYK();
      }
    }
    AppMethodBeat.o(27162);
  }
  
  public final boolean a(f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27157);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramai != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.xc(paramai.field_username));
      az.ayM();
      c.agA().a(this);
      this.contact = paramai;
      this.screen = paramf;
      bYK();
      AppMethodBeat.o(27157);
      return true;
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27160);
    az.ayM();
    c.agA().b(this);
    this.screen.aPN("contact_info_header_helper");
    b.iyy.Lj();
    AppMethodBeat.o(27160);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27161);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      bYK();
    }
    AppMethodBeat.o(27161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */