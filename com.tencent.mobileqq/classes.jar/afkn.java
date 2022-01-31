import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afkn
  extends afjv
  implements rtz
{
  public afkn(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Aipp.c();
    int i = this.jdField_a_of_type_Aipp.b();
    afko localafko;
    if ((paramView == null) || (!(paramView.getTag() instanceof afko)))
    {
      localafko = new afko();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560916, null);
      localafko.a = ((ThemeTabLayout)paramView.findViewById(2131376812));
      localafko.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Atyy != null) || ((this.jdField_a_of_type_Atyy instanceof atza))) {
        localafko.a.a(((atza)this.jdField_a_of_type_Atyy).a, i);
      }
      localafko.a.setOnTabSelectedListener(this);
      paramView.setTag(localafko);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localafko != null) && (localafko.a != null) && ((this.jdField_a_of_type_Atyy != null) || ((this.jdField_a_of_type_Atyy instanceof atza))))
      {
        ArrayList localArrayList = ((atza)this.jdField_a_of_type_Atyy).a;
        localafko.a.b(localArrayList, i);
      }
      return paramView;
      localafko = (afko)paramView.getTag();
    }
  }
  
  public ArrayList<afly> a()
  {
    if ((this.jdField_a_of_type_Atyy != null) || ((this.jdField_a_of_type_Atyy instanceof atza))) {
      return ((atza)this.jdField_a_of_type_Atyy).a;
    }
    return null;
  }
  
  public void a(rue paramrue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramrue.a());
    }
    if ((this.jdField_a_of_type_Aipp != null) && (paramrue != null))
    {
      this.jdField_a_of_type_Aipp.b(((Integer)paramrue.a()).intValue(), paramrue.a());
      int i = this.jdField_a_of_type_Aipp.b();
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(rue paramrue) {}
  
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
    paramView.setBackgroundResource(2130849130);
  }
  
  public void c(rue paramrue) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkn
 * JD-Core Version:    0.7.0.1
 */