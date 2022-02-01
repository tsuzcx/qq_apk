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

class agcf
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  agcf(agap paramagap, QQAppInterface paramQQAppInterface, Context paramContext)
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
        QQToast.a((Context)localObject, 2131692035, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131299076));
        return;
      }
      l = System.currentTimeMillis();
      if ((agap.a(this.jdField_a_of_type_Agap) == 0L) || (l <= agap.a(this.jdField_a_of_type_Agap)) || (l - agap.a(this.jdField_a_of_type_Agap) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    agap.a(this.jdField_a_of_type_Agap, l);
    if (NetworkUtil.isWifiConnected((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(bibw.b, "100868074");
      localBundle.putString(bibw.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(bibw.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(bibw.k, 2);
      localBundle.putString(bibw.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(bibw.l, amtj.a(2131704454));
      localBundle.putBoolean(bibw.x, false);
      bibs.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      bcef.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = bfwg.a(paramView, (Context)localObject, "qapp://detail?param=" + agap.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((bfvp)localObject).a();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcf
 * JD-Core Version:    0.7.0.1
 */