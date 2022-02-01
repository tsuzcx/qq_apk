import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbListAdapter.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class alae
  extends RecyclerView.Adapter<alaf>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<RedPackGrapInfo> jdField_a_of_type_JavaUtilList;
  
  public alae(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public alaf a(ViewGroup paramViewGroup, int paramInt)
  {
    return new alaf(this, new alag(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList, this.jdField_a_of_type_AndroidContentContext, new ahpr(TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), this.jdField_a_of_type_AndroidContentContext, TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList))));
  }
  
  public void a(alaf paramalaf, int paramInt)
  {
    RedPackGrapInfo localRedPackGrapInfo = (RedPackGrapInfo)this.jdField_a_of_type_JavaUtilList.get(paramalaf.getPosition());
    if (localRedPackGrapInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramalaf, paramInt, getItemId(paramInt));
      return;
      alag localalag = paramalaf.a;
      if (localalag != null) {
        localalag.a(localRedPackGrapInfo);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alae
 * JD-Core Version:    0.7.0.1
 */