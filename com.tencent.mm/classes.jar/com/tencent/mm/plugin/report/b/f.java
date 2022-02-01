package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f
{
  private static void a(String paramString1, o paramo, String paramString2)
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
    paramString1 = com.tencent.mm.vfs.aa.z(paramo.her());
    paramo = localStringBuffer.toString().getBytes();
    s.e(paramString1, paramo, paramo.length);
    AppMethodBeat.o(176168);
  }
  
  public static boolean aMt(String paramString)
  {
    AppMethodBeat.i(143794);
    o localo = new o("/sdcard/cov.txt");
    if (!localo.exists())
    {
      Log.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
      AppMethodBeat.o(143794);
      return false;
    }
    String str = bf.iDu.aA("login_user_name", "never_login_crash");
    a(str, localo, paramString);
    paramString = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    paramString = r.a(localo, false, "/sdcard/cov/cov_" + paramString + ".zip");
    if (paramString == null)
    {
      Log.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
      AppMethodBeat.o(143794);
      return false;
    }
    localo.delete();
    Log.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(str)));
    com.tencent.mm.platformtools.aa.a(paramString, str, false, false, 10, 20004);
    AppMethodBeat.o(143794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.f
 * JD-Core Version:    0.7.0.1
 */