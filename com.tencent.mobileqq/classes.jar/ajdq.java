import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ajdq
  extends ajdx
{
  private affm jdField_a_of_type_Affm;
  private bbgu jdField_a_of_type_Bbgu;
  private bcql jdField_a_of_type_Bcql;
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
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    if (this.jdField_a_of_type_Bcql != null) {
      this.jdField_a_of_type_Bcql = null;
    }
    if (this.jdField_a_of_type_Affm != null)
    {
      this.jdField_a_of_type_Affm.dismiss();
      this.jdField_a_of_type_Affm = null;
    }
  }
  
  public void a(ajdy paramajdy)
  {
    if (this.jdField_a_of_type_Affm != null)
    {
      this.jdField_a_of_type_Affm.hide();
      if (paramajdy != null) {
        paramajdy.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, ajdy paramajdy)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_Bcql == null)
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
          this.jdField_a_of_type_Bcql = bcql.a(localContext, paramString, i);
          j = i;
        }
      }
    }
    if (this.jdField_a_of_type_Bcql != null)
    {
      if (j <= 2000) {}
      for (paramInt = 0;; paramInt = 1)
      {
        this.jdField_a_of_type_Bcql.d(paramInt);
        this.jdField_a_of_type_Bcql.a(paramString);
        this.jdField_a_of_type_Bcql.a();
        if (paramajdy != null) {
          paramajdy.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, ajdy paramajdy)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Affm == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Affm = new affm((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Affm != null)
    {
      if (this.jdField_a_of_type_Affm.isShowing()) {
        this.jdField_a_of_type_Affm.hide();
      }
      localObject = this.jdField_a_of_type_Affm.a(2131370457);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Affm.setOnKeyListener(new ajdr(this, paramajdy));
      this.jdField_a_of_type_Affm.show();
      if (paramajdy != null) {
        paramajdy.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ajdy paramajdy)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramajdy, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramajdy != null) {
        paramajdy.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbgu != null) {
      this.jdField_a_of_type_Bbgu.hide();
    }
  }
  
  public void b(ajdy paramajdy)
  {
    if (this.jdField_a_of_type_Bcql != null)
    {
      this.jdField_a_of_type_Bcql.d(0);
      if (paramajdy != null) {
        paramajdy.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, ajdy paramajdy)
  {
    if ((this.jdField_a_of_type_Bbgu == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_Bbgu = bbdj.a(localContext, 230, paramString1, paramString2, new ajds(this, paramajdy), new ajdt(this, paramajdy));
      }
    }
    if (this.jdField_a_of_type_Bbgu != null)
    {
      if (this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.hide();
      }
      this.jdField_a_of_type_Bbgu.setOnKeyListener(new ajdu(this, paramajdy));
      this.jdField_a_of_type_Bbgu.setTitle(paramString1);
      this.jdField_a_of_type_Bbgu.setMessage(paramString2);
      this.jdField_a_of_type_Bbgu.show();
      if (paramajdy != null) {
        paramajdy.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdq
 * JD-Core Version:    0.7.0.1
 */