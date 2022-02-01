package com.tencent.mm.plugin.recordvideo.plugin;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.ae;
import com.tencent.mm.api.t;
import com.tencent.mm.emoji.c.b.n;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.util.h;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "emojiPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "getEmojiPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "emojiPanel$delegate", "Lkotlin/Lazy;", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "hideEmojiPanel", "initEmojiPanel", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "release", "resetIconColor", "iconColor", "", "setVisibility", "visibility", "showEmojiPanel", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
  implements View.OnClickListener
{
  private final kotlin.j NJA;
  private ImageView cqj;
  
  public c(ViewGroup paramViewGroup, ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(75458);
    this.cqj = paramImageView;
    this.NJA = k.cm((kotlin.g.a.a)new a(paramViewGroup));
    this.cqj.setOnClickListener((View.OnClickListener)this);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_sticker, -1));
    AppMethodBeat.o(75458);
  }
  
  private final com.tencent.mm.plugin.recordvideo.ui.editor.a.a gIl()
  {
    AppMethodBeat.i(280510);
    com.tencent.mm.plugin.recordvideo.ui.editor.a.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.a.a)this.NJA.getValue();
    AppMethodBeat.o(280510);
    return locala;
  }
  
  private final void gIm()
  {
    AppMethodBeat.i(280514);
    if (gIl().NVo != null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        gIl().NVo = ((kotlin.g.a.b)new b(this));
        Object localObject = gIl();
        ad.a locala = (ad.a)new c(this);
        s.u(locala, "callback");
        ad localad = ae.aBJ();
        localad.hej = locala;
        ((com.tencent.mm.emoji.view.a)localObject).moB.setCallback((f)localad);
        localObject = h.Obz;
        h.a(gIl());
      }
      AppMethodBeat.o(280514);
      return;
    }
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(280532);
    s.u(paramn, "externalPanelDataProvider");
    Object localObject = gIl();
    s.u(paramn, "externalPanelDataProvider");
    localObject = ((com.tencent.mm.emoji.view.a)localObject).moB.agJZ;
    com.tencent.mm.emoji.c.b.j localj = ((com.tencent.mm.view.manager.a)localObject).agMO;
    s.u(paramn, "externalPanelProvider");
    localj.miP.add(paramn);
    ((com.tencent.mm.view.manager.a)localObject).agMO.aVl();
    AppMethodBeat.o(280532);
  }
  
  public final void agy(int paramInt)
  {
    AppMethodBeat.i(280575);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_sticker, paramInt));
    AppMethodBeat.o(280575);
  }
  
  public final void fXZ()
  {
    AppMethodBeat.i(280548);
    gIl().setShow(false);
    AppMethodBeat.o(280548);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(280544);
    gIm();
    gIl().setShow(true);
    AppMethodBeat.o(280544);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75456);
    if (gIl().moA.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      gIl().setShow(false);
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
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    gIn();
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_EMOJI_COUNT_INT");
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agG(4);
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agH(6);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75454);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75455);
    gIl().moB.destroy();
    AppMethodBeat.o(75455);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75457);
    super.setVisibility(paramInt);
    this.cqj.setVisibility(paramInt);
    AppMethodBeat.o(75457);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.recordvideo.ui.editor.a.a>
  {
    a(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin$initEmojiPanel$2", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ad.a
  {
    c(c paramc) {}
    
    public final void a(t paramt)
    {
      AppMethodBeat.i(280534);
      s.u(paramt, "emojiInfo");
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramt });
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("PARAM_EDIT_EMOJI_INFO", (Parcelable)paramt);
      this.NJB.GrC.a(a.c.NPG, localBundle);
      onHide();
      AppMethodBeat.o(280534);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(280543);
      c.a(this.NJB).setShow(false);
      AppMethodBeat.o(280543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.c
 * JD-Core Version:    0.7.0.1
 */