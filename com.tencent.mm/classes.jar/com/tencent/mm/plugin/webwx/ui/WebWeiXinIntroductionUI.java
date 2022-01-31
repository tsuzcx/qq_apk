package com.tencent.mm.plugin.webwx.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI
  extends MMActivity
{
  private Button vuN;
  
  public int getLayoutId()
  {
    return 2130971292;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26574);
    setMMTitle("");
    this.vuN = ((Button)findViewById(2131829523));
    this.vuN.setOnClickListener(new WebWeiXinIntroductionUI.1(this));
    setBackBtn(new WebWeiXinIntroductionUI.2(this));
    AppMethodBeat.o(26574);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26573);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(26573);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI
 * JD-Core Version:    0.7.0.1
 */