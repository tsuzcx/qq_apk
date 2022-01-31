import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Base64;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.armap.map.ARMapPOIStarDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class abhj
  implements Runnable
{
  public abhj(ARMapPOIStarDialog paramARMapPOIStarDialog) {}
  
  public void run()
  {
    if (this.a.isShowing())
    {
      String str = new String(Base64.encode(this.a.jdField_a_of_type_JavaLangString.getBytes(), 0));
      str = URLUtil.a(this.a.d, "stid", str);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapPOIStarDialog", 2, "jumpURL=" + str + "--- busiName=" + this.a.jdField_a_of_type_JavaLangString);
      }
      Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      this.a.a();
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2131438772, 1).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abhj
 * JD-Core Version:    0.7.0.1
 */