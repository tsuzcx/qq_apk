package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$ac
  implements View.OnClickListener
{
  StorySettingsUI$ac(StorySettingsUI paramStorySettingsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(178051);
    paramView = new Intent();
    paramView.putExtra("KEY_EDITABLE", true);
    paramView.putExtra("KEY_CONTENT_XML", this.zDI.getSharedPreferences("test_plugin", 0).getString("content", ""));
    d.b((Context)this.zDI.getContext(), "editor", ".EditorUI", paramView, 4096);
    AppMethodBeat.o(178051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.ac
 * JD-Core Version:    0.7.0.1
 */