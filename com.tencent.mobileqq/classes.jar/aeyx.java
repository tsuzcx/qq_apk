import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aeyx
  extends aeyf
  implements rhj
{
  public aeyx(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Aicw.c();
    int i = this.jdField_a_of_type_Aicw.b();
    aeyy localaeyy;
    if ((paramView == null) || (!(paramView.getTag() instanceof aeyy)))
    {
      localaeyy = new aeyy();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495338, null);
      localaeyy.a = ((ThemeTabLayout)paramView.findViewById(2131311003));
      localaeyy.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Atcu != null) || ((this.jdField_a_of_type_Atcu instanceof atcw))) {
        localaeyy.a.a(((atcw)this.jdField_a_of_type_Atcu).a, i);
      }
      localaeyy.a.setOnTabSelectedListener(this);
      paramView.setTag(localaeyy);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localaeyy != null) && (localaeyy.a != null) && ((this.jdField_a_of_type_Atcu != null) || ((this.jdField_a_of_type_Atcu instanceof atcw))))
      {
        ArrayList localArrayList = ((atcw)this.jdField_a_of_type_Atcu).a;
        localaeyy.a.b(localArrayList, i);
      }
      return paramView;
      localaeyy = (aeyy)paramView.getTag();
    }
  }
  
  public ArrayList<afai> a()
  {
    if ((this.jdField_a_of_type_Atcu != null) || ((this.jdField_a_of_type_Atcu instanceof atcw))) {
      return ((atcw)this.jdField_a_of_type_Atcu).a;
    }
    return null;
  }
  
  public void a(rho paramrho)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramrho.a());
    }
    if ((this.jdField_a_of_type_Aicw != null) && (paramrho != null))
    {
      this.jdField_a_of_type_Aicw.b(((Integer)paramrho.a()).intValue(), paramrho.a());
      int i = this.jdField_a_of_type_Aicw.b();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(rho paramrho) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839104);
      return;
    }
    paramView.setBackgroundResource(2130848902);
  }
  
  public void c(rho paramrho) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyx
 * JD-Core Version:    0.7.0.1
 */