import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class acdp
  extends akhb
{
  public acdp(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void b(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramayay != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + paramayay.jdField_b_of_type_JavaLangString + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject2;
    if (paramBoolean)
    {
      this.a.c(this.a.getString(2131719857));
      ayap.a(this.a.app);
      this.a.getActivity().setTitle("");
      this.a.finish();
      if ((QLog.isColorLevel()) && (paramayay != null))
      {
        localObject2 = new StringBuilder().append("onBindSubAccount:");
        if (!paramBoolean) {
          break label873;
        }
      }
    }
    label873:
    for (Object localObject1 = "..success";; localObject1 = "...failed..")
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1 + " ...errorMsg = " + paramayay.jdField_a_of_type_JavaLangString + "...errorType = " + paramayay.jdField_a_of_type_Int);
      do
      {
        return;
      } while (paramayay == null);
      switch (paramayay.jdField_a_of_type_Int)
      {
      default: 
        localObject2 = this.a.getString(2131719846);
        localObject1 = localObject2;
        if (paramayay != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            localObject1 = paramayay.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        break;
      case 1002: 
        ayaq.a(this.a.app, this.a);
        break;
      case 1003: 
        this.a.b(this.a.getString(2131719847));
        break;
      case 1004: 
        switch (paramayay.jdField_b_of_type_Int)
        {
        default: 
          localObject2 = paramayay.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131719846);
          }
          this.a.b((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131719896);
          localObject2 = this.a.getString(2131719849);
          this.a.a((String)localObject1, (String)localObject2, new acdq(this, paramayay));
          break;
        case 1218: 
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131718875);
          this.a.b((String)localObject1);
          break;
        case 1232: 
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131719850);
          this.a.b((String)localObject1);
          break;
        case 1233: 
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131719840);
          this.a.b((String)localObject1);
          break;
        case 1240: 
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131719853);
          this.a.b((String)localObject1);
          break;
        case 1241: 
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131719839);
          this.a.b((String)localObject1);
          break;
        case 1242: 
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131719855);
          this.a.b((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131719846);
        localObject1 = localObject2;
        if (paramayay != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramayay.jdField_a_of_type_JavaLangString)) {
            localObject1 = paramayay.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", paramayay.c);
        ((Intent)localObject1).putExtra("fromWhere", this.a.jdField_b_of_type_JavaLangString);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdp
 * JD-Core Version:    0.7.0.1
 */