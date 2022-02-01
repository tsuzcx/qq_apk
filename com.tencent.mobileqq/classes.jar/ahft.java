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

class ahft
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  ahft(ahed paramahed, QQAppInterface paramQQAppInterface, Context paramContext)
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
      if (!bhnv.d((Context)localObject))
      {
        QQToast.a((Context)localObject, 2131691989, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131299011));
        return;
      }
      l = System.currentTimeMillis();
      if ((ahed.a(this.jdField_a_of_type_Ahed) == 0L) || (l <= ahed.a(this.jdField_a_of_type_Ahed)) || (l - ahed.a(this.jdField_a_of_type_Ahed) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    ahed.a(this.jdField_a_of_type_Ahed, l);
    if (bhnv.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bjwo.b, "100868074");
      localBundle.putString(bjwo.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bjwo.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bjwo.k, 2);
      localBundle.putString(bjwo.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bjwo.l, anzj.a(2131704225));
      localBundle.putBoolean(bjwo.x, false);
      bjwk.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      bdll.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bhni.a(paramView, (Context)localObject, "qapp://detail?param=" + ahed.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bhmr)localObject).a();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahft
 * JD-Core Version:    0.7.0.1
 */