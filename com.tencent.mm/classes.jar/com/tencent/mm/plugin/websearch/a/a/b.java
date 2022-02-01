package com.tencent.mm.plugin.websearch.a.a;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.egj;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "appendSearchTag", "", "tag", "", "sessionId", "searchId", "requestId", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "startMoreTab", "moreContext", "ui-websearch_release"})
public abstract interface b
  extends c<egj>
{
  public abstract void F(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(buv parambuv, Bitmap paramBitmap, String paramString);
  
  public abstract void a(egj paramegj);
  
  public abstract void aXn(String paramString);
  
  public abstract void cK(String paramString, boolean paramBoolean);
  
  public abstract d fYG();
  
  public abstract a fYH();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.b
 * JD-Core Version:    0.7.0.1
 */