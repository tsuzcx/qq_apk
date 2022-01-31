package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class SendFeedBackUI
  extends MMActivity
  implements f
{
  private ProgressDialog eeN = null;
  private EditText pLt;
  private TextView qGF = null;
  
  public int getLayoutId()
  {
    return 2130969351;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127050);
    setMMTitle(2131303261);
    this.pLt = ((EditText)findViewById(2131820946));
    String str = getIntent().getStringExtra("intentKeyFrom");
    if ((str != null) && (str.equals("fromEnjoyAppDialog")))
    {
      this.qGF = ((TextView)findViewById(2131823495));
      this.qGF.setVisibility(0);
      this.qGF.setOnClickListener(new SendFeedBackUI.1(this));
    }
    setBackBtn(new SendFeedBackUI.2(this));
    addTextOptionMenu(0, getString(2131297067), new SendFeedBackUI.3(this));
    AppMethodBeat.o(127050);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127048);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127048);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127049);
    g.Rc().b(153, this);
    super.onDestroy();
    AppMethodBeat.o(127049);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127051);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.a(this, getString(2131303260), getString(2131297087), new SendFeedBackUI.4(this));
      AppMethodBeat.o(127051);
      return;
    }
    h.a(this, getString(2131303259), getString(2131297087), new SendFeedBackUI.5(this));
    AppMethodBeat.o(127051);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI
 * JD-Core Version:    0.7.0.1
 */