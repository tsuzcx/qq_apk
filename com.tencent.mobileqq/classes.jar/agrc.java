import android.text.TextUtils;
import com.tencent.ark.ark.RuntimeClassCallbackWrapper;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class agrc
  implements agww, ark.RuntimeClassCallbackWrapper
{
  private agsr jdField_a_of_type_Agsr;
  private ark.VariantWrapper jdField_a_of_type_ComTencentArkArk$VariantWrapper;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public agrc(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void a(ark.VariantWrapper paramVariantWrapper)
  {
    if (this.jdField_a_of_type_ComTencentArkArk$VariantWrapper != null)
    {
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.Reset();
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = null;
    }
    if (paramVariantWrapper != null) {
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = paramVariantWrapper.Copy();
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Agsr != null)
    {
      this.jdField_a_of_type_Agsr.a(null);
      this.jdField_a_of_type_Agsr.a();
      this.jdField_a_of_type_Agsr = null;
    }
  }
  
  public boolean Destruct()
  {
    b();
    a(null);
    return true;
  }
  
  public boolean HasMethod(String paramString)
  {
    return (paramString.equals("Open")) || (paramString.equals("Abort")) || (paramString.equals("AttachEvent")) || (paramString.equals("DetachEvent")) || (paramString.equals("Send")) || (paramString.equals("SetTimeout")) || (paramString.equals("IsSuccess")) || (paramString.equals("GetData"));
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (paramString.equals("Open")) {
        return a(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
      if (paramString.equals("Abort")) {
        return b(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
      if (paramString.equals("AttachEvent")) {
        return c(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
      if (paramString.equals("DetachEvent")) {
        return d(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
      if (paramString.equals("Send")) {
        return e(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
      if (paramString.equals("SetTimeout")) {
        return f(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
      if (paramString.equals("IsSuccess")) {
        return g(paramArrayOfVariantWrapper, paramVariantWrapper);
      }
    } while (!paramString.equals("GetData"));
    return h(paramArrayOfVariantWrapper, paramVariantWrapper);
  }
  
  public boolean IsModule()
  {
    return false;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.indexOf("://");
    } while (i < 0);
    return paramString.substring(0, i);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agsr == null) {}
    while ((this.jdField_a_of_type_ComTencentArkArk$VariantWrapper == null) || (!this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.IsFunction())) {
      return;
    }
    this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.InvokeDefault(null, null);
  }
  
  protected boolean a(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    b();
    if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2)) {}
    for (;;)
    {
      paramVariantWrapper.SetBool(false);
      return true;
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
      if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
      {
        Object localObject = a(paramArrayOfVariantWrapper);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase("sso")))
        {
          localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {}
          for (this.jdField_a_of_type_Agsr = new ahhb((QQAppInterface)localObject, this.jdField_a_of_type_JavaLangString); this.jdField_a_of_type_Agsr.a(paramArrayOfVariantWrapper); this.jdField_a_of_type_Agsr = new agwx(this.jdField_a_of_type_JavaLangString))
          {
            paramVariantWrapper.SetBool(true);
            return true;
          }
        }
      }
    }
  }
  
  protected boolean b(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    b();
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  protected boolean c(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 3)) {}
    String str;
    do
    {
      paramVariantWrapper.SetBool(false);
      return true;
      str = paramArrayOfVariantWrapper[1].GetString();
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[2];
    } while ((TextUtils.isEmpty(str)) || (paramArrayOfVariantWrapper == null) || (!paramArrayOfVariantWrapper.IsFunction()) || (!str.equals("OnComplete")));
    a(paramArrayOfVariantWrapper);
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  protected boolean d(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2)) {}
    do
    {
      paramVariantWrapper.SetBool(false);
      return true;
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
    } while ((TextUtils.isEmpty(paramArrayOfVariantWrapper)) || (!paramArrayOfVariantWrapper.equals("OnComplete")));
    a(null);
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  protected boolean e(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((this.jdField_a_of_type_Agsr == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2)) {}
    do
    {
      paramVariantWrapper.SetBool(false);
      return true;
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
    } while (paramArrayOfVariantWrapper == null);
    if (paramArrayOfVariantWrapper.GetType() == 1) {
      paramArrayOfVariantWrapper = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Agsr.a(this);
      if (!this.jdField_a_of_type_Agsr.b(paramArrayOfVariantWrapper)) {
        break;
      }
      paramVariantWrapper.SetBool(true);
      return true;
      if (paramArrayOfVariantWrapper.GetType() == 5)
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetString();
      }
      else
      {
        if ((!paramArrayOfVariantWrapper.IsArray()) && (!paramArrayOfVariantWrapper.IsTable())) {
          break;
        }
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetTableAsJsonString();
      }
    }
  }
  
  protected boolean f(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    int j = 0;
    if ((this.jdField_a_of_type_Agsr == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2))
    {
      paramVariantWrapper.SetBool(false);
      return true;
    }
    paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
    int i;
    if (paramArrayOfVariantWrapper == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < 0) {
        i = j;
      }
      for (;;)
      {
        this.jdField_a_of_type_Agsr.a(i);
        paramVariantWrapper.SetBool(true);
        return true;
        if (paramArrayOfVariantWrapper.GetType() == 3)
        {
          i = paramArrayOfVariantWrapper.GetInt();
          break;
        }
        if (paramArrayOfVariantWrapper.GetType() != 4) {
          break label97;
        }
        i = (int)paramArrayOfVariantWrapper.GetDouble();
        break;
      }
      label97:
      i = 0;
    }
  }
  
  protected boolean g(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Agsr == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1))
    {
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (this.jdField_a_of_type_Agsr.a() == 0) {
      bool = true;
    }
    paramVariantWrapper.SetBool(bool);
    return true;
  }
  
  protected boolean h(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((this.jdField_a_of_type_Agsr == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2)) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              paramVariantWrapper.SetNull();
              return true;
            } while (this.jdField_a_of_type_Agsr.a() != 0);
            str = this.jdField_a_of_type_Agsr.a();
          } while (str == null);
          paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
        } while (TextUtils.isEmpty(paramArrayOfVariantWrapper));
        if (!paramArrayOfVariantWrapper.equals("text")) {
          break;
        }
        paramArrayOfVariantWrapper = str;
        if (str == null) {
          paramArrayOfVariantWrapper = "";
        }
      } while (!paramVariantWrapper.SetString(paramArrayOfVariantWrapper));
      return true;
    } while ((!paramArrayOfVariantWrapper.equals("json")) || (!paramVariantWrapper.SetTableAsJsonString(str)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrc
 * JD-Core Version:    0.7.0.1
 */