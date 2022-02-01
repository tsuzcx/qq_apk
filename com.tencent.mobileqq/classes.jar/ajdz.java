import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajdz
  implements View.OnClickListener
{
  ajdz(ajdv paramajdv) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    if ((localRecommendTroopItem == null) || (TextUtils.isEmpty(localRecommendTroopItem.uin))) {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      antq.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, localRecommendTroopItem.uin, new ajea(this));
      this.a.b.remove(localRecommendTroopItem);
      this.a.notifyDataSetChanged();
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        this.a.jdField_a_of_type_Ajdg.a().sendEmptyMessage(100);
      }
      if (ajdv.a(this.a) != null)
      {
        antq localantq = (antq)ajdv.a(this.a).getManager(22);
        if ((this.a.b != null) && (this.a.b.size() == 0)) {
          localantq.a(1);
        }
        localantq.a(localRecommendTroopItem.uin);
      }
      bcst.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, localRecommendTroopItem.uin, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdz
 * JD-Core Version:    0.7.0.1
 */