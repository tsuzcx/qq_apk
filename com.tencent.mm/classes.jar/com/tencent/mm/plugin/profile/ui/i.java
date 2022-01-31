package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i
  implements a, n.b
{
  private ad contact;
  Context context;
  private HelperHeaderPreference.a pAh;
  private f screen;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(23539);
    this.context = paramContext;
    this.pAh = new s(paramContext);
    AppMethodBeat.o(23539);
  }
  
  private void bkc()
  {
    AppMethodBeat.i(23543);
    boolean bool = cck();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165210);
    ((HelperHeaderPreference)this.screen.atx("contact_info_header_helper")).a(this.contact, this.pAh);
    if (bool)
    {
      this.screen.cl("contact_info_linkedin_account", false);
      this.screen.aty("contact_info_linkedin_install");
      AppMethodBeat.o(23543);
      return;
    }
    this.screen.cl("contact_info_linkedin_account", true);
    this.screen.aty("contact_info_linkedin_uninstall");
    AppMethodBeat.o(23543);
  }
  
  private static boolean cck()
  {
    AppMethodBeat.i(23540);
    if ((r.Zy() & 0x1000000) == 0)
    {
      AppMethodBeat.o(23540);
      return true;
    }
    AppMethodBeat.o(23540);
    return false;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(23544);
    if (paramBoolean) {}
    for (String str = paramContext.getString(2131303380);; str = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      new ap(new i.2(h.b(paramContext, str, true, null), paramBoolean), false).ag(1500L, 1500L);
      AppMethodBeat.o(23544);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23541);
    ab.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(23541);
      return false;
    }
    if (paramString.equals("contact_info_linkedin_install"))
    {
      u(this.context, true);
      AppMethodBeat.o(23541);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(23537);
          i.u(i.this.context, false);
          AppMethodBeat.o(23537);
        }
      }, null);
      AppMethodBeat.o(23541);
      return true;
    }
    if (paramString.equals("contact_info_linkedin_account"))
    {
      Intent localIntent = new Intent(this.context, BindLinkedInUI.class);
      ((Activity)this.context).startActivityForResult(localIntent, 1);
    }
    ab.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(23541);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(23547);
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if ((paramInt == 40) || (paramInt == 34)) {
        bkc();
      }
    }
    AppMethodBeat.o(23547);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(23542);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.op(paramad.field_username));
      aw.aaz();
      c.Ru().a(this);
      this.contact = paramad;
      this.screen = paramf;
      bkc();
      AppMethodBeat.o(23542);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23545);
    aw.aaz();
    c.Ru().b(this);
    this.screen.atx("contact_info_header_helper");
    b.gmP.BO();
    AppMethodBeat.o(23545);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23546);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      bkc();
    }
    AppMethodBeat.o(23546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i
 * JD-Core Version:    0.7.0.1
 */