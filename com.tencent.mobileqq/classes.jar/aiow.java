import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class aiow
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public ProgressBar a;
  public RadioButton a;
  public RelativeLayout a;
  public BubbleImageView a;
  public WeakReference<aioz> a;
  
  public aiow(ZhituPanelView paramZhituPanelView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramView.findViewById(2131376660));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(5.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = false;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131376661));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131376662));
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
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean) {
        onClick(paramCompoundButton);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (aioz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject == null) || (((aioz)localObject).jdField_a_of_type_JavaLangString == null) || (((aioz)localObject).jdField_a_of_type_Aipa == null) || (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).a == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() == 1)
      {
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, (aioz)localObject);
        localObject = aioi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.app);
        if ((localObject != null) && (((aioi)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null))
        {
          ((aioi)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.b();
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.app, "dc00898", "", "", "0X800ACA1", "0X800ACA1", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.sessionInfo.curType, 0, "", "", "", "");
        }
      }
      else if (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != localObject)
      {
        Iterator localIterator = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).a.iterator();
        while (localIterator.hasNext()) {
          ((aioz)localIterator.next()).d = false;
        }
        ((aioz)localObject).d = true;
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setVisibility(0);
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setEnabled(true);
        if (!((aioz)localObject).b)
        {
          ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, (aioz)localObject);
          ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).notifyDataSetChanged();
        }
        else
        {
          aioi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.app).d((aioz)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiow
 * JD-Core Version:    0.7.0.1
 */