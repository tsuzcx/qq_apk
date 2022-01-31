import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;

class adkp
  implements ViewTreeObserver.OnPreDrawListener
{
  adkp(adko paramadko, TextView paramTextView, String paramString) {}
  
  private String a(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  public boolean onPreDraw()
  {
    int j = 0;
    int k = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() * 2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
    String str2 = a(this.jdField_a_of_type_Adko.a.getString(2131697475) + ">");
    String str3 = a(this.jdField_a_of_type_JavaLangString);
    String str1 = "  " + str2;
    Object localObject = str3 + str1;
    if (localTextPaint.measureText((String)localObject + "      ") < k) {}
    label329:
    for (;;)
    {
      k = ((String)localObject).length();
      int i = j;
      if (k > str2.length()) {
        i = k - str2.length();
      }
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-12541697), i, k, 33);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return true;
      String str4 = "..." + str1;
      int m = str3.length();
      i = 0;
      for (;;)
      {
        if (i >= m) {
          break label329;
        }
        str1 = str3.substring(0, m - i) + str4;
        localObject = str1;
        if (localTextPaint.measureText(str1 + "      ") < k) {
          break;
        }
        i += 1;
        localObject = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkp
 * JD-Core Version:    0.7.0.1
 */