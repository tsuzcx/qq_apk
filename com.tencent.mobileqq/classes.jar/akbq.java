import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.NewFriendManager.3.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class akbq
  extends ajxj
{
  akbq(akbn paramakbn) {}
  
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
      atza localatza = (atza)((Iterator)localObject).next();
      if ((localatza instanceof atyv))
      {
        int i = ((atyv)localatza).a.structMsg.msg.sub_type.get();
        String str = ((atyv)localatza).a.senderuin;
        if ((i == 13) && (paramString.equals(str)))
        {
          ((Iterator)localObject).remove();
          akbn.a(this.a).a().b(ajsd.M, 0, ((atyv)localatza).a.uniseq, false);
        }
      }
    }
    akbn.a(this.a).sendEmptyMessage(2);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (akbn.a(this.a) != null)) {
      akbn.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onGetPushRecommend(boolean paramBoolean)
  {
    if ((paramBoolean) && (akbn.a(this.a) != null)) {
      akbn.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    akbn.a(this.a).runOnUiThread(new NewFriendManager.3.1(this, paramBoolean));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (akbn.a(this.a) != null)) {
      akbn.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbq
 * JD-Core Version:    0.7.0.1
 */