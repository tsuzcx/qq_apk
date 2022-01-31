import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahsg
  implements Runnable
{
  public ahsg(DCShortVideo paramDCShortVideo, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new ahsm();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (ahsl)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((ahsm)localObject).f + ",uinType = " + ((ahsm)localObject).b + ",groupMemCount = " + ((ahsm)localObject).c + ",age = " + ((ahsm)localObject).d + ",gender = " + ((ahsm)localObject).e + ",reprotHour = " + ((ahsm)localObject).g + ",netType = " + ((ahsm)localObject).h);
    }
    localObject = new ahsr("ShortVideo.Save", ((ahsm)localObject).a("ShortVideo.Save"));
    DataReport.a().a((ahsr)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahsg
 * JD-Core Version:    0.7.0.1
 */