import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;

public class aart
  implements bcsc
{
  public aart(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    aasw localaasw = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aasw != null)
      {
        this.a.jdField_a_of_type_Aasw.b();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_Aasw.a());
      }
      if (localaasw == null) {
        break;
      }
      localaasw.h_(ChatHistoryFileActivity.a(this.a));
      localaasw.a();
      this.a.jdField_a_of_type_Aasw = localaasw;
      this.a.jdField_a_of_type_Aasw.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Aasw.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label326;
      }
      this.a.jdField_a_of_type_Aasw.d();
      return;
      localaasw = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localaasw = ChatHistoryFileActivity.a(this.a, 4);
      continue;
      localaasw = ChatHistoryFileActivity.a(this.a, 1);
      axqy.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localaasw = ChatHistoryFileActivity.a(this.a, 2);
      axqy.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localaasw = ChatHistoryFileActivity.a(this.a, 3);
      axqy.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.a.jdField_a_of_type_Aasw.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aart
 * JD-Core Version:    0.7.0.1
 */