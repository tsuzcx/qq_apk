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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.jv.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.LinkedList;

public final class h
{
  MMFragmentActivity JrI;
  LauncherUI.b JrJ;
  jv.a JrK;
  f JrL;
  boolean JrM;
  boolean JrN;
  com.tencent.mm.sdk.b.c JrO;
  com.tencent.mm.sdk.b.c<bm> JrP;
  int dnx;
  ProgressDialog fOC;
  com.tencent.mm.ui.widget.a.d jfx;
  private View yWh;
  private TextView yWi;
  EditText yWj;
  boolean yWk;
  
  public h(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(33160);
    this.JrK = null;
    this.JrM = false;
    this.JrN = false;
    this.JrO = new com.tencent.mm.sdk.b.c() {};
    this.dnx = 0;
    this.JrP = new com.tencent.mm.sdk.b.c() {};
    this.JrI = paramMMFragmentActivity;
    this.JrJ = paramb;
    AppMethodBeat.o(33160);
  }
  
  final boolean a(final jv.a parama)
  {
    AppMethodBeat.i(33161);
    if ((parama == null) || (parama.dxQ == null) || (parama.dxQ.FIc == null) || (parama.dxQ.FIc.size() == 0))
    {
      AppMethodBeat.o(33161);
      return false;
    }
    final int i = parama.dxQ.id;
    String str1 = parama.dxQ.title;
    String str2 = parama.dxQ.msg;
    int j = parama.type;
    int k = parama.dxQ.FIc.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.dxQ.FIc.get(0);
        ae.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.FIa, parama.FIb });
        com.tencent.mm.ui.base.h.a(this.JrI, str2, str1, parama.FIa, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33151);
            h.a(h.this, i, parama.actionType, parama.id, parama.FIb);
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
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.dxQ.FIc.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.dxQ.FIc.get(0);
      ae.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.FIa, locala1.FIb, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.FIa, parama.FIb });
      com.tencent.mm.ui.base.h.a(this.JrI, str2, str1, locala1.FIa, parama.FIa, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33152);
          h.a(h.this, i, locala1.actionType, locala1.id, locala1.FIb);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33153);
          h.a(h.this, i, parama.actionType, parama.id, parama.FIb);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33153);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.dxQ.FIc.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.dxQ.FIc.get(1);
        com.tencent.mm.ui.base.h.a(this.JrI, str2, str1, locala1.FIa, locala2.FIa, false, parama.dxR, parama.dxS);
      }
    }
  }
  
  final f fzW()
  {
    AppMethodBeat.i(33162);
    if (this.JrL == null) {
      this.JrL = new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(33156);
          ae.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          if (h.this.fOC != null)
          {
            h.this.fOC.dismiss();
            h.this.fOC = null;
          }
          if (paramAnonymousn.getType() == 255)
          {
            bc.ajj().b(255, h.this.JrL);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              h.this.xl(true);
              AppMethodBeat.o(33156);
              return;
            }
            if (y.a.a(h.this.JrI, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              AppMethodBeat.o(33156);
              return;
            }
            h.this.xl(false);
            AppMethodBeat.o(33156);
            return;
          }
          if (paramAnonymousn.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              bc.aCg();
              com.tencent.mm.model.c.ajA().set(77830, ((ad)paramAnonymousn).aHN());
              paramAnonymousn = new Intent(h.this.JrI, RegByMobileSetPwdUI.class);
              paramAnonymousn.putExtra("kintent_hint", h.this.getString(2131763302));
              paramAnonymousString = h.this.JrI;
              paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousn);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.ahE(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousn.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33156);
              return;
            }
            h.this.yWk = true;
            com.tencent.mm.ui.base.h.a(h.this.JrI, 2131763340, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33155);
                h.this.fzX();
                AppMethodBeat.o(33155);
              }
            });
          }
          AppMethodBeat.o(33156);
        }
      };
    }
    f localf = this.JrL;
    AppMethodBeat.o(33162);
    return localf;
  }
  
  final void fzX()
  {
    AppMethodBeat.i(33164);
    if (this.jfx != null)
    {
      this.jfx.show();
      AppMethodBeat.o(33164);
      return;
    }
    if (this.yWh == null)
    {
      this.yWh = View.inflate(this.JrI, 2131495371, null);
      this.yWi = ((TextView)this.yWh.findViewById(2131304591));
      this.yWi.setText(getString(2131763244));
      this.yWj = ((EditText)this.yWh.findViewById(2131304590));
      this.yWj.setInputType(129);
    }
    this.jfx = com.tencent.mm.ui.base.h.a(this.JrI, null, this.yWh, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33158);
        paramAnonymousDialogInterface = h.this.yWj.getText().toString();
        h.this.yWj.setText("");
        h.this.yWj.clearFocus();
        af.a(h.this.JrI, h.this.yWj);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          com.tencent.mm.ui.base.h.a(h.this.JrI, 2131764658, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(33158);
          return;
        }
        h.this.fzW();
        bc.ajj().a(384, h.this.JrL);
        paramAnonymousDialogInterface = new ad(paramAnonymousDialogInterface, "", "", "");
        bc.ajj().a(paramAnonymousDialogInterface, 0);
        h localh = h.this;
        MMFragmentActivity localMMFragmentActivity = h.this.JrI;
        h.this.getString(2131755906);
        localh.fOC = com.tencent.mm.ui.base.h.b(localMMFragmentActivity, h.this.getString(2131763261), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(33157);
            bc.ajj().b(384, h.this.JrL);
            h.this.JrL = null;
            bc.ajj().a(paramAnonymousDialogInterface);
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
        h.this.yWj.setText("");
        h.this.jfx.dismiss();
        AppMethodBeat.o(33159);
      }
    });
    AppMethodBeat.o(33164);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(33165);
    String str = this.JrI.getString(paramInt);
    AppMethodBeat.o(33165);
    return str;
  }
  
  final void xl(boolean paramBoolean)
  {
    AppMethodBeat.i(33163);
    ae.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      fzX();
      AppMethodBeat.o(33163);
      return;
    }
    Object localObject = new Intent(this.JrI, RegByMobileSetPwdUI.class);
    ((Intent)localObject).putExtra("kintent_hint", getString(2131763302));
    MMFragmentActivity localMMFragmentActivity = this.JrI;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMFragmentActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */