import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afxf
  implements afzq, View.OnClickListener, bkiz
{
  alqj jdField_a_of_type_Alqj;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d;
  
  private afxf(afxc paramafxc) {}
  
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
  
  private boolean a(bguh parambguh, View paramView, boolean paramBoolean, ChatMessage paramChatMessage, afxi paramafxi)
  {
    if (parambguh.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((afxj)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label465;
      }
    }
    label257:
    label420:
    label431:
    label465:
    for (int i = 1;; i = 0)
    {
      int k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = afur.a(10.0F, paramView.getResources());
      Object localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      int j = localObject[1] - afur.a(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - afur.a(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Alqj == null)
        {
          this.jdField_a_of_type_Alqj = new alqb(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Alqj.a(this);
          this.jdField_a_of_type_Alqj.a(this);
        }
        this.jdField_a_of_type_Alqj.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bgtn.b(14.0F);
        this.jdField_a_of_type_Alqj.b = k;
        boolean bool;
        if (paramBoolean)
        {
          localObject = this.jdField_a_of_type_Alqj;
          if ((paramChatMessage != null) && (paramChatMessage.isMultiMsg))
          {
            bool = true;
            ((alqj)localObject).a(parambguh, bool);
            this.jdField_a_of_type_Alqj.a(k);
            this.jdField_a_of_type_Alqj.b(j);
            a(paramView);
            if (i != 0) {
              a(paramView, paramafxi);
            }
            if ((paramafxi instanceof BaseBubbleBuilder))
            {
              parambguh = ((BaseBubbleBuilder)paramafxi).a(paramView);
              if (parambguh != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!paramBoolean) {
                  break label420;
                }
                parambguh.a(paramView, true);
              }
            }
          }
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Afxc.jdField_a_of_type_Alqg.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
              break label431;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatHistoryAdapterForC2C", 2, "performCursorTouch ");
            }
          }
          return true;
          bool = false;
          break;
          paramChatMessage = this.jdField_a_of_type_Alqj.a(paramView, this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Alqj.a(paramView, k, paramChatMessage.a, parambguh, true, paramChatMessage.b);
          break label257;
          parambguh.a(paramView, false);
        }
        this.jdField_a_of_type_Afxc.jdField_a_of_type_Alqg.a(paramView, this.jdField_a_of_type_Alqj);
        return true;
        a(paramView);
        return false;
        j = k - m;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Alqj != null) {
      this.jdField_a_of_type_Alqj.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Afxc.jdField_a_of_type_Agwz.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afxc);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((afwq)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
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
        if (!(localObject2 instanceof bcvt)) {
          break label148;
        }
        ((bcvt)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label148:
      label328:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView = null;
          this.jdField_b_of_type_AndroidViewView = null;
          return;
          if ((!(localObject2 instanceof ahkc)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (ahkc)localObject2;
          if (this.jdField_a_of_type_Boolean) {
            if (((ahkc)localObject3).jdField_a_of_type_Apwt != null) {
              ((ahkc)localObject3).jdField_a_of_type_Apwt.a(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ahkc)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((ahkc)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((ahkc)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368420);
            if (!(localObject1 instanceof PAHighLightImageView)) {
              break label328;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((ahkc)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838306);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                afwy.a((MessageForStructing)localObject3, (afwr)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131377935);
          if ((localObject1 instanceof PAHighLightImageView)) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof bcxp));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
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
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838298);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838296);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      if (i == 2131365308)
      {
        if (afxc.a(this.jdField_a_of_type_Afxc) != null) {
          afxc.a(this.jdField_a_of_type_Afxc).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        VipUtils.a(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
    }
    for (;;)
    {
      if ((i != 2131377124) && (alqc.a().c())) {
        alqc.a().d();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (i == 2131378323)
      {
        bcst.b(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        localObject = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject = atvo.a(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
        if (localObject != null) {
          bdho.a((FileManagerEntity)localObject, this.jdField_a_of_type_Afxc.b, this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        } else {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131718472), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298998));
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_Afxc.jdField_a_of_type_Agwz.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afxc);
        Context localContext = paramView.getContext();
        ((afxi)localObject).a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = 0;
    if (this.jdField_a_of_type_Afxc.jdField_a_of_type_Boolean) {}
    for (boolean bool = false;; bool = this.jdField_a_of_type_Afxc.jdField_a_of_type_Alqg.a(paramView))
    {
      this.jdField_b_of_type_Boolean = true;
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      if ((bool) || (this.jdField_a_of_type_Alqj == null) || (!this.jdField_a_of_type_Alqj.a())) {
        break;
      }
      a(paramView);
      return false;
    }
    bguh localbguh = new bguh();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((afxj)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype;
    if ((j == -2014) || (j == -2005))
    {
      if (this.c)
      {
        this.d = arag.a().c();
        this.c = false;
      }
      localObject1 = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject3 = atvo.a(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if ((localObject3 != null) && (((FileManagerEntity)localObject3).status != 16))
      {
        long l = atvo.a(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject3).fileName);
        localObject2 = araw.a().c();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = bdjg.a;
        }
        if ((this.d) && (bdjg.a(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          bcst.b(this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          localbguh.a(2131378323, this.jdField_a_of_type_Afxc.b.getString(2131718475), 2130838940);
        }
      }
    }
    Object localObject1 = ((afxj)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = this.jdField_a_of_type_Afxc.jdField_a_of_type_Agwz.a((ChatMessage)localObject1, this.jdField_a_of_type_Afxc);
    Object localObject3 = ((afxi)localObject2).a(paramView);
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      j = localObject3.length;
      while (i < j)
      {
        bguj localbguj = localObject3[i];
        int k = localbguj.a();
        if (((k == 2131365147) || (k == 2131377124) || (k == 2131367027) || (k == 2131366271)) && (localbguj.b() != 2130838466)) {
          localbguh.a(localbguj);
        }
        i += 1;
      }
    }
    localbguh.a(2131365308, this.jdField_a_of_type_Afxc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690641), 2130838924);
    return a(localbguh, paramView, bool, (ChatMessage)localObject1, (afxi)localObject2);
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
    Object localObject = this.jdField_a_of_type_Afxc.jdField_a_of_type_Agwz.a(((afxj)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Afxc);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((afwq)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxf
 * JD-Core Version:    0.7.0.1
 */