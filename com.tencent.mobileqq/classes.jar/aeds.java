import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;

public class aeds
  implements bjdq
{
  public aeds(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    aeev localaeev = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aeev != null)
      {
        this.a.jdField_a_of_type_Aeev.c();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_Aeev.a());
      }
      if (localaeev == null) {
        break;
      }
      localaeev.i_(ChatHistoryFileActivity.a(this.a));
      localaeev.b();
      this.a.jdField_a_of_type_Aeev = localaeev;
      this.a.jdField_a_of_type_Aeev.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Aeev.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label326;
      }
      this.a.jdField_a_of_type_Aeev.e();
      return;
      localaeev = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localaeev = ChatHistoryFileActivity.a(this.a, 4);
      continue;
      localaeev = ChatHistoryFileActivity.a(this.a, 1);
      bdll.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localaeev = ChatHistoryFileActivity.a(this.a, 2);
      bdll.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localaeev = ChatHistoryFileActivity.a(this.a, 3);
      bdll.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.a.jdField_a_of_type_Aeev.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeds
 * JD-Core Version:    0.7.0.1
 */