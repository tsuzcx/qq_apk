import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import java.util.ArrayList;

class ahqh
  implements ahun
{
  ahqh(ahqg paramahqg) {}
  
  public void a(Intent paramIntent)
  {
    ahqg.a(this.a).a(ahqg.a(this.a).hashCode(), paramIntent);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = ahqg.a(this.a).a(ahqg.a(this.a).hashCode());
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
    if ((ahqg.a(this.a).panelicons != null) && (!ahqg.a(this.a).receiptMode))
    {
      boolean bool = nty.a().a(ahqg.a(this.a).sessionInfo.curFriendUin);
      if (ahqg.a(this.a).getCurrentPanel() == 4) {}
      localPanelIconLinearLayout = ahqg.a(this.a).panelicons;
      if (!bool) {
        break label182;
      }
    }
    label182:
    for (localObject = ahpt.m;; localObject = ahpt.l)
    {
      localPanelIconLinearLayout.a((int[])localObject, i);
      if ((i > 0) && (!ahqg.a(this.a).getFunBtnEnable())) {
        ahqg.a(this.a).setFunBtnEnabled(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqh
 * JD-Core Version:    0.7.0.1
 */