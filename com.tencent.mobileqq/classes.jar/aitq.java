import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Map;

public class aitq
  implements View.OnClickListener
{
  aitq(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    aitr localaitr;
    int j;
    int i;
    if ((localObject1 != null) && ((localObject1 instanceof aitr)))
    {
      localaitr = (aitr)localObject1;
      if ((localaitr.b != 80000003) || (SearchContactsFragment.c(this.a) == null)) {
        break label304;
      }
      this.a.a(SearchContactsFragment.c(this.a), SearchContactsFragment.a(this.a), SearchContactsFragment.b(this.a));
      Integer localInteger = (Integer)SearchContactsFragment.a(this.a).get(Integer.valueOf(localaitr.b));
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localaitr.a != null)
      {
        localObject1 = localObject2;
        if (localaitr.a.uin != null) {
          localObject1 = String.valueOf(localaitr.a.uin.get());
        }
      }
      j = localaitr.b;
      if (localInteger == null) {
        break label404;
      }
      i = localInteger.intValue();
      label162:
      bbup.a(j, i, 0, true, (String)localObject1, this.a.jdField_a_of_type_JavaLangString, SearchContactsFragment.d());
      if (localaitr.b != 80000002) {
        break label455;
      }
      localObject2 = this.a.getActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchBaseActivity)))
      {
        i = ((SearchBaseActivity)localObject2).a();
        if (SearchContactsFragment.d() != 12) {
          break label409;
        }
        bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", aitb.a(i), (String)localObject1, this.a.jdField_a_of_type_JavaLangString);
        label268:
        localObject2 = txm.a();
        if (localInteger == null) {
          break label450;
        }
        i = localInteger.intValue();
        label284:
        ((txm)localObject2).a(2, (String)localObject1, i, SearchContactsFragment.d());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label304:
      if (localaitr.b == 80000004)
      {
        QzoneSearchResultView.a(this.a.getActivity(), localaitr.jdField_c_of_type_JavaLangString);
        break;
      }
      i = 0;
      if (this.a.d == 1)
      {
        i = 3;
        label347:
        localObject1 = this.a;
        j = localaitr.b;
        if (localaitr.jdField_c_of_type_Int != 2) {
          break label398;
        }
      }
      label398:
      for (boolean bool = true;; bool = false)
      {
        ((SearchContactsFragment)localObject1).a(j, bool, i);
        break;
        if (this.a.d != 0) {
          break label347;
        }
        i = 2;
        break label347;
      }
      label404:
      i = 0;
      break label162;
      label409:
      oat.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D20", "0X8005D20", 0, 0, "0", aitb.a(i), this.a.jdField_a_of_type_JavaLangString, "", false);
      break label268;
      label450:
      i = 0;
      break label284;
      label455:
      if (localaitr.b == 80000003)
      {
        if (SearchContactsFragment.d() == 12) {
          bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0");
        } else {
          oat.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0", false);
        }
      }
      else if (localaitr.b == 80000001) {
        bbup.a("add_page", "all_result", "clk_more_grp", 0, SearchContactsFragment.a(this.a), new String[] { "", "", this.a.jdField_a_of_type_JavaLangString, "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitq
 * JD-Core Version:    0.7.0.1
 */