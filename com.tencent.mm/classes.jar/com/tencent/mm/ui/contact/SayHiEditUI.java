package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class SayHiEditUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private MMEditText vNi;
  
  protected final int getLayoutId()
  {
    return R.i.say_hi;
  }
  
  protected final void initView()
  {
    this.vNi = ((MMEditText)findViewById(R.h.say_hi_content));
    this.vNi.addTextChangedListener(new SayHiEditUI.a((byte)0));
    c.d(this.vNi).Ig(100).a(null);
    String str1 = getIntent().getStringExtra("Contact_User");
    int i = getIntent().getIntExtra("Contact_Scene", 18);
    String str2 = getIntent().getStringExtra(e.a.uHO);
    a(0, getString(R.l.app_send), new SayHiEditUI.1(this, str1, i, str2), s.b.uNx);
    setBackBtn(new SayHiEditUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(30, this);
    setMMTitle(R.l.nearby_friend_say_hi);
    initView();
  }
  
  public void onDestroy()
  {
    au.Dk().b(30, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    y.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.dnm == null) {
        break label218;
      }
      this.dnm.dismiss();
      this.dnm = null;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + paramString.getMessage());
      return;
    }
    Toast.makeText(this, R.l.nearby_friend_say_hi_black_list, 0).show();
    break label255;
    Toast.makeText(this, R.l.nearby_friend_say_hi_spam, 0).show();
    label218:
    label255:
    while (i == 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.bC(this, getString(R.l.confirm_dialog_sent));
        finish();
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!ah.bl(paramString)))
      {
        Toast.makeText(this, paramString, 1).show();
        return;
      }
      if ((paramInt2 == -101) && (!ah.bl(paramString)))
      {
        h.a(this, paramString, getString(R.l.app_tip), getString(R.l.app_ok), null);
        return;
      }
      Toast.makeText(this, R.l.nearby_friend_say_hi_failed, 0).show();
      return;
      switch (paramInt2)
      {
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI
 * JD-Core Version:    0.7.0.1
 */