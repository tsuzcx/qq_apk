import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.arcard.ArCardSelectMemberActivity;
import java.util.ArrayList;

public class aagq
  implements Runnable
{
  public aagq(ArCardSelectMemberActivity paramArCardSelectMemberActivity, StringBuilder paramStringBuilder, TextView paramTextView) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangStringBuilder.toString();
    if (this.jdField_a_of_type_ComTencentMobileqqArcardArCardSelectMemberActivity.a.size() != 1)
    {
      float f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str1);
      int j = this.jdField_a_of_type_AndroidWidgetTextView.getWidth();
      String str2;
      int i;
      if (f > j)
      {
        str2 = String.format("%1$s等%2$d人。", new Object[] { "...", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqArcardArCardSelectMemberActivity.a.size()) });
        i = 0;
      }
      for (;;)
      {
        if (i < str1.length())
        {
          String str3 = str1.substring(0, i) + str2;
          if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str3) > j) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(str1.substring(0, i - 1) + str2);
          }
        }
        else
        {
          return;
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aagq
 * JD-Core Version:    0.7.0.1
 */