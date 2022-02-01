package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.model.bb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f
{
  private static void a(String paramString1, k paramk, String paramString2)
  {
    AppMethodBeat.i(176168);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#username=".concat(String.valueOf(paramString1)));
    localStringBuffer.append("\n");
    localStringBuffer.append("#rev=" + j.REV);
    localStringBuffer.append("\n");
    localStringBuffer.append("#path=" + j.SVNPATH);
    localStringBuffer.append("\n");
    if (paramString2.length() > 0)
    {
      localStringBuffer.append("#startrev=".concat(String.valueOf(paramString2)));
      localStringBuffer.append("\n");
    }
    paramString1 = w.B(paramk.fTh());
    paramk = localStringBuffer.toString().getBytes();
    o.e(paramString1, paramk, paramk.length);
    AppMethodBeat.o(176168);
  }
  
  public static boolean axR(String paramString)
  {
    AppMethodBeat.i(143794);
    k localk = new k("/sdcard/cov.txt");
    if (!localk.exists())
    {
      ae.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
      AppMethodBeat.o(143794);
      return false;
    }
    String str = bb.hIK.ay("login_user_name", "never_login_crash");
    a(str, localk, paramString);
    paramString = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    paramString = r.a(localk, false, "/sdcard/cov/cov_" + paramString + ".zip");
    if (paramString == null)
    {
      ae.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
      AppMethodBeat.o(143794);
      return false;
    }
    localk.delete();
    ae.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :".concat(String.valueOf(str)));
    aa.a(paramString, str, false, false, 20004);
    AppMethodBeat.o(143794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.f
 * JD-Core Version:    0.7.0.1
 */