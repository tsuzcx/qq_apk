import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringBigInsertPage.4.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class ahgr
  implements ahbt
{
  ahgr(ahgn paramahgn) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpringBigInsertPage", 2, "onResult: " + paramInt + ", path: " + paramPathResult.filePath);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.filePath))) {
      ahgn.a(this.a).a().runOnUiThread(new SpringBigInsertPage.4.1(this, paramPathResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgr
 * JD-Core Version:    0.7.0.1
 */