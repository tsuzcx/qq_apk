import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class aisn
  extends bbwt
{
  WeakReference<QQAppInterface> a;
  WeakReference<aism> b;
  
  public aisn(QQAppInterface paramQQAppInterface, aism paramaism)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaism);
  }
  
  public void onDone(bbwu parambbwu)
  {
    Object localObject = (QQAppInterface)this.a.get();
    aism localaism = (aism)this.b.get();
    if ((localObject == null) || (localaism == null) || (parambbwu == null) || (parambbwu.a() == null) || (parambbwu.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambbwu.f), ", status: ", Integer.valueOf(parambbwu.a()), ",task.currUrl:", parambbwu.c });
    }
    if (parambbwu.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambbwu.c + "_lastModifiedTime", parambbwu.i);
      long l2 = 0L;
      File localFile = (File)parambbwu.jdField_a_of_type_JavaUtilMap.get(parambbwu.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambbwu.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambbwu.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localaism.a(parambbwu.jdField_a_of_type_Int, parambbwu.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisn
 * JD-Core Version:    0.7.0.1
 */