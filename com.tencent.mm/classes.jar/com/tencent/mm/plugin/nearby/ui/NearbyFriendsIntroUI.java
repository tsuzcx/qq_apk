package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.b.c;

public class NearbyFriendsIntroUI
  extends MMActivity
{
  private Button gtF;
  private View pcK;
  private CheckBox pcL;
  private c pcN = null;
  
  public int getLayoutId()
  {
    return 2130970344;
  }
  
  public void initView()
  {
    AppMethodBeat.i(55438);
    this.pcK = View.inflate(this, 2130969978, null);
    this.pcL = ((CheckBox)this.pcK.findViewById(2131825412));
    this.pcL.setChecked(false);
    this.gtF = ((Button)findViewById(2131826491));
    this.gtF.setOnClickListener(new NearbyFriendsIntroUI.1(this));
    setBackBtn(new NearbyFriendsIntroUI.2(this));
    AppMethodBeat.o(55438);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55437);
    super.onCreate(paramBundle);
    setMMTitle(2131301773);
    initView();
    AppMethodBeat.o(55437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI
 * JD-Core Version:    0.7.0.1
 */