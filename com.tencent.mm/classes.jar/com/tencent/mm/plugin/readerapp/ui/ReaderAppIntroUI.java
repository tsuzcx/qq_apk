package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.f;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI
  extends MMActivity
{
  private int bWp = 0;
  
  protected final int getLayoutId()
  {
    return a.e.readerapp_intro;
  }
  
  protected final void initView()
  {
    ImageView localImageView = (ImageView)findViewById(a.d.readerapp_intro_iv);
    TextView localTextView = (TextView)findViewById(a.d.readerapp_intro_tv);
    this.bWp = getIntent().getIntExtra("type", 0);
    if (this.bWp == 20)
    {
      setMMTitle(a.g.hardcode_plugin_readerappnews_nick);
      localImageView.setImageResource(a.c.readerapp_news_intro);
      localTextView.setText(a.g.contact_info_readerappnews_tip);
    }
    setBackBtn(new ReaderAppIntroUI.1(this));
    addIconOptionMenu(0, a.f.actionbar_setting_icon, new ReaderAppIntroUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI
 * JD-Core Version:    0.7.0.1
 */