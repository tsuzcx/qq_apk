import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;

public class acyt
  implements bhjm
{
  public acyt(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    aczw localaczw = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aczw != null)
      {
        this.a.jdField_a_of_type_Aczw.c();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_Aczw.a());
      }
      if (localaczw == null) {
        break;
      }
      localaczw.i_(ChatHistoryFileActivity.a(this.a));
      localaczw.b();
      this.a.jdField_a_of_type_Aczw = localaczw;
      this.a.jdField_a_of_type_Aczw.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Aczw.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label326;
      }
      this.a.jdField_a_of_type_Aczw.e();
      return;
      localaczw = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localaczw = ChatHistoryFileActivity.a(this.a, 4);
      continue;
      localaczw = ChatHistoryFileActivity.a(this.a, 1);
      bcef.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localaczw = ChatHistoryFileActivity.a(this.a, 2);
      bcef.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localaczw = ChatHistoryFileActivity.a(this.a, 3);
      bcef.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.a.jdField_a_of_type_Aczw.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyt
 * JD-Core Version:    0.7.0.1
 */