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

public class ajgz
  extends ajdm<MessageRecord>
{
  public ajgz(TroopSuspiciousFragment paramTroopSuspiciousFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ajdw a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new ajfc(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373819));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373803));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373811));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373823));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373809));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373820));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131373822));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131373810));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131373818));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131379575));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131379574);
    ajhg.a(paramContext.a(), false);
    return paramContext;
  }
  
  protected void a(ajdw paramajdw, MessageRecord paramMessageRecord, int paramInt)
  {
    TroopSuspiciousFragment.a(this.a, paramajdw, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgz
 * JD-Core Version:    0.7.0.1
 */