package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.d;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.an.i, com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private static boolean GsU = true;
  private com.tencent.mm.plugin.nearby.a.c GsS;
  private CheckBox GsT;
  private d GsV;
  private as contact;
  private Context context;
  private View mrQ;
  private com.tencent.mm.ui.base.preference.f screen;
  private s tipDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(89816);
    this.GsV = null;
    this.context = paramContext;
    this.mrQ = View.inflate(paramContext, b.d.lbs_open_dialog_view, null);
    this.GsT = ((CheckBox)this.mrQ.findViewById(b.c.lbs_open_dialog_cb));
    this.GsT.setChecked(false);
    com.tencent.mm.kernel.h.aGY().a(148, this);
    AppMethodBeat.o(89816);
  }
  
  public static void F(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89821);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(b.g.settings_plugins_installing);; localObject = paramContext.getString(b.g.settings_plugins_uninstalling))
    {
      GsU = paramBoolean;
      paramContext.getString(b.g.app_tip);
      paramContext = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      localObject = new a.6(paramBoolean);
      com.tencent.e.h.ZvG.o(new a.7(paramContext, (MMHandler)localObject), 1500L);
      AppMethodBeat.o(89821);
      return;
    }
  }
  
  private void cQY()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89820);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bf(this.contact.field_username, this.contact.ays(), this.context.getString(b.g.contact_info_lbs_tip));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.dz("contact_info_lbs_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label167;
      }
      bool1 = true;
      label97:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_lbs_go_lbs", bool1);
      localObject = this.screen;
      if (bool3) {
        break label172;
      }
      bool1 = true;
      label121:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_lbs_clear_info", bool1);
      localObject = this.screen;
      if (bool3) {
        break label177;
      }
    }
    label167:
    label172:
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_lbs_uninstall", bool1);
      AppMethodBeat.o(89820);
      return;
      i = 0;
      break;
      bool1 = false;
      break label97;
      bool1 = false;
      break label121;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(89818);
    if ((z.bdn() & 0x200) == 0)
    {
      AppMethodBeat.o(89818);
      return true;
    }
    AppMethodBeat.o(89818);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(89819);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Qz(paramas.field_username));
      com.tencent.mm.kernel.h.aHG().aHp().add(this);
      Log.v("MicroMsg.ContactWidgetLBS", "listener added");
      this.contact = paramas;
      this.screen = paramf;
      GsU = true;
      paramf.auC(b.h.contact_info_pref_lbs);
      cQY();
      AppMethodBeat.o(89819);
      return true;
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(89817);
    Log.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(89817);
      return false;
    }
    if (paramString.equals("contact_info_lbs_go_lbs"))
    {
      paramString = (Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(4103, null);
      if ((paramString == null) || (!paramString.booleanValue())) {
        com.tencent.mm.by.c.ad(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
      }
      for (;;)
      {
        AppMethodBeat.o(89817);
        return true;
        paramString = ca.bfo();
        if (paramString == null)
        {
          com.tencent.mm.by.c.ad(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
        }
        else
        {
          String str1 = Util.nullAsNil(paramString.getProvince());
          String str2 = Util.nullAsNil(paramString.getCity());
          int i = paramString.sex;
          if ((str1.equals("")) || (str2.equals("")) || (i == 0))
          {
            com.tencent.mm.by.c.ad(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
          }
          else
          {
            paramString = (Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(4104, null);
            if ((paramString == null) || (!paramString.booleanValue()))
            {
              com.tencent.mm.bw.a.jk(this.context);
              ((Activity)this.context).finish();
            }
            else if (this.GsV == null)
            {
              this.GsV = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(b.g.app_tip), this.mrQ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(89811);
                  paramAnonymousDialogInterface = com.tencent.mm.kernel.h.aHG().aHp();
                  if (!a.b(a.this).isChecked()) {}
                  for (boolean bool = true;; bool = false)
                  {
                    paramAnonymousDialogInterface.i(4104, Boolean.valueOf(bool));
                    com.tencent.mm.bw.a.jk(a.a(a.this));
                    ((Activity)a.a(a.this)).finish();
                    AppMethodBeat.o(89811);
                    return;
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
            }
            else
            {
              this.GsV.show();
            }
          }
        }
      }
    }
    if (paramString.equals("contact_info_lbs_install"))
    {
      F(this.context, true);
      AppMethodBeat.o(89817);
      return true;
    }
    if (paramString.equals("contact_info_lbs_clear_info"))
    {
      com.tencent.mm.ui.base.h.a(this.context, b.g.nearby_friend_clear_location_exit_hint, b.g.nearby_friend_clear_location_exit, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89813);
          a.a(a.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.h.aGY().a(a.c(a.this), 0);
          paramAnonymousDialogInterface = a.this;
          Context localContext = a.a(a.this);
          a.a(a.this).getString(b.g.app_tip);
          a.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a(localContext, a.a(a.this).getString(b.g.nearby_friend_clearing_location), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89812);
              com.tencent.mm.kernel.h.aGY().a(a.c(a.this));
              AppMethodBeat.o(89812);
            }
          }));
          AppMethodBeat.o(89813);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(89817);
      return true;
    }
    if (paramString.equals("contact_info_lbs_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(b.g.settings_plugins_uninstall_hint), "", this.context.getString(b.g.app_clear), this.context.getString(b.g.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89810);
          a.F(a.a(a.this), false);
          AppMethodBeat.o(89810);
        }
      }, null);
      AppMethodBeat.o(89817);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89817);
    return false;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(89822);
    com.tencent.mm.kernel.h.aHG().aHp().remove(this);
    com.tencent.mm.kernel.h.aGY().b(148, this);
    com.tencent.mm.plugin.nearby.a.mIH.abC();
    AppMethodBeat.o(89822);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(89823);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.aHG().aHp()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(89823);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(89823);
      return;
    }
    cQY();
    AppMethodBeat.o(89823);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(89824);
    if ((this.GsS == null) && (((com.tencent.mm.plugin.nearby.a.c)paramq).ZB() == 2))
    {
      AppMethodBeat.o(89824);
      return;
    }
    Log.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 148)
    {
      AppMethodBeat.o(89824);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (paramInt1 = b.g.nearby_friend_clear_location_ok;; paramInt1 = b.g.nearby_friend_clear_location_failed)
    {
      if ((((com.tencent.mm.plugin.nearby.a.c)paramq).ZB() == 2) && (GsU))
      {
        com.tencent.mm.ui.base.h.a(this.context, paramInt1, b.g.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        this.GsS = null;
      }
      AppMethodBeat.o(89824);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a
 * JD-Core Version:    0.7.0.1
 */