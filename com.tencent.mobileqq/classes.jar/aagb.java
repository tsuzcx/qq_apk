import com.tencent.mobileqq.arcard.ARCardUtils;
import com.tencent.mobileqq.arcard.ARRelationShipFileUpload;
import com.tencent.mobileqq.arcard.ARRelationShipFileUpload.ARRelationShipReqInfo;
import com.tencent.mobileqq.arcard.ARVideoPreviewActivity;
import java.io.File;

public class aagb
  implements Runnable
{
  public aagb(ARVideoPreviewActivity paramARVideoPreviewActivity) {}
  
  public void run()
  {
    Object localObject1 = "";
    if (this.a.jdField_a_of_type_Int == 1)
    {
      localObject1 = new File(ARCardUtils.jdField_b_of_type_JavaLangString);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdir();
      }
      localObject1 = ARCardUtils.jdField_b_of_type_JavaLangString + System.currentTimeMillis() + ".jpg";
      ARCardUtils.a(ARVideoPreviewActivity.a(this.a), (String)localObject1);
    }
    for (;;)
    {
      Object localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        this.a.jdField_b_of_type_Long = ((File)localObject2).length();
      }
      localObject2 = new File(ARVideoPreviewActivity.a(this.a));
      if (((File)localObject2).exists()) {
        this.a.d = ((File)localObject2).length();
      }
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_b_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_Long = 0L;
      this.a.c = 0L;
      localObject2 = new ARRelationShipFileUpload.ARRelationShipReqInfo();
      ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2).jdField_a_of_type_Int = 2;
      ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2).jdField_b_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a();
      ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2).jdField_a_of_type_JavaLangString = ARVideoPreviewActivity.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2, new aagc(this));
      localObject2 = new ARRelationShipFileUpload.ARRelationShipReqInfo();
      ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2).jdField_a_of_type_Int = 1;
      ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2).jdField_b_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a();
      ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      this.a.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject2, new aage(this));
      return;
      if (this.a.jdField_a_of_type_Int == 2) {
        localObject1 = ARVideoPreviewActivity.b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aagb
 * JD-Core Version:    0.7.0.1
 */