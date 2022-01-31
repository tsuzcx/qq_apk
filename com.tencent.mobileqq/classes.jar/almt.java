import android.widget.PopupWindow.OnDismissListener;
import com.tencent.widget.KandianPopupWindow;

public class almt
  implements PopupWindow.OnDismissListener
{
  public almt(KandianPopupWindow paramKandianPopupWindow) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    KandianPopupWindow.a(this.a, 1.0F);
    com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     almt
 * JD-Core Version:    0.7.0.1
 */