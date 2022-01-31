import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ajds
  extends ajdz
{
  private affo jdField_a_of_type_Affo;
  private bbgg jdField_a_of_type_Bbgg;
  private bcpw jdField_a_of_type_Bcpw;
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
    if (this.jdField_a_of_type_Bbgg != null)
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      this.jdField_a_of_type_Bbgg = null;
    }
    if (this.jdField_a_of_type_Bcpw != null) {
      this.jdField_a_of_type_Bcpw = null;
    }
    if (this.jdField_a_of_type_Affo != null)
    {
      this.jdField_a_of_type_Affo.dismiss();
      this.jdField_a_of_type_Affo = null;
    }
  }
  
  public void a(ajea paramajea)
  {
    if (this.jdField_a_of_type_Affo != null)
    {
      this.jdField_a_of_type_Affo.hide();
      if (paramajea != null) {
        paramajea.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, ajea paramajea)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_Bcpw == null)
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
          this.jdField_a_of_type_Bcpw = bcpw.a(localContext, paramString, i);
          j = i;
        }
      }
    }
    if (this.jdField_a_of_type_Bcpw != null)
    {
      if (j <= 2000) {}
      for (paramInt = 0;; paramInt = 1)
      {
        this.jdField_a_of_type_Bcpw.d(paramInt);
        this.jdField_a_of_type_Bcpw.a(paramString);
        this.jdField_a_of_type_Bcpw.a();
        if (paramajea != null) {
          paramajea.a(a(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, ajea paramajea)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Affo == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.jdField_a_of_type_Affo = new affo((Context)localObject, paramString);
      }
    }
    if (this.jdField_a_of_type_Affo != null)
    {
      if (this.jdField_a_of_type_Affo.isShowing()) {
        this.jdField_a_of_type_Affo.hide();
      }
      localObject = this.jdField_a_of_type_Affo.a(2131370458);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_Affo.setOnKeyListener(new ajdt(this, paramajea));
      this.jdField_a_of_type_Affo.show();
      if (paramajea != null) {
        paramajea.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ajea paramajea)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramajea, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramajea != null) {
        paramajea.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbgg != null) {
      this.jdField_a_of_type_Bbgg.hide();
    }
  }
  
  public void b(ajea paramajea)
  {
    if (this.jdField_a_of_type_Bcpw != null)
    {
      this.jdField_a_of_type_Bcpw.d(0);
      if (paramajea != null) {
        paramajea.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, ajea paramajea)
  {
    if ((this.jdField_a_of_type_Bbgg == null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null) {
        this.jdField_a_of_type_Bbgg = bbcv.a(localContext, 230, paramString1, paramString2, new ajdu(this, paramajea), new ajdv(this, paramajea));
      }
    }
    if (this.jdField_a_of_type_Bbgg != null)
    {
      if (this.jdField_a_of_type_Bbgg.isShowing()) {
        this.jdField_a_of_type_Bbgg.hide();
      }
      this.jdField_a_of_type_Bbgg.setOnKeyListener(new ajdw(this, paramajea));
      this.jdField_a_of_type_Bbgg.setTitle(paramString1);
      this.jdField_a_of_type_Bbgg.setMessage(paramString2);
      this.jdField_a_of_type_Bbgg.show();
      if (paramajea != null) {
        paramajea.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajds
 * JD-Core Version:    0.7.0.1
 */