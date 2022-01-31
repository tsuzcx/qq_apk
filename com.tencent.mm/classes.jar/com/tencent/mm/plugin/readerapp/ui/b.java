package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private ad contact;
  Context context;
  private f screen;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bkc()
  {
    AppMethodBeat.i(76794);
    boolean bool1 = isOpen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165220);
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298719));
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      ((HelperHeaderPreference)localObject).sb(i);
      localObject = (CheckBoxPreference)this.screen.atx("contact_info_readerappnews_recv_remind");
      boolean bool2 = c.cfj();
      ab.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(bool2)));
      ((CheckBoxPreference)localObject).vxW = bool2;
      if (!bool1) {
        break;
      }
      this.screen.aty("contact_info_readerappnews_install");
      AppMethodBeat.o(76794);
      return;
    }
    this.screen.aty("contact_info_readerappnews_subscribe");
    this.screen.aty("contact_info_readerappnews_view");
    this.screen.aty("contact_info_readerappnews_clear_data");
    this.screen.aty("contact_info_readerappnews_uninstall");
    this.screen.aty("contact_info_readerappnews_recv_remind");
    AppMethodBeat.o(76794);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(76790);
    if ((r.Zy() & 0x80000) == 0)
    {
      AppMethodBeat.o(76790);
      return true;
    }
    AppMethodBeat.o(76790);
    return false;
  }
  
  static void kq(boolean paramBoolean)
  {
    AppMethodBeat.i(76791);
    int i = r.Zt();
    if (paramBoolean)
    {
      i &= 0xFFFFFBFF;
      com.tencent.mm.kernel.g.RL().Ru().set(40, Integer.valueOf(i));
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (i = 2;; i = 1)
    {
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new com.tencent.mm.az.g(26, i));
      AppMethodBeat.o(76791);
      return;
      i |= 0x400;
      break;
    }
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(76795);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      paramContext = new b.3(paramBoolean, paramContext);
      new Timer().schedule(new b.4((ProgressDialog)localObject, paramContext), 5000L);
      AppMethodBeat.o(76795);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(76792);
    ab.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(76792);
      return false;
    }
    if (paramString.equals("contact_info_readerappnews_view"))
    {
      paramString = new Intent(this.context, ReaderAppUI.class);
      paramString.putExtra("type", 20);
      this.context.startActivity(paramString);
      com.tencent.mm.plugin.readerapp.b.a.gmP.BO();
      AppMethodBeat.o(76792);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_subscribe"))
    {
      paramString = new Intent(this.context, ReaderAppSubscribeUI.class);
      this.context.startActivity(paramString);
      AppMethodBeat.o(76792);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_clear_data"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131298572), "", this.context.getString(2131296891), this.context.getString(2131296888), new b.1(this), null);
      AppMethodBeat.o(76792);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.screen.atx(paramString);
      boolean bool3 = c.cfj();
      if (!bool3)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(15413, new Object[] { Integer.valueOf(7), "", "" });
        if (bool3) {
          break label332;
        }
      }
      label332:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramString.vxW = bool1;
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        kq(bool1);
        AppMethodBeat.o(76792);
        return true;
        com.tencent.mm.plugin.report.service.h.qsU.e(15413, new Object[] { Integer.valueOf(6), "", "" });
        break;
      }
    }
    if (paramString.equals("contact_info_readerappnews_install"))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(15413, new Object[] { Integer.valueOf(5), "", "" });
      u(this.context, true);
      AppMethodBeat.o(76792);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_uninstall"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new b.2(this), null);
      AppMethodBeat.o(76792);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(76792);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(76797);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.RL().Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(76797);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(76797);
      return;
    }
    bkc();
    AppMethodBeat.o(76797);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(76793);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.ok(paramad.field_username));
      com.tencent.mm.kernel.g.RL().Ru().a(this);
      this.contact = paramad;
      this.screen = paramf;
      bkc();
      AppMethodBeat.o(76793);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(76796);
    com.tencent.mm.kernel.g.RL().Ru().b(this);
    com.tencent.mm.plugin.readerapp.b.a.gmP.BO();
    AppMethodBeat.o(76796);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b
 * JD-Core Version:    0.7.0.1
 */