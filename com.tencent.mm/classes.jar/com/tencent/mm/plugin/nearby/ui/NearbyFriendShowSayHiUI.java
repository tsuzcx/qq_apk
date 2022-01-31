package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI
  extends MMActivity
{
  ImageView egq;
  String pcQ = "";
  View pcR = null;
  
  public int getLayoutId()
  {
    return 2130970346;
  }
  
  public void initView()
  {
    AppMethodBeat.i(55432);
    setBackBtn(new NearbyFriendShowSayHiUI.1(this));
    ((Button)findViewById(2131826491)).setOnClickListener(new NearbyFriendShowSayHiUI.2(this));
    this.pcR = findViewById(2131824817);
    this.pcR.setVisibility(0);
    this.pcR.setOnClickListener(new NearbyFriendShowSayHiUI.3(this));
    AppMethodBeat.o(55432);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(55433);
    if ((paramInt1 == 2009) && (paramInt2 == -1)) {
      finish();
    }
    AppMethodBeat.o(55433);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55429);
    super.onCreate(paramBundle);
    setMMTitle(2131301773);
    initView();
    AppMethodBeat.o(55429);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(55431);
    super.onPause();
    AppMethodBeat.o(55431);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(55430);
    super.onResume();
    Object localObject = (TextView)findViewById(2131824819);
    g.RJ().QQ();
    int i = ((j)g.E(j.class)).bPN().bbZ();
    if (i == 0)
    {
      this.pcR.setVisibility(4);
      AppMethodBeat.o(55430);
      return;
    }
    ((TextView)localObject).setText(getResources().getQuantityString(2131361819, i, new Object[] { Integer.valueOf(i) }));
    this.egq = ((ImageView)findViewById(2131824818));
    localObject = ((j)g.E(j.class)).bPN().bPW();
    if (localObject != null)
    {
      this.pcQ = ((bf)localObject).field_sayhiuser;
      a.b.c(this.egq, this.pcQ);
    }
    AppMethodBeat.o(55430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI
 * JD-Core Version:    0.7.0.1
 */