import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahby
  implements View.OnClickListener
{
  ahby(ahbx paramahbx) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    int i;
    if ((paramView instanceof ConfessNewsBgView))
    {
      localObject = paramView.getTag();
      if ((localObject instanceof MessageForConfessNews))
      {
        localObject = (MessageForConfessNews)localObject;
        if (((MessageForConfessNews)localObject).istroop != 1) {
          break label80;
        }
        i = 1;
        if (i == 0) {
          break label85;
        }
        aqzo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, 2, ((MessageForConfessNews)localObject).strGroupUin, ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).strRecUin);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      i = 0;
      break;
      label85:
      aqyt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).nConfessorSex, ((MessageForConfessNews)localObject).strRecUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahby
 * JD-Core Version:    0.7.0.1
 */