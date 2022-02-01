package com.tencent.mm.search.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.search.b.a;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final a EZh;
  public SimilarEmojiQueryModel EZg;
  
  static
  {
    AppMethodBeat.i(105838);
    EZh = new a((byte)0);
    AppMethodBeat.o(105838);
  }
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(Context paramContext, int paramInt, y paramy)
  {
    AppMethodBeat.i(105837);
    k.h(paramContext, "context");
    if (paramy == null)
    {
      AppMethodBeat.o(105837);
      return;
    }
    if ((paramy instanceof h)) {}
    for (Object localObject = ((h)paramy).fLP.field_md5;; localObject = "")
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", md5 :" + (String)localObject);
      if ((!(paramy instanceof h)) || (((h)paramy).fNE != 102)) {
        break label403;
      }
      localObject = a.EZj;
      a.eHz();
      localObject = com.tencent.mm.search.b.b.EZl;
      com.tencent.mm.search.b.b.b(((h)paramy).fLP, paramInt);
      if (((h)paramy).fLP.LCn == 1)
      {
        if (bt.isNullOrNil(((h)paramy).fLP.asy())) {
          break;
        }
        localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        if (!((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().TE(((h)paramy).fLP.asy())) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
      }
      paramContext = ((h)paramy).fLP;
      paramy = aw.eLx();
      k.g(paramy, "EmojiStorageMgr.getInstance()");
      if (paramy.bxR().aJx(paramContext.field_md5) == null)
      {
        paramy = aw.eLx();
        k.g(paramy, "EmojiStorageMgr.getInstance()");
        paramy.bxR().K(paramContext);
      }
      paramy = this.fPO;
      if (paramy == null) {
        break label397;
      }
      paramy.B(paramContext);
      AppMethodBeat.o(105837);
      return;
    }
    paramy = ((h)paramy).fLP;
    localObject = new d.a(paramContext);
    ((d.a)localObject).aMf("");
    ((d.a)localObject).aMg(paramContext.getString(2131763721));
    ((d.a)localObject).wX(true);
    ((d.a)localObject).aaB(2131758210).b((DialogInterface.OnClickListener)new b.b(paramy, paramContext));
    ((d.a)localObject).aaC(2131755691);
    paramContext = ((d.a)localObject).fft();
    k.g(paramContext, "alert");
    paramy = paramContext.getWindow();
    if (paramy != null)
    {
      paramy.setSoftInputMode(48);
      paramy.setFlags(131072, 131072);
    }
    paramContext.show();
    AppMethodBeat.o(105837);
    return;
    label397:
    AppMethodBeat.o(105837);
    return;
    label403:
    if (((paramy instanceof com.tencent.mm.emoji.a.a.ad)) && (((com.tencent.mm.emoji.a.a.ad)paramy).fNE == 101))
    {
      if (this.EZg == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
        AppMethodBeat.o(105837);
        return;
      }
      paramy = com.tencent.mm.search.b.b.EZl;
      com.tencent.mm.search.b.b.eHD();
      paramy = new Intent();
      paramy.putExtra("KEY_NET_PARAM", (Parcelable)this.EZg);
      com.tencent.mm.bs.d.b(((s)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramy, 229);
    }
    AppMethodBeat.o(105837);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.a.b
 * JD-Core Version:    0.7.0.1
 */