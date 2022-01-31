package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.bd;
import com.tencent.mm.h.a.ig.a;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public final class j
{
  int bHt = 0;
  ProgressDialog dnm;
  com.tencent.mm.ui.widget.a.c feI;
  private View nTC;
  private TextView nTD;
  EditText nTE;
  boolean nTF;
  MMFragmentActivity uJA;
  LauncherUI.b uJB;
  ig.a uJC = null;
  f uJD;
  boolean uJE = false;
  boolean uJF = false;
  com.tencent.mm.sdk.b.c uJG = new j.1(this);
  com.tencent.mm.sdk.b.c<bd> uJH = new j.2(this);
  
  public j(MMFragmentActivity paramMMFragmentActivity, LauncherUI.b paramb)
  {
    this.uJA = paramMMFragmentActivity;
    this.uJB = paramb;
  }
  
  final boolean a(ig.a parama)
  {
    if ((parama == null) || (parama.bQu == null) || (parama.bQu.srm == null) || (parama.bQu.srm.size() == 0)) {
      return false;
    }
    int i = parama.bQu.id;
    String str1 = parama.bQu.title;
    String str2 = parama.bQu.bHk;
    int j = parama.type;
    int k = parama.bQu.srm.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (a)parama.bQu.srm.get(0);
        y.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.srk, parama.srl });
        h.a(this.uJA, str2, str1, parama.srk, false, new j.7(this, i, parama));
      }
    }
    for (;;)
    {
      return true;
      a locala1 = (a)parama.bQu.srm.get(1);
      parama = (a)parama.bQu.srm.get(0);
      y.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.srk, locala1.srl, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.srk, parama.srl });
      h.a(this.uJA, str2, str1, locala1.srk, parama.srk, false, new j.8(this, i, locala1), new j.9(this, i, parama));
      continue;
      if (j == 1)
      {
        locala1 = (a)parama.bQu.srm.get(0);
        a locala2 = (a)parama.bQu.srm.get(1);
        h.a(this.uJA, str2, str1, locala1.srk, locala2.srk, false, parama.bQv, parama.bQw);
      }
    }
  }
  
  final f cyB()
  {
    if (this.uJD == null) {
      this.uJD = new j.11(this);
    }
    return this.uJD;
  }
  
  final void cyC()
  {
    if (this.feI != null)
    {
      this.feI.show();
      return;
    }
    if (this.nTC == null)
    {
      this.nTC = View.inflate(this.uJA, R.i.sendrequest_dialog, null);
      this.nTD = ((TextView)this.nTC.findViewById(R.h.sendrequest_tip));
      this.nTD.setText(getString(R.l.settings_independent_password_tip));
      this.nTE = ((EditText)this.nTC.findViewById(R.h.sendrequest_content));
      this.nTE.setInputType(129);
    }
    this.feI = h.a(this.uJA, null, this.nTC, new j.12(this), new j.13(this));
  }
  
  final String getString(int paramInt)
  {
    return this.uJA.getString(paramInt);
  }
  
  final void mN(boolean paramBoolean)
  {
    y.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword " + paramBoolean);
    if (paramBoolean)
    {
      cyC();
      return;
    }
    Intent localIntent = new Intent(this.uJA, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(R.l.settings_modify_password_tip));
    this.uJA.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.j
 * JD-Core Version:    0.7.0.1
 */