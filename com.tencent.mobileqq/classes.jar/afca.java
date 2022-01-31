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

class afca
  implements acxj, View.OnClickListener, bfqj
{
  aibu jdField_a_of_type_Aibu;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  
  private afca(afbx paramafbx) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aibu != null) {
      this.jdField_a_of_type_Aibu.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Afbx.jdField_a_of_type_Adte.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afbx);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((acui)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
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
        if ((localObject2 == null) || (!(localObject2 instanceof axuq))) {
          break label153;
        }
        ((axuq)localObject2).b(this.jdField_a_of_type_AndroidViewView);
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
          if ((!(localObject2 instanceof aebu)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (aebu)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((aebu)localObject3).jdField_a_of_type_Ambg != null) {
              ((aebu)localObject3).jdField_a_of_type_Ambg.a(this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((aebu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((aebu)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((aebu)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131367947);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label376;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((aebu)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838136);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                afbx.c((MessageForStructing)localObject3, (acuj)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131376574);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof axwm));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131376557)).intValue();
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
    int i = paramView.getId();
    label150:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      if (i == 2131364984)
      {
        if (this.jdField_a_of_type_Afbx.jdField_a_of_type_Afbz != null) {
          this.jdField_a_of_type_Afbx.jdField_a_of_type_Afbz.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        if (this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          axqy.b(this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
      for (;;)
      {
        if ((i != 2131375791) && (aibn.a().c())) {
          aibn.a().d();
        }
        return;
        if ((i != 2131364824) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))) {
          break label307;
        }
        if (!aibn.a().c()) {
          break;
        }
        paramView = aibn.a().a();
        ((ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard")).setText(paramView);
        if (this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          axqy.b(this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
        if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null) || (!"web".equals(((MessageForStructing)localObject).structingMsg.mMsgAction)) || (((MessageForStructing)localObject).structingMsg.mMsgUrl == null)) {
          break label373;
        }
        paramView = ((MessageForStructing)localObject).structingMsg.mMsgUrl;
      }
    }
    label307:
    label373:
    for (;;)
    {
      break label150;
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
      break label150;
      localObject = this.jdField_a_of_type_Afbx.jdField_a_of_type_Adte.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afbx);
      Context localContext = paramView.getContext();
      ((acuz)localObject).b = 2;
      ((acuz)localObject).a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
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
    if (this.jdField_a_of_type_Afbx.jdField_a_of_type_Boolean) {}
    for (boolean bool1 = false; (this.jdField_a_of_type_Aibu != null) && (this.jdField_a_of_type_Aibu.a()); bool1 = this.jdField_a_of_type_Afbx.jdField_a_of_type_Aibr.a(paramView))
    {
      a(paramView);
      return false;
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject4 = (acva)actj.a(paramView);
    Object localObject2 = new bbmf();
    Object localObject3 = ((acva)actj.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject1 = this.jdField_a_of_type_Afbx.jdField_a_of_type_Adte.a((ChatMessage)localObject3, this.jdField_a_of_type_Afbx);
    bbmh[] arrayOfbbmh = ((acuz)localObject1).a(paramView);
    int j;
    int k;
    if ((arrayOfbbmh != null) && (arrayOfbbmh.length > 0))
    {
      j = arrayOfbbmh.length;
      i = 0;
      while (i < j)
      {
        bbmh localbbmh = arrayOfbbmh[i];
        k = localbbmh.a();
        if ((k == 2131364824) || (k == 2131375791) || (k == 2131366632) || (k == 2131365928)) {
          ((bbmf)localObject2).a(localbbmh);
        }
        i += 1;
      }
    }
    ((bbmf)localObject2).a(2131364984, this.jdField_a_of_type_Afbx.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690708), 2130838601);
    if (((bbmf)localObject2).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((acva)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
        break label1101;
      }
    }
    label534:
    label1073:
    label1101:
    for (int i = 1;; i = 0)
    {
      k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = actj.a(10.0F, paramView.getResources());
      localObject4 = new int[2];
      paramView.getLocationOnScreen((int[])localObject4);
      j = localObject4[1] - actj.a(3.0F, paramView.getResources());
      localObject4 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
      if (j - actj.a(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Aibu == null)
        {
          this.jdField_a_of_type_Aibu = new aibm(afbx.a(this.jdField_a_of_type_Afbx));
          this.jdField_a_of_type_Aibu.a(this);
          this.jdField_a_of_type_Aibu.a(this);
        }
        this.jdField_a_of_type_Aibu.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bbll.b(14.0F);
        this.jdField_a_of_type_Aibu.b = k;
        boolean bool2;
        if (bool1)
        {
          localObject4 = this.jdField_a_of_type_Aibu;
          if ((localObject3 != null) && (((ChatMessage)localObject3).isMultiMsg))
          {
            bool2 = true;
            ((aibu)localObject4).a((bbmf)localObject2, bool2);
            this.jdField_a_of_type_Aibu.a(k);
            this.jdField_a_of_type_Aibu.b(j);
            label486:
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject2 instanceof axuq)) {
                break label648;
              }
              ((axuq)localObject2).c(this.jdField_a_of_type_AndroidViewView);
            }
            if ((localObject1 instanceof BaseBubbleBuilder))
            {
              localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
              if (localObject1 != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!bool1) {
                  break label1073;
                }
                ((acui)localObject1).a(paramView, true);
              }
            }
          }
        }
        for (;;)
        {
          if (bool1) {
            this.jdField_a_of_type_Afbx.jdField_a_of_type_Aibr.a(paramView, this.jdField_a_of_type_Aibu);
          }
          return true;
          bool2 = false;
          break;
          localObject3 = this.jdField_a_of_type_Aibu.a(paramView, afbx.b(this.jdField_a_of_type_Afbx));
          this.jdField_a_of_type_Aibu.a(paramView, k, ((aibv)localObject3).jdField_a_of_type_Int, (bbmf)localObject2, true, ((aibv)localObject3).b);
          break label486;
          if ((localObject2 instanceof aebu))
          {
            localObject4 = (aebu)localObject2;
            if ((localObject1 instanceof StructingMsgItemBuilder))
            {
              if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
              {
                if ((((aebu)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((aebu)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                  this.jdField_b_of_type_AndroidViewView = ((aebu)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                }
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else
            {
              label723:
              if ((this.jdField_b_of_type_AndroidViewView == null) || (((aebu)localObject4).jdField_a_of_type_Boolean)) {
                break label850;
              }
              localObject3 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
              i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
              j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
              k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
              m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
              if (!this.jdField_a_of_type_Boolean) {
                break label866;
              }
              if (!((aebu)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                break label852;
              }
              ((aebu)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848935);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              this.jdField_b_of_type_AndroidViewView = ((aebu)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
              this.jdField_a_of_type_Boolean = true;
              break label723;
              label850:
              break;
              label852:
              ((aebu)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848759);
              continue;
              label866:
              if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
              {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838138);
              }
              else
              {
                localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                  afbx.b((MessageForStructing)localObject4, (acuj)localObject2, this.jdField_b_of_type_AndroidViewView, true);
                }
              }
            }
          }
          if (!(localObject2 instanceof axwm)) {
            break label534;
          }
          this.jdField_b_of_type_AndroidViewView = paramView;
          localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          int n = ((Integer)paramView.getTag(2131376557)).intValue();
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
          ((acui)localObject1).a(paramView, false);
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
    Object localObject = this.jdField_a_of_type_Afbx.jdField_a_of_type_Adte.a(actj.a(paramView), this.jdField_a_of_type_Afbx);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((acui)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afca
 * JD-Core Version:    0.7.0.1
 */