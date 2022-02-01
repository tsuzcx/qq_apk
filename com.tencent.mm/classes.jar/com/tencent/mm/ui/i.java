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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.kk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.LinkedList;

public final class i
{
  private View DaW;
  private TextView DaX;
  EditText DaY;
  boolean DaZ;
  LauncherUI.b OBZ;
  kk.a OCa;
  com.tencent.mm.ak.i OCb;
  boolean OCc;
  boolean OCd;
  IListener OCe;
  IListener<bo> OCf;
  int dEM;
  ProgressDialog gtM;
  d kdA;
  MMFragmentActivity uLr;
  
  public i(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(33160);
    this.OCa = null;
    this.OCc = false;
    this.OCd = false;
    this.OCe = new IListener() {};
    this.dEM = 0;
    this.OCf = new i.3(this);
    this.uLr = paramMMFragmentActivity;
    this.OBZ = paramb;
    AppMethodBeat.o(33160);
  }
  
  final void AZ(boolean paramBoolean)
  {
    AppMethodBeat.i(33163);
    Log.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      gHO();
      AppMethodBeat.o(33163);
      return;
    }
    Object localObject = new Intent(this.uLr, RegByMobileSetPwdUI.class);
    ((Intent)localObject).putExtra("kintent_hint", getString(2131765477));
    MMFragmentActivity localMMFragmentActivity = this.uLr;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMFragmentActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localMMFragmentActivity, "com/tencent/mm/ui/GlobalAlertMgr", "handlePassword", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33163);
  }
  
  final boolean a(final kk.a parama)
  {
    AppMethodBeat.i(33161);
    if ((parama == null) || (parama.dPx == null) || (parama.dPx.KBq == null) || (parama.dPx.KBq.size() == 0))
    {
      AppMethodBeat.o(33161);
      return false;
    }
    final int i = parama.dPx.id;
    String str1 = parama.dPx.title;
    String str2 = parama.dPx.msg;
    int j = parama.type;
    int k = parama.dPx.KBq.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.dPx.KBq.get(0);
        Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.KBo, parama.KBp });
        com.tencent.mm.ui.base.h.a(this.uLr, str2, str1, parama.KBo, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33151);
            i.a(i.this, i, parama.actionType, parama.id, parama.KBp);
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
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.dPx.KBq.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.dPx.KBq.get(0);
      Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.KBo, locala1.KBp, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.KBo, parama.KBp });
      com.tencent.mm.ui.base.h.a(this.uLr, str2, str1, locala1.KBo, parama.KBo, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33152);
          i.a(i.this, i, locala1.actionType, locala1.id, locala1.KBp);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33152);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33153);
          i.a(i.this, i, parama.actionType, parama.id, parama.KBp);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(33153);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.dPx.KBq.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.dPx.KBq.get(1);
        com.tencent.mm.ui.base.h.a(this.uLr, str2, str1, locala1.KBo, locala2.KBo, false, parama.dPy, parama.dPz);
      }
    }
  }
  
  final com.tencent.mm.ak.i gHN()
  {
    AppMethodBeat.i(33162);
    if (this.OCb == null) {
      this.OCb = new com.tencent.mm.ak.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(33156);
          Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousq.getType());
          if (i.this.gtM != null)
          {
            i.this.gtM.dismiss();
            i.this.gtM = null;
          }
          if (paramAnonymousq.getType() == 255)
          {
            bg.azz().b(255, i.this.OCb);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              i.this.AZ(true);
              AppMethodBeat.o(33156);
              return;
            }
            if (z.a.a(i.this.uLr, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              AppMethodBeat.o(33156);
              return;
            }
            i.this.AZ(false);
            AppMethodBeat.o(33156);
            return;
          }
          if (paramAnonymousq.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              bg.aVF();
              com.tencent.mm.model.c.azQ().set(77830, ((ad)paramAnonymousq).bbG());
              paramAnonymousq = new Intent(i.this.uLr, RegByMobileSetPwdUI.class);
              paramAnonymousq.putExtra("kintent_hint", i.this.getString(2131765477));
              paramAnonymousString = i.this.uLr;
              paramAnonymousq = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousq);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousq.axQ(), "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousq.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/GlobalAlertMgr$7", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33156);
              return;
            }
            i.this.DaZ = true;
            com.tencent.mm.ui.base.h.a(i.this.uLr, 2131765521, 2131755998, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33155);
                i.this.gHO();
                AppMethodBeat.o(33155);
              }
            });
          }
          AppMethodBeat.o(33156);
        }
      };
    }
    com.tencent.mm.ak.i locali = this.OCb;
    AppMethodBeat.o(33162);
    return locali;
  }
  
  final void gHO()
  {
    AppMethodBeat.i(33164);
    if (this.kdA != null)
    {
      this.kdA.show();
      AppMethodBeat.o(33164);
      return;
    }
    if (this.DaW == null)
    {
      this.DaW = View.inflate(this.uLr, 2131496232, null);
      this.DaX = ((TextView)this.DaW.findViewById(2131307637));
      this.DaX.setText(getString(2131765414));
      this.DaY = ((EditText)this.DaW.findViewById(2131307636));
      this.DaY.setInputType(129);
    }
    this.kdA = com.tencent.mm.ui.base.h.a(this.uLr, null, this.DaW, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(33158);
        paramAnonymousDialogInterface = i.this.DaY.getText().toString();
        i.this.DaY.setText("");
        i.this.DaY.clearFocus();
        af.a(i.this.uLr, i.this.DaY);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          com.tencent.mm.ui.base.h.a(i.this.uLr, 2131767029, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(33158);
          return;
        }
        i.this.gHN();
        bg.azz().a(384, i.this.OCb);
        paramAnonymousDialogInterface = new ad(paramAnonymousDialogInterface, "", "", "");
        bg.azz().a(paramAnonymousDialogInterface, 0);
        i locali = i.this;
        MMFragmentActivity localMMFragmentActivity = i.this.uLr;
        i.this.getString(2131755998);
        locali.gtM = com.tencent.mm.ui.base.h.a(localMMFragmentActivity, i.this.getString(2131765431), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(33157);
            bg.azz().b(384, i.this.OCb);
            i.this.OCb = null;
            bg.azz().a(paramAnonymousDialogInterface);
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
        i.this.DaY.setText("");
        i.this.kdA.dismiss();
        AppMethodBeat.o(33159);
      }
    });
    AppMethodBeat.o(33164);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(33165);
    String str = this.uLr.getString(paramInt);
    AppMethodBeat.o(33165);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.i
 * JD-Core Version:    0.7.0.1
 */