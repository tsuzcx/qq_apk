package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-websearch_release"})
public final class WebSearchResetLocalConfigUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return 2131497060;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201752);
    super.onCreate(paramBundle);
    setMMTitle(2131764624);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    ((Button)findViewById(2131305592)).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(201752);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(WebSearchResetLocalConfigUI paramWebSearchResetLocalConfigUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201750);
      this.IGP.finish();
      AppMethodBeat.o(201750);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchResetLocalConfigUI paramWebSearchResetLocalConfigUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201751);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      ar.a locala;
      try
      {
        paramView = this.IGP.findViewById(2131302944);
        p.g(paramView, "findViewById<MMEditText>(R.id.key_et)");
        paramView = ((MMEditText)paramView).getText().toString();
        localObject = this.IGP.findViewById(2131309674);
        p.g(localObject, "findViewById<MMEditText>(R.id.value_et)");
        localObject = ((MMEditText)localObject).getText().toString();
        locala = ar.a.valueOf(paramView);
        paramView = (CharSequence)paramView;
        paramView = ((Collection)new k("_").q(paramView, 0)).toArray(new String[0]);
        if (paramView != null) {
          break label194;
        }
        paramView = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(201751);
        throw paramView;
      }
      catch (Exception paramView)
      {
        u.makeText((Context)this.IGP.getContext(), (CharSequence)this.IGP.getString(2131755897), 0).show();
      }
      a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201751);
      return;
      label194:
      String[] arrayOfString = (String[])paramView;
      paramView = arrayOfString[(arrayOfString.length - 1)];
      if (p.j(paramView, "SYNC"))
      {
        paramView = arrayOfString[(arrayOfString.length - 2)];
        label227:
        switch (paramView.hashCode())
        {
        }
      }
      for (;;)
      {
        label288:
        paramView = (Throwable)new RuntimeException();
        AppMethodBeat.o(201751);
        throw paramView;
        if (paramView.equals("FLOAT"))
        {
          paramView = g.aAh();
          p.g(paramView, "MMKernel.storage()");
          paramView.azQ().set(locala, Float.valueOf(Float.parseFloat((String)localObject)));
          for (;;)
          {
            u.makeText((Context)this.IGP.getContext(), (CharSequence)this.IGP.getString(2131755898), 0).show();
            break;
            if (!paramView.equals("STRING")) {
              break label288;
            }
            paramView = g.aAh();
            p.g(paramView, "MMKernel.storage()");
            paramView.azQ().set(locala, localObject);
            continue;
            if (!paramView.equals("DOUBLE")) {
              break label288;
            }
            paramView = g.aAh();
            p.g(paramView, "MMKernel.storage()");
            paramView.azQ().set(locala, Double.valueOf(Double.parseDouble((String)localObject)));
            continue;
            if (!paramView.equals("INT")) {
              break label288;
            }
            paramView = g.aAh();
            p.g(paramView, "MMKernel.storage()");
            paramView.azQ().set(locala, Integer.valueOf(Integer.parseInt((String)localObject)));
            continue;
            if (!paramView.equals("BOOLEAN")) {
              break label288;
            }
            paramView = g.aAh();
            p.g(paramView, "MMKernel.storage()");
            paramView.azQ().set(locala, Boolean.valueOf(Boolean.parseBoolean((String)localObject)));
            continue;
            if (!paramView.equals("LONG")) {
              break label288;
            }
            paramView = g.aAh();
            p.g(paramView, "MMKernel.storage()");
            paramView.azQ().set(locala, Long.valueOf(Long.parseLong((String)localObject)));
          }
          break label227;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchResetLocalConfigUI
 * JD-Core Version:    0.7.0.1
 */