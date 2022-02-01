package com.tencent.mm.plugin.soter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.i;

public class SoterTestUI
  extends MMActivity
{
  private Button FiA = null;
  private Button FiB = null;
  private Button FiC = null;
  private Button FiD = null;
  private Button FiE = null;
  private Button FiF = null;
  private TextView FiG = null;
  private Button Fix = null;
  private Button Fiy = null;
  private Button Fiz = null;
  
  public int getLayoutId()
  {
    return 2131496537;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(130918);
    super.onCreate(paramBundle);
    this.Fix = ((Button)findViewById(2131308305));
    this.Fiy = ((Button)findViewById(2131308300));
    this.Fiz = ((Button)findViewById(2131308304));
    this.FiA = ((Button)findViewById(2131308302));
    this.FiB = ((Button)findViewById(2131308299));
    this.FiC = ((Button)findViewById(2131308303));
    this.FiD = ((Button)findViewById(2131308301));
    this.FiE = ((Button)findViewById(2131308298));
    this.FiF = ((Button)findViewById(2131308297));
    this.FiG = ((TextView)findViewById(2131307040));
    this.Fix.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130905);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = SoterTestUI.a(SoterTestUI.this);
        if (com.tencent.soter.a.a.hlC()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not support")
        {
          ((TextView)localObject).setText(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130905);
          return;
        }
      }
    });
    this.Fiy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130906);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = com.tencent.soter.core.a.hlk();
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
    this.Fiz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130907);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = com.tencent.soter.core.a.hll();
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
    this.FiA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130908);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.soter.core.a.hlo();
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
    this.FiB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130909);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = com.tencent.soter.core.a.bqg("sample_auth_key_name");
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
    this.FiC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130910);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = com.tencent.soter.core.a.dE("sample_auth_key_name", false);
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
    this.FiD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130911);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.soter.core.a.bqj("sample_auth_key_name");
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
    this.FiE.setOnClickListener(new SoterTestUI.8(this));
    AppMethodBeat.o(130918);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI
 * JD-Core Version:    0.7.0.1
 */