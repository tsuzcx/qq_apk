package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.ah;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.search.c.a;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final b.a ICA;
  public SimilarEmojiQueryModel ICz;
  
  static
  {
    AppMethodBeat.i(105838);
    ICA = new b.a((byte)0);
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
    for (Object localObject = ((h)paramac).glt.field_md5;; localObject = "")
    {
      ae.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", md5 :" + (String)localObject);
      if ((!(paramac instanceof h)) || (((h)paramac).gnk != 102)) {
        break label403;
      }
      localObject = a.ICC;
      a.fqz();
      localObject = com.tencent.mm.search.c.b.ICF;
      com.tencent.mm.search.c.b.b(((h)paramac).glt, paramInt);
      if (((h)paramac).glt.OAr == 1)
      {
        if (bu.isNullOrNil(((h)paramac).glt.afK())) {
          break;
        }
        localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        if (!((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().acn(((h)paramac).glt.afK())) {
          break;
        }
        ae.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
      }
      paramContext = ((h)paramac).glt;
      paramac = be.fvc();
      p.g(paramac, "EmojiStorageMgr.getInstance()");
      if (paramac.bJU().aWl(paramContext.field_md5) == null)
      {
        paramac = be.fvc();
        p.g(paramac, "EmojiStorageMgr.getInstance()");
        paramac.bJU().J(paramContext);
      }
      paramac = this.gpJ;
      if (paramac == null) {
        break label397;
      }
      paramac.A(paramContext);
      AppMethodBeat.o(105837);
      return;
    }
    paramac = ((h)paramac).glt;
    localObject = new d.a(paramContext);
    ((d.a)localObject).aZh("");
    ((d.a)localObject).aZi(paramContext.getString(2131763721));
    ((d.a)localObject).zf(true);
    ((d.a)localObject).afU(2131758210).c((DialogInterface.OnClickListener)new b.b(paramac, paramContext));
    ((d.a)localObject).afV(2131755691);
    paramContext = ((d.a)localObject).fQv();
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
    if (((paramac instanceof ah)) && (((ah)paramac).gnk == 101))
    {
      if (this.ICz == null)
      {
        ae.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
        AppMethodBeat.o(105837);
        return;
      }
      paramac = com.tencent.mm.search.c.b.ICF;
      com.tencent.mm.search.c.b.fqD();
      paramac = new Intent();
      paramac.putExtra("KEY_NET_PARAM", (Parcelable)this.ICz);
      com.tencent.mm.br.d.b(((t)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramac, 229);
    }
    AppMethodBeat.o(105837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.b.b
 * JD-Core Version:    0.7.0.1
 */