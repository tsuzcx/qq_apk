import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13.ViewHolder;
import com.tencent.qphone.base.util.QLog;

public class ainq
  implements View.OnClickListener
{
  public ainq(StructMsgItemLayout13 paramStructMsgItemLayout13) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131362172);
    if ((localObject instanceof Integer)) {}
    Intent localIntent;
    switch (((Integer)localObject).intValue())
    {
    default: 
    case 1: 
      do
      {
        do
        {
          return;
        } while ((this.a.a == null) || (!(this.a.a instanceof StructMsgForGeneralShare)));
        localObject = ((StructMsgForGeneralShare)this.a.a).author;
      } while ((localObject == null) || (this.a.a.message == null));
      localIntent = new Intent(paramView.getContext(), FriendProfileCardActivity.class);
      localIntent.putExtra("troopUin", this.a.a.message.frienduin);
      localIntent.putExtra("memberUin", (String)localObject);
      localIntent.putExtra("fromFlag", 0);
      paramView.getContext().startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout13 onClick TAG_AVATAR_VIEW. troopUin:" + this.a.a.message.frienduin + " memberUin:" + (String)localObject);
      }
      ReportController.b(StructMsgItemLayout13.a(this.a), "dc00899", "Grp_talk", "", "obj", "obj_head", 0, 0, this.a.a.message.frienduin + "", "", "", "");
      return;
    }
    localObject = paramView.getTag(2131362173);
    if ((localObject instanceof StructMsgItemLayout13.ViewHolder))
    {
      localObject = (StructMsgItemLayout13.ViewHolder)localObject;
      if (!TextUtils.isEmpty(((StructMsgItemLayout13.ViewHolder)localObject).a))
      {
        localIntent = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
        localIntent.putExtra("url", ((StructMsgItemLayout13.ViewHolder)localObject).a);
        paramView.getContext().startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout13 onClick TAG_ACTION_VIEW. parentMsg.pid:" + ((StructMsgForGeneralShare)this.a.a).pid + " url:" + ((StructMsgItemLayout13.ViewHolder)localObject).a);
        }
      }
    }
    localObject = "";
    paramView = (View)localObject;
    if (this.a.a != null)
    {
      paramView = (View)localObject;
      if (this.a.a.message != null) {
        paramView = this.a.a.message.frienduin;
      }
    }
    ReportController.b(StructMsgItemLayout13.a(this.a), "dc00899", "Grp_talk", "", "obj", "Clk_origin", 0, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainq
 * JD-Core Version:    0.7.0.1
 */