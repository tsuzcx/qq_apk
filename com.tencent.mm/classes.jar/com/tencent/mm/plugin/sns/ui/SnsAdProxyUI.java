package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public class SnsAdProxyUI
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98450);
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    if (localObject == null)
    {
      ae.e("MicroMsg.SnsAdBlankUI", "intent null!");
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    int i = ((Intent)localObject).getIntExtra("action_type", -1);
    ae.i("MicroMsg.SnsAdBlankUI", "action=".concat(String.valueOf(i)));
    if (i < 0)
    {
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    if (i == 1)
    {
      paramBundle = new co();
      paramBundle.dou.activity = this;
      paramBundle.dou.dmI = ((Intent)localObject).getStringExtra("qrcodeStr");
      paramBundle.dou.dov = ((Intent)localObject).getIntExtra("qrcodeType", 0);
      paramBundle.dou.dow = ((Intent)localObject).getIntExtra("qrcodeVer", 0);
      a.IvT.l(paramBundle);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(98450);
      return;
      if (i == 2)
      {
        paramBundle = ((Intent)localObject).getStringExtra("username");
        String str = ((Intent)localObject).getStringExtra("url");
        localObject = ((Intent)localObject).getStringExtra("sceneNote");
        vq localvq = new vq();
        localvq.dKT.userName = paramBundle;
        localvq.dKT.dKV = str;
        localvq.dKT.scene = 1084;
        localvq.dKT.dlj = ((String)localObject);
        localvq.dKT.context = this;
        a.IvT.l(localvq);
      }
    }
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