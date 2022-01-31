import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OcrCamera;
import com.tencent.mobileqq.widget.QQToast;

public class agfu
  implements Runnable
{
  public agfu(OcrCamera paramOcrCamera) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "开始选图", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfu
 * JD-Core Version:    0.7.0.1
 */