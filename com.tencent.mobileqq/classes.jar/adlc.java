import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.txproxy.HostInterface;
import mqq.app.AppRuntime;

public class adlc
  implements HostInterface
{
  public adlc(NowPlugin paramNowPlugin) {}
  
  public boolean isMobileNet()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public void reportBadIp(String paramString1, String paramString2)
  {
    InnerDns.a().a(paramString1, paramString2, 1017);
  }
  
  public String reqDns(String paramString)
  {
    return InnerDns.a().a(paramString, 1017);
  }
  
  public boolean useIpDirectConnect()
  {
    QQAppInterface localQQAppInterface = NowPlugin.a(this.a);
    Object localObject = localQQAppInterface;
    if (localQQAppInterface == null) {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localObject != null) {
      return ((Integer)NearbySPUtil.a(((AppRuntime)localObject).getAccount(), "now_ip_conn_switch", Integer.valueOf(0))).intValue() == 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlc
 * JD-Core Version:    0.7.0.1
 */