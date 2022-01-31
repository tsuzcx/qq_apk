package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.readerapp.a.h;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.Timer;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.pluginsdk.b.a, m.b
{
  Context context;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void awY()
  {
    int j = 1;
    int i;
    Object localObject;
    if ((q.Gu() & 0x80000) == 0)
    {
      i = 1;
      this.dnn.removeAll();
      this.dnn.addPreferencesFromResource(a.h.contact_info_pref_readerappnews);
      localObject = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(a.g.contact_info_readerappnews_tip));
      if (i == 0) {
        break label161;
      }
    }
    for (;;)
    {
      ((HelperHeaderPreference)localObject).ov(j);
      localObject = (CheckBoxPreference)this.dnn.add("contact_info_readerappnews_recv_remind");
      boolean bool = c.buX();
      y.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = " + bool);
      ((CheckBoxPreference)localObject).rHo = bool;
      if (i == 0) {
        break label166;
      }
      this.dnn.ade("contact_info_readerappnews_install");
      return;
      i = 0;
      break;
      label161:
      j = 0;
    }
    label166:
    this.dnn.ade("contact_info_readerappnews_subscribe");
    this.dnn.ade("contact_info_readerappnews_view");
    this.dnn.ade("contact_info_readerappnews_clear_data");
    this.dnn.ade("contact_info_readerappnews_uninstall");
    this.dnn.ade("contact_info_readerappnews_recv_remind");
  }
  
  static void io(boolean paramBoolean)
  {
    int i = q.Gp();
    if (paramBoolean)
    {
      i &= 0xFFFFFBFF;
      g.DP().Dz().o(40, Integer.valueOf(i));
      if (!paramBoolean) {
        break label73;
      }
    }
    label73:
    for (i = 2;; i = 1)
    {
      ((j)g.r(j.class)).Fv().b(new com.tencent.mm.ay.f(26, i));
      return;
      i |= 0x400;
      break;
    }
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(a.g.settings_plugins_installing);; localObject = paramContext.getString(a.g.settings_plugins_uninstalling))
    {
      paramContext.getString(a.g.app_tip);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      paramContext = new b.3(paramBoolean, paramContext);
      new Timer().schedule(new b.4((ProgressDialog)localObject, paramContext), 5000L);
      return;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != g.DP().Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while ((i != 40) && (i != 34) && (i != 7)) {
      return;
    }
    awY();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(s.hB(paramad.field_username));
      g.DP().Dz().a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    g.DP().Dz().b(this);
    com.tencent.mm.plugin.readerapp.b.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    boolean bool2 = false;
    y.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_readerappnews_view"))
    {
      paramString = new Intent(this.context, ReaderAppUI.class);
      paramString.putExtra("type", 20);
      this.context.startActivity(paramString);
      com.tencent.mm.plugin.readerapp.b.a.eUS.tk();
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_subscribe"))
    {
      paramString = new Intent(this.context, ReaderAppSubscribeUI.class);
      this.context.startActivity(paramString);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.g.contact_info_clear_data_alert), "", this.context.getString(a.g.app_clear), this.context.getString(a.g.app_cancel), new b.1(this), null);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_recv_remind"))
    {
      paramString = (CheckBoxPreference)this.dnn.add(paramString);
      boolean bool3 = c.buX();
      if (!bool3)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15413, new Object[] { Integer.valueOf(7), "", "" });
        if (bool3) {
          break label312;
        }
      }
      label312:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramString.rHo = bool1;
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        io(bool1);
        return true;
        com.tencent.mm.plugin.report.service.h.nFQ.f(15413, new Object[] { Integer.valueOf(6), "", "" });
        break;
      }
    }
    if (paramString.equals("contact_info_readerappnews_install"))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(15413, new Object[] { Integer.valueOf(5), "", "" });
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_readerappnews_uninstall"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.g.settings_plugins_uninstall_hint), "", this.context.getString(a.g.app_clear), this.context.getString(a.g.app_cancel), new b.2(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b
 * JD-Core Version:    0.7.0.1
 */