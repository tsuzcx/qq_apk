package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q;
import junit.framework.Assert;

public final class i
  implements a, n.b
{
  private af contact;
  Context context;
  private f screen;
  private HelperHeaderPreference.a uBP;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(27154);
    this.context = paramContext;
    this.uBP = new r(paramContext);
    AppMethodBeat.o(27154);
  }
  
  private void bRv()
  {
    AppMethodBeat.i(27158);
    boolean bool = dcB();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951644);
    ((HelperHeaderPreference)this.screen.aKk("contact_info_header_helper")).a(this.contact, this.uBP);
    if (bool)
    {
      this.screen.cE("contact_info_linkedin_account", false);
      this.screen.aKl("contact_info_linkedin_install");
      AppMethodBeat.o(27158);
      return;
    }
    this.screen.cE("contact_info_linkedin_account", true);
    this.screen.aKl("contact_info_linkedin_uninstall");
    AppMethodBeat.o(27158);
  }
  
  private static boolean dcB()
  {
    AppMethodBeat.i(27155);
    if ((u.aqS() & 0x1000000) == 0)
    {
      AppMethodBeat.o(27155);
      return true;
    }
    AppMethodBeat.o(27155);
    return false;
  }
  
  public static void w(Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(27159);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131763362);; str = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27153);
          if (this.nZT != null) {
            this.nZT.dismiss();
          }
          int i = u.aqS();
          cau localcau;
          if (paramBoolean)
          {
            i &= 0xFEFFFFFF;
            az.arV();
            c.afk().set(34, Integer.valueOf(i));
            localcau = new cau();
            localcau.CuI = 16777216;
            if (!paramBoolean) {
              break label176;
            }
          }
          label176:
          for (i = 0;; i = 1)
          {
            localcau.DXj = i;
            az.arV();
            c.apL().c(new j.a(39, localcau));
            if (this.tvY != null) {
              this.tvY.a(null, null);
            }
            AppMethodBeat.o(27153);
            return false;
            i |= 0x1000000;
            az.arV();
            c.afk().set(286722, "");
            az.arV();
            c.afk().set(286721, "");
            az.arV();
            c.afk().set(286723, "");
            break;
          }
        }
      }, false).av(1500L, 1500L);
      AppMethodBeat.o(27159);
      return;
    }
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(27156);
    ad.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27156);
      return false;
    }
    if (paramString.equals("contact_info_linkedin_install"))
    {
      w(this.context, true);
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
          i.w(i.this.context, false);
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
    ad.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
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
        bRv();
      }
    }
    AppMethodBeat.o(27162);
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27157);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramaf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.sZ(paramaf.field_username));
      az.arV();
      c.afk().a(this);
      this.contact = paramaf;
      this.screen = paramf;
      bRv();
      AppMethodBeat.o(27157);
      return true;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27160);
    az.arV();
    c.afk().b(this);
    this.screen.aKk("contact_info_header_helper");
    b.hYu.Ll();
    AppMethodBeat.o(27160);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27161);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      bRv();
    }
    AppMethodBeat.o(27161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */