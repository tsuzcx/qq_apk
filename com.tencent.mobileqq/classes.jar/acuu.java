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

public class acuu
  implements acxn, View.OnClickListener, bfps
{
  public aibo a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  
  public acuu(acut paramacut) {}
  
  private void a(acvd paramacvd)
  {
    if ((paramacvd instanceof aebz)) {
      paramacvd = Integer.toString(0);
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramacvd, "", "", "");
      return;
      if ((paramacvd instanceof advu)) {
        paramacvd = Integer.toString(1);
      } else {
        paramacvd = Integer.toString(999);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "popup onDismiss is called");
    }
    EmojiStickerManager.a().b();
    if (this.jdField_a_of_type_Aibo != null) {
      this.jdField_a_of_type_Aibo.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Acut.jdField_a_of_type_Adtg.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Acut);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((acum)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      bbcc.jdField_a_of_type_Boolean = false;
      Object localObject2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if ((localObject2 == null) || (!(localObject2 instanceof axuo))) {
          break label200;
        }
        ((axuo)localObject2).b(this.jdField_a_of_type_AndroidViewView);
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
          if ((!(localObject2 instanceof aebw)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (aebw)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((aebw)localObject3).jdField_a_of_type_Ambh != null) {
              ((aebw)localObject3).jdField_a_of_type_Ambh.a(this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((aebw)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((aebw)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((aebw)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131367947);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label440;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((aebw)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838136);
              }
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                acut.a((MessageForStructing)localObject3, (acun)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131376572);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof axwk));
      label440:
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131376555)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838124);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838128);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838126);
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
      localacvd = this.jdField_a_of_type_Acut.jdField_a_of_type_Adtg.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Acut);
      localContext = paramView.getContext();
      localacvd.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((paramView.getId() != 2131375789) && (aibp.a().c())) {
        aibp.a().d();
      }
    }
    while (!QLog.isColorLevel())
    {
      acvd localacvd;
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
    if (this.jdField_a_of_type_Acut.jdField_a_of_type_Boolean)
    {
      bool = false;
      if ((paramView instanceof AnimationTextView)) {
        ((AnimationTextView)paramView).setTag(2131367770, Boolean.valueOf(true));
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      localObject2 = actn.a(paramView);
      if (!((ChatMessage)localObject2).isMultiMsg) {
        break label1319;
      }
      if (asuf.b((ChatMessage)localObject2)) {
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
          bool = this.jdField_a_of_type_Acut.jdField_a_of_type_Aibt.a(paramView);
          break;
          i = 0;
          break label113;
          if (this.jdField_a_of_type_Acut.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
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
      actn.n = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
      }
      if ((!bool) && (this.jdField_a_of_type_Aibo != null) && (this.jdField_a_of_type_Aibo.a()))
      {
        a(paramView);
        return false;
      }
      Object localObject3 = new bblr();
      if (QLog.isColorLevel()) {
        QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + ((ChatMessage)localObject2).msgUid + ", time = " + ((ChatMessage)localObject2).time + ", msgtype = " + ((ChatMessage)localObject2).msgtype);
      }
      Object localObject1 = this.jdField_a_of_type_Acut.jdField_a_of_type_Adtg.a((ChatMessage)localObject2, this.jdField_a_of_type_Acut);
      Object localObject4 = ((acvd)localObject1).a(paramView);
      int j;
      if ((localObject4 != null) && (localObject4.length > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = actn.a(paramView);
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          ((bblr)localObject3).a(localObject4[i]);
          i += 1;
        }
        if (((bblr)localObject3).a() < 1) {
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
        int m = actn.a(10.0F, paramView.getResources());
        localObject4 = new int[2];
        paramView.getLocationOnScreen((int[])localObject4);
        j = localObject4[1] - actn.a(3.0F, paramView.getResources());
        localObject4 = new Rect();
        paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
        if (j - actn.a(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
        for (;;)
        {
          if (this.jdField_a_of_type_Aibo == null)
          {
            this.jdField_a_of_type_Aibo = new aibo(this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            this.jdField_a_of_type_Aibo.a(this);
            this.jdField_a_of_type_Aibo.a(this);
          }
          this.jdField_a_of_type_Aibo.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
          k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bbkx.b(14.0F);
          this.jdField_a_of_type_Aibo.b = k;
          if (bool)
          {
            this.jdField_a_of_type_Aibo.a((bblr)localObject3, ((ChatMessage)localObject2).isMultiMsg);
            this.jdField_a_of_type_Aibo.a(k);
            this.jdField_a_of_type_Aibo.b(j);
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
              if (!(localObject2 instanceof axuo)) {
                break label861;
              }
              ((axuo)localObject2).c(this.jdField_a_of_type_AndroidViewView);
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
                ((acum)localObject2).a(paramView, true);
              }
            }
          }
          for (;;)
          {
            if (bool) {
              this.jdField_a_of_type_Acut.jdField_a_of_type_Aibt.a(paramView, this.jdField_a_of_type_Aibo);
            }
            a((acvd)localObject1);
            bbcc.jdField_a_of_type_Boolean = true;
            return true;
            localObject2 = this.jdField_a_of_type_Aibo.a(paramView, this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
            this.jdField_a_of_type_Aibo.a(paramView, k, ((aibx)localObject2).a, (bblr)localObject3, true, ((aibx)localObject2).b);
            break;
            label861:
            if ((localObject2 instanceof aebw))
            {
              localObject4 = (aebw)localObject2;
              if ((localObject1 instanceof StructingMsgItemBuilder))
              {
                if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
                {
                  if ((((aebw)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((aebw)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                    this.jdField_b_of_type_AndroidViewView = ((aebw)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                  }
                  this.jdField_a_of_type_Boolean = false;
                }
              }
              else
              {
                if ((this.jdField_b_of_type_AndroidViewView == null) || (((aebw)localObject4).jdField_a_of_type_Boolean)) {
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
                if (!((aebw)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                  break label1065;
                }
                ((aebw)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848929);
              }
              for (;;)
              {
                this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
                break;
                this.jdField_b_of_type_AndroidViewView = ((aebw)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
                this.jdField_a_of_type_Boolean = true;
                break label936;
                break;
                ((aebw)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848753);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
                {
                  this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838138);
                }
                else
                {
                  localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                  if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                    acut.a((MessageForStructing)localObject4, (acun)localObject2, this.jdField_b_of_type_AndroidViewView, true);
                  }
                }
              }
            }
            label936:
            label1065:
            label1079:
            if (!(localObject2 instanceof axwk)) {
              break label736;
            }
            label1063:
            this.jdField_b_of_type_AndroidViewView = paramView;
            localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
            j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
            k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
            m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
            int n = ((Integer)paramView.getTag(2131376555)).intValue();
            if (n == 0) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838125);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              if (n == 2) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838129);
              } else {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838127);
              }
            }
            ((acum)localObject2).a(paramView, false);
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
    Object localObject1 = actn.a(paramView);
    if ((paramView instanceof ArkAppView))
    {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) {
          break label238;
        }
        sgj.a(this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (localObject1 != null)) {
      akwv.a(118, (ChatMessage)localObject1, actn.a(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131367947);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Acut.jdField_a_of_type_Adtg.a((ChatMessage)localObject1, this.jdField_a_of_type_Acut);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
      {
        localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (localObject1 != null) {
          ((acum)localObject1).a(paramView, paramMotionEvent);
        }
      }
      return false;
      label238:
      if ((this.jdField_a_of_type_Acut.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
        break;
      }
      localObject2 = (MessageForArkApp)localObject1;
      if (((MessageForArkApp)localObject2).ark_app_message == null) {
        break;
      }
      MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", ((MessageForArkApp)localObject2).ark_app_message.appView, "", "");
      break;
      localObject2 = paramView.findViewById(2131376572);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acuu
 * JD-Core Version:    0.7.0.1
 */