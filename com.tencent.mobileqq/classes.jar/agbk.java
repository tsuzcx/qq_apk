import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OcrCamera;
import com.tencent.mobileqq.widget.QQToast;

public class agbk
  implements Runnable
{
  public agbk(OcrCamera paramOcrCamera) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "开始选图", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbk
 * JD-Core Version:    0.7.0.1
 */