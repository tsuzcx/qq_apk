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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.ju.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.LinkedList;

public final class h
{
  MMFragmentActivity IXa;
  LauncherUI.b IXb;
  ju.a IXc;
  f IXd;
  boolean IXe;
  boolean IXf;
  com.tencent.mm.sdk.b.c IXg;
  com.tencent.mm.sdk.b.c<bm> IXh;
  int dmv;
  ProgressDialog fMu;
  com.tencent.mm.ui.widget.a.d jcE;
  private View yFY;
  private TextView yFZ;
  EditText yGa;
  boolean yGb;
  
  public h(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(33160);
    this.IXc = null;
    this.IXe = false;
    this.IXf = false;
    this.IXg = new com.tencent.mm.sdk.b.c() {};
    this.dmv = 0;
    this.IXh = new com.tencent.mm.sdk.b.c() {};
    this.IXa = paramMMFragmentActivity;
    this.IXb = paramb;
    AppMethodBeat.o(33160);
  }
  
  final boolean a(final ju.a parama)
  {
    AppMethodBeat.i(33161);
    if ((parama == null) || (parama.dwL == null) || (parama.dwL.FpE == null) || (parama.dwL.FpE.size() == 0))
    {
      AppMethodBeat.o(33161);
      return false;
    }
    final int i = parama.dwL.id;
    String str1 = parama.dwL.title;
    String str2 = parama.dwL.msg;
    int j = parama.type;
    int k = parama.dwL.FpE.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.dwL.FpE.get(0);
        ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.FpC, parama.FpD });
        com.tencent.mm.ui.base.h.a(this.IXa, str2, str1, parama.FpC, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33151);
            h.a(h.this, i, parama.actionType, parama.id, parama.FpD);
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
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.dwL.FpE.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.dwL.FpE.get(0);
      ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.FpC, locala1.FpD, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.FpC, parama.FpD });
      com.tencent.mm.ui.base.h.a(this.IXa, str2, str1, locala1.FpC, parama.FpC, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33152);
          h.a(h.this, i, locala1.actionType, locala1.id, locala1.FpD);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33153);
          h.a(h.this, i, parama.actionType, parama.id, parama.FpD);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33153);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.dwL.FpE.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.dwL.FpE.get(1);
        com.tencent.mm.ui.base.h.a(this.IXa, str2, str1, locala1.FpC, locala2.FpC, false, parama.dwM, parama.dwN);
      }
    }
  }
  
  final f fvW()
  {
    AppMethodBeat.i(33162);
    if (this.IXd == null) {
      this.IXd = new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(33156);
          ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousn.getType());
          if (h.this.fMu != null)
          {
            h.this.fMu.dismiss();
            h.this.fMu = null;
          }
          if (paramAnonymousn.getType() == 255)
          {
            ba.aiU().b(255, h.this.IXd);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              h.this.xd(true);
              AppMethodBeat.o(33156);
              return;
            }
            if (y.a.a(h.this.IXa, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              AppMethodBeat.o(33156);
              return;
            }
            h.this.xd(false);
            AppMethodBeat.o(33156);
            return;
          }
          if (paramAnonymousn.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              ba.aBQ();
              com.tencent.mm.model.c.ajl().set(77830, ((ac)paramAnonymousn).aHw());
              paramAnonymousn = new Intent(h.this.IXa, RegByMobileSetPwdUI.class);
              paramAnonymousn.putExtra("kintent_hint", h.this.getString(2131763302));
              paramAnonymousString = h.this.IXa;
              paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousn);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.ahp(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousn.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33156);
              return;
            }
            h.this.yGb = true;
            com.tencent.mm.ui.base.h.a(h.this.IXa, 2131763340, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33155);
                h.this.fvX();
                AppMethodBeat.o(33155);
              }
            });
          }
          AppMethodBeat.o(33156);
        }
      };
    }
    f localf = this.IXd;
    AppMethodBeat.o(33162);
    return localf;
  }
  
  final void fvX()
  {
    AppMethodBeat.i(33164);
    if (this.jcE != null)
    {
      this.jcE.show();
      AppMethodBeat.o(33164);
      return;
    }
    if (this.yFY == null)
    {
      this.yFY = View.inflate(this.IXa, 2131495371, null);
      this.yFZ = ((TextView)this.yFY.findViewById(2131304591));
      this.yFZ.setText(getString(2131763244));
      this.yGa = ((EditText)this.yFY.findViewById(2131304590));
      this.yGa.setInputType(129);
    }
    this.jcE = com.tencent.mm.ui.base.h.a(this.IXa, null, this.yFY, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33158);
        paramAnonymousDialogInterface = h.this.yGa.getText().toString();
        h.this.yGa.setText("");
        h.this.yGa.clearFocus();
        af.a(h.this.IXa, h.this.yGa);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          com.tencent.mm.ui.base.h.a(h.this.IXa, 2131764658, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(33158);
          return;
        }
        h.this.fvW();
        ba.aiU().a(384, h.this.IXd);
        paramAnonymousDialogInterface = new ac(paramAnonymousDialogInterface, "", "", "");
        ba.aiU().a(paramAnonymousDialogInterface, 0);
        h localh = h.this;
        MMFragmentActivity localMMFragmentActivity = h.this.IXa;
        h.this.getString(2131755906);
        localh.fMu = com.tencent.mm.ui.base.h.b(localMMFragmentActivity, h.this.getString(2131763261), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(33157);
            ba.aiU().b(384, h.this.IXd);
            h.this.IXd = null;
            ba.aiU().a(paramAnonymousDialogInterface);
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
        h.this.yGa.setText("");
        h.this.jcE.dismiss();
        AppMethodBeat.o(33159);
      }
    });
    AppMethodBeat.o(33164);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(33165);
    String str = this.IXa.getString(paramInt);
    AppMethodBeat.o(33165);
    return str;
  }
  
  final void xd(boolean paramBoolean)
  {
    AppMethodBeat.i(33163);
    ad.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      fvX();
      AppMethodBeat.o(33163);
      return;
    }
    Object localObject = new Intent(this.IXa, RegByMobileSetPwdUI.class);
    ((Intent)localObject).putExtra("kintent_hint", getString(2131763302));
    MMFragmentActivity localMMFragmentActivity = this.IXa;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMFragmentActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */