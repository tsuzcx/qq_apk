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

public class aicv
  extends aibl
{
  public aicv(Context paramContext, bhoe parambhoe, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambhoe, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aicu localaicu = (aicu)getItem(paramInt);
    View localView;
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559260, null);
      paramViewGroup = new aibm();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131377553));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377555));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367808));
      paramViewGroup.b = ((TextView)localView.findViewById(2131369115));
      localView.setTag(paramViewGroup);
      localMessageRecord = localaicu.a;
      paramView = bdnm.a(localMessageRecord.msg, localMessageRecord, 32, 3);
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
      if (!nav.a(localMessageRecord)) {
        break label293;
      }
      paramView = nav.a(localMessageRecord);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697670) + paramView.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(nav.a(paramView.jdField_b_of_type_Int)));
      paramViewGroup.b.setText(localaicu.a(localMessageRecord.time));
      return localView;
      paramViewGroup = (aibm)paramView.getTag();
      localView = paramView;
      break;
    }
    label293:
    Object localObject = bcid.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((bcie)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840084);
      localObject = URLDrawable.getDrawable(((bcie)localObject).jdField_a_of_type_JavaLangString, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(bcuq.b(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(bcuq.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new bahs(paramView, 32).a();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      bdnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
      break;
      localObject = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicv
 * JD-Core Version:    0.7.0.1
 */