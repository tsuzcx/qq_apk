package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ShareToQQUI
  extends MMActivity
  implements f
{
  private ProgressDialog eeN = null;
  private EditText pLt;
  private TextView qFx;
  private int qFy;
  private boolean qFz = false;
  
  public int getLayoutId()
  {
    return 2130969350;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126928);
    setMMTitle(2131303118);
    this.pLt = ((EditText)findViewById(2131820946));
    this.qFx = ((TextView)findViewById(2131823234));
    this.pLt.addTextChangedListener(new MMEditText.c(this.pLt, this.qFx, 280));
    this.qFy = getIntent().getIntExtra("show_to", 2);
    if (this.qFy == 4) {
      this.pLt.setText(2131303092);
    }
    for (;;)
    {
      setBackBtn(new ShareToQQUI.1(this));
      addTextOptionMenu(0, getString(2131297073), new ShareToQQUI.2(this));
      AppMethodBeat.o(126928);
      return;
      this.pLt.setText(2131303094);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126926);
    super.onCreate(paramBundle);
    g.Rc().a(26, this);
    initView();
    if (r.ZP())
    {
      paramBundle = new c(getString(2131306163));
      paramBundle.auI(bo.nullAsNil((String)g.RL().Ru().get(65830, null)));
      new com.tencent.mm.plugin.account.model.h(paramBundle, new ShareToQQUI.5(this)).apL();
    }
    AppMethodBeat.o(126926);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126927);
    g.Rc().b(26, this);
    super.onDestroy();
    AppMethodBeat.o(126927);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(126929);
    ab.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 26)
    {
      AppMethodBeat.o(126929);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -68))
    {
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = "error";
      }
      com.tencent.mm.ui.base.h.a(this, paramm, getString(2131297087), new ShareToQQUI.3(this), null);
      AppMethodBeat.o(126929);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      hideVKB();
      paramString = getString(2131303664);
      new ShareToQQUI.4(this);
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(126929);
      return;
    }
    this.qFz = false;
    if (b.gmP.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(126929);
      return;
    }
    Toast.makeText(this, getString(2131303663, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(126929);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI
 * JD-Core Version:    0.7.0.1
 */