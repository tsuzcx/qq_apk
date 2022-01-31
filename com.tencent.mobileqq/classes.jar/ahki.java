import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ahki
  implements View.OnClickListener
{
  ahki(ahke paramahke) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    if ((paramView == null) || (TextUtils.isEmpty(paramView.uin)))
    {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
      return;
    }
    alws.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, paramView.uin, new ahkj(this));
    this.a.b.remove(paramView);
    this.a.notifyDataSetChanged();
    if ((this.a.b != null) && (this.a.b.size() == 0)) {
      this.a.jdField_a_of_type_Ahjp.a().sendEmptyMessage(100);
    }
    if (ahke.a(this.a) != null)
    {
      alws localalws = (alws)ahke.a(this.a).getManager(22);
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        localalws.a(1);
      }
      localalws.a(paramView.uin);
    }
    azmj.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, paramView.uin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */