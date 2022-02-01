import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class afqe
  extends BaseAdapter
{
  public afqe(BabyQAIOPanel paramBabyQAIOPanel) {}
  
  public afqc a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < BabyQAIOPanel.a(this.a).size())) {
      return (afqc)BabyQAIOPanel.a(this.a).get(paramInt);
    }
    return new afqc();
  }
  
  public int getCount()
  {
    return BabyQAIOPanel.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new afqd();
      localView = LayoutInflater.from(BabyQAIOPanel.a(this.a)).inflate(2131558602, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131369110));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368407));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378673));
      paramView.b = ((ImageView)localView.findViewById(2131371913));
      localView.setTag(paramView);
      localObject = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt % 2 == 0) {
        break label271;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.a.getContext(), 8.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this.a.getContext(), 12.0F);
      label145:
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a(paramInt);
      paramView.jdField_a_of_type_Int = ((afqc)localObject).jdField_a_of_type_Int;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((afqc)localObject).jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((afqc)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!((afqc)localObject).jdField_a_of_type_Boolean) {
        break label308;
      }
      paramView.b.setVisibility(0);
    }
    for (;;)
    {
      localView.setOnClickListener(this.a);
      if (AppSetting.c) {
        localView.setContentDescription(((afqc)localObject).jdField_a_of_type_JavaLangString);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (afqd)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label271:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.a.getContext(), 12.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this.a.getContext(), 8.0F);
      break label145;
      label308:
      paramView.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqe
 * JD-Core Version:    0.7.0.1
 */