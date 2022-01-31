import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class afbo
  implements View.OnClickListener
{
  afbo(afbk paramafbk) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    if ((paramView == null) || (TextUtils.isEmpty(paramView.uin)))
    {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
      return;
    }
    ajqt.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, paramView.uin, new afbp(this));
    this.a.b.remove(paramView);
    this.a.notifyDataSetChanged();
    if ((this.a.b != null) && (this.a.b.size() == 0)) {
      this.a.jdField_a_of_type_Afaw.a().sendEmptyMessage(100);
    }
    if (afbk.a(this.a) != null)
    {
      ajqt localajqt = (ajqt)afbk.a(this.a).getManager(22);
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        localajqt.a(1);
      }
      localajqt.a(paramView.uin);
    }
    awqx.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, paramView.uin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afbo
 * JD-Core Version:    0.7.0.1
 */