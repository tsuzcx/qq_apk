import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agaf
  implements View.OnClickListener
{
  public agaf(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    String str;
    label93:
    do
    {
      do
      {
        do
        {
          int j;
          do
          {
            do
            {
              int i;
              do
              {
                do
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.history.BaseFragment", 2, "mOnKickOutBtnClickListener onclick");
                  }
                  j = paramView.getId();
                  str = (String)paramView.getTag();
                  bool1 = str.equals(this.a.jdField_f_of_type_JavaLangString);
                  if ((this.a.jdField_g_of_type_JavaLangString != null) && (this.a.jdField_g_of_type_JavaLangString.contains(str)))
                  {
                    i = 1;
                    boolean bool4 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.a.jdField_f_of_type_JavaLangString);
                    if (((!bool4) || (str.equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) && ((bool4) || (bool1) || (i != 0))) {
                      break label292;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if (j != 2131364983) {
                      break label551;
                    }
                    paramView = paramView.findViewById(2131364984);
                    bool1 = bool2;
                    if (paramView.getTag() != null)
                    {
                      bool1 = bool2;
                      if ((paramView.getTag() instanceof Boolean)) {
                        bool1 = ((Boolean)paramView.getTag()).booleanValue();
                      }
                    }
                    paramView = this.a.a(str, bool1);
                    if (this.a.jdField_d_of_type_Int != 20) {
                      break label297;
                    }
                    if (paramView == null) {
                      break;
                    }
                    paramView = paramView.a.getTag();
                    if ((paramView == null) || (!(paramView instanceof Integer))) {
                      break;
                    }
                    i = ((Integer)paramView).intValue();
                    if (i < 0) {
                      break;
                    }
                    paramView = (agau)this.a.jdField_a_of_type_Agaw.getItem(i);
                    this.a.a(paramView);
                    return;
                    i = 0;
                    break label93;
                  }
                  if (this.a.jdField_g_of_type_Boolean)
                  {
                    if (this.a.jdField_a_of_type_Agaw.jdField_b_of_type_JavaUtilList.contains(str)) {
                      this.a.jdField_a_of_type_Agaw.jdField_b_of_type_JavaUtilList.remove(str);
                    }
                    for (;;)
                    {
                      ChatHistoryTroopMemberFragment.a(this.a);
                      this.a.jdField_a_of_type_Agaw.notifyDataSetChanged();
                      return;
                      if (i != 0) {
                        this.a.jdField_a_of_type_Agaw.jdField_b_of_type_JavaUtilList.add(str);
                      }
                    }
                  }
                  if (!bool1) {
                    break;
                  }
                } while (this.a.v.equals(str));
                if (paramView != null) {
                  paramView.a.a(true);
                }
                if (!TextUtils.isEmpty(this.a.v))
                {
                  paramView = this.a.a(this.a.v, bool1);
                  if (paramView != null) {
                    paramView.a.b(true);
                  }
                }
                this.a.v = str;
                return;
              } while (this.a.u.equals(str));
              if (paramView != null) {
                paramView.a.a(true);
              }
              if (!TextUtils.isEmpty(this.a.u))
              {
                paramView = this.a.a(this.a.u, bool1);
                if (paramView != null) {
                  paramView.a.b(true);
                }
              }
              this.a.u = str;
              return;
              if (j != 2131376268) {
                break;
              }
              paramView = paramView.findViewById(2131378256);
              boolean bool1 = bool3;
              if (paramView.getTag() != null)
              {
                bool1 = bool3;
                if ((paramView.getTag() instanceof Boolean)) {
                  bool1 = ((Boolean)paramView.getTag()).booleanValue();
                }
              }
              if (this.a.jdField_g_of_type_Boolean)
              {
                if (!this.a.jdField_a_of_type_Agaw.jdField_b_of_type_JavaUtilList.contains(str)) {
                  break label720;
                }
                this.a.jdField_a_of_type_Agaw.jdField_b_of_type_JavaUtilList.remove(str);
              }
              for (;;)
              {
                ChatHistoryTroopMemberFragment.a(this.a);
                this.a.jdField_a_of_type_Agaw.notifyDataSetChanged();
                if (!bool1) {
                  break;
                }
                paramView = this.a.a(this.a.v, bool1);
                if (paramView != null)
                {
                  paramView.a.b(true);
                  this.a.v = "";
                }
                this.a.jdField_a_of_type_Agay.notifyDataSetChanged();
                return;
                if (i != 0) {
                  this.a.jdField_a_of_type_Agaw.jdField_b_of_type_JavaUtilList.add(str);
                }
              }
              paramView = this.a.a(this.a.u, bool1);
            } while (paramView == null);
            paramView.a.b(true);
            this.a.u = "";
            return;
          } while ((j != 2131363572) || (!this.a.jdField_f_of_type_Boolean));
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "delBtn onClick, uin=" + str);
          }
          if (bbev.d(BaseApplication.getContext())) {
            break;
          }
        } while (!this.a.getActivity().isResume());
        bcpw.a(this.a.getActivity(), this.a.getString(2131694609), 0).b(this.a.getActivity().getTitleBarHeight());
        return;
        if (this.a.jdField_d_of_type_Int == 1)
        {
          this.a.f(str);
          return;
        }
        if (this.a.jdField_d_of_type_Int != 13) {
          break;
        }
        paramView = this.a.a(str);
        this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
        this.a.jdField_a_of_type_Agaw.a();
      } while (!this.a.jdField_d_of_type_AndroidAppDialog.isShowing());
      if (paramView != null) {
        this.a.jdField_b_of_type_JavaUtilList.remove(paramView);
      }
      this.a.jdField_a_of_type_Agay.notifyDataSetChanged();
      return;
      if (this.a.jdField_d_of_type_Int != 21) {
        break;
      }
      paramView = this.a.a(str);
      this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.a.jdField_a_of_type_Agaw.a();
    } while (!this.a.jdField_d_of_type_AndroidAppDialog.isShowing());
    label292:
    label297:
    label720:
    if (paramView != null) {
      this.a.jdField_b_of_type_JavaUtilList.remove(paramView);
    }
    label551:
    this.a.jdField_a_of_type_Agay.notifyDataSetChanged();
    return;
    paramView = new ArrayList();
    paramView.add(Long.valueOf(Long.parseLong(str)));
    ChatHistoryTroopMemberFragment.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agaf
 * JD-Core Version:    0.7.0.1
 */