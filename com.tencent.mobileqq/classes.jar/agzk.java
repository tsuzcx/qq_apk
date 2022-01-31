import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class agzk
  implements Runnable
{
  public agzk(DCShortVideo paramDCShortVideo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new agzq();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (agzr)localObject);
    ((agzq)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((agzq)localObject).f + ",uinType = " + ((agzq)localObject).b + ",groupMemCount = " + ((agzq)localObject).c + ",age = " + ((agzq)localObject).d + ",gender = " + ((agzq)localObject).e + ",reprotHour = " + ((agzq)localObject).g + ",netType = " + ((agzq)localObject).h + ",playAction = " + ((agzq)localObject).jdField_a_of_type_Int);
    }
    localObject = new agzx("ShortVideo.Preview", ((agzq)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((agzx)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzk
 * JD-Core Version:    0.7.0.1
 */