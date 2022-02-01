import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class ailf
  extends aike<MessageRecord>
{
  public ailf(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected aiix a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = new bjtz();
    paramViewGroup = this.jdField_a_of_type_Aijb.a(paramContext, paramInt, (bjtz)localObject);
    paramContext = new aikf(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_Bjtz = ((bjtz)localObject);
    localObject = new aiji();
    ((aiji)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131373587);
    ((aiji)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((aiji)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373599));
    ((aiji)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((aiji)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373600));
    ((aiji)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((aiji)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373596));
    paramContext.jdField_a_of_type_Aiji = ((aiji)localObject);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373602));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373586));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373594));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373606));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373592));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373603));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131373605));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131373593));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131373601));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131379271));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131379270);
    aimg.a(paramContext.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    return paramContext;
  }
  
  protected void a(aiix paramaiix, MessageRecord paramMessageRecord, int paramInt)
  {
    if (!(paramaiix instanceof aikf)) {
      return;
    }
    aikf localaikf = (aikf)paramaiix;
    this.jdField_a_of_type_Aijb.a(this.jdField_a_of_type_AndroidContentContext, paramaiix.itemView, paramInt, paramMessageRecord, localaikf.jdField_a_of_type_Bjtz, new ailg(this), this.d);
    TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView, paramaiix, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailf
 * JD-Core Version:    0.7.0.1
 */