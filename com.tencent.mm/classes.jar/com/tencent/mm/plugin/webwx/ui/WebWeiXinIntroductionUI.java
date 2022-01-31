package com.tencent.mm.plugin.webwx.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI
  extends MMActivity
{
  private Button rEl;
  
  protected final int getLayoutId()
  {
    return R.i.web_weixin_introduction;
  }
  
  protected final void initView()
  {
    setMMTitle("");
    this.rEl = ((Button)findViewById(R.h.webwx_introduction_begin_btn));
    this.rEl.setOnClickListener(new WebWeiXinIntroductionUI.1(this));
    setBackBtn(new WebWeiXinIntroductionUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWeiXinIntroductionUI
 * JD-Core Version:    0.7.0.1
 */