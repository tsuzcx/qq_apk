package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.xweb.util.d;

final class c$a
  implements Runnable
{
  private c$a(c paramc) {}
  
  private static long bm(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return paramArrayOfByte.length;
  }
  
  public final void run()
  {
    AppMethodBeat.i(2152);
    long l = System.currentTimeMillis();
    Object localObject = aa.Ja(1);
    String str1 = String.format("%s/%s", new Object[] { ((ao)localObject).aLw(), "app.html" });
    String str2 = String.format("%s/%s", new Object[] { ((ao)localObject).aLw(), "dist/build.js" });
    String str3 = String.format("%s/%s", new Object[] { ((ao)localObject).aLw(), "dist/style.css" });
    this.tmb.tlW = com.tencent.mm.vfs.e.i(str1, 0, -1);
    this.tmb.tlX = com.tencent.mm.vfs.e.i(str2, 0, -1);
    this.tmb.tlY = com.tencent.mm.vfs.e.i(str3, 0, -1);
    String str4 = d.w(this.tmb.tlX);
    String str5 = ((ao)localObject).cZL();
    if ((str4 == null) || (!str4.equals(str5)))
    {
      com.tencent.mm.a.e.cO(((ao)localObject).aLw());
      aa.a(new b(((ao)localObject).aLw()), 1);
      this.tmb.tlW = com.tencent.mm.vfs.e.i(str1, 0, -1);
      this.tmb.tlX = com.tencent.mm.vfs.e.i(str2, 0, -1);
      this.tmb.tlY = com.tencent.mm.vfs.e.i(str3, 0, -1);
      str1 = d.w(this.tmb.tlX);
      localObject = ((ao)localObject).cZL();
      an.Jw(21);
      ab.i("MicroMsg.TopStory.TopStoryWebData", "update template file fileJSMd5 %s configJSMD5 %s", new Object[] { str1, localObject });
      ab.i("MicroMsg.TopStory.TopStoryWebData", "loadHtmlDataFromSdcard totalLength: %d usetime: %d fileJSMd5 %s configJSMD5 %s", new Object[] { Long.valueOf(bm(this.tmb.tlW) + bm(this.tmb.tlX) + bm(this.tmb.tlY)), Long.valueOf(System.currentTimeMillis() - l), str1, localObject });
    }
    AppMethodBeat.o(2152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c.a
 * JD-Core Version:    0.7.0.1
 */