import android.util.SparseArray;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONObject;

public class aadg
  implements FileFilter
{
  public aadg(ApolloContentUpdateHandler paramApolloContentUpdateHandler, SparseArray paramSparseArray) {}
  
  public boolean accept(File paramFile)
  {
    Object localObject = new File(paramFile, "config.json");
    if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
      localObject = FileUtils.a((File)localObject);
    }
    try
    {
      int i = Integer.parseInt(paramFile.getName());
      long l = new JSONObject((String)localObject).optLong("version");
      this.jdField_a_of_type_AndroidUtilSparseArray.append(i, Long.valueOf(l));
      QLog.i("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo roleId: " + i + ", ver: " + l / 1000L);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo failed role: " + paramFile.getAbsolutePath());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aadg
 * JD-Core Version:    0.7.0.1
 */