import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.2;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class agio
  implements agin, View.OnClickListener, bbdl, blgw
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private bbdg jdField_a_of_type_Bbdg = new agip(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AIOIceBreakShow jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow;
  private String jdField_a_of_type_JavaLangString;
  
  agio(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = ((bbdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramString, paramInt);
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
        } while (!bbdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin));
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = new AIOIceBreakShow(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().setOnGoingToShowPanelListener(this);
        localbbdh = (bbdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        localbbdh.a(this);
        localbbdh.a(this.jdField_a_of_type_Bbdg);
        return;
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
      } while (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null);
      bbdh localbbdh = (bbdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      localbbdh.b(this);
      localbbdh.f();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.b();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = null;
      return;
      QLog.i("IceBreak.HotPic", 1, "onMoveToState show first.");
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    if (a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
    {
      a(true, true);
      return;
    }
    bbdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
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
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    if (!bbdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(str)) || (!str.equals(paramString)) || (((!paramBoolean) || (!bbdk.c(i))) && ((paramBoolean) || (!bbdk.b(i))) && (!bbdk.d(i)) && (!bbdk.e(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().post(new IceBreakHelper.2(this));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!bbdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
      }
    } while ((!paramBoolean) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin())) || (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)));
    bbdk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      bbdh localbbdh = (bbdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
      if (bbdk.b(i))
      {
        anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) && (localanvk.b(str)) && (!localbbdh.a(str)))
        {
          if (localbbdh.a(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType) != 1) {
            break label180;
          }
          i = 6;
          localbbdh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, i, str);
        }
      }
      label180:
      label219:
      label253:
      do
      {
        do
        {
          do
          {
            return;
            i = 1;
            break;
            if (!bbdk.c(i)) {
              break label219;
            }
          } while (localbbdh.b(str));
          localbbdh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, 2, str);
          return;
          if (!bbdk.d(i)) {
            break label253;
          }
        } while (localbbdh.c(str));
        localbbdh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, 4, str);
        return;
      } while ((!bbdk.e(i)) || (localbbdh.d(str)));
      localbbdh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, 5, str);
      return;
    }
    this.jdField_a_of_type_Bbdg.a(true, null, 0);
  }
  
  public int[] a()
  {
    return new int[] { 4, 14, 8 };
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((!bbdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin)) || (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentPanel() != 0) || (paramInt2 == 0));
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    if (!bbdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(paramString)) || (!str.equals(paramString)) || (((!paramBoolean) || (!bbdk.c(i))) && ((paramBoolean) || (!bbdk.b(i))) && (!bbdk.d(i)) && (!bbdk.e(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().post(new IceBreakHelper.3(this));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368909) && (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentPanel() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agio
 * JD-Core Version:    0.7.0.1
 */