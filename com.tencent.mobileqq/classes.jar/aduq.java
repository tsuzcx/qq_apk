import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;

public class aduq
  implements bics
{
  public aduq(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    advt localadvt = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Advt != null)
      {
        this.a.jdField_a_of_type_Advt.c();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_Advt.a());
      }
      if (localadvt == null) {
        break;
      }
      localadvt.i_(ChatHistoryFileActivity.a(this.a));
      localadvt.b();
      this.a.jdField_a_of_type_Advt = localadvt;
      this.a.jdField_a_of_type_Advt.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Advt.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label326;
      }
      this.a.jdField_a_of_type_Advt.e();
      return;
      localadvt = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localadvt = ChatHistoryFileActivity.a(this.a, 4);
      continue;
      localadvt = ChatHistoryFileActivity.a(this.a, 1);
      bcst.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localadvt = ChatHistoryFileActivity.a(this.a, 2);
      bcst.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localadvt = ChatHistoryFileActivity.a(this.a, 3);
      bcst.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.a.jdField_a_of_type_Advt.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduq
 * JD-Core Version:    0.7.0.1
 */