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

public class ajni
  extends ajjh
{
  ajni(ajnf paramajnf) {}
  
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
      atcu localatcu = (atcu)((Iterator)localObject).next();
      if ((localatcu instanceof atcp))
      {
        int i = ((atcp)localatcu).a.structMsg.msg.sub_type.get();
        String str = ((atcp)localatcu).a.senderuin;
        if ((i == 13) && (paramString.equals(str)))
        {
          ((Iterator)localObject).remove();
          ajnf.a(this.a).a().b(ajed.M, 0, ((atcp)localatcu).a.uniseq, false);
        }
      }
    }
    ajnf.a(this.a).sendEmptyMessage(2);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (ajnf.a(this.a) != null)) {
      ajnf.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onGetPushRecommend(boolean paramBoolean)
  {
    if ((paramBoolean) && (ajnf.a(this.a) != null)) {
      ajnf.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    ajnf.a(this.a).runOnUiThread(new NewFriendManager.3.1(this, paramBoolean));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (ajnf.a(this.a) != null)) {
      ajnf.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajni
 * JD-Core Version:    0.7.0.1
 */