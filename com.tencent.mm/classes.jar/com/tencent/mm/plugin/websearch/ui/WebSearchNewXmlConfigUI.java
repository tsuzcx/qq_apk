package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchNewXmlConfigUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-websearch_release"})
public final class WebSearchNewXmlConfigUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return 2131497059;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201746);
    super.onCreate(paramBundle);
    setMMTitle(2131763546);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(2131305592).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(201746);
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
    a(WebSearchNewXmlConfigUI paramWebSearchNewXmlConfigUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201744);
      this.IGN.finish();
      AppMethodBeat.o(201744);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchNewXmlConfigUI paramWebSearchNewXmlConfigUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201745);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/websearch/ui/WebSearchNewXmlConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = new de();
      paramView.xKb = 10002;
      localObject = this.IGN.findViewById(2131310670);
      p.g(localObject, "findViewById<MMEditText>(R.id.xml_et)");
      localObject = ((MMEditText)localObject).getText().toString();
      paramView.KHn = new dqi().bhy((String)localObject);
      paramView = new h.a(paramView, false, false, false);
      localObject = g.ah(s.class);
      p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((s)localObject).getSysCmdMsgExtension().b(paramView);
      a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchNewXmlConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201745);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchNewXmlConfigUI
 * JD-Core Version:    0.7.0.1
 */