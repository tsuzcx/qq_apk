import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahse
  implements Runnable
{
  public ahse(DCShortVideo paramDCShortVideo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new ahsk();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (ahsl)localObject);
    ((ahsk)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((ahsk)localObject).f + ",uinType = " + ((ahsk)localObject).b + ",groupMemCount = " + ((ahsk)localObject).c + ",age = " + ((ahsk)localObject).d + ",gender = " + ((ahsk)localObject).e + ",reprotHour = " + ((ahsk)localObject).g + ",netType = " + ((ahsk)localObject).h + ",playAction = " + ((ahsk)localObject).jdField_a_of_type_Int);
    }
    localObject = new ahsr("ShortVideo.Preview", ((ahsk)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((ahsr)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahse
 * JD-Core Version:    0.7.0.1
 */