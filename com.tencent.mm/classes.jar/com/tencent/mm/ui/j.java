package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.au.b.a;
import com.tencent.mm.autogen.a.cc;
import com.tencent.mm.autogen.a.mf.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI;
import com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI;
import com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.LinkedList;

public final class j
{
  MMFragmentActivity EzS;
  private View Prp;
  private TextView Prq;
  EditText Prr;
  boolean Prs;
  LauncherUI.b adzP;
  mf.a adzQ;
  com.tencent.mm.am.h adzR;
  boolean adzS;
  boolean adzT;
  IListener adzU;
  IListener<cc> adzV;
  int hCf;
  ProgressDialog lzP;
  com.tencent.mm.ui.widget.a.e pRH;
  
  public j(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(33160);
    this.adzQ = null;
    this.adzS = false;
    this.adzT = false;
    this.adzU = new GlobalAlertMgr.1(this, f.hfK);
    this.hCf = 0;
    this.adzV = new GlobalAlertMgr.11(this, f.hfK);
    this.EzS = paramMMFragmentActivity;
    this.adzP = paramb;
    AppMethodBeat.o(33160);
  }
  
  private void i(int paramInt1, int paramInt2, int paramInt3, final String paramString)
  {
    AppMethodBeat.i(249228);
    Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    com.tencent.mm.plugin.report.service.h.OAn.b(13191, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Boolean.FALSE });
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(249228);
      return;
      AppMethodBeat.o(249228);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramString);
      ((Intent)localObject).putExtra("showShare", false);
      ((Intent)localObject).putExtra("show_bottom", false);
      ((Intent)localObject).putExtra("needRedirect", false);
      ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
      ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
      com.tencent.mm.br.c.b(this.EzS, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(249228);
      return;
      if (this.Prs)
      {
        La(true);
        AppMethodBeat.o(249228);
        return;
      }
      jiJ();
      bh.aZW().a(255, this.adzR);
      paramString = new v(1);
      bh.aZW().a(paramString, 0);
      localObject = this.EzS;
      getString(R.l.app_tip);
      this.lzP = k.a((Context)localObject, getString(R.l.settings_loading), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(33154);
          bh.aZW().a(paramString);
          AppMethodBeat.o(33154);
        }
      });
      AppMethodBeat.o(249228);
      return;
      paramString = new Intent();
      paramString.setClass(this.EzS, BindMContactUI.class);
      paramString.putExtra("bind_scene", 3);
      localObject = ((TelephonyManager)this.EzS.getSystemService("phone")).getSimCountryIso();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = com.tencent.mm.au.b.bH((String)localObject, getString(R.l.country_code));
        if (localObject != null)
        {
          paramString.putExtra("country_name", ((b.a)localObject).oLl);
          paramString.putExtra("couttry_code", ((b.a)localObject).oLk);
        }
      }
      MMWizardActivity.aQ(this.EzS, paramString);
      AppMethodBeat.o(249228);
      return;
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 1);
      paramString.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      paramString.setFlags(65536);
      if ((!com.tencent.mm.n.a.p(this.EzS, true)) && (!com.tencent.mm.bc.e.bNA()) && (!com.tencent.mm.n.a.u(this.EzS, true)))
      {
        com.tencent.mm.br.c.b(this.EzS, "scanner", ".ui.BaseScanUI", paramString);
        AppMethodBeat.o(249228);
        return;
        paramString = new Intent(this.EzS, SettingsModifyAliasUI.class);
        paramString.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
        MMWizardActivity.aQ(this.EzS, paramString);
        AppMethodBeat.o(249228);
        return;
        localObject = new Intent(this.EzS, SettingsModifyEmailAddrUI.class);
        paramString = this.EzS;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/GlobalAlertMgr", "jumpByActionType", "(IIILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/ui/GlobalAlertMgr", "jumpByActionType", "(IIILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  final void La(boolean paramBoolean)
  {
    AppMethodBeat.i(33163);
    Log.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      jiK();
      AppMethodBeat.o(33163);
      return;
    }
    Object localObject = new Intent(this.EzS, RegByMobileSetPwdUI.class);
    ((Intent)localObject).putExtra("kintent_hint", getString(R.l.settings_modify_password_tip));
    MMFragmentActivity localMMFragmentActivity = this.EzS;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localMMFragmentActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMFragmentActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localMMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33163);
  }
  
  final boolean a(final mf.a parama)
  {
    AppMethodBeat.i(33161);
    if ((parama == null) || (parama.hOm == null) || (parama.hOm.YzI == null) || (parama.hOm.YzI.size() == 0))
    {
      AppMethodBeat.o(33161);
      return false;
    }
    final int i = parama.hOm.id;
    String str1 = parama.hOm.title;
    String str2 = parama.hOm.msg;
    int j = parama.type;
    int k = parama.hOm.YzI.size();
    if ((parama.hOm.YzJ >= 0) && (parama.hOm.YzJ < k))
    {
      parama = (com.tencent.mm.protocal.b.a.a)parama.hOm.YzI.get(parama.hOm.YzJ);
      i(i, parama.actionType, parama.id, parama.YzH);
      AppMethodBeat.o(33161);
      return true;
    }
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.hOm.YzI.get(0);
        Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.YzG, parama.YzH });
        k.a(this.EzS, str2, str1, parama.YzG, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33151);
            j.a(j.this, i, parama.actionType, parama.id, parama.YzH);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(33151);
          }
        });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33161);
      return true;
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.hOm.YzI.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.hOm.YzI.get(0);
      Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.YzG, locala1.YzH, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.YzG, parama.YzH });
      k.a(this.EzS, str2, str1, locala1.YzG, parama.YzG, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33152);
          j.a(j.this, i, locala1.actionType, locala1.id, locala1.YzH);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33153);
          j.a(j.this, i, parama.actionType, parama.id, parama.YzH);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33153);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.hOm.YzI.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.hOm.YzI.get(1);
        k.a(this.EzS, str2, str1, locala1.YzG, locala2.YzG, false, parama.hOn, parama.hOo);
      }
    }
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(33165);
    String str = this.EzS.getString(paramInt);
    AppMethodBeat.o(33165);
    return str;
  }
  
  final com.tencent.mm.am.h jiJ()
  {
    AppMethodBeat.i(33162);
    if (this.adzR == null) {
      this.adzR = new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(33156);
          Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousp.getType());
          if (j.this.lzP != null)
          {
            j.this.lzP.dismiss();
            j.this.lzP = null;
          }
          if (paramAnonymousp.getType() == 255)
          {
            bh.aZW().b(255, j.this.adzR);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              j.this.La(true);
              AppMethodBeat.o(33156);
              return;
            }
            if (ae.a.a(j.this.EzS, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              AppMethodBeat.o(33156);
              return;
            }
            j.this.La(false);
            AppMethodBeat.o(33156);
            return;
          }
          if (paramAnonymousp.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              bh.bCz();
              com.tencent.mm.model.c.ban().B(77830, ((ae)paramAnonymousp).bIQ());
              paramAnonymousp = new Intent(j.this.EzS, RegByMobileSetPwdUI.class);
              paramAnonymousp.putExtra("kintent_hint", j.this.getString(R.l.settings_modify_password_tip));
              paramAnonymousString = j.this.EzS;
              paramAnonymousp = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousp);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, paramAnonymousp.aYi(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousp.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33156);
              return;
            }
            j.this.Prs = true;
            k.a(j.this.EzS, R.l.settings_password_error, R.l.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33155);
                j.this.jiK();
                AppMethodBeat.o(33155);
              }
            });
          }
          AppMethodBeat.o(33156);
        }
      };
    }
    com.tencent.mm.am.h localh = this.adzR;
    AppMethodBeat.o(33162);
    return localh;
  }
  
  final void jiK()
  {
    AppMethodBeat.i(33164);
    if (this.pRH != null)
    {
      this.pRH.show();
      AppMethodBeat.o(33164);
      return;
    }
    if (this.Prp == null)
    {
      this.Prp = View.inflate(this.EzS, R.i.sendrequest_dialog, null);
      this.Prq = ((TextView)this.Prp.findViewById(R.h.sendrequest_tip));
      this.Prq.setText(getString(R.l.settings_independent_password_tip));
      this.Prr = ((EditText)this.Prp.findViewById(R.h.sendrequest_content));
      this.Prr.setInputType(129);
    }
    this.pRH = k.a(this.EzS, null, this.Prp, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33158);
        paramAnonymousDialogInterface = j.this.Prr.getText().toString();
        j.this.Prr.setText("");
        j.this.Prr.clearFocus();
        ab.a(j.this.EzS, j.this.Prr);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          k.a(j.this.EzS, R.l.verify_password_null_tip, R.l.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(33158);
          return;
        }
        j.this.jiJ();
        bh.aZW().a(384, j.this.adzR);
        paramAnonymousDialogInterface = new ae(paramAnonymousDialogInterface, "", "", "");
        bh.aZW().a(paramAnonymousDialogInterface, 0);
        j localj = j.this;
        MMFragmentActivity localMMFragmentActivity = j.this.EzS;
        j.this.getString(R.l.app_tip);
        localj.lzP = k.a(localMMFragmentActivity, j.this.getString(R.l.settings_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(33157);
            bh.aZW().b(384, j.this.adzR);
            j.this.adzR = null;
            bh.aZW().a(paramAnonymousDialogInterface);
            AppMethodBeat.o(33157);
          }
        });
        AppMethodBeat.o(33158);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33159);
        j.this.Prr.setText("");
        j.this.pRH.dismiss();
        AppMethodBeat.o(33159);
      }
    });
    AppMethodBeat.o(33164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.j
 * JD-Core Version:    0.7.0.1
 */