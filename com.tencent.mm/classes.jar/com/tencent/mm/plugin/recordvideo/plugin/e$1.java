package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.story.ui.view.editor.item.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$1
  implements View.OnClickListener
{
  e$1(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150605);
    Object localObject = this.qbR;
    if (!(paramView instanceof g)) {
      paramView = null;
    }
    for (;;)
    {
      ((e)localObject).qbP = ((g)paramView);
      paramView = this.qbR.qbP;
      if (paramView != null)
      {
        paramView.setVisibility(8);
        localObject = new Bundle();
        ((Bundle)localObject).putCharSequence("PARAM_EDIT_TEXT_CONTENT", paramView.getText());
        ((Bundle)localObject).putInt("PARAM_EDIT_TEXT_COLOR", paramView.getColor());
        ((Bundle)localObject).putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramView.getTextBg());
        this.qbR.qbI.a(d.c.qez, (Bundle)localObject);
        AppMethodBeat.o(150605);
        return;
      }
      AppMethodBeat.o(150605);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.e.1
 * JD-Core Version:    0.7.0.1
 */