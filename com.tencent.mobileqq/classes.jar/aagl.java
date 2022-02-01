import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class aagl
  implements aagf
{
  aagl(aagg paramaagg) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (aagg.a(this.a))
    {
      aagg.b(this.a, false);
      if (aagg.a(this.a) != null) {
        aagg.a(this.a).setVisibility(0);
      }
      if (aagg.a(this.a) != null) {
        aagg.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      aagg.a(this.a, false);
      return;
      this.a.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (aagg.a(this.a) != paramInt)
    {
      aagg.a(this.a, paramInt);
      aagg.a(this.a);
      aagg.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      aagg.a(this.a).commit();
    }
    this.a.c();
    aagg.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aagl
 * JD-Core Version:    0.7.0.1
 */