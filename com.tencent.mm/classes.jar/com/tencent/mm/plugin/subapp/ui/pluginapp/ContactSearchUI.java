package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;

public class ContactSearchUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private ProgressDialog eeN = null;
  private EditText sZB;
  
  private static int adW(String paramString)
  {
    AppMethodBeat.i(25536);
    if (bo.apG(paramString))
    {
      AppMethodBeat.o(25536);
      return 1;
    }
    if (bo.apH(paramString))
    {
      AppMethodBeat.o(25536);
      return 2;
    }
    if (bo.apI(paramString))
    {
      AppMethodBeat.o(25536);
      return 3;
    }
    AppMethodBeat.o(25536);
    return 3;
  }
  
  private void cHb()
  {
    AppMethodBeat.i(25534);
    Object localObject = this.sZB.getText().toString().trim();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      com.tencent.mm.ui.base.h.h(getContext(), 2131304498, 2131297087);
      AppMethodBeat.o(25534);
      return;
    }
    ab.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
    localObject = new com.tencent.mm.plugin.messenger.a.f((String)localObject, 1);
    aw.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131296492), true, new ContactSearchUI.5(this, (com.tencent.mm.plugin.messenger.a.f)localObject));
    AppMethodBeat.o(25534);
  }
  
  public int getLayoutId()
  {
    return 2130969270;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25533);
    setMMTitle(2131298846);
    this.sZB = ((EditText)findViewById(2131823241));
    this.sZB.addTextChangedListener(new ContactSearchUI.1(this));
    this.sZB.setImeOptions(3);
    this.sZB.setOnEditorActionListener(new ContactSearchUI.2(this));
    addTextOptionMenu(0, getString(2131296963), new ContactSearchUI.3(this));
    setBackBtn(new ContactSearchUI.4(this));
    if (getIntent().getBooleanExtra("from_webview", false))
    {
      String str = getIntent().getStringExtra("userName");
      this.sZB.setText(str);
      cHb();
    }
    AppMethodBeat.o(25533);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25530);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(25530);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25532);
    aw.Rc().b(106, this);
    super.onPause();
    AppMethodBeat.o(25532);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25531);
    aw.Rc().a(106, this);
    super.onResume();
    AppMethodBeat.o(25531);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(25535);
    ab.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (b.gmP.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(25535);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.h(getContext(), 2131296486, 2131297087);
      AppMethodBeat.o(25535);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131300094), 0).show();
      ab.w("MicroMsg.ContactSearchUI", getString(2131300093, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(25535);
      return;
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bPI();
    if (paramString.xaS > 0)
    {
      paramm = new Intent();
      paramm.setClass(this, ContactSearchResultUI.class);
      try
      {
        paramm.putExtra("result", paramString.toByteArray());
        startActivity(paramm);
        AppMethodBeat.o(25535);
        return;
      }
      catch (IOException paramString)
      {
        ab.printErrStackTrace("MicroMsg.ContactSearchUI", paramString, "", new Object[0]);
        AppMethodBeat.o(25535);
        return;
      }
    }
    paramm = aa.a(paramString.wOT);
    Intent localIntent = new Intent();
    ((j)g.E(j.class)).a(localIntent, paramString, adW(this.sZB.getText().toString().trim()));
    if (bo.nullAsNil(paramm).length() > 0)
    {
      if ((paramString.xpe & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramm + "," + adW(this.sZB.getText().toString().trim()));
      }
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    }
    AppMethodBeat.o(25535);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI
 * JD-Core Version:    0.7.0.1
 */