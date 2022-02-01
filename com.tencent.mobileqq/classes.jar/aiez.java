import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aiez
  extends aiea
  implements tdu
{
  public aiez(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Aifw.c();
    int i = this.jdField_a_of_type_Aifw.b();
    aifa localaifa;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifa)))
    {
      localaifa = new aifa();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561240, null);
      localaifa.a = ((ThemeTabLayout)paramView.findViewById(2131378130));
      localaifa.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Aigo != null) || ((this.jdField_a_of_type_Aigo instanceof aigq))) {
        localaifa.a.a(((aigq)this.jdField_a_of_type_Aigo).a, i);
      }
      localaifa.a.setOnTabSelectedListener(this);
      paramView.setTag(localaifa);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localaifa != null) && (localaifa.a != null) && ((this.jdField_a_of_type_Aigo != null) || ((this.jdField_a_of_type_Aigo instanceof aigq))))
      {
        ArrayList localArrayList = ((aigq)this.jdField_a_of_type_Aigo).a;
        localaifa.a.b(localArrayList, i);
      }
      return paramView;
      localaifa = (aifa)paramView.getTag();
    }
  }
  
  public ArrayList<aicz> a()
  {
    if ((this.jdField_a_of_type_Aigo != null) || ((this.jdField_a_of_type_Aigo instanceof aigq))) {
      return ((aigq)this.jdField_a_of_type_Aigo).a;
    }
    return null;
  }
  
  public void a(tdz paramtdz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramtdz.a());
    }
    if ((this.jdField_a_of_type_Aifw != null) && (paramtdz != null))
    {
      this.jdField_a_of_type_Aifw.b(((Integer)paramtdz.a()).intValue(), paramtdz.a());
      int i = this.jdField_a_of_type_Aifw.b();
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(tdz paramtdz) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839437);
      return;
    }
    paramView.setBackgroundResource(2130850152);
  }
  
  public void c(tdz paramtdz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiez
 * JD-Core Version:    0.7.0.1
 */