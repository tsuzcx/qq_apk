package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e
{
  private static void a(String paramString1, q paramq, String paramString2)
  {
    AppMethodBeat.i(176168);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#username=".concat(String.valueOf(paramString1)));
    localStringBuffer.append("\n");
    localStringBuffer.append("#rev=" + BuildInfo.REV);
    localStringBuffer.append("\n");
    localStringBuffer.append("#path=" + BuildInfo.SVNPATH);
    localStringBuffer.append("\n");
    if (paramString2.length() > 0)
    {
      localStringBuffer.append("#startrev=".concat(String.valueOf(paramString2)));
      localStringBuffer.append("\n");
    }
    u.F(paramq.bOF(), localStringBuffer.toString().getBytes());
    AppMethodBeat.o(176168);
  }
  
  public static boolean aWY(String paramString)
  {
    AppMethodBeat.i(143794);
    q localq = new q("/sdcard/cov.txt");
    if (!localq.ifE())
    {
      Log.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
      AppMethodBeat.o(143794);
      return false;
    }
    String str = bg.ltv.aD("login_user_name", "never_login_crash");
    a(str, localq, paramString);
    paramString = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    paramString = r.a(localq, "/sdcard/cov/cov_" + paramString + ".zip");
    if (paramString == null)
    {
      Log.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
      AppMethodBeat.o(143794);
      return false;
    }
    localq.cFq();
    Log.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(str)));
    aa.b(paramString, str, false, 10, 20004);
    AppMethodBeat.o(143794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.e
 * JD-Core Version:    0.7.0.1
 */