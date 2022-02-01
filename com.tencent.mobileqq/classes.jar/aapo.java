import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aapo
  extends aabs
{
  public aapo(CommodityListView paramCommodityListView) {}
  
  public aabt a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(this.a.getContext());
    paramViewGroup.setIsPublishUI(CommodityListView.a(this.a));
    paramViewGroup.setCurrentFeed(CommodityListView.a(this.a));
    return new aabt(this, paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!blgn.a(paramInt, this.mDataList))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(this.mDataList.get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).a().setOnClickListener(new aapp(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapo
 * JD-Core Version:    0.7.0.1
 */