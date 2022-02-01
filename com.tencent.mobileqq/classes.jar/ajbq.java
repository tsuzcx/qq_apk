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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajbq
  implements agjk, View.OnClickListener, blkc
{
  amcb jdField_a_of_type_Amcb;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  
  private ajbq(ajbn paramajbn) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Amcb != null) {
      this.jdField_a_of_type_Amcb.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Ajbn.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Ajbn);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((aggk)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
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
        if ((localObject2 == null) || (!(localObject2 instanceof bdom))) {
          break label153;
        }
        ((bdom)localObject2).b(this.jdField_a_of_type_AndroidViewView);
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
          if ((!(localObject2 instanceof ahtm)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (ahtm)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((ahtm)localObject3).jdField_a_of_type_Aqkt != null) {
              ((ahtm)localObject3).jdField_a_of_type_Aqkt.a(this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((ahtm)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((ahtm)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((ahtm)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368493);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label376;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((ahtm)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838316);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                ajbn.c((MessageForStructing)localObject3, (aggl)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131378089);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof bdqi));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
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
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838308);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838306);
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
    label157:
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      if (i == 2131365352)
      {
        if (this.jdField_a_of_type_Ajbn.jdField_a_of_type_Ajbp != null) {
          this.jdField_a_of_type_Ajbn.jdField_a_of_type_Ajbp.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        if (this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          bdll.b(this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
      for (;;)
      {
        if ((i != 2131377264) && (ambu.a().c())) {
          ambu.a().d();
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((i != 2131365191) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))) {
          break label320;
        }
        if (!ambu.a().c()) {
          break;
        }
        localObject1 = ambu.a().b();
        ((ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard")).setText((CharSequence)localObject1);
        if (this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          bdll.b(this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))
      {
        localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
        if ((localObject2 == null) || (((MessageForStructing)localObject2).structingMsg == null) || (!"web".equals(((MessageForStructing)localObject2).structingMsg.mMsgAction)) || (((MessageForStructing)localObject2).structingMsg.mMsgUrl == null)) {
          break label386;
        }
        localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgUrl;
      }
    }
    label386:
    for (;;)
    {
      break label157;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
      break label157;
      label320:
      localObject1 = this.jdField_a_of_type_Ajbn.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Ajbn);
      localObject2 = paramView.getContext();
      ((aghc)localObject1).b = 2;
      ((aghc)localObject1).a(paramView.getId(), (Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
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
    if (this.jdField_a_of_type_Ajbn.jdField_a_of_type_Boolean) {}
    for (boolean bool1 = false; (!bool1) && (this.jdField_a_of_type_Amcb != null) && (this.jdField_a_of_type_Amcb.a()); bool1 = this.jdField_a_of_type_Ajbn.jdField_a_of_type_Amby.a(paramView))
    {
      a(paramView);
      return false;
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject4 = (aghd)agej.a(paramView);
    Object localObject2 = new bhuk();
    Object localObject3 = ((aghd)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject1 = this.jdField_a_of_type_Ajbn.jdField_a_of_type_Ahgk.a((ChatMessage)localObject3, this.jdField_a_of_type_Ajbn);
    bhum[] arrayOfbhum = ((aghc)localObject1).a(paramView);
    int j;
    int k;
    if ((arrayOfbhum != null) && (arrayOfbhum.length > 0))
    {
      j = arrayOfbhum.length;
      i = 0;
      while (i < j)
      {
        bhum localbhum = arrayOfbhum[i];
        k = localbhum.a();
        if ((k == 2131365191) || (k == 2131377264) || (k == 2131367078) || (k == 2131366320)) {
          ((bhuk)localObject2).a(localbhum);
        }
        i += 1;
      }
    }
    ((bhuk)localObject2).a(2131365352, this.jdField_a_of_type_Ajbn.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690639), 2130838934);
    if (((bhuk)localObject2).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aghd)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
        break label1162;
      }
    }
    label1162:
    for (int i = 1;; i = 0)
    {
      k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = agej.a(10.0F, paramView.getResources());
      localObject4 = new int[2];
      paramView.getLocationOnScreen((int[])localObject4);
      j = localObject4[1] - agej.a(3.0F, paramView.getResources());
      localObject4 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
      if (j - agej.a(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Amcb == null)
        {
          this.jdField_a_of_type_Amcb = new ambt(ajbn.a(this.jdField_a_of_type_Ajbn));
          this.jdField_a_of_type_Amcb.a(this);
          this.jdField_a_of_type_Amcb.a(this);
        }
        this.jdField_a_of_type_Amcb.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bhtq.b(14.0F);
        this.jdField_a_of_type_Amcb.b = k;
        boolean bool2;
        if (bool1)
        {
          localObject4 = this.jdField_a_of_type_Amcb;
          if ((localObject3 != null) && (((ChatMessage)localObject3).isMultiMsg))
          {
            bool2 = true;
            ((amcb)localObject4).a((bhuk)localObject2, bool2);
            this.jdField_a_of_type_Amcb.a(k);
            this.jdField_a_of_type_Amcb.b(j);
            label491:
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject2 instanceof bdom)) {
                break label691;
              }
              ((bdom)localObject2).c(this.jdField_a_of_type_AndroidViewView);
            }
            label539:
            if ((localObject1 instanceof BaseBubbleBuilder))
            {
              localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
              if (localObject1 != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!bool1) {
                  break label1116;
                }
                ((aggk)localObject1).a(paramView, true);
              }
            }
            label582:
            if (bool1)
            {
              if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Ajbn.jdField_a_of_type_Amby.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
                break label1128;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryBubbleListAdapter", 2, "performCursorTouch ");
              }
            }
          }
        }
        for (;;)
        {
          return true;
          bool2 = false;
          break;
          localObject3 = this.jdField_a_of_type_Amcb.a(paramView, ajbn.b(this.jdField_a_of_type_Ajbn));
          this.jdField_a_of_type_Amcb.a(paramView, k, ((amcc)localObject3).jdField_a_of_type_Int, (bhuk)localObject2, true, ((amcc)localObject3).b);
          break label491;
          label691:
          if ((localObject2 instanceof ahtm))
          {
            localObject4 = (ahtm)localObject2;
            if ((localObject1 instanceof StructingMsgItemBuilder))
            {
              if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
              {
                if ((((ahtm)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((ahtm)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                  this.jdField_b_of_type_AndroidViewView = ((ahtm)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                }
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else
            {
              label766:
              if ((this.jdField_b_of_type_AndroidViewView == null) || (((ahtm)localObject4).jdField_a_of_type_Boolean)) {
                break label893;
              }
              localObject3 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
              i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
              j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
              k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
              m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
              if (!this.jdField_a_of_type_Boolean) {
                break label909;
              }
              if (!((ahtm)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                break label895;
              }
              ((ahtm)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850001);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              this.jdField_b_of_type_AndroidViewView = ((ahtm)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
              this.jdField_a_of_type_Boolean = true;
              break label766;
              label893:
              break;
              label895:
              ((ahtm)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849825);
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
              {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838318);
              }
              else
              {
                localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                  ajbn.b((MessageForStructing)localObject4, (aggl)localObject2, this.jdField_b_of_type_AndroidViewView, true);
                }
              }
            }
          }
          label909:
          if (!(localObject2 instanceof bdqi)) {
            break label539;
          }
          this.jdField_b_of_type_AndroidViewView = paramView;
          localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          int n = ((Integer)paramView.getTag(2131378072)).intValue();
          if (n == 0) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838305);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            if (n == 2) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838309);
            } else {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838307);
            }
          }
          label1116:
          ((aggk)localObject1).a(paramView, false);
          break label582;
          label1128:
          this.jdField_a_of_type_Ajbn.jdField_a_of_type_Amby.a(paramView, this.jdField_a_of_type_Amcb);
        }
        a(paramView);
        return false;
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
    Object localObject = this.jdField_a_of_type_Ajbn.jdField_a_of_type_Ahgk.a(agej.a(paramView), this.jdField_a_of_type_Ajbn);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((aggk)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbq
 * JD-Core Version:    0.7.0.1
 */