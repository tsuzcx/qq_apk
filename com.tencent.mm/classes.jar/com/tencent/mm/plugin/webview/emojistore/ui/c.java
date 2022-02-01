package com.tencent.mm.plugin.webview.emojistore.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "continueFlag", "", "emojiDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lkotlin/collections/ArrayList;", "getEmojiDataList", "()Ljava/util/ArrayList;", "setEmojiDataList", "(Ljava/util/ArrayList;)V", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "searchID", "", "getSearchID", "()Ljava/lang/String;", "setSearchID", "(Ljava/lang/String;)V", "totalCount", "enableLoadMore", "", "getHeadData", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getSimilarEmojiList", "", "onCrate", "intent", "Landroid/content/Intent;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-webview_release"})
public final class c
  implements com.tencent.mm.al.g
{
  public static final a ANZ;
  SimilarEmojiQueryModel ANX;
  ArrayList<h> ANY;
  com.tencent.mm.al.g callback;
  private int fwP;
  String oEK;
  int offset;
  boolean qpI;
  
  static
  {
    AppMethodBeat.i(82496);
    ANZ = new a((byte)0);
    AppMethodBeat.o(82496);
  }
  
  public c()
  {
    AppMethodBeat.i(82495);
    this.oEK = ("Similar" + System.currentTimeMillis());
    this.qpI = true;
    this.ANY = new ArrayList();
    AppMethodBeat.o(82495);
  }
  
  public final void d(com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(82493);
    k.h(paramg, "callback");
    ad.i("MicroMsg.SimilarEmoji", "do net request:[" + this.ANX + ']');
    this.callback = paramg;
    if (!this.qpI)
    {
      AppMethodBeat.o(82493);
      return;
    }
    paramg = this.ANX;
    if (paramg != null)
    {
      EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramg.emojiMD5);
      paramg = new com.tencent.mm.plugin.webview.fts.c(paramg.emojiMD5, this.offset, this.oEK, this.oEK, 0, this.oEK, 59, localEmojiInfo.field_cdnUrl, localEmojiInfo.field_aeskey);
      com.tencent.mm.kernel.g.aeS().b((n)paramg);
      AppMethodBeat.o(82493);
      return;
    }
    AppMethodBeat.o(82493);
  }
  
  public final EmojiInfo ejP()
  {
    AppMethodBeat.i(82492);
    Object localObject1 = this.ANX;
    if (localObject1 != null)
    {
      Object localObject2 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(localObject2, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getEmojiMgr().Tz(((SimilarEmojiQueryModel)localObject1).emojiMD5);
      ((EmojiInfo)localObject1).field_catalog = EmojiInfo.LBQ;
      if (this.ANY.isEmpty())
      {
        localObject2 = this.ANY;
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
      localObject1 = bt.by(((com.tencent.mm.plugin.webview.fts.c)paramn).ejT().DLy, "");
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.offset = ((JSONObject)localObject1).optInt("offset", 0);
      this.fwP = ((JSONObject)localObject1).optInt("totalCount", 0);
      this.qpI = ((JSONObject)localObject1).optBoolean("continueFlag", false);
      localObject2 = ((JSONObject)localObject1).optString("searchID");
      k.g(localObject2, "responseJson.optString(\"searchID\")");
      this.oEK = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optJSONArray("items");
      if (((Collection)this.ANY).isEmpty()) {
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
    if ((i != 0) && (((h)j.iA((List)this.ANY)).fNE == 104)) {
      this.ANY.remove(j.iA((List)this.ANY));
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONArray();
    }
    ad.i("MicroMsg.SimilarEmoji", "get more emoji size:" + ((JSONArray)localObject1).length());
    j = ((JSONArray)localObject1).length();
    i = 0;
    while (i < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
      EmojiInfo localEmojiInfo = new EmojiInfo();
      b.a((JSONObject)localObject2, localEmojiInfo);
      this.ANY.add(new h(localEmojiInfo, 103));
      i += 1;
    }
    if (this.qpI) {
      this.ANY.add(new h(new EmojiInfo(), 104));
    }
    localObject1 = this.callback;
    if (localObject1 != null)
    {
      ((com.tencent.mm.al.g)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(82494);
      return;
    }
    AppMethodBeat.o(82494);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.c
 * JD-Core Version:    0.7.0.1
 */