import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class afcs
  extends aexh<MessageRecord>
{
  public afcs(TroopSuspiciousFragment paramTroopSuspiciousFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void a(aexr paramaexr, MessageRecord paramMessageRecord, int paramInt)
  {
    TroopSuspiciousFragment.a(this.a, paramaexr, paramMessageRecord, paramInt);
  }
  
  protected aexr b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new afbv(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131306841));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131306831));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131306838));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131306845));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131306836));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131306842));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131306844));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131306837));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131306840));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131312047));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131312046);
    afcz.a(paramContext.a(), false);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afcs
 * JD-Core Version:    0.7.0.1
 */