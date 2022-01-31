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

class akfu
  extends alox
{
  akfu(akfo paramakfo) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      akfo.c(this.a);
    }
  }
  
  protected void onAddFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = (ArrayList)akfo.a(this.a).clone();
    } while (localArrayList.isEmpty());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (avqe)localIterator.next();
      if ((localObject instanceof avpz))
      {
        localObject = (avpz)localObject;
        int i = ((avpz)localObject).a.structMsg.msg.sub_type.get();
        localObject = ((avpz)localObject).a.senderuin;
        if ((i == 13) && (paramString.equals(localObject))) {
          localIterator.remove();
        }
      }
    }
    akfo.a(this.a, localArrayList);
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
    if ((akfo.a(this.a) != null) && (akfo.a(this.a).getVisibility() == 0))
    {
      if ((paramBoolean) && (paramInt2 > 0)) {
        akfo.a(this.a).setText(paramInt2 + "");
      }
    }
    else {
      return;
    }
    akfo.a(this.a).setText("");
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (bnpd.a(paramBundle.getInt("source_id")))) {
      akfo.c(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfu
 * JD-Core Version:    0.7.0.1
 */