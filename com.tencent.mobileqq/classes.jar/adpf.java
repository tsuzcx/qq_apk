import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;

public class adpf
  implements biuc
{
  public adpf(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    adqi localadqi = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Adqi != null)
      {
        this.a.jdField_a_of_type_Adqi.c();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_Adqi.a());
      }
      if (localadqi == null) {
        break;
      }
      localadqi.j_(ChatHistoryFileActivity.a(this.a));
      localadqi.b();
      this.a.jdField_a_of_type_Adqi = localadqi;
      this.a.jdField_a_of_type_Adqi.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Adqi.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label326;
      }
      this.a.jdField_a_of_type_Adqi.e();
      return;
      localadqi = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localadqi = ChatHistoryFileActivity.a(this.a, 4);
      continue;
      localadqi = ChatHistoryFileActivity.a(this.a, 1);
      bdla.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localadqi = ChatHistoryFileActivity.a(this.a, 2);
      bdla.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localadqi = ChatHistoryFileActivity.a(this.a, 3);
      bdla.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.a.jdField_a_of_type_Adqi.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpf
 * JD-Core Version:    0.7.0.1
 */