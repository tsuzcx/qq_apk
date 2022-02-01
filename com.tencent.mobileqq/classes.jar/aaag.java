import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class aaag
  implements bdvw
{
  public aaag(SubscribeUtils.1 param1) {}
  
  public void onResp(bdwt parambdwt)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + parambdwt.c);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      nmk.a(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      bgmg.a(this.a.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception parambdwt)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambdwt);
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaag
 * JD-Core Version:    0.7.0.1
 */