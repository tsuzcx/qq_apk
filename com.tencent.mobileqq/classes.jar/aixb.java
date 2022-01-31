import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

class aixb
  implements UpCallBack
{
  aixb(aixa paramaixa, boolean paramBoolean) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    boolean bool;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramSendResult == null)
      {
        bool = true;
        localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
        if (paramSendResult != null) {
          break label71;
        }
        i = -99;
        label46:
        QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      }
    }
    else
    {
      if (paramSendResult != null) {
        break label79;
      }
    }
    label71:
    label79:
    do
    {
      return;
      bool = false;
      break;
      i = paramSendResult.a;
      break label46;
      if (paramSendResult.a == 0)
      {
        bool = true;
        localObject = (CardHandler)this.jdField_a_of_type_Aixa.a.a(2);
        if (localObject == null) {
          break label149;
        }
        ((CardHandler)localObject).a(bool, this.jdField_a_of_type_Aixa.a.getCurrentAccountUin(), 0);
      }
      for (;;)
      {
        if (bool) {
          break label156;
        }
        ProfileCardUtil.a("TransferRequest.onSend", paramSendResult.b, paramSendResult.toString());
        return;
        bool = false;
        break;
        ProfileCardUtil.a(null);
      }
      if (((Integer)NearbySPUtil.a(this.jdField_a_of_type_Aixa.a.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        NearbySPUtil.a(this.jdField_a_of_type_Aixa.a.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new aixc(this));
      }
    } while (SharedPreUtils.ax(this.jdField_a_of_type_Aixa.a.getApp(), this.jdField_a_of_type_Aixa.a.getCurrentAccountUin()) == 2);
    label149:
    label156:
    paramSendResult = (CardHandler)this.jdField_a_of_type_Aixa.a.a(2);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(42104));
    paramSendResult.a(this.jdField_a_of_type_Aixa.a.getCurrentAccountUin(), this.jdField_a_of_type_Aixa.a.getCurrentAccountUin(), 0, (ArrayList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aixb
 * JD-Core Version:    0.7.0.1
 */