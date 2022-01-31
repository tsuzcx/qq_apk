import android.database.Cursor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.utils.SecurityUtile;

public class aghh
  implements Runnable
{
  public aghh(QCallProxy paramQCallProxy, String paramString) {}
  
  public void run()
  {
    Cursor localCursor = QCallProxy.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy, this.jdField_a_of_type_JavaLangString);
    if (localCursor != null)
    {
      int i = localCursor.getColumnIndex("name");
      while (localCursor.moveToNext())
      {
        String str = SecurityUtile.a(localCursor.getString(i));
        int j = QCallProxy.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy, str);
        if (j != -1) {
          QCallProxy.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy).a(this.jdField_a_of_type_JavaLangString, j, str, null, null, 2, null);
        }
      }
      localCursor.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aghh
 * JD-Core Version:    0.7.0.1
 */