package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.a;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.LinkedList;

public final class h
{
  com.tencent.mm.sdk.b.c<bj> HjA;
  MMFragmentActivity Hjt;
  LauncherUI.b Hju;
  jm.a Hjv;
  com.tencent.mm.ak.g Hjw;
  boolean Hjx;
  boolean Hjy;
  com.tencent.mm.sdk.b.c Hjz;
  int dbb;
  ProgressDialog fts;
  com.tencent.mm.ui.widget.a.d iJv;
  private View xrp;
  private TextView xrq;
  EditText xrr;
  boolean xrs;
  
  public h(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(33160);
    this.Hjv = null;
    this.Hjx = false;
    this.Hjy = false;
    this.Hjz = new com.tencent.mm.sdk.b.c() {};
    this.dbb = 0;
    this.HjA = new com.tencent.mm.sdk.b.c() {};
    this.Hjt = paramMMFragmentActivity;
    this.Hju = paramb;
    AppMethodBeat.o(33160);
  }
  
  final boolean a(final jm.a parama)
  {
    AppMethodBeat.i(33161);
    if ((parama == null) || (parama.dkY == null) || (parama.dkY.DKx == null) || (parama.dkY.DKx.size() == 0))
    {
      AppMethodBeat.o(33161);
      return false;
    }
    final int i = parama.dkY.id;
    String str1 = parama.dkY.title;
    String str2 = parama.dkY.bIO;
    int j = parama.type;
    int k = parama.dkY.DKx.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.dkY.DKx.get(0);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.DKv, parama.DKw });
        com.tencent.mm.ui.base.h.a(this.Hjt, str2, str1, parama.DKv, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33151);
            h.a(h.this, i, parama.actionType, parama.id, parama.DKw);
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
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.dkY.DKx.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.dkY.DKx.get(0);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.DKv, locala1.DKw, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.DKv, parama.DKw });
      com.tencent.mm.ui.base.h.a(this.Hjt, str2, str1, locala1.DKv, parama.DKv, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33152);
          h.a(h.this, i, locala1.actionType, locala1.id, locala1.DKw);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33153);
          h.a(h.this, i, parama.actionType, parama.id, parama.DKw);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33153);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.dkY.DKx.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.dkY.DKx.get(1);
        com.tencent.mm.ui.base.h.a(this.Hjt, str2, str1, locala1.DKv, locala2.DKv, false, parama.dkZ, parama.dla);
      }
    }
  }
  
  final com.tencent.mm.ak.g ffJ()
  {
    AppMethodBeat.i(33162);
    if (this.Hjw == null) {
      this.Hjw = new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(33156);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          if (h.this.fts != null)
          {
            h.this.fts.dismiss();
            h.this.fts = null;
          }
          if (paramAnonymousn.getType() == 255)
          {
            az.agi().b(255, h.this.Hjw);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              h.this.wr(true);
              AppMethodBeat.o(33156);
              return;
            }
            if (y.a.a(h.this.Hjt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              AppMethodBeat.o(33156);
              return;
            }
            h.this.wr(false);
            AppMethodBeat.o(33156);
            return;
          }
          if (paramAnonymousn.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              az.ayM();
              com.tencent.mm.model.c.agA().set(77830, ((com.tencent.mm.modelsimple.ac)paramAnonymousn).aEr());
              paramAnonymousn = new Intent(h.this.Hjt, RegByMobileSetPwdUI.class);
              paramAnonymousn.putExtra("kintent_hint", h.this.getString(2131763302));
              paramAnonymousString = h.this.Hjt;
              paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousn);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.aeD(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousn.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33156);
              return;
            }
            h.this.xrs = true;
            com.tencent.mm.ui.base.h.a(h.this.Hjt, 2131763340, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33155);
                h.this.ffK();
                AppMethodBeat.o(33155);
              }
            });
          }
          AppMethodBeat.o(33156);
        }
      };
    }
    com.tencent.mm.ak.g localg = this.Hjw;
    AppMethodBeat.o(33162);
    return localg;
  }
  
  final void ffK()
  {
    AppMethodBeat.i(33164);
    if (this.iJv != null)
    {
      this.iJv.show();
      AppMethodBeat.o(33164);
      return;
    }
    if (this.xrp == null)
    {
      this.xrp = View.inflate(this.Hjt, 2131495371, null);
      this.xrq = ((TextView)this.xrp.findViewById(2131304591));
      this.xrq.setText(getString(2131763244));
      this.xrr = ((EditText)this.xrp.findViewById(2131304590));
      this.xrr.setInputType(129);
    }
    this.iJv = com.tencent.mm.ui.base.h.a(this.Hjt, null, this.xrp, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33158);
        paramAnonymousDialogInterface = h.this.xrr.getText().toString();
        h.this.xrr.setText("");
        h.this.xrr.clearFocus();
        com.tencent.mm.platformtools.ae.a(h.this.Hjt, h.this.xrr);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          com.tencent.mm.ui.base.h.a(h.this.Hjt, 2131764658, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(33158);
          return;
        }
        h.this.ffJ();
        az.agi().a(384, h.this.Hjw);
        paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.ac(paramAnonymousDialogInterface, "", "", "");
        az.agi().a(paramAnonymousDialogInterface, 0);
        h localh = h.this;
        MMFragmentActivity localMMFragmentActivity = h.this.Hjt;
        h.this.getString(2131755906);
        localh.fts = com.tencent.mm.ui.base.h.b(localMMFragmentActivity, h.this.getString(2131763261), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(33157);
            az.agi().b(384, h.this.Hjw);
            h.this.Hjw = null;
            az.agi().a(paramAnonymousDialogInterface);
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
        h.this.xrr.setText("");
        h.this.iJv.dismiss();
        AppMethodBeat.o(33159);
      }
    });
    AppMethodBeat.o(33164);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(33165);
    String str = this.Hjt.getString(paramInt);
    AppMethodBeat.o(33165);
    return str;
  }
  
  final void wr(boolean paramBoolean)
  {
    AppMethodBeat.i(33163);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      ffK();
      AppMethodBeat.o(33163);
      return;
    }
    Object localObject = new Intent(this.Hjt, RegByMobileSetPwdUI.class);
    ((Intent)localObject).putExtra("kintent_hint", getString(2131763302));
    MMFragmentActivity localMMFragmentActivity = this.Hjt;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMFragmentActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */