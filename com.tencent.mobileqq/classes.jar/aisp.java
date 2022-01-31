import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class aisp
  extends bbwf
{
  WeakReference<QQAppInterface> a;
  WeakReference<aiso> b;
  
  public aisp(QQAppInterface paramQQAppInterface, aiso paramaiso)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaiso);
  }
  
  public void onDone(bbwg parambbwg)
  {
    Object localObject = (QQAppInterface)this.a.get();
    aiso localaiso = (aiso)this.b.get();
    if ((localObject == null) || (localaiso == null) || (parambbwg == null) || (parambbwg.a() == null) || (parambbwg.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambbwg.f), ", status: ", Integer.valueOf(parambbwg.a()), ",task.currUrl:", parambbwg.c });
    }
    if (parambbwg.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambbwg.c + "_lastModifiedTime", parambbwg.i);
      long l2 = 0L;
      File localFile = (File)parambbwg.jdField_a_of_type_JavaUtilMap.get(parambbwg.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambbwg.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambbwg.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localaiso.a(parambbwg.jdField_a_of_type_Int, parambbwg.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisp
 * JD-Core Version:    0.7.0.1
 */