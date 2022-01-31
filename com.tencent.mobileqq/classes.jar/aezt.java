import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.qphone.base.util.QLog;

class aezt
  implements aysa
{
  private Handler a;
  
  aezt(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(aysx paramaysx)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = paramaysx.jdField_a_of_type_Aysw;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)paramaysx.jdField_a_of_type_Aysw.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, aezn.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + paramaysx.jdField_a_of_type_Long + " file.path = " + paramaysx.jdField_a_of_type_Aysw.c + " resp.result = " + paramaysx.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (paramaysx.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aezn.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      aezn.a(paramaysx.jdField_a_of_type_Aysw.c);
      if (localZhituImgResponse != null)
      {
        paramaysx = this.a.obtainMessage(3);
        paramaysx.obj = localBundle;
        this.a.sendMessage(paramaysx);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aezn.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      paramaysx = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      paramaysx.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", paramaysx.b);
      ((Message)localObject).obj = localBundle;
      paramaysx = (aysx)localObject;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezt
 * JD-Core Version:    0.7.0.1
 */