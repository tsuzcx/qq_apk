import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class acke
  implements View.OnClickListener
{
  public acke(TroopMemberListActivity paramTroopMemberListActivity) {}
  
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
                    QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnKickOutBtnClickListener onclick");
                  }
                  j = paramView.getId();
                  str = (String)paramView.getTag();
                  bool1 = str.equals(this.a.e);
                  if ((this.a.f != null) && (this.a.f.contains(str)))
                  {
                    i = 1;
                    boolean bool4 = this.a.app.getCurrentAccountUin().equals(this.a.e);
                    if (((!bool4) || (str.equals(this.a.app.getCurrentAccountUin()))) && ((bool4) || (bool1) || (i != 0))) {
                      break label292;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if (j != 2131364982) {
                      break label551;
                    }
                    paramView = paramView.findViewById(2131364983);
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
                    paramView = (acku)this.a.jdField_a_of_type_Ackw.getItem(i);
                    this.a.a(paramView);
                    return;
                    i = 0;
                    break label93;
                  }
                  if (this.a.jdField_d_of_type_Boolean)
                  {
                    if (this.a.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.contains(str)) {
                      this.a.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.remove(str);
                    }
                    for (;;)
                    {
                      TroopMemberListActivity.a(this.a);
                      this.a.jdField_a_of_type_Ackw.notifyDataSetChanged();
                      return;
                      if (i != 0) {
                        this.a.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.add(str);
                      }
                    }
                  }
                  if (!bool1) {
                    break;
                  }
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
              } while (this.a.t.equals(str));
              if (paramView != null) {
                paramView.a.a(true);
              }
              if (!TextUtils.isEmpty(this.a.t))
              {
                paramView = this.a.a(this.a.t, bool1);
                if (paramView != null) {
                  paramView.a.b(true);
                }
              }
              this.a.t = str;
              return;
              if (j != 2131376270) {
                break;
              }
              paramView = paramView.findViewById(2131378259);
              boolean bool1 = bool3;
              if (paramView.getTag() != null)
              {
                bool1 = bool3;
                if ((paramView.getTag() instanceof Boolean)) {
                  bool1 = ((Boolean)paramView.getTag()).booleanValue();
                }
              }
              if (this.a.jdField_d_of_type_Boolean)
              {
                if (!this.a.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.contains(str)) {
                  break label720;
                }
                this.a.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.remove(str);
              }
              for (;;)
              {
                TroopMemberListActivity.a(this.a);
                this.a.jdField_a_of_type_Ackw.notifyDataSetChanged();
                if (!bool1) {
                  break;
                }
                paramView = this.a.a(this.a.u, bool1);
                if (paramView != null)
                {
                  paramView.a.b(true);
                  this.a.u = "";
                }
                this.a.jdField_a_of_type_Acky.notifyDataSetChanged();
                return;
                if (i != 0) {
                  this.a.jdField_a_of_type_Ackw.jdField_b_of_type_JavaUtilList.add(str);
                }
              }
              paramView = this.a.a(this.a.t, bool1);
            } while (paramView == null);
            paramView.a.b(true);
            this.a.t = "";
            return;
          } while ((j != 2131363571) || (!this.a.c));
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "delBtn onClick, uin=" + str);
          }
          if (bbfj.d(BaseApplication.getContext())) {
            break;
          }
        } while (!this.a.isResume());
        bcql.a(this.a, this.a.getString(2131694610), 0).b(this.a.getTitleBarHeight());
        return;
        if (this.a.jdField_d_of_type_Int == 1)
        {
          this.a.d(str);
          return;
        }
        if (this.a.jdField_d_of_type_Int != 13) {
          break;
        }
        paramView = this.a.a(str);
        this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
        this.a.jdField_a_of_type_Ackw.a();
      } while (!this.a.jdField_b_of_type_AndroidAppDialog.isShowing());
      if (paramView != null) {
        this.a.jdField_b_of_type_JavaUtilList.remove(paramView);
      }
      this.a.jdField_a_of_type_Acky.notifyDataSetChanged();
      return;
      if (this.a.jdField_d_of_type_Int != 21) {
        break;
      }
      paramView = this.a.a(str);
      this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.a.jdField_a_of_type_Ackw.a();
    } while (!this.a.jdField_b_of_type_AndroidAppDialog.isShowing());
    label292:
    label297:
    label720:
    if (paramView != null) {
      this.a.jdField_b_of_type_JavaUtilList.remove(paramView);
    }
    label551:
    this.a.jdField_a_of_type_Acky.notifyDataSetChanged();
    return;
    paramView = new ArrayList();
    paramView.add(Long.valueOf(Long.parseLong(str)));
    TroopMemberListActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acke
 * JD-Core Version:    0.7.0.1
 */