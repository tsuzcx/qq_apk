package com.tencent.mm.plugin.voip;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import java.io.File;
import java.io.InputStream;

final class b$2
  implements FilterRawGet.GetInputStream
{
  b$2(b paramb) {}
  
  public final InputStream getInputStream(String paramString)
  {
    try
    {
      InputStream localInputStream = ae.getContext().getAssets().open("raw" + File.separator + paramString);
      return localInputStream;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SubCoreVoip", "cannot find res %s", new Object[] { paramString });
      h.nFQ.h(914L, 13L, 1L);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.2
 * JD-Core Version:    0.7.0.1
 */