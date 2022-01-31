import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class afne
  implements View.OnClickListener
{
  afne(afna paramafna) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    if ((paramView == null) || (TextUtils.isEmpty(paramView.uin)))
    {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
      return;
    }
    akfd.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, paramView.uin, new afnf(this));
    this.a.b.remove(paramView);
    this.a.notifyDataSetChanged();
    if ((this.a.b != null) && (this.a.b.size() == 0)) {
      this.a.jdField_a_of_type_Afmm.a().sendEmptyMessage(100);
    }
    if (afna.a(this.a) != null)
    {
      akfd localakfd = (akfd)afna.a(this.a).getManager(22);
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        localakfd.a(1);
      }
      localakfd.a(paramView.uin);
    }
    axqw.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, paramView.uin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afne
 * JD-Core Version:    0.7.0.1
 */