import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class ahkm
  extends ahkn
{
  ahkm(ahkj paramahkj) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeShortVideoItemBuilder", 2, "get video download finish,vid=" + paramString1);
    }
    if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {}
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TribeShortVideoItemBuilder", 2, "Download video failed,vid=" + paramString1);
    }
    this.jdField_a_of_type_Ahkj.a(this.jdField_a_of_type_Ahko, this.jdField_a_of_type_Long);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TribeShortVideoItemBuilder", 2, "Download video onPause,vid=" + paramString1);
    }
    this.jdField_a_of_type_Ahkj.a(this.jdField_a_of_type_Ahko, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkm
 * JD-Core Version:    0.7.0.1
 */