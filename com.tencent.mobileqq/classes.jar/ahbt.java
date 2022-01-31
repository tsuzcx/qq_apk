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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class ahbt
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public ProgressBar a;
  public RadioButton a;
  public RelativeLayout a;
  public BubbleImageView a;
  public WeakReference<ahbw> a;
  
  public ahbt(ZhituPanelView paramZhituPanelView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramView.findViewById(2131375779));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(5.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = false;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131375780));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131375781));
    this.jdField_a_of_type_AndroidWidgetRadioButton.setOnCheckedChangeListener(this);
    if (paramZhituPanelView.a() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() == 1) {}
    while (!paramBoolean) {
      return;
    }
    onClick(paramCompoundButton);
  }
  
  public void onClick(View paramView)
  {
    paramView = (ahbw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramView == null) || (paramView.jdField_a_of_type_JavaLangString == null) || (paramView.jdField_a_of_type_Ahbx == null) || (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).a == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != 1) {
          break;
        }
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramView);
        paramView = ahbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView == null));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.b();
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ACA1", "0X800ACA1", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, "", "", "", "");
      return;
    } while (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) == paramView);
    Iterator localIterator = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).a.iterator();
    while (localIterator.hasNext()) {
      ((ahbw)localIterator.next()).d = false;
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
    ahbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbt
 * JD-Core Version:    0.7.0.1
 */