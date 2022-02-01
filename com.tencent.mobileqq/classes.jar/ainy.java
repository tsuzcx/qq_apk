import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.qphone.base.util.QLog;

class ainy
  implements bdvw
{
  private Handler a;
  
  ainy(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(bdwt parambdwt)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = parambdwt.jdField_a_of_type_Bdws;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)parambdwt.jdField_a_of_type_Bdws.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, ains.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + parambdwt.jdField_a_of_type_Long + " file.path = " + parambdwt.jdField_a_of_type_Bdws.c + " resp.result = " + parambdwt.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (parambdwt.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ains.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      ains.a(parambdwt.jdField_a_of_type_Bdws.c);
      if (localZhituImgResponse != null)
      {
        parambdwt = this.a.obtainMessage(3);
        parambdwt.obj = localBundle;
        this.a.sendMessage(parambdwt);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ains.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      parambdwt = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      parambdwt.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", parambdwt.b);
      ((Message)localObject).obj = localBundle;
      parambdwt = (bdwt)localObject;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainy
 * JD-Core Version:    0.7.0.1
 */