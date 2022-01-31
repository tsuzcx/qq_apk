import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class akzr
  extends akzy
{
  private ahhg jdField_a_of_type_Ahhg;
  private bdjz jdField_a_of_type_Bdjz;
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
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = null;
    }
    if (this.jdField_a_of_type_Ahhg != null)
    {
      this.jdField_a_of_type_Ahhg.dismiss();
      this.jdField_a_of_type_Ahhg = null;
    }
  }
  
  public void a(akzz paramakzz)
  {
    if (this.jdField_a_of_type_Ahhg != null)
    {
      this.jdField_a_of_type_Ahhg.hide();
      if (paramakzz != null) {
        paramakzz.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, akzz paramakzz)
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
        if (paramakzz != null) {
          paramakzz.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, akzz paramakzz)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Ahhg == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Ahhg = new ahhg((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Ahhg != null)
    {
      if (this.jdField_a_of_type_Ahhg.isShowing()) {
        this.jdField_a_of_type_Ahhg.hide();
      }
      localObject = this.jdField_a_of_type_Ahhg.a(2131370782);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Ahhg.setOnKeyListener(new akzs(this, paramakzz));
      this.jdField_a_of_type_Ahhg.show();
      if (paramakzz != null) {
        paramakzz.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, akzz paramakzz)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramakzz, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramakzz != null) {
        paramakzz.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      this.jdField_a_of_type_Bdjz.hide();
    }
  }
  
  public void b(akzz paramakzz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(0);
      if (paramakzz != null) {
        paramakzz.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, akzz paramakzz)
  {
    if ((this.jdField_a_of_type_Bdjz == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_Bdjz = bdgm.a(localContext, 230, paramString1, paramString2, new akzt(this, paramakzz), new akzu(this, paramakzz));
      }
    }
    if (this.jdField_a_of_type_Bdjz != null)
    {
      if (this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.hide();
      }
      this.jdField_a_of_type_Bdjz.setOnKeyListener(new akzv(this, paramakzz));
      this.jdField_a_of_type_Bdjz.setTitle(paramString1);
      this.jdField_a_of_type_Bdjz.setMessage(paramString2);
      this.jdField_a_of_type_Bdjz.show();
      if (paramakzz != null) {
        paramakzz.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzr
 * JD-Core Version:    0.7.0.1
 */