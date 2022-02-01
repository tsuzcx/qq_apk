import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class aael
  implements beuq
{
  public aael(SubscribeUtils.1 param1) {}
  
  public void onResp(bevm parambevm)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + parambevm.c);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      nof.a(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      bhmi.a(this.a.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception parambevm)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambevm);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aael
 * JD-Core Version:    0.7.0.1
 */