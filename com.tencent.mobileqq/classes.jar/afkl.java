import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afkl
  extends afjt
  implements rtw
{
  public afkl(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Aipn.c();
    int i = this.jdField_a_of_type_Aipn.b();
    afkm localafkm;
    if ((paramView == null) || (!(paramView.getTag() instanceof afkm)))
    {
      localafkm = new afkm();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560915, null);
      localafkm.a = ((ThemeTabLayout)paramView.findViewById(2131376814));
      localafkm.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Atza != null) || ((this.jdField_a_of_type_Atza instanceof atzc))) {
        localafkm.a.a(((atzc)this.jdField_a_of_type_Atza).a, i);
      }
      localafkm.a.setOnTabSelectedListener(this);
      paramView.setTag(localafkm);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localafkm != null) && (localafkm.a != null) && ((this.jdField_a_of_type_Atza != null) || ((this.jdField_a_of_type_Atza instanceof atzc))))
      {
        ArrayList localArrayList = ((atzc)this.jdField_a_of_type_Atza).a;
        localafkm.a.b(localArrayList, i);
      }
      return paramView;
      localafkm = (afkm)paramView.getTag();
    }
  }
  
  public ArrayList<aflw> a()
  {
    if ((this.jdField_a_of_type_Atza != null) || ((this.jdField_a_of_type_Atza instanceof atzc))) {
      return ((atzc)this.jdField_a_of_type_Atza).a;
    }
    return null;
  }
  
  public void a(rub paramrub)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramrub.a());
    }
    if ((this.jdField_a_of_type_Aipn != null) && (paramrub != null))
    {
      this.jdField_a_of_type_Aipn.b(((Integer)paramrub.a()).intValue(), paramrub.a());
      int i = this.jdField_a_of_type_Aipn.b();
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(rub paramrub) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839132);
      return;
    }
    paramView.setBackgroundResource(2130849139);
  }
  
  public void c(rub paramrub) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkl
 * JD-Core Version:    0.7.0.1
 */