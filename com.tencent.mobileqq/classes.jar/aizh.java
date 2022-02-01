import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aizh
  extends aiyi
  implements tja
{
  public aizh(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Ajae.c();
    int i = this.jdField_a_of_type_Ajae.b();
    aizi localaizi;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizi)))
    {
      localaizi = new aizi();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561327, null);
      localaizi.a = ((ThemeTabLayout)paramView.findViewById(2131378206));
      localaizi.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Ajax != null) || ((this.jdField_a_of_type_Ajax instanceof ajaz))) {
        localaizi.a.a(((ajaz)this.jdField_a_of_type_Ajax).a, i);
      }
      localaizi.a.setOnTabSelectedListener(this);
      paramView.setTag(localaizi);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localaizi != null) && (localaizi.a != null) && ((this.jdField_a_of_type_Ajax != null) || ((this.jdField_a_of_type_Ajax instanceof ajaz))))
      {
        ArrayList localArrayList = ((ajaz)this.jdField_a_of_type_Ajax).a;
        localaizi.a.b(localArrayList, i);
      }
      return paramView;
      localaizi = (aizi)paramView.getTag();
    }
  }
  
  public ArrayList<aixh> a()
  {
    if ((this.jdField_a_of_type_Ajax != null) || ((this.jdField_a_of_type_Ajax instanceof ajaz))) {
      return ((ajaz)this.jdField_a_of_type_Ajax).a;
    }
    return null;
  }
  
  public void a(tjf paramtjf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramtjf.a());
    }
    if ((this.jdField_a_of_type_Ajae != null) && (paramtjf != null))
    {
      this.jdField_a_of_type_Ajae.b(((Integer)paramtjf.a()).intValue(), paramtjf.a());
      int i = this.jdField_a_of_type_Ajae.b();
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(tjf paramtjf) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839394);
      return;
    }
    paramView.setBackgroundResource(2130850219);
  }
  
  public void c(tjf paramtjf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizh
 * JD-Core Version:    0.7.0.1
 */