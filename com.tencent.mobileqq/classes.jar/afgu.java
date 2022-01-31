import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Map;

public class afgu
  implements View.OnClickListener
{
  afgu(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    afgv localafgv;
    int i;
    if ((paramView != null) && ((paramView instanceof afgv)))
    {
      localafgv = (afgv)paramView;
      if ((localafgv.b != 80000003) || (SearchContactsFragment.c(this.a) == null)) {
        break label287;
      }
      this.a.a(SearchContactsFragment.c(this.a), SearchContactsFragment.a(this.a), SearchContactsFragment.b(this.a));
      Integer localInteger = (Integer)SearchContactsFragment.a(this.a).get(Integer.valueOf(localafgv.b));
      Object localObject = null;
      paramView = (View)localObject;
      if (localafgv.a != null)
      {
        paramView = (View)localObject;
        if (localafgv.a.uin != null) {
          paramView = String.valueOf(localafgv.a.uin.get());
        }
      }
      int j = localafgv.b;
      if (localInteger == null) {
        break label354;
      }
      i = localInteger.intValue();
      label155:
      awvy.a(j, i, 0, true, paramView, this.a.jdField_a_of_type_JavaLangString, SearchContactsFragment.d());
      if (localafgv.b != 80000002) {
        break label405;
      }
      localObject = this.a.getActivity();
      if ((localObject != null) && ((localObject instanceof SearchBaseActivity)))
      {
        i = ((SearchBaseActivity)localObject).a();
        if (SearchContactsFragment.d() != 12) {
          break label359;
        }
        axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", afgf.a(i), paramView, this.a.jdField_a_of_type_JavaLangString);
        label259:
        localObject = sen.a();
        if (localInteger == null) {
          break label400;
        }
        i = localInteger.intValue();
        label275:
        ((sen)localObject).a(2, paramView, i, SearchContactsFragment.d());
      }
    }
    label287:
    label354:
    label359:
    do
    {
      return;
      if (localafgv.b == 80000004)
      {
        QzoneSearchResultView.a(this.a.getActivity(), localafgv.jdField_c_of_type_JavaLangString);
        break;
      }
      paramView = this.a;
      i = localafgv.b;
      if (localafgv.jdField_c_of_type_Int == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.a(i, bool);
        break;
      }
      i = 0;
      break label155;
      noo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D20", "0X8005D20", 0, 0, "0", afgf.a(i), this.a.jdField_a_of_type_JavaLangString, "", false);
      break label259;
      i = 0;
      break label275;
      if (localafgv.b == 80000003)
      {
        if (SearchContactsFragment.d() == 12)
        {
          axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0");
          return;
        }
        noo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0", false);
        return;
      }
    } while (localafgv.b != 80000001);
    label400:
    label405:
    awvy.a("add_page", "all_result", "clk_more_grp", 0, SearchContactsFragment.a(this.a), new String[] { "", "", this.a.jdField_a_of_type_JavaLangString, "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afgu
 * JD-Core Version:    0.7.0.1
 */