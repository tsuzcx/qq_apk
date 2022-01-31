import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.qphone.base.util.QLog;

class ahbl
  implements baug
{
  private Handler a;
  
  ahbl(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(bavf parambavf)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = parambavf.jdField_a_of_type_Bave;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)parambavf.jdField_a_of_type_Bave.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, ahbf.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + parambavf.jdField_a_of_type_Long + " file.path = " + parambavf.jdField_a_of_type_Bave.c + " resp.result = " + parambavf.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (parambavf.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ahbf.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      ahbf.a(parambavf.jdField_a_of_type_Bave.c);
      if (localZhituImgResponse != null)
      {
        parambavf = this.a.obtainMessage(3);
        parambavf.obj = localBundle;
        this.a.sendMessage(parambavf);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ahbf.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      parambavf = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      parambavf.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", parambavf.b);
      ((Message)localObject).obj = localBundle;
      parambavf = (bavf)localObject;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbl
 * JD-Core Version:    0.7.0.1
 */