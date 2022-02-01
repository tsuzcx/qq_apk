package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.search.c.a;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"})
public final class b
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final b.a NJt;
  public SimilarEmojiQueryModel hek;
  
  static
  {
    AppMethodBeat.i(105838);
    NJt = new b.a((byte)0);
    AppMethodBeat.o(105838);
  }
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void a(View paramView, final Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(200086);
    p.h(paramContext, "context");
    if (paramac == null)
    {
      AppMethodBeat.o(200086);
      return;
    }
    if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(paramContext))
    {
      AppMethodBeat.o(200086);
      return;
    }
    if ((paramac instanceof h)) {}
    for (paramView = ((h)paramac).gWm.field_md5;; paramView = "")
    {
      Log.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", md5 :" + paramView);
      if ((!(paramac instanceof h)) || (((h)paramac).gYc != 102)) {
        break label423;
      }
      paramView = a.NJv;
      a.gxu();
      paramView = com.tencent.mm.search.c.b.NJx;
      com.tencent.mm.search.c.b.b(((h)paramac).gWm, paramInt);
      if (((h)paramac).gWm.UuM == 1)
      {
        if (Util.isNullOrNil(((h)paramac).gWm.avy())) {
          break;
        }
        paramView = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
        if (!((com.tencent.mm.plugin.emoji.b.d)paramView).getEmojiMgr().amq(((h)paramac).gWm.avy())) {
          break;
        }
        Log.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
      }
      paramView = ((h)paramac).gWm;
      paramContext = bj.gCJ();
      p.g(paramContext, "EmojiStorageMgr.getInstance()");
      if (paramContext.cgN().blk(paramView.field_md5) == null)
      {
        paramContext = bj.gCJ();
        p.g(paramContext, "EmojiStorageMgr.getInstance()");
        paramContext.cgN().K(paramView);
      }
      paramContext = this.haC;
      if (paramContext == null) {
        break label417;
      }
      paramContext.B(paramView);
      AppMethodBeat.o(200086);
      return;
    }
    paramView = ((h)paramac).gWm;
    paramac = new d.a(paramContext);
    paramac.bon("");
    paramac.boo(paramContext.getString(2131765912));
    paramac.Dk(true);
    paramac.aoV(2131758498).c((DialogInterface.OnClickListener)new b(paramView, paramContext));
    paramac.aoW(2131755761);
    paramView = paramac.hbn();
    p.g(paramView, "alert");
    paramContext = paramView.getWindow();
    if (paramContext != null)
    {
      paramContext.setSoftInputMode(48);
      paramContext.setFlags(131072, 131072);
    }
    paramView.show();
    AppMethodBeat.o(200086);
    return;
    label417:
    AppMethodBeat.o(200086);
    return;
    label423:
    if (((paramac instanceof ah)) && (((ah)paramac).gYc == 101))
    {
      if (this.hek == null)
      {
        Log.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
        AppMethodBeat.o(200086);
        return;
      }
      paramView = com.tencent.mm.search.c.b.NJx;
      com.tencent.mm.search.c.b.gxy();
      paramView = new Intent();
      paramView.putExtra("KEY_NET_PARAM", (Parcelable)this.hek);
      c.b(((u)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramView, 229);
    }
    AppMethodBeat.o(200086);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(EmojiInfo paramEmojiInfo, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(105836);
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_id", this.haF.field_groupId);
      localIntent.putExtra("preceding_scence", 20);
      Context localContext = paramContext;
      if (localContext == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
        AppMethodBeat.o(105836);
        throw paramDialogInterface;
      }
      c.b(((u)localContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      paramDialogInterface.cancel();
      AppMethodBeat.o(105836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.search.b.b
 * JD-Core Version:    0.7.0.1
 */