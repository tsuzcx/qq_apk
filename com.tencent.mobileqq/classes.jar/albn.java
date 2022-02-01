import Wallet.AcsMsg;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.ConvertParam;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.2;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.3;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;

public class albn
{
  public static int a(String paramString)
  {
    int i = 1;
    if ((BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface)) {
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          i = 2;
        }
        return i;
      }
      catch (Throwable paramString)
      {
        QLog.e("getFileExistStatus", 1, paramString, new Object[0]);
        return 3;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 18);
    localBundle.putString("path", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtils", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      try
      {
        if (paramString.data.containsKey("res"))
        {
          i = paramString.data.getInt("res");
          return i;
        }
        return 4;
      }
      catch (Throwable paramString)
      {
        QLog.e("getFileExistStatus IPC", 1, paramString, new Object[0]);
        return 5;
      }
    }
    return 6;
  }
  
  @NonNull
  public static SoLoadInfo a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 17);
    localBundle.putBoolean("is_sync", true);
    localBundle.putSerializable("load_param", paramLoadParam);
    localBundle.putSerializable("load_item", paramLoadItem);
    paramLoadParam = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "ComIPCUtils", localBundle);
    if ((paramLoadParam != null) && (paramLoadParam.isSuccess()) && (paramLoadParam.data != null)) {
      try
      {
        paramLoadItem = (SoLoadInfo)paramLoadParam.data.getSerializable("res");
        paramLoadParam = paramLoadItem;
        if (paramLoadItem == null) {
          paramLoadParam = SoLoadInfo.sDefault;
        }
        return paramLoadParam;
      }
      catch (Throwable paramLoadParam)
      {
        QLog.e("SoLoadWidget.IPC", 1, paramLoadParam, new Object[0]);
      }
    }
    return SoLoadInfo.sDefault;
  }
  
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
    localBundle.putParcelable("receiver", akxf.a(new ComIPCUtils.2(null, paramOnUpdateListener)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
  }
  
  public static void a(LaunchParam paramLaunchParam, EIPCResultCallback paramEIPCResultCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 1);
    localBundle.putSerializable("mini_launch_param", paramLaunchParam);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem, bdgb parambdgb)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 17);
    localBundle.putBoolean("is_sync", false);
    localBundle.putSerializable("load_param", paramLoadParam);
    localBundle.putSerializable("load_item", paramLoadItem);
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, new albo(parambdgb));
  }
  
  public static void a(String paramString, akud paramakud)
  {
    if (paramakud == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 15);
    localBundle.putString("key", paramString);
    localBundle.putInt("code", paramakud.hashCode());
    localBundle.putParcelable("receiver", akxf.a(new ComIPCUtils.3(null, paramakud, paramString)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtils", localBundle, null);
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
  
  public static void b(String paramString, akud paramakud)
  {
    if (paramakud == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 16);
    localBundle.putString("key", paramString);
    localBundle.putInt("code", paramakud.hashCode());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albn
 * JD-Core Version:    0.7.0.1
 */