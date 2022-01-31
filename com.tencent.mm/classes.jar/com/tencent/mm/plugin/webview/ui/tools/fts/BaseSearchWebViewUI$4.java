package com.tencent.mm.plugin.webview.ui.tools.fts;

import a.f.b.j;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.emoji.loader.d.h.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class BaseSearchWebViewUI$4
  implements t.a
{
  BaseSearchWebViewUI$4(BaseSearchWebViewUI paramBaseSearchWebViewUI) {}
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(153282);
    Object localObject1 = this.vkb.vjW + ";" + this.vkb.cpW + ";" + System.currentTimeMillis();
    BaseSearchWebViewUI.b(this.vkb).set16029ExtraInfo((String)localObject1);
    paramk = (EmojiInfo)paramk;
    localObject1 = "weixin://fts/emoji?path=" + BaseSearchWebViewUI.a(this.vkb, paramk);
    String str1 = paramk.field_md5;
    String str2 = paramk.field_aeskey;
    String str3 = paramk.field_encrypturl;
    boolean bool = paramk.dzn();
    int j = 0;
    int i;
    label139:
    Object localObject2;
    if (paramk.field_catalog == EmojiInfo.yPm)
    {
      i = 1;
      if (i == 0) {
        break label266;
      }
      i = 1;
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSelectedEmoji %s %s %b", new Object[] { str1, localObject1, Boolean.valueOf(bool) });
      localObject2 = this.vkb.getJsapi();
      if (!bool) {
        break label292;
      }
    }
    label266:
    label292:
    for (j = 0;; j = 1)
    {
      ((d)localObject2).a(str1, (String)localObject1, i, j, str3, str2);
      if (!bool)
      {
        localObject2 = a.evk;
        localObject1 = new BaseSearchWebViewUI.4.1(this, paramk, str1, (String)localObject1, i, str3, str2);
        j.q(paramk, "emojiInfo");
        a.a(paramk, true, (h.a)localObject1);
      }
      this.vkb.vjU.setVisibility(8);
      AppMethodBeat.o(153282);
      return;
      i = 0;
      break;
      if (b.y(paramk))
      {
        i = 2;
        break label139;
      }
      i = j;
      if (!b.x(paramk)) {
        break label139;
      }
      i = 3;
      break label139;
    }
  }
  
  public final void onHide() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */