import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout15;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout15.ViewHolder;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.qphone.base.util.QLog;

public class ainu
  implements View.OnClickListener
{
  public ainu(StructMsgItemLayout15 paramStructMsgItemLayout15) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131362172);
    if ((this.a.a == null) || (!(this.a.a.message instanceof MessageForTroopTopic))) {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick message is null." + this.a.a);
      }
    }
    MessageForTroopTopic localMessageForTroopTopic;
    do
    {
      do
      {
        return;
        localMessageForTroopTopic = (MessageForTroopTopic)this.a.a.message;
      } while (!(localObject instanceof Integer));
      switch (((Integer)localObject).intValue())
      {
      default: 
        return;
      case 1: 
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick TAG_ACTION_BUTTON");
        }
        if (!localMessageForTroopTopic.isExpand)
        {
          ((StructMsgItemLayout15.ViewHolder)paramView.getTag(2131362173)).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "unfold_full", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
        }
        for (;;)
        {
          this.a.a(paramView.getContext(), localMessageForTroopTopic);
          return;
          ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "fold_full", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
        }
      case 2: 
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick TAG_LIKE_BUTTON");
        }
        break;
      }
    } while (localMessageForTroopTopic.isLike);
    localMessageForTroopTopic.isLike = true;
    localMessageForTroopTopic.likeNum += 1L;
    paramView = (StructMsgItemLayout15.ViewHolder)paramView.getTag(2131362173);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841517);
    paramView.b.setText("" + localMessageForTroopTopic.likeNum);
    localMessageForTroopTopic.syncFieldsToStruct();
    if ((this.a.a != null) && ((this.a.a instanceof StructMsgForGeneralShare)) && (!AnonymousChatHelper.a().a(localMessageForTroopTopic.frienduin)) && ((this.a.a.message instanceof MessageForTroopTopic)))
    {
      paramView = (MessageForTroopTopic)this.a.a.message;
      if (StructMsgItemLayout15.a(this.a) == null) {
        break label504;
      }
      TroopTopicMgr.a(StructMsgItemLayout15.a(this.a), paramView);
    }
    for (;;)
    {
      ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "obj_like", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
      return;
      label504:
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemLayout15", 2, "likeTopic but app is null");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout15 onClick TAG_COMMENT_BUTTON");
    }
    paramView = ((FragmentActivity)paramView.getContext()).getChatFragment();
    if (paramView != null) {
      paramView.a().h(localMessageForTroopTopic);
    }
    ReportController.b(StructMsgItemLayout15.a(this.a), "dc00899", "Grp_talk", "", "obj", "obj_reply", 0, 0, localMessageForTroopTopic.frienduin + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainu
 * JD-Core Version:    0.7.0.1
 */