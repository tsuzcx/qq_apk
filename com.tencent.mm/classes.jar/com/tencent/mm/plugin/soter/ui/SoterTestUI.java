package com.tencent.mm.plugin.soter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
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
  private Button AGb = null;
  private Button AGc = null;
  private Button AGd = null;
  private Button AGe = null;
  private Button AGf = null;
  private Button AGg = null;
  private Button AGh = null;
  private Button AGi = null;
  private Button AGj = null;
  private TextView AGk = null;
  
  public int getLayoutId()
  {
    return 2131495636;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(130918);
    super.onCreate(paramBundle);
    this.AGb = ((Button)findViewById(2131305127));
    this.AGc = ((Button)findViewById(2131305122));
    this.AGd = ((Button)findViewById(2131305126));
    this.AGe = ((Button)findViewById(2131305124));
    this.AGf = ((Button)findViewById(2131305121));
    this.AGg = ((Button)findViewById(2131305125));
    this.AGh = ((Button)findViewById(2131305123));
    this.AGi = ((Button)findViewById(2131305120));
    this.AGj = ((Button)findViewById(2131305119));
    this.AGk = ((TextView)findViewById(2131304144));
    this.AGb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130905);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = SoterTestUI.a(SoterTestUI.this);
        if (com.tencent.soter.a.a.fUS()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not support")
        {
          ((TextView)localObject).setText(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130905);
          return;
        }
      }
    });
    this.AGc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130906);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = com.tencent.soter.core.a.fUA();
        localObject = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not support")
        {
          ((TextView)localObject).setText(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130906);
          return;
        }
      }
    });
    this.AGd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130907);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = com.tencent.soter.core.a.fUB();
        localObject = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not passed")
        {
          ((TextView)localObject).setText(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130907);
          return;
        }
      }
    });
    this.AGe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130908);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = com.tencent.soter.core.a.fUE();
        if (paramAnonymousView == null)
        {
          SoterTestUI.a(SoterTestUI.this).setText("not passed: no certificate");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130908);
          return;
        }
        SoterTestUI.a(SoterTestUI.this).setText("model available: " + paramAnonymousView.toString());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(130908);
      }
    });
    this.AGf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130909);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = com.tencent.soter.core.a.aZr("sample_auth_key_name");
        localObject = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "pass";; paramAnonymousView = "not passed")
        {
          ((TextView)localObject).setText(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130909);
          return;
        }
      }
    });
    this.AGg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130910);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = com.tencent.soter.core.a.dg("sample_auth_key_name", false);
        localObject = SoterTestUI.a(SoterTestUI.this);
        if (paramAnonymousView.isSuccess()) {}
        for (paramAnonymousView = "pass";; paramAnonymousView = "not passed")
        {
          ((TextView)localObject).setText(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130910);
          return;
        }
      }
    });
    this.AGh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130911);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = com.tencent.soter.core.a.aZu("sample_auth_key_name");
        if (paramAnonymousView == null)
        {
          SoterTestUI.a(SoterTestUI.this).setText("not passed: no certificate");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130911);
          return;
        }
        SoterTestUI.a(SoterTestUI.this).setText("model available: " + paramAnonymousView.toString());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(130911);
      }
    });
    this.AGi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(130917);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = com.tencent.soter.core.a.aZv("sample_auth_key_name");
        if (paramAnonymousView != null) {}
        com.tencent.soter.core.a.a locala;
        try
        {
          paramAnonymousView.update("challenge".getBytes());
          paramAnonymousView.sign();
          ad.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
          SoterTestUI.a(SoterTestUI.this).setText("not passed: signature success without fingerprint authentication");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130917);
          return;
        }
        catch (SignatureException localSignatureException)
        {
          ad.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
          locala = com.tencent.soter.core.a.a.le(SoterTestUI.this);
          if (!com.tencent.soter.core.a.a.LPP.isHardwareDetected(locala.mContext)) {
            break label215;
          }
        }
        ad.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(130917);
        return;
        if (locala.hasEnrolledFingerprints()) {
          locala.a(new a.d(paramAnonymousView), null, new a.b()
          {
            public final void efW()
            {
              AppMethodBeat.i(130914);
              ad.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
              try
              {
                paramAnonymousView.update("challenge".getBytes());
                Object localObject = com.tencent.soter.core.a.cR(paramAnonymousView.sign());
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
                ad.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
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
              ad.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
              AppMethodBeat.o(130912);
            }
            
            public final void onAuthenticationFailed()
            {
              AppMethodBeat.i(130915);
              ad.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
              AppMethodBeat.o(130915);
            }
            
            public final void onAuthenticationHelp(int paramAnonymous2Int, CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(130913);
              ad.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
              AppMethodBeat.o(130913);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130917);
          return;
          label215:
          ad.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
        }
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