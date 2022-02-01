import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afpc
  extends aoib
{
  public afpc(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void b(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + parambdxd.jdField_b_of_type_JavaLangString + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
      }
    }
    this.a.e();
    Object localObject2;
    if (paramBoolean)
    {
      this.a.c(this.a.getString(2131718409));
      bdws.a(this.a.app);
      this.a.getActivity().setTitle("");
      this.a.finish();
      if ((QLog.isColorLevel()) && (parambdxd != null))
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
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1 + " ...errorMsg = " + parambdxd.jdField_a_of_type_JavaLangString + "...errorType = " + parambdxd.jdField_a_of_type_Int);
      do
      {
        return;
      } while (parambdxd == null);
      switch (parambdxd.jdField_a_of_type_Int)
      {
      default: 
        localObject2 = this.a.getString(2131718400);
        localObject1 = localObject2;
        if (parambdxd != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            localObject1 = parambdxd.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        break;
      case 1002: 
        bdwt.a(this.a.app, this.a);
        break;
      case 1003: 
        this.a.b(this.a.getString(2131718401));
        break;
      case 1004: 
        switch (parambdxd.jdField_b_of_type_Int)
        {
        default: 
          localObject2 = parambdxd.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131718400);
          }
          this.a.b((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131718434);
          localObject2 = this.a.getString(2131718403);
          this.a.a((String)localObject1, (String)localObject2, new afpd(this, parambdxd));
          break;
        case 1218: 
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131717562);
          this.a.b((String)localObject1);
          break;
        case 1232: 
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131718404);
          this.a.b((String)localObject1);
          break;
        case 1233: 
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131718399);
          this.a.b((String)localObject1);
          break;
        case 1240: 
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131718405);
          this.a.b((String)localObject1);
          break;
        case 1241: 
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131718398);
          this.a.b((String)localObject1);
          break;
        case 1242: 
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localObject1 = this.a.app.getApp().getResources().getString(2131718407);
          this.a.b((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131718400);
        localObject1 = localObject2;
        if (parambdxd != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(parambdxd.jdField_a_of_type_JavaLangString)) {
            localObject1 = parambdxd.jdField_a_of_type_JavaLangString;
          }
        }
        this.a.b((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", parambdxd.c);
        ((Intent)localObject1).putExtra("fromWhere", this.a.jdField_b_of_type_JavaLangString);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpc
 * JD-Core Version:    0.7.0.1
 */