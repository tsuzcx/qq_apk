package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.plugin.nearby.b.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ah.f, com.tencent.mm.pluginsdk.b.a, m.b
{
  private static boolean mCS = true;
  private Context context;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  private com.tencent.mm.plugin.nearby.a.c mCP;
  private View mCQ;
  private CheckBox mCR;
  private com.tencent.mm.ui.widget.a.c mCT = null;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.mCQ = View.inflate(paramContext, b.e.lbs_open_dialog_view, null);
    this.mCR = ((CheckBox)this.mCQ.findViewById(b.d.lbs_open_dialog_cb));
    this.mCR.setChecked(false);
    g.Dk().a(148, this);
  }
  
  private void awY()
  {
    boolean bool3 = true;
    Object localObject;
    int i;
    label66:
    boolean bool2;
    if ((q.Gu() & 0x200) == 0)
    {
      bool1 = true;
      localObject = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
      ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(b.h.contact_info_lbs_tip));
      if (!bool1) {
        break label157;
      }
      i = 1;
      ((HelperHeaderPreference)localObject).ov(i);
      this.dnn.bJ("contact_info_lbs_install", bool1);
      localObject = this.dnn;
      if (bool1) {
        break label162;
      }
      bool2 = true;
      label96:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_lbs_go_lbs", bool2);
      localObject = this.dnn;
      if (bool1) {
        break label167;
      }
      bool2 = true;
      label118:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_lbs_clear_info", bool2);
      localObject = this.dnn;
      if (bool1) {
        break label172;
      }
    }
    label157:
    label162:
    label167:
    label172:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("contact_info_lbs_uninstall", bool1);
      return;
      bool1 = false;
      break;
      i = 0;
      break label66;
      bool2 = false;
      break label96;
      bool2 = false;
      break label118;
    }
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(b.h.settings_plugins_installing);; localObject = paramContext.getString(b.h.settings_plugins_uninstalling))
    {
      mCS = paramBoolean;
      paramContext.getString(b.h.app_tip);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new ah()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          int i = q.Gu();
          if (this.hZO) {
            i &= 0xFFFFFDFF;
          }
          for (;;)
          {
            g.DP().Dz().o(34, Integer.valueOf(i));
            ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new com.tencent.mm.ay.j("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.hZO)
            {
              g.DN().CX();
              ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhL().aUK();
              g.Dk().a(new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""), 0);
            }
            if (this.hZP != null) {
              this.hZP.a(null, null);
            }
            return;
            i |= 0x200;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          if (this.hZQ != null)
          {
            this.hZQ.dismiss();
            this.hZR.sendEmptyMessage(0);
          }
        }
      }, 1500L);
      return;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != g.DP().Dz()) || (i <= 0)) {
      y.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
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
      Assert.assertTrue(s.hy(paramad.field_username));
      g.DP().Dz().a(this);
      y.v("MicroMsg.ContactWidgetLBS", "listener added");
      this.dnp = paramad;
      this.dnn = paramf;
      mCS = true;
      paramf.addPreferencesFromResource(b.i.contact_info_pref_lbs);
      awY();
      return true;
    }
  }
  
  public final boolean awZ()
  {
    g.DP().Dz().b(this);
    g.Dk().b(148, this);
    com.tencent.mm.plugin.nearby.a.eUS.tk();
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((this.mCP == null) && (((com.tencent.mm.plugin.nearby.a.c)paramm).rN() == 2)) {}
    for (;;)
    {
      return;
      y.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
      if (paramm.getType() == 148)
      {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (paramInt1 = b.h.nearby_friend_clear_location_ok; (((com.tencent.mm.plugin.nearby.a.c)paramm).rN() == 2) && (mCS); paramInt1 = b.h.nearby_friend_clear_location_failed)
        {
          com.tencent.mm.ui.base.h.a(this.context, paramInt1, b.h.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          this.mCP = null;
          return;
        }
      }
    }
  }
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = " + paramString);
    if (bk.pm(paramString).length() <= 0) {
      return false;
    }
    if (paramString.equals("contact_info_lbs_go_lbs"))
    {
      paramString = (Boolean)g.DP().Dz().get(4103, null);
      if ((paramString == null) || (!paramString.booleanValue())) {
        d.x(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
      }
      for (;;)
      {
        return true;
        paramString = bn.Ie();
        if (paramString == null)
        {
          d.x(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
        }
        else
        {
          String str1 = bk.pm(paramString.getProvince());
          String str2 = bk.pm(paramString.getCity());
          int i = paramString.sex;
          if ((str1.equals("")) || (str2.equals("")) || (i == 0))
          {
            d.x(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
          }
          else
          {
            paramString = (Boolean)g.DP().Dz().get(4104, null);
            if ((paramString == null) || (!paramString.booleanValue()))
            {
              com.tencent.mm.bp.a.eF(this.context);
              ((Activity)this.context).finish();
            }
            else if (this.mCT == null)
            {
              this.mCT = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(b.h.app_tip), this.mCQ, new a.2(this), new a.3(this));
            }
            else
            {
              this.mCT.show();
            }
          }
        }
      }
    }
    if (paramString.equals("contact_info_lbs_install"))
    {
      o(this.context, true);
      return true;
    }
    if (paramString.equals("contact_info_lbs_clear_info"))
    {
      com.tencent.mm.ui.base.h.a(this.context, b.h.nearby_friend_clear_location_exit_hint, b.h.nearby_friend_clear_location_exit, new a.4(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return true;
    }
    if (paramString.equals("contact_info_lbs_uninstall"))
    {
      com.tencent.mm.ui.base.h.a(this.context, this.context.getString(b.h.settings_plugins_uninstall_hint), "", this.context.getString(b.h.app_clear), this.context.getString(b.h.app_cancel), new a.1(this), null);
      return true;
    }
    y.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a
 * JD-Core Version:    0.7.0.1
 */