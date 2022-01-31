import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class akjz
  extends bdvu
{
  WeakReference<QQAppInterface> a;
  WeakReference<akjy> b;
  
  public akjz(QQAppInterface paramQQAppInterface, akjy paramakjy)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramakjy);
  }
  
  public void onDone(bdvv parambdvv)
  {
    Object localObject = (QQAppInterface)this.a.get();
    akjy localakjy = (akjy)this.b.get();
    if ((localObject == null) || (localakjy == null) || (parambdvv == null) || (parambdvv.a() == null) || (parambdvv.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambdvv.f), ", status: ", Integer.valueOf(parambdvv.a()), ",task.currUrl:", parambdvv.c });
    }
    if (parambdvv.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambdvv.c + "_lastModifiedTime", parambdvv.i);
      long l2 = 0L;
      File localFile = (File)parambdvv.jdField_a_of_type_JavaUtilMap.get(parambdvv.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambdvv.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambdvv.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localakjy.a(parambdvv.jdField_a_of_type_Int, parambdvv.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjz
 * JD-Core Version:    0.7.0.1
 */