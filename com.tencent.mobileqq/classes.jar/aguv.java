import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aguv
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  aguv(agtf paramagtf, QQAppInterface paramQQAppInterface, Context paramContext)
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
      if (!NetworkUtil.isNetSupport((Context)localObject))
      {
        QQToast.a((Context)localObject, 2131692125, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131299080));
        return;
      }
      l = System.currentTimeMillis();
      if ((agtf.a(this.jdField_a_of_type_Agtf) == 0L) || (l <= agtf.a(this.jdField_a_of_type_Agtf)) || (l - agtf.a(this.jdField_a_of_type_Agtf) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    agtf.a(this.jdField_a_of_type_Agtf, l);
    if (NetworkUtil.isWifiConnected((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bjmy.b, "100868074");
      localBundle.putString(bjmy.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bjmy.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bjmy.k, 2);
      localBundle.putString(bjmy.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bjmy.l, anvx.a(2131704805));
      localBundle.putBoolean(bjmy.x, false);
      bjmu.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      bdla.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bhey.a(paramView, (Context)localObject, "qapp://detail?param=" + agtf.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bheh)localObject).a();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguv
 * JD-Core Version:    0.7.0.1
 */