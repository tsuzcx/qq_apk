import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.2;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class adii
  implements adih, aknz, View.OnClickListener, bfxc
{
  private int jdField_a_of_type_Int;
  akno jdField_a_of_type_Akno;
  private aknu jdField_a_of_type_Aknu = new adij(this);
  Context jdField_a_of_type_AndroidContentContext;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  adii(BaseChatPie paramBaseChatPie)
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
    int i = ((aknv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285)).a(paramString, paramInt);
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
        } while (!akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_Akno = new akno(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setOnGoingToShowPanelListener(this);
        localaknv = (aknv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
        localaknv.a(this);
        localaknv.a(this.jdField_a_of_type_Aknu);
        return;
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
      } while (this.jdField_a_of_type_Akno == null);
      aknv localaknv = (aknv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
      localaknv.b(this);
      localaknv.e();
      this.jdField_a_of_type_Akno.b();
      this.jdField_a_of_type_Akno = null;
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
    akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Akno != null) && (paramInt2 == 0)) {
      this.jdField_a_of_type_Akno.a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Akno != null) {
      this.jdField_a_of_type_Akno.a();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onAddIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(str)) || (!str.equals(paramString)) || (((!paramBoolean) || (!akny.c(i))) && ((paramBoolean) || (!akny.b(i))) && (!akny.d(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new IceBreakHelper.2(this));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
      }
    } while ((!paramBoolean) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    akny.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      aknv localaknv = (aknv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(285);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (akny.b(i))
      {
        ajxn localajxn = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((this.jdField_a_of_type_Akno != null) && (localajxn.b(str)) && (!localaknv.a(str))) {
          localaknv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 1, str);
        }
      }
      do
      {
        do
        {
          return;
          if (!akny.c(i)) {
            break;
          }
        } while (localaknv.b(str));
        localaknv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 2, str);
        return;
      } while ((!akny.d(i)) || (localaknv.c(str)));
      localaknv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 3, 1, str);
      return;
    }
    this.jdField_a_of_type_Aknu.a(true, null);
  }
  
  public int[] a()
  {
    return new int[] { 2, 11, 6 };
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((!akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Akno == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() != 0) || (paramInt2 == 0));
    this.jdField_a_of_type_Akno.a(true);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(paramString)) || (!str.equals(paramString)) || (((!paramBoolean) || (!akny.c(i))) && ((paramBoolean) || (!akny.b(i))) && (!akny.d(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new IceBreakHelper.3(this));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368186) && (this.jdField_a_of_type_Akno != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() == 0) {
        this.jdField_a_of_type_Akno.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adii
 * JD-Core Version:    0.7.0.1
 */