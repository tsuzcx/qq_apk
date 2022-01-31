import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class abud
  implements Runnable
{
  abud(abuc paramabuc) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MessengerService.i(this.a.a);
    QQToast.a(localQQAppInterface.getApplication(), "哦哦~~~获取个签同步说说设置失败，检查一下网络哦！", 0).b(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131558448));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abud
 * JD-Core Version:    0.7.0.1
 */