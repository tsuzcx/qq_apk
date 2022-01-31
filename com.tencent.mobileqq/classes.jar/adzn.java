import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adzn
  extends amdg
{
  public adzn(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void b(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambade != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + parambade.jdField_b_of_type_JavaLangString + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.e();
    Object localObject2;
    if (paramBoolean)
    {
      this.a.c(this.a.getString(2131720400));
      bact.a(this.a.app);
      this.a.getActivity().setTitle("");
      this.a.finish();
      if ((QLog.isColorLevel()) && (parambade != null))
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
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1 + " ...errorMsg = " + parambade.jdField_a_of_type_JavaLangString + "...errorType = " + parambade.jdField_a_of_type_Int);
      do
      {
        return;
      } while (parambade == null);
      switch (parambade.jdField_a_of_type_Int)
      {
      default: 
        localObject2 = this.a.getString(2131720389);
        localObject1 = localObject2;
        if (parambade != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            localObject1 = parambade.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        break;
      case 1002: 
        bacu.a(this.a.app, this.a);
        break;
      case 1003: 
        this.a.b(this.a.getString(2131720390));
        break;
      case 1004: 
        switch (parambade.jdField_b_of_type_Int)
        {
        default: 
          localObject2 = parambade.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131720389);
          }
          this.a.b((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131720440);
          localObject2 = this.a.getString(2131720392);
          this.a.a((String)localObject1, (String)localObject2, new adzo(this, parambade));
          break;
        case 1218: 
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131719363);
          this.a.b((String)localObject1);
          break;
        case 1232: 
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720393);
          this.a.b((String)localObject1);
          break;
        case 1233: 
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720383);
          this.a.b((String)localObject1);
          break;
        case 1240: 
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720396);
          this.a.b((String)localObject1);
          break;
        case 1241: 
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720382);
          this.a.b((String)localObject1);
          break;
        case 1242: 
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131720398);
          this.a.b((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131720389);
        localObject1 = localObject2;
        if (parambade != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(parambade.jdField_a_of_type_JavaLangString)) {
            localObject1 = parambade.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", parambade.c);
        ((Intent)localObject1).putExtra("fromWhere", this.a.jdField_b_of_type_JavaLangString);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzn
 * JD-Core Version:    0.7.0.1
 */