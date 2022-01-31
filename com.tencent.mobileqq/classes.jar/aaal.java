import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudImageSelect;
import com.tencent.mobileqq.widget.QQToast;

public class aaal
  implements Runnable
{
  public aaal(ARCloudControl paramARCloudControl) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), String.format("选图成功 neon=%d", new Object[] { Integer.valueOf(this.a.a.c) }), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaal
 * JD-Core Version:    0.7.0.1
 */