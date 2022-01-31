package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f
{
  public static boolean LV(String paramString)
  {
    File localFile = new File("/sdcard/cov.txt");
    if (!localFile.exists())
    {
      y.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
      return false;
    }
    String str = at.dVC.L("login_user_name", "never_login_crash");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#username=" + str);
    localStringBuffer.append("\n");
    localStringBuffer.append("#rev=" + d.REV);
    localStringBuffer.append("\n");
    localStringBuffer.append("#path=" + d.SVNPATH);
    localStringBuffer.append("\n");
    if (paramString.length() > 0)
    {
      localStringBuffer.append("#startrev=" + paramString);
      localStringBuffer.append("\n");
    }
    e.e(localFile.getAbsolutePath(), localStringBuffer.toString().getBytes());
    paramString = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    paramString = p.b(localFile, false, "/sdcard/cov/cov_" + paramString + ".zip");
    if (paramString == null)
    {
      y.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
      return false;
    }
    localFile.delete();
    y.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :" + str);
    ad.a(paramString, str, false, false, 10, 20004);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.f
 * JD-Core Version:    0.7.0.1
 */