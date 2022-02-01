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

public class ajhl
  extends ajgb
{
  public ajhl(Context paramContext, bjmp parambjmp, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambjmp, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ajhk localajhk = (ajhk)getItem(paramInt);
    View localView;
    ajgc localajgc;
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559346, null);
      localajgc = new ajgc();
      localajgc.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131378368));
      localajgc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378370));
      localajgc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368236));
      localajgc.b = ((TextView)localView.findViewById(2131369605));
      localView.setTag(localajgc);
      localMessageRecord = localajhk.a;
      paramView = bgdk.a(localMessageRecord.msg, localMessageRecord, 32, 3);
      localajgc.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
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
      if (!nmy.a(localMessageRecord)) {
        break label319;
      }
      paramView = nmy.a(localMessageRecord);
      localajgc.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696698) + paramView.jdField_b_of_type_JavaLangString);
      localajgc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(nmy.a(paramView.jdField_b_of_type_Int)));
      localajgc.b.setText(localajhk.a(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localajgc = (ajgc)paramView.getTag();
      localView = paramView;
      break;
    }
    label319:
    Object localObject = bfat.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((bfau)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840312);
      localObject = URLDrawable.getDrawable(((bfau)localObject).a, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(bfol.b(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(bfol.a);
      localajgc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new bczs(paramView, 32).a();
      localajgc.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      bgdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localajgc.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
      break;
      localObject = ContactUtils.getNicknameInSession(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      localajgc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhl
 * JD-Core Version:    0.7.0.1
 */