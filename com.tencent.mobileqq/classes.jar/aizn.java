import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aizn
  extends BroadcastReceiver
{
  public aizn(NonMainAppListViewFaceLoader paramNonMainAppListViewFaceLoader) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetListView == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramIntent == null) || (!"com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())) || (paramIntent.getIntExtra("faceType", -1) != this.a.jdField_b_of_type_Int));
        paramContext = paramIntent.getStringArrayListExtra("uinList");
        paramIntent = paramIntent.getStringArrayListExtra("headPathList");
      } while ((paramContext == null) || (paramIntent == null));
      int j = paramContext.size();
      if (QLog.isColorLevel()) {
        QLog.d("NonMainAppListViewFaceLoader", 2, "onReceive, uinList:" + paramContext.toString() + " reqList:" + this.a.jdField_a_of_type_JavaUtilArrayList + ", headPathList = " + paramIntent.toString());
      }
      int i = 0;
      while (i < j)
      {
        String str = (String)paramContext.get(i);
        if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(str)) {
          this.a.jdField_a_of_type_JavaUtilArrayList.remove(str);
        }
        this.a.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(str, paramIntent.get(i));
        i += 1;
      }
    } while (this.a.jdField_a_of_type_Int != 0);
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aizn
 * JD-Core Version:    0.7.0.1
 */