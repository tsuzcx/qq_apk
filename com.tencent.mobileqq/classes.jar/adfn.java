import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class adfn
  implements View.OnClickListener
{
  public adfn(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a.a.getText();
    if (localObject1 != null) {}
    for (localObject1 = new QQText(localObject1.toString(), 3);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = "";
        if (localObject1 != null) {
          break label100;
        }
        localObject1 = "";
        label43:
        if (this.a.jdField_g_of_type_Boolean) {
          break label347;
        }
        if (this.a.jdField_e_of_type_Int != 0) {
          break label337;
        }
        this.a.b();
        if (this.a.a((String)localObject2, (String)localObject1)) {
          break label108;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = ((QQText)localObject1).toString();
        break;
        label100:
        localObject1 = ((QQText)localObject1).trim();
        break label43;
        label108:
        if ((this.a.b == null) || (this.a.b.length() == 0))
        {
          if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
            EditInfoActivity.a(this.a);
          }
        }
        else
        {
          if ((this.a.h) && ((localObject1 == null) || (((String)localObject1).length() == 0)))
          {
            if (localObject1 == null) {
              continue;
            }
            QQToast.a(this.a, this.a.getString(2131693119), 0).b(this.a.getTitleBarHeight());
            continue;
          }
          if (this.a.b.equals(localObject1))
          {
            EditInfoActivity.b(this.a);
            continue;
          }
        }
        localObject3 = localObject1;
        if (this.a.d == 3)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() >= 1) {}
          }
          else
          {
            localObject2 = "";
          }
          localObject3 = localObject2;
          if (this.a.a((String)localObject2))
          {
            QQToast.a(this.a, this.a.getString(2131693118), 0).b(this.a.getTitleBarHeight());
            continue;
          }
        }
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        this.a.a((String)localObject1);
        continue;
        label337:
        this.a.k();
        continue;
        label347:
        VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentUin(), "group_nickname", "group_nickname_7", "", 1, 0, 0, "", "", "");
        if (NetworkUtil.isNetSupport(this.a.app.getApplication().getApplicationContext())) {
          break label457;
        }
        QQToast.a(this.a, 1, 2131694064, 0).b(this.a.getTitleBarHeight());
        this.a.app.reportClickEvent("dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(this.a.jdField_e_of_type_JavaLangString), "1", "", "");
      }
      label457:
      Object localObject3 = localObject1;
      adfw localadfw;
      if (EditInfoActivity.a(this.a))
      {
        localadfw = new adfw(null);
        if (EditInfoActivity.a(this.a, localadfw))
        {
          this.a.b(true);
          localObject1 = (VasExtensionHandler)this.a.app.getBusinessHandler(71);
          localObject2 = ((ColorClearableEditText)this.a.a).a().iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (((bhcd)((Iterator)localObject2).next()).c != 1);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          QQToast.a(this.a, amtj.a(2131702753), 0).b(this.a.getTitleBarHeight());
          break;
        }
        ((VasExtensionHandler)localObject1).a(this.a.jdField_e_of_type_JavaLangString, ((ColorClearableEditText)this.a.a).a());
        this.a.j = true;
        break;
        localObject3 = localObject1;
        if (localadfw.b)
        {
          localObject3 = localObject1;
          if (!localadfw.a) {
            localObject3 = "";
          }
        }
        if (((this.a.jdField_g_of_type_Int == 3) || (this.a.jdField_g_of_type_Int == 4)) && (TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          QQToast.a(this.a, this.a.getString(2131693059), 0).b(this.a.getTitleBarHeight());
          break;
        }
        if (((TextUtils.isEmpty(this.a.b)) && (TextUtils.isEmpty((CharSequence)localObject3))) || ((!TextUtils.isEmpty(this.a.b)) && (this.a.b.equals(localObject3))))
        {
          EditInfoActivity.c(this.a);
          break;
        }
        localObject2 = new TroopMemberCardInfo();
        ((TroopMemberCardInfo)localObject2).name = ((String)localObject3);
        ((TroopMemberCardInfo)localObject2).memberuin = this.a.f;
        ((TroopMemberCardInfo)localObject2).troopuin = this.a.jdField_e_of_type_JavaLangString;
        ((TroopMemberCardInfo)localObject2).email = "";
        ((TroopMemberCardInfo)localObject2).memo = "";
        ((TroopMemberCardInfo)localObject2).sex = -1;
        ((TroopMemberCardInfo)localObject2).tel = "";
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Integer.valueOf(1));
        localObject3 = (anca)this.a.app.getBusinessHandler(20);
        if ((localObject3 != null) && (!TextUtils.isEmpty(this.a.jdField_e_of_type_JavaLangString)))
        {
          this.a.b(true);
          ((anca)localObject3).a(this.a.jdField_e_of_type_JavaLangString, (ArrayList)localObject1, (ArrayList)localObject2);
        }
        localObject1 = (TroopManager)this.a.app.getManager(52);
        if (localObject1 != null)
        {
          localObject1 = ((TroopManager)localObject1).b(this.a.jdField_e_of_type_JavaLangString);
          if (localObject1 != null) {
            if ((!TextUtils.isEmpty(((TroopInfo)localObject1).troopowneruin)) && (((TroopInfo)localObject1).troopowneruin.equalsIgnoreCase(this.a.app.getAccount()))) {
              i = 0;
            }
          }
        }
        for (;;)
        {
          this.a.j = true;
          bcef.b(this.a.app, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.a.jdField_e_of_type_JavaLangString, i + "", "" + this.a.d, "");
          break;
          if ((!TextUtils.isEmpty(((TroopInfo)localObject1).Administrator)) && (((TroopInfo)localObject1).Administrator.contains(this.a.app.getAccount()))) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfn
 * JD-Core Version:    0.7.0.1
 */