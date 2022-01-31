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

class agzf
  implements aeov, View.OnClickListener, bhrf
{
  ajte jdField_a_of_type_Ajte;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  
  private agzf(agzc paramagzc) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ajte != null) {
      this.jdField_a_of_type_Ajte.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Agzc.jdField_a_of_type_Aflj.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Agzc);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((aels)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
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
        if ((localObject2 == null) || (!(localObject2 instanceof azqk))) {
          break label153;
        }
        ((azqk)localObject2).b(this.jdField_a_of_type_AndroidViewView);
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
          if ((!(localObject2 instanceof afyi)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (afyi)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((afyi)localObject3).jdField_a_of_type_Ansf != null) {
              ((afyi)localObject3).jdField_a_of_type_Ansf.a(this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((afyi)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((afyi)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((afyi)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368083);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label376;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((afyi)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838192);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                agzc.c((MessageForStructing)localObject3, (aelt)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131377074);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof azsg));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131377057)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838180);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838184);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838182);
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
      if (i == 2131365069)
      {
        if (this.jdField_a_of_type_Agzc.jdField_a_of_type_Agze != null) {
          this.jdField_a_of_type_Agzc.jdField_a_of_type_Agze.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        if (this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          azmj.b(this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
      for (;;)
      {
        if ((i != 2131376287) && (ajsx.a().c())) {
          ajsx.a().d();
        }
        return;
        if ((i != 2131364910) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))) {
          break label307;
        }
        if (!ajsx.a().c()) {
          break;
        }
        paramView = ajsx.a().a();
        ((ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard")).setText(paramView);
        if (this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          azmj.b(this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
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
      localObject = this.jdField_a_of_type_Agzc.jdField_a_of_type_Aflj.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Agzc);
      Context localContext = paramView.getContext();
      ((aemj)localObject).b = 2;
      ((aemj)localObject).a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
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
    if (this.jdField_a_of_type_Agzc.jdField_a_of_type_Boolean) {}
    for (boolean bool1 = false; (this.jdField_a_of_type_Ajte != null) && (this.jdField_a_of_type_Ajte.a()); bool1 = this.jdField_a_of_type_Agzc.jdField_a_of_type_Ajtb.a(paramView))
    {
      a(paramView);
      return false;
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject4 = (aemk)aekt.a(paramView);
    Object localObject2 = new bdkz();
    Object localObject3 = ((aemk)aekt.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject1 = this.jdField_a_of_type_Agzc.jdField_a_of_type_Aflj.a((ChatMessage)localObject3, this.jdField_a_of_type_Agzc);
    bdlb[] arrayOfbdlb = ((aemj)localObject1).a(paramView);
    int j;
    int k;
    if ((arrayOfbdlb != null) && (arrayOfbdlb.length > 0))
    {
      j = arrayOfbdlb.length;
      i = 0;
      while (i < j)
      {
        bdlb localbdlb = arrayOfbdlb[i];
        k = localbdlb.a();
        if ((k == 2131364910) || (k == 2131376287) || (k == 2131366750) || (k == 2131366015)) {
          ((bdkz)localObject2).a(localbdlb);
        }
        i += 1;
      }
    }
    ((bdkz)localObject2).a(2131365069, this.jdField_a_of_type_Agzc.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690760), 2130838672);
    if (((bdkz)localObject2).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aemk)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      int m = aekt.a(10.0F, paramView.getResources());
      localObject4 = new int[2];
      paramView.getLocationOnScreen((int[])localObject4);
      j = localObject4[1] - aekt.a(3.0F, paramView.getResources());
      localObject4 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
      if (j - aekt.a(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Ajte == null)
        {
          this.jdField_a_of_type_Ajte = new ajsw(agzc.a(this.jdField_a_of_type_Agzc));
          this.jdField_a_of_type_Ajte.a(this);
          this.jdField_a_of_type_Ajte.a(this);
        }
        this.jdField_a_of_type_Ajte.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bdkf.b(14.0F);
        this.jdField_a_of_type_Ajte.b = k;
        boolean bool2;
        if (bool1)
        {
          localObject4 = this.jdField_a_of_type_Ajte;
          if ((localObject3 != null) && (((ChatMessage)localObject3).isMultiMsg))
          {
            bool2 = true;
            ((ajte)localObject4).a((bdkz)localObject2, bool2);
            this.jdField_a_of_type_Ajte.a(k);
            this.jdField_a_of_type_Ajte.b(j);
            label486:
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject2 instanceof azqk)) {
                break label648;
              }
              ((azqk)localObject2).c(this.jdField_a_of_type_AndroidViewView);
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
                ((aels)localObject1).a(paramView, true);
              }
            }
          }
        }
        for (;;)
        {
          if (bool1) {
            this.jdField_a_of_type_Agzc.jdField_a_of_type_Ajtb.a(paramView, this.jdField_a_of_type_Ajte);
          }
          return true;
          bool2 = false;
          break;
          localObject3 = this.jdField_a_of_type_Ajte.a(paramView, agzc.b(this.jdField_a_of_type_Agzc));
          this.jdField_a_of_type_Ajte.a(paramView, k, ((ajtf)localObject3).jdField_a_of_type_Int, (bdkz)localObject2, true, ((ajtf)localObject3).b);
          break label486;
          if ((localObject2 instanceof afyi))
          {
            localObject4 = (afyi)localObject2;
            if ((localObject1 instanceof StructingMsgItemBuilder))
            {
              if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
              {
                if ((((afyi)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((afyi)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                  this.jdField_b_of_type_AndroidViewView = ((afyi)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                }
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else
            {
              label723:
              if ((this.jdField_b_of_type_AndroidViewView == null) || (((afyi)localObject4).jdField_a_of_type_Boolean)) {
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
              if (!((afyi)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                break label852;
              }
              ((afyi)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849366);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              this.jdField_b_of_type_AndroidViewView = ((afyi)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
              this.jdField_a_of_type_Boolean = true;
              break label723;
              label850:
              break;
              label852:
              ((afyi)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849190);
              continue;
              label866:
              if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
              {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838194);
              }
              else
              {
                localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                  agzc.b((MessageForStructing)localObject4, (aelt)localObject2, this.jdField_b_of_type_AndroidViewView, true);
                }
              }
            }
          }
          if (!(localObject2 instanceof azsg)) {
            break label534;
          }
          this.jdField_b_of_type_AndroidViewView = paramView;
          localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          int n = ((Integer)paramView.getTag(2131377057)).intValue();
          if (n == 0) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838181);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            if (n == 2) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838185);
            } else {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838183);
            }
          }
          ((aels)localObject1).a(paramView, false);
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
    Object localObject = this.jdField_a_of_type_Agzc.jdField_a_of_type_Aflj.a(aekt.a(paramView), this.jdField_a_of_type_Agzc);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((aels)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzf
 * JD-Core Version:    0.7.0.1
 */