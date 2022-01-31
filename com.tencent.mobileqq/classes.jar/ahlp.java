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

public class ahlp
  extends ahga<MessageRecord>
{
  public ahlp(TroopSuspiciousFragment paramTroopSuspiciousFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void a(ahgk paramahgk, MessageRecord paramMessageRecord, int paramInt)
  {
    TroopSuspiciousFragment.a(this.a, paramahgk, paramMessageRecord, paramInt);
  }
  
  protected ahgk b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new ahkp(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131372910));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372900));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131372907));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372914));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372905));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372911));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131372913));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131372906));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131372909));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131378419));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131378418);
    ahlw.a(paramContext.a(), false);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlp
 * JD-Core Version:    0.7.0.1
 */