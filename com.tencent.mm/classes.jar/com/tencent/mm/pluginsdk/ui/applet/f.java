package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  implements com.tencent.mm.at.a.c.b
{
  public f()
  {
    AppMethodBeat.i(11689);
    AppMethodBeat.o(11689);
  }
  
  public final com.tencent.mm.at.a.d.b tB(String paramString)
  {
    AppMethodBeat.i(11690);
    ab.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        com.tencent.mm.at.a.d.b localb = f.a.tC(paramString);
        if (localb != null)
        {
          long l2 = System.currentTimeMillis();
          if ((!q.ahJ()) || (bo.isNullOrNil(localb.aZn)) || (!q.tv(paramString)) || (!localb.aZn.equals("image/webp"))) {
            break label203;
          }
          bool = true;
          ab.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", new Object[] { Boolean.valueOf(bool) });
          l1 = l2 - l1;
          ab.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", new Object[] { Long.valueOf(l1) });
          h.qsU.idkeyStat(86L, 4L, l1, false);
          if (bool) {
            h.qsU.idkeyStat(86L, 17L, l1, false);
          }
        }
        AppMethodBeat.o(11690);
        return localb;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", new Object[] { paramString.toString() });
        paramString = new com.tencent.mm.at.a.d.b(null, null, (byte)0);
        AppMethodBeat.o(11690);
        return paramString;
      }
      label203:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.f
 * JD-Core Version:    0.7.0.1
 */