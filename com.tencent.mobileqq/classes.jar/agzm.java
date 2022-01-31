import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class agzm
  implements Runnable
{
  public agzm(DCShortVideo paramDCShortVideo, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new agzs();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (agzr)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((agzs)localObject).f + ",uinType = " + ((agzs)localObject).b + ",groupMemCount = " + ((agzs)localObject).c + ",age = " + ((agzs)localObject).d + ",gender = " + ((agzs)localObject).e + ",reprotHour = " + ((agzs)localObject).g + ",netType = " + ((agzs)localObject).h);
    }
    localObject = new agzx("ShortVideo.Save", ((agzs)localObject).a("ShortVideo.Save"));
    DataReport.a().a((agzx)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzm
 * JD-Core Version:    0.7.0.1
 */