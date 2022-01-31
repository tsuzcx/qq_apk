import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

public class acdo
  implements aggr
{
  public acdo(BaseChatPie paramBaseChatPie) {}
  
  public void a(Intent paramIntent)
  {
    ((afaz)this.a.jdField_a_of_type_Afag.a(7)).a(this.a.hashCode(), paramIntent);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = ((afaz)this.a.jdField_a_of_type_Afag.a(7)).a(this.a.hashCode());
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (((Intent)localObject).hasExtra("PhotoConst.SELECTED_PATHS"))
      {
        localObject = ((Intent)localObject).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        i = paramInt;
        if (localObject != null) {
          i = ((ArrayList)localObject).size();
        }
      }
    }
    PanelIconLinearLayout localPanelIconLinearLayout;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!this.a.K))
    {
      boolean bool = nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4)) {}
      localPanelIconLinearLayout = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      if (!bool) {
        break label179;
      }
    }
    label179:
    for (localObject = agci.m;; localObject = agci.l)
    {
      localPanelIconLinearLayout.a((int[])localObject, i);
      if ((i > 0) && (!this.a.B())) {
        this.a.a(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdo
 * JD-Core Version:    0.7.0.1
 */