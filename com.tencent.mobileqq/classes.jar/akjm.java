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

public class akjm
  extends akic
{
  public akjm(Context paramContext, blha paramblha, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramblha, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    akjl localakjl = (akjl)getItem(paramInt);
    View localView;
    akid localakid;
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559344, null);
      localakid = new akid();
      localakid.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131378604));
      localakid.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378606));
      localakid.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368212));
      localakid.b = ((TextView)localView.findViewById(2131369615));
      localView.setTag(localakid);
      localMessageRecord = localakjl.a;
      paramView = bhwz.a(localMessageRecord.msg, localMessageRecord, 32, 3);
      localakid.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
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
      if (!nlj.a(localMessageRecord)) {
        break label319;
      }
      paramView = nlj.a(localMessageRecord);
      localakid.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696557) + paramView.jdField_b_of_type_JavaLangString);
      localakid.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(nlj.a(paramView.jdField_b_of_type_Int)));
      localakid.b.setText(localakjl.a(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localakid = (akid)paramView.getTag();
      localView = paramView;
      break;
    }
    label319:
    Object localObject = bgrf.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((bgrg)localObject).c;
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840274);
      localObject = URLDrawable.getDrawable(((bgrg)localObject).jdField_a_of_type_JavaLangString, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(bhez.b(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(bhez.a);
      localakid.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new begb(paramView, 32).a();
      localakid.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(paramView);
      bhwz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localakid.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, paramView);
      break;
      localObject = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      localakid.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjm
 * JD-Core Version:    0.7.0.1
 */