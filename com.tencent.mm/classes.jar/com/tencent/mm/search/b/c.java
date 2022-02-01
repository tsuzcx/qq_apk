package com.tencent.mm.search.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.search.c.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class c
  extends d
{
  public static final c.a Iiq;
  
  static
  {
    AppMethodBeat.i(105840);
    Iiq = new c.a((byte)0);
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
    ad.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", " + ((h)paramac).gjb.field_md5);
    switch (((h)paramac).gkP)
    {
    default: 
      AppMethodBeat.o(105839);
      return;
    }
    paramContext = a.Iir;
    a.fmF();
    paramContext = ((h)paramac).gjb;
    paramac = bd.frc();
    p.g(paramac, "EmojiStorageMgr.getInstance()");
    if (paramac.bIW().aUK(paramContext.field_md5) == null)
    {
      paramac = bd.frc();
      p.g(paramac, "EmojiStorageMgr.getInstance()");
      paramac.bIW().J(paramContext);
    }
    AppMethodBeat.o(105839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.b.c
 * JD-Core Version:    0.7.0.1
 */