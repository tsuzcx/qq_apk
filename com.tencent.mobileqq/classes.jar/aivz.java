import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class aivz
  extends aivy
{
  private static volatile aivz a;
  
  private aivz(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    aiwh.a().a();
  }
  
  public static aivz a()
  {
    return a(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  @Deprecated
  public static aivz a(AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_Aivz == null) {}
    try
    {
      if (jdField_a_of_type_Aivz == null) {
        jdField_a_of_type_Aivz = new aivz(paramAppRuntime);
      }
      return jdField_a_of_type_Aivz;
    }
    finally {}
  }
  
  public static ResultReceiver a(ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramResultReceiver;
  }
  
  private void a(String paramString1, Bundle paramBundle, aivs paramaivs, String paramString2)
  {
    paramBundle.putParcelable("receiver", a(new PreloadManagerProxy.1(this, null, paramaivs, paramString2)));
    if (paramString1.equals("downloadModule")) {
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadModule", paramBundle, null);
    }
    while (!paramString1.equals("downloadRes")) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadRes", paramBundle, null);
  }
  
  public void a(DownloadParam paramDownloadParam, aivw paramaivw)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {}
    do
    {
      return;
      if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("method_type", 1);
        localBundle.putSerializable("download_params", paramDownloadParam);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, new aiwb(this, paramaivw, paramDownloadParam));
        return;
      }
    } while (paramaivw == null);
    paramaivw.onResult(1, PreloadManager.PathResult.getFailRes(paramDownloadParam.url));
  }
  
  public void a(String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null) {
      return;
    }
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString);
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "getFilePathByResID", localBundle, new aiwa(this, paramResultReceiver));
      return;
    }
    paramResultReceiver.send(0, null);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, aivs paramaivs)
  {
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString1);
      localBundle.putString("config_str", paramString2);
      a("downloadModule", localBundle, paramaivs, paramString1);
    }
  }
  
  public String d(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManagerProxy", 2, "getVideoResPathByID:" + paramString + "|" + (String)localObject1);
      }
      return localObject1;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("mid", paramString);
      aiwh.a().a();
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getVideoResPathByMID", (Bundle)localObject1);
      localObject1 = localObject2;
      if (localEIPCResult != null)
      {
        localObject1 = localObject2;
        if (localEIPCResult.isSuccess()) {
          localObject1 = localEIPCResult.data.getString("path");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivz
 * JD-Core Version:    0.7.0.1
 */