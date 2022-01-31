package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class a$2
  implements Runnable
{
  a$2(int paramInt, String paramString1, String paramString2, String paramString3, PByteArray paramPByteArray) {}
  
  public final void run()
  {
    Object localObject = ah.getContext().getSharedPreferences("system_config_prefs", 0);
    localObject = "http://" + ((SharedPreferences)localObject).getString("support.weixin.qq.com", "support.weixin.qq.com");
    localObject = new StringBuilder().append((String)localObject).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.whH)).append("&devicetype=").append(d.eQs).append("&filelength=").append(this.tmX).append("&sum=").append(this.tmY).append("&reporttype=1&NewReportType=").append(bo.g((Integer)a.euI.get(this.bMK)));
    if ((this.efI != null) && (!this.efI.equals(""))) {
      ((StringBuilder)localObject).append("&username=").append(this.efI);
    }
    ab.d("MicroMsg.CrashUpload", "dkcrash sb:" + ((StringBuilder)localObject).toString());
    a.E(((StringBuilder)localObject).toString(), this.tmZ.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a.2
 * JD-Core Version:    0.7.0.1
 */