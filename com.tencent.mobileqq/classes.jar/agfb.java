import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRHandler;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.ocr.OCRObserver;
import java.util.List;

public class agfb
  extends OCRObserver
{
  public agfb(OCRManager paramOCRManager) {}
  
  public void a(boolean paramBoolean, String paramString, List paramList)
  {
    paramList = this.a.a(paramList);
    OCRHandler localOCRHandler = (OCRHandler)this.a.a.a(113);
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      localOCRHandler.a(3, paramBoolean, new Object[] { Integer.valueOf(i), paramString, paramList });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfb
 * JD-Core Version:    0.7.0.1
 */