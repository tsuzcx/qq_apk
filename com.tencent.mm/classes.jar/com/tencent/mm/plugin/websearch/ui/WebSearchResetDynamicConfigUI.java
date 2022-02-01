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
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchResetDynamicConfigUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-websearch_release"})
public final class WebSearchResetDynamicConfigUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return 2131497060;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201749);
    super.onCreate(paramBundle);
    setMMTitle(2131764623);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    ((Button)findViewById(2131305592)).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(201749);
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
    a(WebSearchResetDynamicConfigUI paramWebSearchResetDynamicConfigUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201747);
      this.IGO.finish();
      AppMethodBeat.o(201747);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchResetDynamicConfigUI paramWebSearchResetDynamicConfigUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201748);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/websearch/ui/WebSearchResetDynamicConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      try
      {
        paramView = this.IGO.findViewById(2131302944);
        p.g(paramView, "findViewById<MMEditText>(R.id.key_et)");
        paramView = ((MMEditText)paramView).getText().toString();
        localObject = this.IGO.findViewById(2131309674);
        p.g(localObject, "findViewById<MMEditText>(R.id.value_et)");
        localObject = ((MMEditText)localObject).getText().toString();
        h.aqJ().put(paramView, (String)localObject);
        u.makeText((Context)this.IGO.getContext(), (CharSequence)this.IGO.getString(2131755898), 0).show();
        a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetDynamicConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201748);
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          u.makeText((Context)this.IGO.getContext(), (CharSequence)this.IGO.getString(2131755897), 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchResetDynamicConfigUI
 * JD-Core Version:    0.7.0.1
 */