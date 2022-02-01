package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

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
      ad.e("MicroMsg.SnsAdBlankUI", "intent null!");
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    int i = ((Intent)localObject).getIntExtra("action_type", -1);
    ad.i("MicroMsg.SnsAdBlankUI", "action=".concat(String.valueOf(i)));
    if (i < 0)
    {
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    if (i == 1)
    {
      paramBundle = new cl();
      paramBundle.deA.activity = this;
      paramBundle.deA.dcO = ((Intent)localObject).getStringExtra("qrcodeStr");
      paramBundle.deA.deB = ((Intent)localObject).getIntExtra("qrcodeType", 0);
      paramBundle.deA.deC = ((Intent)localObject).getIntExtra("qrcodeVer", 0);
      a.ESL.l(paramBundle);
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
        uj localuj = new uj();
        localuj.dzH.userName = paramBundle;
        localuj.dzH.dzJ = str;
        localuj.dzH.scene = 1084;
        localuj.dzH.dbt = ((String)localObject);
        localuj.dzH.context = this;
        a.ESL.l(localuj);
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