import com.tencent.mobileqq.armap.test.ARWebTestActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class aboq
  implements Runnable
{
  public aboq(ARWebTestActivity paramARWebTestActivity) {}
  
  public void run()
  {
    QQToast.a(BaseApplication.getContext(), "onMapLoadFinished", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aboq
 * JD-Core Version:    0.7.0.1
 */