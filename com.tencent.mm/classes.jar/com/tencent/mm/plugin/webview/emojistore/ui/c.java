package com.tencent.mm.plugin.webview.emojistore.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.flo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "continueFlag", "", "emojiDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getEmojiDataList", "()Ljava/util/LinkedList;", "setEmojiDataList", "(Ljava/util/LinkedList;)V", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "pageNo", "getPageNo", "setPageNo", "searchID", "", "getSearchID", "()Ljava/lang/String;", "setSearchID", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "totalCount", "enableLoadMore", "", "getHeadData", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getSimilarEmojiList", "", "getTitle", "isSimilarSearch", "onCrate", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-webview_release"})
public final class c
  implements i
{
  public static final a PJW;
  LinkedList<com.tencent.mm.emoji.b.b.h> MGI;
  SimilarEmojiQueryModel PJV;
  i callback;
  int jJe;
  private int jlf;
  int offset;
  String sessionId;
  String uMC;
  boolean xcp;
  
  static
  {
    AppMethodBeat.i(82496);
    PJW = new a((byte)0);
    AppMethodBeat.o(82496);
  }
  
  public c()
  {
    AppMethodBeat.i(82495);
    this.sessionId = "";
    this.uMC = ("Similar" + System.currentTimeMillis());
    this.xcp = true;
    this.MGI = new LinkedList();
    AppMethodBeat.o(82495);
  }
  
  public final void e(i parami)
  {
    AppMethodBeat.i(82493);
    p.k(parami, "callback");
    Log.i("MicroMsg.SimilarEmoji", "do net request:[" + this.PJV + ']');
    this.callback = parami;
    if (!this.xcp)
    {
      AppMethodBeat.o(82493);
      return;
    }
    parami = this.PJV;
    if (parami != null)
    {
      Object localObject;
      if (gTo())
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(parami.emojiMD5);
        parami = new com.tencent.mm.plugin.webview.fts.d(parami.emojiMD5, this.offset, this.uMC, this.uMC, 0, this.uMC, 59, ((EmojiInfo)localObject).field_cdnUrl, ((EmojiInfo)localObject).field_aeskey);
        com.tencent.mm.kernel.h.aGY().b((q)parami);
        AppMethodBeat.o(82493);
        return;
      }
      v localv = new v();
      localv.scene = 78;
      parami = this.PJV;
      if (parami != null)
      {
        localObject = parami.query;
        parami = (i)localObject;
        if (localObject != null) {}
      }
      else
      {
        parami = "";
      }
      localv.fwe = parami;
      localv.businessType = 256;
      localv.fPw = 1;
      localv.offset = this.offset;
      localv.sessionId = this.sessionId;
      localv.uMC = this.uMC;
      localv.fIY = this.uMC;
      parami = new r(localv);
      com.tencent.mm.kernel.h.aGY().b((q)parami);
      AppMethodBeat.o(82493);
      return;
    }
    AppMethodBeat.o(82493);
  }
  
  public final EmojiInfo gTn()
  {
    AppMethodBeat.i(82492);
    Object localObject = this.PJV;
    if (localObject != null)
    {
      if (gTo())
      {
        a locala = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        p.j(locala, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
        localObject = ((com.tencent.mm.plugin.emoji.b.d)locala).getEmojiMgr().aud(((SimilarEmojiQueryModel)localObject).emojiMD5);
        if (localObject == null)
        {
          AppMethodBeat.o(82492);
          return null;
        }
        ((EmojiInfo)localObject).field_catalog = EmojiInfo.YCx;
        if (this.MGI.isEmpty()) {
          this.MGI.add(new com.tencent.mm.emoji.b.b.h((EmojiInfo)localObject, 100));
        }
        AppMethodBeat.o(82492);
        return localObject;
      }
      localObject = new EmojiInfo();
      if (this.MGI.isEmpty()) {
        this.MGI.add(new com.tencent.mm.emoji.b.b.h((EmojiInfo)localObject, 107));
      }
      AppMethodBeat.o(82492);
      return localObject;
    }
    AppMethodBeat.o(82492);
    return null;
  }
  
  public final boolean gTo()
  {
    AppMethodBeat.i(220399);
    SimilarEmojiQueryModel localSimilarEmojiQueryModel = this.PJV;
    if (localSimilarEmojiQueryModel != null)
    {
      boolean bool = localSimilarEmojiQueryModel.gTo();
      AppMethodBeat.o(220399);
      return bool;
    }
    AppMethodBeat.o(220399);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(82494);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramq instanceof com.tencent.mm.plugin.webview.fts.d)) {
        break label363;
      }
      localObject1 = Util.nullAs(((com.tencent.mm.plugin.webview.fts.d)paramq).gTs().Tkw, "");
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.offset = ((JSONObject)localObject1).optInt("offset", 0);
      this.jlf = ((JSONObject)localObject1).optInt("totalCount", 0);
      this.xcp = ((JSONObject)localObject1).optBoolean("continueFlag", false);
      localObject2 = ((JSONObject)localObject1).optString("searchID");
      p.j(localObject2, "responseJson.optString(\"searchID\")");
      this.uMC = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optJSONArray("items");
      if (((Collection)this.MGI).isEmpty()) {
        break label768;
      }
      i = 1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        int j;
        Object localObject3;
        continue;
        int i = 0;
        continue;
        i += 1;
        continue;
        boolean bool = false;
        continue;
        i = 0;
      }
    }
    if ((i != 0) && (((com.tencent.mm.emoji.b.b.h)j.lq((List)this.MGI)).jJc == 104)) {
      this.MGI.remove(j.lq((List)this.MGI));
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONArray();
    }
    Log.i("MicroMsg.SimilarEmoji", "similar get more emoji size:" + ((JSONArray)localObject1).length());
    i = 0;
    j = ((JSONArray)localObject1).length();
    while (i < j)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
      localObject3 = new EmojiInfo();
      b.a("MicroMsg.SimilarEmoji", (JSONObject)localObject2, (EmojiInfo)localObject3);
      this.MGI.add(new com.tencent.mm.emoji.b.b.h((EmojiInfo)localObject3, 103));
      i += 1;
    }
    if (this.xcp) {
      this.MGI.add(new com.tencent.mm.emoji.b.b.h(new EmojiInfo(), 104));
    }
    for (;;)
    {
      localObject1 = this.callback;
      if (localObject1 == null) {
        break;
      }
      ((i)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(82494);
      return;
      label363:
      if ((paramq instanceof r))
      {
        this.jJe += 1;
        localObject1 = ((r)paramq).gQx();
        try
        {
          localObject1 = new JSONObject(((flo)localObject1).Tkw);
          this.offset = ((JSONObject)localObject1).optInt("offset", 0);
          if (((JSONObject)localObject1).optInt("continueFlag", 0) != 1) {
            break label783;
          }
          bool = true;
          this.xcp = bool;
          localObject2 = ((JSONObject)localObject1).optString("searchID", "");
          p.j(localObject2, "responseJson.optString(\"searchID\", \"\")");
          this.uMC = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optJSONArray("data").optJSONObject(0);
          this.jlf = ((JSONObject)localObject1).optInt("totalCount", 0);
          localObject2 = ((JSONObject)localObject1).optJSONArray("items");
          if (((Collection)this.MGI).isEmpty()) {
            break label789;
          }
          i = 1;
          if ((i != 0) && (((com.tencent.mm.emoji.b.b.h)j.lq((List)this.MGI)).jJc == 104)) {
            this.MGI.removeLast();
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new JSONArray();
          }
          Log.i("MicroMsg.SimilarEmoji", "websearch get more emoji size:" + ((JSONArray)localObject1).length());
          i = 0;
          j = ((JSONArray)localObject1).length();
          if (i < j)
          {
            Object localObject4 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject4 == null) {
              break label774;
            }
            localObject2 = new EmojiInfo();
            b.a("MicroMsg.SimilarEmoji", (JSONObject)localObject4, (EmojiInfo)localObject2);
            localObject3 = this.MGI;
            localObject4 = ((JSONObject)localObject4).optString("docID", "");
            p.j(localObject4, "it.optString(\"docID\", \"\")");
            ((LinkedList)localObject3).add(new com.tencent.mm.emoji.b.b.h((EmojiInfo)localObject2, 103, (String)localObject4, this.jJe));
            break label774;
          }
          if (this.xcp) {
            this.MGI.add(new com.tencent.mm.emoji.b.b.h(new EmojiInfo(), 104));
          }
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.SimilarEmoji", (Throwable)localException1, "resultObj", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(82494);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.c
 * JD-Core Version:    0.7.0.1
 */