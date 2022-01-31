import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aigq
  implements waj
{
  long jdField_a_of_type_Long;
  aigm jdField_a_of_type_Aigm;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public aigq(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, aigm paramaigm)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_Aigm = paramaigm;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Aigm.a(-12);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|third step fail:" + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|third step cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D + ", isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Aigm.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.b);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart() {}
  
  public void onSuccess(String paramString)
  {
    vyf.b(BaseApplication.getContext(), new File(this.b));
    bbdx.d(this.jdField_a_of_type_JavaLangString);
    aigj.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aigq
 * JD-Core Version:    0.7.0.1
 */