package com.tencent.mm.plugin.nearby.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;

public class NearbyFriendsIntroUI
  extends MMActivity
{
  private Button fbO;
  private View mCQ;
  private CheckBox mCR;
  private c mCT = null;
  
  protected final int getLayoutId()
  {
    return b.e.nearby_friend_intro;
  }
  
  protected final void initView()
  {
    this.mCQ = View.inflate(this, b.e.lbs_open_dialog_view, null);
    this.mCR = ((CheckBox)this.mCQ.findViewById(b.d.lbs_open_dialog_cb));
    this.mCR.setChecked(false);
    this.fbO = ((Button)findViewById(b.d.nearby_friend_intro_start_btn));
    this.fbO.setOnClickListener(new NearbyFriendsIntroUI.1(this));
    setBackBtn(new NearbyFriendsIntroUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(b.h.nearby_friend_title);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI
 * JD-Core Version:    0.7.0.1
 */