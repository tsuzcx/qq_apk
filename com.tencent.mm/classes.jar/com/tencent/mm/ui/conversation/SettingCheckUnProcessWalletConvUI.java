package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private List<String> AlX;
  private SettingCheckUnProcessWalletConvUI.a AlY;
  private ListView gJa;
  private int[] mHH;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(34626);
    this.mHH = new int[2];
    AppMethodBeat.o(34626);
  }
  
  public int getLayoutId()
  {
    return 2130970681;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34627);
    super.onCreate(paramBundle);
    setMMTitle(2131305024);
    setBackBtn(new SettingCheckUnProcessWalletConvUI.1(this));
    this.gJa = ((ListView)findViewById(2131827590));
    this.AlX = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.AlX != null) && (this.AlX.size() > 0))
    {
      this.AlY = new SettingCheckUnProcessWalletConvUI.a(this);
      this.gJa.setAdapter(this.AlY);
      this.gJa.setOnTouchListener(new SettingCheckUnProcessWalletConvUI.2(this));
      this.gJa.setOnItemClickListener(new SettingCheckUnProcessWalletConvUI.3(this));
      this.gJa.setOnItemLongClickListener(new SettingCheckUnProcessWalletConvUI.4(this));
    }
    AppMethodBeat.o(34627);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */