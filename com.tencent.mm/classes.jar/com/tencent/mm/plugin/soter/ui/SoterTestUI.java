package com.tencent.mm.plugin.soter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.a.a.b;
import com.tencent.soter.core.a.a.d;
import com.tencent.soter.core.a.a.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.i;
import com.tencent.soter.core.c.j;
import java.security.Signature;
import java.security.SignatureException;

public class SoterTestUI
  extends MMActivity
{
  private Button zoh = null;
  private Button zoi = null;
  private Button zoj = null;
  private Button zok = null;
  private Button zol = null;
  private Button zom = null;
  private Button zon = null;
  private Button zoo = null;
  private Button zop = null;
  private TextView zoq = null;
  
  public int getLayoutId()
  {
    return 2131495636;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(130918);
    super.onCreate(paramBundle);
    this.zoh = ((Button)findViewById(2131305127));
    this.zoi = ((Button)findViewById(2131305122));
    this.zoj = ((Button)findViewById(2131305126));
    this.zok = ((Button)findViewById(2131305124));
    this.zol = ((Button)findViewById(2131305121));
    this.zom = ((Button)findViewById(2131305125));
    this.zon = ((Button)findViewById(2131305123));
    this.zoo = ((Button)findViewById(2131305120));
    this.zop = ((Button)findViewById(2131305119));
    this.zoq = ((TextView)findViewById(2131304144));
    this.zoh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130905);
        TextView localTextView = SoterTestUI.a(SoterTestUI.this);
        if (com.tencent.soter.a.a.fDA()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not support")
        {
          localTextView.setText(paramAnonymousView);
          AppMethodBeat.o(130905);
          return;
        }
      }
    });
    this.zoi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130906);
        paramAnonymousView = com.tencent.soter.core.a.fDi();
        TextView localTextView = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not support")
        {
          localTextView.setText(paramAnonymousView);
          AppMethodBeat.o(130906);
          return;
        }
      }
    });
    this.zoj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130907);
        paramAnonymousView = com.tencent.soter.core.a.fDj();
        TextView localTextView = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not passed")
        {
          localTextView.setText(paramAnonymousView);
          AppMethodBeat.o(130907);
          return;
        }
      }
    });
    this.zok.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130908);
        paramAnonymousView = com.tencent.soter.core.a.fDm();
        if (paramAnonymousView == null)
        {
          SoterTestUI.a(SoterTestUI.this).setText("not passed: no certificate");
          AppMethodBeat.o(130908);
          return;
        }
        SoterTestUI.a(SoterTestUI.this).setText("model available: " + paramAnonymousView.toString());
        AppMethodBeat.o(130908);
      }
    });
    this.zol.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130909);
        paramAnonymousView = com.tencent.soter.core.a.aTr("sample_auth_key_name");
        TextView localTextView = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "pass";; paramAnonymousView = "not passed")
        {
          localTextView.setText(paramAnonymousView);
          AppMethodBeat.o(130909);
          return;
        }
      }
    });
    this.zom.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130910);
        paramAnonymousView = com.tencent.soter.core.a.db("sample_auth_key_name", false);
        TextView localTextView = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "pass";; paramAnonymousView = "not passed")
        {
          localTextView.setText(paramAnonymousView);
          AppMethodBeat.o(130910);
          return;
        }
      }
    });
    this.zon.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130911);
        paramAnonymousView = com.tencent.soter.core.a.aTu("sample_auth_key_name");
        if (paramAnonymousView == null)
        {
          SoterTestUI.a(SoterTestUI.this).setText("not passed: no certificate");
          AppMethodBeat.o(130911);
          return;
        }
        SoterTestUI.a(SoterTestUI.this).setText("model available: " + paramAnonymousView.toString());
        AppMethodBeat.o(130911);
      }
    });
    this.zoo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(130917);
        paramAnonymousView = com.tencent.soter.core.a.aTv("sample_auth_key_name");
        if (paramAnonymousView != null) {}
        try
        {
          paramAnonymousView.update("challenge".getBytes());
          paramAnonymousView.sign();
          ac.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
          SoterTestUI.a(SoterTestUI.this).setText("not passed: signature success without fingerprint authentication");
          AppMethodBeat.o(130917);
          return;
        }
        catch (SignatureException localSignatureException)
        {
          ac.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
          com.tencent.soter.core.a.a locala = com.tencent.soter.core.a.a.kR(SoterTestUI.this);
          if ((!com.tencent.soter.core.a.a.JVU.isHardwareDetected(locala.mContext)) || (!locala.hasEnrolledFingerprints())) {
            break label150;
          }
          locala.a(new a.d(paramAnonymousView), null, new a.b()
          {
            public final void dTI()
            {
              AppMethodBeat.i(130914);
              ac.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
              try
              {
                paramAnonymousView.update("challenge".getBytes());
                Object localObject = com.tencent.soter.core.a.cK(paramAnonymousView.sign());
                TextView localTextView = SoterTestUI.a(SoterTestUI.this);
                if (localObject == null) {}
                for (localObject = "not pass: exception occurs";; localObject = ((j)localObject).toString())
                {
                  localTextView.setText((CharSequence)localObject);
                  AppMethodBeat.o(130914);
                  return;
                }
                return;
              }
              catch (SignatureException localSignatureException)
              {
                ac.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
                AppMethodBeat.o(130914);
              }
            }
            
            public final void onAuthenticationCancelled()
            {
              AppMethodBeat.i(130916);
              super.onAuthenticationCancelled();
              AppMethodBeat.o(130916);
            }
            
            public final void onAuthenticationError(int paramAnonymous2Int, CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(130912);
              ac.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
              AppMethodBeat.o(130912);
            }
            
            public final void onAuthenticationFailed()
            {
              AppMethodBeat.i(130915);
              ac.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
              AppMethodBeat.o(130915);
            }
            
            public final void onAuthenticationHelp(int paramAnonymous2Int, CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(130913);
              ac.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
              AppMethodBeat.o(130913);
            }
          });
          AppMethodBeat.o(130917);
          return;
          label150:
          ac.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
          AppMethodBeat.o(130917);
        }
        ac.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
        AppMethodBeat.o(130917);
        return;
      }
    });
    AppMethodBeat.o(130918);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI
 * JD-Core Version:    0.7.0.1
 */