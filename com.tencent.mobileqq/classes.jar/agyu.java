import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbListAdapter.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agyu
  extends RecyclerView.Adapter<agyv>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<RedPackGrapInfo> jdField_a_of_type_JavaUtilList;
  
  public agyu(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public agyv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new agyv(this, new agyw(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList, this.jdField_a_of_type_AndroidContentContext, new adxz(TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), this.jdField_a_of_type_AndroidContentContext, TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList))));
  }
  
  public void a(agyv paramagyv, int paramInt)
  {
    RedPackGrapInfo localRedPackGrapInfo = (RedPackGrapInfo)this.jdField_a_of_type_JavaUtilList.get(paramagyv.getPosition());
    if (localRedPackGrapInfo == null) {}
    do
    {
      return;
      paramagyv = paramagyv.a;
    } while (paramagyv == null);
    paramagyv.a(localRedPackGrapInfo);
  }
  
  void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label233;
        }
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label234;
        }
        return;
      }
      catch (Throwable paramString)
      {
        RedPackGrapInfo localRedPackGrapInfo;
        int j;
        if (!QLog.isColorLevel()) {
          break label233;
        }
        QLog.e(TroopUnAccalimedRedPacketList.b(), 2, "removeHbList occur an exception: " + paramString);
        return;
        i += 1;
        continue;
        TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList).postDelayed(new TroopUnAccalimedRedPacketList.HbListAdapter.1(this), 300L);
        return;
        i = 0;
        continue;
      }
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localRedPackGrapInfo = (RedPackGrapInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localRedPackGrapInfo != null) && (localRedPackGrapInfo.sBiilNo.equals(paramString)))
        {
          j = i;
          if (i == this.jdField_a_of_type_JavaUtilList.size()) {
            j = i - 1;
          }
          this.jdField_a_of_type_JavaUtilList.remove(j);
          notifyItemRemoved(j);
          notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size());
          if (TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList) == null) {
            break label233;
          }
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList.a == null) {
            break label233;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList.a.dismiss();
        }
      }
      label233:
      return;
      label234:
      int i = 0;
    }
  }
  
  void a(List<RedPackGrapInfo> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agyu
 * JD-Core Version:    0.7.0.1
 */