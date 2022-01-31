package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.h.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;

final class BaseSearchWebViewUI$4$1
  implements h.a
{
  BaseSearchWebViewUI$4$1(BaseSearchWebViewUI.4 param4, EmojiInfo paramEmojiInfo, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public final void cd(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(153281);
    if (paramBoolean)
    {
      Object localObject = BaseSearchWebViewUI.a(this.vke.vkb, this.lfG);
      ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s emojiPath %s exist %b", new Object[] { this.iiy, this.fEQ, localObject, Boolean.valueOf(e.cN((String)localObject)) });
      localObject = this.vke.vkb.getJsapi();
      String str1 = this.iiy;
      String str2 = this.fEQ;
      int j = this.vkc;
      if (paramBoolean) {}
      for (;;)
      {
        ((d)localObject).a(str1, str2, j, i, this.uTk, this.vkd);
        AppMethodBeat.o(153281);
        return;
        i = 1;
      }
    }
    ab.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s fail", new Object[] { this.iiy, this.fEQ });
    AppMethodBeat.o(153281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.4.1
 * JD-Core Version:    0.7.0.1
 */