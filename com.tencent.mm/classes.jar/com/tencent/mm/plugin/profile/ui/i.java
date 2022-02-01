package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i
  implements a, n.b
{
  private am contact;
  Context context;
  private f screen;
  private HelperHeaderPreference.a wRR;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(27154);
    this.context = paramContext;
    this.wRR = new r(paramContext);
    AppMethodBeat.o(27154);
  }
  
  private void cdo()
  {
    AppMethodBeat.i(27158);
    boolean bool = dAM();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951644);
    ((HelperHeaderPreference)this.screen.aVD("contact_info_header_helper")).a(this.contact, this.wRR);
    if (bool)
    {
      this.screen.cP("contact_info_linkedin_account", false);
      this.screen.aVE("contact_info_linkedin_install");
      AppMethodBeat.o(27158);
      return;
    }
    this.screen.cP("contact_info_linkedin_account", true);
    this.screen.aVE("contact_info_linkedin_uninstall");
    AppMethodBeat.o(27158);
  }
  
  private static boolean dAM()
  {
    AppMethodBeat.i(27155);
    if ((u.aAy() & 0x1000000) == 0)
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
      new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(27153);
          if (this.pgO != null) {
            this.pgO.dismiss();
          }
          int i = u.aAy();
          cks localcks;
          if (paramBoolean)
          {
            i &= 0xFEFFFFFF;
            ba.aBQ();
            c.ajl().set(34, Integer.valueOf(i));
            localcks = new cks();
            localcks.Fsi = 16777216;
            if (!paramBoolean) {
              break label176;
            }
          }
          label176:
          for (i = 0;; i = 1)
          {
            localcks.Heh = i;
            ba.aBQ();
            c.azo().c(new k.a(39, localcks));
            if (this.vHr != null) {
              this.vHr.a(null, null);
            }
            AppMethodBeat.o(27153);
            return false;
            i |= 0x1000000;
            ba.aBQ();
            c.ajl().set(286722, "");
            ba.aBQ();
            c.ajl().set(286721, "");
            ba.aBQ();
            c.ajl().set(286723, "");
            break;
          }
        }
      }, false).az(1500L, 1500L);
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
        cdo();
      }
    }
    AppMethodBeat.o(27162);
  }
  
  public final boolean a(f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27157);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramam != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.zZ(paramam.field_username));
      ba.aBQ();
      c.ajl().a(this);
      this.contact = paramam;
      this.screen = paramf;
      cdo();
      AppMethodBeat.o(27157);
      return true;
    }
  }
  
  public final boolean aaG(String paramString)
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
    ad.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(27156);
    return false;
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27160);
    ba.aBQ();
    c.ajl().b(this);
    this.screen.aVD("contact_info_header_helper");
    b.iRH.MR();
    AppMethodBeat.o(27160);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27161);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      cdo();
    }
    AppMethodBeat.o(27161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */