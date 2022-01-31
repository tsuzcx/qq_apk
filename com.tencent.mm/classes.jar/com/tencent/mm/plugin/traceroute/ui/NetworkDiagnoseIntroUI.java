package com.tencent.mm.plugin.traceroute.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;

public class NetworkDiagnoseIntroUI
  extends MMActivity
{
  private Button tnw;
  private TextView tnx;
  
  public int getLayoutId()
  {
    return 2130970353;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26015);
    this.tnw = ((Button)findViewById(2131826520));
    this.tnw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26011);
        aw.aaz();
        if (!c.isSDCardAvailable())
        {
          t.ii(NetworkDiagnoseIntroUI.this);
          AppMethodBeat.o(26011);
          return;
        }
        if (aw.Rc().adt() == 0)
        {
          Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(2131300044), 0).show();
          AppMethodBeat.o(26011);
          return;
        }
        paramAnonymousView = new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class);
        NetworkDiagnoseIntroUI.this.startActivity(paramAnonymousView);
        NetworkDiagnoseIntroUI.this.finish();
        AppMethodBeat.o(26011);
      }
    });
    this.tnx = ((TextView)findViewById(2131826521));
    this.tnx.setOnClickListener(new NetworkDiagnoseIntroUI.2(this));
    setMMTitle("");
    setBackBtn(new NetworkDiagnoseIntroUI.3(this));
    AppMethodBeat.o(26015);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26014);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(26014);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseIntroUI
 * JD-Core Version:    0.7.0.1
 */