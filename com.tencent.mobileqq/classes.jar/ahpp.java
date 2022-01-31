import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ahpp
{
  protected static HashMap<String, structmsg.StructMsg> a;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 82: 
    default: 
      return 0;
    case 1: 
    case 13: 
    case 22: 
    case 60: 
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i = 0 + bafj.a().a(paramQQAppInterface) + ambh.b(paramQQAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationUtils", 4, "getTroopNotificationUnreadNum:" + i);
    }
    return i;
  }
  
  public static Drawable a(bdbb parambdbb, String paramString, int paramInt)
  {
    if ((parambdbb == null) || (paramString == null) || (paramInt == -1)) {
      return null;
    }
    if (parambdbb.a()) {
      parambdbb.b();
    }
    Bitmap localBitmap2 = parambdbb.a(paramInt, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      parambdbb.a(paramString, paramInt, true);
      if (paramInt != 4) {
        break label68;
      }
    }
    label68:
    for (localBitmap1 = bdhj.f();; localBitmap1 = bdhj.a()) {
      return new BitmapDrawable(localBitmap1);
    }
  }
  
  public static final structmsg.StructMsg a(String paramString)
  {
    if ((a != null) && (a.containsKey(paramString))) {
      return (structmsg.StructMsg)a.get(paramString);
    }
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationUtils", 2, "clearAccountLoginInfoSp");
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().clear().commit();
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://qun.qq.com/qunpay/qunfee/pay.html?gc=%s&source=joingroup&_wv=1031", new Object[] { paramString }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    int i = paramQQAppInterface.getInt("share_key_pay2joinTroop_request_num", 0);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putInt("share_key_pay2joinTroop_request_num", i + 1);
    paramQQAppInterface.commit();
  }
  
  public static final void a(String paramString, structmsg.StructMsg paramStructMsg)
  {
    if (a == null) {
      a = new HashMap(3);
    }
    a.put(paramString, paramStructMsg);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
      } while (localSharedPreferences == null);
      localSharedPreferences.edit().putBoolean("isFirstLogin" + paramString, paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationUtils", 2, "setIsAccountFirstLogin uin=" + paramString + " firstLogin=" + paramBoolean);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return bool1;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
      } while (localSharedPreferences == null);
      bool2 = localSharedPreferences.getBoolean("isFirstLogin" + paramString, true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationUtils", 2, "isAccountFirstLogin uin=" + paramString + " result=" + bool2);
    return bool2;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getInt("share_key_pay2joinTroop_request_num", 0);
  }
  
  public static final void b()
  {
    if (a != null) {
      a.clear();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit();
    paramQQAppInterface.putInt("share_key_pay2joinTroop_request_num", 0);
    paramQQAppInterface.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpp
 * JD-Core Version:    0.7.0.1
 */