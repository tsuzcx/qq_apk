package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.model.panel.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/MultiVideoPluginLayout$1", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "plugin-vlog_release"})
public final class MultiVideoPluginLayout$1
  implements n
{
  public final void a(Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(196003);
    p.h(paramContext, "context");
    if (!(paramac instanceof e)) {}
    for (paramContext = null;; paramContext = paramac)
    {
      if ((e)paramContext != null)
      {
        paramContext = new Bundle();
        paramContext.putString("EDIT_PAG_STICKER_PATH", ((e)paramac).xPf);
        this.BLi.a(d.c.xGb, paramContext);
      }
      MultiVideoPluginLayout.H(this.BLi).xzQ.setShow(false);
      AppMethodBeat.o(196003);
      return;
    }
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(196004);
    p.h(paramContext, "context");
    AppMethodBeat.o(196004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout.1
 * JD-Core Version:    0.7.0.1
 */