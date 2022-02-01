package com.tencent.mm.plugin.story.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.t;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$c
  implements StorySettingsUI.e
{
  private final View.OnClickListener qQb;
  private final String title;
  private final String value;
  
  public StorySettingsUI$c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(119668);
    this.title = paramString1;
    this.value = paramString2;
    this.qQb = paramOnClickListener;
    AppMethodBeat.o(119668);
  }
  
  public final String aaO()
  {
    return this.title;
  }
  
  public final void dT(View paramView)
  {
    AppMethodBeat.i(119667);
    k.h(paramView, "view");
    this.qQb.onClick(paramView);
    t.makeText(aj.getContext(), (CharSequence)"ClickItem Done", 1).show();
    AppMethodBeat.o(119667);
  }
  
  public final String value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.c
 * JD-Core Version:    0.7.0.1
 */