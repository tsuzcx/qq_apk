import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class afhg
  implements bdbc
{
  afhg(afhd paramafhd) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    for (;;)
    {
      return;
      if (paramString.equals(this.a.jdField_a_of_type_JavaLangString)) {
        afhd.b(this.a).setImageBitmap(paramBitmap);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("intimate_relationship", 2, "onDecodeTaskCompleted, uin: " + paramString + ", type: " + paramInt2);
        return;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          afhd.a(this.a).setImageBitmap(paramBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhg
 * JD-Core Version:    0.7.0.1
 */