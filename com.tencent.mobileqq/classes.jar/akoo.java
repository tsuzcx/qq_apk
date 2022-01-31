import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class akoo
  extends bead
{
  WeakReference<QQAppInterface> a;
  WeakReference<akon> b;
  
  public akoo(QQAppInterface paramQQAppInterface, akon paramakon)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramakon);
  }
  
  public void onDone(beae parambeae)
  {
    Object localObject = (QQAppInterface)this.a.get();
    akon localakon = (akon)this.b.get();
    if ((localObject == null) || (localakon == null) || (parambeae == null) || (parambeae.a() == null) || (parambeae.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambeae.f), ", status: ", Integer.valueOf(parambeae.a()), ",task.currUrl:", parambeae.c });
    }
    if (parambeae.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambeae.c + "_lastModifiedTime", parambeae.i);
      long l2 = 0L;
      File localFile = (File)parambeae.jdField_a_of_type_JavaUtilMap.get(parambeae.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambeae.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambeae.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localakon.a(parambeae.jdField_a_of_type_Int, parambeae.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoo
 * JD-Core Version:    0.7.0.1
 */