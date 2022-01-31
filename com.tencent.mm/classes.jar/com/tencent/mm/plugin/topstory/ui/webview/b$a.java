package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.util.c;

final class b$a
  implements Runnable
{
  private b$a(b paramb) {}
  
  private static long aN(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return paramArrayOfByte.length;
  }
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = aa.Bn(1);
    String str1 = String.format("%s/%s", new Object[] { ((ap)localObject).aoA(), "app.html" });
    String str2 = String.format("%s/%s", new Object[] { ((ap)localObject).aoA(), "dist/build.js" });
    String str3 = String.format("%s/%s", new Object[] { ((ap)localObject).aoA(), "dist/style.css" });
    this.pIl.pIh = com.tencent.mm.vfs.e.c(str1, 0, -1);
    this.pIl.pIi = com.tencent.mm.vfs.e.c(str2, 0, -1);
    this.pIl.pIj = com.tencent.mm.vfs.e.c(str3, 0, -1);
    if (!c.o(this.pIl.pIi).equals(((ap)localObject).bZQ()))
    {
      com.tencent.mm.a.e.bL(((ap)localObject).aoA());
      aa.a(new com.tencent.mm.vfs.b(((ap)localObject).aoA()), 1);
      this.pIl.pIh = com.tencent.mm.vfs.e.c(str1, 0, -1);
      this.pIl.pIi = com.tencent.mm.vfs.e.c(str2, 0, -1);
      this.pIl.pIj = com.tencent.mm.vfs.e.c(str3, 0, -1);
      str1 = c.o(this.pIl.pIi);
      localObject = ((ap)localObject).bZQ();
      ao.BG(21);
      y.i("MicroMsg.TopStory.TopStoryWebData", "update template file fileJSMd5 %s configJSMD5 %s", new Object[] { str1, localObject });
      y.i("MicroMsg.TopStory.TopStoryWebData", "loadHtmlDataFromSdcard totalLength: %d usetime: %d fileJSMd5 %s configJSMD5 %s", new Object[] { Long.valueOf(aN(this.pIl.pIh) + aN(this.pIl.pIi) + aN(this.pIl.pIj)), Long.valueOf(System.currentTimeMillis() - l), str1, localObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.b.a
 * JD-Core Version:    0.7.0.1
 */