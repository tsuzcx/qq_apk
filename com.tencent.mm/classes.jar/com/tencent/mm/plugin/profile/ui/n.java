package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
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

public final class n
  implements a, n.b
{
  private ad contact;
  Context context;
  private f screen;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bkc()
  {
    boolean bool1 = true;
    AppMethodBeat.i(23607);
    boolean bool2 = cck();
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298830));
    int i;
    if (bool2)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).sb(i);
      this.screen.cl("contact_info_voiceinput_install", bool2);
      localObject = this.screen;
      if (bool2) {
        break label112;
      }
    }
    for (;;)
    {
      ((f)localObject).cl("contact_info_voiceinput_uninstall", bool1);
      AppMethodBeat.o(23607);
      return;
      i = 0;
      break;
      label112:
      bool1 = false;
    }
  }
  
  private static boolean cck()
  {
    AppMethodBeat.i(23604);
    if ((r.Zy() & 0x2000000) == 0)
    {
      AppMethodBeat.o(23604);
      return true;
    }
    AppMethodBeat.o(23604);
    return false;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(23608);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new n.2(paramBoolean);
      new Timer().schedule(new n.3(paramContext, (ak)localObject), 1500L);
      AppMethodBeat.o(23608);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23605);
    ab.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(23605);
      return false;
    }
    if (paramString.equals("contact_info_voiceinput_install"))
    {
      u(this.context, true);
      AppMethodBeat.o(23605);
      return true;
    }
    if (paramString.equals("contact_info_voiceinput_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new n.1(this), null);
      AppMethodBeat.o(23605);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(23605);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(23610);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    aw.aaz();
    if ((paramn != c.Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(23610);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(23610);
      return;
    }
    bkc();
    AppMethodBeat.o(23610);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(23606);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.oo(paramad.field_username));
      aw.aaz();
      c.Ru().a(this);
      this.contact = paramad;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131165226);
      bkc();
      AppMethodBeat.o(23606);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23609);
    aw.aaz();
    c.Ru().b(this);
    b.gmP.BO();
    AppMethodBeat.o(23609);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n
 * JD-Core Version:    0.7.0.1
 */