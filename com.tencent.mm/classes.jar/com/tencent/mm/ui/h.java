package com.tencent.mm.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.jf.a;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.LinkedList;

public final class h
{
  MMFragmentActivity FKl;
  LauncherUI.b FKm;
  jf.a FKn;
  com.tencent.mm.al.g FKo;
  boolean FKp;
  boolean FKq;
  com.tencent.mm.sdk.b.c FKr;
  com.tencent.mm.sdk.b.c<bj> FKs;
  int ddF;
  ProgressDialog fpP;
  com.tencent.mm.ui.widget.a.d ijo;
  private View wfZ;
  private TextView wga;
  EditText wgb;
  boolean wgc;
  
  public h(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(33160);
    this.FKn = null;
    this.FKp = false;
    this.FKq = false;
    this.FKr = new com.tencent.mm.sdk.b.c() {};
    this.ddF = 0;
    this.FKs = new com.tencent.mm.sdk.b.c() {};
    this.FKl = paramMMFragmentActivity;
    this.FKm = paramb;
    AppMethodBeat.o(33160);
  }
  
  final boolean a(final jf.a parama)
  {
    AppMethodBeat.i(33161);
    if ((parama == null) || (parama.dnq == null) || (parama.dnq.Csf == null) || (parama.dnq.Csf.size() == 0))
    {
      AppMethodBeat.o(33161);
      return false;
    }
    final int i = parama.dnq.id;
    String str1 = parama.dnq.title;
    String str2 = parama.dnq.bLg;
    int j = parama.type;
    int k = parama.dnq.Csf.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.dnq.Csf.get(0);
        ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.Csd, parama.Cse });
        com.tencent.mm.ui.base.h.a(this.FKl, str2, str1, parama.Csd, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33151);
            h.a(h.this, i, parama.actionType, parama.id, parama.Cse);
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
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.dnq.Csf.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.dnq.Csf.get(0);
      ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.Csd, locala1.Cse, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.Csd, parama.Cse });
      com.tencent.mm.ui.base.h.a(this.FKl, str2, str1, locala1.Csd, parama.Csd, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33152);
          h.a(h.this, i, locala1.actionType, locala1.id, locala1.Cse);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33153);
          h.a(h.this, i, parama.actionType, parama.id, parama.Cse);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33153);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.dnq.Csf.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.dnq.Csf.get(1);
        com.tencent.mm.ui.base.h.a(this.FKl, str2, str1, locala1.Csd, locala2.Csd, false, parama.dnr, parama.dns);
      }
    }
  }
  
  final com.tencent.mm.al.g eQd()
  {
    AppMethodBeat.i(33162);
    if (this.FKo == null) {
      this.FKo = new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(33156);
          ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          if (h.this.fpP != null)
          {
            h.this.fpP.dismiss();
            h.this.fpP = null;
          }
          if (paramAnonymousn.getType() == 255)
          {
            az.aeS().b(255, h.this.FKo);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              h.this.vp(true);
              AppMethodBeat.o(33156);
              return;
            }
            if (x.a.a(h.this.FKl, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              AppMethodBeat.o(33156);
              return;
            }
            h.this.vp(false);
            AppMethodBeat.o(33156);
            return;
          }
          if (paramAnonymousn.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              az.arV();
              com.tencent.mm.model.c.afk().set(77830, ((ac)paramAnonymousn).axz());
              paramAnonymousn = new Intent(h.this.FKl, RegByMobileSetPwdUI.class);
              paramAnonymousn.putExtra("kintent_hint", h.this.getString(2131763302));
              paramAnonymousString = h.this.FKl;
              paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousn);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.adn(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousn.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33156);
              return;
            }
            h.this.wgc = true;
            com.tencent.mm.ui.base.h.a(h.this.FKl, 2131763340, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33155);
                h.this.eQe();
                AppMethodBeat.o(33155);
              }
            });
          }
          AppMethodBeat.o(33156);
        }
      };
    }
    com.tencent.mm.al.g localg = this.FKo;
    AppMethodBeat.o(33162);
    return localg;
  }
  
  final void eQe()
  {
    AppMethodBeat.i(33164);
    if (this.ijo != null)
    {
      this.ijo.show();
      AppMethodBeat.o(33164);
      return;
    }
    if (this.wfZ == null)
    {
      this.wfZ = View.inflate(this.FKl, 2131495371, null);
      this.wga = ((TextView)this.wfZ.findViewById(2131304591));
      this.wga.setText(getString(2131763244));
      this.wgb = ((EditText)this.wfZ.findViewById(2131304590));
      this.wgb.setInputType(129);
    }
    this.ijo = com.tencent.mm.ui.base.h.a(this.FKl, null, this.wfZ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33158);
        paramAnonymousDialogInterface = h.this.wgb.getText().toString();
        h.this.wgb.setText("");
        h.this.wgb.clearFocus();
        ae.a(h.this.FKl, h.this.wgb);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          com.tencent.mm.ui.base.h.a(h.this.FKl, 2131764658, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(33158);
          return;
        }
        h.this.eQd();
        az.aeS().a(384, h.this.FKo);
        paramAnonymousDialogInterface = new ac(paramAnonymousDialogInterface, "", "", "");
        az.aeS().a(paramAnonymousDialogInterface, 0);
        h localh = h.this;
        MMFragmentActivity localMMFragmentActivity = h.this.FKl;
        h.this.getString(2131755906);
        localh.fpP = com.tencent.mm.ui.base.h.b(localMMFragmentActivity, h.this.getString(2131763261), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(33157);
            az.aeS().b(384, h.this.FKo);
            h.this.FKo = null;
            az.aeS().a(paramAnonymousDialogInterface);
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
        h.this.wgb.setText("");
        h.this.ijo.dismiss();
        AppMethodBeat.o(33159);
      }
    });
    AppMethodBeat.o(33164);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(33165);
    String str = this.FKl.getString(paramInt);
    AppMethodBeat.o(33165);
    return str;
  }
  
  final void vp(boolean paramBoolean)
  {
    AppMethodBeat.i(33163);
    ad.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      eQe();
      AppMethodBeat.o(33163);
      return;
    }
    Object localObject = new Intent(this.FKl, RegByMobileSetPwdUI.class);
    ((Intent)localObject).putExtra("kintent_hint", getString(2131763302));
    MMFragmentActivity localMMFragmentActivity = this.FKl;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMFragmentActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */