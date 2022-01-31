import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adsm
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  adsm(adqw paramadqw, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (Context)this.b.get();
    if ((paramView == null) || (localObject == null)) {}
    long l;
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof Activity));
      if (!bbfj.d((Context)localObject))
      {
        bcql.a((Context)localObject, 2131692321, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298865));
        return;
      }
      l = System.currentTimeMillis();
      if ((adqw.a(this.jdField_a_of_type_Adqw) == 0L) || (l <= adqw.a(this.jdField_a_of_type_Adqw)) || (l - adqw.a(this.jdField_a_of_type_Adqw) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    adqw.a(this.jdField_a_of_type_Adqw, l);
    if (bbfj.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bdlb.b, "100868074");
      localBundle.putString(bdlb.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bdlb.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bdlb.k, 2);
      localBundle.putString(bdlb.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bdlb.l, ajya.a(2131705333));
      localBundle.putBoolean(bdlb.x, false);
      bdkx.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      axqy.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bbex.a(paramView, (Context)localObject, "qapp://detail?param=" + adqw.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bbeg)localObject).c();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsm
 * JD-Core Version:    0.7.0.1
 */