import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import java.util.ArrayList;

class agxh
  implements ahbn
{
  agxh(agxg paramagxg) {}
  
  public void a(Intent paramIntent)
  {
    agxg.a(this.a).a(agxg.a(this.a).hashCode(), paramIntent);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = agxg.a(this.a).a(agxg.a(this.a).hashCode());
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
    if ((agxg.a(this.a).panelicons != null) && (!agxg.a(this.a).receiptMode))
    {
      boolean bool = nmy.a().a(agxg.a(this.a).sessionInfo.curFriendUin);
      if (agxg.a(this.a).getCurrentPanel() == 4) {}
      localPanelIconLinearLayout = agxg.a(this.a).panelicons;
      if (!bool) {
        break label182;
      }
    }
    label182:
    for (localObject = agwt.m;; localObject = agwt.l)
    {
      localPanelIconLinearLayout.a((int[])localObject, i);
      if ((i > 0) && (!agxg.a(this.a).getFunBtnEnable())) {
        agxg.a(this.a).setFunBtnEnabled(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxh
 * JD-Core Version:    0.7.0.1
 */