import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class ajqk
  extends ajoe<MessageRecord>
{
  public ajqk(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ajoo a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new ajpp(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373680));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373670));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373677));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373684));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373675));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373681));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131373683));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131373676));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131373679));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131379495));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131379494);
    ajrj.a(paramContext.a(), false);
    return paramContext;
  }
  
  protected void a(ajoo paramajoo, MessageRecord paramMessageRecord, int paramInt)
  {
    TroopNotifyAndRecommendView.a(this.a, paramajoo, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqk
 * JD-Core Version:    0.7.0.1
 */