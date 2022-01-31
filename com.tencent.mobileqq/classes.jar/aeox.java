import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.qphone.base.util.QLog;

class aeox
  implements axrt
{
  private Handler a;
  
  aeox(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(axsq paramaxsq)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = paramaxsq.jdField_a_of_type_Axsp;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)paramaxsq.jdField_a_of_type_Axsp.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, aeor.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + paramaxsq.jdField_a_of_type_Long + " file.path = " + paramaxsq.jdField_a_of_type_Axsp.c + " resp.result = " + paramaxsq.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (paramaxsq.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aeor.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      aeor.a(paramaxsq.jdField_a_of_type_Axsp.c);
      if (localZhituImgResponse != null)
      {
        paramaxsq = this.a.obtainMessage(3);
        paramaxsq.obj = localBundle;
        this.a.sendMessage(paramaxsq);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aeor.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      paramaxsq = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      paramaxsq.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", paramaxsq.b);
      ((Message)localObject).obj = localBundle;
      paramaxsq = (axsq)localObject;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeox
 * JD-Core Version:    0.7.0.1
 */