package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f
{
  private static void a(String paramString1, u paramu, String paramString2)
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
    paramString1 = ah.v(paramu.jKT());
    paramu = localStringBuffer.toString().getBytes();
    y.e(paramString1, paramu, paramu.length);
    AppMethodBeat.o(176168);
  }
  
  public static boolean aUo(String paramString)
  {
    AppMethodBeat.i(143794);
    u localu = new u("/sdcard/cov.txt");
    if (!localu.jKS())
    {
      Log.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
      AppMethodBeat.o(143794);
      return false;
    }
    String str = bg.okT.aM("login_user_name", "never_login_crash");
    a(str, localu, paramString);
    paramString = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    paramString = r.a(localu, "/sdcard/cov/cov_" + paramString + ".zip");
    if (paramString == null)
    {
      Log.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
      AppMethodBeat.o(143794);
      return false;
    }
    localu.diJ();
    Log.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(str)));
    x.b(paramString, str, false, 10, 20004);
    AppMethodBeat.o(143794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.f
 * JD-Core Version:    0.7.0.1
 */