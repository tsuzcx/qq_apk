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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajyd
  extends ajwt
{
  public ajyd(Context paramContext, bkfv parambkfv, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambkfv, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ajyc localajyc = (ajyc)getItem(paramInt);
    View localView;
    ajwu localajwu;
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559344, null);
      localajwu = new ajwu();
      localajwu.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131378446));
      localajwu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378448));
      localajwu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368138));
      localajwu.b = ((TextView)localView.findViewById(2131369522));
      localView.setTag(localajwu);
      localMessageRecord = localajyc.a;
      paramView = bgwv.a(localMessageRecord.msg, localMessageRecord, 32, 3);
      localajwu.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localObject = localMessageRecord.senderuin;
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
      {
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          if (!localMessageRecord.isSend()) {
            break label308;
          }
        }
      }
    }
    label308:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      if (!njo.a(localMessageRecord)) {
        break label319;
      }
      paramView = njo.a(localMessageRecord);
      localajwu.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696514) + paramView.jdField_b_of_type_JavaLangString);
      localajwu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(njo.a(paramView.jdField_b_of_type_Int)));
      localajwu.b.setText(localajyc.a(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localajwu = (ajwu)paramView.getTag();
      localView = paramView;
      break;
    }
    label319:
    Object localObject = bfre.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((bfrf)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840264);
      localObject = URLDrawable.getDrawable(((bfrf)localObject).jdField_a_of_type_JavaLangString, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(bgey.b(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(bgey.a);
      localajwu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new bdnf(paramView, 32).a();
      localajwu.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      bgwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localajwu.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
      break;
      localObject = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      localajwu.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyd
 * JD-Core Version:    0.7.0.1
 */