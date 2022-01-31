import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.1;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.2;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class affz
  extends akqv
{
  public int a;
  private WeakReference<affu> a;
  
  public affz(affu paramaffu)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaffu);
  }
  
  public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] mCreateRoomReqCode != reqCode");
      return;
    }
    affu localaffu = (affu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localaffu == null) || (localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((aleh)localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      akqq.a(localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      affu.a(localaffu).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localaffu, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      affu.a(localaffu).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localaffu, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    affu.a(localaffu).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localaffu));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    affu localaffu = (affu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaffu == null) {
      break label17;
    }
    label17:
    while (localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ChatItemBuilder", 1, "onCreateRoomId mCreateRoomReqCode != reqCode");
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("ChatItemBuilder", 1, "onCreateRoomId createSuccess:false");
      return;
    }
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    aliq localaliq = new aliq();
    Object localObject = (aleh)localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = alpo.a(2131702502);
    ApolloGameData localApolloGameData = ((aleh)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((aleh)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localaliq.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localaliq.jdField_a_of_type_JavaLangString = str;
        localaliq.jdField_b_of_type_Int = paramInt2;
        localaliq.jdField_a_of_type_Long = paramLong;
        localaliq.jdField_a_of_type_Int = paramInt1;
        localaliq.d = 3;
        localaliq.e = 0;
        if ((localaffu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        akqq.a(localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaffu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localaliq);
        if (!akrd.a(localaffu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((akji)localaffu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localaffu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localaliq.jdField_b_of_type_JavaLangString = alpo.a(2131702503);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affz
 * JD-Core Version:    0.7.0.1
 */