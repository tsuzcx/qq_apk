package com.tencent.mm.plugin.websearch.b.a;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.websearch.b.a;
import com.tencent.mm.plugin.websearch.b.d;
import com.tencent.mm.plugin.websearch.webview.e;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.flp;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "appendSearchTag", "", "tag", "", "sessionId", "searchId", "requestId", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onStartSearchShareCgi", "id", "startMoreTab", "moreContext", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends e<flp>
{
  public abstract void N(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(cry paramcry, Bitmap paramBitmap, String paramString);
  
  public abstract void a(flp paramflp);
  
  public abstract void biF(String paramString);
  
  public abstract d iqF();
  
  public abstract a iqG();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.b
 * JD-Core Version:    0.7.0.1
 */