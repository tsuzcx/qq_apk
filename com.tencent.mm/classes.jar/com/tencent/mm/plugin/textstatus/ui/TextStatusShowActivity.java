package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusShowActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "layoutRoot", "Landroid/widget/RelativeLayout;", "getLayoutRoot", "()Landroid/widget/RelativeLayout;", "setLayoutRoot", "(Landroid/widget/RelativeLayout;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusShowActivity
  extends MMActivity
{
  public static final a GfO;
  private RelativeLayout GfN;
  
  static
  {
    AppMethodBeat.i(216665);
    GfO = new a((byte)0);
    AppMethodBeat.o(216665);
  }
  
  public final int getLayoutId()
  {
    return 2131496702;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216664);
    super.onCreate(paramBundle);
    setMMTitle(2131766750);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.GfN = ((RelativeLayout)findViewById(2131303096));
    AppMethodBeat.o(216664);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusShowActivity$Companion;", "", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "p", "Landroid/os/Bundle;", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(TextStatusShowActivity paramTextStatusShowActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(216663);
      this.GfP.finish();
      AppMethodBeat.o(216663);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusShowActivity
 * JD-Core Version:    0.7.0.1
 */