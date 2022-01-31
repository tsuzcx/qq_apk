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

class adso
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  adso(adqy paramadqy, QQAppInterface paramQQAppInterface, Context paramContext)
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
      if (!bbev.d((Context)localObject))
      {
        bcpw.a((Context)localObject, 2131692321, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298865));
        return;
      }
      l = System.currentTimeMillis();
      if ((adqy.a(this.jdField_a_of_type_Adqy) == 0L) || (l <= adqy.a(this.jdField_a_of_type_Adqy)) || (l - adqy.a(this.jdField_a_of_type_Adqy) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    adqy.a(this.jdField_a_of_type_Adqy, l);
    if (bbev.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bdkm.b, "100868074");
      localBundle.putString(bdkm.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bdkm.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bdkm.k, 2);
      localBundle.putString(bdkm.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bdkm.l, ajyc.a(2131705322));
      localBundle.putBoolean(bdkm.x, false);
      bdki.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      axqw.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bbej.a(paramView, (Context)localObject, "qapp://detail?param=" + adqy.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bbds)localObject).c();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adso
 * JD-Core Version:    0.7.0.1
 */