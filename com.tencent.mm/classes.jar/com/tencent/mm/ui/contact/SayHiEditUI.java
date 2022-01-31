package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;

public class SayHiEditUI
  extends MMActivity
  implements f
{
  private MMEditText AeL;
  private ProgressDialog eeN = null;
  
  public int getLayoutId()
  {
    return 2130970594;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33846);
    this.AeL = ((MMEditText)findViewById(2131827397));
    this.AeL.addTextChangedListener(new SayHiEditUI.a((byte)0));
    c.d(this.AeL).QS(100).a(null);
    String str1 = getIntent().getStringExtra("Contact_User");
    int i = getIntent().getIntExtra("Contact_Scene", 18);
    String str2 = getIntent().getStringExtra(e.b.yUZ);
    addTextOptionMenu(0, getString(2131297067), new SayHiEditUI.1(this, str1, i, str2), null, q.b.zby);
    setBackBtn(new SayHiEditUI.2(this));
    AppMethodBeat.o(33846);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33844);
    super.onCreate(paramBundle);
    aw.Rc().a(30, this);
    setMMTitle(2131301766);
    initView();
    AppMethodBeat.o(33844);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33845);
    aw.Rc().b(30, this);
    super.onDestroy();
    AppMethodBeat.o(33845);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(33847);
    ab.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    for (;;)
    {
      try
      {
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        switch (paramInt2)
        {
        default: 
          i = 0;
          if (i == 0) {
            break label171;
          }
          AppMethodBeat.o(33847);
          return;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + paramString.getMessage());
        AppMethodBeat.o(33847);
        return;
      }
      Toast.makeText(this, 2131301767, 0).show();
      continue;
      Toast.makeText(this, 2131301770, 0).show();
    }
    label171:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.bO(this, getString(2131298502));
      finish();
      AppMethodBeat.o(33847);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -24) && (!ah.isNullOrNil(paramString)))
    {
      Toast.makeText(this, paramString, 1).show();
      AppMethodBeat.o(33847);
      return;
    }
    if ((paramInt2 == -101) && (!ah.isNullOrNil(paramString)))
    {
      h.a(this, paramString, getString(2131297087), getString(2131297018), null);
      AppMethodBeat.o(33847);
      return;
    }
    Toast.makeText(this, 2131301768, 0).show();
    AppMethodBeat.o(33847);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI
 * JD-Core Version:    0.7.0.1
 */