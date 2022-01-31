import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ahno
  implements Runnable
{
  public ahno(DCShortVideo paramDCShortVideo, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new ahnu();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (ahnt)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((ahnu)localObject).f + ",uinType = " + ((ahnu)localObject).b + ",groupMemCount = " + ((ahnu)localObject).c + ",age = " + ((ahnu)localObject).d + ",gender = " + ((ahnu)localObject).e + ",reprotHour = " + ((ahnu)localObject).g + ",netType = " + ((ahnu)localObject).h);
    }
    localObject = new ahnz("ShortVideo.Save", ((ahnu)localObject).a("ShortVideo.Save"));
    DataReport.a().a((ahnz)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahno
 * JD-Core Version:    0.7.0.1
 */