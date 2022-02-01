package com.tencent.mm.plugin.webview.emojistore.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "continueFlag", "", "emojiDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lkotlin/collections/ArrayList;", "getEmojiDataList", "()Ljava/util/ArrayList;", "setEmojiDataList", "(Ljava/util/ArrayList;)V", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "searchID", "", "getSearchID", "()Ljava/lang/String;", "setSearchID", "(Ljava/lang/String;)V", "totalCount", "enableLoadMore", "", "getHeadData", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getSimilarEmojiList", "", "onCrate", "intent", "Landroid/content/Intent;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-webview_release"})
public final class c
  implements f
{
  public static final c.a Ebs;
  SimilarEmojiQueryModel Ebq;
  ArrayList<h> Ebr;
  f callback;
  private int fVS;
  int offset;
  String pSq;
  boolean rRg;
  
  static
  {
    AppMethodBeat.i(82496);
    Ebs = new c.a((byte)0);
    AppMethodBeat.o(82496);
  }
  
  public c()
  {
    AppMethodBeat.i(82495);
    this.pSq = ("Similar" + System.currentTimeMillis());
    this.rRg = true;
    this.Ebr = new ArrayList();
    AppMethodBeat.o(82495);
  }
  
  public final EmojiInfo eRK()
  {
    AppMethodBeat.i(82492);
    Object localObject1 = this.Ebq;
    if (localObject1 != null)
    {
      Object localObject2 = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(localObject2, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
      localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject2).getEmojiMgr().aci(((SimilarEmojiQueryModel)localObject1).emojiMD5);
      ((EmojiInfo)localObject1).field_catalog = EmojiInfo.OzU;
      if (this.Ebr.isEmpty())
      {
        localObject2 = this.Ebr;
        p.g(localObject1, "emojiInfo");
        ((ArrayList)localObject2).add(new h((EmojiInfo)localObject1, 100));
      }
      AppMethodBeat.o(82492);
      return localObject1;
    }
    AppMethodBeat.o(82492);
    return null;
  }
  
  public final void f(f paramf)
  {
    AppMethodBeat.i(82493);
    p.h(paramf, "callback");
    ae.i("MicroMsg.SimilarEmoji", "do net request:[" + this.Ebq + ']');
    this.callback = paramf;
    if (!this.rRg)
    {
      AppMethodBeat.o(82493);
      return;
    }
    paramf = this.Ebq;
    if (paramf != null)
    {
      EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramf.emojiMD5);
      paramf = new com.tencent.mm.plugin.webview.fts.d(paramf.emojiMD5, this.offset, this.pSq, this.pSq, 0, this.pSq, 59, localEmojiInfo.field_cdnUrl, localEmojiInfo.field_aeskey);
      g.ajj().b((n)paramf);
      AppMethodBeat.o(82493);
      return;
    }
    AppMethodBeat.o(82493);
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
      localObject1 = bu.bI(((com.tencent.mm.plugin.webview.fts.d)paramn).eRO().GWB, "");
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.offset = ((JSONObject)localObject1).optInt("offset", 0);
      this.fVS = ((JSONObject)localObject1).optInt("totalCount", 0);
      this.rRg = ((JSONObject)localObject1).optBoolean("continueFlag", false);
      localObject2 = ((JSONObject)localObject1).optString("searchID");
      p.g(localObject2, "responseJson.optString(\"searchID\")");
      this.pSq = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optJSONArray("items");
      if (((Collection)this.Ebr).isEmpty()) {
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
    if ((i != 0) && (((h)j.jn((List)this.Ebr)).gnk == 104)) {
      this.Ebr.remove(j.jn((List)this.Ebr));
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONArray();
    }
    ae.i("MicroMsg.SimilarEmoji", "get more emoji size:" + ((JSONArray)localObject1).length());
    j = ((JSONArray)localObject1).length();
    i = 0;
    while (i < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
      EmojiInfo localEmojiInfo = new EmojiInfo();
      b.a((JSONObject)localObject2, localEmojiInfo);
      this.Ebr.add(new h(localEmojiInfo, 103));
      i += 1;
    }
    if (this.rRg) {
      this.Ebr.add(new h(new EmojiInfo(), 104));
    }
    localObject1 = this.callback;
    if (localObject1 != null)
    {
      ((f)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(82494);
      return;
    }
    AppMethodBeat.o(82494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.c
 * JD-Core Version:    0.7.0.1
 */