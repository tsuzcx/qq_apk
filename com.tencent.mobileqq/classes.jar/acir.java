import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;

public class acir
  implements berl
{
  public acir(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    acju localacju = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Acju != null)
      {
        this.a.jdField_a_of_type_Acju.c();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_Acju.a());
      }
      if (localacju == null) {
        break;
      }
      localacju.a(ChatHistoryFileActivity.a(this.a));
      localacju.b();
      this.a.jdField_a_of_type_Acju = localacju;
      this.a.jdField_a_of_type_Acju.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Acju.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label326;
      }
      this.a.jdField_a_of_type_Acju.e();
      return;
      localacju = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localacju = ChatHistoryFileActivity.a(this.a, 4);
      continue;
      localacju = ChatHistoryFileActivity.a(this.a, 1);
      azmj.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localacju = ChatHistoryFileActivity.a(this.a, 2);
      azmj.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localacju = ChatHistoryFileActivity.a(this.a, 3);
      azmj.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.a.jdField_a_of_type_Acju.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acir
 * JD-Core Version:    0.7.0.1
 */