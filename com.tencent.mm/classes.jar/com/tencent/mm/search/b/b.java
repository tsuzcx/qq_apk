package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.ah;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.search.c.a;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final b.a Iip;
  public SimilarEmojiQueryModel Iio;
  
  static
  {
    AppMethodBeat.i(105838);
    Iip = new b.a((byte)0);
    AppMethodBeat.o(105838);
  }
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(105837);
    p.h(paramContext, "context");
    if (paramac == null)
    {
      AppMethodBeat.o(105837);
      return;
    }
    if ((paramac instanceof h)) {}
    for (Object localObject = ((h)paramac).gjb.field_md5;; localObject = "")
    {
      ad.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", md5 :" + (String)localObject);
      if ((!(paramac instanceof h)) || (((h)paramac).gkP != 102)) {
        break label403;
      }
      localObject = a.Iir;
      a.fmE();
      localObject = com.tencent.mm.search.c.b.Iiu;
      com.tencent.mm.search.c.b.b(((h)paramac).gjb, paramInt);
      if (((h)paramac).gjb.Ofk == 1)
      {
        if (bt.isNullOrNil(((h)paramac).gjb.afw())) {
          break;
        }
        localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        if (!((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().abw(((h)paramac).gjb.afw())) {
          break;
        }
        ad.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
      }
      paramContext = ((h)paramac).gjb;
      paramac = bd.frc();
      p.g(paramac, "EmojiStorageMgr.getInstance()");
      if (paramac.bIW().aUK(paramContext.field_md5) == null)
      {
        paramac = bd.frc();
        p.g(paramac, "EmojiStorageMgr.getInstance()");
        paramac.bIW().J(paramContext);
      }
      paramac = this.gnn;
      if (paramac == null) {
        break label397;
      }
      paramac.B(paramContext);
      AppMethodBeat.o(105837);
      return;
    }
    paramac = ((h)paramac).gjb;
    localObject = new d.a(paramContext);
    ((d.a)localObject).aXF("");
    ((d.a)localObject).aXG(paramContext.getString(2131763721));
    ((d.a)localObject).yR(true);
    ((d.a)localObject).afl(2131758210).c((DialogInterface.OnClickListener)new b.b(paramac, paramContext));
    ((d.a)localObject).afm(2131755691);
    paramContext = ((d.a)localObject).fMb();
    p.g(paramContext, "alert");
    paramac = paramContext.getWindow();
    if (paramac != null)
    {
      paramac.setSoftInputMode(48);
      paramac.setFlags(131072, 131072);
    }
    paramContext.show();
    AppMethodBeat.o(105837);
    return;
    label397:
    AppMethodBeat.o(105837);
    return;
    label403:
    if (((paramac instanceof ah)) && (((ah)paramac).gkP == 101))
    {
      if (this.Iio == null)
      {
        ad.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
        AppMethodBeat.o(105837);
        return;
      }
      paramac = com.tencent.mm.search.c.b.Iiu;
      com.tencent.mm.search.c.b.fmI();
      paramac = new Intent();
      paramac.putExtra("KEY_NET_PARAM", (Parcelable)this.Iio);
      com.tencent.mm.bs.d.b(((t)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramac, 229);
    }
    AppMethodBeat.o(105837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.b.b
 * JD-Core Version:    0.7.0.1
 */