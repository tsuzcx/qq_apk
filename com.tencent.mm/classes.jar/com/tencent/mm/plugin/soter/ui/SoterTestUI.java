package com.tencent.mm.plugin.soter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.an.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.a.a.d;
import com.tencent.soter.core.a.a.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.j;
import java.security.Signature;
import java.security.SignatureException;

public class SoterTestUI
  extends MMActivity
{
  private Button Lxc = null;
  private Button Lxd = null;
  private Button Lxe = null;
  private Button Lxf = null;
  private Button Lxg = null;
  private Button Lxh = null;
  private Button Lxi = null;
  private Button Lxj = null;
  private Button Lxk = null;
  private TextView Lxl = null;
  
  public int getLayoutId()
  {
    return com.tencent.mm.plugin.an.a.b.soter_test_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(130918);
    super.onCreate(paramBundle);
    this.Lxc = ((Button)findViewById(a.a.soter_test_support_soter));
    this.Lxd = ((Button)findViewById(a.a.soter_test_gen_ask));
    this.Lxe = ((Button)findViewById(a.a.soter_test_remove_ask));
    this.Lxf = ((Button)findViewById(a.a.soter_test_get_ask_pub));
    this.Lxg = ((Button)findViewById(a.a.soter_test_gen_ak));
    this.Lxh = ((Button)findViewById(a.a.soter_test_remove_ak));
    this.Lxi = ((Button)findViewById(a.a.soter_test_get_ak_pub));
    this.Lxj = ((Button)findViewById(a.a.soter_test_do_sign));
    this.Lxk = ((Button)findViewById(a.a.soter_test_decrypt_import));
    this.Lxl = ((TextView)findViewById(a.a.result_tv));
    this.Lxc.setOnClickListener(new SoterTestUI.1(this));
    this.Lxd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130906);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/soter/ui/SoterTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = com.tencent.soter.core.a.ioJ();
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
    this.Lxe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130907);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/soter/ui/SoterTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = com.tencent.soter.core.a.ioK();
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
    this.Lxf.setOnClickListener(new SoterTestUI.4(this));
    this.Lxg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130909);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/soter/ui/SoterTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = com.tencent.soter.core.a.bCZ("sample_auth_key_name");
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
    this.Lxh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130910);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/soter/ui/SoterTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = com.tencent.soter.core.a.dQ("sample_auth_key_name", false);
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
    this.Lxi.setOnClickListener(new SoterTestUI.7(this));
    this.Lxj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(130917);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = com.tencent.soter.core.a.bDd("sample_auth_key_name");
        if (paramAnonymousView != null) {}
        com.tencent.soter.core.a.a locala;
        try
        {
          paramAnonymousView.update("challenge".getBytes());
          paramAnonymousView.sign();
          Log.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
          SoterTestUI.a(SoterTestUI.this).setText("not passed: signature success without fingerprint authentication");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130917);
          return;
        }
        catch (SignatureException localSignatureException)
        {
          Log.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
          locala = com.tencent.soter.core.a.a.md(SoterTestUI.this);
          if (!com.tencent.soter.core.a.a.ZrP.isHardwareDetected(locala.mContext)) {
            break label215;
          }
        }
        Log.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(130917);
        return;
        if (locala.ioP()) {
          locala.a(new a.d(paramAnonymousView), null, new com.tencent.soter.core.a.a.b()
          {
            public final void gaA()
            {
              AppMethodBeat.i(130914);
              Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
              try
              {
                paramAnonymousView.update("challenge".getBytes());
                Object localObject = com.tencent.soter.core.a.dv(paramAnonymousView.sign());
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
                Log.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
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
              Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
              AppMethodBeat.o(130912);
            }
            
            public final void onAuthenticationFailed()
            {
              AppMethodBeat.i(130915);
              Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
              AppMethodBeat.o(130915);
            }
            
            public final void onAuthenticationHelp(int paramAnonymous2Int, CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(130913);
              Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
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
          Log.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI
 * JD-Core Version:    0.7.0.1
 */