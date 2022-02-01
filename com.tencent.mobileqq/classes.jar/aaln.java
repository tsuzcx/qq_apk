import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aaln
  extends zxx
{
  public aaln(CommodityListView paramCommodityListView) {}
  
  public zxy a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(this.a.getContext());
    paramViewGroup.setIsPublishUI(CommodityListView.a(this.a));
    paramViewGroup.setCurrentFeed(CommodityListView.a(this.a));
    return new zxy(this, paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!bkfj.a(paramInt, this.mDataList))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(this.mDataList.get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).b().setOnClickListener(new aalo(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaln
 * JD-Core Version:    0.7.0.1
 */