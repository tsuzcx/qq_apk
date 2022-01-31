package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class ReaderAppIntroUI
  extends MMActivity
{
  private int cEc = 0;
  
  public int getLayoutId()
  {
    return 2130970518;
  }
  
  public void initView()
  {
    AppMethodBeat.i(76801);
    ImageView localImageView = (ImageView)findViewById(2131827041);
    TextView localTextView = (TextView)findViewById(2131827042);
    this.cEc = getIntent().getIntExtra("type", 0);
    if (this.cEc == 20)
    {
      setMMTitle(2131300614);
      localImageView.setImageResource(2130840111);
      localTextView.setText(2131298719);
    }
    setBackBtn(new ReaderAppIntroUI.1(this));
    addIconOptionMenu(0, 2131230758, new ReaderAppIntroUI.2(this));
    AppMethodBeat.o(76801);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76800);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(76800);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI
 * JD-Core Version:    0.7.0.1
 */