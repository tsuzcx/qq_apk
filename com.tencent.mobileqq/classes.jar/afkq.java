import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class afkq
  extends ClickableSpan
{
  public final String a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  
  afkq(afjb paramafjb, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3";
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((paramView == null) || (localObject == null)) {}
    long l;
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof Activity));
      if (!bdee.d((Context)localObject))
      {
        QQToast.a((Context)localObject, 2131692397, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131298914));
        return;
      }
      l = System.currentTimeMillis();
      if ((afjb.a(this.jdField_a_of_type_Afjb) == 0L) || (l <= afjb.a(this.jdField_a_of_type_Afjb)) || (l - afjb.a(this.jdField_a_of_type_Afjb) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    afjb.a(this.jdField_a_of_type_Afjb, l);
    localObject = bdds.a(paramView, (Context)localObject, String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3", new Object[] { this.jdField_b_of_type_JavaLangString }));
    if (localObject != null) {
      ((bddb)localObject).c();
    }
    azmj.b(paramView, "CliOper", "", "", "0X80055FD", "0X80055FD", 0, 0, avpv.a(paramView)[0], this.jdField_b_of_type_JavaLangString, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkq
 * JD-Core Version:    0.7.0.1
 */