import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;

class aahi
  extends RecyclerView.ViewHolder
{
  public aahi(aahg paramaahg, View paramView)
  {
    super(paramView);
  }
  
  public void a(SubscribeDraftBean paramSubscribeDraftBean)
  {
    if ((this.itemView instanceof SubScribeDraftItemView)) {
      ((SubScribeDraftItemView)this.itemView).setData(paramSubscribeDraftBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahi
 * JD-Core Version:    0.7.0.1
 */