import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;

public class agmv
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnTouchListener
{
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public RoundRectImageView a;
  
  public agmv(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView, @NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369050));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367361));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367358));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131369053));
    paramView.setOnClickListener(this);
    paramView.setOnTouchListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (IntimateContentItemNewDnaView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView) != null) {
      IntimateContentItemNewDnaView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView).a(paramView, getLayoutPosition(), (agmf)this.itemView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmv
 * JD-Core Version:    0.7.0.1
 */