package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.ik.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;

public final class h
{
  int coH;
  ProgressDialog eeN;
  com.tencent.mm.ui.widget.b.c gwr;
  private View qHC;
  private TextView qHD;
  EditText qHE;
  boolean qHF;
  MMFragmentActivity yXg;
  LauncherUI.b yXh;
  ik.a yXi;
  f yXj;
  boolean yXk;
  boolean yXl;
  com.tencent.mm.sdk.b.c yXm;
  com.tencent.mm.sdk.b.c<bf> yXn;
  
  public h(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    AppMethodBeat.i(29327);
    this.yXi = null;
    this.yXk = false;
    this.yXl = false;
    this.yXm = new h.1(this);
    this.coH = 0;
    this.yXn = new h.2(this);
    this.yXg = paramMMFragmentActivity;
    this.yXh = paramb;
    AppMethodBeat.o(29327);
  }
  
  final boolean a(final ik.a parama)
  {
    AppMethodBeat.i(29328);
    if ((parama == null) || (parama.cxN == null) || (parama.cxN.wjT == null) || (parama.cxN.wjT.size() == 0))
    {
      AppMethodBeat.o(29328);
      return false;
    }
    final int i = parama.cxN.id;
    String str1 = parama.cxN.title;
    String str2 = parama.cxN.bjm;
    int j = parama.type;
    int k = parama.cxN.wjT.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (a)parama.cxN.wjT.get(0);
        ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.wjR, parama.wjS });
        com.tencent.mm.ui.base.h.a(this.yXg, str2, str1, parama.wjR, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29318);
            h.a(h.this, i, parama.actionType, parama.id, parama.wjS);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(29318);
          }
        });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29328);
      return true;
      a locala1 = (a)parama.cxN.wjT.get(1);
      parama = (a)parama.cxN.wjT.get(0);
      ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.wjR, locala1.wjS, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.wjR, parama.wjS });
      com.tencent.mm.ui.base.h.a(this.yXg, str2, str1, locala1.wjR, parama.wjR, false, new h.8(this, i, locala1), new h.9(this, i, parama));
      continue;
      if (j == 1)
      {
        locala1 = (a)parama.cxN.wjT.get(0);
        a locala2 = (a)parama.cxN.wjT.get(1);
        com.tencent.mm.ui.base.h.a(this.yXg, str2, str1, locala1.wjR, locala2.wjR, false, parama.cxO, parama.cxP);
      }
    }
  }
  
  final f dBF()
  {
    AppMethodBeat.i(29329);
    if (this.yXj == null) {
      this.yXj = new h.11(this);
    }
    f localf = this.yXj;
    AppMethodBeat.o(29329);
    return localf;
  }
  
  final void dBG()
  {
    AppMethodBeat.i(29331);
    if (this.gwr != null)
    {
      this.gwr.show();
      AppMethodBeat.o(29331);
      return;
    }
    if (this.qHC == null)
    {
      this.qHC = View.inflate(this.yXg, 2130970676, null);
      this.qHD = ((TextView)this.qHC.findViewById(2131827574));
      this.qHD.setText(getString(2131303275));
      this.qHE = ((EditText)this.qHC.findViewById(2131827575));
      this.qHE.setInputType(129);
    }
    this.gwr = com.tencent.mm.ui.base.h.a(this.yXg, null, this.qHC, new h.12(this), new h.13(this));
    AppMethodBeat.o(29331);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(29332);
    String str = this.yXg.getString(paramInt);
    AppMethodBeat.o(29332);
    return str;
  }
  
  final void qh(boolean paramBoolean)
  {
    AppMethodBeat.i(29330);
    ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      dBG();
      AppMethodBeat.o(29330);
      return;
    }
    Intent localIntent = new Intent(this.yXg, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(2131303322));
    this.yXg.startActivity(localIntent);
    AppMethodBeat.o(29330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */