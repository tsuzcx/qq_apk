import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class akbm
  implements Runnable
{
  public akbm(String paramString) {}
  
  public void run()
  {
    QQToast localQQToast = QQToast.a(BaseApplicationImpl.getContext(), "debug:" + this.a, 1);
    localQQToast.a();
    localQQToast.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akbm
 * JD-Core Version:    0.7.0.1
 */