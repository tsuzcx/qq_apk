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
import java.util.LinkedList;
import mqq.app.AppRuntime;

public class ahbw
  extends ahbv
{
  private static volatile ahbw a;
  
  private ahbw(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    ahcf.a().a();
  }
  
  public static ahbw a()
  {
    return a(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  @Deprecated
  public static ahbw a(AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_Ahbw == null) {}
    try
    {
      if (jdField_a_of_type_Ahbw == null) {
        jdField_a_of_type_Ahbw = new ahbw(paramAppRuntime);
      }
      return jdField_a_of_type_Ahbw;
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
  
  private void a(String paramString1, Bundle paramBundle, ahbp paramahbp, String paramString2)
  {
    paramBundle.putParcelable("receiver", a(new PreloadManagerProxy.1(this, null, paramahbp, paramString2)));
    if (paramString1.equals("downloadModule")) {
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadModule", paramBundle, null);
    }
    while (!paramString1.equals("downloadRes")) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadRes", paramBundle, null);
  }
  
  public void a(DownloadParam paramDownloadParam, ahbt paramahbt)
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
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, new ahby(this, paramahbt, paramDownloadParam));
        return;
      }
    } while (paramahbt == null);
    paramahbt.onResult(1, PreloadManager.PathResult.getFailRes(paramDownloadParam.url));
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
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "getFilePathByResID", localBundle, new ahbx(this, paramResultReceiver));
      return;
    }
    paramResultReceiver.send(0, null);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, ahbp paramahbp)
  {
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString1);
      localBundle.putString("config_str", paramString2);
      a("downloadModule", localBundle, paramahbp, paramString1);
    }
  }
  
  public void a(LinkedList<DownloadParam> paramLinkedList, ahbu paramahbu)
  {
    if (paramLinkedList == null) {
      if (paramahbu != null) {
        paramahbu.a(1, null);
      }
    }
    do
    {
      return;
      if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("method_type", 3);
        localBundle.putSerializable("download_params", paramLinkedList);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, new ahbz(this, paramahbu));
        return;
      }
    } while (paramahbu == null);
    paramahbu.a(1, null);
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
      ahcf.a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbw
 * JD-Core Version:    0.7.0.1
 */