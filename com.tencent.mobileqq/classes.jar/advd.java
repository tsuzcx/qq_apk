import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.SevenZip;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.intervideo.now.NowUtil;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.intervideo.od.ODDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.XEventListener;
import java.util.Iterator;
import java.util.List;

public class advd
  implements XEventListener
{
  public advd(NowPlugin paramNowPlugin) {}
  
  public void onDataReport(String paramString, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(paramBundle);
  }
  
  public void onDownload(int paramInt, String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    if (paramInt == 3)
    {
      NowPlugin.a(this.a, paramString1, paramString2, paramHostEventListener);
      return;
    }
    new ODDownloader(NowPlugin.a(this.a)).a(paramString1, paramString2, paramHostEventListener);
  }
  
  public void onError(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString1.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a("Live", paramInt, paramString2);
      }
    }
  }
  
  public void onGetPluginActivity(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "onGetPluginActivity activity  = " + paramActivity);
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)localIterator.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a(paramActivity);
      }
    }
  }
  
  public void onLog(String paramString1, String paramString2, int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      QLog.i(paramString1, 2, paramString2);
      return;
    case 1: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 2: 
      QLog.i(paramString1, 1, paramString2);
      return;
    }
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void onPluginInstalled(String paramString)
  {
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.d("Live");
      }
    }
  }
  
  public void onPluginLoaded(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "Now插件加载完成，当前RequestCode = " + this.a.jdField_a_of_type_Int);
    }
    if (((this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int != 2)) || ((this.a.jdField_a_of_type_Int == 3) && (NowPlugin.a(this.a) != null)))
    {
      paramString = new Intent("qq.launch.login");
      paramString.putExtras(NowPlugin.a(this.a));
      paramString.putExtra("withlogin", true);
      paramString.putExtra("pluginflag", true);
      paramString.putExtra("pluginid", "Live");
      paramString.putExtra("hosttype", String.valueOf(2));
      BaseApplicationImpl.getContext().sendBroadcast(paramString);
    }
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.b("Live");
      }
    }
  }
  
  public void onPluginRun(String paramString)
  {
    StoryReportor.a("now_live", "now_plugin_run", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.b, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a });
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a("Live");
      }
    }
  }
  
  public void onProgress(String paramString, int paramInt)
  {
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a("Live", paramInt);
      }
    }
  }
  
  public void onReceivePluginMsg(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramString2.equals("login.qq.kickout")) {
      if (QLog.isColorLevel()) {
        QLog.i("XProxy|NowProxy", 2, "收到Now被踢下线的广播");
      }
    }
    for (;;)
    {
      Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)((Iterator)localObject).next();
        if (localIVPluginEvtListener != null) {
          localIVPluginEvtListener.a(paramString1, paramString2, paramBundle);
        }
      }
      if (paramString2.equals("com.tencent.now.sharetoqq"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("XProxy|NowProxy", 2, "收到分享到ＱＱ的广播");
        }
        localObject = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
        ((Intent)localObject).addFlags(268435456);
        if (paramBundle != null) {
          ((Intent)localObject).putExtras(paramBundle);
        }
        ((Intent)localObject).putExtra("uin", NowPlugin.a(this.a).c());
        if (this.a.jdField_a_of_type_AndroidOsBundle != null) {
          ((Intent)localObject).putExtras(this.a.jdField_a_of_type_AndroidOsBundle);
        }
        BaseApplicationImpl.getContext().startActivity((Intent)localObject);
      }
      else if (paramString2.equals("now.room.destroy"))
      {
        QLog.i("XProxy|NowProxy", 1, "收到Now Destroy的消息");
        this.a.b();
      }
      else if (paramString2.equals("action.now.showloading"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("XProxy|NowProxy", 2, "收到进入now房间的广播");
        }
        NowUtil.a(BaseApplicationImpl.getContext());
        this.a.b(paramBundle);
      }
      else if (paramString2.equals("action.now.roomactivity.create"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("XProxy|NowProxy", 2, "收到进入now Activity的广播");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a);
      }
      else if (paramString2.equals("action.now.datareport"))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(paramBundle);
      }
    }
  }
  
  public int onUnZipSo(String paramString1, String paramString2)
  {
    int i = 1;
    QLog.i("XProxy|NowProxy", 1, "onUnZipSo soPath  = " + paramString2);
    if (SevenZip.a(BaseApplicationImpl.getContext(), paramString1, paramString2)) {
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advd
 * JD-Core Version:    0.7.0.1
 */