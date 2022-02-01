package com.tencent.mm.search.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.search.c.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class c
  extends d
{
  public static final c.a ICB;
  
  static
  {
    AppMethodBeat.i(105840);
    ICB = new c.a((byte)0);
    AppMethodBeat.o(105840);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(105839);
    p.h(paramContext, "context");
    if (paramac == null)
    {
      AppMethodBeat.o(105839);
      return;
    }
    ae.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", " + ((h)paramac).glt.field_md5);
    switch (((h)paramac).gnk)
    {
    default: 
      AppMethodBeat.o(105839);
      return;
    }
    paramContext = a.ICC;
    a.fqA();
    paramContext = ((h)paramac).glt;
    paramac = be.fvc();
    p.g(paramac, "EmojiStorageMgr.getInstance()");
    if (paramac.bJU().aWl(paramContext.field_md5) == null)
    {
      paramac = be.fvc();
      p.g(paramac, "EmojiStorageMgr.getInstance()");
      paramac.bJU().J(paramContext);
    }
    AppMethodBeat.o(105839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.b.c
 * JD-Core Version:    0.7.0.1
 */