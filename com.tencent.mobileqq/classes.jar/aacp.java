import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aacp
  extends aabs
{
  public aacp(HorizontalRvInnerView paramHorizontalRvInnerView) {}
  
  public aaco a(ViewGroup paramViewGroup, int paramInt)
  {
    if (HorizontalRvInnerView.a(this.a) != null) {
      return HorizontalRvInnerView.a(this.a).a(paramViewGroup, paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (HorizontalRvInnerView.a(this.a) != null) {
      return HorizontalRvInnerView.a(this.a).a();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((!blgn.a(paramInt, this.mDataList)) && (HorizontalRvInnerView.a(this.a) != null)) {
      HorizontalRvInnerView.a(this.a).a(paramViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacp
 * JD-Core Version:    0.7.0.1
 */