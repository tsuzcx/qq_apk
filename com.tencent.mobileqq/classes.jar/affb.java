import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.2;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.icebreaking.AIOIceBreakShow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class affb
  implements affa, amkb, View.OnClickListener, bicx
{
  private int jdField_a_of_type_Int;
  private amjw jdField_a_of_type_Amjw = new affc(this);
  Context jdField_a_of_type_AndroidContentContext;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AIOIceBreakShow jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow;
  private String jdField_a_of_type_JavaLangString;
  
  affb(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = ((amjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285)).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("checkNeedShowImmediately, sessionType: %s, sessionUin: %s, type: %s", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(i) }));
    }
    if (i != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("IceBreak.HotPic", 1, "onMoveToState create.");
        } while (!amka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow = new AIOIceBreakShow(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setOnGoingToShowPanelListener(this);
        localamjx = (amjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
        localamjx.a(this);
        localamjx.a(this.jdField_a_of_type_Amjw);
        return;
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow == null);
      amjx localamjx = (amjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
      localamjx.b(this);
      localamjx.e();
      this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow.b();
      this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow = null;
      return;
      QLog.i("IceBreak.HotPic", 1, "onMoveToState show first.");
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    if (a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
    {
      a(true, true);
      return;
    }
    amka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow != null) && (paramInt2 == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow.a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow.a();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onAddIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!amka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(str)) || (!str.equals(paramString)) || (((!paramBoolean) || (!amka.c(i))) && ((paramBoolean) || (!amka.b(i))) && (!amka.d(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new IceBreakHelper.2(this));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!amka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
      }
    } while ((!paramBoolean) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    amka.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      amjx localamjx = (amjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (amka.b(i))
      {
        alto localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow != null) && (localalto.b(str)) && (!localamjx.a(str))) {
          localamjx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 1, str);
        }
      }
      do
      {
        do
        {
          return;
          if (!amka.c(i)) {
            break;
          }
        } while (localamjx.b(str));
        localamjx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 2, str);
        return;
      } while ((!amka.d(i)) || (localamjx.c(str)));
      localamjx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 1, str);
      return;
    }
    this.jdField_a_of_type_Amjw.a(true, null);
  }
  
  public int[] a()
  {
    return new int[] { 2, 11, 6 };
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((!amka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() != 0) || (paramInt2 == 0));
    this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow.a(true);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!amka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(paramString)) || (!str.equals(paramString)) || (((!paramBoolean) || (!amka.c(i))) && ((paramBoolean) || (!amka.b(i))) && (!amka.d(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new IceBreakHelper.3(this));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368343) && (this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppIcebreakingAIOIceBreakShow.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affb
 * JD-Core Version:    0.7.0.1
 */