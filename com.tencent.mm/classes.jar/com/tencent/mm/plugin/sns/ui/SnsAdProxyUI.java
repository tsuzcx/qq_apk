package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.sdk.b.a;

public class SnsAdProxyUI
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38732);
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    if (localObject == null)
    {
      d.e("MicroMsg.SnsAdBlankUI", "intent null!");
      finish();
      AppMethodBeat.o(38732);
      return;
    }
    paramBundle = ((Intent)localObject).getStringExtra("username");
    String str = ((Intent)localObject).getStringExtra("url");
    localObject = ((Intent)localObject).getStringExtra("sceneNote");
    so localso = new so();
    localso.cIQ.userName = paramBundle;
    localso.cIQ.cIS = str;
    localso.cIQ.scene = 1084;
    localso.cIQ.cmF = ((String)localObject);
    localso.cIQ.context = this;
    a.ymk.l(localso);
    finish();
    AppMethodBeat.o(38732);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdProxyUI
 * JD-Core Version:    0.7.0.1
 */