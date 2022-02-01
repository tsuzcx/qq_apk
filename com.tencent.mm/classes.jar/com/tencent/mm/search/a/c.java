package com.tencent.mm.search.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.search.b.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class c
  extends d
{
  public static final a EZi;
  
  static
  {
    AppMethodBeat.i(105840);
    EZi = new a((byte)0);
    AppMethodBeat.o(105840);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, int paramInt, y paramy)
  {
    AppMethodBeat.i(105839);
    k.h(paramContext, "context");
    if (paramy == null)
    {
      AppMethodBeat.o(105839);
      return;
    }
    ad.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", " + ((h)paramy).fLP.field_md5);
    switch (((h)paramy).fNE)
    {
    default: 
      AppMethodBeat.o(105839);
      return;
    }
    paramContext = a.EZj;
    a.eHA();
    paramContext = ((h)paramy).fLP;
    paramy = aw.eLx();
    k.g(paramy, "EmojiStorageMgr.getInstance()");
    if (paramy.bxR().aJx(paramContext.field_md5) == null)
    {
      paramy = aw.eLx();
      k.g(paramy, "EmojiStorageMgr.getInstance()");
      paramy.bxR().K(paramContext);
    }
    AppMethodBeat.o(105839);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.a.c
 * JD-Core Version:    0.7.0.1
 */