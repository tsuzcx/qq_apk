import android.os.Bundle;
import com.tencent.biz.now.CgiHelper.cigHelperCallback;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.intervideo.now.NowProxy.ListNameData;
import com.tencent.qphone.base.util.QLog;

public class advc
  implements CgiHelper.cigHelperCallback
{
  public advc(NowPlugin paramNowPlugin, long paramLong, NowProxy.ListNameData paramListNameData, NowFromData paramNowFromData, int paramInt, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.i("XProxy|NowProxy", 1, "请求录播cgi完成 time = " + System.currentTimeMillis() + " hasRecording = " + paramBoolean);
    if (paramBoolean)
    {
      NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.jdField_a_of_type_Long, paramString, "record");
      return;
    }
    NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy$ListNameData, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advc
 * JD-Core Version:    0.7.0.1
 */