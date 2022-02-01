package mqq.app;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

class MobileQQ$4
  implements Comparator<SimpleAccount>
{
  MobileQQ$4(MobileQQ paramMobileQQ) {}
  
  public int compare(SimpleAccount paramSimpleAccount1, SimpleAccount paramSimpleAccount2)
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSimpleAccount1.getUin());
    localStringBuilder.append(Constants.Key._logintime);
    long l1 = ((MobileQQ)localObject).string2Long(((MobileQQ)localObject).getProperty(localStringBuilder.toString()));
    localObject = this.this$0;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSimpleAccount2.getUin());
    localStringBuilder.append(Constants.Key._logintime);
    long l2 = ((MobileQQ)localObject).string2Long(((MobileQQ)localObject).getProperty(localStringBuilder.toString()));
    localObject = new StringBuilder(32);
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramSimpleAccount1.getUin()));
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramSimpleAccount1.isLogined());
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramSimpleAccount2.getUin()));
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramSimpleAccount2.isLogined());
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(l2);
    QLog.d("mqq", 1, ((StringBuilder)localObject).toString());
    if (l2 > l1) {
      return 1;
    }
    if (l2 < l1) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MobileQQ.4
 * JD-Core Version:    0.7.0.1
 */