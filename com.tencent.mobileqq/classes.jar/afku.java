import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.MessageForConfessNews;

class afku
  implements View.OnClickListener
{
  afku(afkt paramafkt) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView instanceof ConfessNewsBgView))
    {
      localObject = paramView.getTag();
      if ((localObject instanceof MessageForConfessNews))
      {
        localObject = (MessageForConfessNews)localObject;
        if (((MessageForConfessNews)localObject).istroop != 1) {
          break label73;
        }
      }
    }
    label73:
    for (int i = 1; i != 0; i = 0)
    {
      aojt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, 2, ((MessageForConfessNews)localObject).strGroupUin, ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).strRecUin);
      return;
    }
    aoiy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), ((MessageForConfessNews)localObject).nTopicId, ((MessageForConfessNews)localObject).strConfessorUin, ((MessageForConfessNews)localObject).nConfessorSex, ((MessageForConfessNews)localObject).strRecUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afku
 * JD-Core Version:    0.7.0.1
 */