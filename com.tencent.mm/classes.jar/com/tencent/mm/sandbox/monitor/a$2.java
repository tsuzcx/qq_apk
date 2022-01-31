package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$2
  implements Runnable
{
  a$2(int paramInt, String paramString1, String paramString2, String paramString3, PByteArray paramPByteArray) {}
  
  public final void run()
  {
    Object localObject = ae.getContext().getSharedPreferences("system_config_prefs", 0);
    localObject = "http://" + ((SharedPreferences)localObject).getString("support.weixin.qq.com", "support.weixin.qq.com");
    localObject = new StringBuilder().append((String)localObject).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.spa)).append("&devicetype=").append(d.dOM).append("&filelength=").append(this.pIJ).append("&sum=").append(this.pIK).append("&reporttype=1&NewReportType=").append(bk.g((Integer)a.dBh.get(this.bnl)));
    if ((this.dol != null) && (!this.dol.equals(""))) {
      ((StringBuilder)localObject).append("&username=").append(this.dol);
    }
    y.d("MicroMsg.CrashUpload", "dkcrash sb:" + ((StringBuilder)localObject).toString());
    a.w(((StringBuilder)localObject).toString(), this.pIL.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a.2
 * JD-Core Version:    0.7.0.1
 */