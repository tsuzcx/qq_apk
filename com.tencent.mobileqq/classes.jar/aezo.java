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

public class aezo
  implements afce, View.OnClickListener, bjoy
{
  public akxu a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  
  public aezo(aezn paramaezn) {}
  
  private Integer a()
  {
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null))
    {
      arrayOfInt = new int[2];
      this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLocationInWindow(arrayOfInt);
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
  
  private void a(aeze paramaeze)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bcgx)) {
      ((bcgx)localObject1).b(this.jdField_a_of_type_AndroidViewView);
    }
    do
    {
      do
      {
        return;
        if ((!(localObject1 instanceof agpx)) || (this.jdField_b_of_type_AndroidViewView == null)) {
          break;
        }
        Object localObject2 = (agpx)localObject1;
        this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean) {
          if (((agpx)localObject2).jdField_a_of_type_Apee != null) {
            ((agpx)localObject2).jdField_a_of_type_Apee.a(this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((agpx)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((agpx)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((agpx)localObject2).jdField_a_of_type_AndroidViewView, false);
          }
        }
        for (;;)
        {
          paramaeze = this.jdField_b_of_type_AndroidViewView.findViewById(2131368518);
          if ((paramaeze == null) || (!(paramaeze instanceof PAHighLightImageView))) {
            break;
          }
          ((PAHighLightImageView)paramaeze).a();
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
          {
            if (!((agpx)localObject2).jdField_a_of_type_Boolean) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838341);
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (paramaeze == null) {
              aezn.a((MessageForStructing)localObject2, (aezf)localObject1, this.jdField_b_of_type_AndroidViewView, false);
            }
          }
        }
        paramaeze = this.jdField_b_of_type_AndroidViewView.findViewById(2131377859);
      } while ((paramaeze == null) || (!(paramaeze instanceof PAHighLightImageView)));
      ((PAHighLightImageView)paramaeze).a();
      return;
    } while (!(localObject1 instanceof bcit));
    paramaeze = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131377842)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838329);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramaeze);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838333);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838331);
      }
    }
  }
  
  private void a(aezx paramaezx)
  {
    if ((paramaezx instanceof agqd)) {
      paramaezx = Integer.toString(0);
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramaezx, "", "", "");
      return;
      if ((paramaezx instanceof agjt)) {
        paramaezx = Integer.toString(1);
      } else {
        paramaezx = Integer.toString(999);
      }
    }
  }
  
  private void a(View paramView, aezx paramaezx)
  {
    paramView.setPressed(true);
    this.jdField_a_of_type_AndroidViewView = paramView;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bcgx)) {
      ((bcgx)localObject1).c(this.jdField_a_of_type_AndroidViewView);
    }
    label113:
    label254:
    do
    {
      return;
      if ((localObject1 instanceof agpx))
      {
        Object localObject2 = (agpx)localObject1;
        ViewGroup.LayoutParams localLayoutParams;
        if ((paramaezx instanceof StructingMsgItemBuilder))
        {
          if (((StructingMsgItemBuilder)paramaezx).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
          {
            if ((((agpx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((agpx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
              this.jdField_b_of_type_AndroidViewView = ((agpx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (((agpx)localObject2).jdField_a_of_type_Boolean)) {
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
          if (!((agpx)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            break label241;
          }
          ((agpx)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849918);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          return;
          this.jdField_b_of_type_AndroidViewView = ((agpx)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout;
          this.jdField_a_of_type_Boolean = true;
          break label113;
          break;
          ((agpx)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849742);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838343);
          }
          else
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (((BaseBubbleBuilder)paramaezx).a(paramView) == null) {
              aezn.a((MessageForStructing)localObject2, (aezf)localObject1, this.jdField_b_of_type_AndroidViewView, true);
            }
          }
        }
      }
    } while (!(localObject1 instanceof bcit));
    label239:
    label241:
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramaezx = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)paramView.getTag(2131377842)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838330);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramaezx);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838334);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838332);
      }
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    bgaz localbgaz = new bgaz();
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + paramChatMessage.msgUid + ", time = " + paramChatMessage.time + ", msgtype = " + paramChatMessage.msgtype);
    }
    aezx localaezx = this.jdField_a_of_type_Aezn.jdField_a_of_type_Agcw.a(paramChatMessage, this.jdField_a_of_type_Aezn);
    Object localObject = localaezx.a(paramView);
    int j;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.getMessage(paramView);
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localbgaz.a(localObject[i]);
        i += 1;
      }
      if (localbgaz.a() < 1) {
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
        if (this.jdField_a_of_type_Akxu == null)
        {
          this.jdField_a_of_type_Akxu = new akxu(this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_Akxu.a(this);
          this.jdField_a_of_type_Akxu.a(this);
        }
        this.jdField_a_of_type_Akxu.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.dpToPx(14.0F);
        this.jdField_a_of_type_Akxu.b = k;
        if (paramBoolean)
        {
          this.jdField_a_of_type_Akxu.a(localbgaz, paramChatMessage.isMultiMsg);
          this.jdField_a_of_type_Akxu.a(k);
          this.jdField_a_of_type_Akxu.b(j);
          if ((paramView instanceof ArkAppView))
          {
            ((ArkAppView)paramView).setViewPressed(true);
            this.c = paramView;
          }
          a(paramView);
          if (i != 0) {
            a(paramView, localaezx);
          }
          if ((localaezx instanceof BaseBubbleBuilder))
          {
            EmojiStickerManager.a().a(paramView);
            paramChatMessage = ((BaseBubbleBuilder)localaezx).a(paramView);
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
            if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Aezn.jdField_a_of_type_Akxz.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
              break label586;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatAdapter1", 2, "performCursorTouch ");
            }
          }
        }
        for (;;)
        {
          a(localaezx);
          bfue.jdField_a_of_type_Boolean = true;
          return true;
          paramChatMessage = this.jdField_a_of_type_Akxu.a(paramView, this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_Akxu.a(paramView, k, paramChatMessage.a, localbgaz, true, paramChatMessage.b, a());
          break;
          paramChatMessage.a(paramView, false);
          break label463;
          this.jdField_a_of_type_Aezn.jdField_a_of_type_Akxz.a(paramView, this.jdField_a_of_type_Akxu);
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
    if (this.jdField_a_of_type_Akxu != null) {
      this.jdField_a_of_type_Akxu.b();
    }
    aeze localaeze;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject = this.jdField_a_of_type_Aezn.jdField_a_of_type_Agcw.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aezn);
      if ((localObject instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject).d();
        localaeze = ((BaseBubbleBuilder)localObject).a(this.jdField_a_of_type_AndroidViewView);
        localObject = localaeze;
        if (localaeze != null) {
          localaeze.a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (Object localObject = localaeze;; localObject = null)
    {
      this.jdField_b_of_type_Boolean = false;
      bfue.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        a((aeze)localObject);
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
      aezx localaezx = this.jdField_a_of_type_Aezn.jdField_a_of_type_Agcw.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aezn);
      Context localContext = paramView.getContext();
      localaezx.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((paramView.getId() != 2131377014) && (akxv.a().c())) {
        akxv.a().d();
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
    if (this.jdField_a_of_type_Aezn.jdField_a_of_type_Boolean)
    {
      bool = false;
      if ((paramView instanceof AnimationTextView)) {
        ((AnimationTextView)paramView).setTag(2131368336, Boolean.valueOf(true));
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      localChatMessage = AIOUtils.getMessage(paramView);
      if (!localChatMessage.isMultiMsg) {
        break label293;
      }
      if (awct.b(localChatMessage)) {
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
          bool = this.jdField_a_of_type_Aezn.jdField_a_of_type_Akxz.a(paramView);
          break;
          i = 0;
          break label111;
          if (this.jdField_a_of_type_Aezn.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
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
      if ((!bool) && (this.jdField_a_of_type_Akxu != null) && (this.jdField_a_of_type_Akxu.a()))
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
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1008) {
          break label238;
        }
        ugf.a(this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) && (localObject1 != null)) {
      anxs.a(118, (ChatMessage)localObject1, AIOUtils.findMessagePosition(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131368518);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Aezn.jdField_a_of_type_Agcw.a((ChatMessage)localObject1, this.jdField_a_of_type_Aezn);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
      {
        localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (localObject1 != null) {
          ((aeze)localObject1).a(paramView, paramMotionEvent);
        }
      }
      return false;
      label238:
      if ((this.jdField_a_of_type_Aezn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
        break;
      }
      localObject2 = (MessageForArkApp)localObject1;
      if (((MessageForArkApp)localObject2).ark_app_message == null) {
        break;
      }
      MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", ((MessageForArkApp)localObject2).ark_app_message.appView, "", "");
      break;
      localObject2 = paramView.findViewById(2131377859);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezo
 * JD-Core Version:    0.7.0.1
 */