import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajet
  implements View.OnClickListener
{
  ajet(ajep paramajep) {}
  
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
      aoce.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, localRecommendTroopItem.uin, new ajeu(this));
      this.a.b.remove(localRecommendTroopItem);
      this.a.notifyDataSetChanged();
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        this.a.jdField_a_of_type_Ajdx.a().sendEmptyMessage(100);
      }
      if (ajep.a(this.a) != null)
      {
        aoce localaoce = (aoce)ajep.a(this.a).getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
        if ((this.a.b != null) && (this.a.b.size() == 0)) {
          localaoce.a(1);
        }
        localaoce.a(localRecommendTroopItem.uin);
      }
      bdla.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, localRecommendTroopItem.uin, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajet
 * JD-Core Version:    0.7.0.1
 */