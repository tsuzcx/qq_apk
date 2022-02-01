import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajkq
  extends ajjr
  implements szu
{
  public ajkq(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  public View a(int paramInt, View paramView)
  {
    paramInt = this.jdField_a_of_type_Ajln.c();
    int i = this.jdField_a_of_type_Ajln.b();
    ajkr localajkr;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajkr)))
    {
      localajkr = new ajkr();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561365, null);
      localajkr.a = ((ThemeTabLayout)paramView.findViewById(2131378363));
      localajkr.a.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView new ConnectionsTabLayout tabPosition  ->" + paramInt + ", tabId =" + i);
      }
      if ((this.jdField_a_of_type_Ajmf != null) || ((this.jdField_a_of_type_Ajmf instanceof ajmh))) {
        localajkr.a.a(((ajmh)this.jdField_a_of_type_Ajmf).a, i);
      }
      localajkr.a.setOnTabSelectedListener(this);
      paramView.setTag(localajkr);
    }
    for (;;)
    {
      c(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendSlideTabBuilder", 2, "getView update tabPosition = " + paramInt + ", tabId =" + i);
      }
      if ((localajkr != null) && (localajkr.a != null) && ((this.jdField_a_of_type_Ajmf != null) || ((this.jdField_a_of_type_Ajmf instanceof ajmh))))
      {
        ArrayList localArrayList = ((ajmh)this.jdField_a_of_type_Ajmf).a;
        localajkr.a.b(localArrayList, i);
      }
      return paramView;
      localajkr = (ajkr)paramView.getTag();
    }
  }
  
  public ArrayList<ajiq> a()
  {
    if ((this.jdField_a_of_type_Ajmf != null) || ((this.jdField_a_of_type_Ajmf instanceof ajmh))) {
      return ((ajmh)this.jdField_a_of_type_Ajmf).a;
    }
    return null;
  }
  
  public void a(szz paramszz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendSlideTabBuilder", 2, "builder onTabSelected tab ->" + paramszz.a());
    }
    if ((this.jdField_a_of_type_Ajln != null) && (paramszz != null))
    {
      this.jdField_a_of_type_Ajln.b(((Integer)paramszz.a()).intValue(), paramszz.a());
      int i = this.jdField_a_of_type_Ajln.b();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_recom", "frd_tab_clk", i, 0, "0", "3", "", "");
    }
  }
  
  public void b(szz paramszz) {}
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839402);
      return;
    }
    paramView.setBackgroundResource(2130850231);
  }
  
  public void c(szz paramszz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkq
 * JD-Core Version:    0.7.0.1
 */