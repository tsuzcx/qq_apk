import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ar.arengine.SearchQuestionResult;
import com.tencent.mobileqq.ocr.question.SearchQuestionFragment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

public class agcy
  implements ARCloudFileUpload.ARCloudFileUploadCallback
{
  public agcy(SearchQuestionFragment paramSearchQuestionFragment, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void a(int paramInt, String paramString, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "retCode:" + paramInt + "sessionId:" + paramString + ",recogResult:" + paramARCloudRecogResult);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrQuestionSearchQuestionFragment.c)) && (this.jdField_a_of_type_ComTencentMobileqqOcrQuestionSearchQuestionFragment.c.equals(paramString)))
    {
      if ((paramInt != 0) || (paramARCloudRecogResult == null)) {
        break label205;
      }
      paramString = paramARCloudRecogResult.a;
      if (paramString != null)
      {
        paramString = paramString.c;
        paramARCloudRecogResult = new Message();
        paramARCloudRecogResult.obj = paramString;
        paramARCloudRecogResult.what = 5;
        this.jdField_a_of_type_ComTencentMobileqqOcrQuestionSearchQuestionFragment.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramARCloudRecogResult);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.jdField_a_of_type_JavaLangString))) {}
      try
      {
        if (new File(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.jdField_a_of_type_JavaLangString).getParent().equals(SearchQuestionFragment.jdField_a_of_type_JavaLangString)) {
          FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.jdField_a_of_type_JavaLangString);
        }
        return;
      }
      catch (Exception paramString)
      {
        label205:
        paramString.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrQuestionSearchQuestionFragment.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcy
 * JD-Core Version:    0.7.0.1
 */