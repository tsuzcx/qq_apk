import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public abstract class aacn
  extends aabp
{
  private HorizontalRvInnerView a;
  
  public aacn(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public abstract int a();
  
  public abstract aaco a(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public abstract void a(HorizontalRvInnerView paramHorizontalRvInnerView);
  
  protected boolean a()
  {
    return false;
  }
  
  public int getItemCount()
  {
    if ((!a()) || (getDataList().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder.itemView instanceof HorizontalRvInnerView)) {
      this.a.setData(getDataList());
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = new HorizontalRvInnerView(paramViewGroup.getContext(), this);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup = new aabt(this, this.a);
    paramViewGroup.setIsRecyclable(false);
    a(this.a);
    return paramViewGroup;
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    getDataList().clear();
    getDataList().addAll(paramArrayList);
    if (this.a != null) {
      this.a.setData(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacn
 * JD-Core Version:    0.7.0.1
 */