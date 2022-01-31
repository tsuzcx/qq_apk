package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class a
  implements as, com.tencent.mm.pluginsdk.b.a, n.b
{
  private ad contact;
  Context context;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bkc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(24695);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    int i;
    if (localObject != null)
    {
      ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298758));
      if (bool3)
      {
        i = 1;
        ((HelperHeaderPreference)localObject).sb(i);
      }
    }
    else
    {
      this.screen.cl("contact_info_shake_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label149;
      }
      bool1 = true;
      label104:
      ((f)localObject).cl("contact_info_shake_go_shake", bool1);
      localObject = this.screen;
      if (bool3) {
        break label154;
      }
    }
    label149:
    label154:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cl("contact_info_shake_uninstall", bool1);
      AppMethodBeat.o(24695);
      return;
      i = 0;
      break;
      bool1 = false;
      break label104;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(24693);
    if ((r.Zy() & 0x100) == 0)
    {
      AppMethodBeat.o(24693);
      return true;
    }
    AppMethodBeat.o(24693);
    return false;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(24696);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new a.2(paramBoolean);
      new Timer().schedule(new a.3(paramContext, (ak)localObject), 1500L);
      AppMethodBeat.o(24696);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(24692);
    ab.d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(24692);
      return false;
    }
    if (paramString.equals("contact_info_shake_go_shake"))
    {
      paramString = new Intent();
      paramString.setClass(this.context, ShakeReportUI.class);
      this.context.startActivity(paramString);
      ((Activity)this.context).finish();
      AppMethodBeat.o(24692);
      return true;
    }
    if (paramString.equals("contact_info_shake_install"))
    {
      u(this.context, true);
      AppMethodBeat.o(24692);
      return true;
    }
    if (paramString.equals("contact_info_shake_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.1(this), null);
      AppMethodBeat.o(24692);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(24692);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(24699);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    aw.aaz();
    if ((paramn != c.Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(24699);
      return;
    }
    if ((i != 7) && (i != 34))
    {
      AppMethodBeat.o(24699);
      return;
    }
    bkc();
    AppMethodBeat.o(24699);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(24694);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.oi(paramad.field_username));
      aw.aaz();
      c.Ru().a(this);
      aw.aaz();
      c.a(this);
      this.contact = paramad;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131165222);
      bkc();
      AppMethodBeat.o(24694);
      return true;
    }
  }
  
  public final void aaq()
  {
    AppMethodBeat.i(24698);
    bkc();
    AppMethodBeat.o(24698);
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(24697);
    aw.aaz();
    c.Ru().b(this);
    aw.aaz();
    c.b(this);
    com.tencent.mm.plugin.shake.a.gmP.BO();
    AppMethodBeat.o(24697);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a
 * JD-Core Version:    0.7.0.1
 */