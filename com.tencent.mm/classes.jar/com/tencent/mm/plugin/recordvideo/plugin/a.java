package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "emojiPanel", "Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "name", "", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "release", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, q
{
  private ImageView mCy;
  private final com.tencent.mm.media.editor.b.a qbH;
  d qbI;
  
  public a(ViewGroup paramViewGroup, ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(150590);
    this.mCy = paramImageView;
    this.qbI = paramd;
    this.mCy.setOnClickListener((View.OnClickListener)this);
    this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231476, -1));
    paramImageView = paramViewGroup.getContext();
    j.p(paramImageView, "parent.context");
    this.qbH = new com.tencent.mm.media.editor.b.a(paramImageView, paramViewGroup);
    this.qbH.eTl = ((a.f.a.b)new a.1(this));
    this.qbH.a((t.a)new a.2(this));
    AppMethodBeat.o(150590);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150588);
    if (this.qbH.Pk())
    {
      this.qbH.setShow(false);
      AppMethodBeat.o(150588);
      return true;
    }
    AppMethodBeat.o(150588);
    return false;
  }
  
  public final String name()
  {
    return "plugin_emoji";
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150586);
    this.qbH.setShow(true);
    paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    com.tencent.mm.plugin.recordvideo.c.b.Ya("KEY_CLICK_EMOJI_COUNT_INT");
    paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    com.tencent.mm.plugin.recordvideo.c.b.Cs(4);
    AppMethodBeat.o(150586);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(150587);
    this.qbH.eys.destroy();
    AppMethodBeat.o(150587);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150589);
    this.mCy.setVisibility(paramInt);
    AppMethodBeat.o(150589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a
 * JD-Core Version:    0.7.0.1
 */