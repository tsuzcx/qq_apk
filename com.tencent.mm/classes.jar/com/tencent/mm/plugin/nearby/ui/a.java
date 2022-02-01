package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.x;
import com.tencent.threadpool.i;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.c.a, MStorageEx.IOnStorageChange
{
  private static boolean MoU = true;
  private com.tencent.mm.plugin.nearby.model.c MoS;
  private CheckBox MoT;
  private e MoV;
  private au contact;
  private Context context;
  private View plv;
  private com.tencent.mm.ui.base.preference.f screen;
  private w tipDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(89816);
    this.MoV = null;
    this.context = paramContext;
    this.plv = View.inflate(paramContext, b.d.gli, null);
    this.MoT = ((CheckBox)this.plv.findViewById(b.c.fMB));
    this.MoT.setChecked(false);
    com.tencent.mm.kernel.h.aZW().a(148, this);
    AppMethodBeat.o(89816);
  }
  
  public static void M(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89821);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(b.g.settings_plugins_installing);; localObject = paramContext.getString(b.g.settings_plugins_uninstalling))
    {
      MoU = paramBoolean;
      paramContext.getString(b.g.app_tip);
      paramContext = k.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89814);
          int i = z.bBf();
          if (this.xve) {
            i &= 0xFFFFFDFF;
          }
          for (;;)
          {
            com.tencent.mm.kernel.h.baE().ban().B(34, Integer.valueOf(i));
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new com.tencent.mm.ay.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.xve) {
              com.tencent.mm.plugin.nearby.model.f.gsO();
            }
            if (this.KNw != null) {
              this.KNw.onNotifyChange(null, null);
            }
            AppMethodBeat.o(89814);
            return;
            i |= 0x200;
          }
        }
      };
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89815);
          if (a.this != null)
          {
            a.this.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(89815);
        }
      }, 1500L);
      AppMethodBeat.o(89821);
      return;
    }
  }
  
  private void dvr()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89820);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.bAi("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bz(this.contact.field_username, this.contact.aSV(), this.context.getString(b.g.Mok));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.eh("contact_info_lbs_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label167;
      }
      bool1 = true;
      label97:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_lbs_go_lbs", bool1);
      localObject = this.screen;
      if (bool3) {
        break label172;
      }
      bool1 = true;
      label121:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_lbs_clear_info", bool1);
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
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("contact_info_lbs_uninstall", bool1);
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
    if ((z.bBf() & 0x200) == 0)
    {
      AppMethodBeat.o(89818);
      return true;
    }
    AppMethodBeat.o(89818);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(89819);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramau != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(au.bwd(paramau.field_username));
      com.tencent.mm.kernel.h.baE().ban().add(this);
      Log.v("MicroMsg.ContactWidgetLBS", "listener added");
      this.contact = paramau;
      this.screen = paramf;
      MoU = true;
      paramf.aBe(b.h.Mow);
      dvr();
      AppMethodBeat.o(89819);
      return true;
    }
  }
  
  public final boolean anl(String paramString)
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
      paramString = (Boolean)com.tencent.mm.kernel.h.baE().ban().d(4103, null);
      if ((paramString == null) || (!paramString.booleanValue())) {
        com.tencent.mm.br.c.ai(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
      }
      for (;;)
      {
        AppMethodBeat.o(89817);
        return true;
        paramString = cb.bDf();
        if (paramString == null)
        {
          com.tencent.mm.br.c.ai(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
        }
        else
        {
          String str1 = Util.nullAsNil(paramString.getProvince());
          String str2 = Util.nullAsNil(paramString.getCity());
          int i = paramString.sex;
          if ((str1.equals("")) || (str2.equals("")) || (i == 0))
          {
            com.tencent.mm.br.c.ai(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
          }
          else
          {
            paramString = (Boolean)com.tencent.mm.kernel.h.baE().ban().d(4104, null);
            if ((paramString == null) || (!paramString.booleanValue()))
            {
              com.tencent.mm.bp.a.li(this.context);
              ((Activity)this.context).finish();
            }
            else if (this.MoV == null)
            {
              this.MoV = k.a(this.context, this.context.getString(b.g.app_tip), this.plv, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(89811);
                  paramAnonymousDialogInterface = com.tencent.mm.kernel.h.baE().ban();
                  if (!a.b(a.this).isChecked()) {}
                  for (boolean bool = true;; bool = false)
                  {
                    paramAnonymousDialogInterface.B(4104, Boolean.valueOf(bool));
                    com.tencent.mm.bp.a.li(a.a(a.this));
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
              this.MoV.show();
            }
          }
        }
      }
    }
    if (paramString.equals("contact_info_lbs_install"))
    {
      M(this.context, true);
      AppMethodBeat.o(89817);
      return true;
    }
    if (paramString.equals("contact_info_lbs_clear_info"))
    {
      k.a(this.context, b.g.Mom, b.g.Mol, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89813);
          a.a(a.this, new com.tencent.mm.plugin.nearby.model.c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.h.aZW().a(a.c(a.this), 0);
          paramAnonymousDialogInterface = a.this;
          Context localContext = a.a(a.this);
          a.a(a.this).getString(b.g.app_tip);
          a.a(paramAnonymousDialogInterface, k.a(localContext, a.a(a.this).getString(b.g.Mon), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89812);
              com.tencent.mm.kernel.h.aZW().a(a.c(a.this));
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
      k.b(this.context, this.context.getString(b.g.settings_plugins_uninstall_hint), "", this.context.getString(b.g.app_clear), this.context.getString(b.g.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89810);
          a.M(a.a(a.this), false);
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
  
  public final boolean dvq()
  {
    AppMethodBeat.i(89822);
    com.tencent.mm.kernel.h.baE().ban().remove(this);
    com.tencent.mm.kernel.h.aZW().b(148, this);
    com.tencent.mm.plugin.nearby.a.pFo.aDx();
    AppMethodBeat.o(89822);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(89823);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.baE().ban()) || (i <= 0))
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
    dvr();
    AppMethodBeat.o(89823);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(89824);
    if ((this.MoS == null) && (((com.tencent.mm.plugin.nearby.model.c)paramp).bIO() == 2))
    {
      AppMethodBeat.o(89824);
      return;
    }
    Log.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramp.getType() != 148)
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
    for (paramInt1 = b.g.EHm;; paramInt1 = b.g.EHl)
    {
      if ((((com.tencent.mm.plugin.nearby.model.c)paramp).bIO() == 2) && (MoU))
      {
        k.a(this.context, paramInt1, b.g.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        this.MoS = null;
      }
      AppMethodBeat.o(89824);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a
 * JD-Core Version:    0.7.0.1
 */