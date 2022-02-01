package com.tencent.mm.plugin.recordvideo.plugin;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.b.b.n;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "emojiPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "getEmojiPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "emojiPanel$delegate", "Lkotlin/Lazy;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "hideEmojiPanel", "initEmojiPanel", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "release", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "showEmojiPanel", "plugin-recordvideo_release"})
public final class b
  extends a
  implements View.OnClickListener
{
  d APl;
  private final kotlin.f HMD;
  private ImageView wRg;
  
  public b(ViewGroup paramViewGroup, ImageView paramImageView, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(75458);
    this.wRg = paramImageView;
    this.APl = paramd;
    this.HMD = g.ar((kotlin.g.a.a)new a(paramViewGroup));
    this.wRg.setOnClickListener((View.OnClickListener)this);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_sticker, -1));
    AppMethodBeat.o(75458);
  }
  
  private final com.tencent.mm.plugin.recordvideo.ui.editor.a.a fwC()
  {
    AppMethodBeat.i(223966);
    com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.a.a)this.HMD.getValue();
    AppMethodBeat.o(223966);
    return locala;
  }
  
  private final void fwD()
  {
    AppMethodBeat.i(223974);
    if (fwC().HYF != null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        fwC().HYF = ((kotlin.g.a.b)new b(this));
        Object localObject = fwC();
        ac.a locala = (ac.a)new c(this);
        p.k(locala, "callback");
        ac localac = ad.aaf();
        p.j(localac, "callbackWrapper");
        localac.a(locala);
        ((com.tencent.mm.emoji.view.a)localObject).jPK.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)localac);
        localObject = com.tencent.mm.plugin.recordvideo.e.f.Ifk;
        com.tencent.mm.plugin.recordvideo.e.f.a(fwC());
      }
      AppMethodBeat.o(223974);
      return;
    }
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(223978);
    p.k(paramn, "externalPanelDataProvider");
    com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = fwC();
    p.k(paramn, "externalPanelDataProvider");
    locala.jPK.a(paramn);
    AppMethodBeat.o(223978);
  }
  
  public final void acl(int paramInt)
  {
    AppMethodBeat.i(223989);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_sticker, paramInt));
    AppMethodBeat.o(223989);
  }
  
  public final void ePv()
  {
    AppMethodBeat.i(223983);
    fwC().setShow(false);
    AppMethodBeat.o(223983);
  }
  
  public final void fwE()
  {
    AppMethodBeat.i(223981);
    fwD();
    fwC().setShow(true);
    AppMethodBeat.o(223981);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75456);
    if (fwC().jPJ.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      fwC().setShow(false);
      AppMethodBeat.o(75456);
      return true;
    }
    AppMethodBeat.o(75456);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75454);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    fwE();
    paramView = c.HUw;
    c.aVY("KEY_CLICK_EMOJI_COUNT_INT");
    paramView = c.HUw;
    c.acq(4);
    paramView = c.HUw;
    c.acr(6);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75454);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75455);
    fwC().jPK.destroy();
    AppMethodBeat.o(75455);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75457);
    super.setVisibility(paramInt);
    this.wRg.setVisibility(paramInt);
    AppMethodBeat.o(75457);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.recordvideo.ui.editor.a.a>
  {
    a(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin$initEmojiPanel$2", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-recordvideo_release"})
  public static final class c
    implements ac.a
  {
    public final void a(r paramr)
    {
      AppMethodBeat.i(223666);
      p.k(paramr, "emojiInfo");
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramr });
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("PARAM_EDIT_EMOJI_INFO", (Parcelable)paramr);
      this.HME.APl.a(d.c.HTa, localBundle);
      onHide();
      AppMethodBeat.o(223666);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(223667);
      b.a(this.HME).setShow(false);
      AppMethodBeat.o(223667);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b
 * JD-Core Version:    0.7.0.1
 */