import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class aiqu
  extends airb
{
  private aeus jdField_a_of_type_Aeus;
  private bafb jdField_a_of_type_Bafb;
  private bbmy jdField_a_of_type_Bbmy;
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
    if (this.jdField_a_of_type_Bafb != null)
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy = null;
    }
    if (this.jdField_a_of_type_Aeus != null)
    {
      this.jdField_a_of_type_Aeus.dismiss();
      this.jdField_a_of_type_Aeus = null;
    }
  }
  
  public void a(airc paramairc)
  {
    if (this.jdField_a_of_type_Aeus != null)
    {
      this.jdField_a_of_type_Aeus.hide();
      if (paramairc != null) {
        paramairc.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, airc paramairc)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_Bbmy == null)
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
          this.jdField_a_of_type_Bbmy = bbmy.a(localContext, paramString, i);
          j = i;
        }
      }
    }
    if (this.jdField_a_of_type_Bbmy != null)
    {
      if (j <= 2000) {}
      for (paramInt = 0;; paramInt = 1)
      {
        this.jdField_a_of_type_Bbmy.d(paramInt);
        this.jdField_a_of_type_Bbmy.a(paramString);
        this.jdField_a_of_type_Bbmy.a();
        if (paramairc != null) {
          paramairc.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, airc paramairc)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Aeus == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Aeus = new aeus((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Aeus != null)
    {
      if (this.jdField_a_of_type_Aeus.isShowing()) {
        this.jdField_a_of_type_Aeus.hide();
      }
      localObject = this.jdField_a_of_type_Aeus.a(2131304797);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Aeus.setOnKeyListener(new aiqv(this, paramairc));
      this.jdField_a_of_type_Aeus.show();
      if (paramairc != null) {
        paramairc.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, airc paramairc)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramairc, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramairc != null) {
        paramairc.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.hide();
    }
  }
  
  public void b(airc paramairc)
  {
    if (this.jdField_a_of_type_Bbmy != null)
    {
      this.jdField_a_of_type_Bbmy.d(0);
      if (paramairc != null) {
        paramairc.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, airc paramairc)
  {
    if ((this.jdField_a_of_type_Bafb == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_Bafb = babr.a(localContext, 230, paramString1, paramString2, new aiqw(this, paramairc), new aiqx(this, paramairc));
      }
    }
    if (this.jdField_a_of_type_Bafb != null)
    {
      if (this.jdField_a_of_type_Bafb.isShowing()) {
        this.jdField_a_of_type_Bafb.hide();
      }
      this.jdField_a_of_type_Bafb.setOnKeyListener(new aiqy(this, paramairc));
      this.jdField_a_of_type_Bafb.setTitle(paramString1);
      this.jdField_a_of_type_Bafb.setMessage(paramString2);
      this.jdField_a_of_type_Bafb.show();
      if (paramairc != null) {
        paramairc.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiqu
 * JD-Core Version:    0.7.0.1
 */