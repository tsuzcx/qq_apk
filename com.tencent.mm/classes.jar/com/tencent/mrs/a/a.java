package com.tencent.mrs.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.g.c;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MatrixUploadDataSlice;
import com.tencent.matrix.mrs.core.MatrixUploadIssue;
import com.tencent.matrix.mrs.core.MrsCallback;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  implements MrsCallback
{
  private HashMap<String, Boolean> Bak = new HashMap();
  
  public final String getCryptKey(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    return com.tencent.mm.a.g.w(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.whH), Long.valueOf(paramMatrixUploadDataSlice.getDataSize()) }).getBytes()).toLowerCase();
  }
  
  public final String getHost(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    return "support.weixin.qq.com";
  }
  
  public final String getPublicSharePath()
  {
    try
    {
      Object localObject = ah.getContext().getFilesDir();
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = ((File)localObject).toString();
      c.i("Matrix.MrsCallbackImp", "[TEST-PATH] getPublicSharePath, path: %s", new Object[] { localObject });
      localObject = (String)localObject + "/mrs/";
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("Matrix.MrsCallbackImp", localException.toString());
    }
    return "";
  }
  
  public final String getUrl(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    String str = com.tencent.mm.a.g.w(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.whH), Long.valueOf(paramMatrixUploadDataSlice.getDataSize()) }).getBytes()).toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder(512).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.whH)).append("&devicetype=").append("android-" + Build.VERSION.SDK_INT).append("&filelength=").append(paramMatrixUploadDataSlice.getDataSize()).append("&sum=").append(str);
    long l;
    if ((ah.brt()) && (com.tencent.mm.kernel.g.RG()))
    {
      str = r.Zn();
      if ((str != null) && (str.length() != 0)) {
        localStringBuilder.append("&username=").append(str);
      }
      if (1 != paramMatrixUploadDataSlice.getUploadIssue().getDataType()) {
        break label282;
      }
      if (paramMatrixUploadDataSlice.getUploadIssue().getId() >= 0L) {
        break label271;
      }
      l = -1L * paramMatrixUploadDataSlice.getUploadIssue().getId();
      label191:
      str = l + '.' + paramMatrixUploadDataSlice.getPackageIndex() + '.' + paramMatrixUploadDataSlice.getTotalPackage();
      localStringBuilder.append("&reporttype=19860829&reportvalue=").append(str).append("&rtxname=").append(paramMatrixUploadDataSlice.getUploadIssue().getTag());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      str = null;
      break;
      label271:
      l = paramMatrixUploadDataSlice.getUploadIssue().getId();
      break label191;
      label282:
      localStringBuilder.append("&reporttype=1&NewReportType=111");
    }
  }
  
  public final boolean onRequestGetMrsStrategy(byte[] paramArrayOfByte)
  {
    try
    {
      if (!com.tencent.mm.kernel.g.RG())
      {
        ab.e("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, account not ready");
        return false;
      }
      try
      {
        if (b.isRunning())
        {
          ab.i("Matrix.MrsCallbackImp", "NetSceneGetMrsStrategy is already running, just return");
          return false;
        }
      }
      finally {}
      ab.i("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, try to request mrs strategy");
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("Matrix.MrsCallbackImp", "error: " + paramArrayOfByte.getMessage());
      return false;
    }
    paramArrayOfByte = new b(paramArrayOfByte);
    com.tencent.mm.kernel.g.RK().eHt.a(paramArrayOfByte, 0);
    return true;
  }
  
  public final void onStrategyNotify(String paramString, boolean paramBoolean)
  {
    c.i("Matrix.MrsCallbackImp", "onStrategyNotify, strategy: %s, isReportProcess; %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (!com.tencent.matrix.b.isInstalled()) {}
    label266:
    label333:
    for (;;)
    {
      return;
      if (MatrixReport.isInstalled())
      {
        if (MatrixReport.with().isDebug())
        {
          c.i("Matrix.MrsCallbackImp", "onStrategyNotify, matrix will report all for debug mode", new Object[0]);
          return;
        }
        this.Bak.clear();
        Object localObject = this.Bak;
        if ((TextUtils.isEmpty(paramString)) || (localObject == null))
        {
          c.e("Matrix.MatrixUtil", "changeStrategyToMap, input params is illegal", new Object[0]);
          paramString = com.tencent.matrix.b.yD().bLY.iterator();
        }
        for (;;)
        {
          if (!paramString.hasNext()) {
            break label333;
          }
          localObject = (com.tencent.matrix.d.b)paramString.next();
          String str = ((com.tencent.matrix.d.b)localObject).getTag();
          if (this.Bak.containsKey(str))
          {
            paramBoolean = ((Boolean)this.Bak.get(str)).booleanValue();
            if ((paramBoolean) && (((com.tencent.matrix.d.b)localObject).isPluginStopped()))
            {
              c.w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn on plugin %s", new Object[] { str });
              ((com.tencent.matrix.d.b)localObject).start();
              continue;
              paramString = paramString.split(";");
              int j = paramString.length;
              int i = 0;
              label212:
              String[] arrayOfString;
              if (i < j)
              {
                str = paramString[i];
                arrayOfString = str.split(",", 2);
                if (arrayOfString.length == 2) {
                  break label266;
                }
                c.e("Matrix.MatrixUtil", "changeStrategyToMap, strategy format is illegal, value: %s", new Object[] { str });
              }
              for (;;)
              {
                i += 1;
                break label212;
                break;
                ((HashMap)localObject).put(arrayOfString[0].trim(), Boolean.valueOf(arrayOfString[1].trim().equals("1")));
              }
            }
            else if ((!paramBoolean) && (((com.tencent.matrix.d.b)localObject).isPluginStarted()))
            {
              c.w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn off plugin %s", new Object[] { str });
              ((com.tencent.matrix.d.b)localObject).stop();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.a.a
 * JD-Core Version:    0.7.0.1
 */