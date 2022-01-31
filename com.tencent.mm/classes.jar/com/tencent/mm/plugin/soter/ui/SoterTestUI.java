package com.tencent.mm.plugin.soter.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.ah.a.a;
import com.tencent.mm.plugin.ah.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.i;

public class SoterTestUI
  extends MMActivity
{
  private Button psE = null;
  private Button psF = null;
  private Button psG = null;
  private Button psH = null;
  private Button psI = null;
  private Button psJ = null;
  private Button psK = null;
  private Button psL = null;
  private Button psM = null;
  private TextView psN = null;
  
  protected final int getLayoutId()
  {
    return a.b.soter_test_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.psE = ((Button)findViewById(a.a.soter_test_support_soter));
    this.psF = ((Button)findViewById(a.a.soter_test_gen_ask));
    this.psG = ((Button)findViewById(a.a.soter_test_remove_ask));
    this.psH = ((Button)findViewById(a.a.soter_test_get_ask_pub));
    this.psI = ((Button)findViewById(a.a.soter_test_gen_ak));
    this.psJ = ((Button)findViewById(a.a.soter_test_remove_ak));
    this.psK = ((Button)findViewById(a.a.soter_test_get_ak_pub));
    this.psL = ((Button)findViewById(a.a.soter_test_do_sign));
    this.psM = ((Button)findViewById(a.a.soter_test_decrypt_import));
    this.psN = ((TextView)findViewById(a.a.result_tv));
    this.psE.setOnClickListener(new SoterTestUI.1(this));
    this.psF.setOnClickListener(new SoterTestUI.2(this));
    this.psG.setOnClickListener(new SoterTestUI.3(this));
    this.psH.setOnClickListener(new SoterTestUI.4(this));
    this.psI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = a.afO("sample_auth_key_name");
        TextView localTextView = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "pass";; paramAnonymousView = "not passed")
        {
          localTextView.setText(paramAnonymousView);
          return;
        }
      }
    });
    this.psJ.setOnClickListener(new SoterTestUI.6(this));
    this.psK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = a.afR("sample_auth_key_name");
        if (paramAnonymousView == null)
        {
          SoterTestUI.a(SoterTestUI.this).setText("not passed: no certificate");
          return;
        }
        SoterTestUI.a(SoterTestUI.this).setText("model available: " + paramAnonymousView.toString());
      }
    });
    this.psL.setOnClickListener(new SoterTestUI.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI
 * JD-Core Version:    0.7.0.1
 */