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

public class afoh
  extends afiv<MessageRecord>
{
  public afoh(TroopSuspiciousFragment paramTroopSuspiciousFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void a(afjf paramafjf, MessageRecord paramMessageRecord, int paramInt)
  {
    TroopSuspiciousFragment.a(this.a, paramafjf, paramMessageRecord, paramInt);
  }
  
  protected afjf b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new afnj(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131372553));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372543));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131372550));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372557));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372548));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372554));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131372556));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131372549));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131372552));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131377874));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131377873);
    afoo.a(paramContext.a(), false);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afoh
 * JD-Core Version:    0.7.0.1
 */