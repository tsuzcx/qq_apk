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

class aeqv
  implements aetk, View.OnClickListener, bhvm
{
  ajxt jdField_a_of_type_Ajxt;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d;
  
  private aeqv(aeqs paramaeqs) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ajxt != null) {
      this.jdField_a_of_type_Ajxt.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Aeqs.jdField_a_of_type_Afpy.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aeqs);
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
      Object localObject2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if (!(localObject2 instanceof azut)) {
          break label148;
        }
        ((azut)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label148:
      label326:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView = null;
          this.jdField_b_of_type_AndroidViewView = null;
          return;
          if ((!(localObject2 instanceof agcx)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (agcx)localObject2;
          if (this.jdField_a_of_type_Boolean) {
            if (((agcx)localObject3).jdField_a_of_type_Anwo != null) {
              ((agcx)localObject3).jdField_a_of_type_Anwo.a(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((agcx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((agcx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((agcx)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368094);
            if (!(localObject1 instanceof PAHighLightImageView)) {
              break label326;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((agcx)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838193);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                aeqo.a((MessageForStructing)localObject3, (aeqi)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131377128);
          if ((localObject1 instanceof PAHighLightImageView)) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof azwp));
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
    int i = paramView.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      if (i == 2131365071)
      {
        if (aeqs.a(this.jdField_a_of_type_Aeqs) != null) {
          aeqs.a(this.jdField_a_of_type_Aeqs).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        VipUtils.a(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
    }
    for (;;)
    {
      if ((i != 2131376341) && (ajxm.a().c())) {
        ajxm.a().d();
      }
      return;
      if (i == 2131377486)
      {
        azqs.b(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        paramView = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        paramView = arrr.a(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        if (paramView != null) {
          bagk.a(paramView, this.jdField_a_of_type_Aeqs.b, this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        } else {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720677), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
        }
      }
      else
      {
        aeqy localaeqy = this.jdField_a_of_type_Aeqs.jdField_a_of_type_Afpy.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aeqs);
        Context localContext = paramView.getContext();
        localaeqy.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Aeqs.jdField_a_of_type_Boolean) {}
    for (boolean bool1 = false;; bool1 = this.jdField_a_of_type_Aeqs.jdField_a_of_type_Ajxq.a(paramView))
    {
      this.jdField_b_of_type_Boolean = true;
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      if ((this.jdField_a_of_type_Ajxt == null) || (!this.jdField_a_of_type_Ajxt.a())) {
        break;
      }
      a(paramView);
      return false;
    }
    Object localObject3 = new bdpi();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aeqz)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype;
    if ((i == -2014) || (i == -2005))
    {
      if (this.c)
      {
        this.d = aoxg.a().c();
        this.c = false;
      }
      localObject1 = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject4 = arrr.a(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if ((localObject4 != null) && (((FileManagerEntity)localObject4).status != 16))
      {
        long l = arrr.a(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject4).fileName);
        localObject2 = aoxw.a().c();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = baic.a;
        }
        if ((this.d) && (baic.a(((FileManagerEntity)localObject4).strFilePath, ((FileManagerEntity)localObject4).fileName, (String)localObject1)) && (((FileManagerEntity)localObject4).fileSize <= l))
        {
          azqs.b(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          ((bdpi)localObject3).a(2131377486, this.jdField_a_of_type_Aeqs.b.getString(2131720680), 2130838689);
        }
      }
    }
    Object localObject2 = ((aeqz)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject1 = this.jdField_a_of_type_Aeqs.jdField_a_of_type_Afpy.a((ChatMessage)localObject2, this.jdField_a_of_type_Aeqs);
    Object localObject4 = ((aeqy)localObject1).a(paramView);
    int j;
    int k;
    if ((localObject4 != null) && (localObject4.length > 0))
    {
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        bdpk localbdpk = localObject4[i];
        k = localbdpk.a();
        if (((k == 2131364912) || (k == 2131376341) || (k == 2131366760) || (k == 2131366017)) && (localbdpk.b() != 2130838367)) {
          ((bdpi)localObject3).a(localbdpk);
        }
        i += 1;
      }
    }
    ((bdpi)localObject3).a(2131365071, this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690760), 2130838673);
    if (((bdpi)localObject3).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aeqz)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label1345;
      }
    }
    label778:
    label1317:
    label1345:
    for (i = 1;; i = 0)
    {
      k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = aepi.a(10.0F, paramView.getResources());
      localObject4 = new int[2];
      paramView.getLocationOnScreen((int[])localObject4);
      j = localObject4[1] - aepi.a(3.0F, paramView.getResources());
      localObject4 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
      if (j - aepi.a(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Ajxt == null)
        {
          this.jdField_a_of_type_Ajxt = new ajxl(this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Ajxt.a(this);
          this.jdField_a_of_type_Ajxt.a(this);
        }
        this.jdField_a_of_type_Ajxt.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bdoo.b(14.0F);
        this.jdField_a_of_type_Ajxt.b = k;
        boolean bool2;
        if (bool1)
        {
          localObject4 = this.jdField_a_of_type_Ajxt;
          if ((localObject2 != null) && (((ChatMessage)localObject2).isMultiMsg))
          {
            bool2 = true;
            ((ajxt)localObject4).a((bdpi)localObject3, bool2);
            this.jdField_a_of_type_Ajxt.a(k);
            this.jdField_a_of_type_Ajxt.b(j);
            label730:
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject2 instanceof azut)) {
                break label892;
              }
              ((azut)localObject2).c(this.jdField_a_of_type_AndroidViewView);
            }
            if ((localObject1 instanceof BaseBubbleBuilder))
            {
              localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
              if (localObject1 != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!bool1) {
                  break label1317;
                }
                ((aeqh)localObject1).a(paramView, true);
              }
            }
          }
        }
        for (;;)
        {
          if (bool1) {
            this.jdField_a_of_type_Aeqs.jdField_a_of_type_Ajxq.a(paramView, this.jdField_a_of_type_Ajxt);
          }
          return true;
          bool2 = false;
          break;
          localObject2 = this.jdField_a_of_type_Ajxt.a(paramView, this.jdField_a_of_type_Aeqs.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Ajxt.a(paramView, k, ((ajxu)localObject2).a, (bdpi)localObject3, true, ((ajxu)localObject2).b);
          break label730;
          label892:
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
                break label1094;
              }
              localObject3 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
              i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
              j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
              k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
              m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
              if (!this.jdField_a_of_type_Boolean) {
                break label1110;
              }
              if (!((agcx)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                break label1096;
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
              break label967;
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
          label967:
          label1096:
          label1110:
          if (!(localObject2 instanceof azwp)) {
            break label778;
          }
          label1094:
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
          ((aeqh)localObject1).a(paramView, false);
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
    Object localObject = this.jdField_a_of_type_Aeqs.jdField_a_of_type_Afpy.a(((aeqz)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aeqs);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((aeqh)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqv
 * JD-Core Version:    0.7.0.1
 */