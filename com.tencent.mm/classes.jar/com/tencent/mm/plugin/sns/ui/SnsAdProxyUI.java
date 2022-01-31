package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.j.c;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.sdk.b.a;

public class SnsAdProxyUI
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    if (localObject == null)
    {
      c.e("MicroMsg.SnsAdBlankUI", "intent null!");
      finish();
      return;
    }
    paramBundle = ((Intent)localObject).getStringExtra("username");
    String str = ((Intent)localObject).getStringExtra("url");
    localObject = ((Intent)localObject).getStringExtra("sceneNote");
    rc localrc = new rc();
    localrc.caq.userName = paramBundle;
    localrc.caq.cas = str;
    localrc.caq.scene = 1084;
    localrc.caq.bFv = ((String)localObject);
    localrc.caq.context = this;
    a.udP.m(localrc);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdProxyUI
 * JD-Core Version:    0.7.0.1
 */