import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aguu
  extends ClickableSpan
{
  public final String a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  
  aguu(agtf paramagtf, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
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
    localObject = bhey.a(paramView, (Context)localObject, String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3", new Object[] { this.jdField_b_of_type_JavaLangString }));
    if (localObject != null) {
      ((bheh)localObject).a();
    }
    bdla.b(paramView, "CliOper", "", "", "0X80055FD", "0X80055FD", 0, 0, ayoa.a(paramView)[0], this.jdField_b_of_type_JavaLangString, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguu
 * JD-Core Version:    0.7.0.1
 */