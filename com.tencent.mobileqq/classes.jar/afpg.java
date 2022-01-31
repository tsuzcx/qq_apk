import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class afpg
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  afpg(afnq paramafnq, QQAppInterface paramQQAppInterface, Context paramContext)
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
      if (!bdin.d((Context)localObject))
      {
        QQToast.a((Context)localObject, 2131692398, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298914));
        return;
      }
      l = System.currentTimeMillis();
      if ((afnq.a(this.jdField_a_of_type_Afnq) == 0L) || (l <= afnq.a(this.jdField_a_of_type_Afnq)) || (l - afnq.a(this.jdField_a_of_type_Afnq) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    afnq.a(this.jdField_a_of_type_Afnq, l);
    if (bdin.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bfoh.b, "100868074");
      localBundle.putString(bfoh.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bfoh.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bfoh.k, 2);
      localBundle.putString(bfoh.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bfoh.l, alud.a(2131705717));
      localBundle.putBoolean(bfoh.x, false);
      bfod.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      azqs.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bdib.a(paramView, (Context)localObject, "qapp://detail?param=" + afnq.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bdhk)localObject).c();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpg
 * JD-Core Version:    0.7.0.1
 */