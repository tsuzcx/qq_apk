package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SendFeedBackUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private TextView nSH = null;
  private EditText nge;
  
  protected final int getLayoutId()
  {
    return a.g.edit_signature;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_feedbackui_title);
    this.nge = ((EditText)findViewById(a.f.content));
    String str = getIntent().getStringExtra("intentKeyFrom");
    if ((str != null) && (str.equals("fromEnjoyAppDialog")))
    {
      this.nSH = ((TextView)findViewById(a.f.view_question_text_view));
      this.nSH.setVisibility(0);
      this.nSH.setOnClickListener(new SendFeedBackUI.1(this));
    }
    setBackBtn(new SendFeedBackUI.2(this));
    addTextOptionMenu(0, getString(a.i.app_send), new SendFeedBackUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    g.Dk().b(153, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.a(this, getString(a.i.settings_feedbackui_succ), getString(a.i.app_tip), new SendFeedBackUI.4(this));
      return;
    }
    h.a(this, getString(a.i.settings_feedbackui_err), getString(a.i.app_tip), new SendFeedBackUI.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI
 * JD-Core Version:    0.7.0.1
 */