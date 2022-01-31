import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class aezz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public ProgressBar a;
  public RadioButton a;
  public RelativeLayout a;
  public BubbleImageView a;
  public WeakReference<afac> a;
  
  public aezz(ZhituPanelView paramZhituPanelView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramView.findViewById(2131375246));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(5.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = false;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131375247));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131375248));
    this.jdField_a_of_type_AndroidWidgetRadioButton.setOnCheckedChangeListener(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      onClick(paramCompoundButton);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = (afac)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramView == null) || (paramView.jdField_a_of_type_JavaLangString == null) || (paramView.jdField_a_of_type_Afad == null) || (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).a == null)) {}
    while (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) == paramView) {
      return;
    }
    Iterator localIterator = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).a.iterator();
    while (localIterator.hasNext()) {
      ((afac)localIterator.next()).d = false;
    }
    paramView.d = true;
    ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setVisibility(0);
    ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setEnabled(true);
    if (!paramView.b)
    {
      ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramView);
      ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).notifyDataSetChanged();
      return;
    }
    aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.a).d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezz
 * JD-Core Version:    0.7.0.1
 */