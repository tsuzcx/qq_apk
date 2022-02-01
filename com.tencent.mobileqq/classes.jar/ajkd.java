import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajkd
  extends anyu
{
  ajkd(ajka paramajka) {}
  
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
      ajmf localajmf = (ajmf)((Iterator)localObject).next();
      if ((localajmf instanceof ajma))
      {
        int i = ((ajma)localajmf).a.structMsg.msg.sub_type.get();
        String str = ((ajma)localajmf).a.senderuin;
        if ((i == 13) && (paramString.equals(str)))
        {
          ((Iterator)localObject).remove();
          ajka.a(this.a).a().b(antf.M, 0, ((ajma)localajmf).a.uniseq, false);
        }
      }
    }
    ajka.a(this.a).sendEmptyMessage(2);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (ajka.a(this.a) != null)) {
      ajka.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onGetPushRecommend(boolean paramBoolean)
  {
    if ((paramBoolean) && (ajka.a(this.a) != null)) {
      ajka.a(this.a).sendEmptyMessage(2);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    ajka.a(this.a).runOnUiThread(new NewFriendManager.3.1(this, paramBoolean));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (ajka.a(this.a) != null)) {
      ajka.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkd
 * JD-Core Version:    0.7.0.1
 */