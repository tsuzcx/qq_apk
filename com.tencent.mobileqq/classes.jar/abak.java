import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class abak
  implements View.OnClickListener
{
  public abak(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.getText();
    if (paramView != null) {}
    for (paramView = new ayki(paramView.toString(), 3);; paramView = null)
    {
      Object localObject1;
      if (paramView == null)
      {
        localObject1 = "";
        if (paramView != null) {
          break label90;
        }
        paramView = "";
      }
      for (;;)
      {
        if (!this.a.jdField_g_of_type_Boolean)
        {
          if (this.a.jdField_e_of_type_Int == 0)
          {
            this.a.e();
            if (!this.a.a((String)localObject1, paramView))
            {
              return;
              localObject1 = paramView.toString();
              break;
              label90:
              paramView = paramView.c();
              continue;
            }
            if ((this.a.b == null) || (this.a.b.length() == 0))
            {
              if ((paramView == null) || (paramView.length() == 0)) {
                EditInfoActivity.a(this.a);
              }
            }
            else {
              if ((paramView != null) && (paramView.length() != 0)) {
                break label228;
              }
            }
            label228:
            while (!this.a.b.equals(paramView))
            {
              localObject2 = paramView;
              if (this.a.d != 3) {
                break;
              }
              if (!TextUtils.isEmpty(paramView))
              {
                localObject1 = paramView;
                if (paramView.length() >= 1) {}
              }
              else
              {
                localObject1 = "";
              }
              localObject2 = localObject1;
              if (!this.a.a((String)localObject1)) {
                break;
              }
              bcpw.a(this.a, this.a.getString(2131693577), 0).b(this.a.getTitleBarHeight());
              return;
            }
            EditInfoActivity.b(this.a);
            return;
            paramView = (View)localObject2;
            if (localObject2 == null) {
              paramView = "";
            }
            this.a.a(paramView);
            return;
          }
          this.a.n();
          return;
        }
      }
      VasWebviewUtil.reportCommercialDrainage(this.a.app.c(), "group_nickname", "group_nickname_7", "", 1, 0, 0, "", "", "");
      if (!bbev.d(this.a.app.getApplication().getApplicationContext()))
      {
        bcpw.a(this.a, 1, 2131694609, 0).b(this.a.getTitleBarHeight());
        return;
      }
      Object localObject2 = paramView;
      abau localabau;
      if (EditInfoActivity.a(this.a))
      {
        localabau = new abau(null);
        if (EditInfoActivity.a(this.a, localabau))
        {
          this.a.b(true);
          paramView = (bbqp)this.a.app.a(71);
          localObject1 = ((ColorClearableEditText)this.a.a).a().iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          } while (((bcka)((Iterator)localObject1).next()).c != 1);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          bcpw.a(this.a, ajyc.a(2131703619), 0).b(this.a.getTitleBarHeight());
          return;
        }
        paramView.a(this.a.jdField_e_of_type_JavaLangString, ((ColorClearableEditText)this.a.a).a());
        this.a.j = true;
        return;
        localObject2 = paramView;
        if (localabau.b)
        {
          localObject2 = paramView;
          if (!localabau.a) {
            localObject2 = "";
          }
        }
        if (((this.a.jdField_g_of_type_Int == 3) || (this.a.jdField_g_of_type_Int == 4)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          bcpw.a(this.a, this.a.getString(2131693454), 0).b(this.a.getTitleBarHeight());
          return;
        }
        if (((TextUtils.isEmpty(this.a.b)) && (TextUtils.isEmpty((CharSequence)localObject2))) || ((!TextUtils.isEmpty(this.a.b)) && (this.a.b.equals(localObject2))))
        {
          EditInfoActivity.c(this.a);
          return;
        }
        localObject1 = new TroopMemberCardInfo();
        ((TroopMemberCardInfo)localObject1).name = ((String)localObject2);
        ((TroopMemberCardInfo)localObject1).memberuin = this.a.f;
        ((TroopMemberCardInfo)localObject1).troopuin = this.a.jdField_e_of_type_JavaLangString;
        ((TroopMemberCardInfo)localObject1).email = "";
        ((TroopMemberCardInfo)localObject1).memo = "";
        ((TroopMemberCardInfo)localObject1).sex = -1;
        ((TroopMemberCardInfo)localObject1).tel = "";
        paramView = new ArrayList();
        paramView.add(localObject1);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(Integer.valueOf(1));
        localObject2 = (akhq)this.a.app.a(20);
        if ((localObject2 != null) && (!TextUtils.isEmpty(this.a.jdField_e_of_type_JavaLangString)))
        {
          this.a.b(true);
          ((akhq)localObject2).a(this.a.jdField_e_of_type_JavaLangString, paramView, (ArrayList)localObject1);
        }
        paramView = (TroopManager)this.a.app.getManager(52);
        if (paramView != null)
        {
          paramView = paramView.b(this.a.jdField_e_of_type_JavaLangString);
          if (paramView != null) {
            if ((!TextUtils.isEmpty(paramView.troopowneruin)) && (paramView.troopowneruin.equalsIgnoreCase(this.a.app.getAccount()))) {
              i = 0;
            }
          }
        }
        for (;;)
        {
          this.a.j = true;
          axqw.b(this.a.app, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.a.jdField_e_of_type_JavaLangString, i + "", "" + this.a.d, "");
          return;
          if ((!TextUtils.isEmpty(paramView.Administrator)) && (paramView.Administrator.contains(this.a.app.getAccount()))) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abak
 * JD-Core Version:    0.7.0.1
 */