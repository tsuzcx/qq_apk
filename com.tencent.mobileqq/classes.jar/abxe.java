import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abxe
  extends EmoticonPackageDownloadListener
{
  public abxe(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onPackageEnd resultCode = " + paramInt + ",ep = " + paramEmoticonPackage);
      }
    } while (this.a.m);
    ThreadManager.getUIHandler().post(new abxf(this, paramEmoticonPackage, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxe
 * JD-Core Version:    0.7.0.1
 */