import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;

public class ageq
  extends agdg
{
  public ageq(Context paramContext, bfnk parambfnk, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambfnk, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    agep localagep = (agep)getItem(paramInt);
    View localView;
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559216, null);
      paramViewGroup = new agdh();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131377033));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377035));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367679));
      paramViewGroup.b = ((TextView)localView.findViewById(2131368885));
      localView.setTag(paramViewGroup);
      localMessageRecord = localagep.a;
      paramView = bbos.a(localMessageRecord.msg, localMessageRecord, 32, 3);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localObject = localMessageRecord.senderuin;
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
      {
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          if (!localMessageRecord.isSend()) {
            break label282;
          }
        }
      }
    }
    label282:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      if (!myb.a(localMessageRecord)) {
        break label293;
      }
      paramView = myb.a(localMessageRecord);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697495) + paramView.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(myb.a(paramView.jdField_b_of_type_Int)));
      paramViewGroup.b.setText(localagep.a(localMessageRecord.time));
      return localView;
      paramViewGroup = (agdh)paramView.getTag();
      localView = paramView;
      break;
    }
    label293:
    Object localObject = bajp.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((bajq)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839736);
      localObject = URLDrawable.getDrawable(((bajq)localObject).jdField_a_of_type_JavaLangString, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(bavw.b(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(bavw.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new ayjw(paramView, 32).a();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      bbos.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
      break;
      localObject = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ageq
 * JD-Core Version:    0.7.0.1
 */