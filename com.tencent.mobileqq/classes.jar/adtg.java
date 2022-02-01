import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import mqq.util.WeakReference;

public class adtg
  extends ClickableSpan
{
  public String a;
  public WeakReference<NotificationActivity> a;
  
  public adtg(String paramString, WeakReference<NotificationActivity> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      paramView = (NotificationActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      paramView.startActivity(localIntent);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adtg
 * JD-Core Version:    0.7.0.1
 */