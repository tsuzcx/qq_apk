package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

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
      ac.e("MicroMsg.SnsAdBlankUI", "intent null!");
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    int i = ((Intent)localObject).getIntExtra("action_type", -1);
    ac.i("MicroMsg.SnsAdBlankUI", "action=".concat(String.valueOf(i)));
    if (i < 0)
    {
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    if (i == 1)
    {
      paramBundle = new cl();
      paramBundle.dbW.activity = this;
      paramBundle.dbW.dam = ((Intent)localObject).getStringExtra("qrcodeStr");
      paramBundle.dbW.dbX = ((Intent)localObject).getIntExtra("qrcodeType", 0);
      paramBundle.dbW.dbY = ((Intent)localObject).getIntExtra("qrcodeVer", 0);
      a.GpY.l(paramBundle);
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
        ut localut = new ut();
        localut.dxt.userName = paramBundle;
        localut.dxt.dxv = str;
        localut.dxt.scene = 1084;
        localut.dxt.cYP = ((String)localObject);
        localut.dxt.context = this;
        a.GpY.l(localut);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdProxyUI
 * JD-Core Version:    0.7.0.1
 */