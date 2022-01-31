package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ai.f, com.tencent.mm.pluginsdk.b.a, n.b
{
  private static boolean pcM = true;
  private ad contact;
  private Context context;
  private com.tencent.mm.plugin.nearby.a.c pcJ;
  private View pcK;
  private CheckBox pcL;
  private com.tencent.mm.ui.widget.b.c pcN;
  private com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(55417);
    this.pcN = null;
    this.context = paramContext;
    this.pcK = View.inflate(paramContext, 2130969978, null);
    this.pcL = ((CheckBox)this.pcK.findViewById(2131825412));
    this.pcL.setChecked(false);
    g.Rc().a(148, this);
    AppMethodBeat.o(55417);
  }
  
  private void bkc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(55421);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131298638));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).sb(i);
      this.screen.cl("contact_info_lbs_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label162;
      }
      bool1 = true;
      label95:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_lbs_go_lbs", bool1);
      localObject = this.screen;
      if (bool3) {
        break label167;
      }
      bool1 = true;
      label118:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_lbs_clear_info", bool1);
      localObject = this.screen;
      if (bool3) {
        break label172;
      }
    }
    label162:
    label167:
    label172:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("contact_info_lbs_uninstall", bool1);
      AppMethodBeat.o(55421);
      return;
      i = 0;
      break;
      bool1 = false;
      break label95;
      bool1 = false;
      break label118;
    }
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(55419);
    if ((r.Zy() & 0x200) == 0)
    {
      AppMethodBeat.o(55419);
      return true;
    }
    AppMethodBeat.o(55419);
    return false;
  }
  
  public static void u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(55422);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      pcM = paramBoolean;
      paramContext.getString(2131297087);
      paramContext = h.b(paramContext, (String)localObject, true, null);
      localObject = new ak()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(55415);
          int i = r.Zy();
          if (this.ldm) {
            i &= 0xFFFFFDFF;
          }
          for (;;)
          {
            g.RL().Ru().set(34, Integer.valueOf(i));
            ((j)g.E(j.class)).Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.ldm)
            {
              g.RJ().QQ();
              ((j)g.E(j.class)).bPN().axH();
              g.Rc().a(new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""), 0);
            }
            if (this.oBt != null) {
              this.oBt.a(null, null);
            }
            AppMethodBeat.o(55415);
            return;
            i |= 0x200;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(55416);
          if (this.oBu != null)
          {
            this.oBu.dismiss();
            this.mFP.sendEmptyMessage(0);
          }
          AppMethodBeat.o(55416);
        }
      }, 1500L);
      AppMethodBeat.o(55422);
      return;
    }
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(55418);
    ab.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(55418);
      return false;
    }
    if (paramString.equals("contact_info_lbs_go_lbs"))
    {
      paramString = (Boolean)g.RL().Ru().get(4103, null);
      if ((paramString == null) || (!paramString.booleanValue())) {
        d.H(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
      }
      for (;;)
      {
        AppMethodBeat.o(55418);
        return true;
        paramString = bp.abb();
        if (paramString == null)
        {
          d.H(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
        }
        else
        {
          String str1 = bo.nullAsNil(paramString.getProvince());
          String str2 = bo.nullAsNil(paramString.getCity());
          int i = paramString.dqC;
          if ((str1.equals("")) || (str2.equals("")) || (i == 0))
          {
            d.H(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
          }
          else
          {
            paramString = (Boolean)g.RL().Ru().get(4104, null);
            if ((paramString == null) || (!paramString.booleanValue()))
            {
              com.tencent.mm.bo.a.fF(this.context);
              ((Activity)this.context).finish();
            }
            else if (this.pcN == null)
            {
              this.pcN = h.a(this.context, this.context.getString(2131297087), this.pcK, new a.2(this), new a.3(this));
            }
            else
            {
              this.pcN.show();
            }
          }
        }
      }
    }
    if (paramString.equals("contact_info_lbs_install"))
    {
      u(this.context, true);
      AppMethodBeat.o(55418);
      return true;
    }
    if (paramString.equals("contact_info_lbs_clear_info"))
    {
      h.a(this.context, 2131301749, 2131301748, new a.4(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(55418);
      return true;
    }
    if (paramString.equals("contact_info_lbs_uninstall"))
    {
      h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.1(this), null);
      AppMethodBeat.o(55418);
      return true;
    }
    ab.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55418);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(55424);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != g.RL().Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(55424);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(55424);
      return;
    }
    bkc();
    AppMethodBeat.o(55424);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(55420);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramad != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(t.oh(paramad.field_username));
      g.RL().Ru().a(this);
      ab.v("MicroMsg.ContactWidgetLBS", "listener added");
      this.contact = paramad;
      this.screen = paramf;
      pcM = true;
      paramf.addPreferencesFromResource(2131165209);
      bkc();
      AppMethodBeat.o(55420);
      return true;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(55423);
    g.RL().Ru().b(this);
    g.Rc().b(148, this);
    com.tencent.mm.plugin.nearby.a.gmP.BO();
    AppMethodBeat.o(55423);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(55425);
    if ((this.pcJ == null) && (((com.tencent.mm.plugin.nearby.a.c)paramm).Ac() == 2))
    {
      AppMethodBeat.o(55425);
      return;
    }
    ab.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 148)
    {
      AppMethodBeat.o(55425);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (paramInt1 = 2131301751;; paramInt1 = 2131301750)
    {
      if ((((com.tencent.mm.plugin.nearby.a.c)paramm).Ac() == 2) && (pcM))
      {
        h.a(this.context, paramInt1, 2131297087, new a.8(this));
        this.pcJ = null;
      }
      AppMethodBeat.o(55425);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a
 * JD-Core Version:    0.7.0.1
 */