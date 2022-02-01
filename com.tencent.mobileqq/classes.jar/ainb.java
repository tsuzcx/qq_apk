import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class ainb
  extends axwp
{
  ainb(aimx paramaimx) {}
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 4, "onAutoInput, [" + paramString1 + "," + paramString2 + "," + paramObject + "," + System.currentTimeMillis() + "]");
    }
    if (!"tag_nearby_chat".equals(paramString1)) {}
    while ((TextUtils.isEmpty(paramString2)) || (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx == null)) {
      return;
    }
    this.a.aB();
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramString2);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.selectAll();
    this.a.g = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainb
 * JD-Core Version:    0.7.0.1
 */