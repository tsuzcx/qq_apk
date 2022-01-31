package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.aq;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import junit.framework.Assert;

public final class a
  implements aq, com.tencent.mm.pluginsdk.b.a, m.b
{
  Context context;
  private f dnn;
  private ad dnp;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void awY()
  {
    boolean bool3 = true;
    Object localObject;
    int i;
    label74:
    boolean bool2;
    if ((q.Gu() & 0x100) == 0)
    {
      bool1 = true;
      localObject = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
      if (localObject != null)
      {
        ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(R.l.contact_info_shake_tip));
        if (!bool1) {
          break label143;
        }
        i = 1;
        ((HelperHeaderPreference)localObject).ov(i);
      }
      this.dnn.bJ("contact_info_shake_install", bool1);
      localObject = this.dnn;
      if (bool1) {
        break label148;
      }
      bool2 = true;
      label104:
      ((f)localObject).bJ("contact_info_shake_go_shake", bool2);
      localObject = this.dnn;
      if (bool1) {
        break label153;
      }
    }
    label143:
    label148:
    label153:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      ((f)localObject).bJ("contact_info_shake_uninstall", bool1);
      return;
      bool1 = false;
      break;
      i = 0;
      break label74;
      bool2 = false;
      break label104;
    }
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(R.l.settings_plugins_installing);; localObject = paramContext.getString(R.l.settings_plugins_uninstalling))
    {
      paramContext.getString(R.l.app_tip);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new a.2(paramBoolean);
      new Timer().schedule(new a.3(paramContext, (ah)localObject), 1500L);
      return;
    }
  }
  
  public final void Hn()
  {
    awY();
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while ((i != 7) && (i != 34)) {
      return;
    }
    awY();
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
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
      Assert.assertTrue(s.hz(paramad.field_username));
      au.Hx();
      c.Dz().a(this);
      au.Hx();
      c.a(this);
      this.dnp = paramad;
      this.dnn = paramf;
      paramf.addPreferencesFromResource(R.o.contact_info_pref_shake);
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    au.Hx();
    c.Dz().b(this);
    au.Hx();
    c.b(this);
    com.tencent.mm.plugin.shake.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetShake", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_shake_go_shake"))
    {
      paramString = new Intent();
      paramString.setClass(this.context, ShakeReportUI.class);
      this.context.startActivity(paramString);
      ((Activity)this.context).finish();
      return true;
    }
    if (paramString.equals("contact_info_shake_install"))
    {
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_shake_uninstall"))
    {
      h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new a.1(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a
 * JD-Core Version:    0.7.0.1
 */