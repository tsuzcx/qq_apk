import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajya
  implements xpb
{
  long jdField_a_of_type_Long;
  ajxw jdField_a_of_type_Ajxw;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public ajya(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, ajxw paramajxw)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_Ajxw = paramajxw;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Ajxw.a(-12);
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
      this.jdField_a_of_type_Ajxw.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.b);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart() {}
  
  public void onSuccess(String paramString)
  {
    xmx.b(BaseApplication.getContext(), new File(this.b));
    bdcs.d(this.jdField_a_of_type_JavaLangString);
    ajxt.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajya
 * JD-Core Version:    0.7.0.1
 */