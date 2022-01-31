import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class aabr
  implements Runnable
{
  public aabr(DataLineMsgProxy paramDataLineMsgProxy, long paramLong, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_Long);
    ContentValues localContentValues = new ContentValues();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localContentValues.put("serverPath", this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
      localContentValues.put("md5", this.jdField_a_of_type_ArrayOfByte);
    }
    if (localDataLineMsgRecord != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy.jdField_a_of_type_JavaLangString, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aabr
 * JD-Core Version:    0.7.0.1
 */