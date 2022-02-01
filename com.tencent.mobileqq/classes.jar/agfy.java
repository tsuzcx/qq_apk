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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class agfy
  extends BaseAdapter
{
  public agfy(BabyQAIOPanel paramBabyQAIOPanel) {}
  
  public agfw a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < BabyQAIOPanel.a(this.a).size())) {
      return (agfw)BabyQAIOPanel.a(this.a).get(paramInt);
    }
    return new agfw();
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
      paramView = new agfx();
      localView = LayoutInflater.from(BabyQAIOPanel.a(this.a)).inflate(2131558587, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368923));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368238));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378618));
      paramView.b = ((ImageView)localView.findViewById(2131371761));
      localView.setTag(paramView);
      localObject = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt % 2 == 0) {
        break label271;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bhgr.a(this.a.getContext(), 8.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = bhgr.a(this.a.getContext(), 12.0F);
      label145:
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a(paramInt);
      paramView.jdField_a_of_type_Int = ((agfw)localObject).jdField_a_of_type_Int;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((agfw)localObject).jdField_a_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((agfw)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!((agfw)localObject).jdField_a_of_type_Boolean) {
        break label308;
      }
      paramView.b.setVisibility(0);
    }
    for (;;)
    {
      localView.setOnClickListener(this.a);
      if (AppSetting.c) {
        localView.setContentDescription(((agfw)localObject).jdField_a_of_type_JavaLangString);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (agfx)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label271:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bhgr.a(this.a.getContext(), 12.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = bhgr.a(this.a.getContext(), 8.0F);
      break label145;
      label308:
      paramView.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfy
 * JD-Core Version:    0.7.0.1
 */