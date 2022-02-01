import Wallet.GetPasswordReq;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.PatternLockUtils;

public class akxp
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (PatternLockUtils.getSyncPatternLockState(paramQQAppInterface.getApp(), paramQQAppInterface.c()))
    {
      GetPasswordReq localGetPasswordReq = new GetPasswordReq();
      localGetPasswordReq.MQOS = "Android";
      localGetPasswordReq.MQVersion = bhlo.a(paramQQAppInterface.getApp());
      ((aofq)paramQQAppInterface.a(42)).a(localGetPasswordReq);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong < 1L)) {
      return;
    }
    Intent localIntent = new Intent("com.tencent.qwallet.payer.notify");
    localIntent.putExtra("sendUin", paramLong);
    localIntent.putExtra("tokenId", paramString);
    paramQQAppInterface.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxp
 * JD-Core Version:    0.7.0.1
 */