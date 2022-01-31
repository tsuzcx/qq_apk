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
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ackh
  implements acmv, View.OnClickListener, behy
{
  ahpe jdField_a_of_type_Ahpe;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d;
  
  private ackh(acke paramacke) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ahpe != null) {
      this.jdField_a_of_type_Ahpe.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Acke.jdField_a_of_type_Adie.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Acke);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((acjt)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
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
        if (!(localObject2 instanceof awum)) {
          break label148;
        }
        ((awum)localObject2).b(this.jdField_a_of_type_AndroidViewView);
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
          if ((!(localObject2 instanceof adqx)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (adqx)localObject2;
          if (this.jdField_a_of_type_Boolean) {
            if (((adqx)localObject3).jdField_a_of_type_Almt != null) {
              ((adqx)localObject3).jdField_a_of_type_Almt.a(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((adqx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((adqx)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((adqx)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131302327);
            if (!(localObject1 instanceof PAHighLightImageView)) {
              break label326;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((adqx)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838129);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                acka.a((MessageForStructing)localObject3, (acju)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131310776);
          if ((localObject1 instanceof PAHighLightImageView)) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof awwi));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131310759)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838117);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838121);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838119);
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
      if (i == 2131299417)
      {
        if (acke.a(this.jdField_a_of_type_Acke) != null) {
          acke.a(this.jdField_a_of_type_Acke).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        bajr.a(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
    }
    for (;;)
    {
      if ((i != 2131310025) && (ahox.a().c())) {
        ahox.a().d();
      }
      return;
      if (i == 2131311102)
      {
        awqx.b(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        paramView = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        paramView = apck.a(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        if (paramView != null) {
          axea.a(paramView, this.jdField_a_of_type_Acke.b, this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        } else {
          bbmy.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131654228), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131167766));
        }
      }
      else
      {
        ackk localackk = this.jdField_a_of_type_Acke.jdField_a_of_type_Adie.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Acke);
        Context localContext = paramView.getContext();
        localackk.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Acke.jdField_a_of_type_Boolean) {}
    for (boolean bool1 = false;; bool1 = this.jdField_a_of_type_Acke.jdField_a_of_type_Ahpb.a(paramView))
    {
      this.jdField_b_of_type_Boolean = true;
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      if ((this.jdField_a_of_type_Ahpe == null) || (!this.jdField_a_of_type_Ahpe.a())) {
        break;
      }
      a(paramView);
      return false;
    }
    Object localObject3 = new bakh();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ackl)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype;
    if ((i == -2014) || (i == -2005))
    {
      if (this.c)
      {
        this.d = amlh.a().c();
        this.c = false;
      }
      localObject1 = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject4 = apck.a(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if ((localObject4 != null) && (((FileManagerEntity)localObject4).status != 16))
      {
        long l = apck.a(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject4).fileName);
        localObject2 = amlu.a().c();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = axfs.a;
        }
        if ((this.d) && (axfs.a(((FileManagerEntity)localObject4).strFilePath, ((FileManagerEntity)localObject4).fileName, (String)localObject1)) && (((FileManagerEntity)localObject4).fileSize <= l))
        {
          awqx.b(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          ((bakh)localObject3).a(2131311102, this.jdField_a_of_type_Acke.b.getString(2131654231), 2130838610);
        }
      }
    }
    Object localObject2 = ((ackl)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject1 = this.jdField_a_of_type_Acke.jdField_a_of_type_Adie.a((ChatMessage)localObject2, this.jdField_a_of_type_Acke);
    Object localObject4 = ((ackk)localObject1).a(paramView);
    int j;
    int k;
    if ((localObject4 != null) && (localObject4.length > 0))
    {
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        bakj localbakj = localObject4[i];
        k = localbakj.a();
        if (((k == 2131299262) || (k == 2131310025) || (k == 2131301021) || (k == 2131300328)) && (localbakj.b() != 2130838298)) {
          ((bakh)localObject3).a(localbakj);
        }
        i += 1;
      }
    }
    ((bakh)localObject3).a(2131299417, this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131625147), 2130838594);
    if (((bakh)localObject3).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ackl)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      int m = aciy.a(10.0F, paramView.getResources());
      localObject4 = new int[2];
      paramView.getLocationOnScreen((int[])localObject4);
      j = localObject4[1] - aciy.a(3.0F, paramView.getResources());
      localObject4 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject4);
      if (j - aciy.a(72.0F, paramView.getResources()) > ((Rect)localObject4).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Ahpe == null)
        {
          this.jdField_a_of_type_Ahpe = new ahow(this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Ahpe.a(this);
          this.jdField_a_of_type_Ahpe.a(this);
        }
        this.jdField_a_of_type_Ahpe.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bajq.b(14.0F);
        this.jdField_a_of_type_Ahpe.b = k;
        boolean bool2;
        if (bool1)
        {
          localObject4 = this.jdField_a_of_type_Ahpe;
          if ((localObject2 != null) && (((ChatMessage)localObject2).isMultiMsg))
          {
            bool2 = true;
            ((ahpe)localObject4).a((bakh)localObject3, bool2);
            this.jdField_a_of_type_Ahpe.a(k);
            this.jdField_a_of_type_Ahpe.b(j);
            label730:
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject2 instanceof awum)) {
                break label892;
              }
              ((awum)localObject2).c(this.jdField_a_of_type_AndroidViewView);
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
                ((acjt)localObject1).a(paramView, true);
              }
            }
          }
        }
        for (;;)
        {
          if (bool1) {
            this.jdField_a_of_type_Acke.jdField_a_of_type_Ahpb.a(paramView, this.jdField_a_of_type_Ahpe);
          }
          return true;
          bool2 = false;
          break;
          localObject2 = this.jdField_a_of_type_Ahpe.a(paramView, this.jdField_a_of_type_Acke.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Ahpe.a(paramView, k, ((ahpf)localObject2).a, (bakh)localObject3, true, ((ahpf)localObject2).b);
          break label730;
          label892:
          if ((localObject2 instanceof adqx))
          {
            localObject4 = (adqx)localObject2;
            if ((localObject1 instanceof StructingMsgItemBuilder))
            {
              if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
              {
                if ((((adqx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((adqx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                  this.jdField_b_of_type_AndroidViewView = ((adqx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                }
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else
            {
              if ((this.jdField_b_of_type_AndroidViewView == null) || (((adqx)localObject4).jdField_a_of_type_Boolean)) {
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
              if (!((adqx)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                break label1096;
              }
              ((adqx)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848703);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              this.jdField_b_of_type_AndroidViewView = ((adqx)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
              this.jdField_a_of_type_Boolean = true;
              break label967;
              break;
              ((adqx)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848510);
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
              {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838131);
              }
              else
              {
                localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                  acka.a((MessageForStructing)localObject4, (acju)localObject2, this.jdField_b_of_type_AndroidViewView, true);
                }
              }
            }
          }
          label967:
          label1096:
          label1110:
          if (!(localObject2 instanceof awwi)) {
            break label778;
          }
          label1094:
          this.jdField_b_of_type_AndroidViewView = paramView;
          localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          int n = ((Integer)paramView.getTag(2131310759)).intValue();
          if (n == 0) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838118);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            if (n == 2) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838122);
            } else {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838120);
            }
          }
          ((acjt)localObject1).a(paramView, false);
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
    Object localObject = this.jdField_a_of_type_Acke.jdField_a_of_type_Adie.a(((ackl)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Acke);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((acjt)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ackh
 * JD-Core Version:    0.7.0.1
 */