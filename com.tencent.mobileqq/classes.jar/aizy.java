import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aizy
  extends aiyz
  implements trf
{
  public aizy(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Ajav.c();
    int i = this.jdField_a_of_type_Ajav.b();
    aizz localaizz;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizz)))
    {
      localaizz = new aizz();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561301, null);
      localaizz.a = ((ThemeTabLayout)paramView.findViewById(2131378418));
      localaizz.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Ajbn != null) || ((this.jdField_a_of_type_Ajbn instanceof ajbp))) {
        localaizz.a.a(((ajbp)this.jdField_a_of_type_Ajbn).a, i);
      }
      localaizz.a.setOnTabSelectedListener(this);
      paramView.setTag(localaizz);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localaizz != null) && (localaizz.a != null) && ((this.jdField_a_of_type_Ajbn != null) || ((this.jdField_a_of_type_Ajbn instanceof ajbp))))
      {
        ArrayList localArrayList = ((ajbp)this.jdField_a_of_type_Ajbn).a;
        localaizz.a.b(localArrayList, i);
      }
      return paramView;
      localaizz = (aizz)paramView.getTag();
    }
  }
  
  public ArrayList<aixy> a()
  {
    if ((this.jdField_a_of_type_Ajbn != null) || ((this.jdField_a_of_type_Ajbn instanceof ajbp))) {
      return ((ajbp)this.jdField_a_of_type_Ajbn).a;
    }
    return null;
  }
  
  public void a(trk paramtrk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramtrk.a());
    }
    if ((this.jdField_a_of_type_Ajav != null) && (paramtrk != null))
    {
      this.jdField_a_of_type_Ajav.b(((Integer)paramtrk.a()).intValue(), paramtrk.a());
      int i = this.jdField_a_of_type_Ajav.b();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(trk paramtrk) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839458);
      return;
    }
    paramView.setBackgroundResource(2130850254);
  }
  
  public void c(trk paramtrk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizy
 * JD-Core Version:    0.7.0.1
 */