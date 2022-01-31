package com.tencent.mm.plugin.soter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.i;

public class SoterTestUI
  extends MMActivity
{
  private Button soK = null;
  private Button soL = null;
  private Button soM = null;
  private Button soN = null;
  private Button soO = null;
  private Button soP = null;
  private Button soQ = null;
  private Button soR = null;
  private Button soS = null;
  private TextView soT = null;
  
  public int getLayoutId()
  {
    return 2130970908;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(59392);
    super.onCreate(paramBundle);
    this.soK = ((Button)findViewById(2131828215));
    this.soL = ((Button)findViewById(2131828216));
    this.soM = ((Button)findViewById(2131828217));
    this.soN = ((Button)findViewById(2131828218));
    this.soO = ((Button)findViewById(2131828219));
    this.soP = ((Button)findViewById(2131828220));
    this.soQ = ((Button)findViewById(2131828221));
    this.soR = ((Button)findViewById(2131828222));
    this.soS = ((Button)findViewById(2131828223));
    this.soT = ((TextView)findViewById(2131828214));
    this.soK.setOnClickListener(new SoterTestUI.1(this));
    this.soL.setOnClickListener(new SoterTestUI.2(this));
    this.soM.setOnClickListener(new SoterTestUI.3(this));
    this.soN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(59382);
        paramAnonymousView = a.dVh();
        if (paramAnonymousView == null)
        {
          SoterTestUI.a(SoterTestUI.this).setText("not passed: no certificate");
          AppMethodBeat.o(59382);
          return;
        }
        SoterTestUI.a(SoterTestUI.this).setText("model available: " + paramAnonymousView.toString());
        AppMethodBeat.o(59382);
      }
    });
    this.soO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(59383);
        paramAnonymousView = a.awJ("sample_auth_key_name");
        TextView localTextView = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "pass";; paramAnonymousView = "not passed")
        {
          localTextView.setText(paramAnonymousView);
          AppMethodBeat.o(59383);
          return;
        }
      }
    });
    this.soP.setOnClickListener(new SoterTestUI.6(this));
    this.soQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(59385);
        paramAnonymousView = a.awM("sample_auth_key_name");
        if (paramAnonymousView == null)
        {
          SoterTestUI.a(SoterTestUI.this).setText("not passed: no certificate");
          AppMethodBeat.o(59385);
          return;
        }
        SoterTestUI.a(SoterTestUI.this).setText("model available: " + paramAnonymousView.toString());
        AppMethodBeat.o(59385);
      }
    });
    this.soR.setOnClickListener(new SoterTestUI.8(this));
    AppMethodBeat.o(59392);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI
 * JD-Core Version:    0.7.0.1
 */