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

class aggz
  implements agjk, View.OnClickListener, blkc
{
  amcb jdField_a_of_type_Amcb;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d;
  
  private aggz(aggw paramaggw) {}
  
  private void a(View paramView, aghc paramaghc)
  {
    paramView.setPressed(true);
    this.jdField_a_of_type_AndroidViewView = paramView;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof bdom)) {
      ((bdom)localObject1).c(this.jdField_a_of_type_AndroidViewView);
    }
    label113:
    label254:
    do
    {
      return;
      if ((localObject1 instanceof ahtm))
      {
        Object localObject2 = (ahtm)localObject1;
        ViewGroup.LayoutParams localLayoutParams;
        if ((paramaghc instanceof StructingMsgItemBuilder))
        {
          if (((StructingMsgItemBuilder)paramaghc).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
          {
            if ((((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
              this.jdField_b_of_type_AndroidViewView = ((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (((ahtm)localObject2).jdField_a_of_type_Boolean)) {
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
          if (!((ahtm)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            break label241;
          }
          ((ahtm)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850001);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          return;
          this.jdField_b_of_type_AndroidViewView = ((ahtm)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout;
          this.jdField_a_of_type_Boolean = true;
          break label113;
          break;
          ((ahtm)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849825);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838318);
          }
          else
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (((BaseBubbleBuilder)paramaghc).a(paramView) == null) {
              aggs.a((MessageForStructing)localObject2, (aggl)localObject1, this.jdField_b_of_type_AndroidViewView, true);
            }
          }
        }
      }
    } while (!(localObject1 instanceof bdqi));
    label239:
    label241:
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramaghc = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)paramView.getTag(2131378072)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838305);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramaghc);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838309);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838307);
      }
    }
  }
  
  private boolean a(bhuk parambhuk, View paramView, boolean paramBoolean, ChatMessage paramChatMessage, aghc paramaghc)
  {
    if (parambhuk.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aghd)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      int m = agej.a(10.0F, paramView.getResources());
      Object localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      int j = localObject[1] - agej.a(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - agej.a(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Amcb == null)
        {
          this.jdField_a_of_type_Amcb = new ambt(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Amcb.a(this);
          this.jdField_a_of_type_Amcb.a(this);
        }
        this.jdField_a_of_type_Amcb.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - bhtq.b(14.0F);
        this.jdField_a_of_type_Amcb.b = k;
        boolean bool;
        if (paramBoolean)
        {
          localObject = this.jdField_a_of_type_Amcb;
          if ((paramChatMessage != null) && (paramChatMessage.isMultiMsg))
          {
            bool = true;
            ((amcb)localObject).a(parambhuk, bool);
            this.jdField_a_of_type_Amcb.a(k);
            this.jdField_a_of_type_Amcb.b(j);
            a(paramView);
            if (i != 0) {
              a(paramView, paramaghc);
            }
            if ((paramaghc instanceof BaseBubbleBuilder))
            {
              parambhuk = ((BaseBubbleBuilder)paramaghc).a(paramView);
              if (parambhuk != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!paramBoolean) {
                  break label420;
                }
                parambhuk.a(paramView, true);
              }
            }
          }
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_Aggw.jdField_a_of_type_Amby.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
              break label431;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatHistoryAdapterForC2C", 2, "performCursorTouch ");
            }
          }
          return true;
          bool = false;
          break;
          paramChatMessage = this.jdField_a_of_type_Amcb.a(paramView, this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          this.jdField_a_of_type_Amcb.a(paramView, k, paramChatMessage.a, parambhuk, true, paramChatMessage.b);
          break label257;
          parambhuk.a(paramView, false);
        }
        this.jdField_a_of_type_Aggw.jdField_a_of_type_Amby.a(paramView, this.jdField_a_of_type_Amcb);
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
    if (this.jdField_a_of_type_Amcb != null) {
      this.jdField_a_of_type_Amcb.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_Aggw.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aggw);
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
        if (!(localObject2 instanceof bdom)) {
          break label148;
        }
        ((bdom)localObject2).b(this.jdField_a_of_type_AndroidViewView);
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
          if ((!(localObject2 instanceof ahtm)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (ahtm)localObject2;
          if (this.jdField_a_of_type_Boolean) {
            if (((ahtm)localObject3).jdField_a_of_type_Aqkt != null) {
              ((ahtm)localObject3).jdField_a_of_type_Aqkt.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ahtm)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((ahtm)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((ahtm)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368493);
            if (!(localObject1 instanceof PAHighLightImageView)) {
              break label328;
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
                aggs.a((MessageForStructing)localObject3, (aggl)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131378089);
          if ((localObject1 instanceof PAHighLightImageView)) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      if (i == 2131365352)
      {
        if (aggw.a(this.jdField_a_of_type_Aggw) != null) {
          aggw.a(this.jdField_a_of_type_Aggw).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        VipUtils.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
    }
    for (;;)
    {
      if ((i != 2131377264) && (ambu.a().c())) {
        ambu.a().d();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (i == 2131378480)
      {
        bdll.b(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        localObject = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject = aunj.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
        if (localObject != null) {
          beaj.a((FileManagerEntity)localObject, this.jdField_a_of_type_Aggw.b, this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        } else {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131718608), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299011));
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_Aggw.jdField_a_of_type_Ahgk.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aggw);
        Context localContext = paramView.getContext();
        ((aghc)localObject).a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
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
    if (this.jdField_a_of_type_Aggw.jdField_a_of_type_Boolean) {}
    for (boolean bool = false;; bool = this.jdField_a_of_type_Aggw.jdField_a_of_type_Amby.a(paramView))
    {
      this.jdField_b_of_type_Boolean = true;
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      if ((bool) || (this.jdField_a_of_type_Amcb == null) || (!this.jdField_a_of_type_Amcb.a())) {
        break;
      }
      a(paramView);
      return false;
    }
    bhuk localbhuk = new bhuk();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((aghd)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype;
    if ((j == -2014) || (j == -2005))
    {
      if (this.c)
      {
        this.d = arpx.a().c();
        this.c = false;
      }
      localObject1 = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject3 = aunj.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if ((localObject3 != null) && (((FileManagerEntity)localObject3).status != 16))
      {
        long l = aunj.a(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject3).fileName);
        localObject2 = arqn.a().c();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = becb.a;
        }
        if ((this.d) && (becb.a(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          bdll.b(this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          localbhuk.a(2131378480, this.jdField_a_of_type_Aggw.b.getString(2131718611), 2130838949);
        }
      }
    }
    Object localObject1 = ((aghd)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = this.jdField_a_of_type_Aggw.jdField_a_of_type_Ahgk.a((ChatMessage)localObject1, this.jdField_a_of_type_Aggw);
    Object localObject3 = ((aghc)localObject2).a(paramView);
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      j = localObject3.length;
      while (i < j)
      {
        bhum localbhum = localObject3[i];
        int k = localbhum.a();
        if (((k == 2131365191) || (k == 2131377264) || (k == 2131367078) || (k == 2131366320)) && (localbhum.b() != 2130838479)) {
          localbhuk.a(localbhum);
        }
        i += 1;
      }
    }
    localbhuk.a(2131365352, this.jdField_a_of_type_Aggw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690639), 2130838934);
    return a(localbhuk, paramView, bool, (ChatMessage)localObject1, (aghc)localObject2);
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
    Object localObject = this.jdField_a_of_type_Aggw.jdField_a_of_type_Ahgk.a(((aghd)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Aggw);
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
 * Qualified Name:     aggz
 * JD-Core Version:    0.7.0.1
 */