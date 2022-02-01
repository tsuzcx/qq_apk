package com.tencent.mm.search.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.c.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  public static final c.a acsh;
  
  static
  {
    AppMethodBeat.i(105840);
    acsh = new c.a((byte)0);
    AppMethodBeat.o(105840);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt, ae paramae)
  {
    AppMethodBeat.i(236852);
    s.u(paramContext, "context");
    if (paramae == null)
    {
      AppMethodBeat.o(236852);
      return;
    }
    paramView = new StringBuilder("onClick: ").append(paramInt).append(", ");
    if (paramae == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
      AppMethodBeat.o(236852);
      throw paramView;
    }
    Log.i("MicroMsg.SimilarEmoji", ((h)paramae).mgK.field_md5);
    if (((h)paramae).miu == 103)
    {
      paramView = a.acsi;
      a.iTA();
      paramView = ((h)paramae).mgK;
      if (bl.jba().adju.bza(paramView.field_md5) == null) {
        bl.jba().adju.L(paramView);
      }
      AppMethodBeat.o(236852);
      return;
    }
    AppMethodBeat.o(236852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.b.c
 * JD-Core Version:    0.7.0.1
 */