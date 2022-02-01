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
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.pluginsdk.b.a, n.b
{
  private static boolean vji = true;
  private ai contact;
  private Context context;
  private View ijI;
  private com.tencent.mm.ui.base.preference.f screen;
  private p tipDialog;
  private c vjg;
  private CheckBox vjh;
  private com.tencent.mm.ui.widget.a.d vjj;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(89816);
    this.vjj = null;
    this.context = paramContext;
    this.ijI = View.inflate(paramContext, 2131494579, null);
    this.vjh = ((CheckBox)this.ijI.findViewById(2131301369));
    this.vjh.setChecked(false);
    com.tencent.mm.kernel.g.agi().a(148, this);
    AppMethodBeat.o(89816);
  }
  
  private void bYK()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89820);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.aPN("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aR(this.contact.field_username, this.contact.aaS(), this.context.getString(2131757699));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cK("contact_info_lbs_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label166;
      }
      bool1 = true;
      label96:
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("contact_info_lbs_go_lbs", bool1);
      localObject = this.screen;
      if (bool3) {
        break label171;
      }
      bool1 = true;
      label120:
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("contact_info_lbs_clear_info", bool1);
      localObject = this.screen;
      if (bool3) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).cK("contact_info_lbs_uninstall", bool1);
      AppMethodBeat.o(89820);
      return;
      i = 0;
      break;
      bool1 = false;
      break label96;
      bool1 = false;
      break label120;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(89818);
    if ((u.axI() & 0x200) == 0)
    {
      AppMethodBeat.o(89818);
      return true;
    }
    AppMethodBeat.o(89818);
    return false;
  }
  
  public static void x(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89821);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      vji = paramBoolean;
      paramContext.getString(2131755906);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new ao()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89814);
          int i = u.axI();
          if (this.oNP) {
            i &= 0xFFFFFDFF;
          }
          for (;;)
          {
            com.tencent.mm.kernel.g.agR().agA().set(34, Integer.valueOf(i));
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.oNP)
            {
              com.tencent.mm.kernel.g.agP().afT();
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco().aZf();
              com.tencent.mm.kernel.g.agi().a(new c(2, 0.0F, 0.0F, 0, 0, "", ""), 0);
            }
            if (this.uEr != null) {
              this.uEr.a(null, null);
            }
            AppMethodBeat.o(89814);
            return;
            i |= 0x200;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(89815);
          if (this.oDw != null)
          {
            this.oDw.dismiss();
            this.tAL.sendEmptyMessage(0);
          }
          AppMethodBeat.o(89815);
        }
      }, 1500L);
      AppMethodBeat.o(89821);
      return;
    }
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(89817);
    ac.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(89817);
      return false;
    }
    if (paramString.equals("contact_info_lbs_go_lbs"))
    {
      paramString = (Boolean)com.tencent.mm.kernel.g.agR().agA().get(4103, null);
      if ((paramString == null) || (!paramString.booleanValue())) {
        com.tencent.mm.br.d.N(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
      }
      for (;;)
      {
        AppMethodBeat.o(89817);
        return true;
        paramString = com.tencent.mm.model.bs.azt();
        if (paramString == null)
        {
          com.tencent.mm.br.d.N(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
        }
        else
        {
          String str1 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramString.getProvince());
          String str2 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramString.getCity());
          int i = paramString.exL;
          if ((str1.equals("")) || (str2.equals("")) || (i == 0))
          {
            com.tencent.mm.br.d.N(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
          }
          else
          {
            paramString = (Boolean)com.tencent.mm.kernel.g.agR().agA().get(4104, null);
            if ((paramString == null) || (!paramString.booleanValue()))
            {
              com.tencent.mm.bp.a.hc(this.context);
              ((Activity)this.context).finish();
            }
            else if (this.vjj == null)
            {
              this.vjj = h.a(this.context, this.context.getString(2131755906), this.ijI, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(89811);
                  paramAnonymousDialogInterface = com.tencent.mm.kernel.g.agR().agA();
                  if (!a.b(a.this).isChecked()) {}
                  for (boolean bool = true;; bool = false)
                  {
                    paramAnonymousDialogInterface.set(4104, Boolean.valueOf(bool));
                    com.tencent.mm.bp.a.hc(a.a(a.this));
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
              this.vjj.show();
            }
          }
        }
      }
    }
    if (paramString.equals("contact_info_lbs_install"))
    {
      x(this.context, true);
      AppMethodBeat.o(89817);
      return true;
    }
    if (paramString.equals("contact_info_lbs_clear_info"))
    {
      h.a(this.context, 2131761495, 2131761494, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89813);
          a.a(a.this, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.g.agi().a(a.c(a.this), 0);
          paramAnonymousDialogInterface = a.this;
          Context localContext = a.a(a.this);
          a.a(a.this).getString(2131755906);
          a.a(paramAnonymousDialogInterface, h.b(localContext, a.a(a.this).getString(2131761498), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89812);
              com.tencent.mm.kernel.g.agi().a(a.c(a.this));
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
      h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(89810);
          a.x(a.a(a.this), false);
          AppMethodBeat.o(89810);
        }
      }, null);
      AppMethodBeat.o(89817);
      return true;
    }
    ac.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(89817);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(89823);
    int i = com.tencent.mm.sdk.platformtools.bs.l(paramObject, 0);
    ac.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.agR().agA()) || (i <= 0))
    {
      ac.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(89823);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(89823);
      return;
    }
    bYK();
    AppMethodBeat.o(89823);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(89819);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramai != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.wU(paramai.field_username));
      com.tencent.mm.kernel.g.agR().agA().a(this);
      ac.v("MicroMsg.ContactWidgetLBS", "listener added");
      this.contact = paramai;
      this.screen = paramf;
      vji = true;
      paramf.addPreferencesFromResource(2131951643);
      bYK();
      AppMethodBeat.o(89819);
      return true;
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(89822);
    com.tencent.mm.kernel.g.agR().agA().b(this);
    com.tencent.mm.kernel.g.agi().b(148, this);
    com.tencent.mm.plugin.nearby.a.iyy.Lj();
    AppMethodBeat.o(89822);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(89824);
    if ((this.vjg == null) && (((c)paramn).Js() == 2))
    {
      AppMethodBeat.o(89824);
      return;
    }
    ac.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 148)
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
    for (paramInt1 = 2131761497;; paramInt1 = 2131761496)
    {
      if ((((c)paramn).Js() == 2) && (vji))
      {
        h.a(this.context, paramInt1, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        this.vjg = null;
      }
      AppMethodBeat.o(89824);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a
 * JD-Core Version:    0.7.0.1
 */