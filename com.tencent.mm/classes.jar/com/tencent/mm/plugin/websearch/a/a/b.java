package com.tencent.mm.plugin.websearch.a.a;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.eql;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "appendSearchTag", "", "tag", "", "sessionId", "searchId", "requestId", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "startMoreTab", "moreContext", "ui-websearch_release"})
public abstract interface b
  extends c<eql>
{
  public abstract void L(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(ccn paramccn, Bitmap paramBitmap, String paramString);
  
  public abstract void a(eql parameql);
  
  public abstract void biY(String paramString);
  
  public abstract void cY(String paramString, boolean paramBoolean);
  
  public abstract d gRr();
  
  public abstract a gRs();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.b
 * JD-Core Version:    0.7.0.1
 */