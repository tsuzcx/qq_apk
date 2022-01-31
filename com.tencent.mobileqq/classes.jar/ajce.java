import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;

public final class ajce
  extends ClickableSpan
{
  public ajce(String paramString, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    String str = URLUtil.guessUrl(this.jdField_a_of_type_JavaLangString);
    MttBrowerWrapper.a(paramView.getContext(), str, true, true, true, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajce
 * JD-Core Version:    0.7.0.1
 */