import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class aahg
  extends aabp<SubscribeDraftBean>
  implements aaam
{
  public static int a;
  public static String a;
  private int jdField_b_of_type_Int = ImmersiveUtils.a(19.0F);
  private String jdField_b_of_type_JavaLangString;
  private int c = ImmersiveUtils.a(3.0F);
  
  static
  {
    jdField_a_of_type_JavaLangString = "SubscribeDraftAdapter";
    jdField_a_of_type_Int = ImmersiveUtils.a(4.0F);
  }
  
  public aahg(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public void a()
  {
    if ((getBlockMerger() != null) && (getContext() != null) && (((PublicFragmentActivity)getContext()).app != null))
    {
      this.jdField_b_of_type_JavaLangString = ((PublicFragmentActivity)getContext()).app.getAccount();
      if (aanf.a().a(this.jdField_b_of_type_JavaLangString)) {
        aanf.a().a(this.jdField_b_of_type_JavaLangString, new aahh(this));
      }
    }
    else
    {
      return;
    }
    clearData();
    notifyDataSetChanged();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubDraftChangeEvent.class);
    return localArrayList;
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (((StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams()).getSpanIndex() % 2 == 0) {
      paramRect.left = jdField_a_of_type_Int;
    }
    for (paramRect.right = (this.c / 2);; paramRect.right = jdField_a_of_type_Int)
    {
      paramRect.bottom = this.jdField_b_of_type_Int;
      return;
      paramRect.left = (this.c / 2);
    }
  }
  
  public int getSpanCount(int paramInt)
  {
    return 2;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEnableRefresh()
  {
    return true;
  }
  
  public void loadData(aabu paramaabu)
  {
    if ((paramaabu.d()) || (paramaabu.c())) {
      a();
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof aahi)) {
      ((aahi)paramViewHolder).a((SubscribeDraftBean)getDataList().get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new aahi(this, new SubScribeDraftItemView(paramViewGroup.getContext(), this));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    aaak.a().b(this);
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubDraftChangeEvent)) {
      a();
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    aaak.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahg
 * JD-Core Version:    0.7.0.1
 */