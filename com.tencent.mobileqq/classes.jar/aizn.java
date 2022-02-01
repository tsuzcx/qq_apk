import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aizn
  implements View.OnClickListener
{
  public aizn(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "mOnKickOutBtnClickListener onclick");
      }
      int j = paramView.getId();
      Object localObject1 = (String)paramView.getTag();
      boolean bool1 = ((String)localObject1).equals(this.a.jdField_f_of_type_JavaLangString);
      int i;
      if ((this.a.jdField_g_of_type_JavaLangString != null) && (this.a.jdField_g_of_type_JavaLangString.contains((CharSequence)localObject1)))
      {
        i = 1;
        label100:
        boolean bool4 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.a.jdField_f_of_type_JavaLangString);
        if (((!bool4) || (((String)localObject1).equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) && ((bool4) || (bool1) || (i != 0))) {
          break label314;
        }
        i = 1;
      }
      Object localObject2;
      for (;;)
      {
        if (j == 2131365380)
        {
          localObject2 = paramView.findViewById(2131365381);
          bool1 = bool2;
          if (((View)localObject2).getTag() != null)
          {
            bool1 = bool2;
            if ((((View)localObject2).getTag() instanceof Boolean)) {
              bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
            }
          }
          localObject2 = this.a.a((String)localObject1, bool1);
          if (this.a.jdField_d_of_type_Int == 20)
          {
            if (localObject2 == null) {
              break;
            }
            localObject1 = ((ajaj)localObject2).a.getTag();
            if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
              break;
            }
            i = ((Integer)localObject1).intValue();
            if (i < 0) {
              break;
            }
            localObject1 = (ajac)this.a.jdField_a_of_type_Ajae.getItem(i);
            this.a.a((ajac)localObject1);
            break;
            i = 0;
            break label100;
            label314:
            i = 0;
            continue;
          }
          if (this.a.jdField_g_of_type_Boolean)
          {
            if (this.a.jdField_a_of_type_Ajae.jdField_b_of_type_JavaUtilList.contains(localObject1)) {
              this.a.jdField_a_of_type_Ajae.jdField_b_of_type_JavaUtilList.remove(localObject1);
            }
            for (;;)
            {
              ChatHistoryTroopMemberFragment.a(this.a);
              this.a.jdField_a_of_type_Ajae.notifyDataSetChanged();
              break;
              if (i != 0) {
                this.a.jdField_a_of_type_Ajae.jdField_b_of_type_JavaUtilList.add(localObject1);
              }
            }
          }
          if (bool1)
          {
            if (this.a.v.equals(localObject1)) {
              break;
            }
            if (localObject2 != null) {
              ((ajaj)localObject2).a.a(true);
            }
            if (!TextUtils.isEmpty(this.a.v))
            {
              localObject2 = this.a.a(this.a.v, bool1);
              if (localObject2 != null) {
                ((ajaj)localObject2).a.b(true);
              }
            }
            this.a.v = ((String)localObject1);
            break;
          }
          if (this.a.u.equals(localObject1)) {
            break;
          }
          if (localObject2 != null) {
            ((ajaj)localObject2).a.a(true);
          }
          if (!TextUtils.isEmpty(this.a.u))
          {
            localObject2 = this.a.a(this.a.u, bool1);
            if (localObject2 != null) {
              ((ajaj)localObject2).a.b(true);
            }
          }
          this.a.u = ((String)localObject1);
          break;
        }
      }
      if (j == 2131377558)
      {
        localObject2 = paramView.findViewById(2131379713);
        bool1 = bool3;
        if (((View)localObject2).getTag() != null)
        {
          bool1 = bool3;
          if ((((View)localObject2).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject2).getTag()).booleanValue();
          }
        }
        if (this.a.jdField_g_of_type_Boolean)
        {
          if (!this.a.jdField_a_of_type_Ajae.jdField_b_of_type_JavaUtilList.contains(localObject1)) {
            break label767;
          }
          this.a.jdField_a_of_type_Ajae.jdField_b_of_type_JavaUtilList.remove(localObject1);
        }
        for (;;)
        {
          ChatHistoryTroopMemberFragment.a(this.a);
          this.a.jdField_a_of_type_Ajae.notifyDataSetChanged();
          if (!bool1) {
            break label792;
          }
          localObject1 = this.a.a(this.a.v, bool1);
          if (localObject1 != null)
          {
            ((ajaj)localObject1).a.b(true);
            this.a.v = "";
          }
          this.a.jdField_a_of_type_Ajag.notifyDataSetChanged();
          break;
          label767:
          if (i != 0) {
            this.a.jdField_a_of_type_Ajae.jdField_b_of_type_JavaUtilList.add(localObject1);
          }
        }
        label792:
        localObject1 = this.a.a(this.a.u, bool1);
        if (localObject1 != null)
        {
          ((ajaj)localObject1).a.b(true);
          this.a.u = "";
        }
      }
      else if ((j == 2131363868) && (this.a.jdField_f_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "delBtn onClick, uin=" + (String)localObject1);
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          if (this.a.getActivity().isResume()) {
            QQToast.a(this.a.getActivity(), this.a.getString(2131694064), 0).b(this.a.getActivity().getTitleBarHeight());
          }
        }
        else if (this.a.jdField_d_of_type_Int == 1)
        {
          this.a.f((String)localObject1);
        }
        else if (this.a.jdField_d_of_type_Int == 13)
        {
          localObject2 = this.a.a((String)localObject1);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          this.a.jdField_a_of_type_Ajae.a();
          if (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.jdField_b_of_type_JavaUtilList.remove(localObject2);
            }
            this.a.jdField_a_of_type_Ajag.notifyDataSetChanged();
          }
        }
        else if (this.a.jdField_d_of_type_Int == 21)
        {
          localObject2 = this.a.a((String)localObject1);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          this.a.jdField_a_of_type_Ajae.a();
          if (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())
          {
            if (localObject2 != null) {
              this.a.jdField_b_of_type_JavaUtilList.remove(localObject2);
            }
            this.a.jdField_a_of_type_Ajag.notifyDataSetChanged();
          }
        }
        else
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(Long.valueOf(Long.parseLong((String)localObject1)));
          ChatHistoryTroopMemberFragment.a(this.a, (List)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizn
 * JD-Core Version:    0.7.0.1
 */