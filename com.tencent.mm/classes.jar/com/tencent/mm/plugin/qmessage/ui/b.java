package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
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
  private boolean mVI;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  static void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = q.Gn();
    if (paramBoolean)
    {
      paramInt1 = i | paramInt1;
      au.Hx();
      c.Dz().o(7, Integer.valueOf(paramInt1));
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      au.Hx();
      c.Fv().b(new com.tencent.mm.ay.f(paramInt2, paramInt1));
      return;
      paramInt1 = i & (paramInt1 ^ 0xFFFFFFFF);
      break;
    }
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new b.7(paramBoolean);
      new Timer().schedule(new b.8(paramContext, (ah)localObject), 5000L);
      return;
    }
  }
  
  private static boolean wi(int paramInt)
  {
    return (q.Gn() & paramInt) != 0;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    au.Hx();
    if (paramm != c.Dz()) {
      return;
    }
    awY();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    if (paramad != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      Assert.assertTrue(s.hs(paramad.field_username));
      bool1 = bool2;
      if (paramf != null) {
        bool1 = true;
      }
      Assert.assertTrue(bool1);
      au.Hx();
      c.Dz().a(this);
      this.dnp = paramad;
      this.mVI = paramBoolean;
      this.dnn = paramf;
      awY();
      return true;
    }
  }
  
  final void awY()
  {
    int j = 1;
    int i;
    boolean bool;
    HelperHeaderPreference localHelperHeaderPreference;
    if ((q.Gu() & 0x20) == 0)
    {
      i = 1;
      bool = wi(64);
      wi(8192);
      this.dnn.removeAll();
      this.dnn.addPreferencesFromResource(R.o.contact_info_pref_qmessage);
      localHelperHeaderPreference = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
      localHelperHeaderPreference.al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(R.l.contact_info_qmessage_tip));
      if (i == 0) {
        break label163;
      }
    }
    for (;;)
    {
      localHelperHeaderPreference.ov(j);
      if (i != 0) {
        break label168;
      }
      this.dnn.ade("contact_info_view_message");
      this.dnn.ade("contact_info_qmessage_recv_offline_msg");
      this.dnn.ade("contact_info_qmessage_uninstall");
      this.dnn.ade("contact_info_qmessage_clear_data");
      return;
      i = 0;
      break;
      label163:
      j = 0;
    }
    label168:
    this.dnn.ade("contact_info_qmessage_install");
    ((CheckBoxPreference)this.dnn.add("contact_info_qmessage_recv_offline_msg")).rHo = bool;
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    com.tencent.mm.plugin.qmessage.a.ncr.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_view_message"))
    {
      paramString = new Intent(this.context, QConversationUI.class);
      if (this.mVI) {
        ((Activity)this.context).setResult(-1, paramString);
      }
      for (;;)
      {
        ((Activity)this.context).finish();
        return true;
        this.context.startActivity(paramString);
      }
    }
    if (paramString.equals("contact_info_qmessage_recv_offline_msg"))
    {
      paramString = (CheckBoxPreference)this.dnn.add(paramString);
      if (paramString.isChecked()) {
        e(64, true, 5);
      }
      for (;;)
      {
        return true;
        if (!wi(8192))
        {
          e(64, false, 5);
          return true;
        }
        com.tencent.mm.ui.base.h.a(this.context, R.l.contact_info_qmessage_close_weixin_online_tip, R.l.app_tip, new b.1(this), new b.2(this, paramString));
      }
    }
    if (paramString.equals("contact_info_qmessage_display_weixin_online"))
    {
      e(8192, ((CheckBoxPreference)this.dnn.add(paramString)).isChecked(), 12);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_clear_data"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.contact_info_clear_data), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new b.3(this), null);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_install"))
    {
      au.Hx();
      if (bk.g((Integer)c.Dz().get(9, null)) == 0)
      {
        com.tencent.mm.ui.base.h.b(this.context, R.l.settings_weibo_notice, R.l.app_tip, new b.4(this), new b.5(this));
        return true;
      }
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_qmessage_uninstall"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new b.6(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b
 * JD-Core Version:    0.7.0.1
 */