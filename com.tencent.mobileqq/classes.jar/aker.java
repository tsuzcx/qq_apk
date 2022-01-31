import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class aker
  extends ajzk
{
  aker(akep paramakep) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    String str2 = "";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (paramArrayOfByte != null)
      {
        str1 = new String(paramArrayOfByte);
        akep.a(this.a).sendBroadcast(new Intent().setAction("com.tencent.mobileqq.onGetStreetViewUrl").putExtra("streetViewUrl", str1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivityProxy", 2, "mLbsObserver, onGetStreetViewUrl: isSuccess=" + paramBoolean + ", hashCode=" + hashCode() + ",url=" + str1);
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("mLbsObserver, onGetLbsShareSearch: isSuccess=").append(paramBoolean).append(", isDataNull=");
      if (paramArrayOfObject != null) {
        break label65;
      }
    }
    label65:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQMapActivityProxy", 2, paramBoolean + ", hashCode=" + hashCode());
      if (paramArrayOfObject != null) {
        break;
      }
      return;
    }
    Object localObject = (ToServiceMsg)paramArrayOfObject[0];
    paramArrayOfObject = (byte[])paramArrayOfObject[1];
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.onGetLbsShareSearch");
    localIntent.putExtra("data", paramArrayOfObject);
    localIntent.putExtra("req", ((ToServiceMsg)localObject).extraData.getBundle("req"));
    akep.a(this.a).sendBroadcast(localIntent);
  }
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("mLbsObserver, onGetLbsShareShop: isSuccess=").append(paramBoolean).append(", isDataNull=");
      if (paramArrayOfObject != null) {
        break label65;
      }
    }
    label65:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQMapActivityProxy", 2, paramBoolean + ", hashCode=" + hashCode());
      if (paramArrayOfObject != null) {
        break;
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.onGetLbsShareShop");
    ((Intent)localObject).putExtra("data", (byte[])paramArrayOfObject[1]);
    ((Intent)localObject).putExtra("req", ((ToServiceMsg)paramArrayOfObject[0]).extraData.getBundle("req"));
    akep.a(this.a).sendBroadcast((Intent)localObject);
  }
  
  protected void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("mLbsObserver, onGetShareShopDetail: isSuccess=").append(paramBoolean).append(", isDataNull=");
      if (paramArrayOfObject != null) {
        break label65;
      }
    }
    label65:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQMapActivityProxy", 2, paramBoolean + ", hashCode=" + hashCode());
      if (paramArrayOfObject != null) {
        break;
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.onGetShareShopDetail");
    ((Intent)localObject).putExtra("data", (byte[])paramArrayOfObject[1]);
    ((Intent)localObject).putExtra("req", ((ToServiceMsg)paramArrayOfObject[0]).extraData.getBundle("req"));
    akep.a(this.a).sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aker
 * JD-Core Version:    0.7.0.1
 */