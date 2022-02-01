package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;

final class BaseSearchWebViewUI$3
  implements ac.a
{
  BaseSearchWebViewUI$3(BaseSearchWebViewUI paramBaseSearchWebViewUI, String paramString) {}
  
  public final void a(final r paramr)
  {
    AppMethodBeat.i(211226);
    final String str1 = this.JnH.JnD + ";" + this.JnH.sessionId + ";" + this.DHv;
    BaseSearchWebViewUI.a(this.JnH).set16029ExtraInfo(str1);
    paramr = (EmojiInfo)paramr;
    str1 = BaseSearchWebViewUI.a(this.JnH, paramr);
    Object localObject1;
    if ((paramr.NA()) || (paramr.field_catalog == EmojiGroupInfo.Uun))
    {
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "emoji is system emoji %s", new Object[] { Integer.valueOf(paramr.field_catalog) });
      if (!s.YS(str1))
      {
        localObject1 = paramr.A(this.JnH, 480);
        if (localObject1 == null) {}
      }
    }
    try
    {
      BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 80, Bitmap.CompressFormat.PNG, str1, false);
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "save emoji bitmap %d %s", new Object[] { Long.valueOf(s.boW(str1)), str1 });
      str1 = "weixin://fts/emoji?path=".concat(String.valueOf(str1));
      localObject1 = paramr.field_md5;
      final String str2 = paramr.field_aeskey;
      final String str3 = paramr.field_encrypturl;
      boolean bool = paramr.hRx();
      i = 0;
      if (b.x(paramr))
      {
        i = 1;
        Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSelectedEmoji %s %s %b", new Object[] { localObject1, str1, Boolean.valueOf(bool) });
        Object localObject2 = this.JnH.getJsapi();
        if (!bool) {
          break label386;
        }
        j = 0;
        ((h)localObject2).a((String)localObject1, str1, i, j, str3, str2);
        if (!bool)
        {
          localObject2 = e.gVM;
          e.a(paramr, new i.a()
          {
            public final void dQ(boolean paramAnonymousBoolean)
            {
              int i = 0;
              AppMethodBeat.i(211225);
              if (paramAnonymousBoolean)
              {
                Object localObject = BaseSearchWebViewUI.a(BaseSearchWebViewUI.3.this.JnH, paramr);
                Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s emojiPath %s exist %b", new Object[] { this.lhI, str1, localObject, Boolean.valueOf(s.YS((String)localObject)) });
                localObject = BaseSearchWebViewUI.3.this.JnH.getJsapi();
                String str1 = this.lhI;
                String str2 = str1;
                int j = i;
                if (paramAnonymousBoolean) {}
                for (;;)
                {
                  ((h)localObject).a(str1, str2, j, i, str3, str2);
                  AppMethodBeat.o(211225);
                  return;
                  i = 1;
                }
              }
              Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s fail", new Object[] { this.lhI, str1 });
              AppMethodBeat.o(211225);
            }
          });
        }
        this.JnH.JnC.setVisibility(8);
        AppMethodBeat.o(211226);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        final int i;
        int j;
        Log.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localException, "SaveEmojiBitmap", new Object[0]);
        continue;
        if (b.y(paramr))
        {
          i = 2;
        }
        else if (b.w(paramr))
        {
          i = 3;
          continue;
          label386:
          j = 1;
        }
      }
    }
  }
  
  public final void onHide() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */