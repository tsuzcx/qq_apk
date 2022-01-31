import Wallet.AcsMsg;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.ConvertParam;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.1;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.2;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class ahio
{
  public static String a(String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("oper_type", 0);
    ((Bundle)localObject).putString("uin", paramString);
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtils", (Bundle)localObject);
    localObject = paramString;
    if (localEIPCResult != null)
    {
      localObject = paramString;
      if (localEIPCResult.isSuccess())
      {
        localObject = paramString;
        if (localEIPCResult.data != null) {
          localObject = localEIPCResult.data.getString("res");
        }
      }
    }
    return localObject;
  }
  
  public static void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 8);
    localBundle.putInt("req_id", paramInt);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(int paramInt, MiniAppConfig paramMiniAppConfig)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 5);
    localBundle.putInt("action", paramInt);
    localBundle.putSerializable("req_param", paramMiniAppConfig);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 11);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(EmojiGifHelper.ConvertParam paramConvertParam, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 7);
    localBundle.putSerializable("req_param", paramConvertParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 4);
    localBundle.putSerializable("req_param", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(AppInfo paramAppInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 3);
    localBundle.putSerializable("req_param", paramAppInfo);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(LaunchParam paramLaunchParam, int paramInt, OnUpdateListener paramOnUpdateListener)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 2);
    localBundle.putSerializable("mini_launch_param", paramLaunchParam);
    localBundle.putInt("version", paramInt);
    localBundle.putParcelable("receiver", ahbu.a(new ComIPCUtils.1(null, paramOnUpdateListener)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(LaunchParam paramLaunchParam, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 1);
    localBundle.putSerializable("mini_launch_param", paramLaunchParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(String paramString, agzh paramagzh)
  {
    if (paramagzh == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 15);
    localBundle.putString("key", paramString);
    localBundle.putInt("code", paramagzh.hashCode());
    localBundle.putParcelable("receiver", ahbu.a(new ComIPCUtils.2(null, paramagzh, paramString)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(String paramString, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 14);
    localBundle.putString("name", paramString);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 10);
    localBundle.putBoolean("req_param", paramBoolean);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static boolean a()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("oper_type", 9);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtils", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getBoolean("res");
    }
    return false;
  }
  
  public static void b(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 12);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void b(String paramString, agzh paramagzh)
  {
    if (paramagzh == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 16);
    localBundle.putString("key", paramString);
    localBundle.putInt("code", paramagzh.hashCode());
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void c(AcsMsg paramAcsMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 13);
    localBundle.putSerializable("req_param", paramAcsMsg);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahio
 * JD-Core Version:    0.7.0.1
 */