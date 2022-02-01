import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloMessageProgressView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class agnf
  extends agog
{
  private amly jdField_a_of_type_Amly;
  protected View.OnClickListener a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private long c;
  private boolean f = true;
  
  public agnf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agng(this);
    this.jdField_a_of_type_Amly = ((amma)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a();
    amwn.a(paramQQAppInterface);
  }
  
  protected static void a(agni paramagni, int paramInt)
  {
    if (paramInt < 100)
    {
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setDrawStatus(1);
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setAnimProgress(paramInt, paramagni.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagni.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setAnimProgress(paramInt, paramagni.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagni.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  private void a(agni paramagni, MessageForApollo paramMessageForApollo, View paramView)
  {
    if (paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView == null)
    {
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView = new ApolloMessageProgressView(this.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(242.66667F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(173.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(13);
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setRadius(15.0F, true);
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setShowCorner(false);
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setCornerDirection(false);
      ((RelativeLayout)paramView).addView(paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView, localLayoutParams);
    }
    paramMessageForApollo = ((amma)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(paramMessageForApollo.gameId);
    if ((paramMessageForApollo != null) && (paramMessageForApollo.uniseq == paramagni.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
      return;
    }
    paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(4);
  }
  
  public static void a(agni paramagni, MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((paramagni == null) || (paramQQAppInterface == null) || (paramMessageForApollo == null)) {}
    for (;;)
    {
      return;
      if (paramMessageForApollo.uniseq == paramagni.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)
      {
        paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(0);
        a(paramagni, paramInt2);
        if (paramInt2 == 100) {
          paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloGameItemBuilder", 2, new Object[] { "gameId = ", Integer.valueOf(paramInt1), ":", Integer.valueOf(paramInt2) });
        return;
        paramagni.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView)
  {
    if ((paramMessageForApollo == null) || (paramView == null)) {}
    while (TextUtils.isEmpty(ApolloUtil.b(paramMessageForApollo))) {
      return;
    }
    e(paramView);
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1036)
    {
      localObject = ApolloUtil.b(paramMessageForApollo);
      if ((NetConnInfoCenter.getServerTimeMillis() / 1000L < paramMessageForApollo.time + 60L) && (paramMessageForApollo.gameStatus == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP start robot game");
        CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(paramMessageForApollo.gameId, true, "message", paramMessageForApollo.roomId, 7, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 318001, paramMessageForApollo.gameName);
        localStartCheckParam.extendJson = paramMessageForApollo.extendJson;
        localStartCheckParam.disableMinGame = true;
        localStartCheckParam.mRobotOpenId = ((String)localObject);
        localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
        localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick;
        ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
        amub.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForApollo.gameId, paramMessageForApollo.roomId);
        return;
      }
      QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP onClickGameView but dispatch to ark");
      return;
    }
    int i;
    if (paramMessageForApollo.msgType == 4)
    {
      i = 201;
      int j = paramMessageForApollo.mGameMode;
      localObject = new CmGameStartChecker.StartCheckParam(paramMessageForApollo.gameId, paramMessageForApollo.isSend(), "message", paramMessageForApollo.roomId, 1, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, i, paramMessageForApollo.gameName);
      if (paramMessageForApollo.msgType != 4) {
        break label362;
      }
      ((CmGameStartChecker.StartCheckParam)localObject).launchNewGame = true;
    }
    for (;;)
    {
      ((CmGameStartChecker.StartCheckParam)localObject).mSendMsgUin = paramMessageForApollo.senderuin;
      ((CmGameStartChecker.StartCheckParam)localObject).msgGameStatus = paramMessageForApollo.gameStatus;
      ((CmGameStartChecker.StartCheckParam)localObject).extendJson = paramMessageForApollo.gameExtendJson;
      ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, (CmGameStartChecker.StartCheckParam)localObject);
      return;
      i = 200;
      break;
      label362:
      ((CmGameStartChecker.StartCheckParam)localObject).showAlertTips = true;
    }
  }
  
  private void e(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int k = ((ViewGroup)paramView).getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = ((ViewGroup)paramView).getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(j);
            if ((localView2 instanceof ArkAppView))
            {
              localView2.setOnTouchListener(null);
              localView2.setClickable(false);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public afqr a()
  {
    return new agni();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    if (!(paramChatMessage.getTag() instanceof agni))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getView], NOT GameHolder.");
      return paramChatMessage;
    }
    paramView = (agni)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramaftk = paramChatMessage.b();
    if ((paramaftk != null) && (paramaftk.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364540);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.h;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364531);
    }
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    if ((paramChatMessage == null) || (paramafqr == null) || (paramBaseChatItemLayout == null) || (this.jdField_a_of_type_Amly == null)) {
      return paramView;
    }
    if (!(paramafqr instanceof agni))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getBubbleView], NOT GameHolder.");
      return paramView;
    }
    paramChatMessage = (MessageForApollo)paramChatMessage;
    paramafqr = (agni)paramafqr;
    MessageForArkApp localMessageForArkApp = this.jdField_a_of_type_Amly.a(paramChatMessage, paramChatMessage.mApolloGameArkMsg);
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new agnw();
    }
    localMessageForArkApp.arkContainer.a(true);
    paramChatMessage.mApolloGameArkMsg = localMessageForArkApp;
    paramView = super.a(localMessageForArkApp, paramafqr, paramView, paramBaseChatItemLayout, paramaftk);
    a(paramafqr, paramChatMessage, paramView);
    paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(paramChatMessage, paramView);
    return paramView;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anvx.a(2131699877) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
  }
  
  public void a(View paramView)
  {
    paramView = (agol)AIOUtils.getHolder(paramView);
    try
    {
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
      {
        QLog.w("ApolloGameItemBuilder", 1, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
        bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != 0) || (super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)))
        {
          localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690075), 1);
          localbkzi.c(2131690697);
          localbkzi.a(new agnh(this, paramView, localbkzi));
          localbkzi.show();
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("ApolloGameItemBuilder", 1, paramView, new Object[0]);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    if (!(paramafqr instanceof agni)) {
      QLog.w("ApolloGameItemBuilder", 1, "[handleBubbleBg], NOT GameHolder.");
    }
    do
    {
      return;
      paramChatMessage = (agni)paramafqr;
    } while (paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView == null);
    paramChatMessage.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
    paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.a;
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = AIOUtils.getMessage(paramView);
    if (ApolloUtil.a(paramView))
    {
      e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      return localbhjq.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbhjq, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnf
 * JD-Core Version:    0.7.0.1
 */