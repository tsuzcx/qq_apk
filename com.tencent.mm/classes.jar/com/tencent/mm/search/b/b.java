package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ad;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.search.c.a;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final b.a Gwv;
  public SimilarEmojiQueryModel Gwu;
  
  static
  {
    AppMethodBeat.i(105838);
    Gwv = new b.a((byte)0);
    AppMethodBeat.o(105838);
  }
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(final Context paramContext, int paramInt, y paramy)
  {
    AppMethodBeat.i(105837);
    k.h(paramContext, "context");
    if (paramy == null)
    {
      AppMethodBeat.o(105837);
      return;
    }
    if ((paramy instanceof h)) {}
    for (Object localObject = ((h)paramy).fPB.field_md5;; localObject = "")
    {
      ac.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", md5 :" + (String)localObject);
      if ((!(paramy instanceof h)) || (((h)paramy).fRp != 102)) {
        break label403;
      }
      localObject = a.Gwx;
      a.eWU();
      localObject = com.tencent.mm.search.c.b.GwA;
      com.tencent.mm.search.c.b.b(((h)paramy).fPB, paramInt);
      if (((h)paramy).fPB.Kgo == 1)
      {
        if (bs.isNullOrNil(((h)paramy).fPB.azp())) {
          break;
        }
        localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        if (!((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().XQ(((h)paramy).fPB.azp())) {
          break;
        }
        ac.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
      }
      paramContext = ((h)paramy).fPB;
      paramy = az.faZ();
      k.g(paramy, "EmojiStorageMgr.getInstance()");
      if (paramy.bEN().aOT(paramContext.field_md5) == null)
      {
        paramy = az.faZ();
        k.g(paramy, "EmojiStorageMgr.getInstance()");
        paramy.bEN().K(paramContext);
      }
      paramy = this.fTJ;
      if (paramy == null) {
        break label397;
      }
      paramy.B(paramContext);
      AppMethodBeat.o(105837);
      return;
    }
    paramy = ((h)paramy).fPB;
    localObject = new d.a(paramContext);
    ((d.a)localObject).aRH("");
    ((d.a)localObject).aRI(paramContext.getString(2131763721));
    ((d.a)localObject).yf(true);
    ((d.a)localObject).acM(2131758210).b((DialogInterface.OnClickListener)new b(paramy, paramContext));
    ((d.a)localObject).acN(2131755691);
    paramContext = ((d.a)localObject).fvp();
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
    if (((paramy instanceof ad)) && (((ad)paramy).fRp == 101))
    {
      if (this.Gwu == null)
      {
        ac.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
        AppMethodBeat.o(105837);
        return;
      }
      paramy = com.tencent.mm.search.c.b.GwA;
      com.tencent.mm.search.c.b.eWY();
      paramy = new Intent();
      paramy.putExtra("KEY_NET_PARAM", (Parcelable)this.Gwu);
      com.tencent.mm.br.d.b(((t)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramy, 229);
    }
    AppMethodBeat.o(105837);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(EmojiInfo paramEmojiInfo, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(105836);
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_id", this.fTM.field_groupId);
      localIntent.putExtra("preceding_scence", 20);
      Context localContext = paramContext;
      if (localContext == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
        AppMethodBeat.o(105836);
        throw paramDialogInterface;
      }
      com.tencent.mm.br.d.b(((t)localContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      paramDialogInterface.cancel();
      AppMethodBeat.o(105836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.b.b
 * JD-Core Version:    0.7.0.1
 */