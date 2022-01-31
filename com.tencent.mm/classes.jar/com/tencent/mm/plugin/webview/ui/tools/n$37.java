package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class n$37
  implements Runnable
{
  n$37(n paramn, int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(7750);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()) || (((WebViewUI)n.a(this.vdr).get()).pOd == null))
    {
      AppMethodBeat.o(7750);
      return;
    }
    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible, actionCode = " + this.uZz);
    Object localObject2 = new HashSet();
    if ((this.uZz == 3003) || (this.uZz == 3004))
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
    }
    String str;
    Object localObject1;
    for (;;)
    {
      str = ((WebViewUI)n.a(this.vdr).get()).pOd.getUrl();
      localObject1 = (SparseBooleanArray)((WebViewUI)n.a(this.vdr).get()).vfS.vcC.get(str);
      switch (this.uZz)
      {
      default: 
        AppMethodBeat.o(7750);
        return;
        if (this.cax == null)
        {
          ab.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible data is null.");
          AppMethodBeat.o(7750);
          return;
        }
        localObject1 = this.cax.getStringArrayList("menu_item_list");
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          ab.w("MicroMsg.WebViewStubCallbackAIDLStub", "setMenuItemsVisible menuItems is null or nil.");
          AppMethodBeat.o(7750);
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
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new SparseBooleanArray();
      ((WebViewUI)n.a(this.vdr).get()).vfS.vcC.put(str, localObject1);
    }
    for (;;)
    {
      localObject2 = ((Set)localObject2).iterator();
      int i;
      while (((Iterator)localObject2).hasNext())
      {
        i = bo.a((Integer)((WebViewUI)n.a(this.vdr).get()).vfS.vcD.get(((Iterator)localObject2).next()), -1);
        if (i >= 0) {
          ((SparseBooleanArray)localObject1).put(i, true);
        }
      }
      ((WebViewUI)n.a(this.vdr).get()).vfS.Km();
      AppMethodBeat.o(7750);
      return;
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = bo.a((Integer)((WebViewUI)n.a(this.vdr).get()).vfS.vcD.get(((Iterator)localObject2).next()), -1);
        if (i >= 0) {
          ((SparseBooleanArray)localObject1).delete(i);
        }
      }
      ((WebViewUI)n.a(this.vdr).get()).vfS.Km();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.37
 * JD-Core Version:    0.7.0.1
 */