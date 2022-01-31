import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.qphone.base.util.QLog;

class agww
  implements bapx
{
  private Handler a;
  
  agww(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(baqw parambaqw)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = parambaqw.jdField_a_of_type_Baqv;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)parambaqw.jdField_a_of_type_Baqv.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, agwq.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + parambaqw.jdField_a_of_type_Long + " file.path = " + parambaqw.jdField_a_of_type_Baqv.c + " resp.result = " + parambaqw.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (parambaqw.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, agwq.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      agwq.a(parambaqw.jdField_a_of_type_Baqv.c);
      if (localZhituImgResponse != null)
      {
        parambaqw = this.a.obtainMessage(3);
        parambaqw.obj = localBundle;
        this.a.sendMessage(parambaqw);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, agwq.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      parambaqw = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      parambaqw.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", parambaqw.b);
      ((Message)localObject).obj = localBundle;
      parambaqw = (baqw)localObject;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agww
 * JD-Core Version:    0.7.0.1
 */