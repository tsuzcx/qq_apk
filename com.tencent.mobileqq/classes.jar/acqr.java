import android.content.ContentValues;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;

public class acqr
  implements Runnable
{
  public acqr(FileManagerProxy paramFileManagerProxy, ContentValues paramContentValues, long paramLong) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.a(FileManagerEntity.tableName(), this.jdField_a_of_type_AndroidContentContentValues, "nSessionId=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) }, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqr
 * JD-Core Version:    0.7.0.1
 */