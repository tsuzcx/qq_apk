import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class afzb
  implements aere
{
  int jdField_a_of_type_Int;
  RedPackGrapInfo jdField_a_of_type_WalletRedPackGrapInfo;
  agmg jdField_a_of_type_Agmg;
  agmp jdField_a_of_type_Agmp;
  public Context a;
  bdbb jdField_a_of_type_Bdbb;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public QQAppInterface a;
  MessageForQQWalletMsg jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = null;
  
  public afzb(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Bdbb = new bdbb(paramQQAppInterface);
    this.jdField_a_of_type_Agmg = new agmg(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramInt;
  }
  
  public FrameLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.gravity = 48;
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    return localLayoutParams;
  }
  
  public FrameLayout a(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null)) {
      return null;
    }
    this.jdField_a_of_type_Agmp = new agmp();
    this.jdField_a_of_type_Agmp.jdField_a_of_type_ComTencentMobileqqDataChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
    this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Agmg.b(this.jdField_a_of_type_Agmp, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    Object localObject1 = paramLinearLayout.findViewById(2131374027);
    if (QLog.isColorLevel()) {
      QLog.d("TroopUnAccalimedRedPacketList", 2, new Object[] { Boolean.valueOf(localObject1 instanceof RelativeLayout) });
    }
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int i = (int)(173.0F * f + 0.5F);
    int j = (int)(255.0F * f + 0.5F);
    int k = (int)(6.5F * f + 0.5F);
    int m = (int)(f * 7.5F + 0.5F);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Agmg.b(this.jdField_a_of_type_Agmp, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      ((FrameLayout)localObject2).addView(this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout, a(i, j, k, m));
      View localView = paramLinearLayout.findViewById(2131374052);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Agmp.b != null)
      {
        localObject1 = new RelativeLayout.LayoutParams(i, j);
        if (localView == null) {
          break label305;
        }
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramLinearLayout.addView((View)localObject2, -1, -1);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      return localObject1;
      label305:
      ((FrameLayout)localObject2).addView(this.jdField_a_of_type_Agmp.b, (ViewGroup.LayoutParams)localObject1);
      break;
      localObject1 = ((View)localObject1).getParent();
      if ((localObject1 instanceof FrameLayout))
      {
        localObject1 = (FrameLayout)localObject1;
        ((FrameLayout)localObject1).removeAllViews();
        this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Agmg.b(this.jdField_a_of_type_Agmp, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        ((FrameLayout)localObject1).addView(this.jdField_a_of_type_Agmp.jdField_a_of_type_AndroidWidgetRelativeLayout, a(i, j, k, m));
        localObject2 = new RelativeLayout.LayoutParams(i, j);
        paramLinearLayout = paramLinearLayout.findViewById(2131374052);
        if (paramLinearLayout != null) {
          paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        } else {
          ((FrameLayout)localObject1).addView(this.jdField_a_of_type_Agmp.b, (ViewGroup.LayoutParams)localObject2);
        }
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    this.jdField_a_of_type_WalletRedPackGrapInfo = paramRedPackGrapInfo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = new MessageForQQWalletMsg();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin = (paramRedPackGrapInfo.lUin + "");
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType = paramRedPackGrapInfo.iMsgType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId = paramRedPackGrapInfo.sBiilNo;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey = paramRedPackGrapInfo.sAuthKey;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redtype = paramRedPackGrapInfo.iRedType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel = paramRedPackGrapInfo.iRedChannel;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid = paramRedPackGrapInfo.iEnvelopeId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName = paramRedPackGrapInfo.sName;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList = paramRedPackGrapInfo.vecGrapUin;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem = new QQWalletTransferMsgElem();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title = paramRedPackGrapInfo.sTitle;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.themeId = paramRedPackGrapInfo.iSubjectId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType = paramRedPackGrapInfo.iResourceType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId = paramRedPackGrapInfo.iSkinId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.effectsId = paramRedPackGrapInfo.iEffectsId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.special_pop_id = paramRedPackGrapInfo.iSpecialPopId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.soundRecordDuration = paramRedPackGrapInfo.iSoundRecordDuration;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.content = paramRedPackGrapInfo.sContent;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.actionsPriority = "3|2|1";
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.nativeAndroid = ("red?id=" + paramRedPackGrapInfo.sBiilNo);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songId = paramRedPackGrapInfo.iSongId;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songFlag = paramRedPackGrapInfo.iSongFlag;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.lastPinyin = paramRedPackGrapInfo.hbIdiomLastPY;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body = new QQWalletAioBodyReserve(paramRedPackGrapInfo.sReserve);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramRedPackGrapInfo.lUin + "")) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.issend = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType != 6) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList = 1;
    }
    this.jdField_a_of_type_Int = agmv.a(paramRedPackGrapInfo.iMsgType);
    if ((this.jdField_a_of_type_Int == 4) && (paramRedPackGrapInfo.iSkinId > 0)) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int i = agmv.a(paramMessageForQQWalletMsg.messageType);
    paramMessageForQQWalletMsg = agmv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agmp, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem, i, this);
    if ((paramMessageForQQWalletMsg instanceof agms)) {
      ((agms)paramMessageForQQWalletMsg).a(new bdbb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    try
    {
      paramMessageForQQWalletMsg.a();
      paramMessageForQQWalletMsg.e();
      paramMessageForQQWalletMsg.f();
      paramMessageForQQWalletMsg.b();
      paramMessageForQQWalletMsg.g();
      paramMessageForQQWalletMsg.i();
      return;
    }
    catch (Throwable paramMessageForQQWalletMsg) {}
  }
  
  public boolean a(FrameLayout paramFrameLayout, RedPackGrapInfo paramRedPackGrapInfo, aixi paramaixi)
  {
    if (paramFrameLayout == null) {
      return false;
    }
    this.jdField_a_of_type_Agmg.a(paramaixi);
    paramFrameLayout = (RelativeLayout)paramFrameLayout.findViewById(2131374027);
    if (paramFrameLayout == null) {
      return false;
    }
    if ((MessageForQQWalletMsg)paramFrameLayout.getTag() == null) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext.getString(2131717720);
    }
    return this.jdField_a_of_type_Agmg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramFrameLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Int, paramRedPackGrapInfo.iSkinId, "");
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    if ((paramRedPacketInfo != null) && ((paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForQQWalletMsg)))
    {
      localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramRedPacketInfo.skinType == 1) {
              a(localMessageForQQWalletMsg);
            }
          } while ((paramRedPacketInfo.skinType != 3) || (paramRedPacketInfo.specailBackgroundAnimInfo == null));
          a(localMessageForQQWalletMsg);
          return;
        } while (paramRedPacketInfo.animInfo == null);
        a(localMessageForQQWalletMsg);
        return;
      } while (paramRedPacketInfo.background == null);
      a(localMessageForQQWalletMsg);
      return;
    } while ((!paramRedPacketInfo.a()) && (paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap == null));
    a(localMessageForQQWalletMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzb
 * JD-Core Version:    0.7.0.1
 */