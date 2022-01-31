import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahnm
  implements Runnable
{
  public ahnm(DCShortVideo paramDCShortVideo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new ahns();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (ahnt)localObject);
    ((ahns)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((ahns)localObject).f + ",uinType = " + ((ahns)localObject).b + ",groupMemCount = " + ((ahns)localObject).c + ",age = " + ((ahns)localObject).d + ",gender = " + ((ahns)localObject).e + ",reprotHour = " + ((ahns)localObject).g + ",netType = " + ((ahns)localObject).h + ",playAction = " + ((ahns)localObject).jdField_a_of_type_Int);
    }
    localObject = new ahnz("ShortVideo.Preview", ((ahns)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((ahnz)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnm
 * JD-Core Version:    0.7.0.1
 */