package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class j
  implements a, n.b
{
  private static boolean isDeleteCancel = false;
  private ad contact;
  private Context context;
  private f screen;
  
  public j(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bkc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(23560);
    boolean bool3 = isOpen();
    boolean bool4 = ccl();
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298665));
    int i;
    boolean bool1;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).sb(i);
      this.screen.cl("contact_info_medianote_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label246;
      }
      bool1 = true;
      label101:
      ((f)localObject).cl("contact_info_medianote_view", bool1);
      if ((!bool3) || (r.ZT())) {
        break label271;
      }
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("BindQQSwitch"), 1) != 1) {
        break label251;
      }
      bool1 = true;
      label140:
      ab.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
    }
    for (;;)
    {
      localObject = this.screen;
      if (!bool1)
      {
        bool1 = true;
        label159:
        ((f)localObject).cl("contact_info_medianote_sync_to_qqmail", bool1);
        localObject = this.screen;
        if (bool3) {
          break label261;
        }
        bool1 = true;
        label182:
        ((f)localObject).cl("contact_info_medianote_clear_data", bool1);
        localObject = this.screen;
        if (bool3) {
          break label266;
        }
      }
      label261:
      label266:
      for (bool1 = bool2;; bool1 = false)
      {
        ((f)localObject).cl("contact_info_medianote_uninstall", bool1);
        ((CheckBoxPreference)this.screen.atx("contact_info_medianote_sync_to_qqmail")).vxW = bool4;
        AppMethodBeat.o(23560);
        return;
        i = 0;
        break;
        label246:
        bool1 = false;
        break label101;
        label251:
        bool1 = false;
        break label140;
        bool1 = false;
        break label159;
        bool1 = false;
        break label182;
      }
      label271:
      bool1 = bool3;
    }
  }
  
  private static boolean ccl()
  {
    AppMethodBeat.i(23558);
    int i = r.Zr();
    if (!r.ZT())
    {
      if ((i & 0x4000) != 0)
      {
        aw.aaz();
        c.Ru().set(7, Integer.valueOf(i & 0xFFFFBFFF));
      }
      AppMethodBeat.o(23558);
      return false;
    }
    if ((i & 0x4000) != 0)
    {
      AppMethodBeat.o(23558);
      return true;
    }
    AppMethodBeat.o(23558);
    return false;
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(23557);
    if ((r.Zy() & 0x10) == 0)
    {
      AppMethodBeat.o(23557);
      return true;
    }
    AppMethodBeat.o(23557);
    return false;
  }
  
  static void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(23564);
    int i = r.Zr();
    if (paramBoolean)
    {
      i |= 0x4000;
      aw.aaz();
      c.Ru().set(7, Integer.valueOf(i));
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (i = 1;; i = 2)
    {
      aw.aaz();
      c.Yz().c(new com.tencent.mm.az.g(13, i));
      AppMethodBeat.o(23564);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(23561);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      localObject = h.b(paramContext, (String)localObject, true, null);
      paramContext = new j.4(paramBoolean, paramContext);
      new Timer().schedule(new j.5((p)localObject, paramContext), 1500L);
      AppMethodBeat.o(23561);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23556);
    ab.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(23556);
      return false;
    }
    if (paramString.equals("contact_info_medianote_view"))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", "medianote");
      b.gmO.d(paramString, this.context);
      b.gmP.BO();
      AppMethodBeat.o(23556);
      return true;
    }
    if (paramString.equals("contact_info_medianote_sync_to_qqmail"))
    {
      if (!r.ZT())
      {
        h.a(this.context, 2131298664, 2131298663, new j.1(this), null);
        bkc();
      }
      for (;;)
      {
        AppMethodBeat.o(23556);
        return true;
        ke(((CheckBoxPreference)this.screen.atx(paramString)).isChecked());
      }
    }
    if (paramString.equals("contact_info_medianote_clear_data"))
    {
      h.d(this.context, this.context.getString(2131298571), "", this.context.getString(2131296891), this.context.getString(2131296888), new j.2(this), null);
      AppMethodBeat.o(23556);
      return true;
    }
    if (paramString.equals("contact_info_medianote_install"))
    {
      u(this.context, true);
      AppMethodBeat.o(23556);
      return true;
    }
    if (paramString.equals("contact_info_medianote_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new j.3(this), null);
      AppMethodBeat.o(23556);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(23556);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(23563);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    aw.aaz();
    if ((paramn != c.Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(23563);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(23563);
      return;
    }
    bkc();
    AppMethodBeat.o(23563);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(23559);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.oj(paramad.field_username));
      aw.aaz();
      c.Ru().a(this);
      this.contact = paramad;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131165212);
      bkc();
      AppMethodBeat.o(23559);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23562);
    aw.aaz();
    c.Ru().b(this);
    b.gmP.BO();
    AppMethodBeat.o(23562);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j
 * JD-Core Version:    0.7.0.1
 */