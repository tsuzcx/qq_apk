import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class ahio
  extends awjx
{
  ahio(ahik paramahik) {}
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.a.tag, 4, "onAutoInput, [" + paramString1 + "," + paramString2 + "," + paramObject + "," + System.currentTimeMillis() + "]");
    }
    if (!"tag_nearby_chat".equals(paramString1)) {}
    while ((TextUtils.isEmpty(paramString2)) || (this.a.input == null)) {
      return;
    }
    this.a.showInputPanel();
    this.a.input.setText(paramString2);
    this.a.input.selectAll();
    this.a.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahio
 * JD-Core Version:    0.7.0.1
 */