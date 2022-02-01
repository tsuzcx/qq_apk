package com.tencent.mm.ui.n.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.magicemoji.c.b.b.d;
import com.tencent.mm.plugin.emoji.magicemoji.c.b.b.f;
import com.tencent.mm.plugin.emoji.magicemoji.view.MEHolderView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.n.b.d;
import com.tencent.mm.ui.n.b.e;
import com.tencent.mm.ui.n.b.f;
import com.tencent.mm.ui.n.b.g;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiJsApiHandler;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "holder", "Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView;", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView;)V", "getChattingContext", "()Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "currentSessionTimeout", "", "eggMeta", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggMeta;", "emojiEggStatusListener", "Lcom/tencent/mm/ui/magicemoji/core/IEmojiEggStatusListener;", "getHolder", "()Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView;", "jsApiMap", "", "", "Lcom/tencent/mm/ui/magicemoji/jsapi/IMEChattingJsApi;", "mHandler", "Landroid/os/Handler;", "pendingEggItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr$MagicEggSendItem;", "Lkotlin/collections/ArrayList;", "resetBoundingBoxTask", "Ljava/lang/Runnable;", "sessionClickableEggSend", "", "stopSessionTask", "forceMagicEggStop", "", "meta", "stopReason", "markMagicEgg", "clickable", "ext", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData;", "onBoundingBoxClick", "onBoundingBoxSet", "eggId", "", "rectF", "Landroid/graphics/RectF;", "onChattingViewUpdate", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "onJsApi", "type", "data", "Lorg/json/JSONObject;", "onMagicEggStatusChange", "status", "timeout", "playEmojiEffect", "msgId", "emojiId", "emojiKey", "prepare", "sendMagicEgg", "setEmojiEggStatusListener", "listener", "start", "stop", "stopSession", "Companion", "MagicEggSendItem", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.emoji.magicemoji.a.c
{
  public static final b.a afwF;
  public final com.tencent.mm.ui.chatting.d.a adCQ;
  public final MEHolderView afwG;
  public final Map<Integer, com.tencent.mm.ui.n.b.a> afwH;
  public a afwI;
  public com.tencent.mm.plugin.emoji.magicemoji.bean.b afwJ;
  public final ArrayList<b.b> afwK;
  public final Runnable afwL;
  public final Runnable afwM;
  public long afwN;
  private boolean akml;
  public final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(249888);
    afwF = new b.a((byte)0);
    AppMethodBeat.o(249888);
  }
  
  public b(com.tencent.mm.ui.chatting.d.a parama, MEHolderView paramMEHolderView)
  {
    AppMethodBeat.i(249871);
    this.adCQ = parama;
    this.afwG = paramMEHolderView;
    this.afwG.setClickHandler((kotlin.g.a.a)new q() {});
    this.afwH = ak.e(new r[] { v.Y(Integer.valueOf(1), new e()), v.Y(Integer.valueOf(2), new d()), v.Y(Integer.valueOf(4), new com.tencent.mm.ui.n.b.c()), v.Y(Integer.valueOf(6), new g()), v.Y(Integer.valueOf(5), new f()), v.Y(Integer.valueOf(3), new com.tencent.mm.ui.n.b.h()) });
    this.mHandler = new Handler(Looper.getMainLooper());
    parama = com.tencent.mm.plugin.emoji.magicemoji.bean.b.xHZ;
    this.afwJ = com.tencent.mm.plugin.emoji.magicemoji.bean.b.dyI();
    this.afwK = new ArrayList();
    this.afwL = new b..ExternalSyntheticLambda1(this);
    this.afwM = new b..ExternalSyntheticLambda0(this);
    this.afwN = 20000L;
    AppMethodBeat.o(249871);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(249880);
    s.u(paramb, "this$0");
    paramb.afwG.ekW = MEHolderView.xKz;
    paramb.a(paramb.afwJ, 1);
    AppMethodBeat.o(249880);
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(249884);
    s.u(paramb, "this$0");
    paramb.jBG();
    AppMethodBeat.o(249884);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.magicemoji.bean.b paramb, int paramInt)
  {
    AppMethodBeat.i(249906);
    s.u(paramb, "meta");
    if (!jBG())
    {
      AppMethodBeat.o(249906);
      return;
    }
    ((com.tencent.mm.plugin.emoji.magicemoji.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).be(4097, new com.tencent.mm.plugin.emoji.magicemoji.c.b.b((com.tencent.mm.plugin.emoji.magicemoji.c.b.b.b)new b.d(paramb.xIa, paramb.xIb, paramb.xIc, paramInt)).dyV());
    AppMethodBeat.o(249906);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.magicemoji.bean.b paramb, boolean paramBoolean, com.tencent.mm.plugin.emoji.magicemoji.bean.a parama)
  {
    AppMethodBeat.i(249905);
    s.u(paramb, "meta");
    s.u(parama, "ext");
    com.tencent.mm.plugin.emoji.magicemoji.bean.b localb = this.afwJ;
    com.tencent.mm.plugin.emoji.magicemoji.bean.b.a locala = com.tencent.mm.plugin.emoji.magicemoji.bean.b.xHZ;
    if ((!s.p(localb, com.tencent.mm.plugin.emoji.magicemoji.bean.b.dyI())) && (!s.p(this.afwJ, paramb)))
    {
      Log.w("MicroMsg.MEChattingMgr", "[MEChattingMgr]: markMagicEgg trying to override eggMeta");
      a(this.afwJ, 2);
    }
    if (!s.p(this.afwJ, paramb))
    {
      prepare();
      this.afwJ = paramb;
    }
    Log.i("MicroMsg.MEChattingMgr", "[MEChattingMgr]: markMagicEgg: " + paramb + ' ' + paramBoolean + ' ' + parama);
    if ((paramBoolean) && (this.afwK.isEmpty()))
    {
      b(this.afwJ, true, parama);
      AppMethodBeat.o(249905);
      return;
    }
    this.afwK.add(new b.b(System.currentTimeMillis(), paramBoolean, parama));
    AppMethodBeat.o(249905);
  }
  
  public final String b(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(249896);
    s.u(paramJSONObject, "data");
    com.tencent.mm.ui.n.b.a locala = (com.tencent.mm.ui.n.b.a)this.afwH.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(249896);
      return null;
    }
    paramJSONObject = locala.a(this, paramJSONObject);
    AppMethodBeat.o(249896);
    return paramJSONObject;
  }
  
  public final void b(com.tencent.mm.plugin.emoji.magicemoji.bean.b paramb, boolean paramBoolean, com.tencent.mm.plugin.emoji.magicemoji.bean.a parama)
  {
    AppMethodBeat.i(249876);
    Log.i("MicroMsg.MEChattingMgr", "[MEChattingMgr]: sendMagicEgg: " + paramb + ", " + paramBoolean + ", " + parama);
    if ((paramBoolean) && (this.akml))
    {
      Log.w("MicroMsg.MEChattingMgr", "[MEChattingMgr]: only one clickable in a session");
      AppMethodBeat.o(249876);
      return;
    }
    if (paramBoolean) {
      this.akml = true;
    }
    ((com.tencent.mm.plugin.emoji.magicemoji.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).be(4097, new com.tencent.mm.plugin.emoji.magicemoji.c.b.b((com.tencent.mm.plugin.emoji.magicemoji.c.b.b.b)new b.f(paramb.xIa, paramb.xIb, paramb.xIc, paramBoolean, parama.hAB, parama.xHX)).dyV());
    AppMethodBeat.o(249876);
  }
  
  public final boolean jBG()
  {
    AppMethodBeat.i(249904);
    Object localObject = this.afwJ;
    com.tencent.mm.plugin.emoji.magicemoji.bean.b.a locala = com.tencent.mm.plugin.emoji.magicemoji.bean.b.xHZ;
    if (s.p(localObject, com.tencent.mm.plugin.emoji.magicemoji.bean.b.dyI()))
    {
      AppMethodBeat.o(249904);
      return false;
    }
    this.afwG.ekW = MEHolderView.xKz;
    this.mHandler.removeCallbacks(this.afwL);
    this.mHandler.removeCallbacks(this.afwM);
    this.afwK.clear();
    localObject = this.afwI;
    if (localObject != null) {
      ((a)localObject).c(this.afwJ);
    }
    localObject = com.tencent.mm.plugin.emoji.magicemoji.bean.b.xHZ;
    this.afwJ = com.tencent.mm.plugin.emoji.magicemoji.bean.b.dyI();
    this.akml = false;
    AppMethodBeat.o(249904);
    return true;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(249900);
    this.afwG.start();
    ((com.tencent.mm.plugin.emoji.magicemoji.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).dyD();
    AppMethodBeat.o(249900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b
 * JD-Core Version:    0.7.0.1
 */