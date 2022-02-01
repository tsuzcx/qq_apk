package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusShowActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "layoutRoot", "Landroid/widget/RelativeLayout;", "getLayoutRoot", "()Landroid/widget/RelativeLayout;", "setLayoutRoot", "(Landroid/widget/RelativeLayout;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusShowActivity
  extends MMActivity
{
  public static final a MOi;
  private RelativeLayout MOh;
  
  static
  {
    AppMethodBeat.i(232852);
    MOi = new a((byte)0);
    AppMethodBeat.o(232852);
  }
  
  public final int getLayoutId()
  {
    return b.f.Myh;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232850);
    super.onCreate(paramBundle);
    setMMTitle(b.h.Mzj);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.MOh = ((RelativeLayout)findViewById(b.e.Mwa));
    AppMethodBeat.o(232850);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusShowActivity$Companion;", "", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "p", "Landroid/os/Bundle;", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(TextStatusShowActivity paramTextStatusShowActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(232788);
      this.MOj.finish();
      AppMethodBeat.o(232788);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusShowActivity
 * JD-Core Version:    0.7.0.1
 */