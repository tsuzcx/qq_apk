package com.tencent.mm.search.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.search.c.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class c
  extends d
{
  public static final c.a Gww;
  
  static
  {
    AppMethodBeat.i(105840);
    Gww = new c.a((byte)0);
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
    ac.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", " + ((h)paramy).fPB.field_md5);
    switch (((h)paramy).fRp)
    {
    default: 
      AppMethodBeat.o(105839);
      return;
    }
    paramContext = a.Gwx;
    a.eWV();
    paramContext = ((h)paramy).fPB;
    paramy = az.faZ();
    k.g(paramy, "EmojiStorageMgr.getInstance()");
    if (paramy.bEN().aOT(paramContext.field_md5) == null)
    {
      paramy = az.faZ();
      k.g(paramy, "EmojiStorageMgr.getInstance()");
      paramy.bEN().K(paramContext);
    }
    AppMethodBeat.o(105839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.b.c
 * JD-Core Version:    0.7.0.1
 */