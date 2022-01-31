package com.tencent.mm.plugin.voip;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import java.io.File;
import java.io.InputStream;

final class b$2
  implements FilterRawGet.GetInputStream
{
  b$2(b paramb) {}
  
  public final InputStream getInputStream(String paramString)
  {
    AppMethodBeat.i(4308);
    try
    {
      InputStream localInputStream = ah.getContext().getAssets().open("raw" + File.separator + paramString);
      AppMethodBeat.o(4308);
      return localInputStream;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SubCoreVoip", "cannot find res %s", new Object[] { paramString });
      h.qsU.j(914L, 13L, 1L);
      AppMethodBeat.o(4308);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.2
 * JD-Core Version:    0.7.0.1
 */