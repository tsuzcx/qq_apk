import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class adkb
  implements Runnable
{
  adkb(adka paramadka) {}
  
  public void run()
  {
    if (NetworkUtil.a(BaseApplication.getContext()) != 0) {
      QQToast.a(this.a.a.a.getApp(), 2, 2131435089, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adkb
 * JD-Core Version:    0.7.0.1
 */