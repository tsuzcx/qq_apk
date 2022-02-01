import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class aloi
  extends bgod
{
  WeakReference<QQAppInterface> a;
  WeakReference<aloh> b;
  
  public aloi(QQAppInterface paramQQAppInterface, aloh paramaloh)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaloh);
  }
  
  public void onDone(bgoe parambgoe)
  {
    Object localObject = (QQAppInterface)this.a.get();
    aloh localaloh = (aloh)this.b.get();
    if ((localObject == null) || (localaloh == null) || (parambgoe == null) || (parambgoe.a() == null) || (parambgoe.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambgoe.f), ", status: ", Integer.valueOf(parambgoe.a()), ",task.currUrl:", parambgoe.c });
    }
    if (parambgoe.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambgoe.c + "_lastModifiedTime", parambgoe.i);
      long l2 = 0L;
      File localFile = (File)parambgoe.jdField_a_of_type_JavaUtilMap.get(parambgoe.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambgoe.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambgoe.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localaloh.a(parambgoe.jdField_a_of_type_Int, parambgoe.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloi
 * JD-Core Version:    0.7.0.1
 */