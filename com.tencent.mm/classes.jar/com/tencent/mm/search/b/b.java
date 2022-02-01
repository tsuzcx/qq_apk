package com.tencent.mm.search.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.aj;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.search.c.a;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.z;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/logic/SimilarEmojiPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "(I)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "handlePayEmoji", "", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final b.a acsg;
  public SimilarEmojiQueryModel moX;
  
  static
  {
    AppMethodBeat.i(105838);
    acsg = new b.a((byte)0);
    AppMethodBeat.o(105838);
  }
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  private static final void b(EmojiInfo paramEmojiInfo, Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(236851);
    s.u(paramEmojiInfo, "$emoji");
    s.u(paramContext, "$context");
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_id", paramEmojiInfo.field_groupId);
    localIntent.putExtra("preceding_scence", 20);
    c.b(((z)paramContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
    paramDialogInterface.cancel();
    AppMethodBeat.o(236851);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt, ae paramae)
  {
    AppMethodBeat.i(236857);
    s.u(paramContext, "context");
    if (paramae == null)
    {
      AppMethodBeat.o(236857);
      return;
    }
    if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(paramContext))
    {
      AppMethodBeat.o(236857);
      return;
    }
    if ((paramae instanceof com.tencent.mm.emoji.c.b.h)) {}
    for (paramView = ((com.tencent.mm.emoji.c.b.h)paramae).mgK.field_md5;; paramView = "")
    {
      Log.i("MicroMsg.SimilarEmoji", "onClick: " + paramInt + ", md5 :" + paramView);
      if ((!(paramae instanceof com.tencent.mm.emoji.c.b.h)) || (((com.tencent.mm.emoji.c.b.h)paramae).miu != 102)) {
        break label386;
      }
      paramView = a.acsi;
      a.iTz();
      paramView = com.tencent.mm.search.c.b.acsj;
      com.tencent.mm.search.c.b.b(((com.tencent.mm.emoji.c.b.h)paramae).mgK, paramInt);
      if (((com.tencent.mm.emoji.c.b.h)paramae).mgK.pay == 1)
      {
        if ((Util.isNullOrNil(((com.tencent.mm.emoji.c.b.h)paramae).mgK.field_groupId)) || (!((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoj(((com.tencent.mm.emoji.c.b.h)paramae).mgK.field_groupId))) {
          break;
        }
        Log.i("MicroMsg.SimilarEmoji", "buy and resend emoji");
      }
      paramView = ((com.tencent.mm.emoji.c.b.h)paramae).mgK;
      if (bl.jba().adju.bza(paramView.field_md5) == null) {
        bl.jba().adju.L(paramView);
      }
      paramContext = this.mkP;
      if (paramContext == null) {
        break label478;
      }
      paramContext.o(paramView);
      AppMethodBeat.o(236857);
      return;
    }
    paramView = ((com.tencent.mm.emoji.c.b.h)paramae).mgK;
    paramae = new e.a(paramContext);
    paramae.bDv("");
    paramae.bDw(paramContext.getString(a.j.similar_emoji_pay_dialog_title));
    paramae.NC(true);
    paramae.aER(a.j.emoji_add_fialed_non_purchase_goto).c(new b..ExternalSyntheticLambda0(paramView, paramContext));
    paramae.aES(a.j.app_cancel);
    paramView = paramae.jHH();
    paramContext = paramView.getWindow();
    if (paramContext != null)
    {
      paramContext.setSoftInputMode(48);
      paramContext.setFlags(131072, 131072);
    }
    paramView.show();
    AppMethodBeat.o(236857);
    return;
    label386:
    if (((paramae instanceof aj)) && (((aj)paramae).miu == 101))
    {
      if (this.moX == null)
      {
        Log.i("MicroMsg.SimilarEmoji", "can not jump for null data!");
        AppMethodBeat.o(236857);
        return;
      }
      paramView = com.tencent.mm.search.c.b.acsj;
      com.tencent.mm.search.c.b.iTD();
      paramView = new Intent();
      paramView.putExtra("KEY_NET_PARAM", (Parcelable)this.moX);
      c.b(((z)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramView, 229);
    }
    label478:
    AppMethodBeat.o(236857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.b.b
 * JD-Core Version:    0.7.0.1
 */