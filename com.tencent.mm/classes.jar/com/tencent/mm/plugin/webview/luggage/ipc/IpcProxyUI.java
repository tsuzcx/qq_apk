package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ipcinvoker.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(7)
public class IpcProxyUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(78490);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.IpcProxyUI", "onCreate");
    if (d.rb(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (c)r.f(getIntent().getStringExtra("task_class_name"), c.class);
    if (paramBundle != null)
    {
      paramBundle.a(this, getIntent().getBundleExtra("input_data"), new a()
      {
        public final void J(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(78489);
          Intent localIntent = new Intent();
          localIntent.putExtra("input_data", paramAnonymousBundle);
          IpcProxyUI.this.setResult(-1, localIntent);
          IpcProxyUI.this.finish();
          AppMethodBeat.o(78489);
        }
        
        public final void bn(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(295983);
          Intent localIntent = new Intent();
          localIntent.putExtra("input_data", paramAnonymousBundle);
          localIntent.putExtra("event_type", true);
          IpcProxyUI.this.setResult(-1, localIntent);
          IpcProxyUI.this.finish();
          AppMethodBeat.o(295983);
        }
      });
      AppMethodBeat.o(78490);
      return;
    }
    setResult(-1, new Intent());
    finish();
    AppMethodBeat.o(78490);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78491);
    super.onDestroy();
    Log.i("MicroMsg.IpcProxyUI", "onDestroy");
    AppMethodBeat.o(78491);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(78492);
    int i = getIntent().getIntExtra("orientation", -1);
    if (i != -1) {
      setRequestedOrientation(i);
    }
    AppMethodBeat.o(78492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.IpcProxyUI
 * JD-Core Version:    0.7.0.1
 */