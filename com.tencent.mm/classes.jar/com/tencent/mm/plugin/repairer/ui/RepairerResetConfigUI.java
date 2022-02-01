package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-repairer_release"})
public final class RepairerResetConfigUI
  extends MMActivity
{
  public static final a Ixb;
  
  static
  {
    AppMethodBeat.i(226844);
    Ixb = new a((byte)0);
    AppMethodBeat.o(226844);
  }
  
  public final int getLayoutId()
  {
    return b.b.IwR;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226841);
    super.onCreate(paramBundle);
    setMMTitle("微信设置本地配置");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = (Button)findViewById(b.a.Iwq);
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    ((Button)findViewById(b.a.Iwp)).setOnClickListener((View.OnClickListener)new d(this));
    ((Button)findViewById(b.a.Iwc)).setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(226841);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI$Companion;", "", "()V", "TAG", "", "ui-repairer_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(RepairerResetConfigUI paramRepairerResetConfigUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226636);
      this.Ixc.finish();
      AppMethodBeat.o(226636);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RepairerResetConfigUI paramRepairerResetConfigUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227430);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Ixc.findViewById(b.a.Iwo);
      p.j(paramView, "findViewById<EditText>(R.id.local_key_et)");
      ((EditText)paramView).getText();
      this.Ixc.findViewById(b.a.Iwr);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227430);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(RepairerResetConfigUI paramRepairerResetConfigUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227032);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      ar.a locala;
      try
      {
        paramView = this.Ixc.findViewById(b.a.Iwo);
        p.j(paramView, "findViewById<MMEditText>(R.id.local_key_et)");
        paramView = ((MMEditText)paramView).getText().toString();
        localObject = this.Ixc.findViewById(b.a.Iwr);
        p.j(localObject, "findViewById<MMEditText>(R.id.local_value_et)");
        localObject = ((MMEditText)localObject).getText().toString();
        locala = ar.a.valueOf(paramView);
        paramView = (CharSequence)paramView;
        paramView = ((Collection)new k("_").u(paramView, 0)).toArray(new String[0]);
        if (paramView != null) {
          break label197;
        }
        paramView = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(227032);
        throw paramView;
      }
      catch (Exception paramView)
      {
        w.makeText((Context)this.Ixc.getContext(), (CharSequence)this.Ixc.getString(b.d.app_modify_failed), 0).show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227032);
      return;
      label197:
      String[] arrayOfString = (String[])paramView;
      paramView = arrayOfString[(arrayOfString.length - 1)];
      if (p.h(paramView, "SYNC"))
      {
        paramView = arrayOfString[(arrayOfString.length - 2)];
        label230:
        switch (paramView.hashCode())
        {
        }
      }
      for (;;)
      {
        label292:
        paramView = (Throwable)new RuntimeException();
        AppMethodBeat.o(227032);
        throw paramView;
        if (paramView.equals("FLOAT"))
        {
          paramView = h.aHG();
          p.j(paramView, "MMKernel.storage()");
          paramView.aHp().set(locala, Float.valueOf(Float.parseFloat((String)localObject)));
          for (;;)
          {
            w.makeText((Context)this.Ixc.getContext(), (CharSequence)this.Ixc.getString(b.d.app_modify_success), 0).show();
            break;
            if (!paramView.equals("STRING")) {
              break label292;
            }
            paramView = h.aHG();
            p.j(paramView, "MMKernel.storage()");
            paramView.aHp().set(locala, localObject);
            continue;
            if (!paramView.equals("DOUBLE")) {
              break label292;
            }
            paramView = h.aHG();
            p.j(paramView, "MMKernel.storage()");
            paramView.aHp().set(locala, Double.valueOf(Double.parseDouble((String)localObject)));
            continue;
            if (!paramView.equals("INT")) {
              break label292;
            }
            paramView = h.aHG();
            p.j(paramView, "MMKernel.storage()");
            paramView.aHp().set(locala, Integer.valueOf(Integer.parseInt((String)localObject)));
            continue;
            if (!paramView.equals("BOOLEAN")) {
              break label292;
            }
            paramView = h.aHG();
            p.j(paramView, "MMKernel.storage()");
            paramView.aHp().set(locala, Boolean.valueOf(Boolean.parseBoolean((String)localObject)));
            continue;
            if (!paramView.equals("LONG")) {
              break label292;
            }
            paramView = h.aHG();
            p.j(paramView, "MMKernel.storage()");
            paramView.aHp().set(locala, Long.valueOf(Long.parseLong((String)localObject)));
          }
          break label230;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(RepairerResetConfigUI paramRepairerResetConfigUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226700);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      try
      {
        paramView = this.Ixc.findViewById(b.a.Iwb);
        p.j(paramView, "findViewById<MMEditText>(R.id.dynamic_key_et)");
        paramView = ((MMEditText)paramView).getText().toString();
        localObject = this.Ixc.findViewById(b.a.Iwd);
        p.j(localObject, "findViewById<MMEditText>(R.id.dynamic_value_et)");
        localObject = ((MMEditText)localObject).getText().toString();
        com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.zero.b.a.class);
        p.j(locala, "MMKernel.service(IConfigService::class.java)");
        ((com.tencent.mm.plugin.zero.b.a)locala).axc().put(paramView, (String)localObject);
        w.makeText((Context)this.Ixc.getContext(), (CharSequence)this.Ixc.getString(b.d.app_modify_success), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226700);
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          w.makeText((Context)this.Ixc.getContext(), (CharSequence)this.Ixc.getString(b.d.app_modify_failed), 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerResetConfigUI
 * JD-Core Version:    0.7.0.1
 */