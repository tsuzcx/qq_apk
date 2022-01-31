import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahmf
  extends ahln
  implements skj
{
  public ahmf(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Akln.c();
    int i = this.jdField_a_of_type_Akln.b();
    ahmg localahmg;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmg)))
    {
      localahmg = new ahmg();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561116, null);
      localahmg.a = ((ThemeTabLayout)paramView.findViewById(2131377381));
      localahmg.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Avun != null) || ((this.jdField_a_of_type_Avun instanceof avup))) {
        localahmg.a.a(((avup)this.jdField_a_of_type_Avun).a, i);
      }
      localahmg.a.setOnTabSelectedListener(this);
      paramView.setTag(localahmg);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localahmg != null) && (localahmg.a != null) && ((this.jdField_a_of_type_Avun != null) || ((this.jdField_a_of_type_Avun instanceof avup))))
      {
        ArrayList localArrayList = ((avup)this.jdField_a_of_type_Avun).a;
        localahmg.a.b(localArrayList, i);
      }
      return paramView;
      localahmg = (ahmg)paramView.getTag();
    }
  }
  
  public ArrayList<ahnq> a()
  {
    if ((this.jdField_a_of_type_Avun != null) || ((this.jdField_a_of_type_Avun instanceof avup))) {
      return ((avup)this.jdField_a_of_type_Avun).a;
    }
    return null;
  }
  
  public void a(sko paramsko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramsko.a());
    }
    if ((this.jdField_a_of_type_Akln != null) && (paramsko != null))
    {
      this.jdField_a_of_type_Akln.b(((Integer)paramsko.a()).intValue(), paramsko.a());
      int i = this.jdField_a_of_type_Akln.b();
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(sko paramsko) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839217);
      return;
    }
    paramView.setBackgroundResource(2130849643);
  }
  
  public void c(sko paramsko) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmf
 * JD-Core Version:    0.7.0.1
 */