import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class afnc
  implements View.OnClickListener
{
  afnc(afmy paramafmy) {}
  
  public void onClick(View paramView)
  {
    paramView = (RecommendTroopItem)paramView.getTag(-1);
    if ((paramView == null) || (TextUtils.isEmpty(paramView.uin)))
    {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
      return;
    }
    akfc.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, paramView.uin, new afnd(this));
    this.a.b.remove(paramView);
    this.a.notifyDataSetChanged();
    if ((this.a.b != null) && (this.a.b.size() == 0)) {
      this.a.jdField_a_of_type_Afmk.a().sendEmptyMessage(100);
    }
    if (afmy.a(this.a) != null)
    {
      akfc localakfc = (akfc)afmy.a(this.a).getManager(22);
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        localakfc.a(1);
      }
      localakfc.a(paramView.uin);
    }
    axqy.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, paramView.uin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afnc
 * JD-Core Version:    0.7.0.1
 */