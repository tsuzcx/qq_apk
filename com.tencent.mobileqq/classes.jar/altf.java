import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.NewFriendManager.3.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class altf
  extends alox
{
  altf(altc paramaltc) {}
  
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
      avqe localavqe = (avqe)((Iterator)localObject).next();
      if ((localavqe instanceof avpz))
      {
        int i = ((avpz)localavqe).a.structMsg.msg.sub_type.get();
        String str = ((avpz)localavqe).a.senderuin;
        if ((i == 13) && (paramString.equals(str)))
        {
          ((Iterator)localObject).remove();
          altc.a(this.a).a().b(aljq.M, 0, ((avpz)localavqe).a.uniseq, false);
        }
      }
    }
    altc.a(this.a).sendEmptyMessage(2);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (altc.a(this.a) != null)) {
      altc.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onGetPushRecommend(boolean paramBoolean)
  {
    if ((paramBoolean) && (altc.a(this.a) != null)) {
      altc.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    altc.a(this.a).runOnUiThread(new NewFriendManager.3.1(this, paramBoolean));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (altc.a(this.a) != null)) {
      altc.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     altf
 * JD-Core Version:    0.7.0.1
 */