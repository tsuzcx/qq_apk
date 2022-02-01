package com.tencent.mm.search.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.c.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class c
  extends e
{
  public static final a UWV;
  
  static
  {
    AppMethodBeat.i(105840);
    UWV = new a((byte)0);
    AppMethodBeat.o(105840);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt, ae paramae)
  {
    AppMethodBeat.i(224427);
    p.k(paramContext, "context");
    if (paramae == null)
    {
      AppMethodBeat.o(224427);
      return;
    }
    Log.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", " + ((h)paramae).jHh.field_md5);
    switch (((h)paramae).jJc)
    {
    default: 
      AppMethodBeat.o(224427);
      return;
    }
    paramView = a.UWW;
    a.htt();
    paramView = ((h)paramae).jHh;
    paramContext = bj.hyV();
    p.j(paramContext, "EmojiStorageMgr.getInstance()");
    if (paramContext.ctY().bxK(paramView.field_md5) == null)
    {
      paramContext = bj.hyV();
      p.j(paramContext, "EmojiStorageMgr.getInstance()");
      paramContext.ctY().L(paramView);
    }
    AppMethodBeat.o(224427);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.b.c
 * JD-Core Version:    0.7.0.1
 */