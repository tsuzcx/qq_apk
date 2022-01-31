package com.tencent.mm.plugin.traceroute.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class a$f$1
  implements Runnable
{
  a$f$1(a.f paramf, int paramInt, String paramString, PByteArray paramPByteArray) {}
  
  public final void run()
  {
    Object localObject = ae.getContext().getSharedPreferences("system_config_prefs", 0);
    localObject = "http://" + ((SharedPreferences)localObject).getString("support.weixin.qq.com", "support.weixin.qq.com");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject + "/cgi-bin/mmsupport-bin/stackreport?version=");
    localStringBuffer.append(Integer.toHexString(d.spa));
    localStringBuffer.append("&devicetype=");
    localStringBuffer.append(d.dOM);
    localStringBuffer.append("&filelength=");
    localStringBuffer.append(this.pIJ);
    localStringBuffer.append("&sum=");
    localStringBuffer.append(this.pIK);
    localStringBuffer.append("&reporttype=");
    localStringBuffer.append(4);
    if ((this.pIM.pII.userName != null) && (!this.pIM.pII.userName.equals("")))
    {
      localStringBuffer.append("&username=");
      localStringBuffer.append(this.pIM.pII.userName);
    }
    y.d("MicroMsg.MMTraceRoute", "traceroute report url:" + localStringBuffer.toString());
    a.f.a(this.pIM, localStringBuffer.toString(), this.pIL.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a.f.1
 * JD-Core Version:    0.7.0.1
 */