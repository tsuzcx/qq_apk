import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class adzk
  extends lnc
{
  private adzk(BaseChatPie paramBaseChatPie) {}
  
  protected void a(int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a();
      super.a(paramInt, paramLong);
    }
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberInfo", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, 0L);
      }
      super.a(paramInt, paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberInfo", localNumberFormatException);
        }
      }
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioObserver", 2, "OnAudioChatting uinType: " + paramInt + ", peerUin: " + paramString1);
    }
    if (this.a.jdField_a_of_type_Ascw != null) {
      this.a.jdField_a_of_type_Ascw.d();
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || ((paramInt == 1006) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2)))) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramString1))) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(paramInt, paramString1, paramString2);
    }
    super.a(paramInt, paramString1, paramString2);
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    super.a(paramLong1, paramInt1, paramLong2, paramInt2);
    QLog.d("OnManagerForbiddenOpenRoom", 2, " avtype:" + paramInt2);
    String str1;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt1) && (Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue() == paramLong1))
    {
      if ((paramLong2 != 1L) && (paramLong2 != 2L) && (paramLong2 != 35L) && (paramLong2 != 42L) && (paramLong2 != 43L) && (paramLong2 != 41L) && (paramLong2 != 40L)) {
        break label312;
      }
      str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695027);
      if (paramLong2 != 2L) {
        break label234;
      }
      str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695028);
    }
    label233:
    label234:
    String str2;
    label312:
    do
    {
      do
      {
        break label233;
        break label233;
        if ((paramLong2 == 41L) || (paramLong2 == 40L)) {
          str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695032);
        }
        for (;;)
        {
          bhlq.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, str1, 2131694814, 2131719223, new adzl(this), null).show();
          return;
          if (paramLong2 != 35L) {
            break;
          }
          str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695029);
          break;
          if (paramLong2 == 42L) {
            str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695030);
          } else if (paramLong2 == 43L) {
            str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695031);
          }
        }
        if (paramLong2 == 3L)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_AndroidContentContext.getString(2131694989), 1).b(this.a.a());
          return;
        }
        if (paramLong2 == 4L)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_AndroidContentContext.getString(2131694986), 1).b(this.a.a());
          return;
        }
        if (paramLong2 == 8L)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_AndroidContentContext.getString(2131694985), 1).b(this.a.a());
          return;
        }
      } while (paramLong2 != 7L);
      str1 = String.valueOf(paramLong1);
      str2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramInt2 == 10)
      {
        VideoMsgTools.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 59, false, str1, str2, false, null, false, paramInt2, new Object[0]);
        return;
      }
    } while (paramInt2 != 2);
    VideoMsgTools.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 60, false, str1, str2, false, null, false, paramInt2, new Object[0]);
  }
  
  protected void a(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramInt, paramLong2, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt) && (Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue() == paramLong1)) {
      bhlq.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, paramString, 2131694814, 2131719223, new adzm(this), null).show();
    }
  }
  
  protected void a(String paramString)
  {
    boolean bool = false;
    super.a(paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]) != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()))
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() == 2) {
        bool = true;
      }
      paramString.a(bool);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    boolean bool = false;
    super.a(paramString1, paramString2);
    if (this.a.i != 4) {}
    while ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k())) {
      return;
    }
    TextView localTextView = (TextView)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]).findViewById(2131378709);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    String str;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      str = "";
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        i = mvd.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        long l = Long.valueOf(paramString1).longValue();
        l = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i, l);
        String.format(this.a.jdField_a_of_type_AndroidContentContext.getString(2131689905), new Object[] { Long.valueOf(l) });
        localTextView.setText(paramString2);
      }
    }
    else
    {
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g() == 2) {
        bool = true;
      }
      paramString1.a(bool);
      return;
    }
    if (i == 2) {
      str = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695340);
    }
    for (;;)
    {
      i = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166998);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(null, str, i, paramString1, 0);
      break;
      if (i == 1) {
        str = this.a.jdField_a_of_type_AndroidContentContext.getString(2131694764);
      }
    }
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.b();
    }
    super.b(paramInt, paramLong);
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberJoin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, paramLong2);
      }
      super.b(paramInt, paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberJoin", localNumberFormatException);
        }
      }
    }
  }
  
  protected void c(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberQuit", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2, paramLong2);
      }
      super.c(paramInt, paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberQuit", localNumberFormatException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzk
 * JD-Core Version:    0.7.0.1
 */