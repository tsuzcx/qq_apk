import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.ViewHolder;

public class ahvl
  implements Runnable
{
  public ahvl(StructMsgItemPAAudio paramStructMsgItemPAAudio, View paramView, StructMsgItemPAAudio.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getParent();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (((ViewGroup)localObject2).getId() != 2131361855) {
          break label64;
        }
        localObject2 = (StructMsgForGeneralShare)((ViewGroup)localObject2).getTag(2131361855);
      }
    }
    if (localObject2 == null) {}
    label64:
    do
    {
      do
      {
        return;
        localObject1 = ((ViewGroup)localObject2).getParent();
        break;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject1);
      } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_AndroidViewViewGroup == null);
      localObject1 = (ChatItemBuilder.BaseHolder)AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_AndroidViewViewGroup);
    } while (localObject1 == null);
    long l = ((ChatItemBuilder.BaseHolder)localObject1).a.uniseq;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.y = ((StructMsgForGeneralShare)localObject2).uin;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.a(l);
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio$ViewHolder.c.setBackgroundResource(2130839771);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio$ViewHolder.c.setBackgroundResource(2131034223);
    ((AnimationDrawable)this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio$ViewHolder.c.getBackground()).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahvl
 * JD-Core Version:    0.7.0.1
 */