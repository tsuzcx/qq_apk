package com.tencent.mm.plugin.webview.emojistore.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.fav;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "continueFlag", "", "emojiDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getEmojiDataList", "()Ljava/util/LinkedList;", "setEmojiDataList", "(Ljava/util/LinkedList;)V", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "pageNo", "getPageNo", "setPageNo", "searchID", "", "getSearchID", "()Ljava/lang/String;", "setSearchID", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "totalCount", "enableLoadMore", "", "getHeadData", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getSimilarEmojiList", "", "getTitle", "isSimilarSearch", "onCrate", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-webview_release"})
public final class c
  implements i
{
  public static final c.a INE;
  SimilarEmojiQueryModel INC;
  LinkedList<h> IND;
  i callback;
  private int gAZ;
  int gYe;
  int offset;
  String rjq;
  String sessionId;
  boolean tuG;
  
  static
  {
    AppMethodBeat.i(82496);
    INE = new c.a((byte)0);
    AppMethodBeat.o(82496);
  }
  
  public c()
  {
    AppMethodBeat.i(82495);
    this.sessionId = "";
    this.rjq = ("Similar" + System.currentTimeMillis());
    this.tuG = true;
    this.IND = new LinkedList();
    AppMethodBeat.o(82495);
  }
  
  public final void f(i parami)
  {
    AppMethodBeat.i(82493);
    p.h(parami, "callback");
    Log.i("MicroMsg.SimilarEmoji", "do net request:[" + this.INC + ']');
    this.callback = parami;
    if (!this.tuG)
    {
      AppMethodBeat.o(82493);
      return;
    }
    parami = this.INC;
    if (parami != null)
    {
      Object localObject;
      if (gau())
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(parami.emojiMD5);
        parami = new com.tencent.mm.plugin.webview.fts.d(parami.emojiMD5, this.offset, this.rjq, this.rjq, 0, this.rjq, 59, ((EmojiInfo)localObject).field_cdnUrl, ((EmojiInfo)localObject).field_aeskey);
        g.azz().b((q)parami);
        AppMethodBeat.o(82493);
        return;
      }
      v localv = new v();
      localv.scene = 78;
      parami = this.INC;
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
      localv.dDv = parami;
      localv.businessType = 256;
      localv.dVS = 1;
      localv.offset = this.offset;
      localv.sessionId = this.sessionId;
      localv.rjq = this.rjq;
      localv.dPI = this.rjq;
      parami = new r(localv);
      g.azz().b((q)parami);
      AppMethodBeat.o(82493);
      return;
    }
    AppMethodBeat.o(82493);
  }
  
  public final EmojiInfo gat()
  {
    AppMethodBeat.i(82492);
    Object localObject = this.INC;
    if (localObject != null)
    {
      if (gau())
      {
        a locala = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(locala, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
        localObject = ((com.tencent.mm.plugin.emoji.b.d)locala).getEmojiMgr().aml(((SimilarEmojiQueryModel)localObject).emojiMD5);
        if (localObject == null)
        {
          AppMethodBeat.o(82492);
          return null;
        }
        ((EmojiInfo)localObject).field_catalog = EmojiInfo.Uup;
        if (this.IND.isEmpty()) {
          this.IND.add(new h((EmojiInfo)localObject, 100));
        }
        AppMethodBeat.o(82492);
        return localObject;
      }
      localObject = new EmojiInfo();
      if (this.IND.isEmpty()) {
        this.IND.add(new h((EmojiInfo)localObject, 107));
      }
      AppMethodBeat.o(82492);
      return localObject;
    }
    AppMethodBeat.o(82492);
    return null;
  }
  
  public final boolean gau()
  {
    AppMethodBeat.i(210290);
    SimilarEmojiQueryModel localSimilarEmojiQueryModel = this.INC;
    if (localSimilarEmojiQueryModel != null)
    {
      boolean bool = localSimilarEmojiQueryModel.gau();
      AppMethodBeat.o(210290);
      return bool;
    }
    AppMethodBeat.o(210290);
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
      localObject1 = Util.nullAs(((com.tencent.mm.plugin.webview.fts.d)paramq).gay().MaZ, "");
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.offset = ((JSONObject)localObject1).optInt("offset", 0);
      this.gAZ = ((JSONObject)localObject1).optInt("totalCount", 0);
      this.tuG = ((JSONObject)localObject1).optBoolean("continueFlag", false);
      localObject2 = ((JSONObject)localObject1).optString("searchID");
      p.g(localObject2, "responseJson.optString(\"searchID\")");
      this.rjq = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optJSONArray("items");
      if (((Collection)this.IND).isEmpty()) {
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
    if ((i != 0) && (((h)j.ku((List)this.IND)).gYc == 104)) {
      this.IND.remove(j.ku((List)this.IND));
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
      this.IND.add(new h((EmojiInfo)localObject3, 103));
      i += 1;
    }
    if (this.tuG) {
      this.IND.add(new h(new EmojiInfo(), 104));
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
        this.gYe += 1;
        localObject1 = ((r)paramq).fXM();
        try
        {
          localObject1 = new JSONObject(((fav)localObject1).MaZ);
          this.offset = ((JSONObject)localObject1).optInt("offset", 0);
          if (((JSONObject)localObject1).optInt("continueFlag", 0) != 1) {
            break label783;
          }
          bool = true;
          this.tuG = bool;
          localObject2 = ((JSONObject)localObject1).optString("searchID", "");
          p.g(localObject2, "responseJson.optString(\"searchID\", \"\")");
          this.rjq = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optJSONArray("data").optJSONObject(0);
          this.gAZ = ((JSONObject)localObject1).optInt("totalCount", 0);
          localObject2 = ((JSONObject)localObject1).optJSONArray("items");
          if (((Collection)this.IND).isEmpty()) {
            break label789;
          }
          i = 1;
          if ((i != 0) && (((h)j.ku((List)this.IND)).gYc == 104)) {
            this.IND.removeLast();
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
            localObject3 = this.IND;
            localObject4 = ((JSONObject)localObject4).optString("docID", "");
            p.g(localObject4, "it.optString(\"docID\", \"\")");
            ((LinkedList)localObject3).add(new h((EmojiInfo)localObject2, 103, (String)localObject4, this.gYe));
            break label774;
          }
          if (this.tuG) {
            this.IND.add(new h(new EmojiInfo(), 104));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.c
 * JD-Core Version:    0.7.0.1
 */