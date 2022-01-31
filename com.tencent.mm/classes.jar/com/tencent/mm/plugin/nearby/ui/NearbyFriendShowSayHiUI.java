package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.f;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI
  extends MMActivity
{
  ImageView doU;
  String mCW = "";
  View mCX = null;
  
  protected final int getLayoutId()
  {
    return b.e.nearby_friend_show_sayhi;
  }
  
  protected final void initView()
  {
    setBackBtn(new NearbyFriendShowSayHiUI.1(this));
    ((Button)findViewById(b.d.nearby_friend_intro_start_btn)).setOnClickListener(new NearbyFriendShowSayHiUI.2(this));
    this.mCX = findViewById(b.d.goto_sayhi_btn);
    this.mCX.setVisibility(0);
    this.mCX.setOnClickListener(new NearbyFriendShowSayHiUI.3(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2009) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(b.h.nearby_friend_title);
    initView();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = (TextView)findViewById(b.d.say_hi_count);
    g.DN().CX();
    int i = ((j)g.r(j.class)).bhL().aAo();
    if (i == 0) {
      this.mCX.setVisibility(4);
    }
    do
    {
      return;
      ((TextView)localObject).setText(getResources().getQuantityString(b.f.say_hi_count_text_quantity, i, new Object[] { Integer.valueOf(i) }));
      this.doU = ((ImageView)findViewById(b.d.match_dlg_img));
      localObject = ((j)g.r(j.class)).bhL().bhU();
    } while (localObject == null);
    this.mCW = ((bf)localObject).field_sayhiuser;
    a.b.a(this.doU, this.mCW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI
 * JD-Core Version:    0.7.0.1
 */