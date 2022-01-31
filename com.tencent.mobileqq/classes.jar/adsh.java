import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class adsh
  implements Runnable
{
  adsh(adsg paramadsg) {}
  
  public void run()
  {
    if (NetworkUtil.a(BaseApplication.getContext()) != 0) {
      QQToast.a(this.a.a.a.getApp(), 2, 2131435105, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adsh
 * JD-Core Version:    0.7.0.1
 */