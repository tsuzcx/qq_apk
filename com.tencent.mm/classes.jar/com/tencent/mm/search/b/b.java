package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.aj;
import com.tencent.mm.emoji.panel.a.e;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.search.c.a;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.x;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class b
  extends e
{
  public static final a UWU;
  public SimilarEmojiQueryModel jQa;
  
  static
  {
    AppMethodBeat.i(105838);
    UWU = new a((byte)0);
    AppMethodBeat.o(105838);
  }
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(View paramView, final Context paramContext, int paramInt, ae paramae)
  {
    AppMethodBeat.i(229129);
    p.k(paramContext, "context");
    if (paramae == null)
    {
      AppMethodBeat.o(229129);
      return;
    }
    if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(paramContext))
    {
      AppMethodBeat.o(229129);
      return;
    }
    if ((paramae instanceof com.tencent.mm.emoji.b.b.h)) {}
    for (paramView = ((com.tencent.mm.emoji.b.b.h)paramae).jHh.field_md5;; paramView = "")
    {
      Log.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", md5 :" + paramView);
      if ((!(paramae instanceof com.tencent.mm.emoji.b.b.h)) || (((com.tencent.mm.emoji.b.b.h)paramae).jJc != 102)) {
        break label426;
      }
      paramView = a.UWW;
      a.hts();
      paramView = com.tencent.mm.search.c.b.UWY;
      com.tencent.mm.search.c.b.b(((com.tencent.mm.emoji.b.b.h)paramae).jHh, paramInt);
      if (((com.tencent.mm.emoji.b.b.h)paramae).jHh.ZuO == 1)
      {
        if (Util.isNullOrNil(((com.tencent.mm.emoji.b.b.h)paramae).jHh.aCt())) {
          break;
        }
        paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
        if (!((com.tencent.mm.plugin.emoji.b.d)paramView).getEmojiMgr().aui(((com.tencent.mm.emoji.b.b.h)paramae).jHh.aCt())) {
          break;
        }
        Log.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
      }
      paramView = ((com.tencent.mm.emoji.b.b.h)paramae).jHh;
      paramContext = bj.hyV();
      p.j(paramContext, "EmojiStorageMgr.getInstance()");
      if (paramContext.ctY().bxK(paramView.field_md5) == null)
      {
        paramContext = bj.hyV();
        p.j(paramContext, "EmojiStorageMgr.getInstance()");
        paramContext.ctY().L(paramView);
      }
      paramContext = this.jLH;
      if (paramContext == null) {
        break label420;
      }
      paramContext.o(paramView);
      AppMethodBeat.o(229129);
      return;
    }
    paramView = ((com.tencent.mm.emoji.b.b.h)paramae).jHh;
    paramae = new d.a(paramContext);
    paramae.bBc("");
    paramae.bBd(paramContext.getString(a.j.similar_emoji_pay_dialog_title));
    paramae.HG(true);
    paramae.ayj(a.j.emoji_add_fialed_non_purchase_goto).c((DialogInterface.OnClickListener)new b(paramView, paramContext));
    paramae.ayk(a.j.app_cancel);
    paramView = paramae.icu();
    p.j(paramView, "alert");
    paramContext = paramView.getWindow();
    if (paramContext != null)
    {
      paramContext.setSoftInputMode(48);
      paramContext.setFlags(131072, 131072);
    }
    paramView.show();
    AppMethodBeat.o(229129);
    return;
    label420:
    AppMethodBeat.o(229129);
    return;
    label426:
    if (((paramae instanceof aj)) && (((aj)paramae).jJc == 101))
    {
      if (this.jQa == null)
      {
        Log.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
        AppMethodBeat.o(229129);
        return;
      }
      paramView = com.tencent.mm.search.c.b.UWY;
      com.tencent.mm.search.c.b.htw();
      paramView = new Intent();
      paramView.putExtra("KEY_NET_PARAM", (Parcelable)this.jQa);
      c.b(((x)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramView, 229);
    }
    AppMethodBeat.o(229129);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(EmojiInfo paramEmojiInfo, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(105836);
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_id", this.jLK.field_groupId);
      localIntent.putExtra("preceding_scence", 20);
      Context localContext = paramContext;
      if (localContext == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
        AppMethodBeat.o(105836);
        throw paramDialogInterface;
      }
      c.b(((x)localContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      paramDialogInterface.cancel();
      AppMethodBeat.o(105836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.b.b
 * JD-Core Version:    0.7.0.1
 */