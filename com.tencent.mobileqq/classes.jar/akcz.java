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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akcz
  extends akbp
{
  public akcz(Context paramContext, bkyc parambkyc, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambkyc, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    akcy localakcy = (akcy)getItem(paramInt);
    View localView;
    akbq localakbq;
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559396, null);
      localakbq = new akbq();
      localakbq.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131378659));
      localakbq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378661));
      localakbq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368381));
      localakbq.b = ((TextView)localView.findViewById(2131369774));
      localView.setTag(localakbq);
      localMessageRecord = localakcy.a;
      paramView = bhmb.a(localMessageRecord.msg, localMessageRecord, 32, 3);
      localakbq.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localObject = localMessageRecord.senderuin;
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1)
      {
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000) {
          if (!localMessageRecord.isSend()) {
            break label308;
          }
        }
      }
    }
    label308:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)
    {
      if (!nty.a(localMessageRecord)) {
        break label319;
      }
      paramView = nty.a(localMessageRecord);
      localakbq.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696965) + paramView.jdField_b_of_type_JavaLangString);
      localakbq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(nty.a(paramView.jdField_b_of_type_Int)));
      localakbq.b.setText(localakcy.a(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localakbq = (akbq)paramView.getTag();
      localView = paramView;
      break;
    }
    label319:
    Object localObject = bgiz.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((bgja)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840348);
      localObject = URLDrawable.getDrawable(((bgja)localObject).a, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(bgxc.b(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(bgxc.a);
      localakbq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new begq(paramView, 32).a();
      localakbq.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      bhmb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localakbq.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
      break;
      localObject = ContactUtils.getNicknameInSession(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      localakbq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcz
 * JD-Core Version:    0.7.0.1
 */