import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import java.util.ArrayList;

class aias
  implements aiex
{
  aias(aiar paramaiar) {}
  
  public void a(Intent paramIntent)
  {
    aiar.a(this.a).a(aiar.a(this.a).hashCode(), paramIntent);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = aiar.a(this.a).a(aiar.a(this.a).hashCode());
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
    if ((aiar.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!aiar.a(this.a).J))
    {
      boolean bool = nlj.a().a(aiar.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (aiar.a(this.a).g() == 4) {}
      localPanelIconLinearLayout = aiar.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      if (!bool) {
        break label182;
      }
    }
    label182:
    for (localObject = aiaf.m;; localObject = aiaf.l)
    {
      localPanelIconLinearLayout.a((int[])localObject, i);
      if ((i > 0) && (!aiar.a(this.a).B())) {
        aiar.a(this.a).a(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aias
 * JD-Core Version:    0.7.0.1
 */