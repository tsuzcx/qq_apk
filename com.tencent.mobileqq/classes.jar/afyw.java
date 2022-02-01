import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class afyw
  extends GestureDetector.SimpleOnGestureListener
{
  private afyv a;
  
  private void a(VasAvatar paramVasAvatar, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    new afyy(paramVasAvatar).a();
    ((azhb)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER)).a(paramChatMessage.senderuin, paramChatMessage.frienduin, paramChatMessage.istroop);
    if (paramChatMessage.istroop == 0) {}
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B3A1", "0X800B3A1", i, 0, "", "", "", "");
      return;
      if (paramChatMessage.istroop == 1) {
        i = 2;
      } else {
        i = 10;
      }
    }
  }
  
  public void a(afyv paramafyv)
  {
    this.a = paramafyv;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() called with: e = [" + paramMotionEvent + "]");
    }
    this.a.setIsLongpressEnabled(false);
    Object localObject = this.a.a();
    ChatMessage localChatMessage = (ChatMessage)((VasAvatar)localObject).getTag();
    QQAppInterface localQQAppInterface = BaseActivity.sTopActivity.app;
    if ((((VasAvatar)localObject).getContext() instanceof MultiForwardActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() MultiForwardActivity");
      }
      return super.onDoubleTap(paramMotionEvent);
    }
    if (!NetworkUtil.isNetSupport(((VasAvatar)localObject).getContext()))
    {
      QQToast.a(((VasAvatar)localObject).getContext(), anvx.a(2131714258), 0).a();
      return super.onDoubleTap(paramMotionEvent);
    }
    if (localChatMessage.istroop == 0) {
      a((VasAvatar)localObject, localChatMessage, localQQAppInterface);
    }
    TroopManager localTroopManager;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return super.onDoubleTap(paramMotionEvent);
      } while (localChatMessage.istroop != 1);
      if (((bgkf)localQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(localChatMessage.frienduin, true).a)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() DisableSendMsg");
        }
        return super.onDoubleTap(paramMotionEvent);
      }
      if ((nty.a(localChatMessage)) || (nty.a().a(localChatMessage.frienduin)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() AioAnonymous");
        }
        return super.onDoubleTap(paramMotionEvent);
      }
      if (localQQAppInterface.getTroopMask(localChatMessage.frienduin) == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() MSG_FILTER_CLOSE");
        }
        return super.onDoubleTap(paramMotionEvent);
      }
      localTroopManager = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localTroopInfo = localTroopManager.a(localChatMessage.frienduin, true);
    } while (localTroopInfo == null);
    if (localTroopInfo.isDisband())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694494, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() isDisband");
      }
      return super.onDoubleTap(paramMotionEvent);
    }
    localObject = new afyx((VasAvatar)localObject, localChatMessage, localQQAppInterface, this);
    localTroopManager.a(localChatMessage.frienduin, localChatMessage.senderuin, (aofo)localObject);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarOnGestureListener", 2, "onLongPress() called with: e = [" + paramMotionEvent + "]");
    }
    paramMotionEvent = this.a.a();
    if (paramMotionEvent.a()) {
      paramMotionEvent.performLongClick();
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarOnGestureListener", 2, "onSingleTapConfirmed() called with: e = [" + paramMotionEvent + "]");
    }
    VasAvatar localVasAvatar = this.a.a();
    if (localVasAvatar.hasOnClickListeners()) {
      localVasAvatar.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyw
 * JD-Core Version:    0.7.0.1
 */