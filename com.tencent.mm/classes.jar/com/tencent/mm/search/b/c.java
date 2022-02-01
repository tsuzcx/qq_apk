package com.tencent.mm.search.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.c.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class c
  extends d
{
  public static final c.a NJu;
  
  static
  {
    AppMethodBeat.i(105840);
    NJu = new c.a((byte)0);
    AppMethodBeat.o(105840);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(200087);
    p.h(paramContext, "context");
    if (paramac == null)
    {
      AppMethodBeat.o(200087);
      return;
    }
    Log.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", " + ((h)paramac).gWm.field_md5);
    switch (((h)paramac).gYc)
    {
    default: 
      AppMethodBeat.o(200087);
      return;
    }
    paramView = a.NJv;
    a.gxv();
    paramView = ((h)paramac).gWm;
    paramContext = bj.gCJ();
    p.g(paramContext, "EmojiStorageMgr.getInstance()");
    if (paramContext.cgN().blk(paramView.field_md5) == null)
    {
      paramContext = bj.gCJ();
      p.g(paramContext, "EmojiStorageMgr.getInstance()");
      paramContext.cgN().K(paramView);
    }
    AppMethodBeat.o(200087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.search.b.c
 * JD-Core Version:    0.7.0.1
 */