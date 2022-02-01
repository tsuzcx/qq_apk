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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;

public class afra
  implements aftk, View.OnClickListener, blak
{
  public alvq a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  
  public afra(afqz paramafqz) {}
  
  private Integer a()
  {
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null))
    {
      arrayOfInt = new int[2];
      this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLocationInWindow(arrayOfInt);
    }
    for (;;)
    {
      if (arrayOfInt == null) {
        return null;
      }
      return Integer.valueOf(arrayOfInt[1]);
      arrayOfInt = null;
    }
  }
  
  private void a(afqq paramafqq)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bdnv)) {
      ((bdnv)localObject1).b(this.jdField_a_of_type_AndroidViewView);
    }
    do
    {
      do
      {
        return;
        if ((!(localObject1 instanceof ahin)) || (this.jdField_b_of_type_AndroidViewView == null)) {
          break;
        }
        Object localObject2 = (ahin)localObject1;
        this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean) {
          if (((ahin)localObject2).jdField_a_of_type_Aqhi != null) {
            ((ahin)localObject2).jdField_a_of_type_Aqhi.a(this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ahin)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((ahin)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((ahin)localObject2).jdField_a_of_type_AndroidViewView, false);
          }
        }
        for (;;)
        {
          paramafqq = this.jdField_b_of_type_AndroidViewView.findViewById(2131368676);
          if ((paramafqq == null) || (!(paramafqq instanceof PAHighLightImageView))) {
            break;
          }
          ((PAHighLightImageView)paramafqq).a();
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
          {
            if (!((ahin)localObject2).jdField_a_of_type_Boolean) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838354);
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (paramafqq == null) {
              afqz.a((MessageForStructing)localObject2, (afqr)localObject1, this.jdField_b_of_type_AndroidViewView, false);
            }
          }
        }
        paramafqq = this.jdField_b_of_type_AndroidViewView.findViewById(2131378145);
      } while ((paramafqq == null) || (!(paramafqq instanceof PAHighLightImageView)));
      ((PAHighLightImageView)paramafqq).a();
      return;
    } while (!(localObject1 instanceof bdpr));
    paramafqq = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131378124)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838342);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramafqq);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838346);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838344);
      }
    }
  }
  
  private void a(afrj paramafrj)
  {
    if ((paramafrj instanceof ahit)) {
      paramafrj = Integer.toString(0);
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramafrj, "", "", "");
      return;
      if ((paramafrj instanceof ahcj)) {
        paramafrj = Integer.toString(1);
      } else {
        paramafrj = Integer.toString(999);
      }
    }
  }
  
  private void a(View paramView, afrj paramafrj)
  {
    paramView.setPressed(true);
    this.jdField_a_of_type_AndroidViewView = paramView;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bdnv)) {
      ((bdnv)localObject1).c(this.jdField_a_of_type_AndroidViewView);
    }
    label113:
    label254:
    do
    {
      return;
      if ((localObject1 instanceof ahin))
      {
        Object localObject2 = (ahin)localObject1;
        ViewGroup.LayoutParams localLayoutParams;
        if ((paramafrj instanceof StructingMsgItemBuilder))
        {
          if (((StructingMsgItemBuilder)paramafrj).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
          {
            if ((((ahin)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((ahin)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
              this.jdField_b_of_type_AndroidViewView = ((ahin)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (((ahin)localObject2).jdField_a_of_type_Boolean)) {
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
          if (!((ahin)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            break label241;
          }
          ((ahin)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850011);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          return;
          this.jdField_b_of_type_AndroidViewView = ((ahin)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout;
          this.jdField_a_of_type_Boolean = true;
          break label113;
          break;
          ((ahin)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849835);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838356);
          }
          else
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (((BaseBubbleBuilder)paramafrj).a(paramView) == null) {
              afqz.a((MessageForStructing)localObject2, (afqr)localObject1, this.jdField_b_of_type_AndroidViewView, true);
            }
          }
        }
      }
    } while (!(localObject1 instanceof bdpr));
    label239:
    label241:
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramafrj = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)paramView.getTag(2131378124)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838343);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramafrj);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838347);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838345);
      }
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    bhjq localbhjq = new bhjq();
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + paramChatMessage.msgUid + ", time = " + paramChatMessage.time + ", msgtype = " + paramChatMessage.msgtype);
    }
    afrj localafrj = this.jdField_a_of_type_Afqz.jdField_a_of_type_Agvm.a(paramChatMessage, this.jdField_a_of_type_Afqz);
    Object localObject = localafrj.a(paramView);
    int j;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.getMessage(paramView);
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localbhjq.a(localObject[i]);
        i += 1;
      }
      if (localbhjq.a() < 1) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label621;
      }
    }
    label463:
    label621:
    for (int i = 1;; i = 0)
    {
      int k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = AIOUtils.dp2px(10.0F, paramView.getResources());
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      j = localObject[1] - AIOUtils.dp2px(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - AIOUtils.dp2px(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Alvq == null)
        {
          this.jdField_a_of_type_Alvq = new alvq(this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_Alvq.a(this);
          this.jdField_a_of_type_Alvq.a(this);
        }
        this.jdField_a_of_type_Alvq.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.dpToPx(14.0F);
        this.jdField_a_of_type_Alvq.b = k;
        if (paramBoolean)
        {
          this.jdField_a_of_type_Alvq.a(localbhjq, paramChatMessage.isMultiMsg);
          this.jdField_a_of_type_Alvq.a(k);
          this.jdField_a_of_type_Alvq.b(j);
          if ((paramView instanceof ArkAppView))
          {
            ((ArkAppView)paramView).setViewPressed(true);
            this.c = paramView;
          }
          a(paramView);
          if (i != 0) {
            a(paramView, localafrj);
          }
          if ((localafrj instanceof BaseBubbleBuilder))
          {
            EmojiStickerManager.a().a(paramView);
            paramChatMessage = ((BaseBubbleBuilder)localafrj).a(paramView);
            if (paramChatMessage != null)
            {
              this.jdField_a_of_type_AndroidViewView = paramView;
              if (!paramBoolean) {
                break label575;
              }
              paramChatMessage.a(paramView, true);
            }
          }
          if (paramBoolean)
          {
            if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Afqz.jdField_a_of_type_Alvv.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
              break label586;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatAdapter1", 2, "performCursorTouch ");
            }
          }
        }
        for (;;)
        {
          a(localafrj);
          bhcw.jdField_a_of_type_Boolean = true;
          return true;
          paramChatMessage = this.jdField_a_of_type_Alvq.a(paramView, this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_Alvq.a(paramView, k, paramChatMessage.a, localbhjq, true, paramChatMessage.b, a());
          break;
          paramChatMessage.a(paramView, false);
          break label463;
          this.jdField_a_of_type_Afqz.jdField_a_of_type_Alvv.a(paramView, this.jdField_a_of_type_Alvq);
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
    if (this.jdField_a_of_type_Alvq != null) {
      this.jdField_a_of_type_Alvq.b();
    }
    afqq localafqq;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject = this.jdField_a_of_type_Afqz.jdField_a_of_type_Agvm.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afqz);
      if ((localObject instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject).d();
        localafqq = ((BaseBubbleBuilder)localObject).a(this.jdField_a_of_type_AndroidViewView);
        localObject = localafqq;
        if (localafqq != null) {
          localafqq.a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (Object localObject = localafqq;; localObject = null)
    {
      this.jdField_b_of_type_Boolean = false;
      bhcw.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        a((afqq)localObject);
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
      afrj localafrj = this.jdField_a_of_type_Afqz.jdField_a_of_type_Agvm.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afqz);
      Context localContext = paramView.getContext();
      localafrj.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((paramView.getId() != 2131377287) && (alvr.a().c())) {
        alvr.a().d();
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
    if (this.jdField_a_of_type_Afqz.jdField_a_of_type_Boolean)
    {
      bool = false;
      if ((paramView instanceof AnimationTextView)) {
        ((AnimationTextView)paramView).setTag(2131368493, Boolean.valueOf(true));
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      localChatMessage = AIOUtils.getMessage(paramView);
      if (!localChatMessage.isMultiMsg) {
        break label293;
      }
      if (axiv.b(localChatMessage)) {
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
          bool = this.jdField_a_of_type_Afqz.jdField_a_of_type_Alvv.a(paramView);
          break;
          i = 0;
          break label111;
          if (this.jdField_a_of_type_Afqz.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
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
      AIOUtils.isUserOperatedInAIO = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
      }
      if ((!bool) && (this.jdField_a_of_type_Alvq != null) && (this.jdField_a_of_type_Alvq.a()))
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
    Object localObject1 = AIOUtils.getMessage(paramView);
    if ((paramView instanceof ArkAppView))
    {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1008) {
          break label238;
        }
        uuc.a(this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) && (localObject1 != null)) {
      apau.a(118, (ChatMessage)localObject1, AIOUtils.findMessagePosition(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131368676);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Afqz.jdField_a_of_type_Agvm.a((ChatMessage)localObject1, this.jdField_a_of_type_Afqz);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
      {
        localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (localObject1 != null) {
          ((afqq)localObject1).a(paramView, paramMotionEvent);
        }
      }
      return false;
      label238:
      if ((this.jdField_a_of_type_Afqz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
        break;
      }
      localObject2 = (MessageForArkApp)localObject1;
      if (((MessageForArkApp)localObject2).ark_app_message == null) {
        break;
      }
      MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", ((MessageForArkApp)localObject2).ark_app_message.appView, "", "");
      break;
      localObject2 = paramView.findViewById(2131378145);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afra
 * JD-Core Version:    0.7.0.1
 */