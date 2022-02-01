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

public class aggt
  implements agjk, View.OnClickListener, blkc
{
  public ambt a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  
  public aggt(aggs paramaggs) {}
  
  private void a(aggk paramaggk)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bdom)) {
      ((bdom)localObject1).b(this.jdField_a_of_type_AndroidViewView);
    }
    do
    {
      do
      {
        return;
        if ((!(localObject1 instanceof ahtm)) || (this.jdField_b_of_type_AndroidViewView == null)) {
          break;
        }
        Object localObject2 = (ahtm)localObject1;
        this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean) {
          if (((ahtm)localObject2).jdField_a_of_type_Aqkt != null) {
            ((ahtm)localObject2).jdField_a_of_type_Aqkt.a(this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ahtm)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((ahtm)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((ahtm)localObject2).jdField_a_of_type_AndroidViewView, false);
          }
        }
        for (;;)
        {
          paramaggk = this.jdField_b_of_type_AndroidViewView.findViewById(2131368493);
          if ((paramaggk == null) || (!(paramaggk instanceof PAHighLightImageView))) {
            break;
          }
          ((PAHighLightImageView)paramaggk).a();
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
          {
            if (!((ahtm)localObject2).jdField_a_of_type_Boolean) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838316);
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (paramaggk == null) {
              aggs.a((MessageForStructing)localObject2, (aggl)localObject1, this.jdField_b_of_type_AndroidViewView, false);
            }
          }
        }
        paramaggk = this.jdField_b_of_type_AndroidViewView.findViewById(2131378089);
      } while ((paramaggk == null) || (!(paramaggk instanceof PAHighLightImageView)));
      ((PAHighLightImageView)paramaggk).a();
      return;
    } while (!(localObject1 instanceof bdqi));
    paramaggk = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131378072)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838304);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramaggk);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838308);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838306);
      }
    }
  }
  
  private void a(aghc paramaghc)
  {
    if ((paramaghc instanceof ahtp)) {
      paramaghc = Integer.toString(0);
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramaghc, "", "", "");
      return;
      if ((paramaghc instanceof ahng)) {
        paramaghc = Integer.toString(1);
      } else {
        paramaghc = Integer.toString(999);
      }
    }
  }
  
  private void a(View paramView, aghc paramaghc)
  {
    paramView.setPressed(true);
    this.jdField_a_of_type_AndroidViewView = paramView;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bdom)) {
      ((bdom)localObject1).c(this.jdField_a_of_type_AndroidViewView);
    }
    label113:
    label254:
    do
    {
      return;
      if ((localObject1 instanceof ahtm))
      {
        Object localObject2 = (ahtm)localObject1;
        ViewGroup.LayoutParams localLayoutParams;
        if ((paramaghc instanceof StructingMsgItemBuilder))
        {
          if (((StructingMsgItemBuilder)paramaghc).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
          {
            if ((((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
              this.jdField_b_of_type_AndroidViewView = ((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (((ahtm)localObject2).jdField_a_of_type_Boolean)) {
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
          if (!((ahtm)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            break label241;
          }
          ((ahtm)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850001);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          return;
          this.jdField_b_of_type_AndroidViewView = ((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout;
          this.jdField_a_of_type_Boolean = true;
          break label113;
          break;
          ((ahtm)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849825);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838318);
          }
          else
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (((BaseBubbleBuilder)paramaghc).a(paramView) == null) {
              aggs.a((MessageForStructing)localObject2, (aggl)localObject1, this.jdField_b_of_type_AndroidViewView, true);
            }
          }
        }
      }
    } while (!(localObject1 instanceof bdqi));
    label239:
    label241:
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramaghc = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)paramView.getTag(2131378072)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838305);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramaghc);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838309);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838307);
      }
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    bhuk localbhuk = new bhuk();
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + paramChatMessage.msgUid + ", time = " + paramChatMessage.time + ", msgtype = " + paramChatMessage.msgtype);
    }
    aghc localaghc = this.jdField_a_of_type_Aggs.jdField_a_of_type_Ahgk.a(paramChatMessage, this.jdField_a_of_type_Aggs);
    Object localObject = localaghc.a(paramView);
    int j;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = agej.a(paramView);
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localbhuk.a(localObject[i]);
        i += 1;
      }
      if (localbhuk.a() < 1) {
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
      int m = agej.a(10.0F, paramView.getResources());
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      j = localObject[1] - agej.a(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - agej.a(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Ambt == null)
        {
          this.jdField_a_of_type_Ambt = new ambt(this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Ambt.a(this);
          this.jdField_a_of_type_Ambt.a(this);
        }
        this.jdField_a_of_type_Ambt.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bhtq.b(14.0F);
        this.jdField_a_of_type_Ambt.b = k;
        if (paramBoolean)
        {
          this.jdField_a_of_type_Ambt.a(localbhuk, paramChatMessage.isMultiMsg);
          this.jdField_a_of_type_Ambt.a(k);
          this.jdField_a_of_type_Ambt.b(j);
          if ((paramView instanceof ArkAppView))
          {
            ((ArkAppView)paramView).setViewPressed(true);
            this.c = paramView;
          }
          a(paramView);
          if (i != 0) {
            a(paramView, localaghc);
          }
          if ((localaghc instanceof BaseBubbleBuilder))
          {
            EmojiStickerManager.a().a(paramView);
            paramChatMessage = ((BaseBubbleBuilder)localaghc).a(paramView);
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
            if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Aggs.jdField_a_of_type_Amby.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
              break label581;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatAdapter1", 2, "performCursorTouch ");
            }
          }
        }
        for (;;)
        {
          a(localaghc);
          bhkx.jdField_a_of_type_Boolean = true;
          return true;
          paramChatMessage = this.jdField_a_of_type_Ambt.a(paramView, this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Ambt.a(paramView, k, paramChatMessage.a, localbhuk, true, paramChatMessage.b);
          break;
          paramChatMessage.a(paramView, false);
          break label462;
          this.jdField_a_of_type_Aggs.jdField_a_of_type_Amby.a(paramView, this.jdField_a_of_type_Ambt);
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
    if (this.jdField_a_of_type_Ambt != null) {
      this.jdField_a_of_type_Ambt.b();
    }
    aggk localaggk;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject = this.jdField_a_of_type_Aggs.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aggs);
      if ((localObject instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject).d();
        localaggk = ((BaseBubbleBuilder)localObject).a(this.jdField_a_of_type_AndroidViewView);
        localObject = localaggk;
        if (localaggk != null) {
          localaggk.a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (Object localObject = localaggk;; localObject = null)
    {
      this.jdField_b_of_type_Boolean = false;
      bhkx.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        a((aggk)localObject);
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
      aghc localaghc = this.jdField_a_of_type_Aggs.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aggs);
      Context localContext = paramView.getContext();
      localaghc.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((paramView.getId() != 2131377264) && (ambu.a().c())) {
        ambu.a().d();
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
    if (this.jdField_a_of_type_Aggs.jdField_a_of_type_Boolean)
    {
      bool = false;
      if ((paramView instanceof AnimationTextView)) {
        ((AnimationTextView)paramView).setTag(2131368312, Boolean.valueOf(true));
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      localChatMessage = agej.a(paramView);
      if (!localChatMessage.isMultiMsg) {
        break label293;
      }
      if (axpm.b(localChatMessage)) {
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
          bool = this.jdField_a_of_type_Aggs.jdField_a_of_type_Amby.a(paramView);
          break;
          i = 0;
          break label111;
          if (this.jdField_a_of_type_Aggs.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
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
      agej.n = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
      }
      if ((!bool) && (this.jdField_a_of_type_Ambt != null) && (this.jdField_a_of_type_Ambt.a()))
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
    Object localObject1 = agej.a(paramView);
    if ((paramView instanceof ArkAppView))
    {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) {
          break label238;
        }
        tzq.a(this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (localObject1 != null)) {
      apeg.a(118, (ChatMessage)localObject1, agej.a(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131368493);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Aggs.jdField_a_of_type_Ahgk.a((ChatMessage)localObject1, this.jdField_a_of_type_Aggs);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
      {
        localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (localObject1 != null) {
          ((aggk)localObject1).a(paramView, paramMotionEvent);
        }
      }
      return false;
      label238:
      if ((this.jdField_a_of_type_Aggs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
        break;
      }
      localObject2 = (MessageForArkApp)localObject1;
      if (((MessageForArkApp)localObject2).ark_app_message == null) {
        break;
      }
      MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", ((MessageForArkApp)localObject2).ark_app_message.appView, "", "");
      break;
      localObject2 = paramView.findViewById(2131378089);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggt
 * JD-Core Version:    0.7.0.1
 */