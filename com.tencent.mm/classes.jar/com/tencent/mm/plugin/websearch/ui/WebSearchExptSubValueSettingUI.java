package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.util.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchExptSubValueSettingUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-websearch_release"})
public final class WebSearchExptSubValueSettingUI
  extends MMSecDataActivity
{
  public final int getLayoutId()
  {
    return 2131497057;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(201743);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = getIntent().getStringExtra("valueKey");
    Object localObject = c.QYz;
    p.g(paramBundle, "key");
    localObject = c.axY(paramBundle);
    ((MMEditText)findViewById(2131309674)).setText((CharSequence)localObject);
    findViewById(2131305592).setOnClickListener((View.OnClickListener)new b(this, paramBundle));
    AppMethodBeat.o(201743);
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
    a(WebSearchExptSubValueSettingUI paramWebSearchExptSubValueSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201741);
      this.IGF.finish();
      AppMethodBeat.o(201741);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(WebSearchExptSubValueSettingUI paramWebSearchExptSubValueSettingUI, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201742);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/websearch/ui/WebSearchExptSubValueSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.IGF.findViewById(2131309674);
      p.g(paramView, "findViewById<MMEditText>(R.id.value_et)");
      paramView = ((MMEditText)paramView).getText().toString();
      localObject = c.QYz;
      localObject = paramBundle;
      p.g(localObject, "key");
      paramView = Util.nullAs(paramView, "");
      p.g(paramView, "Util.nullAs(value, \"\")");
      c.nq((String)localObject, paramView);
      a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchExptSubValueSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchExptSubValueSettingUI
 * JD-Core Version:    0.7.0.1
 */