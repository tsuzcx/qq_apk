import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class adxl
  implements ActionSheet.OnButtonClickListener
{
  adxl(adxi paramadxi, View paramView, ActionSheet paramActionSheet) {}
  
  private void a()
  {
    ReportController.b(this.jdField_a_of_type_Adxi.a.app, "CliOper", "", "", "0X800682D", "0X800682D", 0, 0, "", "", "", "");
    long l = 0L;
    for (;;)
    {
      try
      {
        localObject = new URL("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject;
        QLog.e("MusicPlayerActivity", 1, "music player activity url io MalformedURLException ", localMalformedURLException);
        continue;
        int i = -1;
        continue;
      }
      try
      {
        i = ((URL)localObject).openConnection().getContentLength();
        l = i;
      }
      catch (IOException localIOException)
      {
        QLog.e("MusicPlayerActivity", 1, "music player activity url IOException ", localIOException);
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putLong("_filesize_from_dlg", l);
    ((Bundle)localObject).putString("_filename_from_dlg", this.jdField_a_of_type_Adxi.a.getResources().getString(2131435090));
    UniformDownloadMgr.a().b("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435", (Bundle)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof Integer))
    {
      i = ((Integer)localObject).intValue();
      Message.obtain(MusicPlayerActivity.a(this.jdField_a_of_type_Adxi.a), 54, 2131438462, i, this.jdField_a_of_type_AndroidViewView).sendToTarget();
      return;
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (!UniformDownloadMgr.a().a("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435")) {
        ThreadManager.post(new adxm(this), 5, null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adxl
 * JD-Core Version:    0.7.0.1
 */