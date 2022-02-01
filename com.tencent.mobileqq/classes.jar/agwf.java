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

class agwf
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  agwf(agup paramagup, QQAppInterface paramQQAppInterface, Context paramContext)
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
      if (!bgnt.d((Context)localObject))
      {
        QQToast.a((Context)localObject, 2131691985, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298998));
        return;
      }
      l = System.currentTimeMillis();
      if ((agup.a(this.jdField_a_of_type_Agup) == 0L) || (l <= agup.a(this.jdField_a_of_type_Agup)) || (l - agup.a(this.jdField_a_of_type_Agup) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    agup.a(this.jdField_a_of_type_Agup, l);
    if (bgnt.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bivp.b, "100868074");
      localBundle.putString(bivp.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bivp.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bivp.k, 2);
      localBundle.putString(bivp.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bivp.l, anni.a(2131704118));
      localBundle.putBoolean(bivp.x, false);
      bivl.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      bcst.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bgng.a(paramView, (Context)localObject, "qapp://detail?param=" + agup.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bgmp)localObject).a();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwf
 * JD-Core Version:    0.7.0.1
 */