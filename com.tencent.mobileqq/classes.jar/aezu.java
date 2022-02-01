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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aezu
  implements afce, View.OnClickListener, bjoy
{
  akyc jdField_a_of_type_Akyc;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d;
  
  private aezu(aezr paramaezr) {}
  
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
  
  private boolean a(bgaz parambgaz, View paramView, boolean paramBoolean, ChatMessage paramChatMessage, aezx paramaezx)
  {
    if (parambgaz.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aezy)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label549;
      }
    }
    label549:
    for (int i = 1;; i = 0)
    {
      int k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = AIOUtils.dp2px(10.0F, paramView.getResources());
      Object localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      int j = localObject[1] - AIOUtils.dp2px(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - AIOUtils.dp2px(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Akyc == null)
        {
          this.jdField_a_of_type_Akyc = new akxu(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_Akyc.a(this);
          this.jdField_a_of_type_Akyc.a(this);
        }
        this.jdField_a_of_type_Akyc.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.dpToPx(14.0F);
        this.jdField_a_of_type_Akyc.b = k;
        if (paramBoolean)
        {
          localObject = this.jdField_a_of_type_Akyc;
          if ((paramChatMessage != null) && (paramChatMessage.isMultiMsg)) {}
          for (boolean bool = true;; bool = false)
          {
            ((akyc)localObject).a(parambgaz, bool);
            this.jdField_a_of_type_Akyc.a(k);
            this.jdField_a_of_type_Akyc.b(j);
            a(paramView);
            if (i != 0) {
              a(paramView, paramaezx);
            }
            if ((paramaezx instanceof BaseBubbleBuilder))
            {
              parambgaz = ((BaseBubbleBuilder)paramaezx).a(paramView);
              if (parambgaz != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!paramBoolean) {
                  break;
                }
                parambgaz.a(paramView, true);
              }
            }
            label313:
            if (paramBoolean)
            {
              if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Aezr.jdField_a_of_type_Akxz.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
                break label508;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryAdapterForC2C", 2, "performCursorTouch ");
              }
            }
            label370:
            return true;
          }
        }
        localObject = this.jdField_a_of_type_Akyc.a(paramView, this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        if ((this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar != null))
        {
          paramChatMessage = new int[2];
          this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLocationInWindow(paramChatMessage);
        }
        for (;;)
        {
          akyc localakyc = this.jdField_a_of_type_Akyc;
          j = ((akyd)localObject).a;
          m = ((akyd)localObject).b;
          if (paramChatMessage == null) {}
          for (paramChatMessage = null;; paramChatMessage = Integer.valueOf(paramChatMessage[1]))
          {
            localakyc.a(paramView, k, j, parambgaz, true, m, paramChatMessage);
            break;
          }
          parambgaz.a(paramView, false);
          break label313;
          label508:
          this.jdField_a_of_type_Aezr.jdField_a_of_type_Akxz.a(paramView, this.jdField_a_of_type_Akyc);
          break label370;
          a(paramView);
          return false;
          paramChatMessage = null;
        }
        j = k - m;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Akyc != null) {
      this.jdField_a_of_type_Akyc.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Aezr.jdField_a_of_type_Agcw.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aezr);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((aeze)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
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
        if (!(localObject2 instanceof bcgx)) {
          break label148;
        }
        ((bcgx)localObject2).b(this.jdField_a_of_type_AndroidViewView);
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
          if ((!(localObject2 instanceof agpx)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (agpx)localObject2;
          if (this.jdField_a_of_type_Boolean) {
            if (((agpx)localObject3).jdField_a_of_type_Apee != null) {
              ((agpx)localObject3).jdField_a_of_type_Apee.a(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((agpx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((agpx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((agpx)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368518);
            if (!(localObject1 instanceof PAHighLightImageView)) {
              break label328;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((agpx)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838341);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                aezn.a((MessageForStructing)localObject3, (aezf)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131377859);
          if ((localObject1 instanceof PAHighLightImageView)) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof bcit));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
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
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838333);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838331);
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
      if (i == 2131365382)
      {
        if (aezr.a(this.jdField_a_of_type_Aezr) != null) {
          aezr.a(this.jdField_a_of_type_Aezr).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        VipUtils.a(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
    }
    for (;;)
    {
      if ((i != 2131377014) && (akxv.a().c())) {
        akxv.a().d();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (i == 2131378248)
      {
        bcef.b(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        localObject = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject = aszt.a(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
        if (localObject != null) {
          bcua.a((FileManagerEntity)localObject, this.jdField_a_of_type_Aezr.b, this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        } else {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131718856), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299076));
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_Aezr.jdField_a_of_type_Agcw.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aezr);
        Context localContext = paramView.getContext();
        ((aezx)localObject).a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
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
    if (this.jdField_a_of_type_Aezr.jdField_a_of_type_Boolean) {}
    for (boolean bool = false;; bool = this.jdField_a_of_type_Aezr.jdField_a_of_type_Akxz.a(paramView))
    {
      this.jdField_b_of_type_Boolean = true;
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      if ((bool) || (this.jdField_a_of_type_Akyc == null) || (!this.jdField_a_of_type_Akyc.a())) {
        break;
      }
      a(paramView);
      return false;
    }
    bgaz localbgaz = new bgaz();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aezy)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype;
    if ((j == -2014) || (j == -2005))
    {
      if (this.c)
      {
        this.d = aqjv.a().c();
        this.c = false;
      }
      localObject1 = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject3 = aszt.a(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if ((localObject3 != null) && (((FileManagerEntity)localObject3).status != 16))
      {
        long l = aszt.a(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject3).fileName);
        localObject2 = aqkl.a().c();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = bcvs.a;
        }
        if ((this.d) && (bcvs.a(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          bcef.b(this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          localbgaz.a(2131378248, this.jdField_a_of_type_Aezr.b.getString(2131718859), 2130838983);
        }
      }
    }
    Object localObject1 = ((aezy)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = this.jdField_a_of_type_Aezr.jdField_a_of_type_Agcw.a((ChatMessage)localObject1, this.jdField_a_of_type_Aezr);
    Object localObject3 = ((aezx)localObject2).a(paramView);
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      j = localObject3.length;
      while (i < j)
      {
        bgbb localbgbb = localObject3[i];
        int k = localbgbb.a();
        if (((k == 2131365216) || (k == 2131377014) || (k == 2131367094) || (k == 2131366347)) && (localbgbb.b() != 2130838504)) {
          localbgaz.a(localbgbb);
        }
        i += 1;
      }
    }
    localbgaz.a(2131365382, this.jdField_a_of_type_Aezr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690679), 2130838966);
    return a(localbgaz, paramView, bool, (ChatMessage)localObject1, (aezx)localObject2);
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
    Object localObject = this.jdField_a_of_type_Aezr.jdField_a_of_type_Agcw.a(((aezy)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aezr);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((aeze)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezu
 * JD-Core Version:    0.7.0.1
 */