import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class akvc
  extends akvj
{
  private ahcr jdField_a_of_type_Ahcr;
  private bdfq jdField_a_of_type_Bdfq;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  int a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    return 0;
  }
  
  public String a()
  {
    return "Dialog";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = null;
    }
    if (this.jdField_a_of_type_Ahcr != null)
    {
      this.jdField_a_of_type_Ahcr.dismiss();
      this.jdField_a_of_type_Ahcr = null;
    }
  }
  
  public void a(akvk paramakvk)
  {
    if (this.jdField_a_of_type_Ahcr != null)
    {
      this.jdField_a_of_type_Ahcr.hide();
      if (paramakvk != null) {
        paramakvk.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, akvk paramakvk)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null)
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = 1500;
      }
      j = i;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        j = i;
        if (localContext != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(localContext, paramString, i);
          j = i;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null)
    {
      if (j <= 2000) {}
      for (paramInt = 0;; paramInt = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
        if (paramakvk != null) {
          paramakvk.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, akvk paramakvk)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Ahcr == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Ahcr = new ahcr((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Ahcr != null)
    {
      if (this.jdField_a_of_type_Ahcr.isShowing()) {
        this.jdField_a_of_type_Ahcr.hide();
      }
      localObject = this.jdField_a_of_type_Ahcr.a(2131370763);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Ahcr.setOnKeyListener(new akvd(this, paramakvk));
      this.jdField_a_of_type_Ahcr.show();
      if (paramakvk != null) {
        paramakvk.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, akvk paramakvk)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramakvk, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramakvk != null) {
        paramakvk.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdfq != null) {
      this.jdField_a_of_type_Bdfq.hide();
    }
  }
  
  public void b(akvk paramakvk)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
      if (paramakvk != null) {
        paramakvk.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, akvk paramakvk)
  {
    if ((this.jdField_a_of_type_Bdfq == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_Bdfq = bdcd.a(localContext, 230, paramString1, paramString2, new akve(this, paramakvk), new akvf(this, paramakvk));
      }
    }
    if (this.jdField_a_of_type_Bdfq != null)
    {
      if (this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.hide();
      }
      this.jdField_a_of_type_Bdfq.setOnKeyListener(new akvg(this, paramakvk));
      this.jdField_a_of_type_Bdfq.setTitle(paramString1);
      this.jdField_a_of_type_Bdfq.setMessage(paramString2);
      this.jdField_a_of_type_Bdfq.show();
      if (paramakvk != null) {
        paramakvk.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvc
 * JD-Core Version:    0.7.0.1
 */