import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class aakm
  implements aakg
{
  aakm(aakh paramaakh) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (aakh.a(this.a))
    {
      aakh.b(this.a, false);
      if (aakh.a(this.a) != null) {
        aakh.a(this.a).setVisibility(0);
      }
      if (aakh.a(this.a) != null) {
        aakh.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      aakh.a(this.a, false);
      return;
      this.a.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (aakh.a(this.a) != paramInt)
    {
      aakh.a(this.a, paramInt);
      aakh.a(this.a);
      aakh.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      aakh.a(this.a).commit();
    }
    this.a.c();
    aakh.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakm
 * JD-Core Version:    0.7.0.1
 */