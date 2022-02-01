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

public class ajgc
  extends ajfb<MessageRecord>
{
  public ajgc(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ajdw a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = new blfl();
    paramViewGroup = this.jdField_a_of_type_Ajdz.a(paramContext, paramInt, (blfl)localObject);
    paramContext = new ajfc(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_Blfl = ((blfl)localObject);
    localObject = new ajef();
    ((ajef)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131373804);
    ((ajef)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ajef)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373816));
    ((ajef)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ajef)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373817));
    ((ajef)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((ajef)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373813));
    paramContext.jdField_a_of_type_Ajef = ((ajef)localObject);
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
    ajhg.a(paramContext.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    return paramContext;
  }
  
  protected void a(ajdw paramajdw, MessageRecord paramMessageRecord, int paramInt)
  {
    if (!(paramajdw instanceof ajfc)) {
      return;
    }
    ajfc localajfc = (ajfc)paramajdw;
    this.jdField_a_of_type_Ajdz.a(this.jdField_a_of_type_AndroidContentContext, paramajdw.itemView, paramInt, paramMessageRecord, localajfc.jdField_a_of_type_Blfl, new ajgd(this), this.d);
    TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView, paramajdw, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgc
 * JD-Core Version:    0.7.0.1
 */