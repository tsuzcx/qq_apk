import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class adhn
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  adhn(adfw paramadfw, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Context localContext = (Context)this.b.get();
    if ((paramView == null) || (localContext == null)) {}
    while (!(localContext instanceof Activity)) {
      return;
    }
    if (!badq.d(localContext))
    {
      bbmy.a(localContext, 2131626719, 0).b(localContext.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    Intent localIntent = new Intent(localContext, QQSpecialCareSettingActivity.class);
    localIntent.putExtra("key_friend_uin", this.jdField_a_of_type_Adfw.a.a);
    localContext.startActivity(localIntent);
    bajr.a(paramView, "Vip_SpecialRemind", "0X8005057", "0X8005057", 0, 1, new String[0]);
  }
  
  public void updateDrawState(TextPaint paramTextPaint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhn
 * JD-Core Version:    0.7.0.1
 */