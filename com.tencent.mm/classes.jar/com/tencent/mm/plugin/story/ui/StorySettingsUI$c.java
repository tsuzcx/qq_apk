package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.t;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$c
  implements StorySettingsUI.e
{
  private final View.OnClickListener sHV;
  private final String title;
  private final String value;
  
  public StorySettingsUI$c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110050);
    this.title = paramString1;
    this.value = paramString2;
    this.sHV = paramOnClickListener;
    AppMethodBeat.o(110050);
  }
  
  public final String Ol()
  {
    return this.title;
  }
  
  public final void ek(View paramView)
  {
    AppMethodBeat.i(110049);
    j.q(paramView, "view");
    this.sHV.onClick(paramView);
    t.makeText(ah.getContext(), (CharSequence)"ClickItem Done", 1).show();
    AppMethodBeat.o(110049);
  }
  
  public final String value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.c
 * JD-Core Version:    0.7.0.1
 */