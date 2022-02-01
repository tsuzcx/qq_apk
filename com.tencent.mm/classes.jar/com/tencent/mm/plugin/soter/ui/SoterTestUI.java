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
  private Button AXE = null;
  private Button AXF = null;
  private Button AXG = null;
  private Button AXH = null;
  private Button AXI = null;
  private Button AXJ = null;
  private Button AXK = null;
  private Button AXL = null;
  private Button AXM = null;
  private TextView AXN = null;
  
  public int getLayoutId()
  {
    return 2131495636;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(130918);
    super.onCreate(paramBundle);
    this.AXE = ((Button)findViewById(2131305127));
    this.AXF = ((Button)findViewById(2131305122));
    this.AXG = ((Button)findViewById(2131305126));
    this.AXH = ((Button)findViewById(2131305124));
    this.AXI = ((Button)findViewById(2131305121));
    this.AXJ = ((Button)findViewById(2131305125));
    this.AXK = ((Button)findViewById(2131305123));
    this.AXL = ((Button)findViewById(2131305120));
    this.AXM = ((Button)findViewById(2131305119));
    this.AXN = ((TextView)findViewById(2131304144));
    this.AXE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130905);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = SoterTestUI.a(SoterTestUI.this);
        if (com.tencent.soter.a.a.fZr()) {}
        for (paramAnonymousView = "passed";; paramAnonymousView = "not support")
        {
          ((TextView)localObject).setText(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130905);
          return;
        }
      }
    });
    this.AXF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130906);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = com.tencent.soter.core.a.fYZ();
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
    this.AXG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130907);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = com.tencent.soter.core.a.fZa();
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
    this.AXH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130908);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = com.tencent.soter.core.a.fZd();
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
    this.AXI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130909);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = com.tencent.soter.core.a.baU("sample_auth_key_name");
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
    this.AXJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130910);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = com.tencent.soter.core.a.dj("sample_auth_key_name", false);
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
    this.AXK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130911);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = com.tencent.soter.core.a.baX("sample_auth_key_name");
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
    this.AXL.setOnClickListener(new SoterTestUI.8(this));
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