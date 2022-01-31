import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class ajoy
  extends Handler
{
  WeakReference a;
  
  public ajoy(PublishHomeWorkFragment paramPublishHomeWorkFragment, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramPublishHomeWorkFragment);
  }
  
  void a()
  {
    PublishHomeWorkFragment localPublishHomeWorkFragment = (PublishHomeWorkFragment)this.a.get();
    if ((localPublishHomeWorkFragment == null) || ((!localPublishHomeWorkFragment.isAdded()) && (PublishHomeWorkFragment.a(localPublishHomeWorkFragment) == null))) {
      return;
    }
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(2) + 1;
    int j = ((Calendar)localObject).get(5);
    if (PublishHomeWorkFragment.e(localPublishHomeWorkFragment) == null) {
      PublishHomeWorkFragment.d(localPublishHomeWorkFragment, "");
    }
    localObject = localPublishHomeWorkFragment.getString(2131430629, new Object[] { Integer.valueOf(i), Integer.valueOf(j), PublishHomeWorkFragment.e(localPublishHomeWorkFragment) }).trim();
    String str1 = localPublishHomeWorkFragment.getString(2131430629, new Object[] { Integer.valueOf(i), Integer.valueOf(j), "" }).trim();
    String str2 = PublishHomeWorkFragment.a(localPublishHomeWorkFragment).getText().toString();
    if ((TextUtils.isEmpty(str2)) || (str1.equals(str2))) {
      PublishHomeWorkFragment.a(localPublishHomeWorkFragment).setText((CharSequence)localObject);
    }
    PublishHomeWorkFragment.e(localPublishHomeWorkFragment);
    PublishHomeWorkFragment.f(localPublishHomeWorkFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "handle msg " + paramMessage.what);
    }
    PublishHomeWorkFragment localPublishHomeWorkFragment = (PublishHomeWorkFragment)this.a.get();
    if ((localPublishHomeWorkFragment == null) || (!localPublishHomeWorkFragment.isAdded())) {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "reference null");
      }
    }
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3: 
        PublishHomeWorkFragment.f(localPublishHomeWorkFragment, true);
        PublishHomeWorkFragment.a(localPublishHomeWorkFragment).b(false);
        return;
      case 515: 
        QLog.d("PublishHomeWorkFragment", 1, "init data time out");
        PublishHomeWorkFragment.e(localPublishHomeWorkFragment, true);
        a();
        return;
      case 513: 
        a();
        return;
      case 514: 
        PublishHomeWorkFragment.f(localPublishHomeWorkFragment);
        return;
      case 101: 
        PublishHomeWorkFragment.f(localPublishHomeWorkFragment, false);
        PublishHomeWorkFragment.g(localPublishHomeWorkFragment);
        return;
      case 102: 
        int i = (int)PublishHomeWorkFragment.a(localPublishHomeWorkFragment).a();
        if (i < 1000)
        {
          QQToast.a(localPublishHomeWorkFragment.getActivity(), "录音不能小于1秒,录制失败", 0).a();
          PublishHomeWorkFragment.a(localPublishHomeWorkFragment).b();
          return;
        }
        if (!NetworkUtil.d(localPublishHomeWorkFragment.getActivity()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublishHomeWorkFragment", 2, "no network toast");
          }
          QQToast.a(localPublishHomeWorkFragment.getActivity(), 2131430301, 0).a();
          PublishHomeWorkFragment.f(localPublishHomeWorkFragment, false);
          PublishHomeWorkFragment.g(localPublishHomeWorkFragment);
          return;
        }
        paramMessage = paramMessage.obj.toString();
        File localFile = new File(paramMessage);
        if (localFile.exists()) {}
        for (long l = localFile.length();; l = 0L)
        {
          paramMessage = new AudioInfo(paramMessage, null, i / 1000, (int)l, PublishHomeWorkFragment.a(localPublishHomeWorkFragment));
          PublishHomeWorkFragment.a(localPublishHomeWorkFragment).a(paramMessage);
          PublishHomeWorkFragment.f(localPublishHomeWorkFragment, false);
          PublishHomeWorkFragment.g(localPublishHomeWorkFragment);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "parse config from network success");
      }
    } while ((PublishHomeWorkFragment.a(localPublishHomeWorkFragment)) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
    PublishHomeWorkFragment.a(localPublishHomeWorkFragment, (String)paramMessage.obj, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoy
 * JD-Core Version:    0.7.0.1
 */