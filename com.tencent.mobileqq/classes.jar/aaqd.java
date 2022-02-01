import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aaqd
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<CertifiedAccountMeta.StQQGroup> jdField_a_of_type_JavaUtilList;
  
  public aaqd(List<CertifiedAccountMeta.StQQGroup> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt))
    {
      aaqe localaaqe = (aaqe)paramViewHolder;
      if (localaaqe != null) {
        localaaqe.a((CertifiedAccountMeta.StQQGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558782, paramViewGroup, false);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1)) {
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
    return new aaqe(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqd
 * JD-Core Version:    0.7.0.1
 */