import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class abth
  extends ajss
{
  public abth(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void b(boolean paramBoolean, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramaxau != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + paramaxau.jdField_b_of_type_JavaLangString + " subAccount=" + paramaxau.c + " errType=" + paramaxau.jdField_a_of_type_Int + " errMsg=" + paramaxau.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.c();
    Object localObject2;
    if (paramBoolean)
    {
      this.a.c(this.a.getString(2131653962));
      axal.a(this.a.app);
      this.a.getActivity().setTitle("");
      this.a.finish();
      if ((QLog.isColorLevel()) && (paramaxau != null))
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
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1 + " ...errorMsg = " + paramaxau.jdField_a_of_type_JavaLangString + "...errorType = " + paramaxau.jdField_a_of_type_Int);
      do
      {
        return;
      } while (paramaxau == null);
      switch (paramaxau.jdField_a_of_type_Int)
      {
      default: 
        localObject2 = this.a.getString(2131653951);
        localObject1 = localObject2;
        if (paramaxau != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            localObject1 = paramaxau.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        break;
      case 1002: 
        axam.a(this.a.app, this.a);
        break;
      case 1003: 
        this.a.b(this.a.getString(2131653952));
        break;
      case 1004: 
        switch (paramaxau.jdField_b_of_type_Int)
        {
        default: 
          localObject2 = paramaxau.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131653951);
          }
          this.a.b((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131654001);
          localObject2 = this.a.getString(2131653954);
          this.a.a((String)localObject1, (String)localObject2, new abti(this, paramaxau));
          break;
        case 1218: 
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131653037);
          this.a.b((String)localObject1);
          break;
        case 1232: 
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131653955);
          this.a.b((String)localObject1);
          break;
        case 1233: 
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131653945);
          this.a.b((String)localObject1);
          break;
        case 1240: 
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131653958);
          this.a.b((String)localObject1);
          break;
        case 1241: 
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131653944);
          this.a.b((String)localObject1);
          break;
        case 1242: 
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131653960);
          this.a.b((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131653951);
        localObject1 = localObject2;
        if (paramaxau != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramaxau.jdField_a_of_type_JavaLangString)) {
            localObject1 = paramaxau.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", paramaxau.c);
        ((Intent)localObject1).putExtra("fromWhere", this.a.jdField_b_of_type_JavaLangString);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abth
 * JD-Core Version:    0.7.0.1
 */