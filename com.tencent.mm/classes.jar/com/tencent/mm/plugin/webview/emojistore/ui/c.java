package com.tencent.mm.plugin.webview.emojistore.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "continueFlag", "", "emojiDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lkotlin/collections/ArrayList;", "getEmojiDataList", "()Ljava/util/ArrayList;", "setEmojiDataList", "(Ljava/util/ArrayList;)V", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "searchID", "", "getSearchID", "()Ljava/lang/String;", "setSearchID", "(Ljava/lang/String;)V", "totalCount", "enableLoadMore", "", "getHeadData", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getSimilarEmojiList", "", "onCrate", "intent", "Landroid/content/Intent;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-webview_release"})
public final class c
  implements com.tencent.mm.ak.g
{
  public static final c.a Cgr;
  SimilarEmojiQueryModel Cgp;
  ArrayList<h> Cgq;
  com.tencent.mm.ak.g callback;
  private int fAw;
  int offset;
  String pik;
  boolean qYO;
  
  static
  {
    AppMethodBeat.i(82496);
    Cgr = new c.a((byte)0);
    AppMethodBeat.o(82496);
  }
  
  public c()
  {
    AppMethodBeat.i(82495);
    this.pik = ("Similar" + System.currentTimeMillis());
    this.qYO = true;
    this.Cgq = new ArrayList();
    AppMethodBeat.o(82495);
  }
  
  public final void d(com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(82493);
    k.h(paramg, "callback");
    ac.i("MicroMsg.SimilarEmoji", "do net request:[" + this.Cgp + ']');
    this.callback = paramg;
    if (!this.qYO)
    {
      AppMethodBeat.o(82493);
      return;
    }
    paramg = this.Cgp;
    if (paramg != null)
    {
      EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramg.emojiMD5);
      paramg = new com.tencent.mm.plugin.webview.fts.c(paramg.emojiMD5, this.offset, this.pik, this.pik, 0, this.pik, 59, localEmojiInfo.field_cdnUrl, localEmojiInfo.field_aeskey);
      com.tencent.mm.kernel.g.agi().b((n)paramg);
      AppMethodBeat.o(82493);
      return;
    }
    AppMethodBeat.o(82493);
  }
  
  public final EmojiInfo ezk()
  {
    AppMethodBeat.i(82492);
    Object localObject1 = this.Cgp;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(localObject2, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getEmojiMgr().XL(((SimilarEmojiQueryModel)localObject1).emojiMD5);
      ((EmojiInfo)localObject1).field_catalog = EmojiInfo.Jss;
      if (this.Cgq.isEmpty())
      {
        localObject2 = this.Cgq;
        k.g(localObject1, "emojiInfo");
        ((ArrayList)localObject2).add(new h((EmojiInfo)localObject1, 100));
      }
      AppMethodBeat.o(82492);
      return localObject1;
    }
    AppMethodBeat.o(82492);
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(82494);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.fts.NetSceneQuerySimilarEmotion");
        AppMethodBeat.o(82494);
        throw paramString;
      }
      localObject1 = bs.bG(((com.tencent.mm.plugin.webview.fts.c)paramn).ezo().FhN, "");
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.offset = ((JSONObject)localObject1).optInt("offset", 0);
      this.fAw = ((JSONObject)localObject1).optInt("totalCount", 0);
      this.qYO = ((JSONObject)localObject1).optBoolean("continueFlag", false);
      localObject2 = ((JSONObject)localObject1).optString("searchID");
      k.g(localObject2, "responseJson.optString(\"searchID\")");
      this.pik = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optJSONArray("items");
      if (((Collection)this.Cgq).isEmpty()) {
        break label384;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        int j;
        continue;
        int i = 0;
      }
    }
    if ((i != 0) && (((h)j.iQ((List)this.Cgq)).fRp == 104)) {
      this.Cgq.remove(j.iQ((List)this.Cgq));
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONArray();
    }
    ac.i("MicroMsg.SimilarEmoji", "get more emoji size:" + ((JSONArray)localObject1).length());
    j = ((JSONArray)localObject1).length();
    i = 0;
    while (i < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
      EmojiInfo localEmojiInfo = new EmojiInfo();
      b.a((JSONObject)localObject2, localEmojiInfo);
      this.Cgq.add(new h(localEmojiInfo, 103));
      i += 1;
    }
    if (this.qYO) {
      this.Cgq.add(new h(new EmojiInfo(), 104));
    }
    localObject1 = this.callback;
    if (localObject1 != null)
    {
      ((com.tencent.mm.ak.g)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(82494);
      return;
    }
    AppMethodBeat.o(82494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.c
 * JD-Core Version:    0.7.0.1
 */