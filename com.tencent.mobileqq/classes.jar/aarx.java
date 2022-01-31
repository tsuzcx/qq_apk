import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;

public class aarx
  implements bcrn
{
  public aarx(ChatHistoryFileActivity paramChatHistoryFileActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    aata localaata = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Aata != null)
      {
        this.a.jdField_a_of_type_Aata.b();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_Aata.a());
      }
      if (localaata == null) {
        break;
      }
      localaata.h_(ChatHistoryFileActivity.a(this.a));
      localaata.a();
      this.a.jdField_a_of_type_Aata = localaata;
      this.a.jdField_a_of_type_Aata.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Aata.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label326;
      }
      this.a.jdField_a_of_type_Aata.d();
      return;
      localaata = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localaata = ChatHistoryFileActivity.a(this.a, 4);
      continue;
      localaata = ChatHistoryFileActivity.a(this.a, 1);
      axqw.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localaata = ChatHistoryFileActivity.a(this.a, 2);
      axqw.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localaata = ChatHistoryFileActivity.a(this.a, 3);
      axqw.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label326:
    this.a.jdField_a_of_type_Aata.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aarx
 * JD-Core Version:    0.7.0.1
 */