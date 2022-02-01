import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aahj
  extends aacq
{
  private aabn jdField_a_of_type_Aabn;
  private RelativePersonalBottomView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  
  public aahj(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.b();
    }
    return 0;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView = new RelativePersonalBottomView(paramViewGroup.getContext(), paramaabp);
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView;
  }
  
  public void loadData(aabu paramaabu) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(this.jdField_a_of_type_Aabn);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void setShareData(String paramString, aabn paramaabn)
  {
    super.setShareData(paramString, paramaabn);
    this.jdField_a_of_type_Aabn = paramaabn;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalBottomView.a(paramaabn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahj
 * JD-Core Version:    0.7.0.1
 */