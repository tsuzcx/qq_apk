package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IpcProxyUI
  extends MMActivity
{
  protected final void ahA()
  {
    int i = getIntent().getIntExtra("orientation", -1);
    if (i != -1) {
      setRequestedOrientation(i);
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.IpcProxyUI", "onCreate");
    if (com.tencent.mm.compatible.util.d.gF(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (d)k.d(getIntent().getStringExtra("task_class_name"), d.class);
    if (paramBundle != null)
    {
      paramBundle.a(this, getIntent().getBundleExtra("input_data"), new IpcProxyUI.1(this));
      return;
    }
    setResult(-1, new Intent());
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.IpcProxyUI", "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.IpcProxyUI
 * JD-Core Version:    0.7.0.1
 */