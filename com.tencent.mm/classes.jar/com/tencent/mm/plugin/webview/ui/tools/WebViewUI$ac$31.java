package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class WebViewUI$ac$31
  implements Runnable
{
  WebViewUI$ac$31(WebViewUI.ac paramac, int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    if (this.rqr.rpH.niQ == null) {
      return;
    }
    y.i("MicroMsg.WebViewUI", "setMenuItemsVisible, actionCode = " + this.rkh);
    Object localObject2 = new HashSet();
    label264:
    Object localObject1;
    if ((this.rkh == 3003) || (this.rkh == 3004))
    {
      ((Set)localObject2).add("menuItem:share:brand");
      ((Set)localObject2).add("menuItem:share:appMessage");
      ((Set)localObject2).add("menuItem:share:dataMessage");
      ((Set)localObject2).add("menuItem:share:timeline");
      ((Set)localObject2).add("menuItem:favorite");
      ((Set)localObject2).add("menuItem:profile");
      ((Set)localObject2).add("menuItem:addContact");
      ((Set)localObject2).add("menuItem:copyUrl");
      ((Set)localObject2).add("menuItem:openWithSafari");
      ((Set)localObject2).add("menuItem:share:email");
      ((Set)localObject2).add("menuItem:delete");
      ((Set)localObject2).add("menuItem:editTag");
      ((Set)localObject2).add("menuItem:readMode");
      ((Set)localObject2).add("menuItem:originPage");
      ((Set)localObject2).add("menuItem:share:qq");
      ((Set)localObject2).add("menuItem:share:weiboApp");
      ((Set)localObject2).add("menuItem:share:QZone");
      ((Set)localObject2).add("menuItem:share:Facebook");
      ((Set)localObject2).add("menuItem:share:enterprise");
      ((Set)localObject2).add("menuItem:share:wework");
      ((Set)localObject2).add("menuItem:share:weread");
      ((Set)localObject2).add("menuItem:addShortcut");
      String str = this.rqr.rpH.niQ.getUrl();
      localObject1 = (SparseBooleanArray)WebViewUI.f(this.rqr.rpH).get(str);
      switch (this.rkh)
      {
      default: 
        return;
      case 3001: 
      case 3003: 
        if (localObject1 == null)
        {
          localObject1 = new SparseBooleanArray();
          WebViewUI.f(this.rqr.rpH).put(str, localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = ((Set)localObject2).iterator();
      int i;
      while (((Iterator)localObject2).hasNext())
      {
        i = bk.a((Integer)WebViewUI.g(this.rqr.rpH).get(((Iterator)localObject2).next()), -1);
        if (i >= 0) {
          ((SparseBooleanArray)localObject1).put(i, true);
        }
      }
      if (this.byv == null)
      {
        y.w("MicroMsg.WebViewUI", "setMenuItemsVisible data is null.");
        return;
      }
      localObject1 = this.byv.getStringArrayList("menu_item_list");
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        y.w("MicroMsg.WebViewUI", "setMenuItemsVisible menuItems is null or nil.");
        return;
      }
      ((Set)localObject2).addAll((Collection)localObject1);
      ((Set)localObject2).remove("menuItem:exposeArticle");
      ((Set)localObject2).remove("menuItem:setFont");
      ((Set)localObject2).remove("menuItem:keepTop");
      ((Set)localObject2).remove("menuItem:cancelKeepTop");
      ((Set)localObject2).remove("menuItem:profile");
      ((Set)localObject2).remove("menuItem:addContact");
      ((Set)localObject2).remove("menuItem:refresh");
      break label264;
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = bk.a((Integer)WebViewUI.g(this.rqr.rpH).get(((Iterator)localObject2).next()), -1);
        if (i >= 0) {
          ((SparseBooleanArray)localObject1).delete(i);
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.31
 * JD-Core Version:    0.7.0.1
 */