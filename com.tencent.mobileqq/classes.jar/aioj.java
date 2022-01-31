import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class aioj
  extends ajxj
{
  aioj(aiod paramaiod) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      aiod.c(this.a);
    }
  }
  
  protected void onAddFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = (ArrayList)aiod.a(this.a).clone();
    } while (localArrayList.isEmpty());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (atza)localIterator.next();
      if ((localObject instanceof atyv))
      {
        localObject = (atyv)localObject;
        int i = ((atyv)localObject).a.structMsg.msg.sub_type.get();
        localObject = ((atyv)localObject).a.senderuin;
        if ((i == 13) && (paramString.equals(localObject))) {
          localIterator.remove();
        }
      }
    }
    aiod.a(this.a, localArrayList);
    this.a.notifyDataSetChanged();
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void onSuspiciousGetUnreadNum(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSuspiciousGetUnreadNum " + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    if ((aiod.a(this.a) != null) && (aiod.a(this.a).getVisibility() == 0))
    {
      if ((paramBoolean) && (paramInt2 > 0)) {
        aiod.a(this.a).setText(paramInt2 + "");
      }
    }
    else {
      return;
    }
    aiod.a(this.a).setText("");
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (bldt.a(paramBundle.getInt("source_id")))) {
      aiod.c(this.a);
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aioj
 * JD-Core Version:    0.7.0.1
 */