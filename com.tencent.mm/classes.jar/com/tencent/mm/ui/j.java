package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.bt;
import com.tencent.mm.f.a.lb;
import com.tencent.mm.f.a.lb.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;

public final class j
{
  boolean JgA;
  private View Jgx;
  private TextView Jgy;
  EditText Jgz;
  LauncherUI.b VVr;
  lb.a VVs;
  i VVt;
  boolean VVu;
  boolean VVv;
  IListener VVw;
  IListener<bt> VVx;
  int fxA;
  ProgressDialog iXX;
  d mVa;
  MMFragmentActivity zwS;
  
  public j(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(33160);
    this.VVs = null;
    this.VVu = false;
    this.VVv = false;
    this.VVw = new IListener() {};
    this.fxA = 0;
    this.VVx = new j.3(this);
    this.zwS = paramMMFragmentActivity;
    this.VVr = paramb;
    AppMethodBeat.o(33160);
  }
  
  final void Fp(boolean paramBoolean)
  {
    AppMethodBeat.i(33163);
    Log.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      hGy();
      AppMethodBeat.o(33163);
      return;
    }
    Object localObject = new Intent(this.zwS, RegByMobileSetPwdUI.class);
    ((Intent)localObject).putExtra("kintent_hint", getString(R.l.settings_modify_password_tip));
    MMFragmentActivity localMMFragmentActivity = this.zwS;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localMMFragmentActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMFragmentActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localMMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33163);
  }
  
  final boolean a(final lb.a parama)
  {
    AppMethodBeat.i(33161);
    if ((parama == null) || (parama.fIL == null) || (parama.fIL.RDg == null) || (parama.fIL.RDg.size() == 0))
    {
      AppMethodBeat.o(33161);
      return false;
    }
    final int i = parama.fIL.id;
    String str1 = parama.fIL.title;
    String str2 = parama.fIL.msg;
    int j = parama.type;
    int k = parama.fIL.RDg.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.fIL.RDg.get(0);
        Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.RDe, parama.RDf });
        h.a(this.zwS, str2, str1, parama.RDe, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33151);
            j.a(j.this, i, parama.actionType, parama.id, parama.RDf);
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
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.fIL.RDg.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.fIL.RDg.get(0);
      Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.RDe, locala1.RDf, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.RDe, parama.RDf });
      h.a(this.zwS, str2, str1, locala1.RDe, parama.RDe, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33152);
          j.a(j.this, i, locala1.actionType, locala1.id, locala1.RDf);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33153);
          j.a(j.this, i, parama.actionType, parama.id, parama.RDf);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33153);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.fIL.RDg.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.fIL.RDg.get(1);
        h.a(this.zwS, str2, str1, locala1.RDe, locala2.RDe, false, parama.fIM, parama.fIN);
      }
    }
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(33165);
    String str = this.zwS.getString(paramInt);
    AppMethodBeat.o(33165);
    return str;
  }
  
  final i hGx()
  {
    AppMethodBeat.i(33162);
    if (this.VVt == null) {
      this.VVt = new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(33156);
          Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousq.getType());
          if (j.this.iXX != null)
          {
            j.this.iXX.dismiss();
            j.this.iXX = null;
          }
          if (paramAnonymousq.getType() == 255)
          {
            bh.aGY().b(255, j.this.VVt);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              j.this.Fp(true);
              AppMethodBeat.o(33156);
              return;
            }
            if (ac.a.a(j.this.zwS, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              AppMethodBeat.o(33156);
              return;
            }
            j.this.Fp(false);
            AppMethodBeat.o(33156);
            return;
          }
          if (paramAnonymousq.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              bh.beI();
              c.aHp().i(77830, ((ad)paramAnonymousq).bkW());
              paramAnonymousq = new Intent(j.this.zwS, RegByMobileSetPwdUI.class);
              paramAnonymousq.putExtra("kintent_hint", j.this.getString(R.l.settings_modify_password_tip));
              paramAnonymousString = j.this.zwS;
              paramAnonymousq = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousq);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, paramAnonymousq.aFh(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousq.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33156);
              return;
            }
            j.this.JgA = true;
            h.a(j.this.zwS, R.l.settings_password_error, R.l.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33155);
                j.this.hGy();
                AppMethodBeat.o(33155);
              }
            });
          }
          AppMethodBeat.o(33156);
        }
      };
    }
    i locali = this.VVt;
    AppMethodBeat.o(33162);
    return locali;
  }
  
  final void hGy()
  {
    AppMethodBeat.i(33164);
    if (this.mVa != null)
    {
      this.mVa.show();
      AppMethodBeat.o(33164);
      return;
    }
    if (this.Jgx == null)
    {
      this.Jgx = View.inflate(this.zwS, R.i.sendrequest_dialog, null);
      this.Jgy = ((TextView)this.Jgx.findViewById(R.h.sendrequest_tip));
      this.Jgy.setText(getString(R.l.settings_independent_password_tip));
      this.Jgz = ((EditText)this.Jgx.findViewById(R.h.sendrequest_content));
      this.Jgz.setInputType(129);
    }
    this.mVa = h.a(this.zwS, null, this.Jgx, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33158);
        paramAnonymousDialogInterface = j.this.Jgz.getText().toString();
        j.this.Jgz.setText("");
        j.this.Jgz.clearFocus();
        ae.a(j.this.zwS, j.this.Jgz);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          h.a(j.this.zwS, R.l.verify_password_null_tip, R.l.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(33158);
          return;
        }
        j.this.hGx();
        bh.aGY().a(384, j.this.VVt);
        paramAnonymousDialogInterface = new ad(paramAnonymousDialogInterface, "", "", "");
        bh.aGY().a(paramAnonymousDialogInterface, 0);
        j localj = j.this;
        MMFragmentActivity localMMFragmentActivity = j.this.zwS;
        j.this.getString(R.l.app_tip);
        localj.iXX = h.a(localMMFragmentActivity, j.this.getString(R.l.settings_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(33157);
            bh.aGY().b(384, j.this.VVt);
            j.this.VVt = null;
            bh.aGY().a(paramAnonymousDialogInterface);
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
        j.this.Jgz.setText("");
        j.this.mVa.dismiss();
        AppMethodBeat.o(33159);
      }
    });
    AppMethodBeat.o(33164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.j
 * JD-Core Version:    0.7.0.1
 */