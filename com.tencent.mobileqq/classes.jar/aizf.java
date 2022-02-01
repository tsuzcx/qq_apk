import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.qphone.base.util.QLog;

class aizf
  implements beuq
{
  private Handler a;
  
  aizf(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(bevm parambevm)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = parambevm.jdField_a_of_type_Bevl;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)parambevm.jdField_a_of_type_Bevl.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, aiyz.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + parambevm.jdField_a_of_type_Long + " file.path = " + parambevm.jdField_a_of_type_Bevl.c + " resp.result = " + parambevm.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (parambevm.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aiyz.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      aiyz.a(parambevm.jdField_a_of_type_Bevl.c);
      if (localZhituImgResponse != null)
      {
        parambevm = this.a.obtainMessage(3);
        parambevm.obj = localBundle;
        this.a.sendMessage(parambevm);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aiyz.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      parambevm = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      parambevm.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", parambevm.b);
      ((Message)localObject).obj = localBundle;
      parambevm = (bevm)localObject;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizf
 * JD-Core Version:    0.7.0.1
 */