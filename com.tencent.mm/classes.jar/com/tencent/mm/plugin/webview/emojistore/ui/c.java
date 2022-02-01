package com.tencent.mm.plugin.webview.emojistore.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.fco;
import com.tencent.mm.protocal.protobuf.gid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "continueFlag", "", "emojiDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getEmojiDataList", "()Ljava/util/LinkedList;", "setEmojiDataList", "(Ljava/util/LinkedList;)V", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "pageNo", "getPageNo", "setPageNo", "searchID", "", "getSearchID", "()Ljava/lang/String;", "setSearchID", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "totalCount", "enableLoadMore", "", "getHeadData", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getSimilarEmojiList", "", "getTitle", "isSimilarSearch", "onCrate", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.am.h
{
  public static final a WAn;
  boolean ABD;
  LinkedList<com.tencent.mm.emoji.c.b.h> Trs;
  SimilarEmojiQueryModel WAo;
  com.tencent.mm.am.h callback;
  private int lNX;
  int miw;
  int offset;
  String sessionId;
  String xVe;
  
  static
  {
    AppMethodBeat.i(82496);
    WAn = new a((byte)0);
    AppMethodBeat.o(82496);
  }
  
  public c()
  {
    AppMethodBeat.i(82495);
    this.sessionId = "";
    this.xVe = kotlin.g.b.s.X("Similar", Long.valueOf(System.currentTimeMillis()));
    this.ABD = true;
    this.Trs = new LinkedList();
    AppMethodBeat.o(82495);
  }
  
  public final void e(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(82493);
    kotlin.g.b.s.u(paramh, "callback");
    Log.i("MicroMsg.SimilarEmoji", "do net request:[" + this.WAo + ']');
    this.callback = paramh;
    if (!this.ABD)
    {
      AppMethodBeat.o(82493);
      return;
    }
    paramh = this.WAo;
    Object localObject;
    w localw;
    if (paramh != null)
    {
      if (itb())
      {
        localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramh.emojiMD5);
        paramh = new com.tencent.mm.plugin.webview.fts.d(paramh.emojiMD5, this.offset, this.xVe, this.xVe, 0, this.xVe, 59, ((EmojiInfo)localObject).field_cdnUrl, ((EmojiInfo)localObject).field_aeskey);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramh, 0);
        AppMethodBeat.o(82493);
        return;
      }
      localw = new w();
      localw.scene = 78;
      paramh = this.WAo;
      if (paramh != null) {
        break label256;
      }
      paramh = "";
    }
    for (;;)
    {
      localw.hAB = paramh;
      localw.businessType = 256;
      localw.hVr = 1;
      localw.offset = this.offset;
      localw.sessionId = this.sessionId;
      localw.xVe = this.xVe;
      localw.hOG = this.xVe;
      paramh = new com.tencent.mm.plugin.websearch.api.s(localw);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramh, 0);
      AppMethodBeat.o(82493);
      return;
      label256:
      localObject = paramh.query;
      paramh = (com.tencent.mm.am.h)localObject;
      if (localObject == null) {
        paramh = "";
      }
    }
  }
  
  public final EmojiInfo ita()
  {
    AppMethodBeat.i(82492);
    Object localObject = this.WAo;
    if (localObject != null)
    {
      if (itb())
      {
        localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(((SimilarEmojiQueryModel)localObject).emojiMD5);
        if (localObject == null)
        {
          AppMethodBeat.o(82492);
          return null;
        }
        ((EmojiInfo)localObject).field_catalog = EmojiInfo.aklG;
        if (this.Trs.isEmpty()) {
          this.Trs.add(new com.tencent.mm.emoji.c.b.h((EmojiInfo)localObject, 100));
        }
        AppMethodBeat.o(82492);
        return localObject;
      }
      localObject = new EmojiInfo();
      if (this.Trs.isEmpty()) {
        this.Trs.add(new com.tencent.mm.emoji.c.b.h((EmojiInfo)localObject, 107));
      }
      AppMethodBeat.o(82492);
      return localObject;
    }
    AppMethodBeat.o(82492);
    return null;
  }
  
  public final boolean itb()
  {
    AppMethodBeat.i(294771);
    SimilarEmojiQueryModel localSimilarEmojiQueryModel = this.WAo;
    if (localSimilarEmojiQueryModel == null)
    {
      AppMethodBeat.o(294771);
      return false;
    }
    boolean bool = localSimilarEmojiQueryModel.itb();
    AppMethodBeat.o(294771);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(82494);
    Object localObject1;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramp instanceof com.tencent.mm.plugin.webview.fts.d)) {
        break label360;
      }
      localObject1 = Util.nullAs(((com.tencent.mm.plugin.webview.fts.d)paramp).WBd.aayd, "");
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.offset = ((JSONObject)localObject1).optInt("offset", 0);
      this.lNX = ((JSONObject)localObject1).optInt("totalCount", 0);
      this.ABD = ((JSONObject)localObject1).optBoolean("continueFlag", false);
      localObject2 = ((JSONObject)localObject1).optString("searchID");
      kotlin.g.b.s.s(localObject2, "responseJson.optString(\"searchID\")");
      this.xVe = ((String)localObject2);
      localObject1 = ((JSONObject)localObject1).optJSONArray("items");
      if (((Collection)this.Trs).isEmpty()) {
        break label354;
      }
      i = 1;
      if ((i != 0) && (((com.tencent.mm.emoji.c.b.h)kotlin.a.p.oM((List)this.Trs)).miu == 104)) {
        this.Trs.remove(kotlin.a.p.oM((List)this.Trs));
      }
      if (localObject1 != null) {
        break label780;
      }
      localObject1 = new JSONArray();
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        int k;
        label234:
        int j;
        Object localObject3;
        label354:
        label360:
        label746:
        label752:
        continue;
        label566:
        label600:
        do
        {
          i = j;
          break label600;
          break label566;
          i = j;
          break label234;
          break;
        } while (j < k);
      }
    }
    Log.i("MicroMsg.SimilarEmoji", kotlin.g.b.s.X("similar get more emoji size:", Integer.valueOf(((JSONArray)localObject1).length())));
    i = 0;
    k = ((JSONArray)localObject1).length();
    if (k > 0)
    {
      j = i + 1;
      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
      localObject3 = new EmojiInfo();
      com.tencent.mm.plugin.emoji.g.d.a("MicroMsg.SimilarEmoji", (JSONObject)localObject2, (EmojiInfo)localObject3);
      this.Trs.add(new com.tencent.mm.emoji.c.b.h((EmojiInfo)localObject3, 103));
      if (j < k) {}
    }
    else
    {
      if (this.ABD) {
        this.Trs.add(new com.tencent.mm.emoji.c.b.h(new EmojiInfo(), 104));
      }
      while (!(paramp instanceof com.tencent.mm.plugin.websearch.api.s)) {
        for (;;)
        {
          localObject1 = this.callback;
          if (localObject1 != null) {
            ((com.tencent.mm.am.h)localObject1).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
          }
          AppMethodBeat.o(82494);
          return;
          i = 0;
        }
      }
      this.miw += 1;
      localObject1 = ((com.tencent.mm.plugin.websearch.api.s)paramp).WnR;
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject(((gid)localObject1).aayd);
          this.offset = ((JSONObject)localObject1).optInt("offset", 0);
          if (((JSONObject)localObject1).optInt("continueFlag", 0) != 1) {
            break label746;
          }
          bool = true;
          this.ABD = bool;
          localObject2 = ((JSONObject)localObject1).optString("searchID", "");
          kotlin.g.b.s.s(localObject2, "responseJson.optString(\"searchID\", \"\")");
          this.xVe = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optJSONArray("data").optJSONObject(0);
          this.lNX = ((JSONObject)localObject1).optInt("totalCount", 0);
          localObject1 = ((JSONObject)localObject1).optJSONArray("items");
          if (((Collection)this.Trs).isEmpty()) {
            break label752;
          }
          i = 1;
          if ((i != 0) && (((com.tencent.mm.emoji.c.b.h)kotlin.a.p.oM((List)this.Trs)).miu == 104)) {
            this.Trs.removeLast();
          }
          if (localObject1 != null) {
            break label770;
          }
          localObject1 = new JSONArray();
          Log.i("MicroMsg.SimilarEmoji", kotlin.g.b.s.X("websearch get more emoji size:", Integer.valueOf(((JSONArray)localObject1).length())));
          i = 0;
          k = ((JSONArray)localObject1).length();
          if (k > 0)
          {
            j = i + 1;
            Object localObject4 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject4 == null) {
              break label783;
            }
            localObject2 = new EmojiInfo();
            com.tencent.mm.plugin.emoji.g.d.a("MicroMsg.SimilarEmoji", (JSONObject)localObject4, (EmojiInfo)localObject2);
            localObject3 = this.Trs;
            localObject4 = ((JSONObject)localObject4).optString("docID", "");
            kotlin.g.b.s.s(localObject4, "it.optString(\"docID\", \"\")");
            ((LinkedList)localObject3).add(new com.tencent.mm.emoji.c.b.h((EmojiInfo)localObject2, 103, (String)localObject4, this.miw));
            break label783;
          }
          if (!this.ABD) {
            break;
          }
          this.Trs.add(new com.tencent.mm.emoji.c.b.h(new EmojiInfo(), 104));
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.SimilarEmoji", (Throwable)localException1, "resultObj", new Object[0]);
        }
        break;
        boolean bool = false;
        continue;
        i = 0;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.c
 * JD-Core Version:    0.7.0.1
 */