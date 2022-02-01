import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import java.util.ArrayList;

class ahre
  implements ahvj
{
  ahre(ahrd paramahrd) {}
  
  public void a(Intent paramIntent)
  {
    ahrd.a(this.a).a(ahrd.a(this.a).hashCode(), paramIntent);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = ahrd.a(this.a).a(ahrd.a(this.a).hashCode());
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
    if ((ahrd.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!ahrd.a(this.a).J))
    {
      boolean bool = njo.a().a(ahrd.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (ahrd.a(this.a).g() == 4) {}
      localPanelIconLinearLayout = ahrd.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      if (!bool) {
        break label182;
      }
    }
    label182:
    for (localObject = ahqr.m;; localObject = ahqr.l)
    {
      localPanelIconLinearLayout.a((int[])localObject, i);
      if ((i > 0) && (!ahrd.a(this.a).B())) {
        ahrd.a(this.a).a(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahre
 * JD-Core Version:    0.7.0.1
 */