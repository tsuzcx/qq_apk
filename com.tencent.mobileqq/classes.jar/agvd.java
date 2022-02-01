import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.2;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class agvd
  implements agvc, View.OnClickListener, bbch, blrm
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private bbcc jdField_a_of_type_Bbcc = new agve(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AIOIceBreakShow jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow;
  private String jdField_a_of_type_JavaLangString;
  
  agvd(BaseChatPie paramBaseChatPie)
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
    int i = ((bbcd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285)).a(paramString, paramInt);
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
        } while (!bbcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = new AIOIceBreakShow(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setOnGoingToShowPanelListener(this);
        localbbcd = (bbcd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
        localbbcd.a(this);
        localbbcd.a(this.jdField_a_of_type_Bbcc);
        return;
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
      } while (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null);
      bbcd localbbcd = (bbcd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
      localbbcd.b(this);
      localbbcd.f();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.b();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = null;
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
    bbcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) && (paramInt2 == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) {
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onAddIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!bbcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(str)) || (!str.equals(paramString)) || (((!paramBoolean) || (!bbcg.c(i))) && ((paramBoolean) || (!bbcg.b(i))) && (!bbcg.d(i)) && (!bbcg.e(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new IceBreakHelper.2(this));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!bbcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
      }
    } while ((!paramBoolean) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    bbcg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      bbcd localbbcd = (bbcd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (bbcg.b(i))
      {
        anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) && (localanyw.b(str)) && (!localbbcd.a(str))) {
          localbbcd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 1, str);
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            if (!bbcg.c(i)) {
              break;
            }
          } while (localbbcd.b(str));
          localbbcd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 2, str);
          return;
          if (!bbcg.d(i)) {
            break;
          }
        } while (localbbcd.c(str));
        localbbcd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 1, str);
        return;
      } while ((!bbcg.e(i)) || (localbbcd.d(str)));
      localbbcd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 1, str);
      return;
    }
    this.jdField_a_of_type_Bbcc.a(true, null);
  }
  
  public int[] a()
  {
    return new int[] { 3, 13, 7 };
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((!bbcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g() != 0) || (paramInt2 == 0));
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!bbcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(paramString)) || (!str.equals(paramString)) || (((!paramBoolean) || (!bbcg.c(i))) && ((paramBoolean) || (!bbcg.b(i))) && (!bbcg.d(i)) && (!bbcg.e(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new IceBreakHelper.3(this));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368725) && (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvd
 * JD-Core Version:    0.7.0.1
 */