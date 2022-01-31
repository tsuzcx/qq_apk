import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.qphone.base.util.QLog;

class aezr
  implements aysc
{
  private Handler a;
  
  aezr(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onResp(aysz paramaysz)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = paramaysz.jdField_a_of_type_Aysy;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)paramaysz.jdField_a_of_type_Aysy.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, aezl.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + paramaysz.jdField_a_of_type_Long + " file.path = " + paramaysz.jdField_a_of_type_Aysy.c + " resp.result = " + paramaysz.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (paramaysz.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aezl.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      aezl.a(paramaysz.jdField_a_of_type_Aysy.c);
      if (localZhituImgResponse != null)
      {
        paramaysz = this.a.obtainMessage(3);
        paramaysz.obj = localBundle;
        this.a.sendMessage(paramaysz);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, aezl.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      paramaysz = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      paramaysz.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", paramaysz.b);
      ((Message)localObject).obj = localBundle;
      paramaysz = (aysz)localObject;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezr
 * JD-Core Version:    0.7.0.1
 */