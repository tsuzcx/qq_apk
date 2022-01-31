import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.qphone.base.util.QLog;

class aenp
  extends amnt
{
  aenp(aeno paramaeno) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!amnk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    do
    {
      do
      {
        return;
      } while ((!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) || (paramInt2 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      aeno.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onCheckHolmesTipsView  frdUin:" + paramString + " type:" + paramInt2 + " topicid:" + paramInt1);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (!amnk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return;
    }
    if (paramBoolean2) {}
    for (;;)
    {
      String str = Long.toString(paramLong2);
      if ((!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) || (paramInt2 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        break;
      }
      if (paramBoolean1)
      {
        amnx localamnx = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        ConfessConvInfo localConfessConvInfo = localamnx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
        if ((localConfessConvInfo != null) && ((localConfessConvInfo.holmesCurCount != paramInt3) || (localConfessConvInfo.holmesTolCount != paramInt4))) {
          localamnx.a(str, paramInt2, paramInt1, paramInt3, paramInt4);
        }
        aeno.a(this.a, true);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onGetHolmesProgress " + paramBoolean1 + " frdUin:" + str + " type:" + paramInt2 + " topicid:" + paramInt1 + " curCount:" + paramInt3);
      return;
      paramLong2 = paramLong1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo)
  {
    String str;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (bbbd.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (paramInt2 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
      if (QLog.isColorLevel())
      {
        str = this.a.jdField_a_of_type_JavaLangString;
        paramInt2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        if (paramString2 != null) {
          break label190;
        }
      }
    }
    label190:
    for (paramConfessInfo = "";; paramConfessInfo = paramString2)
    {
      QLog.i(str, 2, String.format("onSetShieldFlag suc:%b frdUin:%s uinType:%d topicId:%d hours:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo }));
      this.a.bo();
      if ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
      {
        paramString1 = new StringBuilder();
        if (!paramBoolean) {
          break;
        }
      }
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1.append("屏蔽失败，请重试。");
      this.a.a(2, paramString1.toString(), 500);
      return;
    }
    paramString1.append("屏蔽失败，").append(paramString2);
    this.a.a(2, paramString1.toString(), 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenp
 * JD-Core Version:    0.7.0.1
 */