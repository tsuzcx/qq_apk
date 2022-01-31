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

class adhm
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  adhm(adfw paramadfw, QQAppInterface paramQQAppInterface, Context paramContext)
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
      if (!badq.d((Context)localObject))
      {
        bbmy.a((Context)localObject, 2131626719, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131167766));
        return;
      }
      l = System.currentTimeMillis();
      if ((adfw.a(this.jdField_a_of_type_Adfw) == 0L) || (l <= adfw.a(this.jdField_a_of_type_Adfw)) || (l - adfw.a(this.jdField_a_of_type_Adfw) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    adfw.a(this.jdField_a_of_type_Adfw, l);
    if (badq.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bcgl.b, "100868074");
      localBundle.putString(bcgl.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bcgl.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bcgl.k, 2);
      localBundle.putString(bcgl.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bcgl.l, ajjy.a(2131639537));
      localBundle.putBoolean(bcgl.x, false);
      bcgh.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      awqx.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bade.a(paramView, (Context)localObject, "qapp://detail?param=" + adfw.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bacn)localObject).c();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhm
 * JD-Core Version:    0.7.0.1
 */