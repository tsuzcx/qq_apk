import android.text.TextUtils;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity.OcrResultCache;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

class agcr
  implements Runnable
{
  agcr(agcq paramagcq, String paramString, int paramInt, OcrRecogResult paramOcrRecogResult, long paramLong) {}
  
  public void run()
  {
    if ((!ScanOcrActivity.a(this.jdField_a_of_type_Agcq.a)) || (TextUtils.isEmpty(ScanOcrActivity.b(this.jdField_a_of_type_Agcq.a))) || (!ScanOcrActivity.b(this.jdField_a_of_type_Agcq.a).equals(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("Q.ocr.ScanOcrActivity", 1, "OcrCallback onResult is not In recog, mRecogPicPath:" + ScanOcrActivity.b(this.jdField_a_of_type_Agcq.a) + " ,imagePath:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!ScanOcrActivity.b(this.jdField_a_of_type_Agcq.a))
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Agcq.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    ScanOcrActivity.a(this.jdField_a_of_type_Agcq.a, new ScanOcrActivity.OcrResultCache());
    ScanOcrActivity.a(this.jdField_a_of_type_Agcq.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    ScanOcrActivity.a(this.jdField_a_of_type_Agcq.a).jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult;
    ScanOcrActivity.a(this.jdField_a_of_type_Agcq.a).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ScanOcrActivity.a(this.jdField_a_of_type_Agcq.a).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcr
 * JD-Core Version:    0.7.0.1
 */