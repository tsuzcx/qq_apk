import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiqz
  implements aftk, View.OnClickListener, blak
{
  alvy jdField_a_of_type_Alvy;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  
  private aiqz(aiqw paramaiqw) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Alvy != null) {
      this.jdField_a_of_type_Alvy.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Aiqw.jdField_a_of_type_Agvm.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aiqw);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((afqq)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if ((localObject2 == null) || (!(localObject2 instanceof bdnv))) {
          break label153;
        }
        ((bdnv)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label153:
      label376:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView = null;
          this.jdField_b_of_type_AndroidViewView = null;
          return;
          if ((!(localObject2 instanceof ahin)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (ahin)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((ahin)localObject3).jdField_a_of_type_Aqhi != null) {
              ((ahin)localObject3).jdField_a_of_type_Aqhi.a(this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((ahin)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((ahin)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((ahin)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368676);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label376;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((ahin)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838354);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                aiqw.c((MessageForStructing)localObject3, (afqr)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131378145);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof bdpr));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
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
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838346);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838344);
        }
      }
      localObject1 = null;
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
    int i = paramView.getId();
    Object localObject1;
    label158:
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      if (i == 2131365475)
      {
        if (this.jdField_a_of_type_Aiqw.jdField_a_of_type_Aiqy != null) {
          this.jdField_a_of_type_Aiqw.jdField_a_of_type_Aiqy.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        if (this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
          bdla.b(this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
        }
      }
      for (;;)
      {
        if ((i != 2131377287) && (alvr.a().c())) {
          alvr.a().d();
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((i != 2131365307) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))) {
          break label321;
        }
        if (!alvr.a().c()) {
          break;
        }
        localObject1 = alvr.a().b();
        ((ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard")).setText((CharSequence)localObject1);
        if (this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
          bdla.b(this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))
      {
        localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
        if ((localObject2 == null) || (((MessageForStructing)localObject2).structingMsg == null) || (!"web".equals(((MessageForStructing)localObject2).structingMsg.mMsgAction)) || (((MessageForStructing)localObject2).structingMsg.mMsgUrl == null)) {
          break label387;
        }
        localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgUrl;
      }
    }
    label387:
    for (;;)
    {
      break label158;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
      break label158;
      label321:
      localObject1 = this.jdField_a_of_type_Aiqw.jdField_a_of_type_Agvm.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aiqw);
      localObject2 = paramView.getContext();
      ((afrj)localObject1).b = 2;
      ((afrj)localObject1).a(paramView.getId(), (Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aiqw.jdField_a_of_type_Boolean) {}
    for (boolean bool1 = false; (!bool1) && (this.jdField_a_of_type_Alvy != null) && (this.jdField_a_of_type_Alvy.a()); bool1 = this.jdField_a_of_type_Aiqw.jdField_a_of_type_Alvv.a(paramView))
    {
      a(paramView);
      return false;
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject3 = (afrk)AIOUtils.getHolder(paramView);
    Object localObject2 = new bhjq();
    Object localObject1 = ((afrk)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    afrj localafrj = this.jdField_a_of_type_Aiqw.jdField_a_of_type_Agvm.a((ChatMessage)localObject1, this.jdField_a_of_type_Aiqw);
    Object localObject4 = localafrj.a(paramView);
    int j;
    int k;
    if ((localObject4 != null) && (localObject4.length > 0))
    {
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        bhjs localbhjs = localObject4[i];
        k = localbhjs.a();
        if ((k == 2131365307) || (k == 2131377287) || (k == 2131367213) || (k == 2131366456)) {
          ((bhjq)localObject2).a(localbhjs);
        }
        i += 1;
      }
    }
    ((bhjq)localObject2).a(2131365475, this.jdField_a_of_type_Aiqw.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690756), 2130838986);
    if (((bhjq)localObject2).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((afrk)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
        break label1244;
      }
    }
    label540:
    label583:
    label842:
    label971:
    label985:
    label1244:
    for (int i = 1;; i = 0)
    {
      k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = AIOUtils.dp2px(10.0F, paramView.getResources());
      localObject3 = new int[2];
      paramView.getLocationOnScreen((int[])localObject3);
      j = localObject3[1] - AIOUtils.dp2px(3.0F, paramView.getResources());
      localObject3 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject3);
      if (j - AIOUtils.dp2px(72.0F, paramView.getResources()) > ((Rect)localObject3).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Alvy == null)
        {
          this.jdField_a_of_type_Alvy = new alvq(aiqw.a(this.jdField_a_of_type_Aiqw));
          this.jdField_a_of_type_Alvy.a(this);
          this.jdField_a_of_type_Alvy.a(this);
        }
        this.jdField_a_of_type_Alvy.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.dpToPx(14.0F);
        this.jdField_a_of_type_Alvy.b = k;
        if (bool1)
        {
          localObject3 = this.jdField_a_of_type_Alvy;
          if ((localObject1 != null) && (((ChatMessage)localObject1).isMultiMsg)) {}
          for (boolean bool2 = true;; bool2 = false)
          {
            ((alvy)localObject3).a((bhjq)localObject2, bool2);
            this.jdField_a_of_type_Alvy.a(k);
            this.jdField_a_of_type_Alvy.b(j);
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject1 instanceof bdnv)) {
                break;
              }
              ((bdnv)localObject1).c(this.jdField_a_of_type_AndroidViewView);
            }
            if ((localafrj instanceof BaseBubbleBuilder))
            {
              localObject1 = ((BaseBubbleBuilder)localafrj).a(paramView);
              if (localObject1 != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!bool1) {
                  break label1192;
                }
                ((afqq)localObject1).a(paramView, true);
              }
            }
            if (bool1)
            {
              if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Aiqw.jdField_a_of_type_Alvv.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
                break label1204;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryBubbleListAdapter", 2, "performCursorTouch ");
              }
            }
            return true;
          }
        }
        localObject3 = this.jdField_a_of_type_Alvy.a(paramView, aiqw.b(this.jdField_a_of_type_Aiqw));
        if ((aiqw.c(this.jdField_a_of_type_Aiqw) != null) && (aiqw.d(this.jdField_a_of_type_Aiqw).mInputBar != null))
        {
          localObject1 = new int[2];
          aiqw.e(this.jdField_a_of_type_Aiqw).mInputBar.getLocationInWindow((int[])localObject1);
        }
        for (;;)
        {
          localObject4 = this.jdField_a_of_type_Alvy;
          j = ((alvz)localObject3).a;
          m = ((alvz)localObject3).b;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = Integer.valueOf(localObject1[1]))
          {
            ((alvy)localObject4).a(paramView, k, j, (bhjq)localObject2, true, m, (Integer)localObject1);
            break;
          }
          if ((localObject1 instanceof ahin))
          {
            localObject3 = (ahin)localObject1;
            if ((localafrj instanceof StructingMsgItemBuilder))
            {
              if (((StructingMsgItemBuilder)localafrj).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
              {
                if ((((ahin)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((ahin)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                  this.jdField_b_of_type_AndroidViewView = ((ahin)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                }
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else
            {
              if ((this.jdField_b_of_type_AndroidViewView == null) || (((ahin)localObject3).jdField_a_of_type_Boolean)) {
                break label969;
              }
              localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
              i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
              j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
              k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
              m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
              if (!this.jdField_a_of_type_Boolean) {
                break label985;
              }
              if (!((ahin)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                break label971;
              }
              ((ahin)localObject3).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850011);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              this.jdField_b_of_type_AndroidViewView = ((ahin)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout;
              this.jdField_a_of_type_Boolean = true;
              break label842;
              break;
              ((ahin)localObject3).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849835);
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
              {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838356);
              }
              else
              {
                localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if (((BaseBubbleBuilder)localafrj).a(paramView) == null) {
                  aiqw.b((MessageForStructing)localObject3, (afqr)localObject1, this.jdField_b_of_type_AndroidViewView, true);
                }
              }
            }
          }
          if (!(localObject1 instanceof bdpr)) {
            break label540;
          }
          this.jdField_b_of_type_AndroidViewView = paramView;
          localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          int n = ((Integer)paramView.getTag(2131378124)).intValue();
          if (n == 0) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838343);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            if (n == 2) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838347);
            } else {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838345);
            }
          }
          ((afqq)localObject1).a(paramView, false);
          break label583;
          this.jdField_a_of_type_Aiqw.jdField_a_of_type_Alvv.a(paramView, this.jdField_a_of_type_Alvy);
          break label641;
          a(paramView);
          return false;
          localObject1 = null;
        }
        j = k - m;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
    }
    Object localObject = this.jdField_a_of_type_Aiqw.jdField_a_of_type_Agvm.a(AIOUtils.getMessage(paramView), this.jdField_a_of_type_Aiqw);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((afqq)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqz
 * JD-Core Version:    0.7.0.1
 */