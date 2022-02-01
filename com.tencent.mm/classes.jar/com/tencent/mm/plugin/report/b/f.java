package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f
{
  private static void a(String paramString1, e parame, String paramString2)
  {
    AppMethodBeat.i(176168);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#username=".concat(String.valueOf(paramString1)));
    localStringBuffer.append("\n");
    localStringBuffer.append("#rev=" + com.tencent.mm.sdk.platformtools.i.REV);
    localStringBuffer.append("\n");
    localStringBuffer.append("#path=" + com.tencent.mm.sdk.platformtools.i.SVNPATH);
    localStringBuffer.append("\n");
    if (paramString2.length() > 0)
    {
      localStringBuffer.append("#startrev=".concat(String.valueOf(paramString2)));
      localStringBuffer.append("\n");
    }
    paramString1 = q.B(parame.fOK());
    parame = localStringBuffer.toString().getBytes();
    com.tencent.mm.vfs.i.e(paramString1, parame, parame.length);
    AppMethodBeat.o(176168);
  }
  
  public static boolean awC(String paramString)
  {
    AppMethodBeat.i(143794);
    e locale = new e("/sdcard/cov.txt");
    if (!locale.exists())
    {
      ad.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
      AppMethodBeat.o(143794);
      return false;
    }
    String str = az.hFS.ax("login_user_name", "never_login_crash");
    a(str, locale, paramString);
    paramString = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    paramString = r.a(locale, false, "/sdcard/cov/cov_" + paramString + ".zip");
    if (paramString == null)
    {
      ad.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
      AppMethodBeat.o(143794);
      return false;
    }
    locale.delete();
    ad.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(str)));
    aa.a(paramString, str, false, false, 20004);
    AppMethodBeat.o(143794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.f
 * JD-Core Version:    0.7.0.1
 */