import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3.1;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aizl
  extends anvi
{
  aizl(aizi paramaizi) {}
  
  protected void onAddFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = this.a.b();
    } while (((ArrayList)localObject).isEmpty());
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajbn localajbn = (ajbn)((Iterator)localObject).next();
      if ((localajbn instanceof ajbi))
      {
        int i = ((ajbi)localajbn).a.structMsg.msg.sub_type.get();
        String str = ((ajbi)localajbn).a.senderuin;
        if ((i == 13) && (paramString.equals(str)))
        {
          ((Iterator)localObject).remove();
          aizi.a(this.a).getMessageFacade().removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((ajbi)localajbn).a.uniseq, false);
        }
      }
    }
    aizi.a(this.a).sendEmptyMessage(2);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (aizi.a(this.a) != null)) {
      aizi.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onGetPushRecommend(boolean paramBoolean)
  {
    if ((paramBoolean) && (aizi.a(this.a) != null)) {
      aizi.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    aizi.a(this.a).runOnUiThread(new NewFriendManager.3.1(this, paramBoolean));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (aizi.a(this.a) != null)) {
      aizi.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizl
 * JD-Core Version:    0.7.0.1
 */