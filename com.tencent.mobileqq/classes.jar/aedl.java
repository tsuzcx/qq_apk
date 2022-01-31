import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.PluginRecordHelper;
import com.tencent.biz.now.PluginRecordHelper.cigHelperCallback;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.intervideo.now.NowProxy.ListNameData;
import com.tencent.qphone.base.util.QLog;

public class aedl
  implements PluginRecordHelper.cigHelperCallback
{
  public aedl(NowPlugin paramNowPlugin, long paramLong, NowProxy.ListNameData paramListNameData, String paramString, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    QLog.i("XProxy|NowProxy", 1, "请求录播cgi完成 time = " + System.currentTimeMillis() + " hasRecording = " + paramBoolean + " timeconsume = " + paramLong + " last_err_code = " + this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.a());
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.a(), this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.a(), paramLong, this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentBizNowPluginRecordHelper.b());
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.jdField_a_of_type_Long, paramString, "record");
      return;
    }
    NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy$ListNameData, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedl
 * JD-Core Version:    0.7.0.1
 */