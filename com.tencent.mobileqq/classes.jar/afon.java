import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult.JDSearchResult;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult.YoutuOcrResult;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

public class afon
  implements ARCloudFileUpload.ARCloudFileUploadCallback
{
  public afon(OcrControl paramOcrControl) {}
  
  public void a(int paramInt, String paramString, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "retCode:" + paramInt + ",sessionId:" + paramString + ",recogResult:" + paramARCloudRecogResult);
    }
    paramString = OcrControl.a(this.a, paramString);
    long l = 0L;
    if (paramString != null) {
      l = System.currentTimeMillis() - paramString.c;
    }
    int n = -1;
    int i1 = -1;
    int i2 = -1;
    int i3 = -1;
    int i = i1;
    int j = n;
    int k = i3;
    int m = i2;
    if (paramString != null)
    {
      i = i1;
      j = n;
      k = i3;
      m = i2;
      if (paramString.a != null)
      {
        if ((paramInt != 0) || (paramARCloudRecogResult == null) || (paramARCloudRecogResult.a == null)) {
          break label345;
        }
        paramARCloudRecogResult = paramARCloudRecogResult.a;
        OcrRecogResult localOcrRecogResult = paramARCloudRecogResult.a();
        if (OcrControl.a(this.a) != null) {
          OcrControl.a(this.a).a(0, localOcrRecogResult, paramString.a.b, l);
        }
        if ((localOcrRecogResult != null) && ((this.a.a == 1) || (this.a.a == 2))) {
          ThreadManager.postImmediately(new afoo(this, localOcrRecogResult, paramString), null, false);
        }
        if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult == null) {
          break label422;
        }
        i = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult.a;
        j = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$JDSearchResult.b;
      }
    }
    for (;;)
    {
      if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult != null)
      {
        k = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult.a;
        m = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqOcrDataARCloudOcrResult$YoutuOcrResult.b;
      }
      for (;;)
      {
        n = m;
        i1 = j;
        m = k;
        k = n;
        j = i;
        i = i1;
        for (;;)
        {
          ThreadManager.postImmediately(new afop(this, paramString), null, false);
          ThreadManager.post(new afoq(this, j, i, m, k, paramInt), 5, null, false);
          return;
          label345:
          i = i1;
          j = n;
          k = i3;
          m = i2;
          if (OcrControl.a(this.a) != null)
          {
            OcrControl.a(this.a).a(3, null, paramString.a.b, l);
            i = i1;
            j = n;
            k = i3;
            m = i2;
          }
        }
        m = -1;
        k = -1;
      }
      label422:
      j = -1;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afon
 * JD-Core Version:    0.7.0.1
 */