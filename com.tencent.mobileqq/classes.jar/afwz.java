import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;

public class afwz
  implements afzq, View.OnClickListener, bkiz
{
  public alqb a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  
  public afwz(afwy paramafwy) {}
  
  private void a(afwq paramafwq)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bcvt)) {
      ((bcvt)localObject1).b(this.jdField_a_of_type_AndroidViewView);
    }
    do
    {
      do
      {
        return;
        if ((!(localObject1 instanceof ahkc)) || (this.jdField_b_of_type_AndroidViewView == null)) {
          break;
        }
        Object localObject2 = (ahkc)localObject1;
        this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean) {
          if (((ahkc)localObject2).jdField_a_of_type_Apwt != null) {
            ((ahkc)localObject2).jdField_a_of_type_Apwt.a(this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ahkc)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((ahkc)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((ahkc)localObject2).jdField_a_of_type_AndroidViewView, false);
          }
        }
        for (;;)
        {
          paramafwq = this.jdField_b_of_type_AndroidViewView.findViewById(2131368420);
          if ((paramafwq == null) || (!(paramafwq instanceof PAHighLightImageView))) {
            break;
          }
          ((PAHighLightImageView)paramafwq).a();
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
          {
            if (!((ahkc)localObject2).jdField_a_of_type_Boolean) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838306);
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (paramafwq == null) {
              afwy.a((MessageForStructing)localObject2, (afwr)localObject1, this.jdField_b_of_type_AndroidViewView, false);
            }
          }
        }
        paramafwq = this.jdField_b_of_type_AndroidViewView.findViewById(2131377935);
      } while ((paramafwq == null) || (!(paramafwq instanceof PAHighLightImageView)));
      ((PAHighLightImageView)paramafwq).a();
      return;
    } while (!(localObject1 instanceof bcxp));
    paramafwq = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131377918)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838294);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramafwq);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838298);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838296);
      }
    }
  }
  
  private void a(afxi paramafxi)
  {
    if ((paramafxi instanceof ahkf)) {
      paramafxi = Integer.toString(0);
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramafxi, "", "", "");
      return;
      if ((paramafxi instanceof ahdu)) {
        paramafxi = Integer.toString(1);
      } else {
        paramafxi = Integer.toString(999);
      }
    }
  }
  
  private void a(View paramView, afxi paramafxi)
  {
    paramView.setPressed(true);
    this.jdField_a_of_type_AndroidViewView = paramView;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bcvt)) {
      ((bcvt)localObject1).c(this.jdField_a_of_type_AndroidViewView);
    }
    label113:
    label254:
    do
    {
      return;
      if ((localObject1 instanceof ahkc))
      {
        Object localObject2 = (ahkc)localObject1;
        ViewGroup.LayoutParams localLayoutParams;
        if ((paramafxi instanceof StructingMsgItemBuilder))
        {
          if (((StructingMsgItemBuilder)paramafxi).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
          {
            if ((((ahkc)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((ahkc)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
              this.jdField_b_of_type_AndroidViewView = ((ahkc)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (((ahkc)localObject2).jdField_a_of_type_Boolean)) {
            break label239;
          }
          localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (!this.jdField_a_of_type_Boolean) {
            break label254;
          }
          if (!((ahkc)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            break label241;
          }
          ((ahkc)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849990);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          return;
          this.jdField_b_of_type_AndroidViewView = ((ahkc)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout;
          this.jdField_a_of_type_Boolean = true;
          break label113;
          break;
          ((ahkc)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849814);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838308);
          }
          else
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (((BaseBubbleBuilder)paramafxi).a(paramView) == null) {
              afwy.a((MessageForStructing)localObject2, (afwr)localObject1, this.jdField_b_of_type_AndroidViewView, true);
            }
          }
        }
      }
    } while (!(localObject1 instanceof bcxp));
    label239:
    label241:
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramafxi = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)paramView.getTag(2131377918)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838295);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramafxi);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838299);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838297);
      }
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    bguh localbguh = new bguh();
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + paramChatMessage.msgUid + ", time = " + paramChatMessage.time + ", msgtype = " + paramChatMessage.msgtype);
    }
    afxi localafxi = this.jdField_a_of_type_Afwy.jdField_a_of_type_Agwz.a(paramChatMessage, this.jdField_a_of_type_Afwy);
    Object localObject = localafxi.a(paramView);
    int j;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = afur.a(paramView);
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localbguh.a(localObject[i]);
        i += 1;
      }
      if (localbguh.a() < 1) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label616;
      }
    }
    label462:
    label616:
    for (int i = 1;; i = 0)
    {
      int k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = afur.a(10.0F, paramView.getResources());
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      j = localObject[1] - afur.a(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - afur.a(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Alqb == null)
        {
          this.jdField_a_of_type_Alqb = new alqb(this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Alqb.a(this);
          this.jdField_a_of_type_Alqb.a(this);
        }
        this.jdField_a_of_type_Alqb.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bgtn.b(14.0F);
        this.jdField_a_of_type_Alqb.b = k;
        if (paramBoolean)
        {
          this.jdField_a_of_type_Alqb.a(localbguh, paramChatMessage.isMultiMsg);
          this.jdField_a_of_type_Alqb.a(k);
          this.jdField_a_of_type_Alqb.b(j);
          if ((paramView instanceof ArkAppView))
          {
            ((ArkAppView)paramView).setViewPressed(true);
            this.c = paramView;
          }
          a(paramView);
          if (i != 0) {
            a(paramView, localafxi);
          }
          if ((localafxi instanceof BaseBubbleBuilder))
          {
            EmojiStickerManager.a().a(paramView);
            paramChatMessage = ((BaseBubbleBuilder)localafxi).a(paramView);
            if (paramChatMessage != null)
            {
              this.jdField_a_of_type_AndroidViewView = paramView;
              if (!paramBoolean) {
                break label570;
              }
              paramChatMessage.a(paramView, true);
            }
          }
          if (paramBoolean)
          {
            if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Afwy.jdField_a_of_type_Alqg.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
              break label581;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatAdapter1", 2, "performCursorTouch ");
            }
          }
        }
        for (;;)
        {
          a(localafxi);
          bgkw.jdField_a_of_type_Boolean = true;
          return true;
          paramChatMessage = this.jdField_a_of_type_Alqb.a(paramView, this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Alqb.a(paramView, k, paramChatMessage.a, localbguh, true, paramChatMessage.b);
          break;
          paramChatMessage.a(paramView, false);
          break label462;
          this.jdField_a_of_type_Afwy.jdField_a_of_type_Alqg.a(paramView, this.jdField_a_of_type_Alqb);
        }
        a(paramView);
        return false;
        j = k - m;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "popup onDismiss is called");
    }
    EmojiStickerManager.a().b();
    if (this.jdField_a_of_type_Alqb != null) {
      this.jdField_a_of_type_Alqb.b();
    }
    afwq localafwq;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject = this.jdField_a_of_type_Afwy.jdField_a_of_type_Agwz.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afwy);
      if ((localObject instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject).d();
        localafwq = ((BaseBubbleBuilder)localObject).a(this.jdField_a_of_type_AndroidViewView);
        localObject = localafwq;
        if (localafwq != null) {
          localafwq.a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (Object localObject = localafwq;; localObject = null)
    {
      this.jdField_b_of_type_Boolean = false;
      bgkw.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        a((afwq)localObject);
        this.jdField_a_of_type_AndroidViewView = null;
        this.jdField_b_of_type_AndroidViewView = null;
      }
      if (this.c != null)
      {
        ((ArkAppView)this.c).setViewPressed(false);
        this.c = null;
      }
      return;
    }
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      afxi localafxi = this.jdField_a_of_type_Afwy.jdField_a_of_type_Agwz.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afwy);
      Context localContext = paramView.getContext();
      localafxi.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((paramView.getId() != 2131377124) && (alqc.a().c())) {
        alqc.a().d();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "onLongClick() called with: v = [" + paramView + "]");
    }
    boolean bool;
    ChatMessage localChatMessage;
    int i;
    if (this.jdField_a_of_type_Afwy.jdField_a_of_type_Boolean)
    {
      bool = false;
      if ((paramView instanceof AnimationTextView)) {
        ((AnimationTextView)paramView).setTag(2131368238, Boolean.valueOf(true));
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      localChatMessage = afur.a(paramView);
      if (!localChatMessage.isMultiMsg) {
        break label293;
      }
      if (awwt.b(localChatMessage)) {
        break label147;
      }
      i = 1;
    }
    for (;;)
    {
      label111:
      if (i != 0) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 1");
        }
      }
      label147:
      label182:
      do
      {
        do
        {
          return true;
          bool = this.jdField_a_of_type_Afwy.jdField_a_of_type_Alqg.a(paramView);
          break;
          i = 0;
          break label111;
          if (this.jdField_a_of_type_Afwy.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break label182;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 2");
        return true;
        if (!(paramView instanceof ETTextView)) {
          break label231;
        }
        ETTextView localETTextView = (ETTextView)paramView;
        if (!localETTextView.mHasClickedArkSpan) {
          break label231;
        }
        localETTextView.mHasClickedArkSpan = false;
        a(paramView);
      } while (!QLog.isColorLevel());
      QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 3");
      return true;
      label231:
      this.jdField_b_of_type_Boolean = true;
      afur.n = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
      }
      if ((!bool) && (this.jdField_a_of_type_Alqb != null) && (this.jdField_a_of_type_Alqb.a()))
      {
        a(paramView);
        return false;
      }
      return a(paramView, bool, localChatMessage);
      label293:
      i = 0;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    Object localObject1 = afur.a(paramView);
    if ((paramView instanceof ArkAppView))
    {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) {
          break label238;
        }
        tzo.a(this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (localObject1 != null)) {
      aoqq.a(118, (ChatMessage)localObject1, afur.a(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131368420);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Afwy.jdField_a_of_type_Agwz.a((ChatMessage)localObject1, this.jdField_a_of_type_Afwy);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
      {
        localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (localObject1 != null) {
          ((afwq)localObject1).a(paramView, paramMotionEvent);
        }
      }
      return false;
      label238:
      if ((this.jdField_a_of_type_Afwy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
        break;
      }
      localObject2 = (MessageForArkApp)localObject1;
      if (((MessageForArkApp)localObject2).ark_app_message == null) {
        break;
      }
      MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", ((MessageForArkApp)localObject2).ark_app_message.appView, "", "");
      break;
      localObject2 = paramView.findViewById(2131377935);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwz
 * JD-Core Version:    0.7.0.1
 */