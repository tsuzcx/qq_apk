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
import com.tencent.widget.ListView;

public class aeqp
  implements aetk, View.OnClickListener, bhvm
{
  public ajxl a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  
  public aeqp(aeqo paramaeqo) {}
  
  private void a(aeqy paramaeqy)
  {
    if ((paramaeqy instanceof agda)) {
      paramaeqy = Integer.toString(0);
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramaeqy, "", "", "");
      return;
      if ((paramaeqy instanceof afwu)) {
        paramaeqy = Integer.toString(1);
      } else {
        paramaeqy = Integer.toString(999);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "popup onDismiss is called");
    }
    EmojiStickerManager.a().b();
    if (this.jdField_a_of_type_Ajxl != null) {
      this.jdField_a_of_type_Ajxl.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Aeqo.jdField_a_of_type_Afpy.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aeqo);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((aeqh)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      bdft.jdField_a_of_type_Boolean = false;
      Object localObject2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if ((localObject2 == null) || (!(localObject2 instanceof azut))) {
          break label200;
        }
        ((azut)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label200:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView = null;
          this.jdField_b_of_type_AndroidViewView = null;
          if (this.c != null)
          {
            ((ArkAppView)this.c).setViewPressed(false);
            this.c = null;
          }
          return;
          if ((!(localObject2 instanceof agcx)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (agcx)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((agcx)localObject3).jdField_a_of_type_Anwo != null) {
              ((agcx)localObject3).jdField_a_of_type_Anwo.a(this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((agcx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((agcx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((agcx)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368094);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label440;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((agcx)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838193);
              }
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                aeqo.a((MessageForStructing)localObject3, (aeqi)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131377128);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof azwp));
      label440:
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131377111)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838181);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838185);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838183);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localaeqy = this.jdField_a_of_type_Aeqo.jdField_a_of_type_Afpy.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aeqo);
      localContext = paramView.getContext();
      localaeqy.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((paramView.getId() != 2131376341) && (ajxm.a().c())) {
        ajxm.a().d();
      }
    }
    while (!QLog.isColorLevel())
    {
      aeqy localaeqy;
      Context localContext;
      return;
    }
    QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "onLongClick() called with: v = [" + paramView + "]");
    }
    boolean bool;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_Aeqo.jdField_a_of_type_Boolean)
    {
      bool = false;
      if ((paramView instanceof AnimationTextView)) {
        ((AnimationTextView)paramView).setTag(2131367915, Boolean.valueOf(true));
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      localObject2 = aepi.a(paramView);
      if (!((ChatMessage)localObject2).isMultiMsg) {
        break label1319;
      }
      if (aupn.b((ChatMessage)localObject2)) {
        break label151;
      }
      i = 1;
    }
    for (;;)
    {
      label113:
      if (i != 0) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 1");
        }
      }
      label151:
      label187:
      do
      {
        do
        {
          return true;
          bool = this.jdField_a_of_type_Aeqo.jdField_a_of_type_Ajxq.a(paramView);
          break;
          i = 0;
          break label113;
          if (this.jdField_a_of_type_Aeqo.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break label187;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 2");
        return true;
        if (!(paramView instanceof ETTextView)) {
          break label237;
        }
        localObject1 = (ETTextView)paramView;
        if (!((ETTextView)localObject1).mHasClickedArkSpan) {
          break label237;
        }
        ((ETTextView)localObject1).mHasClickedArkSpan = false;
        a(paramView);
      } while (!QLog.isColorLevel());
      QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 3");
      return true;
      label237:
      this.jdField_b_of_type_Boolean = true;
      aepi.n = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
      }
      if ((!bool) && (this.jdField_a_of_type_Ajxl != null) && (this.jdField_a_of_type_Ajxl.a()))
      {
        a(paramView);
        return false;
      }
      Object localObject3 = new bdpi();
      if (QLog.isColorLevel()) {
        QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + ((ChatMessage)localObject2).msgUid + ", time = " + ((ChatMessage)localObject2).time + ", msgtype = " + ((ChatMessage)localObject2).msgtype);
      }
      Object localObject1 = this.jdField_a_of_type_Aeqo.jdField_a_of_type_Afpy.a((ChatMessage)localObject2, this.jdField_a_of_type_Aeqo);
      Object localObject4 = ((aeqy)localObject1).a(paramView);
      int j;
      if ((localObject4 != null) && (localObject4.length > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = aepi.a(paramView);
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          ((bdpi)localObject3).a(localObject4[i]);
          i += 1;
        }
        if (((bdpi)localObject3).a() < 1) {
          return false;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
          break label1314;
        }
      }
      label1286:
      label1314:
      for (i = 1;; i = 0)
      {
        int k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
        int m = aepi.a(10.0F, paramView.getResources());
        localObject4 = new int[2];
        paramView.getLocationOnScreen((int[])localObject4);
        j = localObject4[1] - aepi.a(3.0F, paramView.getResources());
        localObject4 = new Rect();
        paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
        if (j - aepi.a(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
        for (;;)
        {
          if (this.jdField_a_of_type_Ajxl == null)
          {
            this.jdField_a_of_type_Ajxl = new ajxl(this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            this.jdField_a_of_type_Ajxl.a(this);
            this.jdField_a_of_type_Ajxl.a(this);
          }
          this.jdField_a_of_type_Ajxl.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
          k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bdoo.b(14.0F);
          this.jdField_a_of_type_Ajxl.b = k;
          if (bool)
          {
            this.jdField_a_of_type_Ajxl.a((bdpi)localObject3, ((ChatMessage)localObject2).isMultiMsg);
            this.jdField_a_of_type_Ajxl.a(k);
            this.jdField_a_of_type_Ajxl.b(j);
            if ((paramView instanceof ArkAppView))
            {
              ((ArkAppView)paramView).setViewPressed(true);
              this.c = paramView;
            }
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject2 instanceof azut)) {
                break label861;
              }
              ((azut)localObject2).c(this.jdField_a_of_type_AndroidViewView);
            }
            label736:
            if ((localObject1 instanceof BaseBubbleBuilder))
            {
              EmojiStickerManager.a().a(paramView);
              localObject2 = ((BaseBubbleBuilder)localObject1).a(paramView);
              if (localObject2 != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!bool) {
                  break label1286;
                }
                ((aeqh)localObject2).a(paramView, true);
              }
            }
          }
          for (;;)
          {
            if (bool) {
              this.jdField_a_of_type_Aeqo.jdField_a_of_type_Ajxq.a(paramView, this.jdField_a_of_type_Ajxl);
            }
            a((aeqy)localObject1);
            bdft.jdField_a_of_type_Boolean = true;
            return true;
            localObject2 = this.jdField_a_of_type_Ajxl.a(paramView, this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            this.jdField_a_of_type_Ajxl.a(paramView, k, ((ajxu)localObject2).a, (bdpi)localObject3, true, ((ajxu)localObject2).b);
            break;
            label861:
            if ((localObject2 instanceof agcx))
            {
              localObject4 = (agcx)localObject2;
              if ((localObject1 instanceof StructingMsgItemBuilder))
              {
                if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
                {
                  if ((((agcx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((agcx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                    this.jdField_b_of_type_AndroidViewView = ((agcx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                  }
                  this.jdField_a_of_type_Boolean = false;
                }
              }
              else
              {
                if ((this.jdField_b_of_type_AndroidViewView == null) || (((agcx)localObject4).jdField_a_of_type_Boolean)) {
                  break label1063;
                }
                localObject3 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
                i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
                j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
                k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
                m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
                if (!this.jdField_a_of_type_Boolean) {
                  break label1079;
                }
                if (!((agcx)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                  break label1065;
                }
                ((agcx)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849439);
              }
              for (;;)
              {
                this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
                break;
                this.jdField_b_of_type_AndroidViewView = ((agcx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
                this.jdField_a_of_type_Boolean = true;
                break label936;
                break;
                ((agcx)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849263);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
                {
                  this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838195);
                }
                else
                {
                  localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                  if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                    aeqo.a((MessageForStructing)localObject4, (aeqi)localObject2, this.jdField_b_of_type_AndroidViewView, true);
                  }
                }
              }
            }
            label936:
            label1065:
            label1079:
            if (!(localObject2 instanceof azwp)) {
              break label736;
            }
            label1063:
            this.jdField_b_of_type_AndroidViewView = paramView;
            localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
            j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
            k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
            m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
            int n = ((Integer)paramView.getTag(2131377111)).intValue();
            if (n == 0) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838182);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              if (n == 2) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838186);
              } else {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838184);
              }
            }
            ((aeqh)localObject2).a(paramView, false);
          }
          a(paramView);
          return false;
          j = k - m;
        }
      }
      label1319:
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
    Object localObject1 = aepi.a(paramView);
    if ((paramView instanceof ArkAppView))
    {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) {
          break label238;
        }
        syb.a(this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (localObject1 != null)) {
      amrz.a(118, (ChatMessage)localObject1, aepi.a(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131368094);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Aeqo.jdField_a_of_type_Afpy.a((ChatMessage)localObject1, this.jdField_a_of_type_Aeqo);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
      {
        localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (localObject1 != null) {
          ((aeqh)localObject1).a(paramView, paramMotionEvent);
        }
      }
      return false;
      label238:
      if ((this.jdField_a_of_type_Aeqo.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
        break;
      }
      localObject2 = (MessageForArkApp)localObject1;
      if (((MessageForArkApp)localObject2).ark_app_message == null) {
        break;
      }
      MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", ((MessageForArkApp)localObject2).ark_app_message.appView, "", "");
      break;
      localObject2 = paramView.findViewById(2131377128);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqp
 * JD-Core Version:    0.7.0.1
 */