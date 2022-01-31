import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

public class aifw
  extends batl
{
  WeakReference<QQAppInterface> a;
  WeakReference<aifv> b;
  
  public aifw(QQAppInterface paramQQAppInterface, aifv paramaifv)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaifv);
  }
  
  public void onDone(batm parambatm)
  {
    Object localObject = (QQAppInterface)this.a.get();
    aifv localaifv = (aifv)this.b.get();
    if ((localObject == null) || (localaifv == null) || (parambatm == null) || (parambatm.a() == null) || (parambatm.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(parambatm.f), ", status: ", Integer.valueOf(parambatm.a()), ",task.currUrl:", parambatm.c });
    }
    if (parambatm.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(parambatm.c + "_lastModifiedTime", parambatm.i);
      long l2 = 0L;
      File localFile = (File)parambatm.jdField_a_of_type_JavaUtilMap.get(parambatm.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(parambatm.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(parambatm.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localaifv.a(parambatm.jdField_a_of_type_Int, parambatm.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aifw
 * JD-Core Version:    0.7.0.1
 */