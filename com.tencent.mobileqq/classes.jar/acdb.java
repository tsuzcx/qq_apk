import android.os.Bundle;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.data.RespProcessor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.util.ProtocolUtils;
import mqq.app.MSFServlet;

public final class acdb
  implements RespProcessor
{
  public void a(MSFServlet paramMSFServlet, QzoneCommonIntent paramQzoneCommonIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = true;
    Object localObject = paramQzoneCommonIntent.getRequest();
    String str = ((QZoneCommonRequest)localObject).uniKey();
    int i = ((QZoneCommonRequest)localObject).a();
    int[] arrayOfInt = new int[1];
    if (!paramFromServiceMsg.isSuccess())
    {
      arrayOfInt[0] = (paramFromServiceMsg.getResultCode() + 300000);
      paramFromServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.i("QzoneCommonIntent", 2, String.format("cmd :%s, success:%b,code:%d", new Object[] { ((QZoneCommonRequest)localObject).getCmdString(), Boolean.valueOf(QzoneCommonIntent.succeeded(arrayOfInt[0])), Integer.valueOf(arrayOfInt[0]) }));
      }
      localObject = new Bundle();
      ((Bundle)localObject).putSerializable("key_response", paramFromServiceMsg);
      ((Bundle)localObject).putInt("key_response_code", arrayOfInt[0]);
      if (paramQzoneCommonIntent.getObserver() == null) {
        QLog.e("QzoneCommonIntent", 1, "observer ==null,无法回调，请检查是否有调用setObserver");
      }
      if ((paramFromServiceMsg == null) || (!QzoneCommonIntent.succeeded(arrayOfInt[0]))) {
        break label185;
      }
    }
    for (;;)
    {
      paramMSFServlet.notifyObserver(paramQzoneCommonIntent, i, bool, (Bundle)localObject, null);
      return;
      paramFromServiceMsg = ProtocolUtils.a(paramFromServiceMsg.getWupBuffer(), str, arrayOfInt);
      break;
      label185:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acdb
 * JD-Core Version:    0.7.0.1
 */