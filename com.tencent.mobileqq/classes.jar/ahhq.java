import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahhq
  extends ahgy
  implements skj
{
  public ahhq(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Akgy.c();
    int i = this.jdField_a_of_type_Akgy.b();
    ahhr localahhr;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahhr)))
    {
      localahhr = new ahhr();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561098, null);
      localahhr.a = ((ThemeTabLayout)paramView.findViewById(2131377327));
      localahhr.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Avqe != null) || ((this.jdField_a_of_type_Avqe instanceof avqg))) {
        localahhr.a.a(((avqg)this.jdField_a_of_type_Avqe).a, i);
      }
      localahhr.a.setOnTabSelectedListener(this);
      paramView.setTag(localahhr);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localahhr != null) && (localahhr.a != null) && ((this.jdField_a_of_type_Avqe != null) || ((this.jdField_a_of_type_Avqe instanceof avqg))))
      {
        ArrayList localArrayList = ((avqg)this.jdField_a_of_type_Avqe).a;
        localahhr.a.b(localArrayList, i);
      }
      return paramView;
      localahhr = (ahhr)paramView.getTag();
    }
  }
  
  public ArrayList<ahjb> a()
  {
    if ((this.jdField_a_of_type_Avqe != null) || ((this.jdField_a_of_type_Avqe instanceof avqg))) {
      return ((avqg)this.jdField_a_of_type_Avqe).a;
    }
    return null;
  }
  
  public void a(sko paramsko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramsko.a());
    }
    if ((this.jdField_a_of_type_Akgy != null) && (paramsko != null))
    {
      this.jdField_a_of_type_Akgy.b(((Integer)paramsko.a()).intValue(), paramsko.a());
      int i = this.jdField_a_of_type_Akgy.b();
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
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
      paramView.setBackgroundResource(2130839216);
      return;
    }
    paramView.setBackgroundResource(2130849570);
  }
  
  public void c(sko paramsko) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhq
 * JD-Core Version:    0.7.0.1
 */