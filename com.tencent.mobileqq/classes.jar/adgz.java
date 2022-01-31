import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.OnHolderItemClickListener;

public class adgz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  public OnHolderItemClickListener a;
  public ImageView d;
  
  public adgz(HotPicPageView paramHotPicPageView, View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    if (paramOnHolderItemClickListener != null)
    {
      this.a = paramOnHolderItemClickListener;
      this.d = ((ImageView)paramView.findViewById(2131362976));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramOnHolderItemClickListener);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(paramView, getPosition());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    if (this.a != null)
    {
      this.a.b(paramView, getPosition());
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adgz
 * JD-Core Version:    0.7.0.1
 */